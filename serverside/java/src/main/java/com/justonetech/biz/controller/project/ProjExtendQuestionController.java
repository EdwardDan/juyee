package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendCost;
import com.justonetech.biz.domain.ProjExtendQuestion;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjExtendCostType;
import com.justonetech.biz.utils.enums.ProjQuestionType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.ExcelPrintManager;
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
import java.util.*;


/**
 * note:项目问题清单
 * author: gq
 * create date:
 */
@Controller
public class ProjExtendQuestionController extends BaseCRUDActionController<ProjExtendQuestion> {
    private Logger logger = LoggerFactory.getLogger(ProjExtendQuestionController.class);

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
    private ProjExtendQuestionService projExtendQuestionService;

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

    @Autowired
    private ExcelPrintManager excelPrintManager;

    private static final String xlsTemplateName = "ProjExtendQuestion.xls";

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String flag, String msg, String qdType) {
        List<SysCodeDetail> propertyList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> projinfostageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        List<SysCodeDetail> projinfocategoryList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_CATEGORY);
        model.addAttribute("propertyList", propertyList); //管理属性
        model.addAttribute("projinfostageList", projinfostageList); //项目状态
        model.addAttribute("projinfocategoryList", projinfocategoryList); //业务类别
        //判断是否有编辑权限
        model.addAttribute("flag", flag);
        model.addAttribute("msg", msg);
        model.addAttribute("qdType", qdType);

        String qdName = ProjQuestionType.QUESTION_TYPE.getName();
        if (ProjQuestionType.DUTY_TYPE.getCode().equals(qdType)) {
            qdName = ProjQuestionType.DUTY_TYPE.getName();
        }
        model.addAttribute("qdName", qdName);
        if (StringHelper.isEmpty(flag)) {
            model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT1));
            model.addAttribute("titleName", "十二五" + qdName);
        } else {
            if ("1012".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT2));
                model.addAttribute("titleName", "2010-2012区区对接" + qdName);
            } else if ("1517".equals(msg)) {
                model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_EXTEND_EDIT3));
                model.addAttribute("titleName", "2015-2017区区对接、断头路" + qdName);
            }
        }

        return "view/project/projExtendQuestion/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String flag, String msg, String qdType, HttpServletRequest request) {
        try {

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
            if (!isJsdw()) {
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

    private boolean isJsdw() {
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
                        if (StringHelper.isEmpty(code) || (!StringHelper.isEmpty(code) && !code.equals("OWNER") && !code.equals("JYKJ") && !code.equals("3"))) {
                            isJsdw = false;
                        }
                    }
                }
            }
        }
        return isJsdw;
    }

    /**
     * 修改清单信息
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String input(Model model, Long projectId, String qdType) {
        model.addAttribute("projectId", projectId);
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
        model.addAttribute("bean", projExtend);
        model.addAttribute("qdType", qdType);
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String monthOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(month));
        String yearOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(year));
        model.addAttribute("monthOptions", monthOptions);
        model.addAttribute("yearOptions", yearOptions);
        model.addAttribute("questionType", ProjQuestionType.QUESTION_TYPE.getCode());
        model.addAttribute("dutyType", ProjQuestionType.DUTY_TYPE.getCode());
        model.addAttribute("dutyDept", Constants.DUTY_DEPT);

        return "view/project/projExtendQuestion/input";
    }

    /**
     * 查看清单信息
     *
     * @param model     。
     * @param projectId 。
     * @return 。
     */
    @RequestMapping
    public String view(Model model, Long projectId, String qdType) {
        model.addAttribute("projectId", projectId);
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
        model.addAttribute("bean", projExtend);
        model.addAttribute("qdType", qdType);
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String monthOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(month));
        String yearOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(year));
        model.addAttribute("monthOptions", monthOptions);
        model.addAttribute("yearOptions", yearOptions);
        model.addAttribute("questionType", ProjQuestionType.QUESTION_TYPE.getCode());
        model.addAttribute("dutyType", ProjQuestionType.DUTY_TYPE.getCode());
        model.addAttribute("dutyDept", Constants.DUTY_DEPT);

        return "view/project/projExtendQuestion/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjExtend entity, HttpServletRequest request, String qdType) throws Exception {
        try {
            ProjExtend target;
            if (entity.getId() != null) {
                target = projExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{});
            } else {
                target = entity;
            }
            projExtendService.save(target);
            //先删除，在保存
            if (qdType.equals(ProjQuestionType.QUESTION_TYPE.getCode())) {
                Set<ProjExtendQuestion> projExtendQuestions = target.getProjExtendQuestions();
                List<ProjExtendQuestion> deleteList = new ArrayList<ProjExtendQuestion>();
                for (ProjExtendQuestion question : projExtendQuestions) {
                    deleteList.add(question);
                }
                projExtendQuestionService.batchDelete(deleteList, deleteList.size());
                //保存操作
                List<ProjExtendQuestion> saveList = new ArrayList<ProjExtendQuestion>();
                String[] nums = request.getParameterValues("num");
                String[] years = request.getParameterValues("year");
                String[] months = request.getParameterValues("month");
                String[] questions = request.getParameterValues("question");
                if (null != nums && nums.length > 0) {
                    for (int i = 0; i < nums.length; i++) {
                        ProjExtendQuestion question = new ProjExtendQuestion();
                        question.setProjExtend(target);
                        question.setQdType(qdType);
                        question.setYear(Integer.valueOf(years[i]));
                        question.setMonth(Integer.valueOf(months[i]));
                        question.setQuestion(questions[i]);
                        saveList.add(question);
                    }
                }
                projExtendQuestionService.batchSave(saveList, saveList.size());
            } else if (qdType.equals(ProjQuestionType.DUTY_TYPE.getCode())) {
                //保存操作
                List<ProjExtendQuestion> saveList = new ArrayList<ProjExtendQuestion>();
                String[] questionIds = request.getParameterValues("questionId");
                if (null != questionIds && questionIds.length > 0) {
                    for (int i = 0; i < questionIds.length; i++) {
                        String deptIds = request.getParameter("deptIds" + i);
                        String deptNames = request.getParameter("deptNames" + i);
                        ProjExtendQuestion question = projExtendQuestionService.get(Long.valueOf(questionIds[i]));
                        question.setQdType(question.getQdType() + qdType);
                        question.setDeptIds(deptIds);
                        question.setDeptName(deptNames);
                        saveList.add(question);
                    }
                }
                projExtendQuestionService.batchSave(saveList, saveList.size());
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 汇总页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String doSum(Model model, String qdType, String flag, String msg) {
        model.addAttribute("qdType", qdType);
        model.addAttribute("flag", flag);
        model.addAttribute("msg", msg);
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String monthOptions = DateTimeHelper.getMonthSelectOptions("");
        String yearOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(year));
        model.addAttribute("monthOptions", monthOptions);
        model.addAttribute("yearOptions", yearOptions);
        model.addAttribute("currentYear", year);
        model.addAttribute("currentMonth", month);
        model.addAttribute("PROJ_INFO_CATEGORY", Constants.PROJ_INFO_CATEGORY);
        List<SysCodeDetail> areaList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_BELONG_AREA);
        model.addAttribute("areaList", areaList);
        model.addAttribute("PROJ_INFO_PROPERTY", Constants.PROJ_INFO_PROPERTY);
        List<SysCodeDetail> stageList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_STAGE);
        model.addAttribute("stageList", stageList); //项目状态

        return "view/project/projExtendQuestion/qdSum";
    }

    /**
     * 查看项目推进信息--获取数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String qdSumData(Model model, HttpServletRequest request, String flag, String msg) {
        String projectName = request.getParameter("projectName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String propertyId = request.getParameter("propertyId");
        String isMajor = request.getParameter("isMajor");
        String qdYear = request.getParameter("qdYear");
        String qdMonth = request.getParameter("qdMonth");
        String categoryId = request.getParameter("categoryId");
        String areaId = request.getParameter("areaId");
        String stageId = request.getParameter("stageId");
        String qdType = request.getParameter("qdType");

        String qdName = ProjQuestionType.QUESTION_TYPE.getName();
        if (ProjQuestionType.DUTY_TYPE.getCode().equals(qdType)) {
            qdName = ProjQuestionType.DUTY_TYPE.getName();
        }
        model.addAttribute("year", year);
        model.addAttribute("qdName", qdName);
        model.addAttribute("dutyType", ProjQuestionType.DUTY_TYPE.getCode());
        model.addAttribute("qdType", qdType);

        String conditionHql = "from ProjInfo where 1 = 1 ";
        if (!StringHelper.isEmpty(flag) && "qqdj".equals(flag)) {
            conditionHql += " and packageAttr like '%区区对接%' ";
            if (!StringHelper.isEmpty(msg)) {
                conditionHql += " and projNum like '" + msg + "%'";
            }
        } else {
            conditionHql += " and packageAttr is null ";
        }
        if (!isJsdw()) {
            conditionHql += projectRelateManager.getRelateProjectHql("id");
        }
        if (!StringHelper.isEmpty(projectName)) {
            conditionHql += " and name like '%" + projectName + "%'";
        }
        if (!StringHelper.isEmpty(jsDept)) {
            conditionHql += " and jsDept like '%" + jsDept + "%'";
        }
        if (!StringHelper.isEmpty(year)) {
            conditionHql += " and year='" + year + "'";
        }
        if (!StringHelper.isEmpty(propertyId)) {
            conditionHql += " and property.id=" + propertyId;
        }
        if (!StringHelper.isEmpty(isMajor)) {
            conditionHql += " and isMajor=" + isMajor;
        }
        if (!StringHelper.isEmpty(categoryId)) {
            conditionHql += " and category.id=" + categoryId;
        }
        if (!StringHelper.isEmpty(areaId) && !"0".equals(areaId)) {
            conditionHql += " and areaCode='" + sysCodeManager.getCodeListById(Long.valueOf(areaId)).getName() + "'";
        }
        if (!StringHelper.isEmpty(stageId)) {
            conditionHql += " and stage.id=" + stageId;
        }
        List<ProjInfo> projInfos = projInfoService.findByQuery(conditionHql + " order by no asc,id asc");
        model.addAttribute("projects", projInfos);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        if (null != projInfos && projInfos.size() > 0) {
            for (ProjInfo info : projInfos) {
                Map<String, Object> map = new HashMap<String, Object>();
                Long projectId = info.getId();
                map.put("projectId", projectId);
                map.put("projectName", info.getName());
                int size = 1;
                ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
                if (null != projExtend) {
                    Set<ProjExtendQuestion> items = projExtend.getProjExtendQuestions();
                    Set<ProjExtendQuestion> list = new HashSet<ProjExtendQuestion>();
                    if (null != items && items.size() > 0) {
                        for (ProjExtendQuestion item : items) {
                            Integer itemYear = item.getYear();
                            Integer itemMonth = item.getMonth();
                            boolean isYear = !StringHelper.isEmpty(qdYear) && JspHelper.getInteger(qdYear) == itemYear;
                            boolean isMonth = !StringHelper.isEmpty(qdMonth) && JspHelper.getInteger(qdMonth) == itemMonth;
                            if (isYear && isMonth) {
                                list.add(item);
                            }
                        }
                        if (list.size() > 0) {
                            size = list.size();
                            map.put("item" + projectId, list);
                        } else {
                            size = items.size();
                            map.put("item" + projectId, items);
                        }
                    }
                }
                map.put("size", size);
                mapList.add(map);
            }
        }
        model.addAttribute("mapList", mapList);

        return "view/project/projExtendQuestion/qdSumData";
    }

    /**
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel(HttpServletResponse response, HttpServletRequest request, String flag, String msg) throws Exception {
        //把打印的数据压入map中
        Map<String, Object> beans = new HashMap<String, Object>();
        String projectName = request.getParameter("projectName");
        String jsDept = request.getParameter("jsDept");
        String year = request.getParameter("year");
        String propertyId = request.getParameter("propertyId");
        String isMajor = request.getParameter("isMajor");
        String qdYear = request.getParameter("qdYear");
        String qdMonth = request.getParameter("qdMonth");
        String categoryId = request.getParameter("categoryId");
        String areaId = request.getParameter("areaId");
        String stageId = request.getParameter("stageId");
        String qdType = request.getParameter("qdType");

        String qdName = ProjQuestionType.QUESTION_TYPE.getName();
        if (ProjQuestionType.DUTY_TYPE.getCode().equals(qdType)) {
            qdName = ProjQuestionType.DUTY_TYPE.getName();
        }

        beans.put("dutyType", ProjQuestionType.DUTY_TYPE.getCode());
        beans.put("qdType", qdType);

        String conditionHql = "from ProjInfo where 1 = 1 ";
        if (!StringHelper.isEmpty(flag) && "qqdj".equals(flag)) {
            conditionHql += " and packageAttr like '%区区对接%' ";
            if (!StringHelper.isEmpty(msg)) {
                conditionHql += " and projNum like '" + msg + "%'";
            }
        } else {
            conditionHql += " and packageAttr is null ";
        }
        if (!isJsdw()) {
            conditionHql += projectRelateManager.getRelateProjectHql("id");
        }
        if (!StringHelper.isEmpty(projectName)) {
            conditionHql += " and name like '%" + projectName + "%'";
        }
        if (!StringHelper.isEmpty(jsDept)) {
            conditionHql += " and jsDept like '%" + jsDept + "%'";
        }
        if (!StringHelper.isEmpty(year)) {
            conditionHql += " and year='" + year + "'";
        }
        if (!StringHelper.isEmpty(propertyId)) {
            conditionHql += " and property.id=" + propertyId;
        }
        if (!StringHelper.isEmpty(isMajor)) {
            conditionHql += " and isMajor=" + isMajor;
        }
        if (!StringHelper.isEmpty(categoryId)) {
            conditionHql += " and category.id=" + categoryId;
        }
        if (!StringHelper.isEmpty(areaId) && !"0".equals(areaId)) {
            conditionHql += " and areaCode='" + sysCodeManager.getCodeListById(Long.valueOf(areaId)).getName() + "'";
        }
        if (!StringHelper.isEmpty(stageId)) {
            conditionHql += " and stage.id=" + stageId;
        }
        List<ProjInfo> projInfos = projInfoService.findByQuery(conditionHql + " order by no asc,id asc");
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        if (null != projInfos && projInfos.size() > 0) {
            for (ProjInfo info : projInfos) {
                Map<String, Object> map = new HashMap<String, Object>();
                Long projectId = info.getId();
                map.put("projectId", projectId);
                map.put("projectName", info.getName());
                int size = 1;
                ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
                if (null != projExtend) {
                    Set<ProjExtendQuestion> items = projExtend.getProjExtendQuestions();
                    Set<ProjExtendQuestion> list = new HashSet<ProjExtendQuestion>();
                    if (null != items && items.size() > 0) {
                        for (ProjExtendQuestion item : items) {
                            Integer itemYear = item.getYear();
                            Integer itemMonth = item.getMonth();
                            boolean isYear = !StringHelper.isEmpty(qdYear) && JspHelper.getInteger(qdYear) == itemYear;
                            boolean isMonth = !StringHelper.isEmpty(qdMonth) && JspHelper.getInteger(qdMonth) == itemMonth;
                            if (isYear && isMonth) {
                                list.add(item);
                            }
                        }
                        if (list.size() > 0) {
                            size = list.size();
                            map.put(String.valueOf(projectId), list);
                        } else {
                            size = items.size();
                            map.put(String.valueOf(projectId), items);
                        }
                    }
                }
                map.put("size", size);
                mapList.add(map);
            }
        }
        beans.put("mapList", mapList);
        String fileName = qdName + "汇总表.xls";
        excelPrintManager.printExcel(response, request, ProjExtendQuestion.class.getSimpleName(), xlsTemplateName, beans, fileName);
    }
}
