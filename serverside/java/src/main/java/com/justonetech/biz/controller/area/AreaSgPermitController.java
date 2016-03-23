package com.justonetech.biz.controller.area;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.AreaSgPermitManager;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.AreaSgPermitStatus;
import com.justonetech.biz.utils.enums.SgPermitNotAcceptMat;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.ExcelPrintManager;
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
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:区县施工许可证
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class AreaSgPermitController extends BaseCRUDActionController<AreaSgPermit> {
    private Logger logger = LoggerFactory.getLogger(AreaSgPermitController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private AreaSgPermitService areaSgPermitService;

    @Autowired
    private AreaSgPermitManager areaSgPermitManager;

    @Autowired
    private AreaPermitHdExtendService areaPermitHdExtendService;

    @Autowired
    private AreaSgMaterialService areaSgMaterialService;

    @Autowired
    private AreaPermitOperationService areaPermitOperationService;

    @Autowired
    private AreaHistoryOpinionService areaHistoryOpinionService;

    @Autowired
    private AreaAuditOpinionService areaAuditOpinionService;

    @Autowired
    private AreaProjPersonService areaProjPersonService;

    @Autowired
    private AreaSgUnitProjService areaSgUnitProjService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    private static final String xlsTemplateName1 = "SgPermit.xls";
    private static final String xlsTemplateName2 = "SgPermit_green.xls";
    private static final String xlsTemplateName3 = "SgPermit_kgba.xls";


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {

        areaSgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/area/areaSgPermit/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            SysUser sysUser = sysUserManager.getSysUser();
            String area = "";
            SysPerson person = sysUser.getPerson();
            if (null != person) {
                area = person.getAreaCode();
            }
            String hql = "from AreaSgPermit where 1=1";
            if (null != sysUser.getRegPerson()) {
                hql += " and createUser='" + sysUser.getLoginName() + "'";
            }
            if (!StringHelper.isEmpty(area)) {
                hql += " and areaCode='" + area + "'";
            }
            hql += " order by id desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = areaSgPermitService.findByPage(pageModel, queryTranslate.toString());
            session.setAttribute(Constants.GRID_SQL_KEY, queryTranslate.toString());
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object property = bean.get("propertyType.id");
                if (null != property && !StringHelper.isEmpty(String.valueOf(property))) {
                    SysCodeDetail detail = sysCodeManager.getCodeListById(JspHelper.getLong(property));
                    if (detail.getCode().equals(Constants.PROJECT_PROPERTY_5)) {
                        bean.put("isGreen", "");
                    } else {
                        bean.put("isGreen", "★");
                    }
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
     * 项目选择页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String selectProjectType(Model model) {
        List<SysCodeDetail> list = sysCodeManager.getCodeListByCode(Constants.PROJECT_TYPE);
        model.addAttribute("list", list);

        return "view/area/areaSgPermit/projectType";
    }

    /**
     * tab显示页面
     *
     * @param model .
     * @param id    .
     * @param act   .
     * @return .
     */
    @RequestMapping
    public String frame(Model model, String id, String act, String projectTypeId) {
        model.addAttribute("id", JspHelper.getString(id));
        model.addAttribute("act", JspHelper.getString(act));
        if (!StringHelper.isEmpty(projectTypeId)) {
            model.addAttribute("projectTypeId", projectTypeId);
            SysCodeDetail projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            model.addAttribute("projName", projectType.getName());
        }
        if (!StringHelper.isEmpty(id)) {
            AreaSgPermit areaSgPermit = areaSgPermitService.get(Long.valueOf(id));
            model.addAttribute("projectTypeId", areaSgPermit.getProjectType().getId());
            model.addAttribute("projName", areaSgPermit.getProjectType().getName());
        }

        return "view/area/areaSgPermit/frame";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, String id, String projectTypeId, String tab) {
        model.addAttribute("tab", tab);
        AreaSgPermit sgPermit = new AreaSgPermit();
        SysCodeDetail projectType;
        if (!StringHelper.isEmpty(id)) {
            sgPermit = areaSgPermitService.get(Long.valueOf(id));
        } else {
            Calendar calendar = Calendar.getInstance();
            sgPermit.setYear(calendar.get(Calendar.YEAR));
            sgPermit.setStatus(AreaSgPermitStatus.STATUS_EDIT.getCode());
        }
        if (!StringHelper.isEmpty(projectTypeId)) {
            projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            sgPermit.setProjectType(projectType);
        } else {
            projectType = sgPermit.getProjectType();
        }
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(sgPermit, "edit", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态
        AreaPermitHdExtend hdExtend = new AreaPermitHdExtend();
        if (projectType.getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<AreaPermitHdExtend> extendSet = sgPermit.getAreaPermitHdExtends();
            if (extendSet.size() > 0) {
                hdExtend = extendSet.iterator().next();
            }
        }
        model.addAttribute("hdExtend", hdExtend);

        return backPageInput(projectType);
    }

    /**
     * 受理显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String accept(Model model, String id) {
        AreaSgPermit sgPermit = areaSgPermitService.get(Long.valueOf(id));
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态
        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<AreaPermitHdExtend> extendSet = sgPermit.getAreaPermitHdExtends();
            if (null != extendSet && extendSet.size() > 0) {
                AreaPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }

        return backPageAccept(sgPermit.getProjectType());
    }

    /**
     * 审核显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        AreaSgPermit sgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(sgPermit, "edit", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态

        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<AreaPermitHdExtend> extendSet = sgPermit.getAreaPermitHdExtends();
            if (extendSet.size() > 0) {
                AreaPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }
        SysCodeDetail detail = sgPermit.getPropertyType();
        boolean isGreen = false;
        if (null != detail) {
            String code = detail.getCode();
            if (code.equals(Constants.PROJECT_PROPERTY_5)) {
                isGreen = false;
            } else {
                isGreen = true;
            }
        }
        model.addAttribute("isGreen", isGreen);
        Set<AreaHistoryOpinion> opinions = sgPermit.getAreaHistoryOpinions();
        model.addAttribute("historyOpinions", opinions);

        return backPageAudit(sgPermit.getProjectType());
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
        AreaSgPermit sgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);

        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<AreaPermitHdExtend> extendSet = sgPermit.getAreaPermitHdExtends();
            if (extendSet.size() > 0) {
                AreaPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }
        SysCodeDetail detail = sgPermit.getPropertyType();
        boolean isGreen = false;
        if (null != detail) {
            String code = detail.getCode();
            if (code.equals(Constants.PROJECT_PROPERTY_5)) {
                isGreen = false;
            } else {
                isGreen = true;
            }
        }
        model.addAttribute("isGreen", isGreen);
        Set<AreaHistoryOpinion> opinions = sgPermit.getAreaHistoryOpinions();
        model.addAttribute("historyOpinions", opinions);

        return backPageView(sgPermit.getProjectType());
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);

        return "view/area/areaSgPermit/printView";
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView1(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        model.addAttribute("title", areaSgPermit.getProjectType().getName());

        return "view/area/areaSgPermit/printView1";
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView2(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);

        return "view/area/areaSgPermit/printView2";
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView3(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/area/areaSgPermit/printView3";
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView4(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/area/areaSgPermit/printView4";
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView5(Model model, Long id) {
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        model.addAttribute("bean", areaSgPermit);
        List<Map<String, Object>> applyList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = areaSgPermitManager.getMaterials(areaSgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        areaSgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/area/areaSgPermit/printView5";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") AreaSgPermit entity, HttpServletRequest request) throws Exception {
        try {
            AreaSgPermit target;
            if (entity.getId() != null) {
                target = areaSgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "year",
                        "bjbh",
                        "projectName",
                        "buildName",
                        "buildUnitType",
                        "buildUnitAddress",
                        "buildSite",
                        "buildProjSize",
                        "contractPrice",
                        "contractPeriod",
                        "fr",
                        "buildUnitPhone",
                        "buildUnitPerson",
                        "buildUnitMobile",
                        "buildFileCode",
                        "buildXkzCode",
                        "startWorkCon",
                        "hjgYear",
                        "hjgNum",
                        "applyPerson",
                        "applyMatter",
                        "applyNum",
                        "materialPerson",
                        "materialPersonPhone",
                        "materialPersonAddress",
                        "receivePerson",
                        "receivePersonPhone",
                        "status",
                        "zbPrice",
                        "contractBeginDate",
                        "contractEndDate",
                        "projectPlanCost",
                        "sgUnitName",
                        "jlUnitName",
                        "sjUnitName",
                        "acceptCode",
                        "acceptOpinion",
                        "bizCode",
                        "propertyType"
                });

            } else {
                target = entity;
            }
            //保存填报区县
            String areaCode = request.getParameter("areaCode");
            if (!StringHelper.isEmpty(areaCode)) {
                SysCodeDetail detail = sysCodeManager.getCodeDetailByCode(Constants.PROJ_INFO_BELONG_AREA, areaCode);
                target.setAreaCode(detail.getCode());
                target.setAreaName(detail.getName());
            }

            SysUser sysUser = sysUserManager.getSysUser();
            Integer status = target.getStatus();
            if (status == AreaSgPermitStatus.STATUS_SUBMIT.getCode()) {
                target.setSubmitDate(new Timestamp(System.currentTimeMillis()));
                target.setBizCode(areaSgPermitManager.getBizCode(target.getProjectType().getCode(), "XX"));
            }
            if (status == AreaSgPermitStatus.STATUS_SLZX_PASS.getCode() || status == AreaSgPermitStatus.STATUS_SLZX_BACK.getCode()) {
                target.setAcceptDate(new Timestamp(System.currentTimeMillis()));
                target.setAcceptPerson(sysUser.getDisplayName());
            }
            String buildLbIds = "";
            String[] buildLbs = request.getParameterValues("buildLbId");
            if (null != buildLbs && buildLbs.length > 0) {
                for (String lb : buildLbs) {
                    buildLbIds += "," + lb;
                }
            }
            if (!StringHelper.isEmpty(buildLbIds)) {
                buildLbIds = buildLbIds.substring(1);
                target.setBuildLbIds(buildLbIds);
            }
            String buildSx = request.getParameter("buildSx");
            if (!StringHelper.isEmpty(buildSx)) {
                SysCodeDetail sx = sysCodeManager.getCodeListById(Long.valueOf(buildSx));
                target.setBuildSx(sx);
            }
            areaSgPermitService.save(target);
            //保存航道的扩展信息(先删除后保存)
            Set<AreaPermitHdExtend> sgPermitHdExtends = target.getAreaPermitHdExtends();
            for (AreaPermitHdExtend hdExtend : sgPermitHdExtends) {
                areaPermitHdExtendService.delete(hdExtend);
            }
            areaSgPermitManager.saveHdExtend(request, target);
            //保存信息之前先删除材料申请信息
            List<AreaSgMaterial> list1 = new ArrayList<AreaSgMaterial>();
            Set<AreaSgMaterial> sgMaterials = target.getAreaSgMaterials();
            for (AreaSgMaterial material : sgMaterials) {
                list1.add(material);
            }
            areaSgMaterialService.batchDelete(list1, list1.size());
            //保存材料信息
            List<AreaSgMaterial> saveList = new ArrayList<AreaSgMaterial>();
            String[] nos = request.getParameterValues("no");//序号
            if (null != nos && nos.length > 0) {
                for (String no : nos) {
                    AreaSgMaterial sgMaterial = new AreaSgMaterial();
                    sgMaterial.setSgPermit(target);
                    sgMaterial.setNo(Long.valueOf(no));
                    //份数
                    String yjNum = request.getParameter("yjNum" + no);
                    if (!StringHelper.isEmpty(yjNum)) {
                        sgMaterial.setYjNum(Long.valueOf(yjNum));
                    } else {
                        sgMaterial.setYjNum(null);
                    }
                    //份数
                    String sjNum = request.getParameter("sjNum" + no);
                    if (!StringHelper.isEmpty(sjNum)) {
                        sgMaterial.setSjNum(Long.valueOf(sjNum));
                    } else {
                        sgMaterial.setSjNum(null);
                    }
                    //附件
                    String docId = request.getParameter("docId" + no);//附件
                    if (!StringHelper.isEmpty(docId)) {
                        DocDocument docDocument = documentManager.getDocDocument(Long.valueOf(docId));
                        sgMaterial.setDoc(docDocument);
                    }
                    saveList.add(sgMaterial);
                }
            }
            areaSgMaterialService.batchSave(saveList, saveList.size());
            //保存操作信息

            if (status != AreaSgPermitStatus.STATUS_EDIT.getCode()) {

                AreaPermitOperation operation = new AreaPermitOperation();
                operation.setSgPermit(target);
                operation.setOptionCode(AreaSgPermitStatus.getTypeCode(status));
                operation.setOptionName(AreaSgPermitStatus.getNameByCode(status));
                operation.setOptionUser(sysUser.getDisplayName());
                operation.setStatus(status);
                areaPermitOperationService.save(operation);
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
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveAudit(HttpServletResponse response, @ModelAttribute("bean") AreaSgPermit entity, HttpServletRequest request) throws Exception {
        try {
            AreaSgPermit target;
            if (entity.getId() != null) {
                target = areaSgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "status",
                        "csOpinion",
                        "fhOpinion",
                        "shOpinion",
                        "backNum",
                        "bzBackMaterial"
                });

            } else {
                target = entity;
            }
            areaSgPermitService.save(target);
            Integer status = target.getStatus();
            SysUser sysUser = sysUserManager.getSysUser();
            Timestamp date = new Timestamp(System.currentTimeMillis());
            //保存历史审核信息
            if (status == AreaSgPermitStatus.STATUS_CS_PASS.getCode() || status == AreaSgPermitStatus.STATUS_CS_BACK.getCode()) { //初审
                target.setCsUser(sysUser.getDisplayName());
                target.setCsDate(date);
            } else if (status == AreaSgPermitStatus.STATUS_FH_PASS.getCode() || status == AreaSgPermitStatus.STATUS_FH_BACK.getCode()) { //复审
                target.setFhUser(sysUser.getDisplayName());
                target.setFhDate(date);
            } else if (status == AreaSgPermitStatus.STATUS_SH_PASS.getCode() || status == AreaSgPermitStatus.STATUS_SH_BACK.getCode()) { //审核
                target.setShUser(sysUser.getDisplayName());
                target.setShDate(date);
            }
            areaSgPermitService.save(target);
            //保存历史审核信息
            AreaHistoryOpinion historyOpinion = new AreaHistoryOpinion();
            historyOpinion.setSgPermit(target);
            historyOpinion.setProjectType(target.getProjectType());
            if (status == AreaSgPermitStatus.STATUS_CS_PASS.getCode() || status == AreaSgPermitStatus.STATUS_CS_BACK.getCode()) { //初审
                historyOpinion.setOpinion(target.getCsOpinion());
                historyOpinion.setAuditDate(target.getCsDate());
            } else if (status == AreaSgPermitStatus.STATUS_FH_PASS.getCode() || status == AreaSgPermitStatus.STATUS_FH_BACK.getCode()) { //复审
                historyOpinion.setOpinion(target.getFhOpinion());
                historyOpinion.setAuditDate(target.getFhDate());
            } else if (status == AreaSgPermitStatus.STATUS_SH_PASS.getCode() || status == AreaSgPermitStatus.STATUS_SH_BACK.getCode()) { //审核
                historyOpinion.setOpinion(target.getShOpinion());
                historyOpinion.setAuditDate(target.getShDate());
            }
            historyOpinion.setStatus(status);
            areaHistoryOpinionService.save(historyOpinion);
            //保存审核信息
            List<AreaAuditOpinion> saveList = new ArrayList<AreaAuditOpinion>();
            Set<AreaAuditOpinion> list = target.getAreaAuditOpinions();
//            List<AreaAuditOpinion> list = areaAuditOpinionService.findByProperty("sgPermit.id", target.getId());
            if (null != list && list.size() > 0) {
                for (AreaAuditOpinion opinion : list) {
                    Long no = opinion.getNo();
                    if (status == AreaSgPermitStatus.STATUS_FH_PASS.getCode()) {
                        String fhOpinion = request.getParameter("isFhOpinion" + no);
                        if (!StringHelper.isEmpty(fhOpinion) && Constants.FLAG_TRUE.equals(fhOpinion)) {
                            opinion.setIsFhOpinion(true);
                        } else if (!StringHelper.isEmpty(fhOpinion) && Constants.FLAG_FALSE.equals(fhOpinion)) {
                            opinion.setIsFhOpinion(false);
                        }
                    }
                    if (status == AreaSgPermitStatus.STATUS_SH_PASS.getCode()) {
                        String shOpinion = request.getParameter("isShOpinion" + no);
                        if (!StringHelper.isEmpty(shOpinion) && Constants.FLAG_TRUE.equals(shOpinion)) {
                            opinion.setIsShOpinion(true);
                        } else if (!StringHelper.isEmpty(shOpinion) && Constants.FLAG_FALSE.equals(shOpinion)) {
                            opinion.setIsShOpinion(false);
                        }
                    }
                    saveList.add(opinion);
                }
            } else {
                String[] nos = request.getParameterValues("no");
                if (null != nos && nos.length > 0) {
                    for (String no : nos) {
                        AreaAuditOpinion opinion = new AreaAuditOpinion();
                        opinion.setSgPermit(target);
                        opinion.setNo(Long.valueOf(no));
                        opinion.setStatus(status);
                        String csOpinion = request.getParameter("isCsOpinion" + no);
                        if (!StringHelper.isEmpty(csOpinion) && Constants.FLAG_TRUE.equals(csOpinion)) {
                            opinion.setIsCsOpinion(true);
                        } else if (!StringHelper.isEmpty(csOpinion) && Constants.FLAG_FALSE.equals(csOpinion)) {
                            opinion.setIsCsOpinion(false);
                        }
                        saveList.add(opinion);
                    }
                }
            }
            areaAuditOpinionService.batchSave(saveList, saveList.size());
            //保存操作信息
            AreaPermitOperation operation = new AreaPermitOperation();
            operation.setSgPermit(target);
            operation.setOptionCode(AreaSgPermitStatus.getTypeCode(status));
            operation.setOptionName(AreaSgPermitStatus.getNameByCode(status));
            operation.setOptionUser(sysUser.getDisplayName());
            operation.setStatus(status);
            areaPermitOperationService.save(operation);

            createOaTask(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "审核成功");
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
        AreaSgPermit areaSgPermit = areaSgPermitService.get(id);
        //删除审核意见
        List<AreaAuditOpinion> list1 = new ArrayList<AreaAuditOpinion>();
        Set<AreaAuditOpinion> sgAuditOpinions = areaSgPermit.getAreaAuditOpinions();
        for (AreaAuditOpinion opinion : sgAuditOpinions) {
            list1.add(opinion);
        }
        areaAuditOpinionService.batchDelete(list1, list1.size());
        //删除材料申请
        List<AreaSgMaterial> list2 = new ArrayList<AreaSgMaterial>();
        Set<AreaSgMaterial> sgMaterials = areaSgPermit.getAreaSgMaterials();
        for (AreaSgMaterial material : sgMaterials) {
//            DocDocument doc = material.getDoc();
//            if (null != doc) {
//                documentManager.removeAllDoc(doc.getId(), null);
//            }
            list2.add(material);
        }
        areaSgMaterialService.batchDelete(list2, list2.size());
        //删除操作记录
        List<AreaPermitOperation> list3 = new ArrayList<AreaPermitOperation>();
        Set<AreaPermitOperation> sgPermitOperations = areaSgPermit.getAreaPermitOperations();
        for (AreaPermitOperation operation : sgPermitOperations) {
            list3.add(operation);
        }
        areaPermitOperationService.batchDelete(list3, list3.size());
        //删除人员
        List<AreaProjPerson> list4 = new ArrayList<AreaProjPerson>();
        Set<AreaProjPerson> sgContractProjPersons = areaSgPermit.getAreaProjPersons();
        for (AreaProjPerson person : sgContractProjPersons) {
            list4.add(person);
        }
        areaProjPersonService.batchDelete(list4, list4.size());
        //删除工程
        List<AreaSgUnitProj> list5 = new ArrayList<AreaSgUnitProj>();
        Set<AreaSgUnitProj> sgUnitProjs = areaSgPermit.getAreaSgUnitProjs();
        for (AreaSgUnitProj proj : sgUnitProjs) {
            list5.add(proj);
        }
        areaSgUnitProjService.batchDelete(list5, list5.size());
        //删除航道扩展信息
        List<AreaPermitHdExtend> list6 = new ArrayList<AreaPermitHdExtend>();
        Set<AreaPermitHdExtend> sgPermitHdExtends = areaSgPermit.getAreaPermitHdExtends();
        for (AreaPermitHdExtend sgPermitHdExtend : sgPermitHdExtends) {
            list6.add(sgPermitHdExtend);
        }
        areaPermitHdExtendService.batchDelete(list6, list6.size());
        //删除历史信息
        List<AreaHistoryOpinion> list7 = new ArrayList<AreaHistoryOpinion>();
        Set<AreaHistoryOpinion> historyOpinions = areaSgPermit.getAreaHistoryOpinions();
        for (AreaHistoryOpinion opinion : historyOpinions) {
            list7.add(opinion);
        }
        areaHistoryOpinionService.batchDelete(list7, list7.size());
        areaSgPermitService.delete(areaSgPermit);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 获取最后保存的记录
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getSgPermitId(Model model, String projectTypeId) {
        List<AreaSgPermit> list = areaSgPermitService.findByQuery("from AreaSgPermit where projectType.id=" + projectTypeId + " order by id desc");
        if (list.size() > 0) {
            AreaSgPermit sgPermit = list.iterator().next();
            model.addAttribute("msg", "<id>" + sgPermit.getId() + "</id>");
        } else {
            model.addAttribute("msg", "<id></id>");
        }

        return "common/msg";
    }

    /**
     * 选择退回原因
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String selectMaterial(Model model) {
        String options = SgPermitNotAcceptMat.getOptions("");
        model.addAttribute("options", options);

        return "view/area/areaSgPermit/selectMaterial";
    }

    /**
     * 补正退回原因
     *
     * @return 。
     */
    @RequestMapping
    public String bzBackMaterial() {

        return "view/area/areaSgPermit/bzBackMaterial";
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(AreaSgPermit data) throws Exception {
        int status = data.getStatus();
        String simpleName = AreaSgPermit.class.getSimpleName();
        //创建任务
        String title;
        Set<Long> managers = new HashSet<Long>();
        if (status == AreaSgPermitStatus.STATUS_SUBMIT.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_sl_pass");
            //获取有初审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.AREA_PERMIT_SL_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_sl_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == AreaSgPermitStatus.STATUS_SLZX_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_ch_pass");
            //获取有初审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.AREA_PERMIT_CS_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_ch_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == AreaSgPermitStatus.STATUS_CS_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_fh_pass");
            //获取有复审权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.AREA_PERMIT_FH_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_fh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == AreaSgPermitStatus.STATUS_FH_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_sh_pass");
            //获取有审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.AREA_PERMIT_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_sh_pass", data.getId(), title, managers, false, null, null);
            }
        }
    }


    /**
     * 返回input页面
     *
     * @param projectType 。
     * @return 。
     */
    private String backPageInput(SysCodeDetail projectType) {
        String page = "view/area/areaSgPermit/input";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (projectType == gksh) {
            page = "view/area/areaSgPermit/inputGksh";
        } else if (projectType == hd) {
            page = "view/area/areaSgPermit/inputHd";
        } else if (projectType == gl) {
            page = "view/area/areaSgPermit/inputGl";
        } else if (projectType == szjcsh) {
            page = "view/area/areaSgPermit/inputSzjcsh";
        }
        return page;
    }

    /**
     * 返回accept页面
     *
     * @param projectType 。
     * @return 。
     */
    private String backPageAccept(SysCodeDetail projectType) {
        String page = "view/area/areaSgPermit/accept";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (projectType == gksh) {
            page = "view/area/areaSgPermit/acceptGksh";
        } else if (projectType == hd) {
            page = "view/area/areaSgPermit/acceptHd";
        } else if (projectType == gl) {
            page = "view/area/areaSgPermit/acceptGl";
        } else if (projectType == szjcsh) {
            page = "view/area/areaSgPermit/acceptSzjcsh";
        }
        return page;
    }

    /**
     * 返回audit页面
     *
     * @param projectType 。
     * @return 。
     */
    private String backPageAudit(SysCodeDetail projectType) {
        String page = "view/area/areaSgPermit/audit";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/area/areaSgPermit/auditGksh";
            } else if (projectType == hd) {
                page = "view/area/areaSgPermit/auditHd";
            } else if (projectType == gl) {
                page = "view/area/areaSgPermit/auditGl";
            } else if (projectType == szjcsh) {
                page = "view/area/areaSgPermit/auditSzjcsh";
            }
        }
        return page;
    }

    /**
     * 返回view页面
     *
     * @param projectType 。
     * @return 。
     */
    private String backPageView(SysCodeDetail projectType) {
        String page = "view/area/areaSgPermit/view";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/area/areaSgPermit/viewGksh";
            } else if (projectType == hd) {
                page = "view/area/areaSgPermit/viewHd";
            } else if (projectType == gl) {
                page = "view/area/areaSgPermit/viewGl";
            } else if (projectType == szjcsh) {
                page = "view/area/areaSgPermit/viewSzjcsh";
            }
        }
        return page;
    }

    /**
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel1(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //把打印的数据压入map中
        Map<String, Object> beans = new HashMap<String, Object>();
        String fileName = "公路施工许可证.xls";
        String id = request.getParameter("id");
        AreaSgPermit sgPermit = areaSgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        String title = "";
        String titleFl = "";
        String code = sgPermit.getProjectType().getCode();
        if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
            title = "上海市(港口)工程施工许可证";
            titleFl = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_GL)) {
            title = "上海市(公路)工程施工许可证";
            titleFl = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_SZJCSH)) {
            title = "上海市(市政基础设施)工程施工许可证";
            titleFl = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        }
        beans.put("title", title);
        beans.put("titleFl", titleFl);

        excelPrintManager.printExcel(response, request, SgPermit.class.getSimpleName(), xlsTemplateName1, beans, fileName);
    }

    /**
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel2(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //把打印的数据压入map中
        Map<String, Object> beans = new HashMap<String, Object>();
        String fileName = "公路施工许可证(绿色通道).xls";
        String id = request.getParameter("id");
        AreaSgPermit sgPermit = areaSgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        String title = "";
        String titleFl = "";
        String code = sgPermit.getProjectType().getCode();
        if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
            title = "上海市(港口)工程施工许可证";
            titleFl = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_GL)) {
            title = "上海市(公路)工程施工许可证";
            titleFl = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_SZJCSH)) {
            title = "上海市(市政基础设施)工程施工许可证";
            titleFl = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        }
        beans.put("title", title);
        beans.put("titleFl", titleFl);

        excelPrintManager.printExcel(response, request, SgPermit.class.getSimpleName(), xlsTemplateName2, beans, fileName);
    }

    /**
     * 导出excel
     *
     * @param response .
     * @throws Exception .
     */
    @RequestMapping
    public void printExcel3(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //把打印的数据压入map中
        Map<String, Object> beans = new HashMap<String, Object>();
        String fileName = "航道工程建设项目开工备案表.xls";
        String id = request.getParameter("id");
        AreaSgPermit sgPermit = areaSgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        Set<AreaPermitHdExtend> hdExtendSet = sgPermit.getAreaPermitHdExtends();
        if (hdExtendSet.size() > 0) {
            AreaPermitHdExtend hdExtend = hdExtendSet.iterator().next();
            beans.put("hdExtend", hdExtend);
        }

        excelPrintManager.printExcel(response, request, SgPermit.class.getSimpleName(), xlsTemplateName3, beans, fileName);
    }
}
