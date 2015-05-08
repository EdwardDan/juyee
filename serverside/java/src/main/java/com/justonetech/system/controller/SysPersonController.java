package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
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
import java.util.*;


/**
 * author: Chen Junping
 * revised : Stanley
 * create date: 2015-04-16
 * modify date: 2015-05-08
 */
@Controller
public class SysPersonController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(SysPersonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PERSON_EDIT));
//        model.addAttribute("canEditPro", sysUserManager.hasPrivilege(PrivilegeCode.JD_PERSON_SUBJECT_EDIT));
        return "view/system/sysPerson/grid";
    }

    /**
     * 根据给定单位的列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid2(Model model, Long deptId, String deptName, String originalUrl, String originalLocation) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptName);
        model.addAttribute("originalUrl", originalUrl);
        model.addAttribute("originalLocation", originalLocation);
        return grid(model);
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
    public void gridDataCustom(HttpServletRequest request, HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "select sp" +
                    " from SysPerson sp left join sp.sysPersonDepts spd " +
                    " left join spd.dept dept ";
            //增加自定义查询条件

            String unitName = request.getParameter("unitName");
            if (StringUtils.isNotEmpty(unitName)) {
                List<SysDept> sysDepts = sysDeptService.findByQuery("from SysDept where name like '%" + unitName + "%' and isTag=" + Constants.FLAG_TRUE);
                if (sysDepts.size() > 0) {
                    String unitHql = "(select id from SysDept where isTag=" + Constants.FLAG_FALSE + " and (";
                    List<String> likeHqls = new ArrayList<String>();
                    for (SysDept sysDept : sysDepts) {
                        likeHqls.add("dept.treeId like '" + sysDept.getTreeId() + "%'");
                    }
                    unitHql += StringUtils.join(likeHqls, " or ") + "))";
                    hql += " where dept.id in " + unitHql;
                } else {
                    hql += " where 1=2";
                }
            }
            hql += " order by dept.treeId asc,spd.orderNo asc,sp.name asc";

            //执行查询
            filters = filters.replaceAll("\"field\":\"(?!dept\\.name)", "\"field\":\"sp.");   //统一添加别名
            filters = filters.replaceAll("\"orderColumn\":\"company", "\"orderColumn\":\"dept");   //表头排序，单位排序有问题
            filters = filters.replaceAll("\"orderColumn\":\"(?!dept\\.name|\")", "\"orderColumn\":\"sp.");   //表头排序
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysPersonService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 根据给定单位获取列表数据
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
    public void gridDataCustom2(HttpServletRequest request, HttpServletResponse response, String filters, String columns, int page, int rows, Long deptId) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "select sp from SysPerson sp left join sp.sysPersonDepts spd left join spd.dept dept " +
                    " where dept.id = " + deptId.longValue() + " order by dept.treeId asc, spd.orderNo asc, sp.name asc ";
            //增加自定义查询条件
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
     * 新增录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String add(Model model) {
        SysPerson sysPerson = new SysPerson();
        model.addAttribute("bean", sysPerson);
        return "view/system/sysPerson/input";
    }

    /**
     * 给定某一部门新增录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String add2(Model model, Long deptId, String deptName) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptName);
        return add(model);
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
        SysPerson sysPerson = sysPersonService.get(id);
        model.addAttribute("bean", sysPerson);
        return "view/system/sysPerson/input";
    }

    /**
     * 给定某一部门修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify2(Model model, Long id, Long deptId, String deptName) {
        model.addAttribute("deptId", deptId);
        model.addAttribute("deptName", deptName);
        return modify(model, id);
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SysPerson sysPerson = sysPersonService.get(id);
        model.addAttribute("bean", sysPerson);
        return "view/system/sysPerson/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysPerson entity, HttpServletRequest request) throws Exception {
        try {
            SysPerson target;
            if (entity.getId() != null) {
                target = sysPersonService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "age",
                        "bornDate",
                        "bornPlace",
                        "card",
                        "code",
                        "email",
                        "faxTel",
                        "memo",
                        "mobile",
                        "msnCode",
                        "name",
                        "officeTel",
                        "qqCode",
                        "sex",
                        "workYear",
                        "isShowPersonOut",
                        "zipcode"
                });
            } else {
                target = entity;
            }
            String sysDeptId = request.getParameter("sysDeptId");
            target.setCategory(StringHelper.isEmpty(sysDeptId) ? null : sysDeptService.get(Long.valueOf(sysDeptId)).getCategory());
            sysPersonService.save(target);
            //所属部门
            Set<SysPersonDept> personDepts = target.getSysPersonDepts();
            if (personDepts != null) {
                for (SysPersonDept personDept : personDepts) {
                    sysPersonDeptService.delete(personDept);
                }
            }
            if (!StringHelper.isEmpty(sysDeptId)) {
                SysPersonDept personDept = new SysPersonDept();
                personDept.setPerson(target);
                personDept.setDept(sysDeptService.get(Long.valueOf(sysDeptId)));
                personDept.setIsValid(true);
                personDept.setOrderNo(JspHelper.getLong(request.getParameter("orderNo")));
                personDept.setPosition(request.getParameter("position"));
                sysPersonDeptService.save(personDept);
            }
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
        SysPerson person = sysPersonService.get(id);
        if (person.getSysUsers().size() > 0) {
            sendFailureJSON(response, "删除失败，已被用户引用！");
        } else {
            Set<SysPersonDept> personDepts = person.getSysPersonDepts();
            for (SysPersonDept personDept : personDepts) {
                sysPersonDeptService.delete(personDept);
            }
            sysPersonService.delete(id);
            sendSuccessJSON(response, "删除成功");
        }
    }

    /**
     * 人员选择树
     *
     * @param model 。
     */
    @RequestMapping
    public String treeDataForSelect(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //单位
            String hql = "from SysDept where parent.id is null order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "company") || StringUtils.equals(type, "dept")) {
            //单位/部门
            String hql = "from SysDept where parent.id=" + id + " order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }

            //人员
            List<SysPersonDept> personDeptList = sysPersonDeptService.findByQuery("from SysPersonDept where dept.id=" + id + " order by orderNo,person.name asc");
            for (SysPersonDept personDept : personDeptList) {
                SysPerson person = personDept.getPerson();
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(person.getId()));
                treeNode.setIsLeaf(true);
                treeNode.setName(person.getName());
                treeNode.setIcon("3");
                treeNode.setType("person");
                treeBranch.addTreeNode(treeNode);
            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

    /**
     * 司机选择树
     *
     * @param model 。
     */
    @RequestMapping
    public String treeDataForSelectDriver(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //单位
            String hql = "from SysDept where parent.id is null order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "company") || StringUtils.equals(type, "dept")) {
            //单位/部门
            String hql = "from SysDept where parent.id=" + id + " order by treeId asc";
            List<SysDept> nodeList = sysDeptService.findByQuery(hql);
            for (SysDept data : nodeList) {
                boolean isLeaf = data.getChildren().size() == 0;
                if (isLeaf) {
                    isLeaf = data.getSysPersonDepts().size() == 0;
                }
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                if (data.getIsTag() != null && data.getIsTag()) {
                    treeNode.setIcon("1");
                    treeNode.setType("company");
                } else {
                    treeNode.setIcon("2");
                    treeNode.setType("dept");
                }
                treeBranch.addTreeNode(treeNode);
            }

            //人员
            String position = "司机";
            List<SysPersonDept> personDeptList = sysPersonDeptService.findByQuery("from SysPersonDept where dept.id=" + id + " and position='" + position + "'order by orderNo,person.name asc");
            for (SysPersonDept personDept : personDeptList) {
                SysPerson person = personDept.getPerson();
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(person.getId()));
                treeNode.setIsLeaf(true);
                treeNode.setName(person.getName());
                treeNode.setIcon("3");
                treeNode.setType("person");
                treeBranch.addTreeNode(treeNode);
            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

    /**
     * 根据personId返回人员信息
     *
     * @param personId 。
     */
    @RequestMapping
    public String getPersonInfo(Model model, Long personId) {
        SysPerson sysPerson = sysPersonService.get(personId);
        SysDept sysDept = sysPerson.getDept();  //根据personId获取单位信息
        String personName = sysPerson.getName(); //人员姓名
        String personMobile = sysPerson.getMobile();  //人员手机
        String deptId = JspHelper.getString(sysDept.getId());  //单位id
        String deptName = sysDept.getName(); //单位名称
        Map<String, String> map = new HashMap<String, String>();
        map.put("personName", personName);
        map.put("personMobile", personMobile);
        map.put("deptId", deptId);
        map.put("deptName", deptName);
        String string = JSONObject.fromObject(map).toString();
        model.addAttribute("msg", string);
        return "common/msg";
    }
}