package com.justonetech.biz.controller.oa;

import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaMailService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaMail;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaMailManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
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
import java.util.HashSet;
import java.util.Set;

/**
 * note: 新建邮件信息
 * User: guoqiong
 * Date: 14-3-31
 */
@Controller
public class OaMailNewController extends BaseCRUDActionController<OaMail> {

    private Logger logger = LoggerFactory.getLogger(OaMailNewController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMailService oaMailService;

    @Autowired
    private OaMailManager oaMailManager;

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaMail oaMail = new OaMail();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMail);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaMail.class.getSimpleName(), oaMail.getDocument(), null, null));

        return "view/oa/oaMailNew/input";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMail entity, HttpServletRequest request, String msgSend) throws Exception {
        try {
            OaMail target;
            if (entity.getId() != null) {
                target = oaMailService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "content",
                        "receivePersons",
                        "ccPersons"
                });

            } else {
                target = entity;
            }
            //发送的状态下才保存发送表的发送人
            if ("send".equals(msgSend)) {
                //获取当前用户（发件人）
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                SysUser sysUser = sysUserManager.getSysUser(loginUser.getLoginName());
                target.setSendUser(loginUser.getLoginName());
                target.setSendPerson(sysUser.getDisplayName());
                target.setSendTime(new Timestamp(System.currentTimeMillis()));
                target.setIsNeedReply(false);
                target.setIsDelete(false);
                target.setIsSend(true);
            }
            if ("save".equals(msgSend)) {
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                SysUser sysUser = sysUserManager.getSysUser(loginUser.getLoginName());
                target.setSendUser(loginUser.getLoginName());
                target.setSendPerson(sysUser.getDisplayName());
                target.setIsNeedReply(false);
                target.setIsDelete(false);
                target.setIsSend(false);
            }
            //获取收件人或抄送人
            String receivePersonId = request.getParameter("receivePersonId");
            String ccPersonId = request.getParameter("ccPersonId");
            String receivePersons = oaMailManager.getNames(receivePersonId);
            target.setReceivePersons(receivePersons);
            String ccPersons = oaMailManager.getNames(ccPersonId);
            target.setCcPersons(ccPersons);
            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            oaMailService.save(target);
            //获取收件人和抄送人(id)
            Set<String> recAndCcPersonIds = oaMailManager.setOaMailUser(target, receivePersonId, ccPersonId);
            if ("send".equals(msgSend)) {
                Set<Long> convtRecAndCcPerIds = new HashSet<Long>(recAndCcPersonIds.size());
                for (String recAndCcPersonId : recAndCcPersonIds) {
                    convtRecAndCcPerIds.add(JspHelper.getLong(recAndCcPersonId));
                }
                oaTaskManager.createTask(OaMail.class.getSimpleName(), target.getId(), oaTaskManager.getTaskTitle(target, OaMail.class.getSimpleName()), convtRecAndCcPerIds, false, Constants.OA_PRIORITY_NORMAL, Constants.OA_AUDIT_METHOD_SHARE);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        if ("save".equals(msgSend)) {
            sendSuccessJSON(response, "邮件已保存！");
        }
        if ("send".equals(msgSend)) {
            sendSuccessJSON(response, "邮件已发送！");
        }
    }

}
