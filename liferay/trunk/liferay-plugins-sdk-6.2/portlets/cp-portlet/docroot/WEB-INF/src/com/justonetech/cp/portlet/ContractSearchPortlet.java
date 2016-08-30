
package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.contract.model.Contract;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContractSearchPortlet
 */
public class ContractSearchPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ContractSearchPortlet.class);

	private static String dateFormatPattern = "yyyy-MM-dd";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		List<Contract> contracts = null;
		int contractsCount = 0;

		renderRequest.setAttribute("contracts", contracts);
		renderRequest.setAttribute("contractsCount", contractsCount);
		super.doView(renderRequest, renderResponse);
	}

}
