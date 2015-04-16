package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysSkinService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysSkin;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysSkinManager;
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


/**
 * note:系统皮肤
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysSkinController extends BaseCRUDActionController<SysSkin> {
    private Logger logger = LoggerFactory.getLogger(SysSkinController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysSkinService sysSkinService;

    @Autowired
    private SysSkinManager sysSkinManager;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SKIN_EDIT));

        return "view/system/sysSkin/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SysSkin order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysSkinService.findByPage(pageModel, queryTranslate.toString());

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
        SysSkin sysSkin = new SysSkin();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", sysSkin);

        return "view/system/sysSkin/input";
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
        SysSkin sysSkin = sysSkinService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysSkin);

        return "view/system/sysSkin/input";
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
        SysSkin sysSkin = sysSkinService.get(id);

        model.addAttribute("bean", sysSkin);
        return "view/system/sysSkin/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysSkin entity, HttpServletRequest request) throws Exception {
        try {
            SysSkin target;
            if (entity.getId() != null) {
                target = sysSkinService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "path",
                        "isValid",
                        "isDefault",
                        "customDefine"
                });

            } else {
                target = entity;
            }
            sysSkinService.save(target);

            //当前设置为缺省，那么其他设置为非缺省
            if (target.getIsDefault()) {
                sysSkinManager.updateSkinDefault(target);
            }

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
        SysSkin sysSkin = sysSkinService.get(id);
        if (sysSkin.getSysUsers().size() > 0) {
            sendFailureJSON(response, "删除失败，已有用户选择此皮肤！");

        } else {
            sysSkinService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }
    }

    /**
     * 选择皮肤页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String select(Model model) {
        SysSkin skin = sysUserManager.getSysUser().getSkin();
        model.addAttribute("oldSkinId", skin != null ? skin.getId() : "");
        model.addAttribute("oldSkinPath", skin != null ? skin.getPath() : sysSkinManager.getDefaultSkinPath());

        //处理其他业务逻辑
        model.addAttribute("list", sysSkinManager.getValidSkins());

        return "view/system/sysSkin/select";
    }

    /**
     * 选择皮肤保存操作
     *
     * @param response  .
     * @param newSkinId .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void selectSave(HttpServletResponse response, Long newSkinId) throws Exception {
        try {
            SysSkin sysSkin = sysSkinService.get(newSkinId);
            SysUser sysUser = sysUserManager.getSysUser();
            sysUser.setSkin(sysSkin);

            sysUserService.save(sysUser);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "更换皮肤成功");
    }
}