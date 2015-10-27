package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendCost;
import com.justonetech.biz.domain.ProjExtendSchedule;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
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
    public String grid(Model model, String flag,String msg) {
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList", projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList", projinfocategoryList); //业务类别
        //判断是否有编辑权限
        model.addAttribute("flag", flag);
        model.addAttribute("msg", msg);
        if (StringHelper.isEmpty(flag)) {
            model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT1));
        } else {
            if ("1012".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT2));
            } else if ("1517".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT3));
            }
        }

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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String flag,String msg, HttpServletRequest request) {
        try {
            boolean isJsdw = true;
            SysUser sysUser = sysUserManager.getSysUser();
            //是否是建设单位用户
            if (null != sysUser.getPerson()) {
                SysDept dept = sysUser.getPerson().getDept();
                if (null != dept) {
                    SysDept company = getParentCompany(dept);
                    if (null != company) {
                        if (!company.getName().equals("上海市交通建设工程管理中心") && !company.getName().equals("巨一科技发展有限公司") && !company.getName().equals("上海市交通委员会")) {
                            isJsdw = false;
                        }
                    }
                }
            }
            //按项目屬性状态类别查询数据
            String projproperty = request.getParameter("projproperty");//项目性质
            String ismajor = request.getParameter("ismajor");//是否重大
            String projstage = request.getParameter("projstage");//项目状态
            String projcategory = request.getParameter("projcategory");//业务类别
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1 = 1 ";
            if (!StringHelper.isEmpty(flag) && "qqdj".equals(flag)) {
                hql += " and packageAttr like '%区区对接%' ";
                if (!StringHelper.isEmpty(msg)) {
                    hql += " and projNum like '" + msg + "%'";
                }
            } else {
                hql += " and packageAttr is null ";
            }
            if (!isJsdw) {
                hql += projectRelateManager.getRelateProjectHql("id");
            }
            //增加项目过滤
            if (!StringHelper.isEmpty(projproperty)) {
                hql += " and property.name = '" + projproperty + "' ";
            }
            if (!StringHelper.isEmpty(ismajor)) {
                hql += " and isMajor = '" + ismajor + "' ";
            }
            if (!StringHelper.isEmpty(projstage)) {
                hql += " and stage.name = '" + projstage + "' ";
            }
            if (!StringHelper.isEmpty(projcategory)) {
                hql += " and category.name = '" + projcategory + "' ";
            }
            hql += " order by no asc,id asc";
//            System.out.println("hql///////////////////////////////// = " + hql);
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

    private SysDept getParentCompany(SysDept dept) {
        if (dept.getIsTag() != null && dept.getIsTag()) {
            return dept;
        }
        if (dept.getParent() != null) {
            return getParentCompany(dept.getParent());
        } else {
            return dept;
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
     * 修改项目基本信息
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String input(Model model, Long projectId) {
        model.addAttribute("projectId", projectId);
        ProjInfo projInfo = projInfoService.get(projectId);
        model.addAttribute("bean", projInfo);
        model.addAttribute("areas", projInfo.getBelongAreaNames());
        modelStatus(model);

        return "view/project/projExtend/input";
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
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveProjInfo(HttpServletResponse response, @ModelAttribute("bean") ProjInfo entity, HttpServletRequest request) throws Exception {
        try {
            ProjInfo target;
            if (entity.getId() != null) {
                target = projInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "jsDept",
                        "jsDeptPerson",
                        "jsDeptTel",
                        "sgDept",
                        "sgDeptPerson",
                        "sgDeptTel",
                        "jlDept",
                        "jlDeptPerson",
                        "jlDeptTel",
                        "isMajor",
                        "function",
                        "engineerRange",
                        "mainContent",
                });
            } else {
                target = entity;
            }
            String intro = request.getParameter("intro");
            target.setIntro(intro);

            projInfoService.save(target);

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

    //传递系统字典定义的类型
    private void modelStatus(Model model) {
        model.addAttribute("PROJ_INFO_STAGE", Constants.PROJ_INFO_STAGE); //项目状态
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY); //业务类别
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("PROJ_INFO_SOURCE", Constants.PROJ_INFO_SOURCE); //项目来源
        List<SysCodeDetail> areaList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_BELONG_AREA);
        model.addAttribute("areaList", areaList); //所属区域
        model.addAttribute("PROJ_INFO_DBSX", Constants.PROJ_INFO_DBSX); //打包属性
    }
}