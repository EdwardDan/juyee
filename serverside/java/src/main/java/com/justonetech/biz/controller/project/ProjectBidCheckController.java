package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjectBidSignDeptService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.ProjectBidSign;
import com.justonetech.biz.domain.ProjectBidSignDept;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description:
 * User: user
 * Date: 14-7-22 下午12:27
 */
@Controller
public class ProjectBidCheckController extends BaseCRUDActionController<ProjectBidSign> {
    private Logger logger = LoggerFactory.getLogger(ProjectBidCheckController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectBidSignService projectBidSignService;

    @Autowired
    private ProjectBidSignDeptService projectBidSignDeptService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        //获取四种状态
        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.PROJECT_BID_SIGN_STATUS);
        model.addAttribute("list", codeListByCode);
        return "view/project/projectBidCheck/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String codeStatus) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_BID_SIGN_CHECK));
        model.addAttribute("codeStatus", codeStatus);
        String title = "";
        if (Constants.PROJECT_BID_SIGN_STATUS_DJ.equals(codeStatus)) {
            title = "招标登记列表";
        } else if (Constants.PROJECT_BID_SIGN_STATUS_DS.equals(codeStatus)) {
            title = "待收保证金列表";
        } else if (Constants.PROJECT_BID_SIGN_STATUS_YT.equals(codeStatus)) {
            title = "已退保证金列表";
        } else {
            title = "已确认待退列表";
        }
        model.addAttribute("title", title);
        return "view/project/projectBidCheck/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String codeStatus) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjectBidSign  where 1=1 ";
            //增加自定义查询条件
            if (Constants.PROJECT_BID_SIGN_STATUS_DJ.equals(codeStatus)) {
                hql += "and  status=" + status().get("status_DJ").getId() + " ";
            } else if (Constants.PROJECT_BID_SIGN_STATUS_DS.equals(codeStatus)) {
                hql += "and  status=" + status().get("status_DS").getId() + " ";
            } else if (Constants.PROJECT_BID_SIGN_STATUS_DT.equals(codeStatus) || Constants.PROJECT_BID_SIGN_STATUS_YQR.equals(codeStatus)) {
                hql += "and (status=" + status().get("status_DT").getId() + " or status=" + status().get("status_YQR").getId() + ") ";
            } else if (Constants.PROJECT_BID_SIGN_STATUS_YT.equals(codeStatus)) {
                hql += "and  status=" + status().get("status_YT").getId() + " ";
            } else {
                hql += "and (status=" + status().get("status_DT").getId() + " or status=" + status().get("status_YQR").getId() + ") ";
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

    /*
    * 确认操作
    * */
    @RequestMapping
    public void confirm(Model model, HttpServletRequest request, HttpServletResponse response, Integer status) {
        try {
            String deptIds[] = request.getParameterValues("deptIds");
            String needBack[] = request.getParameterValues("needBack");
            Long id = Long.valueOf(request.getParameter("id"));
            ProjectBidSign projectBidSign = projectBidSignService.get(id);
            if (Constants.FLAG_TRUE.equals(String.valueOf(status))) {
                projectBidSign.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_YQR));
                projectBidSignService.save(projectBidSign);
                String privilegeCode = PrivilegeCode.PROJECT_BID_PAY_BACK;
                List<SysUser> sysUsers = sysUserManager.getUsersByPrivilegeCode(privilegeCode);
                if (null != sysUsers) {
                    for (SysUser sysUser : sysUsers) {
                        SysPerson sysPerson = sysUser.getPerson();
                        if (null != sysPerson) {
                            String msgTemp = projectBidSign.getProjectName() + "项目已经可以退还投标保证金，请尽快办理退款。";
                            msgMessageManager.sendSms(msgTemp, sysPerson.getMobile());
                        }
                    }
                }
            }
            Set<ProjectBidSignDept> depts = projectBidSign.getProjectBidSignDepts();
            if (null != depts && null != deptIds && deptIds.length > 0) {
                for (ProjectBidSignDept dept : depts) {
                    Integer i = 0;
                    for (String deptid : deptIds) {
                        if (deptid.equals(String.valueOf(dept.getId()))) {
                            Long back = StringHelper.isEmpty(needBack[i]) ? 0 : Long.valueOf(needBack[i]);
                            dept.setNeedBack(back);
                            projectBidSignDeptService.save(dept);
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String checkBack(Model model, Long id, String statusType) {
        ProjectBidSign projectBidSign = projectBidSignService.get(id);
        model.addAttribute("bean", projectBidSign);
        model.addAttribute("statusType", statusType);
        setProjectBidStatus(model);//状态设置

        return "view/project/projectBidCheck/input";
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
     * 获取各状态详情
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
