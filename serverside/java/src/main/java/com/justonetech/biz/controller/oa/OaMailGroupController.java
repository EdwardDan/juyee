package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMailGroupService;
import com.justonetech.biz.daoservice.OaMailGroupUserService;
import com.justonetech.biz.domain.OaMailGroup;
import com.justonetech.biz.domain.OaMailGroupUser;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;


/**
 * note:邮件分组
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaMailGroupController extends BaseCRUDActionController<OaMailGroup> {
    private Logger logger = LoggerFactory.getLogger(OaMailGroupController.class);

    @Autowired
    private OaMailGroupUserService oaMailGroupUserService;

    @Autowired
    private OaMailGroupService oaMailGroupService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model,String tabNo) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", true);
        model.addAttribute("tabNo", tabNo);

        return "view/oa/oaMailGroup/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpServletRequest request) {
        try {
            Page pageModel = new Page(page, rows, true);

            String userName = "";
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                userName = loginUser.getLoginName();
            }
            String hql = "from OaMailGroup where createUser='" + userName + "' order by id asc";
            hql += " order by name asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMailGroupService.findByPage(pageModel, queryTranslate.toString());

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
        OaMailGroup oaMailGroup = new OaMailGroup();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMailGroup);

        return "view/oa/oaMailGroup/input";
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
        OaMailGroup oaMailGroup = oaMailGroupService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaMailGroup);

        return "view/oa/oaMailGroup/input";
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
        OaMailGroup oaMailGroup = oaMailGroupService.get(id);

        model.addAttribute("bean", oaMailGroup);
        return "view/oa/oaMailGroup/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMailGroup entity, HttpServletRequest request) throws Exception {
        try {
            OaMailGroup target;
            if (entity.getId() != null) {
                target = oaMailGroupService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "description"
                });

            } else {
                target = entity;
            }
            oaMailGroupService.save(target);

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
        OaMailGroup oaMailGroup = oaMailGroupService.get(id);
        Set<OaMailGroupUser> list = oaMailGroup.getOaMailGroupUsers();
        for (OaMailGroupUser oaMailGroupUser : list) {
            oaMailGroupUserService.delete(oaMailGroupUser);
        }

        oaMailGroupService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}