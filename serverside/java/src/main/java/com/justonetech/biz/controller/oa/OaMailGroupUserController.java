package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMailGroupService;
import com.justonetech.biz.daoservice.OaMailGroupUserService;
import com.justonetech.biz.domain.OaMailGroup;
import com.justonetech.biz.domain.OaMailGroupUser;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysDeptService;
import com.justonetech.system.daoservice.SysPersonDeptService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysPersonDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:邮件分组用户
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaMailGroupUserController extends BaseCRUDActionController<OaMailGroupUser> {
    private Logger logger = LoggerFactory.getLogger(OaMailGroupUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private OaMailGroupUserService oaMailGroupUserService;

    @Autowired
    private OaMailGroupService oaMailGroupService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysPersonDeptService sysPersonDeptService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String tabNo) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", true);
        model.addAttribute("tabNo", tabNo);

        //获取我的通讯录分组
        String userName = "";
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            userName = loginUser.getLoginName();
        }
        model.addAttribute("groups", oaMailGroupService.findByQuery("from OaMailGroup where createUser=? order by id asc", userName));

        //获取科室列表
        model.addAttribute("depts", sysDeptService.findByQuery("from SysDept where parent.id is not null and parent.code=? order by orderNo asc,id asc", Constants.SYS_DEPT_OWNER));

        return "view/oa/oaMailGroupUser/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String deptId, String groupId, HttpSession session) {
        try {
            //分组显示（过滤当前用户的分组：改在SysUser.java中）
//            String userName = "";
//            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
//            if (loginUser != null) {
//                userName = loginUser.getLoginName();
//            }
//            Map<Long, String> existMap = new HashMap<Long, String>();
//            List<OaMailGroupUser> users = oaMailGroupUserService.findByQuery("from OaMailGroupUser where group.createUser=? order by id asc", userName);
//            for (OaMailGroupUser user : users) {
//                existMap.put(user.getUser().getId(), user.getGroup().getName());
//            }

            Page pageModel = new Page(page, rows, true);

            String hql = "from SysUser where id in(select distinct s.id from SysUser s" +
                    " left join s.oaMailGroupUsers m" +
                    " left join s.person.sysPersonDepts d" +
                    " where s.regPerson is null and d.dept.parent.code='"+Constants.SYS_DEPT_OWNER+"'";
            if (!StringHelper.isEmpty(deptId)) {
                hql += " and d.dept.id=" + deptId;
            }
            if (!StringHelper.isEmpty(groupId)) {
                hql += " and m.group.id=" + groupId;
            }
            hql += ")";
            hql += " order by person.name asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = sysUserService.findByPage(pageModel, query);
//            System.out.println("hql = " + queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 加入分组的保存操作
     *
     * @param response .
     * @param groupId  .
     * @param userIds  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, Long groupId, String userIds) throws Exception {
        try {
            if (!StringHelper.isEmpty(userIds)) {
                String userName = "";
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                if (loginUser != null) {
                    userName = loginUser.getLoginName();
                }

                String tempHql = "from OaMailGroupUser where group.createUser='{0}' and user.id={1} and group.id={2}";
                String[] ss = StringHelper.stringToStringArray(userIds, ",");
                for (String s : ss) {
                    String hql = FormatUtils.format(tempHql, userName, s, String.valueOf(groupId));
                    if (oaMailGroupUserService.findByQuery(hql).size() == 0) {
                        OaMailGroupUser data = new OaMailGroupUser();
                        data.setGroup(oaMailGroupService.get(groupId));
                        data.setUser(sysUserService.get(Long.valueOf(s)));
                        oaMailGroupUserService.save(data);
                    }
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "加入成功");
    }

    /**
     * 从组中删除的操作
     *
     * @param response .
     * @param userId   .
     * @param groupId  .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, String groupId, String userId) throws Exception {
        String userName = "";
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            userName = loginUser.getLoginName();
        }

        String hql = "from OaMailGroupUser where user.id in({0}) and group.createUser='{1}'";
        hql = FormatUtils.format(hql, userId, userName);
        if (!StringHelper.isEmpty(groupId)) {
            hql += " and group.id=" + groupId;
        }
//        System.out.println("hql = " + hql);
        List<OaMailGroupUser> list = oaMailGroupUserService.findByQuery(hql);
        for (OaMailGroupUser oaMailGroupUser : list) {
            oaMailGroupUserService.delete(oaMailGroupUser);
        }
        sendSuccessJSON(response, "移除成功");
    }

    /**
     * ***************************选择用户*******************************
     */
    @RequestMapping
    public String select(Model model, String objId, String objName, String tabNo) {
        String userName = "";
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            userName = loginUser.getLoginName();
        }

        //已分组用户
        Map<Long, String> userMap = new HashMap<Long, String>();
        Map<Long, List<SysUser>> groupMap = new HashMap<Long, List<SysUser>>();

        List<OaMailGroupUser> groupUsers = oaMailGroupUserService.findByQuery("from OaMailGroupUser where group.createUser=? order by user.person.id asc", userName);
        for (OaMailGroupUser groupUser : groupUsers) {
            //系统用户
            SysUser sysUser = groupUser.getUser();
            userMap.put(sysUser.getId(), groupUser.getGroup().getName());

            //分组用户
            Long groupId = groupUser.getGroup().getId();
            List<SysUser> userList = groupMap.get(groupId);
            if (userList == null) {
                userList = new ArrayList<SysUser>();
            }
            userList.add(sysUser);
            groupMap.put(groupId, userList);
        }

        //获取我的通讯录分组
        List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();
        List<OaMailGroup> groups = oaMailGroupService.findByQuery("from OaMailGroup where createUser=? order by id asc", userName);
        for (OaMailGroup group : groups) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("group", group);
            List<SysUser> sysUsers = groupMap.get(group.getId());
            if (sysUsers == null) {
                sysUsers = new ArrayList<SysUser>();
            }
            map.put("userList", sysUsers);
            groupList.add(map);
        }
        model.addAttribute("groups", groupList);

        //获取科室下所有用户列表
        Map<Long, List<SysUser>> deptMap = new HashMap<Long, List<SysUser>>();
        List<SysPersonDept> sysPersonDepts = sysPersonDeptService.findByQuery("from SysPersonDept where dept.parent.id is not null and dept.parent.code=? order by dept.id asc,orderNo asc", Constants.SYS_DEPT_OWNER);
        for (SysPersonDept sysPersonDept : sysPersonDepts) {
            Long deptId = sysPersonDept.getDept().getId();
            List<SysUser> deptUserList = deptMap.get(deptId);
            if (deptUserList == null) {
                deptUserList = new ArrayList<SysUser>();
            }
            deptUserList.addAll(sysPersonDept.getPerson().getSysUsers());
            deptMap.put(deptId, deptUserList);
        }

        //获取科室列表
        List<Map<String, Object>> deptList = new ArrayList<Map<String, Object>>();
        List<SysDept> depts = sysDeptService.findByQuery("from SysDept where parent.id is not null and parent.code=? order by orderNo asc,id asc", Constants.SYS_DEPT_OWNER);
        for (SysDept dept : depts) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("dept", dept);
            List<SysUser> sysUsers = deptMap.get(dept.getId());
            if (sysUsers == null) {
                sysUsers = new ArrayList<SysUser>();
            }
            map.put("userList", sysUsers);
            deptList.add(map);
        }
        model.addAttribute("depts", deptList);

        //系统用户
        String hql = "select s from SysUser s" +
