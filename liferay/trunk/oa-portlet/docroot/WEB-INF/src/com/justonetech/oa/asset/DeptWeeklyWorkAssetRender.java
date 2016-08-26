package com.justonetech.oa.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.DeptWork;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class DeptWeeklyWorkAssetRender extends BaseAssetRenderer {   
    public static final String CLASS_NAME = DeptWork.class.getName();   
    private DeptWork _deptWork;
    
    public DeptWeeklyWorkAssetRender(DeptWork deptWork){   
        _deptWork = deptWork;   
    }   
    @Override  
    public long getClassPK() {   
        return _deptWork.getDeptWorkId();   
    }   
  
    @Override  
    public long getGroupId() {   
        return _deptWork.getGroupId();   
    }   
  
    @Override  
    public String getSummary(Locale arg0) {   
        return HtmlUtil.stripHtml(_deptWork.getContent());   
    }   
  
    @Override  
    public String getTitle(Locale arg0) {   
        return _deptWork.getTitle();   
    }   
  
    @Override  
    public long getUserId() {   
        return _deptWork.getUserId();   
    }   
  
    @Override  
    public String getUserName() {   
        return _deptWork.getUserName();   
    }   
  
//    @Override  
//    public String getUuid() {   
//        return _deptWork.getUuid();   
//    }   
//  
    @Override  
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template)   
            throws Exception {   
        if (template.equals(TEMPLATE_FULL_CONTENT)) {   
            renderRequest.setAttribute(   
                "deptWork", _deptWork);   
  
            return "/portlet/vehicle-application/" + template + ".jsp";   
        }   
        else {   
            return null;   
        }   
    }   
  
    

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