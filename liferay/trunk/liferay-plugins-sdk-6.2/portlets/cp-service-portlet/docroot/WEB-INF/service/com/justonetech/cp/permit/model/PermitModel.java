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

package com.justonetech.cp.permit.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Permit service. Represents a row in the &quot;cp_Permit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.cp.permit.model.impl.PermitModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.cp.permit.model.impl.PermitImpl}.
 * </p>
 *
 * @author fanqi
 * @see Permit
 * @see com.justonetech.cp.permit.model.impl.PermitImpl
 * @see com.justonetech.cp.permit.model.impl.PermitModelImpl
 * @generated
 */
public interface PermitModel extends BaseModel<Permit>, GroupedModel,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a permit model instance should use the {@link Permit} interface instead.
	 */

	/**
	 * Returns the primary key of this permit.
	 *
	 * @return the primary key of this permit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this permit.
	 *
	 * @param primaryKey the primary key of this permit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the permit ID of this permit.
	 *
	 * @return the permit ID of this permit
	 */
	public long getPermitId();

	/**
	 * Sets the permit ID of this permit.
	 *
	 * @param permitId the permit ID of this permit
	 */
	public void setPermitId(long permitId);

	/**
	 * Returns the group ID of this permit.
	 *
	 * @return the group ID of this permit
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this permit.
	 *
	 * @param groupId the group ID of this permit
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this permit.
	 *
	 * @return the company ID of this permit
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this permit.
	 *
	 * @param companyId the company ID of this permit
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this permit.
	 *
	 * @return the user ID of this permit
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this permit.
	 *
	 * @param userId the user ID of this permit
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this permit.
	 *
	 * @return the user uuid of this permit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this permit.
	 *
	 * @param userUuid the user uuid of this permit
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this permit.
	 *
	 * @return the user name of this permit
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this permit.
	 *
	 * @param userName the user name of this permit
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this permit.
	 *
	 * @return the create date of this permit
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this permit.
	 *
	 * @param createDate the create date of this permit
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this permit.
	 *
	 * @return the modified date of this permit
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this permit.
	 *
	 * @param modifiedDate the modified date of this permit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the zzjgdm of this permit.
	 *
	 * @return the zzjgdm of this permit
	 */
	@AutoEscape
	public String getZzjgdm();

	/**
	 * Sets the zzjgdm of this permit.
	 *
	 * @param zzjgdm the zzjgdm of this permit
	 */
	public void setZzjgdm(String zzjgdm);

	/**
	 * Returns the bjbh of this permit.
	 *
	 * @return the bjbh of this permit
	 */
	@AutoEscape
	public String getBjbh();

	/**
	 * Sets the bjbh of this permit.
	 *
	 * @param bjbh the bjbh of this permit
	 */
	public void setBjbh(String bjbh);

	/**
	 * Returns the htxxbsbh of this permit.
	 *
	 * @return the htxxbsbh of this permit
	 */
	@AutoEscape
	public String getHtxxbsbh();

	/**
	 * Sets the htxxbsbh of this permit.
	 *
	 * @param htxxbsbh the htxxbsbh of this permit
	 */
	public void setHtxxbsbh(String htxxbsbh);

	/**
	 * Returns the sqbz of this permit.
	 *
	 * @return the sqbz of this permit
	 */
	public int getSqbz();

	/**
	 * Sets the sqbz of this permit.
	 *
	 * @param sqbz the sqbz of this permit
	 */
	public void setSqbz(int sqbz);

	/**
	 * Returns the status of this permit.
	 *
	 * @return the status of this permit
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this permit.
	 *
	 * @param status the status of this permit
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the bdh of this permit.
	 *
	 * @return the bdh of this permit
	 */
	@AutoEscape
	public String getBdh();

	/**
	 * Sets the bdh of this permit.
	 *
	 * @param bdh the bdh of this permit
	 */
	public void setBdh(String bdh);

	/**
	 * Returns the ywbh of this permit.
	 *
	 * @return the ywbh of this permit
	 */
	@AutoEscape
	public String getYwbh();

	/**
	 * Sets the ywbh of this permit.
	 *
	 * @param ywbh the ywbh of this permit
	 */
	public void setYwbh(String ywbh);

	/**
	 * Returns the sgxkzbh of this permit.
	 *
	 * @return the sgxkzbh of this permit
	 */
	@AutoEscape
	public String getSgxkzbh();

	/**
	 * Sets the sgxkzbh of this permit.
	 *
	 * @param sgxkzbh the sgxkzbh of this permit
	 */
	public void setSgxkzbh(String sgxkzbh);

	/**
	 * Returns the slbh of this permit.
	 *
	 * @return the slbh of this permit
	 */
	@AutoEscape
	public String getSlbh();

	/**
	 * Sets the slbh of this permit.
	 *
	 * @param slbh the slbh of this permit
	 */
	public void setSlbh(String slbh);

	/**
	 * Returns the hjgsz of this permit.
	 *
	 * @return the hjgsz of this permit
	 */
	public int getHjgsz();

	/**
	 * Sets the hjgsz of this permit.
	 *
	 * @param hjgsz the hjgsz of this permit
	 */
	public void setHjgsz(int hjgsz);

	/**
	 * Returns the hjgsh of this permit.
	 *
	 * @return the hjgsh of this permit
	 */
	public int getHjgsh();

	/**
	 * Sets the hjgsh of this permit.
	 *
	 * @param hjgsh the hjgsh of this permit
	 */
	public void setHjgsh(int hjgsh);

	/**
	 * Returns the sqr of this permit.
	 *
	 * @return the sqr of this permit
	 */
	@AutoEscape
	public String getSqr();

	/**
	 * Sets the sqr of this permit.
	 *
	 * @param sqr the sqr of this permit
	 */
	public void setSqr(String sqr);

	/**
	 * Returns the sqsx of this permit.
	 *
	 * @return the sqsx of this permit
	 */
	@AutoEscape
	public String getSqsx();

	/**
	 * Sets the sqsx of this permit.
	 *
	 * @param sqsx the sqsx of this permit
	 */
	public void setSqsx(String sqsx);

	/**
	 * Returns the sqh of this permit.
	 *
	 * @return the sqh of this permit
	 */
	@AutoEscape
	public String getSqh();

	/**
	 * Sets the sqh of this permit.
	 *
	 * @param sqh the sqh of this permit
	 */
	public void setSqh(String sqh);

	/**
	 * Returns the cltjr of this permit.
	 *
	 * @return the cltjr of this permit
	 */
	@AutoEscape
	public String getCltjr();

	/**
	 * Sets the cltjr of this permit.
	 *
	 * @param cltjr the cltjr of this permit
	 */
	public void setCltjr(String cltjr);

	/**
	 * Returns the cltjrlxdh of this permit.
	 *
	 * @return the cltjrlxdh of this permit
	 */
	@AutoEscape
	public String getCltjrlxdh();

	/**
	 * Sets the cltjrlxdh of this permit.
	 *
	 * @param cltjrlxdh the cltjrlxdh of this permit
	 */
	public void setCltjrlxdh(String cltjrlxdh);

	/**
	 * Returns the cltjrlxdz of this permit.
	 *
	 * @return the cltjrlxdz of this permit
	 */
	@AutoEscape
	public String getCltjrlxdz();

	/**
	 * Sets the cltjrlxdz of this permit.
	 *
	 * @param cltjrlxdz the cltjrlxdz of this permit
	 */
	public void setCltjrlxdz(String cltjrlxdz);

	/**
	 * Returns the sjr of this permit.
	 *
	 * @return the sjr of this permit
	 */
	@AutoEscape
	public String getSjr();

	/**
	 * Sets the sjr of this permit.
	 *
	 * @param sjr the sjr of this permit
	 */
	public void setSjr(String sjr);

	/**
	 * Returns the sjrlxdh of this permit.
	 *
	 * @return the sjrlxdh of this permit
	 */
	@AutoEscape
	public String getSjrlxdh();

	/**
	 * Sets the sjrlxdh of this permit.
	 *
	 * @param sjrlxdh the sjrlxdh of this permit
	 */
	public void setSjrlxdh(String sjrlxdh);

	/**
	 * Returns the slyj of this permit.
	 *
	 * @return the slyj of this permit
	 */
	@AutoEscape
	public String getSlyj();

	/**
	 * Sets the slyj of this permit.
	 *
	 * @param slyj the slyj of this permit
	 */
	public void setSlyj(String slyj);

	/**
	 * Returns the slsj of this permit.
	 *
	 * @return the slsj of this permit
	 */
	@AutoEscape
	public String getSlsj();

	/**
	 * Sets the slsj of this permit.
	 *
	 * @param slsj the slsj of this permit
	 */
	public void setSlsj(String slsj);

	/**
	 * Returns the nsgnr of this permit.
	 *
	 * @return the nsgnr of this permit
	 */
	@AutoEscape
	public String getNsgnr();

	/**
	 * Sets the nsgnr of this permit.
	 *
	 * @param nsgnr the nsgnr of this permit
	 */
	public void setNsgnr(String nsgnr);

	/**
	 * Returns the sgxkz file entry ID of this permit.
	 *
	 * @return the sgxkz file entry ID of this permit
	 */
	public long getSgxkzFileEntryId();

	/**
	 * Sets the sgxkz file entry ID of this permit.
	 *
	 * @param sgxkzFileEntryId the sgxkz file entry ID of this permit
	 */
	public void setSgxkzFileEntryId(long sgxkzFileEntryId);

	/**
	 * Returns the title of this permit.
	 *
	 * @return the title of this permit
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this permit.
	 *
	 * @param title the title of this permit
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this permit.
	 *
	 * @return the content of this permit
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this permit.
	 *
	 * @param content the content of this permit
	 */
	public void setContent(String content);

	/**
	 * Returns the status by user ID of this permit.
	 *
	 * @return the status by user ID of this permit
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this permit.
	 *
	 * @param statusByUserId the status by user ID of this permit
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this permit.
	 *
	 * @return the status by user uuid of this permit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this permit.
	 *
	 * @param statusByUserUuid the status by user uuid of this permit
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this permit.
	 *
	 * @return the status by user name of this permit
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this permit.
	 *
	 * @param statusByUserName the status by user name of this permit
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this permit.
	 *
	 * @return the status date of this permit
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this permit.
	 *
	 * @param statusDate the status date of this permit
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	 */
	@Override
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this permit is approved.
	 *
	 * @return <code>true</code> if this permit is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this permit is denied.
	 *
	 * @return <code>true</code> if this permit is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this permit is a draft.
	 *
	 * @return <code>true</code> if this permit is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this permit is expired.
	 *
	 * @return <code>true</code> if this permit is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this permit is inactive.
	 *
	 * @return <code>true</code> if this permit is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this permit is incomplete.
	 *
	 * @return <code>true</code> if this permit is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this permit is pending.
	 *
	 * @return <code>true</code> if this permit is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this permit is scheduled.
	 *
	 * @return <code>true</code> if this permit is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.justonetech.cp.permit.model.Permit permit);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.cp.permit.model.Permit> toCacheModel();

	@Override
	public com.justonetech.cp.permit.model.Permit toEscapedModel();

	@Override
	public com.justonetech.cp.permit.model.Permit toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}