package com.justonetech.biz.controller.report;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ReportDeptDefineService;
import com.justonetech.biz.domain.ReportDeptDefine;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
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


/**
 * note:综合报表单位权限定义
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ReportDeptDefineController extends BaseCRUDActionController<ReportDeptDefine> {
    private Logger logger = LoggerFactory.getLogger(ReportDeptDefineController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private ReportDeptDefineService reportDeptDefineService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.REPORT_DEPT_DEFINE_EDIT));

        return "view/report/reportDeptDefine/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ReportDeptDefine order by id asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = reportDeptDefineService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ReportDeptDefine reportDeptDefine = new ReportDeptDefine();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", reportDeptDefine);

        return "view/report/reportDeptDefine/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        ReportDeptDefine reportDeptDefine = reportDeptDefineService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", reportDeptDefine);

        return "view/report/reportDeptDefine/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ReportDeptDefine reportDeptDefine = reportDeptDefineService.get(id);

        model.addAttribute("bean", reportDeptDefine);
        return "view/report/reportDeptDefine/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ReportDeptDefine entity, HttpServletRequest request) throws Exception {
        try {
            ReportDeptDefine target;
            if (entity.getId() != null) {
                target = reportDeptDefineService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "deptName",
                        "orderNo",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser"
                });

            } else {
                target = entity;
            }
            reportDeptDefineService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        reportDeptDefineService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}