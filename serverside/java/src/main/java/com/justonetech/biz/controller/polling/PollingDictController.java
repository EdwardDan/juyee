package com.justonetech.biz.controller.polling;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.PollingDictService;
import com.justonetech.biz.domain.PollingDict;
import com.justonetech.biz.utils.Constants;
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


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class PollingDictController extends BaseCRUDActionController<PollingDict> {
    private Logger logger = LoggerFactory.getLogger(PollingDictController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private PollingDictService pollingDictService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/polling/pollingDict/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_PROBLEM_EDIT));
        model.addAttribute("clazz", PollingDict.class.getName());

        return "view/polling/pollingDict/tree";
    }

    /**
     * 获取树数据
     *
     * @param model .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("巡查字典树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from PollingDict where parent.id is null order by treeId asc";
            List<PollingDict> nodeList = pollingDictService.findByQuery(hql);
            for (PollingDict data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from PollingDict where parent.id=" + id + " order by treeId asc";
            List<PollingDict> nodeList = pollingDictService.findByQuery(hql);
            for (PollingDict data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
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
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/polling/pollingDict/grid";
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
            String hql = "from PollingDict order by treeId asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = pollingDictService.findByPage(pageModel, query);
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
     * 新增录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String add(Model model, Long parentId, Integer level) {
        PollingDict pollingDict = new PollingDict();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            pollingDict.setParent(pollingDictService.get(parentId));
        }

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", pollingDict);
        model.addAttribute("level", level);

        return "view/polling/pollingDict/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id, Integer level) {
        PollingDict pollingDict = pollingDictService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", pollingDict);
        model.addAttribute("level", level);

        return "view/polling/pollingDict/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id, Integer level) {
        PollingDict pollingDict = pollingDictService.get(id);

        model.addAttribute("bean", pollingDict);
        model.addAttribute("level", level);
        return "view/polling/pollingDict/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") PollingDict entity, HttpServletRequest request) throws Exception {
        try {
            PollingDict target;
            if (entity.getId() != null) {
                target = pollingDictService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "refRule",
                        "name",
                        "reformType",
                        "registerType",
                        "safeType",
//                        "isLeaf",
//                        "treeId",
                        "isValid",
                        "orderNo",
                        "description",
//                        "createTime",
//                        "updateTime",
//                        "updateUser",
//                        "createUser"
                });

            } else {
                target = entity;
            }
            pollingDictService.save(target);

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
        pollingDictService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}