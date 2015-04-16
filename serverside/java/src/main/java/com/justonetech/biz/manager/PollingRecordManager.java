package com.justonetech.biz.manager;

import com.justonetech.biz.domain.OrderFormDeployUser;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.PollingGroupUser;
import com.justonetech.biz.domain.PollingWorkGroup;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-3-28
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PollingRecordManager {
    private Logger logger = LoggerFactory.getLogger(PollingRecordManager.class);

    @Autowired
    SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 获取监督记录自动编号
     *
     * @return .
     */
    public String getNextPollingCode(String flowCode,String id) {
        //注意不能使用count，否则以前记录删除后生成的编号会有重复
        String sql = "select nvl(max(substr(t.POLLING_CODE,instr(t.polling_code,'-')+1)),0)+1 code from POLLING_RECORD t where t.POLLING_CODE is not null and t.flow_code='"+flowCode+"'";
        if(!StringHelper.isEmpty(id)){
            sql += "  and t.id<>"+id;
        }
        sql += " and instr(t.polling_code,'S')<=0";
//        System.out.println("sql = " + sql);
        Integer nextId = simpleQueryManager.getIntegerBySql(sql);
        return flowCode+"-"+StringHelper.leftPad(String.valueOf(nextId),3,"0");
    }
    /**
     * 获取监督组负责人集合
     *
     * @param users .
     * @return .
     */
    public Set<Long> getManagerIds(Set<OrderFormDeployUser> users) {
        Set<Long> list = new HashSet<Long>();
        for (OrderFormDeployUser user : users) {
//            if (user.getIsManager() != null && user.getIsManager()) {
                SysUser sysUser = user.getUser();
                if (Constants.FLAG_TRUE.equals(sysUser.getStatus())) {
                    list.add(sysUser.getId());
                }
//            }
        }
        return list;
    }

    /**
     * 获取监督组负责人集合
     *
     * @param group .
     * @return .
     */
    public Set<Long> getGroupManagers(PollingWorkGroup group) {
        Set<Long> list = new HashSet<Long>();
        Set<PollingGroupUser> users = group.getPollingGroupUsers();
        for (PollingGroupUser user : users) {
            if (user.getIsCharge() != null && user.getIsCharge()) {
                SysUser sysUser = user.getUser();
                if (Constants.FLAG_TRUE.equals(sysUser.getStatus())) {
                    list.add(sysUser.getId());
                }
            }
        }
        return list;
    }

    /**
     * 根据监督计划类型编码获取监督记录类型
     *
     * @param typeCode 监督计划类型编码
     * @return 监督记录类型
     */
    public SysCodeDetail getFormClassData(String typeCode) {
        SysCodeDetail formClassData = null;
        if (Constants.PLAN_MAIN_INFO_TYPE_SAFE.equals(typeCode)) {
            formClassData = sysCodeManager.getCodeDetailByCode(Constants.POLLING_FORM_CLASS, Constants.POLLING_FORM_CLASS_SAFE);
        } else if (Constants.PLAN_MAIN_INFO_TYPE_QUALITY.equals(typeCode)) {
            formClassData = sysCodeManager.getCodeDetailByCode(Constants.POLLING_FORM_CLASS, Constants.POLLING_FORM_CLASS_QUALITY);
        }else{  //默认为质量计划
            formClassData = sysCodeManager.getCodeDetailByCode(Constants.POLLING_FORM_CLASS, Constants.POLLING_FORM_CLASS_QUALITY);
        }
        return formClassData;
    }

    /**
     * 根据类型id获取权限编码的前缀
     *
     * @param formClass .
     * @return .
     */
    public String getPrivilegePrefix(Long formClass) {
        SysCodeDetail codeListById = sysCodeManager.getCodeListById(formClass);
        return getPrivilegePrefix(codeListById.getCode());
    }
    public String getPrivilegePrefix(String flag) {
        if (Constants.POLLING_FORM_CLASS_SAFE.equals(flag)) {
            return PrivilegeCode.POLLING_PREFIX_SAFE;
        } else {
            return PrivilegeCode.POLLING_PREFIX_QUALITY;
        }
    }
}
