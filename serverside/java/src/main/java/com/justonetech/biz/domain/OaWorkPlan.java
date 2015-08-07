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

	public String getStatusName()
	{
		return null != getStatus() ? OaWorkPlanStatus.getColorNameByCode(getStatus()) : "";
	}

	public String getWorkTime()
	{
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		if (getBeginDate() != null && getEndDate() != null)
		{
			return sp.format(getBeginDate()) + " ~ " + sp.format(getEndDate());
		}
		return null;
	}
}