package com.justonetech.expert.portlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.expert.model.Jbxx;
import com.justonetech.expert.service.JbxxLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
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
		System.out.println(tabNum);
		renderRequest.setAttribute("tabNum", tabNum);
		super.render(renderRequest, renderResponse);
	}
	
	//保存基本信息
	public void saveJbxx(ActionRequest request,ActionResponse response) throws SystemException, ParseException {
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
		Jbxx jbxx = JbxxLocalServiceUtil.createJbxx(CounterLocalServiceUtil.increment());
		jbxx.setXb(xm);
		jbxx.setXb(xb);
		jbxx.setSfzh(sfzh);
		jbxx.setCsny(csny);
		jbxx.setGzdw(gzdw);
		jbxx.setDzyx(dzyx);
		jbxx.setTxdz(txdz);
		jbxx.setYzbm(yzbm);
		jbxx.setXrzw(xrzw);
		jbxx.setZc(zc);
		jbxx.setZyzg(zyzg);
		jbxx.setCszy(cszy);
		jbxx.setZygznx(zygznx);
		jbxx.setSjhm(sjhm);
		jbxx.setLxdh(lxdh);
		jbxx.setCz(cz);
		JbxxLocalServiceUtil.updateJbxx(jbxx);
	}
}
