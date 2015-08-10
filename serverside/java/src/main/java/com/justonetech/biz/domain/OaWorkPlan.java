package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaWorkPlan;
import com.justonetech.biz.utils.enums.OaWorkPlanStatus;

import java.text.SimpleDateFormat;


public class OaWorkPlan extends BaseOaWorkPlan {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaWorkPlan () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaWorkPlan (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	public String getStatusName()//获取状态名及其颜色
	{
		return null != getStatus() ? OaWorkPlanStatus.getColorNameByCode(getStatus()) : "";
	}

	public String getWorkTime()//获取工作时间段开始日期至结束日期
	{
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		if (getBeginDate() != null && getEndDate() != null)
		{
			return sp.format(getBeginDate()) + " ~ " + sp.format(getEndDate());
		}
		return null;
	}
}