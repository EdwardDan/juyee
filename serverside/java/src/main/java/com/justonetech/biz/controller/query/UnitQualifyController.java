package com.justonetech.biz.controller.query;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ShareUnitInfoService;
import com.justonetech.biz.daoservice.ShareUnitQualifyService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业信息查询---用于项目查询
 * User: Chen Junping
 * Date: 12-3-19
 */
@Controller
public class UnitQualifyController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ShareUnitInfoService shareUnitInfoService;

    @Autowired
    private ShareUnitQualifyService shareUnitQualifyService;

    /**
     * 列表显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/query/unitQualify/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response
     * @param filters
     * @param columns
     * @param page
     * @param rows
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ShareUnitInfo order by orgCode asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = shareUnitInfoService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看企业资质信息
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String view(Model model, Long id,String deptName) {
        ShareUnitInfo data = null;
        List<ShareUnitQualify> list = null;
        if(id>0){
            data = shareUnitInfoService.get(id);
        }else if(!StringHelper.isEmpty(deptName)){
            List<ShareUnitInfo> infos = shareUnitInfoService.findByQuery("from ShareUnitInfo where unitName=?", deptName);
            if(infos.size()>0){
                data = infos.iterator().next();
            }
        }
        if(data != null){
            list = relateManager.getShareUnitQualifyList(data.getId());
        }else{
            data = new ShareUnitInfo();
            list = new ArrayList<ShareUnitQualify>();
        }
        model.addAttribute("bean", data);
        model.addAttribute("list", list);
        return "view/query/unitQualify/view";
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
        model.addAttribute("bean", data);

        List<SharePersonQualify> list = relateManager.getSharePersonQualifyList(data.getId());
        model.addAttribute("list", list);
        return "view/query/unitQualify/viewPerson";
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
        model.addAttribute("bean", data);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<ShareProTobuild> projectList = relateManager.getShareProTobuildList(data.getId());
        for (ShareProTobuild proTobuild : projectList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("project", proTobuild);
//            ProType proType = relateManager.getProType(proTobuild.getBjbh());
//            if (proType != null) {
//                map.put("typeName", proType.getType().getName());
//            }

            list.add(map);
        }
        model.addAttribute("list", list);
        return "view/query/unitQualify/viewProject";
    }
}
