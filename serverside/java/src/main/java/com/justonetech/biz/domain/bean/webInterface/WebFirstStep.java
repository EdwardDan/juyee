package com.justonetech.biz.domain.bean.webInterface;

import java.util.List;

/**
 * description: 项目审批--第1层（报建、施工图、报监、许可）
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebFirstStep {
    private Boolean need;               //是否需要做
    private Boolean complete;          //是否完成
    private List<WebOperation> child;  //操作状态

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
