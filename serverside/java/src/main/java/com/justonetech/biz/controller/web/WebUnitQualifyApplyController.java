package com.justonetech.biz.controller.web;

import com.justonetech.biz.daoservice.*;
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
 * note:企业资质申请
 * User: Shaxj
 * Date: 15-4-9
 * Time: 上午9:14
 */
@Controller
public class WebUnitQualifyApplyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(WebUnitQualifyApplyController.class);

    @Autowired
    WebQualifyAcceptInfoService webQualifyAcceptInfoService;

    @Autowired
    WebUnitApplyQualifyService webUnitApplyQualifyService;

    @Autowired
    WebUnitPersonInfoService webUnitPersonInfoService;

    @Autowired
    WebPersonPerformanceService webPersonPerformanceService;


    @RequestMapping
    public String getUnitQualifyApplyInfo(Model model) throws Exception {
        // todo
//        String strURL = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/WsGsgg_Qx.aspx?sssx=310109";
        String strURL = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/WsGsgg_PD.aspx";   //浦东区
        String doc = WebScopeManager.getDocs(strURL);

        List<WebPersonPerformance> all = webPersonPerformanceService.findAll();
        webPersonPerformanceService.batchDelete(all, all.size());
        List<WebUnitPersonInfo> all1 = webUnitPersonInfoService.findAll();
        webUnitPersonInfoService.batchDelete(all1, all1.size());
        List<WebUnitApplyQualify> all2 = webUnitApplyQualifyService.findAll();
        webUnitApplyQualifyService.batchDelete(all2, all2.size());
        List<WebQualifyAcceptInfo> all3 = webQualifyAcceptInfoService.findAll();
        webQualifyAcceptInfoService.batchDelete(all3, all3.size());
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

        if (!doc.contains("暂无受理公示数据")) {
            String pages = WebScopeManager.getElementValueByKeyWords(doc, "span", "id=\"lbPage\"");
            int totalPage = Integer.parseInt(pages.substring((pages.indexOf("共") + 1), pages.indexOf("条记录")).trim());
// todo           for (int i = 1; i <= totalPage; i++) {
            for (int i = 1; i <= 1; i++) {
                // todo
                String pageUrl = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/WsGsgg_PD.aspx";   //浦东区
                String page = WebScopeManager.getDocs(pageUrl);
                String mainTable = WebScopeManager.getElementValueByKeyWords(page, "table", "id=\"gvrslgs\"");
                List<String> trs = WebScopeManager.getElementsFromTags(mainTable, "tr");
                for (int j = 1; j < trs.size(); j++) {

                    List<String> td = WebScopeManager.getElementsFromTags(trs.get(j), "td");
                    WebQualifyAcceptInfo webQualifyAcceptInfo = new WebQualifyAcceptInfo();
                    webQualifyAcceptInfo.setUnitName(WebScopeManager.getElementValue(td.get(1), "span"));
                    webQualifyAcceptInfo.setApplys(WebScopeManager.getElementValue(td.get(2), "span"));
                    webQualifyAcceptInfo.setAcceptNo(WebScopeManager.getElementValue(td.get(3), "span"));
                    String date = WebScopeManager.getElementValue(td.get(4), "span");
                    if (!StringHelper.isEmpty(date)) {
                        webQualifyAcceptInfo.setPublicDate(new java.sql.Date(sp.parse(date).getTime()));
                    }
                    String chakan = td.get(5);
                    String viewUrl = "http://www.ciac.sh.cn/JGBQyWsbsNewWeb/QyWSGSGg/" +
                            chakan.substring(chakan.indexOf("href=") + 6, chakan.lastIndexOf("'"));
                    String view = WebScopeManager.getDocs(viewUrl);
                    String mainViewTable = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"tab_DefaultContent\"");
                    String table = WebScopeManager.getElementValue(mainViewTable, WebScopeManager.OTHERS, "</table>");
                    List<String> viewTrs = WebScopeManager.getElementsFromTags(table, "tr");
                    webQualifyAcceptInfo.setZcAddress(WebScopeManager.getElementValue(WebScopeManager.getElementsFromTags(viewTrs.get(2), "td").get(1), "span"));
                    List<String> tr3 = WebScopeManager.getElementsFromTags(viewTrs.get(3), "td");
                    webQualifyAcceptInfo.setUnitCategory(WebScopeManager.getElementValue(tr3.get(1), "span"));
                    webQualifyAcceptInfo.setZcMoney(WebScopeManager.getElementValue(tr3.get(3), "span"));
                    webQualifyAcceptInfo.setLegalPerson(WebScopeManager.getElementValueByKeyWords(view, "span", "id=\"lbl_frxm\""));
                    webQualifyAcceptInfo.setLegalPersonTitle(WebScopeManager.getElementValueByKeyWords(view, "span", "id=\"lbl_frzc\""));
                    webQualifyAcceptInfo.setLegalPersonPersion(WebScopeManager.getElementValueByKeyWords(view, "span", "id=\"lbl_frzw\""));
                    webQualifyAcceptInfoService.save(webQualifyAcceptInfo);
                    logger.info("=============   企业资质受理情况保存成功  =============");

                    String qualifyTable = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"gvrQyzzqksb\"");
                    List<String> qualifyTr = WebScopeManager.getElementsFromTags(qualifyTable, "tr");
                    if (qualifyTr.size() > 1) {
                        for (int q = 1; q < qualifyTr.size(); q++) {
                            WebUnitApplyQualify qualify = new WebUnitApplyQualify();  // 企业申请资质
                            List<String> qualifyTds = WebScopeManager.getElementsFromTags(qualifyTr.get(q), "td");
                            qualify.setQualifyOrder(WebScopeManager.getElementValue(qualifyTds.get(0), "span"));
                            qualify.setQualifyCategory(WebScopeManager.getElementValue(qualifyTds.get(1), "span"));
                            qualify.setQualifyLevel(WebScopeManager.getElementValue(qualifyTds.get(2), "span"));

                            qualify.setQualifyAcceptInfo(webQualifyAcceptInfo);
                            webUnitApplyQualifyService.save(qualify);
                            logger.info("=============   企业申请资质保存成功  =============");
                        }
                    }

                    String mainPerson = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"gvrrySb\"");
                    if (!StringHelper.isEmpty(mainPerson)) {
                        List<String> mainPersonTr = WebScopeManager.getElementsFromTags(mainPerson, "tr");
                        if (mainPersonTr.size() > 1) {
                            for (int m = 1; m < mainPersonTr.size(); m++) {
                                List<String> mainPersontds = WebScopeManager.getElementsFromTags(mainPersonTr.get(m), "td");
                                WebUnitPersonInfo personInfo = new WebUnitPersonInfo();
                                personInfo.setPersonCategor(mainPersontds.get(1));
                                personInfo.setName(WebScopeManager.getElementValue(mainPersontds.get(2), "span"));
                                personInfo.setPosition(mainPersontds.get(3));
                                personInfo.setTitle(mainPersontds.get(4));
                                personInfo.setQualifyAcceptInfo(webQualifyAcceptInfo);
                                webUnitPersonInfoService.save(personInfo);
                                logger.info("=============   企业主要人员信息保存成功  =============");
                                //todo 保存人员业绩
//                                String s = mainPersontds.get(5);
                            }
                        }
                    }

                    String zcPerson = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"gvrzcrysb\"");
                    if (!StringHelper.isEmpty(zcPerson)) {
                        List<String> zcPersonTr = WebScopeManager.getElementsFromTags(zcPerson, "tr");
                        if (zcPersonTr.size() > 1) {
                            for (int m = 1; m < zcPersonTr.size(); m++) {
                                List<String> mainPersontds = WebScopeManager.getElementsFromTags(zcPersonTr.get(m), "td");
                                WebUnitPersonInfo personInfo = new WebUnitPersonInfo();
                                personInfo.setName(WebScopeManager.getElementValue(mainPersontds.get(1), "span"));
                                personInfo.setZcType(WebScopeManager.getElementValue(mainPersontds.get(2), "span"));

                                personInfo.setQualifyAcceptInfo(webQualifyAcceptInfo);
                                webUnitPersonInfoService.save(personInfo);
                                logger.info("=============   企业注册人员信息保存成功  =============");
                            }
                        }
                    }

                    String zyPerson = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"gvrKcsj\"");
                    if (!StringHelper.isEmpty(zyPerson)) {
                        List<String> zyPersonTr = WebScopeManager.getElementsFromTags(zyPerson, "tr");
                        if (zyPersonTr.size() > 1) {
                            for (int m = 1; m < zyPersonTr.size(); m++) {
                                List<String> zyPersontds = WebScopeManager.getElementsFromTags(zyPersonTr.get(m), "td");
                                WebUnitPersonInfo personInfo = new WebUnitPersonInfo();
                                personInfo.setName(WebScopeManager.getElementValue(zyPersontds.get(1), "span"));
                                personInfo.setTitle(zyPersontds.get(2));
                                personInfo.setMajor(zyPersontds.get(3));

                                personInfo.setQualifyAcceptInfo(webQualifyAcceptInfo);
                                webUnitPersonInfoService.save(personInfo);
                                logger.info("=============   企业专业技术人员信息保存成功  =============");
                                //todo 保存人员业绩
//                                String s = mainPersontds.get(4);
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
