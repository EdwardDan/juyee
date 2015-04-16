package com.justonetech.biz.domain.base;

import com.justonetech.core.entity.Auditable;
import com.justonetech.core.entity.Guidable;
import com.justonetech.biz.domain.CheckFingerPrint;
import com.justonetech.biz.domain.CheckInfo;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;
import org.apache.cxf.aegis.type.java5.IgnoreProperty;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CHECK_MANAGER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 管理人员表
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 管理人员表
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : check
 * Projectable : false
 *
 * @hibernate.class
 *  table="CHECK_MANAGER"
 */

public abstract class BaseCheckManager implements Serializable, Auditable, Guidable {

    public static String REF = "CheckManager";
    public static String PROP_IS_DELETE = "isDelete";
    public static String PROP_UPDATE_TIME = "updateTime";
    public static String PROP_PHOTO_FILE = "photoFile";
    public static String PROP_CARD_NO = "cardNo";
    public static String PROP_NAME = "name";
    public static String PROP_CREATE_USER = "createUser";
    public static String PROP_GUID = "guid";
    public static String PROP_DELETE_TIME = "deleteTime";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_MOBILE = "mobile";
    public static String PROP_DELETE_USER = "deleteUser";
    public static String PROP_ID = "id";
    public static String PROP_SEX = "sex";
    public static String PROP_UPDATE_USER = "updateUser";


    // constructors
    public BaseCheckManager() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCheckManager(java.lang.Long id) {
        this.setId(id);
        initialize();
    }

    protected void initialize () {}



    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Long id;

    // fields
    /*姓名*/
    /*姓名*/
    private java.lang.String name;

    /*性别*/
    /*性别*/
    private java.lang.String sex;

    /*身份证号*/
    /*身份证号*/
    private java.lang.String cardNo;

    /*手机号码*/
    /*手机号码*/
    private java.lang.String mobile;

    /*照片*/
    /*照片*/
    private String photoFile;

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

    /*GUID*/
    /*GUID*/
    private java.lang.String guid;


    // collections
    private java.util.Set<CheckManagerPosition> checkManagerPositions;
    private java.util.Set<CheckFingerPrint> checkFingerPrints;
    private java.util.Set<CheckInfo> checkInfos;
    private java.util.Set<com.justonetech.biz.domain.CheckReason> checkReasons;



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
     * Return the value associated with the column: NAME
     */
    public java.lang.String getName () {
        return name;
    }

    /**
     * Set the value related to the column: NAME
     * @param name the NAME value
     */
    public void setName (java.lang.String name) {
        this.name = name;
    }


    /**
     * Return the value associated with the column: SEX
     */
    public java.lang.String getSex () {
        return sex;
    }

    /**
     * Set the value related to the column: SEX
     * @param sex the SEX value
     */
    public void setSex (java.lang.String sex) {
        this.sex = sex;
    }


    /**
     * Return the value associated with the column: CARD_NO
     */
    public java.lang.String getCardNo () {
        return cardNo;
    }

    /**
     * Set the value related to the column: CARD_NO
     * @param cardNo the CARD_NO value
     */
    public void setCardNo (java.lang.String cardNo) {
        this.cardNo = cardNo;
    }


    /**
     * Return the value associated with the column: MOBILE
     */
    public java.lang.String getMobile () {
        return mobile;
    }

    /**
     * Set the value related to the column: MOBILE
     * @param mobile the MOBILE value
     */
    public void setMobile (java.lang.String mobile) {
        this.mobile = mobile;
    }


    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
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
     * Return the value associated with the column: checkManagerPositions
     */
    @IgnoreProperty
    public java.util.Set<CheckManagerPosition> getCheckManagerPositions () {
        if(checkManagerPositions == null){
            checkManagerPositions = new java.util.LinkedHashSet<CheckManagerPosition>();
        }
        return checkManagerPositions;
    }

