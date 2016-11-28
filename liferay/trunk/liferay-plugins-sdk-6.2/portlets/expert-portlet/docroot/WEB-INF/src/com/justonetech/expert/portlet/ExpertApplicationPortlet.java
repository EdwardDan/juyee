package com.justonetech.expert.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.justonetech.expert.model.Expert;
import com.justonetech.expert.model.Gzjl;
import com.justonetech.expert.model.Xlxx;
import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.model.Zysqlb;
import com.justonetech.expert.service.ExpertLocalServiceUtil;
import com.justonetech.expert.service.GzjlLocalServiceUtil;
import com.justonetech.expert.service.XlxxLocalServiceUtil;
import com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil;
import com.justonetech.expert.service.ZysqlbLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ExpertApplicationPortlet
 */
public class ExpertApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(ExpertApplicationPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		// TODO Auto-generated method stub
		String tabNum = ParamUtil.get(renderRequest, "tabNum", "1");
		renderRequest.setAttribute("tabNum", tabNum);
		super.render(renderRequest, renderResponse);
	}

	public void deleteExpert(ActionRequest request, ActionResponse response) throws NumberFormatException,
			PortalException, SystemException {
		String expertId = ParamUtil.get(request, "expertId", "");
		if (expertId != "") {
			Expert expert = ExpertLocalServiceUtil.getExpert(Long.parseLong(expertId));
			ExpertLocalServiceUtil.deleteExpert(expert);
		}
	}

	// 保存基本信息
	public void saveJbxx(ActionRequest request, ActionResponse response) throws SystemException, ParseException,
			PortalException, IOException {
		String xm = ParamUtil.getString(request, "xm");
		String xb = ParamUtil.getString(request, "xb");
		String sfzh = ParamUtil.getString(request, "sfzh");
		String csnyStr = sfzh.substring(6, 10) + "-" + sfzh.substring(10, 12);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		java.util.Date csny = sdf.parse(csnyStr);
		String gzdw = ParamUtil.getString(request, "gzdw");
		String dzyx = ParamUtil.getString(request, "dzyx");
		String txdz = ParamUtil.getString(request, "txdz");
		String yzbm = ParamUtil.getString(request, "yzbm");
		String xrzw = ParamUtil.getString(request, "xrzw");
		String zc = ParamUtil.getString(request, "zc");
		String zyzg = ParamUtil.getString(request, "zyzg");
		String cszy = ParamUtil.getString(request, "cszy");
		String zygznx = ParamUtil.getString(request, "zygznx");
		String sjhm = ParamUtil.getString(request, "sjhm");
		String lxdh = ParamUtil.getString(request, "lxdh");
		String cz = ParamUtil.getString(request, "cz");
		long expertId = ParamUtil.getLong(request, "expertId");
		Expert expert = null;
		if (Validator.isNotNull(expertId)) {
			expert = ExpertLocalServiceUtil.getExpert(expertId);
		} else {
			expert = ExpertLocalServiceUtil.createExpert(CounterLocalServiceUtil.increment());
		}
		User user  = PortalUtil.getUser(request);
		expert.setUserId(user.getUserId());
		expert.setXm(xm);
		expert.setXb(xb);
		expert.setSfzh(sfzh);
		expert.setCsny(csny);
		expert.setGzdw(gzdw);
		expert.setDzyx(dzyx);
		expert.setTxdz(txdz);
		expert.setYzbm(yzbm);
		expert.setXrzw(xrzw);
		expert.setZc(zc);
		expert.setZyzg(zyzg);
		expert.setCszy(cszy);
		expert.setZygznx(zygznx);
		expert.setSjhm(sjhm);
		expert.setLxdh(lxdh);
		expert.setCz(cz);
		if(expert.getSqbz()<1){
			expert.setSqbz(1);
		}
		ExpertLocalServiceUtil.updateExpert(expert);
		redirect(request, response, expert, 1);
	}

	public void redirect(ActionRequest request, ActionResponse response, Expert expert, int sqbz) throws IOException {
		String redirect = ParamUtil.getString(request, "redirectURL");
		int tabNum = 1;
		if (expert.getSqbz() == sqbz && sqbz < 5) {
			tabNum = sqbz + 1;
		} else if (expert.getSqbz() == sqbz && sqbz == 4) {
			tabNum = sqbz;
		} else if (expert.getSqbz() > sqbz) {
			tabNum = sqbz;
		}
		redirect += "&" + response.getNamespace() + "expertId=" + expert.getExpertId();
		redirect += "&" + response.getNamespace() + "tabNum=" + tabNum;
		response.sendRedirect(redirect);
	}

	// 保存学历信息
	public void saveXlxxs(ActionRequest request, ActionResponse response) throws SystemException, PortalException,
			IOException {
		long expertId = ParamUtil.getLong(request, "expertId");
		String[] byyxs = ParamUtil.getParameterValues(request, "byyx");
		String[] sxzys = ParamUtil.getParameterValues(request, "sxzy");
		String[] xlhxws = ParamUtil.getParameterValues(request, "xlhxw");
		String[] zxsjs = ParamUtil.getParameterValues(request, "zxsj");

		List<Xlxx> xlxxs = XlxxLocalServiceUtil.getXlxxs(expertId, -1, -1);
		if (null != xlxxs && xlxxs.size() > 0) {
			for (Xlxx xlxx : xlxxs) {
				XlxxLocalServiceUtil.deleteXlxx(xlxx);
			}
		}

		if (null != byyxs && byyxs.length > 0) {
			for (int i = 0; i < byyxs.length; i++) {
				Xlxx xlxx = XlxxLocalServiceUtil.createXlxx(CounterLocalServiceUtil.increment());
				xlxx.setByyx(byyxs[i]);
				if (null != sxzys && sxzys.length > 0) {
					xlxx.setSxzy(sxzys[i]);
				}
				if (null != xlhxws && xlhxws.length > 0) {
					xlxx.setXlhxw(xlhxws[i]);
				}
				if (null != zxsjs && zxsjs.length > 0) {
					xlxx.setZxsj(zxsjs[i]);
				}
				xlxx.setExpertId(expertId);
				XlxxLocalServiceUtil.addXlxx(xlxx);
			}

		}
		Expert expert = ExpertLocalServiceUtil.getExpert(expertId);
		if(expert.getSqbz()<2){
			expert.setSqbz(2);
		}
		
		ExpertLocalServiceUtil.updateExpert(expert);
		redirect(request, response, expert, 2);
	}

	// 保存工作简历
	public void saveGzjls(ActionRequest request, ActionResponse response) throws SystemException, PortalException,
			IOException {
		long expertId = ParamUtil.getLong(request, "expertId");
		String[] gzdws = ParamUtil.getParameterValues(request, "gzdw");
		String[] qznys = ParamUtil.getParameterValues(request, "qzny");
		String[] cszyzygzs = ParamUtil.getParameterValues(request, "cszyzygz");
		String[] zws = ParamUtil.getParameterValues(request, "zw");

		List<Gzjl> gzjls = GzjlLocalServiceUtil.getGzjls(expertId, -1, -1);
		if (null != gzjls && gzjls.size() > 0) {
			for (Gzjl gzjl : gzjls) {
				GzjlLocalServiceUtil.deleteGzjl(gzjl);
			}
		}

		if (null != gzdws && gzdws.length > 0) {
			for (int i = 0; i < gzdws.length; i++) {
				Gzjl gzjl = GzjlLocalServiceUtil.createGzjl(CounterLocalServiceUtil.increment());
				gzjl.setGzdw(gzdws[i]);
				if (null != qznys && qznys.length > 0) {
					gzjl.setQzny(qznys[i]);
				}
				if (null != cszyzygzs && cszyzygzs.length > 0) {
					gzjl.setCszyzygz(cszyzygzs[i]);
				}
				if (null != zws && zws.length > 0) {
					gzjl.setZw(zws[i]);
				}
				gzjl.setExpertId(expertId);
				GzjlLocalServiceUtil.addGzjl(gzjl);
			}

		}
		Expert expert = ExpertLocalServiceUtil.getExpert(expertId);
		if(expert.getSqbz()<3){
			expert.setSqbz(3);
		}
		ExpertLocalServiceUtil.updateExpert(expert);
		redirect(request, response, expert, 3);
	}

	// 保存在其他专家库任职情况
	public void saveZqtzjkrzqks(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, IOException {
		long expertId = ParamUtil.getLong(request, "expertId");
		String[] zjkxtlsdws = ParamUtil.getParameterValues(request, "zjkxtlsdw");
		String[] sqzys = ParamUtil.getParameterValues(request, "sqzy");
		Date[] pzrqs = ParamUtil.getDateValues(request, "pzrq", new SimpleDateFormat("yyyy-MM-dd"), null);

		List<Zqtzjkrzqk> zqtzjkrzqks = ZqtzjkrzqkLocalServiceUtil.getZqtzjkrzqks(expertId, -1, -1);
		if (null != zqtzjkrzqks && zqtzjkrzqks.size() > 0) {
			for (Zqtzjkrzqk zqtzjkrzqk : zqtzjkrzqks) {
				ZqtzjkrzqkLocalServiceUtil.deleteZqtzjkrzqk(zqtzjkrzqk);
			}
		}

		if (null != zjkxtlsdws && zjkxtlsdws.length > 0) {
			for (int i = 0; i < zjkxtlsdws.length; i++) {
				Zqtzjkrzqk zqtzjkrzqk = ZqtzjkrzqkLocalServiceUtil
						.createZqtzjkrzqk(CounterLocalServiceUtil.increment());
				zqtzjkrzqk.setZjkxtlsdw(zjkxtlsdws[i]);
				if (null != sqzys && sqzys.length > 0) {
					zqtzjkrzqk.setSqzy(sqzys[i]);
				}
				if (null != pzrqs && pzrqs.length > 0) {
					zqtzjkrzqk.setPzrq(pzrqs[i]);
				}
				zqtzjkrzqk.setExpertId(expertId);
				ZqtzjkrzqkLocalServiceUtil.addZqtzjkrzqk(zqtzjkrzqk);
			}

		}
		Expert expert = ExpertLocalServiceUtil.getExpert(expertId);
		if(expert.getSqbz()<4){
			expert.setSqbz(4);
		}
		ExpertLocalServiceUtil.updateExpert(expert);
		redirect(request, response, expert, 4);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String selectedVal = ParamUtil.getString(resourceRequest, "subject");
		List<Dictionary> zyList = null;
		try {
			Dictionary zy = DictionaryLocalServiceUtil.getDictionary(Long.parseLong(selectedVal));
			zyList = DictionaryLocalServiceUtil.findByParentId(zy.getDictionaryId(), -1, -1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject = null;
		for (Dictionary a : zyList) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("name", a.getName());
			jsonObject.put("id", a.getDictionaryId());
			jsonArray.put(jsonObject);
		}
		resourceResponse.setContentType("text/javascript");
		PrintWriter out = null;
		try {
			out = resourceResponse.getWriter();
			out.println(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	public void saveZysqlb(ActionRequest request, ActionResponse response) throws SystemException, PortalException,
			ParseException, IOException {

		String zysqlbId = ParamUtil.getString(request, "zysqlbId");
		String sx = ParamUtil.getString(request, "sx");
		String[] zy = ParamUtil.getParameterValues(request, "zy");
		String zylb = "";
		for (String lb : zy) {
			Dictionary lbDic = DictionaryLocalServiceUtil.getDictionary(Long.parseLong(lb));
			zylb += lbDic.getName() + " ";
		}
		long expertId = ParamUtil.getLong(request, "expertId");
		int zt = ParamUtil.getInteger(request, "zt");
		Zysqlb zysqlb = null;
		if (zysqlbId.equals("")) {
			zysqlb = ZysqlbLocalServiceUtil.createZysqlb(CounterLocalServiceUtil.increment());
		} else {
			zysqlb = ZysqlbLocalServiceUtil.getZysqlb(Long.parseLong(zysqlbId));
		}
		zysqlb.setSx(sx);
		zysqlb.setZy(zylb);
		zysqlb.setZt(zt);
		zysqlb.setExpertId(expertId);
		ZysqlbLocalServiceUtil.updateZysqlb(zysqlb);
	}

	public void editZysqlb(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		String zysqlbId = ParamUtil.getString(actionRequest, "zysqlbId");
		Zysqlb zysqlb = ZysqlbLocalServiceUtil.getZysqlb(Long.parseLong(zysqlbId));
		actionRequest.setAttribute("zysqlb", zysqlb);
	}

	public void deleteZysqlb(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		String zysqlbId = ParamUtil.getString(actionRequest, "zysqlbId");
		System.out.println("zysqlbId=" + zysqlbId);
		ZysqlbLocalServiceUtil.deleteZysqlb(Long.parseLong(zysqlbId));
	}
}
