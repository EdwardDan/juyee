package com.justonetech.biz.controller.document;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocCategoryService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.DocCategory;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * note:文档信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class DocDocumentController extends BaseCRUDActionController<DocDocument> {
    private Logger logger = LoggerFactory.getLogger(DocDocumentController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocCategoryService docCategoryService;

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.DOC_DOCUMENT_EDIT));

        return "view/document/docDocument/grid";
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
            String hql = "from DocDocument order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = docDocumentService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object docId = bean.get("id");
                if (docId != null && org.hibernate.util.StringHelper.isNotEmpty((String) docId)) {
                    bean.put("docDocumentAttachs", documentManager.getDownloadButton(JspHelper.getLong(docId)));
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
     * 获取文档目录
     */
    @RequestMapping
    public String init(Model model) {
        DocDocument docDocument = new DocDocument();
        List<DocCategory> docCategoryList = docCategoryService.find("from DocCategory order by name");
        model.addAttribute("docCategoryList", docCategoryList);
        model.addAttribute("bean", docDocument);
        return "view/document/docDocument/init";

    }

    /**
     * 新增录入页面
     *
     * @param model .
     */
    @RequestMapping
    public String add(Model model, String bizCode) {
        DocDocument docDocument = new DocDocument();
        DocCategory docCategory = docCategoryService.findUniqueByProperty("bizCode", bizCode);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), bizCode, null, null, null));
        //如需增加其他默认值请在此添加
        model.addAttribute("docMenu", docCategory.getName());
        model.addAttribute("docCategoryId", docCategory.getId());
        model.addAttribute("bean", docDocument);
        return "view/document/docDocument/input";
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
        DocDocument docDocument = docDocumentService.get(id);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), docDocument.getCategory().getBizCode(), docDocument, null, null));

        //处理其他业务逻辑
        model.addAttribute("bean", docDocument);
        model.addAttribute("docMenu", docDocument.getCategory().getBizName());

        return "view/document/docDocument/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        DocDocument docDocument = docDocumentService.get(id);
        model.addAttribute("docButton", documentManager.getDownloadButton(docDocument));
        model.addAttribute("bean", docDocument);
        model.addAttribute("docMenu", docDocument.getCategory().getBizName());

        return "view/document/docDocument/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") DocDocument entity, Long docId, Long docCategoryId) throws Exception {
        try {
            DocDocument target;
            if (entity.getId() != null || docId != null) {
                if (entity.getId() != null) {
                    target = docDocumentService.get(entity.getId());
                } else {
                    target = docDocumentService.get(docId);
                }
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "originCode",
                        "code",
                        "name",
                        "author",
                        "keywords",
                        "abstractContent",
                        "description",
                });
            } else {
                target = entity;
            }
            if (docId == null) {
                target.setCategory(docCategoryService.get(docCategoryId));
            }
            docDocumentService.save(target);

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
        Boolean opeation = false;
        try {
            documentManager.removeAllDoc(id, null);
            opeation = true;
        } catch (Exception e) {

        }
        if (opeation) {
            sendSuccessJSON(response, "删除成功");
        } else {
            sendFailureJSON(response, "删除失败，文档已被引用");
        }
    }

}