package com.justonetech.biz.domain.bean.webInterface;

/**
 * description: 项目审批--承发包分包信息
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebCfbFb {
    private String childName;   //分包名称
    private String childTime;  //分包时间
    private Long childId;      //分包ID
    private String bizCode;    //业务编码
    private String bidMethod;  //发包方式（public公开招标，direct直接发包）

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildTime() {
        return childTime;
    }

    public void setChildTime(String childTime) {
        this.childTime = childTime;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBidMethod() {
        return bidMethod;
    }

    public void setBidMethod(String bidMethod) {
        this.bidMethod = bidMethod;
    }
}
