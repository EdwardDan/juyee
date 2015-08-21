package com.justonetech.biz.controller.oa;

import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.DocumentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 外部通讯录
 * User: gq
 * Date: 15-8-20
 */
@Controller
public class TxlController {

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    @Autowired
    private DocumentManager documentManager;

    /**
     * 通讯录1
     *
     * @param id .
     * @return .
     */
    @RequestMapping
    public String txl(Long id, Model model) {
        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);
        if (oaPublicInfo.getDocument() != null) {
            model.addAttribute("document", documentManager.getDownloadFile(oaPublicInfo.getDocument()));
        }
        model.addAttribute("bean", oaPublicInfo);

        return "view/oa/txl/view";
    }
}
