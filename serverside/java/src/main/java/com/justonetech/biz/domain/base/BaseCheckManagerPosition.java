package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Guidable;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CHECK_MANAGER_POSITION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 人员岗位表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 人员岗位表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class
 *  table="CHECK_MANAGER_POSITION"
 */

public abstract class BaseCheckManagerPosition implements Serializable, Auditable, Guidable {

    public static String REF = "CheckManagerPosition";
    public static String PROP_CERTIFICATE_CODE = "certificateCode";
    public static String PROP_POSITION_NAME = "positionName";
    public static String PROP_CERTIFICATE_NAME = "certificateName";
    public static String PROP_POSITION_TYPE = "positionType";
    public static String PROP_IS_DELETE = "isDelete";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_STREET_AREA = "streetArea";
    public static String PROP_GD_CODE = "gdCode";
    public static String PROP_GD_NAME = "gdName";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_GUID = "guid";
    public static String PROP_DELETE_TIME = "deleteTime";
    public static String PROP_BJBH = "bjbh";
    public static String PROP_MANAGER = "manager";
    public static String PROP_JD_TASK_CODE = "jdTaskCode";
    public static String PROP_IS_VALID = "isValid";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_DELETE_USER = "deleteUser";
    public static String PROP_ID = "id";
    public static String PROP_BELONG_AREA = "belongArea";
    public static String PROP_CERTIFICATE_DOC = "certificateDoc";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseCheckManagerPosition() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCheckManagerPosition(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*监督任务书编号*/
    /*监督任务书编号*/
    private java.lang.String jdTaskCode;

    /*报建编号*/
    /*报建编号*/
    private java.lang.String bjbh;

    /*工地编号*/
    /*工地编号*/
    private java.lang.String gdCode;

    /*工地名称*/
    /*工地名称*/
    private java.lang.String gdName;

    /*所属区县*/
    /*所属区县*/
    private java.lang.String belongArea;

    /*街镇*/
    /*街镇*/
    private java.lang.String streetArea;

    /*是否有效*/
    /*是否有效*/
    private java.lang.Boolean isValid;

    /*岗位名称*/
    /*岗位名称*/
    private java.lang.String positionName;

    /*证书编号*/
    /*证书编号*/
    private java.lang.String certificateCode;

    /*证书名称*/
    /*证书名称*/
    private java.lang.String certificateName;

    /*GUID*/
    /*GUID*/
    private java.lang.String guid;

    /*创建时间*/
    /*创建时间*/
    private java.sql.Timestamp createTime;

    /*更新时间*/
    /*更新时间*/
    private java.sql.Timestamp updateTime;

    /*更新人*/
    /*更新人*/
    private java.lang.String updateUser;

    /*创建人*/
    /*创建人*/
    private java.lang.String createUser;

    /*删除人*/
    /*删除人*/
    private java.lang.String deleteUser;

    /*删除时间*/
    /*删除时间*/
    private java.sql.Timestamp deleteTime;

    /*逻辑删除*/
    /*逻辑删除*/
    private java.lang.Boolean isDelete;


    // many to one
    private CheckManager manager;
    private com.justonetech.system.domain.SysCodeDetail positionType;
    private com.justonetech.biz.domain.DocDocument certificateDoc;

    // collections



    /**
     * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
    public java.lang.Long getId () {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * @param id the new ID
     * @deprecated
     */
    public void setId (java.lang.Long id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }




    /**
     * Return the value associated with the column: JD_TASK_CODE
     */
    public java.lang.String getJdTaskCode () {
        return jdTaskCode;
    }

    /**
     * Set the value related to the column: JD_TASK_CODE
     * @param jdTaskCode the JD_TASK_CODE value
     */
    public void setJdTaskCode (java.lang.String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }


    /**
     * Return the value associated with the column: BJBH
     */
    public java.lang.String getBjbh () {
        return bjbh;
    }

    /**
     * Set the value related to the column: BJBH
     * @param bjbh the BJBH value
     */
    public void setBjbh (java.lang.String bjbh) {
        this.bjbh = bjbh;
    }


    /**
     * Return the value associated with the column: GD_CODE
     */
    public java.lang.String getGdCode () {
        return gdCode;
    }

    /**
     * Set the value related to the column: GD_CODE
     * @param gdCode the GD_CODE value
     */
    public void setGdCode (java.lang.String gdCode) {
        this.gdCode = gdCode;
    }


    /**
     * Return the value associated with the column: GD_NAME
     */
    public java.lang.String getGdName () {
        return gdName;
    }

    /**
     * Set the value related to the column: GD_NAME
     * @param gdName the GD_NAME value
     */
    public void setGdName (java.lang.String gdName) {
        this.gdName = gdName;
    }


    /**
     * Return the value associated with the column: BELONG_AREA
     */
    public java.lang.String getBelongArea () {
        return belongArea;
    }

    /**
     * Set the value related to the column: BELONG_AREA
     * @param belongArea the BELONG_AREA value
     */
    public void setBelongArea (java.lang.String belongArea) {
        this.belongArea = belongArea;
    }


    /**
     * Return the value associated with the column: STREET_AREA
     */
    public java.lang.String getStreetArea () {
        return streetArea;
    }

    /**
     * Set the value related to the column: STREET_AREA
     * @param streetArea the STREET_AREA value
     */
    public void setStreetArea (java.lang.String streetArea) {
        this.streetArea = streetArea;
    }


    /**
     * Return the value associated with the column: IS_VALID
     */
    public java.lang.Boolean getIsValid () {
        return isValid;
    }

    /**
     * Set the value related to the column: IS_VALID
     * @param isValid the IS_VALID value
     */
    public void setIsValid (java.lang.Boolean isValid) {
        this.isValid = isValid;
    }


    /**
     * Return the value associated with the column: POSITION_NAME
     */
    public java.lang.String getPositionName () {
        return positionName;
    }

    /**
     * Set the value related to the column: POSITION_NAME
     * @param positionName the POSITION_NAME value
     */
    public void setPositionName (java.lang.String positionName) {
        this.positionName = positionName;
    }


    /**
     * Return the value associated with the column: CERTIFICATE_CODE
     */
    public java.lang.String getCertificateCode () {
        return certificateCode;
    }

    /**
     * Set the value related to the column: CERTIFICATE_CODE
     * @param certificateCode the CERTIFICATE_CODE value
     */
    public void setCertificateCode (java.lang.String certificateCode) {
        this.certificateCode = certificateCode;
    }


    /**
     * Return the value associated with the column: CERTIFICATE_NAME
     */
    public java.lang.String getCertificateName () {
        return certificateName;
    }

    /**
     * Set the value related to the column: CERTIFICATE_NAME
     * @param certificateName the CERTIFICATE_NAME value
     */
    public void setCertificateName (java.lang.String certificateName) {
        this.certificateName = certificateName;
    }


    /**
     * Return the value associated with the column: GUID
     */
    public java.lang.String getGuid () {
        return guid;
    }

    /**
     * Set the value related to the column: GUID
     * @param guid the GUID value
     */
    public void setGuid (java.lang.String guid) {
        this.guid = guid;
    }


    /**
     * Return the value associated with the column: CREATE_TIME
     */
    public java.sql.Timestamp getCreateTime () {
        return createTime;
    }

    /**
     * Set the value related to the column: CREATE_TIME
     * @param createTime the CREATE_TIME value
     */
    public void setCreateTime (java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    /**
     * Return the value associated with the column: UPDATE_TIME
     */
    public java.sql.Timestamp getUpdateTime () {
        return updateTime;
    }

    /**
     * Set the value related to the column: UPDATE_TIME
     * @param updateTime the UPDATE_TIME value
     */
    public void setUpdateTime (java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    /**
     * Return the value associated with the column: UPDATE_USER
     */
    public java.lang.String getUpdateUser () {
        return updateUser;
    }

    /**
     * Set the value related to the column: UPDATE_USER
     * @param updateUser the UPDATE_USER value
     */
    public void setUpdateUser (java.lang.String updateUser) {
        this.updateUser = updateUser;
    }


    /**
     * Return the value associated with the column: CREATE_USER
     */
    public java.lang.String getCreateUser () {
        return createUser;
    }

    /**
     * Set the value related to the column: CREATE_USER
     * @param createUser the CREATE_USER value
     */
    public void setCreateUser (java.lang.String createUser) {
        this.createUser = createUser;
    }


    /**
     * Return the value associated with the column: DELETE_USER
     */
    public java.lang.String getDeleteUser () {
        return deleteUser;
    }

    /**
     * Set the value related to the column: DELETE_USER
     * @param deleteUser the DELETE_USER value
     */
    public void setDeleteUser (java.lang.String deleteUser) {
        this.deleteUser = deleteUser;
    }


    /**
     * Return the value associated with the column: DELETE_TIME
     */
    public java.sql.Timestamp getDeleteTime () {
        return deleteTime;
    }

    /**
     * Set the value related to the column: DELETE_TIME
     * @param deleteTime the DELETE_TIME value
     */
    public void setDeleteTime (java.sql.Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }


    /**
     * Return the value associated with the column: IS_DELETE
     */
    public java.lang.Boolean getIsDelete () {
        return isDelete;
    }

    /**
     * Set the value related to the column: IS_DELETE
     * @param isDelete the IS_DELETE value
     */
    public void setIsDelete (java.lang.Boolean isDelete) {
        this.isDelete = isDelete;
    }


    /**
     * Return the value associated with the column: MANAGER_ID
     */
    public CheckManager getManager () {
        return manager;
    }

    /**
     * Set the value related to the column: MANAGER_ID
     * @param manager the MANAGER_ID value
     */
    public void setManager (CheckManager manager) {
        this.manager = manager;
    }


    /**
     * Return the value associated with the column: POSITION_TYPE
     */
    public com.justonetech.system.domain.SysCodeDetail getPositionType () {
        return positionType;
    }

    /**
     * Set the value related to the column: POSITION_TYPE
     * @param positionType the POSITION_TYPE value
     */
    public void setPositionType (com.justonetech.system.domain.SysCodeDetail positionType) {
        this.positionType = positionType;
    }


    /**
     * Return the value associated with the column: CERTIFICATE_DOC_ID
     */
    public com.justonetech.biz.domain.DocDocument getCertificateDoc () {
        return certificateDoc;
    }

    /**
     * Set the value related to the column: CERTIFICATE_DOC_ID
     * @param certificateDoc the CERTIFICATE_DOC_ID value
     */
    public void setCertificateDoc (com.justonetech.biz.domain.DocDocument certificateDoc) {
        this.certificateDoc = certificateDoc;
    }


    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof CheckManagerPosition)) return false;
        else {
            CheckManagerPosition checkManagerPosition = (CheckManagerPosition) obj;
            if (null == this.getId() || null == checkManagerPosition.getId()) return false;
            else return (this.getId().equals(checkManagerPosition.getId()));
        }
    }

    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }


    public String toString () {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append(id);
        builder.append(jdTaskCode);
        builder.append(bjbh);
        builder.append(gdCode);
        builder.append(gdName);
        builder.append(belongArea);
        builder.append(streetArea);
        builder.append(isValid);
        builder.append(positionName);
        builder.append(certificateCode);
        builder.append(certificateName);
        builder.append(guid);
        builder.append(createTime);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(createUser);
        builder.append(deleteUser);
        builder.append(deleteTime);
        builder.append(isDelete);
        return builder.toString();
    }


}