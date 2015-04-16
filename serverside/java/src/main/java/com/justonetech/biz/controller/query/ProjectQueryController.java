package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.webService.monitorWebService.Exception_Exception;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorParam;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorService;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorWebServiceClient;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: Chen Junping
 * Date: 12-3-19
 */
@Controller
public class ProjectQueryController extends BaseCRUDActionController<ShareProTobuild> {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private MonitorWebServiceClient monitorWebServiceClient;

    @Autowired
    private ProjectStreetService projectStreetService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private ProjectMajorService projectMajorService;

    @Autowired
    private JdStopOrderService jdStopOrderService;

    @Autowired
    private JdRecordFirstService jdRecordFirstService;

    @Autowired
    private JdRecordSafeService jdRecordSafeService;

    @Autowired
    private JdRecordQualityService jdRecordQualityService;

    @Autowired
    private JdRecordCompleteService jdRecordCompleteService;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    //项目工地类别
    private static final String PROJECT_TYPE_HAS_VIDEO = "1"; //有视频
    private static final String PROJECT_TYPE_NO_VIDEO = "2";   //无视频
    private static final String PROJECT_TYPE_UNLAWFUL = "3";  //六无工地

    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        model.addAttribute("flag1", Constants.PROJECT_QUERY_TAB_BJ);
        model.addAttribute("flag2", Constants.PROJECT_QUERY_TAB_ZJ);
        model.addAttribute("flag3", Constants.PROJECT_QUERY_TAB_WGWY);
        model.addAttribute("flag4", Constants.PROJECT_QUERY_SMALL_PROJECT);

