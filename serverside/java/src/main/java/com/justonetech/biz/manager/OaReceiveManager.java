package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.DocDocumentAttach;
import com.justonetech.biz.domain.OaReceive;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaReceiveStatus;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * description: 收文管理的业务类
 */
@Service
public class OaReceiveManager {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    @Autowired
    private OaReceiveOperationService oaReceiveOperationService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaReceiveNodeService oaReceiveNodeService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaReceiveService oaReceiveService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private OaReceiveStepService oaReceiveStepService;

    @Autowired
    private SysDeptManager sysDeptManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 自动生成当年的序号
     *
     * @param year
     * @return
     */
    public Integer setAutoCode(Integer year) {
        Integer orderNo = new Integer(1);
        List<OaReceive> receiveList = oaReceiveService.findByQuery(" from OaReceive where year=" + year + "  order by orderNo desc ");
        if (null != receiveList && receiveList.size() > 0) {
            OaReceive receive = receiveList.iterator().next();
            if (null != receive.getOrderNo()) {
                orderNo = receive.getOrderNo() + 1;
            }
        }
        return orderNo;
    }

    /**
     * 将用户Ids的字符串转换成Map
     *
     * @param cUserIds
     * @return
     */
    public HashMap<String, String> setPersonIdsToMap(String cUserIds) {
        HashMap<String, String> sysUserHM = new HashMap<String, String>();
        if (StringUtils.isNotBlank(cUserIds)) {
            String[] ids = cUserIds.split(",");
            for (String uid : ids) {
                try {
                    SysUser sysUser = sysUserService.get(Long.valueOf(uid));
                    sysUserHM.put(uid, sysUser.getDisplayName());
                } catch (NumberFormatException e) {
                    //排除id 无效的情况
                }
            }
        }
        return sysUserHM;
    }

    /**
     * 将部门Ids的字符串转换成Map
     *
     * @param cDeptIds
     * @return
     */
    public HashMap<String, String> setDeptIdsToMap(String cDeptIds) {
        HashMap<String, String> sysDeptHM = new HashMap<String, String>();
        if (StringUtils.isNotBlank(cDeptIds)) {
            String[] ids = cDeptIds.split(",");
            for (String uid : ids) {
                try {
                    SysDept sysDept = sysDeptService.get(Long.valueOf(uid));
                    sysDeptHM.put(uid, sysDept.getName());
                } catch (NumberFormatException e) {
                    //排除id 无效的情况
                }
            }
        }
        return sysDeptHM;
    }

    /**
     * 设置附件 如果附件有挂接文件显示文件名
     *
     * @param oaReceive
     * @return
     */
    public Map<String, Object> setDocAndAttach(OaReceive oaReceive) {
        Map<String, Object> docMap = new HashMap<String, Object>();
        docMap.put("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaReceive.class.getSimpleName(), oaReceive.getDoc(), null, null));
        if (null != oaReceive.getDoc()) {
            Set<DocDocumentAttach> docDocumentAttachs = oaReceive.getDoc().getDocDocumentAttachs();
            docMap.put("docAttachs", docDocumentAttachs);
        }
        return docMap;
    }

    /**
     * 通过科室获取科室科长
     *
     * @param sysDeptId .
     * @return .
     */
    public Set<SysUser> getDeptLeader(String sysDeptId) {
        Set<SysUser> sysUsers = new HashSet<SysUser>();
        if (!StringHelper.isEmpty(sysDeptId)) {
            String hql = "from SysPersonDept t where t.dept.id='{0}'and t.position='{1}'";
            List<SysPersonDept> sysPersonDeptList = sysPersonDeptService.findByQuery(FormatUtils.format(hql, sysDeptId, Constants.SYS_DEPT_LEADER_NAME));
            if (sysPersonDeptList.size() > 0) {
                SysPersonDept sysPersonDept = sysPersonDeptList.iterator().next();
                SysPerson person = sysPersonDept.getPerson();
                sysUsers = person.getSysUsers();
            }
        }
        return sysUsers;
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaReceive data,String userCbIds) throws Exception {
        String code = data.getStep().getCode();
        //创建任务
        String title ="";
        Set<Long> managers = new HashSet<Long>();
        if(!StringHelper.isEmpty(userCbIds)){
            title = oaTaskManager.getTaskTitle(data, OaReceive.class.getSimpleName()+"_cb");
            //获取办公室主任
            String[] user = userCbIds.split(",");
            for (String id : user) {
                managers.add(Long.valueOf(id));
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaReceive.class.getSimpleName()+"_cb", data.getId(), title, managers, false, null, null);
            }
        }
        //办公室主任在提交后收到待办提醒
        if (OaReceiveStatus.OA_RECEIVE_BGSNB.getCode().equals(code)) {
            title = oaTaskManager.getTaskTitle(data, OaReceive.class.getSimpleName()+"_nb");
            //获取办公室主任
            String privilegeCodeZR = PrivilegeCode.OA_CAR_AUDIT_ZR;
            Set<Long> managersZR = sysUserManager.getUserIdsByPrivilegeCode(privilegeCodeZR);
            managers.addAll(managersZR);
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaReceive.class.getSimpleName()+"_nb", data.getId(), title, managers, false, null, null);
            }
        }
        //领导在办公室拟办后收到待办提醒
        if (OaReceiveStatus.OA_RECEIVE_LDPS.getCode().equals(code)) {
            title = oaTaskManager.getTaskTitle(data, OaReceive.class.getSimpleName());
            String dealPersons = data.getDealPersons();
            if (!StringHelper.isEmpty(dealPersons)) {
                String[] userIds = dealPersons.split(",");
                for (String userId : userIds) {
                    managers.add(Long.valueOf(userId));
                }
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaReceive.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }

        //部门领导在领导批示完后收到代办事项
        if (OaReceiveStatus.OA_RECEIVE_BMLDYJ.getCode().equals(code)) {
            title = oaTaskManager.getTaskTitle(data, OaReceive.class.getSimpleName());
            String dealDepts = data.getDealDepts();
            if (!StringHelper.isEmpty(dealDepts)) {
                String[] deptIds = dealDepts.split(",");
                for (String deptId : deptIds) {
                    Set<SysUser> deptLeader = getDeptLeader(deptId);
                    if (null != deptLeader && deptLeader.size() > 0) {
                        for (SysUser sysUser : deptLeader) {
                            managers.add(sysUser.getId());
                        }
                    }
                }
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaReceive.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
    }
}
