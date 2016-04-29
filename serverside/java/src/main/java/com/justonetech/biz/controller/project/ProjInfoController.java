package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjBidService;
import com.justonetech.biz.daoservice.ProjInfoAreaService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjBid;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.ProjInfoArea;
import com.justonetech.biz.manager.ProjInfoManager;
import com.justonetech.biz.manager.ProjectInfoContentManager;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;


/**
 * note:项目基本信息管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjInfoController extends BaseCRUDActionController<ProjInfo> {
    private Logger logger = LoggerFactory.getLogger(ProjInfoController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjInfoAreaService projInfoAreaService;

    @Autowired
    private ProjInfoManager projInfoManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private ProjectInfoContentManager projectInfoContentManager;

    @Autowired
    private ProjBidService projBidService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_INFO_EDIT));
        model.addAttribute("TYPE_STAGE", ProjBidType.TYPE_STAGE.getCode());
        model.addAttribute("TYPE_NODE", ProjBidType.TYPE_NODE.getCode());
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList", projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList", projinfocategoryList); //业务类别
        return "view/project/projInfo/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            //按项目屬性状态类别查询数据
            String projproperty = request.getParameter("projproperty");//管理属性
            String ismajor = request.getParameter("ismajor");//是否重大
            String projstage = request.getParameter("projstage");//项目状态
            String projcategory = request.getParameter("projcategory");//业务类别

            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1=1 ";
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
//            hql += projectRelateManager.getRelateProjectHql("id");
//            System.out.println("hql////////////////////////////////// = " + hql);
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ProjInfo projInfo = new ProjInfo();
        //如需增加其他默认值请在此添加
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(c.get(Calendar.YEAR) + "");
        modelStatus(model);
        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("bean", projInfo);

        projectInfoContentManager.setReportContent(model, projInfo.getProjContent());

        return "view/project/projInfo/input";
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
        ProjInfo projInfo = projInfoService.get(id);
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(projInfo.getYear() + "");
        //处理其他业务逻辑
        modelStatus(model);
        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("bean", projInfo);
        model.addAttribute("areas", projInfo.getBelongAreaNames());

        projectInfoContentManager.setReportContent(model, projInfo.getProjContent());

        return "view/project/projInfo/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String isTab) {
        ProjInfo projInfo = projInfoService.get(id);

        modelStatus(model);
        model.addAttribute("bean", projInfo);
        String[] splitArea = projInfo.getBelongAreaNames().split(",");
        ArrayList<String> areaList = new ArrayList<String>();
        for (String s : splitArea) {
            areaList.add(s);
        }
        model.addAttribute("areas", areaList);
//        model.addAttribute("areas", projInfo.getBelongAreaNames());
        model.addAttribute("isTab", isTab);

        projectInfoContentManager.setReportContent(model, projInfo.getProjContent());

        return "view/project/projInfo/view";
    }

    /**
     * 查看标段信息
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewBid(Model model, Long id, String typeCode) {
        ProjInfo projInfo = projInfoService.get(id);

        List<ProjBid> ret = new ArrayList<ProjBid>();
        Set<ProjBid> projBids = projInfo.getProjBids();
        for (ProjBid projBid : projBids) {
            if (JspHelper.getString(typeCode).equals(JspHelper.getString(projBid.getTypeCode()))) {
                ret.add(projBid);
            }
        }
        model.addAttribute("projBids", ret);
        model.addAttribute("areas", projInfo.getBelongAreaNames());

        return "view/project/projInfo/viewBid";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjInfo entity, HttpServletRequest request) throws Exception {
        try {
            ProjInfo target;
            if (entity.getId() != null) {
                target = projInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
//                        "bjbh",
                        "projNum",
                        "name",
                        "no",
                        "buildMileage",
                        "location",
                        "startDate",
                        "endDate",
                        "planStartDate",
                        "planEndDate",
                        "kgjd",
                        "wgjd",
                        "intro",
                        "isMajor",
                        "planTotalInvest",
                        "gkpfTotalInvest",
                        "gkpfPreInvest",
                        "gkpfJaInvest",
                        "csTotalInvest",
                        "csPreInvest",
                        "csJaInvest",
                        "ghhx",
//                        "function",
//                        "engineerRange",
//                        "mainContent",
                });

            } else {
                target = entity;
            }
//            String year = request.getParameter("year");
//            target.setYear(Integer.valueOf(year));
            String managerProperty = request.getParameter("managerProperty");//管理属性
            String projStage = request.getParameter("ProjStage");//项目状态
            String projCategory = request.getParameter("ProjCategory");//业态类别
            String projProperty = request.getParameter("projProperty");//项目属性
            String roadGrade = request.getParameter("roadGrade");//道路等级
            String roadTecGrade = request.getParameter("roadTecGrade");//道路技术等级
            String[] areaIds = request.getParameterValues("ProjBelongArea");//涉及区（县）
            String intro = request.getParameter("intro");
            if (!StringHelper.isEmpty(managerProperty)) {
                target.setProperty(sysCodeDetailService.get(Long.valueOf(managerProperty)));
            }
            if (!StringHelper.isEmpty(projProperty)) {
                target.setProjProperty(sysCodeDetailService.get(Long.valueOf(projProperty)));
            }
            if (!StringHelper.isEmpty(roadGrade)) {
                target.setRoadGrade(sysCodeDetailService.get(Long.valueOf(roadGrade)));
            }
            if (!StringHelper.isEmpty(roadTecGrade)) {
                target.setRoadTecGrade(sysCodeDetailService.get(Long.valueOf(roadTecGrade)));
            }
            if (!StringHelper.isEmpty(projStage)) {
                target.setStage(sysCodeDetailService.get(Long.valueOf(projStage)));
            }
            if (!StringHelper.isEmpty(projCategory)) {
                target.setCategory(sysCodeDetailService.get(Long.valueOf(projCategory)));
            } else {
                target.setCategory(null);
            }
            target.setIntro(intro);

            String projSources = request.getParameter("ProjSources");
            target.setProjectSource(sysCodeDetailService.get(Long.valueOf(projSources)));
            String area = request.getParameter("areaId");
            if (area == null || area.equals("0")) {
                target.setAreaCode("");
            } else {
                target.setAreaCode(sysCodeDetailService.get(JspHelper.getLong(area)).getName());
            }

//            String[] projPackageAttrs = request.getParameterValues("ProjPackageAttr");
//            target.setPackageAttr(StringHelper.join(projPackageAttrs, ","));
            //保存项目相关信息
            String requestContent = projectInfoContentManager.getRequestContent(target, request);
            target.setProjContent(requestContent);

            projInfoService.save(target);

            //保存区县前删除保存过的信息
            if (target.getProjInfoAreas() != null) {
                for (ProjInfoArea projInfoArea : target.getProjInfoAreas()) {
                    projInfoAreaService.delete(projInfoArea);
                }
            }
            if (areaIds != null && areaIds.length > 0) {
                for (String areaId : areaIds) {
                    if (!StringHelper.isEmpty(areaId)) {
                        SysCodeDetail sysCodeDetail = sysCodeDetailService.get(Long.valueOf(areaId));
                        ProjInfoArea projInfoArea = new ProjInfoArea();
                        projInfoArea.setBelongArea(sysCodeDetail);
                        projInfoArea.setProject(target);
                        projInfoAreaService.save(projInfoArea);
                    }
                }
            }

            //添加和修改项目时判断如果下面没有标段则自动创建一个形象进度标段，并且默认标段的所属区县与项目一致
            projInfoManager.initScheduleBid(target);


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
        ProjInfo projInfo = projInfoService.get(id);
        Set<ProjInfoArea> projInfoAreas = projInfo.getProjInfoAreas();
        if (null != projInfoAreas && projInfoAreas.size() > 0) {
            for (ProjInfoArea projInfoArea : projInfoAreas) {
                projInfoAreaService.delete(projInfoArea);
            }
        }
        Set<ProjBid> projBids = projInfo.getProjBids();
        if (null != projBids && projBids.size() > 0) {
            for (ProjBid projBid : projBids) {
                projBidService.delete(projBid);
            }
        }
        projInfoService.delete(projInfo);

        sendSuccessJSON(response, "删除成功");
    }

    //传递系统字典定义的类型
    private void modelStatus(Model model) {
        List<SysCodeDetail> areaList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_BELONG_AREA);
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("areaList", areaList); //所属区域
        model.addAttribute("PROJ_INFO_SOURCE", Constants.PROJ_INFO_SOURCE); //项目来源
        model.addAttribute("PROJ_INFO_STAGE", Constants.PROJ_INFO_STAGE); //项目状态
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY); //业务类别
        model.addAttribute("PROJ_INFO_DBSX", Constants.PROJ_INFO_DBSX); //打包属性

        model.addAttribute("PORJECT_ROAD_GRADE", Constants.PORJECT_ROAD_GRADE);
        model.addAttribute("PORJECT_ROAD_TEC_GRADE", Constants.PORJECT_ROAD_TEC_GRADE);
        model.addAttribute("PORJECT_PROJ_PROPERTY", Constants.PORJECT_PROJ_PROPERTY);
    }

}
