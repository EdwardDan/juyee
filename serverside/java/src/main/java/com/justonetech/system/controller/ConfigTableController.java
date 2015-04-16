package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.ConfigTableService;
import com.justonetech.system.daoservice.SysOperationTableLogService;
import com.justonetech.system.domain.ConfigTable;
import com.justonetech.system.manager.ConfigTableManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * note:表日志配置
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ConfigTableController extends BaseCRUDActionController<ConfigTable> {
    private Logger logger = LoggerFactory.getLogger(ConfigTableController.class);

    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private SysOperationTableLogService sysOperationTableLogService;

    @Autowired
    private ConfigTableManager configTableManager;


    @Autowired
    private ConfigTableService configTableService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CONFIG_TABLE_EDIT));

        return "view/system/configTable/grid";
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
            String hql = "from ConfigTable order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = configTableService.findByPage(pageModel, query);
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
        ConfigTable configTable = new ConfigTable();
        List<Map> bizClasses = configTableManager.getAllBizClass();

        model.addAttribute("bean", configTable);

        model.addAttribute("bizClasses", bizClasses);
        return "view/system/configTable/input";
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
        ConfigTable configTable = configTableService.get(id);
        List<Map> bizClasses = configTableManager.getAllBizClass();
        //处理其他业务逻辑
        model.addAttribute("bean", configTable);
        model.addAttribute("bizClasses", bizClasses);
        return "view/system/configTable/input";
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
        ConfigTable configTable = configTableService.get(id);
        model.addAttribute("bean", configTable);
        return "view/system/configTable/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ConfigTable entity) throws Exception {
        try {
            ConfigTable target;
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (entity.getId() != null) {
                target = configTableService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "tableName",
                        "isLog",
                        "extendXml",
                        "className"

                });
                target.setUpdateUser(loginUser.getLoginName());
                target.setUpdateTime(DateTimeHelper.getTimestamp());

            } else {
                target = entity;
                target.setCreateTime(DateTimeHelper.getTimestamp());
                target.setCreateUser(sysUserManager.getSysUser().getLoginName());

            }
            configTableService.save(target);

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

        String sql = "select * from sys_operation_table_log where table_id=" + id;
        List list = sysOperationTableLogService.findBySql(sql);
        if (list.size() > 0)
            sendFailureJSON(response, "已有日志，请先删除日志！");
        else {
            configTableService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }


    }


    @RequestMapping
    public void info(String className, HttpServletResponse response) {
        List<Map> maps = configTableManager.getAllBizClass();
        Map infoMap = null;
        for (Map map : maps) {
            if (map.get("className").equals(className)) {
                infoMap = map;
                break;
            }
        }
        sendJSON(response, new JSONSerializer().exclude("*.clsss").serialize(infoMap));
    }

}