package com.justonetech.cp.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.permit.model.Permit;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class PermitApplicationAssetRender extends BaseAssetRenderer {   
    public static final String CLASS_NAME = Permit.class.getName();   
       
    public PermitApplicationAssetRender(Permit permit){   
        _permit = permit;   
    }   
    @Override  
    public long getClassPK() {   
        return _permit.getPermitId();   
    }   
  
    @Override  
    public long getGroupId() {   
        return _permit.getGroupId();   
    }   
  
    @Override  
    public String getSummary(Locale arg0) {   
        return HtmlUtil.stripHtml(_permit.getContent());   
    }   
  
    @Override  
    public String getTitle(Locale arg0) {   
        return _permit.getTitle();   
    }   
  
    @Override  
    public long getUserId() {   
        return _permit.getUserId();   
    }   
  
    @Override  
    public String getUserName() {   
        return _permit.getUserName();   
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
                "permit", _permit);   
  
            return "/portlet/permit-application/" + template + ".jsp";   
        }   
        else {   
            return null;   
        }   
    }   
  
    private Permit _permit;

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