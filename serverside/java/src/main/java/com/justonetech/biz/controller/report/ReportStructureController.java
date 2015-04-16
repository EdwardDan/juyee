package com.justonetech.biz.controller.report;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ReportDeptDefineService;
import com.justonetech.biz.daoservice.ReportStructureService;
import com.justonetech.biz.daoservice.ReportStructureVerService;
import com.justonetech.biz.domain.ReportDeptDefine;
import com.justonetech.biz.domain.ReportStructure;
import com.justonetech.biz.domain.ReportStructureVer;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
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
import java.util.List;
import java.util.Set;


/**
 * note:综合报表结构维护
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ReportStructureController extends BaseCRUDActionController<ReportStructure> {
    private Logger logger = LoggerFactory.getLogger(ReportStructureController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ReportStructureService reportStructureService;

    @Autowired
    private ReportDeptDefineService reportDeptDefineService;

    @Autowired
    private ReportStructureVerService reportStructureVerService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/report/reportStructure/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.REPORT_STRUCTURE_EDIT));

        //上下移动使用
        model.addAttribute("clazz", ReportStructure.class.getName());

        return "view/report/reportStructure/tree";
    }

    /**
     * 获取树数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("综合报表结构维护树"));
        } else if (StringUtils.equals(id, "root")) {                                                                     //年份
            String hql = "from ReportStructureVer order by id asc";
            List<ReportStructureVer> nodeList = reportStructureVerService.findByQuery(hql);
            for (ReportStructureVer data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(false);
                if (!data.getIsValid()) {
                    treeNode.setIcon("3");
                } else {
                    treeNode.setIcon("1");
                }
                treeNode.setType("ver");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "ver")) {
            String hql = "from ReportStructure where version.id=" + id + " and parent.id is null order by treeId asc";
            List<ReportStructure> nodeList = reportStructureService.findByQuery(hql);
            for (ReportStructure data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("2");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {                                                                     //年份
            String hql = "from ReportStructure where parent.id=" + id + " order by treeId asc";
            List<ReportStructure> nodeList = reportStructureService.findByQuery(hql);
            for (ReportStructure data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("2");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.REPORT_STRUCTURE_EDIT));

        return "view/report/reportStructure/grid";
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
            String hql = "from ReportStructure order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = reportStructureService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入版本页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String addVer(Model model) {
        ReportStructureVer reportStructureVer = new ReportStructureVer();
        model.addAttribute("bean", reportStructureVer);
        return "view/report/reportStructure/inputVer";
    }

    /**
     * 新增录入表结构页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String parentId, String versionId) {
        ReportStructure reportStructure = new ReportStructure();
        //当为版本节点添加版本
        if (StringHelper.isNotEmpty(versionId) && StringHelper.isEmpty(parentId)) {
            ReportStructureVer version = reportStructureVerService.get(Long.valueOf(versionId));
            reportStructure.setVersion(version);
            System.out.println("versionId = " + versionId);
        }
        //当为报表节点从父节点获取版本
        if (!StringHelper.isEmpty(parentId) && StringHelper.isEmpty(versionId)) {
            ReportStructure parent = reportStructureService.get(Long.valueOf(parentId));
            reportStructure.setParent(parent);
            reportStructure.setVersion(parent.getVersion());
            System.out.println("parentId = " + parentId);
        }
        //获取计量单位
        model.addAttribute("REPORT_MEASURE_UNIT", Constants.REPORT_MEASURE_UNIT);

        //全部部门
        List<ReportDeptDefine> reportDeptDefines = reportDeptDefineService.findAll();
        model.addAttribute("list", reportDeptDefines);

        model.addAttribute("bean", reportStructure);

        return "view/report/reportStructure/input";
    }

    /**
     * 修改报表页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        ReportStructure reportStructure = reportStructureService.get(id);
        //获取计量单位
        model.addAttribute("REPORT_MEASURE_UNIT", Constants.REPORT_MEASURE_UNIT);

        //全部部门
        List<ReportDeptDefine> reportDeptDefines = reportDeptDefineService.findAll();
        model.addAttribute("list", reportDeptDefines);
        //处理其他业务逻辑
        model.addAttribute("bean", reportStructure);

        return "view/report/reportStructure/input";
    }

    /**
     * 修改版本页面
     *
     * @param versionId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String modifyVer(Model model, Long versionId) {
        ReportStructureVer reportStructureVer = reportStructureVerService.get(versionId);
        //处理其他业务逻辑
        model.addAttribute("bean", reportStructureVer);

        return "view/report/reportStructure/inputVer";
    }

    /**
     * 查看报表页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ReportStructure reportStructure = reportStructureService.get(id);

        model.addAttribute("bean", reportStructure);
        model.addAttribute("REPORT_MEASURE_UNIT", Constants.REPORT_MEASURE_UNIT);
        return "view/report/reportStructure/view";
    }

    /**
     * 查看版本页面
     *
     * @param versionId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String viewVer(Model model, Long versionId) {
        ReportStructureVer reportStructureVer = reportStructureVerService.get(versionId);

        model.addAttribute("bean", reportStructureVer);
        return "view/report/reportStructure/viewVer";
    }

    /*
       * 报表版本复制
       * */
    @RequestMapping
    public String copyVer(Model model, Long versionId) {
        //数据库中存在年份
        String name = reportStructureVerService.get(versionId).getName();
        model.addAttribute("sourceName", name);
        return "view/report/reportStructure/copy";
    }

    /**
     * 保存复制年份的数据
     * .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void copySave(HttpServletRequest request, @ModelAttribute("bean") ReportStructure entity, HttpServletResponse response) throws Exception {
        try {
            //库存版本
            String sourceVer = request.getParameter("ver");
            //新版本
            String desVer = request.getParameter("desVer");
            //新版本保存
            ReportStructureVer reportStructureVer = new ReportStructureVer();
            reportStructureVer.setName(desVer);
            reportStructureVer.setIsValid(false);
            reportStructureVerService.save(reportStructureVer);

            List<ReportStructure> list = reportStructureService.findByQuery("from ReportStructure where parent is null and version.name=?", sourceVer);
            for (ReportStructure source : list) {
                ReportStructure target = new ReportStructure();
                ReflectionUtils.copyBean(source, target, new String[]{
                        "code",
                        "name",
                        "isSumAccu",
                        "measureUnit",
                        "reportDeptDefine",
                        "treeId"
                });
                //将内容放入新版本
                target.setVersion(reportStructureVer);
                reportStructureService.save(target);
                updateChildren(target);
                copyChildren(source, target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "复制完成");
    }


    //复制-递归算法
    private void copyChildren(ReportStructure sourceParent, ReportStructure desParent) throws Exception {
        Set<ReportStructure> reportStructureSet = sourceParent.getReportStructures();
        for (ReportStructure source : reportStructureSet) {
            ReportStructure target = new ReportStructure();
            ReflectionUtils.copyBean(source, target, new String[]{
                    "code",
                    "name",
                    "isSumAccu",
                    "measureUnit",
                    "reportDeptDefine",
                    "treeId"
            });
            target.setVersion(desParent.getVersion());
            if (source.getParent() != null) {
                target.setParent(desParent);
            }
            reportStructureService.save(target);
            if (source.getReportStructures().size() > 0) {
                copyChildren(source, target);
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ReportStructure entity, HttpServletRequest request) throws Exception {
        try {
            ReportStructure target;
            if (entity.getId() != null) {
                target = reportStructureService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "isSumAccu",
                        "measureUnit",
                        "reportDeptDefine"
                });

            } else {
                target = entity;
            }
            reportStructureService.save(target);
            updateChildren(target);
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
    public void saveVer(HttpServletResponse response, @ModelAttribute("bean") ReportStructureVer entity, HttpServletRequest request) throws Exception {
        try {
            ReportStructureVer target;
            if (entity.getId() != null) {
                target = reportStructureVerService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name"
                });

            } else {
                target = entity;
            }
            target.setIsValid(false);
            reportStructureVerService.save(target);
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
        reportStructureService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /*
    * 是否有效
    * */
    @RequestMapping
    public void isValid(HttpServletResponse response, Long versionId) {
        List<ReportStructureVer> reportStructureVerList = reportStructureVerService.findAll();
        for (ReportStructureVer ver : reportStructureVerList) {
            if (versionId.equals(ver.getId())) {
                ver.setIsValid(true);
                reportStructureVerService.save(ver);
            } else {
                ver.setIsValid(false);
                reportStructureVerService.save(ver);
            }
        }
        sendSuccessJSON(response, "设置成功");
    }

    /**
     * 删除版本操作
     *
     * @param response  .
     * @param versionId .
     * @throws Exception .
     */
    @RequestMapping
    public void deleteVer(HttpServletResponse response, Long versionId) throws Exception {
        ReportStructureVer reportStructureVer = reportStructureVerService.get(versionId);
        Set<ReportStructure> reportStructures = reportStructureVer.getReportStructures();
        if (!reportStructureVer.getIsValid()) {
            if (reportStructures.size() > 0) {
                for (ReportStructure reportStructure : reportStructures) {
                    deleteAll(reportStructure);
                    reportStructureService.delete(reportStructure);
                }
            }
            reportStructureVerService.delete(versionId);
            sendSuccessJSON(response, "删除成功");
        } else {
            sendFailureJSON(response, "版本处于有效状态，不能被删除;请另行设置有效版本后，进行删除");
        }

    }
    /*
    * 由父节点改变子节点部门名称
    * */

    private void updateChildren(ReportStructure reportStructure) {
        Set<ReportStructure> reportStructures = reportStructure.getReportStructures();
        if (reportStructures.size() > 0) {
            for (ReportStructure reportStructureChild : reportStructures) {
                reportStructureChild.setReportDeptDefine(reportStructure.getReportDeptDefine());
                reportStructureService.save(reportStructureChild);
                updateChildren(reportStructureChild);
            }
        }
    }

    /*
    *递归删除版本下面节点
    * */
    private void deleteAll(ReportStructure reportStructure) {
        Set<ReportStructure> reportStructures = reportStructure.getReportStructures();
        if (reportStructures.size() == 0) {
            reportStructureService.delete(reportStructure);
        }
        if (reportStructures.size() > 0) {
            for (ReportStructure rs : reportStructures) {
                deleteAll(rs);
                reportStructureService.delete(rs);
            }
        }
    }
}