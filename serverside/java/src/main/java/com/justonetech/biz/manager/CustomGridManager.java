package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.indexGrid.CustomGridData;
import com.justonetech.biz.utils.enums.OaCarApplyStatus;
import com.justonetech.biz.utils.enums.OaExpertiseStatus;
import com.justonetech.biz.utils.enums.OaQuarterplanStatus;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCustomGridService;
import com.justonetech.system.daoservice.SysCustomGridUserService;
import com.justonetech.system.domain.SysCustomGrid;
import com.justonetech.system.domain.SysCustomGridUser;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * description: 系统首页版块处理
 * User: Chenjp
 * Date: 14-4-3 下午12:48
 */
@Service
public class CustomGridManager {
    private Logger logger = LoggerFactory.getLogger(CustomGridManager.class);

    private static final int MAX_COUNT = 6;  //最多记录数

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCustomGridService sysCustomGridService;

    @Autowired
    private SysCustomGridUserService sysCustomGridUserService;

    @Autowired
    private OaCarService oaCarService;

    @Autowired
    private OaKnowledgeService oaKnowledgeService;

    @Autowired
    private OaNewsService oaNewsService;

    @Autowired
    private OaExpertiseService oaExpertiseService;

    @Autowired
    private OaDynamicWorkService oaDynamicWorkService;

    @Autowired
    private OaMonthplanService oaMonthplanService;

    @Autowired
    private OaMonthplanSumService oaMonthplanSumService;

    @Autowired
    private OaQuarterplanService oaQuarterplanService;

    @Autowired
    private OaQuarterplanSumService oaQuarterplanSumService;

    @Autowired
    private PlanMainInfoService planMainInfoService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;


    private static final String LINK_URL = "<a href='#' class='index' onclick='viewCustomGridDetail(\"{0}\")'>{1}</a>"; //查看链接

    /**
     * 获取版块数据
     *
     * @param orderNo 序号 1-4
     * @return .
     */
    public CustomGridData getGridData(int orderNo) {
        CustomGridData data = new CustomGridData();
        SysCustomGrid grid = getSysCustomGrid(orderNo);
        String modelCode = grid.getModelCode();
        data.setOrderNo(orderNo);
        data.setCheckedNo(grid.getOrderNo());
        data.setModelCode(modelCode);
        data.setModelName(grid.getModelName());
        data.setMoreLink(grid.getMoreLink());

        if (OaCar.class.getSimpleName().equals(modelCode)) {
            setCarData(data);
        } else if (OaKnowledge.class.getSimpleName().equals(modelCode)) {
            setOaKnowledgeData(data);
        } else if (OaNews.class.getSimpleName().equals(modelCode)) {
            setNewsData(data);
        } else if (OaExpertise.class.getSimpleName().equals(modelCode)) {
            setExpertiseData(data);
        } else if (OaDynamicWork.class.getSimpleName().equals(modelCode)) {
            setDynamicWorkData(data);
        } else if (OaMonthplan.class.getSimpleName().equals(modelCode)) {
            setOaMonthplanData(data);
        } else if (OaMonthplanSum.class.getSimpleName().equals(modelCode)) {
            setOaMonthplanSumData(data);
        } else if (OaQuarterplan.class.getSimpleName().equals(modelCode)) {
            setOaQuarterplanData(data);
        } else if (OaQuarterplanSum.class.getSimpleName().equals(modelCode)) {
            setOaQuarterplanSumData(data);
        } else if ((PlanMainInfo.class.getSimpleName() + "_safe").equals(modelCode)) {
            setPlanMainInfoData(data, "safe");
        } else if ((PlanMainInfo.class.getSimpleName() + "_quality").equals(modelCode)) {
            setPlanMainInfoData(data, "quality");
        } else if ((JdRecordFirst.class.getSimpleName() + "_safe").equals(modelCode)) {
            setJdRecordFirstData(data, "safe");
        } else if ((JdRecordFirst.class.getSimpleName() + "_quality").equals(modelCode)) {
            setJdRecordFirstData(data, "quality");
        }
        return data;
    }

