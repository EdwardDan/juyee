package com.justonetech.expert.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.expert.model.Expert;
import com.justonetech.expert.service.ExpertLocalServiceUtil;
import com.justonetech.expert.service.XlxxLocalServiceUtil;
import com.justonetech.expert.service.ZysqlbLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExpertApplicationPortlet
 */
public class ExpertApplicationPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		String tabNum = ParamUtil.get(renderRequest, "tabNum", "1");
		renderRequest.setAttribute("tabNum", tabNum);
		super.render(renderRequest, renderResponse);
	}


	public void deleteExpert(ActionRequest request,ActionResponse response) throws NumberFormatException, PortalException, SystemException{
		String expertId = ParamUtil.get(request, "expertId", "");
		if(expertId!=""){
			Expert expert = ExpertLocalServiceUtil.getExpert(Long.parseLong(expertId));
			ExpertLocalServiceUtil.deleteExpert(expert);
		}
	}

	
	//保存基本信息
	public void saveJbxx(ActionRequest request,ActionResponse response) throws SystemException, ParseException, PortalException, IOException {
		String xm = ParamUtil.getString(request, "xm");
		String xb = ParamUtil.getString(request, "xb");
		String sfzh = ParamUtil.getString(request, "sfzh");
		String csnyStr = sfzh.substring(6, 10)+"-"+sfzh.substring(10, 12);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		java.util.Date csny = sdf.parse(csnyStr);
		String gzdw = ParamUtil.getString(request, "gzdw");
		String dzyx = ParamUtil.getString(request, "dzyx");
		String txdz = ParamUtil.getString(request, "txdz");
		String yzbm = ParamUtil.getString(request, "yzbm");
		String xrzw = ParamUtil.getString(request, "xrzw");
		String zc = ParamUtil.getString(request, "zc");
		String zyzg = ParamUtil.getString(request, "zyzg");
		String cszy = ParamUtil.getString(request, "cszy");
		String zygznx = ParamUtil.getString(request, "zygznx");
		String sjhm = ParamUtil.getString(request, "sjhm");
		String lxdh = ParamUtil.getString(request, "lxdh");
		String cz = ParamUtil.getString(request, "cz");
		long expertId = ParamUtil.getLong(request, "expertId");
		Expert expert = null;
		if(Validator.isNotNull(expertId)){
			expert = ExpertLocalServiceUtil.getExpert(expertId);
		}else{
			expert = ExpertLocalServiceUtil.createExpert(CounterLocalServiceUtil.increment());
		}
		expert.setXm(xm);
		expert.setXb(xb);
		expert.setSfzh(sfzh);
		expert.setCsny(csny);
		expert.setGzdw(gzdw);
		expert.setDzyx(dzyx);
		expert.setTxdz(txdz);
		expert.setYzbm(yzbm);
		expert.setXrzw(xrzw);
		expert.setZc(zc);
		expert.setZyzg(zyzg);
		expert.setCszy(cszy);
		expert.setZygznx(zygznx);
		expert.setSjhm(sjhm);
		expert.setLxdh(lxdh);
		expert.setCz(cz);
		expert.setSqbz(1);
		ExpertLocalServiceUtil.updateExpert(expert);
		redirect(request, response, expert, 1);
	}
	public void redirect(ActionRequest request, ActionResponse response, Expert expert, int sqbz) throws IOException {
		String redirect = ParamUtil.getString(request, "redirectURL");
		System.out.println("==============="+redirect);
		int tabNum = 1;
		if (expert.getSqbz() == sqbz && sqbz < 5) {
			tabNum = sqbz + 1;
		} else if (expert.getSqbz() == sqbz && sqbz == 4) {
			tabNum = sqbz;
		} else if (expert.getSqbz() > sqbz) {
			tabNum = sqbz;
		}
		redirect += "&" + response.getNamespace() + "experetId=" + expert.getExpertId();
		redirect += "&" + response.getNamespace() + "tabNum=" + tabNum;
		response.sendRedirect(redirect);
	}
}
