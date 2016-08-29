package com.justonetech.oa.asset;

import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class OfficeSupplyApplicationAssetRenderFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = OfficeSupplyApplication.class.getName();
	public static final String TYPE = "OfficeSupplyApplication";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.getOfficeSupplyApplication(classPK);
		return new OfficeSupplyApplicationAssetRender(officeSupplyApplication);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
}
