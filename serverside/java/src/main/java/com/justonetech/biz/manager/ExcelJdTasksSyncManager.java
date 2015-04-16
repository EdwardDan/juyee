package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.utils.DateUtil;
import com.justonetech.biz.utils.LogFileUtils;
import com.justonetech.biz.utils.webService.jdrwsWebService.JdrwsServiceClient;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.Jdrws;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsDw;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsDwGc;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description: 监督任务书--数据同步处理类
 */
@Service
public class ExcelJdTasksSyncManager {
    private Logger logger = LoggerFactory.getLogger(ExcelJdTasksSyncManager.class);

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private JdrwsServiceClient jdrwsServiceClient;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SysParameterManager sysParameterManager;

    private static final String JD_TASKS_LAST_UPDATE_ID = "JdTasksLastUpdateId";   //监督任务书最后更新ID
    private static final String JD_TASKS_LAST_UPDATE_TIME = "JdTasksLastUpdateTime";   //监督任务书最后更新时间
    private static final int JD_TASKS_SYNC_BATCH_LIMIT = 20;   //监督任务书每次同步的数量限制

    private static String LOG_FILE = null;   //同步日志文件路径__正常
    private static String ERROR_LOG_FILE = null;   //同步日志文件路径__错误

    private static Set<String> ID_HS = null;   //最后ID方式的监督任务书编号集合
    private static Set<String> TIME_HS = null;   //最后TIME方式的监督任务书编号集合

    /**
     * 数据同步入口
     */
    public void syncData() {
        if (ID_HS == null) ID_HS = new HashSet<String>();
        if (TIME_HS == null) TIME_HS = new HashSet<String>();

        String qxmc = configManager.getProjectArea();
        LOG_FILE = getLogFilePath("sync");
        ERROR_LOG_FILE = getLogFilePath("error");
        LogFileUtils.logFile(LOG_FILE, "---------------监督任务书 开始同步-------------------", true);

        //最后更新的记录ID（建昆数据库中的ID主键）
        String lastId = sysParameterManager.getSysParameterValue(JD_TASKS_LAST_UPDATE_ID);
        if (StringHelper.isEmpty(lastId)) {
            lastId = "0";
        }

        //1、先检查有无新增的记录--根据ID
        int countByLastId = jdrwsServiceClient.getJdrwsCountByLastId(qxmc, lastId);
        logger.debug("start countByLastId = " + countByLastId);
        LogFileUtils.logFile(LOG_FILE, "---------------最后更新ID：" + lastId + "-------------------", true);
        LogFileUtils.logFile(LOG_FILE, "---------------1、按最后更新ID同步 需同步记录数为：" + countByLastId + "-------------------", true);
        if (countByLastId > 0) {
            syncDataBatchById(qxmc, lastId);
        }

        //2、检查有无修改的记录--根据时间
        String lastTime = sysParameterManager.getSysParameterValue(JD_TASKS_LAST_UPDATE_TIME);
        if (StringHelper.isEmpty(lastTime)) {  //首次同步仅从前一天开始，因为之前的记录均已进入数据库中，无需从头更新
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            Timestamp curTime = new Timestamp(c.getTimeInMillis());
            lastTime = DateTimeHelper.formatTimestamp(curTime, "YYYY-MM-DD HH:MM:SS");
            sysParameterManager.setParamValueByCode(JD_TASKS_LAST_UPDATE_TIME, lastTime);
        }
        int countByLastTime = jdrwsServiceClient.getJdrwsCountByLastTime(qxmc, lastTime);
        logger.debug("start countByLastTime = " + countByLastTime);
        LogFileUtils.logFile(LOG_FILE, "---------------最后更新时间：" + lastTime + "-------------------", true);
        LogFileUtils.logFile(LOG_FILE, "---------------2、按最后更新时间 需同步记录数为：" + countByLastTime + "-------------------", true);
        if (countByLastTime > 0) {
            syncDataBatchByTime(qxmc, lastTime);
        }
        LogFileUtils.logFile(LOG_FILE, "---------------监督任务书 同步结束-------------------", true);
        ID_HS = null;
        TIME_HS = null;
    }

