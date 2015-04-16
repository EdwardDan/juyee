package com.justonetech.biz.controller.syn;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.manager.*;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
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
import java.util.Map;


/**
 * note:Excel监督单位工程
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ExcelJdDwgcController extends BaseCRUDActionController<ExcelJdDwgc> {
    private Logger logger = LoggerFactory.getLogger(ExcelJdDwgcController.class);

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
    private JdReportManager jdReportManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.SYN_EXCEL_JD_TASKS_EDIT));
//      model.addAttribute("canEdit",true);

        return "view/syn/excelJdDwgc/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ExcelJdDwgc order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = excelJdDwgcService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                if (null != id){
                    ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(JspHelper.getLong(id));
                    String jdTaskCode = excelJdDwgc.getJdTaskCode();
                    String findHql = "from ExcelJdTasks where jdTaskCode= '" +jdTaskCode+"'";
                    List<ExcelJdTasks> excelJdTasksList = excelJdTasksService.findByQuery(findHql);
                    if(excelJdTasksList.size()>0){
                        ExcelJdTasks data = excelJdTasksList.iterator().next();
                        bean.put("projectName",data.getProjectName());
                        bean.put("projectAdd",data.getProjectAdd());
                        bean.put("jdDateTime",data.getJdDatetime());
                    }
                }
            }

            //输出显示
            String json = GridJq.toJSON(list, pageModel);
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
        ExcelJdDwgc excelJdDwgc = new ExcelJdDwgc();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", excelJdDwgc);

        return "view/syn/excelJdDwgc/input";
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
        ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", excelJdDwgc);

        return "view/syn/excelJdDwgc/input";
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
        ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(id);
        String jdTaskCode = excelJdDwgc.getJdTaskCode();
        String findHql = "from ExcelJdTasks where jdTaskCode= '" +jdTaskCode+"'";
        List<ExcelJdTasks> excelJdTasksList = excelJdTasksService.findByQuery(findHql);
        if(excelJdTasksList.size()>0){
            ExcelJdTasks excelJdTasks = excelJdTasksList.iterator().next();
            model.addAttribute("data",excelJdTasks);
        }

        model.addAttribute("bean", excelJdDwgc);
        return "view/syn/excelJdDwgc/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ExcelJdDwgc entity, HttpServletRequest request) throws Exception {
        try {
            ExcelJdDwgc target;
            if (entity.getId() != null) {
                target = excelJdDwgcService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "jdTaskCode",
                        "dwgcCode",
                        "customCode",
                        "dwgcName",
                        "projectType",
                        "structType",
                        "dwgcArea",
                        "dwgcMoney",
                        "upCs",
                        "downCs",
                        "ts",
                        "proSchedule",
                        "changetime",
                        "synDatetime"
                });

            } else {
                target = entity;
            }
            excelJdDwgcService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        excelJdDwgcService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取树数据
     *
     * @param jdTaskCode 。
     * @param id       。
     * @param icon     。
     * @param model    。
     * @return 。
     */
    @RequestMapping
    public String treeDataForSelect(String jdTaskCode, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringHelper.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringHelper.equals(id, "root")) {
            List<ExcelJdDwgc> excelJdDwgc = jdReportManager.getJdTasksData(jdTaskCode);
            if (excelJdDwgc != null) {
                for (ExcelJdDwgc data : excelJdDwgc) {
                    ZTreeNode treeNode = new ZTreeNode();
                    treeNode.setId(String.valueOf(data.getId()));
                    treeNode.setName(data.getDwgcName());
                    treeNode.setIsLeaf(true);
                    treeNode.setIcon("1");
                    treeNode.setType("data");
                    treeBranch.addTreeNode(treeNode);
                }
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }
}