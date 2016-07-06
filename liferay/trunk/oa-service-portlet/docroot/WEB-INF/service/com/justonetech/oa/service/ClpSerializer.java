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

package com.justonetech.oa.service;

import com.justonetech.oa.model.DeptWorkClp;
import com.justonetech.oa.model.DeptWorkItemClp;
import com.justonetech.oa.model.DispatchClp;
import com.justonetech.oa.model.LeaderWorkClp;
import com.justonetech.oa.model.OfficeSupplyApplicationClp;
import com.justonetech.oa.model.OfficeSupplyApplicationItemClp;
import com.justonetech.oa.model.OfficeSupplyClp;
import com.justonetech.oa.model.VehicleApplicationClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author justonetech
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"oa-service-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"oa-service-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "oa-service-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DeptWorkClp.class.getName())) {
			return translateInputDeptWork(oldModel);
		}

		if (oldModelClassName.equals(DeptWorkItemClp.class.getName())) {
			return translateInputDeptWorkItem(oldModel);
		}

		if (oldModelClassName.equals(DispatchClp.class.getName())) {
			return translateInputDispatch(oldModel);
		}

		if (oldModelClassName.equals(LeaderWorkClp.class.getName())) {
			return translateInputLeaderWork(oldModel);
		}

		if (oldModelClassName.equals(OfficeSupplyClp.class.getName())) {
			return translateInputOfficeSupply(oldModel);
		}

		if (oldModelClassName.equals(OfficeSupplyApplicationClp.class.getName())) {
			return translateInputOfficeSupplyApplication(oldModel);
		}

		if (oldModelClassName.equals(
					OfficeSupplyApplicationItemClp.class.getName())) {
			return translateInputOfficeSupplyApplicationItem(oldModel);
		}

		if (oldModelClassName.equals(VehicleApplicationClp.class.getName())) {
			return translateInputVehicleApplication(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDeptWork(BaseModel<?> oldModel) {
		DeptWorkClp oldClpModel = (DeptWorkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeptWorkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDeptWorkItem(BaseModel<?> oldModel) {
		DeptWorkItemClp oldClpModel = (DeptWorkItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeptWorkItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDispatch(BaseModel<?> oldModel) {
		DispatchClp oldClpModel = (DispatchClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDispatchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLeaderWork(BaseModel<?> oldModel) {
		LeaderWorkClp oldClpModel = (LeaderWorkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLeaderWorkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOfficeSupply(BaseModel<?> oldModel) {
		OfficeSupplyClp oldClpModel = (OfficeSupplyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOfficeSupplyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOfficeSupplyApplication(
		BaseModel<?> oldModel) {
		OfficeSupplyApplicationClp oldClpModel = (OfficeSupplyApplicationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOfficeSupplyApplicationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOfficeSupplyApplicationItem(
		BaseModel<?> oldModel) {
		OfficeSupplyApplicationItemClp oldClpModel = (OfficeSupplyApplicationItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOfficeSupplyApplicationItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVehicleApplication(BaseModel<?> oldModel) {
		VehicleApplicationClp oldClpModel = (VehicleApplicationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVehicleApplicationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.DeptWorkImpl")) {
			return translateOutputDeptWork(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.DeptWorkItemImpl")) {
			return translateOutputDeptWorkItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.DispatchImpl")) {
			return translateOutputDispatch(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.LeaderWorkImpl")) {
			return translateOutputLeaderWork(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.OfficeSupplyImpl")) {
			return translateOutputOfficeSupply(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.OfficeSupplyApplicationImpl")) {
			return translateOutputOfficeSupplyApplication(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.OfficeSupplyApplicationItemImpl")) {
			return translateOutputOfficeSupplyApplicationItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.justonetech.oa.model.impl.VehicleApplicationImpl")) {
			return translateOutputVehicleApplication(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.justonetech.oa.NoSuchDeptWorkException")) {
			return new com.justonetech.oa.NoSuchDeptWorkException();
		}

		if (className.equals("com.justonetech.oa.NoSuchDeptWorkItemException")) {
			return new com.justonetech.oa.NoSuchDeptWorkItemException();
		}

		if (className.equals("com.justonetech.oa.NoSuchDispatchException")) {
			return new com.justonetech.oa.NoSuchDispatchException();
		}

		if (className.equals("com.justonetech.oa.NoSuchLeaderWorkException")) {
			return new com.justonetech.oa.NoSuchLeaderWorkException();
		}

		if (className.equals("com.justonetech.oa.NoSuchOfficeSupplyException")) {
			return new com.justonetech.oa.NoSuchOfficeSupplyException();
		}

		if (className.equals(
					"com.justonetech.oa.NoSuchOfficeSupplyApplicationException")) {
			return new com.justonetech.oa.NoSuchOfficeSupplyApplicationException();
		}

		if (className.equals(
					"com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException")) {
			return new com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException();
		}

		if (className.equals(
					"com.justonetech.oa.NoSuchVehicleApplicationException")) {
			return new com.justonetech.oa.NoSuchVehicleApplicationException();
		}

		return throwable;
	}

	public static Object translateOutputDeptWork(BaseModel<?> oldModel) {
		DeptWorkClp newModel = new DeptWorkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeptWorkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDeptWorkItem(BaseModel<?> oldModel) {
		DeptWorkItemClp newModel = new DeptWorkItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeptWorkItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDispatch(BaseModel<?> oldModel) {
		DispatchClp newModel = new DispatchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDispatchRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLeaderWork(BaseModel<?> oldModel) {
		LeaderWorkClp newModel = new LeaderWorkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLeaderWorkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOfficeSupply(BaseModel<?> oldModel) {
		OfficeSupplyClp newModel = new OfficeSupplyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOfficeSupplyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOfficeSupplyApplication(
		BaseModel<?> oldModel) {
		OfficeSupplyApplicationClp newModel = new OfficeSupplyApplicationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOfficeSupplyApplicationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOfficeSupplyApplicationItem(
		BaseModel<?> oldModel) {
		OfficeSupplyApplicationItemClp newModel = new OfficeSupplyApplicationItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOfficeSupplyApplicationItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVehicleApplication(
		BaseModel<?> oldModel) {
		VehicleApplicationClp newModel = new VehicleApplicationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVehicleApplicationRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}