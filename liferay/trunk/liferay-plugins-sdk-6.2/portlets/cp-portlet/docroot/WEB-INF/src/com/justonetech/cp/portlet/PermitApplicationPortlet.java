package com.justonetech.cp.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

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
			String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm", "");
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

		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm");
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
		super.doView(renderRequest, renderResponse);
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

		Long xmlx = ParamUtil.getLong(request, "xmlx");
		String lxjb = ParamUtil.getString(request, "lxjb");
		Long xmxz = ParamUtil.getLong(request, "xmxz");
		String ssqx = ParamUtil.getString(request, "ssqx");
		String ywbm = ParamUtil.getString(request, "ywbm");
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
		String gyzjbz = ParamUtil.getString(request, "gyzjbz");
		String fwjzmj = ParamUtil.getString(request, "fwjzmj");
		String htjg = ParamUtil.getString(request, "htjg");
		int htgq = ParamUtil.getInteger(request, "htgq");
		String zbjg = ParamUtil.getString(request, "zbjg");
		String xmtzgs = ParamUtil.getString(request, "xmtzgs");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String jsdwlxdh = ParamUtil.getString(request, "jsdwlxdh");
		String jsdwlxr = ParamUtil.getString(request, "jsdwlxr");
		String jsdwsjh = ParamUtil.getString(request, "jsdwsjh");
		String jsydpzwjhfdccqzbh = ParamUtil.getString(request, "jsydpzwjhfdccqzbh");
		String jsgcghxkzbh = ParamUtil.getString(request, "jsgcghxkzbh");
		String xckgqk = ParamUtil.getString(request, "xckgqk");
		Date jhkg = ParamUtil.getDate(request, "jhkg", new SimpleDateFormat(dateFormatPattern));
		Date jhjg = ParamUtil.getDate(request, "jhjg", new SimpleDateFormat(dateFormatPattern));
		Boolean sfzftzl = ParamUtil.getBoolean(request, "sfzftzl");
		String yzzpl1 = ParamUtil.getString(request, "yzzpl1");
		String yzzpl2 = ParamUtil.getString(request, "yzzpl2");
		String yzzpl3 = ParamUtil.getString(request, "yzzpl3");
		String yzzpl4 = ParamUtil.getString(request, "yzzpl4");
		Long permitId = ParamUtil.getLong(request, "permitId");
		String bjbh = ParamUtil.getString(request, "bjbh");
		String bdh = ParamUtil.getString(request, "bdh");

		ProjectProfile projectProfile = null;
		Permit permit = null;
		if (permitId != 0) {
			projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			permit = PermitLocalServiceUtil.getPermit(permitId);
		} else {
			projectProfile = ProjectProfileLocalServiceUtil.createProjectProfile(CounterLocalServiceUtil.increment());
			permit = PermitLocalServiceUtil.createPermit(projectProfile.getPermitId());
			permit.setSqbz(1);
			permit.setSqzt("填写");
		}
		projectProfile.setXmlx(xmlx);
		projectProfile.setLxjb(lxjb);
		projectProfile.setXmxz(xmxz);
		projectProfile.setSsqx(ssqx);
		projectProfile.setYwbm(ywbm);
		projectProfile.setJsdwmc(jsdwmc);
		projectProfile.setJsdwxz(jsdwxz);
		projectProfile.setJsdwdz(jsdwdz);
		projectProfile.setGcmc(gcmc);
		projectProfile.setJsdd(jsdd);
		projectProfile.setJsddssqx(jsddssqx);
		projectProfile.setJsgclb(jsgclbs);
		projectProfile.setJsgcsx(jsgcsx);
		projectProfile.setJsgcgm(jsgcgm);
		projectProfile.setGyzjbz(gyzjbz);
		projectProfile.setFwjzmj(fwjzmj);
		projectProfile.setHtjg(htjg);
		projectProfile.setHtgq(htgq);
		projectProfile.setZbjg(zbjg);
		projectProfile.setXmtzgs(xmtzgs);
		projectProfile.setFddbr(fddbr);
		projectProfile.setJsdwlxdh(jsdwlxdh);
		projectProfile.setJsdwlxr(jsdwlxr);
		projectProfile.setJsdwsjh(jsdwsjh);
		projectProfile.setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
		projectProfile.setXckgqk(xckgqk);
		projectProfile.setJhkg(jhkg);
		projectProfile.setJhjg(jhjg);
		projectProfile.setSfzftzl(sfzftzl);
		projectProfile.setYzzpl1(yzzpl1);
		projectProfile.setYzzpl2(yzzpl2);
		projectProfile.setYzzpl3(yzzpl3);
		projectProfile.setYzzpl4(yzzpl4);
		ProjectProfileLocalServiceUtil.updateProjectProfile(projectProfile);
		permit.setBjbh(bjbh);
		permit.setBdh(bdh);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 1);
	}

	public void saveParticipationUnits(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

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
		System.out.println("=========" + dwmcs.toString() + dwmcs.length);
		for (int i = 0; i < dwmcs.length; i++) {
			ParticipationUnit participationUnit = ParticipationUnitLocalServiceUtil.createParticipationUnit(CounterLocalServiceUtil.increment());
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

	public void saveUnitProjects(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

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
			UnitProject unitProject = UnitProjectLocalServiceUtil.createUnitProject(CounterLocalServiceUtil.increment());
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

	public void saveApplyMaterials(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

		long permitId = ParamUtil.getLong(request, "permitId");
		String ywbh = "JT";
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if (permit.getSqbz() == 3) {
			permit.setSqbz(4);
		}

		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		ywbh = ywbh + xmlx.getCode();

		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
		ywbh = ywbh + currentDateStr;

		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		List<Long> nums = new ArrayList<Long>();
		System.out.println(permits);
		for (Permit permit_ : permits) {
			if (permit_.getYwbh().substring(4, 8).equals(currentDateStr)) {
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

		permit.setYwbh(ywbh);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 4);
	}

	public void redirect(ActionRequest request, ActionResponse response, Permit permit, int sqbz) throws IOException {

		String redirect = ParamUtil.getString(request, "redirectURL");
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
}
