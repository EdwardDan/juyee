package com.justonetech.biz.controller.msg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.MsgMessageService;
import com.justonetech.biz.daoservice.MsgSendDetailService;
import com.justonetech.biz.domain.MsgMessage;
import com.justonetech.biz.domain.MsgSendDetail;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysRegPerson;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


/**
 * note:系统消息通知
 * author: chenjp
 * create date:2014-07-18
 */
@Controller
public class MsgMessageController extends BaseCRUDActionController<MsgMessage> {
    private Logger logger = LoggerFactory.getLogger(MsgMessageController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private MsgSendDetailService msgSendDetailService;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private SysRegPersonService sysRegPersonService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.MSG_MESSAGE_EDIT));

        return "view/msg/msgMessage/grid";
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
            String hql = "from MsgMessage order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = msgMessageService.findByPage(pageModel, query);

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
        MsgMessage msgMessage = new MsgMessage();

        //如需增加其他默认值请在此添加
        msgMessage.setIsSend(false);
        msgMessage.setIsSendSms(true);
        model.addAttribute("bean", msgMessage);

        return "view/msg/msgMessage/input";
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
        MsgMessage msgMessage = msgMessageService.get(id);

        //内部接收人
        String innerPersonIds = msgMessage.getInnerPersonIds();
        if (!StringHelper.isEmpty(innerPersonIds)) {
            List<SysPerson> persons = sysPersonService.findByQuery("from SysPerson where id in("+innerPersonIds+")");
            model.addAttribute("innerPersons",persons);
        }

        //工地接收人
        String gdPersonIds = msgMessage.getGdPersonIds();
        if (!StringHelper.isEmpty(gdPersonIds)) {
            List<SysRegPerson> persons = sysRegPersonService.findByQuery("from SysRegPerson where id in("+gdPersonIds+")");
            model.addAttribute("gdPersons",persons);
        }

        model.addAttribute("bean", msgMessage);

        return "view/msg/msgMessage/input";
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
        MsgMessage msgMessage = msgMessageService.get(id);

        model.addAttribute("bean", msgMessage);
        return "view/msg/msgMessage/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") MsgMessage entity) throws Exception {
        String msg = "保存成功";
        try {
            MsgMessage target;
            if (entity.getId() != null) {
                target = msgMessageService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "content",
                        "innerPersonIds",
                        "innerPersonNames",
                        "gdPersonIds",
                        "gdPersonNames",
                        "mobiles",
                        "isSendSms",
                        "isSend"
                });

            } else {
                target = entity;
                String displayName = sysUserManager.getSysUser().getDisplayName();
                target.setSender(displayName);
            }
            if (target.getIsSend()) {
                msg = "发送成功";
                target.setSendTime(new Timestamp(System.currentTimeMillis()));
            }
            msgMessageService.save(target);

            //先删除
            List<MsgSendDetail> existDetails = msgSendDetailService.findByQuery("from MsgSendDetail where smsMessage.id=?", target.getId());
            for (MsgSendDetail detail : existDetails) {
                msgSendDetailService.delete(detail);
            }

            //保存明细
            //系统人员
            String innerPersonIds = target.getInnerPersonIds();
            String innerPersonNames = "";
            if (!StringHelper.isEmpty(innerPersonIds)) {
                String[] ids = StringHelper.stringToStringArray(innerPersonIds, ",");
                if (ids.length > 0) {
                    for (int i = 0; i < ids.length; i++) {
                        MsgSendDetail detail = new MsgSendDetail();
                        detail.setSmsMessage(target);
                        SysPerson sysPerson = sysPersonService.get(Long.valueOf(ids[i]));
                        innerPersonNames += ","+sysPerson.getName();
                        detail.setSysPersonId(Long.valueOf(ids[i]));
                        detail.setReceiveName(sysPerson.getName());
                        detail.setReceiveMobile(sysPerson.getMobile());
                        msgSendDetailService.save(detail);
                    }
                    innerPersonNames = innerPersonNames.substring(1);
                }
            }

            //工地注册人员
            String gdPersonIds = target.getGdPersonIds();
            String gdPersonNames = "";
            if (!StringHelper.isEmpty(gdPersonIds)) {
                String[] ids = StringHelper.stringToStringArray(gdPersonIds, ",");
                if (ids.length > 0) {
                    for (int i = 0; i < ids.length; i++) {
                        MsgSendDetail detail = new MsgSendDetail();
                        detail.setSmsMessage(target);
                        SysRegPerson sysRegPerson = sysRegPersonService.get(Long.valueOf(ids[i]));
                        gdPersonNames += ","+sysRegPerson.getPersonName();
                        detail.setGdPersonId(Long.valueOf(ids[i]));
                        detail.setReceiveName(sysRegPerson.getPersonName());
                        detail.setReceiveMobile(sysRegPerson.getMobile());
                        msgSendDetailService.save(detail);
                    }
                    gdPersonNames = gdPersonNames.substring(1);
                }
            }
            target.setInnerPersonNames(innerPersonNames);
            target.setGdPersonNames(gdPersonNames);
            msgMessageService.save(target);

            //临时号码
            String mobiles = target.getMobiles();
            if (!StringHelper.isEmpty(mobiles)) {
                mobiles = StringHelper.findAndReplace(mobiles,"，",",");
                String[] mm = StringHelper.stringToStringArray(mobiles, ",");
                if (mm.length > 0) {
                    for (String aMm : mm) {
                        MsgSendDetail detail = new MsgSendDetail();
                        detail.setSmsMessage(target);
                        detail.setReceiveMobile(aMm);
                        msgSendDetailService.save(detail);
                    }
                }
            }

            //发送短信
            if (target.getIsSendSms() && target.getIsSend()) {
                List<MsgSendDetail> details = msgSendDetailService.findByQuery("from MsgSendDetail where smsMessage.id=" + target.getId()+" order by id asc");
                for (MsgSendDetail detail : details) {
                    String mobile = detail.getReceiveMobile();
                    if (!StringHelper.isEmpty(mobile) && detail.getSendSmsTime() == null) {
                        msgMessageManager.sendSmsByMsgSendDetail(detail);
                    }
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, msg);
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
        MsgMessage msgMessage = msgMessageService.get(id);
        Set<MsgSendDetail> details = msgMessage.getMsgSendDetails();
        for (MsgSendDetail detail : details) {
            msgSendDetailService.delete(detail);
        }

        msgMessageService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}