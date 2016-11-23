package com.justonetech.biz.controller.query;

import com.justonetech.system.manager.SimpleQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 执业资格注册
 */
@Controller
public class PersonQualifyQueryController {

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @RequestMapping
    public String list(Model model) {

        String sql = "select a.QUALIFY_TYPE_DESC as QUALIFY_TYPE_DESC,a.QUALIFY_LEVEL_DESC as QUALIFY_LEVEL_DESC,a.thisCity as thisCity,b.otherCity as otherCity from " +
                "(select  QUALIFY_TYPE_DESC,QUALIFY_LEVEL_DESC,count(trim(qualify_belong_desc)) as thisCity from share_person_qualify where trim(qualify_belong_desc)='本市人员'  group by QUALIFY_TYPE_DESC,QUALIFY_LEVEL_DESC order by QUALIFY_LEVEL_DESC)  a  left join " +
                "(select  QUALIFY_TYPE_DESC,QUALIFY_LEVEL_DESC,count(trim(qualify_belong_desc)) as otherCity from share_person_qualify where trim(qualify_belong_desc)<>'本市人员'  group by QUALIFY_TYPE_DESC,QUALIFY_LEVEL_DESC order by QUALIFY_LEVEL_DESC)  b on a.QUALIFY_TYPE_DESC=b.QUALIFY_TYPE_DESC and a.QUALIFY_LEVEL_DESC=b.QUALIFY_LEVEL_DESC";
        List mapList = simpleQueryManager.getMapList(sql);
        model.addAttribute("mapList", mapList);
        return "view/query/personQualify/list";
    }
}
