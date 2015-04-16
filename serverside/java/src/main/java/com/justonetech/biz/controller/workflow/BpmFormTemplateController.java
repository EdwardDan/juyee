package com.justonetech.biz.controller.workflow;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.BpmFormTemplateService;
import com.justonetech.biz.daoservice.BpmProcessDefinitionService;
import com.justonetech.biz.domain.BpmFormTemplate;
import com.justonetech.biz.domain.BpmProcessDefinition;
import com.justonetech.biz.domain.BpmProcessDefinitionForm;
import com.justonetech.biz.domain.bean.column.ColumnParam;
import com.justonetech.biz.manager.workflow.BpmFormTemplateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.excel.ExcelFormUtils;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ParFileUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.FileDocumentManager;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;


/**
 * note:表单模板库
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmFormTemplateController extends BaseCRUDActionController<BpmFormTemplate> {
    private Logger logger = LoggerFactory.getLogger(BpmFormTemplateController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private FileDocumentManager fileDocumentManager;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    /**
     * 树+列表显示页面
     *
     * @param model 。
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/workflow/bpmFormTemplate/init";
    }


    /**
     * 左边树
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model) {
        return "view/workflow/bpmFormTemplate/tree";
    }

    /**
     * 获取树数据
     *
     * @param id。
     * @param model。
     * @return 。
     */
    @RequestMapping
    public String treeData(String id, String type, Model model, String icon) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("表单模板"));
        } else if (StringUtils.equals(id, "root")) {
            List<SysCodeDetail> sysCodeDetails = sysCodeManager.getCodeListByCode(Constants.BPM_PROCESS_TEMPLATE_CATEGORY);
            for (SysCodeDetail node : sysCodeDetails) {
                String hql = "from BpmFormTemplate where category.id=" + node.getId() + "  order by Id asc";
                List<BpmFormTemplate> bpmPTS = bpmFormTemplateService.findByQuery(hql);
                ZTreeNode treeNode = new ZTreeNode();
                boolean isLeaf = bpmPTS.size() == 0;
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setName(node.getName());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeNode.setIsLeaf(isLeaf);
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from BpmFormTemplate where category.id=" + id + "  order by Id asc";
            List<BpmFormTemplate> nodeList = bpmFormTemplateService.findByQuery(hql);
            for (BpmFormTemplate node : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(node.getId()));
                treeNode.setName(node.getName());
                treeNode.setIcon("2");
                treeNode.setIsLeaf(true);
                treeNode.setType("detail");
                treeBranch.addTreeNode(treeNode);
            }
        }


        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }


    /**
     * 列表显示页面
     *
     * @param model      .
     * @param categoryId .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, Long categoryId) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_FORM_TEMPLATE_EDIT));
        model.addAttribute("categoryId", categoryId);
        return "view/workflow/bpmFormTemplate/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, Long categoryId, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmFormTemplate order by id desc";
            if (categoryId != null) {
                hql = "from BpmFormTemplate where category.id=" + categoryId + " order by id desc";
            }

            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = bpmFormTemplateService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long categoryId) {
        BpmFormTemplate bpmFormTemplate = new BpmFormTemplate();

        //如需增加其他默认值请在此添加
        if (categoryId != null) {
            bpmFormTemplate.setCategory(sysCodeDetailService.get(categoryId));
        }
        //字段映射
        String columnXml = bpmFormTemplate.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        model.addAttribute("list", list);
        model.addAttribute("bean", bpmFormTemplate);
        model.addAttribute("infoType", Constants.BPM_PROCESS_TEMPLATE_CATEGORY);
        return "view/workflow/bpmFormTemplate/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(id);

        //处理其他业务逻辑
        String columnXml = bpmFormTemplate.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        model.addAttribute("list", list);
        model.addAttribute("infoType", Constants.BPM_PROCESS_TEMPLATE_CATEGORY);
        model.addAttribute("bean", bpmFormTemplate);

        return "view/workflow/bpmFormTemplate/input";
    }


    /**
     * 保存操作
     *
     * @param response        .
     * @param bpmFormTemplate .
     * @param request         .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public String save(HttpServletResponse response, @ModelAttribute("bean") BpmFormTemplate bpmFormTemplate, HttpServletRequest request, Model model) throws Exception {

        BpmFormTemplate target;
        if (bpmFormTemplate.getId() != null) {
            target = bpmFormTemplateService.get(bpmFormTemplate.getId());
            ReflectionUtils.copyBean(bpmFormTemplate, target, new String[]{
                    "name",
                    "category",
                    "code"

            });

        } else {
            target = bpmFormTemplate;
            target.setUploadTime(new Timestamp(System.currentTimeMillis()));

        }


        byte[] par = bpmFormTemplate.getFormPar();
        if (par.length > 0) {
            target.setFormPar(par);

            //get tmp file
            File tempFile = File.createTempFile("parFile", ".tmp");
            org.apache.commons.io.FileUtils.writeByteArrayToFile(tempFile, par);

            //decompress the file to get the internal file and set to attribute
            try {
                ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(tempFile);

                //modify by chenjp 解决excel2007不兼容的情况，文件列表与2003不同，取有效的文件即可
                /**
                 * excel 2003 文件列表
                 * fileName = 收文审批单.htm   -- 有效
                 * fileName = 收文审批单.xml   -- 有效
                 */

                /**
                 * excel 2007 文件列表
                 * fileName = 收文审批单.htm
                 * fileName = 收文审批单.xml  -- 有效
                 * fileName = 收文审批单.files/stylesheet.css  -- 有效
                 * fileName = 收文审批单.files/sheet001.htm  -- 有效
                 * fileName = 收文审批单.files/tabstrip.htm
                 * fileName = 收文审批单.files/filelist.xml
                 */
                Boolean isExcel2003 = zipEntries.length == 2;
                String css = "";
                for (ZipEntry zipEntry : zipEntries) {
                    String fileName = zipEntry.getName();    //只取有效的文件
//                    System.out.println("fileName = " + fileName+"|"+zipEntry.getSize());
                    if (fileName.endsWith(".htm") && fileName.endsWith("001.htm")) {
                        target.setParHtml(ParFileUtils.getContentFromPar(tempFile, fileName, "gbk"));
                    }

                    if (fileName.endsWith(".xml") && !fileName.endsWith("/filelist.xml")) {
                        target.setParXml(ParFileUtils.getContentFromPar(tempFile, fileName, "utf-8"));
                    }

                    if (fileName.endsWith(".css")) {
                        css = ParFileUtils.getContentFromPar(tempFile, fileName, "gbk");
                    }
                }

                if (!isExcel2003) {
                    String parHtml = target.getParHtml();
                    if (!StringHelper.isEmpty(parHtml)) {
                        //excel2007生成的html网页有框架需去除，否则无法显示
                        parHtml = StringHelper.findAndReplace(parHtml, "window.location.replace", "//window.location.replace");
                        //将style.css合并到html中
                        if (!StringHelper.isEmpty(css)) {
                            String line = System.getProperty("line.separator");
                            parHtml = StringHelper.findAndReplace(parHtml, "</style>", "</style>" + line + "<style>" + line + css + line + "</style>");
                            parHtml = StringHelper.findAndReplace(parHtml, "<link rel=File-List href=filelist.xml>", "");
                            parHtml = StringHelper.findAndReplace(parHtml, "<link rel=Stylesheet href=stylesheet.css>", "");
                        }
                        target.setParHtml(parHtml);
                    }
                }

                tempFile.delete();
            } finally {
                tempFile.deleteOnExit();
            }

            //合并为页面模板
            if (!StringHelper.isEmpty(target.getParHtml()) && !StringHelper.isEmpty(target.getParXml())) {
                target.setHtmlTemplate(ExcelFormUtils.Transform(target.getParHtml(), target.getParXml()));
            }
        }

        //保存列表配置
        int len = request.getParameterValues("no").length;
        List<ColumnParam> list = new ArrayList<ColumnParam>();
        for (int i = 1; i <= len; i++) {
            ColumnParam param = new ColumnParam();
            param.setColumn(request.getParameter("column_" + i));
            param.setKey(request.getParameter("key_" + i));
            param.setIsValid(request.getParameter("isValid_" + i) != null);
            param.setIsGridShow(request.getParameter("isGridShow_" + i) != null);
            param.setGridName(request.getParameter("gridName_" + i));
            param.setGridWidth(request.getParameter("gridWidth_" + i));
            list.add(param);
        }
        target.setColumnXml(bpmFormTemplateManager.toXml(list));

        //保存排序号orderno
        if (target.getOrderNo() == null) {
            String sql = "select nvl(max(order_no),0)+1 as maxNo from Bpm_Form_Template";
            target.setOrderNo(Long.valueOf(simpleQueryManager.getStringBySql(sql)));
        }
        bpmFormTemplateService.save(target);

        return OperationMsgManager.successCloseMsg(model, null, "操作成功");

    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        bpmFormTemplateService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 重新排序，仅用于orderNo初始化时使用
     *
     * @param model    .
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void reOrder(Model model, HttpServletResponse response) throws Exception {
        String hql = "from BpmFormTemplate order by category.treeId asc,name asc";
        List<BpmFormTemplate> templateList = bpmFormTemplateService.findByQuery(hql);
        Long i = 0L;
        for (BpmFormTemplate bpmFormTemplate : templateList) {
            i++;
            bpmFormTemplate.setOrderNo(i);
            bpmFormTemplateService.save(bpmFormTemplate);
        }

        sendSuccessJSON(response, "排序成功");
    }

    /**
     * 下载PAR文件
     *
     * @param id       .
     * @param response .
     */
    @RequestMapping
    public void blobDownload(Long id, HttpServletResponse response) {
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(id);
        try {
            fileDocumentManager.downloadByByte(response, bpmFormTemplate.getFormPar(), bpmFormTemplate.getName());
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    /**
     * 查看表单模板页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewFormHtml(Long id, Model model) {
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(id);
        model.addAttribute("html", bpmFormTemplate.getHtmlTemplate());

        return "view/workflow/bpmFormTemplate/viewFormHtml";
    }


    /**
     * 查看页面--页面模板、par_html、par_xml
     *
     * @param id     。
     * @param column .
     * @param model  。
     * @return .
     */
    @RequestMapping
    public String viewTemplate(Long id, String column, Model model) {
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(id);
        if ("htmlTemplate".equals(column)) {
            //其中textarea必须特殊处理否则页面上使用文本框显示不正常
            String htmlTemplate = bpmFormTemplate.getHtmlTemplate();
            htmlTemplate = StringHelper.findAndReplace(htmlTemplate, "</textarea>", "&lt;/textarea&gt;");
            htmlTemplate = StringHelper.findAndReplace(htmlTemplate, "<textarea>", "&lt;textarea&gt;");
            model.addAttribute("templateCode", htmlTemplate);

        } else if ("parHtml".equals(column)) {
            model.addAttribute("templateCode", bpmFormTemplate.getParHtml());
        } else if ("parXml".equals(column)) {
            model.addAttribute("templateCode", bpmFormTemplate.getParXml());
        }
        model.addAttribute("column", column);
        return "view/workflow/bpmFormTemplate/viewTemplate";
    }

    /**
     * 查看页面
     *
     * @param id    。
     * @param model 。
     * @return .
     * @throws java.io.IOException         .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                     .
     * @throws org.dom4j.DocumentException .
     * @throws org.xml.sax.SAXException    .
     */
    @RequestMapping
    public String view(Long id, Model model) throws IOException, DocumentException, SAXException, ParserConfigurationException {
        BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(id);

        //字段映射
        String columnXml = bpmFormTemplate.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        if (bpmFormTemplate.getParXml() != null) {
            List<String> formKeys = ExcelFormUtils.getFormKeys(bpmFormTemplate.getParXml());
            for (ColumnParam param : list) {
                if (!formKeys.contains(param.getKey())) {
                    param.setIsExpired(true);
                } else {
                    param.setIsExpired(false);
                }
            }
        }
        model.addAttribute("list", list);
        model.addAttribute("bean", bpmFormTemplate);

        //是否通用检验or抽验模板
        //Boolean isGeneralTemplate = quaTemplateManager.isGeneralTemplate(bpmFormTemplate.getCode());

        //  model.addAttribute("isGeneralTemplate", isGeneralTemplate);
        return "view/workflow/bpmFormTemplate/view";
    }


    /**
     * 获取树数据--提供给选择树--仅选择当前流程定义关联的表单
     *
     * @param id。
     * @param bpmProcessDefinitionId .
     * @param icon                   .
     * @param model。
     * @return 。
     */
    @RequestMapping
    public String treeDataForDefinition(String id, Long bpmProcessDefinitionId, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(bpmProcessDefinitionId);
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionForms = bpmProcessDefinition.getBpmProcessDefinitionForms();
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            for (BpmProcessDefinitionForm bpmProcessDefinitionForm : bpmProcessDefinitionForms) {
                BpmFormTemplate bpmFormTemplate = bpmProcessDefinitionForm.getFormTemplate();
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(JspHelper.getString(bpmFormTemplate.getId()));
                treeNode.setName(bpmFormTemplate.getName());
                treeNode.setIcon("2");
                treeNode.setType("detail");
                treeNode.setIsLeaf(true);
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    /**
     * 获取表单key---提供给选择树
     *
     * @param id     .
     * @param formId .
     * @param icon   .
     * @param model  .
     * @return .
     * @throws java.io.IOException         .
     * @throws javax.xml.parsers.ParserConfigurationException
     *                                     .
     * @throws org.dom4j.DocumentException .
     * @throws org.xml.sax.SAXException    .
     */
    @RequestMapping
    public String treeDataForSelectKey(String id, Long formId, String icon, Model model) throws IOException, DocumentException, SAXException, ParserConfigurationException {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(formId);
            List<String> nodeList = ExcelFormUtils.getFormKeys(bpmFormTemplate.getParXml());
            for (String node : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(node);
                treeNode.setName(node);
                treeNode.setIcon("2");
                treeNode.setType("data");
                treeNode.setIsLeaf(true);
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(false));
        return "common/msg";
    }

    /**
     * 获取表单权限编码---提供给选择树
     *
     * @param id     .
     * @param formId .
     * @param model  .
     * @return .
     * @throws IOException                  .
     * @throws DocumentException            .
     * @throws SAXException                 .
     * @throws ParserConfigurationException .
     */
    @RequestMapping
    public String privilegeDataForSelect(String id, Long formId, String icon, Model model) throws IOException, DocumentException, SAXException, ParserConfigurationException {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(formId);
            List<String> formPrivileges = ExcelFormUtils.getFormPrivileges(bpmFormTemplate.getParXml());
            for (String formPrivilege : formPrivileges) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(formPrivilege);
                treeNode.setName(formPrivilege);
                treeNode.setIcon("2");
                treeNode.setType("data");
                treeNode.setIsLeaf(true);
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }
}