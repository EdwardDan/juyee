package com.justonetech.oa.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.VehicleApplication;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class VehicleApplicationAssetRender extends BaseAssetRenderer {   
    public static final String CLASS_NAME = VehicleApplication.class.getName();   
       
    public VehicleApplicationAssetRender(VehicleApplication vehicleApplication){   
        _vehicleApplication = vehicleApplication;   
    }   
    @Override  
    public long getClassPK() {   
        return _vehicleApplication.getVehicleApplicationId();   
    }   
  
    @Override  
    public long getGroupId() {   
        return _vehicleApplication.getGroupId();   
    }   
  
    @Override  
    public String getSummary(Locale arg0) {   
        return HtmlUtil.stripHtml(_vehicleApplication.getContent());   
    }   
  
    @Override  
    public String getTitle(Locale arg0) {   
        return _vehicleApplication.getTitle();   
    }   
  
    @Override  
    public long getUserId() {   
        return _vehicleApplication.getUserId();   
    }   
  
    @Override  
    public String getUserName() {   
        return _vehicleApplication.getUserName();   
    }   
  
//    @Override  
//    public String getUuid() {   
//        return _vehicleApplication.getUuid();   
//    }   
//  
    @Override  
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template)   
            throws Exception {   
        if (template.equals(TEMPLATE_FULL_CONTENT)) {   
            renderRequest.setAttribute(   
                "vehicleApplication", _vehicleApplication);   
  
            return "/portlet/vehicle-application/" + template + ".jsp";   
        }   
        else {   
            return null;   
        }   
    }   
  
    private VehicleApplication _vehicleApplication;

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}   
}  