package com.justonetech.biz.manager;

import com.justonetech.core.orm.log.TableLog;
import com.justonetech.core.orm.log.TableLogUtils;
import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.domain.CheckDeviceInfo;
import com.justonetech.biz.domain.CheckFingerPrint;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;
import com.justonetech.system.daoservice.SysOperationTableLogService;
import com.justonetech.system.daoservice.SysParameterService;
import com.justonetech.system.domain.SysOperationTableLog;
import com.justonetech.system.domain.SysParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 考勤记录同步入口
 * User: yujun
 * Date: 12-8-30
 */
@Service
public class CheckSyncManager {
    @Autowired
    private SysOperationTableLogService sysOperationTableLogService;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private SysParameterService sysParameterService;

    @Autowired
    private CheckInfoSyncManager checkInfoSyncManager;

    @Autowired
    private ConfigManager configManager;


    //表操作日志类型
    public final String LOG_TYPE_INSERT = "INSERT";
    public final String LOG_TYPE_UPDATE = "UPDATE";
    public final String LOG_TYPE_DELETE = "DELETE";

    //考勤数据上传同步最后更新ID---sys_operation_table_log.id
    public final String PARAM_CODE_OF_UPLOADID = "CHECK_LAST_ID";
    public final String PARAM_NAME_OF_UPLOADID = "考勤上传最后同步ID";

    //考勤记录下载同步最后时间---check_info.updateTime
    public final String PARAM_CODE_OF_CHECKINFO_DOWNTIME = "CHECKINFO_LAST_DOWNTIME";
    public final String PARAM_NAME_OF_CHECKINFO_DOWNTIME = "考勤记录下载最后同步时间";

    //设备信息下载同步最后时间---check_device_info.updateTime
    public final String PARAM_CODE_OF_DEVICEINFO_DOWNTIME = "DEVICEINFO_LAST_DOWNTIME";
    public final String PARAM_NAME_OF_DEVICEINFO_DOWNTIME = "设备信息下载最后同步时间";

    public final int SYNC_LIMIT_COUNT = 20;    //每次同步数据数量
    public final String IDCARD_IMAGE_PATH = "idcardImage";    //身份证照片保存路径

    /**
     * 获取最后更新ID
     */
    public Long getLastId(Long id, String parameterCode, String parameterName) {
        SysParameter parameter = getSysParameter(parameterCode, parameterName);
        if (id != null) {
            parameter.setValue(String.valueOf(id));
            parameter.setUpdateTime(DateTimeHelper.getTimestamp());
            sysParameterService.save(parameter);
        } else {
            id = JspHelper.getLong(parameter.getValue());
        }
        return id;
    }

    private SysParameter getSysParameter(String parameterCode, String parameterName) {
        List<SysParameter> list = sysParameterService.findByQuery("from SysParameter where code='" + parameterCode + "'");
        if (list.size() > 0) {
            return list.iterator().next();
        } else {
            SysParameter data = new SysParameter();
            data.setCode(parameterCode);
            data.setName(parameterName);
            data.setValue("0");
            data.setUpdateTime(DateTimeHelper.getTimestamp());
            sysParameterService.save(data);
            return data;
        }
    }
    //时间格式转换
    public Long getTimeFormat(Timestamp lastTime){
        if(lastTime != null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            return Long.valueOf(formatter.format(lastTime));
        }
        return 0L;
    }

