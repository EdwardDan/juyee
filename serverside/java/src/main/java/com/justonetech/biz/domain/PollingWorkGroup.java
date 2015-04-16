package com.justonetech.biz.domain;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.base.BasePollingWorkGroup;

import java.util.Set;


public class PollingWorkGroup extends BasePollingWorkGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PollingWorkGroup() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PollingWorkGroup(Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    /**
     * 取得责任区域名.
     * @return .
     */
    public String getArea(){
        String area = "";
        Set<PollingBelongArea> pollingBelongAreas = getPollingBelongAreas();
        for(PollingBelongArea pollingBelongArea : pollingBelongAreas)
        {
            area += pollingBelongArea.getBelongArea().getName() + "，";
        }
        if(!StringHelper.isEmpty(area))
        {
            area = area.substring(0, area.length()-1);
        }
        return area;
    }

    /**
     * 取得组成员
     * @return .
     */
    public String getGroupUser(){
        String groupUser = "";
        Set<PollingGroupUser> pollingGroupUsers = getPollingGroupUsers();
        for(PollingGroupUser pollingGroupUser : pollingGroupUsers)
        {
            groupUser += pollingGroupUser.getUser().getDisplayName() + "，";
        }
        if(!StringHelper.isEmpty(groupUser))
        {
            groupUser = groupUser.substring(0, groupUser.length()-1);
        }
        return groupUser;
    }
    
    /**
     * 取得负责人
     * @return .
     */
    public String getChargeUserName(){
        String chargeUserName = "";
        Set<PollingGroupUser> pollingGroupUsers = getPollingGroupUsers();
        for(PollingGroupUser pollingGroupUser : pollingGroupUsers)
        {
            if(pollingGroupUser.getIsCharge()){
                chargeUserName += pollingGroupUser.getUser().getDisplayName() + "，";
            }

        }
        if(!StringHelper.isEmpty(chargeUserName))
        {
            chargeUserName = chargeUserName.substring(0, chargeUserName.length()-1);
        }
        return chargeUserName;
    }
}