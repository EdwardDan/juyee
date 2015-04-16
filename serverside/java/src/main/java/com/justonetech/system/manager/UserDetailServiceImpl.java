package com.justonetech.system.manager;

import com.justonetech.core.security.privilege.Privilege;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.webservice.security.WSUserService;
import com.justonetech.biz.manager.NetAuthManager;
import com.justonetech.system.domain.SysPrivilege;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.utils.UserSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

/**
 *
 * Project:shmpi-mis
 *
 * <p>
 * 用户详细信息获取实现类
 * </p>
 * Create On 2009-5-11 上午10:24:38
 *
 * @author <a href="mailto:hzxia2002@gmail.com">Jackie</a>
 * @version 1.0
 *
 */
public class UserDetailServiceImpl implements UserDetailsService, WSUserService {
	private UserManager userManager;
	private NetAuthManager netAuthManager;

	/**
	 * 设置service
	 *
	 * @param userManager
	 *            UserManager
	 */
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * 取得service
	 *
	 * @return UserManager
	 */
	public UserManager getUserManager() {
		return this.userManager;
	}

    @Autowired
    public void setNetAuthManager(NetAuthManager netAuthManager) {
        this.netAuthManager = netAuthManager;
    }
    public NetAuthManager getNetAuthManager() {
        return netAuthManager;
    }

    /**
	 * 用户详细信息获取实现
	 *
	 * @param userName
	 *            用户名
	 * @return UserDetails接口
	 * @throws UsernameNotFoundException
	 *             UsernameNotFoundException
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	public UserDetails loadUserBySysUser(String userName)
			throws UsernameNotFoundException, DataAccessException {
		List<SysUser> userList = userManager.findByProperty("loginName",
				userName);

		if (userList == null || userList.size() <= 0) {
			throw new UsernameNotFoundException("用户[<font color='red'>"
					+ userName + "</font>]不存在");
		}

		SysUser user = userList.get(0);

		if (UserSessionUtils.getInstance().isUserInvalid(user)) {
			throw new UsernameNotFoundException("用户[<font color='red'>"
					+ userName + "</font>]已经无效!");
		} else if(UserSessionUtils.getInstance().isUserLocked(user)) {
            throw new UsernameNotFoundException("用户[<font color='red'>"
                    + userName + "</font>]已经锁定!");
        }

		// 取得用户所拥有的权限
		Set<GrantedAuthority> authsList = new HashSet<GrantedAuthority>();

		authsList.add(new GrantedAuthorityImpl("ROLE_USER"));

		Map<String, Privilege> set = new HashMap<String, Privilege>();

		// 取得用户的特权
		List<SysPrivilege> privileges = userManager
				.getUserPrivileges(user, "0");

		if (privileges != null && privileges.size() > 0) {
			for (SysPrivilege tmp : privileges) {
				set.put(tmp.getCode(), tmp);
			}
		}

		// 取得用户的角色权限
		List<SysPrivilege> rolePrivileges = userManager.getUserRolePrivileges(
				user, "1");

		if (rolePrivileges != null && rolePrivileges.size() > 0) {
			for (SysPrivilege tmp : rolePrivileges) {
				set.put(tmp.getCode(), tmp);
			}
		}

		BaseUser userdetail = new BaseUser(user.getId(), user.getDisplayName(),
				user.getLoginName(), user.getPassword(), true, true, true,
				        true,
                authsList.toArray(new GrantedAuthority[authsList.size()]), set);

        userdetail.setLoginName(user.getLoginName());
        userdetail.setLoginTime(new Date());
        userdetail.setIdCard(userManager.USERTYPE_SYS);

		return userdetail;
	}

    /**
     * 用户验证
     *
     * @param multiParam .
     * @return .
     * @throws UsernameNotFoundException
     * @throws DataAccessException
     */
    public UserDetails loadUserByUsername(String multiParam) throws UsernameNotFoundException, DataAccessException {
        System.out.println("multiParam = " + multiParam);
        multiParam = JspHelper.getString(multiParam);

        //系统用户校验
        String[] ss = StringHelper.stringToStringArray(multiParam, "|");
        if (ss.length <2 && netAuthManager.isSysUser(multiParam)) {
            return loadUserBySysUser(multiParam);
        }
        if (ss.length < 2) {
            throw new UsernameNotFoundException("账号和密码输入有误！");
        }

        String userName = ss[0];
        Map netUserData = netAuthManager.getNetUserData(userName, ss[1]);
        System.out.println("netUserData = " + netUserData);
        if (netUserData == null) {
            throw new UsernameNotFoundException("账号和密码不匹配！");
        }
        String pass = JspHelper.getString(netUserData.get("Password"));
        String RealName = JspHelper.getString(netUserData.get("RealName"));

        // 取得用户所拥有的权限
        Set<GrantedAuthority> authsList = new HashSet<GrantedAuthority>();
        authsList.add(new GrantedAuthorityImpl("ROLE_USER"));

        Map<String, Privilege> set = new HashMap<String, Privilege>();
        List<SysPrivilege> netProjectPrivileges = netAuthManager.getNetProjectPrivileges();
//        System.out.println("getNetProjectPrivileges.size() = " + netProjectPrivileges.size());
        if (netProjectPrivileges.size() > 0) {
            for (SysPrivilege tmp : netProjectPrivileges) {
                set.put(tmp.getCode(), tmp);
            }
        }

        BaseUser userdetail = new BaseUser(
                userName, pass, true, true, true,
                true,
                authsList.toArray(new GrantedAuthority[authsList.size()]));
        userdetail.setLoginName(userName);
        userdetail.setRealName(RealName);
        userdetail.setPassword(pass);
        userdetail.setIdCard(userManager.USERTYPE_NET);
        userdetail.setPrivilegeList(set);
        userdetail.setLoginTime(new Date());
        return userdetail;
    }

    /**
     * 取得Web Service访问用户的详细信息
     *
     * @param username 。
     * @return 。
     */
    public BaseUser getUser(String username) {
        return (BaseUser)loadUserByUsername(username);
    }
}