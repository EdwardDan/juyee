package com.justonetech.biz.controller.web;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.WebScopeManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * note:项目信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class WebDealResultController extends BaseCRUDActionController<WebProjectInfo> {
    private Logger logger = LoggerFactory.getLogger(WebDealResultController.class);

    @Autowired
    WebProjectInfoService webProjectInfoService;

    @Autowired
    WebSgPermitService webSgPermitService;

    @Autowired
    WebSgPermitScopeService webSgPermitScopeService;

    @Autowired
    WebContractBackService webContractBackService;

    @Autowired
    WebContractBackPagsService webContractBackPagsService;


    /**
     * 获取项目办事结果信息
     */
    @RequestMapping
    public String getDealResultProjectInfo(Model model) throws Exception {

        String strURL = "http://www.ciac.sh.cn/wsbsweb/ciac/bulletin_xm_List_new.aspx";
        String doc = WebScopeManager.getDocs(strURL);

        List<WebContractBackPags> all = webContractBackPagsService.findAll();
        webContractBackPagsService.batchDelete(all, all.size());
        List<WebContractBack> all1 = webContractBackService.findAll();
        webContractBackService.batchDelete(all1, all1.size());
        List<WebSgPermitScope> all4 = webSgPermitScopeService.findAll();
        webSgPermitScopeService.batchDelete(all4, all4.size());
        List<WebSgPermit> all3 = webSgPermitService.findAll();
        webSgPermitService.batchDelete(all3, all3.size());
        List<WebProjectInfo> all2 = webProjectInfoService.findAll();
        webProjectInfoService.batchDelete(all2, all2.size());

        String mainTable = WebScopeManager.getElementValueByKeyWords(doc, "table", "id=\"dgXmxxList\"");
        List<String> trs = WebScopeManager.getElementsFromTags(mainTable, "tr");
        // 报建编号
        List<String> bjbhList = new ArrayList<String>();
        // 项目名称
        List<String> projectNameList = new ArrayList<String>();
        // 报建日期
        List<String> bjDateList = new ArrayList<String>();
        // 项目分类
        List<String> projectCategoryList = new ArrayList<String>();
        // 施工许可
        List<String> sgPermitList = new ArrayList<String>();
        for (String tr : trs) {
            List<String> td = WebScopeManager.getElementsFromTags(tr, "td");
            if (td.size() == 5) {
                Iterator<String> iterator = td.iterator();
                String bjbh = iterator.next();
                if (bjbh.contains("<a")) {
                    bjbhList.add(WebScopeManager.getElementsFromTags(bjbh, "a").iterator().next());
                    projectNameList.add(WebScopeManager.getElementsFromTags(iterator.next(), "a").iterator().next());
                    bjDateList.add(WebScopeManager.getElementsFromTags(iterator.next(), "a").iterator().next());
                    projectCategoryList.add(WebScopeManager.getElementsFromTags(iterator.next(), "a").iterator().next());
                    sgPermitList.add(WebScopeManager.getElementsFromTags(iterator.next(), "a").iterator().next());
                }
            }
        }

        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sp2 = new SimpleDateFormat("yyyy/MM/dd");

        for (int i = 0; i < bjbhList.size(); i++) {
            String bjbh = bjbhList.get(i);
            if (!StringHelper.isEmpty(bjbh)) {
                WebProjectInfo pro = new WebProjectInfo();
                pro.setBjbh(bjbhList.get(i));
                pro.setProject＿name(projectNameList.get(i));
                pro.setBjDate(new java.sql.Date(sp.parse(bjDateList.get(i)).getTime()));
                pro.setProjectCategory(projectCategoryList.get(i));
                pro.setSgPermit(sgPermitList.get(i));


                String viewUrl = "http://www.ciac.sh.cn/wsbsweb/ciac/bulletin_xm.aspx?bjbh=" + bjbh;
                String view = WebScopeManager.getDocs(viewUrl);
                String mainViewTable = WebScopeManager.getElementValueByKeyWords(view, "table", "id=\"tabbjxm\"");
                List<String> view_trs = WebScopeManager.getElementsFromTags(mainViewTable, "tr");

                int j = 0;
                Boolean projectInfoIsSaved = false;
                WebSgPermit webSgPermit = new WebSgPermit();

                List<String> proList = new ArrayList<String>();
                List<String> permitList = new ArrayList<String>();
                List<String> contractList = new ArrayList<String>();
                for (String view_tr : view_trs) {
                    j++;
                    List<String> td = WebScopeManager.getElementsFromTags(view_tr, "td");
                    if (td.size() == 3 || j == view_trs.size()) {
                        // 保存项目概况或者施工许可情况
                        if (j != 1) {
                            // 保存施工许可
                            if (projectInfoIsSaved || j == view_trs.size()) {
                                if (!StringHelper.isEmpty(permitList.get(0))) {
                                    webSgPermit.setPermitDate(new java.sql.Date(sp2.parse(permitList.get(0)).getTime()));
                                }
                                webSgPermit.setSjUnit(permitList.get(1));
                                webSgPermit.setSgUnit(permitList.get(2));
                                webSgPermit.setJlUnit(permitList.get(3));
                                webSgPermit.setContractMoney(permitList.get(4));
                                webSgPermit.setArea(permitList.get(5));
                                if (!StringHelper.isEmpty(permitList.get(6))) {
                                    webSgPermit.setStartDate(new java.sql.Date(sp2.parse(permitList.get(6)).getTime()));
                                }
                                if (!StringHelper.isEmpty(permitList.get(7))) {
                                    webSgPermit.setCompleteDate(new java.sql.Date(sp2.parse(permitList.get(7)).getTime()));
                                }

                                webSgPermit.setProjectInfo(pro);
                                webSgPermitService.save(webSgPermit);
                                logger.info("=============   施工许可情况保存成功  =============");

                                if (!StringHelper.isEmpty(permitList.get(8))) {
                                    String s = permitList.get(8);
                                    s = s.substring((s.indexOf("openXkfw(") + 9), (s.indexOf(");>"))).replace("'", "");
                                    String[] split = s.split(",");
                                    String viewScopeUrl = "http://www.ciac.sh.cn/wsbsweb/ciac/xkfw.aspx?bjbh=" + split[0] + "&bdh=" + split[1];
                                    String scopeView = WebScopeManager.getDocs(viewScopeUrl);
                                    List<String> scopeTr = WebScopeManager.getElementsFromTags(scopeView, "td");
                                    List<String> scopeDivs = WebScopeManager.getElementsFromTags(scopeTr.get(0), "div");
                                    WebSgPermitScope scope = new WebSgPermitScope();
                                    scope.setMainProjectInfo(scopeDivs.get(0));
                                    scope.setSgPermitScope(scopeDivs.get(1).replace("&nbsp;", "").replace("---", ""));
                                    scope.setSgPermit(webSgPermit);
                                    webSgPermitScopeService.save(scope);
                                    logger.info("=============   许可范围保存成功  =============");
                                }
                                // 下一条施工许可数据
                                webSgPermit = new WebSgPermit();

                            }
                            if (j != view_trs.size()) {
                                webSgPermit.setPermitNo(td.get(2));
                            }

                            // 保存项目概况
                            if (!projectInfoIsSaved) {
                                pro.setSjUnit(proList.get(1));
                                pro.setSjAddress(proList.get(2));
                                pro.setTotalMoney(proList.get(3));
                                pro.setTotalArea(proList.get(4));
                                webProjectInfoService.save(pro);
                                logger.info("========   项目信息保存成功  =======");
                                projectInfoIsSaved = true;
                            }
                            // 存入合同登记备案情况
                            if (j == view_trs.size()) {
                                String contractTd = td.get(1);
                                List<String> contractBacks = WebScopeManager.getElementsFromTags(contractTd, "tr");
                                if (contractBacks.size() > 0) {
                                    for (int k = 1; k < contractBacks.size(); k++) {
                                        WebContractBack webContractBack = new WebContractBack();
                                        List<String> contractBackResult = WebScopeManager.getElementsFromTags(contractBacks.get(k), "td");
                                        webContractBack.setProjectName(WebScopeManager.getElementValue(contractBackResult.get(0), "div"));
                                        webContractBack.setCbUnit(WebScopeManager.getElementValue(contractBackResult.get(1), "div"));
                                        webContractBack.setContractCategory(WebScopeManager.getElementValue(contractBackResult.get(2), "div"));
                                        webContractBack.setContractMonry(WebScopeManager.getElementValue(contractBackResult.get(3), "div"));
                                        webContractBack.setProjectInfo(pro);
                                        webContractBackService.save(webContractBack);
                                        logger.info("========   合同登记备案情况保存成功  =======");
                                        String div = WebScopeManager.getElementValue(contractBackResult.get(4), "div");
                                        if (!StringHelper.isEmpty(div)) {
                                            div = div.substring((div.indexOf("openFbqk(") + 9), (div.indexOf(");>"))).replace("'", "");
                                            String[] split = div.split(",");
                                            String contractViewUrl = "http://www.ciac.sh.cn/wsbsweb/ciac/fbqk.aspx?bjbh=" + split[0] + "&bdh=" + split[1];
                                            String contractView = WebScopeManager.getDocs(contractViewUrl);
                                            String contractPagTds = WebScopeManager.getElementValueByKeyWords(contractView, "tr", "class=\"style3\"");
                                            List<String> pagDivs = WebScopeManager.getElementsFromTags(contractPagTds, "td");
                                            WebContractBackPags webContractBackPags = new WebContractBackPags();
                                            webContractBackPags.setProjectName(WebScopeManager.getElementValue(pagDivs.get(0), "div"));
                                            webContractBackPags.setCbUnit(WebScopeManager.getElementValue(pagDivs.get(1), "div"));
                                            webContractBackPags.setContractCategory(WebScopeManager.getElementValue(pagDivs.get(2), "div"));
                                            webContractBackPags.setContractMoney(WebScopeManager.getElementValue(pagDivs.get(3), "div"));
                                            webContractBackPags.setContractBack(webContractBack);
                                            webContractBackPagsService.save(webContractBackPags);
                                            logger.info("========   合同备案分包情况保存成功！  =======");
                                        }
                                    }
                                }
                            }
                        }
                    } else if (td.size() == 2) {
                        if (j != view_trs.size()) {
                            // 存入项目信息
                            if (!projectInfoIsSaved) {
                                proList.add(td.get(1));
                                // 存入施工许可
                            } else {
                                permitList.add(td.get(1));
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