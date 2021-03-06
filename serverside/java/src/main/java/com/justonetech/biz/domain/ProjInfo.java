package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjInfo;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.utils.JspHelper;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class ProjInfo extends BaseProjInfo {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public ProjInfo() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public ProjInfo(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取总标段数量
     *
     * @return .
     */
    public int getBidCount() {
        return getProjBids().size();
    }

    /**
     * 获取办证进度的标段数量
     *
     * @return .
     */
    public int getBidCountOfStage() {
        int count = 0;
        Set<ProjBid> projBids = getProjBids();
        for (ProjBid projBid : projBids) {
            if (ProjBidType.TYPE_STAGE.getCode().equals(JspHelper.getString(projBid.getTypeCode()))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取形象进度的标段数量
     *
     * @return .
     */
    public int getBidCountOfNode() {
        int count = 0;
        Set<ProjBid> projBids = getProjBids();
        for (ProjBid projBid : projBids) {
            if (ProjBidType.TYPE_NODE.getCode().equals(JspHelper.getString(projBid.getTypeCode()))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取已填报办证进度的标段数量
     *
     * @return .
     */
    public int getFillBidCountOfStage() {
        Set<Long> bids = new HashSet<Long>();
        Set<DataStageReport> dataStageReports = getDataStageReports();
        for (DataStageReport dataStageReport : dataStageReports) {
            bids.add(dataStageReport.getBid().getId());
        }
        return bids.size();
    }

    /**
     * 获取已填报本月形象进度的标段数量
     *
     * @return .
     */
    public int getFillBidCountOfNode() {
        Calendar c = Calendar.getInstance();
        Set<Long> bids = new HashSet<Long>();
        Set<DataNodeReport> dataNodeReports = getDataNodeReports();
        for (DataNodeReport dataNodeReport : dataNodeReports) {
            if (dataNodeReport.getYear() == c.get(Calendar.YEAR) && dataNodeReport.getMonth() == (c.get(Calendar.MONTH) + 1)) {
                bids.add(dataNodeReport.getBid().getId());
            }
        }
        return bids.size();
    }

    /**
     * 获取所属区县名称
     *
     * @return .
     */
    public String getBelongAreaNames() {
        String name = "";
        Set<ProjInfoArea> projBidAreas = getProjInfoAreas();
        if (projBidAreas.size() > 0) {
            for (ProjInfoArea projInfoArea : projBidAreas) {
                name += "," + projInfoArea.getBelongArea().getName();
            }
            name = name.substring(1);
        }
        return name;
    }

    /**
     * 获取项目问题附件(适用于文档下载格式化)
     * @return
     */
    public DocDocument getDoc() {
        Set<DataStageReportDoc> dataStageReportDocs = getDataStageReportDocs();
        if (dataStageReportDocs != null && !dataStageReportDocs.isEmpty()) {
            return dataStageReportDocs.iterator().next().getDoc();
        } else {
            return null;
        }
    }

    /**
     * 获取项目问题附件Id(适用于文档下载格式化)
     * @return
     */
    public Long getDocId() {
        return getDoc() != null ? getDoc().getId() : null;
    }
}