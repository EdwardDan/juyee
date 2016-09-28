package com.justonetech.cp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class ProvideSgxkzbh {
	public static void updateYwbh(long permitId) throws PortalException, SystemException {
		String ywbh = "JT";
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		ywbh = ywbh + xmlx.getCode();
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
		ywbh = ywbh + currentDateStr;
		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		List<Long> nums = new ArrayList<Long>();
		for (Permit permit_ : permits) {
			if (Validator.isNotNull(permit_.getYwbh()) && permit_.getYwbh().substring(4, 8).equals(currentDateStr)) {
				nums.add(Long.parseLong(permit_.getYwbh().substring(8, 12)));
			}
		}
		Long num = 0L;
		for (Long num_ : nums) {
			if (num_ > num) {
				num = num_;
			}
		}
		num++;

		if (num / 10 < 1) {
			ywbh = ywbh + "000" + num;
		} else if (num / 100 < 1) {
			ywbh = ywbh + "00" + num;
		} else if (num / 1000 < 1) {
			ywbh = ywbh + "0" + num;
		} else if (num / 10000 < 1) {
			ywbh = ywbh + num;
		}
		permit.setYwbh(ywbh);
		PermitLocalServiceUtil.updatePermit(permit);
	}
}
