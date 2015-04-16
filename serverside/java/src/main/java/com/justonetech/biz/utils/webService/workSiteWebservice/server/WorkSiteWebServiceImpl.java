package com.justonetech.biz.utils.webService.workSiteWebservice.server;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.utils.webService.workSiteWebservice.bean.ProjectDeptData;
import com.justonetech.biz.utils.webService.workSiteWebservice.bean.ProjectDwgcData;
import com.justonetech.biz.utils.webService.workSiteWebservice.bean.ProjectInfoData;
import com.justonetech.biz.utils.webService.workSiteWebservice.bean.WorkSiteData;
import com.justonetech.system.manager.SimpleQueryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description: 工地信息同步---补充平安工地信息
 * User: Chenjp
 * Date: 12-11-15 下午3:40
 */
public class WorkSiteWebServiceImpl implements WorkSiteWebService {
    private Logger logger = LoggerFactory.getLogger(WorkSiteWebServiceImpl.class);

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 同步工地及相关信息
     * @param gdCode 工地编号
     * @return .
     */
    public WorkSiteData getWorkSiteData(String gdCode) {
        WorkSiteData data = null;

        String sql = "select * from SHARE_GD_INFO t where t.GD_CODE='{0}'";
        List gdList = simpleQueryManager.getMapList(FormatUtils.format(sql, gdCode));
        if (gdList.size() > 0) {
            Object object = gdList.iterator().next();
            Map map = (Map) object;

            data = new WorkSiteData();
            data.setWorkCode(JspHelper.getString(map.get("GD_CODE")));
            data.setWorkName(JspHelper.getString(map.get("GD_NAME")));
            data.setAddress(JspHelper.getString(map.get("GD_ADDRESS")));
            data.setStatusCode(JspHelper.getString(map.get("GD_STATUS_CODE")));
            data.setStatusDesc(JspHelper.getString(map.get("GD_STATUS_DESC")));
//                    data.setJgDeptCode(JspHelper.getString(map.get("")));
//                    data.setJgDeptName(JspHelper.getString(map.get("")));
            data.setSgDeptCode(JspHelper.getString(map.get("SG_TOTAL_UNIT_CODE")));
            data.setSgDeptName(JspHelper.getString(map.get("SG_TOTAL_UNIT_NAME")));
            data.setJlDeptCode(JspHelper.getString(map.get("JL_UNIT_CODE")));
            data.setJlDeptName(JspHelper.getString(map.get("JL_UNIT_NAME")));

            String bjbh = JspHelper.getString(map.get("BJBH"));

            //项目信息
            data.setProjectInfoData(getProjectInfoData(bjbh));

            //参建单位集合
            data.setProjectDeptDatas(getProjectDeptDataList(gdCode));

            //单位工程集合
            data.setProjectDwgcDatas(getProjectDwgcDataList(gdCode));
        }
        return data;
    }

    //获取项目信息
    private ProjectInfoData getProjectInfoData(String bjbh) {
        ProjectInfoData projectInfo = null;
        String sql = "select * from SHARE_PRO_TOBUILD t where t.bjbh='{0}'";
        List proList = simpleQueryManager.getMapList(FormatUtils.format(sql, bjbh));
        if (proList.size() > 0) {
            Object object = proList.iterator().next();
            Map map = (Map) object;

            projectInfo = new ProjectInfoData();
            projectInfo.setBuildCode(bjbh);
            projectInfo.setBuildDatetime(getDate(map.get("BJ_DATE")));
            projectInfo.setBuildName(JspHelper.getString(map.get("PROJECT_NAME")));
            projectInfo.setBuildDept(JspHelper.getString(map.get("BUILD_UNIT_NAME")));
            projectInfo.setBuildDeptProperty(JspHelper.getString(map.get("BUILD_UNIT_PROPERTY")));
            projectInfo.setBuildDeptAddress(JspHelper.getString(map.get("BUILD_UNIT_ADDRESS")));
            projectInfo.setBuildDeptPhone(JspHelper.getString(map.get("BUILD_UNIT_TEL")));
            projectInfo.setBuildDeptLegal(JspHelper.getString(map.get("BUILD_UNIT_LEGAL")));
            projectInfo.setBuildDeptLinkman(JspHelper.getString(map.get("BUILD_UNIT_LINKMAN")));
            projectInfo.setBuildDeptZipcode(JspHelper.getString(map.get("BUILD_UNIT_ZIPCODE")));
            projectInfo.setBuildDeptRegCapital(JspHelper.getDouble(map.get("BUILD_UNIT_REG_MONEY")));
            projectInfo.setBuildAddress(JspHelper.getString(map.get("BUILD_ADDRESS")));
            projectInfo.setBuildProperty(JspHelper.getString(map.get("BUILD_PROPERTY")));
            projectInfo.setBuildScope(JspHelper.getString(map.get("BUILD_SCALE")));
            projectInfo.setBuildArea(JspHelper.getDouble(map.get("TOTAL_AREA")));
            projectInfo.setBuildStartDate(getDate(map.get("BUILD_START_DATE")));
            projectInfo.setTotalInvest(JspHelper.getDouble(map.get("TOTAL_INVESTMENT")));
            projectInfo.setProjectType(JspHelper.getString(map.get("PROJECT_TYPE")));
            projectInfo.setBelongArea(JspHelper.getString(map.get("BELONG_AREA")));
            projectInfo.setProDesc(JspHelper.getString(map.get("EXPLAIN_THING")));
            projectInfo.setProSchedule(JspHelper.getString(map.get("SHARE_STATUS")));
            projectInfo.setProAttention(JspHelper.getString(map.get("LX_LEVEL")));
        }
        return projectInfo;
    }

