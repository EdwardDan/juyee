package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于获取share表之间的数据--无外键关联，通过bjbh匹配
 * User: Chen Junping
 * Date: 12-3-21
 */
@Service
public class RelateManager {
    private Logger logger = LoggerFactory.getLogger(RelateManager.class);

    @Autowired
    private ShareUnitQualifyService shareUnitQualifyService;

    @Autowired
    private ShareUnitInfoService shareUnitInfoService;

    @Autowired
    private ShareProSgPermitService shareProSgPermitService;

    @Autowired
    private ShareProSgInfoService shareProSgInfoService;

    @Autowired
    private ShareGdDwgcService shareGdDwgcService;

    @Autowired
    private SharePunishCaseService sharePunishCaseService;

    @Autowired
    private SharePersonQualifyService sharePersonQualifyService;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private ShareProContractService shareProContractService;

    @Autowired
    private ShareProDwgcMonitorService shareProDwgcMonitorService;

    @Autowired
    private ProjectExtendService projectExtendService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    /**
     * 获取报建项目信息
     *
     * @param unitId 企业标识
     * @return .
     */
    public List<ShareUnitQualify> getShareUnitQualifyList(Long unitId) {
        return shareUnitQualifyService.findByQuery("from ShareUnitQualify where unitId=" + unitId + " order by qualifyCode asc");
    }

    /**
     * 获取ExcelJdTasks
     *
     * @param bjbh 报建标号
     * @return .
     */
    public ExcelJdTasks getExcelJdTasks(String bjbh) {
        List<ExcelJdTasks> list = excelJdTasksService.findByQuery("from ExcelJdTasks where bjbh='" + bjbh + "' ");
        if (null != list && list.size() > 0) {
            return list.iterator().next();
        } else {
            return new ExcelJdTasks();
        }
    }

    /**
     * 获取单位信息
     *
     * @param unitId .
     * @return .
     */
    public ShareUnitInfo getShareUnitInfo(Long unitId) {
        if (unitId != null) {
            return shareUnitInfoService.findUniqueByProperty("id", unitId);
        }
        return null;
    }

    /**
     * 获取项目的施工许可信息
     *
     * @param bjbh .
     * @return .
     */
    public List<ShareProSgPermit> getShareProSgPermitList(String bjbh) {
        return shareProSgPermitService.findByQuery("from ShareProSgPermit where id.bjbh='" + bjbh + "' order by id asc");
    }

    public ShareProSgPermit getShareProSgPermit(String bjbh, String bdh) {
        List<ShareProSgPermit> list = shareProSgPermitService.findByQuery("from ShareProSgPermit where id.bjbh='" + bjbh + "' and id.bdh='" + bdh + "'");
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * 获取项目的施工承发包
     *
     * @param bjbh .
     * @return .
     */
    public List<ShareProSgInfo> getShareProSgInfoList(String bjbh) {
        return shareProSgInfoService.findByQuery("from ShareProSgInfo where id.bjbh='" + bjbh + "' order by id asc");
    }

    /**
     * 获取项目的单位工程信息
     *
     * @param bjbh   .
     * @param gdCode .
     * @return .
     */
    public List<ShareGdDwgc> getShareGdDwgcList(String bjbh, String gdCode) {
        String hql = "from ShareGdDwgc where bjbh='" + bjbh + "'";
        if (!StringHelper.isEmpty(gdCode)) {
            hql += " and id.gdCode='" + gdCode + "'";
        }
        hql += " order by id asc";
        return shareGdDwgcService.findByQuery(hql);
    }

    /**
     * 获取项目的单位工程信息（根据流转编号匹配，如在监督任务书的单位工程则作标记，如仅在监督任务书的单位工程中有也一并列出）
     *
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @return .
     */
    public List<Map<String, Object>> getShareGdDwgcMapList(String bjbh, String gdCode, String jdTaskCode) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (!StringHelper.isEmpty(jdTaskCode)) {//优先获取jdTaskCode对应的单位工程
            List<ExcelJdDwgc> excelJdDwgcList = excelJdDwgcService.findByQuery("from ExcelJdDwgc where jdTaskCode='" + jdTaskCode + "'");
            for (ExcelJdDwgc dwgc : excelJdDwgcList) {
                String dwgcCard = dwgc.getDwgcCode();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("dwgcCard", dwgcCard);
                map.put("dwgcName", dwgc.getDwgcName());
                map.put("buildArea", dwgc.getDwgcArea());
                map.put("proCost", dwgc.getDwgcMoney());
                map.put("proTypeName", dwgc.getProjectType());
                map.put("zjStatusName", dwgc.getTs());
                map.put("floorCount", dwgc.getUpCs());
                map.put("groundFloorCount", dwgc.getDownCs());
                map.put("schedule", dwgc.getProSchedule());
                map.put("isTaskDwgc", false);

                list.add(map);
            }
        }
        if (list.size() == 0) {//如果jdTaskCode对应的单位工程没有获取到，则取共享库里的单位工程
            //获取项目工地中的单位工程
            List<ShareGdDwgc> shareGdDwgcList = getShareGdDwgcList(bjbh, gdCode);
            for (ShareGdDwgc dwgc : shareGdDwgcList) {
                String dwgcCard = dwgc.getId().getDwgcCard();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("dwgcCard", dwgcCard);
                map.put("dwgcName", dwgc.getDwgcName());
                map.put("buildArea", dwgc.getBuildArea());
                map.put("proCost", dwgc.getProCost());
                map.put("proTypeName", dwgc.getProTypeName());
                map.put("zjStatusName", dwgc.getZjStatusName());
                map.put("floorCount", dwgc.getFloorCount());
                map.put("groundFloorCount", dwgc.getGroundFloorCount());
                map.put("schedule", "");
                map.put("isTaskDwgc", false);

                list.add(map);
            }
        }
        return list;
    }

