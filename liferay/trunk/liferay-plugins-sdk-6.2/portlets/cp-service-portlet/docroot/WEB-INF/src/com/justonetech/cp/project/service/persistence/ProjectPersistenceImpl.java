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

package com.justonetech.cp.project.service.persistence;

import com.justonetech.cp.project.NoSuchProjectException;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.model.impl.ProjectImpl;
import com.justonetech.cp.project.model.impl.ProjectModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ProjectPersistence
 * @see ProjectUtil
 * @generated
 */
public class ProjectPersistenceImpl extends BasePersistenceImpl<Project>
	implements ProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectPersistenceImpl() {
		setModelClass(Project.class);
	}

	/**
	 * Caches the project in the entity cache if it is enabled.
	 *
	 * @param project the project
	 */
	@Override
	public void cacheResult(Project project) {
		EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey(), project);

		project.resetOriginalValues();
	}

	/**
	 * Caches the projects in the entity cache if it is enabled.
	 *
	 * @param projects the projects
	 */
	@Override
	public void cacheResult(List<Project> projects) {
		for (Project project : projects) {
			if (EntityCacheUtil.getResult(
						ProjectModelImpl.ENTITY_CACHE_ENABLED,
						ProjectImpl.class, project.getPrimaryKey()) == null) {
				cacheResult(project);
			}
			else {
				project.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Project project) {
		EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Project> projects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Project project : projects) {
			EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
				ProjectImpl.class, project.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param bjbh the primary key for the new project
	 * @return the new project
	 */
	@Override
	public Project create(String bjbh) {
		Project project = new ProjectImpl();

		project.setNew(true);
		project.setPrimaryKey(bjbh);

		return project;
	}

	/**
	 * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bjbh the primary key of the project
	 * @return the project that was removed
	 * @throws com.justonetech.cp.project.NoSuchProjectException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project remove(String bjbh)
		throws NoSuchProjectException, SystemException {
		return remove((Serializable)bjbh);
	}

	/**
	 * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project that was removed
	 * @throws com.justonetech.cp.project.NoSuchProjectException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project remove(Serializable primaryKey)
		throws NoSuchProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Project project = (Project)session.get(ProjectImpl.class, primaryKey);

			if (project == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(project);
		}
		catch (NoSuchProjectException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Project removeImpl(Project project) throws SystemException {
		project = toUnwrappedModel(project);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(project)) {
				project = (Project)session.get(ProjectImpl.class,
						project.getPrimaryKeyObj());
			}

			if (project != null) {
				session.delete(project);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (project != null) {
			clearCache(project);
		}

		return project;
	}

	@Override
	public Project updateImpl(com.justonetech.cp.project.model.Project project)
		throws SystemException {
		project = toUnwrappedModel(project);

		boolean isNew = project.isNew();

		Session session = null;

		try {
			session = openSession();

			if (project.isNew()) {
				session.save(project);

				project.setNew(false);
			}
			else {
				session.merge(project);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey(), project);

		return project;
	}

	protected Project toUnwrappedModel(Project project) {
		if (project instanceof ProjectImpl) {
			return project;
		}

		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setNew(project.isNew());
		projectImpl.setPrimaryKey(project.getPrimaryKey());

		projectImpl.setBjbh(project.getBjbh());
		projectImpl.setBjrq(project.getBjrq());
		projectImpl.setJsdw(project.getJsdw());
		projectImpl.setJsdwxz(project.getJsdwxz());
		projectImpl.setJsdwdz(project.getJsdwdz());
		projectImpl.setJsdwdh(project.getJsdwdh());
		projectImpl.setJsdwfr(project.getJsdwfr());
		projectImpl.setJsdwlxr(project.getJsdwlxr());
		projectImpl.setJsdwyb(project.getJsdwyb());
		projectImpl.setJsdwzczj(project.getJsdwzczj());
		projectImpl.setXmmc(project.getXmmc());
		projectImpl.setJsdd(project.getJsdd());
		projectImpl.setLxwj(project.getLxwj());
		projectImpl.setLxwh(project.getLxwh());
		projectImpl.setLxjb(project.getLxjb());
		projectImpl.setPzjg(project.getPzjg());
		projectImpl.setPzrq(project.getPzrq());
		projectImpl.setZtz(project.getZtz());
		projectImpl.setSbtz(project.getSbtz());
		projectImpl.setJsxz(project.getJsxz());
		projectImpl.setJsgm(project.getJsgm());
		projectImpl.setZmj(project.getZmj());
		projectImpl.setKgrq(project.getKgrq());
		projectImpl.setXmxz(project.getXmxz());
		projectImpl.setCjqk(project.getCjqk());
		projectImpl.setSmqk(project.getSmqk());
		projectImpl.setBjbz(project.getBjbz());
		projectImpl.setFbzgsc(project.getFbzgsc());
		projectImpl.setCardid(project.getCardid());
		projectImpl.setZjlygc_1(project.getZjlygc_1());
		projectImpl.setZjlygc_2(project.getZjlygc_2());
		projectImpl.setZjlygc_3(project.getZjlygc_3());
		projectImpl.setZjlygc_4(project.getZjlygc_4());
		projectImpl.setZjlygc_5(project.getZjlygc_5());
		projectImpl.setZjlygc_6(project.getZjlygc_6());
		projectImpl.setZjlygc_7(project.getZjlygc_7());
		projectImpl.setZjlygc_8(project.getZjlygc_8());
		projectImpl.setZjlygc_9(project.getZjlygc_9());
		projectImpl.setJgxs(project.getJgxs());
		projectImpl.setXmfl(project.getXmfl());
		projectImpl.setJzmq(project.getJzmq());
		projectImpl.setYwdt(project.getYwdt());
		projectImpl.setDxsck(project.getDxsck());
		projectImpl.setBhjz(project.getBhjz());
		projectImpl.setFjms(project.getFjms());
		projectImpl.setSfsbxm(project.getSfsbxm());
		projectImpl.setHzyj(project.getHzyj());
		projectImpl.setBj_sx(project.getBj_sx());
		projectImpl.setBj_webid(project.getBj_webid());
		projectImpl.setBjwcbj(project.getBjwcbj());
		projectImpl.setBmdm(project.getBmdm());
		projectImpl.setJbr(project.getJbr());
		projectImpl.setShr(project.getShr());
		projectImpl.setShbmdm(project.getShbmdm());
		projectImpl.setWcbjsj(project.getWcbjsj());
		projectImpl.setOld_bjbh(project.getOld_bjbh());
		projectImpl.setSffb(project.getSffb());
		projectImpl.setTimeflag(project.getTimeflag());
		projectImpl.setJbrdm(project.getJbrdm());
		projectImpl.setShrdm(project.getShrdm());
		projectImpl.setJsbh(project.getJsbh());
		projectImpl.setNeedSbjl(project.getNeedSbjl());
		projectImpl.setWcSbjl(project.getWcSbjl());
		projectImpl.setSfgyzbkg(project.getSfgyzbkg());
		projectImpl.setJyzxfbxx(project.getJyzxfbxx());
		projectImpl.setSgGkzbfb(project.getSgGkzbfb());
		projectImpl.setSgjlGkzbfb(project.getSgjlGkzbfb());
		projectImpl.setFxglxm(project.getFxglxm());
		projectImpl.setFxglxmJbr(project.getFxglxmJbr());
		projectImpl.setFxglxmJbrdm(project.getFxglxmJbrdm());
		projectImpl.setFxglxmJbrq(project.getFxglxmJbrq());
		projectImpl.setJsdwjgdm(project.getJsdwjgdm());
		projectImpl.setSzqy(project.getSzqy());
		projectImpl.setYwxjfwjz(project.getYwxjfwjz());
		projectImpl.setYwgbfwjg(project.getYwgbfwjg());
		projectImpl.setGczh(project.getGczh());
		projectImpl.setZdcyyn(project.getZdcyyn());
		projectImpl.setLxfl(project.getLxfl());
		projectImpl.setMs1(project.getMs1());
		projectImpl.setMs2(project.getMs2());
		projectImpl.setMs3(project.getMs3());
		projectImpl.setZdxmyn(project.getZdxmyn());
		projectImpl.setDxjzsq(project.getDxjzsq());
		projectImpl.setYwjzxzz(project.getYwjzxzz());
		projectImpl.setFgwjhm(project.getFgwjhm());
		projectImpl.setZzbl(project.getZzbl());
		projectImpl.setChangeTime(project.getChangeTime());
		projectImpl.setPD_SW(project.getPD_SW());
		projectImpl.setBmpfrq(project.getBmpfrq());
		projectImpl.setBmpfwh(project.getBmpfwh());
		projectImpl.setBmpfwj(project.getBmpfwj());
		projectImpl.setCertificateKey(project.getCertificateKey());
		projectImpl.setDsjzmj(project.getDsjzmj());
		projectImpl.setDxjzmj(project.getDxjzmj());
		projectImpl.setGdzctzbh(project.getGdzctzbh());
		projectImpl.setJsxz_2011(project.getJsxz_2011());
		projectImpl.setLhmj(project.getLhmj());
		projectImpl.setLxjb_2011(project.getLxjb_2011());
		projectImpl.setMfmj(project.getMfmj());
		projectImpl.setOther_qx(project.getOther_qx());
		projectImpl.setProjectSlyj(project.getProjectSlyj());
		projectImpl.setQxbz(project.getQxbz());
		projectImpl.setSfcysjkfq(project.getSfcysjkfq());
		projectImpl.setSfmfss(project.getSfmfss());
		projectImpl.setSzqx(project.getSzqx());
		projectImpl.setTsgs(project.getTsgs());
		projectImpl.setXmfl_2011(project.getXmfl_2011());
		projectImpl.setXsjpw(project.getXsjpw());
		projectImpl.setXsjpzdw(project.getXsjpzdw());
		projectImpl.setZjlygc_10(project.getZjlygc_10());
		projectImpl.setZjlygc_11(project.getZjlygc_11());
		projectImpl.setZjlygc_xs_1(project.getZjlygc_xs_1());
		projectImpl.setZjlygc_xs_2(project.getZjlygc_xs_2());
		projectImpl.setZjlygc_xs_3(project.getZjlygc_xs_3());
		projectImpl.setZjlygc_xs_4(project.getZjlygc_xs_4());
		projectImpl.setZjlygc_1_2(project.getZjlygc_1_2());
		projectImpl.setZjlygc_1_2_4(project.getZjlygc_1_2_4());
		projectImpl.setYwptlh(project.getYwptlh());
		projectImpl.setGyyqbh(project.getGyyqbh());
		projectImpl.setSfcyxm(project.getSfcyxm());
		projectImpl.setZbxmfzrxm(project.getZbxmfzrxm());
		projectImpl.setZbxmfzrzjh(project.getZbxmfzrzjh());
		projectImpl.setZbxmfzrzjlx(project.getZbxmfzrzjlx());
		projectImpl.setZbxmfzrqrsj(project.getZbxmfzrqrsj());
		projectImpl.setSflsjzbs(project.getSflsjzbs());
		projectImpl.setSjbs(project.getSjbs());
		projectImpl.setYxbs(project.getYxbs());
		projectImpl.setSfyjngz(project.getSfyjngz());
		projectImpl.setSfsszpjz(project.getSfsszpjz());
		projectImpl.setZczxjgdmz(project.getZczxjgdmz());
		projectImpl.setIscheckxmbm(project.getIscheckxmbm());
		projectImpl.setZddtmj(project.getZddtmj());
		projectImpl.setSjjdYn(project.getSjjdYn());
		projectImpl.setSgjdYn(project.getSgjdYn());
		projectImpl.setYxjdYn(project.getYxjdYn());
		projectImpl.setTdhtqdbh(project.getTdhtqdbh());
		projectImpl.setTdhtqdrq(project.getTdhtqdrq());
		projectImpl.setDkbh(project.getDkbh());
		projectImpl.setZpsjzlsbl(project.getZpsjzlsbl());
		projectImpl.setZpsjzmj(project.getZpsjzmj());
		projectImpl.setDwyzzpl(project.getDwyzzpl());
		projectImpl.setZdh(project.getZdh());
		projectImpl.setSfgdcg(project.getSfgdcg());
		projectImpl.setPtlhmj(project.getPtlhmj());
		projectImpl.setBimjszxfy(project.getBimjszxfy());
		projectImpl.setBz(project.getBz());
		projectImpl.setSfzcxm(project.getSfzcxm());
		projectImpl.setZcxmbm(project.getZcxmbm());
		projectImpl.setSfzmqxm(project.getSfzmqxm());
		projectImpl.setPrintPDFTime(project.getPrintPDFTime());
		projectImpl.setIsBgPrint(project.getIsBgPrint());

		return projectImpl;
	}

	/**
	 * Returns the project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project
	 * @throws com.justonetech.cp.project.NoSuchProjectException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectException, SystemException {
		Project project = fetchByPrimaryKey(primaryKey);

		if (project == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return project;
	}

	/**
	 * Returns the project with the primary key or throws a {@link com.justonetech.cp.project.NoSuchProjectException} if it could not be found.
	 *
	 * @param bjbh the primary key of the project
	 * @return the project
	 * @throws com.justonetech.cp.project.NoSuchProjectException if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project findByPrimaryKey(String bjbh)
		throws NoSuchProjectException, SystemException {
		return findByPrimaryKey((Serializable)bjbh);
	}

	/**
	 * Returns the project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project, or <code>null</code> if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Project project = (Project)EntityCacheUtil.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
				ProjectImpl.class, primaryKey);

		if (project == _nullProject) {
			return null;
		}

		if (project == null) {
			Session session = null;

			try {
				session = openSession();

				project = (Project)session.get(ProjectImpl.class, primaryKey);

				if (project != null) {
					cacheResult(project);
				}
				else {
					EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
						ProjectImpl.class, primaryKey, _nullProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
					ProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return project;
	}

	/**
	 * Returns the project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bjbh the primary key of the project
	 * @return the project, or <code>null</code> if a project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project fetchByPrimaryKey(String bjbh) throws SystemException {
		return fetchByPrimaryKey((Serializable)bjbh);
	}

	/**
	 * Returns all the projects.
	 *
	 * @return the projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.project.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.project.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Project> list = (List<Project>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECT;

				if (pagination) {
					sql = sql.concat(ProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project>(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Project project : findAll()) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.project.model.Project")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Project>> listenersList = new ArrayList<ModelListener<Project>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Project>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECT = "SELECT project FROM Project project";
	private static final String _SQL_COUNT_PROJECT = "SELECT COUNT(project) FROM Project project";
	private static final String _ORDER_BY_ENTITY_ALIAS = "project.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectPersistenceImpl.class);
	private static Project _nullProject = new ProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Project> toCacheModel() {
				return _nullProjectCacheModel;
			}
		};

	private static CacheModel<Project> _nullProjectCacheModel = new CacheModel<Project>() {
			@Override
			public Project toEntityModel() {
				return _nullProject;
			}
		};
}