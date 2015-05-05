package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjInfo;

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
     * 获取标段数量
     *
     * @return .
     */
    public int getBidCount() {
        return getProjBids().size();
    }

    /**
     * 获取已填报办证进度的标段数量
     *
     * @return .
     */
    public int getBidCountOfStage() {
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
    public int getBidCountOfNode() {
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
}