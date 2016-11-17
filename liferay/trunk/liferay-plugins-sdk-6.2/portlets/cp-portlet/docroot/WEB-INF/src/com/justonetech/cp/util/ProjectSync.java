package com.justonetech.cp.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class ProjectSync {
	private static Log _log = LogFactoryUtil.getLog(ProjectSync.class
			.getName());
	private static Map<String, String> cookies;
	
	public static boolean projectSync(String bjbh){
		_log.info("ProjectSync start(bjbh:" + bjbh + ")...");
		cookies = getCookies();
		System.out.println("cookies1="+cookies);
		boolean result = syncProject(bjbh);
		_log.info("ProjectSync end(bjbh:" + bjbh + ")...");
		return result;
	}
	
	
	public static boolean syncProject(String bjbh) {
		 final String[] htlbArr = { "kc", "sj", "sg", "jl", "yth", "sbjl",
				"dl", "zj", "xmgl" };
		 final String[] htlbmcArr = { "勘察合同", "设计合同", "施工合同", "监理合同",
				"一体化合同", "设备监理合同", "招标代理合同", "造价合同", "项目管理合同" };
		 final int page = 1;
		 final int rows = 20;
		// 同步项目数据

		// 同步项目合同数据
		for (String htlb : htlbArr) {
			try {
				syncHtList(bjbh, htlb, page, rows);
			} catch (IOException e) {
				_log.error("IOException Error syncHtList(" + bjbh + ", " + htlb
						+ ", " + page + ", " + rows + ").");
				continue;
			} catch (SystemException e) {
				_log.error("SystemException Error syncHtList(" + bjbh + ", "
						+ htlb + ", " + page + ", " + rows + ").");
				continue;
			}
		}
		return true;
	}

	public static void syncHtList(String bjbh, String htlb, int page, int rows)
			throws IOException, SystemException {

		
		String url = "http://mis.ciac.sh.cn/XmQueryWeb/Htbs/GetHtList?bjbh="
				+ bjbh + "&htlb=" + htlb;
		Map<String, String> data = new HashMap<String, String>();
		data.put("page", String.valueOf(page));
		data.put("rows", String.valueOf(rows));
		Document doc = getConnection(url).data(data).post();
		JSONObject resultObj = JSON.parseObject(doc.body().text());
		int total=resultObj.getIntValue("total");
		if(total>rows){
			_log.info("total>rows");
			syncHtList(bjbh,htlb,page,total);
			return;
		}
		_log.info("total<rows");
		JSONArray rowsArr = resultObj.getJSONArray("rows");
		for (int i = 0; i < rowsArr.size(); i++) {
			JSONObject htObj = rowsArr.getJSONObject(i);
			String contractId = htObj.getString("wsslbh");

			Contract contract;
			try {
				contract = ContractLocalServiceUtil.getContract(contractId);
			} catch (PortalException | SystemException e) {
				contract = ContractLocalServiceUtil.createContract(contractId);
			}
			try {
				Project project=ProjectLocalServiceUtil.getProject(bjbh);
				contract.setZzjgdm(project.getJsdwjgdm());
			} catch (PortalException e1) {
			}
			contract.setBjbh(bjbh);
			contract.setHtlb(htlb);
			contract.setId(htObj.getString("id"));
			contract.setXmmc(htObj.getString("xmmc"));
			contract.setBdh(htObj.getString("bdh"));
			contract.setHtbh(htObj.getString("htbh"));
			contract.setZbhtbh(htObj.getString("zbhtbh"));
			contract.setFbhtbh(htObj.getString("fbhtbh"));
			contract.setLwfbhtbh(htObj.getString("lwfbhtbh"));
			contract.setCbfs(htObj.getString("cbfs_desc"));
			contract.setFbdw(htObj.getString("fbdw"));
			contract.setCbdw(htObj.getString("cbdw"));
			contract.setHtzt(htObj.getString("htzt"));
			contract.setSfsl(htObj.getString("sfsl"));
			contract.setSfzx(htObj.getString("sfzx"));
			contract.setZxsm(htObj.getString("zxsm"));
			contract.setState(htObj.getString("status"));
			contract.setSlsj(new Date(Long.parseLong(htObj.getString("slsj")
					.replace("/Date(", "").replace(")/", ""))));
			contract.setBssj(GetterUtil.getDate(htObj.getString("bssh"),
					new SimpleDateFormat("yyyy/MM/dd")));
			contract = syncHtbaxx(contract);
			contract = syncHtbaDetail(contract);

			ContractLocalServiceUtil.updateContract(contract);
		}

	}

	public static Contract syncHtbaxx(Contract contract) {
		String url = "http://mis.ciac.sh.cn/htbaintraweb/htba/Htbaxx.aspx?wsslbh="
				+ contract.getContractId();
		try {
			Document doc = getConnection(url).get();
			String htbaDetailURL=doc.getElementById("maincontent_lnkView").attr("href");
			contract.setHtid(htbaDetailURL.substring(htbaDetailURL.lastIndexOf("=")+1));
			contract.setHtlx(doc.getElementById("maincontent_lblHtlx").text());
			contract.setCbfs(doc.getElementById("maincontent_lblCbfs").text());
			if (contract.getHtlx().equals("施工")
					&& contract.getCbfs().equals("总包")) {
				contract = syncSgzbHtba(contract, doc);
			} else if (contract.getHtlx().equals("设计施工一体化")) {
				contract = syncSjsgythHtba(contract, doc);
			} else if (contract.getHtlx().equals("勘察设计施工一体化")) {
				contract = syncKcsjsgythHtba(contract, doc);
			}
		} catch (IOException e) {
			_log.error("syncHtbaDetail error!url:" + url);
			_log.error(e.getMessage());
		}
		return contract;
	}

	private static Contract syncSgzbHtba(Contract contract, Document doc) {
		contract.setContractId(doc.getElementById("maincontent_lblWsslbh")
				.text());
		contract.setBjbh(doc.getElementById("maincontent_lblBjbh").text());
		contract.setBdh(doc.getElementById("maincontent_lblBdh").text());
		contract.setHtmc(doc.getElementById("maincontent_lblXmmc").text());
		contract.setHtlx(doc.getElementById("maincontent_lblHtlx").text());
		contract.setCbfs(doc.getElementById("maincontent_lblCbfs").text());
		contract.setFbdw(doc.getElementById("maincontent_hlkFbdw").text());
		contract.setCbdw(doc.getElementById("maincontent_lblCbdw").text());
		contract.setXmfzr(doc.getElementById("maincontent_lblHtfzr").text());
		contract.setXmfzrzjlx(doc.getElementById("maincontent_lblHtfzrzjlx")
				.text());
		contract.setXmfzrzjh(doc.getElementById("maincontent_lblHtfzrZjh")
				.text());
		contract.setZycbht(doc.getElementById("maincontent_lblsfzycbht").text());
		contract.setZygclb(doc.getElementById("maincontent_lblzygclb").text());
		contract.setHtqzrq(doc.getElementById("maincontent_lblHtqzrq").text());
		contract.setHtqdrq(GetterUtil.getDate(
				doc.getElementById("maincontent_lblHtqdrq").text(),
				new SimpleDateFormat("yyyy-MM-dd")));

		return contract;
	}

	private static Contract syncSjsgythHtba(Contract contract, Document doc) {
		contract.setContractId(doc.getElementById("maincontent_lblWsslbh")
				.text());
		contract.setBjbh(doc.getElementById("maincontent_lblBjbh").text());
		contract.setBdh(doc.getElementById("maincontent_lblBdh").text());
		contract.setHtmc(doc.getElementById("maincontent_lblXmmc").text());
		contract.setHtlx(doc.getElementById("maincontent_lblHtlx").text());
		contract.setCbfs(doc.getElementById("maincontent_lblCbfs").text());
		contract.setFbdw(doc.getElementById("maincontent_hlkFbdw").text());

		contract.setSjdw(doc.getElementById("maincontent_hykSjdw").text());
		contract.setSjfzr(doc.getElementById("maincontent_lblSjhtfzr").text());
		contract.setSjfzrzjlx(doc.getElementById("maincontent_lblSjhtfzr_zjlx")
				.text());
		contract.setSjfzrzjh(doc.getElementById("maincontent_lblSjhtfzr_sfzh")
				.text());
		contract.setSgdw(doc.getElementById("maincontent_hykSgdw").text());
		contract.setSgfzr(doc.getElementById("maincontent_lblSghtfzr").text());
		contract.setSgfzrzjlx(doc.getElementById("maincontent_lblSghtfzr_zjlx")
				.text());
		contract.setSgfzrzjh(doc.getElementById("maincontent_lblSghtfzr_sfzh")
				.text());

		contract.setHtqzrq(doc.getElementById("maincontent_lblHtqzrq").text());
		contract.setHtqdrq(GetterUtil.getDate(
				doc.getElementById("maincontent_lblHtqdrq").text(),
				new SimpleDateFormat("yyyy-MM-dd")));

		return contract;
	}

	private static Contract syncKcsjsgythHtba(Contract contract, Document doc) {
		contract = syncSjsgythHtba(contract, doc);
		contract.setKcdw(doc.getElementById("maincontent_hykKcdw").text());
		contract.setKcfzr(doc.getElementById("maincontent_lblKchtfzr").text());
		contract.setKcfzrzjlx(doc.getElementById("maincontent_lblKchtfzr_zjlx")
				.text());
		contract.setKcfzrzjh(doc.getElementById("maincontent_lblKchtfzr_sfzh")
				.text());
		return contract;
	}

	public static Contract syncHtbaDetail(Contract contract) {
		String url = "http://mis.ciac.sh.cn/htbaintraweb/htba/Htba_Detail.aspx?bjbh="
				+ contract.getBjbh()
				+ "&wsslbh="
				+ contract.getContractId()
				+ "&isFlag=view&htlb="
				+ contract.getHtlb()
				+ "&htid="
				+ contract.getHtid();
		try {
			Document doc = getConnection(url).get();
			if (contract.getHtlx().equals("施工")
					&& contract.getCbfs().equals("总包")) {
				contract = syncSgzbHtbaDetail(contract, doc);
			} else if (contract.getHtlx().equals("设计施工一体化")) {
				contract = syncSjsgythHtbaDetail(contract, doc);
			} else if (contract.getHtlx().equals("勘察设计施工一体化")) {
				contract = syncKcsjsgythHtbaDetail(contract, doc);
			}
		} catch (IOException e) {
			_log.error("syncHtbaDetail error!url:" + url);
			_log.error(e.getMessage());
		}
		return contract;
	}

	private static Contract syncHtbaDetailXmxx(Contract contract, Document doc) {
		contract.setBjbh(doc.getElementById("maincontent_HtbaXmxxCG_lblbjbh")
				.text());
		contract.setSzdq(doc.getElementById("maincontent_HtbaXmxxCG_lblszqx")
				.text());
		contract.setJsdw(doc.getElementById("maincontent_HtbaXmxxCG_lbljsdwmc")
				.text());
		contract.setJsdd(doc.getElementById("maincontent_HtbaXmxxCG_lbljsdd")
				.text());
		contract.setLxpw(doc.getElementById("maincontent_HtbaXmxxCG_lbllxpw")
				.text());
		contract.setPzwh(doc.getElementById("maincontent_HtbaXmxxCG_lblpzwh")
				.text());
		contract.setDwxz(doc.getElementById("maincontent_HtbaXmxxCG_lbldwxz")
				.text());
		contract.setZjlygc(doc.getElementById(
				"maincontent_HtbaXmxxCG_lblzjlygc").text());
		contract.setZtz(doc.getElementById("maincontent_HtbaXmxxCG_lblZtz")
				.text());
		contract.setZmj(doc.getElementById("maincontent_HtbaXmxxCG_lbljzmj")
				.text());
		contract.setXmfl(doc.getElementById("maincontent_HtbaXmxxCG_lblxmfl")
				.text());
		contract.setJsgm(doc.getElementById("maincontent_HtbaXmxxCG_lbljsgm")
				.text());
		return contract;
	}

	private static Contract syncSgzbHtbaDetail(Contract contract, Document doc) {
		contract = syncHtbaDetailXmxx(contract, doc);
		contract.setContractId(doc.getElementById("maincontent_lblwsslbh")
				.text());
		contract.setBdh(doc.getElementById("maincontent_Label73").text());
		contract.setFbfs(doc.getElementById("maincontent_lblsgzbfs").text());
		contract.setZycbht(doc.getElementById("maincontent_lblsgzycbht").text());
		contract.setZygclb(doc.getElementById("maincontent_lblsgzygclb").text());
		contract.setHtmc(doc.getElementById("maincontent_Label74").text());
		contract.setFbdw(doc.getElementById("maincontent_Label75").text());
		contract.setCbdw(doc.getElementById("maincontent_HtbaCbdws7_lblcbdw")
				.text());
		contract.setXmfzr(doc.getElementById("maincontent_Label76").text());
		contract.setXmfzrzjlx(doc.getElementById("maincontent_lblsgzjlx")
				.text());
		contract.setXmfzrzjh(doc.getElementById("maincontent_Label77").text());
		contract.setXmlb(doc.getElementById("maincontent_HtbaGcgm6_lblxmfl")
				.text());
		contract.setGclb(doc.getElementById("maincontent_HtbaGcgm6_lblgclb")
				.text());
		contract.setGcgm(doc.getElementById("maincontent_HtbaGcgm6_lblgm")
				.text());
		contract.setHtj(doc.getElementById("maincontent_Label78").text());
		contract.setZlje(doc.getElementById("maincontent_Label79").text());
		contract.setZgj(doc.getElementById("maincontent_Label80").text());
		contract.setWmcsf(doc.getElementById("maincontent_Label81").text());
		contract.setKgrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label82").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setJgrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label83").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setJsfs(doc.getElementById("maincontent_lbljsfs").text());
		contract.setHtqdrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label84").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setHtqzrq(doc.getElementById("maincontent_Label85").text());
		contract.setCbnr(doc.getElementById("maincontent_Label86").text());
		contract.setHtsfwbmc(doc.getElementById("maincontent_Label87").text());
		contract.setBz(doc.getElementById("maincontent_Label88").text());
		contract.setSfzx(doc.getElementById("maincontent_lblsfzx").text());
		// TODO 待确定注销时间类型
		// contract.setZxsj(doc.getElementById("maincontent_Label161").text());
		contract.setZxsm(doc.getElementById("maincontent_Label160").text());
		return contract;
	}

	private static Contract syncSjsgythHtbaDetail(Contract contract, Document doc) {
		contract = syncHtbaDetailXmxx(contract, doc);
		contract.setContractId(doc.getElementById("maincontent_lblwsslbh")
				.text());
		contract.setBdh(doc.getElementById("maincontent_Label135").text());
		contract.setFbfs(doc.getElementById("maincontent_lblyth").text());
		contract.setCbfs(doc.getElementById("maincontent_lblythcbfs").text());
		contract.setHtmc(doc.getElementById("maincontent_Label136").text());
		contract.setFbdw(doc.getElementById("maincontent_Label137").text());
		contract.setSjdw(doc.getElementById("maincontent_lblythsjdw").text());
		contract.setSjfzr(doc.getElementById("maincontent_Label139").text());
		contract.setSjfzrzjlx(doc.getElementById("maincontent_lblythsjzjlx")
				.text());
		contract.setSjfzrzjh(doc.getElementById("maincontent_Label140").text());
		contract.setSgdw(doc.getElementById("maincontent_lblythsgdw").text());
		contract.setSgfzr(doc.getElementById("maincontent_Label145").text());
		contract.setSgfzrzjlx(doc.getElementById("maincontent_lblythsgzjlx")
				.text());
		contract.setSgfzrzjh(doc.getElementById("maincontent_Label146").text());
		contract.setSjxmlb(doc
				.getElementById("maincontent_HtbaGcgm5_lblsjxmbl").text());
		contract.setSjgclb(doc
				.getElementById("maincontent_HtbaGcgm5_lblsjgclb").text());
		contract.setSjgcgm(doc
				.getElementById("maincontent_HtbaGcgm5_lblsjgcgm").text());
		contract.setSgxmlb(doc
				.getElementById("maincontent_HtbaGcgm5_lblsgxmlb").text());
		contract.setSggclb(doc
				.getElementById("maincontent_HtbaGcgm5_lblsggclb").text());
		contract.setSggcgm(doc
				.getElementById("maincontent_HtbaGcgm5_lblsggcgm").text());
		contract.setKgrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label147").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setJgrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label148").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setHtj(doc.getElementById("maincontent_Label149").text());
		contract.setSjf(doc.getElementById("maincontent_Label150").text());
		contract.setJazj(doc.getElementById("maincontent_Label152").text());
		contract.setZlje(doc.getElementById("maincontent_Label153").text());
		contract.setZgj(doc.getElementById("maincontent_Label154").text());
		contract.setWmcsf(doc.getElementById("maincontent_Label155").text());
		contract.setHtqdrq(GetterUtil.getDate(
				doc.getElementById("maincontent_Label156").text(),
				new SimpleDateFormat("yyyy-MM-dd")));
		contract.setHtqzrq(doc.getElementById("maincontent_Label157").text());
		contract.setHtsfwbmc(doc.getElementById("maincontent_Label158").text());
		contract.setBz(doc.getElementById("maincontent_Label159").text());
		contract.setSfzx(doc.getElementById("maincontent_lblsfzx").text());
		// TODO 待确定注销时间类型
		// contract.setZxsj(doc.getElementById("maincontent_Label161").text());
		contract.setZxsm(doc.getElementById("maincontent_Label160").text());
		return contract;
	}

	private static Contract syncKcsjsgythHtbaDetail(Contract contract, Document doc) {
		contract = syncSjsgythHtbaDetail(contract, doc);
		contract.setKcdw(doc.getElementById("maincontent_lblythkcdw").text());
		contract.setKcfzr(doc.getElementById("maincontent_Label142").text());
		contract.setKcfzrzjlx(doc.getElementById("maincontent_lblythkczjlx")
				.text());
		contract.setKcfzrzjh(doc.getElementById("maincontent_Label143").text());
		contract.setKcf(doc.getElementById("maincontent_Label151").text());
		return contract;
	}

	public static Connection getConnection(String url) throws IOException {
		System.out.println("cookies="+cookies);
		return Jsoup.connect(url).cookies(cookies).ignoreContentType(true);
	}

	private static Map<String, String> getCookies() {
		try {
			System.out.println("getCookies()");
			Response res = Jsoup
					.connect("http://mis.ciac.sh.cn/NewCiacUserSys/?type=1")
					.data("txAccount", "pdjdz").data("txPassword", "f123456")
					.method(Connection.Method.POST).execute();
			System.out.println("res.cookies="+res.cookies());
			return res.cookies();
		} catch (IOException e) {
			return null;
		}

	}

}
