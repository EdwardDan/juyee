package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.orm.log.TableLog;
import com.justonetech.core.orm.log.TableLogUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysOperationTableLogService;
import com.justonetech.system.domain.SysOperationTableLog;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * note:数据表操作日志
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysOperationTableLogController extends BaseCRUDActionController<SysOperationTableLog> {
    private Logger logger = LoggerFactory.getLogger(SysOperationTableLogController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysOperationTableLogService sysOperationTableLogService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_OPERATION_TABLE_LOG_EDIT));

        return "view/system/sysOperationTableLog/grid";
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
            String hql = "from SysOperationTableLog order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysOperationTableLogService.findByPage(pageModel, query);
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        SysOperationTableLog sysOperationTableLog = new SysOperationTableLog();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", sysOperationTableLog);

        return "view/system/sysOperationTableLog/input";
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
        SysOperationTableLog sysOperationTableLog = sysOperationTableLogService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysOperationTableLog);

        return "view/system/sysOperationTableLog/input";
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
        SysOperationTableLog sysOperationTableLog = sysOperationTableLogService.get(id);
        if (StringUtils.isNotBlank(sysOperationTableLog.getLogXml())) {

            TableLog tableLog = TableLogUtils.fromXml(sysOperationTableLog.getLogXml());
            model.addAttribute("tableLog", tableLog);
        }

        model.addAttribute("bean", sysOperationTableLog);
        return "view/system/sysOperationTableLog/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysOperationTableLog entity) throws Exception {
        try {
            SysOperationTableLog target;
            if (entity.getId() != null) {
                target = sysOperationTableLogService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{

                        "logXml",
                        "ipAddress",
                        "createTime",
                        "updateTime",
                        "logType"
                });

            } else {
                target = entity;
            }

            sysOperationTableLogService.save(target);

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
        sysOperationTableLogService.delete(id);


        sendSuccessJSON(response, "删除成功");
    }

}