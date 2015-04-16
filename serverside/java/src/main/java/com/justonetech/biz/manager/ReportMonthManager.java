package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.MathHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 综合报表月份上报复杂逻辑处理
 * User: guoqiong
 * Date: 14-7-16
 */
@Service
public class ReportMonthManager {
    private Logger logger = LoggerFactory.getLogger(ReportMonthManager.class);

    @Autowired
    private ReportDeptDefineService reportDeptDefineService;

    @Autowired
    private ReportStructureService reportStructureService;

    @Autowired
    private ReportMonthDetailService reportMonthDetailService;

    @Autowired
    private ReportStructureVerService reportStructureVerService;

    @Autowired
    private ReportMonthService reportMonthService;

    /**
     * 根据CODE获取综合报表单位权限
     *
     * @param defineCode 。
     * @return 。
     */
    public ReportDeptDefine getReportDeptDefineByCode(String defineCode) {
        ReportDeptDefine reportDeptDefine = null;
        String hql = "from ReportDeptDefine where code=?";
        List<ReportDeptDefine> defineList = reportDeptDefineService.findByQuery(hql, defineCode);

        if (null != defineList && defineList.size() > 0) {
            reportDeptDefine = defineList.iterator().next();
        }
        return reportDeptDefine;
    }

    /**
     * 获取当前有效版本数据
     *
     * @return 。
     */
    public ReportStructureVer getReportStructureVer() {
        String hql = "from ReportStructureVer where isValid=1";
        ReportStructureVer structureVer = reportStructureVerService.findUnique(hql);
        if (null != structureVer) {
            return structureVer;
        }
        return null;
    }

    /**
     * 根据综合报表单位权限获取(第一层数据)
     *
     * @param reportMonth .
     * @param defineCode  .
     * @return .
     */
    public List<ReportStructure> getReportStructureFirstList(ReportMonth reportMonth, String defineCode) {
        String hql = "from ReportStructure where parent is null and version=?";
        if (!StringHelper.isEmpty(defineCode)) {
            hql += " and reportDeptDefine.code=? order by treeId";
            return reportStructureService.findByQuery(hql, reportMonth.getVersion(), defineCode);
        } else {
            hql += " order by treeId";
            return reportStructureService.findByQuery(hql, reportMonth.getVersion());
        }
    }

    /**
     * 获取报表项
     *
     * @param reportMonth 。
     * @param defineCode  。
     * @return 。
     */
    public List<Map<String, Object>> getReportStructureMapList(ReportMonth reportMonth, String defineCode) {
        List<ReportStructure> firstList = getReportStructureFirstList(reportMonth, defineCode);
        List<Map<String, Object>> itemMapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> itemMap = getItemDetailMap(reportMonth);
        for (ReportStructure item1 : firstList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("structureId", item1.getId());
            map.put("name", item1.getName());
            map.put("item", item1);
            Set<ReportStructure> structures = item1.getReportStructures();
            int size1 = 0;
            for (ReportStructure item2 : structures) {
                Long item2Id = item2.getId();
                int size = item2.getReportStructures().size();
                size1 += size == 0 ? 1 : size;
                map.put("size", size1);
                //获取详细表的数据
                if (size == 0) {
                    getDetailData(map, itemMap, item2Id);
                } else {
                    for (ReportStructure item3 : item2.getReportStructures()) {
                        Long item3Id = item3.getId();
                        getDetailData(map, itemMap, item3Id);
                    }
                }
            }
            itemMapList.add(map);
        }

        return itemMapList;
    }

    /**
     * 获取部分详细数据
     *
     * @param map         。
     * @param itemMap     。
     * @param structureId 。
     */
    private void getDetailData(Map<String, Object> map, Map<String, Object> itemMap, Long structureId) {
        map.put("monthValue" + structureId, itemMap.get("monthValue" + structureId));
        map.put("accuValue" + structureId, itemMap.get("accuValue" + structureId));
        Double hb = JspHelper.getDouble(itemMap.get("percentHb" + structureId));
        if (null == hb || hb == 0.0) {
            map.put("percentHb" + structureId, "0%");
        } else {
            map.put("percentHb" + structureId, hb + "%");
        }
        Double tb = JspHelper.getDouble(itemMap.get("percentTb" + structureId));
        if (null == tb || tb == 0.0) {
            map.put("percentTb" + structureId, "0%");
        } else {
            map.put("percentTb" + structureId, tb + "%");
        }
        map.put("description" + structureId, itemMap.get("description" + structureId));
    }

