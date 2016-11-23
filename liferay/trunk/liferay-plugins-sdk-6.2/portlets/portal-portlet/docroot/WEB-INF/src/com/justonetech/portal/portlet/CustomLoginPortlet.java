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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sheca.safeengine.javasafeengine;

/**
 * Portlet implementation class CustomLoginPortlet
 */
public class CustomLoginPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(CustomLoginPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		renderRequest.setAttribute("UUID", UUID.randomUUID().toString());
		renderRequest.setAttribute("certSwitch", true);
		PortletPreferences preferences = renderRequest.getPreferences();
		String loginPage = preferences.getValue("loginPage", StringPool.BLANK);
		renderRequest.setAttribute("loginPage", loginPage);
		String loggedInPage = preferences.getValue("loggedInPage", StringPool.BLANK);
		renderRequest.setAttribute("loggedInPage", loggedInPage);
		String redirectPage = preferences.getValue("redirectPage", StringPool.BLANK);
		renderRequest.setAttribute("redirectPage", redirectPage);
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceId = resourceRequest.getResourceID();
		if ("Management-Center-login".equals(resourceId)) {
			String loginUser = ParamUtil.get(resourceRequest, "_58_login", "");
			String loginPassword = ParamUtil.get(resourceRequest, "_58_password", "");
			Boolean loginState = false;
			String responseContent = "";

			try {
				List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);

				if (Validator.isNotNull(loginUser) && !loginUser.equals("请输入用户名")) {
					User defaultUser = null;
					for (User user : userList) {
						if (loginUser.equals(user.getScreenName())) {
							defaultUser = user;
						}
					}
					if (Validator.isNotNull(defaultUser)) {
						long compangyId = PortalUtil.getCompanyId(resourceRequest);
						int authResult = Authenticator.FAILURE;
						try {
							authResult = UserLocalServiceUtil.authenticateByScreenName(compangyId, loginUser, loginPassword, null, null, null);
						} catch (PortalException e) {
							log.info("获取authResult异常:"+e);
						}
						if (authResult == Authenticator.SUCCESS) {
							loginState = true;
						} else {
							responseContent = "密码错误！";
						}
					} else {
						responseContent = "用户名错误!";
					}

				} else {
					responseContent = "请输入用户名和密码!";
				}

			} catch (SystemException e) {
				log.info("验证用户名和密码异常:"+e);
			}
			JSONObject userJson = JSONFactoryUtil.createJSONObject();
			userJson.put("loginState", loginState);
			userJson.put("responseContent", responseContent);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				log.info("out对象获取异常:"+e);
			}
			out.print(userJson.toString());
			out.flush();
			out.close();
			resourceResponse.setContentType("text/html");
			super.serveResource(resourceRequest, resourceResponse);

		}

		if ("certificate-login".equals(resourceId)) {
			String prikeypwd = PropsUtil.get("passwords.passwordpolicytoolkit.static");
			String cCert = ParamUtil.get(resourceRequest, "cCert", "");
			String cSign = ParamUtil.get(resourceRequest, "cSign", "");
			String content = ParamUtil.get(resourceRequest, "content", "");
			javasafeengine oSE = new javasafeengine();
			boolean is = false;
			// 转为二进制
			byte[] signed = oSE.base64Decode(cSign);
			byte[] clientCert = oSE.base64Decode(cCert);
			// 获取证书链
			// FileInputStream oFile = new
			// FileInputStream(PropsUtil.get("sheca.certificate.chain.file"));
			FileInputStream oFile = new FileInputStream(PropsUtil.get("sheca.certificate.chain.file"));
			byte[] bChain = null;
			int iFile = 0;
			try {
				iFile = oFile.available();
				bChain = new byte[iFile];
				iFile = oFile.read(bChain);
			} catch (Exception e) {
				log.info("获取bChain异常:"+e);
				try {
					oFile.close();
				} catch (Exception e1) {
					log.info("oFile关闭异常:"+e);
				}
			}
			String UniqueID = null;
			// 验证客户端证书
			// int iRet = oSE.verifyCert(clientCert, bChain, 101);
			int iRet = oSE.verifyCert(clientCert, bChain, 0);

			if (iRet == 1) {
				// 验证签名
				is = oSE.verifySign(content.getBytes(), signed, "SHA1withRSA", clientCert, "SunRsaSign");
				if (!is) {
				} else {
					// 获取证书组织机构代码证（非一证通证书）
					UniqueID = oSE.getCertExtInfo("1.2.156.1.8888.148", clientCert);
					if (Validator.isNull(UniqueID)) {
						// 获取证书组织机构代码证（一证通证书）
						UniqueID = oSE.getCertExtInfo("1.2.156.10260.4.1.4", clientCert);
						// log
					}
					if (!Validator.isNull(UniqueID)) {
						long companyId_ = PortalUtil.getCompanyId(resourceRequest);
						JSONObject digitalCertificate = JSONFactoryUtil.createJSONObject();
						String userName = null;
						try {
							userName = oSE.getCertDetail(17, clientCert);
							digitalCertificate.put("version", oSE.getCertDetail(1, clientCert));
							digitalCertificate.put("certificateSerialNo", oSE.getCertDetail(2, clientCert));
							digitalCertificate.put("signatureAlgorithm", oSE.getCertDetail(3, clientCert));
							digitalCertificate.put("issuerCountry", oSE.getCertDetail(4, clientCert));
							digitalCertificate.put("issuerOrganization", oSE.getCertDetail(5, clientCert));
							digitalCertificate.put("issuerDepartment", oSE.getCertDetail(6, clientCert));
							digitalCertificate.put("issuerProvinces", oSE.getCertDetail(7, clientCert));
							digitalCertificate.put("issuerName", oSE.getCertDetail(8, clientCert));
							digitalCertificate.put("issuerCity", oSE.getCertDetail(9, clientCert));
							digitalCertificate.put("issuerEmail", oSE.getCertDetail(10, clientCert));
							digitalCertificate.put("startDate", oSE.getCertDetail(11, clientCert));
							String expirationDate = oSE.getCertDetail(12, clientCert);
							digitalCertificate.put("expirationDate", expirationDate.substring(0, 4)+"-"+expirationDate.substring(4, 6)+"-"+expirationDate.substring(6, 8));
							digitalCertificate.put("userCountry", oSE.getCertDetail(13, clientCert));
							digitalCertificate.put("userOrganization", oSE.getCertDetail(14, clientCert));
							digitalCertificate.put("userDepartment", oSE.getCertDetail(15, clientCert));
							digitalCertificate.put("userProvinces", oSE.getCertDetail(16, clientCert));
							digitalCertificate.put("userName", oSE.getCertDetail(17, clientCert));
							digitalCertificate.put("userCity", oSE.getCertDetail(18, clientCert));
							digitalCertificate.put("userEmail", oSE.getCertDetail(19, clientCert));
							digitalCertificate.put("key", oSE.getCertDetail(20, clientCert));
							digitalCertificate.put("UniqueID", UniqueID);
						} catch (Exception e) {
							log.info("自定义字段获取异常:"+e);
						}
						String digitalCertificateData = digitalCertificate.toString();
						User user = null;
						try {
							user = UserLocalServiceUtil.getUserByScreenName(companyId_, UniqueID);
						} catch (Exception e) {
							log.info("用户不存在进入创建用户方法:"+e);
							try {
								createUser(UniqueID,prikeypwd, userName, companyId_, resourceRequest);// 创建用户
								user = UserLocalServiceUtil.getUserByScreenName(companyId_, UniqueID);
							} catch (Exception e1) {
								log.info("创建用户并获取用户对象异常:"+e1);
							}
						}
						try {
							ExpandoTable eTable = ExpandoTableLocalServiceUtil.getDefaultTable(PortalUtil.getDefaultCompanyId(), User.class.getName());
							ExpandoColumn eColumn = ExpandoColumnLocalServiceUtil.getColumn(eTable.getTableId(), "digitalCertificate");
							try {
								ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(eTable.getTableId(), eColumn.getColumnId(), user.getUserId());
								expandoValue.setData(digitalCertificateData);
								ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
							} catch (Exception e) {
								log.info("自定义字段未创建则创建自定义字段:"+e);
								ExpandoValueLocalServiceUtil.addValue(eTable.getClassNameId(), eTable.getTableId(), eColumn.getColumnId(), user.getUserId(), digitalCertificateData);
							}
						} catch (Exception e) {
							log.info("自定义字段异常:"+e);
						}

						com.liferay.portal.kernel.json.JSONObject userJson = JSONFactoryUtil.createJSONObject();

						userJson.put("screenName", user.getScreenName());

						HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = null;
						try {
							out = response.getWriter();
						} catch (IOException e) {
							log.info("out对象获取异常:"+e);
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
	}

	public void createUser(String UniqueID,String prikeypwd , String userName, Long companyId_, ResourceRequest resourceRequest) throws PortalException, SystemException {

		// 获取参数
		long companyId = companyId_;
		boolean autoPassword = false;
		String password1 = prikeypwd;
		String password2 = prikeypwd;
		boolean autoScreenName = false;
		String screenName = UniqueID;
		String emailAddress = UniqueID + StringPool.AT + PortalUtil.getCompany(resourceRequest).getMx();// 必填
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
		long[] groupIds = { Long.parseLong(PropsUtil.get("bsdtGroupId")) };
		long[] organizationIds = null;
		long[] roleIds = { Long.parseLong(PropsUtil.get("jsdw")) };
		long[] userGroupIds = null;
		boolean sendEmail = false;

		// 新增用户
		try {
			User defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
			long creatorUserId = defaultUser.getUserId();
			ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
			User user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			log.info("新增用户异常:"+e);
		}
	}

}
