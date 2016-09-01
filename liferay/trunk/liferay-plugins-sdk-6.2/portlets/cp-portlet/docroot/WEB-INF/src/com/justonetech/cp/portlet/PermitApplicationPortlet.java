
package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PermitApplicationPortlet
 */
public class PermitApplicationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/permit-application/select-contract.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String bdh = ParamUtil.getString(renderRequest, "bdh");
			String htmc = ParamUtil.getString(renderRequest, "htmc");
			List<Contract> contracts = new ArrayList<Contract>();
			int contractsCount = 0;
			renderRequest.setAttribute("contracts", contracts);
			renderRequest.setAttribute("contractsCount", contractsCount);
		}else if (Validator.equals(mvcPath, "/portlet/permit-application/edit-permit.jsp")) {

//			String projectId = ParamUtil.getString(renderRequest, "projectId", "");
//			long contractId = ParamUtil.getLong(renderRequest, "contractId", 0);
//			long permitId = ParamUtil.getLong(renderRequest, "permitId", 0);
//			Project project = null;
//			Contract contract = null;
//			Permit permit = null;
			int sqbz = ParamUtil.getInteger(renderRequest, "sqbz",1);
			renderRequest.setAttribute("sqbz", sqbz);
//			if(sqbz==1){
//				
//			}else if(sqbz==2){
//				
//			}else if(sqbz==3){
//				
//			}else if(sqbz==4){
//				
//			}
//			try {
//				project = ProjectLocalServiceUtil.getProject(projectId);
//				contract = ContractLocalServiceUtil.getContract(contractId);
//				permit = PermitLocalServiceUtil.getPermit(permitId);
//				
//				sqbz = permit.getSqbz();
//			}
//			catch (PortalException | SystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			


//			String bdh = ParamUtil.getString(renderRequest, "bdh");
//			String htmc = ParamUtil.getString(renderRequest, "htmc");
//			List<Contract> contracts = new ArrayList<Contract>();
//			int contractsCount = 0;
//			renderRequest.setAttribute("contracts", contracts);
//			renderRequest.setAttribute("contractsCount", contractsCount);
		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String zzjgdm =ParamUtil.getString(renderRequest, "zzjgdm");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;

		List<Permit> permits = new ArrayList<Permit>();
		int permitsCount = 0;
		permits = PermitLocalServiceUtil.getPermits(zzjgdm, bjbh, wssqbh, gcmc, start, end);
		permitsCount = PermitLocalServiceUtil.getPermitsCount(zzjgdm, bjbh, wssqbh, gcmc);
		renderRequest.setAttribute("permits", permits);
		renderRequest.setAttribute("permitsCount", permitsCount);
		super.doView(renderRequest, renderResponse);
	}
}
