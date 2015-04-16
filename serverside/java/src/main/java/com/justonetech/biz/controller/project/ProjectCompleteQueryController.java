package com.justonetech.biz.controller.project;


import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjectExtendService;
import com.justonetech.biz.daoservice.ShareProTobuildService;
import com.justonetech.biz.domain.ProjectExtend;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 竣工项目查询
 * User: Shaxj
 * Date: 14-6-12
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class ProjectCompleteQueryController extends BaseCRUDActionController<ProjectExtend> {
    private Logger logger = LoggerFactory.getLogger(ProjectExtendController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private ProjectExtendService projectExtendService;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_EXTEND_COMPLETE_EDIT));

        return "view/project/projectCompleteQuery/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String setCode, String searchType) {
        try {
            Page pageModel = new Page(page, rows, true);
            //注意：流转编号显示会造成重复记录（由于1个bjbh可能对应多个流转编号）
            String sql = "select distinct t.bjbh||ejt.jd_task_code as id,t.bjbh,ejt.jd_task_code,t.project_name,t.build_address,t.BUILD_PROPERTY,t.total_Investment,t.total_Area,t.bj_Date" +
                    ",t.build_unit_name,p.complete_Date,p.description" +
                    " from share_pro_tobuild t" +
                    " left join Project_Extend p on t.bjbh=p.bjbh " +
                    " left join excel_jd_tasks ejt on ejt.bjbh=t.bjbh " +
                    " where trim(t.belong_area)='{0}' " +
                    "  and p.complete_Date is not null";
            // 虹口区建管中心只负责3,4位报建编号为01和02的项目
            sql += " and ( t.bjbh like '__01{1}%' or t.bjbh like '__02{2}%' )";

            sql += " order by t.bj_Date desc,t.bjbh desc";
            String projectArea = configManager.getProjectArea();
            String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
            String hql = FormatUtils.format(sql, projectArea, projectAreaCode, projectAreaCode);
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectExtendService.findBySql(pageModel, query, null);

            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }
}