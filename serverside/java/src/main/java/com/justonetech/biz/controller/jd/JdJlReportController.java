package com.justonetech.biz.controller.jd;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdJlReportService;
import com.justonetech.biz.daoservice.ShareProTobuildService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.JdJlReport;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.*;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
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
import java.sql.Date;
import java.util.*;


/**
 * note:监理报告
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class JdJlReportController extends BaseCRUDActionController<JdJlReport> {
    private Logger logger = LoggerFactory.getLogger(JdJlReportController.class);

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
    private JdJlReportService jdJlReportService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private RegPersonManager regPersonManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        SysUser sysUser = sysUserManager.getSysUser();
//        Boolean canEdit = sysUserManager.hasPrivilege(PrivilegeCode.JD_JL_REPORT_EDIT);
//
//        if(sysUser.getRegPerson()!=null){
//            canEdit = true;
//        }
//        model.addAttribute("canEdit",canEdit);

        model.addAttribute("isJLDW", sysUser.getRegPerson() != null);  //是否参建单位
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.JD_JL_REPORT_EDIT));  //内网用户允许编辑，但不允许添加


        return "view/jd/jdJlReport/grid";
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
            String hql = " from JdJlReport order by id desc";
            if (sysUserManager.getSysUser().getRegPerson() != null) {    //外网用户过滤
                String bjbhCondition = regPersonManager.getJdBjbhCondition();
                hql += " and bjbh in (" + bjbhCondition + ")";
            }
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdJlReportService.findByPage(pageModel, queryTranslate.toString());
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            List<Map> result = new ArrayList<Map>();
            Set<String> set = new HashSet<String>();
            for (Map bean : mapList) {
                JdJlReport jdJlReport = jdJlReportService.get(JspHelper.getLong(bean.get("id")));
                String contHql = "from  ShareProTobuild where bjbh ='" + jdJlReport.getBjbh() + "'";
                List<ShareProTobuild> list = shareProTobuildService.findByQuery(contHql);

                if (list.size() > 0) {
                    ShareProTobuild shareProTobuild = list.get(0);
                    String projectName = shareProTobuild.getProjectName();
                    bean.put("projectName", projectName);
                }

                String findhql = "from JdJlReport where bjbh ='" + jdJlReport.getBjbh() + "' order by reportDate desc ";
                List<JdJlReport> jlReportList = jdJlReportService.findByQuery(findhql);

                JdJlReport data = jlReportList.get(0);

                bean.put("reportTime", data.getReportDate());
                bean.put("reportCount", jlReportList.size());

                //附件显示
                bean.put("docButton", documentManager.getDownloadButton(jdJlReport.getDocument()));

            }
            for (Map bean : mapList) {
                String bjbh = (String) bean.get("bjbh");
                if (!set.contains(bjbh)) {
                    result.add(bean);
                    set.add(bjbh);
                }
            }
            mapList = result;
            String json = GridJq.toJSON(mapList, pageModel);
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
     * @param bjbh  .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String bjbh) {
        JdJlReport jdJlReport = new JdJlReport();
        SysUser sysUser = sysUserManager.getSysUser();
        //获取报建编号
        SysRegPerson regPerson = sysUser.getRegPerson();
        if (regPerson != null) {
            jdJlReport.setBjbh(bjbh);
            //监理单位
            jdJlReport.setJlDeptName(regPerson.getUnitName());
        }
//        String bjbh = regPerson.getBjbh();
//        jdJlReport.setBjbh(bjbh); //默认当前的报建编号
        jdJlReport.setReportDate(new Date(System.currentTimeMillis())); //默认提交时间

        model.addAttribute("bean", jdJlReport);

        //附件上传
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdJlReport.class.getSimpleName(), jdJlReport.getDocument(), sysUser.getId(), null));

        return "view/jd/jdJlReport/input";
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
        JdJlReport jdJlReport = jdJlReportService.get(id);
        model.addAttribute("bean", jdJlReport);

        SysUser sysUser = sysUserManager.getSysUser();
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdJlReport.class.getSimpleName(), jdJlReport.getDocument(), sysUser.getId(), null));

        return "view/jd/jdJlReport/input";
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
        JdJlReport jdJlReport = jdJlReportService.get(id);

        String bjbh = jdJlReport.getBjbh(); //获取报建编号

        //根据bjbh找出所有的监理报告
        String hql = "from JdJlReport where bjbh ='" + bjbh + "' order by id asc";
        List<JdJlReport> jdJlReportList = jdJlReportService.findByQuery(hql);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (JdJlReport data : jdJlReportList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("reportDate", data.getReportDate());
            map.put("description", data.getDescription());
            map.put("reportTypeDesc", data.getReportTypeDesc());
            map.put("docButton", documentManager.getDownloadButton(data.getDocument()));
            mapList.add(map);
        }
        model.addAttribute("mapList", mapList);

        model.addAttribute("bean", jdJlReport);

        return "view/jd/jdJlReport/view";
    }


    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(JdJlReport data) throws Exception {
        //创建任务

        if (data.getReportTypeDesc().equals("紧急报告")) {
            SysUser sysUser = sysUserManager.getSysUser();
            String privilegeCode = PrivilegeCode.JD_JL_REPORT_ALERT_URGENT;

            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            String msgTemp = oaTaskManager.getTaskTitle(data, JdJlReport.class.getSimpleName() + "_Urgent");
            String[] ids = new String[managers.size()];
            int i = 0;
            for (Long id : managers) {
                ids[i] = String.valueOf(id);
                i++;
            }
            if (null!=ids&&null!=msgTemp) {
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        } else {
            String privilegeCode = PrivilegeCode.JD_JL_REPORT_ALERT_NORMAL;
            String title = oaTaskManager.getTaskTitle(data, JdJlReport.class.getSimpleName());
            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0&&null!=title) {
                oaTaskManager.createTask(JdJlReport.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdJlReport entity, HttpServletRequest request) throws Exception {
        try {
            JdJlReport target;
            Long reportTypeId = Long.parseLong(request.getParameter("reportTypeId"));
            if (entity.getId() != null) {
                target = jdJlReportService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "reportTypeDesc",
                        "reportDate",
                        "description"
                });

            } else {
                target = entity;
            }
            SysCodeDetail sysCodeDetail = sysCodeDetailService.get(reportTypeId);
            target.setReportType(sysCodeDetail);
            target.setReportTypeDesc(sysCodeDetail.getName());
            //保存上传附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            jdJlReportService.save(target);

            createOaTask(target);//创建待办事项


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
        JdJlReport jdJlReport = jdJlReportService.get(id);

        String bjbh = jdJlReport.getBjbh();
        String hql = "from  JdJlReport where bjbh ='" + bjbh + "' order by reportDate desc";
        List<JdJlReport> jdJlReportList = jdJlReportService.findByQuery(hql);
        for (JdJlReport data : jdJlReportList) {
            jdJlReportService.delete(data);
        }
        oaTaskManager.removeTask(JdJlReport.class.getSimpleName(), id);//删除任务

        sendSuccessJSON(response, "删除成功");
    }

}