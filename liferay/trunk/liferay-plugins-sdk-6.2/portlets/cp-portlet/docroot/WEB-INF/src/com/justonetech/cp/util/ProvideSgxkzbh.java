package com.justonetech.cp.util;

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

public class ProvideSgxkzbh {
	public static void provideSgxkzbh(long permitId) throws PortalException, SystemException{
		String sgxkzbh = "JT";//JT
		Permit permit1 = PermitLocalServiceUtil.getPermit(permitId);
		sgxkzbh = sgxkzbh + permit1.getBjbh() + permit1.getBdh();//报建编号+标段号
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4);
		sgxkzbh = sgxkzbh + currentDateStr;//两位年份
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		sgxkzbh = sgxkzbh + xmlx.getCode();//类别
		
		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		int num = 1;
		for(Permit permit2:permits){
			if(permit2.getSgxkzbh()!=null&&permit2.getSgxkzbh()!=""){
				String bjbh = permit2.getSgxkzbh().substring(2, 12);
				if(bjbh.equals(permit1.getBjbh())){
					num++;
				}
			}
		}
		if (num / 10 < 1) {
			sgxkzbh = sgxkzbh + "00" + num;
		} else if (num / 100 < 1) {
			sgxkzbh = sgxkzbh + "0" + num;
		} else if (num / 1000 < 1) {
			sgxkzbh = sgxkzbh + num;
		}
		permit1.setSgxkzbh(sgxkzbh);
		com.justonetech.cp.permit.service.PermitLocalServiceUtil.updatePermit(permit1);
	}
}
