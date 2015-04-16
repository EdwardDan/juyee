package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaKnowledgeService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaKnowledge;
import com.justonetech.biz.manager.DocumentManager;
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
import java.sql.Timestamp;
import java.util.*;


/**
 * note:业务知识交流
 * author: 张超凡
 * create date:
 * modify 2014-4-21:
 */
@Controller
public class OaKnowledgeController extends BaseCRUDActionController<OaKnowledge> {
    private Logger logger = LoggerFactory.getLogger(OaKnowledgeController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaKnowledgeService oaKnowledgeService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限

        SysUser sysUser = sysUserManager.getSysUser();
        model.addAttribute("currentUserName", sysUser.getLoginName());//current user
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_KNOWLEDGE_DELETE));//强制删除权限

        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_KNOWLEDGE_EDIT));
        return "view/oa/oaKnowledge/grid";
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
            String hql = "from OaKnowledge ok where ok.refer.id is  null order by createTime desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaKnowledgeService.findByPage(pageModel, queryTranslate.toString());
            //处理附件
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                Object id = bean.get("id");
                if (null != id) {
                    OaKnowledge oaKnowledge = oaKnowledgeService.get(JspHelper.getLong(id));
                    bean.put("docButton", documentManager.getDownloadButton(oaKnowledge.getDocument()));
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
        OaKnowledge oaKnowledge = new OaKnowledge();
        //获取当前登录用户信息
        SysUser sysUser = sysUserManager.getSysUser();
        String deptName = sysUser.getPerson().getDeptName();
        oaKnowledge.setReportPerson(sysUser.getDisplayName());
        oaKnowledge.setReportDept(deptName);

        oaKnowledge.setReportDate(new Timestamp(System.currentTimeMillis()));

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaKnowledge.class.getSimpleName(), oaKnowledge.getDocument(), sysUser.getId(), null));
        model.addAttribute("bean", oaKnowledge);
        return "view/oa/oaKnowledge/input";
    }

    //修改主题页面
    @RequestMapping
    public String modify(Model model, Long id) {
        OaKnowledge oaKnowledge = oaKnowledgeService.get(id);
        //获取当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        String deptName = sysUser.getPerson().getDeptName();
        oaKnowledge.setReportPerson(sysUser.getDisplayName());
        oaKnowledge.setReportDept(deptName);

        //传入前台需要值
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaKnowledge.class.getSimpleName(), oaKnowledge.getDocument(), sysUser.getId(), null));
        model.addAttribute("bean", oaKnowledge);

        return "view/oa/oaKnowledge/input";
    }


    //回复信息
    @RequestMapping
    public String reply(Model model, Long id) {
        OaKnowledge oaKnowledge = new OaKnowledge();
        SysUser sysUser = sysUserManager.getSysUser();
        String deptName = sysUser.getPerson().getDeptName();
        oaKnowledge.setReportPerson(sysUser.getDisplayName());
        oaKnowledge.setReportDept(deptName);
        oaKnowledge.setReportDate(new Timestamp(System.currentTimeMillis()));
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaKnowledge.class.getSimpleName(), oaKnowledge.getDocument(), oaKnowledge.getId(), null));
        model.addAttribute("refId", id);
        model.addAttribute("bean", oaKnowledge);

        return "view/oa/oaKnowledge/reply";
    }

    /*
     *修改回复内容
     */
    @RequestMapping
    public String replyModify(Model model, Long id) {
        OaKnowledge oaKnowledge = oaKnowledgeService.get(id);

        SysUser sysUser = sysUserManager.getSysUser();
        String deptName = sysUser.getPerson().getDeptName();
        oaKnowledge.setReportPerson(sysUser.getDisplayName());
        oaKnowledge.setReportDept(deptName);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaKnowledge.class.getSimpleName(), oaKnowledge.getDocument(), sysUser.getId(), null));
        model.addAttribute("bean", oaKnowledge);

        return "view/oa/oaKnowledge/reply";
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
        SysUser sysUser = sysUserManager.getSysUser();
        model.addAttribute("currentUserName", sysUser.getLoginName());//current user

        //获取发题人
        OaKnowledge oaKnowledgeRep = oaKnowledgeService.get(id);

        //回复人信息处理
        List<Map<String, Object>> refLists = new ArrayList<Map<String, Object>>();
        Set<OaKnowledge> oaKnowledgeRefs = oaKnowledgeRep.getOaKnowledges();
        if (oaKnowledgeRefs != null) {
            for (OaKnowledge oaKnowledgeRef : oaKnowledgeRefs) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("ref", oaKnowledgeRef);
                if (oaKnowledgeRef.getDocument() != null) {
                    map.put("doc", documentManager.getDownloadButton(oaKnowledgeRef.getDocument()));
                }
                refLists.add(map);
            }

            model.addAttribute("refLists", refLists);
        }

        //发题人信息处理
        model.addAttribute("docButton", documentManager.getDownloadButton(oaKnowledgeRep.getDocument()));
        model.addAttribute("bean", oaKnowledgeRep);

        return "view/oa/oaKnowledge/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaKnowledge entity, HttpServletRequest request) throws Exception {
        try {
            OaKnowledge target;
            if (entity.getId() != null) {
                target = oaKnowledgeService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "reportPerson",
                        "reportDept",
                        "content"
                });

            } else {
                target = entity;
                //设置值
                target.setVisitTimes(0L);
                target.setIsValid(true);
                target.setReportDate(new Timestamp(System.currentTimeMillis()));
            }
            //回复用户
            String refId = request.getParameter("refId");
            if (!StringHelper.isEmpty(refId)) {
                target.setReportDate(new Timestamp(System.currentTimeMillis()));
                target.setRefer(oaKnowledgeService.get(Long.valueOf(refId)));
            }
            //获取文档人ID
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            oaKnowledgeService.save(target);

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
        OaKnowledge oaKnowledgeRep = oaKnowledgeService.get(id);
        Long docId = oaKnowledgeRep.getDocument() != null ? oaKnowledgeRep.getDocument().getId() :null;
        Set<OaKnowledge> oaKnowledgeRefs = oaKnowledgeRep.getOaKnowledges();
        for (OaKnowledge oaKnowledgeRef : oaKnowledgeRefs) {
            oaKnowledgeService.delete(oaKnowledgeRef);
        }

        oaKnowledgeService.delete(id);
        documentManager.removeAllDoc(docId,null);
        sendSuccessJSON(response, "删除成功");
    }

}