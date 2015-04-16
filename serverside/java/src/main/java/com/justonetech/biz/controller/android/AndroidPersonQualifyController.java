package com.justonetech.biz.controller.android;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.biz.controller.query.ProjectQueryController;
import com.justonetech.biz.daoservice.SharePersonQualifyService;
import com.justonetech.biz.domain.SharePersonQualify;
import com.justonetech.biz.manager.RelateManager;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手持终端信息交互--人员查询
 * User: Wu yang
 * Date: 12-3-19
 */
@Controller
public class AndroidPersonQualifyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);


    @Autowired
    private RelateManager relateManager;

    @Autowired
    private SharePersonQualifyService sharePersonQualifyService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model,String name) {
        String hql = "from SharePersonQualify where personName like '%" + name + "%' order by personName asc";
        List<SharePersonQualify> sharePersonQualifies = sharePersonQualifyService.findByQuery(hql);
        String msg = new JSONSerializer().exclude("*.class").deepSerialize(sharePersonQualifies);
        model.addAttribute("msg", msg);
        return "common/msg";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        SharePersonQualify data = sharePersonQualifyService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bean", data);

        map.put("unit", relateManager.getShareUnitInfo(data.getRegUnitId()));
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }
}
