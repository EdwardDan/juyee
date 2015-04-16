package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaFgldSet;

import java.util.Set;


public class OaFgldSet extends BaseOaFgldSet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaFgldSet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaFgldSet (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/
   //获取分管部门名称
    public String getDeptNames(){
        Set<OaFgldSetItem> oaFgldSetItems = this.getOaFgldSetItems();
        String deptNames="";
        for(OaFgldSetItem oaFgldSetItem:oaFgldSetItems){
             if(null!=oaFgldSetItem.getDept().getName()){
                 deptNames=deptNames+oaFgldSetItem.getDept().getName()+"&nbsp;&nbsp;&nbsp;";
             }
        }
        return deptNames;
    }

}