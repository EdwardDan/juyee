package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-8
 * Time: 下午1:21
 */
public class AndroidJdPhoto implements Serializable {
    // id
    private Long id;
    // 文件名
    private String name;
    // 照片字节流
    private String photoByte;
    // 照片url
    private String url;
    /**
     * 最后修改时间
     */
    private String modifiedTime;

    private Long jdRecordId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getJdRecordId() {
        return jdRecordId;
    }

    public void setJdRecordId(Long jdRecordId) {
        this.jdRecordId = jdRecordId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoByte() {
        return photoByte;
    }

    public void setPhotoByte(String photoByte) {
        this.photoByte = photoByte;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "AndroidJdPhoto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photoByte='" + photoByte + '\'' +
                ", url='" + url + '\'' +
                ", jdRecordId=" + jdRecordId +
                '}';
    }
}
