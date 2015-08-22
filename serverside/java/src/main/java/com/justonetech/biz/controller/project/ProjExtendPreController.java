package com.justonetech.biz.controller.project;

import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendSchedule;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


/**
 * note:项目前期计划情况
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjExtendPreController extends BaseCRUDActionController<ProjExtendSchedule> {
    private Logger logger = LoggerFactory.getLogger(ProjExtendPreController.class);

    @Autowired
    private ProjExtendService projExtendService;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    /**
     * 修改显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long projectId) {
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);

        if (null == projExtend) {
            projExtend = new ProjExtend();
        }

        model.addAttribute("bean", projExtend);

        return "view/project/projExtendPre/input";
    }

    /**
     * 查看页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long projectId) {
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);

        if (projExtend == null) {
            projExtend = new ProjExtend();
        }
        model.addAttribute("bean", projExtend);

        return "view/project/projExtendPre/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjExtend entity) throws Exception {
        try {
            ProjExtend target;
            if (entity.getId() != null) {
                target = projExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "planXmjys",
                        "planXmjysTime",
                        "planGk",
                        "planGkTime",
                        "planCbsj",
                        "planCbsjTime",
                });
            } else {
                target = entity;
            }
            projExtendService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

}