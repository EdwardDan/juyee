package com.justonetech.biz.manager;

import com.justonetech.biz.domain.OrderFormDeployUser;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.OrderFormDeployService;
import com.justonetech.biz.domain.OrderForm;
import com.justonetech.biz.domain.OrderFormDeploy;
import com.justonetech.biz.domain.PollingWorkGroup;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 主要用于监督预约
 * User: Chen Junping
 * Date: 12-4-24
 */
@Service
public class OrderFormManager {

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private PollingRecordManager pollingRecordManager;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    @Autowired
    private RegPersonManager regPersonManager;

    /**
     * 获取受理记录
     *
     * @param orderFormId .
     * @return .
     */
    public OrderFormDeploy getOrderFormDeploy(Long orderFormId) {
        List<OrderFormDeploy> list = orderFormDeployService.findByQuery("from OrderFormDeploy where orderForm.id=" + orderFormId);
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 获取预约编号
     * 编号规则（年份+4位自动编号）
     *
     * @return 编号
     */
    public String getOrderCode() {
        int codeLen = 4;
        Calendar c = Calendar.getInstance();
        String prefix = c.get(Calendar.YEAR) + "";
        String sql = "select substr(t.order_code,{0},{1}) as code" +
                " from order_form t where t.order_code is not null" +
                " and t.order_code like '{2}-%'" +
                " order by order_code desc";
        int maxCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(sql, String.valueOf(prefix.length() + 2), String.valueOf(codeLen), prefix));
        return prefix + "-" + StringHelper.getPadCode(codeLen, maxCount + 1);
    }

