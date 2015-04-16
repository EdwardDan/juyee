package com.justonetech.biz.controller.project;

import com.justonetech.biz.daoservice.ProjectStreetService;
import com.justonetech.biz.domain.ProjectStreet;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


/**
 * note:行政区街镇划分
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjectStreetController extends BaseCRUDActionController<ProjectStreet> {
    private Logger logger = LoggerFactory.getLogger(ProjectStreetController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectStreetService projectStreetService;

    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {

        return "view/project/projectStreet/init";
    }

    /**
     * 项目地图分布
     *
     * @param model .
     */
    @RequestMapping
    public String draw(Model model) throws Exception {
        List<ProjectStreet> streets = projectStreetService.findAll();
        String polygonData = "[";
        for (ProjectStreet street : streets) {
            String color = !StringHelper.isEmpty(street.getColor()) ? street.getColor() : "#FF0000";
            polygonData += "{\"id\":" + street.getId() + ",\"name\":\"" + street.getStreetName() + "\",\"pointData\":" + street.getPointData() + ",\"color\":\"" + color + "\"},";
        }
        polygonData += "]";
        model.addAttribute("polygonData", polygonData);

        return "view/project/projectStreet/draw";
    }


    /**
     * 保存地图数据
     *
     * @param id        .
     * @param streetId  .
     * @param pointData .
     * @param model     .
     * @throws Exception
     */
    @RequestMapping
    public String drawSave(Long id, Long streetId, String pointData, String color, Model model) throws Exception {
        ProjectStreet street;
        if (id == null) {
            street = new ProjectStreet();
            Calendar c = Calendar.getInstance();
            street.setYear(c.get(Calendar.YEAR));
        } else {
            street = projectStreetService.get(id);
        }
        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeListById(streetId);
        street.setStreet(sysCodeDetail);
        street.setStreetName(sysCodeDetail.getName());

        street.setPointData(pointData);
        street.setColor(color);
        projectStreetService.save(street);

        String msg = "{'success':true,'msg':'区域绘制成功','id':" + street.getId() + ",'name':'" + sysCodeDetail.getName() + "'}";
        model.addAttribute("msg", msg);

        return "common/msg";
    }


    /**
     * 街道删除
     *
     * @param id    .
     * @param model .
     * @return .
     * @throws Exception
     */
    @RequestMapping
    public String drawDelete(Long id, Model model) throws Exception {
        projectStreetService.delete(id);
        String msg = "{'success':true,'msg':'区域删除成功'}";
        model.addAttribute("msg", msg);
        return "common/msg";
    }


    /**
     * 获取街道信息
     *
     * @param id    .
     * @param model .
     * @return .
     * @throws Exception
     */
    @RequestMapping
    public String getStreetInfo(String id, Model model) throws Exception {
        model.addAttribute("selectId", "");
        model.addAttribute("color", "");
        if (!StringHelper.isEmpty(id)) {
            ProjectStreet street = projectStreetService.get(Long.valueOf(id));
            model.addAttribute("selectId", street.getStreet().getId());
            model.addAttribute("color", JspHelper.getString(street.getColor()));
        }

        //已设置的街镇
        Set<Long> existHS = new HashSet<Long>();
        String hql = "from ProjectStreet where 1=1";
        if (!StringHelper.isEmpty(id)) {
            hql += " and id<>" + id;
        }
        List<ProjectStreet> exists = projectStreetService.findByQuery(hql);
        for (ProjectStreet exist : exists) {
            existHS.add(exist.getStreet().getId());
        }

        //不显示已经设置的街镇
        List<SysCodeDetail> retList = new ArrayList<SysCodeDetail>();
        List<SysCodeDetail> sysCodeDetails = sysCodeManager.getCodeListByCode(Constants.EXCEL_JDTASK_POSITION);
        for (SysCodeDetail sysCodeDetail : sysCodeDetails) {
            if (!existHS.contains(sysCodeDetail.getId())) {
                retList.add(sysCodeDetail);
            }
        }

        model.addAttribute("streets", retList);

        return "view/project/projectStreet/drawSelect";
    }

}