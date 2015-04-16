package com.justonetech.biz.manager;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.domain.ShareUnitInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册管理
 */
@Service
public class RegPersonManager {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private SysRegPersonService sysRegPersonService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    //获取项目名称或企业名称
    public String getRegName(String income, String regType) {
        if (regType.equals(Constants.SYS_REGPERSON_TYPE_Gd)) {
            ShareGdInfo gd = projectManager.getGDInfo(income);
            if (gd != null) {
                return gd.getGdName();
            }
        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
            ShareProTobuild pro = projectManager.getProject(income);
            if (pro != null) {
                return pro.getProjectName();
            }
        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG) || regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL)) {
            ShareUnitInfo unit = projectManager.getUnitInfo(income.split(",")[0]);
            ShareProTobuild pro = projectManager.getProject(income.split(",")[1]);
            if (unit != null && null != pro) {
                return unit.getUnitName();
            }
        }
        return null;
    }

    //根据注册类型和编号在注册人员表获取相应的信息。
    public List<SysRegPerson> getRegPerson(String income, String regType) {
        List<SysRegPerson> sysRegPersons = null;
        if (regType.equals(Constants.SYS_REGPERSON_TYPE_Gd)) {
            sysRegPersons = sysRegPersonService.findByProperty("gdCode", income);
        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
            sysRegPersons = sysRegPersonService.findByProperty("bjbh", income);
        } else if (regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG) || regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL)) {
            String sql = "from SysRegPerson where unitCode=? and bjbh=?";
            sysRegPersons = sysRegPersonService.findByQuery(sql, income.split(",")[0], income.split(",")[1]);
        }
        return sysRegPersons;
    }


    //是否已注册
    public String isReg(String loginName, String regType) {
        String name = getRegName(loginName, regType);
        String msg = "用户已经注册!!";
        List<SysRegPerson> sysRegPersons = getRegPerson(loginName, regType);
        if (sysRegPersons != null && sysRegPersons.size() > 0) {
            return msg;
        }

        SysUser sysUser = sysUserService.findUniqueByProperty("loginName", loginName);
        if (sysUser == null) {
            if (name != null) {
                return name;
            } else {
                return "未找到有效编号!!";
            }
        } else {
            return msg;
        }
    }

    //通过注册表用户获取状态
    public String getAcceptOption(SysRegPerson sysRegPerson) {
        String acceptOption = "未受理";
        if (sysRegPerson != null) {
            if (sysRegPerson.getAcceptOpinion() == 2) {
                acceptOption = "未通过";
            } else if (sysRegPerson.getAcceptOpinion() == 1) {
                acceptOption = "已通过";
            }
        }
        return acceptOption;
    }

    /**
     * 获取当前外网用户的工地编号
     *
     * @return .
     */
    public String getGdCode() {
        SysUser sysUser = sysUserManager.getSysUser();
        SysRegPerson regPerson = sysUser.getRegPerson();
        if (regPerson != null) {
            if (regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_Gd)) {
                return regPerson.getGdCode();
            }
        }
        return "";
    }

    /**
     * 获取当前外网用户的报建编号
     *
     * @param regPerson .
     * @return .
     */
    public String getBjbh(SysRegPerson regPerson) {
        if (regPerson != null) {
            if (regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_Gd) || regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG) || regPerson.getRegType().getCode().equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
                return regPerson.getBjbh();
            }
        }
        return "";
    }

    public String getBjbh() {
        return getBjbh(getRegPerson());
    }


    /**
     * 根据相关编号获取外网用户
     *
     * @param code .
     * @return .
     */
    public SysRegPerson getRegPerson(String code) {
        SysRegPerson sysRegPerson = null;
        SysUser sysUser = sysUserManager.getSysUser(code);
        if (sysUser != null) {
            sysRegPerson = sysUser.getRegPerson();
        }
        return sysRegPerson;
    }

    public SysRegPerson getRegPerson() {
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            return getRegPerson(sysUser.getLoginName());
        }
        return null;
    }

    /**
     * 是否施工单位用户
     *
     * @return .
     */
    public Boolean isSGUser(String bjbh) {
        return isAppointUser(Constants.SYS_REGPERSON_TYPE_UNIT_SG, bjbh);
    }

    /**
     * 是否监理单位用户
     *
     * @return .
     */
    public Boolean isJLUser(String bjbh) {
        return isAppointUser(Constants.SYS_REGPERSON_TYPE_UNIT_JL, bjbh);
    }

    private Boolean isAppointUser(String regTypeCode, String bjbh) {
        Boolean isAppoint = false;
        SysRegPerson regPerson = getRegPerson();
        if (regPerson != null && !StringHelper.isEmpty(bjbh)) {
            return (regTypeCode.equals(regPerson.getRegType().getCode()) && bjbh.equals(regPerson.getBjbh()));
        }
        return isAppoint;
    }

    //获取监督任务书编号
    public List<String> getJdTaskCodes() {
        List<String> ret = new ArrayList<String>();
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            SysRegPerson regPerson = sysUser.getRegPerson();
            if (regPerson != null) {
                String code = regPerson.getRegType().getCode();
                if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(code) || Constants.SYS_REGPERSON_TYPE_UNIT_JL.equals(code)) {
                    if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(code)) {
                        code = "sgzb";
                    }
                    String sql = "select distinct t.jd_task_code from excel_jd_tasks t,Share_Gd_Info g where t.{0}_unit_name like '{1}%' and t.bjbh=g.bjbh and g.gd_Status_Code in (" + projectManager.GD_STATUS_CODE_MONITORING + ")";
                    sql = FormatUtils.format(sql, code, JspHelper.getString(regPerson.getUnitName()).trim());
                    List list = simpleQueryManager.getListBySql(sql);
                    for (Object o : list) {
                        ret.add(JspHelper.getString(o));
                    }
                } else if (Constants.SYS_REGPERSON_TYPE_UNIT_JS.equals(code)) {
                    ret.add(regPerson.getBjbh());
                }
            }
        }
        return ret;
    }

    //获取报建编号
    public List<String> getBjbhs() {
        List<String> ret = new ArrayList<String>();
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            SysRegPerson regPerson = sysUser.getRegPerson();
            String bjbh = getBjbh(regPerson);
            if (regPerson != null) {
                String code = regPerson.getRegType().getCode();
                if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(code) || Constants.SYS_REGPERSON_TYPE_UNIT_JL.equals(code)) {
                    if (Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(code)) {
                        code = "sgzb";
                    }
                    String sql = "select distinct t.bjbh from excel_jd_tasks t,Share_Gd_Info g where " +
                            " t.{0}_unit_name like '{1}%' and t.bjbh=g.bjbh " +
                            " and g.gd_Status_Code in (" + projectManager.GD_STATUS_CODE_MONITORING + ") ";
                    if (!StringHelper.isEmpty(bjbh))
                        sql += " and t.bjbh='" + bjbh + "' ";
                    sql = FormatUtils.format(sql, code, JspHelper.getString(regPerson.getUnitName()).trim());
                    List list = simpleQueryManager.getListBySql(sql);
                    for (Object o : list) {
                        ret.add(JspHelper.getString(o));
                    }
                } else if (Constants.SYS_REGPERSON_TYPE_UNIT_JS.equals(code)) {
                    ret.add(regPerson.getBjbh());
                }
            }
        }
        return ret;
    }

    public SysRegPerson getSysRegPersonByBjbh(String bjbh) {
        SysRegPerson sysRegPerson = null;
        if (null != bjbh) {
            String hql = "select  r from SysRegPerson r,JdStopOrder s where  r.bjbh=s.bjbh and s.bjbh='" + bjbh + "'";
            List<SysRegPerson> list = sysRegPersonService.findByQuery(hql);
            if (list.size() > 0) {
                sysRegPerson = list.iterator().next();
            } else {
                return null;
            }
        }
        return sysRegPerson;
    }

