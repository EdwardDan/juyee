package com.justonetech.biz.utils.webService.projectPubservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService()
public interface ProjectPubservice {
    @WebMethod
    public List<WebProToBuild> getAllProBuildInfo();
}