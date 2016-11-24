package com.justonetech.expert.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

}
