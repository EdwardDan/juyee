package com.justonetech.cp.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
public class PermitApplicationWorkflowHandler extends BaseWorkflowHandler {   
  
    public static final String CLASS_NAME = Permit.class.getName();   
    @Override  
    public String getClassName() {   
        return CLASS_NAME;   
    }   
   
    @Override  
    public String getType(Locale locale) {   
        return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);   
    }   
  
    public  Permit updateStatus(int status,
            Map<String, Serializable> workflowContext) throws PortalException,
            SystemException {
    	
    	
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        Permit permit = PermitLocalServiceUtil.getPermit(resourcePrimKey);
        ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(resourcePrimKey);
        if(projectProfile.getLxjb().contains("区县级机关或区县级单位")){
        	if(status==7){
        		provideSgxkzbh(resourcePrimKey);
        	}
        }else{
        	if(status==21){
        		provideSgxkzbh(resourcePrimKey);
        	}
        }
        
        permit.setStatus(status);
        permit.setStatusByUserId(userId);
        permit.setStatusDate(new Date());
        permit=PermitLocalServiceUtil.updatePermit(permit);
            AssetEntryLocalServiceUtil.updateVisible(Permit.class.getName(),
                    resourcePrimKey, true);
        return permit;
    }
    
    public static void provideSgxkzbh(long permitId) throws PortalException, SystemException{
		String sgxkzbh = "JT";//JT
		Permit permit1 = PermitLocalServiceUtil.getPermit(permitId);
		sgxkzbh = sgxkzbh + permit1.getBjbh() + permit1.getBdh()+"-";//报建编号+标段号
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4);
		sgxkzbh = sgxkzbh + currentDateStr;//两位年份
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		sgxkzbh = sgxkzbh + xmlx.getCode();//类别
		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		int num = 1;
		for(Permit permit2:permits){
			if(permit2.getSgxkzbh().trim()!=null&&permit2.getSgxkzbh().trim()!=""&&permit2.getSgxkzbh().length()>12){
				String bjbh = permit2.getSgxkzbh().substring(2, 12);
				System.out.println("bjbh="+bjbh);
				if(bjbh.equals(permit1.getBjbh())){
					num++;
				}
			}
		}
		if (num / 10 < 1) {
			sgxkzbh = sgxkzbh + "00" + num;
		} else if (num / 100 < 1) {
			sgxkzbh = sgxkzbh + "0" + num;
		} else if (num / 1000 < 1) {
			sgxkzbh = sgxkzbh + num;
		}
		permit1.setSgxkzbh(sgxkzbh);
		com.justonetech.cp.permit.service.PermitLocalServiceUtil.updatePermit(permit1);
	}
}  
