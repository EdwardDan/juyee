package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaThingsService;
import com.justonetech.biz.domain.OaThings;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
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


/**
 * note:办公用品信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaThingsController extends BaseCRUDActionController<OaThings>
{
    private Logger logger = LoggerFactory.getLogger(OaThingsController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaThingsService oaThingsService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model)
    {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_EDIT));

        return "view/oa/oaThings/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session)
    {
        try
        {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaThings order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaThingsService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e)
        {
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
    public String add(Model model)
    {
        OaThings oaThings = new OaThings();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaThings);

        return "view/oa/oaThings/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id)
    {
        OaThings oaThings = oaThingsService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaThings);

        return "view/oa/oaThings/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id)
    {
        OaThings oaThings = oaThingsService.get(id);

        model.addAttribute("bean", oaThings);
        return "view/oa/oaThings/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaThings entity, HttpServletRequest request) throws Exception
    {
        try
        {
            OaThings target;
            if (entity.getId() != null)
            {
                target = oaThingsService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "orderNo",
                        "name",
                        "model",
                        "price",
                        "unit",
                        "amount",
                        "isValid",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser"
                });

            } else
            {
                target = entity;
            }
            oaThingsService.save(target);

        } catch (Exception e)
        {
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
    public void delete(HttpServletResponse response, Long id) throws Exception
    {
        oaThingsService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}