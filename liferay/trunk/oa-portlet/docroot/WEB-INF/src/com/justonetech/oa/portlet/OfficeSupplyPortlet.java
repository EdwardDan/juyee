
package com.justonetech.oa.portlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.OfficeSupply;
import com.justonetech.oa.service.OfficeSupplyLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OfficeSupplyPortlet
 */
public class OfficeSupplyPortlet extends MVCPortlet {

    private static Log log = LogFactoryUtil.getLog(OfficeSupplyPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        String keywords = ParamUtil.getString(renderRequest, "keywords");
        int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
        int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
        int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
        int start = pageSize * (pageNumber - 1);
        int end = pageSize * pageNumber;

        List<OfficeSupply> officeSupplies = Collections.emptyList();
        try {
            officeSupplies = OfficeSupplyLocalServiceUtil.findByName(keywords, start, end);
        }
        catch (SystemException e) {
            log.error("getOfficeSuppliesByName(" + keywords + ", " + start + ", " + end + ")出错：" + e.getMessage());
        }
        int officeSuppliesCount = 0;
        try {
            officeSuppliesCount = OfficeSupplyLocalServiceUtil.countByName(keywords);
        }
        catch (SystemException e) {
            log.error("getOfficeSuppliesCountByName(" + keywords + ")出错：" + e.getMessage());

        }
        renderRequest.setAttribute("officeSupplies", officeSupplies);
        renderRequest.setAttribute("officeSuppliesCount", officeSuppliesCount);

        super.doView(renderRequest, renderResponse);
    }

    public void editOfficeSupply(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException, PortalException, SystemException {

        long officeSupplyId = ParamUtil.getLong(actionRequest, "officeSupplyId");
        OfficeSupply officeSupply = null;
        if (officeSupplyId != 0) {
            officeSupply = OfficeSupplyLocalServiceUtil.getOfficeSupply(officeSupplyId);
        }
        actionRequest.setAttribute("officeSupply", officeSupply);
    }

    public void saveOfficeSupply(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException, SystemException, PortalException {

        long officeSupplyId = ParamUtil.getLong(actionRequest, "officeSupplyId");
        String name = ParamUtil.getString(actionRequest, "name");
        String model = ParamUtil.getString(actionRequest, "model");
        String unit = ParamUtil.getString(actionRequest, "unit");
        double unitPrice = ParamUtil.getDouble(actionRequest, "unitPrice");
        int quantity = ParamUtil.getInteger(actionRequest, "quantity");
        OfficeSupply officeSupply = null;
        Date now = new Date();
        if (officeSupplyId == 0) {
            officeSupplyId = CounterLocalServiceUtil.increment();
            officeSupply = OfficeSupplyLocalServiceUtil.createOfficeSupply(officeSupplyId);

            officeSupply.setCreateTime(now);
        }
        else {
            officeSupply = OfficeSupplyLocalServiceUtil.getOfficeSupply(officeSupplyId);
        }

        User user = PortalUtil.getUser(actionRequest);
        if (Validator.isNotNull(user)) {
            officeSupply.setUserId(user.getUserId());
            officeSupply.setUserName(user.getFullName());
        }

        officeSupply.setName(name);
        officeSupply.setModel(model);
        officeSupply.setUnit(unit);
        officeSupply.setUnitPrice(unitPrice);
        officeSupply.setQuantity(quantity);
        officeSupply.setModifiedTime(now);
        OfficeSupplyLocalServiceUtil.updateOfficeSupply(officeSupply);
    }

    public void deleteOfficeSupplies(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

        String deleteOfficeSupplyIds = ParamUtil.getString(actionRequest, "officeSupplyIds");
        String[] officeSupplyIds = deleteOfficeSupplyIds.split(",");
        OfficeSupplyLocalServiceUtil.deleteOfficeSupplies(officeSupplyIds);
    }

}
