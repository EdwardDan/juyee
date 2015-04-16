package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.projectInfo.CustomProjectInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.MathHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取项目和工地信息
 * User: Chen Junping
 * Date: 12-3-19
 */
@Service
public class ProjectManager {
    private Logger logger = LoggerFactory.getLogger(ProjectManager.class);

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private ShareGdInfoService shareGdInfoService;

    @Autowired
    private ShareUnitInfoService shareUnitInfoService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private PlanDetailService planDetailService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    //项目过滤条件（关联工地状态）
    public final String GD_STATUS_CODE_NOTCHECK = "5";          //完工未验项目
    public final String GD_STATUS_CODE_MONITORING = "1,2";     //在监项目
    public final String GD_STATUS_CODE_NOTCOMPLETE = "1,2,5";  //未完工的全部项目

    //获取行政区域编码，如HK、SJ、JA等
    public String getProjectAreaCode(){
        return configManager.getProjectAreaCode().toUpperCase();
    }

    /**
     * 获取报建项目信息(by bjbh)
     *
     * @param bjbh .
     * @return .
     */
    public ShareProTobuild getProject(String bjbh) {
        if (!StringHelper.isEmpty(bjbh)) {
            return shareProTobuildService.findUniqueByProperty("bjbh", bjbh);
        }
        return null;
    }

    /**
     * 根据报建编号获取项目信息
     *
     * @param bjbh .
     * @return .
     */
    public CustomProjectInfo getProjectInfoByBjbh(String bjbh) {
        CustomProjectInfo data = new CustomProjectInfo();
        ShareProTobuild project = getProject(bjbh);
        if (project != null) {
            data.setBjbh(project.getBjbh());
            data.setBjDate(JspHelper.getString(project.getBjDate()));
            data.setProjectName(project.getProjectName());
            data.setProjectType(project.getProjectType());
            data.setProjectProperty(project.getProjectProperty());
            data.setBuildAddress(project.getBuildAddress());
            data.setBuildProperty(project.getBuildProperty());
            data.setBuildScale(project.getBuildScale());
            data.setBelongArea(project.getBelongArea());
            data.setLxFileCode(project.getLxFileCode());
            data.setTotalArea(JspHelper.getDouble(project.getTotalArea()));
            data.setTotalAreaDesc(MathHelper.formatCurrency(JspHelper.getDouble(project.getTotalArea()), 2) + " ㎡");
            data.setTotalInvestment(JspHelper.getDouble(project.getTotalInvestment()));
            data.setTotalInvestmentDesc(MathHelper.formatCurrency(JspHelper.getDouble(project.getTotalInvestment()), 2) + " 万元");
            data.setStructureForm(project.getStructureForm());
            data.setApprovalDept(project.getApprovalUnit());
            data.setApprovalDate(JspHelper.getString(project.getApprovalDate()));
            data.setJsdwmc(project.getBuildUnitName());
            data.setJsdwFr(project.getBuildUnitLegal());
            data.setJsdwLxr(project.getBuildUnitLinkman());
            data.setJsdwTel(project.getBuildUnitTel());
            data.setJsdwZipcode(project.getBuildUnitZipcode());
            data.setJsdwAddress(project.getBuildUnitAddress());
//            data.setSgdwmc(project.getBjbh());
//            data.setSgdwLxr(project.getBjbh());
//            data.setSgdwTel(project.getBjbh());
//            data.setSgzbdwmc(project.getBjbh());
//            data.setSgzbdwLxr(project.getBjbh());
//            data.setSgzbdwTel(project.getBjbh());
//            data.setJldwmc(project.getBjbh());
//            data.setJldwLxr(project.getBjbh());
//            data.setJldwTel(project.getBjbh());
//            data.setKcdwmc(project.getBjbh());
//            data.setKcdwLxr(project.getBjbh());
//            data.setKcdwTel(project.getBjbh());
//            data.setSjdwmc(project.getBjbh());
//            data.setSjdwLxr(project.getBjbh());
//            data.setSjdwYel(project.getBjbh());
//            data.setBjbh(project.getBjbh());
//            data.setJdTaskCode(project.getBjbh());

            //单体数量
            List<Map<String, Object>> shareGdDwgcMapList = relateManager.getShareGdDwgcMapList(bjbh, null, null);
            data.setDtsl(shareGdDwgcMapList.size());

//            ShareProDwgcMonitor dwgcMonitor = relateManager.getShareProDwgcMonitor(jdTaskCode);
//            if (dwgcMonitor != null) {
//                ShareProContract kcdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getKcUnitCode());
//                map.put("kcdwmc", dwgcMonitor.getKcUnitName());
//                map.put("kcdw_fzr", kcdw.getProHeader());
//                map.put("kcdw_tel", kcdw.getProHeaderPhone());
//
//                ShareProContract sjdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getSjUnitCode());
//                map.put("sjdwmc", dwgcMonitor.getSjUnitName());
//                map.put("sjdw_fzr", sjdw.getProHeader());
//                map.put("sjdw_tel", sjdw.getProHeaderPhone());
//
//                ShareProContract jldw = relateManager.getShareProContract(bjbh, dwgcMonitor.getJlUnitCode());
//                map.put("jldwmc", dwgcMonitor.getJlUnitName());
//                map.put("jldw_fzr", jldw.getProHeader());
//                map.put("jldw_tel", jldw.getProHeaderPhone());
//
//                ShareProContract sgdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getSgUnitCode());
//                map.put("sgdwmc", dwgcMonitor.getSgUnitName());
//                map.put("sgdw_fzr", sgdw.getProHeader());
//                map.put("sgdw_tel", sgdw.getProHeaderPhone());
//            }
        }
        return data;
    }

