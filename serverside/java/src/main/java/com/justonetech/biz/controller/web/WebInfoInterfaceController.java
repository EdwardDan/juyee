package com.justonetech.biz.controller.web;

import com.justonetech.biz.daoservice.WebProjectInfoService;
import com.justonetech.biz.domain.WebProjectInfo;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * note: 接口
 * User: Shaxj
 * Date: 15-4-9
 * Time: 下午4:36
 */
@Controller
public class WebInfoInterfaceController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(WebInfoInterfaceController.class);

    @Autowired
    WebProjectInfoService webProjectInfoService;


    @RequestMapping
    public String getDealResultProjectInfo(Model model) {
        List<WebProjectInfo> projectInfoLists = webProjectInfoService.findAll();


        model.addAttribute("msg", "保存成功！");
        return "common/androidMsg";
    }


}
