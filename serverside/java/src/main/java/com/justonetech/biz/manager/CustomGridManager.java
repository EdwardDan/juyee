package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.indexGrid.CustomGridData;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
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

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    private static final String LINK_URL = "<a href='#' class='index' onclick='viewCustomGridDetail(\"{0}\")'>{1}</a>"; //查看链接
    private static final String LINK_URL_XXFB = "<a href='#' class='index' onclick='viewCustomGridDetailXxfb(\"{0}\")'>{1}</a>"; //查看链接

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
        try {
            Method method = this.getClass().getDeclaredMethod("setGridData" + modelCode, CustomGridData.class);
            method.invoke(this, data);
        } catch (Exception e) {
            e.printStackTrace();
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

    //查看链接
    private String getLinkUrlXxfb(String title, String url) {
        return FormatUtils.format(LINK_URL_XXFB, url, title);
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

    /**
     * *******************************************以下为业务数据****************************************************
     */
    //获取指定字符的长度
    private Object getPartStr(Object o, int n) {
        return o != null ? (o.toString().length() > n ? StringHelper.truncLength(o.toString(), 10) : o) : o;
    }

    /**
     * 会议纪要
     */
    private void setGridData1(CustomGridData data) {
        data.setCols(new String[]{"信息类型", "标题", "信息来源", "发布时间"});
        data.setAligns(new String[]{"center", "center", "center", "center"});
        data.setWidths(new int[]{20, 25, 20, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaPublicInfo> list = oaPublicInfoService.findByQuery("from OaPublicInfo where type.code='" + Constants.OA_PUBLIC_INFO_TYPE_MEETING + "' order by id desc");
        int i = 0;
        for (OaPublicInfo bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(bizData.getType().getName());
            v.add(getLinkUrlXxfb(String.valueOf(getPartStr(bizData.getTitle(), 10)), "site/infoView.do?id=" + bizData.getId()));
            v.add(bizData.getCreateDeptName());
            v.add(bizData.getReportDate());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 情况通报
     */
    private void setGridData2(CustomGridData data) {
        data.setCols(new String[]{"信息类型", "标题", "信息来源", "发布时间"});
        data.setAligns(new String[]{"center", "center", "center", "center"});
        data.setWidths(new int[]{20, 25, 20, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaPublicInfo> list = oaPublicInfoService.findByQuery("from OaPublicInfo where type.code='" + Constants.OA_PUBLIC_INFO_TYPE_NOTICE + "' order by id desc");
        int i = 0;
        for (OaPublicInfo bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(bizData.getType().getName());
            v.add(getLinkUrlXxfb(String.valueOf(getPartStr(bizData.getTitle(), 10)), "site/infoView.do?id=" + bizData.getId()));
            v.add(bizData.getCreateDeptName());
            v.add(bizData.getReportDate());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 规章制度
     */
    private void setGridData3(CustomGridData data) {
        data.setCols(new String[]{"信息类型", "标题", "信息来源", "发布时间"});
        data.setAligns(new String[]{"center", "center", "center", "center"});
        data.setWidths(new int[]{20, 25, 20, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaPublicInfo> list = oaPublicInfoService.findByQuery("from OaPublicInfo where type.code='" + Constants.OA_PUBLIC_INFO_TYPE_RULE + "' order by id desc");
        int i = 0;
        for (OaPublicInfo bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(bizData.getType().getName());
            v.add(getLinkUrlXxfb(String.valueOf(getPartStr(bizData.getTitle(), 10)), "site/infoView.do?id=" + bizData.getId()));
            v.add(bizData.getCreateDeptName());
            v.add(bizData.getReportDate());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }

    /**
     * 工作动态
     */
    private void setGridData4(CustomGridData data) {
        data.setCols(new String[]{"信息类型", "标题", "信息来源", "发布时间"});
        data.setAligns(new String[]{"center", "center", "center", "center"});
        data.setWidths(new int[]{20, 25, 20, 20});

        List<Vector<Object>> ret = new ArrayList<Vector<Object>>();
        List<OaPublicInfo> list = oaPublicInfoService.findByQuery("from OaPublicInfo where type.code='" + Constants.OA_PUBLIC_INFO_TYPE_WORK + "' order by id desc");
        int i = 0;
        for (OaPublicInfo bizData : list) {
            i++;
            if (i > MAX_COUNT) break;
            Vector<Object> v = new Vector<Object>();
            v.add(bizData.getType().getName());
            v.add(getLinkUrlXxfb(String.valueOf(getPartStr(bizData.getTitle(), 10)), "site/infoView.do?id=" + bizData.getId()));
            v.add(bizData.getCreateDeptName());
            v.add(bizData.getReportDate());
            ret.add(v);
        }
        addBlankLine(ret, list.size(), data.getCols());
        data.setList(ret);
    }
}