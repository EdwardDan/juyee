package com.justonetech.projApproval.service.impl;

import java.util.Date;
import java.util.List;

import com.justonetech.projApproval.model.ConstructionPermit;
import com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil;
import com.justonetech.projApproval.service.base.ConstructionPermitLocalServiceBaseImpl;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the construction permit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.projApproval.service.ConstructionPermitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.projApproval.service.base.ConstructionPermitLocalServiceBaseImpl
 * @see com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil
 */
public class ConstructionPermitLocalServiceImpl
	extends ConstructionPermitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil} to access the construction permit local service.
	 */

	public List<ConstructionPermit> findByUserId(long userId, int start, int end)
			throws SystemException {
		return constructionPermitPersistence.findByUserId(userId, start, end);
	}

	public int countByUserId(long userId) throws SystemException {

		return constructionPermitPersistence.countByUserId(userId);
	}

	public void deleteConstructionPermits(String[] constructionPermitIds) {

		for (String constructionPermitId : constructionPermitIds) {
			try {
				ConstructionPermitLocalServiceUtil
						.deleteConstructionPermit(Long
								.parseLong(constructionPermitId));
			} catch (NumberFormatException | PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
	}
	public ConstructionPermit updateStatus(long userId, long resourcePrimKey,
			int status, ServiceContext serviceContext)
			throws NoSuchUserException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		ConstructionPermit constructionPermit = constructionPermitPersistence
				.fetchByPrimaryKey(resourcePrimKey);

		constructionPermit.setModifiedTime(serviceContext.getModifiedDate(now));
		constructionPermit.setStatus(status);
		constructionPermit.setStatusByUserId(user.getUserId());
		constructionPermit.setStatusByUserName(user.getFullName());
		constructionPermit.setStatusDate(serviceContext.getModifiedDate(now));
		constructionPermitPersistence.update(constructionPermit);
		return constructionPermit;
	}

}