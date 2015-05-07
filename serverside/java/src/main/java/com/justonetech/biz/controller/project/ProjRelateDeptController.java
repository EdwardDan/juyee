package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ProjRelateDeptService;
import com.justonetech.biz.domain.ProjRelateDept;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.SysDeptManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.domain.SysDept;
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
import java.util.List;


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
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private ProjRelateDeptService projRelateDeptService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysDeptManager sysDeptManager;

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
     * @return
     */
    @RequestMapping
    public String grid2(Model model, Long deptId) {
//        System.out.println("the deptId -----------> " + deptId);
        model.addAttribute("deptId", deptId);
        String forwardURL = grid(model).concat("2");
//        System.out.println("the forwardURL ----> " + forwardURL);
        return forwardURL;
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
            String sql = "select sd.id, scd.name as depttype, sd.name, sd.manager, sd.tel, sd.fax, '' as prjCharged from sys_dept sd left join sys_code_detail scd " +
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
    public void gridDataCustom2(HttpServletResponse response, String filters, String columns, int page, int rows, Long deptId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String sql = "select pd2.id, pi.year, pi.name, sp.name as spname, sp.office_tel, sp.mobile from (select * from proj_relate_dept pd where pd.dept_id = " + deptId.longValue() + ") pd2 " +
                    "left join proj_info pi on pd2.project_id = pi.id left join proj_relate_person pp on pi.id = pp.project_id left join sys_person sp on pp.person_id = sp.id " +
                    "order by pi.year asc, pi.name asc ";
            //增加自定义查询条件
            //执行查询
//            System.out.println("the sql statement -----------> " + sql);
            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
//            System.out.println("the query statement ----------->>>>>>>>>>>> " + query);
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
        } else {
            sd.setParent(sysDeptService.findUniqueByProperty("code", "CJDW"));
        }
        sd.setCategory(sysCodeManager.getCodeDetailByCode(Constants.SYS_DEPT_CATAGORY, Constants.CONSTRUCTION_UNIT));
        sd.setIsTag(true);
        model.addAttribute("bean", sd);
        /*ProjRelateDept projRelateDept = new ProjRelateDept();
        model.addAttribute("bean", projRelateDept);*/
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
        /*ProjRelateDept projRelateDept = projRelateDeptService.get(id);
        model.addAttribute("bean", projRelateDept);*/
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
        /*ProjRelateDept projRelateDept = projRelateDeptService.get(id);
        model.addAttribute("bean", projRelateDept);*/
//        return "view/project/projRelateDept/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysDept entity, HttpServletRequest request) throws Exception {
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
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        try {
            List<ProjRelateDept> prjRelDepts = projRelateDeptService.findByQuery("from ProjRelateDept where dept.id = ?", id);
            if (prjRelDepts != null && !prjRelDepts.isEmpty()) {
                for (ProjRelateDept prjRelDept : prjRelDepts) {
                    projRelateDeptService.delete(prjRelDept);
                }
            }//todo 需要删除项目关联的人员
            sysDeptService.delete(id);
            sendSuccessJSON(response, "删除成功");
        } catch (Exception e) {
            log.error("删除项目建设单位及其承担项目失败！该单位的标识符Id为 " + id.longValue() + "。", e);
            super.processException(response, e);
            sendFailureJSON(response, "删除失败");
        }
    }
}