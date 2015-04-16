package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjectBidSignDeptService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.ProjectBidSign;
import com.justonetech.biz.domain.ProjectBidSignDept;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.io.IOException;
import java.util.*;


/**
 * note:银行保证金征收退还
 * author:huangguorong
 * create date:
 * modify date:2014-7-18
 */
@Controller
public class ProjectBidPayController extends BaseCRUDActionController<ProjectBidSign> {
    private Logger logger = LoggerFactory.getLogger(ProjectBidPayController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectBidSignService projectBidSignService;

    @Autowired
    private ProjectBidSignDeptService projectBidSignDeptService;
    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/project/projectBidPay/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String statusType) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_BID_SIGN_PAY));
        model.addAttribute("statusType", statusType);
        String title = "";
        if (statusType.equals("STATUS_DS")) {
            title = "待收保证金列表";
        } else {
            title = "已确认待退列表";
        }
        model.addAttribute("title", title);
        setProjectBidStatus(model);//状态设置
        return "view/project/projectBidPay/grid";
    }

    /**
     * 各状态权限状态
     *
     * @param model .
     */
    private void setProjectBidStatus(Model model) {
        Map<String, SysCodeDetail> map = status();
        model.addAttribute("STATUS_DJ", map.get("status_DJ").getCode()); //招标登记
        model.addAttribute("STATUS_DS", map.get("status_DS").getCode());//待收保证金
        model.addAttribute("STATUS_DT", map.get("status_DT").getCode());//待退保证金
        model.addAttribute("STATUS_YQR", map.get("status_YQR").getCode());//已确认待退
        model.addAttribute("STATUS_YT", map.get("status_YT").getCode());//已退保证金
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String statusType) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjectBidSign  where 1=1 ";
            Map<String, SysCodeDetail> map = status();

            //增加自定义查询条件
            if (statusType.equals("STATUS_DS")) {
                hql += "and  status=" + map.get("status_DS").getId() + " or status=" + map.get("status_DJ").getId() + " ";
            } else if (statusType.equals("STATUS_DT")) {
                hql += "and  status=" + map.get("status_YQR").getId() + " ";
            }
            hql += "order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectBidSignService.findByPage(pageModel, query);

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    ProjectBidSign projectBidSign = projectBidSignService.get(JspHelper.getLong(id));
                    if (null != projectBidSign.getStatus()) {
                        bean.put("statusName", projectBidSign.getStatus().getName());
                        bean.put("statusCode", projectBidSign.getStatus().getCode());
                    }
