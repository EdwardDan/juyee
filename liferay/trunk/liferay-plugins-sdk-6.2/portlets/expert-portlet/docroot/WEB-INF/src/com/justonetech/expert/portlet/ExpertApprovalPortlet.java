package com.justonetech.expert.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.expert.model.Expert;
import com.justonetech.expert.model.Zysqlb;
import com.justonetech.expert.service.ExpertLocalServiceUtil;
import com.justonetech.expert.service.ZysqlbLocalServiceUtil;
import com.justonetech.expert.util.ExpertApprovalStatus;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.xml.internal.ws.api.ha.HaInfo;

/**
 * Portlet implementation class ExpertApprovalPortlet
 */
public class ExpertApprovalPortlet extends MVCPortlet {
 
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		String keyword=ParamUtil.getString(renderRequest, "keyword");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<Zysqlb> zysqlbs=Collections.emptyList();
		int zysqlbsCount = 0;
		try {
			zysqlbs = ZysqlbLocalServiceUtil.getZysqlbs(keyword,start, end);
			if(zysqlbs.size()>=0){
				for (Zysqlb zysqlb : zysqlbs) {
					Map<String, Object>map=new HashMap<String, Object>();
					Expert expert=ExpertLocalServiceUtil.getExpert(zysqlb.getExpertId());
					map.put("zysqlbId",zysqlb.getZysqlbId());
					map.put("name",expert.getXm());
					map.put("sex",expert.getXb());
					map.put("expertId",expert.getExpertId());
					map.put("sx",zysqlb.getSx());
					map.put("zy",zysqlb.getZy());
					map.put("zt",ExpertApprovalStatus.getNameByCode(zysqlb.getZt()));
					list.add(map);
				}

			}
			zysqlbsCount =ZysqlbLocalServiceUtil.getZysqlbs(keyword,start, end).size();
		}
		catch (SystemException | PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderRequest.setAttribute("list", list);
		renderRequest.setAttribute("zysqlbs", zysqlbs);
		renderRequest.setAttribute("zysqlbsCount", zysqlbsCount);
		renderRequest.setAttribute("keyword", keyword);
		super.doView(renderRequest, renderResponse);
	}
	
	public void saveAuditInfo(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
		long zysqlbId =ParamUtil.getLong(request, "zysqlbId", 0);
		
		String expertStatus=ParamUtil.getString(request, "expertStatus");
		String shyj=ParamUtil.getString(request, "shyj");
		String shr=ParamUtil.getString(request, "shr");
		Date shrq = ParamUtil.getDate(request, "shrq", new SimpleDateFormat("yyyy-MM-dd"),null);
		if(zysqlbId!=0){
			Zysqlb zysqlb=ZysqlbLocalServiceUtil.getZysqlb(zysqlbId);
			if(Validator.isNotNull(expertStatus)){
				if(expertStatus.equals("preExpert"))
				zysqlb.setZt(ExpertApprovalStatus.STATUS_YB.getCode());
				if(expertStatus.equals("fomalExpert"))
				zysqlb.setZt(ExpertApprovalStatus.STATUS_ZS.getCode());
			}
			zysqlb.setShyj(shyj);
			zysqlb.setShr(shr);
			zysqlb.setShrq(shrq);
			ZysqlbLocalServiceUtil.updateZysqlb(zysqlb);
		}
	}
	
	
	
	
	
	
	

}
