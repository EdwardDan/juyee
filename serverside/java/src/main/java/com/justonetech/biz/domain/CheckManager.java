package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseCheckManager;

import java.util.Set;


public class CheckManager extends BaseCheckManager {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CheckManager() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CheckManager(java.lang.Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 获取多个职务名称
     * @return
     */
    public String getPositionNames(){
        String names = "";
        Set<CheckManagerPosition> list = getCheckManagerPositions();
        for(CheckManagerPosition position:list){
            if(!"".equals(names)){
                names += ","+position.getPositionName();
            }else{
                names += position.getPositionName();
            }

        }
        return names;
    }
}