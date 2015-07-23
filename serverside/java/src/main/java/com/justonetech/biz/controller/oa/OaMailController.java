package com.justonetech.biz.controller.oa;

import com.justonetech.biz.domain.OaMail;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * note:邮件信息
 * author: guoqiong
 * create date:
 * modify date:
 */
@Controller
public class OaMailController extends BaseCRUDActionController<OaMail> {
    private Logger logger = LoggerFactory.getLogger(OaMailController.class);

    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/oa/oaMail/init";
    }

}