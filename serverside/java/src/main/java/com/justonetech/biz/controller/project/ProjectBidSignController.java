package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ProjectBidSignDeptService;
import com.justonetech.biz.daoservice.ProjectBidSignService;
import com.justonetech.biz.domain.ProjectBidSign;
import com.justonetech.biz.domain.ProjectBidSignDept;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.sql.Timestamp;
import java.util.*;


/**
 * note:招标登记
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjectBidSignController extends BaseCRUDActionController<ProjectBidSign> {
    private Logger logger = LoggerFactory.getLogger(ProjectBidSignController.class);

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
    private ProjectBidSignService projectBidSignService;

    @Autowired
    private ProjectBidSignDeptService projectBidSignDeptService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJECT_BID_SIGN_EDIT));

        return "view/project/projectBidSign/grid";
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
            String hql = "from ProjectBidSign where 1=1";
            Map<String, SysCodeDetail> map = status();
            //增加自定义查询条件
            hql += "and  status=" + map.get("status_DS").getId() +" or status=" + map.get("status_DJ").getId()+ " ";
            hql += "order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projectBidSignService.findByPage(pageModel, query);

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id) {
                    ProjectBidSign projectBidSign =projectBidSignService.get(JspHelper.getLong(id));
                    if(checkTime(projectBidSign)){
                        projectBidSign.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS,Constants.PROJECT_BID_SIGN_STATUS_DS));
                        projectBidSignService.save(projectBidSign);
                    }
                    if(null!=projectBidSign.getStatus()){
                         bean.put("statusName",projectBidSign.getStatus().getName());
                    }
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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ProjectBidSign projectBidSign = new ProjectBidSign();
        projectBidSign.setSignLastDate(new Timestamp(System.currentTimeMillis()));
        projectBidSign.setSignDate(new Timestamp(System.currentTimeMillis()));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", projectBidSign);

        return "view/project/projectBidSign/input";
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
        ProjectBidSign projectBidSign = projectBidSignService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", projectBidSign);

        return "view/project/projectBidSign/input";
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
        ProjectBidSign projectBidSign = projectBidSignService.get(id);
        String hql="from ProjectBidSignDept where projectBidSign.id='" + id + "'";
        List<ProjectBidSignDept> list = projectBidSignDeptService.findByQuery(hql);
        if(list.size()>0){
           model.addAttribute("list",list);
        }
        model.addAttribute("bean", projectBidSign);
        return "view/project/projectBidSign/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjectBidSign entity, HttpServletRequest request) throws Exception {
        try {
            ProjectBidSign target;
            if (entity.getId() != null) {
                target = projectBidSignService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "bdh",
                        "projectName",
                        "buildUnit",
                        "buildAddress",
                        "signLastDate",
                        "signProxyUnit",
                        "linkPerson",
                        "linkTel",
                        "signDate",
                        "signAccount"

                });

            } else {
                target = entity;
            }
            target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS,Constants.PROJECT_BID_SIGN_STATUS_DJ));
            if(checkTime(target)){
              target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS,Constants.PROJECT_BID_SIGN_STATUS_DS));
            }
            projectBidSignService.save(target);

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
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        ProjectBidSign projectBidSign =projectBidSignService.get(id);
        Set<ProjectBidSignDept> projectBidSignDepts = projectBidSign.getProjectBidSignDepts();
        for(ProjectBidSignDept projectBidSignDept:projectBidSignDepts){
            projectBidSignDeptService.delete(projectBidSignDept);
        }
        projectBidSignService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }
    /**
     * 判断是否超过报名截止72h
     *
     * @param projectBidSign       .
     */
     private boolean checkTime(ProjectBidSign projectBidSign){
         Timestamp timestamp = projectBidSign.getSignLastDate();
         Calendar ca = Calendar.getInstance();
         ca.setTimeInMillis(timestamp.getTime());

         Calendar now = Calendar.getInstance();
         now.add(Calendar.DAY_OF_YEAR,-3);
         return  now.after(ca);
     }
    /**
     * 获取各状态详情
     *
     * @return
     */
    private Map<String, SysCodeDetail> status() {
        Map<String, SysCodeDetail> map = new HashMap<String, SysCodeDetail>();
        SysCodeDetail codeDetail_DJ = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS,Constants.PROJECT_BID_SIGN_STATUS_DJ);
        SysCodeDetail codeDetail_DS = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DS);
        SysCodeDetail codeDetail_YQR = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_YQR);
        SysCodeDetail codeDetail_DT = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_DT);
        SysCodeDetail codeDetail_YT = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_BID_SIGN_STATUS, Constants.PROJECT_BID_SIGN_STATUS_YT);

        map.put("status_DJ",codeDetail_DJ);
        map.put("status_DS", codeDetail_DS);
        map.put("status_YQR", codeDetail_YQR);
        map.put("status_DT", codeDetail_DT);
        map.put("status_YT", codeDetail_YT);
        return map;
    }
}