package com.justonetech.system.manager;

import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysMenuService;
import com.justonetech.system.domain.SysMenu;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * </p>
 * User: <a href="mailto:hzxia2002@gmail.com">Jackie</a> Date: 2009-11-23 Time:
 * 23:40:36 Version: 1.0
 */
@Service
public class SysMenuManager {
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 取得所有的菜单，根据treeId进行排序
     *
     * @return
     */
    private List<SysMenu> getAllMenu() {
        String hql = "select t from SysMenu t where parent is null and isValid=1 order by treeId asc";

        return sysMenuService.findByQuery(hql);
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    public String getAllMenuJson() {

        //获取所有菜单
        return JSONArray.fromObject(getMenuList()).toString();
    }

    private List<Map<String, Object>> getMenuList() {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        List<SysMenu> list = getAllMenu();
        for (SysMenu menu : list) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("menuid", menu.getId() + "");
            map.put("menuname", menu.getName());
            map.put("icon", JspHelper.getString(menu.getIcon()));
            map.put("privilege", JspHelper.getString(menu.getPrivilege()));
            map.put("target", JspHelper.getString(menu.getTarget()));

            Set<SysMenu> children = menu.getSysMenus();
            if (children.size() > 0) {
                map.put("menus", getChildMenuList(children));
            } else {
                map.put("url", JspHelper.getString(menu.getUrl()));
            }
            ret.add(map);
        }
        return ret;
    }

    private List<Map<String, Object>> getChildMenuList(Set<SysMenu> children) {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        for (SysMenu menu : children) {
            if (!menu.getIsValid()) continue;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("menuid", menu.getId() + "");
            map.put("menuname", menu.getName());
            map.put("icon", JspHelper.getString(menu.getIcon()));
            map.put("privilege", JspHelper.getString(menu.getPrivilege()));
//            map.put("url", JspHelper.getString(menu.getUrl()));
            Set<SysMenu> nextChildren = menu.getSysMenus();
            if (nextChildren.size() > 0) {
                map.put("menus", getChildMenuList(nextChildren));
            } else {
                map.put("url", JspHelper.getString(menu.getUrl()));
                map.put("target", JspHelper.getString(menu.getTarget()));
            }

            ret.add(map);
        }
        return ret;
    }

    /**
     * 获取用户菜单--根据权限
     *
     * @param userId
     * @return
     */
    public String getUserMenuJson(Long userId) {
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

        Set<String> privileges = sysUserManager.getUserPrivilegeCodesCache(userId);
        List<Map<String, Object>> menuList = getMenuList();
        for (Map<String, Object> menuItem : menuList) {
            List<Map<String, Object>> childMenuItems = getChildMenuItem(menuItem, privileges);
            if (childMenuItems != null) {
                menuItem.put("menus", childMenuItems);
                retList.add(menuItem);
            } else if (privileges.contains(JspHelper.getString(menuItem.get("privilege")))) {
                menuItem.put("menus", "");
                retList.add(menuItem);
            }
        }
        return JSONArray.fromObject(retList).toString();
    }

    /**
     * 根据权限递归得到菜单结点的子结点
     *
     * @param menuItem     .
     * @param privilegeMap .
     * @return .
     */
    private List<Map<String, Object>> getChildMenuItem(Map<String, Object> menuItem, Set<String> privilegeMap) {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

        List<Map<String, Object>> itemList = (List<Map<String, Object>>) menuItem.get("menus");
        if (itemList != null) {
            for (Map<String, Object> item : itemList) {
                if (item.get("menus") != null) {
                    menuItem.put("menus", getChildMenuItem(item, privilegeMap));
                    ret.add(item);
                } else if (privilegeMap.contains(JspHelper.getString(item.get("privilege")))) {
                    item.put("menus", "");
                    ret.add(item);

                }
            }
        }

        if (ret.size() > 0) {
            return ret;
        } else {
            return null;
        }
    }
    /***************************新的div菜单******************************/
    public List<SysMenu> getNewAllMenus(String platform){
        //全部菜单
        List<SysMenu> list;
        if (!StringHelper.isEmpty(platform)) {
            list = sysMenuService.findByQuery("from SysMenu where isValid=1 and platform=? order by treeId asc",platform);
        }else{
            list = sysMenuService.findByQuery("from SysMenu where isValid=1 order by treeId asc");
        }
        return list;
    }
    /**
     * 获取用户菜单--仅显示有权限的菜单--新
     * @param platform .
     * @return .
     */
    public List<SysMenu> getNewUserMenus(String platform){
        //全部菜单
        List<SysMenu> list = getNewAllMenus(platform);

        //用户权限
        Set<String> privileges;
        BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
        if (loginUser != null) {
            privileges = sysUserManager.getUserPrivilegeCodesCache(loginUser.getId());
        }else{
            privileges = new HashSet<String>();
        }
//        System.out.println("privileges = " + privileges);

        //根据权限过滤菜单
        String loginName = sysUserManager.getSysUser().getLoginName();
        List<SysMenu> menus = new ArrayList<SysMenu>();
        for (SysMenu sysMenu : list) {
            if(privileges.contains(JspHelper.getString(sysMenu.getPrivilege()))){
                if (!StringHelper.isEmpty(sysMenu.getUrl())) {
                    sysMenu.setUrl(StringHelper.findAndReplace(sysMenu.getUrl(),"{loginName}",loginName));
                }
                menus.add(sysMenu);
            }
        }
        return menus;
    }