    /**
     * 通过reportMonth获取详细数据
     *
     * @param reportMonth .
     * @return .
     */
    public Map<String, Object> getItemDetailMap(ReportMonth reportMonth) {
        Map<String, Object> itemValueMap = new HashMap<String, Object>();
        Set<ReportMonthDetail> details = reportMonth.getReportMonthDetails();
        if (null != details && details.size() > 0) {
            for (ReportMonthDetail detail : details) {
                ReportStructure reportStructure = detail.getReportStructure();
                Long structureId = reportStructure.getId();
                itemValueMap.put("monthValue" + structureId, detail.getMonthValue());
                itemValueMap.put("accuValue" + structureId, sumAccuValue(reportMonth, reportStructure));
                itemValueMap.put("percentHb" + structureId, MathHelper.formatDouble(countPercentHb(reportMonth, reportStructure), 2));
                itemValueMap.put("percentTb" + structureId, MathHelper.formatDouble(countPercentTb(reportMonth, reportStructure), 2));
                itemValueMap.put("description" + structureId, detail.getDescription());
            }
        }

        return itemValueMap;
    }

    /**
     * 获取明细信息
     *
     * @param reportMonth .
     * @param structure   .
     * @return .
     */
    public ReportMonthDetail getReportMonthDetail(ReportMonth reportMonth, ReportStructure structure) {
        String hql = "from ReportMonthDetail r where r.reportMonth.id=? and r.reportStructure.id=?";
        ReportMonthDetail monthDetail = reportMonthDetailService.findUnique(hql, reportMonth.getId(), structure.getId());
        if (null == monthDetail) {
            ReportMonthDetail reportMonthDetail = new ReportMonthDetail();
            reportMonthDetail.setReportMonth(reportMonth);
            reportMonthDetail.setReportStructure(structure);
            return reportMonthDetail;
        } else {
            return monthDetail;
        }
    }

    /**
     * 计算累计值
     *
     * @param reportMonth     。
     * @param reportStructure 。
     * @return 。
     */
    public Double sumAccuValue(ReportMonth reportMonth, ReportStructure reportStructure) {
        Double sumAccuValue = 0.0;
        String hql = "select sum(monthValue) from ReportMonthDetail where reportStructure.id=? and reportMonth.year=? and reportMonth.month<=?";
        List<ReportMonthDetail> list = reportMonthDetailService.find(hql, reportStructure.getId(), reportMonth.getYear(), reportMonth.getMonth());
        if (null != list && list.size() > 0) {
            Object object = list.iterator().next();
            if (null != object) {
                sumAccuValue = Double.parseDouble(String.valueOf(object));
            }
        }

        return sumAccuValue;
    }

    /**
     * 计算环比
     *
     * @param reportMonth     。
     * @param reportStructure 。
     * @return 。
     */
    public Double countPercentHb(ReportMonth reportMonth, ReportStructure reportStructure) {
        Double countPercentHb;
        List<ReportMonthDetail> listHbNow = reportMonthDetailService.find(countHql(), reportStructure.getCode(), reportMonth.getYear(), reportMonth.getMonth());
        List<ReportMonthDetail> listHbLast = reportMonthDetailService.find(countHql(), reportStructure.getCode(), reportMonth.getYear(), reportMonth.getMonth() - 1);
        Object objectHbNow = null;
        Object objectTbLast = null;
        if (null != listHbNow && listHbNow.size() > 0) {
            objectHbNow = listHbNow.iterator().next();
        }
        if (null != listHbLast && listHbLast.size() > 0) {
            objectTbLast = listHbLast.iterator().next();
        }
        double hbNow = 0.0;
        double hbLast = 0.0;
        if (null != objectHbNow) {
            hbNow = Double.parseDouble(String.valueOf(objectHbNow));
        }
        if (null != objectTbLast) {
            hbLast = Double.parseDouble(String.valueOf(objectTbLast));
        }
        if (hbLast != 0.0) {
            countPercentHb = (hbNow - hbLast) / hbLast * 100;
        } else {
            countPercentHb = (hbNow - hbLast) / 1.0 * 100;
        }

        return countPercentHb;
    }

