package com.justonetech.biz.controller.web;

import com.justonetech.biz.daoservice.WebQualifySuggestResultsService;
import com.justonetech.biz.daoservice.WebUnitQualifySuggestService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.WebScopeManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * note:企业资质审查意见公示
 * User: Shaxj
 * Date: 15-4-9
 * Time: 下午2:02
 */
@Controller
public class WebQualifySuggestController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(WebQualifySuggestController.class);

    @Autowired
    WebUnitQualifySuggestService webUnitQualifySuggestService;

    @Autowired
    WebQualifySuggestResultsService webQualifySuggestResultsService;

    @RequestMapping
    public String getQualifySuggestInfo(Model model) throws Exception {
        // todo
//        String strURL = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWsGsGg/scgs_Qx.aspx?sssx=310109";
        String strURL = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWsGsGg/scgs_PD.aspx";
        String doc = WebScopeManager.getDocs(strURL);

        List<WebQualifySuggestResults> all = webQualifySuggestResultsService.findAll();
        webQualifySuggestResultsService.batchDelete(all, all.size());
        List<WebUnitQualifySuggest> all1 = webUnitQualifySuggestService.findAll();
        webUnitQualifySuggestService.batchDelete(all1, all1.size());
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

        if (!doc.contains("暂无审查公示数据")) {
            String pages = WebScopeManager.getElementValueByKeyWords(doc, "span", "id=\"lbPage1\"");
            int totalPage = Integer.parseInt(pages.substring((pages.indexOf("共") + 1), pages.indexOf("条记录")).trim());
// todo           for (int i = 1; i <= totalPage; i++) {
            for (int i = 1; i <= 1; i++) {
                // todo
                String pageUrl = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWsGsGg/scgs_PD.aspx";   //浦东区
                String page = WebScopeManager.getDocs(pageUrl);
                String mainTable = WebScopeManager.getElementValueByKeyWords(page, "table", "id=\"gvrscgs\"");
                List<String> trs = WebScopeManager.getElementsFromTags(mainTable, "tr");
                for (int j = 1; j < trs.size(); j++) {
                    List<String> td = WebScopeManager.getElementsFromTags(trs.get(j), "td");

                    WebUnitQualifySuggest webUnitQualifySuggest = new WebUnitQualifySuggest();
                    webUnitQualifySuggest.setUnitName(WebScopeManager.getElementValue(td.get(1), "span"));
                    webUnitQualifySuggest.setApplys(WebScopeManager.getElementValue(td.get(2), "span"));
                    webUnitQualifySuggest.setAcceptNo(WebScopeManager.getElementValue(td.get(3), "span"));
                    String date = WebScopeManager.getElementValue(td.get(4), "span");
                    if (!StringHelper.isEmpty(date)) {
                        webUnitQualifySuggest.setPublicDate(new java.sql.Date(sp.parse(date).getTime()));
                    }
                    webUnitQualifySuggestService.save(webUnitQualifySuggest);
                    logger.info("=============   企业资质审查意见公示保存成功  =============");

                    String chakan = td.get(5);
                    if (!StringHelper.isEmpty(chakan)) {
                        int index = chakan.indexOf("href=") + 6;
                        String viewUrl = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWsGsGg/" +
                                chakan.substring(index, chakan.indexOf("'", index));
                        String view = WebScopeManager.getDocs(viewUrl);
                        String mainViewTable = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"gvlist\"");
                        List<String> viewTrs = WebScopeManager.getElementsFromTags(mainViewTable, "tr");
                        if (viewTrs.size() > 1) {
                            for (int k = 1; k < viewTrs.size(); k++) {
                                List<String> resultList = WebScopeManager.getElementsFromTags(viewTrs.get(k), "td");
                                WebQualifySuggestResults results = new WebQualifySuggestResults();
                                results.setAyyly(WebScopeManager.getElementValue(resultList.get(1), "span"));
                                results.setAdvice(resultList.get(2));
                                results.setContent(resultList.get(3));
                                results.setQualifySuggest(webUnitQualifySuggest);
                                webQualifySuggestResultsService.save(results);
                                logger.info("=============   企业资质核准条目保存成功  =============");
                            }
                        }
                    }
                }
            }
        }


        model.addAttribute("msg", "保存成功！");
        return "common/androidMsg";
    }


}
