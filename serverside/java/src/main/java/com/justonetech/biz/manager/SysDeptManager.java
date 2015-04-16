package com.justonetech.biz.manager;

import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysPersonDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单位、部门
 */
@Service
public class SysDeptManager {
    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    /**
     * 获取单位部门名称(支持多个)
     *
     * @param dept .
     * @return company
     */
    public SysDept getSysUnitBySysDept(SysDept dept) {
        SysDept company = null;
        if (dept != null) {
            company = getParentCompany(dept);
        }
        return company;
    }

    private SysDept getParentCompany(SysDept dept) {
        if (dept.getParent() != null) {
            return getParentCompany(dept.getParent());
        } else {
            return dept;
        }
    }

    /**
     * 获取业主各科室部门
     * @return .
     */
    public List<SysDept> getOwnerDepts(){
        return sysDeptService.findByQuery("from SysDept where parent.code=? and isValid=1 order by orderNo asc", Constants.SYS_DEPT_OWNER);
    }

    /**
     * 获取业主各科室部门的科长
     * @return .
     */
    public Map<String,SysPerson> getDeptLeaderMap(){
        Map<String,SysPerson> map = new HashMap<String, SysPerson>();
        List<SysPersonDept> list = sysPersonDeptService.findByQuery("from SysPersonDept where dept.parent.code=? and dept.isValid=1 and isValid=1 and position=? order by orderNo asc", Constants.SYS_DEPT_OWNER,Constants.SYS_DEPT_LEADER_NAME);
        for (SysPersonDept sysPersonDept : list) {
            String deptName = sysPersonDept.getDept().getName();
            if(!map.containsKey(deptName)){
                map.put(deptName,sysPersonDept.getPerson());
            }
        }
        return map;
    }
}
