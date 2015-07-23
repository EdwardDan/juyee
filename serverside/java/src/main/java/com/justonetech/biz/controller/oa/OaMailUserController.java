package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMailUserService;
import com.justonetech.biz.domain.OaMailUser;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * note:邮件接收人员
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaMailUserController extends BaseCRUDActionController<OaMailUser> {
    private Logger logger = LoggerFactory.getLogger(OaMailUserController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaMailUserService oaMailUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));

        return "view/oa/oaMailUser/grid";
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
            String hql = "from OaMailUser order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMailUserService.findByPage(pageModel, queryTranslate.toString());

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
        OaMailUser oaMailUser = new OaMailUser();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMailUser);

        return "view/oa/oaMailUser/input";
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
        OaMailUser oaMailUser = oaMailUserService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaMailUser);

        return "view/oa/oaMailUser/input";
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
        OaMailUser oaMailUser = oaMailUserService.get(id);

        model.addAttribute("bean", oaMailUser);
        return "view/oa/oaMailUser/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMailUser entity, HttpServletRequest request) throws Exception {
        try {
            OaMailUser target;
            if (entity.getId() != null) {
                target = oaMailUserService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "typeCode",
                        "userName",
                        "isRead",
                        "readTime",
                        "isDelete",
                        "deleteTime",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser"
                });

            } else {
                target = entity;
            }
            oaMailUserService.save(target);

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
        oaMailUserService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}