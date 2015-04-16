package com.justonetech.biz.utils.process.web;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-3-26
 * Time: 19:40:27
 * To change this template use File | Settings | File Templates.
 */
public class VmlHtml {

    private Long id;
    private Long pageID;
    private String path;
    private String onclick;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPageID() {
        return pageID;
    }

    public void setPageID(Long pageID) {
        this.pageID = pageID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }
}
