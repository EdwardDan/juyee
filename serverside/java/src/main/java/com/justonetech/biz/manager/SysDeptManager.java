package com.justonetech.biz.manager;

import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.domain.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
