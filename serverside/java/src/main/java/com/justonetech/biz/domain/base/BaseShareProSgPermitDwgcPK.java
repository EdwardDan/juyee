package com.justonetech.biz.domain.base;

import java.io.Serializable;


public abstract class BaseShareProSgPermitDwgcPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Long dwgcId;
	private java.lang.String bdh;
	private java.lang.String bjbh;


	public BaseShareProSgPermitDwgcPK () {}
	
	public BaseShareProSgPermitDwgcPK (
		java.lang.Long dwgcId,
		java.lang.String bdh,
		java.lang.String bjbh) {

		this.setDwgcId(dwgcId);
		this.setBdh(bdh);
		this.setBjbh(bjbh);
	}


	/**
	 * Return the value associated with the column: DWGC_ID
	 */
	public java.lang.Long getDwgcId () {
		return dwgcId;
	}

	/**
	 * Set the value related to the column: DWGC_ID
	 * @param dwgcId the DWGC_ID value
	 */
	public void setDwgcId (java.lang.Long dwgcId) {
		this.dwgcId = dwgcId;
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
		if (!(obj instanceof com.justonetech.biz.domain.ShareProSgPermitDwgcPK)) return false;
		else {
			com.justonetech.biz.domain.ShareProSgPermitDwgcPK mObj = (com.justonetech.biz.domain.ShareProSgPermitDwgcPK) obj;
			if (null != this.getDwgcId() && null != mObj.getDwgcId()) {
				if (!this.getDwgcId().equals(mObj.getDwgcId())) {
					return false;
				}
			}
			else {
				return false;
			}
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
			if (null != this.getDwgcId()) {
				sb.append(this.getDwgcId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
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