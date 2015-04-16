package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.system.daoservice.SysRolePrivilegeService;
import com.justonetech.system.domain.SysRolePrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysRolePrivilegeController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysRolePrivilegeController.class);

    @Autowired
    private SysRolePrivilegeService sysRolePrivilegeService;

   /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {    
      return "view/system/sysRolePrivilege/grid";
    }
    
    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SysRolePrivilege order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysRolePrivilegeService.findByPage(pageModel, queryTranslate.toString());

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
     */
    @RequestMapping
    public String add(Model model, Long parentId) {
        SysRolePrivilege sysRolePrivilege = new SysRolePrivilege();

        //如需增加其他默认值请在此添加
        //if (parentId != null) {
        //    sysRolePrivilege.setParent(sysRolePrivilegeService.get(parentId));
        //}

        model.addAttribute("bean", sysRolePrivilege);

        return "view/system/sysRolePrivilege/input";
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
        SysRolePrivilege sysRolePrivilege = sysRolePrivilegeService.get(id);

        //处理其他业务逻辑

        model.addAttribute("bean", sysRolePrivilege);
        return "view/system/sysRolePrivilege/input";
    }
    
    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysRolePrivilege sysRolePrivilege = sysRolePrivilegeService.get(id);
        
        model.addAttribute("bean", sysRolePrivilege);        
        return "view/system/sysRolePrivilege/view";
    }
    
    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @return         .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysRolePrivilege entity, HttpServletRequest request) throws Exception {
        try {
            SysRolePrivilege target;
            if (entity.getId() != null) {
                target = sysRolePrivilegeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                });

            } else {
                target = entity;
            }
            sysRolePrivilegeService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        sysRolePrivilegeService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}