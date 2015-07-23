package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaMailService;
import com.justonetech.biz.daoservice.OaMailUserService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaMail;
import com.justonetech.biz.domain.OaMailUser;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaMailManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
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
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * note:邮件接收信息
 * User: guoqiong
 * Date: 14-3-31
 */
@Controller
public class OaMailWaitController extends BaseCRUDActionController<OaMail> {
    private Logger logger = LoggerFactory.getLogger(OaMailWaitController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMailService oaMailService;

    @Autowired
    private OaMailUserService oaMailUserService;

    @Autowired
    private OaMailManager oaMailManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限

        return "view/oa/oaMailWait/grid";
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
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            String hql = "from OaMail where isSend=0 and isDelete=0 and sendUser = '" + loginUser.getLoginName() + "' order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMailService.findByPage(pageModel, queryTranslate.toString());

            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);

            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : mapList) {
                OaMail oaMail = oaMailService.get(JspHelper.getLong(bean.get("id")));
                //附件
                bean.put("documentFile", documentManager.getDownloadButton(oaMail.getDocument()));
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
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        OaMail oaMail = oaMailService.get(id);
        //获取接收人的ID
        Set<OaMailUser> oaMailUsers = oaMail.getOaMailUsers();
        String receivePersonId = "";
        String receivePersons = "";
        for (OaMailUser mailUser : oaMailUsers) {
            SysUser sysUser = sysUserManager.getSysUser(mailUser.getUserName());
            receivePersons += "," + sysUser.getDisplayName();
            receivePersonId += "," + sysUser.getId();
        }
        receivePersons = receivePersons.substring(1);
        receivePersonId = receivePersonId.substring(1);
        model.addAttribute("receivePersons", receivePersons);
        model.addAttribute("receivePersonId", receivePersonId);

        //处理其他业务逻辑
        model.addAttribute("LINE", OaMailManager.LINE);
        model.addAttribute("bean", oaMail);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaMail.class.getSimpleName(), oaMail.getDocument(), null, null));

        return "view/oa/oaMailWait/input";
    }

    /**
     * 发送多封邮件
     *
     * @param response 。
     * @param ids      。
     */
    @RequestMapping
    public void sends(HttpServletResponse response, String ids) throws Exception {
        if (!StringHelper.isEmpty(ids)) {
            String userName = "";
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                userName = loginUser.getLoginName();
            }
            String hql = "from OaMail where sendUser='{0}' and id in({1})";
            hql = FormatUtils.format(hql, userName, ids);
            List<OaMail> list = oaMailService.findByQuery(hql);
            for (OaMail oaMail : list) {
                oaMail.setIsSend(true);
                oaMail.setSendTime(new Timestamp(System.currentTimeMillis()));
                oaMailService.save(oaMail);
            }
        }

        sendSuccessJSON(response, "邮件发送成功");
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
        OaMail oaMail = oaMailService.get(id);
        String toNames = "";
        Set<OaMailUser> oaMailUsers = oaMail.getOaMailUsers();
        if (oaMailUsers.size() > 0) {
            for (OaMailUser oaMailUser : oaMailUsers) {
                toNames += "," + sysUserManager.getSysUser(oaMailUser.getUserName()).getDisplayName();
            }
        }
        if (!StringHelper.isEmpty(toNames)) {
            toNames = toNames.substring(1);
        }
        model.addAttribute("toNames", toNames);
        model.addAttribute("bean", oaMail);
        //附件
        model.addAttribute("docButton", documentManager.getDownloadButton(oaMail.getDocument()));

        return "view/oa/oaMailWait/view";
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
                        "ccPersons",
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

            //先删除在保存
            Set<OaMailUser> oaMailUsers = target.getOaMailUsers();
            if (oaMailUsers.size() > 0) {
                for (OaMailUser oaMailUser : oaMailUsers) {
                    oaMailUserService.delete(oaMailUser);
                }
            }

            //获取收件人和抄送人(id)
            oaMailManager.setOaMailUser(target, receivePersonId, ccPersonId);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        if ("save".equals(msgSend)) {
            sendSuccessJSON(response, "保存成功");
        }
        if ("send".equals(msgSend)) {
            sendSuccessJSON(response, "邮件发送成功");
        }
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param ids      .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, String ids) throws Exception {
        if (!StringHelper.isEmpty(ids)) {
            String userName = "";
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            if (loginUser != null) {
                userName = loginUser.getLoginName();
            }
            String hql = "from OaMail where sendUser='{0}' and id in({1})";
            hql = FormatUtils.format(hql, userName, ids);
            List<OaMail> list = oaMailService.findByQuery(hql);
            for (OaMail oaMail : list) {
                oaMail.setIsDelete(true);
                oaMail.setDeleteTime(new Timestamp(System.currentTimeMillis()));
                oaMailService.save(oaMail);
            }
        }

        sendSuccessJSON(response, "删除成功");
    }
}
