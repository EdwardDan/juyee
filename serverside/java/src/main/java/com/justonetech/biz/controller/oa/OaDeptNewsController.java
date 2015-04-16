package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaDeptNewsService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaDeptNews;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.enums.OaDeptNewsStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * note:各科室新闻
 * author: 张超凡
 * create date:
 * modify date:
 */
@Controller
public class OaDeptNewsController extends BaseCRUDActionController<OaDeptNews> {
    private Logger logger = LoggerFactory.getLogger(OaDeptNewsController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaDeptNewsService oaDeptNewsService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_DEPT_NEWS_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_DEPT_NEWS_AUDIT));
        model.addAttribute("currentUser",sysUserManager.getSysUser().getLoginName());
        pushStaticValueToPage(model);
        return "view/oa/oaDeptNews/grid";
    }

    /**
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {

        model.addAttribute("STATUS_EDIT", OaDeptNewsStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaDeptNewsStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BACK", OaDeptNewsStatus.STATUS_BACK.getCode()); //退回修改
        model.addAttribute("STATUS_PASS", OaDeptNewsStatus.STATUS_PASS.getCode()); //审核通过
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
            String hql = "from OaDeptNews order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaDeptNewsService.findByPage(pageModel, queryTranslate.toString());
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                Object id = bean.get("id");
                if (null != id) {
                    OaDeptNews oaDeptNews = oaDeptNewsService.get(JspHelper.getLong(id));
                    bean.put("docButton", documentManager.getDownloadButton(oaDeptNews.getDocument()));
                }
            }
            //输出显示
            String json = GridJq.toJSON(mapList, pageModel);
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
        OaDeptNews oaDeptNews = new OaDeptNews();
        //默认当前登录用户和部门
        SysUser sysUser = sysUserManager.getSysUser();
        String reportPersonName = sysUser.getDisplayName();
        String reportDeptName = sysUser.getPerson().getDeptName();
        oaDeptNews.setReportPerson(reportPersonName);
        oaDeptNews.setReportDept(reportDeptName);
        /* 如需增加其他默认值请在此添加 */
        model.addAttribute("bean", oaDeptNews);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaDeptNews.class.getSimpleName(), oaDeptNews.getDocument(), null, null));
        pushStaticValueToPage(model);
        return "view/oa/oaDeptNews/input";
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
        OaDeptNews oaDeptNews = oaDeptNewsService.get(id);
        pushStaticValueToPage(model);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaDeptNews.class.getSimpleName(), oaDeptNews.getDocument(), null, null));
        model.addAttribute("bean", oaDeptNews);
        return "view/oa/oaDeptNews/input";
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
        OaDeptNews oaDeptNews = oaDeptNewsService.get(id);
        pushStaticValueToPage(model);
        oaDeptNews.setVisitTimes(JspHelper.getLong(oaDeptNews.getVisitTimes() + 1));
        oaDeptNewsService.save(oaDeptNews);
        model.addAttribute("docButton", documentManager.getDownloadButton(oaDeptNews.getDocument()));
        model.addAttribute("bean", oaDeptNews);
        return "view/oa/oaDeptNews/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaDeptNews entity, HttpServletRequest request) throws Exception {
        try {
            OaDeptNews target;
            if (entity.getId() != null) {
                target = oaDeptNewsService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "reportPerson",
                        "reportDept",
                        "content",
                        "reportDate",
                        "status",
                        "officeOpinion",
                        "officeAuditTime",
                        "officeAuditUser"

                });

            } else {
                target = entity;
            }
            target.setVisitTimes(0L);
            target.setReportDate(new Date(System.currentTimeMillis()));
            if (target.getStatus() == OaDeptNewsStatus.STATUS_PASS.getCode() || target.getStatus() == OaDeptNewsStatus.STATUS_BACK.getCode()) {
                target.setOfficeAuditTime(new Timestamp(System.currentTimeMillis()));
                target.setOfficeAuditUser(sysUserManager.getSysUser().getDisplayName());
            }
            //处理附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }


            oaDeptNewsService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /*
    审核
    * */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaDeptNews oaDeptNews = oaDeptNewsService.get(id);
        oaDeptNews.setOfficeAuditTime(new Timestamp(System.currentTimeMillis()));
        pushStaticValueToPage(model);
        model.addAttribute("docButton", documentManager.getDownloadButton(oaDeptNews.getDocument()));
        model.addAttribute("bean", oaDeptNews);
        return "view/oa/oaDeptNews/audit";


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
        OaDeptNews oaDeptNews = oaDeptNewsService.get(Long.valueOf(id));
        Long docId = oaDeptNews.getDocument() != null ? oaDeptNews.getDocument().getId() : null;
        oaDeptNewsService.delete(id);
        documentManager.removeAllDoc(docId, null);
        sendSuccessJSON(response, "删除成功");
    }

}