//                    开标日期前5天不能再录入保证金缴纳信息
//                    if (checkTime(projectBidSign)) {
//                        bean.put("canInput", true);
//                    } else {
//                        bean.put("canInput", false);
//                    }
                    bean.put("canInput", true);
                }
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
     * 报名单位列表
     *
     * @param model .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String add(Long projectId, String statusType, Model model) throws IOException {
        ProjectBidSign projectBidSign = projectBidSignService.get(projectId);
        model.addAttribute("bean", projectBidSign);
        model.addAttribute("projectId", String.valueOf(projectId));
        model.addAttribute("statusType", statusType);
        setProjectBidStatus(model);//状态设置

        return "view/project/projectBidPay/input";

    }


    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String statusType) {
        ProjectBidSign projectBidSign = projectBidSignService.get(id);
        model.addAttribute("bean", projectBidSign);
        model.addAttribute("statusType", statusType);
        setProjectBidStatus(model);//状态设置

        return "view/project/projectBidPay/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, HttpServletRequest request, String statusType, String status) throws Exception {
        try {
            Map<String, SysCodeDetail> map = status();//判断状态
            String id = request.getParameter("id");
            ProjectBidSign projectBidSign = projectBidSignService.get(Long.valueOf(id));

            String[] deptId = request.getParameterValues("deptId");
            String[] payAccount = new String[0];
            String[] payDate = new String[0];
            String[] returnAccount = new String[0];
            String[] returnDate = new String[0];
            String[] isAfford = new String[0];


            if (statusType.equals(map.get("status_DS").getCode())) {
                payAccount = request.getParameterValues("payAccount");
//                payDate = request.getParameterValues("payDate");
                isAfford = request.getParameterValues("isAfford");
            }
            if (statusType.equals(map.get("status_DJ").getCode())) {
                payAccount = request.getParameterValues("payAccount");
//                payDate = request.getParameterValues("payDate");
                isAfford = request.getParameterValues("isAfford");
            }
            if (statusType.equals(map.get("status_YQR").getCode())) {
                returnAccount = request.getParameterValues("returnAccount");
                returnDate = request.getParameterValues("returnDate");
            }

            if (null != deptId) {
                for (int i = 0; i < deptId.length; i++) {
                    ProjectBidSignDept projectBidSignDept = projectBidSignDeptService.get(Long.valueOf(deptId[i]));
                    projectBidSignDept.setProjectBidSign(projectBidSign);
                    if (statusType.equals(map.get("status_DS").getCode()) || statusType.equals(map.get("status_DJ").getCode())) {
                        if (!StringHelper.isEmpty(payAccount[i])) {
                            projectBidSignDept.setPayAccount(Double.valueOf(payAccount[i]));
                        }
                        if (null != isAfford && !StringHelper.isEmpty(isAfford[i]) && String.valueOf(isAfford[i]).equals("1")) {
                            projectBidSignDept.setIsAfford(1L);
                        } else {
                            projectBidSignDept.setIsAfford(0L);
                        }
//                        if (!StringHelper.isEmpty(payDate[i])) {
//                            projectBidSignDept.setPayDate(java.sql.Date.valueOf(payDate[i]));
//                        } else {
//                            projectBidSignDept.setPayAccount(null);
//                        }
                    }
                    if (statusType.equals(map.get("status_YQR").getCode())) {
                        if (!StringHelper.isEmpty(returnAccount[i])) {
                            projectBidSignDept.setReturnAccount(Double.valueOf(returnAccount[i]));
                        }
                        if (!StringHelper.isEmpty(returnDate[i])) {
                            projectBidSignDept.setReturnDate(java.sql.Date.valueOf(returnDate[i]));
                        } else {
                            projectBidSignDept.setReturnAccount(null);
                        }
                    }
                    projectBidSignDeptService.save(projectBidSignDept);
                }
            }
            if (status.equals(map.get("status_DS").getCode())) {
                if (statusType.equals(map.get("status_DS").getCode())) {
                    projectBidSign.setStatus(map.get("status_DT"));
                }
                if (statusType.equals(map.get("status_DJ").getCode())) {
                    projectBidSign.setStatus(map.get("status_DT"));
                }
            } else if (status.equals(map.get("status_DJ").getCode())) {
                projectBidSign.setStatus(map.get("status_DS"));
            }
            if (status.equals(map.get("status_YT").getCode())) {
                if (statusType.equals(map.get("status_YQR").getCode())) {
                    projectBidSign.setStatus(map.get("status_YT"));
                }
            }
            projectBidSignService.save(projectBidSign);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 判断是否为开标日期前5天
     *
     * @param projectBidSign .
     */
    private boolean checkTime(ProjectBidSign projectBidSign) {
        Date date = projectBidSign.getSignDate();
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(date.getTime());
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, 5);
        return now.before(ca);

    }

    /**
     * 获取各状态详情
     *
     * @return
     */
    private Map<String, SysCodeDetail> status() {
        Map<String, SysCodeDetail> map = new HashMap<String, SysCodeDetail>();
        SysCodeDetail codeDetail_DJ = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DJ);
        SysCodeDetail codeDetail_DS = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DS);
        SysCodeDetail codeDetail_YQR = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_YQR);
        SysCodeDetail codeDetail_DT = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DT);
        SysCodeDetail codeDetail_YT = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_YT);

        map.put("status_DJ", codeDetail_DJ);
        map.put("status_DS", codeDetail_DS);
        map.put("status_YQR", codeDetail_YQR);
        map.put("status_DT", codeDetail_DT);
        map.put("status_YT", codeDetail_YT);
        return map;
    }
}