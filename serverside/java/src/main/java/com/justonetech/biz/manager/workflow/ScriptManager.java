package com.justonetech.biz.manager.workflow;

import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-7-20
 * Time: 上午9:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ScriptManager {

    @Autowired
    RegPersonManager regPersonManager;

    @Autowired
    ProjectManager projectManager;

    @Autowired
    RelateManager relateManager;

    @Autowired
    SysUserManager sysUserManager;

    @Autowired
    SimpleQueryManager simpleQueryManager;

    /**
     * 外网注册人员获取工作组负责人
     *
     * @param sysPerson 流程人员
     * @return 是否包含
     */
    public Boolean filterAuditPersonByRegPerson(SysPerson sysPerson) {
        SysUser sysUser = sysUserManager.getSysUser();
        SysRegPerson regPerson = sysUser.getRegPerson();
        if (regPerson == null) {
            return true;
        }
        Set<String> auditPersonIds = getAuditPersonByRegPerson(regPerson);
        if (auditPersonIds == null || auditPersonIds.size() == 0) {
            return false;
        }
        return auditPersonIds.contains(sysPerson.getId().toString());
    }

    /**
     * 根据外部注册用户获取负责人
     *
     * @param regPerson 注册人员
     * @return 负责人ids
     */
    public Set<String> getAuditPersonByRegPerson(SysRegPerson regPerson) {
        String bjbh = null;
        if (regPerson == null) {
            return null;
        }
        if (regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_Gd)) {      //获取工地用户报建编号
            String gdCode = regPerson.getGdCode();
            if (gdCode != null) {
                ShareGdInfo gdInfo = projectManager.getGDInfo(gdCode);
                if (gdInfo != null) {
                    bjbh = gdInfo.getBjbh();
                }
            }

        } else if (regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_Gd) || regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
            bjbh = regPerson.getBjbh();
        } else {
            return null;
        }
        if (bjbh == null) {
            return null;
        }
//        ProBelongArea proBelongArea = relateManager.getProBelongArea(bjbh);
//        if (proBelongArea == null) {
//            return null;
//        }
//        SysCodeDetail belongArea = proBelongArea.getBelongArea();
//        if (belongArea == null) {
//            return null;
//        }
//        List<PollingWorkGroup> workGroups = pollingWorkGroupManager.getPollingWorkGroupsByBelongArea(belongArea.getId());
//        return pollingWorkGroupManager.getPollingGroupPersonIds(workGroups);
        return null;
    }

}
