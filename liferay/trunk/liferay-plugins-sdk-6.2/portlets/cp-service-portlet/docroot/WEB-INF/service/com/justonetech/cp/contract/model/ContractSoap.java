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

package com.justonetech.cp.contract.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class ContractSoap implements Serializable {
	public static ContractSoap toSoapModel(Contract model) {
		ContractSoap soapModel = new ContractSoap();

		soapModel.setContractId(model.getContractId());
		soapModel.setHtlb(model.getHtlb());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setBdh(model.getBdh());
		soapModel.setCbfs(model.getCbfs());
		soapModel.setHtmc(model.getHtmc());

		return soapModel;
	}

	public static ContractSoap[] toSoapModels(Contract[] models) {
		ContractSoap[] soapModels = new ContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[][] toSoapModels(Contract[][] models) {
		ContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[] toSoapModels(List<Contract> models) {
		List<ContractSoap> soapModels = new ArrayList<ContractSoap>(models.size());

		for (Contract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContractSoap[soapModels.size()]);
	}

	public ContractSoap() {
	}

	public String getPrimaryKey() {
		return _contractId;
	}

	public void setPrimaryKey(String pk) {
		setContractId(pk);
	}

	public String getContractId() {
		return _contractId;
	}

	public void setContractId(String contractId) {
		_contractId = contractId;
	}

	public String getHtlb() {
		return _htlb;
	}

	public void setHtlb(String htlb) {
		_htlb = htlb;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getBdh() {
		return _bdh;
	}

	public void setBdh(String bdh) {
		_bdh = bdh;
	}

	public String getCbfs() {
		return _cbfs;
	}

	public void setCbfs(String cbfs) {
		_cbfs = cbfs;
	}

	public String getHtmc() {
		return _htmc;
	}

	public void setHtmc(String htmc) {
		_htmc = htmc;
	}

	private String _contractId;
	private String _htlb;
	private String _bjbh;
	private String _bdh;
	private String _cbfs;
	private String _htmc;
}