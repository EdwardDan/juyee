package com.justonetech.biz.utils.webService.workSiteWebservice.server;

import com.justonetech.biz.utils.webService.workSiteWebservice.bean.WorkSiteData;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * description:发布工地信息--传给平安工地用于完善工地信息
 * User: Chenjp
 * Date: 12-11-15 下午3:41
 */
@WebService
public interface WorkSiteWebService {

    @WebMethod
    public WorkSiteData getWorkSiteData(String gdbh);
}
