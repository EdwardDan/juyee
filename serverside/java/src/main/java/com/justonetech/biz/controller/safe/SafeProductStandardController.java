package com.justonetech.biz.controller.safe;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SafeProductStandardService;
import com.justonetech.biz.domain.SafeProductStandard;
import com.justonetech.biz.manager.SafeProductStandardManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
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
 * note:安全生产标准
 * author: guoqiong
 * modify date: 2014-6-9
 */
@Controller
public class SafeProductStandardController extends BaseCRUDActionController<SafeProductStandard> {
    private Logger logger = LoggerFactory.getLogger(SafeProductStandardController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SafeProductStandardService safeProductStandardService;

    @Autowired
    private SafeProductStandardManager safeProductStandardManager;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/safe/safeProductStandard/init";
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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SAFE_PRODUCT_STANDARD_EDIT));
        //上下移动使用
        model.addAttribute("clazz", SafeProductStandard.class.getName());

        return "view/safe/safeProductStandard/tree";
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
            treeBranch.addTreeNode(treeBranch.getRootNode("安全生产标准树"));
        } else if (StringUtils.equals(id, "root")) {//年份
            String[] nodeList = safeProductStandardManager.getYears();
            for (String data : nodeList) {
                List<SafeProductStandard> standardList = safeProductStandardManager.getSafeProductStandards(Integer.parseInt(data));
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(data);
                treeNode.setName(data + "年");
                treeNode.setIsLeaf(standardList.size() == 0);
                treeNode.setIcon("1");
                treeNode.setType("dataParent");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "dataParent")) {
            List<SafeProductStandard> nodeList = safeProductStandardManager.getSafeProductStandards(Integer.parseInt(id));
            for (SafeProductStandard data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getItemName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from SafeProductStandard where parent.id=" + id + " order by treeId asc";
            List<SafeProductStandard> nodeList = safeProductStandardService.findByQuery(hql);
            for (SafeProductStandard data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getItemName());
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
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/safe/safeProductStandard/grid";
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
            String hql = "from SafeProductStandard order by itemNo asc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = safeProductStandardService.findByPage(pageModel, query);

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
     * @param model    .
     * @param parentId .
     * @param year     .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String parentId, String year) {
        SafeProductStandard safeProductStandard = new SafeProductStandard();

        //如需增加其他默认值请在此添加
        if (!StringHelper.isEmpty(parentId)) {
            SafeProductStandard parent = safeProductStandardService.get(Long.valueOf(parentId));
            safeProductStandard.setParent(parent);
            safeProductStandard.setYear(parent.getYear());
        }
        if (!StringHelper.isEmpty(year)) {
            safeProductStandard.setYear(Integer.valueOf(year));
        }
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(safeProductStandard.getYear()));
        model.addAttribute("yearSelectOption", yearSelectOptions);
        model.addAttribute("bean", safeProductStandard);

        return "view/safe/safeProductStandard/input";
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
        SafeProductStandard safeProductStandard = safeProductStandardService.get(id);

        //处理其他业务逻辑
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(safeProductStandard.getYear()));
        model.addAttribute("yearSelectOption", yearSelectOptions);
        model.addAttribute("bean", safeProductStandard);

        return "view/safe/safeProductStandard/input";
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
        SafeProductStandard safeProductStandard = safeProductStandardService.get(id);

        model.addAttribute("bean", safeProductStandard);

        return "view/safe/safeProductStandard/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SafeProductStandard entity) throws Exception {
        try {
            SafeProductStandard target;
            if (entity.getId() != null) {
                target = safeProductStandardService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "year",
                        "itemNo",
                        "itemName",
                        "score",
                        "isLeaf",
                });

            } else {
                target = entity;
            }
            safeProductStandardService.save(target);

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
        SafeProductStandard safeProductStandard = safeProductStandardService.get(id);
        Set<SafeProductStandard> safeProductStandards = safeProductStandard.getSafeProductStandards();
        if (safeProductStandards != null) {
            for (SafeProductStandard productStandard : safeProductStandards) {
                safeProductStandardService.delete(productStandard);
            }
        }
        safeProductStandardService.delete(safeProductStandard);

        sendSuccessJSON(response, "删除成功");
    }

}