package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseMsgMessage;



public class MsgMessage extends BaseMsgMessage {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MsgMessage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MsgMessage (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

    //是否已读
    private Boolean isRead;

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}