package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.util.List;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-5
 * Time: 下午6:18
 */
public class AndroidJdRecordQuality implements Serializable {
    // id
    private Long id;
    private Long planDetailid;
    // 监督类型
    private String type;
    /*监督日期*/
    private String jdDatetime;
    /*监督任务书编号*/
    private String jdTaskCode;
    /*报建编号*/
    private String bjbh;
    /*天气*/
    private String weather;
    /*工程名称*/
    private String projectName;
    /*状态*/
    private Integer status;
    /*建设单位*/
    private String jsDept;
    /*勘察单位*/
    private String kcDept;
    /*设计单位*/
    private String sjDept;
    /*施工单位*/
    private String sgDept;
    /*监理单位*/
    private String jlDept;
    /*检测单位*/
    private String jcDept;
    // 完工进度
    private String scheduleItems;
    // 监理对工程质量报告
    private String content;
    // 单位工程
    private AndroidDwgc dwgc;
    /*抽查对象内容*/
    private String inspectionContent;
    /*抽查内容和部位*/
    private String inspectionPosition;
    /*监督抽测*/
    private String jdInspection;
    //质量监督--问题类别--行为抽查
    private List<AndroidJdRecordQuestion> behavior;
    // //质量监督--问题类别--实体抽查
    private List<AndroidJdRecordQuestion> entity;
    // 总处理意见
    private String dealOpinion;
    // 备注
    private String description;
    /*监督负责人*/
    private AndroidJdPersonInfo jdManagerName;
    // 参加人员
    private List<AndroidJdPersonInfo> attendPersons;

    // 照片
    private List<AndroidJdPhoto> photos;
    // 文档id
    private Long documentId;

    public Long getPlanDetailid() {
        return planDetailid;
    }

    public void setPlanDetailid(Long planDetailid) {
        this.planDetailid = planDetailid;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public List<AndroidJdPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<AndroidJdPhoto> photos) {
        this.photos = photos;
    }

    public AndroidJdPersonInfo getJdManagerName() {
        return jdManagerName;
    }

    public void setJdManagerName(AndroidJdPersonInfo jdManagerName) {
        this.jdManagerName = jdManagerName;
    }

    public List<AndroidJdPersonInfo> getAttendPersons() {
        return attendPersons;
    }

    public void setAttendPersons(List<AndroidJdPersonInfo> attendPersons) {
        this.attendPersons = attendPersons;
    }

    public String getJdDatetime() {
        return jdDatetime;
    }

    public void setJdDatetime(String jdDatetime) {
        this.jdDatetime = jdDatetime;
    }

    public String getJdTaskCode() {
        return jdTaskCode;
    }

    public void setJdTaskCode(String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJsDept() {
        return jsDept;
    }

    public void setJsDept(String jsDept) {
        this.jsDept = jsDept;
    }

    public String getKcDept() {
        return kcDept;
    }

    public void setKcDept(String kcDept) {
        this.kcDept = kcDept;
    }

    public String getSjDept() {
        return sjDept;
    }

    public void setSjDept(String sjDept) {
        this.sjDept = sjDept;
    }

    public String getSgDept() {
        return sgDept;
    }

    public void setSgDept(String sgDept) {
        this.sgDept = sgDept;
    }

    public String getJlDept() {
        return jlDept;
    }

    public void setJlDept(String jlDept) {
        this.jlDept = jlDept;
    }

    public String getJcDept() {
        return jcDept;
    }

    public void setJcDept(String jcDept) {
        this.jcDept = jcDept;
    }

    public String getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(String scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AndroidDwgc getDwgc() {
        return dwgc;
    }

    public void setDwgc(AndroidDwgc dwgc) {
        this.dwgc = dwgc;
    }

    public String getInspectionContent() {
        return inspectionContent;
    }

    public void setInspectionContent(String inspectionContent) {
        this.inspectionContent = inspectionContent;
    }

    public String getInspectionPosition() {
        return inspectionPosition;
    }

    public void setInspectionPosition(String inspectionPosition) {
        this.inspectionPosition = inspectionPosition;
    }

    public String getJdInspection() {
        return jdInspection;
    }

    public void setJdInspection(String jdInspection) {
        this.jdInspection = jdInspection;
    }

    public List<AndroidJdRecordQuestion> getBehavior() {
        return behavior;
    }

    public void setBehavior(List<AndroidJdRecordQuestion> behavior) {
        this.behavior = behavior;
    }

    public List<AndroidJdRecordQuestion> getEntity() {
        return entity;
    }

    public void setEntity(List<AndroidJdRecordQuestion> entity) {
        this.entity = entity;
    }

    public String getDealOpinion() {
        return dealOpinion;
    }

    public void setDealOpinion(String dealOpinion) {
        this.dealOpinion = dealOpinion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordQuality{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", jdDatetime='" + jdDatetime + '\'' +
                ", jdTaskCode='" + jdTaskCode + '\'' +
                ", bjbh='" + bjbh + '\'' +
                ", weather='" + weather + '\'' +
                ", projectName='" + projectName + '\'' +
                ", status=" + status +
                ", jsDept='" + jsDept + '\'' +
                ", kcDept='" + kcDept + '\'' +
                ", sjDept='" + sjDept + '\'' +
                ", sgDept='" + sgDept + '\'' +
                ", jlDept='" + jlDept + '\'' +
                ", jcDept='" + jcDept + '\'' +
                ", scheduleItems='" + scheduleItems + '\'' +
                ", content='" + content + '\'' +
                ", dwgc=" + dwgc +
                ", inspectionContent='" + inspectionContent + '\'' +
                ", inspectionPosition='" + inspectionPosition + '\'' +
                ", jdInspection='" + jdInspection + '\'' +
                ", behavior=" + behavior +
                ", entity=" + entity +
                ", dealOpinion='" + dealOpinion + '\'' +
                ", description='" + description + '\'' +
                ", jdManagerName=" + jdManagerName +
                ", attendPersons=" + attendPersons +
                ", photos=" + photos +
                ", documentId=" + documentId +
                '}';
    }
}
