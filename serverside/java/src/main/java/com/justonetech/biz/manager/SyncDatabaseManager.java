package com.justonetech.biz.manager;

import com.justonetech.biz.utils.SyncData.ResultSetSyncMain;
import com.justonetech.system.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据同步
 * User: Chen Junping
 * Date: 12-5-22
 */
@Service
public class SyncDatabaseManager {
    @Autowired
    private ConfigManager configManager;

//    @Autowired
//    private WxyManager wxyManager;

    /**
     * 数据同步
     *
     * @throws Exception .
     */
    public void syncDatabase() throws Exception {
        if (configManager.getSyncDatabase()) {
            //sql server -> oracle
            //oracle -> oracle
            String logPath = configManager.getFilePath() + "temp";
            FileUtils.mkDirs(logPath);

            ResultSetSyncMain.init(logPath);

            //危险源数据同步
//            wxyManager.saveToTable();
        }
    }

}
