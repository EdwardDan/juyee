package com.justonetech.system.utils;

import com.justonetech.core.utils.Constant;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.*;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Project:bcscmis
 * <p/>
 * <p>
 * 数据授权处理工具类
 * </p>
 * <p/>
 * Create On 2010-1-17 下午11:40:43
 *
 * @author <a href="mailto:hzxia2002@gmail.com">XiaHongzhong</a>
 * @version 1.0
 */
public class PrivilegeUtils {
    /**
     * 取得项目数据授权过滤条件
     *
     * @param prefix
     * @return 过滤条件
     */
    public static String getProjectCondition(String prefix) {
        boolean isTag0 = false;
        boolean isTag1 = false;

        SysUser loginUser = UserSessionUtils.getInstance().getLoginedUser();

        Iterator<SysUserRole> roles = null; //loginUser.getSysUserRoles().iterator();

        // 根据角色名称进行判断
        while (roles.hasNext()) {
            SysRole role = roles.next().getRole();
            String code = StringUtils.defaultIfEmpty(role.getCode(), "");

            if (code.equals(Constant.ROLE_PROJECT_TAG_0)) {
                isTag0 = true;
            } else if (code.equals(Constant.ROLE_PROJECT_TAG_1)) {
                isTag1 = true;
            }
        }

        if (isTag0 && isTag1) {
            return " ";
        } else if (isTag0) {
            return " and " + prefix + ".isTag = 0 ";
        } else if (isTag1) {
            return " and " + prefix + ".isTag = 1 ";
        } else {
            return " and 1<>1 ";
        }
    }

    /**
     * 取得项目数据授权过滤条件
     *
     * @return 过滤条件
     */
    public static String getProjectCondition() {
        return getProjectCondition("");
    }

    /**
     * 将权限List转成Map
     *
     * @param list 权限List
     * @return 权限Map
     */
    public static Map<Long, SysPrivilege> listToMap(List<SysPrivilege> list) {
        Map<Long, SysPrivilege> ret = new HashMap<Long, SysPrivilege>();

        if (list != null && list.size() > 0) {
            for (SysPrivilege bean : list) {
                ret.put(bean.getId(), bean);
            }
        }

        return ret;
    }

    /**
     * 将权限List转成Map
     *
     * @param list 权限List
     * @return 权限Map
     */
    public static Map<Long, SysUserPrivilege> userPrivilegeListToMap(
            List<SysUserPrivilege> list) {
        Map<Long, SysUserPrivilege> ret = new HashMap<Long, SysUserPrivilege>();

        if (list != null && list.size() > 0) {
            for (SysUserPrivilege bean : list) {
                ret.put(bean.getPrivilege().getId(), bean);
            }
        }

        return ret;
    }

    private static final int treeidIncrease = 1;
    private static final String FORMAT_TYPE = "%05d";

    //获取后续treeId
    public static String getNextTreeId(String parentTreeId,String maxTreeId){
        int maxId = 0;
        if (!StringHelper.isEmpty(maxTreeId)) {
            String[] ss = com.justonetech.core.utils.StringHelper.stringToStringArray(maxTreeId, ".");
            String s = ss[ss.length - 1];
            maxId = Integer.parseInt(s);
        }
        String nextId = String.format(FORMAT_TYPE, maxId+treeidIncrease);
        if(parentTreeId != null){
            return parentTreeId+"."+nextId;
        }else{
            return nextId;
        }
    }
}
