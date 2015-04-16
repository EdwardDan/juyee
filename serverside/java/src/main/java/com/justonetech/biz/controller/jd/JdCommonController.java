package com.justonetech.biz.controller.jd;

import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * note:外网监管平台公用类
 * User: guoqiong
 * Date: 14-7-9
 */
@Controller
public class JdCommonController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(JdCommonController.class);

    @Autowired
    private RegPersonManager regPersonManager;

    /**
     * 选择报建编号
     *
     * @param model .
     * @param url   需跳转的链接
     * @param title   .
     * @return .
     */
    @RequestMapping
    public String selectJdTaskCode(Model model, String url, String title) {
        model.addAttribute("bjbhs", regPersonManager.getBjbhs());
        model.addAttribute("url", url);
        model.addAttribute("title", title);

        return "view/jd/jdCommon/selectJdTaskCode";
    }
}
