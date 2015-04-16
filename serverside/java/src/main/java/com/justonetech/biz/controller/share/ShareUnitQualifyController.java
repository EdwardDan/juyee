package com.justonetech.biz.controller.share;

import com.justonetech.biz.controller.query.ProjectQueryController;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ShareUnitInfoService;
import com.justonetech.biz.daoservice.ShareUnitQualifyService;
import com.justonetech.biz.domain.ShareUnitInfo;
import com.justonetech.biz.domain.ShareUnitQualify;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 企业资质查询--用于首页显示
 * User: Chen Junping
 * Date: 14-08-20
 */
@Controller
public class ShareUnitQualifyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ShareUnitInfoService shareUnitInfoService;

    @Autowired
    private ShareUnitQualifyService shareUnitQualifyService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model, String curDate) {
        model.addAttribute("curDate", curDate);

        return "view/share/shareUnitQualify/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String curDate) {
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "select distinct a.id,b.unit_name,a.qualify_big_type_desc,a.qualify_type_desc,a.qualify_level_desc,a.accept_datetime" +
                    " from share_unit_qualify a,share_unit_info b where a.unit_id=b.id";
            if (!StringHelper.isEmpty(curDate)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parse = dateFormat.parse(curDate);
                curDate = DateTimeHelper.formatTimestamp(new Timestamp(parse.getTime()), "YYYY-MM");
                String ym = curDate.substring(0, 7);
                sql += " and to_char(a.accept_datetime,'yyyy-mm')='" + ym + "'";
            }
            sql += " order by a.accept_datetime desc";
//            System.out.println("sql = " + sql);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = shareUnitQualifyService.findBySql(pageModel, query, null);

            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看企业资质信息
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ShareUnitQualify shareUnitQualify = shareUnitQualifyService.get(id);
        ShareUnitInfo shareUnitInfo = shareUnitInfoService.get(shareUnitQualify.getUnitId());
        model.addAttribute("qualify", shareUnitQualify);
        model.addAttribute("unit", shareUnitInfo);

        return "view/share/shareUnitQualify/view";
    }
}
