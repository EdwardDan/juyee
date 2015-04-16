package com.justonetech.biz.controller.oa;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaTaskService;
import com.justonetech.biz.domain.OaTask;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SysUserManager;
import org.hibernate.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 任务统计--用于领导查询
 * User: Chen Junping
 * Date: 12-6-15
 */
@Controller
public class OaTaskCalcController extends BaseCRUDActionController<OaTask> {
    private Logger logger = LoggerFactory.getLogger(OaTaskController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskService oaTaskService;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/oa/oaTaskCalc/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaTaskDeal where status<>'{0}'";
            hql += " order by id desc";
            hql = FormatUtils.format(hql, Constants.OA_TASK_DELETE);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaTaskService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object status = bean.get("status");
                if (status != null && StringHelper.isNotEmpty((String) status)) {
                    bean.put("status", oaTaskManager.getStatusName(JspHelper.getString(status)));
                }
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }
}