    /**
     * 计算同比
     *
     * @param reportMonth     。
     * @param reportStructure 。
     * @return 。
     */
    public Double countPercentTb(ReportMonth reportMonth, ReportStructure reportStructure) {
        Double countPercentTb;
        List<ReportMonthDetail> lisTbtNow = reportMonthDetailService.find(countHql(), reportStructure.getCode(), reportMonth.getYear(), reportMonth.getMonth());
        List<ReportMonthDetail> listTbLast = reportMonthDetailService.find(countHql(), reportStructure.getCode(), reportMonth.getYear() - 1, reportMonth.getMonth());
        Object objectTbNow = null;
        Object objectTbLast = null;
        if (null != lisTbtNow && lisTbtNow.size() > 0) {
            objectTbNow = lisTbtNow.iterator().next();
        }
        if (null != listTbLast && listTbLast.size() > 0) {
            objectTbLast = listTbLast.iterator().next();
        }
        double tbNow = 0.0;
        double tbLast = 0.0;
        if (null != objectTbNow) {
            tbNow = Double.parseDouble(String.valueOf(objectTbNow));
        }
        if (null != objectTbLast) {
            tbLast = Double.parseDouble(String.valueOf(objectTbLast));
        }
        if (tbLast != 0.0) {
            countPercentTb = (tbNow - tbLast) / tbLast * 100;
        } else {
            countPercentTb = (tbNow - tbLast) / 1.0 * 100;
        }

        return countPercentTb;
    }

    /**
     * 统计使用的hql语句
     *
     * @return 。
     */
    public String countHql() {
        return "select monthValue from ReportMonthDetail where reportStructure.code=? and reportMonth.year=? and reportMonth.month=?";
    }

    /**
     * 获取报表汇总项
     *
     * @param reportMonth
     * @return
     */
    public List<Map<String, Object>> getReportStructureSumMapList(ReportMonth reportMonth) {
        List<ReportStructure> firstList = getReportStructureFirstList(reportMonth, null);
        List<Map<String, Object>> itemMapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> itemMap = getItemDetaiSumlMap(String.valueOf(reportMonth.getYear()), String.valueOf(reportMonth.getMonth()));
        for (ReportStructure item1 : firstList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("structureId", item1.getId());
            map.put("name", item1.getName());
            map.put("item", item1);
            Set<ReportStructure> structures = item1.getReportStructures();
            int size1 = 0;
            for (ReportStructure item2 : structures) {
                Long item2Id = item2.getId();
                int size = item2.getReportStructures().size();
                size1 += size == 0 ? 1 : size;
                map.put("size", size1);
                //获取详细表的数据
                if (size == 0) {
                    getDetailData(map, itemMap, item2Id);
                } else {
                    for (ReportStructure item3 : item2.getReportStructures()) {
                        Long item3Id = item3.getId();
                        getDetailData(map, itemMap, item3Id);
                    }
                }
            }
            itemMapList.add(map);
        }
        return itemMapList;
    }

    /**
     * 通过year,month获取汇总详细数据
     *
     * @param year  .
     * @param month .
     * @return .
     */
    public Map<String, Object> getItemDetaiSumlMap(String year, String month) {
        String hql = "from ReportMonth where 1=1 and year=" + Integer.parseInt(year) + " and month=" + Integer.parseInt(month) + " order by reportDeptDefine.id";
        List<ReportMonth> reportMonthList = reportMonthService.findByQuery(hql);
        Map<String, Object> itemValueMap = new HashMap<String, Object>();
        for (ReportMonth reportMonth : reportMonthList) {
            Set<ReportMonthDetail> details = reportMonth.getReportMonthDetails();
            if (null != details && details.size() > 0) {
                for (ReportMonthDetail detail : details) {
                    ReportStructure reportStructure = detail.getReportStructure();
                    Long structureId = reportStructure.getId();
                    itemValueMap.put("monthValue" + structureId, detail.getMonthValue());
                    itemValueMap.put("accuValue" + structureId, sumAccuValue(reportMonth, reportStructure));
                    itemValueMap.put("percentHb" + structureId, MathHelper.formatDouble(countPercentHb(reportMonth, reportStructure), 2));
                    itemValueMap.put("percentTb" + structureId, MathHelper.formatDouble(countPercentTb(reportMonth, reportStructure), 2));
                    itemValueMap.put("description" + structureId, detail.getDescription());
                }
            }
        }
        return itemValueMap;
    }

