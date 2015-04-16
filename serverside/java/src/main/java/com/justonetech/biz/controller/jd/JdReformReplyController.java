package com.justonetech.biz.controller.jd;

import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdReformReplyService;
import com.justonetech.biz.daoservice.JdStopOrderService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.JdReformReply;
import com.justonetech.biz.domain.JdStopOrder;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdReformReplyStatus;
import com.justonetech.biz.utils.enums.JdStopOrderStatus;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
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
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * note:安全质量监督--整改回复单
 * author: shaxiaojie
 * create 2014/1/28:
 * modify 2014/1/28:
 */
@Controller
public class JdReformReplyController extends BaseCRUDActionController<JdReformReply> {
    private Logger logger = LoggerFactory.getLogger(JdReformReplyController.class);

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private JdReformReplyService jdReformReplyService;

    @Autowired
    private JdStopOrderService jdStopOrderService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private SysUserManager sysUserManager;
    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String commonLogin(Model model, Long id) {

        JdReformReply jdReformReply = new JdReformReply();
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);

        if (null == jdStopOrder.getJdReformReplies() || jdStopOrder.getJdReformReplies().size() == 0) {
            //  新增
            add(model, jdReformReply);
            // 修改
        } else {
            Iterator<JdReformReply> ita = jdStopOrder.getJdReformReplies().iterator();
            modify(model, ita.next());
        }
        model.addAttribute("stopFormId", id);

