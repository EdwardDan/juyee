package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.CheckFingerPrint;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;
import com.justonetech.biz.manager.CheckSyncManager;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.FileDocumentManager;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import com.justonetech.system.utils.PrivilegeCode;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:管理人员表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckManagerController extends BaseCRUDActionController<CheckManager> {
    private Logger logger = LoggerFactory.getLogger(CheckManagerController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private FileDocumentManager fileDocumentManager;

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
    private CheckManagerService checkManagerService;

    @Autowired
    private CheckDeviceInfoService checkDeviceInfoService;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private CheckFingerPrintService checkFingerPrintService;

    @Autowired
    private CheckSyncManager checkSyncManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CHECK_MANAGER_EDIT));

        return "view/check/checkManager/grid";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String gridDetail(Model model, String gdCode, String jdTaskCode) {
        //判断是否有编辑权限
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CHECK_MANAGER_EDIT));

        return "view/check/checkManager/gridDetail";
    }

    /**
     * 根据报建编号取得所属街镇。
     *
     * @param bjbh .
     * @return .
     */
    public String getStreetAreaByBjbh(String bjbh) {
        String streetArea = null;
        if (StringHelper.isNotEmpty(bjbh)) {
            String sql = "select t.name from sys_code_detail t,pro_belong_area n where n.BELONG_AREA_ID=t.id and n.BJBH='{0}'";
            sql = FormatUtils.format(sql, bjbh);
            streetArea = simpleQueryManager.getStringBySql(sql);
        }
        return streetArea;
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
//            String sql = "select distinct t1.flow_code,t1.gd_code,t1.gd_name,t3.build_unit_name,t2.sg_total_unit_name,t2.bjbh \n" +
//                    "from check_device_info t1,share_gd_info t2,share_pro_tobuild t3 \n" +
//                    "where t1.gd_code=t2.gd_code and t2.bjbh=t3.bjbh \n";
            String sql = "select distinct t1.jd_task_code,t1.gd_code,t1.gd_name,t3.belong_area,t3.js_unit_name as build_unit_name,t2.sg_total_unit_name,t3.bjbh \n" +
                    "from check_device_info t1,share_gd_info t2,excel_jd_tasks t3 \n" +
                    "where t1.gd_code=t2.gd_code and t2.bjbh=t3.bjbh \n";

            QueryTranslateJq queryTranslate = new QueryTranslateJq(sql, filters);
            String query = queryTranslate.toString();

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
                map.put("t1.jd_task_code", data.get("JD_TASK_CODE"));

//                map.put("streetArea", getStreetAreaByBjbh(data.get("BJBH") + ""));
                map.put("streetArea", JspHelper.getString(data.get("BELONG_AREA")));

                //统计该工地下的考勤注册人员。
                sql = "select count(*) from check_manager_position n,check_manager t " +
                        "where t.id=n.MANAGER_ID and n.GD_CODE='{0}' and (t.is_delete=0 or t.is_delete is null)";
                sql = FormatUtils.format(sql, data.get("GD_CODE") + "");

                int regCount = simpleQueryManager.getIntegerBySql(sql);
                map.put("regCount", regCount);

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
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustomDetail(HttpServletResponse response, String filters, String columns, int page, int rows, String gdCode, String jdTaskCode) {
        try {
            Page pageModel = new Page(page, rows, true);
            //增加自定义查询条件
//            String hql = "select m from CheckManager m, CheckManagerPosition n where m.id=n.manager.id and m.isDelete=false and n.gdCode='{0}' and n.jdTaskCode='{1}' order by m.id desc";
//            hql = FormatUtils.format(hql, gdCode, jdTaskCode);

            //不加监督任务书编号查询，避免同一工地多个监督任务书编号时无法快速查找那条记录
            String hql = "select m from CheckManager m, CheckManagerPosition n where m.id=n.manager.id and m.isDelete=false and n.gdCode='{0}' order by m.id desc";
            hql = FormatUtils.format(hql, gdCode);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = checkManagerService.findByPage(pageModel, queryTranslate.toString());

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                CheckManager checkManager = checkManagerService.get(JspHelper.getLong(id));
                CheckManagerPosition checkManagerPosition = getPersonPositionByGdManager(checkManager);
                List<CheckFingerPrint> checkFingerPrints = checkFingerPrintService.findByQuery("from CheckFingerPrint where isDelete=0 and manager.id=" + id);
                bean.put("fingerNum", checkFingerPrints.size());
                if (checkManagerPosition != null && checkManagerPosition.getPositionName() != null) {
                    bean.put("sex", checkManagerPosition.getPositionName());
                }
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
    public String add(Model model, String gdCode, String jdTaskCode, String sWitch) {

        CheckManager checkManager = new CheckManager();

        //设置默认性别为男性。
        checkManager.setSex(Constants.FLAG_TRUE);

        //根据监督任务书编号和工地编号获取工地信息
        Map<String, Object> map = projectManager.getGdInfoByJdTaskCode(gdCode, jdTaskCode);
        if (!map.isEmpty()) {
            model.addAttribute("gdName", map.get("GD_NAME") + "");
            model.addAttribute("projectName", map.get("PROJECT_NAME") + "");
        }

        CheckManagerPosition checkManagerPosition = new CheckManagerPosition();

        //上传岗位证书图片功能
        model.addAttribute("uploadButtonImage", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                CheckManagerPosition.class.getSimpleName(), checkManagerPosition.getCertificateDoc(), null, null, "Image"));
        //处理其他业务逻辑

        //如需增加其他默认值请在此添加
        model.addAttribute("male", Constants.FLAG_TRUE);
        model.addAttribute("female", Constants.FLAG_FALSE);
        model.addAttribute("positionType", Constants.CHECK_MANAGER_POSITION);
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("bean", checkManager);

        model.addAttribute("IDCARD_IMAGE_PATH", checkSyncManager.IDCARD_IMAGE_PATH);
        if ("pt".equals(sWitch))
            return "view/check/checkManager/ptinput";
        else
            return "view/check/checkManager/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id, String gdCode, String jdTaskCode, String sWitch) {
        CheckManager checkManager = checkManagerService.get(id);

        //根据监督任务书编号和工地编号获取工地信息
        Map<String, Object> map = projectManager.getGdInfoByJdTaskCode(gdCode, jdTaskCode);
        if (!map.isEmpty()) {
            model.addAttribute("gdName", map.get("GD_NAME") + "");
            model.addAttribute("projectName", map.get("PROJECT_NAME") + "");
        }

        CheckManagerPosition checkManagerPosition = getPersonPositionByGdManager(checkManager);
        model.addAttribute("checkManagerPosition", checkManagerPosition);

        //上传岗位证书图片功能
        model.addAttribute("uploadButtonImage", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(),
                CheckManagerPosition.class.getSimpleName(), checkManagerPosition.getCertificateDoc(), null, null, "Image"));

        //处理其他业务逻辑

        model.addAttribute("male", Constants.FLAG_TRUE);
        model.addAttribute("female", Constants.FLAG_FALSE);
        model.addAttribute("positionType", Constants.CHECK_MANAGER_POSITION);
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("id", id);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("configPath", configManager.getFilePath());
        model.addAttribute("IDCARD_IMAGE_PATH", checkSyncManager.IDCARD_IMAGE_PATH);

        model.addAttribute("bean", checkManager);
        model.addAttribute("photoFile", checkManager.getPhotoFile());
        if (!FileUtils.exist(configManager.getFilePath() + checkSyncManager.IDCARD_IMAGE_PATH)) {
            FileUtils.mkDirs(configManager.getFilePath() + checkSyncManager.IDCARD_IMAGE_PATH);
        }
        if ("pt".equals(sWitch))
            return "view/check/checkManager/ptinput";
        else
            return "view/check/checkManager/input";
    }


    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String gdCode, String jdTaskCode, String sWitch) {
        CheckManager checkManager = checkManagerService.get(id);

        //根据监督任务书编号和工地编号获取工地信息
        Map<String, Object> map = projectManager.getGdInfoByJdTaskCode(gdCode, jdTaskCode);
        if (!map.isEmpty()) {
            model.addAttribute("gdName", map.get("GD_NAME") + "");
            model.addAttribute("projectName", map.get("PROJECT_NAME") + "");
        }

        CheckManagerPosition checkManagerPosition = getPersonPositionByGdManager(checkManager);

        model.addAttribute("checkManagerPosition", checkManagerPosition);

        //查看岗位证书图片功能
        model.addAttribute("imageButton", documentManager.getDownloadButton(checkManagerPosition.getCertificateDoc()));

        //处理其他业务逻辑

        model.addAttribute("male", Constants.FLAG_TRUE);
        model.addAttribute("female", Constants.FLAG_FALSE);

        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        List<CheckFingerPrint> checkFingerPrints = checkFingerPrintService.findByQuery("from CheckFingerPrint where isDelete=0 and manager.id=" + id);
        model.addAttribute("fingerNum", checkFingerPrints.size());
        model.addAttribute("bean", checkManager);
        model.addAttribute("photoFile", checkManager.getPhotoFile());
        return "view/check/checkManager/view";
    }

    /**
     * 根据身份证号检查考勤人员是否已经在其他工地注册，或者已经该工地下注册。
     *
     * @param model    .
     * @param gdCode   .
     * @param jdTaskCode .
     * @param cardNo   .
     * @return .
     */
    @RequestMapping
    public String checkCardNo(Model model, String gdCode, String jdTaskCode, String cardNo, Long id) {
        String info = "";
        //以下hql语句用于根据身份证号检查考勤人员是否已经在其他工地注册
        String hql = "select n from CheckManager m, CheckManagerPosition n where m.id=n.manager.id and m.isDelete=false and n.gdCode<>'{0}' and m.cardNo='{1}' order by n.id desc";
        //以下hql2语句用于根据身份证号检查考勤人员是否已经该工地下注册，不能重复注册相同身份证号的人员。
        String hql2 = "select n from CheckManager m, CheckManagerPosition n where m.id=n.manager.id and m.isDelete=false and n.gdCode='{0}' and n.jdTaskCode='{1}' and m.cardNo='{2}'";
        if (id != null) {
            hql2 += " and m.id<>{3}";
        }
        hql = FormatUtils.format(hql, gdCode, cardNo);
        hql2 = FormatUtils.format(hql2, gdCode, jdTaskCode, cardNo, JspHelper.getString(id));
        List<CheckManagerPosition> list = checkManagerPositionService.findByQuery(hql);
        List<CheckManagerPosition> list2 = checkManagerPositionService.findByQuery(hql2);
        if (list.size() == 0 && list2.size() == 0) {
            model.addAttribute("msg", "{success:'safe',msg:'" + info + "'}");
            return "common/msg";
        } else if (list2.size() > 0) {
            model.addAttribute("msg", "{success:'error',msg:'" + info + "'}");
            return "common/msg";
        } else if (list.size() > 0 && list2.size() == 0) {
            for (CheckManagerPosition checkManagerPosition : list) {
                info += checkManagerPosition.getGdName() + "（" + checkManagerPosition.getGdCode() + "），";
            }
            info = info.substring(0, info.length() - 1);
            model.addAttribute("msg", "{success:'warning',msg:'" + info + "'}");
        }
        return "common/msg";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") CheckManager entity, HttpServletRequest request, String gdCode, String jdTaskCode, Long docIdImage, Long positionTypeId, String certificateCode, String certificateName) throws Exception {
        Long id = entity.getId();
        Long tid = entity.getId();

        try {
            CheckManager target;
            String photoFile = request.getParameter("photoFile");
            if (entity.getId() != null) {
                target = checkManagerService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
                        "sex",
                        "cardNo",
                        "mobile",
                        "photoFile"
//                        "isSync"
                });

            } else {
                target = entity;
                target.setIsDelete(false);
            }
            String photo = request.getParameter("image");
            if (photo != null && !"".equals(photo)) {
                byte[] thePhoto = org.apache.commons.codec.binary.Base64.decodeBase64(photo.getBytes());
                String fullPathName = configManager.getFilePath() + checkSyncManager.IDCARD_IMAGE_PATH + File.separator + target.getCardNo() + ".jpg";
                File file = new File(fullPathName);
                if (FileUtils.exist(fullPathName)) {
                    FileUtils.removeDir(file);
                }
                org.apache.commons.io.FileUtils.writeByteArrayToFile(file, thePhoto);
            }
            target.setPhotoFile(photoFile);
            target.setName(target.getName().trim()); //去空格
            checkManagerService.save(target);
            tid = target.getId();

            CheckManagerPosition checkManagerPosition;

            if (id == null) {
                checkManagerPosition = new CheckManagerPosition();
                Map<String, Object> map = projectManager.getGdInfoByJdTaskCode(gdCode, jdTaskCode);
                if (!map.isEmpty()) {
                    checkManagerPosition.setJdTaskCode(jdTaskCode);
                    checkManagerPosition.setBjbh(map.get("BJBH") + "");
                    checkManagerPosition.setGdCode(gdCode);
                    checkManagerPosition.setGdName(map.get("GD_NAME") + "");
                    checkManagerPosition.setBelongArea(map.get("BELONG_AREA") + "");
                    checkManagerPosition.setStreetArea(getStreetAreaByBjbh(map.get("BJBH") + ""));
                }
                checkManagerPosition.setManager(target);
                checkManagerPosition.setIsDelete(false);
                checkManagerPosition.setIsValid(true);
            } else {
                checkManagerPosition = getPersonPositionByGdManager(target);
            }

            if (checkManagerPosition != null) {
                if (positionTypeId != null) {
                    SysCodeDetail positionType = sysCodeDetailService.get(positionTypeId);
                    checkManagerPosition.setPositionType(positionType);
                    if (positionType != null) {
                        checkManagerPosition.setPositionName(positionType.getName());
                    }
                }
                //获取已上传的证书扫描件
                if (docIdImage != null) {
                    checkManagerPosition.setCertificateDoc(docDocumentService.get(docIdImage));
                }
                checkManagerPosition.setCertificateCode(certificateCode);
                checkManagerPosition.setCertificateName(certificateName);
                checkManagerPositionService.save(checkManagerPosition);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendJSON(response, "{\"success\":true,\"msg\":\"保存成功\",\"id\":" + tid + "}");
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
        CheckManager checkManager = checkManagerService.get(id);
        Timestamp timestamp = DateTimeHelper.getTimestamp();
        String loginName = sysUserManager.getSysUser().getLoginName();

        //虚拟删除人员岗位表的相关记录
        String hql = "from CheckManagerPosition where manager.id=" + checkManager.getId() + " order by id desc";
        List<CheckManagerPosition> checkManagerPositionList = checkManagerPositionService.findByQuery(hql);
        for (CheckManagerPosition checkManagerPosition : checkManagerPositionList) {
//        CheckManagerPosition checkManagerPosition = getPersonPositionByGdManager(checkManager);
            checkManagerPosition.setIsDelete(true);
            checkManagerPosition.setDeleteTime(timestamp);
            checkManagerPosition.setDeleteUser(loginName);
            checkManagerPositionService.save(checkManagerPosition);
        }

        //虚拟删除管理人员表的相关记录
        Set<CheckFingerPrint> set = checkManager.getCheckFingerPrints();
        for (CheckFingerPrint checkFingerPrint : set) {
            checkFingerPrint.setIsDelete(true);
            checkFingerPrint.setDeleteTime(timestamp);
            checkFingerPrint.setDeleteUser(loginName);
            checkFingerPrintService.save(checkFingerPrint);
        }

        checkManager.setIsDelete(true);
        checkManager.setDeleteTime(timestamp);
        checkManager.setDeleteUser(loginName);
        checkManagerService.save(checkManager);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 根据考勤人员获得人员岗位表中对应的信息。
     *
     * @param checkManager .
     * @return .
     */
    private CheckManagerPosition getPersonPositionByGdManager(CheckManager checkManager) {
        CheckManagerPosition checkManagerPosition = null;

        if (checkManager != null && checkManager.getId() != null) {
            String hql = "from CheckManagerPosition where manager.id=" + checkManager.getId() + " order by id desc";
            List<CheckManagerPosition> checkManagerPositionList = checkManagerPositionService.findByQuery(hql);
            if (checkManagerPositionList.size() > 0) {
                checkManagerPosition = checkManagerPositionList.get(0);
            }
        }
        return checkManagerPosition;
    }

}