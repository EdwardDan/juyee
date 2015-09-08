package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaPetitionService;
import com.justonetech.biz.domain.OaPetition;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
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
 * note:信访管理
 * author: Stanley
 * create date: 2015-06-18
 * modify date: 2015-06-19
 */
@Controller
public class OaPetitionController extends BaseCRUDActionController<OaPetition> {
    private Logger logger = LoggerFactory.getLogger(OaPetitionController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaPetitionService oaPetitionService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_PETITION_EDIT));
        return "view/oa/oaPetition/grid";
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
            String hql = "from OaPetition order by receiveDate desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaPetitionService.findByPage(pageModel, query);
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
        return modify(model, null);
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
        OaPetition oaPetition = id != null ? oaPetitionService.get(id) : new OaPetition();
        model.addAttribute("status", Constants.OA_PETITION_STATUS);
        model.addAttribute("source", Constants.OA_PETITION_SOURCE);
        model.addAttribute("type", Constants.OA_PETITION_TYPE);
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaPetition.class.getSimpleName(), oaPetition.getDoc(), sysUserManager.getSysUser().getId(), null, "Document"));
        model.addAttribute("bean", oaPetition);
        return "view/oa/oaPetition/input";
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
        model.addAttribute("downloadButtonDocument", documentManager.getDownloadButton(oaPetitionService.get(id).getDoc()));
        return modify(model, id).replace("input", "view");
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaPetition entity, HttpServletRequest request) throws Exception {
        try {
            OaPetition target;
            if (entity.getId() != null) {
                target = oaPetitionService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "person",
                        "tel",
                        "receiveDate",
                        "address",
                        "jbrName",
                        "endDate",
                        "content",
                        "dealResult",
                        "description"
                });
            } else {
                target = entity;
            }
            target.setStatus(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("status"))));
            target.setSource(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("source"))));
            target.setType(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("type"))));
            target.setStatusDesc(target.getStatus().getName());
            target.setSourceDesc(target.getSource().getName());
            target.setTypeDesc(target.getType().getName());
            if (StringHelper.isNotEmpty(request.getParameter("jbrId"))) {
                target.setJbrUser(sysUserService.get(JspHelper.getLong(request.getParameter("jbrId"))));
            }
            if (StringHelper.isNotEmpty(request.getParameter("docIdDocument"))) {
                target.setDoc(documentManager.getDocDocument(JspHelper.getLong(request.getParameter("docIdDocument"))));
                if (target.getDoc() != null) {
                    documentManager.updateDocumentByBizData(target.getDoc(), null, JspHelper.getString(target.getDoc().getName()));
                }
            }
            oaPetitionService.save(target);
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
        oaPetitionService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}