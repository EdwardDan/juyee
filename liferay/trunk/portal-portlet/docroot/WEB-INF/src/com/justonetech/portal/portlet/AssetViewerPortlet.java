package com.justonetech.portal.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AssetViewerPortlet
 */
public class AssetViewerPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String displayPage = preferences.getValue("displayPage", StringPool.BLANK);
		renderRequest.setAttribute("displayPage", displayPage);

		long entryId = ParamUtil.getLong(renderRequest, "entryId", 0);
		if (entryId != 0) {
			try {
				//获取文章的AssetEntry
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(entryId);
				//获取文章对应附件关系表的AssetLink
				List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(assetEntry.getEntryId());
				List lists = new ArrayList();
				//获取附件的AssetEntry和DLFileEntry
				for (AssetLink assetLink : assetLinks) {
					Map map = new HashMap();
					AssetEntry assetEntry_ = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId2());
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntryByUuidAndCompanyId(assetEntry_.getClassUuid(), assetEntry_.getCompanyId());
					System.out.println(dlFileEntry);
					if (assetEntry_ != null && dlFileEntry != null) {
						map.put("assetEntry", assetEntry_);
						map.put("dlFileEntry", dlFileEntry);
					}
					lists.add(map);
				}
				renderRequest.setAttribute("assetEntry", assetEntry);
				renderRequest.setAttribute("lists", lists);
				renderRequest.setAttribute("entryId", entryId);
			} catch (PortalException | SystemException e) {
				e.printStackTrace();
			}
		}

		super.render(renderRequest, renderResponse);
	}

}
