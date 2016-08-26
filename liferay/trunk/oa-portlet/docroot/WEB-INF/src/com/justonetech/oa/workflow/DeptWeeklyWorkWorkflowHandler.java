package com.justonetech.oa.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
public class DeptWeeklyWorkWorkflowHandler extends BaseWorkflowHandler {   
  
    public static final String CLASS_NAME = DeptWork.class.getName();   
    @Override  
    public String getClassName() {   
        return CLASS_NAME;   
    }   
   
    @Override  
    public String getType(Locale locale) {   
        return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);   
    }   
  
    public  DeptWork updateStatus(int status,
            Map<String, Serializable> workflowContext) throws PortalException,
            SystemException {
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        DeptWork deptWork = DeptWorkLocalServiceUtil.getDeptWork(resourcePrimKey);
        deptWork.setStatus(status);
        deptWork.setStatusByUserId(userId);
        //statusByUserName应放置在此处
        deptWork.setStatusDate(new Date());
        deptWork=DeptWorkLocalServiceUtil.updateDeptWork(deptWork);
//        if (status == WorkflowConstants.STATUS_APPROVED) {
        //不用批准也可以查看
            AssetEntryLocalServiceUtil.updateVisible(DeptWork.class.getName(),
                    resourcePrimKey, true);
//        } else {
//        	AssetEntryLocalServiceUtil.updateVisible(VehicleApplication.class.getName(),
//                    resourcePrimKey, false);
//        }
        return deptWork;
    }
    
  
}  
