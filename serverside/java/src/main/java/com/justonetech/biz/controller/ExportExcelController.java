package com.justonetech.biz.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
public class ExportExcelController extends BaseCRUDActionController {


    /**
     * 列表导出
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String export(Model model, String cols, String showtitles) {
        String[] col = cols.split(",");
        List<String> colList = new ArrayList<String>(Arrays.asList(col));
        String[] showtitle = showtitles.split(",");
        List<String> showtitleList = new ArrayList<String>(Arrays.asList(showtitle));
        List list = new ArrayList();
        Map<String, String> map;
        for (int i = 0; i < colList.size(); i++) {
            if (!colList.get(i).equals("operation")) {
                map = new HashMap();
                map.put("cols", colList.get(i));
                map.put("titles", showtitleList.get(i));
                list.add(map);
            }
        }
        model.addAttribute("bean", list);
        return "view/workflow/bpmSwimlane/export";
    }
}