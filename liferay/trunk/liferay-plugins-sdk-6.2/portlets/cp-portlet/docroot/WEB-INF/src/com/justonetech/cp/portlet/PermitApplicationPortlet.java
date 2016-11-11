package com.justonetech.cp.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;
import com.justonetech.cp.util.CityPermitStatus;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchWorkflowDefinitionLinkException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * Portlet implementation class PermitApplicationPortlet
 */
public class PermitApplicationPortlet extends MVCPortlet {
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/permit-application/select-contract.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh", "");
			String bdh = ParamUtil.getString(renderRequest, "bdh", "");
			String htmc = ParamUtil.getString(renderRequest, "htmc", "");
			User user = null;
			try {
				user = PortalUtil.getUser(renderRequest);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm", "");
			
			if (user != null) {
				try {
					long[] roles = user.getRoleIds();
					for (long role : roles) {
						if (role == Long.parseLong(PropsUtil.get("jsdw"))) {
							zzjgdm = user.getScreenName();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("bdh", bdh);
			renderRequest.setAttribute("htmc", htmc);
			renderRequest.setAttribute("zzjgdm", zzjgdm);
			List<Contract> ybssgzbContracts = new ArrayList<Contract>();
			int ybssgzbContractsCount = 0;
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			ybssgzbContracts = ContractLocalServiceUtil.getYbssgzbContracts(zzjgdm, bjbh, bdh, htmc, start, end);
			ybssgzbContractsCount = ContractLocalServiceUtil.getYbssgzbContractsCount(zzjgdm, bjbh, bdh, htmc);
			renderRequest.setAttribute("ybssgzbContracts", ybssgzbContracts);
			renderRequest.setAttribute("ybssgzbContractsCount", ybssgzbContractsCount);
		} else if (Validator.equals(mvcPath, "/portlet/permit-application/edit-permit.jsp")) {
		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String path = ParamUtil.getString(renderRequest, "path");
		if (path.contains("uploadFile")) {
			path=path.replace("uploadFile", "");
			if(Validator.isNotNull(path)){
				String[] pathParam=path.split("\\/");
				String divNo=pathParam[0];
				String materialId=pathParam[1];
				String no=pathParam[2];
				renderRequest.setAttribute("divNo",divNo); 
				renderRequest.setAttribute("materialId", materialId);
				renderRequest.setAttribute("no", no);
			}else{
				renderRequest.setAttribute("divNo",ParamUtil.getString(renderRequest, "divNo"));
				renderRequest.setAttribute("materialId",ParamUtil.getString(renderRequest, "materialId"));
				renderRequest.setAttribute("no",ParamUtil.getString(renderRequest, "no"));
				renderRequest.setAttribute("upLoadMessage",ParamUtil.getString(renderRequest, "upLoadMessage"));
			}
			include("/portlet/permit-application/uploadFile.jsp", renderRequest, renderResponse);
		}
		else {

		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm");
		
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			try {
				long[] roles = user.getRoleIds();
				for (long role : roles) {
					if (role == Long.parseLong(PropsUtil.get("jsdw"))) {
						zzjgdm = user.getScreenName();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;

		List<Permit> permits = new ArrayList<Permit>();
		int permitsCount = 0;
		permits = PermitLocalServiceUtil.getPermits(zzjgdm, bjbh, wssqbh, gcmc, start, end);
		permitsCount = PermitLocalServiceUtil.getPermitsCount(zzjgdm, bjbh, wssqbh, gcmc);
		renderRequest.setAttribute("permits", permits);
		renderRequest.setAttribute("permitsCount", permitsCount);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		super.doView(renderRequest, renderResponse);}
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {

		Long xmlx = ParamUtil.getLong(request, "xmlx");
		String lxjb = ParamUtil.getString(request, "lxjb");
		Long xmxz = ParamUtil.getLong(request, "xmxz");
		String ssqx = ParamUtil.getString(request, "ssqx");
		String jsdwmc = ParamUtil.getString(request, "jsdwmc");
		String jsdwxz = ParamUtil.getString(request, "jsdwxz");
		String jsdwdz = ParamUtil.getString(request, "jsdwdz");
		String gcmc = ParamUtil.getString(request, "gcmc");
		String jsdd = ParamUtil.getString(request, "jsdd");
		Long jsddssqx = ParamUtil.getLong(request, "jsddssqx");
		String[] jsgclbArrs = ParamUtil.getParameterValues(request, "jsgclbCheckbox");
		String jsgclbs = "";
		if (null != jsgclbArrs && jsgclbArrs.length > 0) {
			for (String jsgclb : jsgclbArrs) {
				jsgclbs += "," + jsgclb;
			}
		}
		Long jsgcsx = ParamUtil.getLong(request, "jsgcsx");
		String jsgcgm = ParamUtil.getString(request, "jsgcgm");
		String gls = ParamUtil.getString(request, "gls");
		String jzmj = ParamUtil.getString(request, "jzmj");
		int qlsl = ParamUtil.getInteger(request, "qlsl");
		String qlkd = ParamUtil.getString(request, "qlkd");
		int guijiaosl = ParamUtil.getInteger(request, "guijiaosl");
		int sdsl = ParamUtil.getInteger(request, "sdsl");
		int gaojiasl = ParamUtil.getInteger(request, "gaojiasl");
		String gcnr = ParamUtil.getString(request, "gcnr");
		String gyzjbz = ParamUtil.getString(request, "gyzjbz");
		String zgj = ParamUtil.getString(request, "zgj");
		String fwjzmj = ParamUtil.getString(request, "fwjzmj");
		String htjg = ParamUtil.getString(request, "htjg");
		int htgq = ParamUtil.getInteger(request, "htgq");
		String zbjg = ParamUtil.getString(request, "zbjg");
		String xmtzgs = ParamUtil.getString(request, "xmtzgs");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String jsdwlxdh = ParamUtil.getString(request, "jsdwlxdh");
		String jsdwlxr = ParamUtil.getString(request, "jsdwlxr");
		String jsdwsjh = ParamUtil.getString(request, "jsdwsjh");
		String jsgcghxkzbh = ParamUtil.getString(request, "jsgcghxkzbh");
		String xckgqk = ParamUtil.getString(request, "xckgqk");
		Date jhkg = ParamUtil.getDate(request, "jhkg", new SimpleDateFormat(dateFormatPattern));
		Date jhjg = ParamUtil.getDate(request, "jhjg", new SimpleDateFormat(dateFormatPattern));
		Date zsqxks = null,zsqxjs = null;
		if(Validator.isNotNull(ParamUtil.getDate(request, "zsqxks",new SimpleDateFormat(dateFormatPattern)))){
			zsqxks = ParamUtil.getDate(request, "zsqxks",new SimpleDateFormat(dateFormatPattern));
			zsqxjs = ParamUtil.getDate(request, "zsqxjs",new SimpleDateFormat(dateFormatPattern));
		}
		String cnsx = ParamUtil.getString(request, "cnsx");
		System.out.println("=================="+zsqxks+zsqxjs+cnsx);
		String tzly = "";
		String gkpzhhzjghwh = "";
		Date pfhhzrq = null;
		String cbsjpzjghwh = "";
		Date pfrq = null;
		int pfgq = 0;
		String pzjghwh = "";
		String xmdw = "";
		String xmfzr = "";
		String xmfzrlxdh = "";
		String zysjdw = "";
		String sj_zbfs = "";
		String sj_zbj = "";
		String sj_zzdj = "";
		String sj_zzdjzsbh = "";
		String sj_xmfzr = "";
		String sj_xmfzrzsbh = "";
		String zyjldw = "";
		String jl_zbfs = "";
		String jl_zbj = "";
		String jl_zzdj = "";
		String jl_zzdjzsbh = "";
		String jl_zj = "";
		String jl_zjzsbh = "";
		String zysgdw = "";
		String sg_zbfs = "";
		String sg_zbj = "";
		String sg_zzdj = "";
		String sg_zzdjzsbh = "";
		String sg_xmjl = "";
		String sg_xmjlzsbh = "";
		String jszjjhlsqk = "";
		String dcqwcqk = "";
		String sgzbqk = "";
		String sytdxgwj = "";
		String gczljddjqk = "";
		if(xmlx == 29741){
			tzly = ParamUtil.getString(request, "tzly");
			gkpzhhzjghwh = ParamUtil.getString(request, "gkpzhhzjghwh");
			pfhhzrq = ParamUtil.getDate(request, "pfhhzrq",new SimpleDateFormat(dateFormatPattern));
			cbsjpzjghwh = ParamUtil.getString(request, "cbsjpzjghwh");
			pfrq = ParamUtil.getDate(request, "pfrq",new SimpleDateFormat(dateFormatPattern));
			pfgq = ParamUtil.getInteger(request, "pfgq");
			pzjghwh = ParamUtil.getString(request, "pzjghwh");
			xmdw = ParamUtil.getString(request, "xmdw");
			xmfzr = ParamUtil.getString(request, "xmfzr");
			xmfzrlxdh = ParamUtil.getString(request, "xmfzrlxdh");
			zysjdw = ParamUtil.getString(request, "zysjdw");
			sj_zbfs = ParamUtil.getString(request, "sj_zbfs");
			sj_zbj = ParamUtil.getString(request, "sj_zbj");
			sj_zzdj = ParamUtil.getString(request, "sj_zzdj");
			sj_zzdjzsbh = ParamUtil.getString(request, "sj_zzdjzsbh");
			sj_xmfzr = ParamUtil.getString(request, "sj_xmfzr");
			sj_xmfzrzsbh = ParamUtil.getString(request, "sj_xmfzrzsbh");
			
			zyjldw = ParamUtil.getString(request, "zyjldw");
			jl_zbfs = ParamUtil.getString(request, "jl_zbfs");
			jl_zbj = ParamUtil.getString(request, "jl_zbj");
			jl_zzdj = ParamUtil.getString(request, "jl_zzdj");
			jl_zzdjzsbh = ParamUtil.getString(request, "jl_zzdjzsbh");
			jl_zj = ParamUtil.getString(request, "jl_zj");
			jl_zjzsbh = ParamUtil.getString(request, "jl_zjzsbh");
			
			zysgdw = ParamUtil.getString(request, "zysgdw");
			sg_zbfs = ParamUtil.getString(request, "sg_zbfs");
			sg_zbj = ParamUtil.getString(request, "sg_zbj");
			sg_zzdj = ParamUtil.getString(request, "sg_zzdj");
			sg_zzdjzsbh = ParamUtil.getString(request, "sg_zzdjzsbh");
			sg_xmjl = ParamUtil.getString(request, "sg_xmjl");
			sg_xmjlzsbh = ParamUtil.getString(request, "sg_xmjlzsbh");
			
			jszjjhlsqk = ParamUtil.getString(request, "jszjjhlsqk");
			dcqwcqk = ParamUtil.getString(request, "dcqwcqk");
			sgzbqk = ParamUtil.getString(request, "sgzbqk");
			sytdxgwj = ParamUtil.getString(request, "sytdxgwj");
			gczljddjqk = ParamUtil.getString(request, "gczljddjqk");
		}
		String sgxkzsbz = ParamUtil.getString(request, "sgxkzsbz");
		Boolean sfzftzl = ParamUtil.getBoolean(request, "sfzftzl");
		String yzzpl1 = ParamUtil.getString(request, "yzzpl1");
		String yzzpl2 = ParamUtil.getString(request, "yzzpl2");
		String yzzpl3 = ParamUtil.getString(request, "yzzpl3");
		String yzzpl4 = ParamUtil.getString(request, "yzzpl4");
		Long permitId = ParamUtil.getLong(request, "permitId");
		String bjbh = ParamUtil.getString(request, "bjbh");
		String bdh = ParamUtil.getString(request, "bdh");
		String htxxbsbh = ParamUtil.getString(request, "htxxbsbh");
		String zzjgdm = null;
		User user = null;
		try {
			user = PortalUtil.getUser(request);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			zzjgdm = user.getScreenName();
		}

		ProjectProfile projectProfile = null;
		Permit permit = null;
		if (permitId != 0) {
			projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			permit = PermitLocalServiceUtil.getPermit(permitId);
		} else {
			projectProfile = ProjectProfileLocalServiceUtil.createProjectProfile(CounterLocalServiceUtil.increment());
			permit = PermitLocalServiceUtil.createPermit(projectProfile.getPermitId());
			permit.setStatus(1);
		}
		permit.setSqbz(1);
		permit.setHtxxbsbh(htxxbsbh);
		projectProfile.setXmlx(xmlx);
		projectProfile.setLxjb(lxjb);
		projectProfile.setXmxz(xmxz);
		projectProfile.setSsqx(ssqx);
		projectProfile.setJsdwmc(jsdwmc);
		projectProfile.setJsdwxz(jsdwxz);
		projectProfile.setJsdwdz(jsdwdz);
		projectProfile.setGcmc(gcmc);
		projectProfile.setJsdd(jsdd);
		projectProfile.setJsddssqx(jsddssqx);
		projectProfile.setJsgclb(jsgclbs);
		projectProfile.setJsgcsx(jsgcsx);
		projectProfile.setJsgcgm(jsgcgm);
		projectProfile.setGls(gls);
		projectProfile.setJzmj(jzmj);
		projectProfile.setQlsl(qlsl);
		projectProfile.setQlkd(qlkd);
		projectProfile.setGuijiaosl(guijiaosl);
		projectProfile.setSdsl(sdsl);
		projectProfile.setGaojiasl(gaojiasl);
		projectProfile.setGcnr(gcnr);
		projectProfile.setGyzjbz(gyzjbz);
		projectProfile.setZgj(zgj);
		projectProfile.setFwjzmj(fwjzmj);
		projectProfile.setHtjg(htjg);
		projectProfile.setHtgq(htgq);
		projectProfile.setZbjg(zbjg);
		projectProfile.setXmtzgs(xmtzgs);
		projectProfile.setFddbr(fddbr);
		projectProfile.setJsdwlxdh(jsdwlxdh);
		projectProfile.setJsdwlxr(jsdwlxr);
		projectProfile.setJsdwsjh(jsdwsjh);
		projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
		projectProfile.setXckgqk(xckgqk);
		projectProfile.setJhkg(jhkg);
		projectProfile.setJhjg(jhjg);
		projectProfile.setZsqxks(zsqxks);
		projectProfile.setZsqxjs(zsqxjs);
		projectProfile.setCnsx(cnsx);
		
		projectProfile.setTzly(tzly);
		projectProfile.setGkpzhhzjghwh(gkpzhhzjghwh);
		projectProfile.setPfhhzrq(pfhhzrq);
		projectProfile.setCbsjpzjghwh(cbsjpzjghwh);
		projectProfile.setPfrq(pfrq);
		projectProfile.setPfgq(pfgq);
		projectProfile.setPzjghwh(pzjghwh);
		projectProfile.setXmdw(xmdw);
		projectProfile.setXmfzr(xmfzr);
		projectProfile.setXmfzrlxdh(xmfzrlxdh);
		projectProfile.setZysjdw(zysjdw);
		projectProfile.setSj_zbfs(sj_zbfs);
		projectProfile.setSj_zbj(sj_zbj);
		projectProfile.setSj_zzdj(sj_zzdj);
		projectProfile.setSj_zzdjzsbh(sj_zzdjzsbh);
		projectProfile.setSj_xmfzr(sj_xmfzr);
		projectProfile.setSj_xmfzrzsbh(sj_xmfzrzsbh);
		projectProfile.setZyjldw(zyjldw);
		projectProfile.setJl_zbfs(jl_zbfs);
		projectProfile.setJl_zbj(jl_zbj);
		projectProfile.setJl_zzdj(jl_zzdj);
		projectProfile.setJl_zzdjzsbh(jl_zzdjzsbh);
		projectProfile.setJl_zj(jl_zj);
		projectProfile.setJl_zjzsbh(jl_zjzsbh);
		projectProfile.setZysgdw(zysgdw);
		projectProfile.setSg_zbfs(sg_zbfs);
		projectProfile.setSg_zbj(sg_zbj);
		projectProfile.setSg_zzdj(sg_zzdj);
		projectProfile.setSg_zzdjzsbh(sg_zzdjzsbh);
		projectProfile.setSg_xmjl(sg_xmjl);
		projectProfile.setSg_xmjlzsbh(sg_xmjlzsbh);
		projectProfile.setJszjjhlsqk(jszjjhlsqk);
		projectProfile.setDcqwcqk(dcqwcqk);
		projectProfile.setSgzbqk(sgzbqk);
		projectProfile.setSytdxgwj(sytdxgwj);
		projectProfile.setGczljddjqk(gczljddjqk);
		projectProfile.setSgxkzsbz(sgxkzsbz);
		projectProfile.setSfzftzl(sfzftzl);
		projectProfile.setYzzpl1(yzzpl1);
		projectProfile.setYzzpl2(yzzpl2);
		projectProfile.setYzzpl3(yzzpl3);
		projectProfile.setYzzpl4(yzzpl4);
		ProjectProfileLocalServiceUtil.updateProjectProfile(projectProfile);
		if (Validator.isNull(permit.getYwbh())) {
			String ywbh = "JT";
			Dictionary xmlxDic = DictionaryLocalServiceUtil.getDictionary(xmlx);
			ywbh = ywbh + xmlxDic.getCode();
			Locale locale = LocaleUtil.getDefault();
			String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
			String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
			ywbh = ywbh + currentDateStr + "0000";
			permit.setYwbh(ywbh);
		}
		permit.setBjbh(bjbh);
		permit.setBdh(bdh);
		permit.setZzjgdm(zzjgdm);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 1);
	}

	public void saveParticipationUnits(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {

		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if (permit.getSqbz() == 1) {
			permit.setSqbz(2);
		}

		PermitLocalServiceUtil.updatePermit(permit);

		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		if (null != participationUnits) {
			for (ParticipationUnit participationUnit : participationUnits) {
				ParticipationUnitLocalServiceUtil.deleteParticipationUnit(participationUnit);
			}
		}
		String[] dwmcs = ParamUtil.getParameterValues(request, "dwmc");
		String[] sfssjs = ParamUtil.getParameterValues(request, "sfyssj");
		String[] dwlxs = ParamUtil.getParameterValues(request, "dwlx");
		String[] xmfzrs = ParamUtil.getParameterValues(request, "xmfzr");
		String[] zjlxs = ParamUtil.getParameterValues(request, "zjlx");
		String[] zjhs = ParamUtil.getParameterValues(request, "zjh");
		String[] dhhms = ParamUtil.getParameterValues(request, "dhhm");
		for (int i = 0; i < dwmcs.length; i++) {
			ParticipationUnit participationUnit = ParticipationUnitLocalServiceUtil
					.createParticipationUnit(CounterLocalServiceUtil.increment());
			participationUnit.setDwmc(dwmcs[i]);
			participationUnit.setSfyssj(Boolean.valueOf(sfssjs[i]));
			participationUnit.setDwlx(dwlxs[i]);
			if (xmfzrs.length > 0) {
				participationUnit.setXmfzr(xmfzrs[i]);
			}
			if (zjhs.length > 0) {
				participationUnit.setZjh(zjhs[i]);
			}
			participationUnit.setZjlx(zjlxs[i]);
			if (dhhms.length > 0) {
				participationUnit.setDhhm(dhhms[i]);
			}
			participationUnit.setPermitId(permitId);
			ParticipationUnitLocalServiceUtil.addParticipationUnit(participationUnit);

		}
		redirect(request, response, permit, 2);
	}

	public void saveUnitProjects(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {

		long permitId = ParamUtil.getLong(request, "permitId");

		List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (UnitProject unitProject : unitProjects) {
			UnitProjectLocalServiceUtil.deleteUnitProject(unitProject);
		}
		String bjbh = ParamUtil.getString(request, "bjbh");
		String[] gcbhs = ParamUtil.getParameterValues(request, "gcbh");
		String[] gcmcs = ParamUtil.getParameterValues(request, "gcmc");
		String[] jsnrs = ParamUtil.getParameterValues(request, "jsnr");
		for (int i = 0; i < gcbhs.length - 1; i++) {
			UnitProject unitProject = UnitProjectLocalServiceUtil
					.createUnitProject(CounterLocalServiceUtil.increment());
			unitProject.setBjbh(bjbh);
			unitProject.setPermitId(permitId);
			unitProject.setGcbh(gcbhs[i]);
			unitProject.setGcmc(gcmcs[i]);
			unitProject.setJsnr(jsnrs[i]);
			UnitProjectLocalServiceUtil.addUnitProject(unitProject);
		}
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);

		if (permit.getSqbz() == 2) {
			permit.setSqbz(3);
		}
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 3);
	}

	public void saveApplyMaterials(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if (permit.getSqbz() == 3) {
			permit.setSqbz(4);
		}
		if (permit.getStatus() <= 2
				&& WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(permit.getCompanyId(), 0L,
						Permit.class.getName(), permit.getPermitId())) {
			WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(permit.getCompanyId(), 0L,
					Permit.class.getName(), permit.getPermitId());
			permit.setStatus(1);
		}
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 4);
	}

	public void submitAll(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Permit.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		User user = PortalUtil.getUser(request);
		if (Validator.isNotNull(user)) {
			permit.setUserId(user.getUserId());
			permit.setUserName(user.getFullName());
			permit.setStatusByUserName(user.getFullName());
		}
		Date now = new Date();
		permit.setCreateDate(now);
		permit.setModifiedDate(now);
		permit.setGroupId(themeDisplay.getScopeGroupId());
		permit.setCompanyId(themeDisplay.getCompanyId());
		// 保存状态
		permit.setStatus(CityPermitStatus.STATUS_SB.getCode());
		permit.setSqbz(4);
		permit.setStatus(2);
		PermitLocalServiceUtil.updatePermit(permit);
		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(permit.getCompanyId(), 0L,
				Permit.class.getName(), permit.getPermitId());
		WorkflowDefinitionLink workflowDefinitionLink = null;
		try {
			workflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil.getDefaultWorkflowDefinitionLink(
					themeDisplay.getCompanyId(), Permit.class.getName(), 0, 0);
		} catch (Exception e) {
			if (e instanceof NoSuchWorkflowDefinitionLinkException) {
				SessionMessages.add(request.getPortletSession(), "workflow-not-enabled");
			}
			e.printStackTrace();
		}
		if (permit != null && workflowDefinitionLink != null) {
			AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), permit.getGroupId(),
					Permit.class.getName(), permit.getPermitId(), null, null);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(permit.getCompanyId(), permit.getUserId(),
					Permit.class.getName(), permit.getPermitId(), permit, serviceContext);
		}
	}

	public void redirect(ActionRequest request, ActionResponse response, Permit permit, int sqbz) throws IOException {

		String redirect = ParamUtil.getString(request, "redirectURL");
		System.out.println(redirect);
		int tabSqbz = 1;
		if (permit.getSqbz() == sqbz && sqbz < 4) {
			tabSqbz = sqbz + 1;
		} else if (permit.getSqbz() == sqbz && sqbz == 4) {
			tabSqbz = sqbz;
		} else if (permit.getSqbz() > sqbz) {
			tabSqbz = sqbz;
		}
		redirect += "&" + response.getNamespace() + "permitId=" + permit.getPermitId();
		redirect += "&" + response.getNamespace() + "tabSqbz=" + tabSqbz;
		response.sendRedirect(redirect);
	}

	public void deletePermits(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException,
			PortalException, SystemException {
		String deletePermitIds = ParamUtil.getString(actionRequest, "permitIds");
		String[] permitIds = deletePermitIds.split(",");
		for (String permitId : permitIds) {
			ProjectProfileLocalServiceUtil.deleteProjectProfile(Long.parseLong(permitId));
			List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(Long.parseLong(permitId), -1,
					-1);
			for (UnitProject unitProject : unitProjects) {
				UnitProjectLocalServiceUtil.deleteUnitProject(unitProject);
			}
			List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(
					Long.parseLong(permitId), -1, -1);
			for (ParticipationUnit participationUnit : participationUnits) {
				ParticipationUnitLocalServiceUtil.deleteParticipationUnit(participationUnit);
			}
			List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(Long.parseLong(permitId),
					-1, -1);
			for (ApplyMaterial applyMaterial : applyMaterials) {
				ApplyMaterialLocalServiceUtil.deleteApplyMaterial(applyMaterial);
			}
			Permit permit = PermitLocalServiceUtil.getPermit(Long.parseLong(permitId));
			WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(permit.getCompanyId(), 0L,
					Permit.class.getName(), permit.getPermitId());
			PermitLocalServiceUtil.deletePermit(Long.parseLong(permitId));
		}
	}

	public Map<String, String> getMap(long permitId, String xmlx) throws PortalException, SystemException {
		Map<String, String> map = new HashMap<String, String>();
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String title = "上海市(" + xmlx + ")工程施工许可证";
		String bh = "";
		String gj = "";
		if (xmlx.equals("港口")) {
			gj = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else if (xmlx.equals("公路")) {
			gj = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else {
			gj = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		}
		String jsdw = projectProfile.getJsdwmc();
		String gcmc = projectProfile.getGcmc();
		String gcwz = projectProfile.getJsdd();
		String gcnr = projectProfile.getGcnr();
		String xmtzgs = projectProfile.getXmtzgs() + "万元";
		String htjg = projectProfile.getHtjg() + "万元";
		String sjdw = "";
		String sgdw = "";
		String jldw = "";

		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (ParticipationUnit participationUnit : participationUnits) {
			if (participationUnit.getDwlx().equals("设计单位")) {
				sjdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("施工单位")) {
				sgdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("监理单位")) {
				jldw = participationUnit.getDwmc();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String jhkg = sdf.format(projectProfile.getJhkg());
		String jhjg = sdf.format(projectProfile.getJhjg());
		String jhkgrq = jhkg.substring(0, 4) + "年" + jhkg.substring(4, 6) + "月" + jhkg.substring(6, 8) + "日";
		String jhjgrq = jhjg.substring(0, 4) + "年" + jhjg.substring(4, 6) + "月" + jhjg.substring(6, 8) + "日";
		String bz = projectProfile.getSgxkzsbz();
		map.put("xmtzgs", xmtzgs);
		map.put("htjg", htjg);
		map.put("gcwz", gcwz);
		map.put("gcnr", gcnr);
		map.put("jsdw", jsdw);
		map.put("gcmc", gcmc);
		map.put("bh", bh);
		map.put("gj", gj);
		map.put("title", title);
		map.put("jhkgrq", jhkgrq);
		map.put("jhjgrq", jhjgrq);
		map.put("sgdw", sgdw);
		map.put("jldw", jldw);
		map.put("sjdw", sjdw);
		map.put("bz", bz);
		return map;
	}
	
	public Map<String, String> getKgbaMap(long permitId) throws PortalException, SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Map<String, String> map = new HashMap<String, String>();
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String babh = "";
		String xmmc = projectProfile.getGcmc();
		String jsdd = projectProfile.getJsdd();
		String tzly = projectProfile.getTzly();
		String gkpzwh = projectProfile.getGkpzhhzjghwh();
		Date pfhhzrqDate = projectProfile.getPfhhzrq();
		String pfhhzrq = sdf.format(pfhhzrqDate);
		String hzrq = pfhhzrq.substring(0, 4) + "年" + pfhhzrq.substring(4, 6) + "月" + pfhhzrq.substring(6, 8) + "日";
		String tzgs = projectProfile.getXmtzgs();
		String cbpzwh = projectProfile.getCbsjpzjghwh();
		Date pfrqDate = projectProfile.getPfrq();
		String pfrqStr = sdf.format(pfrqDate);
		String pfrq = pfrqStr.substring(0, 4) + "年" + pfrqStr.substring(4, 6) + "月" + pfrqStr.substring(6, 8) + "日";
		String pfgq = projectProfile.getPfgq()+"天";
		String jsgm = projectProfile.getJsgcgm()+"。"+projectProfile.getGcnr();
		String pzjghwh = projectProfile.getPzjghwh();
		String xmdw = projectProfile.getXmdw();
		String xmdwfzr = projectProfile.getXmfzr();
		String xmdwfzrlxdh = projectProfile.getXmfzrlxdh();
		String sjdw = projectProfile.getZyjldw();
		String sjdwzbfs = projectProfile.getSj_zbfs();
		String sjdwzbj = projectProfile.getSj_zbj();
		String sjdwzzdj = projectProfile.getSj_zzdj();
		String sjdwzzdjzs = projectProfile.getSj_zzdjzsbh();
		String sjdwxmfzr = projectProfile.getSj_xmfzr();
		String sjdwxmfzrzs = projectProfile.getSj_xmfzrzsbh();
		
		String jldw = projectProfile.getZyjldw();
		String jldwzbfs = projectProfile.getJl_zbfs();
		String jldwzbj = projectProfile.getJl_zbj();
		String jldwzzdj = projectProfile.getJl_zzdj();
		String jldwzzdjzs = projectProfile.getJl_zzdjzsbh();
		String jldwzj = projectProfile .getJl_zj();
		String jldwzjzs = projectProfile.getJl_zjzsbh();
		
		String sgdw = projectProfile.getZysgdw();
		String sgdwzbfs = projectProfile.getSg_zbfs();
		String sgdwzbj = projectProfile.getSg_zbj();
		String sgdwzzdj = projectProfile.getSg_zzdj();
		String sgdwzzdjzs = projectProfile.getSg_zzdjzsbh();
		String sgdwxmjl = projectProfile.getSg_xmjl();
		String sgdwxmjlzs = projectProfile.getSg_xmjlzsbh();  	
		
		String jszjjh = projectProfile.getJszjjhlsqk();
		String dcqwcqk = projectProfile.getDcqwcqk();
		String sgzbqk = projectProfile.getSgzbqk();
		String xgwj = projectProfile.getSytdxgwj();
		String gczljd = projectProfile.getGczljddjqk();
		
		
		String jhkgrq = sdf.format(projectProfile.getJhkg());
		String jhjgrq = sdf.format(projectProfile.getJhjg());
		String jhkg = jhkgrq.substring(0, 4) + "年" + jhkgrq.substring(4, 6) + "月" + jhkgrq.substring(6, 8) + "日";
		String jhwg = jhjgrq.substring(0, 4) + "年" + jhjgrq.substring(4, 6) + "月" + jhjgrq.substring(6, 8) + "日";
		map.put("babh", babh);
		map.put("xmmc", xmmc);
		map.put("jsdd", jsdd);
		map.put("tzly", tzly);
		map.put("gkpzwh", gkpzwh);
		map.put("hzrq", hzrq);
		map.put("tzgs", tzgs);
		map.put("cbpzwh", cbpzwh);
		map.put("pfrq", pfrq);
		map.put("pfgq", pfgq);
		map.put("jsgm", jsgm);
		map.put("pzjghwh", pzjghwh);
		map.put("xmdw", xmdw);
		map.put("xmdwfzr", xmdwfzr);
		map.put("xmdwfzrlxdh", xmdwfzrlxdh);
		map.put("sjdw", sjdw);
		map.put("sjdwzbfs", sjdwzbfs);
		map.put("sjdwzbj", sjdwzbj);
		map.put("sjdwzzdj", sjdwzzdj);
		map.put("sjdwzzdjzs", sjdwzzdjzs);
		map.put("sjdwxmfzr", sjdwxmfzr);
		map.put("sjdwxmfzrzs", sjdwxmfzrzs);
		map.put("jldw", jldw);
		map.put("jldwzbfs", jldwzbfs);
		map.put("jldwzbj", jldwzbj);
		map.put("jldwzzdj", jldwzzdj);
		map.put("jldwzzdjzs", jldwzzdjzs);
		map.put("jldwzj", jldwzj);
		map.put("jldwzjzs", jldwzjzs);
		map.put("sgdw", sgdw);
		map.put("sgdwzbfs", sgdwzbfs);
		map.put("sgdwzbj", sgdwzbj);
		map.put("sgdwzzdj", sgdwzzdj);
		map.put("sgdwzzdjzs", sgdwzzdjzs);
		map.put("sgdwxmjl", sgdwxmjl);
		map.put("sgdwxmjlzs", sgdwxmjlzs);
		map.put("jszjjh", jszjjh);
		map.put("dcqwcqk", dcqwcqk);
		map.put("sgzbqk", sgzbqk);
		map.put("xgwj", xgwj);
		map.put("gczljd", gczljd);
		
		map.put("jhkg", jhkg);
		map.put("jhwg", jhwg);
		return map;
	}

	public void fillTemplate(DLFileEntry fileEntry, String newPDFPath, Map<String, String> map,
			ResourceRequest request, ResourceResponse response, Permit permit) throws IOException, DocumentException,
			PortalException, SystemException, com.lowagie.text.DocumentException {
		PdfReader pdfReader = new PdfReader(fileEntry.getContentStream());
		File file = new File(newPDFPath);
		file.delete();
		FileOutputStream outputStream = new FileOutputStream(file);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfStamper pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
		AcroFields acroFields = pdfStamper.getAcroFields();
		Iterator<String> iterator = acroFields.getFields().keySet().iterator();
		while (iterator.hasNext()) {
			String data = iterator.next().toString();
			acroFields.setField(data, map.get(data));
		}
		pdfStamper.setFormFlattening(true);
		pdfStamper.close();
		Document document = new Document();
		PdfCopy pdfCopy = new PdfCopy(document, outputStream);
		document.open();
		for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
			PdfImportedPage importedPage = pdfCopy.getImportedPage(new PdfReader(byteArrayOutputStream.toByteArray()),
					i);
			pdfCopy.addPage(importedPage);
		}
		document.close();
	}
	
	private byte[] inputStreamToByte(InputStream is) throws IOException {
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int ch;
		while ((ch = is.read(buffer)) != -1) {
			bytestream.write(buffer, 0, ch);
		}
		byte data[] = bytestream.toByteArray();
		bytestream.close();
		return data;
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			long permitId = ParamUtil.getLong(resourceRequest, "permitId");
			Permit permit = PermitLocalServiceUtil.getPermit(permitId);
			ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
			if ("view".equals(resourceId)) {
				Map<String, String> map = null;
				String newPDFPath = "";
				if (xmlx.equals("航道")) {
					newPDFPath = PropsUtil.get("sgxkz.temp.folder.id") + "开工备案.pdf";
				} else {
					newPDFPath = PropsUtil.get("sgxkz.temp.folder.id") + "施工许可证书.pdf";
				}
				if (xmlx.equals("航道")) {
					map = getKgbaMap(permitId);
					fillTemplate(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
							.get("sgxkz.hd.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse, permit);
				} else {
					map = getMap(permitId, xmlx);
					if (projectProfile.getXmxz() == 29769) {
						fillTemplate(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
								.get("sgxkz.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse,
								permit);
					} else {
						fillTemplate(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
								.get("sgxkz.ls.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse,
								permit);
					}
				}

				HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
				HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
				File file = null;
				if (xmlx.equals("航道")) {
					file = new File("D:\\temp\\开工备案.pdf");
				} else {
					file = new File("D:\\temp\\施工许可证书.pdf");
				}
				byte[] bytes = FileUtil.getBytes(file);
				if (xmlx.equals("航道")) {
				ServletResponseUtil.sendFile(request, response, "开工备案.pdf", bytes, ContentTypes.APPLICATION_PDF);
				}else{
					ServletResponseUtil.sendFile(request, response, "施工许可证书.pdf", bytes, ContentTypes.APPLICATION_PDF);
				}
			}
			
			
			// 删除文件
			if ("fileDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				System.out.println(fileId);
				System.out.println(materialId);
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if (!materialId.equals("0")) {
						ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
								.valueOf(materialId));
						String fileEntryIds = applyMaterial.getFileEntryIds();
						fileEntryIds = fileEntryIds + ",";// 加上逗号为了容易替换
						// 获取文件路径
						String str = fileId + "\\|" + dlFileEntry.getExtension() + "\\,";
						fileEntryIds = fileEntryIds.replaceFirst(str, "");
						if (Validator.isNotNull(fileEntryIds)) {
							fileEntryIds = fileEntryIds.substring(0, fileEntryIds.length() - 1);// 最后一步再把逗号去掉
						}
						applyMaterial.setFileEntryIds(fileEntryIds);
						ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
					}
					DLFileEntryLocalServiceUtil.deleteFileEntry(Long.valueOf(fileId));
				}
			}

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.lowagie.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		super.serveResource(resourceRequest, resourceResponse);
	}


	public FileEntry uploadFile(ActionRequest request, String fileSourceName, byte[] fileBytes,
			ServiceContext serviceContext, String portletId, String materialId, String fileTitle)
			throws PortalException, SystemException, IOException {
		System.out.println(222);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setIndexingEnabled(true);

		User user = PortalUtil.getUser(request);
		long userId = user.getUserId();
		Long groupId = user.getGroupId();
		Long rootFolderId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT;
		FileEntry fileEntry = null;
		// 为每一种材料名称创建一个文件夹,如果已有就不再创建
		DLFolder dlParentFolder = null;
		DLFolder dlChildFolder = null;
		if (Validator.isNotNull(portletId) && Validator.isNotNull(materialId)) {
			dlParentFolder = DLFolderLocalServiceUtil.fetchFolder(groupId, rootFolderId, portletId);
			if (Validator.isNotNull(dlParentFolder)) {
				dlChildFolder = DLFolderLocalServiceUtil.fetchFolder(groupId, dlParentFolder.getFolderId(), materialId);
				if (Validator.isNull(dlChildFolder)) {
					dlChildFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
							dlParentFolder.getFolderId(), materialId, "", false, serviceContext);
				}
			} else {
				dlParentFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, true, rootFolderId,
						portletId, "", true, serviceContext);
				dlChildFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
						dlParentFolder.getFolderId(), materialId, "", false, serviceContext);
			}
		}

		if (fileBytes != null) {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, dlChildFolder.getFolderId(),
					fileSourceName, MimeTypesUtil.getContentType(fileSourceName), fileTitle, null, null, fileBytes,
					serviceContext);
		}
		return fileEntry;
	}
	
	public void addDLFileEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String sourceFileName = uploadPortletRequest.getFileName("file");
			File file = uploadPortletRequest.getFile("file");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			String[] groupPermissions = { "VIEW" };
			serviceContext.setGroupPermissions(groupPermissions);
			String materialId=ParamUtil.getString(actionRequest, "materialId");
			actionResponse.setRenderParameter("materialId", materialId);
			String no=ParamUtil.getString(actionRequest, "no");
			byte[] fileBytes = null;
			long fileSize=0l;
			FileEntry fileEntry=null;
			if (null != file) {
				fileBytes = FileUtil.getBytes(file);
				fileSize=fileBytes.length/1024/1024;
			}
			String fileTitle = "";
			
			String fileExtension=sourceFileName.substring(sourceFileName.lastIndexOf(".")+1).toUpperCase().trim();
			String upLoadMessage="上传成功！";
			Boolean upLoadStatus=true;
			if(!fileExtension.equals("JPG")&&!fileExtension.equals("PDF")){
				upLoadMessage="文件上传仅限于jpg或者pdf格式！";
				upLoadStatus=false;
				SessionErrors.add(actionRequest, "error-key"); 
	        }else if(fileExtension.equals("JPG")){
	        	if(fileSize>2){	
	        		upLoadMessage="上传的jpg文件超过2M,请压缩后上传！";
	        		upLoadStatus=false;
	        		SessionErrors.add(actionRequest, "error-key"); 
	        	}
	        }else if(fileExtension.equals("PDF")){
	        	if(fileSize>20){	
	        		upLoadMessage="上传的pdf文件超过20M,请压缩或拆分后上传！";
	        		upLoadStatus=false;
	        		SessionErrors.add(actionRequest, "error-key"); 
	        	}
	        }
			
			if (!materialId.equals("0")&upLoadStatus) {
				
				ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
						.valueOf(materialId));
				 fileTitle = applyMaterial.getClmc() + "-" + no + "." + fileExtension.toLowerCase();
				 fileEntry=uploadFile(actionRequest, sourceFileName, fileBytes, serviceContext, "permitapplication_WAR_cpportlet", materialId, fileTitle);	
				 String fileEntryIds = applyMaterial.getFileEntryIds();
						// 添加第一条数据时
						if (Validator.isNull(fileEntryIds)) {
							fileEntryIds = fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
						}
						// 如果已有数据
						else {
							fileEntryIds = fileEntryIds + "," + fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();						
						}
						applyMaterial.setFileEntryIds(fileEntryIds);
						ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
						no=(Integer.valueOf(no)+1)+"";	
				 actionResponse.setRenderParameter("materialName", applyMaterial.getClmc());
				 actionResponse.setRenderParameter("fieId", Long.toString(fileEntry.getFileEntryId()));
				 actionResponse.setRenderParameter("name", sourceFileName);
				actionResponse.setRenderParameter("divNo", ParamUtil.getString(actionRequest, "divNo"));
				actionResponse.setRenderParameter("fileExtension", fileExtension.toLowerCase());
				SessionMessages.add(actionRequest, "request_processed",applyMaterial.getClmc()+"上传成功！"); 	
			}
			actionResponse.setRenderParameter("no", no);
			SessionMessages.add(actionRequest, "permitapplication_WAR_cpportlet" + SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setRenderParameter("path", "uploadFile");
			actionResponse.setRenderParameter("upLoadMessage", upLoadMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,
	PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
		} else {
	portletRequestDispatcher.include(renderRequest, renderResponse);
		}
}


}
