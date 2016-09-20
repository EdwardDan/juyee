/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.justonetech.portal.feedback.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author fanqi
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper implements Feedback, ModelWrapper<Feedback> {
	public FeedbackWrapper(Feedback feedback) {
		_feedback = feedback;
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("zt", getZt());
		attributes.put("lxId", getLxId());
		attributes.put("fkrId", getFkrId());
		attributes.put("fkrq", getFkrq());
		attributes.put("fknr", getFknr());
		attributes.put("hfrId", getHfrId());
		attributes.put("hfrq", getHfrq());
		attributes.put("hfjg", getHfjg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String zt = (String)attributes.get("zt");

		if (zt != null) {
			setZt(zt);
		}

		Long lxId = (Long)attributes.get("lxId");

		if (lxId != null) {
			setLxId(lxId);
		}

		Long fkrId = (Long)attributes.get("fkrId");

		if (fkrId != null) {
			setFkrId(fkrId);
		}

		Date fkrq = (Date)attributes.get("fkrq");

		if (fkrq != null) {
			setFkrq(fkrq);
		}

		String fknr = (String)attributes.get("fknr");

		if (fknr != null) {
			setFknr(fknr);
		}

		Long hfrId = (Long)attributes.get("hfrId");

		if (hfrId != null) {
			setHfrId(hfrId);
		}

		Date hfrq = (Date)attributes.get("hfrq");

		if (hfrq != null) {
			setHfrq(hfrq);
		}

		String hfjg = (String)attributes.get("hfjg");

		if (hfjg != null) {
			setHfjg(hfjg);
		}
	}

	/**
	* Returns the primary key of this feedback.
	*
	* @return the primary key of this feedback
	*/
	@Override
	public long getPrimaryKey() {
		return _feedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feedback.
	*
	* @param primaryKey the primary key of this feedback
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the feedback ID of this feedback.
	*
	* @return the feedback ID of this feedback
	*/
	@Override
	public long getFeedbackId() {
		return _feedback.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feedback.
	*
	* @param feedbackId the feedback ID of this feedback
	*/
	@Override
	public void setFeedbackId(long feedbackId) {
		_feedback.setFeedbackId(feedbackId);
	}

	/**
	* Returns the group ID of this feedback.
	*
	* @return the group ID of this feedback
	*/
	@Override
	public long getGroupId() {
		return _feedback.getGroupId();
	}

	/**
	* Sets the group ID of this feedback.
	*
	* @param groupId the group ID of this feedback
	*/
	@Override
	public void setGroupId(long groupId) {
		_feedback.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this feedback.
	*
	* @return the company ID of this feedback
	*/
	@Override
	public long getCompanyId() {
		return _feedback.getCompanyId();
	}

	/**
	* Sets the company ID of this feedback.
	*
	* @param companyId the company ID of this feedback
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feedback.setCompanyId(companyId);
	}

	/**
	* Returns the zt of this feedback.
	*
	* @return the zt of this feedback
	*/
	@Override
	public java.lang.String getZt() {
		return _feedback.getZt();
	}

	/**
	* Sets the zt of this feedback.
	*
	* @param zt the zt of this feedback
	*/
	@Override
	public void setZt(java.lang.String zt) {
		_feedback.setZt(zt);
	}

	/**
	* Returns the lx ID of this feedback.
	*
	* @return the lx ID of this feedback
	*/
	@Override
	public long getLxId() {
		return _feedback.getLxId();
	}

	/**
	* Sets the lx ID of this feedback.
	*
	* @param lxId the lx ID of this feedback
	*/
	@Override
	public void setLxId(long lxId) {
		_feedback.setLxId(lxId);
	}

	/**
	* Returns the fkr ID of this feedback.
	*
	* @return the fkr ID of this feedback
	*/
	@Override
	public long getFkrId() {
		return _feedback.getFkrId();
	}

	/**
	* Sets the fkr ID of this feedback.
	*
	* @param fkrId the fkr ID of this feedback
	*/
	@Override
	public void setFkrId(long fkrId) {
		_feedback.setFkrId(fkrId);
	}

	/**
	* Returns the fkrq of this feedback.
	*
	* @return the fkrq of this feedback
	*/
	@Override
	public java.util.Date getFkrq() {
		return _feedback.getFkrq();
	}

	/**
	* Sets the fkrq of this feedback.
	*
	* @param fkrq the fkrq of this feedback
	*/
	@Override
	public void setFkrq(java.util.Date fkrq) {
		_feedback.setFkrq(fkrq);
	}

	/**
	* Returns the fknr of this feedback.
	*
	* @return the fknr of this feedback
	*/
	@Override
	public java.lang.String getFknr() {
		return _feedback.getFknr();
	}

	/**
	* Sets the fknr of this feedback.
	*
	* @param fknr the fknr of this feedback
	*/
	@Override
	public void setFknr(java.lang.String fknr) {
		_feedback.setFknr(fknr);
	}

	/**
	* Returns the hfr ID of this feedback.
	*
	* @return the hfr ID of this feedback
	*/
	@Override
	public long getHfrId() {
		return _feedback.getHfrId();
	}

	/**
	* Sets the hfr ID of this feedback.
	*
	* @param hfrId the hfr ID of this feedback
	*/
	@Override
	public void setHfrId(long hfrId) {
		_feedback.setHfrId(hfrId);
	}

	/**
	* Returns the hfrq of this feedback.
	*
	* @return the hfrq of this feedback
	*/
	@Override
	public java.util.Date getHfrq() {
		return _feedback.getHfrq();
	}

	/**
	* Sets the hfrq of this feedback.
	*
	* @param hfrq the hfrq of this feedback
	*/
	@Override
	public void setHfrq(java.util.Date hfrq) {
		_feedback.setHfrq(hfrq);
	}

	/**
	* Returns the hfjg of this feedback.
	*
	* @return the hfjg of this feedback
	*/
	@Override
	public java.lang.String getHfjg() {
		return _feedback.getHfjg();
	}

	/**
	* Sets the hfjg of this feedback.
	*
	* @param hfjg the hfjg of this feedback
	*/
	@Override
	public void setHfjg(java.lang.String hfjg) {
		_feedback.setHfjg(hfjg);
	}

	@Override
	public boolean isNew() {
		return _feedback.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedback.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedback.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedback.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedback.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedback.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedback.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedback.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedbackWrapper((Feedback)_feedback.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.portal.feedback.model.Feedback feedback) {
		return _feedback.compareTo(feedback);
	}

	@Override
	public int hashCode() {
		return _feedback.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.portal.feedback.model.Feedback> toCacheModel() {
		return _feedback.toCacheModel();
	}

	@Override
	public com.justonetech.portal.feedback.model.Feedback toEscapedModel() {
		return new FeedbackWrapper(_feedback.toEscapedModel());
	}

	@Override
	public com.justonetech.portal.feedback.model.Feedback toUnescapedModel() {
		return new FeedbackWrapper(_feedback.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedback.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedback.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedback.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackWrapper)) {
			return false;
		}

		FeedbackWrapper feedbackWrapper = (FeedbackWrapper)obj;

		if (Validator.equals(_feedback, feedbackWrapper._feedback)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Feedback getWrappedFeedback() {
		return _feedback;
	}

	@Override
	public Feedback getWrappedModel() {
		return _feedback;
	}

	@Override
	public void resetOriginalValues() {
		_feedback.resetOriginalValues();
	}

	private Feedback _feedback;
}