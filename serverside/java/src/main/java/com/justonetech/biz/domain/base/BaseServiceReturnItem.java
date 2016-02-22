package com.justonetech.biz.domain.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SERVICE_RETURN_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * TableComment : 送达回证明细
 * SyncTemplatepatterns : list\w*
 * SyncDao : false
 * TableName : 送达回证明细
 * SyncBoolean : get
 * SyncJsp : true
 * Treeable : false
 * SubSystem : service
 * Projectable : false
 *
 * @hibernate.class
 *  table="SERVICE_RETURN_ITEM"
 */

public abstract class BaseServiceReturnItem  implements Serializable {

	public static String REF = "ServiceReturnItem";
	public static String PROP_SERVICE_PERSON = "servicePerson";
	public static String PROP_RECEIVE_SIGN = "receiveSign";
	public static String PROP_NUM = "num";
	public static String PROP_SERVICE_BOOK = "serviceBook";
	public static String PROP_MEMO = "memo";
	public static String PROP_RECEIVE_DATE = "receiveDate";
	public static String PROP_RETURN = "return";
	public static String PROP_ID = "id";


	// constructors
	public BaseServiceReturnItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceReturnItem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
    /*序号*/
    /*序号*/
	private java.lang.Integer num;
	
    /*送达文书*/
    /*送达文书*/
	private java.lang.String serviceBook;
	
    /*送达人*/
    /*送达人*/
	private java.lang.String servicePerson;
	
    /*收到日期*/
    /*收到日期*/
	private java.sql.Date receiveDate;
	
    /*收到人签名*/
    /*收到人签名*/
	private java.lang.String receiveSign;
	
    /*备注*/
    /*备注*/
	private java.lang.String memo;
	

	// many to one
	private com.justonetech.biz.domain.ServiceReturn m_return;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="com.justonetech.core.orm.hibernate.LongIdGenerator"
     *  column="ID"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 * @deprecated
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: NUM
	 */
	public java.lang.Integer getNum () {
		return num;
	}

	/**
	 * Set the value related to the column: NUM
	 * @param num the NUM value
	 */
	public void setNum (java.lang.Integer num) {
		this.num = num;
	}


	/**
	 * Return the value associated with the column: SERVICE_BOOK
	 */
	public java.lang.String getServiceBook () {
		return serviceBook;
	}

	/**
	 * Set the value related to the column: SERVICE_BOOK
	 * @param serviceBook the SERVICE_BOOK value
	 */
	public void setServiceBook (java.lang.String serviceBook) {
		this.serviceBook = serviceBook;
	}


	/**
	 * Return the value associated with the column: SERVICE_PERSON
	 */
	public java.lang.String getServicePerson () {
		return servicePerson;
	}

	/**
	 * Set the value related to the column: SERVICE_PERSON
	 * @param servicePerson the SERVICE_PERSON value
	 */
	public void setServicePerson (java.lang.String servicePerson) {
		this.servicePerson = servicePerson;
	}


	/**
	 * Return the value associated with the column: RECEIVE_DATE
	 */
	public java.sql.Date getReceiveDate () {
		return receiveDate;
	}

	/**
	 * Set the value related to the column: RECEIVE_DATE
	 * @param receiveDate the RECEIVE_DATE value
	 */
	public void setReceiveDate (java.sql.Date receiveDate) {
		this.receiveDate = receiveDate;
	}


	/**
	 * Return the value associated with the column: RECEIVE_SIGN
	 */
	public java.lang.String getReceiveSign () {
		return receiveSign;
	}

	/**
	 * Set the value related to the column: RECEIVE_SIGN
	 * @param receiveSign the RECEIVE_SIGN value
	 */
	public void setReceiveSign (java.lang.String receiveSign) {
		this.receiveSign = receiveSign;
	}


	/**
	 * Return the value associated with the column: MEMO
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: MEMO
	 * @param memo the MEMO value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
	}


	/**
	 * Return the value associated with the column: RETURN_ID
	 */
	public com.justonetech.biz.domain.ServiceReturn getReturn () {
		return m_return;
	}

	/**
	 * Set the value related to the column: RETURN_ID
	 * @param m_return the RETURN_ID value
	 */
	public void setReturn (com.justonetech.biz.domain.ServiceReturn m_return) {
		this.m_return = m_return;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ServiceReturnItem)) return false;
		else {
			com.justonetech.biz.domain.ServiceReturnItem serviceReturnItem = (com.justonetech.biz.domain.ServiceReturnItem) obj;
			if (null == this.getId() || null == serviceReturnItem.getId()) return false;
			else return (this.getId().equals(serviceReturnItem.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(id);
		builder.append(num);
		builder.append(serviceBook);
		builder.append(servicePerson);
		builder.append(receiveDate);
		builder.append(receiveSign);
		builder.append(memo);
		return builder.toString();
	}


}