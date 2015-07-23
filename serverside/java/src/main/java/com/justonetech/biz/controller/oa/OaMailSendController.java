package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaMailService;
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
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import net.sf.json.JSONArray;
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
import java.util.*;

/**
 * note:邮件发送信息
 * User: guoqiong
 * Date: 14-3-31
 */
@Controller
public class OaMailSendController extends BaseCRUDActionController<OaMail> {
    private Logger logger = LoggerFactory.getLogger(OaMailSendController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMailService oaMailService;

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
        model.addAttribute("MAIL_TYPE_FW", OaMailManager.MAIL_TYPE_FW);

        return "view/oa/oaMailSend/grid";
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
            String hql = "from OaMail where isSend=1 and sendUser='" + loginUser.getLoginName() + "' and isDelete=0 order by id desc";
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
    public String doReceiveNotReadNum(Model model, Long id) {
        String json = "";
        OaMail oaMail = oaMailService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        String notReadNames = oaMailManager.getReceiveNotReadNames(oaMail);
        if (!StringHelper.isEmpty(notReadNames)) {
            map.put("names", notReadNames);
        } else {
            map.put("names", "无");
        }
        json = JSONArray.fromObject(map).toString();
        model.addAttribute("msg", json);

        return "common/msg";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id, String mailType) {
        OaMail oaMail = oaMailService.get(id);
        OaMail fwOaMail = new OaMail();
        fwOaMail.setTitle(oaMail.getTitle());
        if (null != oaMail.getDocument()) {
            fwOaMail.setDocument(oaMail.getDocument());
        }
        fwOaMail.setContent(oaMail.getContent());

        //处理其他业务逻辑
        model.addAttribute("mailType", oaMailManager.getMailType(mailType));
        model.addAttribute("LINE", OaMailManager.LINE);
        model.addAttribute("bean", fwOaMail);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaMail.class.getSimpleName(), fwOaMail.getDocument(), null, null));

        return "view/oa/oaMailSend/input";
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
        model.addAttribute("MAIL_TYPE_FW", OaMailManager.MAIL_TYPE_FW);
        model.addAttribute("bean", oaMail);
        //附件
        model.addAttribute("docButton", documentManager.getDownloadButton(oaMail.getDocument()));

        return "view/oa/oaMailSend/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMail entity, HttpServletRequest request) throws Exception {
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
            //获取当前用户（发件人）
            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
            SysUser sysUser = sysUserManager.getSysUser(loginUser.getLoginName());
            target.setSendUser(loginUser.getLoginName());
            target.setSendPerson(sysUser.getDisplayName());
            //获取收件人或抄送人
            String receivePersonId = request.getParameter("receivePersonId");
            String ccPersonId = request.getParameter("ccPersonId");
            String receivePersons = oaMailManager.getNames(receivePersonId);
            target.setReceivePersons(receivePersons);
            String ccPersons = oaMailManager.getNames(ccPersonId);
            target.setCcPersons(ccPersons);
            target.setIsDelete(false);
            target.setIsNeedReply(false);
            target.setIsSend(true);
            target.setSendTime(new Timestamp(System.currentTimeMillis()));

            //保存附件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            oaMailService.save(target);

            //获取收件人和抄送人(id)
            oaMailManager.setOaMailUser(target, receivePersonId, ccPersonId);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "邮件已发送！");
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
