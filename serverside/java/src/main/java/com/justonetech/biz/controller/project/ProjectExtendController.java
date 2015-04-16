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
 * note:项目扩展信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjectExtendController extends BaseCRUDActionController<ProjectExtend> {
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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_EXTEND_EDIT));

        return "view/project/projectExtend/grid";
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
            String sql = "SELECT * FROM (select s.bjbh as id ,s.bjbh,s.project_Name as projectName,s.build_Address as buildAddress,p.belong_Area as belongArea,p.pos_X as posX,p.pos_Y as posY" +
                    " ,s.bj_Date as bjDate from Share_Pro_ToBuild s inner join excel_jd_tasks ejt on s.bjbh=ejt.bjbh left join Project_Extend p on p.bjbh=s.bjbh " +
                    " where TRIM (s.belong_Area)='" + configManager.getProjectArea() + "' ";
            if (!StringHelper.isEmpty(searchType)) {
                if ("all".equals(searchType)) {
                    if (!StringHelper.isEmpty(setCode)) {
                        if ("0".equals(setCode)) {
                            sql += " and p.belong_Area is null or p.pos_X is null";
                        } else if ("1".equals(setCode)) {
                            sql += " and p.belong_Area is not null and p.pos_X is not null";
                        }
                    }
                }
                if ("area".equals(searchType)) {
                    if (!StringHelper.isEmpty(setCode)) {
                        if ("0".equals(setCode)) {
                            sql += " and p.belong_Area is null";
                        } else if ("1".equals(setCode)) {
                            sql += " and p.belong_Area is not null";
                        }
                    }
                }
                if ("position".equals(searchType)) {
                    if (!StringHelper.isEmpty(setCode)) {
                        if ("0".equals(setCode)) {
                            sql += " and p.pos_X is null";
                        } else if ("1".equals(setCode)) {
                            sql += " and p.pos_X is not null";
                        }
                    }
                }
            }

            sql += " and ( s.bjbh like '__01{0}%' or s.bjbh like '__02{1}%') " +
                    " ) where 1=1 order by bjDate desc nulls last";
            //执行查询
            String projectAreaCode = configManager.getProjectAreaCode().toUpperCase();
            String hql = FormatUtils.format(sql, projectAreaCode,  projectAreaCode);
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

    /**
     * 修改显示页面
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, String bjbh) {
        String sql = " from ProjectExtend where bjbh ='" + bjbh + "'";
        List<ProjectExtend> projectExtend = projectExtendService.findByQuery(sql);
        model.addAttribute("ProBelongArea", Constants.EXCEL_JDTASK_POSITION);
        model.addAttribute("bjbh", bjbh);

        String sql2 = " from ShareProTobuild where bjbh ='" + bjbh + "'";
        List<ShareProTobuild> ShareProTobuild = shareProTobuildService.findByQuery(sql2);
        model.addAttribute("projectName", (null != ShareProTobuild && ShareProTobuild.size() > 0) ? ShareProTobuild.listIterator().next().getProjectName() : "");
        //处理其他业务逻辑
        model.addAttribute("bean", (null != projectExtend && projectExtend.size() > 0) ? projectExtend.listIterator().next() : new ProjectExtend());

        return "view/project/projectExtend/input";
    }

    /**
     * 竣工项目
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String doComplete(Model model, String bjbh) {
        String sql = " from ProjectExtend where bjbh ='" + bjbh + "'";
        List<ProjectExtend> projectExtend = projectExtendService.findByQuery(sql);
        model.addAttribute("bjbh", bjbh);

        String sql2 = " from ShareProTobuild where bjbh ='" + bjbh + "'";
        List<ShareProTobuild> ShareProTobuild = shareProTobuildService.findByQuery(sql2);
        model.addAttribute("projectName", (null != ShareProTobuild && ShareProTobuild.size() > 0) ? ShareProTobuild.listIterator().next().getProjectName() : "");
        //处理其他业务逻辑
        model.addAttribute("bean", (null != projectExtend && projectExtend.size() > 0) ? projectExtend.listIterator().next() : new ProjectExtend());

        return "view/project/projectExtend/complete";
    }

    /**
     * 地图页面
     *
     * @param bjbh  .
     * @param model .
     */
    @RequestMapping
    public String map(Model model, String bjbh, String level) {
        model.addAttribute("bjbh", bjbh);
        model.addAttribute("level", !StringHelper.isEmpty(level) ? level : "14");
        String sql = " from ShareProTobuild where bjbh ='" + bjbh + "'";
        List<ShareProTobuild> list = shareProTobuildService.findByQuery(sql);
        String sql2 = " from ProjectExtend where bjbh ='" + bjbh + "'";
        List<ProjectExtend> prolist = projectExtendService.findByQuery(sql2);
        String pos = "";
        ShareProTobuild res = new ShareProTobuild();
        ProjectExtend pro = new ProjectExtend();
        if (null != list && list.size() > 0) {
            res = list.get(0);
        }
        if (null != prolist && prolist.size() > 0) {
            pro = prolist.get(0);
        }
        String x = "";
        String y = "";
        if (null != pro.getPosX()) {
            x = String.valueOf(pro.getPosX());
        }
        if (null != pro.getPosY()) {
            y = String.valueOf(pro.getPosY());
        }
        pos = "{'name':'" + res.getProjectName() + "','address':'" + res.getBuildAddress() + "','x':'" + x + "','y':'" + y + "'}";

        if (pro.getPosX() == null && pro.getPosY() == null) {
            model.addAttribute("queryValue", 3);
        } else if (pro.getPosX() != null && pro.getPosY() != null) {
            model.addAttribute("queryValue", 2);
        } else {
            model.addAttribute("queryValue", 1);
        }
        model.addAttribute("pos", pos);

        model.addAttribute("name", res.getProjectName());
        model.addAttribute("address", res.getBuildAddress());

        return "view/project/projectExtend/map";
    }

    /**
     * 查看页面
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String bjbh) {

        String sql = " from ProjectExtend where bjbh ='" + bjbh + "'";
        List<ProjectExtend> projectExtend = projectExtendService.findByQuery(sql);
        model.addAttribute("ProBelongArea", Constants.EXCEL_JDTASK_POSITION);
        model.addAttribute("bean", (null != projectExtend && projectExtend.size() > 0) ? projectExtend.listIterator().next() : new ProjectExtend());
        model.addAttribute("bjbh", bjbh);

        String sql2 = " from ShareProToBuild where bjbh ='" + bjbh + "'";
        List<ShareProTobuild> ShareProTobuild = shareProTobuildService.findByQuery(sql2);
        model.addAttribute("projectName", (null != ShareProTobuild && ShareProTobuild.size() > 0) ? ShareProTobuild.listIterator().next().getProjectName() : "");

        return "view/project/projectExtend/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjectExtend entity, HttpServletRequest request) throws Exception {
        try {
            ProjectExtend target;
            if (entity.getId() != null) {
                target = projectExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "belongArea"
                });

            } else {
                target = entity;
            }
            projectExtendService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveCompleteInfo(HttpServletResponse response, @ModelAttribute("bean") ProjectExtend entity, HttpServletRequest request) throws Exception {
        try {
            ProjectExtend target;
            if (entity.getId() != null) {
                target = projectExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "description",
                        "completeDate"
                });

            } else {
                target = entity;
            }
            projectExtendService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存操作
     *
     * @param response .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveMap(HttpServletResponse response, Double x, Double y, String bjbh) throws Exception {
        try {
            String sql = " from ProjectExtend where bjbh ='" + bjbh + "'";
            List<ProjectExtend> list = projectExtendService.findByQuery(sql);
            ProjectExtend target;
            if (null != list && list.size() > 0) {
                target = list.iterator().next();
            } else {
                target = new ProjectExtend();
            }
            target.setPosX(x);
            target.setPosY(y);
            target.setBjbh(bjbh);
            projectExtendService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param bjbh     .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, String bjbh) throws Exception {
        String sql = "from ProjectExtend where bjbh='" + bjbh + "'";

        List<ProjectExtend> projectExtend = projectExtendService.findByQuery(sql);
        if (projectExtend.size() > 0) {
            projectExtendService.delete(projectExtend.listIterator().next());
        }

        sendSuccessJSON(response, "删除成功");
    }

}