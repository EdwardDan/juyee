package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysParameterService;
import com.justonetech.system.domain.SysParameter;
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
 * author: 系统参数维护
 * create date:
 * modify date:
 */
@Controller
public class SysParameterController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysParameterController.class);

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model,String code) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PARAMETER_EDIT));
        model.addAttribute("code", code);
        return "view/system/sysParameter/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows,String code) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SysParameter where 1=1";
            if (!StringHelper.isEmpty(code)) {
                hql += " and code='"+code+"'";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysParameterService.findByPage(pageModel, queryTranslate.toString());

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
    public String add(Model model, String code) {
        SysParameter sysParameter = new SysParameter();
        if (!StringHelper.isEmpty(code)) {
            sysParameter.setCode(code);
        }
        model.addAttribute("bean", sysParameter);

        return "view/system/sysParameter/input";
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
        SysParameter sysParameter = sysParameterService.get(id);

        model.addAttribute("bean", sysParameter);
        return "view/system/sysParameter/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysParameter sysParameter = sysParameterService.get(id);

        model.addAttribute("bean", sysParameter);
        return "view/system/sysParameter/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysParameter entity, HttpServletRequest request) throws Exception {
        try {
            SysParameter target;
            if (entity.getId() != null) {
                target = sysParameterService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "value",
                        "constraint",
                        "clobvalue"
                });

            } else {
                target = entity;
            }
            sysParameterService.save(target);

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
        sysParameterService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}