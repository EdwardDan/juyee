package com.justonetech.biz.controller.jd;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.PollingDictService;
import com.justonetech.biz.domain.JdRecordQuestion;
import com.justonetech.biz.domain.PollingDict;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * note:安全质量监督--问题
 * author: shaxiaojie
 * create 2014/01/08:
 * modify 2014/01/08:
 */
@Controller
public class JdRecordQuestionController extends BaseCRUDActionController<JdRecordQuestion> {
    private Logger logger = LoggerFactory.getLogger(JdRecordQuestionController.class);

    @Autowired
    private PollingDictService pollingDictService;

    @Autowired
    private JdRecordManager jdRecordManager;

    /**
     * 问题列表
     *
     * @param model .
     * @return .
     * @throws java.io.IOException .
     */
    @RequestMapping
    public String getRecordList(String formTypeCode, String questionTypeCode, Long formId, String pageStyle, Model model) throws IOException {
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();

        List<JdRecordQuestion> jdRecordQItem = jdRecordManager.getJdRecordQuestions(formTypeCode, questionTypeCode, formId);
        model.addAttribute("formTypeCode", formTypeCode);
        model.addAttribute("questionTypeCode", questionTypeCode);
        model.addAttribute("formId", String.valueOf(formId));

        // 问题列表
        model.addAttribute("jdRecordQItem", jdRecordQItem);
        if ("input".equals(pageStyle)) {
            return "view/jd/jdRecordQuestion/jdRecordQuestionList";
        } else {
            return "view/jd/jdRecordQuestion/jdRecordQuestionListView";
        }
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(String questionTypeCode, Model model) {

        model.addAttribute("questionTypeCode", questionTypeCode);
        return "view/jd/jdRecordQuestion/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from PollingDict order by treeId asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = pollingDictService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            List rows1 = pageModel.getRows();
            for (Object o : rows1) {
                PollingDict data = (PollingDict)o;
                data.setDescription(JspHelper.getLevelStr(data.getTreeId(),"&nbsp;&nbsp;")+data.getName());
                String refRule = StringHelper.findAndReplace(JspHelper.getString(data.getRefRule()),"NULL","");
                refRule = StringHelper.findAndReplace(refRule,"\n","");
                refRule = StringHelper.findAndReplace(refRule,"\r","");
                data.setRefRule(refRule);
            }

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getQuestions(String formTypeCode, String formId, String questionTypeCode, Model model) {

        model.addAttribute("questionTypeCode", questionTypeCode);

        return "view/jd/jdRecordQuestion/questionList";
    }

    /**
     * 初始化问题页面
     * <p/>
     * //     * @param id .
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(String formTypeCode, String formId, String questionTypeCode, Model model) {

        model.addAttribute("formTypeCode", formTypeCode);
        model.addAttribute("formId", formId);
        model.addAttribute("questionTypeCode", questionTypeCode);

        return "view/jd/jdRecordQuestion/questionInit";
    }
}