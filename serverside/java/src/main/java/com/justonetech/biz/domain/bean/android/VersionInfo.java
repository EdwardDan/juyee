package com.justonetech.biz.domain.bean.android;

/**
 * Created by asus-pc on 2014/8/5.
 */
public class VersionInfo {
    public String isForce;
    public String verCode;
    public String verDesc;
    public String apkDoc;
    public Integer verType;

    @Override
    public String toString() {
        return "VersionInfo{" +
                "isForce=" + isForce +
                ", verCode='" + verCode + '\'' +
                ", verDesc='" + verDesc + '\'' +
                ", apkDoc='" + apkDoc + '\'' +
                ", verType=" + verType +
                '}';
    }

}