    /**
     * Set the value related to the column: checkManagerPositions
     * @param checkManagerPositions the checkManagerPositions value
     */
    @IgnoreProperty
    public void setCheckManagerPositions (java.util.Set<CheckManagerPosition> checkManagerPositions) {
        this.checkManagerPositions = checkManagerPositions;
    }

    public void addTocheckManagerPositions (CheckManagerPosition checkManagerPosition) {
        if (null == getCheckManagerPositions()) setCheckManagerPositions(new java.util.LinkedHashSet<CheckManagerPosition>());
        getCheckManagerPositions().add(checkManagerPosition);
    }

    /**
     * Return the value associated with the column: checkFingerPrints
     */
    public java.util.Set<com.justonetech.biz.domain.CheckFingerPrint> getCheckFingerPrints () {
        if(checkFingerPrints == null){
            checkFingerPrints = new java.util.LinkedHashSet<com.justonetech.biz.domain.CheckFingerPrint>();
        }
        return checkFingerPrints;
    }

    /**
     * Set the value related to the column: checkFingerPrints
     * @param checkFingerPrints the checkFingerPrints value
     */
    public void setCheckFingerPrints (java.util.Set<com.justonetech.biz.domain.CheckFingerPrint> checkFingerPrints) {
        this.checkFingerPrints = checkFingerPrints;
    }

    public void addTocheckFingerPrints (com.justonetech.biz.domain.CheckFingerPrint checkFingerPrint) {
        if (null == getCheckFingerPrints()) setCheckFingerPrints(new java.util.LinkedHashSet<com.justonetech.biz.domain.CheckFingerPrint>());
        getCheckFingerPrints().add(checkFingerPrint);
    }


    /**
     * Return the value associated with the column: checkInfos
     */
    public java.util.Set<CheckInfo> getCheckInfos() {
        if(checkInfos == null){
            checkInfos = new java.util.LinkedHashSet<CheckInfo>();
        }
        return checkInfos;
    }

    /**
     * Set the value related to the column: checkInfos
     * @param checkInfos the checkInfos value
     */
    public void setCheckInfos(java.util.Set<CheckInfo> checkInfos) {
        this.checkInfos = checkInfos;
    }

    public void addTocheckInfos (CheckInfo checkInfo) {
        if (null == getCheckInfos()) setCheckInfos(new java.util.LinkedHashSet<CheckInfo>());
        getCheckInfos().add(checkInfo);
    }


    /**
     * Return the value associated with the column: checkReasons
     */
    public java.util.Set<com.justonetech.biz.domain.CheckReason> getCheckReasons () {
        if(checkReasons == null){
            checkReasons = new java.util.LinkedHashSet<com.justonetech.biz.domain.CheckReason>();
        }
        return checkReasons;
    }

    /**
     * Set the value related to the column: checkReasons
     * @param checkReasons the checkReasons value
     */
    public void setCheckReasons (java.util.Set<com.justonetech.biz.domain.CheckReason> checkReasons) {
        this.checkReasons = checkReasons;
    }

    public void addTocheckReasons (com.justonetech.biz.domain.CheckReason checkReason) {
        if (null == getCheckReasons()) setCheckReasons(new java.util.LinkedHashSet<com.justonetech.biz.domain.CheckReason>());
        getCheckReasons().add(checkReason);
    }



    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof CheckManager)) return false;
        else {
            CheckManager checkManager = (CheckManager) obj;
            if (null == this.getId() || null == checkManager.getId()) return false;
            else return (this.getId().equals(checkManager.getId()));
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
        builder.append(name);
        builder.append(sex);
        builder.append(cardNo);
        builder.append(mobile);
        builder.append(photoFile);
        builder.append(createTime);
        builder.append(updateTime);
        builder.append(updateUser);
        builder.append(createUser);
        builder.append(deleteUser);
        builder.append(deleteTime);
        builder.append(isDelete);
        builder.append(guid);
        return builder.toString();
    }


}