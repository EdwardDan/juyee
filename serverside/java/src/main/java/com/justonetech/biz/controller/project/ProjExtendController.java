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
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjExtendCostType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.MathHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
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
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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
    public String grid(Model model, String flag, String msg) {
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
            model.addAttribute("titleName", "十二五项目清单");
        } else {
            if ("1012".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT2));
                model.addAttribute("titleName", "2010-2012区区对接项目清单");
            } else if ("1517".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT3));
                model.addAttribute("titleName", "2015-2017区区对接、断头路项目清单");
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String flag, String msg, HttpServletRequest request) {
        try {
            boolean isJsdw = true;
            SysUser sysUser = sysUserManager.getSysUser();
            //是否是建设单位用户
            if (null != sysUser) {
                SysPerson person = sysUser.getPerson();
                if (null != person) {
                    SysDept dept = person.getDept();
                    if (null != dept) {
                        SysDept company = getParentCompany(dept);
                        if (null != company) {
                            String code = company.getCode();
                            if (!StringHelper.isEmpty(code) && !code.equals("OWNER") && !code.equals("JYKJ") && !code.equals("3")) {
                                isJsdw = false;
                            }else{
                                isJsdw = false;
                            }
                        }
                    }
                }
            }
            //按项目屬性状态类别查询数据
            String projproperty = request.getParameter("projproperty");//项目性质
            String ismajor = request.getParameter("ismajor");//是否重大
            String projstage = request.getParameter("projstage");//项目状态
            String projcategory = request.getParameter("projcategory");//业务类别
            Page<ProjInfo> pageModel = new Page<ProjInfo>(page, rows, true);
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

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    List<ProjExtend> extendList = projExtendService.findByProperty("project.id", JspHelper.getLong(id));
                    ProjExtend projExtend = null;
                    if (null != extendList && extendList.size() > 0) {
                        projExtend = extendList.iterator().next();
                    }
                    if (null != projExtend) {
                        bean.put("gctxGkpfTotal", null != projExtend.getGctxGkpfTotal() ? projExtend.getGctxGkpfTotal() : ""); //工可总投资（亿元）
                        List<ProjExtendCost> costList = projExtendCostService.findByProperty("projExtend.id", projExtend.getId());
                        double accCost = 0.0;
                        double yearAccCost = 0.0;
                        double yearPlanCost = 0.0;
                        if (null != costList && costList.size() > 0) {
                            for (ProjExtendCost cost : costList) {
                                String type = cost.getType();
                                Integer costYear = cost.getYear();
                                String half = cost.getHalf();
                                Double accComplete = cost.getAccComplete();
                                if (null == accComplete) {
                                    accComplete = 0.0;
                                }
                                if (null != costYear && costYear == (year - 1) && !StringHelper.isEmpty(type) && type.equals(ProjExtendCostType.EXTEND_TYPE_1.getCode())) {
                                    accCost += accComplete;
                                }
                                if (null != costYear && costYear == year && !StringHelper.isEmpty(half) && half.equals("sbn") && !StringHelper.isEmpty(type) && type.equals(ProjExtendCostType.EXTEND_TYPE_3.getCode())) {
                                    accCost += accComplete;
                                    yearAccCost += accComplete;
                                }
                                if (null != costYear && costYear == year && !StringHelper.isEmpty(type) && type.equals(ProjExtendCostType.EXTEND_TYPE_2.getCode())) {
                                    yearPlanCost += accComplete;
                                }
                            }
                        }
                        if (0.0 == accCost) {
                            bean.put("accCost", "");
                        } else {
                            bean.put("accCost", MathHelper.roundDouble(accCost, 4));
                        }
                        if (0.0 == yearPlanCost) {
                            bean.put("costRate", "");
                        } else {
                            bean.put("costRate", MathHelper.roundDouble(yearAccCost / yearPlanCost, 2) * 100);
                        }
                    }
                }
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);
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