package com.justonetech.cp.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
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
    	Thread thread = new Thread();
    	try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        Permit permit = PermitLocalServiceUtil.getPermit(resourcePrimKey);
        permit.setStatus(status);
        permit.setStatusByUserId(userId);
        permit.setStatusDate(new Date());
        permit=PermitLocalServiceUtil.updatePermit(permit);
            AssetEntryLocalServiceUtil.updateVisible(Permit.class.getName(),
                    resourcePrimKey, true);
        return permit;
    }
    
  
}  