    /**
     * 获取项目的行政处罚信息
     *
     * @param bjbh .
     * @return .
     */
    public List<SharePunishCase> getSharePunishCaseList(String bjbh) {
        return sharePunishCaseService.findByQuery("from SharePunishCase where bjbh='" + bjbh + "' order by id asc");
    }

    /**
     * 获取项目扩展信息
     *
     * @param bjbh .
     * @return .
     */
    public ProjectExtend getProjectExtend(String bjbh) {
        List<ProjectExtend> list = projectExtendService.findByQuery("from ProjectExtend where bjbh=? order by id asc", bjbh);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取某企业下属的人员资质列表
     *
     * @param unitId .
     * @return .
     */
    public List<SharePersonQualify> getSharePersonQualifyList(Long unitId) {
        return sharePersonQualifyService.findByQuery("from SharePersonQualify where regUnitId=" + unitId + " order by regQualifyCode asc");
    }

    /**
     * 获取指定单位的承建工程列表
     *
     * @param unitId .
     * @return .
     */
    public List<ShareProTobuild> getShareProTobuildList(Long unitId) {
        return shareProTobuildService.findByQuery("from ShareProTobuild where bjbh in (select bjbh from ShareProContract where cbUnitId=" + unitId + ") order by bjbh asc");
    }

    /**
     * 获取标段单位列表
     *
     * @param bjbh     .
     * @param unitType .
     * @param gdCode   .
     * @return .
     */
    public List getBidUnitList(String bjbh, String unitType, String gdCode) {
        String sql = "select t3.*,t2.cb_unit,t2.pro_header,t2.pro_header_phone,t2.pro_header_card" +
                " from SHARE_BID_UNIT t1,SHARE_PRO_CONTRACT t2,SHARE_PRO_{0}_INFO t3" +
                " where t3.bjbh='{1}' and t1.bjbh=t2.bjbh" +
                " and t1.bjbh=t3.bjbh and t1.bdh=t3.bdh" +
                " and t2.cb_unit_code=t1.bid_unit_code" +
                " and t2.cont_type_desc='{2}'";
        if (!StringHelper.isEmpty(gdCode)) {
            if (Constants.BID_UNIT_TYPE_JL.equals(unitType)) {
                sql += " and t2.cb_unit_code in (select JL_UNIT_CODE from SHARE_GD_INFO where bjbh='{1}' and gd_code='{3}')";
            } else if (Constants.BID_UNIT_TYPE_SG.equals(unitType)) {
                sql += " and t2.cb_unit_code in (select SG_TOTAL_UNIT_CODE from SHARE_GD_INFO where bjbh='{1}' and gd_code='{3}')";
            }
        }
        sql += " order by t3.bdh";
        sql = FormatUtils.format(sql, unitType, bjbh, getContTypeDesc(unitType), gdCode);
        return simpleQueryManager.getMapList(sql);
    }

    private String getContTypeDesc(String unitType) {
        if (Constants.BID_UNIT_TYPE_KC.equals(unitType)) {
            return "勘察";
        } else if (Constants.BID_UNIT_TYPE_SJ.equals(unitType)) {
            return "设计";
        } else if (Constants.BID_UNIT_TYPE_JL.equals(unitType)) {
            return "监理";
        } else if (Constants.BID_UNIT_TYPE_SG.equals(unitType)) {
            return "施工";
        }
        return "";
    }

    /**
     * 获取施工分包列表
     *
     * @param bjbh .
     * @return .
     */
    public List<ShareProContract> getShareProContractList(String bjbh) {
        return shareProContractService.findByQuery("from ShareProContract where bjbh='" + bjbh + "' and contTypeDesc='施工' order by cbUnit asc");
    }

    /**
     * 根据监督任务书获取负责人
     *
     * @param bjbh .
     * @return .
     */
    public String getShareProContractFZR(String bjbh, String unitCode) {
        ShareProContract contract = getShareProContract(bjbh, unitCode);
        if (contract != null) {
            return contract.getProHeader();
        }
        return "";
    }

    public ShareProContract getShareProContract(String bjbh, String unitCode) {
        String hql = "from ShareProContract where bjbh='{0}' and cbUnitCode='{1}' and proHeader is not null order by cbUnit asc";
        List<ShareProContract> list = shareProContractService.findByQuery(FormatUtils.format(hql, bjbh, unitCode));
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取单位工程信息 -- 一次性取出单位工程信息（单位工程表数据量太大，逐个取出效率太低）
     *
     * @param dwgcCodes .
     * @return .
     */
    public Map<String, ShareProDwgcMonitor> getShareProDwgcMonitors(String[] dwgcCodes) {
        Map<String, ShareProDwgcMonitor> map = new HashMap<String, ShareProDwgcMonitor>();
        if (dwgcCodes.length > 0) {
            String codes = StringHelper.stringArrayToString(dwgcCodes, ",");
            if (codes.endsWith(",")) codes = codes.substring(0, codes.length() - 1);
            codes = StringHelper.findAndReplace(codes, ",", "','");
            String hql = "from ShareProDwgcMonitor where (bjbh||dwgch) in ('{0}') and ynDwgc='y' order by id desc";
            List<ShareProDwgcMonitor> list = shareProDwgcMonitorService.findByQuery(FormatUtils.format(hql, codes));
            for (ShareProDwgcMonitor data : list) {
                map.put(data.getBjbh() + data.getDwgch(), data);
            }
        }
        return map;
    }

    //根据监督任务书获取单位工程
    public ShareProDwgcMonitor getShareProDwgcMonitor(String jdTaskCode) {
        List<ShareProDwgcMonitor> list = getShareProDwgcMonitorList(jdTaskCode);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 获取单位工程列表--从项目单位工程表中
     *
     * @param jdTaskCode .
     * @return .
     */
    public List<ShareProDwgcMonitor> getShareProDwgcMonitorList(String jdTaskCode) {
//        String hql = "from ShareProDwgcMonitor where jdrwsbh='{0}' and ynDwgc='y' order by id desc";
        String hql = "from ShareProDwgcMonitor where jdrwsbh='{0}' order by id desc";
        return shareProDwgcMonitorService.findByQuery(FormatUtils.format(hql, jdTaskCode));
    }

    /**
     * 获取项目的巡检记录--如果监督任务书编号不为空则按监督任务书编号过滤
     *
     * @param bjbh       .
     * @param jdTaskCode .
     * @return .
     */
    public List getJdRecordList(String bjbh, String jdTaskCode) {
        String sql = "select t.jdtypecode,t.code,t.id,t.bjbh,t.jd_task_code,t.jd_manager_name,t.jd_datetime,t.document_id" +
                " from jd_record t";
        if (!StringHelper.isEmpty(jdTaskCode)) {
            sql += " where t.jd_task_code='" + jdTaskCode + "' order by t.jd_datetime desc";
        } else {
            sql += " where t.bjbh='" + bjbh + "' order by t.jd_datetime desc";
        }
        List list = simpleQueryManager.getMapList(sql);
        return list;
    }
}
