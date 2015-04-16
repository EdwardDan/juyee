package com.justonetech.biz.controller.check;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.CheckDeviceInfoService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.CheckDeviceInfo;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.manager.*;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


/**
 * note:设备注册表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckDeviceInfoController extends BaseCRUDActionController<CheckDeviceInfo> {
    private Logger logger = LoggerFactory.getLogger(CheckDeviceInfoController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private CheckDeviceInfoService checkDeviceInfoService;

    @Autowired
    private PollingRecordManager pollingRecordManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CHECK_DEVICE_INFO_EDIT));

        return "view/check/checkDeviceInfo/grid";
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
            Page<CheckDeviceInfo> pageModel = new Page<CheckDeviceInfo>(page, rows, true);
            String hql = "from CheckDeviceInfo where isDelete=false order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = checkDeviceInfoService.findByPage(pageModel, queryTranslate.toString());


            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                //联机状态
                String onlineStatus = JspHelper.getString(bean.get("onlineStatus"));
                if (!StringHelper.isEmpty(onlineStatus) && "0".equals(onlineStatus)) {
                    bean.put("onlineStatus", "正常");
                } else {
                    bean.put("onlineStatus", "脱机");
                }

                //注销状态
                Object cancelStatus = bean.get("cancelStatus");
                if (cancelStatus.equals("1")) {
                    bean.put("cancelStatus", "注销");
                } else {
                    bean.put("cancelStatus", "正常");
                }

                Object longitude = bean.get("longitude");
                Object latitude = bean.get("latitude");
                Object currentLongitude = bean.get("currentLongitude");
                Object currentLatitude = bean.get("currentLatitude");

                //limit为允许设备距离工地坐标的范围。
                Double limit = 0.0001D;

                if (Math.abs(JspHelper.getDouble(longitude)) != 0D && Math.abs(JspHelper.getDouble(latitude)) != 0D
                        && Math.abs(JspHelper.getDouble(currentLongitude)) != 0D && Math.abs(JspHelper.getDouble(currentLatitude)) != 0D
                        && (Math.abs(JspHelper.getDouble(longitude) - JspHelper.getDouble(currentLongitude)) <= limit)
                        && (Math.abs(JspHelper.getDouble(latitude) - JspHelper.getDouble(currentLatitude)) <= limit)) {
                    bean.put("regDateTime", "正常");
                } else {
                    bean.put("regDateTime", "离开工地");
                }

                //统计该工地下的考勤注册人员。
                Object gdCode = bean.get("gdCode");
                String sql = "select count(*) from check_manager_position n,check_manager t " +
                        "where t.id=n.MANAGER_ID and n.GD_CODE='{0}' and (t.is_delete=0 or t.is_delete is null)";
                sql = FormatUtils.format(sql, gdCode + "");
                int regCount = simpleQueryManager.getIntegerBySql(sql);
                bean.put("longitude", regCount);
            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        CheckDeviceInfo checkDeviceInfo = new CheckDeviceInfo();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        checkDeviceInfo.setRegDateTime(timestamp);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", checkDeviceInfo);

        return "view/check/checkDeviceInfo/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        CheckDeviceInfo checkDeviceInfo = checkDeviceInfoService.get(id);

        //处理其他业务逻辑
        if (checkDeviceInfo != null && StringHelper.isNotEmpty(checkDeviceInfo.getBjbh())) {
            model.addAttribute("project", projectManager.getProjectInfo(checkDeviceInfo.getBjbh()));
        }

        model.addAttribute("bean", checkDeviceInfo);

        return "view/check/checkDeviceInfo/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String cancel(Model model, Long id) {
        CheckDeviceInfo checkDeviceInfo = checkDeviceInfoService.get(id);
        if (checkDeviceInfo != null && checkDeviceInfo.getCancelDateTime() == null) {
            //默认取当前系统时间为注销时间。
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            checkDeviceInfo.setCancelDateTime(timestamp);
        }
        if (checkDeviceInfo != null && StringHelper.isNotEmpty(checkDeviceInfo.getBjbh())) {

            model.addAttribute("project", projectManager.getProjectInfo(checkDeviceInfo.getBjbh()));
        }

        if (checkDeviceInfo != null && StringHelper.isNotEmpty(checkDeviceInfo.getJdTaskCode())) {

        }
        //处理其他业务逻辑

        model.addAttribute("bean", checkDeviceInfo);

        return "view/check/checkDeviceInfo/cancel";
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
        CheckDeviceInfo checkDeviceInfo = checkDeviceInfoService.get(id);

        model.addAttribute("bean", checkDeviceInfo);
        return "view/check/checkDeviceInfo/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") CheckDeviceInfo entity, HttpServletRequest request) throws Exception {
        try {
            CheckDeviceInfo target;
            if (entity.getId() != null) {
                target = checkDeviceInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "jdTaskCode",
                        "bjbh",
                        "gdCode",
                        "gdName",
//                        "belongArea",
//                        "streetArea",
//                        "longitude",
//                        "latitude",
//                        "devName",
                        "devSn",
                        "devMode",
                        "devSim",
//                        "devIp",
//                        "currentLongitude",
//                        "currentLatitude",
//                        "positionTime",
//                        "lastOnlineTime",
//                        "onlineStatus",
//                        "isSync",
                        "regDateTime"//,
//                        "regUserName",
//                        "cancelDateTime",
//                        "cancelStatus",
//                        "cancelUserName"
                });

            } else {
                target = entity;
                target.setIsDelete(false);
            }

            //默认设置当前用户为注册操作人
            target.setRegUser(sysUserManager.getSysUser());
            target.setRegUserName(sysUserManager.getSysUser().getDisplayName());

            //如果所属区县为空则默认为项目报建信息的所属区县
            String bjbh = entity.getBjbh();
            if (StringHelper.isEmpty(entity.getBelongArea()) && StringHelper.isNotEmpty(bjbh)) {
                ShareProTobuild shareProTobuild = projectManager.getProject(bjbh);
                target.setBelongArea(shareProTobuild.getBelongArea());
            } else {
                target.setBelongArea(null);
            }

            //如果所属街镇为空则默认为项目报建信息的所属街镇
            if (StringHelper.isNotEmpty(bjbh)) {
                target.setStreetArea(getStreetAreaByBjbh(bjbh));
            } else {
                target.setStreetArea(null);
            }

            checkDeviceInfoService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void cancelSave(HttpServletResponse response, @ModelAttribute("bean") CheckDeviceInfo entity, HttpServletRequest request) throws Exception {
        try {
            CheckDeviceInfo target;
            if (entity.getId() != null) {
                target = checkDeviceInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "cancelDateTime",
                        "cancelStatus"
                });

                if (entity.getCancelStatus() == null || !entity.getCancelStatus().equals(1L)) {
                    target.setCancelDateTime(null);
                    target.setCancelUserName(null);
                } else {
                    //默认设置当前用户为注销操作人
                    target.setCancelUser(sysUserManager.getSysUser());
                    target.setCancelUserName(sysUserManager.getSysUser().getDisplayName());
                }
                checkDeviceInfoService.save(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "操作成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        CheckDeviceInfo checkDeviceInfo = checkDeviceInfoService.get(id);
        checkDeviceInfo.setIsDelete(true);
        checkDeviceInfoService.save(checkDeviceInfo);
//        checkDeviceInfoService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取工程信息
     *
     * @param gdCode .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String gdCode, Model model) {
        ShareGdInfo gdInfo = projectManager.getGDInfo(gdCode);
        if (gdInfo != null) {
            model.addAttribute("project", projectManager.getProjectInfo(gdInfo.getBjbh()));
            model.addAttribute("gd", gdInfo);
            model.addAttribute("bjbh", gdInfo.getBjbh());
            model.addAttribute("gdName", gdInfo.getGdName());
        }

        return "view/check/checkDeviceInfo/getProjectInfo";
    }

    /**
     * 获取监督任务书编号下的工地信息
     *
     * @param jdTaskCode .
     * @param model    .
     */
    @RequestMapping
    public String getGdInfoSelect(String jdTaskCode, String gdCode, Model model) {
        String selectString = "<select id=\"selectGd\" name=\"selectGd\" class=\"form_select_long\" style=\"width:590px\" onchange=\"getProjectInfo()\">\n" +
                "<option value =\"\">==============================请选择=============================</option>\n";
        String bjbh;
        String gdCodeNew;
        ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
        bjbh = excelJdTasks.getBjbh();
        //获取该报建编号下的所有工地信息。
        List<ShareGdInfo> shareGdInfoList = projectManager.getGDInfoList(JspHelper.getString(bjbh));
        for (ShareGdInfo gdInfo : shareGdInfoList) {
            gdCodeNew = gdInfo.getGdCode();
            if (StringHelper.isNotEmpty(gdCode) && StringHelper.isNotEmpty(gdCodeNew) && gdCode.equals(gdCodeNew)) {
                selectString += "<option value =\"" + gdCodeNew + "\" selected=\"selected\">" + gdInfo.getGdName() + "  （" + gdCodeNew + "）</option>\n";
            } else {
                selectString += "<option value =\"" + gdCodeNew + "\">" + gdInfo.getGdName() + "  （" + gdCodeNew + "）</option>\n";

            }
        }
        selectString += "</select>";
        model.addAttribute("msg", selectString);
        return "common/msg";
    }

    /**
     * 检查设备编号是否可用。
     *
     * @param model .
     * @param devSn .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String checkDevSn(Model model, String devSn, Long id) {
        String info = "";
        String hql = "from CheckDeviceInfo where devSn='{0}' and isDelete=false";
        if (id != null) {
            hql += " and id<>{1}";
        }
        hql = FormatUtils.format(hql, devSn, JspHelper.getString(id));
        List<CheckDeviceInfo> list = checkDeviceInfoService.findByQuery(hql);
        if (list.size() > 0) {
            model.addAttribute("msg", "{success:'false',msg:'" + info + "'}");
        } else {
            model.addAttribute("msg", "{success:'true',msg:'" + info + "'}");
        }
        return "common/msg";
    }

    /**
     * 检查设备SIM卡号是否可用。
     *
     * @param model  .
     * @param devSim .
     * @param id     .
     * @return .
     */
    @RequestMapping
    public String checkDevSim(Model model, String devSim, Long id) {
        String info = "";
        String hql = "from CheckDeviceInfo where devSim='{0}' and isDelete=false";
        if (id != null) {
            hql += " and id<>{1}";
        }
        hql = FormatUtils.format(hql, devSim, JspHelper.getString(id));
        List<CheckDeviceInfo> list = checkDeviceInfoService.findByQuery(hql);
        if (list.size() > 0) {
            model.addAttribute("msg", "{success:'false',msg:'" + info + "'}");
        } else {
            model.addAttribute("msg", "{success:'true',msg:'" + info + "'}");
        }
        return "common/msg";
    }

    /**
     * 地图页面
     *
     * @param id    .
     * @param model .
     */
    @RequestMapping
    public String map(Model model, Long id) {

        String pos = "";
        if (id != null) {
            CheckDeviceInfo checkDeviceInfo = checkDeviceInfoService.get(id);
            if (checkDeviceInfo != null && checkDeviceInfo.getLatitude() != null && checkDeviceInfo.getLongitude() != null) {
                pos = "{'id':'" + id + "','x':'" + checkDeviceInfo.getLongitude() + "','y':'" + checkDeviceInfo.getLatitude() + "'}";
            }
        }
        model.addAttribute("pos", pos);
        model.addAttribute("id", id);


        return "view/check/checkDeviceInfo/map";
    }

    /**
     * 地图标注--保存操作
     *
     * @param response .
     * @param id       .
     * @param x        .
     * @param y        .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void mapSave(HttpServletResponse response, String id, Double x, Double y) throws Exception {
        try {
            if (!StringHelper.isEmpty(id) && x > 0 && y > 0) {
                CheckDeviceInfo data = checkDeviceInfoService.get(Long.valueOf(id));
                if (data != null) {
                    data.setLongitude(x);
                    data.setLatitude(y);
                    checkDeviceInfoService.save(data);
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "考勤工地标注成功");
    }

    /**
     * 根据报建编号取得所属街镇。
     *
     * @param bjbh .
     * @return .
     */
    public String getStreetAreaByBjbh(String bjbh) {
        String streetArea = null;
        if (org.hibernate.annotations.common.util.StringHelper.isNotEmpty(bjbh)) {
//            String sql = "select t.name from sys_code_detail t,pro_belong_area n where n.BELONG_AREA_ID=t.id and n.BJBH='{0}'";
            String sql = "select t.position from excel_jd_tasks t where t.bjbh='{0}' order by id desc";
            sql = FormatUtils.format(sql, bjbh);
            streetArea = simpleQueryManager.getStringBySql(sql);

            if (StringHelper.isEmpty(streetArea)) {
                sql = "select t.name from sys_code_detail t,pro_belong_area n where n.BELONG_AREA_ID=t.id and n.BJBH='{0}'";
                sql = FormatUtils.format(sql, bjbh);
                streetArea = simpleQueryManager.getStringBySql(sql);
            }
        }
        return streetArea;
    }

}