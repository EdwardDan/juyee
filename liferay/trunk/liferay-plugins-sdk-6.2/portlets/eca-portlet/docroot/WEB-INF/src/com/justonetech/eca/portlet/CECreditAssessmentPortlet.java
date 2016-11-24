package com.justonetech.eca.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import com.justonetech.eca.model.CECreditAssessment;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EnterpriseCreditAssessmentPortlet
 */
public class CECreditAssessmentPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse)
			throws PortletException, IOException {
		String mvcPath=ParamUtil.getString(renderRequest, "mvcPath");
		if(Validator.equals(mvcPath, "/portlet/ce-credit-assessment/cur-day-score.jsp")){
			curDayScoreRender(renderRequest,renderResponse);
		}else if(Validator.equals(mvcPath, "/portlet/ce-credit-assessment/ulto-score.jsp")){
			ultoScoreRender(renderRequest,renderResponse);
		}else{
			super.render(renderRequest, renderResponse);
		}
		
	}
	
	public void curDayScoreRender(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException{
		String enterpriseCode= ParamUtil.getString(renderRequest, "enterpriseCode");
		String url = "http://www.ciac.sh.cn/SHCreditInfoInterWeb/DisplayEnterpriseMonthCreditInfo/DisplayEnterpriseCreditInfoSelfCreate?enterpriseCode="+enterpriseCode;
		Document doc = Jsoup.connect(url).timeout(5000).get();
		String data = doc.select("body > div > div.row > div > div:nth-child(1)").html();
		renderRequest.setAttribute("data", data);
		super.render(renderRequest, renderResponse);
	}
	
	public void ultoScoreRender(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		String ultoReportId= ParamUtil.getString(renderRequest, "ultoReportId");
		String url = "http://www.ciac.sh.cn/SHCreditInfoInterWeb/CreditBookAnounce/DisplayCredit?reportid="+ultoReportId;
		Document doc = Jsoup.connect(url).timeout(5000).get();
		String data = doc.select("body > div > div.row > div > div:nth-child(1)").html();
		data += doc.select("body > div > div.row > div > div:nth-child(2)").html();
		renderRequest.setAttribute("data", data);
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String cur = ParamUtil.getString(renderRequest, "cur", "1");//当前页
		int total = 0;//总数
		int delta = 10;//每页条数
		String enterpriseName = ParamUtil.getString(renderRequest, "enterpriseName", "");//企业名称
		String enterpriseCode = ParamUtil.getString(renderRequest, "enterpriseCode", "");//企业组织机构代码
	
		List<CECreditAssessment> ceCreditAssessments = new ArrayList<CECreditAssessment>();
		String url="http://www.ciac.sh.cn/SHCreditInfoInterWeb/CreditBookAnounce/GetQyCreditReportAll";
		Map<String, String> queryParamMap = new HashMap<String, String>();
		queryParamMap.put("page", cur);
		queryParamMap.put("qyNam", enterpriseName);
		queryParamMap.put("qyzjCode", enterpriseCode);
		JSONObject responseData;
		try {
			responseData = JSONFactoryUtil.createJSONObject(Jsoup.connect(url)
					.data(queryParamMap).ignoreContentType(true).timeout(5000).execute().body());
			String result=responseData.getString("result");
			if(Validator.equals(result,"succecss") ){
				String resultdata=responseData.getString("resultdata");
				Document doc = Jsoup.parse(resultdata);
				Elements elements = doc.select("body > table > tbody > tr");
				for(int i = 0;i<elements.size();i++){
					Element element = elements.get(i);
					CECreditAssessment ceCreditAssessment = new CECreditAssessment();
					String curDayScoreHref=element.child(2).child(0).attr("href");
					ceCreditAssessment.setEnterpriseCode(curDayScoreHref.substring(curDayScoreHref.lastIndexOf("=")+1));
					ceCreditAssessment.setEnterpriseName(element.child(1).text().trim());
					String ultoScoreDetailHref = element.child(3).child(0).attr("href");
					ceCreditAssessment.setUltoReportId(ultoScoreDetailHref.substring(ultoScoreDetailHref.lastIndexOf("=")+1));
					ceCreditAssessment.setUltoScore(element.child(3).text().replace("明细", "").trim());
					ceCreditAssessment.setUltoScoreBaseDate(element.child(4).text());
					ceCreditAssessments.add(ceCreditAssessment);
				}
				String zongyeshu = doc.select("#zongyeshu").text();
				total = Validator.isBlank(zongyeshu)?ceCreditAssessments.size():Integer.valueOf(zongyeshu)*delta;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderRequest.setAttribute("ceCreditAssessmentsCount", total);
		renderRequest.setAttribute("ceCreditAssessments", ceCreditAssessments);
		super.doView(renderRequest, renderResponse);
	}

}