    /**
     * 根据监督任务书编号获取工程信息
     *
     * @param jdTaskCode .
     * @return .
     */
    public CustomProjectInfo getProjectInfoByJdTaskCode(String jdTaskCode) {
        CustomProjectInfo data = new CustomProjectInfo();
        ExcelJdTasks excelJdTasks = getExcelJdTasks(jdTaskCode);
        if (excelJdTasks != null) {
//            ShareProTobuild project = getProject(excelJdTasks.getBjbh());
            ExcelJdDwgc excelJdDwgc = getExcelJdDwgc(jdTaskCode);
            if (excelJdDwgc != null) {
                data.setProjectType(excelJdDwgc.getProjectType());
            }
            data.setBjbh(excelJdTasks.getBjbh());
            data.setBjDate(JspHelper.getString(new Date(excelJdTasks.getJdDatetime().getTime())));
            data.setProjectName(excelJdTasks.getProjectName());
//            data.setProjectProperty(project.getProjectProperty());
            data.setBuildAddress(excelJdTasks.getProjectAdd());
//            data.setBuildProperty(excelJdTasks.getBuildProperty());
//            data.setBuildScale(excelJdTasks.getBuildScale());
            data.setBelongArea(excelJdTasks.getBelongArea());
//            data.setLxFileCode(excelJdTasks.getLxFileCode());
            data.setTotalArea(JspHelper.getDouble(excelJdTasks.getBuildArea()));
            data.setTotalAreaDesc(MathHelper.formatCurrency(JspHelper.getDouble(excelJdTasks.getBuildArea()), 2) + " ㎡");
            data.setTotalInvestment(JspHelper.getDouble(excelJdTasks.getContMoney()));
            data.setTotalInvestmentDesc(MathHelper.formatCurrency(JspHelper.getDouble(excelJdTasks.getContMoney()), 2) + " 万元");
//            data.setStructureForm(excelJdTasks.getStructureForm());
//            data.setApprovalDept(excelJdTasks.getApprovalUnit());
//            data.setApprovalDate(excelJdTasks.getApprovalDate());
            if (null != excelJdTasks.getDtsl()) {
                data.setDtsl(excelJdTasks.getDtsl());
            }

            data.setJsdwmc(excelJdTasks.getJsUnitName());
            data.setJsdwLxr(excelJdTasks.getJsLinkman());
            data.setJsdwTel(excelJdTasks.getJsPhone());
            data.setJsdwAddress(excelJdTasks.getJsUnitAdd());
//            data.setJsdwFr(excelJdTasks.getJsLinkman());
//            data.setJsdwZipcode(excelJdTasks.getBuildUnitZipcode());

            data.setSgdwmc(excelJdTasks.getSgUnitName());
            data.setSgdwLxr(excelJdTasks.getSgLinkman());
            data.setSgdwTel(excelJdTasks.getSgPhone());

            data.setSgzbdwmc(excelJdTasks.getSgzbUnitName());
            data.setSgzbdwLxr(excelJdTasks.getSgzbLinkman());
            data.setSgzbdwTel(excelJdTasks.getSgzbPhone());

            data.setJldwmc(excelJdTasks.getJlUnitName());
            data.setJldwLxr(excelJdTasks.getJlLinkman());
            data.setJldwTel(excelJdTasks.getJlPhone());

            data.setKcdwmc(excelJdTasks.getKcUnitName());
            data.setKcdwLxr(excelJdTasks.getKcLinkman());
            data.setKcdwTel(excelJdTasks.getKcPhone());

            data.setSjdwmc(excelJdTasks.getSjUnitName());
            data.setSjdwLxr(excelJdTasks.getSjLinkman());
            data.setSjdwTel(excelJdTasks.getSjPhone());

            data.setBjbh(excelJdTasks.getBjbh());
            data.setJdTaskCode(excelJdTasks.getJdTaskCode());
        }
        return data;
    }