    //1、根据ID更新记录
    private void syncDataBatchById(String qxmc, String lastId) {
        Boolean isEnd = false;  //判断如果有重复的记录则中止
        List<String> list = jdrwsServiceClient.getJdrwsBhByLastId(qxmc, lastId, JD_TASKS_SYNC_BATCH_LIMIT);
        for (String jdrwsbh : list) {
            if (ID_HS.contains(jdrwsbh)) {
                LogFileUtils.logFile(ERROR_LOG_FILE, "---------------同步中止,lastId=" + lastId + ",jdrwsbh=" + jdrwsbh + "-------------------", true);
                isEnd = true;
                break;
            } else {
                ID_HS.add(jdrwsbh);
            }
            lastId = saveJdTasks(jdrwsbh, false);
        }

        //强制刷新缓存
        excelJdDwgcService.flush();
        excelJdTasksService.flush();

        if (!StringHelper.isEmpty(lastId)) {
            sysParameterManager.setParamValueByCode(JD_TASKS_LAST_UPDATE_ID, lastId);
        }

        if (!isEnd) {
            //如果还有记录则继续获取
            int count = jdrwsServiceClient.getJdrwsCountByLastId(qxmc, lastId);
            logger.debug("count by id = " + count);
            if (count > 0) {
                syncDataBatchById(qxmc, lastId);
            }
        }
    }

    //2、根据时间更新记录
    private void syncDataBatchByTime(String qxmc, String lastTime) {
        Boolean isEnd = false;  //判断如果有重复的记录则中止
        List<String> list = jdrwsServiceClient.getJdrwsBhByLastTime(qxmc, lastTime, JD_TASKS_SYNC_BATCH_LIMIT);
        for (String jdrwsbh : list) {
            if (TIME_HS.contains(jdrwsbh)) {
                LogFileUtils.logFile(ERROR_LOG_FILE, "---------------同步中止,lastTime=" + lastTime + ",jdrwsbh=" + jdrwsbh + "-------------------", true);
                isEnd = true;
                break;
            } else {
                TIME_HS.add(jdrwsbh);
            }
            lastTime = saveJdTasks(jdrwsbh, true);
        }

        //强制刷新缓存
        excelJdDwgcService.flush();
        excelJdTasksService.flush();

        if (!StringHelper.isEmpty(lastTime)) {
            sysParameterManager.setParamValueByCode(JD_TASKS_LAST_UPDATE_TIME, lastTime);
        }

        if (!isEnd) {
            //如果还有记录则继续获取
            int count = jdrwsServiceClient.getJdrwsCountByLastTime(qxmc, lastTime);
            logger.debug("count by time = " + count);
            if (count > 0) {
                syncDataBatchByTime(qxmc, lastTime);
            }
        }
    }

