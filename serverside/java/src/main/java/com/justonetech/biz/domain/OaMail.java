package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMail;
import com.justonetech.system.manager.SysUserManager;
import org.hibernate.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class OaMail extends BaseOaMail {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMail() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMail(java.lang.Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    public int getReceiveNum() {
        return getOaMailUsers().size();
    }

    public String getReceiveNames(){
        return getReceivePersons();
    }

    //获取未读人的数量和名称
    public int getReceiveNotReadNum() {
        int num = 0;
        Set<OaMailUser> oaMailUsers = this.getOaMailUsers();
        for (OaMailUser oaMailUser : oaMailUsers) {
            if (!oaMailUser.getIsRead()) {
                num++;
            }
        }
        return num;
    }

}