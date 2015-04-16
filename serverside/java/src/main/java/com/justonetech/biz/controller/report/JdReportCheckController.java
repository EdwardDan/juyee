package com.justonetech.biz.controller.report;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.JdReportService;
import com.justonetech.biz.domain.JdReport;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.JdReportManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 监督报告核查表
 * User: Chen Junping
 * Date: 12-5-23
 */
@Controller
public class JdReportCheckController extends BaseCRUDActionController<JdReport> {
    private Logger logger = LoggerFactory.getLogger(JdReportCheckController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private JdReportManager jdReportManager;

    @Autowired
    private JdReportService jdReportService;

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
        }

        //处理其他业务逻辑
        model.addAttribute("bean", jdReport);
        jdReportManager.setReportContent(model, jdReport);

        return "view/report/jdReportCheck/input";
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
        jdReportManager.setReportContent(model, jdReport);

        return "view/report/jdReportCheck/view";
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
//                        "flowCode",
//                        "bjbh",
                        "buildUnit",
                        "projectName"
//                        "reportDate"
//                        "printReport",
//                        "printDatetime"
                });

            } else {
                target = entity;
            }

            String printContent = jdReportManager.getRequestContent(target, request, true);
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
}