//                " left join s.oaMailGroupUsers m" +
//                " left join s.person.sysPersonDepts d" +
                " where s.regPerson is null";
        hql += " order by s.person.name asc";
        List<SysUser> users = sysUserService.findByQuery(hql);
        model.addAttribute("users", users);

        //用于回写
        model.addAttribute("objId", objId);
        model.addAttribute("objName", objName);
        model.addAttribute("tabNo", tabNo);

        //外部用户
        String hqlReg = "select s from SysUser s where s.regPerson is not null order by s.regPerson.regType.name asc,s.regPerson.unitName asc,s.loginName asc";
        List<SysUser> regPersons = sysUserService.findByQuery(hqlReg);
        model.addAttribute("regs", regPersons);

        return "view/oa/oaMailGroupUser/select";
    }

    /**
     * 获取选中的用户ID
     *
     * @param model .
     * @param type  .
     * @param ids   .
     * @return .
     */
    @RequestMapping
    public String getSelectIds(Model model, String type, String ids) {
        String objIds = "";
        String objNames = "";

        if ("user".equals(type) || "regPerson".equals(type)) {   //用户(或注册用户)
            objIds = ids;
            objNames = sysUserManager.getSysUserNames(StringHelper.stringToStringArray(ids, ","));

        } else if ("dept".equals(type)) {   //科室
            String hql = "select s from SysUser s left join s.person.sysPersonDepts d where d.dept.id in(" + ids + ")";
            List<SysUser> list = sysUserService.findByQuery(hql);
            for (SysUser sysUser : list) {
                objIds += "," + sysUser.getId();
                objNames += "," + sysUser.getDisplayName();
            }
        } else if ("group".equals(type)) {   //分组
            String hql = "select s.user from OaMailGroupUser s where s.group.id in(" + ids + ")";
            List<SysUser> list = sysUserService.findByQuery(hql);
            for (SysUser sysUser : list) {
                objIds += "," + sysUser.getId();
                objNames += "," + sysUser.getDisplayName();
            }
        }
        if (!"".equals(objIds)) {
            objIds = objIds.substring(1);
        }
        if (!"".equals(objNames)) {
            objNames = objNames.substring(1);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("ids", objIds);
        map.put("names", objNames);
        model.addAttribute("msg", JSONObject.fromObject(map).toString());
        return "common/msg";
    }
}