        return "view/query/projectQuery/init";
    }

    /**
     * 列表显示页面--报建tab页
     *
     * @param model .
     * @param flag  .
     * @return .
     */
    @RequestMapping
    public String gridBJ(Model model, int flag) {
        model.addAttribute("flag", flag);
        model.addAttribute("FLAG_BJ", Constants.PROJECT_QUERY_TAB_BJ);//报建记录显示需要特殊处理

        return "view/query/projectQuery/gridBJ";
    }

    /**
     * 获取列表数据--报建tab页
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param request  .
     */
    @RequestMapping
    public void gridDataCustomBJ(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            //改用sql查询
            String sql = projectManager.getProjectQuerySqlOfBJ(request);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslate.toString();
//            System.out.println("querySql = " + querySql);
            Page pageModel = new Page(page, rows, true);
            pageModel = shareProTobuildService.findBySql(pageModel, querySql, null);
            //供excel导出
            session.setAttribute(Constants.GRID_SQL_KEY, querySql);

            List list = pageModel.getRows();
            for (Object object : list) {
                Object[] objects = (Object[]) object;
                String bjbh = JspHelper.getString(objects[1]);
                if (!StringHelper.isEmpty(bjbh)) {
                    //工地数量和编号
                    List<ShareGdInfo> gdInfoList = projectManager.getGDInfoList(JspHelper.getString(bjbh));
                    if (gdInfoList.size() == 0) {
                        objects[8] = 0;
                        objects[9] = "";
                    } else if (gdInfoList.size() == 1) {
                        ShareGdInfo gdInfo = gdInfoList.iterator().next();
                        objects[8] = 1;
                        objects[9] = gdInfo.getGdCode();
                    } else {
                        objects[8] = gdInfoList.size();
                        objects[9] = "";
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

    /**
     * 列表显示页面--除报建之外的其他tab页
     *
     * @param model .
     * @param flag  .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, int flag) {
        model.addAttribute("flag", flag);
        model.addAttribute("FLAG_BJ", Constants.PROJECT_QUERY_TAB_BJ);//报建记录显示需要特殊处理

        return "view/query/projectQuery/grid";
    }

    /**
     * 获取列表数据--除报建之外的其他tab页
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param request  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            //改用sql查询
            String sql = projectManager.getProjectQuerySql(request);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslate.toString();
//            System.out.println("querySql = " + querySql);
            Page pageModel = new Page(page, rows, true);
            pageModel = shareProTobuildService.findBySql(pageModel, querySql, null);
            //供excel导出
            session.setAttribute(Constants.GRID_SQL_KEY, querySql);

            List list = pageModel.getRows();
            for (Object object : list) {
                Object[] objects = (Object[]) object;
                String bjbh = JspHelper.getString(objects[1]);
                if (!StringHelper.isEmpty(bjbh)) {
                    //工地数量和编号
                    List<ShareGdInfo> gdInfoList = projectManager.getGDInfoList(JspHelper.getString(bjbh));
                    if (gdInfoList.size() == 0) {
                        objects[9] = 0;
                        objects[10] = "";
                    } else if (gdInfoList.size() == 1) {
                        ShareGdInfo gdInfo = gdInfoList.iterator().next();
                        objects[9] = 1;
                        objects[10] = gdInfo.getGdCode();
                    } else {
                        objects[9] = gdInfoList.size();
                        objects[10] = "";
                    }

                    //总投资、总面积计算
//                    ExcelJdTasks excelJdTasksByFlowCode = relateManager.getExcelJdTasksByFlowCode(JspHelper.getString(objects[2]), JspHelper.getString(objects[1]));
//                    if(excelJdTasksByFlowCode != null){
//                        objects[6] = JspHelper.getString(excelJdTasksByFlowCode.getJagzl());
//                        objects[7] = JspHelper.getString(excelJdTasksByFlowCode.getBuildArea());
//                    }
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

    /**
     * 列表显示页面--除报建之外的其他tab页
     *
     * @param model .
     * @param flag  .
     * @return .
     */
    @RequestMapping
    public String gridAJ(Model model, int flag) {
        model.addAttribute("flag", flag);
        model.addAttribute("FLAG_BJ", Constants.PROJECT_QUERY_TAB_BJ);//报建记录显示需要特殊处理

        return "view/query/projectQuery/gridAJ";
    }

    /**
     * 获取列表数据--除报建之外的其他tab页--小型项目
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param request  .
     */
    @RequestMapping
    public void gridDataCustomAJ(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            //改用sql查询
            String sql = projectManager.getProjectQuerySqlAJ(request);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String querySql = queryTranslate.toString();
//            System.out.println("querySql = " + querySql);
            Page pageModel = new Page(page, rows, true);
            pageModel = shareProTobuildService.findBySql(pageModel, querySql, null);
            //供excel导出
            session.setAttribute(Constants.GRID_SQL_KEY, querySql);

            List list = pageModel.getRows();
            for (Object object : list) {
                Object[] objects = (Object[]) object;
                String bjbh = JspHelper.getString(objects[1]);
                if (!StringHelper.isEmpty(bjbh)) {
                    //工地数量和编号
                    List<ShareGdInfo> gdInfoList = projectManager.getGDInfoList(JspHelper.getString(bjbh));
                    if (gdInfoList.size() == 0) {
                        objects[9] = 0;
                        objects[10] = "";
                    } else if (gdInfoList.size() == 1) {
                        ShareGdInfo gdInfo = gdInfoList.iterator().next();
                        objects[9] = 1;
                        objects[10] = gdInfo.getGdCode();
                    } else {
                        objects[9] = gdInfoList.size();
                        objects[10] = "";
                    }

                    //总投资、总面积计算
//                    ExcelJdTasks excelJdTasksByFlowCode = relateManager.getExcelJdTasksByFlowCode(JspHelper.getString(objects[2]), JspHelper.getString(objects[1]));
//                    if(excelJdTasksByFlowCode != null){
//                        objects[6] = JspHelper.getString(excelJdTasksByFlowCode.getJagzl());
//                        objects[7] = JspHelper.getString(excelJdTasksByFlowCode.getBuildArea());
//                    }
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

    /**
     * 项目地图分布
     *
     * @param model   .
     * @param request .
     * @return .
     */
    @RequestMapping
    public String map(Model model, HttpServletRequest request) {
//        model.addAttribute("dangerTypes", hibernateService.findByQuery("select DISTINCT lb from SynGreatDanger order by LB"));
        model.addAttribute("monthsCN", new String[]{"一", "二", "三"});

        //街镇
        List<ProjectStreet> streets = projectStreetService.findAll();
        String polygonData = "[";
        for (ProjectStreet street : streets) {
            String color = !StringHelper.isEmpty(street.getColor()) ? street.getColor() : "#FF0000";
            polygonData += "{\"id\":" + street.getId() + ",\"name\":\"" + street.getStreetName() + "\",\"pointData\":" + street.getPointData() + ",\"color\":\"" + color + "\"},";
        }
        polygonData += "]";
        model.addAttribute("polygonData", polygonData);

        //项目类别--显示不同图标
        model.addAttribute("PROJECT_TYPE_UNLAWFUL", PROJECT_TYPE_UNLAWFUL);
        model.addAttribute("PROJECT_TYPE_HAS_VIDEO", PROJECT_TYPE_HAS_VIDEO);
        model.addAttribute("PROJECT_TYPE_NO_VIDEO", PROJECT_TYPE_NO_VIDEO);

        return "view/query/projectQuery/map";
    }

    /**
     * 项目地图分布
     *
     * @param model    .
     * @param response .
     * @param request  .
     */
    @RequestMapping
    public void getMapData(Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
//        String sqlHeader = " from share_pro_tobuild t" +
//                " left join project_extend pe on pe.bjbh=t.bjbh";
        String sqlHeader = " from excel_jd_tasks t" +
                " inner join project_extend pe on pe.bjbh=t.bjbh";
//                " inner join share_gd_info g on g.bjbh=t.bjbh";     //没有工地的项目不显示
        String sqlWhere = " where pe.pos_x is not null and pe.complete_date is null ";
//                " and g.gd_status_code in(" + projectManager.GD_STATUS_CODE_NOTCOMPLETE + ")";
//                " and trim(t.belong_area)='" + configManager.getProjectArea() + "'";

        //六无工地查询
        String sqlHeader6 = " from polling_unlawful_project t";
        String sqlWhere6 = " where t.pos_x is not null";

        //项目属地
        String proBelongArea = request.getParameter("proBelongArea");
        if (StringHelper.isNotEmpty(proBelongArea)) {  //项目属地
            sqlWhere += " and trim(pe.BELONG_AREA)='" + proBelongArea + "'";
            sqlWhere6 += " and trim(t.BELONG_AREA)='" + proBelongArea + "'";
        }

        //工程性质
        String typeId = request.getParameter("typeId");
        if (StringHelper.isNotEmpty(typeId)) {
            sqlWhere += " and t.property='" + typeId + "'";
        }

        //危险源类型
        String dangerType = request.getParameter("dangerType");
        if (StringHelper.isNotEmpty(dangerType)) {
            String currDateStr = new java.sql.Date(System.currentTimeMillis()).toString();
            sqlHeader += " inner join SYN_GREAT_DANGER sgd on sgd.GDBH=g.GD_CODE";
            sqlWhere += " and sgd.LB like '%" + dangerType + "%'" +
                    " and sgd.START_DATETIME<=to_date('" + currDateStr + "', 'yyyy-MM-dd')" +
                    " and sgd.END_DATETIME>=to_date('" + currDateStr + "', 'yyyy-MM-dd')";
        }

        //监督频率
        String frequency = request.getParameter("frequency");
        if (StringHelper.isNotEmpty(frequency)) {
            sqlHeader += " left join JD_RECORD pr on t.bjbh=pr.bjbh";
            String[] infos = frequency.split("_");
            Calendar currCal = Calendar.getInstance();
            currCal.add(Calendar.DATE, 1);
            Calendar lastCal = Calendar.getInstance();
            lastCal.add(Calendar.MONTH, -Integer.parseInt(infos[0]));
            if (Boolean.valueOf(infos[1])) {
                sqlWhere += " and pr.id is not null and";
            } else {
                sqlWhere += " and pr.id is null and (pr.jd_datetime is null or ";
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            sqlWhere += " pr.jd_datetime<to_date('" + dateFormat.format(currCal.getTime()) + "','yyyy-MM-dd')"
                    + " and pr.jd_datetime>to_date('" + dateFormat.format(lastCal.getTime()) + "','yyyy-MM-dd')";
            if (!Boolean.valueOf(infos[1])) {
                sqlWhere += ")";
            }
        }

        //建筑面积
        String totalArea = request.getParameter("totalArea");
        if (StringHelper.isNotEmpty(totalArea)) {
            String areaOperation = request.getParameter("area_operation");
            sqlWhere += " and t.BUILD_AREA" + areaOperation + totalArea;
        }

        //监督任务书编号
        String jdTaskCode = request.getParameter("jdTaskCode");
        if (StringHelper.isNotEmpty(jdTaskCode)) {
            sqlWhere += " and t.JD_TASK_CODE like '%" + jdTaskCode + "%'";
        }

        //报建编号
        String bjbh = request.getParameter("bjbh");
        if (StringHelper.isNotEmpty(bjbh)) {
            sqlWhere += " and t.bjbh like '%" + bjbh + "%'";
        }

        //项目名称
        String name = request.getParameter("name");
        if (StringHelper.isNotEmpty(name)) {
            sqlWhere += " and t.project_name like '%" + name + "%'";
            sqlWhere6 += " and t.project_name like '%" + name + "%'";
        }

        //建设单位
        String buildUnitName = request.getParameter("buildUnitName");
        if (StringHelper.isNotEmpty(buildUnitName)) {
            sqlWhere += " and t.JS_UNIT_NAME like '%" + buildUnitName + "%'";
            sqlWhere6 += " and t.BUILD_UNIT like '%" + buildUnitName + "%'";
        }

        //施工单位
        String sgUnitName = request.getParameter("sgUnitName");
        if (StringHelper.isNotEmpty(sgUnitName)) {
            sqlWhere += " and t.SG_UNIT_NAME like '%" + sgUnitName + "%'";
            sqlWhere6 += " and t.SG_UNIT like '%" + sgUnitName + "%'";
        }

        //在监项目查询
//        String sql = "select distinct t.bjbh,t.project_name as name,pe.pos_x as x,pe.pos_y as y,t.build_address as address,t.project_type as typeName,'"+PROJECT_TYPE_HAS_VIDEO+"' as type "+ sqlHeader + sqlWhere;
        String sql = "select distinct t.bjbh,t.project_name as name,pe.pos_X as x,pe.pos_Y as y,t.project_add as address,t.PROPERTY as typeName,'" + PROJECT_TYPE_HAS_VIDEO + "' as type " + sqlHeader + sqlWhere;

        //六无工地查询
        String lwgdSql = "select id||'' as bjbh,t.project_name as name,t.pos_x as x,t.pos_y as y,t.build_address as address,'六无工地' as typeName,'" + PROJECT_TYPE_UNLAWFUL + "'  as type " + sqlHeader6 + sqlWhere6;

        sql += " union " + lwgdSql;
//        sql += " order by t.bjbh asc";
        System.out.println("sql = " + sql);

        List<Map> list = simpleQueryManager.getMapList(sql);
//        System.out.println("list.size() = " + list.size());

        String majorSql = "SELECT T. bjbh, T .project_name AS NAME,  T .pos_x AS x, T .pos_y AS y, T .PROJECT_ADD AS address,  '2' AS TYPE " +
                " FROM Project_Major T " +
                "  WHERE  T .pos_x IS NOT NULL ";
        List<Map> projectMajors = simpleQueryManager.getMapList(majorSql);
        Map<String, Map> majorMap = new HashMap<String, Map>();
        Set<String> majorSet = new HashSet<String>();
        Set<String> majorUsed = new HashSet<String>();
        for (Map bean : projectMajors) {
            majorMap.put(String.valueOf(bean.get("BJBH")), bean);
            majorSet.add(String.valueOf(bean.get("BJBH")));
        }
        for (Map bean : list) {
            Object bjbhM = bean.get("BJBH");
            String typeName = JspHelper.getString(bean.get("TYPENAME"));   //区分六无工地还是普通工地
            if (bjbhM != null && StringHelper.isNotEmpty((String) bjbhM)) {
                if (majorSet.contains(bjbhM)) {
                    String sq = "from ProjectMajor where bjbh='" + String.valueOf(bjbhM) + "'";
                    List<ProjectMajor> major = projectMajorService.findByQuery(sq);
                    if (null != major) {
                        majorUsed.add((String) bjbhM);
                        ProjectMajor p = major.iterator().next();
                        bean.put("X", p.getPosX());
                        bean.put("Y", p.getPosY());
                    }
                    bean.put("isMajor", true);
                } else {
                    bean.put("isMajor", false);
                }
                if (!StringHelper.isEmpty(typeName) && "六无工地".equals(typeName)) {
                    bean.put("isUnlawFul", true);
                } else {
                    bean.put("isUnlawFul", false);
                }
//                //工地数量--暂以另外字段作为载体输出
//                List<ShareGdInfo> gdInfoList = projectManager.getGDInfoList(JspHelper.getString(bjbhM));
//                if (gdInfoList.size() == 1) {
//                    ShareGdInfo gdInfo = gdInfoList.iterator().next();
//                    bean.put("gdCount", 1);
//                    bean.put("gdCode", gdInfo.getGdCode());
//                } else {
//                    bean.put("gdCount", gdInfoList.size());
//                    bean.put("gdCode", "");
//                }
            }
        }
        for (String set : majorSet) {
            for (String userd : majorUsed) {
                 if(!set.equals(userd)){
                     Map map = majorMap.get(set);
                     map.put("isMajor", true);
                     map.put("TYPENAME", "重大工程");
                     map.put("isUnlawFul", false);
                     list.add(map);
                 }
            }
        }

        JSONSerializer serializer = new JSONSerializer();
//        System.out.println("serializer.serialize(list) = " + serializer.serialize(list));
        sendJSON(response, serializer.serialize(list));
    }

    /**
     * 查看页面--先选择工地
     *
     * @param model .
     * @param bjbh  .
     * @return .
     */
    @RequestMapping
    public String viewSelect(Model model, String bjbh, String jdTaskCode) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);
        model.addAttribute("jdTaskCode", JspHelper.getString(jdTaskCode));

        model.addAttribute("list", projectManager.getGDInfoList(JspHelper.getString(bjbh)));

        return "view/query/projectQuery/viewSelect";
    }

    /**
     * 项目详细页面--同时提供给其他模块调用
     *
     * @param model      .
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ExcelJdTasks jdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
        if (jdTasks != null) {
            bjbh = jdTasks.getBjbh();
        }

        model.addAttribute("bjbh", JspHelper.getString(bjbh));
        model.addAttribute("gdCode", JspHelper.getString(gdCode));
        model.addAttribute("jdTaskCode", JspHelper.getString(jdTaskCode));
        model.addAttribute("param", "bjbh=" + bjbh + "&gdCode=" + gdCode + "&jdTaskCode=" + jdTaskCode);

        return "view/query/projectQuery/view";
    }

    /**
     * 1、查看项目概况
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewProject(Model model, String bjbh, String jdTaskCode) {
        if (!StringHelper.isEmpty(jdTaskCode)) {
            model.addAttribute("bean", projectManager.getProjectInfoByJdTaskCode(jdTaskCode));

        }else{
            ExcelJdTasks jdTasks = excelJdTasksManager.getDefaultExcelJdTasks(bjbh);
            if(jdTasks != null){
                model.addAttribute("bean",projectManager.getProjectInfoByJdTaskCode(jdTasks.getJdTaskCode()));
            }else{
                model.addAttribute("bean", projectManager.getAllProjectInfo(null, bjbh));
            }
        }
//        model.addAttribute("projectMsg", getProjectStatusMsg(bjbh, null));

        return "view/query/projectQuery/viewProject";
    }

    /**
     * 2、查看建设程序
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewBuild(Model model, String bjbh) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        model.addAttribute("list", relateManager.getShareProSgPermitList(bjbh));
        return "view/query/projectQuery/viewBuild";
    }

    /**
     * 3、查看承发包
     *
     * @param bjbh   .
     * @param gdCode .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String viewCfb(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        if (!StringHelper.isEmpty(jdTaskCode)) {
            Set<Map<String, Object>> kcList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> sjList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> jlList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> sgList = new HashSet<Map<String, Object>>();

            if (!StringHelper.isEmpty(jdTaskCode)) {
                List<ShareProDwgcMonitor> monitorList = relateManager.getShareProDwgcMonitorList(jdTaskCode);
                for (ShareProDwgcMonitor monitor : monitorList) {
                    getcfbList(kcList, monitor, Constants.BID_UNIT_TYPE_KC);
                    getcfbList(sjList, monitor, Constants.BID_UNIT_TYPE_SJ);
                    getcfbList(jlList, monitor, Constants.BID_UNIT_TYPE_JL);
                    getcfbList(sgList, monitor, Constants.BID_UNIT_TYPE_SG);
                }
            }
            model.addAttribute("kcList", kcList);
            model.addAttribute("sjList", sjList);
            model.addAttribute("jlList", jlList);
            model.addAttribute("sgList", sgList);

            return "view/query/projectQuery/viewCfb";


        } else {
            //kc、sj、jl、sg
            Set kcSet = new HashSet();
            Set sjSet = new HashSet();
            Set jlSet = new HashSet();
            Set sgSet = new HashSet();
            kcSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_KC, gdCode));
            sjSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_SJ, gdCode));
            jlSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_JL, gdCode));
            sgSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_SG, gdCode));
            model.addAttribute("kcList", kcSet);
            model.addAttribute("sjList", sjSet);
            model.addAttribute("jlList", jlSet);
            model.addAttribute("sgList", sgSet);

            return "view/query/projectQuery/viewCfb";
        }
    }

    private void getcfbList(Set<Map<String, Object>> retList, ShareProDwgcMonitor monitor, String type) {
        Map<String, Object> map = new HashMap<String, Object>();
        String unitCode = monitor.getSgUnitCode();
        String unitName = monitor.getSgUnitName();
        if (Constants.BID_UNIT_TYPE_KC.equals(type)) {
            unitCode = monitor.getKcUnitCode();
            unitName = monitor.getKcUnitName();
        } else if (Constants.BID_UNIT_TYPE_SJ.equals(type)) {
            unitCode = monitor.getSjUnitCode();
            unitName = monitor.getSjUnitName();
        } else if (Constants.BID_UNIT_TYPE_JL.equals(type)) {
            unitCode = monitor.getJlUnitCode();
            unitName = monitor.getJlUnitName();
        } else if (Constants.BID_UNIT_TYPE_SG.equals(type)) {
            map.put("PRO_HEADER", monitor.getSgUnitManager());
            map.put("PRO_HEADER_CARD", monitor.getSgUnitManagerCode());
            map.put("PRO_HEADER_PHONE", monitor.getSgUnitPhone());
        }
        map.put("CB_UNIT", unitName);

        ShareProContract contract = relateManager.getShareProContract(monitor.getBjbh(), unitCode);
        if (contract != null) {
            map.put("ZB_TYPE", contract.getCbTypeName());
            map.put("BID_DATE", contract.getAcceptTime());
            map.put("SIGN_DATE", "");
            map.put("EXPIRE_DATE", "");
            map.put("BEGIN_DATE", "");
            map.put("END_DATE", "");
            if (!Constants.BID_UNIT_TYPE_SG.equals(type)) {
                map.put("PRO_HEADER", contract.getProHeader());
                map.put("PRO_HEADER_CARD", contract.getProHeaderCard());
                map.put("PRO_HEADER_PHONE", contract.getProHeaderPhone());
            }

            if (Constants.BID_UNIT_TYPE_KC.equals(type)) {
                map.put("KC_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_SJ.equals(type)) {
                map.put("SJ_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_JL.equals(type)) {
                map.put("JL_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_SG.equals(type)) {
                map.put("SG_FEE", contract.getContMoney());
            }
        }
        if (unitName != null && !"".equals(unitName) && !"无".equals(unitName))
            retList.add(map);
    }

    /**
     * 4、查看施工分包
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewSgfb(Model model, String bjbh) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        model.addAttribute("list", relateManager.getShareProContractList(bjbh));
        return "view/query/projectQuery/viewSgfb";
    }

    /**
     * 5、查看单位工程
     *
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String viewUnit(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        //如果有监督任务书编号的参数，那么只显示监督任务书的单位工程，否则根据报建编号取单位工程
        model.addAttribute("jdTaskCode", JspHelper.getString(jdTaskCode));
        model.addAttribute("list", relateManager.getShareGdDwgcMapList(bjbh, gdCode, jdTaskCode));
        return "view/query/projectQuery/viewUnit";
    }


    /**
     * 6、查看管理人员
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewPerson(Model model, String bjbh) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);


        return "view/query/projectQuery/viewPerson";
    }

    /**
     * 7、查看监管情况
     *
     * @param model      .
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String viewMonitor(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        //监督记录
        List jdRecordList = relateManager.getJdRecordList(bjbh, jdTaskCode);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (Object object : jdRecordList) {
            map = new HashMap<String, Object>();
            Map map1 = (Map) object;
            map.put("code", JspHelper.getString(map1.get("CODE")));  //监督编号
            String JdDateTime = JspHelper.getString(map1.get("JD_DATETIME")); //监督日期
            map.put("jdDateTime", JspHelper.getTimestamp(JdDateTime));
            map.put("jdManagerName", JspHelper.getString(map1.get("JD_MANAGER_NAME"))); //监督人员
            String jdTypeCode = JspHelper.getString(map1.get("JDTYPECODE"));
            map.put("jdType", getjdType(jdTypeCode));  //监督类型
            map.put("jdTypeCode", jdTypeCode);//监督code
            map.put("id", JspHelper.getString(map1.get("ID")));//id
            String id = JspHelper.getString(map1.get("ID"));
            //监督记录附件
            DocDocument docDocument = getJdRecodDoc(id, jdTypeCode);
            map.put("doc", documentManager.getDownloadButton(docDocument));
            //整改指令单
            List<JdStopOrder> jdStopReformLists = getJdStopOrder("reform", jdTypeCode, id);
            String jdStopReform = "";
            if (null != jdStopReformLists) {
                for (JdStopOrder jdStopOrder : jdStopReformLists) {
                    jdStopReform += jdStopOrder.getSignDate();
                }
            }
            map.put("jdStopReform", jdStopReform);  //整改指令单
            //暂缓施工指令单
            List<JdStopOrder> jdStopSuspendLists = getJdStopOrder("suspend", jdTypeCode, id);
            String jdStopSuspend = "";
            if (null != jdStopSuspendLists) {
                for (JdStopOrder jdStopOrder : jdStopSuspendLists) {
                    jdStopSuspend += jdStopOrder.getSignDate();
                }
            }
            map.put("jdStopSuspend", jdStopSuspend); //暂缓施工指令单
            //创建停工单
            List<JdStopOrder> jdStopStopLists = getJdStopOrder("stop", jdTypeCode, id);
            String jdStopStop = "";
            if (null != jdStopStopLists) {
                for (JdStopOrder jdStopOrder : jdStopStopLists) {
                    jdStopStop += jdStopOrder.getSignDate();
                }
            }
            map.put("jdStopStop", jdStopStop);  //停工指令单
            list.add(map);
        }
        model.addAttribute("list", list);

        //监督预约
        if (!"".equals(jdTaskCode) && jdTaskCode != null) {
            String hql = "from OrderFormDeploy where 1=1 and orderForm.jdTaskCode = '{0}' ";
            //外网项目用户和工地用户只能查看本项目范围的记录
            SysRegPerson regPerson = regPersonManager.getRegPerson();
            if (regPerson != null) {
                String currentBjbh = regPersonManager.getBjbh(regPerson);
                if (!StringHelper.isEmpty(currentBjbh)) {
                    SysUser sysUser = sysUserManager.getSysUser();
                    hql += " and ((orderForm.jdTaskCode is not null and orderForm.jdTaskCode in(select jdTaskCode from ExcelJdTasks where bjbh='" + currentBjbh + "')) or orderForm.createUser='" + sysUser.getLoginName() + "')";
                } else {
                    hql += " and 1=2";
                }
            }
            hql += " order by  acceptDatetime desc";
            List<OrderFormDeploy> orderFormDeployList = orderFormDeployService.findByQuery(FormatUtils.format(hql, jdTaskCode));
            List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
            if (orderFormDeployList.size() > 0) {
                for (OrderFormDeploy orderFormDeploy : orderFormDeployList) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    if (orderFormDeploy.getOrderForm().getFormDoc() != null) {
                        Long docId = orderFormDeploy.getOrderForm().getFormDoc().getId();
                        if (docId != null && org.hibernate.util.StringHelper.isNotEmpty(docId.toString())) {
                            m.put("doc", documentManager.getDownloadButton(JspHelper.getLong(docId)));
                        }
                    }
                    SysCodeDetail sysCodeDetail = orderFormDeploy.getAcceptOpinion();
                    if (sysCodeDetail != null) {
                        if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE))
                            m.put("acceptOpinion", "安排监督");
                        else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_NOTARRANGE))
                            m.put("acceptOpinion", "不安排监督");
                        else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_BACK))
                            m.put("acceptOpinion", "退回");
                        else
                            m.put("acceptOpinion", null);
                    } else
                        m.put("acceptOpinion", null);
                    m.put("acceptDatetime", orderFormDeploy.getAcceptDatetime());
                    m.put("jdTaskCode", jdTaskCode);
                    m.put("orderFormId", orderFormDeploy.getOrderForm().getId());
                    m.put("orderCode", orderFormDeploy.getOrderForm().getOrderCode());
                    m.put("orderDatetime", orderFormDeploy.getOrderForm().getOrderDatetime());
                    if (orderFormDeploy.getOrderForm().getOrderStatus() != null) {
                        m.put("orderStatus", Constants.ORDER_FORM_STATUS_ACCEPT.equals(orderFormDeploy.getOrderForm().getOrderStatus().getCode()) ? "已受理" : "未受理");
                    }
                    m.put("projectName", orderFormDeploy.getOrderForm().getProjectName());
                    m.put("workGroup", orderFormDeploy.getWorkGroup() == null ? "" : orderFormDeploy.getWorkGroup().getName());
                    list1.add(m);
                }
            }
            model.addAttribute("list1", list1);
        }

        //监督计划
        Map<String, Object> mapp;
        List<PlanDetail> planDetails = projectManager.getPlanDetailByJdTaskCode(jdTaskCode, bjbh);
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        for (PlanDetail planDetail : planDetails) {
            mapp = new HashMap<String, Object>();
            mapp.put("jdTaskCode", planDetail.getJdTaskCode());
            mapp.put("bjbh", planDetail.getBjbh());
            mapp.put("planDetail", planDetail);

            Map<String, Object> allProjectInfo = projectManager.getAllProjectInfo(planDetail.getJdTaskCode(), planDetail.getBjbh());
            mapp.put("jdrwsbh", JspHelper.getString(allProjectInfo.get("jdrwsbh")));
            mapp.put("projectName", JspHelper.getString(allProjectInfo.get("projectName")));
            mapp.put("jdDatetime", allProjectInfo.get("jdDatetime"));

            list2.add(mapp);
        }
        model.addAttribute("list2", list2);

//        //招投标监管记录
//        List<ScjgBidRecord> bidRecords = scjgBidRecordService.findByQuery("from ScjgBidRecord where bjbh=? order by id asc",bjbh);
//        for (ScjgBidRecord bidRecord : bidRecords) {
//            bidRecord.setDealOpinion(ScjgBidRecordStatus.getNameByCode(bidRecord.getStatus()));
//        }
//        model.addAttribute("bidRecordList",bidRecords);

        //是否外网用户
        SysUser user = sysUserManager.getSysUser();
        if (user != null && user.getRegPerson() != null) {
            model.addAttribute("siteUser", true);
        } else {
            model.addAttribute("siteUser", false);
        }
        return "view/query/projectQuery/viewMonitor";
    }

    /**
     * 8、查看行政处罚
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewPunish(Model model, String bjbh) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        model.addAttribute("bean", data);

        model.addAttribute("list", relateManager.getSharePunishCaseList(bjbh));
        return "view/query/projectQuery/viewPunish";
    }

    /**
     * 9、查看现场视频
     *
     * @param bjbh   .
     * @param gdCode .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String viewVideo(Model model, String bjbh, String gdCode) {
        model.addAttribute("bjbh", bjbh);
        model.addAttribute("gdCode", gdCode);
        return "view/query/projectQuery/viewVideo";
    }

    /**
     * 看现场视频页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewVideoMonitor(Model model, String bjbh, String gdCode) throws Exception_Exception {
        model.addAttribute("bjbh", bjbh);
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("gdList", projectManager.getGDInfoList(bjbh));

        MonitorParam monitorParam = new MonitorParam();
        monitorParam.setGdbh(gdCode);
        if (StringHelper.isNotEmpty(gdCode)) {
            model.addAttribute("monitors", monitorWebServiceClient.getMonitorList(monitorParam));
        }
        return "view/query/projectQuery/viewVideoMonitor";
    }

    @RequestMapping
    public void getMonitorServiceByGuid(Model model, HttpServletResponse response, String guid) throws Exception_Exception {
        MonitorService monitorService = monitorWebServiceClient.getMonitorService(guid);
        sendJSON(response, new JSONSerializer().exclude("*.class").serialize(monitorService));
    }

    /**
     * 获取项目状态
     *
     * @param bjbh       .
     * @param jdTaskCode .
     * @return .
     */
    private String getProjectStatusMsg(String bjbh, String jdTaskCode) {
//        logger.debug("bjbh = " + bjbh);
//        logger.debug("flowCode = " + flowCode);
        String msg = "";
        if (StringHelper.isEmpty(jdTaskCode)) {
            msg = "<font color=red>该项目还未分配流转编号，</font>";
        } else {
            msg = "<font color=blue>该项目已分配流转编号，</font>";
        }
//        String hql = "from ShareProDwgcMonitor where bjbh='{0}' and jdrwsbh is not null order by id desc";
//        List<ShareProDwgcMonitor> dwgcList = shareProDwgcMonitorService.findByQuery(FormatUtils.format(hql, bjbh));
//        if (dwgcList.size() == 0) {
        String hql = "from ExcelJdTasks where bjbh=? and jdTaskCode is not null";
//        if(excelJdTasksService.findByQuery(hql,bjbh).size()==0){
//            msg += "<font color=red>还未分配监督任务书编号。</font>";
//        } else {
//            msg += "<font color=blue>已分配监督任务书编号。</font>";
//        }
        return msg;
    }

    /**
     * 10、查看企业上报信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewCompany(Model model, String bjbh) {
        model.addAttribute("bjbh", bjbh);

        return "view/query/projectQuery/viewCompany";
    }

    /**
     * 查看监督类型
     *
     * @param jdTypeCode .
     * @return .
     */
    private String getjdType(String jdTypeCode) {
        if (jdTypeCode.equals("first")) {
            return "首次监督";
        } else if (jdTypeCode.equals("safe")) {
            return "过程安全监督";
        } else if (jdTypeCode.equals("quality")) {
            return "过程质量监督";
        } else if (jdTypeCode.equals("complete")) {
            return "竣工验收监督";
        } else {
            return null;
        }
    }

    /**
     * 监督记录附件
     *
     * @param id
     * @param jdTypeCode .
     * @return .
     */
    private DocDocument getJdRecodDoc(String id, String jdTypeCode) {
        if (jdTypeCode.equals("first")) {
            JdRecordFirst jdRecordFirst = jdRecordFirstService.get(JspHelper.getLong(id));
            return jdRecordFirst.getDocument();
        } else if (jdTypeCode.equals("safe")) {
            JdRecordSafe jdRecordSafe = jdRecordSafeService.get(JspHelper.getLong(id));
            return jdRecordSafe.getDocument();
        } else if (jdTypeCode.equals("quality")) {
            JdRecordQuality jdRecordQuality = jdRecordQualityService.get(JspHelper.getLong(id));
            return jdRecordQuality.getDocument();
        } else if (jdTypeCode.equals("complete")) {
            JdRecordComplete jdRecordComplete = jdRecordCompleteService.get(JspHelper.getLong(id));
            return jdRecordComplete.getDocument();
        } else {
            return null;
        }
    }

    /**
     * 三大整改单数据
     *
     * @param type
     * @param recordId
     * @param jdTypeCode .
     * @return .
     */
    private List<JdStopOrder> getJdStopOrder(String type, String jdTypeCode, String recordId) {
        int id = JspHelper.getInteger(recordId);
        String hql = "from JdStopOrder where formCode='{0}'and jdTypeCode='{1}' and recordId=" + id;
        hql = FormatUtils.format(hql, type, jdTypeCode);
        List<JdStopOrder> jdStopOrderList = jdStopOrderService.findByQuery(hql);
        if (jdStopOrderList.size() > 0) {
            return jdStopOrderList;
        } else {
            return null;
        }
    }
}
