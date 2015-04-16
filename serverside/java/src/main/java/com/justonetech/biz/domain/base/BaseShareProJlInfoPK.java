package com.justonetech.biz.domain.base;

import java.io.Serializable;


public abstract class BaseShareProJlInfoPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String bdh;
	private java.lang.String bjbh;


	public BaseShareProJlInfoPK () {}
	
	public BaseShareProJlInfoPK (
		java.lang.String bdh,
		java.lang.String bjbh) {

		this.setBdh(bdh);
		this.setBjbh(bjbh);
	}


	/**
	 * Return the value associated with the column: BDH
	 */
	public java.lang.String getBdh () {
		return bdh;
	}

	/**
	 * Set the value related to the column: BDH
	 * @param bdh the BDH value
	 */
	public void setBdh (java.lang.String bdh) {
		this.bdh = bdh;
	}



	/**
	 * Return the value associated with the column: BJBH
	 */
	public java.lang.String getBjbh () {
		return bjbh;
	}

	/**
	 * Set the value related to the column: BJBH
	 * @param bjbh the BJBH value
	 */
	public void setBjbh (java.lang.String bjbh) {
		this.bjbh = bjbh;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareProJlInfoPK)) return false;
		else {
			com.justonetech.biz.domain.ShareProJlInfoPK mObj = (com.justonetech.biz.domain.ShareProJlInfoPK) obj;
			if (null != this.getBdh() && null != mObj.getBdh()) {
				if (!this.getBdh().equals(mObj.getBdh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBjbh() && null != mObj.getBjbh()) {
				if (!this.getBjbh().equals(mObj.getBjbh())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getBdh()) {
				sb.append(this.getBdh().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBjbh()) {
				sb.append(this.getBjbh().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}