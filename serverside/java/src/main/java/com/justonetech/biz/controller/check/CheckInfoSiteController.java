package com.justonetech.biz.controller.check;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.CheckInfoService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.CheckInfo;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * note:考勤记录表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckInfoSiteController extends BaseCRUDActionController<CheckInfo> {
    private Logger logger = LoggerFactory.getLogger(CheckInfoSiteController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private CheckInfoService checkInfoService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private CheckInfoManager checkInfoManager;
    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        return "view/check/checkInfoSite/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
            Long detailId = sysCodeDetail.getId();
            //外网项目用户和工地用户只能查看本项目范围的记录
//            SysRegPerson regPerson = regPersonManager.getRegPerson();
            String sql = "select distinct t1.bjbh,t1.gd_code,t1.gd_name,t3.belong_area,t3.JS_UNIT_NAME as build_unit_name,t2.sg_total_unit_name,t2.bjbh" +
                    " from check_device_info t1,share_gd_info t2,excel_jd_tasks t3" +
                    " where t1.gd_code=t2.gd_code and t2.bjbh=t3.bjbh ";
            sql += checkInfoManager.getCheckInfoFilterSql();
            sql += " order by t1.bjbh desc";

            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();
//            logger.debug("query = " + query);

            //获取工地列表--只取已关联监督任务书编号的记录
            List<Map> mapList = simpleQueryManager.getMapList(query);

            Page pageModel = new Page(page, rows, mapList);
            List<Map> rowList = pageModel.getRows();


            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            int i = 1;
            for (Map data : rowList) {
                map = new HashMap<String, Object>();
                map.put("id", i++);
                map.put("t1.gd_code", data.get("GD_CODE"));
                map.put("t1.gd_name", data.get("GD_NAME"));
                map.put("t1.bjbh", data.get("BJBH"));
                map.put("streetArea", JspHelper.getString(data.get("BELONG_AREA")));
                map.put("unitName", data.get("BUILD_UNIT_NAME"));
                map.put("totalUnitName", data.get("SG_TOTAL_UNIT_NAME"));
                map.put("projectName", data.get("PROJECT_NAME"));

                //统计该工地下的考勤注册人员。
                sql = "select count(*) from check_manager_position n,check_manager t " +
                        "where t.id=n.MANAGER_ID and n.GD_CODE='{0}' and (t.is_delete=0 or t.is_delete is null)" +
                        " and n.position_type<>{1}";
                sql = FormatUtils.format(sql, data.get("GD_CODE") + "", detailId + "");

                int regCount = simpleQueryManager.getIntegerBySql(sql);
                map.put("regCount", regCount);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String hql =
                        "select distinct t.manager from CheckInfo t where t.gdCode= '" + data.get("GD_CODE") + "'" +
                                " and to_char(t.checkTime,'YYYY-MM-DD')='" + sdf.format(new Date()) + "'";
                List<CheckInfo> checkInfos = checkInfoService.findByQuery(hql);
                List<Map<String, String>> list = new ArrayList<Map<String, String>>();
                map.put("realCount", checkInfos.size());
                retList.add(map);
            }

            //输出显示
            String json = GridJq.toJSON(retList, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }


    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        CheckInfo checkInfo = checkInfoService.get(id);

        model.addAttribute("bean", checkInfo);
        return "view/check/checkInfo/view";
    }

//    /**
//     * 根据报建编号取得所属街镇。
//     *
//     * @param bjbh .
//     * @return .
//     */
//    public String getStreetAreaByBjbh(String bjbh) {
//        String streetArea = null;
//        if (StringHelper.isNotEmpty(bjbh)) {
//            String sql = "select t.name from sys_code_detail t,pro_belong_area n where n.BELONG_AREA_ID=t.id and n.BJBH='{0}'";
//            sql = FormatUtils.format(sql, bjbh);
//            streetArea = simpleQueryManager.getStringBySql(sql);
//        }
//        return streetArea;
//    }
}