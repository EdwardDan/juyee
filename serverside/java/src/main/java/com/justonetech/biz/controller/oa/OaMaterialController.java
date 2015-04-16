package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaMaterialItemService;
import com.justonetech.biz.daoservice.OaMaterialService;
import com.justonetech.biz.domain.OaMaterial;
import com.justonetech.biz.domain.OaMaterialItem;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaFgldManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.utils.enums.OaMaterialStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * note:物资设备采购管理
 * author: guoqiong
 * create date:
 * modify date: 2014-04-24
 */
@Controller
public class OaMaterialController extends BaseCRUDActionController<OaMaterial> {
    private Logger logger = LoggerFactory.getLogger(OaMaterialController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMaterialService oaMaterialService;

    @Autowired
    private OaMaterialItemService oaMaterialItemService;

    @Autowired
    private OaFgldManager oaFgldManager;


    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MATERIAL_EDIT));//材料采购_编辑
        model.addAttribute("canOfficeAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MATERIAL_OFFICE_AUDIT)); //材料采购_办公室审核
        model.addAttribute("canLeaderAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MATERIAL_LEADER_AUDIT));  //材料采购_领导审核
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_MATERIAL_DELETE));  //材料采购_强制删除
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName()); //当前登录用户
        setOaMaterialStatus(model);

        return "view/oa/oaMaterial/grid";
    }

    /**
     * 编辑审核权限状态
     *
     * @param model .
     */
    private void setOaMaterialStatus(Model model) {

        // 正在填写
        model.addAttribute("STATUS_EDIT", OaMaterialStatus.STATUS_EDIT.getCode());
        // 办公室主任审核
        model.addAttribute("STATUS_SUBMIT", OaMaterialStatus.STATUS_SUBMIT.getCode());
        // 办公室主任退回
        model.addAttribute("STATUS_BACK", OaMaterialStatus.STATUS_BACK.getCode());
        // 领导退回
        model.addAttribute("STATUS_BACK_LEADER", OaMaterialStatus.STATUS_BACK_LEADER.getCode());
        // 领导审核
        model.addAttribute("STATUS_SUBMIT_LEADER", OaMaterialStatus.STATUS_SUBMIT_LEADER.getCode());
        // 审核通过
        model.addAttribute("STATUS_PASS", OaMaterialStatus.STATUS_PASS.getCode());

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
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMaterial order by reportDate desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMaterialService.findByPage(pageModel, queryTranslate.toString());

//            List<Map> mapList = GridJq.getGridValue(pageModel.getRows(), columns);
//            for (Map bean : mapList) {
//                Object id = bean.get("id");
//                if (null != id) {
//                    OaMaterial oaMaterial = oaMaterialService.get(JspHelper.getLong(id));
//                    bean.put("documentDownload", documentManager.getDownloadButton(docDocumentService.get(oaMaterial.getDocumentId())));
//                }
//            }
            //输出显示
//            String json = GridJq.toJSON(mapList, pageModel);
            String json = GridJq.toJSON(columns, pageModel);
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
        OaMaterial oaMaterial = new OaMaterial();
        //默认申请人为当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        oaMaterial.setReportPerson(sysUser.getDisplayName());
        //获取登录人的部门
        SysDept dept = sysUser.getPerson().getDept();
        oaMaterial.setReportDept(dept.getName());
        oaMaterial.setReportDate(new Date(System.currentTimeMillis()));
        oaMaterial.setStatus(OaMaterialStatus.STATUS_EDIT.getCode());
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMaterial);
        setOaMaterialStatus(model);
