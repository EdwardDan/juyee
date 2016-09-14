package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.justonetech.cp.complete.model.Complete;
import com.justonetech.cp.complete.service.CompleteLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CompleteApprovalPortlet
 */
public class CompleteApprovalPortlet extends MVCPortlet {

	public void saveComplete(ActionRequest request,ActionResponse response) throws SystemException, PortalException,IOException {
		long completeId = ParamUtil.getLong(request, "completeId");
		String shyj=ParamUtil.getString(request, "shyj");
		int status=ParamUtil.getInteger(request, "status");
		User user = PortalUtil.getUser(request);
		Complete complete=CompleteLocalServiceUtil.getComplete(completeId);
		complete.setShr(user.getFirstName());
		complete.setShrq(new Date());
		complete.setStatus(status);
		complete.setShyj(shyj);
		CompleteLocalServiceUtil.updateComplete(complete);
	}

}
