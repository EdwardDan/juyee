package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import sun.invoke.empty.Empty;

import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.xml.internal.ws.message.StringHeader;

/**
 * Portlet implementation class PermitApprovalPortlet
 */
public class PermitApprovalPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	// 保存收件sj
	public void saveSj(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		String slbh = ParamUtil.getString(request, "slbh");
		String cltjr = ParamUtil.getString(request, "cltjr");
		String hjgsz = ParamUtil.getString(request, "hjgsz");
		String hjgsh = ParamUtil.getString(request, "hjgsh");
		String cltjrlxdh = ParamUtil.getString(request, "cltjrlxdh");
		String sqr = ParamUtil.getString(request, "sqr");
		String cltjrlxdz = ParamUtil.getString(request, "cltjrlxdz");
		String sqsx = ParamUtil.getString(request, "sqsx");
		String sjr = ParamUtil.getString(request, "sjr");
		String sqh = ParamUtil.getString(request, "sqh");
		String sjrlxdh = ParamUtil.getString(request, "sjrlxdh");
		permit.setSlbh(slbh);
		permit.setCltjr(cltjr);
		try {
			permit.setHjgsz(Integer.parseInt(hjgsz));
			permit.setHjgsh(Integer.parseInt(hjgsh));
		} catch (Exception e) {
			// TODO: handle exception
		}

		permit.setCltjrlxdh(cltjrlxdh);
		permit.setSqr(sqr);
		permit.setCltjrlxdz(cltjrlxdz);
		permit.setSqsx(sqsx);
		permit.setSjr(sjr);
		permit.setSqh(sqh);
		permit.setSjrlxdh(sjrlxdh);
		PermitLocalServiceUtil.updatePermit(permit);
//		redirect(request, response);
	}

	// 保存初审cs和sl
	public void saveCs(ActionRequest request, ActionResponse response) throws SystemException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] csyjs = ParamUtil.getParameterValues(request, "csyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setCsyj(csyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
	}
	// 保存复核fh和sh
	public void saveFh(ActionRequest request, ActionResponse response) throws SystemException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] fhyjs = ParamUtil.getParameterValues(request, "fhyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setFhyj(fhyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
	}
	
	// 保存审核sh和sp
		public void saveSh(ActionRequest request, ActionResponse response) throws SystemException {
			long permitId = ParamUtil.getLong(request, "permitId");
			List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
			String[] shyjs = ParamUtil.getParameterValues(request, "shyj");
			int i = 0;
			for (ApplyMaterial applyMaterial : applyMaterials) {
				applyMaterial.setShyj(shyjs[i]);
				i++;
				ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
			}
		}
		
//		public void redirect(ActionRequest request, ActionResponse response) throws IOException {
//			String redirect = ParamUtil.getString(request, "redirectURL");
//			System.out.println("======================"+redirect);
//			response.sendRedirect(redirect);
//		}
}
