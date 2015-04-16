package com.justonetech.system.domain;

import com.justonetech.system.domain.base.BaseSample;

import java.util.Calendar;


public class Sample extends BaseSample {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public Sample() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public Sample(java.lang.Long id) {
        super(id);
    }

    /**
     * Constructor for required fields
     */
    public Sample(
            java.lang.Long id,
            java.lang.String name) {

        super(
                id,
                name);
    }

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 注：此处可根据需要增加自定义字段，不与数据库绑定，仅用于显示
     * 获取出生年份
     *
     * @return
     */
    public int getYear() {
        Calendar c = Calendar.getInstance();
        if (getBirthday() != null) {
            c.setTime(getBirthday());
        }
        return c.get(Calendar.YEAR);
    }

}