package com.justonetech.biz.manager;

import com.justonetech.biz.domain.BpmProjectGroup;
import com.justonetech.biz.domain.BpmProjectGroupDuty;
import com.justonetech.system.domain.SysPerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @version 1.0
 * @author: MaJi
 * @date: 2009-4-1
 */
public class Candidate {

    //todo
    private BpmProjectGroup bpmProjectGroup;
    private BpmProjectGroupDuty bpmProjectGroupDuty;
    private SysPerson sysPerson;

    public BpmProjectGroup getBpmProjectGroup() {
        return bpmProjectGroup;
    }

    public void setBpmProjectGroup(BpmProjectGroup bpmProjectGroup) {
        this.bpmProjectGroup = bpmProjectGroup;
    }

    public BpmProjectGroupDuty getBpmProjectGroupDuty() {
        return bpmProjectGroupDuty;
    }

    public void setBpmProjectGroupDuty(BpmProjectGroupDuty bpmProjectGroupDuty) {
        this.bpmProjectGroupDuty = bpmProjectGroupDuty;
    }

    public SysPerson getSysPerson() {
        return sysPerson;
    }

    public void setSysPerson(SysPerson sysPerson) {
        this.sysPerson = sysPerson;
    }

    private static final Log log = LogFactory.getLog(Candidate.class);
}
