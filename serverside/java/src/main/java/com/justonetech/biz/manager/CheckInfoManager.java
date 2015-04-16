package com.justonetech.biz.manager;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.daoservice.CheckInfoService;
import com.justonetech.biz.daoservice.CheckManagerPositionService;
import com.justonetech.biz.daoservice.CheckManagerService;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 考勤管理类
 * User: Chen Junping
 * Date: 12-10-12
 */
@Service
public class CheckInfoManager {
    private static Logger logger = LoggerFactory.getLogger(CheckInfoManager.class);

    @Autowired
    private CheckInfoService checkInfoService;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    @Autowired
    private CheckManagerService checkManagerService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;


    /**
     * 获取工地管理人员列表
     *
     * @param gdCode .
     * @return .
     */
    public List<CheckManager> getCheckManagerList(String gdCode) {
        List<CheckManager> managerList = new ArrayList<CheckManager>();
        String managerHql = "from CheckManagerPosition where gdCode='" + gdCode + "' and isValid=1 and isDelete=0";
        managerHql += " order by manager.name asc";
        List<CheckManagerPosition> managerPositionList = checkManagerPositionService.findByQuery(managerHql);
        for (CheckManagerPosition position : managerPositionList) {
            managerList.add(position.getManager());
        }
        return managerList;
    }

    /**
     * 获取当前用户的考勤信息过滤SQL
     * @return .
     */
    public String getCheckInfoFilterSql(){

        String conditionSql = "";
        //外网项目用户和工地用户只能查看本项目范围的记录
        SysRegPerson regPerson = regPersonManager.getRegPerson();
        if(regPerson != null){
//            String loginName = sysUserManager.getSysUser().getLoginName();

            String tmpSql = "and t1.flow_code in({0})";

//            String flowCodeHql = "select distinct f.flowCode from ProFlowCode f,ShareProDwgcMonitor dwgc" +
//                    " where dwgc.{0}UnitCode='{1}' and dwgc.jdrwsbh=f.jdTaskCode";
            String flowCodeHql = "select distinct f.flowCode from ExcelJdTasks f,ShareProDwgcMonitor dwgc" +
                    " where dwgc.{0}UnitCode='{1}' and dwgc.jdrwsbh=f.jdTaskCode";
            String typeCode = regPerson.getRegType().getCode();
            if(Constants.SYS_REGPERSON_TYPE_UNIT_SG.equals(typeCode) || Constants.SYS_REGPERSON_TYPE_UNIT_JL.equals(typeCode)){
                flowCodeHql = FormatUtils.format(flowCodeHql,typeCode,regPerson.getUnitCode());
                String flowCodes = "";
                Object[] list = simpleQueryManager.getObjectArrayByHql(flowCodeHql);
                if(list.length>0){
                    for (Object o : list) {
                        flowCodes += ",'"+o.toString()+"'";
                    }
                    flowCodes = flowCodes.substring(1);
                }else{
                    flowCodes = "'0'";
                }
                conditionSql = FormatUtils.format(tmpSql,flowCodes);

            }else if(Constants.SYS_REGPERSON_TYPE_UNIT_JS.equals(typeCode)){
//                flowCodeHql = "select flowCode from ProFlowCode where bjbh='" + regPersonManager.getBjbh(regPerson) + "'";
//                conditionSql = FormatUtils.format(tmpSql,flowCodeHql);
                conditionSql = " and t3.bjbh='" + regPersonManager.getBjbh(regPerson) + "'";

            }else{
                conditionSql += " and 1=2";      //todo 工地编号目前不允许按报建编号查看
            }
        }
        if(sysUserManager.getSysUser()==null){
            conditionSql += " and 1=2"; //未登录用户不允许查看任何记录
        }
        return conditionSql;
    }

}
