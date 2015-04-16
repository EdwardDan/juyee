package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.column.ColumnParam;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.manager.workflow.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.excel.ExcelFormUtils;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import flexjson.JSONSerializer;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.*;

/**
 * note:业务流程定义表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProcessDefinitionController extends BaseCRUDActionController<BpmProcessDefinition> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessDefinitionController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;


    @Autowired
    private BpmProcessDefinitionService bpmProcessDefinitionService;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private BpmFormTemplateService bpmFormTemplateService;

    @Autowired
    private BpmProcessDefinitionFormService bpmProcessDefinitionFormService;

    @Autowired
    private BpmProcessTemplateService bpmProcessTemplateService;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private BpmSwimlaneDefinitionService bpmSwimlaneDefinitionService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private BpmProcessCheckManager bpmProcessCheckManager;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    @Autowired
    private BpmProcessCopyManager bpmProcessCopyManager;

    /**
     * tab显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tabs(@RequestParam Long id, Model model) {
        model.addAttribute("processDefinitionId", id);
        return "view/workflow/bpmProcessDefinition/tabs";
    }

    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {
        return "view/workflow/bpmProcessDefinition/init";
    }

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model) {
        return "view/workflow/bpmProcessDefinition/grid";
    }

    /**
     * 流程定义入口图片页面
     *
     * @param model 。
     */
    @RequestMapping
    public String define(@RequestParam Long id, Model model) throws Exception {
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        BpmProcessTemplate bpmProcessTemplate = definition.getProcessTemplate();
        model.addAttribute("bean", bpmProcessTemplate);
        model.addAttribute("vmlHtml", bpmProcessDefinitionManager.getVmlHtml(bpmProcessTemplate.getId()));
        model.addAttribute("processDefinitionId", id);
        return "view/workflow/bpmProcessDefinition/define";
    }

    /**
     * 获取流程emz格式底图
     *
     * @param id                流程定义ID
     * @param processTemplateId 流程模板ID
     * @param response          .
     * @param model             .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public void getEmz(@RequestParam(required = false) Long id, @RequestParam(required = false) Long processTemplateId, HttpServletResponse response, Model model) throws Exception {
        BpmProcessTemplate template = null;
        if (processTemplateId != null) {
            template = bpmProcessTemplateService.get(processTemplateId);
        } else if (id != null) {
            BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);
            template = bpmProcessDefinition.getProcessTemplate();
        }

        if (template != null) {
            if (template.getVmlEmz() != null) {
//                response.setContentType("image/*");
                OutputStream outputStream = response.getOutputStream(); //得到向客户端输出二进制数据的对象
                outputStream.write(template.getVmlEmz()); //输出数据
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    /**
     * 左边树
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROCESS_DEFINITION_EDIT));
        model.addAttribute("clazz", BpmProcessDefinition.class.getName());
        return "view/workflow/bpmProcessDefinition/tree";
    }

    /**
     * 流程定义左边树
     *
     * @return .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            List<SysCodeDetail> listByCode = sysCodeManager.getCodeListByCode(Constants.BPM_PROCESS_DEFINITION_CATEGORY);
            for (SysCodeDetail data : listByCode) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(bpmProcessDefinitionManager.getBpmProcessDefinitionList(data.getId()).size() == 0);
                if (data.getIsValid()) {
                    treeNode.setIcon("1");
                } else {
                    treeNode.setIcon("2");
                }
                treeNode.setType("category");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "category")) {
            List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionManager.getBpmProcessDefinitionList(Long.valueOf(id));
            for (BpmProcessDefinition data : bpmProcessDefinitions) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(true);
                if (data.getIsValid()) {
                    treeNode.setIcon("1");
                } else {
                    treeNode.setIcon("2");
                }
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }


    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @return .
     * @throws Exception .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmProcessDefinition order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = bpmProcessDefinitionService.findByPage(pageModel, query);
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
     * @param model 。
     */
    @RequestMapping
    public String input(Long categoryId, Model model) {
        BpmProcessDefinition bpmProcessDefinition = new BpmProcessDefinition();
        bpmProcessDefinition.setCategory(sysCodeManager.getCodeListById(categoryId));

        //如需增加其他默认值请在此添加
        //字段映射
        String columnXml = bpmProcessDefinition.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        model.addAttribute("list", list);

        model.addAttribute("bean", bpmProcessDefinition);
        return "view/workflow/bpmProcessDefinition/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Long id, Model model) {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);

        //处理其他业务逻辑
        List<Map> formTemplates = new ArrayList<Map>();
        Set<BpmProcessDefinitionForm> definitionFormSet = bpmProcessDefinition.getBpmProcessDefinitionForms();
        for (BpmProcessDefinitionForm bizProcessDefinitionForm : definitionFormSet) {
            Map map = new HashMap();
            map.put("id", bizProcessDefinitionForm.getFormTemplate().getId());
            map.put("name", bizProcessDefinitionForm.getFormTemplate().getName());
            formTemplates.add(map);
        }

        //字段映射
        String columnXml = bpmProcessDefinition.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        for (ColumnParam param : list) {
            //是否失效
            Boolean isExpired = true;
            String formId = param.getFormId();
            String key = param.getKey();
            if (!StringHelper.isEmpty(formId) && !StringHelper.isEmpty(key)) {
                try {
                    BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(Long.valueOf(formId));
                    List<String> formKeys = ExcelFormUtils.getFormKeys(bpmFormTemplate.getParXml());
                    if (formKeys.contains(key)) {
                        param.setIsExpired(false);
                    }
                } catch (Exception e) {
                }
            }
            param.setIsExpired(isExpired);
        }
        model.addAttribute("list", list);

        model.addAttribute("bean", bpmProcessDefinition);
        model.addAttribute("formTemplates", formTemplates);
        return "view/workflow/bpmProcessDefinition/input";
    }

    /**
     * 保存操作
     *
     * @param bpmProcessDefinition .
     * @param model                .
     * @return .
     */
    @RequestMapping
    public void save(@ModelAttribute("bean") BpmProcessDefinition bpmProcessDefinition, @RequestParam String formTemplateIds,
                     @RequestParam(required = false) String isChangeFlow, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        //如果是新增对象的话，可以不用拷贝属性
        BpmProcessDefinition target;
        boolean isNew = bpmProcessDefinition.getId() == null;
        if (!isNew) {
            target = bpmProcessDefinitionService.get(bpmProcessDefinition.getId());
            ReflectionUtils.copyBean(bpmProcessDefinition, target, new String[]{
                    "code",
                    "name",
                    "description",
                    "fileCategory",
                    "orderNo"
            });
            target.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            if (target.getIsValid() == null) {
                target.setIsValid(false);
            }
        } else {
            target = bpmProcessDefinition;
            //创建时为第一版本
            target.setVersion(1);
            target.setIsValid(false);
//            target.setCreateTime(new Timestamp(System.currentTimeMillis()));
//            target.setUpdateTime(new Timestamp(System.currentTimeMillis()));

            //排序号
            if (target.getOrderNo() == null) {
                String sql = "select nvl(max(order_no),0)+1 as maxNo from Bpm_Process_Definition";
                target.setOrderNo(Long.valueOf(simpleQueryManager.getStringBySql(sql)));
            }
        }
        //如果流程模板发生变化，则要修改相应的流程节点
        Long targetProcessTemplateId = target.getProcessTemplate().getId();
        Long processTemplateId = bpmProcessDefinition.getProcessTemplate().getId();
        System.out.println("processTemplateId = " + processTemplateId);
        System.out.println("targetProcessTemplateId = " + targetProcessTemplateId);
        boolean isEquals = (targetProcessTemplateId != null && targetProcessTemplateId.equals(processTemplateId))
                || (processTemplateId != null && processTemplateId.equals(targetProcessTemplateId));

        //当流程表单的id发生变化或者页面选中强制级联更新或者是第一次
        if ((!isEquals) || (!StringHelper.isEmpty(isChangeFlow)) || isNew) {
            //设置ProcessTemplate，并清空bpm各表信息，再根据新的ProcessTemplate埴写bpm各表信
            target.setProcessTemplate(bpmProcessDefinition.getProcessTemplate());
            bpmProcessDefinitionManager.clearProcessDefintion(target);
            bpmProcessDefinitionManager.cascadeSaveProcessDefinition(target);
        }

        Set<BpmProcessDefinitionForm> definitionFormSet = target.getBpmProcessDefinitionForms();
        if (!StringHelper.isEmpty(formTemplateIds)) {
            for (BpmProcessDefinitionForm bizProcessDefinitionForm : definitionFormSet) {
                bpmProcessDefinitionFormService.delete(bizProcessDefinitionForm);
            }
            bpmProcessDefinitionFormService.flush();
        }

        //保存列表配置
        int len = request.getParameterValues("no").length;
        List<ColumnParam> list = new ArrayList<ColumnParam>();
        for (int i = 1; i <= len; i++) {
            ColumnParam param = new ColumnParam();
            param.setColumn(request.getParameter("column_" + i));
            param.setFormId(request.getParameter("formId_" + i));
            param.setFormName(request.getParameter("formName_" + i));
            param.setKey(request.getParameter("key_" + i));
            param.setIsValid(request.getParameter("isValid_" + i) != null);
            param.setIsGridShow(request.getParameter("isGridShow_" + i) != null);
            param.setGridName(request.getParameter("gridName_" + i));
            param.setGridWidth(request.getParameter("gridWidth_" + i));
            list.add(param);
        }
        target.setColumnXml(bpmFormTemplateManager.toXml(list));

        bpmProcessDefinitionService.save(target);

        logger.debug("formTemplateIds is {}", formTemplateIds);
        if (!StringHelper.isEmpty(formTemplateIds)) {
            String[] ids = formTemplateIds.split(",");
            for (String id : ids) {
                BpmProcessDefinitionForm bpmProcessDefinitionForm = new BpmProcessDefinitionForm();
                bpmProcessDefinitionForm.setProcessDefinition(target);
                BpmFormTemplate template = bpmFormTemplateService.get(Long.valueOf(id));
                bpmProcessDefinitionForm.setFormTemplate(template);
                bpmProcessDefinitionFormService.save(bpmProcessDefinitionForm);
            }
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param id    。
     * @param model 。
     * @return 。
     * @throws Exception 。
     */
    @RequestMapping
    public void delete(@RequestParam Long id, Model model, HttpServletResponse response) throws Exception {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);
        bpmProcessDefinitionManager.removeProcessInstanceByDefinition(bpmProcessDefinition);
        bpmProcessDefinitionManager.removeProcessDefintion(bpmProcessDefinition);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 删除操作
     *
     * @param id    。
     * @param model 。
     * @return 。
     * @throws Exception 。
     */
    @RequestMapping
    public void deleteInstanceByDefinition(@RequestParam Long id, Model model, HttpServletResponse response) throws Exception {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);
        bpmProcessDefinitionManager.removeProcessInstanceByDefinition(bpmProcessDefinition);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 查看页面
     *
     * @param id    。
     * @param model 。
     */
    @RequestMapping
    public String view(@RequestParam Long id, Model model) {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);

        List<Map> formTemplates = new ArrayList<Map>();
        Set<BpmProcessDefinitionForm> definitionFormSet = bpmProcessDefinition.getBpmProcessDefinitionForms();
        for (BpmProcessDefinitionForm bizProcessDefinitionForm : definitionFormSet) {
            Map map = new HashMap();
            map.put("id", bizProcessDefinitionForm.getFormTemplate().getId());
            map.put("name", bizProcessDefinitionForm.getFormTemplate().getName());
            formTemplates.add(map);
        }

        model.addAttribute("bean", bpmProcessDefinition);
        model.addAttribute("formTemplates", formTemplates);

        //字段映射
        String columnXml = bpmProcessDefinition.getColumnXml();
        List<ColumnParam> list = bpmFormTemplateManager.getColumnList(columnXml);
        for (ColumnParam param : list) {

            //是否失效
            Boolean isExpired = true;
            String formId = param.getFormId();
            String key = param.getKey();
            if (!StringHelper.isEmpty(formId) && !StringHelper.isEmpty(key)) {
                try {
                    BpmFormTemplate bpmFormTemplate = bpmFormTemplateService.get(Long.valueOf(formId));
                    List<String> formKeys = ExcelFormUtils.getFormKeys(bpmFormTemplate.getParXml());
                    if (formKeys.contains(key)) {
                        param.setIsExpired(false);
                    }
                } catch (Exception e) {
                }
            }
            param.setIsExpired(isExpired);
        }
        model.addAttribute("list", list);
        return "view/workflow/bpmProcessDefinition/view";
    }

    /**
     * 查看页面
     *
     * @param id    。
     * @param model 。
     */
    @RequestMapping
    public String deployBpmProcess(@RequestParam Long id, Model model) {
        return "view/workflow/bpmProcessDefinition/deployBpmProcess";
    }

    //查询条件
    @ModelAttribute("gridParam")
    public String setupModelAttribute(@RequestParam(required = false) String gridParam) {
        return StringHelper.isEmpty(gridParam) ? "" : gridParam;
    }


    //================tab============================


    /**
     * 模板信息
     *
     * @param model 。
     */
    @RequestMapping
    public String template(@RequestParam Long id, Model model) {
        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(id);
        Set<BpmProcessDefinitionForm> bpmProcessDefinitionForms = processDefinition.getBpmProcessDefinitionForms();
        List<Map> forms = new ArrayList<Map>();
        for (BpmProcessDefinitionForm bpmProcessDefinitionForm : bpmProcessDefinitionForms) {
            Map<String, String> map = new HashMap<String, String>();
            BpmFormTemplate bpmFormTemplate = bpmProcessDefinitionForm.getFormTemplate();
            map.put("type", bpmFormTemplate.getCategory().getName());
            map.put("name", bpmFormTemplate.getName());
            map.put("id", String.valueOf(bpmFormTemplate.getId()));
            forms.add(map);
        }
        model.addAttribute("forms", forms);
        return "view/workflow/bpmProcessDefinition/template";
    }

    /**
     * 版本信息
     *
     * @param model 。
     */
    @RequestMapping
    public String version(Long id, Model model) {
        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(id);
        String hql = "from BpmProcessDefinition t where t.name='" + processDefinition.getName() + "' order by t.version desc";
        List<BpmProcessDefinition> definitions = bpmProcessDefinitionService.findByQuery(hql);
        model.addAttribute("definitions", definitions);
        return "view/workflow/bpmProcessDefinition/version";
    }

    /**
     * 发布管理
     *
     * @param model 。
     */
    @RequestMapping
    public String deployManager(@RequestParam Long id, Model model) {
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);

        model.addAttribute("bean", definition);
        return "view/workflow/bpmProcessDefinition/deployManager";
    }

    @RequestMapping
    public void doClear(@RequestParam Long id, Model model, HttpServletResponse response) {
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        definition.setJbpmDefinitionId(null);
        bpmProcessDefinitionService.save(definition);
        sendSuccessJSON(response, "清空成功！");
    }

    /**
     * 布署
     *
     * @param model 。
     */
    @RequestMapping
    public void doDeploy(@RequestParam Long id, Model model, HttpServletResponse response) throws JAXBException {
        System.out.println("...........................id = " + id);
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        bpmProcessDefinitionManager.deployBpmProcessDefinition(definition);

        //布署成功设置为启用
        definition.setIsValid(true);
        bpmProcessDefinitionService.save(definition);
        sendSuccessJSON(response, "布署成功！");
    }

    /**
     * 保存是否启用
     *
     * @param model 。
     */
    @RequestMapping
    public void saveIsValid(@RequestParam Long id, @RequestParam Boolean isValid, Model model, HttpServletResponse response) {
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        definition.setIsValid(isValid);
        bpmProcessDefinitionService.save(definition);
        sendSuccessJSON(response, "保存成功！");
    }

    /**
     * 升级版本
     *
     * @param model 。
     */
    @RequestMapping
    public void doUpgrade(@RequestParam Long id, Model model, HttpServletResponse response) {
        //拷贝当前流程
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        bpmProcessCopyManager.upgradeProcessDefinition(definition);
        sendSuccessJSON(response, "升级成功！");
    }

    /**
     * 查看检查流程设置
     *
     * @param model 。
     */
    @RequestMapping
    public String errorInfo(@RequestParam Long id, Model model) {
        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(id);
        List<Map> errors = bpmProcessCheckManager.checkProcessDefinition(processDefinition);
        model.addAttribute("errors", errors);
        return "view/workflow/bpmProcessDefinition/errorInfo";
    }

    @RequestMapping
    public String bizBinding(@RequestParam Long id, Model model) {
        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(id);
        List<Map> bizClasses = bpmProcessDefinitionManager.getAllBizClass();

        model.addAttribute("bean", processDefinition);
        model.addAttribute("bizClasses", bizClasses);
        return "view/workflow/bpmProcessDefinition/bizBinding";
    }

    @RequestMapping
    public void saveBizBiding(@ModelAttribute("bean") BpmProcessDefinition bpmProcessDefinition, @RequestParam Long id, Model model
            , HttpServletResponse response) throws Exception {
        //如果是新增对象的话，可以不用拷贝属性
        BpmProcessDefinition target;
        boolean isNew = bpmProcessDefinition.getId() == null;
        if (!isNew) {
            target = bpmProcessDefinitionService.get(bpmProcessDefinition.getId());
            ReflectionUtils.copyBean(bpmProcessDefinition, target, new String[]{
                    "bizObject",
                    "initScript",
                    "updateScript",
                    "finishScript"
            });
            target.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        } else {
            throw new RuntimeException("请先定义流程！");
        }
        bpmProcessDefinitionService.save(target);
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 查看流程泳道
     *
     * @param model 。
     */
    @RequestMapping
    public String viewSwimlane(@RequestParam Long id, Model model) {
        BpmProcessDefinition definition = bpmProcessDefinitionService.get(id);
        //处理其他业务逻辑
        BpmSwimlaneDefinition bpmSwimlaneDefinition = definition.getViewSwimlaneDefinition();
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_TYPE);
        model.addAttribute("positionType", Constants.BPM_PROJECT_GROUP_DUTY_TYPE);
        model.addAttribute("bean", definition);
        return "view/workflow/bpmProcessDefinition/viewSwimlane";
    }

    /**
     * 保存查看流程泳道
     *
     * @param model 。
     */
    @RequestMapping
    public void saveViewSwimlane(@RequestParam Long id, @RequestParam Long groupId, @RequestParam Long positionTypeId
            , @RequestParam String expression, Model model, HttpServletResponse response) {
        BpmProcessDefinition bpmProcessDefinition = bpmProcessDefinitionService.get(id);

        BpmSwimlaneDefinition definition;
        if (null != bpmProcessDefinition.getViewSwimlaneDefinition()) {
            definition = bpmProcessDefinition.getViewSwimlaneDefinition();
        } else {
            definition = new BpmSwimlaneDefinition();
        }

        SysCodeDetail group = sysCodeDetailService.get(groupId);
        definition.setGroup(group);
        SysCodeDetail positionType = sysCodeDetailService.get(positionTypeId);
        definition.setPositionType(positionType);
        definition.setExpression(expression);
        bpmSwimlaneDefinitionService.save(definition);

        bpmProcessDefinition.setViewSwimlaneDefinition(definition);
        bpmProcessDefinitionService.save(bpmProcessDefinition);
        sendSuccessJSON(response, "保存成功！");
    }

    /**
     * 查看人员
     */
    @RequestMapping
    public String viewSwimlanePerson(HttpServletRequest request, String id, Model model) throws Exception {
        Long iid = Long.parseLong(id);
        BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(iid);
        BpmSwimlaneDefinition definition = processDefinition.getViewSwimlaneDefinition();
        List<Map> varNames = null;
        List<Map> persons = null;

        if (definition != null) {
            String expression = definition.getExpression();
            varNames = new ArrayList<Map>();
            Map<String, String> varMap = new HashMap<String, String>();
            if (!StringHelper.isEmpty(expression)) {
                Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
                for (String varName : varNameSet) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("varName", varName);
                    String varValue = request.getParameter(varName);
                    logger.debug("+++++++++++++++varValue is " + varValue);
                    if (varValue == null) {
                        varValue = "";
                    }
                    map.put("varValue", varValue);
                    varNames.add(map);
                    varMap.put(varName, varValue);
                }
            }

            //get person
            persons = new ArrayList<Map>();
            List<Candidate> canditates = bpmSwimlaneManager.getCandidates(definition, varMap);
            for (Candidate canditate : canditates) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("group", canditate.getBpmProjectGroup().getName());
                map.put("duty", canditate.getBpmProjectGroupDuty().getName());
                map.put("person", canditate.getSysPerson().getName());
                persons.add(map);
            }
        }

        model.addAttribute("varNames", varNames);
        model.addAttribute("persons", persons);
        model.addAttribute("bean", processDefinition);
        return "view/workflow/bpmProcessDefinition/viewSwimlanePerson";
    }

    /**
     * 重新排序，仅用于orderNo初始化时使用
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping
    public void reOrder(Model model, HttpServletResponse response) throws Exception {
        String hql = "from BpmProcessDefinition order by name asc";
        List<BpmProcessDefinition> definitionList = bpmProcessDefinitionService.findByQuery(hql);
        Long i = 0L;
        for (BpmProcessDefinition processDefinition : definitionList) {
            i++;
            processDefinition.setOrderNo(i);
            bpmProcessDefinitionService.save(processDefinition);
        }
        sendSuccessJSON(response, "重新排序成功");
    }

    /**
     * 导入其他项目的流程定义--选择定义页面
     *
     * @param model 。
     */
    @RequestMapping
    public String importDefinition(Model model) {
        List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionManager.getBpmProcessDefinitionList(null);
        model.addAttribute("bpmProcessDefinitions", bpmProcessDefinitions);

        return "view/workflow/bpmProcessDefinition/import";
    }

    /**
     * 导入其他项目的流程定义--保存页面
     *
     * @param model 。
     */
    @RequestMapping
    public void importSave(@RequestParam String[] definitionIds, Model model, HttpServletResponse response) throws Exception {
        //先找出已存在流程，如果编码相同则不允许再次导入
        HashSet<String> hs = new HashSet<String>();
        List<BpmProcessDefinition> bpmProcessDefinitions = bpmProcessDefinitionManager.getBpmProcessDefinitionList(null);
        for (BpmProcessDefinition bpmProcessDefinition : bpmProcessDefinitions) {
            hs.add(bpmProcessDefinition.getCode());
        }

        int count = 0;
        int errCount = 0;
        String names = "";
        for (String defintionId : definitionIds) {
            BpmProcessDefinition processDefinition = bpmProcessDefinitionService.get(Long.valueOf(defintionId));
            if (!hs.contains(processDefinition.getCode())) {
                //导入流程定义
                Boolean isError = false;
                try {
                    bpmProcessCopyManager.importProcessDefinition(processDefinition);
                } catch (Exception e) {
//                    throw new Exception("导入失败！流程【"+processDefinition.getName()+"】定义不正确，请重新设置完整之后再导入！");
                    e.printStackTrace();
                    isError = true;
                }
                if (isError) {
                    errCount++;
                } else {
                    count++;
                }
            } else {
                if ("".equals(names)) {
                    names += processDefinition.getName();
                } else {
                    names += "," + processDefinition.getName();
                }
            }
        }
        String msg = count + "个流程定义导入成功！";
        if (errCount > 0) {
            msg += "<br>" + "" + errCount + "个流程定义导入失败！";
        }
        sendSuccessJSON(response);
    }

    @RequestMapping
    public String testProcess(String code, Model model, HttpServletResponse response) {
        org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();

        WriterAppender writerAppender = new WriterAppender();
        writerAppender.setName("WriterAppender");
        PatternLayout layout = new PatternLayout("%d %p [%c{1} %L] - %m%n");
        writerAppender.setLayout(layout);
        StringWriter stringWriter = new StringWriter();
        writerAppender.setWriter(stringWriter);
        rootLogger.addAppender(writerAppender);

        Map<String, String> mapRecord = new HashMap<String, String>();
        List<String> mapPath = new ArrayList<String>();
        List errors = new ArrayList();
        try {
            errors = bpmProcessCheckManager.autoFlowJBPM(code, mapRecord, mapPath);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        Map<String, Object> infos = new HashMap<String, Object>();
        infos.put("errors", errors);
        infos.put("path", mapPath);
        infos.put("log", JspHelper.FormatOutPutString(stringWriter.toString()));

        rootLogger.removeAppender("WriterAppender");
        model.addAttribute("msg", new JSONSerializer().deepSerialize(infos));
        return "common/msg";
    }
}