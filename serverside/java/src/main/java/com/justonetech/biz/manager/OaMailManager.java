package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.OaMailService;
import com.justonetech.biz.daoservice.OaMailUserService;
import com.justonetech.biz.domain.OaMail;
import com.justonetech.biz.domain.OaMailUser;
import com.justonetech.biz.utils.enums.OaMailReceiveType;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: guoqiong
 * Date: 14-4-2
 */
@Service
public class OaMailManager {
    private Logger logger = LoggerFactory.getLogger(OaMailManager.class);

    @Autowired
    private OaMailUserService oaMailUserService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OaMailService oaMailService;

    @Autowired
    private SysUserManager sysUserManager;

    //发送邮件分割线
    public static final String LINE = "\n\n" + "---------------------------------------------------------------------------" + "\n\n";
    //转发的标志
    public static final String MAIL_TYPE_FW = "Fw";
    //回复的标志
    public static final String MAIL_TYPE_RE = "Re";


    /**
     * 获取转发或回复的标签
     *
     * @param mailType 。
     * @return 。
     */
    public String getMailType(String mailType) {
        String str = "";
        if (MAIL_TYPE_RE.equals(mailType)) {
            str = MAIL_TYPE_RE;
        }
        if (MAIL_TYPE_FW.equals(mailType)) {
            str = MAIL_TYPE_FW;
        }
        return str;
    }

    /**
     * 获取收件人和抄送人(根据获取的id)
     *
     * @param oaMail          .
     * @param receivePersonId .
     * @param ccPersonId      .
     */
    public Set<String> setOaMailUser(OaMail oaMail, String receivePersonId, String ccPersonId) {
        Set<String> idSet = new HashSet<String>();
        if (!StringHelper.isEmpty(receivePersonId)) {
            String[] receiveIds = StringHelper.stringToStringArray(receivePersonId, ",");
            for (String receiveId : receiveIds) {
                if (!idSet.contains(receiveId)) {
                    idSet.add(receiveId);
                }
            }
        }
        if (!StringHelper.isEmpty(ccPersonId)) {
            String[] ccIds = StringHelper.stringToStringArray(ccPersonId, ",");
            for (String s : ccIds) {
                if (!idSet.contains(s)) {
                    idSet.add(s);
                }
            }
        }
        for (String s : idSet) {
            OaMailUser oaMailUser = new OaMailUser();
            oaMailUser.setTypeCode(OaMailReceiveType.TYPE_TO.getCode());
            oaMailUser.setMail(oaMail);
            oaMailUser.setIsDelete(false);
            oaMailUser.setIsRead(false);
            oaMailUser.setUserName(sysUserService.get(Long.valueOf(s)).getLoginName());
            oaMailUserService.save(oaMailUser);
        }
        return idSet;
    }

    /**
     * 获取收件人或抄送人
     *
     * @param ids .
     * @return .
     */
    public String getNames(String ids) {
        String names = "";
        if (!StringHelper.isEmpty(ids)) {
            String[] strings = StringHelper.stringToStringArray(ids, ",");
            if (strings.length >= 3) {
                for (int i = 0; i < 3; i++) {
                    names += sysUserService.get(Long.valueOf(strings[i])).getDisplayName() + ",";
                }
                names = names.substring(0, names.length() - 1);
                names = names + "等";
            } else {
                for (String s : strings) {
                    names += sysUserService.get(Long.valueOf(s)).getDisplayName() + ",";
                }
                names = names.substring(0, names.length() - 1);
            }
        }
        return names;
    }

    /**
     * 判断邮件是否阅读
     *
     * @return 。
     */
    public String getIsRead(BaseUser baseUser, OaMail oaMail) {
        String isRead = "";
        String hql = "from OaMailUser where userName='" + baseUser.getLoginName() + "' and mail.id=" + oaMail.getId();
        List<OaMailUser> userList = oaMailUserService.findByQuery(hql);
        for (OaMailUser oaMailUser : userList) {
            if (oaMailUser.getIsRead()) {
                isRead = "read";
            } else {
                isRead = "notRead";
            }
        }
        return isRead;
    }

    /**
     * 获取当前用户未读邮件列表
     *
     * @return .
     */
    public List<OaMail> getNotReadMails() {
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            String hql = "from OaMail where id in(select distinct t.id from OaMail t left join t.oaMailUsers u where t.id=u.mail.id and t.isSend=1 and u.isRead=0 and u.isDelete=0 and u.userName=?) order by sendTime desc";
            return oaMailService.findByQuery(hql, loginUser.getLoginName());
        }
        return new ArrayList<OaMail>();
    }

    /**
     * 获取未读人的数量和名称
     *
     * @param oaMail 。
     * @return 。
     */
    public String getReceiveNotReadNum(OaMail oaMail) {
        String name = "";
        int num = 0;
        Set<OaMailUser> oaMailUsers = oaMail.getOaMailUsers();
        for (OaMailUser oaMailUser : oaMailUsers) {
            if (!oaMailUser.getIsRead()) {
                num++;
                String displayName = sysUserManager.getDisplayName(oaMailUser.getUserName());
                name += "," + displayName;
            }
        }
        if (!StringHelper.isEmpty(name)) {
            name = name.substring(1);
            return num + "(" + name + ")";
        } else {
            return num + "";
        }
    }

    /**
     * 获取未读人的数量和名称
     *
     * @param oaMail 。
     * @return 。
     */
    public String getReceiveNotReadNames(OaMail oaMail) {
        String name = "";
        Set<OaMailUser> oaMailUsers = oaMail.getOaMailUsers();
        for (OaMailUser oaMailUser : oaMailUsers) {
            if (!oaMailUser.getIsRead()) {
                String displayName = sysUserManager.getDisplayName(oaMailUser.getUserName());
                name += "," + displayName;
            }
        }
        if (!StringHelper.isEmpty(name)) {
            name = name.substring(1);
            return name;
        } else {
            return "";
        }
    }
}
