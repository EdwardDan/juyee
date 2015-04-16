package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.SafeProductCheckItemService;
import com.justonetech.biz.daoservice.SafeProductCheckService;
import com.justonetech.biz.domain.SafeProductCheck;
import com.justonetech.biz.domain.SafeProductCheckItem;
import com.justonetech.biz.domain.SafeProductStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

/**
 * 安全考核标准复杂业务处理
 * User: guoqiong
 * Date: 14-6-10
 */
@Service
public class SafeProductCheckManager {
    @Autowired
    private SafeProductCheckService safeProductCheckService;

    @Autowired
    private SafeProductCheckItemService safeProductCheckItemService;

    @Autowired
    private SafeProductStandardManager safeProductStandardManager;

    /**
     * 获取明细信息
     *
     * @param safeProductCheck 。
     * @param standard         。
     * @return 。
     */
    public SafeProductCheckItem getSafeProductCheckItem(SafeProductCheck safeProductCheck, SafeProductStandard standard) {
        String hql = "from SafeProductCheckItem s "
                + " where s.productCheck.id = " + safeProductCheck.getId()
                + " and s.productStandard.id =" + standard.getId();
        SafeProductCheckItem checkItem = safeProductCheckItemService.findUnique(hql);
        if (checkItem == null) {
            SafeProductCheckItem safeProductCheckItem = new SafeProductCheckItem();
            safeProductCheckItem.setProductCheck(safeProductCheck);
            safeProductCheckItem.setProductStandard(standard);
            return safeProductCheckItem;
        } else {
            return checkItem;
        }
    }

    /**
     * 获得每一条评分
     *
     * @param sets .
     * @param list .
     * @return .
     */
    public Map<Long, SafeProductCheckItem> getSafeProductCheckItemMap(Set<SafeProductCheckItem> sets, List<SafeProductStandard> list) {
        Map<Long, SafeProductCheckItem> map = new HashMap<Long, SafeProductCheckItem>();
        for (SafeProductStandard standard : list) {
            if (standard.getParent() == null) {
                Integer score = 0;
                if (sets != null && sets.size() > 0) {
                    for (SafeProductCheckItem set : sets) {
                        SafeProductStandard parent = set.getProductStandard().getParent();
                        if (parent != null && parent.getId().equals(standard.getId())) {
                            score += (set.getScore() == null ? 0 : set.getScore());
                        }
                    }
                }
                SafeProductCheckItem safeProductCheckItem = new SafeProductCheckItem();
                safeProductCheckItem.setScore(score);
                map.put(standard.getId(), safeProductCheckItem);
            }
        }
        if (sets != null && sets.size() > 0) {
            for (SafeProductCheckItem set : sets) {
                map.put(set.getProductStandard().getId(), set);
            }
        }
        return map;
    }


    /**
     * 获取考核标准数据
     *
     * @param safeProductCheck .
     * @param model            .
     * @return .
     */
    public List<Map<String, Object>> getSafeProductStandardMap(SafeProductCheck safeProductCheck, Model model) {
        Integer year = safeProductStandardManager.getNewYear();
        //获取考核标准
        List<SafeProductStandard> firstList = safeProductStandardManager.getFirstList(String.valueOf(year));
        Map<String, Object> itemScoreMap = getItemScoreMap(safeProductCheck);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (SafeProductStandard standard : firstList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", standard.getId());
            map.put("name", standard.getItemName() + "<font color='red'>（" + Math.round(standard.getScore()) + "分）</span>");
            map.put("scoreLimit", Math.round(standard.getScore()));
            map.put("inputName", "score" + standard.getId());
            map.put("score", itemScoreMap.get("score" + standard.getId()));
            map.put("item", standard);
            map.put("size", standard.getSafeProductStandards().size());
            mapList.add(map);
        }
        //获取所有扣分
        Map<Long, SafeProductCheckItem> checkItemMap = getSafeProductCheckItemMap(safeProductCheck.getSafeProductCheckItems(), firstList);
        model.addAttribute("checkItemMap", checkItemMap);
        return mapList;
    }

    /**
     * 通过safeProductCheck获取值得分
     *
     * @param safeProductCheck .
     * @return .
     */
    public Map<String, Object> getItemScoreMap(SafeProductCheck safeProductCheck) {
        Map<String, Object> itemValueMap = new HashMap<String, Object>();
        for (SafeProductCheckItem item : safeProductCheck.getSafeProductCheckItems()) {
            itemValueMap.put("score" + item.getProductStandard().getId(), item.getScore());
        }

        return itemValueMap;
    }

    /**
     * 获取当前季度
     *
     * @return 。
     */
    public String getCurrentQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        if (month >= 10) {
            return "4";
        } else if (month >= 7) {
            return "3";
        } else if (month >= 4) {
            return "2";
        } else {
            return "1";
        }
    }
}
