package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseProjBid;

import java.util.Set;


public class ProjBid extends BaseProjBid {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public ProjBid() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public ProjBid(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取所属区县名称
     *
     * @return .
     */
    public String getBelongAreaNames() {
        String name = "";
        Set<ProjBidArea> projBidAreas = getProjBidAreas();
        if (projBidAreas != null && !projBidAreas.isEmpty()) {
            for (ProjBidArea projBidArea : projBidAreas) {
                name += "," + projBidArea.getBelongArea().getName();
            }
            name = name.substring(1);
        }
        return name;
    }
}