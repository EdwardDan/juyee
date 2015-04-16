package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ParFileUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.BpmProcessTemplateService;
import com.justonetech.biz.domain.BpmProcessTemplate;
import com.justonetech.biz.manager.workflow.BpmProcessDefinitionManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.FileDocumentManager;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.zip.ZipEntry;


/**
 * note:流程图模板库
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProcessTemplateController extends BaseCRUDActionController<BpmProcessTemplate> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessTemplateController.class);
    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private BpmProcessTemplateService bpmProcessTemplateService;

    @Autowired
    private FileDocumentManager fileDocumentManager;

    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {

        return "view/workflow/bpmProcessTemplate/init";
    }


    /**
     * 左边树
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model) {
        return "view/workflow/bpmProcessTemplate/tree";
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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROCESS_TEMPLATE_EDIT));
        if (categoryId != null) {
            model.addAttribute("categoryId", categoryId);
        }

        return "view/workflow/bpmProcessTemplate/grid";
    }

    /**
     * 获取树数据
     *
     * @param id。
     * @param type   .
     * @param model。
     * @param icon   .
     * @return .
     */
    @RequestMapping
    public String treeData(String id, String type, Model model, String icon) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("流程模板"));
        } else if (StringUtils.equals(id, "root")) {
            List<SysCodeDetail> sysCodeDetails = sysCodeManager.getCodeListByCode(Constants.BPM_PROCESS_TEMPLATE_CATEGORY);

            for (SysCodeDetail node : sysCodeDetails) {
                String hql = "from BpmProcessTemplate where category.id=" + node.getId() + "  order by Id asc";
                List<BpmProcessTemplate> bpmPTS = bpmProcessTemplateService.findByQuery(hql);
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
            String hql = "from BpmProcessTemplate where category.id=" + id + "  order by Id asc";
            List<BpmProcessTemplate> nodeList = bpmProcessTemplateService.findByQuery(hql);
            for (BpmProcessTemplate node : nodeList) {
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
     * 获取列表数据
     *
     * @param response   .
     * @param filters    .
     * @param columns    .
     * @param page       .
     * @param rows       .
     * @param categoryId .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, Long categoryId, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmProcessTemplate order by orderNo asc";
            if (categoryId != null) {
                hql = "from BpmProcessTemplate  where category.id =" + categoryId + "  order by orderNo asc";
            }
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = bpmProcessTemplateService.findByPage(pageModel, query);
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
     * @param model      .
     * @param categoryId .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long categoryId) {
        BpmProcessTemplate bpmProcessTemplate = new BpmProcessTemplate();

        //如需增加其他默认值请在此添加
        if (categoryId != null) {
            bpmProcessTemplate.setCategory(sysCodeDetailService.get(categoryId));
        }
        model.addAttribute("infoType", Constants.BPM_PROCESS_TEMPLATE_CATEGORY);
        model.addAttribute("bean", bpmProcessTemplate);

        return "view/workflow/bpmProcessTemplate/input";
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
        BpmProcessTemplate bpmProcessTemplate = bpmProcessTemplateService.get(id);

        //处理其他业务逻辑
        model.addAttribute("infoType", Constants.BPM_PROCESS_TEMPLATE_CATEGORY);
        model.addAttribute("bean", bpmProcessTemplate);

        return "view/workflow/bpmProcessTemplate/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        BpmProcessTemplate bpmProcessTemplate = bpmProcessTemplateService.get(id);

        model.addAttribute("bean", bpmProcessTemplate);
        return "view/workflow/bpmProcessTemplate/view";
    }


    /**
     * 保存操作
     *
     * @param response           .
     * @param bpmProcessTemplate .
     * @param request            .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public String save(HttpServletResponse response, @ModelAttribute("bean") BpmProcessTemplate bpmProcessTemplate, HttpServletRequest request, Model model) throws Exception {

        BpmProcessTemplate target;
        if (bpmProcessTemplate.getId() != null) {
            target = bpmProcessTemplateService.get(bpmProcessTemplate.getId());
            ReflectionUtils.copyBean(bpmProcessTemplate, target, new String[]{
                    "name",
                    "category"
            });

        } else {
            target = bpmProcessTemplate;
            target.setUploadTime(new Timestamp(System.currentTimeMillis()));
        }
        byte[] par = bpmProcessTemplate.getVisioPar();
        if (par.length > 0) {
            target.setVisioPar(par);
            //get tmp file
            File tempFile = File.createTempFile("parFile", ".tmp");
            org.apache.commons.io.FileUtils.writeByteArrayToFile(tempFile, par);

            //decompress the file to get the internal file and set to attribute
            try {
                ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(tempFile);

                for (ZipEntry zipEntry : zipEntries) {
                    if (zipEntry.getName().endsWith("vml_1.emz")) {
                        target.setVmlEmz(ParFileUtils.readFileContentFromZipfile(tempFile, zipEntry.getName()));
                    }

                    if (zipEntry.getName().endsWith("topology.xml")) {
                        target.setTopologyXml(ParFileUtils.getContentFromPar(tempFile, zipEntry.getName(), "utf-8"));
                    }

                    if (zipEntry.getName().endsWith("vml_1.htm")) {
                        target.setVmlHtml(ParFileUtils.getContentFromPar(tempFile, zipEntry.getName(), "utf-8"));
                    }
                }

                tempFile.delete();
            } finally {
                tempFile.deleteOnExit();
            }
            //保存排序号orderno
            if (target.getOrderNo() == null) {
                String sql = "select nvl(max(order_no),0)+1 as maxNo from Bpm_Process_Template";
                target.setOrderNo(Long.valueOf(simpleQueryManager.getStringBySql(sql)));
            }

        }
        bpmProcessTemplateService.save(target);
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
        bpmProcessTemplateService.delete(id);

        sendSuccessJSON(response, "删除成功");
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
    public String viewDefine(Long id, String column, Model model) {
        BpmProcessTemplate bpmProcessTemplate = bpmProcessTemplateService.get(id);
        if ("vmlHtml".equals(column)) {
            model.addAttribute("templateCode", bpmProcessTemplate.getVmlHtml());
        } else if ("topologyXml".equals(column)) {
            model.addAttribute("templateCode", bpmProcessTemplate.getTopologyXml());
        }
        model.addAttribute("column", column);
        return "view/workflow/bpmProcessTemplate/viewDefine";
    }

    /**
     * 查看Visio流程图
     *
     * @param id    。
     * @param model 。
     * @throws Exception .
     */
    @RequestMapping
    public void viewEmz(Long id, Model model) throws Exception {
        BpmProcessTemplate bpmProcessTemplate = bpmProcessTemplateService.get(id);
        model.addAttribute("vmlHtml", bpmProcessDefinitionManager.getVmlHtml(id));
        model.addAttribute("bean", bpmProcessTemplate);
    }

    /**
     * 下载PAR文件
     *
     * @param id       .
     * @param response .
     */
    @RequestMapping
    public void blobDownload(Long id, HttpServletResponse response) {
        BpmProcessTemplate bpmProcessTemplate = bpmProcessTemplateService.get(id);
        try {
            fileDocumentManager.downloadByByte(response, bpmProcessTemplate.getVisioPar(), bpmProcessTemplate.getName());
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    /**
     * 重新排序，仅用于orderNo初始化时使用
     *
     * @param response .
     * @param model    .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public void reOrder(HttpServletResponse response, Model model) throws Exception {
        String hql = "from BpmProcessTemplate order by category.treeId asc,name asc";
        List<BpmProcessTemplate> templateList = bpmProcessTemplateService.findByQuery(hql);
        Long i = 0L;
        for (BpmProcessTemplate bpmFormTemplate : templateList) {
            i++;
            bpmFormTemplate.setOrderNo(i);
            bpmProcessTemplateService.save(bpmFormTemplate);
        }

        sendSuccessJSON(response, "排序成功");
    }

    /**
     * 流程测试页面
     *
     * @param model 。
     */
    @RequestMapping
    public String test(Model model) {
        BpmProcessTemplate bpmProcessTemplate = new BpmProcessTemplate();

        model.addAttribute("bean", bpmProcessTemplate);
        return "view/workflow/bpmProcessTemplate/test";
    }

    /**
     * 流程测试页面--保存
     *
     * @param bpmProcessTemplate .
     * @param model              .
     * @param response           .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public String testSave(@ModelAttribute("bean") BpmProcessTemplate bpmProcessTemplate, Model model, HttpServletResponse response) throws Exception {
        String topologyXml = "";

        byte[] par = bpmProcessTemplate.getVisioPar();
        if (par.length > 0) {
            //get tmp file
            File tempFile = File.createTempFile("parFile", ".tmp");
            FileUtils.writeByteArrayToFile(tempFile, par);

            //decompress the file to get the internal file and set to attribute
            try {
                ZipEntry[] zipEntries = ParFileUtils.readEntriesFromZipfile(tempFile);

                for (ZipEntry zipEntry : zipEntries) {
                    if (zipEntry.getName().endsWith("topology.xml")) {
                        topologyXml = ParFileUtils.getContentFromPar(tempFile, zipEntry.getName(), "utf-8");
                    }

                }

                tempFile.delete();
            } finally {
                tempFile.deleteOnExit();
            }
        }
        String check = "";
        if (!"".equals(topologyXml)) {
            check = bpmProcessDefinitionManager.checkTopology(topologyXml);
        }
        if (StringHelper.isEmpty(check)) {
            return OperationMsgManager.successCloseMsg(model, null, "该流程没有问题");
        } else {
            return OperationMsgManager.successCloseMsg(model, null, "该流程设置有误");
        }
    }

}