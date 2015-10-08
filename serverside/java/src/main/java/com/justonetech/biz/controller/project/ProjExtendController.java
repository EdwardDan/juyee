package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjExtendCostService;
import com.justonetech.biz.daoservice.ProjExtendScheduleService;
import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendCost;
import com.justonetech.biz.domain.ProjExtendSchedule;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;


/**
 * note:项目扩展信息 -- 维护和查看入口
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjExtendController extends BaseCRUDActionController<ProjExtend> {
    private Logger logger = LoggerFactory.getLogger(ProjExtendController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjExtendService projExtendService;

    @Autowired
    private ProjExtendCostService projExtendCostService;

    @Autowired
    private ProjExtendScheduleService projExtendScheduleService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String flag) {
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList",projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList",projinfocategoryList); //业务类别
        //判断是否有编辑权限
        model.addAttribute("flag", flag);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_INFO_EDIT));

        return "view/project/projExtend/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String flag, HttpServletRequest request) {
        try {
            String projproperty = request.getParameter("projproperty");//项目性质
            String ismajor = request.getParameter("ismajor");//是否重大
            String projstage = request.getParameter("projstage");//项目状态
            String projcategory = request.getParameter("projcategory");//业务类别
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1=1";
            if ("qqdj".equals(flag)) {
                hql += " and category is null and packageAttr like '区区对接'";
            } else {
                hql += " and category is not null and packageAttr is null";
            }
            if (!StringHelper.isEmpty(projproperty)) {
                hql += " and property.name = '" + projproperty +"' ";
            }
            if (!StringHelper.isEmpty(ismajor)) {
                hql += " and isMajor = '" + ismajor +"' ";
            }
            if (!StringHelper.isEmpty(projstage)) {
                hql += " and stage.name = '" + projstage +"' ";
            }
            if (!StringHelper.isEmpty(projcategory)) {
                hql += " and category.name = '" + projcategory +"' ";
            }
            hql += " order by no asc,id asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }


    /**
     * 修改入口
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long projectId) {
        model.addAttribute("projectId", projectId);

        return "view/project/projExtend/modify";
    }

    /**
     * 查看入口
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long projectId) {
        model.addAttribute("projectId", projectId);

        return "view/project/projExtend/view";
    }

    /**
     * 删除操作
     *
     * @param response  .
     * @param projectId .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long projectId) throws Exception {
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
        if (null != projExtend) {
            Set<ProjExtendCost> projExtendCosts = projExtend.getProjExtendCosts();
            for (ProjExtendCost projExtendCost : projExtendCosts) {
                projExtendCostService.delete(projExtendCost);
            }
            Set<ProjExtendSchedule> projExtendSchedules = projExtend.getProjExtendSchedules();
            for (ProjExtendSchedule projExtendSchedule : projExtendSchedules) {
                projExtendScheduleService.delete(projExtendSchedule);
            }
            projExtendService.delete(projExtend);

            sendSuccessJSON(response, "删除成功");
        }
    }
}