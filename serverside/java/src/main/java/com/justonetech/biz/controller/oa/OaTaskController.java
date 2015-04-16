package com.justonetech.biz.controller.oa;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaTaskDealService;
import com.justonetech.biz.daoservice.OaTaskService;
import com.justonetech.biz.domain.OaTask;
import com.justonetech.biz.domain.OaTaskDeal;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.hibernate.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * note:任务
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaTaskController extends BaseCRUDActionController<OaTask> {
    private Logger logger = LoggerFactory.getLogger(OaTaskController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private OaTaskService oaTaskService;

    @Autowired
    private OaTaskDealService oaTaskDealService;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model,HttpServletRequest request) {
        model.addAttribute("count1",JspHelper.getString(request.getParameter("count1")));
        model.addAttribute("count2",JspHelper.getString(request.getParameter("count2")));
        return "view/oa/oaTask/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        //判断是否有编辑权限--已根据用户权限来过滤数据
        model.addAttribute("canEdit", true);

        return "view/oa/oaTask/grid";
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

            //查看所有任务
//            Boolean viewAll = sysUserManager.hasPrivilege(PrivilegeCode.SYS_TASK_VIEW_ALL);
            Boolean viewAll = false;

            Page pageModel = new Page(page, rows, true);
            String hql = "from OaTaskDeal where status<>'{0}'";
            if (!viewAll) {
                hql += " and user.id={1}";
            }
            hql += " order by id desc";
            hql = FormatUtils.format(hql, Constants.OA_TASK_DELETE, String.valueOf(userId));

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

    /**
     * 删除操作--仅作删除标记
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        OaTaskDeal taskDeal = oaTaskDealService.get(id);
        //不做限制
//        OaTask task = taskDeal.getTask();
//        if (task.getOaTaskDeals().size() == 1) {
//            sendErrorJSON(response, "当前任务只有您一个人能操作，系统不允许忽略");
//
//        } else {
            taskDeal.setStatus(Constants.OA_TASK_DELETE);
            oaTaskDealService.save(taskDeal);

            sendSuccessJSON(response, "操作成功");
//        }
    }

    /**
     * 设置任务状态，点击处理后系统设置状态为已读
     * @param response .
     * @param id .
     * @param status .
     * @throws Exception .
     */
    @RequestMapping
    public void setStatus(HttpServletResponse response, Long id,String status) throws Exception {
        OaTaskDeal taskDeal = oaTaskDealService.get(id);
//        System.out.println("........................... = " + id+"|"+status);
        if(Constants.OA_TASK_NOTREAD.equals(taskDeal.getStatus())){
            taskDeal.setStatus(!StringHelper.isEmpty(status)?status:Constants.OA_TASK_READ);
            if(taskDeal.getAcceptTime()==null){
                taskDeal.setAcceptTime(new Timestamp(System.currentTimeMillis()));
            }
            oaTaskDealService.save(taskDeal);
        }

        sendSuccessJSON(response, "操作成功");
    }

    /**
     * 未找到关联主记录时的提示页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String nullPage(Model model, Long id) {
        model.addAttribute("id", id);

        return "view/oa/oaTask/nullPage";
    }
}