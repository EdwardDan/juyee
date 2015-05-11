package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.daoservice.ProjRelateDeptService;
import com.justonetech.biz.daoservice.ProjRelatePersonService;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.ProjRelateDept;
import com.justonetech.biz.domain.ProjRelatePerson;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:项目与单位关联
 * author: Stanley
 * create date: 2015-05-04
 * modify date: 2015-05-06
 */
@Controller
public class ProjRelateDeptController extends BaseCRUDActionController<ProjRelateDept> {
    private Logger logger = LoggerFactory.getLogger(ProjRelateDeptController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private ProjRelateDeptService projRelateDeptService;

    @Autowired
    private ProjRelatePersonService projRelatePersonService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    /**
     * 项目建设单位列表显示页面
     *
     * @param model .l
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_RELATE_DEPT_EDIT));
        return "view/project/projRelateDept/grid";
    }

    /**
     * 项目建设单位承担项目列表显示页面
     *
     * @param model
     * @param deptId
     * @return
     */
    @RequestMapping
    public String grid2(Model model, Long deptId) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("unitPrjInfoOptions", getUnitPrjInfoOptions(deptId));
        return grid(model).concat("2");
    }

    /**
     * 获取项目建设单位列表数据
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
            String sql = "select sd.id, scd.name as depttype, sd.name, sd.manager, sd.tel, sd.fax, '' as prjCharged, '' as deptPersons from sys_dept sd left join sys_code_detail scd " +
                    "on sd.category_id = scd.id order by sd.name asc ";
            //增加自定义查询条件
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
//            pageModel = projRelateDeptService.findByPage(pageModel, query);
            pageModel = sysDeptService.findBySql(pageModel, query, null);
            //输出显示
//            String json = GridJq.toJSON(columns, pageModel);
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 获取项目建设单位承担项目列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom2(HttpServletResponse response, String filters, String columns, int page, int rows, Long deptId, String year, String piName/*, String spname, String officetel, String mobile*/) {
        try {
            Page pageModel = new Page(page, rows, true);
            /*String sql = "select pd2.id, pi.year, pi.name, sp.name as spname, sp.office_tel, sp.mobile from (select * from proj_relate_dept pd where pd.dept_id = " + deptId.longValue() + ") pd2 " +
                    "left join proj_info pi on pd2.project_id = pi.id left join proj_relate_person pp on pi.id = pp.project_id left join sys_person sp on pp.person_id = sp.id " +
                    "where 1 = 1 ";*/
            String sql = "select pd2.id, pi.year, pi.name, '' as spname, '' as office_tel, '' as mobile from (select * from proj_relate_dept pd where " +
                    "pd.dept_id = " + deptId.longValue() + ") pd2 left join proj_info pi on pd2.project_id = pi.id where 1 = 1 ";
            //增加自定义查询条件
            if (StringHelper.isNotEmpty(year)) {
                sql = sql.concat(" and pi.year = " + Long.parseLong(year));
            }
            if (StringHelper.isNotEmpty(piName)) {
                sql = sql.concat(" and pi.name like '%" + piName + "%'");
            }
            /*if (StringHelper.isNotEmpty(spname)) {
                sql = sql.concat(" and sp.name like '%" + spname + "%'");
            }
            if (StringHelper.isNotEmpty(officetel)) {
                sql = sql.concat(" and sp.officetel like '%" + officetel + "%'");
            }
            if (StringHelper.isNotEmpty(mobile)) {
                sql = sql.concat(" and sp.mobile like '%" + mobile + "%'");
            }*/
            sql = sql.concat(" order by pi.year asc, pi.name asc ");

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
            pageModel = sysDeptService.findBySql(pageModel, query, null);
            //输出显示
            String json = GridJq.toJSON(pageModel.getRows(), pageModel);
            sendJSON(response, json);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增项目建设单位录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long parentId) {
        SysDept sd = new SysDept();
        if (parentId != null) {
            sd.setParent(sysDeptService.get(parentId));
        } /*else {
            sd.setParent(sysDeptService.findUniqueByProperty("code", "CJDW"));
        }*/
        sd.setCategory(sysCodeManager.getCodeDetailByCode(Constants.SYS_DEPT_CATAGORY, Constants.CONSTRUCTION_UNIT));
        sd.setIsTag(true);
        model.addAttribute("bean", sd);
        model.addAttribute("category", Constants.SYS_DEPT_CATAGORY);
        return "view/project/projRelateDept/input";
    }

    /**
     * 新增单位承担项目录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add2(Model model, Long id) {
        ProjRelateDept projRelateDept = projRelateDeptService.get(id);
        model.addAttribute("bean", projRelateDept);
        return "view/project/projRelateDept/input";
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
        SysDept sd = sysDeptService.get(id);
        if (sd.getCategory() == null) {
            sd.setCategory(sysCodeManager.getCodeDetailByCode(Constants.SYS_DEPT_CATAGORY, Constants.CONSTRUCTION_UNIT));
        }
        model.addAttribute("bean", sd);
        model.addAttribute("category", Constants.SYS_DEPT_CATAGORY);
        return "view/project/projRelateDept/input";
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
        return modify(model, id).replace("input", "view");
    }

    /**
     * 保存项目建设单位操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysDept entity, HttpServletRequest request, Long categoryId) throws Exception {
        try {
            SysDept target;
            if (entity.getId() != null) {
                target = sysDeptService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "shortName",
//                        "isLeaf",
//                        "treeId",
                        "manager",
                        "linkAddress",
                        "zipcode",
                        "tel",
                        "fax"
                });
            } else {
                target = entity;
            }
            target.setCategory(sysCodeManager.getCodeListById(categoryId));
            target.setIsValid(true);
            sysDeptService.save(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存建设单位关联项目操作
     *
     * @param response
     * @param deptId
     * @param projectIds
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void savePrjRelateDept(HttpServletResponse response, Long deptId, String projectIds) {
        if (deptId == null) {
            sendFailureJSON(response, "很抱歉，添加新承担项目时发生异常！");
            return;
        }
        if (StringHelper.isEmpty(projectIds)) {
            sendFailureJSON(response, "您未添加新的承担项目！");
        } else {
            boolean hasNewPrjDeptAddded = false;
            String originalPrjIds = "";
            String[] prjIds = projectIds.split(",");
            try {
                List<ProjRelateDept> prds = projRelateDeptService.findByQuery("from ProjRelateDept where dept.id = ?", deptId);
                for (ProjRelateDept prd : prds) {
                    originalPrjIds = originalPrjIds.concat(JspHelper.getString(prd.getProject().getId())).concat(",");
                }
//                projRelateDeptService.batchDelete(prds, prds.size());
                for (String prjId : prjIds) {
                    if (!originalPrjIds.contains(prjId)) {
                        ProjRelateDept nprd = new ProjRelateDept();
                        nprd.setDept(sysDeptService.get(deptId));
                        nprd.setProject(projInfoService.get(Long.parseLong(prjId)));
                        projRelateDeptService.save(nprd);
                        hasNewPrjDeptAddded = true;
                    }
                }
                if (hasNewPrjDeptAddded) {
                    sendSuccessJSON(response, "添加新承担项目成功！");
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
        try {
            //删除单位关联项目
            List<ProjRelateDept> prjRelDepts = projRelateDeptService.findByQuery("from ProjRelateDept where dept.id = ?", id);
            if (prjRelDepts != null && !prjRelDepts.isEmpty()) {
                for (ProjRelateDept prjRelDept : prjRelDepts) {
                    projRelateDeptService.delete(prjRelDept);
                }
            }
            //删除人员--部门从属关系
            Set<SysPersonDept> spds = sysDeptService.get(id).getSysPersonDepts();
            List<SysPerson> sps = new ArrayList<SysPerson>();
            if (spds != null && !spds.isEmpty()) {
                for (SysPersonDept spd : spds) {
                    sps.add(spd.getPerson());
                    sysPersonDeptService.delete(spd);
                }
            }
            //删除单位下属人员关联项目
            if (!sps.isEmpty()) {
                for (SysPerson sp : sps) {
                    List<ProjRelatePerson> prps = projRelatePersonService.findByQuery("from ProjRelatePerson where person.id = ?", sp.getId());
                    if (prps != null && !prps.isEmpty()) {
                        for (ProjRelatePerson prp : prps) {
                            projRelatePersonService.delete(prp);
                        }
                    }
                    //删除人员
                    sysPersonService.delete(sp);
                }
            }
            //删除单位
            sysDeptService.delete(id);
            sendSuccessJSON(response, "删除成功");
        } catch (Exception e) {
            log.error("删除项目建设单位及其承担项目失败！该单位的标识符Id为 " + id.longValue() + "。", e);
            super.processException(response, e);
            sendFailureJSON(response, "删除失败");
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
    public void delete2(HttpServletResponse response, Long id) throws Exception {
        try {
            projRelateDeptService.delete(id);
            sendSuccessJSON(response, "删除成功");
        } catch (Exception e) {
            log.error("删除失败！该单位--项目关联关系的标识符Id为 " + id.longValue() + "。", e);
            super.processException(response, e);
            sendFailureJSON(response, "删除失败");
        }
    }

    /**
     * 企业承担项目选择树
     *
     * @param type
     * @param id
     * @param icon
     * @param model
     * @return
     */
    @RequestMapping
    public String treeDataForSelect(String type, String id, String icon, Model model) {
        //按照 项目性质  项目年份  项目名称 分组
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //项目性质 ProjProperty： e.g. 重大项目
            List<Object> grpPropPrjs = simpleQueryManager.getListBySql("select pi.property_id, scd.name, count(*) as cnt from proj_info pi left join sys_code_detail scd on pi.property_id = scd.id group by pi.property_id, scd.name ");
            for (Object grpPropPrj : grpPropPrjs) {
                Object[] prji = (Object[]) grpPropPrj;
                ZTreeNode propNode = new ZTreeNode();
                propNode.setId(JspHelper.getString(prji[0]));
                propNode.setName(JspHelper.getString(prji[1]));
                propNode.setIsLeaf(JspHelper.getString(prji[2]).equals("0"));
                propNode.setType("prjProperty");
                propNode.setIcon("1");
                treeBranch.addTreeNode(propNode);
            }
        } else if (StringUtils.equals(type, "prjProperty") || StringUtils.equals(type, "prjYear")) {
            // 项目年份： e.g. 2015  或者  项目名称 e.g. xxxprj
            List<ProjInfo> grpYearPrjs = new ArrayList<ProjInfo>();
            if (StringUtils.equals(type, "prjProperty")) {
                grpYearPrjs = projInfoService.findByQuery("from ProjInfo where property.id = " + id + " order by year asc ");
            } else if (StringUtils.equals(type, "prjYear")) {
                grpYearPrjs = projInfoService.findByQuery("from ProjInfo where id = " + StringHelper.substringBefore(id, "_") + " order by name asc ");
            }
            for (ProjInfo grpYearPrj : grpYearPrjs) {
                if (StringUtils.equals(type, "prjProperty")) {
                    ZTreeNode yearNode = new ZTreeNode();
                    yearNode.setId(JspHelper.getString(grpYearPrj.getId()).concat("_").concat(JspHelper.getString(grpYearPrj.getYear())));
                    yearNode.setName(JspHelper.getString(grpYearPrj.getYear()));
                    yearNode.setIsLeaf(grpYearPrjs.isEmpty());
                    yearNode.setType("prjYear");
                    yearNode.setIcon("2");
                    treeBranch.addTreeNode(yearNode);
                } else if (StringUtils.equals(type, "prjYear")) {
                    ZTreeNode prjNode = new ZTreeNode();
                    prjNode.setId(JspHelper.getString(grpYearPrj.getId()));
                    prjNode.setName(JspHelper.getString(grpYearPrj.getName()));
                    prjNode.setIsLeaf(true);
                    prjNode.setType("prjName");
                    prjNode.setIcon("3");
                    treeBranch.addTreeNode(prjNode);
                }
            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

    /**
     * 该企业承担项目的前端options展示
     *
     * @param deptId .
     * @return options .
     */
    private String getUnitPrjInfoOptions(Long deptId) {
        String options = "";
        List<ProjRelateDept> prds = projRelateDeptService.findByQuery("from ProjRelateDept where dept.id = ?", deptId);
        if (prds != null && !prds.isEmpty()) {
            for (ProjRelateDept prd : prds) {
                options += "<option value=\"" + prd.getProject().getId() + "\">" + prd.getProject().getName() + "</option>\n";
            }
        }
        return options;
    }
}