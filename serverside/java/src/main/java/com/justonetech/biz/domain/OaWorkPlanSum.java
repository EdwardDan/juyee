package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaWorkPlanSum;
import com.justonetech.biz.utils.enums.OaMeetingStatus;
import com.justonetech.biz.utils.enums.OaWorkPlanSumStatus;
import com.justonetech.core.utils.JspHelper;

import java.text.SimpleDateFormat;
import java.util.Set;


public class OaWorkPlanSum extends BaseOaWorkPlanSum
{
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaWorkPlanSum()
    {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaWorkPlanSum(Long id)
    {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    public String getWorkTime()
    {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        if (getBeginDate() != null && getEndDate() != null)
        {
            return sp.format(getBeginDate()) + " ~ " + sp.format(getEndDate());
        }
        return null;
    }

    public String getStatusName()
    {
        return null != getStatus() ? OaWorkPlanSumStatus.getColorNameByCode(getStatus()) : "";
    }

    public String getSumDept()
    {
        String sum = "";
        String dept = "";
        String depta = "";
        Integer i = 0;
        Set<OaWorkPlanSumItem> oaWorkPlanSumItems = getOaWorkPlanSumItems();
        for (OaWorkPlanSumItem oaWorkPlanSumItem : oaWorkPlanSumItems)
        {
            if (i < 1)
            {
                sum = oaWorkPlanSumItem.getWorkPlanItem().getWeekPlan().getReportDept();
                dept = oaWorkPlanSumItem.getWorkPlanItem().getWeekPlan().getReportDept();
            }
            if (!oaWorkPlanSumItem.getWorkPlanItem().getWeekPlan().getReportDept().equals(dept))
            {
                sum += oaWorkPlanSumItem.getWorkPlanItem().getWeekPlan().getReportDept() + ",";
                dept = oaWorkPlanSumItem.getWorkPlanItem().getWeekPlan().getReportDept();
            }
            i++;
        }
        return sum;
    }
}