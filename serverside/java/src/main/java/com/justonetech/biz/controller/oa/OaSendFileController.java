package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaSendFileService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaSendFile;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.util.StringHelper;
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
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * note:发文记录
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaSendFileController extends BaseCRUDActionController<OaSendFile> {
    private Logger logger = LoggerFactory.getLogger(OaSendFileController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaSendFileService oaSendFileService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;


    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_SEND_FILE_EDIT));

        return "view/oa/oaSendFile/grid";
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
            Page<OaSendFile> pageModel = new Page<OaSendFile>(page, rows, true);
            String hql = "from OaSendFile order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = oaSendFileService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            //输出显示
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object docId = bean.get("fileDoc.id");
                if (docId != null && StringHelper.isNotEmpty((String) docId)) {
                    bean.put("fileDoc.id", documentManager.getDownloadButton(JspHelper.getLong(docId)));
                }

                //将登陆名替换成显示名
                Object createUser = bean.get("createUser");
                if (createUser != null && StringHelper.isNotEmpty((String) createUser)) {
                    bean.put("createUser", sysUserManager.getDisplayName((String) createUser));
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
     */
    @RequestMapping
    public String add(Model model) {
        OaSendFile oaSendFile = new OaSendFile();
        //自动生成编号
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        oaSendFile.setYear(year);
        oaSendFile.setOrderNo(setAutoCode(year));
        model.addAttribute("yearOption", DateTimeHelper.getYearSelectOptions(String.valueOf(year)));

        //如需增加其他默认值请在此添加
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaSendFile.class.getSimpleName(), oaSendFile.getFileDoc(), null, null));

        model.addAttribute("bean", oaSendFile);

        model.addAttribute("type", Constants.OA_AEND_FILE);
        model.addAttribute("secret", Constants.FILE_SECURITY);
        model.addAttribute("emergency", Constants.EMERGENCY);

        return "view/oa/oaSendFile/input";
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
        OaSendFile oaSendFile = oaSendFileService.get(id);

        //处理其他业务逻辑
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaSendFile.class.getSimpleName(), oaSendFile.getFileDoc(), null, null));

        model.addAttribute("bean", oaSendFile);

        model.addAttribute("type", Constants.OA_AEND_FILE);
        model.addAttribute("secret", Constants.FILE_SECURITY);
        model.addAttribute("emergency", Constants.EMERGENCY);

        model.addAttribute("yearOption", DateTimeHelper.getYearSelectOptions(String.valueOf(oaSendFile.getYear())));

        return "view/oa/oaSendFile/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        OaSendFile oaSendFile = oaSendFileService.get(id);
        //将登陆名替换成显示名
        oaSendFile.setCreateUser(sysUserManager.getDisplayName(oaSendFile.getCreateUser()));
        model.addAttribute("docButton", documentManager.getDownloadButton(oaSendFile.getFileDoc()));
        model.addAttribute("bean", oaSendFile);
        return "view/oa/oaSendFile/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   ..
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaSendFile entity, Long docId, HttpServletRequest request) throws Exception {
        try {
            OaSendFile target;
            if (entity.getId() != null) {
                target = oaSendFileService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
//                        "fileCode",
                        "year",
                        "fileTitle",
                        "sendDept",
                        "ccDept",
                        "writtenDept",
                        "writtenDate",
                        "description"
                });
            } else {
                target = entity;
            }
            //文件编号
            String codeType = request.getParameter("codeType");
            if (!StringHelper.isEmpty(codeType)) {
                codeType = "沪交建管办";
            } else {
                codeType = "沪交建管";
            }
            String year = request.getParameter("year");
            String orderNo = request.getParameter("orderNo");
            String fillCode = codeType + "（" + year + "）" + orderNo + "号";
            target.setFileCode(fillCode);

            String typeId = request.getParameter("type");
            SysCodeDetail type = sysCodeDetailService.get(Long.valueOf(typeId));
            target.setType(type);

            String secretId = request.getParameter("secret");
            SysCodeDetail secret = sysCodeDetailService.get(Long.valueOf(secretId));
            target.setSecret(secret);

            String emergencyId = request.getParameter("emergency");
            SysCodeDetail emergency = sysCodeDetailService.get(Long.valueOf(emergencyId));
            target.setEmergency(emergency);

            if (docId != null) {
                DocDocument docDocument = documentManager.getDocDocument(docId);
                target.setFileDoc(docDocument);
                documentManager.updateDocumentByBizData(docDocument, null, target.getFileTitle());
            }
            oaSendFileService.save(target);


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
        OaSendFile data = oaSendFileService.get(id);
        Long docId = data.getFileDoc() != null ? data.getFileDoc().getId() : null;
        oaSendFileService.delete(id);

        //删除文档
        documentManager.removeAllDoc(docId, null);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取最大编号
     *
     * @param year 。
     * @return 。
     */
    public Integer setAutoCode(Integer year) {
        Integer orderNo = 1;
        List<OaSendFile> receiveList = oaSendFileService.findByQuery(" from OaSendFile where year=" + year + " order by orderNo desc");
        if (null != receiveList && receiveList.size() > 0) {
            OaSendFile receive = receiveList.iterator().next();
            if (null != receive.getOrderNo()) {
                orderNo = receive.getOrderNo() + 1;
            }
        }
        return orderNo;
    }

}