    /**
     * 左侧菜单--新
     * @param platform .
     * @return .
     */
    public List<Map> getNewMenus(String platform){
        List<Map> ret = new ArrayList<Map>();

        List<SysMenu> menus = getNewUserMenus(platform);

        //第1层菜单
        List<SysMenu> firstMenus = getFirstMenus(menus);

        Map<Long, List<SysMenu>> menuLevels = getMenuLevels(menus);
        for (SysMenu firstMenu : firstMenus) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("menu",firstMenu);
            map.put("pos", getPos(firstMenu));

            List<Map> menu1List = new ArrayList<Map>();
            List<SysMenu> childMenus = menuLevels.get(firstMenu.getId());
            if(childMenus != null){
                for (SysMenu childMenu : childMenus) {
                    Map<String,Object> map1 = new HashMap<String, Object>();
                    map1.put("menu1",childMenu);
                    map1.put("pos", getPos(childMenu));

                    List<SysMenu> menuLasts = menuLevels.get(childMenu.getId());
                    List<Map> menu2List = new ArrayList<Map>();
                    if(menuLasts != null){
                        for (SysMenu menuLast : menuLasts) {
                            Map<String,Object> map2 = new HashMap<String, Object>();
                            map2.put("menu2",menuLast);
                            map2.put("pos", getPos(menuLast));
                            menu2List.add(map2);
                        }
                    }else{
                        Map<String,Object> map2 = new HashMap<String, Object>();
                        map2.put("menu2",childMenu);
                        map2.put("pos", getPos(childMenu));
                        menu2List.add(map2);
                    }
                    map1.put("menu1List",menu2List);
                    menu1List.add(map1);
                }

            }else{
                Map<String,Object> map1 = new HashMap<String, Object>();
                map1.put("menu",firstMenu);
                map1.put("pos", getPos(firstMenu));
                menu1List.add(map1);
            }
            map.put("menuList",menu1List);
            ret.add(map);
        }
        return ret;
    }

    /**
     * 获取当前位置
     * @param menu .
     * @return .
     */
    public String getPos(SysMenu menu){
        if(menu.getParent() != null){
            return getPos(menu.getParent())+" > "+menu.getName();
        }else{
            return menu.getName();
        }
    }

    private List<SysMenu> getFirstMenus(List<SysMenu> menus){
        List<SysMenu> list = new ArrayList<SysMenu>();
        for (SysMenu menu : menus) {
            if(menu.getParent()==null){
                list.add(menu);
            }
        }
        return list;
    }

    private Map<Long,List<SysMenu>> getMenuLevels(List<SysMenu> menus){
        Map<Long,List<SysMenu>> hs = new HashMap<Long,List<SysMenu>>();
        for (SysMenu menu : menus) {
            if(menu.getParent()!=null){
                Long key = menu.getParent().getId();
                List<SysMenu> sysMenus = hs.get(key);
                if(sysMenus==null)sysMenus = new ArrayList<SysMenu>();
                sysMenus.add(menu);
                hs.put(key,sysMenus);
            }
        }
        return hs;
    }

    private static int treeidIncrease = 1;
    private static final String FORMAT_TYPE = "%05d";
    //获取后续treeId
    public String getNextTreeId(SysMenu parent){
        int nextTreeId = 1;
        if(parent != null){
            int maxId = 1;
            List<SysMenu> list = sysMenuService.findByQuery("from SysMenu where parent.id=" + parent.getId() + " order by treeId desc");
            if(list.size()>0){
                SysMenu next = list.iterator().next();
                String treeId = next.getTreeId();
                String[] ss = com.justonetech.core.utils.StringHelper.stringToStringArray(treeId, ".");
                String s = ss[ss.length - 1];
                maxId = Integer.parseInt(s);
            }
            String nextId = String.format(FORMAT_TYPE, maxId+treeidIncrease);
            return parent.getTreeId()+"."+nextId;
        }else{
            return String.format(FORMAT_TYPE, treeidIncrease);
        }
    }
}
