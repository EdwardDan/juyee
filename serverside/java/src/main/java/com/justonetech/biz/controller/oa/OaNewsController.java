package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaNewsService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaNews;
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
import java.sql.Date;
import java.util.List;
import java.util.Map;


/**
 * note:新闻知识发布
 * author:黄国荣
 * create date:
 * modify date:2014.4.18
 */
@Controller
public class OaNewsController extends BaseCRUDActionController<OaNews> {
  private Logger logger = LoggerFactory.getLogger(OaNewsController.class);


    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaNewsService oaNewsService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_NEWS_EDIT));
        //删除权限
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_NEWS_DELETE));
        //当前用户名
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());
        return "view/oa/oaNews/grid";
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
            String hql = "from OaNews order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaNewsService.findByPage(pageModel, queryTranslate.toString());
            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                OaNews oaNews = oaNewsService.get(JspHelper.getLong(bean.get("id")));
                //附件显示
                bean.put("docButton", documentManager.getDownloadButton(oaNews.getDocument()));
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
        OaNews oaNews = new OaNews();
        SysUser sysUser = sysUserManager.getSysUser();
        String deptName = sysUser.getPerson().getDeptName();
        oaNews.setReportPerson(sysUser.getDisplayName());
        oaNews.setReportDept(deptName);
        //附件保存
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaNews.class.getSimpleName(), oaNews.getDocument(), null, null));
        model.addAttribute("bean", oaNews);

        return "view/oa/oaNews/input";
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
        OaNews oaNews = oaNewsService.get(id);

        //修改附件
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaNews.class.getSimpleName(), oaNews.getDocument(), null, null));
        model.addAttribute("bean", oaNews);

        return "view/oa/oaNews/input";
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
        OaNews oaNews = oaNewsService.get(id);
        //显示附件
        model.addAttribute("docButton", documentManager.getDownloadButton(oaNews.getDocument()));
        model.addAttribute("bean", oaNews);
        //更新访问次数
        oaNews.setVisitTimes(JspHelper.getLong(oaNews.getVisitTimes() + 1));
        oaNewsService.save(oaNews);
        return "view/oa/oaNews/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaNews entity, HttpServletRequest request) throws Exception {
        try {
            OaNews target;
            if (entity.getId() != null) {
                target = oaNewsService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "reportPerson",
                        "reportDept",
                        "content",
                        "isValid",
                });

            } else {
                target = entity;
                target.setVisitTimes(0L);
            }
            //新闻创建时间
            if (target.getIsValid() == true) {
                target.setReportDate(new Date(System.currentTimeMillis()));
            }
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            oaNewsService.save(target);

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
        OaNews oaNews = oaNewsService.get(id);
         Long docId=oaNews.getDocument()!=null?oaNews.getDocument().getId():null;

        //删除记录
        oaNewsService.delete(id);

        //删除文档
        documentManager.removeAllDoc(docId,null);

        sendSuccessJSON(response, "删除成功");
    }

}