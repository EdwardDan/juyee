package com.justonetech.biz.domain.bean.webInterface;

import java.util.List;

/**
 * description: 项目审批--二级节点（受理步骤）
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebSecondStep {
    private String childName;  //子节点名称
    private Boolean need;       //是否需要做
    private Boolean complete;   //是否完成
    private List<WebOperation> child;      //受理操作

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
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

    public List<WebOperation> getChild() {
        return child;
    }

    public void setChild(List<WebOperation> child) {
        this.child = child;
    }
}
