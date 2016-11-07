package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContractSearchPortlet
 */
public class ContractSearchPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ContractSearchPortlet.class);

	private static String dateFormatPattern = "yyyy-MM-dd";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		String zzjgdm = "";
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			try {
				long[] roles = user.getRoleIds();
				for(long role:roles){
					if(role == Long.parseLong(PropsUtil.get("jsdw"))){
						zzjgdm = user.getScreenName();
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String bdh = ParamUtil.getString(renderRequest, "bdh");
		String xmmc = ParamUtil.getString(renderRequest, "xmmc");
		String htlb = ParamUtil.getString(renderRequest, "htlb");
		if (htlb.equals("sy")) {
			htlb = "";
		}
		List<Contract> contracts = Collections.emptyList();
		contracts = ContractLocalServiceUtil.getContracts(zzjgdm, bjbh, bdh, xmmc, htlb, "", start, end);
		int contractsCount = 0;
		contractsCount = ContractLocalServiceUtil.getContractsCount(zzjgdm, bjbh, bdh, xmmc, htlb, "");
		renderRequest.setAttribute("contracts", contracts);
		renderRequest.setAttribute("contractsCount", contractsCount);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("bdh", bdh);
		renderRequest.setAttribute("xmmc", xmmc);
		renderRequest.setAttribute("htlb", htlb);
		super.doView(renderRequest, renderResponse);
	}

}
