package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SgPermitOperationService;
import com.justonetech.biz.domain.SgPermitOperation;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * note:施工许可流转操作
 * author: gq
 * create date:
 * modify date:
 */
@Controller
public class SgPermitOperationController extends BaseCRUDActionController<SgPermitOperation> {
    private Logger logger = LoggerFactory.getLogger(SgPermitOperationController.class);

    @Autowired
    private SgPermitOperationService sgPermitOperationService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String sgPermitId) {
        model.addAttribute("sgPermitId", sgPermitId);

        return "view/sg/sgPermitOperation/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String sgPermitId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SgPermitOperation where 1=1";
            if (!StringHelper.isEmpty(sgPermitId)) {
                hql += " and sgPermit.id=" + sgPermitId;
            }
            hql += " order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = sgPermitOperationService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }
}