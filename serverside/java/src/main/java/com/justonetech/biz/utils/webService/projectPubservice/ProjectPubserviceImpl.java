package com.justonetech.biz.utils.webService.projectPubservice;

import com.justonetech.biz.daoservice.ShareProTobuildService;
import com.justonetech.biz.domain.ShareProContract;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.RelateManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class ProjectPubserviceImpl implements ProjectPubservice {

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private RelateManager relateManager;

    @WebMethod
    public List<WebProToBuild> getAllProBuildInfo() {
        List<WebProToBuild> webProToBuilds = new ArrayList<WebProToBuild>();
        List<ShareProTobuild> shareProTobuilds = shareProTobuildService.findByQuery("from ShareProTobuild where rownum<1000");
        for (ShareProTobuild shareProTobuild : shareProTobuilds) {
            WebProToBuild webProToBuild = new WebProToBuild();
            webProToBuild.setApprovalDate(shareProTobuild.getApprovalDate());
            webProToBuild.setApprovalUnit(shareProTobuild.getApprovalUnit());
            webProToBuild.setBjbh(shareProTobuild.getBjbh());
            webProToBuild.setBjDate(shareProTobuild.getBjDate());
            webProToBuild.setBuildAddress(shareProTobuild.getBuildAddress());
            webProToBuild.setBuildUnitName(shareProTobuild.getBuildUnitName());
            webProToBuild.setLxFile(shareProTobuild.getLxFile());
            webProToBuild.setLxFileCode(shareProTobuild.getLxFile());
            webProToBuild.setProjectName(shareProTobuild.getProjectName());
            webProToBuild.setTotalInvestment(shareProTobuild.getTotalInvestment());
            webProToBuild.setLxLevel(shareProTobuild.getLxLevel());
            webProToBuild.setTotalArea(shareProTobuild.getTotalArea());
            List<ShareProContract> shareProContracts = relateManager.getShareProContractList(shareProTobuild.getBjbh());
            List<WebshareProContract> webshareProContracts = new ArrayList<WebshareProContract>();
            if (shareProContracts != null) {
                for (ShareProContract shareProContract : shareProContracts) {
                    WebshareProContract webshareProContract = new WebshareProContract();
                    webshareProContract.setCbUnit(shareProContract.getCbUnit());
                    webshareProContract.setProHeader(shareProContract.getProHeader());
                    webshareProContract.setProHeaderPhone(shareProContract.getProHeaderPhone());
                    webshareProContracts.add(webshareProContract);
                }
            }
            webProToBuild.setWebshareProContract(webshareProContracts);
            webProToBuilds.add(webProToBuild);
        }
        return webProToBuilds;
    }

}