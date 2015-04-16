package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaDeptNews;
import com.justonetech.biz.utils.enums.OaDeptNewsStatus;


public class OaDeptNews extends BaseOaDeptNews {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaDeptNews() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaDeptNews(Long id) {
        super(id);
    }

    /*[CONSTRUCTOR MARKER END]*/
    /*[CONSTRUCTOR MARKER END]*/
    public String getStatusName() {
        return OaDeptNewsStatus.getColorNameByCode(this.getStatus());
    }
}