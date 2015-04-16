package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.biz.controller.query.ProjectQueryController;
import com.justonetech.biz.daoservice.ShareUnitInfoService;
import com.justonetech.biz.daoservice.ShareUnitQualifyService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
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
 * 手持终端信息交互--企业查询
 * User: Wu yang
 * Date: 12-3-19
 */
@Controller
public class AndroidUnitQualifyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ShareUnitInfoService shareUnitInfoService;

    @Autowired
    private ShareUnitQualifyService shareUnitQualifyService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model, String name) {
        String hql = "from ShareUnitInfo where unitName like '%" + name + "%' order by orgCode asc";
        List<ShareUnitInfo> shareUnitInfos = shareUnitInfoService.findByQuery(hql);
        String msg = new JSONSerializer().exclude("*.class").deepSerialize(shareUnitInfos);
        model.addAttribute("msg", msg);
        return "common/msg";
    }

    /**
     * 查看企业资质信息
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ShareUnitInfo data = shareUnitInfoService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bean", data);

        List<ShareUnitQualify> list = relateManager.getShareUnitQualifyList(data.getId());
        map.put("list", list);
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }

    /**
     * 查看人员资格信息
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String viewPerson(Model model, Long id) {
        ShareUnitInfo data = shareUnitInfoService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bean", data);

        List<SharePersonQualify> list = relateManager.getSharePersonQualifyList(data.getId());
        map.put("list", list);
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }

    /**
     * 查看承建工程信息
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String viewProject(Model model, Long id) {
        ShareUnitInfo data = shareUnitInfoService.get(id);
        Map<String, Object> mapp = new HashMap<String, Object>();
        mapp.put("bean", data);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<ShareProTobuild> projectList = relateManager.getShareProTobuildList(data.getId());
        for (ShareProTobuild proTobuild : projectList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("project", proTobuild);
            ExcelJdTasks proType = relateManager.getExcelJdTasks(proTobuild.getBjbh());
            if (proType != null) {
                map.put("typeName", proType.getReportType());
            }

            list.add(map);
        }
        mapp.put("list", list);
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(mapp));
        return "common/msg";
    }
}
