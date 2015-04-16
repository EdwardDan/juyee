package com.justonetech.biz.controller.worker;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.WorkerStopFormService;
import com.justonetech.biz.domain.WorkerStopForm;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;


/**
 * note:执法管理停工单
 * author: guoqoiong
 * modify date:2014-9-16
 */
@Controller
public class WorkerStopFormController extends BaseCRUDActionController<WorkerStopForm> {
    private Logger logger = LoggerFactory.getLogger(WorkerStopFormController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private WorkerStopFormService workerStopFormService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.WORKER_STOP_FORM_EDIT));

        return "view/worker/workerStopForm/grid";
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
            String hql = "from WorkerStopForm order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = workerStopFormService.findByPage(pageModel, query);

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
        WorkerStopForm workerStopForm = new WorkerStopForm();

        workerStopForm.setStopTime(new Timestamp(System.currentTimeMillis()));
        workerStopForm.setSignDate(new Date(System.currentTimeMillis()));
        workerStopForm.setSignPerson(sysUserManager.getSysUser().getDisplayName());
        workerStopForm.setCheckPerson(sysUserManager.getSysUser().getDisplayName());
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", workerStopForm);

        return "view/worker/workerStopForm/input";
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
        WorkerStopForm workerStopForm = workerStopFormService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", workerStopForm);

        return "view/worker/workerStopForm/input";
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
        WorkerStopForm workerStopForm = workerStopFormService.get(id);

        model.addAttribute("bean", workerStopForm);

        return "view/worker/workerStopForm/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") WorkerStopForm entity) throws Exception {
        try {
            WorkerStopForm target;
            if (entity.getId() != null) {
                target = workerStopFormService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "projectName",
                        "formFont",
                        "formCode",
                        "unitName",
                        "stopTime",
                        "signDate",
                        "checkPerson",
                        "signPerson"
                });

            } else {
                target = entity;
            }
            workerStopFormService.save(target);

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
        workerStopFormService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}