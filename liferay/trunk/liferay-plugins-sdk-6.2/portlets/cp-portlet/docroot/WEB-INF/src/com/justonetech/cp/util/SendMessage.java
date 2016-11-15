package com.justonetech.cp.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;

public class SendMessage {
	// 状态对应编码

	private static String messageContent(int status, String commonContent,String type) {
		String content = "";
		if (status == CityPermitStatus.STATUS_SB.getCode()) {
			content += commonContent + "申请已提交，请进行初审。";
		}
		if (status == CityPermitStatus.STATUS_CS_PASS.getCode()) {
			content += commonContent + "初审已完成，请进行复核。";
		}
		if (status == CityPermitStatus.STATUS_CS_BACK.getCode()) {
			content += commonContent + "未通过审核，请在系统中修改后提交。";
		}
		if (status == CityPermitStatus.STATUS_FH_PASS.getCode()) {
			content += commonContent + "复核已完成，请进行审核。";
		}
		if (status == CityPermitStatus.STATUS_FH_BACK.getCode()) {
			content += commonContent + "未通过复核，请重新进行初审。";
		}
		if (status == CityPermitStatus.STATUS_SH_PASS.getCode()) {
			content += commonContent + "审核已完成，请进行审定。";
		}
		if (status == CityPermitStatus.STATUS_SH_BACK.getCode()) {
			content += commonContent + "未通过审核，请重新进行复核。";
		}
		if (status == CityPermitStatus.STATUS_FGLD_PASS.getCode()) {
			content += commonContent + "审定已完成，请进行审查。";
		}

		if (status == CityPermitStatus.STATUS_FGLD_BACK.getCode()) {
			content += commonContent + "未通过审定，请重新进行审核。";
		}
		if (status == CityPermitStatus.STATUS_ZXLD_PASS.getCode()) {
			if(type.equals("JSDW")){
				content += commonContent + "已通过审核，请将纸质材料送至行政服务中心。";		
			}else{
				content += commonContent + "已通过审核，请准备收件。";
			}
		}
		if (status == CityPermitStatus.STATUS_ZXLD_BACK.getCode()) {
			content += commonContent + "未通过审查，请重新进行审定。";
		}
		if (status == CityPermitStatus.STATUS_SJ_PASS.getCode()) {
			content += commonContent + "审查已完成，请委建设处进行审查。";
		}
		
		if (status == CityPermitStatus.STATUS_JSC_XK.getCode() || status == CityPermitStatus.STATUS_JSC_BXK.getCode()) {
			if(type.equals("JSC")){
				content += commonContent + "委建设处审查已完成，请委领导进行审查。";
			}
			if(type.equals("ZXLD")){
				content += commonContent + "委建设处审查已完成。";		
			}
		}
		if (status == CityPermitStatus.STATUS_JSC_BACK.getCode()) {
			content += commonContent + "书面材料不全，请联系申报人补正材料。";
		}
		if (status == CityPermitStatus.STATUS_SJ_BACK.getCode()) {
			content += commonContent + "未通过审核，请在系统中修改后提交。";
		}
		if (status == CityPermitStatus.STATUS_WLD_PASS.getCode()) {
			if(type.equals("JSDW")){
				content += commonContent + "审查已完成，请至交通委行政服务中心领证。";		
			}
			if(type.equals("SLZX")){
				content += commonContent + "审查已完成，请准备好施工许可证。";
			}
			if(type.equals("ZXLD")){
				content += commonContent + "委领导审查已完成。";
			}
		}
		if (status == CityPermitStatus.STATUS_WLD_BACK.getCode()) {
			if(type.equals("ZXLD")){
				content += commonContent +"委领导审查已完成。";
			}else{
				content += commonContent + "不予行政许可。";
			}
		}

		return content;
	}

	public static void sendMessageByUsers(Permit permit, List<User> userList, int status,String url) throws ClientProtocolException, IOException {
		sendMessage(permit, userList, status, "","",url);
	}

	public static void sendMessage(Permit permit, List<User> userList, int status, String mobiles,String type,String url) throws ClientProtocolException, IOException {
		// String mobiles = "";// 发送信息的电话号码
		if (null != userList && userList.size() > 0) {
			for (User user : userList) {
				try {
					if (null != user.getPhones() && user.getPhones().size() > 0) {
						for (Phone phone : user.getPhones()) {
							mobiles += "," + phone.getNumber();
						}
					}

				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mobiles = mobiles.length() > 0 ? mobiles.substring(1) : "";
		}
		ProjectProfile projectProfile = null;
		try {
			projectProfile = ProjectProfileLocalServiceUtil.fetchProjectProfile(permit.getPermitId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String commonContent = "报建编号" + permit.getBjbh() + ",标段号" + permit.getBdh() + "，项目名称为"
				+ (null != projectProfile ? projectProfile.getGcmc() : "") + "的项目施工许可";

		String content = messageContent(status, commonContent,type);// 短信
		if (mobiles.length() > 0) {
			sendSMS(url,content,mobiles);
//			SendKxt.SendKxtSMS(content, mobiles);
		}
	}
	
	public static void sendSMS(String url,String content,String mobiles)
			throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url + "/sendSMSServlet?content="+content+"&mobiles="+mobiles);
		httpClient.execute(httpGet);
	}
}
