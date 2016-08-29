package com.justonetech.oa.notification;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;

public class VehicleApplicationNotificationHandler extends BaseUserNotificationHandler{
	public static final String PORTLET_ID = "vehicleapplication_WAR_oaportlet";
    
    public VehicleApplicationNotificationHandler() {
  
        setPortletId(com.justonetech.oa.notification.VehicleApplicationNotificationHandler.PORTLET_ID);
  
    }
  
    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
  
        JSONObject jsonObject = JSONFactoryUtil
                .createJSONObject(userNotificationEvent.getPayload());
//        String picTime = jsonObject
//                .getString("picTime");
//        String temperature = jsonObject.getString("temperature");
        String title = "<strong>"
               +"您有一个车辆申请审核任务，快去处理！"
                + "</strong>";
        String bodyText = "点击查看";
        StringBundler sb = new StringBundler(5);
        sb.append("<div class=\"title\">");
        sb.append(title);
        sb.append("</div> <div ");
        sb.append("class=\"body\">");
        sb.append(bodyText);
        sb.append("</div>");
        return sb.toString();
    }
  
    @Override
    protected String getLink(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
  
        JSONObject jsonObject = JSONFactoryUtil
                .createJSONObject(userNotificationEvent.getPayload());
        return jsonObject.getString("viewURL");
    }
  
    protected String getBodyTemplate() throws Exception {
        StringBundler sb = new StringBundler(5);
        sb.append("<div class=\"title\">[$TITLE$]</div><div "); sb.append("class=\"body\">[$BODY_TEXT$]</div>");
        return sb.toString();
    }
}

