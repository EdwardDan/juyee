package com.justonetech.biz.controller.www;

import com.justonetech.biz.daoservice.OaPublicInfoService;
import com.justonetech.biz.domain.OaPublicInfo;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaPublicInfoManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 外部网站
 * Date: 12-4-20
 */
@Controller
public class SiteController extends BaseCRUDActionController {

    @Autowired
    private OaPublicInfoManager oaPublicInfoManager;

    @Autowired
    private OaPublicInfoService oaPublicInfoService;

    @Autowired
    private DocumentManager documentManager;

    /**
     * 信息查看页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String infoView(Model model, Long id, String type) {

        OaPublicInfo oaPublicInfo = oaPublicInfoService.get(id);
        if (oaPublicInfo.getDocument() != null) {
            model.addAttribute("document", documentManager.getDownloadFile(oaPublicInfo.getDocument()));
        }
        model.addAttribute("bean", oaPublicInfo);

        //更新访问次数
        oaPublicInfoManager.updateVisitTimes(oaPublicInfo);

        return "view/www/infoView";
    }
}
