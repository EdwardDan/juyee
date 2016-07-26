
package com.justonetech.sys.portlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
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
 * Portlet implementation class CertificateLoginPortlet
 */
public class CertificateLoginPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        renderRequest.setAttribute("UUID", UUID.randomUUID().toString());
        renderRequest.setAttribute("certSwitch", true);
        super.doView(renderRequest, renderResponse);
    }

    // 不同的企业对应的机构代码不同，企业进入门户网站的办事大厅，用USB数字验证输入密码后获得机构代码UniqueID，然后在后续页面根据机构代码UniqueID来获取相应的数据显示给该企业。
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws IOException, PortletException {

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
        FileInputStream oFile = new FileInputStream(PropsUtil.get("certificate.path"));
        byte[] bChain = null;
        int iFile = 0;
        try {
            iFile = oFile.available();
            bChain = new byte[iFile];
            iFile = oFile.read(bChain);
        }
        catch (Exception e) {
            // log
            try {
                oFile.close();
            }
            catch (Exception e1) {
                // log
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
            }
            else {
                // 获取证书组织机构代码证（非一证通证书）
                UniqueID = oSE.getCertExtInfo("1.2.156.1.8888.148", clientCert);
                if (Validator.isNull(UniqueID)) {
                    // 获取证书组织机构代码证（一证通证书）
                    UniqueID = oSE.getCertExtInfo("1.2.156.10260.4.1.4", clientCert);
                    // log
                }
                if (!Validator.isNull(UniqueID)) {
                    long companyId_ = PortalUtil.getCompanyId(resourceRequest);
                    JSONObject digitalCertificate = new JSONObject();
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
                        digitalCertificate.put("expirationDate", oSE.getCertDetail(12, clientCert));
                        digitalCertificate.put("userCountry", oSE.getCertDetail(13, clientCert));
                        digitalCertificate.put("userOrganization", oSE.getCertDetail(14, clientCert));
                        digitalCertificate.put("userDepartment", oSE.getCertDetail(15, clientCert));
                        digitalCertificate.put("userProvinces", oSE.getCertDetail(16, clientCert));
                        digitalCertificate.put("userName", oSE.getCertDetail(17, clientCert));
                        digitalCertificate.put("userCity", oSE.getCertDetail(18, clientCert));
                        digitalCertificate.put("userEmail", oSE.getCertDetail(19, clientCert));
                        digitalCertificate.put("key", oSE.getCertDetail(20, clientCert));
                    }
                    catch (Exception e) {
                        // TODO: handle exception
                    }
                    String digitalCertificateData = digitalCertificate.toJSONString();
                    User user = null;
                    try {
                        user = UserLocalServiceUtil.getUserByScreenName(companyId_, UniqueID);
                    }
                    catch (Exception e) {
                        // 获取用户失败则创建用户
                        createUser(UniqueID, prikeypwd, userName, companyId_, resourceRequest, digitalCertificateData);// 创建用户
                        try {
                            user = UserLocalServiceUtil.getUserByScreenName(companyId_, UniqueID);
                        }
                        catch (PortalException | SystemException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }

                    com.liferay.portal.kernel.json.JSONObject userJson = JSONFactoryUtil.createJSONObject();;
                    userJson.put("screenName", user.getScreenName());

                    HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = null;
                    try {
                        out = response.getWriter();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    out.print(userJson.toString());
                    out.flush();
                    out.close();

                    resourceResponse.setContentType("text/html");
                    super.serveResource(resourceRequest, resourceResponse);

                }
                else {

                }
            }
        }
    }

    public void createUser(
        String UniqueID, String prikeypwd, String userName, Long companyId_, ResourceRequest resourceRequest,
        String digitalCertificateData) {

        // 获取参数
        long companyId = companyId_;
        boolean autoPassword = false;
        String password1 = prikeypwd;
        String password2 = prikeypwd;
        boolean autoScreenName = false;
        String screenName = UniqueID;
        String emailAddress = UniqueID + "@liferay.com";// 必填
        long facebookId = 0;
        String openId = "";
        Locale locale = PortalUtil.getLocale(resourceRequest);
        String firstName = userName;
        String middleName = "";
        String lastName = "";
        int prefixId = 0;
        int suffixId = 0;
        boolean male = true;
        int birthdayMonth = 3;
        int birthdayDay = 5;
        int birthdayYear = 1991;
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
            ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
            User user =
                UserLocalServiceUtil.addUserWithWorkflow(
                    creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName,
                    emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId,
                    male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
                    userGroupIds, sendEmail, serviceContext);

//            ExpandoTable eTable =
//                ExpandoTableLocalServiceUtil.getDefaultTable(PortalUtil.getDefaultCompanyId(), User.class.getName());
//            ExpandoColumn eColumn = ExpandoColumnLocalServiceUtil.getColumn(eTable.getTableId(), "digitalCertificate");
//            ExpandoValueLocalServiceUtil.addValue(
//                eTable.getClassNameId(), eTable.getTableId(), eColumn.getColumnId(), user.getUserId(),
//                digitalCertificateData);
//            List<ExpandoValue> exvlist =
//                ExpandoValueLocalServiceUtil.getColumnValues(
//                    eColumn.getColumnId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//            System.out.println(exvlist);
        }
        catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}