    /**
     * 获取报表项各层数据
     *
     * @param id .
     * @return .
     */
    public List getPrintList(Long id) {
        List<Object[]> resultList = new ArrayList<Object[]>();
        ReportMonth reportMonth = reportMonthService.get(id);
        List<ReportStructure> firstList = getReportStructureFirstList(reportMonth, "");
        Map<String, Object> itemMap = getItemDetaiSumlMap(String.valueOf(reportMonth.getYear()), String.valueOf(reportMonth.getMonth()));
        for (ReportStructure item1 : firstList) {
            Set<ReportStructure> sets2 = item1.getReportStructures();
            if (null != sets2 && sets2.size() > 0) {
                for (ReportStructure item2 : sets2) {
                    Set<ReportStructure> sets3 = item2.getReportStructures();
                    if (null != sets3 && sets3.size() > 0) {
                        for (ReportStructure item3 : sets3) {
                            Long item3Id = item3.getId();
                            SysCodeDetail measureUnit3 = item3.getMeasureUnit();
                            Object[] data = new Object[8];
                            data[0] = item1.getName();
                            data[1] = item2.getName();
                            if (null != measureUnit3) {
                                data[2] = item3.getName() + "(" + measureUnit3.getName() + ")";
                            } else {
                                data[2] = item3.getName();
                            }
                            data[3] = itemMap.get("monthValue" + item3Id);
                            if (item3.getIsSumAccu()) {
                                data[4] = itemMap.get("accuValue" + item3Id);
                            } else {
                                data[4] = "/";
                            }
                            Double hb3 = JspHelper.getDouble(itemMap.get("percentHb" + item3Id));
                            if (null == hb3 || hb3 == 0.0) {
                                data[5] = "0%";
                            } else {
                                data[5] = hb3 + "%";
                            }
                            Double tb3 = JspHelper.getDouble(itemMap.get("percentTb" + item3Id));
                            if (null == tb3 || tb3 == 0.0) {
                                data[6] = "0%";
                            } else {
                                data[6] = tb3 + "%";
                            }
                            data[7] = itemMap.get("description" + item3Id);
                            resultList.add(data);
                        }
                    } else {
                        Long item2Id = item2.getId();
                        SysCodeDetail measureUnit2 = item2.getMeasureUnit();
                        Object[] data = new Object[8];
                        data[0] = item1.getName();
                        if (null != measureUnit2) {
                            data[1] = item2.getName() + "(" + measureUnit2.getName() + ")";
                        } else {
                            data[1] = item2.getName();
                        }
                        data[2] = "";
                        data[3] = itemMap.get("monthValue" + item2Id);
                        if (item2.getIsSumAccu()) {
                            data[4] = itemMap.get("accuValue" + item2Id);
                        } else {
                            data[4] = "/";
                        }
                        Double hb2 = JspHelper.getDouble(itemMap.get("percentHb" + item2Id));
                        if (null == hb2 || hb2 == 0.0) {
                            data[5] = "0%";
                        } else {
                            data[5] = hb2 + "%";
                        }
                        Double tb2 = JspHelper.getDouble(itemMap.get("percentTb" + item2Id));
                        if (null == tb2 || tb2 == 0.0) {
                            data[6] = "0%";
                        } else {
                            data[6] = tb2 + "%";
                        }
                        data[7] = itemMap.get("description" + item2Id);
                        resultList.add(data);
                    }
                }
            }
        }

        return resultList;
    }
}
