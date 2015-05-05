package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description: 办证推进和形象进度上报的业务类
 */
@Service
public class DataReportManager {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjStageService projStageService;

    @Autowired
    private ProjNodeService projNodeService;

    @Autowired
    private DataStageReportService dataStageReportService;

    @Autowired
    private DataNodeReportService dataNodeReportService;


}
