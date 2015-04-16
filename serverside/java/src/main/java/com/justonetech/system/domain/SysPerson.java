package com.justonetech.system.domain;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.domain.base.BaseSysPerson;

import java.util.Set;


public class SysPerson extends BaseSysPerson {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public SysPerson() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public SysPerson(java.lang.Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取单位部门名称(支持多个)
     *
     * @return 。
     */
    public SysDept getCompany() {
        SysDept company = null;
        SysDept dept = getDept();
        if (dept != null) {
            company = getParentCompany(dept);
        }
        return company;
    }

    private SysDept getParentCompany(SysDept dept) {
        if(dept.getIsTag() != null && dept.getIsTag()){
            return dept;
        }
        if (dept.getParent() != null) {
            return getParentCompany(dept.getParent());
        } else {
            return dept;
        }
    }

    /**
     * 获取单位名称
     * @return .
     */
    public String getCompanyName(){
        SysDept company = getCompany();
        if(company != null){
            return company.getName();
        }
        return "";
    }

    /**
     * 所属部门
     *
     * @return 。
     */
    public SysDept getDept() {
        Set<SysPersonDept> sysPersonDepts = getSysPersonDepts();
        if (sysPersonDepts.size() > 0) {
            SysPersonDept next = sysPersonDepts.iterator().next();
            return next.getDept();
        }
        return null;
    }

    /**
     * 获取单位名称
     * @return .
     */
    public String getDeptName(){
        SysDept dept = getDept();
        if(dept != null){
            return dept.getName();
        }
        return "";
    }

    /**
     * 获取人员与部门关联对象
     * @return 。
     */
    public SysPersonDept getPersonDept() {
        Set<SysPersonDept> sysPersonDepts = getSysPersonDepts();
        if (sysPersonDepts.size() > 0) {
            return sysPersonDepts.iterator().next();
        }
        return null;
    }

    /**
     * 获取人员职务信息
     * @return .
     */
    public String getPositionName(){
        SysPersonDept personDept = getPersonDept();
        if(personDept != null){
            return JspHelper.getString(personDept.getPosition());
        }
        return "";
    }
}