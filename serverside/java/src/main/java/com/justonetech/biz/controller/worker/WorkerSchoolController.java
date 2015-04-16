package com.justonetech.biz.controller.worker;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.WorkerSchoolActivityService;
import com.justonetech.biz.daoservice.WorkerSchoolService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.domain.WorkerSchool;
import com.justonetech.biz.domain.WorkerSchoolActivity;
import com.justonetech.biz.domain.bean.WorkerSchool.WorkerSchoolInfo;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:务工人员学校管理
 * author:黄国荣
 * create date:
 * modify date:2014-05-29
 */
@Controller
public class WorkerSchoolController extends BaseCRUDActionController<WorkerSchool> {
    private Logger logger = LoggerFactory.getLogger(WorkerSchoolController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private WorkerSchoolService workerSchoolService;

    @Autowired
    private WorkerSchoolActivityService workerSchoolActivityService;

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
        SysRegPerson regPerson = sysUserManager.getSysUser().getRegPerson();
        model.addAttribute("isZCYH", regPerson != null);  //是否是注册用户

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.WORKER_SCHOOLE_EDIT));

        return "view/worker/workerSchool/grid";
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
            String hql = "from WorkerSchool where 1=1 ";

            //外网参建单位只允许查看自己项目的数据
            SysRegPerson regPerson = sysUserManager.getSysUser().getRegPerson();
            if (regPerson != null) {
                String bjbh = regPersonManager.getJdBjbhCondition();
                hql += " and bjbh in (" + bjbh + ")";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = workerSchoolService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }


    /**
     * 通过bjbh编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String bjbh, Model model) {
        Map<String, Object> pam = projectManager.getProjectInfo(bjbh);
        ShareProTobuild shareProTobuild = (ShareProTobuild) pam.get("data");
        WorkerSchoolInfo winfo = new WorkerSchoolInfo();
        if (null != shareProTobuild) {
            winfo.setBjbh(shareProTobuild.getBjbh());
            winfo.setProjectName(shareProTobuild.getProjectName());
            winfo.setProjectAddress(shareProTobuild.getBuildAddress());
            winfo.setJsDept(shareProTobuild.getBuildUnitName());
            winfo.setJsDeptLxr(shareProTobuild.getBuildUnitLinkman());
            winfo.setJsDeptTel(shareProTobuild.getBuildUnitTel());
        }
        JSONArray jsonArray = JSONArray.fromObject(winfo);
        String json = jsonArray.toString();
        model.addAttribute("msg", json);
        return "common/msg";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        WorkerSchool workerSchool = new WorkerSchool();
        workerSchool.setCreateTime(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("bean", workerSchool);

        return "view/worker/workerSchool/input";
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
        WorkerSchool workerSchool = workerSchoolService.get(id);

        model.addAttribute("bean", workerSchool);

        return "view/worker/workerSchool/input";
    }


    /**
     * 活动信息
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String action(Model model, Long id) {
        WorkerSchoolActivity workerSchoolActivity = new WorkerSchoolActivity();
        model.addAttribute("schoolId", id);
        SysUser sysUser = sysUserManager.getSysUser();
        workerSchoolActivity.setOpenDate(new java.sql.Date(System.currentTimeMillis()));

        //附件按钮
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                WorkerSchoolActivity.class.getSimpleName(), workerSchoolActivity.getDoc(), sysUser.getId(), null));
        model.addAttribute("bean", workerSchoolActivity);

        return "view/worker/workerSchool/action";
    }

    /**
     * 活动修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String actionModify(Model model, Long id) {
        WorkerSchoolActivity workerSchoolActivity = workerSchoolActivityService.get(id);
        SysUser sysUser = sysUserManager.getSysUser();
        //修改附件
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                WorkerSchoolActivity.class.getSimpleName(), workerSchoolActivity.getDoc(), sysUser.getId(), null));
        //处理其他业务逻辑
        model.addAttribute("bean", workerSchoolActivity);

        return "view/worker/workerSchool/action";
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
        WorkerSchool workerSchool = workerSchoolService.get(id);

        SysUser sysUser = sysUserManager.getSysUser();
        model.addAttribute("currentUserName", sysUser.getLoginName());//current user

        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Set<WorkerSchoolActivity> workerSchoolActivities = workerSchool.getWorkerSchoolActivities();
        for (WorkerSchoolActivity data : workerSchoolActivities) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("openDate", data.getOpenDate());
            map.put("property", data.getProperty());
            map.put("attendCount", data.getAttendCount());
            map.put("title", data.getTitle());
            map.put("content", data.getContent());
            map.put("docButton", documentManager.getDownloadButton(data.getDoc()));
            map.put("createUser", data.getCreateUser());
            map.put("id", data.getId());
            mapList.add(map);

        }

        model.addAttribute("mapList", mapList);

        model.addAttribute("bean", workerSchool);

        return "view/worker/workerSchool/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") WorkerSchool entity) throws Exception {
        try {
            WorkerSchool target;
            if (entity.getId() != null) {
                target = workerSchoolService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "projectName",
                        "projectAddress",
                        "jsDept",
                        "jsDeptLxr",
                        "jsDeptTel",
                        "sgDept",
                        "sgDeptLxr",
                        "sgDeptTel",
                        "xzName",
                        "xzTel",
                        "xzDept",
                        "zzName",
                        "zzTel",
                        "zzDept"
                });

            } else {
                target = entity;
            }
            workerSchoolService.save(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 活动信息保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void actionSave(HttpServletResponse response, @ModelAttribute("bean") WorkerSchoolActivity entity, HttpServletRequest request) throws Exception {
        try {
            WorkerSchoolActivity target;
            if (entity.getId() != null) {
                target = workerSchoolActivityService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "openDate",
                        "property",
                        "attendCount",
                        "title",
                        "content"
                });

            } else {
                target = entity;
            }
            //活动添加
            String schoolId = request.getParameter("schoolId");
            if (!StringHelper.isEmpty(schoolId)) {
                target.setSchool(workerSchoolService.get(Long.valueOf(schoolId)));//

            }
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDoc(docDocument);
            }
            workerSchoolActivityService.save(target);

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
        WorkerSchool workerSchool = workerSchoolService.get(id);
        Set<WorkerSchoolActivity> workerSchoolActivities = workerSchool.getWorkerSchoolActivities();
        for (WorkerSchoolActivity workerSchoolActivity : workerSchoolActivities) {

            Long docId = workerSchoolActivity.getDoc() != null ? workerSchoolActivity.getDoc().getId() : null;
            workerSchoolActivityService.delete(workerSchoolActivity);
            //删除文档
            documentManager.removeAllDoc(docId, null);

        }

        workerSchoolService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }


    /**
     * 删除活动信息
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void actionDelete(HttpServletResponse response, Long id) throws Exception {

        WorkerSchoolActivity workerSchoolActivity = workerSchoolActivityService.get(id);
        Long docId = workerSchoolActivity.getDoc() != null ? workerSchoolActivity.getDoc().getId() : null;
        workerSchoolActivityService.delete(id);
        //删除文档
        documentManager.removeAllDoc(docId, null);
        sendSuccessJSON(response, "删除成功");
    }

}