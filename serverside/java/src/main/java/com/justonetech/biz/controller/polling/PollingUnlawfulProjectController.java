package com.justonetech.biz.controller.polling;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.PollingUnlawfulProjectService;
import com.justonetech.biz.domain.PollingUnlawfulProject;
import com.justonetech.biz.domain.ProjectExtend;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * note:非法工程信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class PollingUnlawfulProjectController extends BaseCRUDActionController<PollingUnlawfulProject> {
    private Logger logger = LoggerFactory.getLogger(PollingUnlawfulProjectController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private PollingUnlawfulProjectService pollingUnlawfulProjectService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.POLLING_UNLAWFUL_PROJECT_EDIT));

        return "view/polling/pollingUnlawfulProject/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from PollingUnlawfulProject order by createTime desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = pollingUnlawfulProjectService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object docId = bean.get("projectDoc.id");
                if (docId != null && StringHelper.isNotEmpty((String) docId)) {
                    bean.put("projectDoc.id", documentManager.getDownloadButton(docDocumentService.get(JspHelper.getLong(docId))));
                }
            }
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
        PollingUnlawfulProject pollingUnlawfulProject = new PollingUnlawfulProject();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", pollingUnlawfulProject);

        return "view/polling/pollingUnlawfulProject/input";
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
        PollingUnlawfulProject pollingUnlawfulProject = pollingUnlawfulProjectService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", pollingUnlawfulProject);

        return "view/polling/pollingUnlawfulProject/input";
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
        PollingUnlawfulProject pollingUnlawfulProject = pollingUnlawfulProjectService.get(id);

        model.addAttribute("bean", pollingUnlawfulProject);
        return "view/polling/pollingUnlawfulProject/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") PollingUnlawfulProject entity, HttpServletRequest request) throws Exception {
        try {
            PollingUnlawfulProject target;
            if (entity.getId() != null) {
                target = pollingUnlawfulProjectService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "projectName",
                        "buildAddress",
                        "buildUnit",
                        "buildLinkman",
                        "buildLinkPhone",
                        "sgUnit",
                        "sgUnitLinkman",
                        "sgUnitLinkPhone",
                        "currentLongitude",
                        "currentLatitude",
                        "mainPerson",
                        "groupPerson",
                        "isLx",
                        "isTdqz",
                        "isGhxk",
                        "isSgxk",
                        "questionDesc",
//                        "dealResult"
//                        "dealUser",
//                        "dealTime",
//                        "padTime",
//                        "padImei"
                });
            } else {
                target = entity;
            }
//            target.setStatus(sysCodeManager.getCodeDetailByCode(Constants.POLLING_UNLAWFUL_PROJECT_STATUS, Constants.POLLING_UNLAWFUL_PROJECT_STATUS_PROCESSED));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            target.setDealTime(timestamp);
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                target.setDealUser(loginUser.getLoginName());
            }
            pollingUnlawfulProjectService.save(target);

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
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveMap(HttpServletResponse response, Double x, Double y, Long id) throws Exception {
        try {
            PollingUnlawfulProject pollingUnlawfulProject = pollingUnlawfulProjectService.get(id);
            pollingUnlawfulProject.setPosX(x);
            pollingUnlawfulProject.setPosY(y);
            pollingUnlawfulProjectService.save(pollingUnlawfulProject);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 属地保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveBelongArea(HttpServletResponse response, @ModelAttribute("bean") PollingUnlawfulProject entity) throws Exception {
        try {
            PollingUnlawfulProject target;
            if (entity.getId() != null) {
                target = pollingUnlawfulProjectService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "belongArea"
                });
            } else {
                target = entity;
            }
            pollingUnlawfulProjectService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String belongArea(Model model, Long id) {
        PollingUnlawfulProject pollingUnlawfulProject = pollingUnlawfulProjectService.get(id);
        model.addAttribute("ProBelongArea", Constants.EXCEL_JDTASK_POSITION);
        model.addAttribute("id", id);

        //处理其他业务逻辑
        model.addAttribute("bean", null != pollingUnlawfulProject ? pollingUnlawfulProject : new ProjectExtend());

        return "view/polling/pollingUnlawfulProject/belongArea";
    }

    /**
     * 地图页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String map(Model model, Long id, String level) {
        model.addAttribute("level", !StringHelper.isEmpty(level) ? level : "14");
        PollingUnlawfulProject pro = pollingUnlawfulProjectService.get(id);
        String pos = "";
        String x = "";
        String y = "";
        if (null != pro.getPosX()) {
            x = String.valueOf(pro.getPosX());
        }
        if (null != pro.getPosY()) {
            y = String.valueOf(pro.getPosY());
        }
        pos = "{'name':'" + pro.getProjectName() + "','address':'" + pro.getBuildAddress() + "','x':'" + x + "','y':'" + y + "'}";

        if (pro.getPosX() == null && pro.getPosY() == null) {
            model.addAttribute("queryValue", 3);
        } else if (pro.getPosX() != null && pro.getPosY() != null) {
            model.addAttribute("queryValue", 2);
        } else {
            model.addAttribute("queryValue", 1);
        }
        model.addAttribute("pos", pos);

        model.addAttribute("name", pro.getProjectName());
        model.addAttribute("address", pro.getBuildAddress());
        model.addAttribute("id",id);

        return "view/polling/pollingUnlawfulProject/map";
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
        pollingUnlawfulProjectService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }
}