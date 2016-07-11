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

package com.justonetech.oa.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author justonetech
 * @generated
 */
public class DeptWorkItemSoap implements Serializable {
	public static DeptWorkItemSoap toSoapModel(DeptWorkItem model) {
		DeptWorkItemSoap soapModel = new DeptWorkItemSoap();

		soapModel.setDeptWorkItemId(model.getDeptWorkItemId());
		soapModel.setDeptWorkId(model.getDeptWorkId());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setDutyPerson(model.getDutyPerson());
		soapModel.setMainWork(model.getMainWork());
		soapModel.setSchedule(model.getSchedule());
		soapModel.setContent(model.getContent());
		soapModel.setAgentPerson(model.getAgentPerson());

		return soapModel;
	}

	public static DeptWorkItemSoap[] toSoapModels(DeptWorkItem[] models) {
		DeptWorkItemSoap[] soapModels = new DeptWorkItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeptWorkItemSoap[][] toSoapModels(DeptWorkItem[][] models) {
		DeptWorkItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeptWorkItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeptWorkItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeptWorkItemSoap[] toSoapModels(List<DeptWorkItem> models) {
		List<DeptWorkItemSoap> soapModels = new ArrayList<DeptWorkItemSoap>(models.size());

		for (DeptWorkItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeptWorkItemSoap[soapModels.size()]);
	}

	public DeptWorkItemSoap() {
	}

	public long getPrimaryKey() {
		return _deptWorkItemId;
	}

	public void setPrimaryKey(long pk) {
		setDeptWorkItemId(pk);
	}

	public long getDeptWorkItemId() {
		return _deptWorkItemId;
	}

	public void setDeptWorkItemId(long deptWorkItemId) {
		_deptWorkItemId = deptWorkItemId;
	}

	public long getDeptWorkId() {
		return _deptWorkId;
	}

	public void setDeptWorkId(long deptWorkId) {
		_deptWorkId = deptWorkId;
	}

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public String getDutyPerson() {
		return _dutyPerson;
	}

	public void setDutyPerson(String dutyPerson) {
		_dutyPerson = dutyPerson;
	}

	public boolean getMainWork() {
		return _mainWork;
	}

	public boolean isMainWork() {
		return _mainWork;
	}

	public void setMainWork(boolean mainWork) {
		_mainWork = mainWork;
	}

	public String getSchedule() {
		return _schedule;
	}

	public void setSchedule(String schedule) {
		_schedule = schedule;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getAgentPerson() {
		return _agentPerson;
	}

	public void setAgentPerson(String agentPerson) {
		_agentPerson = agentPerson;
	}

	private long _deptWorkItemId;
	private long _deptWorkId;
	private int _sortNo;
	private String _dutyPerson;
	private boolean _mainWork;
	private String _schedule;
	private String _content;
	private String _agentPerson;
}