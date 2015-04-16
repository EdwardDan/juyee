package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 上午9:28
 */
public class AndroidJdRecordCompleteResult implements Serializable {
    // primary key
    private Long id;
    /*检查结果*/
    private String checkResult;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordCompleteResult{" +
                "id=" + id +
                ", checkResult='" + checkResult + '\'' +
                '}';
    }
}
