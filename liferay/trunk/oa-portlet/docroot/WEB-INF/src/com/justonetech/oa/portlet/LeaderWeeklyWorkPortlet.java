
package com.justonetech.oa.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LeaderWeeklyWorkPortlet
 */
public class LeaderWeeklyWorkPortlet extends MVCPortlet {

    private static Log log = LogFactoryUtil.getLog(LeaderWeeklyWorkPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        Role role = null;
        try {
            role = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(renderRequest), "中心领导");
            renderRequest.setAttribute("roleId", role.getRoleId());
        }
        catch (PortalException | SystemException e) {
            log.info("没有名为中心领导的角色。");
        }
        super.doView(renderRequest, renderResponse);
    }

}