    /**
     * 上传数据到平安工地
     *
     * @throws Exception
     */
    public void uploadData() throws Exception {
        Long lastId = getLastId(null, PARAM_CODE_OF_UPLOADID, PARAM_NAME_OF_UPLOADID);
        //根据上次同步的最后条数据的id获取数据
        String hql = " from SysOperationTableLog where id >" + lastId + " order by id asc";
        List<SysOperationTableLog> SysOperationTableLogList = sysOperationTableLogService.findByQuery(hql);
        if (SysOperationTableLogList.size() > 0) {
            lastId = SysOperationTableLogList.get(0).getId();
            for (SysOperationTableLog sysOperationTableLog : SysOperationTableLogList) {
                String tableName = sysOperationTableLog.getTable().getTableName();
                String className = sysOperationTableLog.getTable().getClassName();
                String logType = sysOperationTableLog.getLogType();
                TableLog tableLog = TableLogUtils.fromXml(sysOperationTableLog.getLogXml());
                List<TableLog.PropertyLog> logList = tableLog.getPropertyLogs();
                TableLog.PropertyLog propertyLog = null;
                //根据表操作日志获取操作数据的id
                String id = null;
                if (logList.size() > 0) {
                    propertyLog = logList.get(0);
                    if (logType.equalsIgnoreCase(LOG_TYPE_INSERT) || logType.equalsIgnoreCase(LOG_TYPE_UPDATE)) {
                        id = propertyLog.getOldValue();
                    } else if (logType.equalsIgnoreCase(LOG_TYPE_DELETE)) {
                        id = propertyLog.getNewValue();
                    }
                }
                //根据id和类名获取数据
                String hql1 = "from " + className + " where id=" + id;
                List obList = hibernateService.findByQuery(hql1);
                Object object = null;
                if (obList.size() > 0) {
                    object = obList.get(0);
                }
                if (object == null)
                    continue;
                //根据表名和操作类型，对数据进行同步增删
                if (tableName.equalsIgnoreCase("check_device_info")) {
                    CheckDeviceInfo checkDeviceInfo = (CheckDeviceInfo) object;
                    //操作类型为增加和更新的同步
                    if (logType.equalsIgnoreCase(LOG_TYPE_INSERT) || logType.equalsIgnoreCase(LOG_TYPE_UPDATE)) {
                        //只有update没有delete操作类型
                        if(checkDeviceInfo.getIsDelete()!= null && checkDeviceInfo.getIsDelete()){   //删除
                            checkInfoSyncManager.deleteCheckDeviceInfo(checkDeviceInfo.getGuid());
                        }else if(checkDeviceInfo.getCancelStatus()!= null && 1==checkDeviceInfo.getCancelStatus()){   //注销
                            checkInfoSyncManager.deleteCheckDeviceInfo(checkDeviceInfo.getGuid());
                        }else{
                            checkInfoSyncManager.saveCheckDeviceInfo(checkDeviceInfo);
                        }
                    }
                    else if (logType.equalsIgnoreCase(LOG_TYPE_DELETE)) {    //操作类型为删除的同步。
                        checkInfoSyncManager.deleteCheckDeviceInfo(checkDeviceInfo.getGuid());
                    }
                }else if (tableName.equalsIgnoreCase("check_manager")) {
                    CheckManager checkManager = (CheckManager) object;
                    if (logType.equalsIgnoreCase(LOG_TYPE_INSERT) || logType.equalsIgnoreCase(LOG_TYPE_UPDATE)) {
                        if(checkManager.getIsDelete()!= null && checkManager.getIsDelete()){
                            checkInfoSyncManager.deleteCheckManager(checkManager.getGuid());
                        }else{
                            checkInfoSyncManager.saveCheckManager(checkManager);
                        }
                    } else if (logType.equalsIgnoreCase(LOG_TYPE_DELETE)) {
                        checkInfoSyncManager.deleteCheckManager(checkManager.getGuid());
                    }

                }else if (tableName.equalsIgnoreCase("check_manager_position")) {
                    CheckManagerPosition checkManagerPosition = (CheckManagerPosition) object;
                    if (logType.equalsIgnoreCase(LOG_TYPE_INSERT) || logType.equalsIgnoreCase(LOG_TYPE_UPDATE)) {
                        if(checkManagerPosition.getIsDelete()!= null && checkManagerPosition.getIsDelete()){
                            checkInfoSyncManager.deleteCheckManagerPosition(checkManagerPosition.getGdCode(),checkManagerPosition.getManager().getGuid());
                        }else{
                            checkInfoSyncManager.saveCheckManagerPosition(checkManagerPosition);
                        }
                    } else if (logType.equalsIgnoreCase(LOG_TYPE_DELETE)) {
                        checkInfoSyncManager.deleteCheckManagerPosition(checkManagerPosition.getGdCode(),checkManagerPosition.getManager().getGuid());
                    }

                }else if (tableName.equalsIgnoreCase("check_finger_print")) {
                    CheckFingerPrint checkFingerPrint = (CheckFingerPrint) object;
                    if (logType.equalsIgnoreCase(LOG_TYPE_INSERT) || logType.equalsIgnoreCase(LOG_TYPE_UPDATE)) {
                        if(checkFingerPrint.getIsDelete()!= null && checkFingerPrint.getIsDelete()){
                            checkInfoSyncManager.deleteCheckFingerPrint(checkFingerPrint.getGuid());
                        }else{
                            checkInfoSyncManager.saveCheckFingerPrint(checkFingerPrint);
                        }
                    } else if (logType.equalsIgnoreCase(LOG_TYPE_DELETE)) {
                        checkInfoSyncManager.deleteCheckFingerPrint(checkFingerPrint.getGuid());
                    }

                }
            }
            //更新id
            getLastId(lastId, PARAM_CODE_OF_UPLOADID, PARAM_NAME_OF_UPLOADID);
        }
    }

    /**
     * 同步数据入口
     *
     * @throws Exception
     */
    public void syncCheckData() throws Exception {
        System.out.println(".........sync check data:"+ DateTimeHelper.formatTimestamp(DateTimeHelper.getTimestamp(),"YYYY-MM-DD HH:MM:SS"));
        if (configManager.getSyncCheckData()) {
            System.out.println(".........sync data begin ...");

            //上传数据
            uploadData();

            //下载数据--设备信息
            checkInfoSyncManager.getDeviceInfoList();

            //下载数据--考勤信息
            checkInfoSyncManager.getCheckInfoList();

            System.out.println(".........sync data end ...");

        } else {
            System.out.println(".........not permit sync check data");
        }
    }
}
