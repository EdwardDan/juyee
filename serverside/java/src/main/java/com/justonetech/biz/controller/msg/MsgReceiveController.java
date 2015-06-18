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
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


/**
 * note:系统消息通知 -- 我收到的消息
 * author: chenjp
 * create date:2014-07-23
 */
@Controller
public class MsgReceiveController extends BaseCRUDActionController<MsgMessage> {
    private Logger logger = LoggerFactory.getLogger(MsgReceiveController.class);

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

        return "view/msg/msgReceive/grid";
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
            String hql = "select t.smsMessage from MsgSendDetail t where t.smsMessage.isSend=1" +
                    " and t.receiveName is not null and (t.sysPersonId={0}) order by t.smsMessage.id desc";
            Long personId = sysUserManager.getSysUser().getPerson().getId();
            hql = FormatUtils.format(hql, personId);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = msgMessageService.findByPage(pageModel, query);
            List<MsgMessage> rows1 = pageModel.getRows();
            for (MsgMessage msg : rows1) {
                Boolean isRead = false;
                Set<MsgSendDetail> details = msg.getMsgSendDetails();
                for (MsgSendDetail detail : details) {
                    if (detail.getSysPersonId() != null) {
                        if (detail.getSysPersonId().equals(personId) && detail.getReadTime() != null) {
                            isRead = true;
                            break;
                        }
                    }
                }
                msg.setIsRead(isRead);
            }

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
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
        Long personId = sysUserManager.getSysUser().getPerson().getId();
        MsgMessage msgMessage = msgMessageService.get(id);
        Set<MsgSendDetail> details = msgMessage.getMsgSendDetails();
        for (MsgSendDetail detail : details) {
            if (detail.getSysPersonId() != null) {
                if (detail.getSysPersonId().equals(personId)) {
                    detail.setReadTime(new Timestamp(System.currentTimeMillis()));
                    msgSendDetailService.save(detail);
                }
            }
        }
        model.addAttribute("bean", msgMessage);

        return "view/msg/msgReceive/view";
    }
}