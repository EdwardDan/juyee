package com.justonetech.oa.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

public class OfficeSupplyApplicationWorkflowHandler extends BaseWorkflowHandler{
	public static final String CLASS_NAME = OfficeSupplyApplication.class.getName();   
    @Override  
    public String getClassName() {   
        return CLASS_NAME;   
    }   
   
    @Override  
    public String getType(Locale locale) {   
        return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);   
    }   
  
    public  OfficeSupplyApplication updateStatus(int status,
            Map<String, Serializable> workflowContext) throws PortalException,
            SystemException {
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil.getOfficeSupplyApplication(resourcePrimKey);
        System.out.println("status="+status);
        officeSupplyApplication.setStatus(status);
        officeSupplyApplication.setStatusByUserId(userId);
        //statusByUserName应放置在此处
        officeSupplyApplication.setStatusDate(new Date());
        officeSupplyApplication=OfficeSupplyApplicationLocalServiceUtil.updateOfficeSupplyApplication(officeSupplyApplication);
//        if (status == WorkflowConstants.STATUS_APPROVED) {
        //不用批准也可以查看
            AssetEntryLocalServiceUtil.updateVisible(OfficeSupplyApplication.class.getName(),
                    resourcePrimKey, true);
//        } else {
//        	AssetEntryLocalServiceUtil.updateVisible(VehicleApplication.class.getName(),
//                    resourcePrimKey, false);
//        }
        return officeSupplyApplication;
    }
}
