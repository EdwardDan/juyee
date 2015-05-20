package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.daoservice.ProjRelatePersonService;
import com.justonetech.biz.domain.ProjRelatePerson;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysPerson;
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
import java.util.List;


/**
 * note:项目与人员关联
 * author: Stanley
 * create date: 2015-05-04
 * modify date: 2015-05-20
 */
@Controller
public class ProjRelatePersonController extends BaseCRUDActionController<ProjRelatePerson> {
    private Logger logger = LoggerFactory.getLogger(ProjRelatePersonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjRelatePersonService projRelatePersonService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 项目承建单位下下属人员的列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String gridForDeptPersons(Model model, Long deptId, String deptName, String originalUrl, String originalLocation) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PERSON_EDIT));
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptName);
        model.addAttribute("originalUrl", originalUrl);
        model.addAttribute("originalLocation", originalLocation);
        return "view/project/projRelatePerson/gridForDeptPersons";
    }

    /**
     * 项目承建单位下属人员承担项目列表显示页面
     *
     * @param model
     * @param personId
     * @return
     */
    @RequestMapping
    public String gridForPrjRelatePerson(Model model, Long personId) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_RELATE_DEPT_EDIT));
        model.addAttribute("personId", personId);
        model.addAttribute("personPrjInfoOptions", getPersonPrjInfoOptions(personId));
        return "view/project/projRelatePerson/gridForPrjRelatePerson";
    }

    /**
     * 根据项目承建单位获取下属人员的列表显示页面
     *
     * @param request
     * @param response
     * @param filters
     * @param columns
     * @param page
     * @param rows
     * @param deptId
     */
    @RequestMapping
    public void gridDataCustomForDeptPersons(HttpServletRequest request, HttpServletResponse response, String filters, String columns, int page, int rows, Long deptId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "select sp from SysPerson sp left join sp.sysPersonDepts spd left join spd.dept dept " +
                    " where dept.id = " + deptId.longValue() + " order by dept.treeId asc, spd.orderNo asc, sp.name asc ";
            //执行查询
            filters = filters.replaceAll("\"field\":\"(?!dept\\.name)", "\"field\":\"sp.");   //统一添加别名
            filters = filters.replaceAll("\"orderColumn\":\"company", "\"orderColumn\":\"dept");   //表头排序，单位排序有问题
            filters = filters.replaceAll("\"orderColumn\":\"(?!dept\\.name|\")", "\"orderColumn\":\"sp.");   //表头排序
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sysPersonService.findByPage(pageModel, queryTranslate.toString());
            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 获取项目承建单位下属人员承担项目列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustomForPrjRelatePerson(HttpServletResponse response, String filters, String columns, int page, int rows, Long personId, String year, String piName) {
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "select pp2.id, pi.year, pi.name, '' as spname, '' as office_tel, '' as mobile from (select * from proj_relate_person pp where " +
                    "pp.person_id = " + personId.longValue() + ") pp2 left join proj_info pi on pp2.project_id = pi.id where 1 = 1 ";
            //增加自定义查询条件
            if (StringHelper.isNotEmpty(year)) {
                sql = sql.concat(" and pi.year = " + Long.parseLong(year));
            }
            if (StringHelper.isNotEmpty(piName)) {
                sql = sql.concat(" and pi.name like '%" + piName + "%'");
            }
            sql = sql.concat(" order by pi.year asc, pi.name asc ");
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            pageModel = projRelatePersonService.findBySql(pageModel, query, null);
            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增项目关联人员录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ProjRelatePerson projRelatePerson = new ProjRelatePerson();
        model.addAttribute("bean", projRelatePerson);
        return "view/project/projRelatePerson/input";
    }

    /**
     * 给定某一部门新增人员录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String addForDeptPersons(Model model, Long deptId, String deptName) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptId != null ? sysDeptService.get(deptId).getName() : JspHelper.getString(deptName));
        model.addAttribute("bean", new SysPerson());
        return "view/system/sysPerson/input";
    }

    /**
     * 修改项目关联人员显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        ProjRelatePerson projRelatePerson = projRelatePersonService.get(id);
        model.addAttribute("bean", projRelatePerson);
        return "view/project/projRelatePerson/input";
    }

    /**
     * 修改特定部门下的某一人员页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyForDeptPersons(Model model, Long id, Long deptId, String deptName) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptName);
        model.addAttribute("bean", sysPersonService.get(id));
        return "view/system/sysPerson/input";
    }

    /**
     * 查看项目关联人员页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ProjRelatePerson projRelatePerson = projRelatePersonService.get(id);
        model.addAttribute("bean", projRelatePerson);
        return "view/project/projRelatePerson/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjRelatePerson entity, HttpServletRequest request) throws Exception {
        try {
            ProjRelatePerson target;
            if (entity.getId() != null) {
                target = projRelatePersonService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "dutyRole"
                });
            } else {
                target = entity;
            }
            projRelatePersonService.save(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存项目承建单位下属人员关联项目操作
     *
     * @param response
     * @param personId
     * @param projectIds
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void savePrjRelatePerson(HttpServletResponse response, Long personId, String projectIds) {
        if (personId == null) {
            sendFailureJSON(response, "很抱歉，添加新承担项目时发生异常！");
            return;
        }
        if (StringHelper.isEmpty(projectIds)) {
            sendFailureJSON(response, "您未添加新的承担项目！");
        } else {
            boolean hasNewPrjPersonAddded = false;
            String originalPrjIds = "";
            String[] prjIds = projectIds.split(",");
            try {
                List<ProjRelatePerson> prps = projRelatePersonService.findByQuery("from ProjRelatePerson where person.id = ?", personId);
                for (ProjRelatePerson prp : prps) {
                    originalPrjIds = originalPrjIds.concat(JspHelper.getString(prp.getProject().getId())).concat(",");
                }
                for (String prjId : prjIds) {
                    if (!originalPrjIds.contains(prjId)) {
                        ProjRelatePerson nprp = new ProjRelatePerson();
                        nprp.setPerson(sysPersonService.get(personId));
                        nprp.setProject(projInfoService.get(Long.parseLong(prjId)));
                        projRelatePersonService.save(nprp);
                        hasNewPrjPersonAddded = true;
                    }
                }
                if (hasNewPrjPersonAddded) {
                    sendSuccessJSON(response, "添加新承担项目成功！");
                } else {
                    sendSuccessJSON(response, "添加重复承担项目！");
                }
            } catch (Exception e) {
                log.error("很抱歉，添加新承担项目时发生错误！", e);
                super.processException(response, e);
                sendFailureJSON(response, "很抱歉，添加新承担项目时发生错误！");
            }
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
        projRelatePersonService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 删除人员关联项目操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void deletePrjRelatePerson(HttpServletResponse response, Long id) throws Exception {
        try {
            projRelatePersonService.delete(id);
            sendSuccessJSON(response, "删除成功");
        } catch (Exception e) {
            log.error("删除失败！该人员--项目关联关系的标识符Id为 " + id.longValue() + "。", e);
            super.processException(response, e);
            sendFailureJSON(response, "删除失败");
        }
    }

    /**
     * 该企业下属人员承担项目的前端options展示
     *
     * @param personId .
     * @return options .
     */
    private String getPersonPrjInfoOptions(Long personId) {
        String options = "";
        List<ProjRelatePerson> prps = projRelatePersonService.findByQuery("from ProjRelatePerson where person.id = ?", personId);
        if (prps != null && !prps.isEmpty()) {
            for (ProjRelatePerson prp : prps) {
                options += "<option value=\"" + prp.getProject().getId() + "\">" + prp.getProject().getName() + "</option>\n";
            }
        }
        return options;
    }
}