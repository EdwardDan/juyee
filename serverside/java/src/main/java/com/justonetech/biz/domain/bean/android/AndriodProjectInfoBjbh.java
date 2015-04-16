package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-12-24
 * Time: 下午2:40
 */
public class AndriodProjectInfoBjbh implements Serializable {

    private boolean success;
    private String bjbh;
    private String faren;
    private String buildAddress;
    private String tel;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getFaren() {
        return faren;
    }

    public void setFaren(String faren) {
        this.faren = faren;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AndriodProjectInfoBjbh{");
        sb.append("bjbh='").append(bjbh).append('\'');
        sb.append(", faren='").append(faren).append('\'');
        sb.append(", buildAddress='").append(buildAddress).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
