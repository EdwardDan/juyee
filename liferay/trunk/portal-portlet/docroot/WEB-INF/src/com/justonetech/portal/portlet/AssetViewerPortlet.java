package com.justonetech.portal.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AssetViewerPortlet
 */
public class AssetViewerPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String displayPage = preferences.getValue("displayPage",
				StringPool.BLANK);
		renderRequest.setAttribute("displayPage", displayPage);
		
		long entryId = ParamUtil.getLong(renderRequest, "entryId", 0);
		if (entryId != 0) {
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil
						.getEntry(entryId);
				renderRequest.setAttribute("assetEntry", assetEntry);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}

		super.render(renderRequest, renderResponse);
	}

}
