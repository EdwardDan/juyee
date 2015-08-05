package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaWorkWatchService;
import com.justonetech.biz.domain.OaWorkWatch;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaWorkWatchStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.domain.SysUser;
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


/**
 * note:工作督办
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkWatchController extends BaseCRUDActionController<OaWorkWatch> {
    private Logger logger = LoggerFactory.getLogger(OaWorkWatchController.class);

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
    private OaWorkWatchService oaWorkWatchService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        setStatus(model);
        return "view/oa/oaWorkWatch/grid";
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
            String hql = "from OaWorkWatch order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaWorkWatchService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    public void setStatus(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_EDIT));
        model.addAttribute("canEdit_ZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_ZR));
        model.addAttribute("canEdit_KZ", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_KZ));
        model.addAttribute("canEdit_B", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_B));

        model.addAttribute("STATUS_EDIT", OaWorkWatchStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_ZR_SH", OaWorkWatchStatus.STATUS_ZR_SH.getCode());
        model.addAttribute("STATUS_BACK", OaWorkWatchStatus.STATUS_BACK.getCode());
        model.addAttribute("STATUS_INFO", OaWorkWatchStatus.STATUS_INFO.getCode());
        model.addAttribute("STATUS_B_CHECK", OaWorkWatchStatus.STATUS_B_CHECK.getCode());
        model.addAttribute("STATUS_CHECK_BACK", OaWorkWatchStatus.STATUS_CHECK_BACK.getCode());
        model.addAttribute("STATUS_CHECK_PASS", OaWorkWatchStatus.STATUS_CHECK_PASS.getCode());
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaWorkWatch oaWorkWatch = new OaWorkWatch();
        setStatus(model);
        SysUser sysUser = sysUserManager.getSysUser();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaWorkWatch);

        return "view/oa/oaWorkWatch/input";
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
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        setStatus(model);
        //处理其他业务逻辑
        model.addAttribute("bean", oaWorkWatch);

        return "view/oa/oaWorkWatch/input";
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
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        setStatus(model);
        model.addAttribute("bean", oaWorkWatch);
        return "view/oa/oaWorkWatch/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaWorkWatch entity, HttpServletRequest request) throws Exception {
        try {
            OaWorkWatch target;
            if (entity.getId() != null) {
                target = oaWorkWatchService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportDept",
                        "reportUser",
                        "reportPerson",
                        "beginDate",
                        "endDate",
                        "documentId",
                        "status",
                        "zrOpinion",
                        "zrAuditTime",
                        "zrAuditUser",
                        "kzOpinion",
                        "kzAuditTime",
                        "kzAuditUser",
                        "bgsOpinion",
                        "bgsAuditTime",
                        "bgsAuditUser"
                });

            } else {
                target = entity;
            }
            oaWorkWatchService.save(target);

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
        oaWorkWatchService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}