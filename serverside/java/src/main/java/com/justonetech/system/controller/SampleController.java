package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.system.daoservice.SampleService;
import com.justonetech.system.domain.Sample;
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
import java.util.List;

/**
 * User: Chen Junping
 * Date: 12-2-1
 */
@Controller
public class SampleController extends BaseCRUDActionController<Sample> {
    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SampleService sampleService;

    /**
     * 树+列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {
        return "view/system/sample/init";
    }

    /**
     * 树显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));

        return "view/system/sample/tree";
    }

    /**
     * 获取树数据
     *
     * @param model 。
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from Sample where parent.id is null order by treeId asc";
            List<Sample> nodeList = sampleService.findByQuery(hql);
            for (Sample data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from Sample where parent.id=" + id + " order by treeId asc";
            List<Sample> nodeList = sampleService.findByQuery(hql);
            for (Sample data : nodeList) {
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
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));

        return "view/system/sample/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response
     * @param filters
     * @param columns
     * @param page
     * @param rows
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from Sample order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            System.out.println("......queryTranslate.toString() = " + queryTranslate.toString());
            pageModel = sampleService.findByPage(pageModel, queryTranslate.toString());
//            List<Map> gridValue = GridJq.getGridValue(pageModel.getRows(), columns);
//            for(Map map:gridValue){
//                map.put("colName","custom");
//            }

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
    public String add(Model model, Long parentId) {
        Sample sample = new Sample();

        //如需增加其他默认值请在此添加
        if (parentId != null) {
            sample.setParent(sampleService.get(parentId));
        }

        model.addAttribute("bean", sample);

        return "view/system/sample/input";
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
        Sample sample = sampleService.get(id);

        //处理其他业务逻辑

        model.addAttribute("bean", sample);
        return "view/system/sample/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        Sample sample = sampleService.get(id);
        model.addAttribute("bean", sample);
        return "view/system/sample/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") Sample entity, HttpServletRequest request) throws Exception {
        try {
            Sample target;
            if (entity.getId() != null) {
                target = sampleService.get(entity.getId());
                String columns = "name,birthday,possession,age,registerTime,isMarried,description,sysDept,education";
                ReflectionUtils.copyBean(entity, target, columns.split(","));

            } else {
                target = entity;
            }
            sampleService.save(target);

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
        sampleService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }
}