    /**
     * 保存监督任务书数据
     *
     * @param jdrwsbh .
     * @param isTime  是否返回时间，否则为ID
     * @return .
     */
    public String saveJdTasks(String jdrwsbh, Boolean isTime) {
        String lastId = null;
        logger.debug(".......................jdrwsbh = " + jdrwsbh);
        LogFileUtils.logFile(LOG_FILE, "---------------监督任务书编号:" + jdrwsbh + "-------------------", true);
        try {
            Jdrws jdrws = jdrwsServiceClient.getJdrwsByJdrwsbh(jdrwsbh);
            if (jdrws != null) {
                lastId = String.valueOf(jdrws.getDataId());
                if (isTime) {
                    lastId = DateTimeHelper.formatTimestamp(DateUtil.xmlDate2Time(jdrws.getChangeTime()), "YYYY-MM-DD HH:MM:SS");
                }
                ExcelJdTasks data = getExcelJdTasks(jdrwsbh);
                if (data == null) {
                    data = new ExcelJdTasks();
                }
                data.setJdTaskCode(jdrws.getJdrwsBh());
                data.setJdDatetime(DateUtil.xmlDate2Time(jdrws.getJdDateTime()));
                data.setChangeTime(DateUtil.xmlDate2Time(jdrws.getChangeTime()));
                data.setSynDatetime(DateUtil.xmlDate2Time(jdrws.getTimeflag()));
                data.setBelongArea(jdrws.getSzqx());
                data.setBjbh(jdrws.getBjbh());
                data.setBid(jdrws.getBdh());
                data.setProjectAdd(jdrws.getGcdd());
                data.setProjectName(jdrws.getXmmc());
                data.setProperty(jdrws.getXmlx());
                data.setContMoney(jdrws.getHtj());

                //建设单位
                data.setJsUnitName(jdrws.getJsdw());
                data.setJsUnitCode(jdrws.getJsdwDm());
                data.setJsUnitAdd(jdrws.getJsdwDz());
                data.setZipcode(jdrws.getYzbm());
                data.setJsLinkman(jdrws.getLxr());
                data.setJsPhone(jdrws.getLxrDh());

                //参建单位
                List<JdrwsDw> dwList = jdrws.getJdrwsDwList();
                for (JdrwsDw dw : dwList) {
                    if ("施工单位".equals(dw.getDwLx())) {
                        data.setSgUnitName(dw.getDwMc());
                        data.setSgLinkman(dw.getLxr());
                        data.setSgPhone(dw.getLxrDh());
                        data.setSgUnitCode(dw.getDwDm());
                    } else if ("设计单位".equals(dw.getDwLx())) {
                        data.setSjUnitName(dw.getDwMc());
                        data.setSjLinkman(dw.getLxr());
                        data.setSjPhone(dw.getLxrDh());
                        data.setSjUnitCode(dw.getDwDm());
                    } else if ("勘察单位".equals(dw.getDwLx())) {
                        data.setKcUnitName(dw.getDwMc());
                        data.setKcLinkman(dw.getLxr());
                        data.setKcPhone(dw.getLxrDh());
                        data.setKcUnitCode(dw.getDwDm());
                    } else if ("监理单位".equals(dw.getDwLx())) {
                        data.setJlUnitName(dw.getDwMc());
                        data.setJlLinkman(dw.getLxr());
                        data.setJlPhone(dw.getLxrDh());
                        data.setJlUnitCode(dw.getDwDm());
                    } else if ("施工总包单位".equals(dw.getDwLx())) {
                        data.setSgzbUnitName(dw.getDwMc());
                        data.setSgzbLinkman(dw.getLxr());
                        data.setSgzbPhone(dw.getLxrDh());
                        data.setSgzbUnitCode(dw.getDwDm());
                    }
                }

                //单位工程
                int dtsl = 0;
                double money = 0d;
                double area = 0d;
                List<JdrwsDwGc> dwGcList = jdrws.getJdrwsDwGcList();
                for (JdrwsDwGc dwGc : dwGcList) {

                    String dwgcBh = dwGc.getDwgcBh();
                    ExcelJdDwgc dwgcData = getExcelJdDwgc(jdrwsbh, dwgcBh);
                    if (dwgcData == null) {
                        dwgcData = new ExcelJdDwgc();
                    }
                    dwgcData.setJdTaskCode(jdrwsbh);
                    dwgcData.setDwgcCode(dwgcBh);
                    dwgcData.setDwgcName(dwGc.getDwgcMc());
                    dwgcData.setProjectType(dwGc.getGcLx());
                    dwgcData.setStructType(dwGc.getJgLx());
                    dwgcData.setUpCs(JspHelper.getString(dwGc.getDsCs()));
                    dwgcData.setDownCs(JspHelper.getString(dwGc.getDxCs()));
                    dwgcData.setDwgcArea(dwGc.getMj());
                    dwgcData.setDwgcMoney(dwGc.getZj());
                    dwgcData.setChangetime(DateUtil.xmlDate2Time(dwGc.getChangeTime()));
                    dwgcData.setSynDatetime(DateUtil.xmlDate2Time(dwGc.getTimeflag()));
                    dwgcData.setCustomCode("");
                    dwgcData.setProSchedule("");
                    excelJdDwgcService.save(dwgcData);

                    dtsl++;
                    money += JspHelper.getDouble(dwGc.getMj());
                    area += JspHelper.getDouble(dwGc.getZj());
                }

                //统计信息
                data.setDtsl(dtsl);
                data.setJagzl(money);
                data.setBuildArea(area);
                excelJdTasksService.save(data);
            }
        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            LogFileUtils.logFile(ERROR_LOG_FILE, "同步监督任务书数据失败！ 编号为:" + jdrwsbh + "。错误原因如下：" + e.getMessage(), true);
        }
        return lastId;
    }

    //根据监督任务书编号获取监督任务书对象
    private ExcelJdTasks getExcelJdTasks(String jdrwsbh) {
        return excelJdTasksService.findUniqueByProperty("jdTaskCode", jdrwsbh);
    }

    //根据监督任务书编号和单位工程号获取单位工程对象
    private ExcelJdDwgc getExcelJdDwgc(String jdrwsbh, String dwgch) {
        return excelJdDwgcService.findUnique("from ExcelJdDwgc where jdTaskCode=? and dwgcCode=?", jdrwsbh, dwgch);
    }

    //日志文件
    public String getLogFilePath(String prefix) {
        //根据pom设置的同步开关
        String syncLogPath = configManager.getSyncLogPath();
        String fileName = prefix + "_" + System.currentTimeMillis() + ".txt";
        String path = syncLogPath + File.separator + fileName;
        path = FilenameUtils.normalize(path);
        logger.debug("log path = " + path);
        return path;
    }
}