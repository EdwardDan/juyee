package com.justonetech.biz.controller.worker;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.WorkerTalkFormService;
import com.justonetech.biz.domain.WorkerTalkForm;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
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
import java.sql.Date;
import java.sql.Timestamp;


/**
 * note:执法管理谈话通知书
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class WorkerTalkFormController extends BaseCRUDActionController<WorkerTalkForm> {
    private Logger logger = LoggerFactory.getLogger(WorkerTalkFormController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private WorkerTalkFormService workerTalkFormService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.WORKER_TALK_FORM_EDIT));

        return "view/worker/workerTalkForm/grid";
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
            String hql = "from WorkerTalkForm order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = workerTalkFormService.findByPage(pageModel, query);

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
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        WorkerTalkForm workerTalkForm = new WorkerTalkForm();
        workerTalkForm.setTalkTime(new Timestamp(System.currentTimeMillis()));
        workerTalkForm.setSignDate(new Date(System.currentTimeMillis()));
        SysUser sysUser = sysUserManager.getSysUser();
        workerTalkForm.setSignPerson(sysUser.getDisplayName());
        workerTalkForm.setTalkPerson(sysUser.getDisplayName());
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", workerTalkForm);
        model.addAttribute("WORKER_TALK_FORM_LISTS", Constants.WORKER_TALK_FORM_LISTS);

        return "view/worker/workerTalkForm/input";
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
        WorkerTalkForm workerTalkForm = workerTalkFormService.get(id);
        model.addAttribute("WORKER_TALK_FORM_LISTS", Constants.WORKER_TALK_FORM_LISTS);
        //处理其他业务逻辑
        model.addAttribute("bean", workerTalkForm);

        return "view/worker/workerTalkForm/input";
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
        WorkerTalkForm workerTalkForm = workerTalkFormService.get(id);
        model.addAttribute("WORKER_TALK_FORM_LISTS", Constants.WORKER_TALK_FORM_LISTS);
        model.addAttribute("bean", workerTalkForm);
        return "view/worker/workerTalkForm/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") WorkerTalkForm entity, HttpServletRequest request) throws Exception {
        try {
            WorkerTalkForm target;
            if (entity.getId() != null) {
                target = workerTalkFormService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "projectName",
                        "formCode",
                        "unitName1",
                        "unitName2",
                        "content",
                        "talkTime",
                        "signDate",
                        "signPerson",
                        "talkPerson",
                        "materialIds"

                });

            } else {
                target = entity;
            }
            workerTalkFormService.save(target);

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
        workerTalkFormService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}