//    public SysRegPerson getSysRegPersonByJdTypeCode(String jdTypeCode){
//        SysRegPerson sysRegPerson = null;
//        ShareGdInfo shareGdInfo=null;
//        if(null!=jdTypeCode){
//            String sql = "select  g from excel_jd_tasks t,Share_Gd_Info g where t.bjbh=g.bjbh  and t.jd_task_code='{0}'";
//            sql = FormatUtils.format(sql, jdTypeCode);
//
//            List<ShareGdInfo> gdInfoList  = simpleQueryManager.getListBySql(sql);
//            if(gdInfoList.size()>0) {
//                shareGdInfo = gdInfoList.iterator().next();
//            }
//
//            String hql = "from SysRegPerson  where unitCode='{0}'";
//            if (null!=shareGdInfo) {
//                hql=FormatUtils.format(hql, shareGdInfo.getSgTotalUnitCode());
//            }
//            List<SysRegPerson> list = sysRegPersonService.findByQuery(hql);
//            if(list.size()>0) {
//                sysRegPerson = list.iterator().next();
//            }else {
//                return null;
//            }
//        }
//        return sysRegPerson;
//    }


    //返回sql过滤条件 (报建编号)
    public String getJdBjbhCondition() {
        String bjbhCon = "";
        List<String> bjbhs = getBjbhs();
        if (bjbhs.size() > 0) {
            for (String bjbh : bjbhs) {
                bjbhCon += ",'" + bjbh + "'";
            }
            if (!StringHelper.isEmpty(bjbhCon)) {
                bjbhCon = bjbhCon.substring(1);
            }
        } else {
            bjbhCon = "''";
        }

        return bjbhCon;
    }


}
