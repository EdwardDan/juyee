package com.justonetech.biz.controller.report;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.JdPersonSubjectService;
import com.justonetech.biz.daoservice.JdReportDwgcService;
import com.justonetech.biz.daoservice.JdReportService;
import com.justonetech.biz.domain.JdPersonSubject;
import com.justonetech.biz.domain.JdReport;
import com.justonetech.biz.domain.JdReportDwgc;
import com.justonetech.biz.domain.bean.jdReport.JdReportContent;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
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
import java.sql.Date;
import java.util.List;
import java.util.Set;


/**
 * note:监督报告
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class JdReportController extends BaseCRUDActionController<JdReport> {
    private Logger logger = LoggerFactory.getLogger(JdReportController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private JdReportManager jdReportManager;

    @Autowired
    private JdReportDwgcService jdReportDwgcService;

    @Autowired
    private JdReportService jdReportService;

    @Autowired
    private JdPersonSubjectService jdPersonSubjectService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_REPORT_EDIT));

        return "view/report/jdReport/grid";
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
            String hql = "from JdReport order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = jdReportService.findByPage(pageModel, query);
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
     * tab显示页面
     *
     * @param model .
     * @param id    .
     * @param act   .
     * @return .
     */
    @RequestMapping
    public String frame(Model model, String id, String act) {
        model.addAttribute("id", JspHelper.getString(id));
        model.addAttribute("act", JspHelper.getString(act));

        return "view/report/jdReport/frame";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, String id) {
        JdReport jdReport = new JdReport();
        if (!StringHelper.isEmpty(id)) {
            jdReport = jdReportService.get(Long.valueOf(id));
        } else {
            jdReport.setReportDate(new Date(System.currentTimeMillis()));
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            jdReport.setReportPerson(sysUserManager.getSysUser(loginUser.getLoginName()).getDisplayName());
        }

        //处理其他业务逻辑
        model.addAttribute("bean", jdReport);
        jdReportManager.setReportContent(model, jdReport);

        //质量监督单位
        model.addAttribute("zljddw", configManager.getJdDeptName());

        //质量监督人员
        List<JdPersonSubject> personList = jdPersonSubjectService.findByQuery("from JdPersonSubject order by person.name asc");
//        System.out.println("personList.size() = " + personList.size());
        model.addAttribute("personList", personList);

        return "view/report/jdReport/input";
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
        JdReport jdReport = jdReportService.get(id);
        model.addAttribute("bean", jdReport);

        JdReportContent content = jdReportManager.getReportContent(id, true, false);
        model.addAttribute("content", content);

        return "view/report/jdReport/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdReport entity, HttpServletRequest request) throws Exception {
        try {
            JdReport target;
            if (entity.getId() != null) {
                target = jdReportService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "jdTaskCode",
                        "bjbh",
                        "buildUnit",
                        "projectName",
                        "reportDate",
                        "reportPerson"
//                        "printReport",
//                        "printDatetime"
                });

            } else {
                target = entity;
            }

            //报告类型
            SysCodeDetail category = sysCodeManager.getCodeDetailByName(Constants.JD_REPORT_TYPE, request.getParameter("category"));
            target.setReportType(category);
            target.setReportTypeDesc(category.getName());

            //主要填报内容
            String printContent = jdReportManager.getRequestContent(target, request, false);
//            System.out.println("printContent = " + printContent);
            target.setPrintReport(printContent);

            jdReportService.save(target);


        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 获取最后保存的记录
     *
     * @param jdTaskCode .
     * @param model    .
     * @return .
     */
    @RequestMapping
    public String getReportId(String jdTaskCode, Model model) {
        List<JdReport> list = jdReportService.findByQuery("from JdReport where jdTaskCode='" + jdTaskCode + "' order by id desc");
        if (list.size() > 0) {
            JdReport report = list.iterator().next();
            model.addAttribute("msg", "<id>" + report.getId() + "</id>");
        } else {
            model.addAttribute("msg", "<id></id>");
        }

        return "common/msg";
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
        JdReport jdReport = jdReportService.get(id);

        Set<JdReportDwgc> dwgcs = jdReport.getJdReportDwgcs();
        for (JdReportDwgc dwgc : dwgcs) {
            jdReportDwgcService.delete(dwgc);
        }

        jdReportService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }
}