package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.daoservice.ProjRelateDeptService;
import com.justonetech.biz.daoservice.ProjRelatePersonService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.ProjRelateDept;
import com.justonetech.biz.domain.ProjRelatePerson;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * description: 项目关联的业务类
 */
@Service
public class ProjectRelateManager {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjRelateDeptService projRelateDeptService;

    @Autowired
    private ProjRelatePersonService projRelatePersonService;

    @Autowired
    private ProjExtendService projExtendService;

    /**
     * 获取当前用户所拥有的项目列表
     *
     * @return .
     */
    public List<ProjInfo> getRelateProjectList() {
        List<ProjInfo> ret = new ArrayList<ProjInfo>();
        SysUser sysUser = sysUserManager.getSysUser();
        SysPerson person = sysUser.getPerson();
        Set<ProjRelatePerson> relatePersons = person.getProjRelatePersons();
        if (relatePersons.size() > 0) {
            for (ProjRelatePerson relatePerson : relatePersons) {
                ret.add(relatePerson.getProject());
            }
        } else {
            Set<SysPersonDept> depts = person.getSysPersonDepts();
            for (SysPersonDept dept : depts) {
                Set<ProjRelateDept> relateDepts = dept.getDept().getProjRelateDepts();
                for (ProjRelateDept relateDept : relateDepts) {
                    ret.add(relateDept.getProject());
                }
            }
        }
        return ret;
    }

    /**
     * 获取当前用户所拥有的项目过滤HQL条件
     *
     * @param prefix .
     * @return .
     */
    public String getRelateProjectHql(String prefix) {
        String hql = "";
        SysUser sysUser = sysUserManager.getSysUser();
        SysPerson person = sysUser.getPerson();
        if (null != person) {
            Set<ProjRelatePerson> relatePersons = person.getProjRelatePersons();
            if (relatePersons.size() > 0) {
                hql = "and " + prefix + " in (select project.id from ProjRelatePerson where person.id=" + person.getId() + ")";

            } else {
                SysDept dept = person.getDept();
                if (dept != null) {
                    hql = "and " + prefix + " in (select project.id from ProjRelateDept where dept.id=" + dept.getId() + ")";
                }
            }
        }
        return hql;
    }

    /**
     * 获取当前用户所拥有的项目过滤HQL条件
     *
     * @param prefix .
     * @return .
     */
    public String getRelateProjectSql(String prefix) {
        String hql = "";
        SysUser sysUser = sysUserManager.getSysUser();
        SysPerson person = sysUser.getPerson();
        Set<ProjRelatePerson> relatePersons = person.getProjRelatePersons();
        if (relatePersons.size() > 0) {
            hql = "and " + prefix + " in (select project_id from Proj_Relate_Person where person_id=" + person.getId() + ")";

        } else {
            SysDept dept = person.getDept();
            if (dept != null) {
                hql = "and " + prefix + " in (select project_id from Proj_Relate_Dept where dept_id=" + dept.getId() + ")";
            }
        }
        return hql;
    }

    /**
     * 获取项目扩展信息
     *
     * @param projectId .
     * @return .
     */
    public ProjExtend getProjExtend(Long projectId) {
        List<ProjExtend> list = projExtendService.findByQuery("from ProjExtend where project.id=?", projectId);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }
}
