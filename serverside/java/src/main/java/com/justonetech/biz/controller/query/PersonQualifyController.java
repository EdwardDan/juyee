package com.justonetech.biz.controller.query;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SharePersonQualifyService;
import com.justonetech.biz.domain.SharePersonQualify;
import com.justonetech.biz.manager.RelateManager;
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
import java.util.List;

/**
 * User: Chen Junping
 * Date: 12-3-19
 */
@Controller
public class PersonQualifyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(PersonQualifyController.class);


    @Autowired
    private RelateManager relateManager;

    @Autowired
    private SharePersonQualifyService sharePersonQualifyService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/query/personQualify/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SharePersonQualify order by personName asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sharePersonQualifyService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id,String cardNo) {
        if(id>0){
            SharePersonQualify data = sharePersonQualifyService.get(id);
            model.addAttribute("bean", data);
            model.addAttribute("unit", relateManager.getShareUnitInfo(data.getRegUnitId()));
        }else{
            List<SharePersonQualify> persons = sharePersonQualifyService.findByQuery("from SharePersonQualify where cardNo=?", cardNo);
            if(persons.size()>0){
                SharePersonQualify personQualify = persons.iterator().next();
                model.addAttribute("bean", personQualify);
                model.addAttribute("unit", relateManager.getShareUnitInfo(personQualify.getRegUnitId()));
            }
        }
        return "view/query/personQualify/view";
    }
}
