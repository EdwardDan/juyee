package com.justonetech.system.domain.mismenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供给门户网站的左侧菜单
 */
public class MisMenu {
    private String code;
    private String name;
    private String url;
    private List<MisMenu> childMenus;

    public MisMenu(String code, String name, String url) {
        this.code = code;
        this.name = name;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MisMenu> getChildMenus() {
        if(childMenus==null){
            childMenus = new ArrayList<MisMenu>();
        }
        return childMenus;
    }

    public void setChildMenus(List<MisMenu> childMenus) {
        this.childMenus = childMenus;
    }
}
