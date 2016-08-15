package com.justonetech.portal.portlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sheca.safeengine.javasafeengine;

/**
 * Portlet implementation class CustomLoginPortlet
 */
public class CustomLoginPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		renderRequest.setAttribute("UUID", UUID.randomUUID().toString());
		renderRequest.setAttribute("certSwitch", true);
		PortletPreferences preferences = renderRequest.getPreferences();
		String loginPage = preferences.getValue("loginPage", StringPool.BLANK);
		renderRequest.setAttribute("loginPage", loginPage);
		String loggedInPage = preferences.getValue("loggedInPage",
				StringPool.BLANK);
		renderRequest.setAttribute("loggedInPage", loggedInPage);
		String redirectPage = preferences.getValue("redirectPage",
				StringPool.BLANK);
		renderRequest.setAttribute("redirectPage", redirectPage);
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String prikeypwd = ParamUtil.get(resourceRequest, "prikeypwd", "");
		String cCert = ParamUtil.get(resourceRequest, "cCert", "");
		String cSign = ParamUtil.get(resourceRequest, "cSign", "");
		String content = ParamUtil.get(resourceRequest, "content", "");
		javasafeengine oSE = new javasafeengine();
		boolean is = false;
		// 转为二进制
		byte[] signed = oSE.base64Decode(cSign);
		byte[] clientCert = oSE.base64Decode(cCert);
		// 获取证书链
		FileInputStream oFile = new FileInputStream(
				PropsUtil.get("sheca.certificate.chain.file"));
//		FileInputStream oFile = new FileInputStream("D:\\SHECA_G2.spc");
		byte[] bChain = null;
		int iFile = 0;
		try {
			iFile = oFile.available();
			bChain = new byte[iFile];
			iFile = oFile.read(bChain);
		} catch (Exception e) {
			// log
			try {
				oFile.close();
			} catch (Exception e1) {
				// log
			}
		}
		String UniqueID = null;
		// 验证客户端证书
		// int iRet = oSE.verifyCert(clientCert, bChain, 101);
		int iRet = oSE.verifyCert(clientCert, bChain, 0);

		if (iRet == 1) {
			// 验证签名
			is = oSE.verifySign(content.getBytes(), signed, "SHA1withRSA",
					clientCert, "SunRsaSign");
			if (!is) {
			} else {
				// 获取证书组织机构代码证（非一证通证书）
				UniqueID = oSE.getCertExtInfo("1.2.156.1.8888.148", clientCert);
				if (Validator.isNull(UniqueID)) {
					// 获取证书组织机构代码证（一证通证书）
					UniqueID = oSE.getCertExtInfo("1.2.156.10260.4.1.4",
							clientCert);
					// log
				}
				if (!Validator.isNull(UniqueID)) {
					long companyId_ = PortalUtil.getCompanyId(resourceRequest);
					String userName = null;

					User user = null;
					try {
						user = UserLocalServiceUtil.getUserByScreenName(
								companyId_, UniqueID);
					} catch (Exception e) {
						// 获取用户失败则创建用户
						try {
							createUser(UniqueID, prikeypwd, userName,
									companyId_, resourceRequest);// 创建用户
							user = UserLocalServiceUtil.getUserByScreenName(
									companyId_, UniqueID);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					com.liferay.portal.kernel.json.JSONObject userJson = JSONFactoryUtil
							.createJSONObject();
					;
					userJson.put("screenName", user.getScreenName());

					HttpServletResponse response = PortalUtil
							.getHttpServletResponse(resourceResponse);
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = null;
					try {
						out = response.getWriter();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out.print(userJson.toString());
					out.flush();
					out.close();

					resourceResponse.setContentType("text/html");
					super.serveResource(resourceRequest, resourceResponse);

				} else {

				}
			}
		}
	}

	public void createUser(String UniqueID, String prikeypwd, String userName,
			Long companyId_, ResourceRequest resourceRequest)
			throws PortalException, SystemException {

		// 获取参数
		long companyId = companyId_;
		boolean autoPassword = false;
		String password1 = prikeypwd;
		String password2 = prikeypwd;
		boolean autoScreenName = false;
		String screenName = UniqueID;
		System.out.println();
		String emailAddress = UniqueID + StringPool.AT
				+ PortalUtil.getCompany(resourceRequest).getMx();// 必填
		long facebookId = 0;
		String openId = "";
		Locale locale = PortalUtil.getLocale(resourceRequest);
		String firstName = userName;
		String middleName = "";
		String lastName = "";
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = 0;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		// 新增用户
		try {
			User defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
			long creatorUserId = defaultUser.getUserId();
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(resourceRequest);
			User user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId,
					companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId,
					openId, locale, firstName, middleName, lastName, prefixId,
					suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
					jobTitle, groupIds, organizationIds, roleIds, userGroupIds,
					sendEmail, serviceContext);
			// UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(),
			// 20181, new long[] { 21700 });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
