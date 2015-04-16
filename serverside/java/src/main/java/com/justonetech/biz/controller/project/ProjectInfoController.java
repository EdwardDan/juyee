package com.justonetech.biz.controller.project;

import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.manager.ExcelJdTasksManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.projectInfo.CustomProjectInfo;
import com.justonetech.core.controller.BaseCRUDActionController;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 获取工程信息接口
 * author:
 * modify date:
 */
@Controller
public class ProjectInfoController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ProjectInfoController.class);

    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    /**
     * 根据报建编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfoByBjbh(String bjbh, Model model) {
        String json = "";
//        ShareProTobuild project = projectManager.getProject(bjbh);
        CustomProjectInfo project = projectManager.getProjectInfoByBjbh(bjbh);
        if (project != null) {
            JSONArray jsonArray = JSONArray.fromObject(project);
            json = jsonArray.toString();
        }
        model.addAttribute("msg", json);
        return "common/msg";
    }


    /**
     * 获取工程信息提供给监督报告、监督预约等模块使用
     *
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getProjectInfoByJdTaskCode(String jdTaskCode, Model model) {
        String json = "";
        CustomProjectInfo project = projectManager.getProjectInfoByJdTaskCode(jdTaskCode);
        if (project != null) {
            JSONArray jsonArray = JSONArray.fromObject(project);
            json = jsonArray.toString();
        }

//        Map<String, Object> allProjectInfos = projectManager.getAllProjectInfoByJdTaskCode(jdTaskCode, null);
//        System.out.println("allProjectInfo = " + allProjectInfo);
//        allProjectInfos.put("jdDatetime", "");     //注意：日期不能序列化
//        JSONArray jsonArray = JSONArray.fromObject(allProjectInfos);
//        allProjectInfos.clear();
//        String json = jsonArray.toString();

        model.addAttribute("msg", json);
        return "common/msg";
    }

    /**
     * 根据监督任务书编号获取工程信息
     *
     * @param jdTaskCode  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getDwgcsByJdTaskCode(String jdTaskCode, Model model) {
        String json = "";
        List<ExcelJdDwgc> dwgcLists = excelJdTasksManager.getExcelJdDwgcs(jdTaskCode);
        Map<String, String> map = new HashMap<String, String>();

        if (dwgcLists != null) {
            for(ExcelJdDwgc ex:dwgcLists){
                map.put(String.valueOf(ex.getId()),ex.getDwgcName());
            }
            JSONArray jsonArray = JSONArray.fromObject(map);
            json = jsonArray.toString();
        }
        model.addAttribute("msg", json);
        System.out.printf(json);
        return "common/msg";
    }
}