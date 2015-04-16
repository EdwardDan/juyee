package com.justonetech.biz.controller.share;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ShareProJlInfoService;
import com.justonetech.biz.daoservice.ShareProKcInfoService;
import com.justonetech.biz.daoservice.ShareProSgInfoService;
import com.justonetech.biz.daoservice.ShareProSjInfoService;
import com.justonetech.biz.domain.ShareProJlInfo;
import com.justonetech.biz.domain.ShareProKcInfo;
import com.justonetech.biz.domain.ShareProSgInfo;
import com.justonetech.biz.domain.ShareProSjInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 中标通知书
 * User:
 * Date:
 */
@Controller
public class ShareBidInfoController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ShareBidInfoController.class);


    @Autowired
    private ShareProSgInfoService shareProSgInfoService;

    @Autowired
    private ShareProKcInfoService shareProKcInfoService;

    @Autowired
    private ShareProJlInfoService shareProJlInfoService;

    @Autowired
    private ShareProSjInfoService shareProSjInfoService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model, String curDate) {
        model.addAttribute("curDate", curDate);
        return "view/share/shareBidInfo/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response
     * @param filters
     * @param columns
     * @param page
     * @param rows
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, HttpSession session, int page, int rows, String curDate) {
        //处理获取时间
        if (curDate.substring(6, 7).equals("-")) {
            curDate = curDate.substring(0, 5) + "0" + curDate.substring(5, 6);
        } else {
            curDate = curDate.substring(0, 7);
        }
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "select id,bjbh,bdh,project_name,zb_type,zb_agent_unit,fee,bid_date from share_pro_xx_info  where bid_date is not null and to_char(bid_date,'yyyy-mm')='" + curDate + "' ";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = shareProJlInfoService.findBySql(pageModel, query, null);

            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }
    /*
    * 查看页面
    * */
    @RequestMapping
    public String view(Model model, String bjbh, String bdh) {
        ShareProSgInfo shareProSgInfo = shareProSgInfoService.findUnique("from ShareProSgInfo where bjbh=? and bdh=?", bjbh, bdh);
        ShareProKcInfo shareProKcInfo = shareProKcInfoService.findUnique("from ShareProKcInfo where bjbh=? and bdh=?", bjbh, bdh);
        ShareProJlInfo shareProJlInfo = shareProJlInfoService.findUnique("from ShareProJlInfo where bjbh=? and bdh=?", bjbh, bdh);
        ShareProSjInfo shareProSjInfo = shareProSjInfoService.findUnique("from ShareProSjInfo where bjbh=? and bdh=?", bjbh, bdh);
        if (shareProJlInfo != null) {
            model.addAttribute("bean", shareProJlInfo);
            model.addAttribute("fee", shareProJlInfo.getJlFee());
        }
        if (shareProKcInfo != null) {
            model.addAttribute("bean", shareProKcInfo);
            model.addAttribute("fee", shareProKcInfo.getKcFee());
        }
        if (shareProSgInfo != null) {
            model.addAttribute("bean", shareProSgInfo);
            model.addAttribute("fee", shareProSgInfo.getSgFee());
        }
        if (shareProSjInfo != null) {
            model.addAttribute("bean", shareProSjInfo);
            model.addAttribute("fee", shareProSjInfo.getSjFee());
        }
        return "view/share/shareBidInfo/view";
    }
}
