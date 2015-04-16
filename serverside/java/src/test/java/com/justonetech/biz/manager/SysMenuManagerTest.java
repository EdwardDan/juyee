package com.justonetech.biz.manager;

import com.justonetech.biz.utils.enums.Platform;
import com.justonetech.core.test.SpringTransactionalTestCase;
import com.justonetech.system.domain.SysMenu;
import com.justonetech.system.manager.SysMenuManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;
import java.util.Map;

/**
 * description:
 * User: Chenjp
 * Date: 14-3-24 上午10:29
 */
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
@TransactionConfiguration(defaultRollback = true)
public class SysMenuManagerTest extends SpringTransactionalTestCase {
    private static Logger logger = LoggerFactory.getLogger(SysMenuManagerTest.class);

    @Autowired
    private SysMenuManager sysMenuManager;

    public void testMethod1() {

        List<Map> newMenus = sysMenuManager.getNewMenus(Platform.PLATFORM_OA.getCode());
        for (Map newMenu : newMenus) {
            Object menu_1 = newMenu.get("menu");
            if(menu_1 != null){
                SysMenu menu1 = (SysMenu)menu_1;
                System.out.println("1 = " + menu1.getName());

                Object menus = newMenu.get("menuList");
                if(menus != null){
                    List<Map> menu1List = (List<Map>)menus;
                    System.out.println("menu1List.size() = " + menu1List.size());
                    for (Map map : menu1List) {
                        Object menu_2 = map.get("menu1");
                        if(menu_2 != null){
                            SysMenu menu2 = (SysMenu)menu_2;
                            System.out.println("  2 = " + menu2.getName());

                            Object menu2s = newMenu.get("menu1List");
                            if(menu2s != null){
                                List<Map> menu2List = (List<Map>)menu2s;
                                System.out.println("menu2List.size() = " + menu2List.size());
                                for (Map map1 : menu2List) {
                                    Object menu_3 = map1.get("menu2");
                                    if(menu_3 != null){
                                        SysMenu menu3 = (SysMenu)menu_3;
                                        System.out.println("           3 = " + menu3.getName());
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        logger.debug("ret = ");
    }
}