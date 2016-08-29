package com.justonetech.oa.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.model.VehicleApplication;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class OfficeSupplyApplicationAssetRender extends BaseAssetRenderer{
	public static final String CLASS_NAME = VehicleApplication.class.getName();   
    
    public OfficeSupplyApplicationAssetRender(OfficeSupplyApplication officeSupplyApplication){   
        _officeSupplyApplication = officeSupplyApplication;   
    }   
    @Override  
    public long getClassPK() {   
        return _officeSupplyApplication.getOfficeSupplyApplicationId();   
    }   
  
    @Override  
    public long getGroupId() {   
        return _officeSupplyApplication.getGroupId();   
    }   
  
    @Override  
    public String getSummary(Locale arg0) {   
        return HtmlUtil.stripHtml(_officeSupplyApplication.getContent());   
    }   
  
    @Override  
    public String getTitle(Locale arg0) {   
        return _officeSupplyApplication.getTitle();   
    }   
  
    @Override  
    public long getUserId() {   
        return _officeSupplyApplication.getUserId();   
    }   
  
    @Override  
    public String getUserName() {   
        return _officeSupplyApplication.getUserName();   
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
                "vehicleApplication", _officeSupplyApplication);   
  
            return "/portlet/vehicle-application/" + template + ".jsp";   
        }   
        else {   
            return null;   
        }   
    }   
  
    private OfficeSupplyApplication _officeSupplyApplication;

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
