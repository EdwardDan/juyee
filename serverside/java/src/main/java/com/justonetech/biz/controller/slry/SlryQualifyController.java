package com.justonetech.biz.controller.slry;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SlryQualifyService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.SlryQualify;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.SlryQualifyStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
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
 * note:三类人员
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SlryQualifyController extends BaseCRUDActionController<SlryQualify> {
    private Logger logger = LoggerFactory.getLogger(SlryQualifyController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SlryQualifyService slryQualifyService;


    public void setStatus(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SLRY_QUALIFY_EDIT));
        //常量定义
        model.addAttribute("STATUS_EDIT", SlryQualifyStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", SlryQualifyStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_PASS", SlryQualifyStatus.STATUS_PASS.getCode());
        model.addAttribute("STATUS_BACK", SlryQualifyStatus.STATUS_BACK.getCode());
        model.addAttribute("sex", Constants.SEX);//性别
        model.addAttribute("techType", Constants.TECHTYPE);//技术职称
        model.addAttribute("applyType", Constants.APPLYTYPE);//申请类型
        model.addAttribute("applyCerType", Constants.APPLYCERTYPE);//申请证书类型
        model.addAttribute("education", Constants.EDUCATION);//学历
        model.addAttribute("unitType", Constants.UNITTYPE);//企业类型
        model.addAttribute("cardType", Constants.CARDTYPE);//申请类型
    }

    //上传修改文档
    public void doS(Model model, SlryQualify slryQualify) {
        model.addAttribute("uploadButtondocphoto", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SlryQualify.class.getSimpleName() + "_View", slryQualify.getDocPhoto(), null, null, "Image1"));//获取预览附件显示图标
        model.addAttribute("uploadButtondoccard", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SlryQualify.class.getSimpleName() + "_Other", slryQualify.getDocCard(), null, null, "Image2"));//获取其他附件显示图标
        model.addAttribute("uploadButtondoceducation", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SlryQualify.class.getSimpleName() + "_Either", slryQualify.getDocEducation(), null, null, "Image3"));//获取其他附件显示图标
        model.addAttribute("uploadButtondoccontract", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SlryQualify.class.getSimpleName() + "_Nither", slryQualify.getDocContract(), null, null, "Image4"));//获取其他附件显示图标

    }

    //下载文档
    public void downloadButton(Model model, SlryQualify slryQualify) {
        model.addAttribute("photoButton", documentManager.getDownloadButton(slryQualify.getDocPhoto()));//获取预览附件下载路径
        model.addAttribute("cardButton", documentManager.getDownloadButton(slryQualify.getDocCard()));//获取其他附件下载路径
        model.addAttribute("educationButton", documentManager.getDownloadButton(slryQualify.getDocEducation()));//获取其他附件下载路径
        model.addAttribute("contractButton", documentManager.getDownloadButton(slryQualify.getDocContract()));//获取其他附件下载路径
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        String options = SlryQualifyStatus.getOptions("");
        model.addAttribute("option", options);
        setStatus(model);

        return "view/slry/slryQualify/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SlryQualify  where 1=1";
            //按状态类别查询数据
            String status = request.getParameter("status");
            if (!StringHelper.isEmpty(status)) {
                hql += " and status = '" + status + "' ";
            }
            String sex = request.getParameter("sex");
            if (!StringHelper.isEmpty(sex)) {
                if (sex.equals("男")) sex = "1";
                else sex = "0";
                hql += " and sex = '" + sex + "' ";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = slryQualifyService.findByPage(pageModel, query);

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
        SlryQualify slryQualify = new SlryQualify();
        model.addAttribute("bean", slryQualify);
        doS(model, slryQualify);
        setStatus(model);

        return "view/slry/slryQualify/input";
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
        SlryQualify slryQualify = slryQualifyService.get(id);
        model.addAttribute("bean", slryQualify);
        setStatus(model);
        doS(model, slryQualify);

        return "view/slry/slryQualify/input";
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
        SlryQualify slryQualify = slryQualifyService.get(id);
        model.addAttribute("bean", slryQualify);
        downloadButton(model, slryQualify);
        setStatus(model);

        return "view/slry/slryQualify/view";
    }


    /**
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        SlryQualify slryQualify = slryQualifyService.get(id);
        downloadButton(model, slryQualify);
        setStatus(model);
        model.addAttribute("bean", slryQualify);

        return "view/slry/slryQualify/audit";
    }

    /**
     * 保存操作
     *
     * @param response    .
     * @param entity      .
     * @param docIdImage1 .
     * @param docIdImage2 ..
     * @param docIdImage3 ..
     * @param docIdImage4 ..
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SlryQualify entity, Long docIdImage1, Long docIdImage2, Long docIdImage3, Long docIdImage4) throws Exception {
        try {
            SlryQualify target;
            if (entity.getId() != null) {
                target = slryQualifyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "sex",
                        "birthDate",
                        "applyCerType",
                        "cardType",
                        "idCard",
                        "educationType",
                        "techType",
                        "graduationTime",
                        "graduationSchool",
                        "major",
                        "applyType",
                        "workResume",
                        "production",
                        "unitType",
                        "status",
                        "csOpinion"
                });

            } else {
                target = entity;
            }
            DocDocument docDocument;
            if (docIdImage1 != null) {//保存附件
                docDocument = documentManager.getDocDocument(docIdImage1);
                target.setDocPhoto(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getDocPhoto().getName());
            }
            if (docIdImage2 != null) {//保存附件
                docDocument = documentManager.getDocDocument(docIdImage2);
                target.setDocCard(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getDocCard().getName());
            }
            if (docIdImage3 != null) {//保存附件
                docDocument = documentManager.getDocDocument(docIdImage3);
                target.setDocEducation(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getDocEducation().getName());
            }
            if (docIdImage4 != null) {//保存附件
                docDocument = documentManager.getDocDocument(docIdImage4);
                target.setDocContract(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getDocContract().getName());
            }
            slryQualifyService.save(target);


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
        slryQualifyService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}