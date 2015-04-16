package com.justonetech.biz.controller.order;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OrderFormDeployService;
import com.justonetech.biz.daoservice.ShareProTobuildService;
import com.justonetech.biz.domain.OrderForm;
import com.justonetech.biz.domain.OrderFormDeploy;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OrderFormManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.SysParameterManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysParameter;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * note:监督预约 -- 仅提供给外网用户使用
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OrderFormSiteController extends BaseCRUDActionController<OrderForm> {
    private Logger logger = LoggerFactory.getLogger(OrderFormSiteController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    @Autowired
    private OrderFormManager orderFormManager;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private SysParameterManager sysParameterManager;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 主页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {

        return "view/order/orderFormSite/init";
    }

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
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_AUDIT));
        model.addAttribute("canRedo", sysUserManager.hasPrivilege(PrivilegeCode.ORDER_FORM_REDO));
        model.addAttribute("currentUserName", user.getLoginName());
        //预约状态
        model.addAttribute("ORDER_FORM_STATUS_EDIT", Constants.ORDER_FORM_STATUS_EDIT);
        model.addAttribute("ORDER_FORM_STATUS_ACCEPT", Constants.ORDER_FORM_STATUS_ACCEPT);
        model.addAttribute("ORDER_FORM_STATUS_NOTACCEPT", Constants.ORDER_FORM_STATUS_NOTACCEPT);
        model.addAttribute("ORDER_FORM_STATUS_BACK", Constants.ORDER_FORM_STATUS_BACK);

        return "view/order/orderFormSite/grid";
    }

    @RequestMapping
    public String grid2(Model model) {
        model.addAttribute("ORDER_FORM_STATUS_ACCEPT", Constants.ORDER_FORM_STATUS_ACCEPT);
        return "view/order/orderFormSite/grid2";
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
     * @param request  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {

            String sql = "select distinct t.id,t.bjbh,t.jd_task_code,t.project_name,t.project_add as build_address," +
                    "t.property,t.jagzl as total_Investment,t.build_area as total_Area,t.jd_datetime" +
                    ",'' as gdCount,'' as gdCode" +
                    ",t.js_unit_name" +
                    " from excel_jd_tasks t" +
                    " left join share_gd_info g on t.bjbh=g.bjbh" +
                    " left join share_pro_jl_info j on t.bjbh=j.bjbh" +
//                " where trim(t.belong_area)='{0}'";
                    " where 1=1";   //excel_jd_tasks.belong_area存储是松江下面的街镇名称，不需要再过滤
            sql += " and t.bjbh in (select bjbh from Share_Gd_Info where gd_Status_Code in (" + projectManager.GD_STATUS_CODE_MONITORING + "))";
            sql += orderFormManager.getOrderFormFilterSql();

            String sgdw = request.getParameter("sgdw");
            String jldw = request.getParameter("jldw");
            if (!StringHelper.isEmpty(sgdw)) {
                sql += " and g.sg_total_unit_name like '%" + sgdw + "%'";
            }
            if (!StringHelper.isEmpty(jldw)) {
                sql += " and j.dwmc like '%" + jldw + "%'";
            }
            sql += " order by t.jd_task_code desc";
//            sql = FormatUtils.format(sql, configManager.getProjectArea());
//            System.out.println("sql/////////////////////////////////// = " + sql);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslate.toString();
//            logger.debug("querySql = " + querySql);

            Page pageModel = new Page(page, rows, true);
            pageModel = shareProTobuildService.findBySql(pageModel, querySql, null);

            //供excel导出
            session.setAttribute(Constants.GRID_SQL_KEY, querySql);
            List list = pageModel.getRows();

            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
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
    public void gridDataCustom2(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "";

            hql = "from OrderFormDeploy where 1=1";

            hql += orderFormManager.getOrderFormFilterHql();

            hql += " order by orderForm.orderCode desc";
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
//                Object obId = bean.get("id");
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String jdTaskCode) {
        OrderForm orderForm = new OrderForm();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        orderForm.setInputTime(timestamp);

        //权限控制
        orderFormManager.setStatusAttribute(model, orderForm);

        //监督预约备注信息
        SysParameter sysParameter = sysParameterManager.getSysParameter(Constants.ORDER_FORM_MEMO);
        model.addAttribute("orderFormMemo", sysParameter);

        //如需增加其他默认值请在此添加
        orderForm.setOrderStatus(sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_EDIT));
        orderForm.setJdTaskCode(jdTaskCode);
        model.addAttribute("bean", orderForm);
        model.addAttribute("startTime", timestamp);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OrderForm.class.getSimpleName(), orderForm.getFormDoc(), null, null));

        return "view/order/orderFormSite/input";
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
        model.addAttribute("startTime", orderForm.getCreateTime());
        model.addAttribute("isAccept", orderForm.getOrderStatus().getCode().equals(Constants.ORDER_FORM_STATUS_ACCEPT));

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OrderForm.class.getSimpleName(), orderForm.getFormDoc(), null, null));

        return "view/order/orderFormSite/input";
    }
}