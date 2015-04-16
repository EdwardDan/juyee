package com.justonetech.biz.domain.bean.webInterface;

import java.util.List;

/**
 * description: 项目审批--承发包
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebCfb {
    private String type;                //节点类型（施工sg、监理jl、勘察kc、设计sj）
    private String bidMethod;          //发包方式（招标、直接发包）
    private Boolean need;               //是否需要做
    private Boolean complete;          //是否完成
    private List<WebCfbFb> children;   //分包数据

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getNeed() {
        return need;
    }

    public void setNeed(Boolean need) {
        this.need = need;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getBidMethod() {
        return bidMethod;
    }

    public void setBidMethod(String bidMethod) {
        this.bidMethod = bidMethod;
    }

    public List<WebCfbFb> getChildren() {
        return children;
    }

    public void setChildren(List<WebCfbFb> children) {
        this.children = children;
    }
}
