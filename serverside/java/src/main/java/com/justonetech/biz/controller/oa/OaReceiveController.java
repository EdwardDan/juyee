package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaReceiveManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaReceiveStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
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
import java.sql.Timestamp;
import java.util.*;


/**
 * note:收文管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaReceiveController extends BaseCRUDActionController<OaReceive> {
    private Logger logger = LoggerFactory.getLogger(OaReceiveController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaReceiveOperationService oaReceiveOperationService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaReceiveNodeService oaReceiveNodeService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaReceiveService oaReceiveService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private OaReceiveStepService oaReceiveStepService;

    @Autowired
    private OaReceiveManager oaReceiveManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        SysUser sysUser = sysUserManager.getSysUser();
        //判断是否有编辑权限
        model.addAttribute("isZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_RECEIVE_NB_ZR)); //办公室主任拟办
        model.addAttribute("SWDJ", OaReceiveStatus.OA_RECEIVE_SWDJ.getCode());//收文登记
        model.addAttribute("BGSNB", OaReceiveStatus.OA_RECEIVE_BGSNB.getCode());//办公室拟办
        model.addAttribute("LDPS", OaReceiveStatus.OA_RECEIVE_LDPS.getCode());//领导批示
        model.addAttribute("BMLDYJ", OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode());//部门领导意见
        model.addAttribute("BLJG", OaReceiveStatus.OA_RECEIVE_BLJG.getCode());//办理结果
        model.addAttribute("CB", OaReceiveStatus.OA_RECEIVE_CB.getCode());//催办
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_RECEIVE_EDIT));
        return "view/oa/oaReceive/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaReceive order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaReceiveService.findByPage(pageModel, query);

            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            SysUser sysUser = sysUserManager.getSysUser();

            for (Map bean : mapList) {
                OaReceive oaReceive = oaReceiveService.get(JspHelper.getLong(bean.get("id")));
                String dealPersons = oaReceive.getDealPersons();
                String dealDepts = oaReceive.getDealDepts();
                String bljgPersons = oaReceive.getBljgPersons();

                //附件
                bean.put("documentFile", documentManager.getDownloadButton(oaReceive.getDoc()));
                //办公室登记 可编辑
                if (null != sysUser.getDisplayName() && oaReceive.getCreateUser().equals(sysUser.getLoginName())) {
                    if (null != oaReceive.getStep() && OaReceiveStatus.OA_RECEIVE_SWDJ.getCode().equals(oaReceive.getStep().getCode())) {
                        bean.put("isValid", "true");
                    }
                }
                //领导批示  可审核
                if (!StringHelper.isEmpty(dealPersons)) {        //过滤用户 ，在审核人中
                    String dealPersonIds = "," + dealPersons + ",";
                    if (dealPersonIds.contains("," + sysUser.getId() + ",")) {
                        if (null != oaReceive.getStep() && OaReceiveStatus.OA_RECEIVE_LDPS.getCode().equals(oaReceive.getStep().getCode())) {
                            bean.put("isValid", "true");
                        }
                    }
                }
                //部门领导意见 科长可审核
                if (!StringHelper.isEmpty(dealDepts)) {        //过滤用户 ，在审核部门中
                    String dealDeptIds = "," + dealDepts + ",";
                    if (null != sysUser.getPerson() && null != sysUser.getPerson().getDept()) {
                        SysDept dept = sysUser.getPerson().getDept();
                        if (sysUserManager.hasPrivilege(PrivilegeCode.OA_RECEIVE_AUDIT) && dealDeptIds.contains("," + dept.getId() + ",")) { //属于审核部门且有审核权限的才能审核 其他人员只能查看
                            if (null != oaReceive.getStep() && OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode().equals(oaReceive.getStep().getCode())) {
                                bean.put("isValid", "true");
                            }
                        }
                    }
                }

                //办理结果  可审核
                if (!StringHelper.isEmpty(bljgPersons)) {        //过滤用户 ，在办理结果审核人中
                    String bljgPersonIds = "," + bljgPersons + ",";
                    if (bljgPersonIds.contains("," + sysUser.getId() + ",")) {
                        if (null != oaReceive.getStep() && OaReceiveStatus.OA_RECEIVE_BLJG.getCode().equals(oaReceive.getStep().getCode())) {
                            bean.put("isValid", "true");
                        }
                    }
                }
                int days = DateTimeHelper.getDays(new Timestamp(System.currentTimeMillis()), oaReceive.getNodeReceiveTime());
                if (days > 2) {
                    bean.put("isPress", "true");
                }
            }
            //输出显示
            String json = GridJq.toJSON(mapList, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 设置共用属性
     *
     * @param model
     * @param oaReceive
     */
    private void setSysCode(Model model, OaReceive oaReceive) {
        model.addAttribute("type", Constants.OA_RECEIVE_TYPE);
        model.addAttribute("fileType", Constants.OA_RECEIVE_FILE_TYPE);
        model.addAttribute("secret", Constants.FILE_SECURITY);
        model.addAttribute("urgent", Constants.EMERGENCY);
        if (null != oaReceive.getStep()) {
            OaReceiveStep step = oaReceive.getStep();
            Set<OaReceiveOperation> operations = step.getOaReceiveOperations();
            model.addAttribute("operations", operations);
        }

        Map<String, Object> docMap = oaReceiveManager.setDocAndAttach(oaReceive);
        model.addAttribute("documentFile", documentManager.getDownloadButton(oaReceive.getDoc()));
        model.addAttribute("uploadButton", docMap.get("uploadButton"));//设置附件
        model.addAttribute("docAttachs", docMap.get("docAttachs")); //设置附件名称
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaReceive oaReceive = new OaReceive();
        //自动生成编号
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        oaReceive.setYear(year);
        oaReceive.setOrderNo(oaReceiveManager.setAutoCode(year));
        //设置初始步骤 为收文登记
        OaReceiveStep step = oaReceiveStepService.findUniqueByProperty("code", OaReceiveStatus.OA_RECEIVE_SWDJ.getCode());
        oaReceive.setStep(step);
        oaReceive.setNodeReceiveTime(new Timestamp(System.currentTimeMillis())); //当状态改变时 为各审核人收到时间
        //如需增加其他默认值请在此添加
        setSysCode(model, oaReceive);
        model.addAttribute("openTime", new Timestamp(System.currentTimeMillis()));

        model.addAttribute("bean", oaReceive);
        return "view/oa/oaReceive/inputPre";
    }


    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyPre(Model model, Long id) {
        OaReceive oaReceive = oaReceiveService.get(id);
        setSysCode(model, oaReceive);
        model.addAttribute("bean", oaReceive);
        model.addAttribute("openTime", new Timestamp(System.currentTimeMillis()));
        return "view/oa/oaReceive/inputPre";
    }

    /**
     * 修改拟办页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        OaReceive oaReceive = oaReceiveService.get(id);
        //根据处理人和处理部门的IDs获取相应的处理人和处理部门
        HashMap<String, String> sysUserHM = oaReceiveManager.setPersonIdsToMap(oaReceive.getDealPersons());
        model.addAttribute("sysUserHM", sysUserHM);
        HashMap<String, String> sysDeptHM = oaReceiveManager.setDeptIdsToMap(oaReceive.getDealDepts());
        model.addAttribute("sysDeptHM", sysDeptHM);
        //处理其他业务逻辑
        setSysCode(model, oaReceive);
        model.addAttribute("bean", oaReceive);
        model.addAttribute("openTime", new Timestamp(System.currentTimeMillis()));
        return "view/oa/oaReceive/input";
    }

    /**
     * 显示审核主页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String auditMain(Model model, Long id, String type) {
        OaReceive oaReceive = oaReceiveService.get(id);
        //处理其他业务逻辑
        setSysCode(model, oaReceive);

        model.addAttribute("bean", oaReceive);
        List<OaReceiveStep> steps = oaReceiveStepService.findByQuery("from OaReceiveStep where isShow=1  order by orderNo ,id desc ");
        model.addAttribute("stepList", steps);
        Map<Long, List<OaReceiveNode>> stepNodes = new HashMap<Long, List<OaReceiveNode>>();
        for (OaReceiveStep step : steps) {
            List<OaReceiveNode> nodeList = oaReceiveNodeService.findByQuery("from OaReceiveNode where stepId=" + step.getId() + " and oaReceive.id=" + oaReceive.getId() + " order by completeTime");
            stepNodes.put(step.getId(), nodeList);
        }
        model.addAttribute("stepNodes", stepNodes);
        model.addAttribute("type", type);
        model.addAttribute("openTime", new Timestamp(System.currentTimeMillis()));

        model.addAttribute("SWDJ", OaReceiveStatus.OA_RECEIVE_SWDJ.getCode());//收文登记
        model.addAttribute("BGSNB", OaReceiveStatus.OA_RECEIVE_BGSNB.getCode());//办公室拟办
        model.addAttribute("LDPS", OaReceiveStatus.OA_RECEIVE_LDPS.getCode());//领导批示
        model.addAttribute("BMLDYJ", OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode());//部门领导意见
        model.addAttribute("BLJG", OaReceiveStatus.OA_RECEIVE_BLJG.getCode());//办理结果
        model.addAttribute("CB", OaReceiveStatus.OA_RECEIVE_CB.getCode());//催办

        return "view/oa/oaReceive/auditMain";
    }

    /**
     * 修改审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaReceiveNode node;
        OaReceive oaReceive = oaReceiveService.get(id);
        SysUser loginUser = sysUserManager.getSysUser();
        String hql = " from OaReceiveNode where stepId=" + oaReceive.getStep().getId() + " and  dealUser='" + loginUser.getDisplayName() + "'  and oaReceive.id=" + oaReceive.getId() + "  order by id desc ";
        List<OaReceiveNode> nodes = oaReceiveNodeService.findByQuery(hql);
        if (null != nodes && nodes.size() > 0) {
            node = nodes.iterator().next();
        } else {
            node = new OaReceiveNode();
            node.setReceiveTime(oaReceive.getNodeReceiveTime());
            node.setOpenTime(new Timestamp(System.currentTimeMillis()));  //设置打开时间
            node.setOaReceive(oaReceive);
            node.setStepId(oaReceive.getStep().getId());
            node.setDealUser(loginUser.getDisplayName());//设置处理人
        }
        //根据办理结果处理人和处理部门的IDs获取相应的处理人和处理部门
        HashMap<String, String> bljgUserHM = oaReceiveManager.setPersonIdsToMap(oaReceive.getBljgPersons());
        model.addAttribute("bljgUserHM", bljgUserHM);
        HashMap<String, String> sysDeptHM = oaReceiveManager.setDeptIdsToMap(oaReceive.getDealDepts());
        model.addAttribute("sysDeptHM", sysDeptHM);

        if (null != oaReceive.getStep()) {
            OaReceiveStep step = oaReceive.getStep();
            Set<OaReceiveOperation> operations = step.getOaReceiveOperations();
            model.addAttribute("operations", operations);
        }
        //处理其他业务逻辑
        model.addAttribute("bean2", node);
        return "view/oa/oaReceive/audit";
    }

    /**
     * 催办页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String press(Model model, Long id) {
        OaReceiveStep step = oaReceiveStepService.findUniqueByProperty("code", OaReceiveStatus.OA_RECEIVE_CB.getCode());
        OaReceiveNode node;
        OaReceive oaReceive = oaReceiveService.get(id);
        //            String dealDepts = oaReceive.getDealDepts();
        String hql = " from OaReceiveNode where oaReceive.step.code='" + oaReceive.getStep().getCode() + "'  and oaReceive.id=" + oaReceive.getId() + "  order by id desc ";
        List<OaReceiveNode> nodes = oaReceiveNodeService.findByQuery(hql);
        List<String> nodeUser = new ArrayList<String>();
        for (OaReceiveNode oaReceiveNode : nodes) {
            nodeUser.add(oaReceiveNode.getDealUser());
        }

        if (!oaReceive.getStep().getCode().equals(OaReceiveStatus.OA_RECEIVE_SWWC.getCode())) {
            List<SysUser> users = new ArrayList<SysUser>();
            //办公室拟办
            int days = DateTimeHelper.getDays(new Timestamp(System.currentTimeMillis()), oaReceive.getNodeReceiveTime());
            if (OaReceiveStatus.OA_RECEIVE_BGSNB.getCode().equals(oaReceive.getStep().getCode()) && days > 2) {
                users = sysUserManager.getUsersByPrivilegeCode(PrivilegeCode.OA_RECEIVE_NB_ZR);//需要催办的用户
            }

            //领导批示--处理人
            String dealPersons = oaReceive.getDealPersons();
            if (!StringHelper.isEmpty(dealPersons)) {
                String[] persons = dealPersons.split(",");
                List<String> dealUser = new ArrayList<String>();
                Map<String, SysUser> dealUserMap = new HashMap<String, SysUser>();
                for (String personId : persons) {
                    SysUser sysUser = sysUserService.get(Long.valueOf(personId));
                    dealUser.add(sysUser.getDisplayName());
                    dealUserMap.put(sysUser.getDisplayName(), sysUser);
                }
                //领导批示
                if (OaReceiveStatus.OA_RECEIVE_LDPS.getCode().equals(oaReceive.getStep().getCode()) && days > 2) {
                    dealUser.removeAll(nodeUser);
                    for (String user : dealUser) {
                        users.add(dealUserMap.get(user));// 需要催办的用户
                    }
                }
            }

            //办理结果--处理人
            String bljgPersons = oaReceive.getBljgPersons();
            if (!StringHelper.isEmpty(bljgPersons)) {
                String[] bljgUsers = bljgPersons.split(",");
                List<String> bljgUser = new ArrayList<String>();
                Map<String, SysUser> bljgUserMap = new HashMap<String, SysUser>();
                for (String personId : bljgUsers) {
                    SysUser sysUser = sysUserService.get(Long.valueOf(personId));
                    bljgUser.add(sysUser.getDisplayName());
                    bljgUserMap.put(sysUser.getDisplayName(), sysUser);
                }
                //处理结果
                if (OaReceiveStatus.OA_RECEIVE_BLJG.getCode().equals(oaReceive.getStep().getCode()) && days > 2) {
                    bljgUser.removeAll(nodeUser);
                    for (String user : bljgUser) {
                        users.add(bljgUserMap.get(user));// 需要催办的用户
                    }
                }
            }
            model.addAttribute("users", users);
            if (null != users && users.size() > 0) {
                String userId = "";
                for (SysUser user : users) {
                    userId += "," + user.getId();
                }
                model.addAttribute("userId", userId.substring(1));
            }
        }

        SysUser loginUser = sysUserManager.getSysUser();
        String hql1 = " from OaReceiveNode where oaReceive.step.code='" + OaReceiveStatus.OA_RECEIVE_CB.getCode() + "'  and oaReceive.id=" + oaReceive.getId() + "  and dealUser='" + loginUser.getDisplayName() + "'  order by id desc ";
        List<OaReceiveNode> nodes1 = oaReceiveNodeService.findByQuery(hql1);
        if (null != nodes1 && nodes1.size() > 0) {
            node = nodes1.iterator().next();
        } else {
            node = new OaReceiveNode();
            node.setReceiveTime(oaReceive.getNodeReceiveTime());
            node.setOpenTime(new Timestamp(System.currentTimeMillis()));  //设置打开时间
            node.setOaReceive(oaReceive);
            node.setStepId(step.getId());
            node.setDealUser(loginUser.getDisplayName());//设置处理人
        }
        Set<OaReceiveOperation> operations = step.getOaReceiveOperations();
        model.addAttribute("operations", operations);
        //处理其他业务逻辑
        model.addAttribute("bean2", node);
        return "view/oa/oaReceive/press";
    }

    /**
     * 保存登记操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void savePre(HttpServletResponse response, @ModelAttribute("bean") OaReceive entity, HttpServletRequest request) throws Exception {
        try {
            OaReceive target;
            if (entity.getId() != null) {
                target = oaReceiveService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "fileCode",
                        "title",
                        "sourceDept",
                        "receiveDate",
                        "deptName",
                        "writtenDate",
                        "limitDate",
                        "fs",
                        "ys",
                        "startDept",
                        "fileType",
                        "type",
                        "urgent",
                        "secret"
                });

            } else {
                target = entity;
            }
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDoc(docDocument);
            }

            //新建一条数据时，保存一个日志信息
            String openTime = request.getParameter("openTime");
            String operationId = request.getParameter("operationId");

            OaReceiveNode node = new OaReceiveNode();
            node.setDealUser(sysUserManager.getSysUser().getDisplayName());
            if (!StringHelper.isEmpty(openTime)) {
                node.setOpenTime(Timestamp.valueOf(openTime));
                node.setReceiveTime(target.getNodeReceiveTime());
            }
            node.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            //设置操作
            if (!StringHelper.isEmpty(operationId)) {
                node.setOperation(oaReceiveOperationService.get(Long.valueOf(operationId)));
            }
            node.setStepId(target.getStep().getId());
            node.setIsDeal(true);
            node.setOaReceive(target);
            oaReceiveService.save(target);
            oaReceiveNodeService.save(node);

            List<OaReceiveStep> steps = oaReceiveStepService.findByProperty("code", OaReceiveStatus.OA_RECEIVE_BGSNB.getCode()); //设置审核步骤
            if (null != steps && steps.size() > 0) {
                target.setStep(steps.iterator().next());
                target.setNodeReceiveTime(new Timestamp(System.currentTimeMillis()));
            }
            oaReceiveService.save(target);
            oaReceiveManager.createOaTask(target, null);


        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }


    /**
     * 保存拟办操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaReceive entity, HttpServletRequest request) throws Exception {
        try {
            OaReceive target;
            if (entity.getId() != null) {
                target = oaReceiveService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "dealPersons",
                        "dealDepts",
                        "dealContent"
                });
            } else {
                target = entity;
            }

            //新建一条数据时，保存一个日志信息
            String openTime = request.getParameter("openTime");
            String operationId = request.getParameter("operationId");

            OaReceiveNode node = new OaReceiveNode();
            node.setDealUser(sysUserManager.getSysUser().getDisplayName());
            if (!StringHelper.isEmpty(openTime)) {
                node.setOpenTime(Timestamp.valueOf(openTime));
            }
            node.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            //设置操作
            if (!StringHelper.isEmpty(operationId)) {
                node.setOperation(oaReceiveOperationService.get(Long.valueOf(operationId)));
            }
            node.setStepId(target.getStep().getId());
            node.setIsDeal(true);
            node.setOaReceive(target);
            node.setReceiveTime(target.getNodeReceiveTime());
            oaReceiveService.save(target);
            oaReceiveNodeService.save(node);

            List<OaReceiveStep> steps = oaReceiveStepService.findByProperty("code", OaReceiveStatus.OA_RECEIVE_LDPS.getCode()); //设置审核步骤
            if (null != steps && steps.size() > 0) {
                target.setStep(steps.iterator().next());
                target.setNodeReceiveTime(new Timestamp(System.currentTimeMillis()));
            }
            oaReceiveService.save(target);
            oaReceiveManager.createOaTask(target, null);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 审核保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean2") OaReceiveNode entity, HttpServletRequest request) throws Exception {
        try {
            OaReceiveNode target;
            if (entity.getId() != null) {
                target = oaReceiveNodeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "isDeal",
                        "openTime",
                        "dealResult"
                });

            } else {
                target = entity;
            }
            String operationId = request.getParameter("operationId");
            if (!StringHelper.isEmpty(operationId)) {
                target.setOperation(oaReceiveOperationService.get(Long.valueOf(operationId)));
            }
            target.setCompleteTime(new Timestamp(System.currentTimeMillis()));//设置处理完成时间
            //只有部门领导意见审核时才保存审核部门
            if (null != target.getOaReceive() && null != target.getOaReceive().getStep() && OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode().equals(target.getOaReceive().getStep().getCode())) {
                SysUser sysUser = sysUserManager.getSysUser();
                if (null != sysUser.getPerson() && null != sysUser.getPerson().getDept()) {
                    target.setDealDept(sysUser.getPerson().getDept());
                }
            }
            target.setReceiveTime(target.getOaReceive().getNodeReceiveTime());
            oaReceiveNodeService.save(target);
            //修改oaReceive中当前步骤
            OaReceive oaReceive = target.getOaReceive();
            OaReceiveStep step = oaReceive.getStep();

            Set<OaReceiveNode> oaReceiveNodes = oaReceive.getOaReceiveNodes();
            Map<String, OaReceiveNode> byUserMap = new HashMap<String, OaReceiveNode>();
            Map<Long, OaReceiveNode> byDeptMap = new HashMap<Long, OaReceiveNode>();
            for (OaReceiveNode oaReceiveNode : oaReceiveNodes) {
                byUserMap.put(oaReceiveNode.getDealUser(), oaReceiveNode);
                if (null != oaReceiveNode.getDealDept()) {
                    byDeptMap.put(oaReceiveNode.getDealDept().getId(), oaReceiveNode);
                }
            }

            //领导批示
            if (OaReceiveStatus.OA_RECEIVE_LDPS.getCode().equals(step.getCode())) {
                //调整审核部门
                String dealDepts = request.getParameter("dealDepts");
                if (!StringHelper.isEmpty(dealDepts)) {
                    oaReceive.setDealDepts(dealDepts);
                }
                OaReceiveStep next = oaReceiveStepService.findUniqueByProperty("code", OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode());//部门领导意见
                String dealPersons = oaReceive.getDealPersons();
                String[] dealPerson = dealPersons.split(",");
                for (String s : dealPerson) {
                    SysUser sysUser = sysUserService.get(Long.valueOf(s));
                    if (null != sysUser.getDisplayName() && null == byUserMap.get(sysUser.getDisplayName())) {
                        oaReceive.setStep(step);
                        break;
                    } else {
                        oaReceive.setStep(next);
                        oaReceiveManager.createOaTask(oaReceive, null); //创建系统任务
                    }
                }
                if (oaReceive.getStep().equals(next)) {
                    oaReceive.setNodeReceiveTime(new Timestamp(System.currentTimeMillis()));
                }
            }
            //部门领导意见
            if (OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode().equals(step.getCode())) {
                //设置办理结果处理人
                String bljgPersons = request.getParameter("bljgPersons");
                if (!StringHelper.isEmpty(bljgPersons)) {
                    oaReceive.setBljgPersons(bljgPersons);
                }
                OaReceiveStep next = oaReceiveStepService.findUniqueByProperty("code", OaReceiveStatus.OA_RECEIVE_BLJG.getCode());//办理结果
                String dealDepts = oaReceive.getDealDepts();
                String[] dept = dealDepts.split(",");
                for (String s : dept) {
                    SysDept sysDept = sysDeptService.get(Long.valueOf(s));
                    if (null != sysDept && null == byDeptMap.get(sysDept.getId())) {
                        oaReceive.setStep(step);
                        break;
                    } else {
                        oaReceive.setStep(next);
                        oaReceiveManager.createOaTask(oaReceive, null);  //创建系统任务
                    }
                }
                if (oaReceive.getStep().equals(next)) {
                    oaReceive.setNodeReceiveTime(new Timestamp(System.currentTimeMillis()));
                }
            }

            //办理结果
            if (OaReceiveStatus.OA_RECEIVE_BLJG.getCode().equals(step.getCode())) {
                OaReceiveStep next = oaReceiveStepService.findUniqueByProperty("code", OaReceiveStatus.OA_RECEIVE_SWWC.getCode());//收文完成
                String bljgPersons = oaReceive.getBljgPersons();
                String[] bljgPerson = bljgPersons.split(",");
                for (String s : bljgPerson) {
                    SysUser sysUser = sysUserService.get(Long.valueOf(s));
                    if (null != sysUser.getDisplayName() && null == byUserMap.get(sysUser.getDisplayName())) {
                        oaReceive.setStep(step);
                        break;
                    } else {
                        oaReceive.setStep(next);
                        oaReceiveManager.createOaTask(oaReceive, null);//创建系统任务
                    }
                }
                if (oaReceive.getStep().equals(next)) {
                    oaReceive.setNodeReceiveTime(new Timestamp(System.currentTimeMillis()));
                }
            }

            oaReceiveService.save(oaReceive);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 催办保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void pressSave(HttpServletResponse response, @ModelAttribute("bean2") OaReceiveNode entity, HttpServletRequest request) throws Exception {
        try {
            OaReceiveNode target;
            if (entity.getId() != null) {
                target = oaReceiveNodeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "isDeal",
                        "openTime",
                        "dealResult"
                });

            } else {
                target = entity;
            }
            String operationId = request.getParameter("operationId");
            if (!StringHelper.isEmpty(operationId)) {
                target.setOperation(oaReceiveOperationService.get(Long.valueOf(operationId)));
            }
            String userId = request.getParameter("userId");
            target.setCompleteTime(new Timestamp(System.currentTimeMillis()));//设置处理完成时间
            target.setReceiveTime(target.getOaReceive().getNodeReceiveTime());
            oaReceiveNodeService.save(target);
            oaReceiveManager.createOaTask(target.getOaReceive(), userId);//创建系统任务

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
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
        OaReceive oaReceive = oaReceiveService.get(id);
        Set<OaReceiveNode> oaReceiveNodes = oaReceive.getOaReceiveNodes();
        List<OaReceiveNode> oaReceiveNodeList = new ArrayList<OaReceiveNode>(oaReceiveNodes);
        oaReceiveNodeService.batchDelete(oaReceiveNodeList, oaReceiveNodeList.size());
        oaReceiveService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }
}