    /**
     * 获取用户定制版块
     *
     * @param orderNo .
     * @return .
     */
    private SysCustomGrid getSysCustomGrid(int orderNo) {
        SysUser sysUser = sysUserManager.getSysUser();
        String loginName = sysUser.getLoginName();
        List<SysCustomGridUser> list = sysCustomGridUserService.findByQuery("from SysCustomGridUser where userName=? and orderNo=?", loginName, orderNo);
        if (list.size() > 0) {
            SysCustomGridUser gridUser = list.iterator().next();
            return gridUser.getCustomGrid();
        } else {
            return sysCustomGridService.findUnique("from SysCustomGrid where orderNo=?", orderNo);
        }
    }

    //补充空白行
    private void addBlankLine(List<Vector<Object>> ret, int size, String[] cols) {
        if (size < MAX_COUNT) {
            for (int j = (size + 1); j <= MAX_COUNT; j++) {
                Vector<Object> v = new Vector<Object>();
                for (String s : cols) {
                    v.add("&nbsp;");
                }
                ret.add(v);
            }
        }
    }

    //查看链接
    private String getLinkUrl(String title, String url) {
        return FormatUtils.format(LINK_URL, url, title);
    }

    /**
     * 获取车辆管理信息
     *
     * @param data .
     */
    private void setCarData(CustomGridData data) {
        data.setCols(new String[]{"申请人", "用车时间", "拟派车牌号", "拟派驾驶员"});
        data.setAligns(new String[]{"center", "center", "center", "center"});
        data.setWidths(new int[]{30, 40, 15, 15});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaCar> list = oaCarService.findByQuery("from OaCar where status=? order by id desc", OaCarApplyStatus.STATUS_PASS.getCode());
        int i = 0;
        for (OaCar bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getApplyPerson() + "(" + bizData.getApplyDept() + ")", "oaCar/view.do?id=" + bizData.getId()));
            v.add(bizData.getUseDate() + " " + bizData.getUseBeginTime() + "~" + bizData.getUseEndTime());
            v.add(JspHelper.getString(bizData.getCarNo()));
            v.add(JspHelper.getString(bizData.getDriverName()));
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取业务知识交流信息
     *
     * @param data .
     */
    private void setOaKnowledgeData(CustomGridData data) {
        data.setCols(new String[]{"主题名称", "提出人", "提出部门", "提出日期"});
        data.setAligns(new String[]{"left", "center", "center", "center"});
        data.setWidths(new int[]{50, 15, 20, 15});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaKnowledge> list = oaKnowledgeService.findByQuery("from OaKnowledge where refer is null order by id desc");
        int i = 0;
        for (OaKnowledge bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            String title = StringHelper.truncLength(bizData.getContent(),20);
            v.add(getLinkUrl(title,"oaKnowledge/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportPerson());
            v.add(bizData.getReportDept());
            v.add(DateTimeHelper.formatTimestamp(bizData.getReportDate(), "YYYY-MM-DD"));
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取新闻发布信息
     *
     * @param data .
     */
    private void setNewsData(CustomGridData data) {
        data.setCols(new String[]{"新闻标题", "发布时间"});
        data.setAligns(new String[]{"left", "center"});
        data.setWidths(new int[]{80, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaNews> list = oaNewsService.findByQuery("from OaNews where isValid=1 order by reportDate desc");
        int i = 0;
        for (OaNews bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            String title = StringHelper.truncLength(bizData.getTitle(), 25);
            v.add(getLinkUrl(title, "oaNews/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportDate());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取专业知识学习信息
     *
     * @param data .
     */
    private void setExpertiseData(CustomGridData data) {
        data.setCols(new String[]{"主题", "学习周期", "责任人"});
        data.setAligns(new String[]{"left", "center", "center"});
        data.setWidths(new int[]{60, 30, 10});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaExpertise> list = oaExpertiseService.findByQuery("from OaExpertise where status=? order by reportDate desc", OaExpertiseStatus.STATUS_PASS.getCode());
        int i = 0;
        for (OaExpertise bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            String title = StringHelper.truncLength(bizData.getTitle(), 20);
            v.add(getLinkUrl(title, "oaExpertise/view.do?id=" + bizData.getId()));
            v.add(getYearMonth(bizData.getBeginDate()) + "~" + getYearMonth(bizData.getEndDate()));
            v.add(bizData.getReportPerson());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取实时工作动态信息
     *
     * @param data .
     */
    private void setDynamicWorkData(CustomGridData data) {
        data.setCols(new String[]{"提交部门", "提交人", "内容"});
        data.setAligns(new String[]{"center", "center", "left"});
        data.setWidths(new int[]{20, 20, 60});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaDynamicWork> list = oaDynamicWorkService.findByQuery("from OaDynamicWork where isValid=1 order by id desc");
        int i = 0;
        for (OaDynamicWork bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getReportDept(), "oaDynamicWork/view.do?id=" + bizData.getId()));
            v.add(bizData.getCreateUser());
//            v.add(bizData.getContent());
            v.add(StringHelper.truncLength(bizData.getContent(),25));
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取月度计划提交信息
     *
     * @param data .
     */
    private void setOaMonthplanData(CustomGridData data) {
        data.setCols(new String[]{"提交部门", "报告时间", "状态"});
        data.setAligns(new String[]{"center", "center", "center"});
        data.setWidths(new int[]{35, 35, 30});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaMonthplan> list = oaMonthplanService.findByQuery("from OaMonthplan order by id desc");
        int i = 0;
        for (OaMonthplan bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getReportDept(), "oaMonthplan/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportTime());
            v.add(bizData.getStatusName());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }


    /**
     * 获取月度计划汇总信息
     *
     * @param data .
     */
    private void setOaMonthplanSumData(CustomGridData data) {
        data.setCols(new String[]{"报告时间", "已汇总部门", "状态"});
        data.setAligns(new String[]{"center", "center", "center"});
        data.setWidths(new int[]{35, 35, 30});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaMonthplanSum> list = oaMonthplanSumService.findByQuery("from OaMonthplanSum order by id desc");
        int i = 0;
        for (OaMonthplanSum bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getReportTime(), "oaMonthplanSum/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportDepts());
            v.add(bizData.getStatusName());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }


    /**
     * 获取季度计划提交信息
     *
     * @param data .
     */
    private void setOaQuarterplanData(CustomGridData data) {
        data.setCols(new String[]{"提交部门", "报告时间", "状态"});
        data.setAligns(new String[]{"center", "center", "center"});
        data.setWidths(new int[]{35, 35, 30});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaQuarterplan> list = oaQuarterplanService.findByQuery("from OaQuarterplan order by id desc");
        int i = 0;
        for (OaQuarterplan bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getReportDept(), "oaQuarterplan/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportTime());
            OaQuarterplan oaQuarterplan = oaQuarterplanService.get(bizData.getId());
            if (null != oaQuarterplan.getStatus()) {
                String statusName = OaQuarterplanStatus.getColorNameByCode(oaQuarterplan.getStatus());
                v.add(statusName);
            }
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取季度计划汇总信息
     *
     * @param data .
     */
    private void setOaQuarterplanSumData(CustomGridData data) {
        data.setCols(new String[]{"报告时间", "已汇总部门", "状态"});
        data.setAligns(new String[]{"center", "center", "center"});
        data.setWidths(new int[]{35, 35, 30});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaQuarterplanSum> list = oaQuarterplanSumService.findByQuery("from OaQuarterplanSum order by id desc");
        int i = 0;
        for (OaQuarterplanSum bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(getLinkUrl(bizData.getReportTime(), "oaQuarterplanSum/view.do?id=" + bizData.getId()));
            v.add(bizData.getReportDepts());
            v.add(bizData.getStatusName());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取安全质量监督计划信息
     *
     * @param data .
     */
    private void setPlanMainInfoData(CustomGridData data, String planType) {
        data.setCols(new String[]{"计划名称", "创建人", "创建时间"});
        data.setAligns(new String[]{"left", "center", "center"});
        data.setWidths(new int[]{60, 20, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<PlanMainInfo> list = planMainInfoService.findByQuery("from PlanMainInfo where planType.code=? order by planCode desc", planType);
        int i = 0;
        for (PlanMainInfo bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            String title = StringHelper.truncLength(bizData.getPlanName(),20);
            v.add(getLinkUrl(title,"planMainInfo/view.do?id=" + bizData.getId()));
            v.add(bizData.getCreateUserName());
            v.add(DateTimeHelper.formatTimestamp(bizData.getCreateTime(), "YYYY-MM-DD"));
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 获取安全质量监督记录信息
     *
     * @param data .
     */
    private void setJdRecordFirstData(CustomGridData data, String planType) {
        data.setCols(new String[]{"工程名称", "监督日期"});
        data.setAligns(new String[]{"left", "center"});
        data.setWidths(new int[]{60, 40});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        String sql = "select 'JD_RECORD_FIRST'as table_name,id, project_name , jd_datetime  from JD_RECORD_FIRST f where  f.JD_TYPE_CODE='{0}' \n" +
                " union select  'JD_RECORD_COMPLETE'as table_name,id, project_name , jd_datetime  from JD_RECORD_COMPLETE c where c.JD_TYPE_CODE='{1}'\n";
        if (planType.equals("quality")) {
            sql += " union select 'JD_RECORD_QUALITY'as table_name,id, project_name , jd_datetime  from JD_RECORD_QUALITY ";
        } else {
            sql += " union select 'JD_RECORD_SAFE'as table_name,id, project_name , jd_datetime  from JD_RECORD_SAFE ";
        }
        sql = FormatUtils.format(sql, planType, planType);
        List listBySql = simpleQueryManager.getMapList(sql);
        int i = 0;
        for (Object object : listBySql) {
            i++;
            if (i > MAX_COUNT) break;
            Map map = (Map) object;
            Vector<Object> v = new Vector<Object>();
            String table_name = JspHelper.getString(map.get("TABLE_NAME"));
            Long id = JspHelper.getLong(map.get("ID"));
            String project_name = JspHelper.getString(map.get("PROJECT_NAME"));
            String jd_datetime = JspHelper.getString(map.get("JD_DATETIME"));
            String element = null;
            if (table_name.equals("JD_RECORD_FIRST")) {
                element = "jdRecordFirst/view.do?id=" + id;
            } else if (table_name.equals("JD_RECORD_COMPLETE")) {
                element = "jdRecordComplete/view.do?id=" + id;
            } else if (table_name.equals("JD_RECORD_QUALITY")) {
                element = "jdRecordQuality/view.do?id=" + id;
            } else if (table_name.equals("JD_RECORD_SAFE")) {
                element = "jdRecordSafe/view.do?id=" + id;
            }
            if (null != element) {
                v.add(getLinkUrl(StringHelper.truncLength(project_name,20), element));
            } else {
                v.add(StringHelper.truncLength(project_name,20));
            }
            v.add(DateTimeHelper.formatTimestamp(Timestamp.valueOf(jd_datetime), "YYYY-MM-DD"));
            ret.add(v);
        }
        addBlankLine(ret, listBySql.size(), data.getCols());
        data.setList(ret);
    }


    //获取月日
    private String getYearMonth(Date date) {
        if (date != null) {
            Timestamp timestamp = new Timestamp(date.getTime());
            String result = timestamp.toString();
            if (result.length() > 18) {
                return result.substring(5, 10);
            }
        }
        return "";
    }
}