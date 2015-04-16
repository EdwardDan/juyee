package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjectMajor;
import com.justonetech.system.domain.SysCodeDetail;


public class ProjectMajor extends BaseProjectMajor {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ProjectMajor () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ProjectMajor (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //当前进度颜色分类
    public String getScheduleColorName() {
        SysCodeDetail schedule = this.getSchedule();
        if (null != schedule) {
            return "<font color=" + schedule.getTag() + ">" + schedule.getName() + "</font>";
        }
        return "";
    }

}