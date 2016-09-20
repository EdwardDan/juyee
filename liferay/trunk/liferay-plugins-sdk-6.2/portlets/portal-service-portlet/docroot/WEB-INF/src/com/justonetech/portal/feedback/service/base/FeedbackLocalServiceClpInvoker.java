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

package com.justonetech.portal.feedback.service.base;

import com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil;

import java.util.Arrays;

/**
 * @author fanqi
 * @generated
 */
public class FeedbackLocalServiceClpInvoker {
	public FeedbackLocalServiceClpInvoker() {
		_methodName0 = "addFeedback";

		_methodParameterTypes0 = new String[] {
				"com.justonetech.portal.feedback.model.Feedback"
			};

		_methodName1 = "createFeedback";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFeedback";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFeedback";

		_methodParameterTypes3 = new String[] {
				"com.justonetech.portal.feedback.model.Feedback"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchFeedback";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getFeedback";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getFeedbacks";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getFeedbacksCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateFeedback";

		_methodParameterTypes15 = new String[] {
				"com.justonetech.portal.feedback.model.Feedback"
			};

		_methodName32 = "getBeanIdentifier";

		_methodParameterTypes32 = new String[] {  };

		_methodName33 = "setBeanIdentifier";

		_methodParameterTypes33 = new String[] { "java.lang.String" };

		_methodName38 = "getFeedbacks";

		_methodParameterTypes38 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName39 = "getFeedbacksCount";

		_methodParameterTypes39 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName40 = "createDynamicQuery";

		_methodParameterTypes40 = new String[] {
				"java.lang.String", "long", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FeedbackLocalServiceUtil.addFeedback((com.justonetech.portal.feedback.model.Feedback)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FeedbackLocalServiceUtil.createFeedback(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FeedbackLocalServiceUtil.deleteFeedback(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FeedbackLocalServiceUtil.deleteFeedback((com.justonetech.portal.feedback.model.Feedback)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FeedbackLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FeedbackLocalServiceUtil.fetchFeedback(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FeedbackLocalServiceUtil.getFeedback(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FeedbackLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FeedbackLocalServiceUtil.getFeedbacks(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FeedbackLocalServiceUtil.getFeedbacksCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FeedbackLocalServiceUtil.updateFeedback((com.justonetech.portal.feedback.model.Feedback)arguments[0]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return FeedbackLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			FeedbackLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return FeedbackLocalServiceUtil.getFeedbacks((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return FeedbackLocalServiceUtil.getFeedbacksCount((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return FeedbackLocalServiceUtil.createDynamicQuery((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
}