package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.daoservice.SysCodeService;
import com.justonetech.system.domain.SysCode;
import com.justonetech.system.domain.SysCodeDetail;
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

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class SysCodeController extends BaseCRUDActionController<SysCode> {
    private Logger logger = LoggerFactory.getLogger(SysCodeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeService sysCodeService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/system/sysCode/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_CODE_EDIT));

        model.addAttribute("clazz", SysCode.class.getName());
        model.addAttribute("clazzDetail", SysCodeDetail.class.getName());
        return "view/system/sysCode/tree";
    }

    /**
     * 获取树数据
     *
     * @param type  .
     * @param id    .
     * @param icon  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("系统代码树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from SysCode where parent.id is null order by treeId asc";
            List<SysCode> nodeList = sysCodeService.findByQuery(hql);
            for (SysCode data : nodeList) {
                boolean isLeaf = data.getSysCodeDetails().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(isLeaf);
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from SysCodeDetail where sysCode.id=" + id + " order by treeId asc";
            List<SysCodeDetail> nodeList = sysCodeDetailService.findByQuery(hql);
            for (SysCodeDetail data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("2");
                treeNode.setType("detail");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

    @RequestMapping
    public String treeDataForSelect(String code, String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));
        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("系统代码树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from SysCode where parent.id is null and code='" + code + "' order by treeId asc";
            List<SysCode> nodeList = sysCodeService.findByQuery(hql);
            for (SysCode data : nodeList) {
                boolean isLeaf = data.getSysCodeDetails().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(isLeaf);
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from SysCodeDetail where sysCode.id=" + id + " order by treeId asc";
            List<SysCodeDetail> nodeList = sysCodeDetailService.findByQuery(hql);
            for (SysCodeDetail data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("2");
                treeNode.setType("detail");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
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
        SysCode sysCode = new SysCode();

        //如需增加其他默认值请在此添加

        model.addAttribute("bean", sysCode);

        return "view/system/sysCode/input";
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
        SysCode sysCode = sysCodeService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sysCode);

        return "view/system/sysCode/input";
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
        SysCode sysCode = sysCodeService.get(id);

        model.addAttribute("bean", sysCode);
        return "view/system/sysCode/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @return .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysCode entity) throws Exception {
        try {
            SysCode target;
            if (entity.getId() != null) {
                target = sysCodeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "isReserved",
                        "description"
                });

            } else {
                target = entity;
            }
            sysCodeService.save(target);

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
        sysCodeService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}