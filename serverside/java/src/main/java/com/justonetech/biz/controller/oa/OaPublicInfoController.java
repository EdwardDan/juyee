package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaPublicInfoManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * note:公共信息发布
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaPublicInfoController extends BaseCRUDActionController<OaPublicInfo> {
    private Logger logger = LoggerFactory.getLogger(OaPublicInfoController.class);

    @Autowired
    private OaPublicInfoManager oaPublicInfoManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 列表显示页面
     *
     * @param model    .
     * @param typeCode 信息类型编码 -- 用于首页或网站调用
     * @param range    发布范围 -- 用于首页或网站调用
     * @param isZc    发布范围 -- 用于项目管理的政策栏
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String typeCode, String range, String isZc) {
        model.addAttribute("isZc", isZc);
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_PUBLIC_INFO_EDIT));
        model.addAttribute("typeCode", JspHelper.getString(typeCode));
        if (!StringHelper.isEmpty(typeCode)) {
            SysCodeDetail codeDetailByCode = sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, typeCode);
            if (codeDetailByCode != null) {
                model.addAttribute("typeName",codeDetailByCode.getName());
            }
        }
        model.addAttribute("range", JspHelper.getString(range));

        return "view/oa/oaPublicInfo/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param typeCode 信息类型编码 -- 用于首页或网站调用
     * @param range    发布范围 -- 用于首页或网站调用
     * @param session  .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String typeCode, String range,String isZc, HttpSession session) {
        try {
            Boolean canEdit = sysUserManager.hasPrivilege(PrivilegeCode.OA_PUBLIC_INFO_EDIT);

            Page<OaPublicInfo> pageModel = new Page<OaPublicInfo>(page, rows, true);
            String hql = "from OaPublicInfo where 1=1";
            //是否是政策规章
            if (!StringHelper.isEmpty(isZc)) {
                hql += " and type.code='" + isZc + "'";
            } /*else {
                hql += " and type.code!='" + Constants.OA_PUBLIC_INFO_TYPE_ZCGZ + "'";
            }*/

            //信息类型过滤
            if (!StringHelper.isEmpty(typeCode)) {
                hql += " and type.code='" + typeCode + "'";
            }
            //发布范围过滤
            if (!StringHelper.isEmpty(range)) {
                hql += " and (accessRange.code='" + Constants.OA_PUBLIC_INFO_RANGE_ALL + "' or accessRange.code='" + range + "')";
            }
            //如有编辑权限则可看到全部记录
            if (canEdit) {
                hql += " order by id desc";
            } else {
                //没有编辑权限那么只能看到已发布的有效记录
                hql += " and isValid=" + Constants.FLAG_TRUE + " and isPublic=" + Constants.FLAG_TRUE;
                hql += " order by isTop desc,reportDate desc";
            }
//            System.out.println("..................typeCode = " + typeCode);
//            System.out.println("..................range = " + range);
//            System.out.println("..................hql = " + hql);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaPublicInfoService.findByPage(pageModel, query);

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object docId = bean.get("document.id");
                if (docId != null && StringHelper.isNotEmpty((String) docId)) {
                    bean.put("document.id", documentManager.getDownloadButton(docDocumentService.get(JspHelper.getLong(docId))));
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
    public String add(Model model,String isZc) {
        OaPublicInfo oaPublicInfo = new OaPublicInfo();

        //如需增加其他默认值请在此添加

        //上传图片功能
        model.addAttribute("uploadButtonImage", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                OaPublicInfo.class.getSimpleName(), oaPublicInfo.getIconImage(), null, null, "Image"));

        //上传文档功能
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                OaPublicInfo.class.getSimpleName(), oaPublicInfo.getDocument(), null, null, "Document"));

        //信息类型
        model.addAttribute("range", Constants.OA_PUBLIC_INFO_RANGE);
        //发布范围
        SysCodeDetail ZCFZ = sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, Constants.OA_PUBLIC_INFO_TYPE_ZCGZ);
        if (!StringHelper.isEmpty(isZc)) {
            List<SysCodeDetail> typeList = new ArrayList<SysCodeDetail>();
            typeList.add(ZCFZ);
            model.addAttribute("typeList", typeList);
        } else {
            List<SysCodeDetail> typeList1 = sysCodeManager.getCodeListByCode(Constants.OA_PUBLIC_INFO_TYPE);
            typeList1.remove(ZCFZ);
            model.addAttribute("typeList", typeList1);
        }
        model.addAttribute("bean", oaPublicInfo);

        return "view/oa/oaPublicInfo/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id,String isZc) {
        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);

        //处理其他业务逻辑

        //上传图片功能
        model.addAttribute("uploadButtonImage", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                OaPublicInfo.class.getSimpleName(), oaPublicInfo.getIconImage(), null, null, "Image"));

        //上传文档功能
        model.addAttribute("uploadButtonDocument", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                OaPublicInfo.class.getSimpleName(), oaPublicInfo.getDocument(), null, null, "Document"));

        //信息类型
        model.addAttribute("range", Constants.OA_PUBLIC_INFO_RANGE);
        //发布范围
        SysCodeDetail ZCFZ = sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, Constants.OA_PUBLIC_INFO_TYPE_ZCGZ);
        if (!StringHelper.isEmpty(isZc)) {
            List<SysCodeDetail> typeList = new ArrayList<SysCodeDetail>();
            typeList.add(ZCFZ);
            model.addAttribute("typeList", typeList);
        } else {
            List<SysCodeDetail> typeList1 = sysCodeManager.getCodeListByCode(Constants.OA_PUBLIC_INFO_TYPE);
            typeList1.remove(ZCFZ);
            model.addAttribute("typeList", typeList1);
        }

        model.addAttribute("bean", oaPublicInfo);

        return "view/oa/oaPublicInfo/input";
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
        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);

        model.addAttribute("imageButton", documentManager.getDownloadButton(oaPublicInfo.getIconImage()));
        model.addAttribute("docButton", documentManager.getDownloadButton(oaPublicInfo.getDocument()));
        model.addAttribute("bean", oaPublicInfo);

        //更新访问次数
        oaPublicInfoManager.updateVisitTimes(oaPublicInfo);

        return "view/oa/oaPublicInfo/view";
    }

    /**
     * 保存操作
     *
     * @param response      .
     * @param entity        .
     * @param docIdImage    .
     * @param docIdDocument .
     * @param request       .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaPublicInfo entity, Long docIdImage, Long docIdDocument, HttpServletRequest request) throws Exception {
        try {
            OaPublicInfo target;
            if (entity.getId() != null) {
                target = oaPublicInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "content",
                        "createDeptName",
                        "accessRange",
                        "isPublic",
//                        "isValid",
                        "isTop",
                        "type"
                });

            } else {
                target = entity;

                //创建日期为当前系统时间
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                target.setCreateDate(date);

                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                if (loginUser != null) {
                    //创建用户默认为当前用户
                    target.setUser(sysUserManager.getSysUser(loginUser.getLoginName()));

                }
                target.setVisitTimes(0L);
            }


            if (target.getIsPublic()) {
                //若信息的状态为发布则设置当前系统时间为发布时间。
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                target.setReportDate(date);

                //若信息的状态为发布则设置信息为有效。
                target.setIsValid(true);
            }else{
                //若信息的状态为不发布则设置信息为无效。
                target.setIsValid(false);
            }

            if (docIdImage != null) {
                target.setIconImage(docDocumentService.get(docIdImage));
            }

            if (docIdDocument != null) {
                DocDocument docDocument = docDocumentService.get(docIdDocument);
                target.setDocument(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getTitle());
            }
            String thumbnailPath = oaPublicInfoManager.saveandgetThumbnailPath(request, target);
            if (thumbnailPath != null) {
                target.setThumbnail(thumbnailPath);
            } else {
                target.setThumbnail(null);
            }


            oaPublicInfoService.save(target);

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
        oaPublicInfoService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}