    //获取项目参建单位
    private List<ProjectDeptData> getProjectDeptDataList(String gdCode) {
        List<ProjectDeptData> list = new ArrayList<ProjectDeptData>();
        String sql = "select DISTINCT SGI.GD_CODE,SGI.HANDING_UNIT_CODE,SGI.SG_TOTAL_UNIT_CODE,SGI.JL_UNIT_CODE,SUI.*\n" +
                "from SHARE_GD_INFO sgi inner join SHARE_UNIT_INFO sui \n" +
                "on SGI.HANDING_UNIT_CODE=SUI.UNIT_CODE \n" +
                "or SGI.SG_TOTAL_UNIT_CODE=SUI.UNIT_CODE\n" +
                "or SGI.JL_UNIT_CODE=SUI.UNIT_CODE\n";
        sql += " where SGI.GD_CODE='{0}'";
        List deptList = simpleQueryManager.getMapList(FormatUtils.format(sql, gdCode));
        for(Object object:deptList){
            Map map = (Map) object;

            ProjectDeptData projectDept = new ProjectDeptData();
            String unitCode = JspHelper.getString(map.get("UNIT_CODE"));
            String unitCodeName = "";
            if (unitCode.equals(JspHelper.getString(map.get("SG_TOTAL_UNIT_CODE")))) {
                projectDept.setCategoryCode("sg");
                unitCodeName = "施工";
            } else if (unitCode.equals(JspHelper.getString(map.get("JL_UNIT_CODE")))) {
                projectDept.setCategoryCode("jl");
                unitCodeName = "监理";
            } else if (unitCode.equals(JspHelper.getString(map.get("HANDING_UNIT_CODE")))) {
                projectDept.setCategoryCode("hu");
                unitCodeName = "经办";
            }
//        projectDept.setCategoryCode(categoryCode);
            projectDept.setCode(unitCode);
            projectDept.setOrgCode(JspHelper.getString(map.get("ORG_CODE")));
            projectDept.setName(JspHelper.getString(map.get("UNIT_NAME")));
            projectDept.setCountry(JspHelper.getString(map.get("BELOG_PROVINCE_CODE")));
            projectDept.setAreaProperty(JspHelper.getString(map.get("REG_CITY_CODE")));
//        projectDept.setBuildCost(JspHelper.getString(map.get(""));
            projectDept.setRegAddress(JspHelper.getString(map.get("REG_ADDRESS")));

            String[] ss = getHeaderData(gdCode,unitCode,unitCodeName);
            if(ss != null){
                projectDept.setManager(ss[0]);
                projectDept.setManagerMobile(ss[1]);
            }
            list.add(projectDept);
        }
        return list;
    }

    //获取单位工程
    private List<ProjectDwgcData> getProjectDwgcDataList(String gdCode) {
        List<ProjectDwgcData> list = new ArrayList<ProjectDwgcData>();
        String sql = "select * from SHARE_GD_DWGC";
        sql += " where gd_code='{0}'";

        List deptList = simpleQueryManager.getMapList(FormatUtils.format(sql, gdCode));
        for(Object object:deptList){
            Map map = (Map) object;

            ProjectDwgcData dwgc = new ProjectDwgcData();
            dwgc.setCode(JspHelper.getString(map.get("DWGC_CODE")));
            dwgc.setName(JspHelper.getString(map.get("DWGC_NAME")));
            dwgc.setCategory(JspHelper.getString(map.get("PRO_TYPE")));
            dwgc.setBuildArea(JspHelper.getDouble(map.get("BUILD_AREA")));
            dwgc.setBuildCost(JspHelper.getDouble(map.get("PRO_COST")));
            int floorCount = JspHelper.getInteger(map.get("FLOOR_COUNT"));
            if (floorCount < 999) {
                dwgc.setUpLevel(floorCount);
            }
            try {
                dwgc.setDownLevel(JspHelper.getInteger(JspHelper.getString(map.get("GROUND_FLOOR_COUNT"))));         //GD_CODE=0402JS0206G001JS数据超限
            } catch (Exception e) {
//                e.printStackTrace();
            }
//                    dwgc.setStatus(rs.getObject("ZJ_STATUS"));
            dwgc.setStatusDesc(JspHelper.getString(map.get("ZJ_STATUS_NAME")));
            list.add(dwgc);
        }
        return list;
    }

    //获取单位编码及联系方式
    private String[] getHeaderData(String gdCode,String unitCode,String unitCodeName){
        String sql = "select distinct g.gd_code,b.cb_unit_code,b.pro_header,b.pro_header_phone,b.cont_type_desc \n" +
                "from share_pro_contract b,share_gd_info g \n" +
                "where b.cb_unit_code is not null and b.pro_header is not null and b.bjbh=g.bjbh \n" +
                "and (b.cb_unit_code=g.sg_total_unit_code or b.cb_unit_code=g.jl_unit_code or b.cb_unit_code=g.jl_unit_code)";
        sql += " and g.gd_code='{0}' and b.cb_unit_code='{1}' and b.cont_type_desc='{2}'";
        return simpleQueryManager.getStringArrayBySql(FormatUtils.format(sql,gdCode,unitCode,unitCodeName));
    }

    private java.util.Date getDate(Object object) {
        if (object != null) {
            try {
                return DateTimeHelper.convertStringToDate(JspHelper.getString(object));
            } catch (Exception e) {

            }
        }
        return null;
    }
}
