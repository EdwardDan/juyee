package com.justonetech.biz.controller.query;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业资质统计
 */
@Controller
public class UnitQualifyQueryController {

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @RequestMapping
    public String list(Model model) {
        String sql = "select a.type as typeDesc,a.总计 as total,b.本市 as thisCity,c.外省 as otherCity from " +
                "(select qu.qualify_big_type_desc as type ,count(qu.qualify_big_type_desc) as 总计,count(info.belog_province) as 本市 from share_unit_qualify qu,share_unit_info info where qu.unit_id=info.id  group by qu.qualify_big_type_desc order by qu.qualify_big_type_desc)  a left join " +
                "(select qu.qualify_big_type_desc as type,count(qu.qualify_big_type_desc) as 本市 from share_unit_qualify qu,share_unit_info info where qu.unit_id=info.id and info.belog_province= '上海市'  group by qu.qualify_big_type_desc order by qu.qualify_big_type_desc) b on a.type=b.type left join " +
                "(select qu.qualify_big_type_desc as type,count(qu.qualify_big_type_desc) as 外省 from share_unit_qualify qu,share_unit_info info where qu.unit_id=info.id and info.belog_province<> '上海市' group by qu.qualify_big_type_desc order by qu.qualify_big_type_desc) c on  b.type=c.type";
        List<Map> mapList = simpleQueryManager.getMapList(sql);
        model.addAttribute("mapList", mapList);
        return "view/query/unitQualify/list";
    }

}