    /**
     * 按钮权限控制
     *
     * @param model .
     * @param data  .
     */
    public void setStatusAttribute(Model model, OrderForm data) {
        String statusCode = Constants.ORDER_FORM_STATUS_EDIT;
        if (data.getOrderStatus() != null) {
            statusCode = data.getOrderStatus().getCode();
        }

        Boolean isPermitEdit = sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_EDIT);
        Boolean isPermitAudit = sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_AUDIT);
        Boolean isPermitRedo = sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_REDO);
        Boolean isEdit = false;
        Boolean isAudit = false;

        //网站用户允许编辑
        SysUser user = sysUserManager.getSysUser();
        if (user.getRegPerson() != null) {
            isPermitEdit = true;
        }

        if (isPermitEdit && Constants.ORDER_FORM_STATUS_EDIT.equals(statusCode) || Constants.ORDER_FORM_STATUS_BACK.equals(statusCode)) {
            isEdit = true;
        }
        if (isPermitAudit && Constants.ORDER_FORM_STATUS_NOTACCEPT.equals(statusCode)) {
            isAudit = true;
        }
        if (isPermitRedo && Constants.ORDER_FORM_STATUS_ACCEPT.equals(statusCode)) {
            isAudit = true;
        }
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("isAudit", isAudit);

        //状态
        model.addAttribute("ORDER_FORM_STATUS_EDIT", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_EDIT).getId());
        model.addAttribute("ORDER_FORM_STATUS_NOTACCEPT", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_NOTACCEPT).getId());
        model.addAttribute("ORDER_FORM_STATUS_BACK", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_BACK).getId());
        model.addAttribute("ORDER_FORM_STATUS_ACCEPT", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_ACCEPT).getId());

        //审核意见代码
        model.addAttribute("ORDER_FORM_DEPLOY_OPINION", Constants.ORDER_FORM_DEPLOY_OPINION);
        model.addAttribute("ORDER_FORM_DEPLOY_OPINION_ARRANGE", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE).getId());
        model.addAttribute("ORDER_FORM_DEPLOY_OPINION_NOTARRANGE", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_NOTARRANGE).getId());
        model.addAttribute("ORDER_FORM_DEPLOY_OPINION_BACK", sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_BACK).getId());
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createTask(OrderFormDeploy data) throws Exception {
        //任务标题
        OrderForm orderForm = data.getOrderForm();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(orderForm.getOrderDatetime());
//        String taskTitle = "您好！流转编号" + orderForm.getFlowCode() + "，" + orderForm.getBuildUnitName() + "、" + orderForm.getProjectName()
        String taskTitle = "您好！监督任务书编号" + orderForm.getJdTaskCode() + "，" + orderForm.getBuildUnitName() + "、" + orderForm.getProjectName()
                + "、" + orderForm.getSgPosition() + "，已安排“" + time + "”监督，请及时填报监督记录。";
        //任务接收人
        Set<OrderFormDeployUser> users = data.getOrderFormDeployUser();
        if (users != null) {
            Set<Long> managers = pollingRecordManager.getManagerIds(users);
            if (managers.size() > 0) {
                //创建任务
                oaTaskManager.createTask(OrderFormDeploy.class.getSimpleName(), data.getId(), taskTitle, managers);   //默认会同时发送短信通知
            }
        }
    }

    /**
     * 获取当前用户的监督预约记录过滤HQL
     *
     * @return .
     */
    public String getOrderFormFilterHql() {
        String conditionSql = "";
        //外网项目用户和工地用户只能查看本项目范围的记录
        SysRegPerson regPerson = regPersonManager.getRegPerson();
        String bjbh = regPersonManager.getBjbh(regPerson);
        if (regPerson != null) {
            String loginName = sysUserManager.getSysUser().getLoginName();
            String tmpSql = " and ((orderForm.jdTaskCode is not null and orderForm.jdTaskCode in({0})) or orderForm.createUser='{1}')";
            String childSql = "select distinct f.jdTaskCode from ExcelJdTasks f,ShareProDwgcMonitor dwgc" +
                    " where dwgc.{0}UnitCode='{1}' and dwgc.jdrwsbh=f.jdTaskCode ";
            if (!StringHelper.isEmpty(bjbh))
                childSql += " and f.bjbh='" + regPersonManager.getBjbh(regPerson) + "' ";
            String typeCode = regPerson.getRegType().getCode();
            if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(typeCode) || Constants.SYS_REGPERSON_TYPE_UNIT_JL.equals(typeCode)) {
                childSql = FormatUtils.format(childSql, typeCode, regPerson.getUnitCode());
                String codes = "";
                Object[] list = simpleQueryManager.getObjectArrayByHql(childSql);
                if (list.length > 0) {
                    for (Object o : list) {
                        codes += ",'" + o.toString() + "'";
                    }
                    codes = codes.substring(1);
                } else {
                    codes = "'0'";
                }
                conditionSql = FormatUtils.format(tmpSql, codes, loginName);

            } else if (Constants.SYS_REGPERSON_TYPE_UNIT_JS.equals(typeCode)) {
                childSql = "select jdTaskCode from ExcelJdTasks where bjbh='" + regPersonManager.getBjbh(regPerson) + "')";
                conditionSql = FormatUtils.format(tmpSql, childSql, loginName);

            } else {
                conditionSql += " and 1=2";      //todo 工地编号目前不允许按报建编号查看
            }
        }
        if (sysUserManager.getSysUser() == null) {
            conditionSql += " and 1=2"; //未登录用户不允许查看任何记录
        }
        return conditionSql;
    }

    /**
     * 获取当前用户的监督预约记录过滤SQL
     *
     * @return .
     */
    public String getOrderFormFilterSql() {
        String conditionSql = "";
        //外网项目用户和工地用户只能查看本项目范围的记录
        SysRegPerson regPerson = regPersonManager.getRegPerson();
        String bjbh = regPersonManager.getBjbh(regPerson);
        if (regPerson != null) {
            String typeCode = regPerson.getRegType().getCode();
            String unitName = regPerson.getUnitName();
            if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(typeCode)) {
//                conditionSql = " and t.bjbh in ( select a.bjbh from share_pro_sg_permit a,share_unit_info b " +
//                        "  where b.org_code='" + regPerson.getUnitIdentifyCode() + "' and To_single_byte(trim(a.sg_zb_unit))=To_single_byte(trim(b.unit_name)))";
                conditionSql = " and t.sgzb_unit_name like '{0}%'";
                if (!StringHelper.isEmpty(bjbh))
                    conditionSql += " and t.bjbh='" + bjbh + "' ";
                conditionSql = FormatUtils.format(conditionSql, StringHelper.isEmpty(unitName) ? "0" : JspHelper.getString(unitName).trim());

            } else if (Constants.SYS_REGPERSON_TYPE_UNIT_JL.equals(typeCode)) {
//                conditionSql = " and t.bjbh in (select a.bjbh from share_pro_sg_permit a,share_unit_info b " +
//                        "  where b.org_code='" + regPerson.getUnitIdentifyCode() + "' and To_single_byte(trim(a.jl_unit))=To_single_byte(trim(b.unit_name)))";
                conditionSql = " and t.jl_unit_name like '{0}%'";
                if (!StringHelper.isEmpty(bjbh))
                    conditionSql += " and t.bjbh='" + bjbh + "' ";
                conditionSql = FormatUtils.format(conditionSql, StringHelper.isEmpty(unitName) ? "0" : JspHelper.getString(unitName).trim());
            } else if (Constants.SYS_REGPERSON_TYPE_UNIT_JS.equals(typeCode)) {
                conditionSql = " and t.bjbh='" + regPersonManager.getBjbh(regPerson) + "'";
            } else {
                conditionSql += " and 1=2";      //todo 工地编号目前不允许按报建编号查看
            }
        }
        if (sysUserManager.getSysUser() == null) {
            conditionSql += " and 1=2"; //未登录用户不允许查看任何记录
        }
        return conditionSql;
    }
}
