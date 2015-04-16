package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.SysDeptManager;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysPersonManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.manager.UserSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 流程缺省值
 */
@Service
public class BpmGetDefaultValueManager {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPersonManager sysPersonManager;

    @Autowired
    private UserSessionManager userSessionManager;

    @Autowired
    private SysDeptManager sysDeptManager;

    @Autowired
    private ProjectManager projectManager;

    /**
     * 获取缺省数据
     *
     * @return .
     */
    public Map getDefaultValueMap() {
        SysUser sysUser = userSessionManager.getLoginedUser();

        return getDefaultValueMap(sysUser);
    }

    /**
     * 获取缺省数据
     *
     * @param sysUser 用户 ---仅用于处理超时任务实例
     * @return .
     */
    public Map getDefaultValueMap(SysUser sysUser) {
        Map<String, Object> defaultValueMap = new HashMap<String, Object>();
        defaultValueMap.put("{currentDate}", DateTimeHelper.getCurrentDate());
        defaultValueMap.put("{currentPersonName}", "");
        defaultValueMap.put("{currentDepartmentName}", "");
        defaultValueMap.put("{currentUnitName}", "");

        defaultValueMap.put("{currentBjbh}", "");
        defaultValueMap.put("{currentProjectName}", "");
        defaultValueMap.put("{currentGdCode}", "");
        defaultValueMap.put("{currentGdName}", "");

        if (sysUser != null) {
            defaultValueMap.put("{currentPersonName}", sysUser.getDisplayName());

            //增加外网用户的缺省信息
            SysRegPerson regPerson = sysUser.getRegPerson();
            if (regPerson != null) {
                defaultValueMap.put("{currentPersonName}", regPerson.getPersonName());

                defaultValueMap.put("{currentUnitCode}", JspHelper.getString(regPerson.getUnitCode()));
                defaultValueMap.put("{currentUnitName}", JspHelper.getString(regPerson.getUnitName()));

                defaultValueMap.put("{currentBjbh}", JspHelper.getString(regPerson.getBjbh()));
                defaultValueMap.put("{currentProjectName}", JspHelper.getString(regPerson.getProjectName()));

                //获取工地信息
                if (!StringHelper.isEmpty(regPerson.getGdCode())) {
                    ShareGdInfo gdInfo = projectManager.getGDInfo(regPerson.getGdCode());
                    if (gdInfo != null) {
                        ShareProTobuild project = projectManager.getProject(gdInfo.getBjbh());
                        if (project != null) {
                            defaultValueMap.put("{currentBjbh}", project.getBjbh());
                            defaultValueMap.put("{currentProjectName}", project.getProjectName());
                        }
                        defaultValueMap.put("{currentGdCode}", regPerson.getGdCode());
                        defaultValueMap.put("{currentGdName}", gdInfo.getGdName());
                    }
                }
            }else{
                SysDept sysDept = sysPersonManager.getDeptByPersonId(sysUser.getPerson().getId());
                SysDept sysUnit = sysDeptManager.getSysUnitBySysDept(sysDept);
                if (sysDept != null) {
                    defaultValueMap.put("{currentDepartmentName}", sysDept.getName());
                }
                if (sysUnit != null) {
                    defaultValueMap.put("{currentUnitName}", sysUnit.getName());
                }
            }
        }
        return defaultValueMap;
    }

}
