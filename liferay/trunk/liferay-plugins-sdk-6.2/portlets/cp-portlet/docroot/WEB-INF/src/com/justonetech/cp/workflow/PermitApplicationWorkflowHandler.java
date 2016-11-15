package com.justonetech.cp.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.cp.util.SendMessage;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
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
    	
    	ServiceContext serviceContext = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        Permit permit = PermitLocalServiceUtil.getPermit(resourcePrimKey);
        ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(resourcePrimKey);
        Dictionary dictionary = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
        String url = PropsUtil.get("sms.hook.path");
        try{
        if(projectProfile.getLxjb().contains("区县级机关或区县级单位")){
        	JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
        	payloadJSON.put("viewURL","/group/gcxm/qushu");
        	if(status==2){
        		permit.setYwbh(updateYwbh(resourcePrimKey));
        		List<User> aaaList = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("qxslzx")));
        		for(User a:aaaList){
        			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==3){
        		List<User> aaaList = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("qxslry")));
        		for(User a:aaaList){
        			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==4){
        		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(permit.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);
        	}
        	if(status==5){
        		List<User> aaaList = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("qxshry")));
        		for(User a:aaaList){
        			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==6){
        		List<User> aaaList = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("qxspry")));
        		for(User a:aaaList){
        			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==7){
        		permit.setSgxkzbh(provideSgxkzbh(resourcePrimKey));
        	}
        	if(status==8||status==9){
        		List<User> aaaList = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("qxslzx")));
        		for(User a:aaaList){
        			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        }else{
        	JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
        	payloadJSON.put("viewURL","/group/gcxm/shishu");
        	if(status==2){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxcsryhgg")));
        			SendMessage.sendMessageByUsers(permit, users, 2,url);
    				for(User a:users){
    					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        		}else{
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxcsrysz")));
        			SendMessage.sendMessageByUsers(permit, users, 2,url);
        			for(User a:users){
    					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        		}
        		permit.setYwbh(updateYwbh(resourcePrimKey));
        	}
        	if(status==3){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfhryhgg")));
        				SendMessage.sendMessageByUsers(permit, users, 3,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}else{
        				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfhrysz")));
        				SendMessage.sendMessageByUsers(permit, users, 3,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        				
        			}
        	}
        	if(status==4){
        		SendMessage.sendMessage(permit, null, 4 , projectProfile.getJsdwsjh(),"",url);
        		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(permit.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);
        	}
        	if(status==5){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxshryhgg")));
        				SendMessage.sendMessageByUsers(permit, users, 5,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}else{
        				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxshrysz")));
        				SendMessage.sendMessageByUsers(permit, users, 5,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}
        	}
        	if(status==6){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxcsryhgg")));
        				SendMessage.sendMessageByUsers(permit, users, 6,url);
        				for(User a:users){
        					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}else{
        				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxcsrysz")));
        				SendMessage.sendMessageByUsers(permit, users, 6,url);
        				for(User a:users){
        					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}
        	}
        	if(status==7){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfgld")));
        		SendMessage.sendMessageByUsers(permit, users, 7,url);
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==8){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfhryhgg")));
        				SendMessage.sendMessageByUsers(permit, users, 8,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}else{
        				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfhrysz")));
        				SendMessage.sendMessageByUsers(permit, users, 8,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}
        	}
        	if(status==9){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxld")));
        		SendMessage.sendMessageByUsers(permit, users, 9,url);
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==10){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("航道")||dictionary.getName().equals("港口设施")){
        			List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxshryhgg")));
        				SendMessage.sendMessageByUsers(permit, users, 10,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}else{
        				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxshrysz")));
        				SendMessage.sendMessageByUsers(permit, users, 10,url);
        				for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        			}
        	}
        	if(status==11){
        		SendMessage.sendMessage(permit, null, 11 , projectProfile.getJsdwsjh(),"JSDW",url);
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("slzx")));
        			SendMessage.sendMessage(permit, users, 11 , "","CA",url);
        			for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==12){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxfgld")));
        		SendMessage.sendMessageByUsers(permit, users, 12,url);
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==13){
        		if(dictionary.getName().equals("公路")||dictionary.getName().equals("市政基础设施-城市道路")){
    				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wjscglcsdl")));
    	SendMessage.sendMessageByUsers(permit, users, 13,url);
    	for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
    			}
    			if(dictionary.getName().equals("港口设施")||dictionary.getName().equals("航道")){
    				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wjscgkhd")));
    	SendMessage.sendMessageByUsers(permit, users, 13,url);
    	for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
    			}
    			if(dictionary.getName().equals("市政基础设施-隧道")){
    				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wjscsd")));
    	SendMessage.sendMessageByUsers(permit, users, 13,url);
    	for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
    			}
    			if(dictionary.getName().equals("市政基础设施-轨道")){
    				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wjscgd")));
    	SendMessage.sendMessageByUsers(permit, users, 13,url);
    	for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
    			}
    			if(dictionary.getName().equals("市政基础设施-公交场站")){
    				List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wjscgj")));
    	SendMessage.sendMessageByUsers(permit, users, 13,url);
    	for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
    			}
        	}
        	if(status==14){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wld")));
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        		SendMessage.sendMessage(permit, users, 14,"","JSC",url);
        		List<User> users2 = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxld")));
        		SendMessage.sendMessage(permit, users2, 14,"","ZXLD",url);
        		permit.setSgxkzbh(provideSgxkzbh(resourcePrimKey));
        	}
        	if(status==15){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("wld")));
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        		SendMessage.sendMessage(permit, users, 15,"","JSC",url);
        		List<User> users2 = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxld")));
        		SendMessage.sendMessage(permit, users2, 15,"","ZXLD",url);
        		permit.setSgxkzbh(provideSgxkzbh(resourcePrimKey));
        	}
        	if(status==16){
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("slzx")));
        		SendMessage.sendMessageByUsers(permit, users, 16,url);
        		for(User a:users){UserNotificationEventLocalServiceUtil.addUserNotificationEvent(a.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);}
        	}
        	if(status==17){
        		SendMessage.sendMessage(permit, null, 17 , projectProfile.getJsdwsjh(),"",url);
        		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(permit.getUserId(), "permitapplication_WAR_cpportlet", (new Date()).getTime(),0L,payloadJSON.toString(), false, serviceContext);
        	}
        	if(status==18){
        		SendMessage.sendMessage(permit, null, 18 , projectProfile.getJsdwsjh(),"JSDW",url);
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("slzx")));
        		SendMessage.sendMessage(permit, users, 18 , "","SLZX",url);
        		List<User> users2 = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxld")));
        		SendMessage.sendMessage(permit, users2, 18,"","ZXLD",url);
        	}
        	if(status==19){
        		SendMessage.sendMessage(permit, null, 19 , projectProfile.getJsdwsjh(),"",url);
        		List<User> users = UserLocalServiceUtil.getRoleUsers(Long.parseLong(PropsUtil.get("jgzxld")));
        		SendMessage.sendMessage(permit, users, 19,"","ZXLD",url);
        	}
        }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        permit.setStatus(status);
        permit.setStatusByUserId(userId);
        permit.setStatusDate(new Date());
        permit=PermitLocalServiceUtil.updatePermit(permit);
            AssetEntryLocalServiceUtil.updateVisible(Permit.class.getName(),
                    resourcePrimKey, true);
        return permit;
    }
    
    public String provideSgxkzbh(long permitId) throws PortalException, SystemException{
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
		return sgxkzbh;
	}
    
    
    public  String updateYwbh(long permitId) throws PortalException, SystemException {
		String ywbh = "JT";
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		ywbh = ywbh + xmlx.getCode();
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
		ywbh = ywbh + currentDateStr;
		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		List<Long> nums = new ArrayList<Long>();
		for (Permit permit_ : permits) {
			if (Validator.isNotNull(permit_.getYwbh()) && permit_.getYwbh().substring(4, 8).equals(currentDateStr)) {
				nums.add(Long.parseLong(permit_.getYwbh().substring(8, 12)));
			}
		}
		Long num = 0L;
		for (Long num_ : nums) {
			if (num_ > num) {
				num = num_;
			}
		}
		num++;

		if (num / 10 < 1) {
			ywbh = ywbh + "000" + num;
		} else if (num / 100 < 1) {
			ywbh = ywbh + "00" + num;
		} else if (num / 1000 < 1) {
			ywbh = ywbh + "0" + num;
		} else if (num / 10000 < 1) {
			ywbh = ywbh + num;
		}
		return ywbh;
	}
}  
