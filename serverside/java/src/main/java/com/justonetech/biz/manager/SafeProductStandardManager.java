package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.SafeProductStandardService;
import com.justonetech.biz.domain.SafeProductStandard;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 安全生产考核标准
 * User: guoqiong
 * Date: 14-6-9
 */
@Service
public class SafeProductStandardManager {

    @Autowired
    private SafeProductStandardService safeProductStandardService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 获取考核标准的第一层数据
     *
     * @param year 。
     * @return 。
     */
    public List<SafeProductStandard> getFirstList(String year) {
        String hql = "from SafeProductStandard s where s.year=? and s.parent is null order by s.treeId";
        return safeProductStandardService.findByQuery(hql, Integer.parseInt(year));
    }

    /**
     * 获取最新年的考核标准
     *
     * @return 。
     */
    public Integer getNewYear() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        String hql = "from SafeProductStandard order by year desc";
        List<SafeProductStandard> list = safeProductStandardService.findByQuery(hql);
        SafeProductStandard standard = list.iterator().next();
        if (standard != null) {
            year = standard.getYear();
        }
        return year;
    }

    /**
     * 获取标准年份，如没有则取当前年份
     *
     * @return .
     */
    public String[] getYears() {
        String[] nodeList = getExistYears();
        if (nodeList == null) {
            Calendar c = Calendar.getInstance();
            nodeList = new String[]{c.get(Calendar.YEAR) + ""};
        }
        return nodeList;
    }

    public String[] getExistYears() {
        String[] nodeList = null;
        String sql = "select distinct year from safe_product_standard order by year asc";
        List list = simpleQueryManager.getMapList(sql);
        if (list.size() > 0) {
            nodeList = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                nodeList[i] = JspHelper.getString(map.get("YEAR"));
            }
        }
        return nodeList;
    }

    /**
     * 获取指定年份的标准列表
     *
     * @param year .
     * @return .
     */
    public List<SafeProductStandard> getSafeProductStandards(int year) {
        String hqlYear = "from SafeProductStandard where year=? and parent.id is null order by id asc";
        return safeProductStandardService.findByQuery(hqlYear, year);
    }
}
