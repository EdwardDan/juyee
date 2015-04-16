package com.justonetech.biz.controller.web;

import com.justonetech.biz.daoservice.WebQualifyPermitItemsService;
import com.justonetech.biz.daoservice.WebUnitQualifyPermitService;
import com.justonetech.biz.domain.WebQualifyPermitItems;
import com.justonetech.biz.domain.WebUnitQualifyPermit;
import com.justonetech.biz.manager.WebScopeManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * note: 企业资质核准公告
 * User: Shaxj
 * Date: 15-4-9
 * Time: 下午2:11
 */
@Controller
public class WebUnitQualifyPermitController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(WebQualifySuggestController.class);

    @Autowired
    WebUnitQualifyPermitService webUnitQualifyPermitService;

    @Autowired
    WebQualifyPermitItemsService webQualifyPermitItemsService;


    @RequestMapping
    public String getUnitQualifyPermitInfo(Model model) throws Exception {
        String strURL = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/QyWsgg_Qx.aspx?sssx=310109";
        String doc = WebScopeManager.getDocs(strURL);

        List<WebQualifyPermitItems> all = webQualifyPermitItemsService.findAll();
        webQualifyPermitItemsService.batchDelete(all, all.size());
        List<WebUnitQualifyPermit> all1 = webUnitQualifyPermitService.findAll();
        webUnitQualifyPermitService.batchDelete(all1, all1.size());
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

        if (!doc.contains("暂无")) {
            String pages = WebScopeManager.getElementValueByKeyWords(doc, "select", "id=\"drp_page\"");
            List<String> options = WebScopeManager.getElementsFromTags(pages, "option");
            int totalPage = options.size();
// todo           for (int i = 1; i <= totalPage; i++) {
            for (int i = 1; i <= 1; i++) {
                // todo
                String pageUrl = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/QyWsgg_Qx.aspx?sssx=310109";
                String page = WebScopeManager.getDocs(pageUrl);
                String mainTable = WebScopeManager.getElementValueByKeyWords(page, "table", "id=\"gvrgg\"");
                List<String> trs = WebScopeManager.getElementsFromTags(mainTable, "tr");
                for (int j = 1; j < trs.size(); j++) {
                    List<String> td = WebScopeManager.getElementsFromTags(trs.get(j), "td");
                    WebUnitQualifyPermit permit = new WebUnitQualifyPermit();
                    permit.setUnitName(WebScopeManager.getElementValue(td.get(0), "span"));
                    permit.setPermitThing(td.get(1));
                    permit.setApplyNo(WebScopeManager.getElementValue(td.get(2), "span"));
                    permit.setTitleDate(new java.sql.Date(sp.parse(WebScopeManager.getElementValue(td.get(3), "span")).getTime()));
                    webUnitQualifyPermitService.save(permit);
                    logger.info("=============   企业资质核准公告保存成功  =============");

                    String chakan = td.get(4);
                    String canshu = chakan.substring(chakan.indexOf("clicksb(") + 8, chakan.indexOf(")"));
                    String[] split = canshu.replace("'", "").replace("\"", "").split(",");
                    String url = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/GsggFrame.aspx?sbid=" + split[0]
                            + "&time=" + split[1] + "&lx=" + split[2];
                    String view = WebScopeManager.getDocs(url);
                    String viewTable = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"ctl00_ContentPlaceHolder1_gvrsb\"");
                    List<String> viewTrs = WebScopeManager.getElementsFromTags(viewTable, "tr");
                    if (viewTrs.size() > 1) {
                        for (int k = 1; k < viewTrs.size(); k++) {
                            WebQualifyPermitItems items = new WebQualifyPermitItems();
                            List<String> tds = WebScopeManager.getElementsFromTags(viewTrs.get(k), "td");
                            String tab = WebScopeManager.getElementValue(tds.get(1), WebScopeManager.OTHERS, "</table>");
                            List<String> trList = WebScopeManager.getElementsFromTags(tab, "tr");
                            List<String> results = WebScopeManager.getElementsFromTags(trList.get(0), "td");
                            items.setPermitItem(WebScopeManager.getElementValue(results.get(0), "span"));
                            List<String> span = WebScopeManager.getElementsFromTags(results.get(1), "span");
                            items.setQualifyType(span.get(0));
                            items.setQualifyLevel(span.get(1));
                            items.setQualifyPermit(permit);
                            logger.info("=============   企业资质核准公告条目items保存成功  =============");
                        }
                    }
                }
            }
        }


        model.addAttribute("msg", "保存成功！");
        return "common/androidMsg";

    }


}
