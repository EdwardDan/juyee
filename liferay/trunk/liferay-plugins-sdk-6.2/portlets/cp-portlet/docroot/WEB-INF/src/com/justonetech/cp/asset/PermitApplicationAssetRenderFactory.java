package com.justonetech.cp.asset;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;


public class PermitApplicationAssetRenderFactory extends BaseAssetRendererFactory {   
    
	 public static final String CLASS_NAME = Permit.class.getName();   
	 public static final String TYPE = "Permit";   
	    
	  @Override
	    public AssetRenderer getAssetRenderer(long classPK, int type)
	            throws PortalException, SystemException {
		  Permit permit = PermitLocalServiceUtil.getPermit(classPK);
	        return new PermitApplicationAssetRender(permit);
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
