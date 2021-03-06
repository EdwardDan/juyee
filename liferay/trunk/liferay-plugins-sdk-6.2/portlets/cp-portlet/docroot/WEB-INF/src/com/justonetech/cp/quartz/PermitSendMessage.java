package com.justonetech.cp.quartz;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class PermitSendMessage implements MessageListener {
	@Override
	public void receive(Message message) {
		
		try {
			doReceive(message);
		} catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		_log.info(new Date() + "定时器任务已启动");
		String url=PropsUtil.get("sms.hook.path");
		long[] xmlxLongs = new long[7];
		xmlxLongs[0] = 29740;
		xmlxLongs[1] = 29741;
		xmlxLongs[2] = 29742;
		xmlxLongs[3] = 29743;
		xmlxLongs[4] = 43840;
		xmlxLongs[5] = 43841;
		xmlxLongs[6] = 43842;
		List<Permit> permitSs = PermitLocalServiceUtil.getPermits("", "", "",
				xmlxLongs, "", "shwc", "市属", -1, -1);
		for (Permit permitInitSs : permitSs) {
			ProjectProfile projectProfileInitSs = ProjectProfileLocalServiceUtil
					.getProjectProfile(permitInitSs.getPermitId());
			if (projectProfileInitSs.getXmxz() == Long.parseLong(PropsUtil.get("green"))) {
				if (null != projectProfileInitSs.getZsqxjs()) {
					Long day = daysOfTwo(new Date(),
							projectProfileInitSs.getZsqxjs());
					if (day.equals(new Long(30))) {
						String content = "报建编号" + permitInitSs.getBjbh()
								+ ",标段号" + permitInitSs.getBdh() + "，项目名称为"
								+ projectProfileInitSs.getGcmc()
								+ "的项目施工许可还有一个月就要到期，请尽快处理。";
						System.out.println(content);
						// 申请人
//						SendKxt.SendKxtSMS(content,
//								projectProfileInitSs.getJsdwsjh());
						sendSMS(url, content, projectProfileInitSs.getJsdwsjh());
					}
					if (day.equals(new Long(0))) {
						String content = "报建编号" + permitInitSs.getBjbh()
								+ ",标段号" + permitInitSs.getBdh() + "，项目名称为"
								+ projectProfileInitSs.getGcmc()
								+ "的项目施工许可已到期。";
						System.out.println(content);
						Dictionary dictionary = DictionaryLocalServiceUtil
								.getDictionary(projectProfileInitSs.getXmlx());
						// 申请人
//						SendKxt.SendKxtSMS(content,
//								projectProfileInitSs.getJsdwsjh());
						sendSMS(url, content, projectProfileInitSs.getJsdwsjh());
						// 初审人员
						if (dictionary.getName().equals("公路")
								|| dictionary.getName().equals("航道")
								|| dictionary.getName().equals("港口设施")) {
							List<User> csUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxcsryhgg")));
							sendQuartzMessage(content, csUsers, "",url);
							List<User> fhUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxfhryhgg")));
							sendQuartzMessage(content, fhUsers, "",url);
							List<User> shUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxshryhgg")));
							sendQuartzMessage(content, shUsers, "",url);
						} else {
							List<User> csUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxcsrysz")));
							sendQuartzMessage(content, csUsers, "",url);
							List<User> fhUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxfhrysz")));
							sendQuartzMessage(content, fhUsers, "",url);
							List<User> shUsers = UserLocalServiceUtil
									.getRoleUsers(Long.parseLong(PropsUtil
											.get("jgzxshrysz")));
							sendQuartzMessage(content, shUsers, "",url);
						}
					}
				}
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PermitSendMessage.class);

	public static long daysOfTwo(Date fDate, Date oDate) {

		Calendar aCalendar = Calendar.getInstance();

		aCalendar.setTime(fDate);

		long day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

		aCalendar.setTime(oDate);

		long day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

		return day2 - day1;

	}

	public static void sendQuartzMessage(String content, List<User> userList,
			String mobiles,String url) throws ClientProtocolException, IOException {
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
		if (mobiles.length() > 0) {
			sendSMS(url,content,mobiles);
		}
	}

	public static void sendSMS(String url,String content,String mobiles)
			throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url+"/sendSMSServlet?content="+content+"&mobiles="+mobiles);
		httpClient.execute(httpGet);
	}
	
}
