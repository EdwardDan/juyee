package com.justonetech.biz.controller.oa;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaTaskDealLogService;
import com.justonetech.biz.daoservice.OaTaskLogService;
import com.justonetech.biz.daoservice.OaTaskService;
import com.justonetech.biz.domain.OaTask;
import com.justonetech.biz.domain.OaTaskDealLog;
import com.justonetech.biz.domain.OaTaskLog;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
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
 * note:任务
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaTaskHistoryController extends BaseCRUDActionController<OaTask> {
    private Logger logger = LoggerFactory.getLogger(OaTaskHistoryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskService oaTaskService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private OaTaskDealLogService oaTaskDealLogService;

    @Autowired
    private OaTaskLogService oaTaskLogService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", true);

        return "view/oa/oaTaskHistory/grid";
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
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            Long userId = loginUser != null ? sysUserManager.getSysUser(loginUser.getLoginName()).getId() : 0l;
            Boolean viewAll = sysUserManager.hasPrivilege(PrivilegeCode.SYS_TASK_VIEW_ALL);

            Page pageModel = new Page(page, rows, true);
            String hql = "from OaTaskDealLog where status<>'{0}'";
            if (!viewAll) {
                hql += " and user.id={1}";
            }
            hql += " order by id desc";
            hql = FormatUtils.format(hql, Constants.OA_TASK_DELETE, String.valueOf(userId));


            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaTaskDealLogService.findByPage(pageModel, queryTranslate.toString());

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

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        OaTaskDealLog dealLog = oaTaskDealLogService.get(id);
        OaTaskLog taskLog = dealLog.getTask();
        if(taskLog.getOaTaskDealLogs().size()==1){
            oaTaskDealLogService.delete(id);
            oaTaskLogService.delete(taskLog.getId());
        }else{
            oaTaskDealLogService.delete(id);
        }

        sendSuccessJSON(response, "删除成功");
    }
}