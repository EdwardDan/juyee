package com.justonetech.biz.controller.order;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.manager.projectInfo.CustomProjectInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysParameter;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import flexjson.JSONDeserializer;
import net.sf.json.JSONArray;
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
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * note:监督预约 -- 本类仅提供给内网用户使用，外网用户有专门类OrderFormSiteController
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OrderFormController extends BaseCRUDActionController<OrderForm> {
    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);
    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OrderFormDeployUserService orderFormDeployUserService;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    @Autowired
    private OrderFormManager orderFormManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private PollingRecordManager pollingRecordManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysParameterManager sysParameterManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑和审核权限
        SysUser user = sysUserManager.getSysUser();
        Boolean canEdit = sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_EDIT);
        if (user.getRegPerson() != null) {
            canEdit = true;
        }
        model.addAttribute("canEdit", canEdit);
        //修改受理备注权限
        model.addAttribute("canMemoEdit", sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_MEMO_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_AUDIT));
        model.addAttribute("canRedo", sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_REDO));
        model.addAttribute("currentUserName", user.getLoginName());

        //预约状态
        model.addAttribute("ORDER_FORM_STATUS_EDIT", Constants.ORDER_FORM_STATUS_EDIT);
        model.addAttribute("ORDER_FORM_STATUS_ACCEPT", Constants.ORDER_FORM_STATUS_ACCEPT);
        model.addAttribute("ORDER_FORM_STATUS_NOTACCEPT", Constants.ORDER_FORM_STATUS_NOTACCEPT);
        model.addAttribute("ORDER_FORM_STATUS_BACK", Constants.ORDER_FORM_STATUS_BACK);

        return "view/order/orderForm/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OrderFormDeploy where 1=1";

            hql += " order by orderForm.orderDatetime desc";
//            System.out.println("..............hql = " + hql);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = orderFormDeployService.findByPage(pageModel, queryTranslate.toString());
            session.setAttribute(Constants.GRID_SQL_KEY, queryTranslate.toString());
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object docId = bean.get("orderForm.formDoc.id");
                if (docId != null && org.hibernate.util.StringHelper.isNotEmpty((String) docId)) {
                    bean.put("orderForm.formDoc.id", documentManager.getDownloadButton(JspHelper.getLong(docId)));
                }
                Object obId = bean.get("id");
                OrderFormDeploy orderFormDeploy = orderFormDeployService.get(JspHelper.getLong(bean.get("id")));
                SysCodeDetail sysCodeDetail = orderFormDeploy.getAcceptOpinion();
                if (sysCodeDetail != null) {
                    if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE))
                        bean.put("acceptOpinion", "安排监督");
                    else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_NOTARRANGE))
                        bean.put("acceptOpinion", "不安排监督");
                    else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_BACK))
                        bean.put("acceptOpinion", "退回");
                    else
                        bean.put("acceptOpinion", null);
                } else
                    bean.put("acceptOpinion", null);
                List<OrderFormDeployUser> users = orderFormDeployUserService.findByQuery("from OrderFormDeployUser where orderFormDeploy.id=?", Long.valueOf(String.valueOf(obId)));
                String jdManager = "";
                String jdManagerName = "";
                if (null != users) {
                    for (OrderFormDeployUser user : users) {
                        jdManager += "," + user.getUser().getId();
                        jdManagerName += "," + user.getUser().getDisplayName();
                    }
                }
                bean.put("jdManager", jdManager.length() > 1 ? jdManager.substring(1) : "");
                bean.put("jdManagerName", jdManagerName.length() > 0 ? jdManagerName.substring(1) : "");
