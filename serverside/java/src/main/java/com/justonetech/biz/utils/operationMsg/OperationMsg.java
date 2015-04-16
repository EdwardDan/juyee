package com.justonetech.biz.utils.operationMsg;

/**
 * 操作提示信息
 * User: Chen Junping
 * Date: 12-5-9
 */
public class OperationMsg {
    //提示类型：成功 or 失败
    private String msgType;

    //提示内容
    private String msg;

    //跳转地址
    private String url;

    //是否自动跳转--默认情况自动跳转
    private boolean isAutoJump;

    //是否刷新左边树节点
    private boolean isRefreshTree;

    //是否刷新子节点--用于添加操作
    //默认情况是刷新同层节点--用于修改操作
    private boolean isRefreshTreeChildren;

    //是否刷新父窗口页面
    private boolean isRefreshOpener;

    //弹出窗口返回值
    private String returnValue;

    //是否在弹出页面加载
    private boolean isLoadOpener = false;

    //是否需要关闭当前页面
    private boolean isNeedClose;

    //自定义js事件
    private String customEvent;

    //页面加载时执行自定义事件
    private boolean isQuickEvent;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAutoJump() {
        return isAutoJump;
    }

    public void setAutoJump(boolean autoJump) {
        isAutoJump = autoJump;
    }

    public boolean isRefreshTree() {
        return isRefreshTree;
    }

    public void setRefreshTree(boolean refreshTree) {
        isRefreshTree = refreshTree;
    }

    public boolean isRefreshTreeChildren() {
        return isRefreshTreeChildren;
    }

    public void setRefreshTreeChildren(boolean refreshTreeChildren) {
        isRefreshTreeChildren = refreshTreeChildren;
    }

    public boolean isRefreshOpener() {
        return isRefreshOpener;
    }

    public void setRefreshOpener(boolean refreshOpener) {
        isRefreshOpener = refreshOpener;
    }

    public boolean isNeedClose() {
        return isNeedClose;
    }

    public void setNeedClose(boolean needClose) {
        isNeedClose = needClose;
    }

    public boolean isLoadOpener() {
        return isLoadOpener;
    }

    public void setLoadOpener(boolean loadOpener) {
        isLoadOpener = loadOpener;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getCustomEvent() {
        return customEvent;
    }

    public void setCustomEvent(String customEvent) {
        this.customEvent = customEvent;
    }

    public boolean getIsQuickEvent() {
        return isQuickEvent;
    }

    public void setIsQuickEvent(boolean isQuickEvent) {
        this.isQuickEvent = isQuickEvent;
    }
}
