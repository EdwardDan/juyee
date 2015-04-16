package com.justonetech.biz.manager;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPushDefineService;
import com.justonetech.system.daoservice.SysPushUserService;
import com.justonetech.system.daoservice.SysVisitRecordService;
import com.justonetech.system.domain.*;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysMenuManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:首页推送业务类
 * User: Chenjp
 * Date: 14-4-3 下午2:53
 */
@Service
public class PushUserManager {
    private Logger logger = LoggerFactory.getLogger(PushUserManager.class);

    private static final int MAX_COUNT = 5;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysMenuManager sysMenuManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysPushDefineService sysPushDefineService;

    @Autowired
    private SysPushUserService sysPushUserService;

    @Autowired
    private SysVisitRecordService sysVisitRecordService;

    /**
     * 获取首页推送列表
     *
     * @return .
     */
    public List<Map<String, Object>> getPushDefineList() {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        int i = 0;
        List<SysPushDefine> list = getPushDefines();

        String userName = "";
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            userName = sysUser.getLoginName();
        }
        for (SysPushDefine sysPushDefine : list) {
            i++;
            if (i > MAX_COUNT) break;
            SysMenu menu = sysPushDefine.getMenu();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", sysPushDefine.getTaskImg());
            map.put("name", menu.getName());
            map.put("pos", sysMenuManager.getPos(menu));
            map.put("link", menu.getUrl());

            //计算未读数量
            map.put("count", getNotReadCount(sysPushDefine, userName));
            ret.add(map);
        }
        if (list.size() < MAX_COUNT) {
            for (int j = (list.size() + 1); j <= MAX_COUNT; j++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("img", "default.png");
                map.put("name", "暂无");
                map.put("link", "");
                map.put("pos", "");
                map.put("count", 0);
                ret.add(map);
            }
        }
        return ret;
    }

    /**
     * 获取推送栏目
     *
     * @return .
     */
    private List<SysPushDefine> getPushDefines() {
        List<SysPushDefine> ret = new ArrayList<SysPushDefine>();
        SysUser sysUser = sysUserManager.getSysUser();
        String loginName = sysUser.getLoginName();
        List<SysPushUser> list = sysPushUserService.findByQuery("from SysPushUser where pushDefine.isValid=1 and userName=? order by orderNo asc,id asc", loginName);
        if (list.size() > 0) {
            for (SysPushUser sysPushUser : list) {
                ret.add(sysPushUser.getPushDefine());
            }
            return ret;

        } else {
            return sysPushDefineService.findByQuery("from SysPushDefine where isValid=1 order by orderNo asc,id asc");
        }
    }

    /**
     * 获取未读数量
     *
     * @param sysPushDefine .
     * @param userName      .
     * @return .
     */
    private int getNotReadCount(SysPushDefine sysPushDefine, String userName) {
        String querySql = sysPushDefine.getQuerySql();
        if (!StringHelper.isEmpty(querySql)) {
            querySql = StringHelper.findAndReplace(querySql, "{delay}", JspHelper.getInteger(sysPushDefine.getPushDelay()) + "");
            querySql = StringHelper.findAndReplace(querySql, "{userName}", userName);
//            System.out.println("querySql = " + querySql);
            try {
                return simpleQueryManager.getIntegerBySql(querySql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 设置已读标记 -- 用于查看页面
     *
     * @param className 业务模块类名
     * @param tableId   业务记录ID
     */
    public void setReadFlag(String className, Long tableId) {
        //todo 需清除间隔时间之前的记录，避免数据太多影响查询效率
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            List<SysVisitRecord> exists = sysVisitRecordService.find("from SysVisitRecord where tableName=? and tableId=? and createUser=?", className, tableId, sysUser.getLoginName());
            if (exists.size() == 0) {
                SysVisitRecord data = new SysVisitRecord();
                data.setTableName(className);
                data.setTableId(tableId);
                sysVisitRecordService.save(data);
            }
        }
    }

    /**
     * 获取是否未读的记录 -- 用于列表显示
     *
     * @param className 业务模块类名
     * @param tableId   业务记录ID
     * @return 是否已读的图标
     */
    public String getReadFlag(String className, Long tableId, String userName) {
        String img = "";
        if (!StringHelper.isEmpty(userName)) {
            List<SysVisitRecord> exists = sysVisitRecordService.find("from SysVisitRecord where tableName=? and tableId=? and createUser=?", className, tableId, userName);
            if (exists.size() > 0) {
                img = "";
            }
        }
        return img;
    }
}