//        //附件上传
//        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaMaterial.class.getSimpleName(), oaMaterial.getDocumentId(), null, null));

        return "view/oa/oaMaterial/input";
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
        OaMaterial oaMaterial = oaMaterialService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaMaterial);
        setOaMaterialStatus(model);

        return "view/oa/oaMaterial/input";
    }

    /**
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaMaterial oaMaterial = oaMaterialService.get(id);

        //设置审核时间为当前时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (oaMaterial.getStatus() == OaMaterialStatus.STATUS_SUBMIT.getCode())
            oaMaterial.setOfficeAuditTime(timestamp);
        if (oaMaterial.getStatus() == OaMaterialStatus.STATUS_SUBMIT_LEADER.getCode())
            oaMaterial.setLeaderAuditTime(timestamp);
        //处理其他业务逻辑
        model.addAttribute("bean", oaMaterial);
        setOaMaterialStatus(model);

        return "view/oa/oaMaterial/audit";
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
        OaMaterial oaMaterial = oaMaterialService.get(id);

        model.addAttribute("bean", oaMaterial);
        return "view/oa/oaMaterial/view";
    }

    /**
     * 保存操作（编辑）
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveInput(HttpServletResponse response, @ModelAttribute("bean") OaMaterial entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaMaterial target;
            if (entity.getId() != null) {
                target = oaMaterialService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "reportDate",
                        "reportPerson",
                        "reportDept",
                        "requireDesc",
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));

            oaMaterialService.save(target);

            //保存从表信息
            saveOaMaterialItem(target, request);
            if(target.getStatus()!=OaMaterialStatus.STATUS_EDIT.getCode()){
                createOaTask(target);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 保存操作（审核）
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveAudit(HttpServletResponse response, @ModelAttribute("bean") OaMaterial entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaMaterial target;
            if (entity.getId() != null) {
                target = oaMaterialService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "reportDate",
                        "reportPerson",
                        "reportDept",
                        "requireDesc",
                        "officeOpinion",
                        "officeAuditTime",
                        "leaderOpinion",
                        "leaderAuditTime",
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));
            //获取当前登录用户
            String loginName = SpringSecurityUtils.getCurrentUser().getLoginName();
            //保存当前审核人
            if (target.getStatus() == OaMaterialStatus.STATUS_SUBMIT_LEADER.getCode()) {
                target.setOfficeAuditUser(loginName);
            }
            if (target.getStatus() == OaMaterialStatus.STATUS_PASS.getCode()) {
                target.setLeaderAuditUser(loginName);
            }
            oaMaterialService.save(target);

            //保存从表信息
            saveOaMaterialItem(target, request);

                createOaTask(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaMaterial data) throws Exception {
        int Status=data.getStatus();
        //创建任务
        String title = oaTaskManager.getTaskTitle(data, OaMaterial.class.getSimpleName());
        //获取办公室主任
        String privilegeCode = PrivilegeCode.OA_MATERIAL_OFFICE_AUDIT;
       //获取领导
        if(Status==OaMaterialStatus.STATUS_SUBMIT_LEADER.getCode()){
            privilegeCode = PrivilegeCode.OA_MATERIAL_LEADER_AUDIT;
        }
        Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);

        if(Status==OaMaterialStatus.STATUS_SUBMIT.getCode()||Status==OaMaterialStatus.STATUS_SUBMIT_LEADER.getCode()) {
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaMaterial.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if(Status==OaMaterialStatus.STATUS_PASS.getCode()||Status==OaMaterialStatus.STATUS_BACK.getCode()||Status==OaMaterialStatus.STATUS_BACK_LEADER.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser(data.getCreateUser());
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getReportPerson());
            String msgTemp = oaTaskManager.getTaskTitle(data, OaMaterial.class.getSimpleName() + "_Pass");
            String[] ids = new String[1];
            if(Status==OaMaterialStatus.STATUS_BACK.getCode()){
                msgTemp = oaTaskManager.getTaskTitle(data, OaMaterial.class.getSimpleName() + "_Back");
            }
            if (null!=receiveUser) {
                ids[0]= String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        }

    }



    /**
     * 保存从表信息
     *
     * @param oaMaterial 。
     * @param request    。
     */
    private void saveOaMaterialItem(OaMaterial oaMaterial, HttpServletRequest request) {
        //先删除从表信息，在保存
        Set<OaMaterialItem> oaMaterialItems = oaMaterial.getOaMaterialItems();
        if (oaMaterialItems.size() > 0) {
            for (OaMaterialItem oaMaterialItem : oaMaterialItems) {
                oaMaterialItemService.delete(oaMaterialItem);
            }
        }
        //获取申请的详细信息
        //物资设备名称
        String[] materialNames = request.getParameterValues("materialName");
        //具体规格型号
        String[] materialModels = request.getParameterValues("materialModel");
        //供应商情况
        String[] suppliers = request.getParameterValues("supplier");
        //数量
        String[] materialNums = request.getParameterValues("materialNum");

        if (materialModels != null) {
            for (int i = 0; i < materialNames.length; i++) {
                OaMaterialItem oaMaterialItem = new OaMaterialItem();
                oaMaterialItem.setMaterial(oaMaterial);
                if (!StringHelper.isEmpty(materialNames[i])) {
                    oaMaterialItem.setMaterialName(materialNames[i]);
                }
                if (!StringHelper.isEmpty(materialModels[i])) {
                    oaMaterialItem.setMaterialModel(materialModels[i]);
                }
                if (!StringHelper.isEmpty(suppliers[i])) {
                    oaMaterialItem.setSupplier(suppliers[i]);
                }
                if (!StringHelper.isEmpty(materialNums[i])) {
                    oaMaterialItem.setMaterialNum(Double.valueOf(materialNums[i]));
                }
                oaMaterialItemService.save(oaMaterialItem);
            }
        }
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
        OaMaterial oaMaterial = oaMaterialService.get(id);
        Set<OaMaterialItem> oaMaterialItems = oaMaterial.getOaMaterialItems();
        if (oaMaterialItems.size() > 0) {
            for (OaMaterialItem oaMaterialItem : oaMaterialItems) {
                oaMaterialItemService.delete(oaMaterialItem);
            }
        }
        oaTaskManager.removeTask(OaMaterial.class.getSimpleName(), id);//删除任务

        oaMaterialService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}