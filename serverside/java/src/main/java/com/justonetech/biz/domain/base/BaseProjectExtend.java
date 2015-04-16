package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROJECT_EXTEND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 项目扩展信息
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 项目扩展信息
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : project
 * Projectable : false
 *
 * @hibernate.class table="PROJECT_EXTEND"
 */

public abstract class BaseProjectExtend implements Serializable, Auditable {

    public static String REF = "ProjectExtend";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_POS_Y = "posY";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_POS_X = "posX";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_ID = "id";
    public static String PROP_BELONG_AREA = "belongArea";
    public static String PROP_UPDATE_USER = "updateUser";
    public static String PROP_COMPLETE_DATE = "completeDate";
    public static String PROP_DESCRIPTION = "description";


    // constructors
    public BaseProjectExtend() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseProjectExtend(Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }


    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private Long id;

    // fields
    /*报建编号*/
    /*报建编号*/
    private String bjbh;

    /*项目属地*/
    /*项目属地*/
    private String belongArea;

    /*坐标X*/
    /*坐标X*/
    private Double posX;

    /*坐标Y*/
    /*坐标Y*/
    private Double posY;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*创建用户名*/
    /*创建用户名*/
    private String createUser;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*更新用户名*/
    /*更新用户名*/
    private String updateUser;


    /*竣工时间*/
    /*竣工时间*/
    private java.sql.Timestamp completeDate;

    /*竣工描述*/
    /*竣工描述*/
    private String description;

    /**
     * Return the unique identifier of this class
     *
     * @hibernate.id generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     * column="ID"
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     *
     * @param id the new ID
     * @deprecated
     */
    public void setId(Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public String getBjbh() {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     *
     * @param bjbh the BJBH value
     */
    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }


    /**
     * Return the value associated with the column: BELONG_AREA
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * Set the value related to the column: BELONG_AREA
     *
     * @param belongArea the BELONG_AREA value
     */
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }


    /**
     * Return the value associated with the column: POS_X
     */
    public Double getPosX() {
        return posX;
    }

    /**
     * Set the value related to the column: POS_X
     *
     * @param posX the POS_X value
     */
    public void setPosX(Double posX) {
        this.posX = posX;
    }


    /**
     * Return the value associated with the column: POS_Y
     */
    public Double getPosY() {
        return posY;
    }

    /**
     * Set the value related to the column: POS_Y
     *
     * @param posY the POS_Y value
     */
    public void setPosY(Double posY) {
        this.posY = posY;
    }


    /**
     * Return the value associated with the column: CREATE_TIME
     */
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * Set the value related to the column: CREATE_TIME
     *
     * @param createTime the CREATE_TIME value
     */
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    /**
     * Return the value associated with the column: CREATE_USER
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Set the value related to the column: CREATE_USER
     *
     * @param createUser the CREATE_USER value
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    /**
     * Return the value associated with the column: UPDATE_TIME
     */
    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * Set the value related to the column: UPDATE_TIME
     *
     * @param updateTime the UPDATE_TIME value
     */
    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Return the value associated with the column: UPDATE_TIME
     */
    public java.sql.Timestamp getCompleteDate() {
        return completeDate;
    }

    /**
     * Set the value related to the column: UPDATE_TIME
     *
     * @param completeDate the UPDATE_TIME value
     */
    public void setCompleteDate(java.sql.Timestamp completeDate) {
        this.completeDate = completeDate;
    }


    /**
     * Return the value associated with the column: UPDATE_USER
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * Set the value related to the column: UPDATE_USER
     *
     * @param updateUser the UPDATE_USER value
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof com.justonetech.biz.domain.ProjectExtend)) return false;
        else {
            com.justonetech.biz.domain.ProjectExtend projectExtend = (com.justonetech.biz.domain.ProjectExtend) obj;
            if (null == this.getId() || null == projectExtend.getId()) return false;
            else return (this.getId().equals(projectExtend.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }


    public String toString() {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append(id);
        builder.append(bjbh);
        builder.append(belongArea);
        builder.append(posX);
        builder.append(posY);
        builder.append(createTime);
        builder.append(createUser);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(completeDate);
        builder.append(description);
        return builder.toString();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}