        setStatus(model);
        return "view/jd/jdReformReply/input";
    }

    /**
     * 新增录入页面
     *
     * @param model         .
     * @param jdReformReply .
     * @return .
     */
    @RequestMapping
    public String add(Model model, JdReformReply jdReformReply) {

        jdReformReply.setStatus(JdReformReplyStatus.STATUS_EDIT.getCode());
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jdReformReply.getDocument(), null, null));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", jdReformReply);
        model.addAttribute("showFlag", false);
        return "view/jd/jdReformReply/input";
    }

    /**
     * 修改显示页面
     *
     * @param jdReformReply .
     * @param model         .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, JdReformReply jdReformReply) {

        model.addAttribute("opinionType", Constants.POLLING_REVIEW_OPINION);
        SysCodeDetail codeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_REVIEW_OPINION, Constants.POLLING_REVIEW_OPINION_PASS);
        if (codeDetail != null) {
            model.addAttribute("opinionPass", codeDetail.getId());
        }
        //处理其他业务逻辑
        model.addAttribute("bean", jdReformReply);
        boolean showFlag = false;
        if (!StringHelper.isEmpty(jdReformReply.getExistQuestion())) {
            showFlag = true;
        }
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jdReformReply.getDocument(), null, null));
        model.addAttribute("showFlag", showFlag);
        return "view/jd/jdReformReply/input";
    }

    /*
   * 建管署回复
   * */
    @RequestMapping
    public String reply(Model model, Long id) {
        JdReformReply jdReformReply = new JdReformReply();
        SysUser sysUser = sysUserManager.getSysUser();
        jdReformReply.setReplyPerson(sysUser.getDisplayName());
        jdReformReply.setReplyUsername(sysUser.getLoginName());
        jdReformReply.setReplyDate(new Date(System.currentTimeMillis()));
        setStatus(model);
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);

        if (null == jdStopOrder.getJdReformReplies() || jdStopOrder.getJdReformReplies().size() == 0) {
            //  新增
            replyAdd(model, jdReformReply);
            // 修改
        } else {
            Iterator<JdReformReply> ita = jdStopOrder.getJdReformReplies().iterator();
            replyModify(model, ita.next());
        }
        model.addAttribute("stopFormId", id);


        return "view/jd/jdReformReply/reply";
    }

    /**
     * 建管署回复新增录入页面
     *
     * @param model         .
     * @param jdReformReply .
     * @return .
     */
    @RequestMapping
    public String replyAdd(Model model, JdReformReply jdReformReply) {
        jdReformReply.setReplyPerson(sysUserManager.getSysUser().getDisplayName());
        jdReformReply.setStatus(JdReformReplyStatus.STATUS_EDIT.getCode());
        model.addAttribute("bean", jdReformReply);

        //附件
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jdReformReply.getDocument(), null, null));
        model.addAttribute("showFlag", false);

        return "view/jd/jdReformReply/reply";
    }

    /**
     * 建管署回复修改显示页面
     *
     * @param jdReformReply .
     * @param model         .
     * @return .
     */
    @RequestMapping
    public String replyModify(Model model, JdReformReply jdReformReply) {

        model.addAttribute("opinionType", Constants.POLLING_REVIEW_OPINION);
        SysCodeDetail codeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_REVIEW_OPINION, Constants.POLLING_REVIEW_OPINION_PASS);
        if (codeDetail != null) {
            model.addAttribute("opinionPass", codeDetail.getId());
        }
        //处理其他业务逻辑
        model.addAttribute("bean", jdReformReply);
        boolean showFlag = false;
        if (!StringHelper.isEmpty(jdReformReply.getExistQuestion())) {
            showFlag = true;
        }
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jdReformReply.getDocument(), null, null));
        model.addAttribute("showFlag", showFlag);
        return "view/jd/jdReformReply/reply";
    }



    /**
     * 各种状态编码
     *
     * @param model .
     */
    public void setStatus(Model model) {

        // 填写
        model.addAttribute("STATUS_EDIT", JdReformReplyStatus.STATUS_EDIT.getCode());
        // 提交
        model.addAttribute("STATUS_SUBMIT", JdReformReplyStatus.STATUS_SUBMIT.getCode());
        // 预审通过
        model.addAttribute("STATUS_FIRST_PASS", JdReformReplyStatus.STATUS_FIRST_PASS.getCode());
        // 预审退回
        model.addAttribute("STATUS_FIRST_BACK", JdReformReplyStatus.STATUS_FIRST_BACK.getCode());
        // 复核通过
        model.addAttribute("STATUS_BACK", JdReformReplyStatus.STATUS_BACK.getCode());

        // 判断是否有编辑和审核权限
        String bjbh = regPersonManager.getBjbh();
        // 判断是否有施工单位用户权限--用于编辑
        Boolean isSGUser = regPersonManager.isSGUser(bjbh);
        // 判断是否有监理单位用户权限--用于审核
        Boolean isJLUser = regPersonManager.isJLUser(bjbh);
        // 判断是否有编辑权限
        model.addAttribute("isSGUser", isSGUser);
        // 判断是否有审核权限
        model.addAttribute("isJLUser", isJLUser);
    }

    /**
     * 整改回复查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String reformView(Model model, Long id) {

        model.addAttribute("opinionType", Constants.POLLING_REVIEW_OPINION);
        SysCodeDetail codeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_REVIEW_OPINION, Constants.POLLING_REVIEW_OPINION_PASS);
        if (codeDetail != null) {
            model.addAttribute("opinionPass", codeDetail.getId());
        }
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        if (null == jdStopOrder.getJdReformReplies() || jdStopOrder.getJdReformReplies().size() == 0) {
            JdReformReply jdReformReply = new JdReformReply();
            jdReformReply.setExistQuestion("无");
            model.addAttribute("bean", jdReformReply);
            model.addAttribute("optionName", "");
            model.addAttribute("docButton", documentManager.getDownloadButton(jdReformReply.getDocument()));
        } else {

            Iterator<JdReformReply> ita = jdStopOrder.getJdReformReplies().iterator();
            JdReformReply jdReformReply = ita.next();
            model.addAttribute("docButton", documentManager.getDownloadButton(jdReformReply.getDocument()));
            if (StringHelper.isEmpty(jdReformReply.getExistQuestion())) {
                jdReformReply.setExistQuestion("无");
            }
            model.addAttribute("bean", jdReformReply);
            if (null != jdReformReply.getOpinion()) {
                model.addAttribute("optionName", jdReformReply.getOpinion().getName());
            } else {
                model.addAttribute("optionName", "无");
            }
        }

        return "view/jd/jdReformReply/view";
    }

    /**
     * 回复审核查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String checkView(Model model, Long id) {

        model.addAttribute("opinionType", Constants.POLLING_REVIEW_OPINION);
        SysCodeDetail codeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_REVIEW_OPINION, Constants.POLLING_REVIEW_OPINION_PASS);
        if (codeDetail != null) {
            model.addAttribute("opinionPass", codeDetail.getId());
        }

        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        if (null != jdStopOrder.getJdReformReplies() && jdStopOrder.getJdReformReplies().size() != 0) {
            Iterator<JdReformReply> ita = jdStopOrder.getJdReformReplies().iterator();
            JdReformReply jdReformReply = ita.next();

            if (StringHelper.isEmpty(jdReformReply.getExistQuestion())) {
                jdReformReply.setExistQuestion("无");
            }
            model.addAttribute("bean", jdReformReply);
            if (null != jdReformReply.getOpinion()) {
                model.addAttribute("optionName", jdReformReply.getOpinion().getName());
            } else {
                model.addAttribute("optionName", "无");
            }
            model.addAttribute("docButton", documentManager.getDownloadButton(jdReformReply.getDocument()));

        } else {
            JdReformReply jdReformReply = new JdReformReply();
            jdReformReply.setExistQuestion("无");
            model.addAttribute("bean", jdReformReply);
            model.addAttribute("optionName", "");
            model.addAttribute("docButton", documentManager.getDownloadButton(jdReformReply.getDocument()));

        }

        model.addAttribute("stopFormId", id);
        setStatus(model);
        return "view/jd/jdReformReply/checkView";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdReformReply entity, HttpServletRequest request) throws Exception {
        try {
            JdReformReply target;
            if (entity.getId() != null) {
                target = jdReformReplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "status",
                        "replyContent",
                        "replyUsername",
                        "replyPerson",
                        "replyDate",
                        "receiveUsername",
                        "receivePerson"
                });

            } else {
                target = entity;
            }

            //保存文件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            String stopFormId = request.getParameter("stopFormId");
            if (!StringHelper.isEmpty(stopFormId)) {

                JdStopOrder jdStopOrder = jdStopOrderService.get(Long.valueOf(stopFormId));
                Set<JdReformReply> set = new HashSet<JdReformReply>();
                set.add(target);
                jdStopOrder.setJdReformReplies(set);
                jdStopOrderService.save(jdStopOrder);
                target.setStopForm(jdStopOrder);
            }
            jdReformReplyService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
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
    public void saveAduit(HttpServletResponse response, @ModelAttribute("bean") JdReformReply entity, HttpServletRequest request) throws Exception {
        try {
            JdReformReply target;
            if (entity.getId() != null) {
                target = jdReformReplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "status",
                        "opinion",
                        "existQuestion",
                        "limitDate",
                        "signUsername",
                        "signDate"
                });
            } else {
                target = entity;
            }

            String stopFormId = request.getParameter("stopFormId");
            if (!StringHelper.isEmpty(stopFormId)) {

                JdStopOrder jdStopOrder = jdStopOrderService.get(Long.valueOf(stopFormId));
                Set<JdReformReply> set = new HashSet<JdReformReply>();
                set.add(target);
                jdStopOrder.setJdReformReplies(set);
                if (StringHelper.equals(String.valueOf(target.getStatus()), String.valueOf(JdReformReplyStatus.STATUS_BACK.getCode()))) {
                    jdStopOrder.setStatus(JdStopOrderStatus.STATUS_REFORMED.getCode());

                }
                jdStopOrderService.save(jdStopOrder);
                target.setStopForm(jdStopOrder);
                createOaTask(jdStopOrder);
            }
            jdReformReplyService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }
    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(JdStopOrder data) throws Exception {
        if (data.getStatus() == JdStopOrderStatus.STATUS_REFORMED.getCode()) {//已经整改
            Set<Long> managers = new HashSet<Long>();
            SysUser sysUser = sysUserManager.getSysUser();
            managers.add(sysUser.getId());
            String msgTemp = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName());
            if (managers.size() > 0) {
                oaTaskManager.createTask(JdStopOrder.class.getSimpleName(), data.getId(), msgTemp, managers, false, null, null);
            }
        }
    }

    /**
     * 审核页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyAduit(Model model, Long id) {

        model.addAttribute("opinionType", Constants.POLLING_REVIEW_OPINION);
        SysCodeDetail codeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_REVIEW_OPINION, Constants.POLLING_REVIEW_OPINION_PASS);
        if (codeDetail != null) {
            model.addAttribute("opinionPass", codeDetail.getId());
        }

        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        if (null != jdStopOrder.getJdReformReplies() && jdStopOrder.getJdReformReplies().size() != 0) {
            Iterator<JdReformReply> ita = jdStopOrder.getJdReformReplies().iterator();
            JdReformReply jd = ita.next();
            model.addAttribute("bean", jd);
            model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jd.getDocument(), null, null));
        } else {
            JdReformReply jdre = new JdReformReply();
            model.addAttribute("bean", jdre);
            model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), JdReformReply.class.getSimpleName(), jdre.getDocument(), null, null));
        }
        model.addAttribute("stopFormId", id);
        setStatus(model);


        return "view/jd/jdReformReply/inputAduit";
    }
}