//
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 获取工程信息和最近一次预约单中的信息。
     *
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getProjectInfoAndLastOrderForm(String jdTaskCode, Model model) {
        CustomProjectInfo allProjectInfo = projectManager.getProjectInfoByJdTaskCode(jdTaskCode);

        JSONArray jsonArray = JSONArray.fromObject(allProjectInfo);
        String json = jsonArray.toString();
        if (StringHelper.isEmpty(allProjectInfo.getBjbh())) {
            model.addAttribute("msg", "");
        } else {
            model.addAttribute("msg", json);
        }

        return "common/msg";
    }


    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OrderForm orderForm = new OrderForm();
        orderForm.setInputTime(new Timestamp(System.currentTimeMillis()));
        //权限控制
        orderFormManager.setStatusAttribute(model, orderForm);

        //如需增加其他默认值请在此添加
        orderForm.setOrderStatus(sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_EDIT));

        //监督预约备注信息
        SysParameter sysParameter = sysParameterManager.getSysParameter(Constants.ORDER_FORM_MEMO);
        model.addAttribute("orderFormMemo", sysParameter);

        model.addAttribute("bean", orderForm);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OrderForm.class.getSimpleName(), orderForm.getFormDoc(), null, null));

        return "view/order/orderForm/input";
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
        OrderFormDeploy orderFormDeploy = orderFormDeployService.get(id);
        OrderForm orderForm = orderFormDeploy.getOrderForm();

        //权限控制
        orderFormManager.setStatusAttribute(model, orderForm);

        //监督预约备注信息
        SysParameter sysParameter = sysParameterManager.getSysParameter(Constants.ORDER_FORM_MEMO);
        model.addAttribute("orderFormMemo", sysParameter);

        //处理其他业务逻辑
        model.addAttribute("bean", orderForm);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OrderForm.class.getSimpleName(), orderForm.getFormDoc(), null, null));

        return "view/order/orderForm/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyPlus(Model model, Long id) {
        OrderFormDeploy orderFormDeploy = orderFormDeployService.get(id);
        OrderForm orderForm = orderFormDeploy.getOrderForm();

        //权限控制
        orderFormManager.setStatusAttribute(model, orderForm);

        //监督预约备注信息
        SysParameter sysParameter = sysParameterManager.getSysParameter(Constants.ORDER_FORM_MEMO);
        model.addAttribute("orderFormMemo", sysParameter);

        //处理其他业务逻辑
        model.addAttribute("bean", orderForm);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OrderForm.class.getSimpleName(), orderForm.getFormDoc(), null, null));

        return "view/order/orderForm/inputPlus";
    }

    /**
     * 获取单位工程列表
     *
     * @param model      .
     * @param jdTaskCode .
     * @param isEdit     .
     * @return .
     */
    @RequestMapping
    public String excelJdDwgcView(Model model, String jdTaskCode, Boolean isEdit) {
         /*显示单位工程信息*/
        List<ExcelJdDwgc> excelJdDwgcList = excelJdDwgcService.findByProperty("jdTaskCode", jdTaskCode);
        model.addAttribute("proSchedule", Constants.EXCEL_JDTASK_SCHEDULE);
        model.addAttribute("excelJdDwgcList", excelJdDwgcList);
        model.addAttribute("isEdit", isEdit);
        return "view/order/orderForm/excelJdDwgcView";
    }


    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String justView) {
        OrderFormDeploy orderFormDeploy = orderFormDeployService.get(id);
        OrderForm orderForm = orderFormDeploy.getOrderForm();

        model.addAttribute("bean", orderFormDeploy);
        String jdTaskCode = orderFormDeploy.getOrderForm().getJdTaskCode();
        String sql = "FROM ExcelJdTasks where jdTaskCode='" + jdTaskCode + "'";
        List<ExcelJdTasks> list = excelJdTasksService.findByQuery(sql);
        String bjbh = null != list ? list.iterator().next().getBjbh() : "";
        model.addAttribute("bjbh", bjbh);
        //外网注册用户不允许查看项目详细信息
        model.addAttribute("isRegPerson", sysUserManager.getSysUser().getRegPerson() != null);
        if (justView != null && !"".equals(justView)) {
            model.addAttribute("isRegPerson", true);
        }
        model.addAttribute("docButton", documentManager.getDownloadButton(orderForm.getFormDoc()));

        List<OrderFormDeployUser> users = orderFormDeployUserService.findByQuery("from OrderFormDeployUser where orderFormDeploy.id=?", id);
        String jdManager = "";
        String jdManagerName = "";
        if (null != users) {
            for (OrderFormDeployUser user : users) {
                jdManager += "," + user.getUser().getId();
                jdManagerName += "," + user.getUser().getDisplayName();
            }
        }
        model.addAttribute("jdManager", jdManager.length() > 1 ? jdManager.substring(1) : "");
        model.addAttribute("jdManagerName", jdManagerName.length() > 0 ? jdManagerName.substring(1) : "");

        return "view/order/orderForm/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param docId    .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OrderForm entity, Long docId, HttpServletRequest request) throws Exception {
        String orderCode = "";
        Boolean isNew = entity.getId() == null;
        //内网可以修改单位工程列表，外网不能
        String dwgcItems = request.getParameter("dwgcItems");
        if (!StringHelper.isEmpty(dwgcItems)) {
            List<Map> maps = new JSONDeserializer<List<Map>>().use("values", HashMap.class).deserialize(dwgcItems);
            for (Map map : maps) {
                ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(Long.parseLong((String) map.get("id")));
                excelJdDwgc.setProSchedule((String) map.get("proSchedule"));
                excelJdDwgcService.save(excelJdDwgc);
            }
        }

        try {
            OrderForm target;
            if (!isNew) {
                target = orderFormService.get(entity.getId());
                orderCode = target.getOrderCode();
                ReflectionUtils.copyBean(entity, target, new String[]{
//                        "orderCode",
//                        "flowCode",
                        "buildUnitName",
                        "sgUnitName",
                        "projectName",
                        "buildAddress",
                        "buildArea",
                        "structure",
                        "sgPosition",
                        "buildLegalPerson",
//                        "buildLegalPhone",
                        "projectManager",
//                        "planSgDatatime",
                        "orderDatetime",
                        "inputTime",
                        "linkMan",
                        "linkManPhone",
                        "orderStatus"
                });

            } else {
                target = entity;

                //默认编号自动生成（年份+序号）
                orderCode = orderFormManager.getOrderCode();
                target.setOrderCode(orderCode);

            }
            if (docId != null) {
                target.setFormDoc(documentManager.getDocDocument(docId));
                documentManager.updateDocumentByBizData(documentManager.getDocDocument(docId), orderCode, target.getProjectName());
            }
            orderFormService.save(target);

            //退回再提交时必须重置受理时间为空
            OrderFormDeploy deploy = orderFormManager.getOrderFormDeploy(target.getId());
            if (deploy == null) {
                deploy = new OrderFormDeploy();
            }
            deploy.setOrderForm(target);
            deploy.setAcceptDatetime(null);
            orderFormDeployService.save(deploy);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        String msg = "保存成功";
        if (sysUserManager.getSysUser().getRegPerson() != null) {
            if (Constants.ORDER_FORM_STATUS_NOTACCEPT.equals(entity.getOrderStatus() != null ? entity.getOrderStatus().getCode() : "")) {
                msg = "提交成功，您的预约单号为【" + orderCode + "】！";
            } else {
                msg = "保存成功，请到[历史预约单]中继续修改或提交！";
            }
        }
        if (isNew) {

            sendSuccessJSON(response, msg);
        } else {
            sendSuccessJSON(response, msg);
        }
    }


    /**
     * 审核显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OrderFormDeploy data = orderFormDeployService.get(id);


        //权限控制
        orderFormManager.setStatusAttribute(model, data.getOrderForm());

        //处理其他业务逻辑
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            data.setAcceptUser(sysUserManager.getSysUser(loginUser.getLoginName()));
            data.setAcceptUserName(loginUser.getRealName());
        }
        data.setAcceptDatetime(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("bean", data);
        List<OrderFormDeployUser> list = orderFormDeployUserService.findByQuery("from OrderFormDeployUser where orderFormDeploy.id=?", id);
        String jdManager = "";
        String jdManagerName = "";
        if (null != list) {
            for (OrderFormDeployUser user : list) {
                jdManager += "," + user.getUser().getId();
                jdManagerName += "," + user.getUser().getDisplayName();
            }
        }
        model.addAttribute("jdManager", jdManager.length() > 1 ? jdManager.substring(1) : "");
        model.addAttribute("jdManagerName", jdManagerName.length() > 0 ? jdManagerName.substring(1) : "");

        return "view/order/orderForm/audit";
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
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OrderFormDeploy entity, HttpServletRequest request) throws Exception {
        try {
            OrderFormDeploy target;
            if (entity.getId() != null) {
                target = orderFormDeployService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "acceptUser",
                        "acceptUserName",
                        "acceptDatetime",
                        "acceptOpinion",
                        "acceptOpinionDesc"
                });

            } else {
                target = entity;

            }
            orderFormDeployService.save(target);
            // 先删除
            Set<OrderFormDeployUser> set = target.getOrderFormDeployUser();
            if (null != set) {
                for (OrderFormDeployUser orderFormDeployUser : set) {
                    orderFormDeployUserService.delete(orderFormDeployUser);
                }
            }
            // 添加负责人
            String jdManager = request.getParameter("jdManager");
            if (!org.hibernate.util.StringHelper.isEmpty(jdManager)) {
                List<OrderFormDeployUser> users = new ArrayList<OrderFormDeployUser>();
                String[] jdManagerIds = jdManager.split(",");
                for (String jdManagerid : jdManagerIds) {
                    OrderFormDeployUser orderFormDeployUser = new OrderFormDeployUser();
                    orderFormDeployUser.setUser(sysUserService.get(Long.parseLong(jdManagerid)));
                    orderFormDeployUser.setOrderFormDeploy(target);
                    users.add(orderFormDeployUser);
                }
                orderFormDeployUserService.batchSave(users, users.size());
            }

            //保存流转编号和状态
            String jdTaskCode = request.getParameter("jdTaskCode");
            OrderForm orderForm = target.getOrderForm();
            orderForm.setJdTaskCode(jdTaskCode);
            String msgStr = null;

            //如果退回则设置预约单状态为退回，如果安排监督和不安排监督则设置预约单状态为已受理
            String acceptCode = target.getAcceptOpinion().getCode();
            if (Constants.ORDER_FORM_DEPLOY_OPINION_BACK.equals(acceptCode)) {
                orderForm.setOrderStatus(sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_BACK));

                // modify by shaxiaojie 2014/2/12
                // 修改：退回（不安排监督）时有短信发送，提供短信输入框，内容固定。
                String msg = request.getParameter("duanxin");
                msgStr = "您好！监督任务书编号" + orderForm.getJdTaskCode() + "，" + orderForm.getBuildUnitName() + "、" + orderForm.getProjectName()
                        + "、" + orderForm.getSgPosition() + "，已退回。内容：" + msg + "，联系电话－021-57780775。";

            } else if (Constants.ORDER_FORM_DEPLOY_OPINION_NOTARRANGE.equals(acceptCode)) {
                orderForm.setOrderStatus(sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_ACCEPT));
                msgStr = "您好！监督任务书编号" + orderForm.getJdTaskCode() + "，" + orderForm.getBuildUnitName() + "、" + orderForm.getProjectName()
                        + "、" + orderForm.getSgPosition() + "，我站不安排监督，请监理（建设）单位组织验收形成会议纪要。联系电话－021-57780775";
//                您好！流转编号20110398，建设单位名称、项目名称、隐蔽工程部位,我站不安排监督，请监理（建设）单位组织验收形成会议纪要。联系电话－021-57780775
            } else if (Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE.equals(acceptCode)) {
                orderForm.setOrderStatus(sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_ACCEPT));

                //创建任务
                orderFormManager.createTask(target);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String time = simpleDateFormat.format(orderForm.getOrderDatetime());
                msgStr = "您好！监督任务书编号" + orderForm.getJdTaskCode() + "，" + orderForm.getBuildUnitName() + "、" + orderForm.getProjectName()
                        + "、" + orderForm.getSgPosition() + "，已安排“" + time + "”监督，稍后将联系您！联系电话－021-57780775";
            }
            orderFormService.save(orderForm);

            //发送短信
            if (msgStr != null) {
                msgMessageManager.sendSms(msgStr, orderForm.getLinkManPhone());
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "操作成功");
    }

    /**
     * 修改备注页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String memoEdit(Model model, Long id) {
        OrderFormDeploy data = orderFormDeployService.get(id);

        model.addAttribute("bean", data);

        return "view/order/orderForm/memoEdit";
    }

    /**
     * 受理备注保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void memoEditSave(HttpServletResponse response, @ModelAttribute("bean") OrderFormDeploy entity, HttpServletRequest request) throws Exception {
        try {
            OrderFormDeploy target;
            if (entity.getId() != null) {
                target = orderFormDeployService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "acceptOpinionDesc"
                });

            } else {
                target = entity;

            }
            orderFormDeployService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "操作成功");
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
        OrderFormDeploy data = orderFormDeployService.get(id);
        OrderForm orderForm = data.getOrderForm();
        Long docId = orderForm.getFormDoc() != null ? orderForm.getFormDoc().getId() : null;

        orderFormDeployService.delete(id);

        orderFormService.delete(orderForm.getId());

        //删除文档
        documentManager.removeAllDoc(docId, null);

        //删除任务
        oaTaskManager.removeTask(OrderFormDeploy.class.getSimpleName(), id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 任务执行
     *
     * @param response .
     * @param model    .
     * @param id       .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public void task(HttpServletResponse response, HttpServletRequest request, Model model, Long id) throws IOException {
        String url = "../pollingRecord/init.do?formClass={0}&action=add&taskParam=<typeCode>{1}</typeCode><typeId>{2}</typeId><referId>{3}</referId>";
        Boolean isSuccess = false;

        //默认安全
        SysCodeDetail formClassData = pollingRecordManager.getFormClassData(Constants.PLAN_MAIN_INFO_TYPE_SAFE);
        if (formClassData != null) {
            isSuccess = true;
            SysCodeDetail detailByCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_TYPE, Constants.PLAN_MAIN_INFO_TYPE_ORDER);
            response.sendRedirect(FormatUtils.format(url, String.valueOf(formClassData.getId()), detailByCode.getCode(), String.valueOf(detailByCode.getId()), String.valueOf(id)));
        }
        if (!isSuccess) {
//            sendErrorJSON(response,"未找到有效表单，可能表单已删除");
            response.sendRedirect(Constants.OA_TASK_NULL_PAGE + id);
        }
    }

}