package com.justonetech.oa.asset;

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.service.DeptWorkItemLocalServiceUtil;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;


public class DeptWeeklyWorkAssetRenderFactory extends BaseAssetRendererFactory {   
    
	 public static final String CLASS_NAME = DeptWork.class.getName();   
	 public static final String TYPE = "VehicleApplication";   
	    
	  @Override
	    public AssetRenderer getAssetRenderer(long classPK, int type)
	            throws PortalException, SystemException {
		  DeptWork deptWork = DeptWorkLocalServiceUtil.getDeptWork(classPK);
	        return new DeptWeeklyWorkAssetRender(deptWork);
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
//	        
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
