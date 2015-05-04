package com.justonetech.biz.manager;

import com.justonetech.biz.manager.indexGrid.CustomGridData;
import com.justonetech.core.utils.FormatUtils;
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
import java.util.List;
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