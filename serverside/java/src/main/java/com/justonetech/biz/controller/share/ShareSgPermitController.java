package com.justonetech.biz.controller.share;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ShareProSgPermitService;
import com.justonetech.biz.domain.JdReport;
import com.justonetech.biz.domain.ShareProSgPermit;
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
 * User:
 * Date:
 */
@Controller
public class ShareSgPermitController extends BaseCRUDActionController<JdReport> {
    private Logger logger = LoggerFactory.getLogger(ShareSgPermitController.class);

    @Autowired
    private ShareProSgPermitService shareProSgPermitService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model, String curDate) {
        model.addAttribute("curDate", curDate);
        return "view/share/shareSgPermit/grid";
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
        //查询日期
        //处理获取时间
        if (curDate.substring(6, 7).equals("-")) {
            curDate = curDate.substring(0, 5) + "0" + curDate.substring(5, 6);
        } else {
            curDate = curDate.substring(0, 7);
        }
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "select bjbh||bdh as id, bjbh,bdh,pro_name,sg_zb_unit,issue_datetime from share_pro_sg_permit where issue_datetime is not null and to_char(issue_datetime,'yyyy-mm') = '" + curDate + "'";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = shareProSgPermitService.findBySql(pageModel, query, null);
            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看页面
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String bjbh, String bdh) {
        ShareProSgPermit shareProSgPermit = shareProSgPermitService.findUnique("from ShareProSgPermit where bjbh=? and bdh=?", bjbh, bdh);
        model.addAttribute("bean", shareProSgPermit);
        return "view/share/shareSgPermit/view";
    }
}
