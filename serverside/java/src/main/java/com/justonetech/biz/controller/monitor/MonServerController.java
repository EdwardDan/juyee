package com.justonetech.biz.controller.monitor;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.MonCameraService;
import com.justonetech.biz.daoservice.MonServerService;
import com.justonetech.biz.domain.MonCamera;
import com.justonetech.biz.domain.MonServer;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
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
import java.util.List;


/**
 * note:视频服务器
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class MonServerController extends BaseCRUDActionController<MonServer> {
    private Logger logger = LoggerFactory.getLogger(MonServerController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private MonServerService monServerService;

    @Autowired
    private MonCameraService monCameraService;

    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/monitor/monServer/init";
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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.MON_SERVER_EDIT));
        //上下移动使用
        model.addAttribute("clazz", MonServer.class.getName());
        model.addAttribute("clazzCamera", MonCamera.class.getName());
        return "view/monitor/monServer/tree";
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
            treeBranch.addTreeNode(treeBranch.getRootNode("视频管理"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from MonServer order by id asc";
            List<MonServer> nodeList = monServerService.findByQuery(hql);
            for (MonServer data : nodeList) {
                boolean isLeaf = data.getMonCameras().size() == 0;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(isLeaf);
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from MonCamera where monServer.id=" + id + " order by id asc";
            List<MonCamera> nodeList = monCameraService.findByQuery(hql);
            for (MonCamera data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getName());
                treeNode.setIsLeaf(Boolean.TRUE);
                treeNode.setIcon("2");
                treeNode.setType("camera");
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
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.MON_SERVER_EDIT));

        return "view/monitor/monServer/grid";
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
            String hql = "from MonServer order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = monServerService.findByPage(pageModel, query);

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
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        MonServer monServer = new MonServer();
        model.addAttribute("monServerType", Constants.MON_SERVER_TYPE); //视频服务器类型
        model.addAttribute("monConnectType", Constants.MON_CONNECT_TYPE); //连接类型

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", monServer);

        return "view/monitor/monServer/input";
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
        MonServer monServer = monServerService.get(id);
        model.addAttribute("monServerType", Constants.MON_SERVER_TYPE); //视频服务器类型
        model.addAttribute("monConnectType", Constants.MON_CONNECT_TYPE); //连接类型
        //处理其他业务逻辑
        model.addAttribute("bean", monServer);

        return "view/monitor/monServer/input";
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
        MonServer monServer = monServerService.get(id);
        model.addAttribute("monServerType", Constants.MON_SERVER_TYPE); //视频服务器类型
        model.addAttribute("monConnectType", Constants.MON_CONNECT_TYPE); //连接类型
        model.addAttribute("bean", monServer);
        return "view/monitor/monServer/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") MonServer entity, HttpServletRequest request) throws Exception {
        try {
            MonServer target;
            if (entity.getId() != null) {
                target = monServerService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "serverName",
                        "ip",
                        "port",
                        "proxyIp",
                        "connectType",
                        "serverType",
                        "proxyName",
                        "loginName",
                        "password",
                        "description"
                });

            } else {
                target = entity;
            }
            monServerService.save(target);

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
        monServerService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}