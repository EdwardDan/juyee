package com.justonetech.oa.asset;

import com.justonetech.oa.model.VehicleApplication;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;


public class VehicleApplicationAssetRenderFactory extends BaseAssetRendererFactory {   
    
	 public static final String CLASS_NAME = VehicleApplication.class.getName();   
	 public static final String TYPE = "VehicleApplication";   
	    
	  @Override
	    public AssetRenderer getAssetRenderer(long classPK, int type)
	            throws PortalException, SystemException {
		  VehicleApplication vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(classPK);
	        return new VehicleApplicationAssetRender(vehicleApplication);
	    }
	 
	 
//	 @Override  
//	 public AssetRenderer getAssetRenderer(long classPk, int type)   
//	         throws PortalException, SystemException {   
//	     int status = WorkflowConstants.STATUS_ANY;   
//	     /**
//	      * 如果需要根据不同的状态获取不同的内容，可以在此进行设置  
//	      */  
//	     if (type == TYPE_LATEST_APPROVED) {   
//	         status = WorkflowConstants.STATUS_APPROVED;   
//	     }   
//	        s
//	     VehicleApplication vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(classPk);   
//	     return new VehicleApplicationAssetRender(vehicleApplication);   
//	 }   

	 @Override  
	 public String getClassName() {   
	     return CLASS_NAME;   
	 }   

	 @Override 
	 public String getType() {   
	     return TYPE;   
	 }
	}
