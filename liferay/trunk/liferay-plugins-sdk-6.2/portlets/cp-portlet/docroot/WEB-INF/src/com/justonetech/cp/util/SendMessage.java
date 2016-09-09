package com.justonetech.cp.util;

import java.util.List;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.kxt.SendKxt;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;

public class SendMessage {
	// 状态对应编码
	public static String TJ = "提交";
	public static String YSTG = "预审通过";
	public static String YSWTG = "预审未通过";
	public static String XZZXSJTG = "行政服务中心收件通过";
	public static String CSTG = "初审完成";
	public static String FHWC = "复核完成";
	public static String JGZXSHTG = "建管中心审核通过";
	public static String JGZXSHBTG = "建管中心审核不通过";
	public static String FGLDSHTG = "分管领导审核通过";
	public static String FGLDSHWTG = "分管领导审核未通过";
	public static String ZXLDSHTG = "中心领导审核通过";
	public static String ZXLDSHBTG = "中心领导审核不通过";
	public static String WJCXKHBXK = "委建设处许可和不许可";
	public static String WJCTH = "委建设处退回";
	public static String WSPCXKHBXK = "委审批处许可和不许可";
	public static String WSPCTH = "委审批处退回";
	public static String WLDXK = "委领导许可";
	public static String WLDBYXK = "委领导不予许可";

	private static String messageContent(String status, String commonContent) {
		String content = "";
		if (TJ.equals(status)) {
			content += commonContent + "申请已提交，请进行预审。";
		}
		if (YSTG.equals(status)) {
			content += commonContent + "已通过预审，请将纸质材料送至行政服务中心。";
		}
		if (YSWTG.equals(status)) {
			content += commonContent + "未通过预审，请在系统中修改后提交。";
		}
		if (XZZXSJTG.equals(status)) {// 项目类型进行区分
			content += commonContent + "收件已完成，请进行初审。";
		}
		if (CSTG.equals(status)) {// 项目类型进行区分
			content += commonContent + "初审已完成，请进行复核。";
		}

		if (FHWC.equals(status)) {
			content += commonContent + "复核已完成，请进行审核。";
		}
		if (JGZXSHTG.equals(status)) {
			content += commonContent + "审核已完成，请进行审定。";
		}
		if (JGZXSHBTG.equals(status)) {
			content += commonContent + "未通过审核，请在系统中修改后提交。";
		}
		if (FGLDSHTG.equals(status)) {
			content += commonContent + "审定已完成，请进行审查。";
		}

		if (FGLDSHWTG.equals(status)) {
			content += commonContent + "未通过审定，请重新进行审核。";
		}
		if (ZXLDSHTG.equals(status)) {
			content += commonContent + "中心审查已完成，请委建设处进行审查。";
		}
		if (ZXLDSHBTG.equals(status)) {
			content += commonContent + "未通过审查，请重新进行审定。";
		}

		if (WJCXKHBXK.equals(status)) {
			content += commonContent + "委建设处审查已完成，请委审批处进行审查。";
		}
		if (WJCTH.equals(status)) {
			content += commonContent + "建设处未通过审查，请中心领导进行审查。";
		}
		if (WSPCXKHBXK.equals(status)) {
			content += commonContent + "委审批处审查已完成，请委领导进行审查。";
		}
		if (WSPCTH.equals(status)) {
			content += commonContent + "委审批处未通过审查，请委建设处进行审查。";
		}
		if (WLDXK.equals(status)) {
			content += commonContent + "审查已完成，请至交通委行政服务中心领证。";
		}
		if (WLDBYXK.equals(status)) {
			content += commonContent + "不予行政许可。";
		}

		return content;
	}

	public static String PROJECT_TYPE_HD = "航道";
	public static String PROJECT_TYPE_GL = "公路";
	public static String PROJECT_TYPE_GKSS = "港口设施";
	public static String PROJECT_TYPE_SZJC = "市政基础设施";

	public static void sendMessageByUsers(Permit permit, List<User> userList, String status) {
		sendMessage(permit, userList, status, "");
	}

	public static void sendMessage(Permit permit, List<User> userList, String status, String mobiles) {
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

		String content = messageContent(status, commonContent);// 短信

		if (mobiles.length() > 0) {
			SendKxt.SendKxtSMS(content, mobiles);
		}
	}

}
