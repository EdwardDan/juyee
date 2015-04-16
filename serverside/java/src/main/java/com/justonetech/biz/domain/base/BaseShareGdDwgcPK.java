package com.justonetech.biz.domain.base;

import java.io.Serializable;


public abstract class BaseShareGdDwgcPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String gdCode;
	private java.lang.String dwgcCard;


	public BaseShareGdDwgcPK () {}
	
	public BaseShareGdDwgcPK (
		java.lang.String gdCode,
		java.lang.String dwgcCard) {

		this.setGdCode(gdCode);
		this.setDwgcCard(dwgcCard);
	}


	/**
	 * Return the value associated with the column: GD_CODE
	 */
	public java.lang.String getGdCode () {
		return gdCode;
	}

	/**
	 * Set the value related to the column: GD_CODE
	 * @param gdCode the GD_CODE value
	 */
	public void setGdCode (java.lang.String gdCode) {
		this.gdCode = gdCode;
	}



	/**
	 * Return the value associated with the column: DWGC_CARD
	 */
	public java.lang.String getDwgcCard () {
		return dwgcCard;
	}

	/**
	 * Set the value related to the column: DWGC_CARD
	 * @param dwgcCard the DWGC_CARD value
	 */
	public void setDwgcCard (java.lang.String dwgcCard) {
		this.dwgcCard = dwgcCard;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.justonetech.biz.domain.ShareGdDwgcPK)) return false;
		else {
			com.justonetech.biz.domain.ShareGdDwgcPK mObj = (com.justonetech.biz.domain.ShareGdDwgcPK) obj;
			if (null != this.getGdCode() && null != mObj.getGdCode()) {
				if (!this.getGdCode().equals(mObj.getGdCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getDwgcCard() && null != mObj.getDwgcCard()) {
				if (!this.getDwgcCard().equals(mObj.getDwgcCard())) {
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
			if (null != this.getGdCode()) {
				sb.append(this.getGdCode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getDwgcCard()) {
				sb.append(this.getDwgcCard().hashCode());
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