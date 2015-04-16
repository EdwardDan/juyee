package com.justonetech.biz.controller.query;

import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Shaxj
 * Date: 14-7-17
 * Time: 下午2:16
 */
@Controller
public class ProjectMapController extends BaseCRUDActionController<ShareProTobuild> {
    private Logger logger = LoggerFactory.getLogger(ProjectMapController.class);

    /**
     * 项目地图初始化页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {

        return "view/query/projectMap/init";
    }
}