    /**
     * 获取工程信息--简单信息
     *
     * @param bjbh .
     * @return .
     */
    public Map<String, Object> getProjectInfo(String bjbh) {
        Map<String, Object> map = new HashMap<String, Object>();
        ShareProTobuild project = getProject(bjbh);
        if (project != null) {
            map.put("data", project);
        }
//        ProBelongArea belongArea = relateManager.getProBelongArea(bjbh);
//        if (belongArea != null) {
//            map.put("belongArea", belongArea.getBelongArea().getName());
//        }
//        ProType proType = relateManager.getProType(bjbh);
//        if (proType != null) {
//            map.put("property", proType.getType().getName());
//        }
        return map;
    }

    /**
     * 获取工程详细信息 ExcelJdTasks
     *
     * @param jdTaskCode .
     * @return .
     */
    public ExcelJdTasks getExcelJdTasks(String jdTaskCode) {
        List<ExcelJdTasks> list = excelJdTasksService.findByQuery("from ExcelJdTasks where jdTaskCode='" + jdTaskCode + "' order by jdTaskCode asc");
        if (null != list && list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 获取工程详细信息 ExcelJdTasks
     *
     * @param jdTaskCode .
     * @return .
     */
    public ExcelJdDwgc getExcelJdDwgc(String jdTaskCode) {
        List<ExcelJdDwgc> list = excelJdDwgcService.findByQuery("from ExcelJdDwgc where jdTaskCode='" + jdTaskCode + "' order by jdTaskCode asc");
        if (null != list && list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 获取企业信息
     *
     * @param unitCode .
     * @return .
     */

    public ShareUnitInfo getUnitInfo(String unitCode) {
        String hql = "from ShareUnitInfo where unitCode='{0}'";
        List<ShareUnitInfo> list = shareUnitInfoService.findByQuery(FormatUtils.format(hql, unitCode));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取工地信息
     *
     * @param bjbh   .
     * @param gdCode .
     * @return map
     */
    public ShareGdInfo getGDInfo(String bjbh, String gdCode) {
        String hql = "from ShareGdInfo where bjbh='{0}'";
        if (!StringHelper.isEmpty(gdCode)) {
            hql += " and gdCode='{1}'";
        }
        List<ShareGdInfo> list = shareGdInfoService.findByQuery(FormatUtils.format(hql, bjbh, gdCode));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取工地信息
     *
     * @param gdCode .
     * @return map
     */

    public ShareGdInfo getGDInfo(String gdCode) {
        String hql = "from ShareGdInfo where gdCode='{0}'";
        List<ShareGdInfo> list = shareGdInfoService.findByQuery(FormatUtils.format(hql, gdCode));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 根据报建编号获取工地列表
     *
     * @param bjbh .
     * @return .
     */
    public List<ShareGdInfo> getGDInfoList(String bjbh) {
        return shareGdInfoService.findByQuery("from ShareGdInfo where bjbh='" + bjbh + "' order by gdCode asc");
    }
    /**
     * 根据监督任务书编号和工地编号获取工地信息
     *
     * @param gdCode   .
     * @param jdTaskCode .
     * @return .
     */
    public Map<String, Object> getGdInfoByJdTaskCode(String gdCode, String jdTaskCode) {
        String sql = "select f.jd_task_code,t.gd_code,t.bjbh,t.gd_name,t.sg_total_unit_name,f.project_name,f.belong_area,f.js_unit_name as build_unit_name from share_gd_info t \n" +
                "inner join excel_jd_tasks f on t.bjbh=f.bjbh\n" +
                "where t.gd_status_code in({0}) and t.gd_code='{1}' and f.jd_task_code='{2}'";
        sql = FormatUtils.format(sql, GD_STATUS_CODE_NOTCOMPLETE, gdCode, jdTaskCode);
//        System.out.println("sql = " + sql);
        List mapList = simpleQueryManager.getMapList(sql);
        if (mapList.size() > 0) {
            return (Map<String, Object>) mapList.iterator().next();
        }
        return new HashMap<String, Object>();
    }
    /**
     * 获取报建项目查询sql
     *
     * @param request .
     * @return .
     */
    public String getProjectQuerySqlOfBJ(HttpServletRequest request) {
        int flag = Integer.valueOf(request.getParameter("flag"));
        //注意：流转编号显示会造成重复记录（由于1个bjbh可能对应多个流转编号）
        String sql = "select distinct t.bjbh||s.name as id,t.bjbh,t.project_name,t.build_address,s.name,t.total_Investment,t.total_Area,t.bj_Date" +
                ",'' as gdCount,'' as gdCode" +
                ",t.build_unit_name" +
                " from share_pro_tobuild t" +
                " left join Pro_Type p on t.bjbh=p.bjbh" +
                " left join sys_code_detail s on p.type_id=s.id" +
                " left join share_gd_info g on t.bjbh=g.bjbh" +
                " left join share_pro_jl_info j on t.bjbh=j.bjbh " +
                " left Join PROJECT_EXTEND pro on pro.bjbh= t.bjbh" +
                " where trim(t.belong_area)='{0}' " +
                " and pro.complete_date is null ";

        if (Constants.PROJECT_QUERY_TAB_BJ == flag) {      //报建项目
//            sql += " and t.bjbh not in(select bjbh from Share_Pro_Sg_Permit)";  //仅报建项目，不包含已备案项目
        }
        // 虹口区建管中心只负责3,4位报建编号为01和02的项目
        sql += " and ( t.bjbh like '__01{1}%' or t.bjbh like '__02{2}%' )";

        String sgdw = request.getParameter("sgdw");
        String jldw = request.getParameter("jldw");
        if (!StringHelper.isEmpty(sgdw)) {
            sql += " and g.sg_total_unit_name like '%" + sgdw + "%'";
        }
        if (!StringHelper.isEmpty(jldw)) {
            sql += " and j.dwmc like '%" + jldw + "%'";
        }
        sql += "  order by t.bj_Date desc,t.bjbh desc";
        String projectArea = configManager.getProjectArea();
        String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
        return FormatUtils.format(sql, projectArea, projectAreaCode, projectAreaCode);
    }

    /**
     * 获取非报建项目查询Sql
     *
     * @param request tab标记及高级查询条件
     * @return string
     */
    public String getProjectQuerySql(HttpServletRequest request) {
        int flag = Integer.valueOf(request.getParameter("flag"));
        //注意：流转编号显示会造成重复记录（由于1个bjbh可能对应多个流转编号）
        String sql = "select distinct t.bjbh||ejt.jd_task_code as id,t.bjbh,ejt.jd_task_code as jd_task_code,t.PROJECT_NAME,t.BUILD_ADDRESS,t.BUILD_PROPERTY,t.TOTAL_INVESTMENT,t.BELONG_AREA,t.BJ_DATE" +
                ",'' as gdCount,'' as gdCode" +
                ",t.BUILD_UNIT_NAME,t.SHARE_DATETIME" +
                " from share_pro_tobuild t" +
                " left join share_gd_info g on t.bjbh=g.bjbh" +
                " left join share_pro_jl_info j on t.bjbh=j.bjbh" +
                " left Join PROJECT_EXTEND pro on pro.bjbh= t.bjbh " +
                " inner join excel_jd_tasks ejt on ejt.bjbh=t.bjbh  " +
                " where trim(t.belong_area)='{0}' " +
                " and  pro.COMPLETE_DATE is  null";   //excel_jd_tasks.belong_area存储是虹口下面的街镇名称

        if (Constants.PROJECT_QUERY_TAB_BJ == flag) {      //报建项目
//            sql += " and t.bjbh not in(select bjbh from Share_Pro_Sg_Permit)";  //暂不限制，全部显示

        } else if (Constants.PROJECT_QUERY_TAB_ZJ == flag) {  //在监项目
//            sql += " and t.bjbh in (select bjbh from Share_Gd_Info where gd_Status_Code in (" + GD_STATUS_CODE_MONITORING + ")) " +
            sql +=   " and ejt.jd_task_Code is not null";
//            sql += " and t.flow_code is not null";   //流转编号不未空

        } else if (Constants.PROJECT_QUERY_TAB_WGWY == flag) {  //完工未验
            sql += " and t.bjbh in (select bjbh from Share_Gd_Info where gd_Status_Code in (" + GD_STATUS_CODE_NOTCHECK + "))";

        }
        // 虹口区建管中心只负责3,4位报建编号为01和02的项目
        sql += " and ( t.bjbh like '__01{1}%' or t.bjbh like '__02{2}%' )";
        String sgdw = request.getParameter("sgdw");
        String jldw = request.getParameter("jldw");
        if (!StringHelper.isEmpty(sgdw)) {
            sql += " and g.sg_total_unit_name like '%" + sgdw + "%'";
            //modify by chenjp at 20140211 按excel监督任务书中的施工总包单位查询
//            sql += " and t.SGZB_UNIT_NAME like '%" + sgdw + "%'";
        }
        if (!StringHelper.isEmpty(jldw)) {
            sql += " and j.dwmc like '%" + jldw + "%'";
            //modify by chenjp at 20140211 按excel监督任务书中的监理单位查询
//            sql += " and t.JL_UNIT_NAME like '%" + jldw + "%'";
        }
        sql += " order by t.SHARE_DATETIME desc";
        String projectArea = configManager.getProjectArea();
        String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
        return FormatUtils.format(sql, projectArea, projectAreaCode, projectAreaCode);
//        System.out.println("sql = " + sql);
    }

    /**
     * 获取小型项目查询Sql
     *
     * @param request tab标记及高级查询条件
     * @return string
     */
    public String getProjectQuerySqlAJ(HttpServletRequest request) {
        int flag = Integer.valueOf(request.getParameter("flag"));
        //注意：流转编号显示会造成重复记录（由于1个bjbh可能对应多个流转编号）
        String sql = "select distinct t.bjbh as id,t.bjbh,'' as jd_task_code,t.PROJECT_NAME,t.BUILD_ADDRESS,t.BUILD_PROPERTY,t.TOTAL_INVESTMENT,t.BELONG_AREA,t.BJ_DATE" +
                ",'' as gdCount,'' as gdCode" +
                ",t.BUILD_UNIT_NAME,t.SHARE_DATETIME" +
                " from share_pro_tobuild t" +
                " left join share_gd_info g on t.bjbh=g.bjbh" +
                " left join share_pro_jl_info j on t.bjbh=j.bjbh " +
                " left Join PROJECT_EXTEND pro on pro.bjbh= t.bjbh " +
                " where 1=1 and  trim(t.belong_area)='{0}' " +
                " and pro.complete_date is null " +
                " and t.bmdm = 'B2AZHK' " +
                " and t.bjbh like '____{1}%' ";   //excel_jd_tasks.belong_area存储是虹口下面的街镇名称

        // 虹口区建管中心只负责3,4位报建编号为01和02的项目
        sql += " and t.bjbh like '__AJ%'";
        String sgdw = request.getParameter("sgdw");
        String jldw = request.getParameter("jldw");
        if (!StringHelper.isEmpty(sgdw)) {
            sql += " and g.sg_total_unit_name like '%" + sgdw + "%'";
            //modify by chenjp at 20140211 按excel监督任务书中的施工总包单位查询
//            sql += " and t.SGZB_UNIT_NAME like '%" + sgdw + "%'";
        }
        if (!StringHelper.isEmpty(jldw)) {
            sql += " and j.dwmc like '%" + jldw + "%'";
            //modify by chenjp at 20140211 按excel监督任务书中的监理单位查询
//            sql += " and t.JL_UNIT_NAME like '%" + jldw + "%'";
        }
        sql += " order by t.SHARE_DATETIME desc";
//        System.out.println("sql = " + sql);

        String projectArea = configManager.getProjectArea();
        String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
        return FormatUtils.format(sql, projectArea, projectAreaCode);
    }

    /**
     * 获取项目统计信息---首页显示
     *
     * @return map
     */
    public Map<String, Object> getProjectCalcForIndex() {
        Map<String, Object> map = new HashMap<String, Object>();

        //项目统计
//        String prjSql = "select count(bjbh) as count,sum(total_investment) as money,sum(total_area) as area" +
//                " from(" +
//                " select  distinct p.bjbh,p.total_investment,p.total_area" +
//                " from share_pro_tobuild p" +
//                " inner join share_gd_info g on g.bjbh=p.bjbh" +
//                " where trim(p.belong_area)='{0}' " +
//                " and g.gd_status_code in({1})" +
//                " )";
//        prjSql = FormatUtils.format(prjSql, configManager.getProjectArea(), GD_STATUS_CODE_MONITORING);
//        String prjSql = "select count(bjbh) as count,sum(total_investment) as money,sum(total_area) as area" +
//                " from(" +
//                " select  distinct p.bjbh,p.JAGZL as total_investment,p.BUILD_AREA as total_area" +
//                " from excel_jd_tasks p" +
//                " inner join share_gd_info g on g.bjbh=p.bjbh" +
//                " where g.gd_status_code in({0})" +
//                " )";
//        prjSql = FormatUtils.format(prjSql, GD_STATUS_CODE_MONITORING);
////        System.out.println("prjSql = " + prjSql);
//        String[] datas = simpleQueryManager.getStringArrayBySql(prjSql);
//
//        map.put("projectCount", datas[0]);
//        map.put("totalInvest", datas[1]);
//        map.put("totalArea", datas[2]);

        //工地统计
        String gdSql = "select count(distinct t.gd_code) as count from share_gd_info t where t.gd_status_code in({0}) and t.bjbh like '%{1}%'";
        int gdCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(gdSql, GD_STATUS_CODE_MONITORING, configManager.getProjectAreaCode().toUpperCase()));
        map.put("gdCount", gdCount);

        //工程性质统计（pro_type）
//        String sql = "select s.name as typeName,nvl(count(distinct t.bjbh),0) as count from pro_type t" +
//                " left join share_pro_tobuild p on t.bjbh=p.bjbh" +
//                " left join sys_code_detail s on t.type_id=s.id" +
//                " inner join share_gd_info g on g.bjbh=p.bjbh" +
//                " where trim(p.belong_area)='{0}' " +
//                " and g.gd_status_code in({1})" +
//                " group by s.name" +
//                " order by count desc";
//        sql = FormatUtils.format(sql, configManager.getProjectArea(), GD_STATUS_CODE_MONITORING);
        String sql = "select t.property as typeName,nvl(count(distinct t.bjbh),0) as count from excel_jd_tasks t \n" +
                "inner join share_gd_info g on g.bjbh=t.bjbh \n" +
                "where g.gd_status_code in({0}) and t.property is not null \n" +
                "group by t.property order by count desc";
        sql = FormatUtils.format(sql, GD_STATUS_CODE_MONITORING);
//        System.out.println("sql = " + sql);
        map.put("typeList", simpleQueryManager.getMapList(sql));

        return map;
    }

    //项目中心点的遥感距离
    public final double DISTANCE_NUM = 1000.0d;
    private double DISTANCE_FACTOR = Math.PI / 180;
    private double DISTANCE_R = 6378137.0;

    /**
     * 根据经纬度计算两点之间的距离
     *
     * @param lng1 库中经度
     * @param lat1 库中纬度
     * @param lng2 当前经度
     * @param lat2 当前纬度
     * @return double类型的值, 单位是米
     */
    public double distance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = lat1 * DISTANCE_FACTOR;
        double radLat2 = lat2 * DISTANCE_FACTOR;
        double radLat = radLat1 - radLat2;
        double radLng = (lng1 - lng2) * DISTANCE_FACTOR;
        double t1 = Math.sin(radLat / 2);
        double t2 = Math.sin(radLng / 2);
        double l = 2 * Math.asin(Math.sqrt(t1 * t1 + Math.cos(radLat1) * Math.cos(radLat2) * t2 * t2));
        l = l * DISTANCE_R;
        l = Math.round(l);
        return l;
    }
    /**
     * 获取计划详细
     *
     * @param jdTaskCode .
     * @return .
     */
    public List<PlanDetail> getPlanDetailByJdTaskCode(String jdTaskCode, String bjbh) {
        List<PlanDetail> planDetails;
        String hql;
        if (StringHelper.isEmpty(jdTaskCode)) {
            hql = "from PlanDetail where bjbh='{0}' order by planEndTime desc";
            planDetails = planDetailService.findByQuery(FormatUtils.format(hql, bjbh));
        } else {
            hql = "from PlanDetail where bjbh='{0}' and jdTaskCode='{1}' order by planEndTime desc";
            planDetails = planDetailService.findByQuery(FormatUtils.format(hql, bjbh, jdTaskCode));
        }
        return planDetails;
    }

    /**
     * 获取工程详细信息--包括基本信息和参加单位等信息---其他业务模块统一调用此方法
     * @param jdTaskCode .
     * @param bjbh .
     * @return .
     */
    public Map<String, Object> getAllProjectInfo(String jdTaskCode, String bjbh) {
        if (!StringHelper.isEmpty(jdTaskCode)) {
            ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
            if(excelJdTasks != null){
                bjbh = excelJdTasks.getBjbh();
                jdTaskCode = excelJdTasks.getJdTaskCode();
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();

        //基本信息
        map.put("bjbh", bjbh);
        map.put("jdTaskCode", jdTaskCode);
        ShareProTobuild project = getProject(bjbh);
        if (project != null) {
            map.put("projectName", project.getProjectName());    //工程名称
            map.put("buildAddress", project.getBuildAddress());  //建设地点
            map.put("jdDatetime", project.getBjDate());    //报监日期
            map.put("gczj", MathHelper.formatCurrency(JspHelper.getDouble(project.getTotalInvestment()), 2) + " 万元");    //工程造价
            map.put("jzmj", MathHelper.formatCurrency(JspHelper.getDouble(project.getTotalArea()), 2) + " ㎡");  //建筑面积
            map.put("jzmj_number", MathHelper.formatDouble(JspHelper.getDouble(project.getTotalArea()), 2));
            map.put("jgxs", project.getStructureForm());    //结构形式

            map.put("jsdwmc", project.getBuildUnitName());   //建设单位名称
            map.put("jsdw_fr", project.getBuildUnitLegal());  //建设单位法人
            map.put("jsdw_tel", project.getBuildUnitTel());  //建设单位联系电话
            map.put("jsdw_fzr", "");   //建设单位负责人
        }
//        //属地
//        ProBelongArea belongArea = relateManager.getProBelongArea(bjbh);
//        if (belongArea != null) {
//            map.put("belongArea", belongArea.getBelongArea().getName());
//        }
//        //性质
//        ProType proType = relateManager.getProType(bjbh);
//        if (proType != null) {
//            map.put("property", proType.getType().getName());
//        }

        map.put("jdrwsbh", jdTaskCode);

        //优先从excel单位工程表中获取
        ExcelJdTasks jdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
//        System.out.println("jdTasks = " + jdTasks);
        if (jdTasks != null) {
            if (!StringHelper.isEmpty(jdTasks.getJdTaskCode())) {
                map.put("jdrwsbh", JspHelper.getString(jdTaskCode).trim());
            }
            map.put("jdDatetime", jdTasks.getJdDatetime());    //报监日期

            map.put("property",jdTasks.getProperty());
            map.put("belongArea",jdTasks.getPosition());
            map.put("projectName", JspHelper.getString(jdTasks.getProjectName()).trim());    //工程名称
            map.put("buildAddress", JspHelper.getString(jdTasks.getProjectAdd()).trim());  //建设地点

            map.put("jsdwmc", JspHelper.getString(jdTasks.getJsUnitName()).trim());    //建设单位名称
            map.put("jsdw_fzr", JspHelper.getString(jdTasks.getJsLinkman()).trim());   //建设单位负责人
            map.put("jsdw_tel", JspHelper.getString(jdTasks.getJsPhone()).trim());     //建设单位联系电话

            map.put("kcdwmc", JspHelper.getString(jdTasks.getKcUnitName()).trim());
            map.put("kcdw_fzr", JspHelper.getString(jdTasks.getKcLinkman()).trim());
            map.put("kcdw_tel", JspHelper.getString(jdTasks.getKcPhone()).trim());

            map.put("sjdwmc", JspHelper.getString(jdTasks.getSjUnitName()).trim());
            map.put("sjdw_fzr", JspHelper.getString(jdTasks.getSjLinkman()).trim());
            map.put("sjdw_tel", JspHelper.getString(jdTasks.getSjPhone()).trim());

            map.put("jldwmc", JspHelper.getString(jdTasks.getJlUnitName()).trim());
            map.put("jldw_fzr", JspHelper.getString(jdTasks.getJlLinkman()).trim());
            map.put("jldw_tel", JspHelper.getString(jdTasks.getJlPhone()).trim());

            map.put("sgdwmc", JspHelper.getString(jdTasks.getSgUnitName()).trim());
            map.put("sgdw_fzr", JspHelper.getString(jdTasks.getSgLinkman()).trim());
            map.put("sgdw_tel", JspHelper.getString(jdTasks.getSgPhone()).trim());

            map.put("sgzbdwmc", JspHelper.getString(jdTasks.getSgzbUnitName()).trim());
            map.put("sgzbdw_fzr", JspHelper.getString(jdTasks.getSgzbLinkman()).trim());
            map.put("sgzbdw_tel", JspHelper.getString(jdTasks.getSgzbPhone()).trim());

            map.put("gczj", MathHelper.formatCurrency(JspHelper.getDouble(jdTasks.getJagzl()), 2) + " 万元");
            map.put("jzmj", MathHelper.formatDouble(JspHelper.getDouble(jdTasks.getBuildArea()), 2) + " ㎡");

        } else if (!StringHelper.isEmpty(jdTaskCode)) {  //从项目单位工程表中获取
            map.put("jdrwsbh", jdTaskCode);
            ShareProDwgcMonitor dwgcMonitor = relateManager.getShareProDwgcMonitor(jdTaskCode);
            if (dwgcMonitor != null) {
                ShareProContract kcdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getKcUnitCode());
                map.put("kcdwmc", dwgcMonitor.getKcUnitName());
                map.put("kcdw_fzr", kcdw.getProHeader());
                map.put("kcdw_tel", kcdw.getProHeaderPhone());

                ShareProContract sjdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getSjUnitCode());
                map.put("sjdwmc", dwgcMonitor.getSjUnitName());
                map.put("sjdw_fzr", sjdw.getProHeader());
                map.put("sjdw_tel", sjdw.getProHeaderPhone());

                ShareProContract jldw = relateManager.getShareProContract(bjbh, dwgcMonitor.getJlUnitCode());
                map.put("jldwmc", dwgcMonitor.getJlUnitName());
                map.put("jldw_fzr", jldw.getProHeader());
                map.put("jldw_tel", jldw.getProHeaderPhone());

                ShareProContract sgdw = relateManager.getShareProContract(bjbh, dwgcMonitor.getSgUnitCode());
                map.put("sgdwmc", dwgcMonitor.getSgUnitName());
                map.put("sgdw_fzr", sgdw.getProHeader());
                map.put("sgdw_tel", sgdw.getProHeaderPhone());
            }
        }
        return map;
    }
}
