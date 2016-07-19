package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.SgPermitManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.SgPermitNotAcceptMat;
import com.justonetech.biz.utils.enums.SgPermitStatus;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * note:施工许可证
 * author: gq
 * create date:
 * modify date:
 */
@Controller
public class SgPermitController extends BaseCRUDActionController<SgPermit> {
    private Logger logger = LoggerFactory.getLogger(SgPermitController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SgPermitService sgPermitService;

    @Autowired
    private SgMaterialService sgMaterialService;

    @Autowired
    private SgAuditOpinionService sgAuditOpinionService;

    @Autowired
    private SgPermitOperationService sgPermitOperationService;

    @Autowired
    private SgContractProjPersonService sgContractProjPersonService;

    @Autowired
    private SgUnitProjService sgUnitProjService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private SgPermitManager sgPermitManager;

    @Autowired
    private ExcelPrintManager excelPrintManager;

    @Autowired
    private SgPermitHdExtendService sgPermitHdExtendService;

    @Autowired
    private SgPermitHistoryOpinionService sgPermitHistoryOpinionService;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private OaTaskDealService oaTaskDealService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

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

        sgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态

        return "view/sg/sgPermit/grid";
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
            String hql = "from SgPermit where 1=1";
            if (null != sysUser.getRegPerson()) {
                hql += " and createUser='" + sysUser.getLoginName() + "'";
            }
            if (!"sh".equals(area) && !StringHelper.isEmpty(area)) {//上海市可以看到所有，区县只能看到对应区县
                hql += " and areaCode='" + area + "'";
            }
            hql += " order by id desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = sgPermitService.findByPage(pageModel, queryTranslate.toString());
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

        return "view/sg/sgPermit/projectType";
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
    public String frame(Model model, String id, String act, String projectTypeId, Long oaTaskDealId) {
        model.addAttribute("id", JspHelper.getString(id));
        model.addAttribute("act", JspHelper.getString(act));
        if (!StringHelper.isEmpty(projectTypeId)) {
            model.addAttribute("projectTypeId", projectTypeId);
            SysCodeDetail projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            model.addAttribute("projName", projectType.getName());
        }
        if (!StringHelper.isEmpty(id)) {
            SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
            model.addAttribute("projectTypeId", sgPermit.getProjectType().getId());
            model.addAttribute("projName", sgPermit.getProjectType().getName());
        }
        if (null != oaTaskDealId) {
            OaTaskDeal oaTaskDeal = oaTaskDealService.get(oaTaskDealId);
            oaTaskDeal.setStatus(Constants.OA_TASK_ACCEPT);
            oaTaskDealService.save(oaTaskDeal);
        }

        return "view/sg/sgPermit/frame";
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
        SgPermit sgPermit = new SgPermit();
        SysCodeDetail projectType;
        if (!StringHelper.isEmpty(id)) {
            sgPermit = sgPermitService.get(Long.valueOf(id));
        } else {
            Calendar calendar = Calendar.getInstance();
            sgPermit.setYear(calendar.get(Calendar.YEAR));
            sgPermit.setStatus(SgPermitStatus.STATUS_EDIT.getCode());
        }
        if (!StringHelper.isEmpty(projectTypeId)) {
            projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            sgPermit.setProjectType(projectType);
        } else {
            projectType = sgPermit.getProjectType();
        }
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "edit", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态
        SgPermitHdExtend hdExtend = new SgPermitHdExtend();
        if (projectType.getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<SgPermitHdExtend> extendSet = sgPermit.getSgPermitHdExtends();
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
    public String jgzxYs(Model model, String id) {
        SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态
        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<SgPermitHdExtend> extendSet = sgPermit.getSgPermitHdExtends();
            if (null != extendSet && extendSet.size() > 0) {
                SgPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }

        return backPageJgzxYs(sgPermit.getProjectType());
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
        SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态
        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<SgPermitHdExtend> extendSet = sgPermit.getSgPermitHdExtends();
            if (null != extendSet && extendSet.size() > 0) {
                SgPermitHdExtend hdExtend = extendSet.iterator().next();
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "edit", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);//编码和状态

        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<SgPermitHdExtend> extendSet = sgPermit.getSgPermitHdExtends();
            if (extendSet.size() > 0) {
                SgPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }
        SysCodeDetail detail = sgPermit.getPropertyType();
        boolean isGreen;
        if (null != detail) {
            String code = detail.getCode();
            if (code.equals(Constants.PROJECT_PROPERTY_5)) {
                isGreen = false;
            } else {
                isGreen = true;
            }
        } else {
            isGreen = false;
        }
        model.addAttribute("isGreen", isGreen);
//        List<SgPermitHistoryOpinion> historys = sgPermitManager.getHistorys(sgPermit);
        Set<SgPermitHistoryOpinion> opinions = sgPermit.getSgPermitHistoryOpinions();
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);

        if (sgPermit.getProjectType().getCode().equals(Constants.PROJECT_TYPE_HD)) {
            Set<SgPermitHdExtend> extendSet = sgPermit.getSgPermitHdExtends();
            if (extendSet.size() > 0) {
                SgPermitHdExtend hdExtend = extendSet.iterator().next();
                model.addAttribute("hdExtend", hdExtend);
            }
        }
        SysCodeDetail detail = sgPermit.getPropertyType();
        boolean isGreen;
        if (null != detail) {
            String code = detail.getCode();
            if (code.equals(Constants.PROJECT_PROPERTY_5)) {
                isGreen = false;
            } else {
                isGreen = true;
            }
        } else {
            isGreen = false;
        }
        model.addAttribute("isGreen", isGreen);
//        List<SgPermitHistoryOpinion> historys = sgPermitManager.getHistorys(sgPermit);
        Set<SgPermitHistoryOpinion> opinions = sgPermit.getSgPermitHistoryOpinions();
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);

        return "view/sg/sgPermit/printView";
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        model.addAttribute("title", sgPermit.getProjectType().getName());

        return "view/sg/sgPermit/printView1";
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);

        return "view/sg/sgPermit/printView2";
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/sg/sgPermit/printView3";
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/sg/sgPermit/printView4";
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
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = sgPermitManager.getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = sgPermitManager.getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        sgPermitManager.doPrivilegeCodeAndStatus(model);

        return "view/sg/sgPermit/printView5";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SgPermit entity, HttpServletRequest request) throws Exception {
        try {
            SgPermit target;
            if (entity.getId() != null) {
                target = sgPermitService.get(entity.getId());
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
                        "propertyType",
                        "jgzxYsOpinion",
                        "jgzxYsDate",
                        "bdh",
                        "buildSiteCounty",
                        "nationalFundsPro",
                        "sgUnitManager",
                        "jlUnitManager"
                });
            } else {
                target = entity;
            }
            target.setAreaCode("sh");
            target.setAreaName("上海市");
            String buildSiteCounty = request.getParameter("buildSiteCounty");
            if (!StringHelper.isEmpty(buildSiteCounty)) {
                SysCodeDetail detail = sysCodeManager.getCodeListById(Long.valueOf(buildSiteCounty));
                target.setBuildSiteCounty(detail.getCode());
            }
            SysUser sysUser = sysUserManager.getSysUser();
            Integer status = target.getStatus();
            if (status == SgPermitStatus.STATUS_SUBMIT.getCode()) {
                target.setSubmitDate(new Timestamp(System.currentTimeMillis()));
                target.setBizCode(sgPermitManager.getBizCode(target.getProjectType().getCode()));
            }
            if (status == SgPermitStatus.STATUS_SLZX_PASS.getCode() || status == SgPermitStatus.STATUS_SLZX_BACK.getCode()) {
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
            sgPermitService.save(target);
            //保存航道的扩展信息(先删除后保存)
            Set<SgPermitHdExtend> sgPermitHdExtends = target.getSgPermitHdExtends();
            for (SgPermitHdExtend hdExtend : sgPermitHdExtends) {
                sgPermitHdExtendService.delete(hdExtend);
            }
            sgPermitManager.saveHdExtend(request, target);
            //保存信息之前先删除材料申请信息
            List<SgMaterial> list1 = new ArrayList<SgMaterial>();
            Set<SgMaterial> sgMaterials = target.getSgMaterials();
            for (SgMaterial material : sgMaterials) {
                list1.add(material);
            }
            sgMaterialService.batchDelete(list1, list1.size());
            //保存材料信息
            List<SgMaterial> saveList = new ArrayList<SgMaterial>();
            String[] nos = request.getParameterValues("no");//序号
            if (null != nos && nos.length > 0) {
                for (String no : nos) {
                    SgMaterial sgMaterial = new SgMaterial();
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
            sgMaterialService.batchSave(saveList, saveList.size());
            //保存操作信息

            if (status != SgPermitStatus.STATUS_EDIT.getCode()) {
                SgPermitOperation operation = new SgPermitOperation();
                operation.setSgPermit(target);
                operation.setOptionCode(SgPermitStatus.getTypeCode(status));
                operation.setOptionName(SgPermitStatus.getNameByCode(status));
                operation.setOptionUser(sysUser.getDisplayName());
                operation.setStatus(status);
                sgPermitOperationService.save(operation);
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
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveJgzxYs(HttpServletResponse response, @ModelAttribute("bean") SgPermit entity) throws Exception {
        try {
            SgPermit target;
            if (entity.getId() != null) {
                target = sgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "status",
                        "jgzxYsOpinion"
                });
            } else {
                target = entity;
            }
            sgPermitService.save(target);
            Integer status = target.getStatus();
            SysUser sysUser = sysUserManager.getSysUser();
            Timestamp date = new Timestamp(System.currentTimeMillis());
            //保存历史审核信息
            if (status == SgPermitStatus.STATUS_JGZX_YS_PASS.getCode() || status == SgPermitStatus.STATUS_JGZX_YS_BACK.getCode()) {
                target.setJgzxYsUser(sysUser.getDisplayName());
                target.setJgzxYsDate(date);
            }
            sgPermitService.save(target);
            //保存历史审核信息
            SgPermitHistoryOpinion historyOpinion = new SgPermitHistoryOpinion();
            historyOpinion.setSgPermit(target);
            historyOpinion.setProjectType(target.getProjectType());
            if (status == SgPermitStatus.STATUS_JGZX_YS_PASS.getCode() || status == SgPermitStatus.STATUS_JGZX_YS_BACK.getCode()) {
                historyOpinion.setOpinion(target.getCsOpinion());
                historyOpinion.setAuditDate(target.getCsDate());
            }
            historyOpinion.setStatus(status);
            sgPermitHistoryOpinionService.save(historyOpinion);

            //保存操作信息
            SgPermitOperation operation = new SgPermitOperation();
            operation.setSgPermit(target);
            operation.setOptionCode(SgPermitStatus.getTypeCode(status));
            operation.setOptionName(SgPermitStatus.getNameByCode(status));
            operation.setOptionUser(sysUser.getDisplayName());
            operation.setStatus(status);
            sgPermitOperationService.save(operation);

            createOaTask(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "审核成功");
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
    public void saveAudit(HttpServletResponse response, @ModelAttribute("bean") SgPermit entity, HttpServletRequest request) throws Exception {
        try {
            SgPermit target;
            if (entity.getId() != null) {
                target = sgPermitService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "status",
                        "csOpinion",
                        "fhOpinion",
                        "shOpinion",
                        "fgldOpinion",
                        "zxldOpinion",
                        "jscOpinion",
                        "spcOpinion",
                        "wldOpinion",
                        "backNum",
                        "bzBackMaterial"
                });

            } else {
                target = entity;
            }
            sgPermitService.save(target);
            Integer status = target.getStatus();
            SysUser sysUser = sysUserManager.getSysUser();
            Timestamp date = new Timestamp(System.currentTimeMillis());
            //保存历史审核信息
            if (status == SgPermitStatus.STATUS_CS_PASS.getCode() || status == SgPermitStatus.STATUS_CS_BACK.getCode()) { //初审
                target.setCsUser(sysUser.getDisplayName());
                target.setCsDate(date);
            } else if (status == SgPermitStatus.STATUS_FH_PASS.getCode() || status == SgPermitStatus.STATUS_FH_BACK.getCode()) { //复审
                target.setFhUser(sysUser.getDisplayName());
                target.setFhDate(date);
            } else if (status == SgPermitStatus.STATUS_SH_PASS.getCode() || status == SgPermitStatus.STATUS_SH_BACK.getCode()) { //审核
                target.setShUser(sysUser.getDisplayName());
                target.setShDate(date);
            } else if (status == SgPermitStatus.STATUS_FGLD_PASS.getCode() || status == SgPermitStatus.STATUS_FGLD_BACK.getCode()) { //分管领导审核
                target.setFgldUser(sysUser.getDisplayName());
                target.setFgldDate(date);
            } else if (status == SgPermitStatus.STATUS_ZXLD_PASS.getCode() || status == SgPermitStatus.STATUS_ZXLD_BACK.getCode()) { //中心领导审核
                target.setZxldUser(sysUser.getDisplayName());
                target.setZxldDate(date);
            } else if (status == SgPermitStatus.STATUS_JSC_XK.getCode() || status == SgPermitStatus.STATUS_JSC_BXK.getCode() || status == SgPermitStatus.STATUS_JSC_BACK.getCode()) { //中心领导审核
                target.setJscUser(sysUser.getDisplayName());
                target.setJscDate(date);
            } else if (status == SgPermitStatus.STATUS_SPC_XK.getCode() || status == SgPermitStatus.STATUS_SPC_BXK.getCode() || status == SgPermitStatus.STATUS_SPC_BACK.getCode()) { //中心领导审核
                target.setSpcUser(sysUser.getDisplayName());
                target.setSpcDate(date);
            } else if (status == SgPermitStatus.STATUS_WLD_PASS.getCode() || status == SgPermitStatus.STATUS_WLD_BACK.getCode()) { //委领导审核
                target.setWldUser(sysUser.getDisplayName());
                target.setWldDate(date);
            }
            sgPermitService.save(target);
            //保存历史审核信息
            SgPermitHistoryOpinion historyOpinion = new SgPermitHistoryOpinion();
            historyOpinion.setSgPermit(target);
            historyOpinion.setProjectType(target.getProjectType());
            if (status == SgPermitStatus.STATUS_CS_PASS.getCode() || status == SgPermitStatus.STATUS_CS_BACK.getCode()) { //初审
                historyOpinion.setOpinion(target.getCsOpinion());
                historyOpinion.setAuditDate(target.getCsDate());
            } else if (status == SgPermitStatus.STATUS_FH_PASS.getCode() || status == SgPermitStatus.STATUS_FH_BACK.getCode()) { //复审
                historyOpinion.setOpinion(target.getFhOpinion());
                historyOpinion.setAuditDate(target.getFhDate());
            } else if (status == SgPermitStatus.STATUS_SH_PASS.getCode() || status == SgPermitStatus.STATUS_SH_BACK.getCode()) { //审核
                historyOpinion.setOpinion(target.getShOpinion());
                historyOpinion.setAuditDate(target.getShDate());
            } else if (status == SgPermitStatus.STATUS_FGLD_PASS.getCode() || status == SgPermitStatus.STATUS_FGLD_BACK.getCode()) { //分管领导审核
                historyOpinion.setOpinion(target.getFgldOpinion());
                historyOpinion.setAuditDate(target.getFgldDate());
            } else if (status == SgPermitStatus.STATUS_ZXLD_PASS.getCode() || status == SgPermitStatus.STATUS_ZXLD_BACK.getCode()) { //中心领导审核
                historyOpinion.setOpinion(target.getZxldOpinion());
                historyOpinion.setAuditDate(target.getZxldDate());
            } else if (status == SgPermitStatus.STATUS_JSC_XK.getCode() || status == SgPermitStatus.STATUS_JSC_BXK.getCode() || status == SgPermitStatus.STATUS_JSC_BACK.getCode()) { //中心领导审核
                historyOpinion.setOpinion(target.getJscOpinion());
                historyOpinion.setAuditDate(target.getJscDate());
            } else if (status == SgPermitStatus.STATUS_SPC_XK.getCode() || status == SgPermitStatus.STATUS_SPC_BXK.getCode() || status == SgPermitStatus.STATUS_SPC_BACK.getCode()) { //中心领导审核
                historyOpinion.setOpinion(target.getSpcOpinion());
                historyOpinion.setAuditDate(target.getSpcDate());
            } else if (status == SgPermitStatus.STATUS_WLD_PASS.getCode() || status == SgPermitStatus.STATUS_WLD_BACK.getCode()) { //委领导审核
                historyOpinion.setOpinion(target.getWldOpinion());
                historyOpinion.setAuditDate(target.getWldDate());
            }
            historyOpinion.setStatus(status);
            sgPermitHistoryOpinionService.save(historyOpinion);
            //保存审核信息
            List<SgAuditOpinion> saveList = new ArrayList<SgAuditOpinion>();
            List<SgAuditOpinion> list = sgAuditOpinionService.findByProperty("sgPermit.id", target.getId());
            if (null != list && list.size() > 0) {
                for (SgAuditOpinion opinion : list) {
                    Long no = opinion.getNo();
                    if (status == SgPermitStatus.STATUS_FH_PASS.getCode()) {
                        String fhOpinion = request.getParameter("isFhOpinion" + no);
                        if (!StringHelper.isEmpty(fhOpinion) && Constants.FLAG_TRUE.equals(fhOpinion)) {
                            opinion.setIsFhOpinion(true);
                        } else if (!StringHelper.isEmpty(fhOpinion) && Constants.FLAG_FALSE.equals(fhOpinion)) {
                            opinion.setIsFhOpinion(false);
                        }
                    }
                    if (status == SgPermitStatus.STATUS_SH_PASS.getCode()) {
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
                        SgAuditOpinion opinion = new SgAuditOpinion();
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
            sgAuditOpinionService.batchSave(saveList, saveList.size());
            //保存操作信息
            SgPermitOperation operation = new SgPermitOperation();
            operation.setSgPermit(target);
            operation.setOptionCode(SgPermitStatus.getTypeCode(status));
            operation.setOptionName(SgPermitStatus.getNameByCode(status));
            operation.setOptionUser(sysUser.getDisplayName());
            operation.setStatus(status);
            sgPermitOperationService.save(operation);

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
        SgPermit sgPermit = sgPermitService.get(id);
        //删除审核意见
        List<SgAuditOpinion> list1 = new ArrayList<SgAuditOpinion>();
        Set<SgAuditOpinion> sgAuditOpinions = sgPermit.getSgAuditOpinions();
        for (SgAuditOpinion opinion : sgAuditOpinions) {
            list1.add(opinion);
        }
        sgAuditOpinionService.batchDelete(list1, list1.size());
        //删除材料申请
        List<SgMaterial> list2 = new ArrayList<SgMaterial>();
        Set<SgMaterial> sgMaterials = sgPermit.getSgMaterials();
        for (SgMaterial material : sgMaterials) {
//            DocDocument doc = material.getDoc();
//            if (null != doc) {
//                documentManager.removeAllDoc(doc.getId(), null);
//            }
            list2.add(material);
        }
        sgMaterialService.batchDelete(list2, list2.size());
        //删除操作记录
        List<SgPermitOperation> list3 = new ArrayList<SgPermitOperation>();
        Set<SgPermitOperation> sgPermitOperations = sgPermit.getSgPermitOperations();
        for (SgPermitOperation operation : sgPermitOperations) {
            list3.add(operation);
        }
        sgPermitOperationService.batchDelete(list3, list3.size());
        //删除人员
        List<SgContractProjPerson> list4 = new ArrayList<SgContractProjPerson>();
        Set<SgContractProjPerson> sgContractProjPersons = sgPermit.getSgContractProjPersons();
        for (SgContractProjPerson person : sgContractProjPersons) {
            list4.add(person);
        }
        sgContractProjPersonService.batchDelete(list4, list4.size());
        //删除工程
        List<SgUnitProj> list5 = new ArrayList<SgUnitProj>();
        Set<SgUnitProj> sgUnitProjs = sgPermit.getSgUnitProjs();
        for (SgUnitProj proj : sgUnitProjs) {
            list5.add(proj);
        }
        sgUnitProjService.batchDelete(list5, list5.size());
        //删除航道扩展信息
        List<SgPermitHdExtend> list6 = new ArrayList<SgPermitHdExtend>();
        Set<SgPermitHdExtend> sgPermitHdExtends = sgPermit.getSgPermitHdExtends();
        for (SgPermitHdExtend sgPermitHdExtend : sgPermitHdExtends) {
            list6.add(sgPermitHdExtend);
        }
        sgPermitHdExtendService.batchDelete(list6, list6.size());
        //删除历史信息
        List<SgPermitHistoryOpinion> list7 = new ArrayList<SgPermitHistoryOpinion>();
        Set<SgPermitHistoryOpinion> historyOpinions = sgPermit.getSgPermitHistoryOpinions();
        for (SgPermitHistoryOpinion opinion : historyOpinions) {
            list7.add(opinion);
        }
        sgPermitHistoryOpinionService.batchDelete(list7, list7.size());
        sgPermitService.delete(sgPermit);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void doCh(HttpServletResponse response, Long id) throws Exception {
        SgPermit sgPermit = sgPermitService.get(id);
        sgPermit.setStatus(SgPermitStatus.STATUS_CH.getCode());
        sgPermitService.save(sgPermit);
        sendSuccessJSON(response, "撤回成功");
    }


    /**
     * 获取最后保存的记录
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getSgPermitId(Model model, String projectTypeId) {
        List<SgPermit> list = sgPermitService.findByQuery("from SgPermit where projectType.id=" + projectTypeId + " order by id desc");
        if (list.size() > 0) {
            SgPermit sgPermit = list.iterator().next();
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

        return "view/sg/sgPermit/selectMaterial";
    }

    /**
     * 补正退回原因
     *
     * @return 。
     */
    @RequestMapping
    public String bzBackMaterial() {

        return "view/sg/sgPermit/bzBackMaterial";
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(SgPermit data) throws Exception {
        int status = data.getStatus();
        String simpleName = SgPermit.class.getSimpleName();
        //创建任务
        String title;
        Set<Long> managers = new HashSet<Long>();
        SysUser sysUser = sysUserManager.getSysUser();
        boolean isSubmit = status == SgPermitStatus.STATUS_SUBMIT.getCode();
        boolean isYstg = status == SgPermitStatus.STATUS_JGZX_YS_PASS.getCode();
        boolean isNotYstg = status == SgPermitStatus.STATUS_JGZX_YS_BACK.getCode();
        boolean isZxsj = status == SgPermitStatus.STATUS_SLZX_PASS.getCode();
        boolean isCsPass = status == SgPermitStatus.STATUS_CS_PASS.getCode();
        boolean isFhPass = status == SgPermitStatus.STATUS_FH_PASS.getCode();
        boolean isShPass = status == SgPermitStatus.STATUS_SH_PASS.getCode();
        boolean isNotShPass = status == SgPermitStatus.STATUS_SH_BACK.getCode();
        boolean isFgldPass = status == SgPermitStatus.STATUS_FGLD_PASS.getCode();
        boolean isNotFgldPass = status == SgPermitStatus.STATUS_FGLD_BACK.getCode();
        boolean isZxldPass = status == SgPermitStatus.STATUS_ZXLD_PASS.getCode();
        boolean isNotZxldPass = status == SgPermitStatus.STATUS_ZXLD_BACK.getCode();
        boolean isJscPass = status == SgPermitStatus.STATUS_JSC_XK.getCode();
        boolean isNotJscPass = status == SgPermitStatus.STATUS_JSC_BXK.getCode();
        boolean isJscBack = status == SgPermitStatus.STATUS_JSC_BACK.getCode();
        boolean isSpcPass = status == SgPermitStatus.STATUS_SPC_XK.getCode();
        boolean isNotSpcPass = status == SgPermitStatus.STATUS_SPC_BXK.getCode();
        boolean isSpcBack = status == SgPermitStatus.STATUS_SPC_BACK.getCode();
        boolean isWldPass = status == SgPermitStatus.STATUS_WLD_PASS.getCode();
        boolean isWldBack = status == SgPermitStatus.STATUS_WLD_BACK.getCode();
        //发送短信
        String code = data.getProjectType().getCode();
        boolean isNotSzjc = code.equals(Constants.PROJECT_TYPE_GKSH) || code.equals(Constants.PROJECT_TYPE_HD) || code.equals(Constants.PROJECT_TYPE_GL);
        boolean isSzjc = code.equals(Constants.PROJECT_TYPE_SZJCSH_SD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GJCZ) || code.equals(Constants.PROJECT_TYPE_SZJCSH_CSDL);
        String smsContent = "报建编号:" + data.getBjbh() + ",标段号:" + data.getBdh() + "，项目名称为" + data.getProjectName() + "的项目施工许可";
        String sendContent = "";
        SysUser receiveUser;
        String[] ids = new String[1];
        if (isSubmit || isZxsj) {//建设单位提交
            if (isSubmit) {
                sendContent = smsContent + "申请已提交，请进行预审。";
            } else if (isZxsj) {
                sendContent = smsContent + "收件已完成，请进行初审。";
            }
            if (isNotSzjc) {//航道、公路和港口设施发给石鹏
                receiveUser = sysUserManager.getSysUserByDisplayName("石鹏");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (isSzjc) {//市政基础设施发给李偲
                receiveUser = sysUserManager.getSysUserByDisplayName("李偲");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (isSubmit) {
                oaTaskManager.removeTask(simpleName + "_submit", data.getId());
                oaTaskManager.createTask(simpleName + "_submit", data.getId(), sendContent, managers, false, null, null);
            } else if (isZxsj) {
                oaTaskManager.removeTask(simpleName + "_sjtg", data.getId());
                oaTaskManager.createTask(simpleName + "_sjtg", data.getId(), sendContent, managers, false, null, null);
            }
        } else if (isYstg) {//预审通过后，发送给建设单位
            receiveUser = sysUserManager.getSysUserByDisplayName(data.getBuildUnitPerson());
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                sendContent = smsContent + "已通过预审，请将纸质材料送至行政服务中心。";
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            receiveUser = sysUserManager.getSysUserByDisplayName("龚煜");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                sendContent = smsContent + "已通过预审，请准备收件。";
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_ys_pass", data.getId());
            oaTaskManager.createTask(simpleName + "_ys_pass", data.getId(), sendContent, managers, false, null, null);
        } else if (isNotYstg) {//预审不通过发给建设单位
            receiveUser = sysUserManager.getSysUserByDisplayName(data.getBuildUnitPerson());
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                sendContent = smsContent + "未通过预审，请在系统中修改后提交。";
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_ys_back", data.getId());
            oaTaskManager.createTask(simpleName + "_ys_back", data.getId(), sendContent, managers, false, null, null);
        } else if (isCsPass) {
            sendContent = smsContent + "初审已完成，请进行复核。";
            if (isNotSzjc) {
                receiveUser = sysUserManager.getSysUserByDisplayName("张慧慧");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (isSzjc) {
                receiveUser = sysUserManager.getSysUserByDisplayName("杨斌");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            oaTaskManager.removeTask(simpleName + "_ch_pass", data.getId());
            oaTaskManager.createTask(simpleName + "_ch_pass", data.getId(), sendContent, managers, false, null, null);
        } else if (isFhPass || isNotFgldPass) {
            if (isFhPass) {
                sendContent = smsContent + "复核已完成，请进行审核。";
            } else if (isNotFgldPass) {
                sendContent = smsContent + "未通过审定，请重新进行审核。";
            }
            if (isNotSzjc) {
                receiveUser = sysUserManager.getSysUserByDisplayName("施伟");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (isSzjc) {
                receiveUser = sysUserManager.getSysUserByDisplayName("顾顺兴");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (isFhPass) {
                oaTaskManager.removeTask(simpleName + "_fh_pass", data.getId());
                oaTaskManager.createTask(simpleName + "_fh_pass", data.getId(), sendContent, managers, false, null, null);
            } else if (isNotFgldPass) {
                oaTaskManager.removeTask(simpleName + "_fgldsh_back", data.getId());
                oaTaskManager.createTask(simpleName + "_fgldsh_back", data.getId(), sendContent, managers, false, null, null);
            }

        } else if (isShPass) {
            sendContent = smsContent + "审核已完成，请进行审定。";
            receiveUser = sysUserManager.getSysUserByDisplayName("林海榕");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_sh_pass", data.getId());
            oaTaskManager.createTask(simpleName + "_sh_pass", data.getId(), sendContent, managers, false, null, null);
        } else if (isNotShPass) {
            sendContent = smsContent + "未通过审核，请在系统中修改后提交。";
            receiveUser = sysUserManager.getSysUserByDisplayName(data.getBuildUnitPerson());
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_sh_back", data.getId());
            oaTaskManager.createTask(simpleName + "_sh_back", data.getId(), sendContent, managers, false, null, null);
        } else if (isFgldPass) {
            sendContent = smsContent + "审定已完成，请进行审查。";
            receiveUser = sysUserManager.getSysUserByDisplayName("杨志杰");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_fgldsh_pass", data.getId());
            oaTaskManager.createTask(simpleName + "_fgldsh_pass", data.getId(), sendContent, managers, false, null, null);
        } else if (isZxldPass) {
            sendContent = smsContent + "中心审查已完成，请委建设处进行审查。";
            if (code.equals(Constants.PROJECT_TYPE_GL) || code.equals(Constants.PROJECT_TYPE_SZJCSH_CSDL)) {//公路和市政基础设施-城市道路发给胡燎原
                receiveUser = sysUserManager.getSysUserByDisplayName("胡燎原");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_HD) || code.equals(Constants.PROJECT_TYPE_GKSH)) {//港口和航道发给俞晓
                receiveUser = sysUserManager.getSysUserByDisplayName("俞晓");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_SD)) {//市政基础设施-隧道发给陈骞
                receiveUser = sysUserManager.getSysUserByDisplayName("陈骞");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_GD)) {//市政基础设施-隧道发给陈骞
                receiveUser = sysUserManager.getSysUserByDisplayName("宋光华");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_GJCZ)) {//市政基础设施-公交场站
                receiveUser = sysUserManager.getSysUserByDisplayName("徐倩华");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            oaTaskManager.createTask(simpleName + "_zxldsh_pass", data.getId(), sendContent, managers, false, null, null);
        } else if (isNotZxldPass) {//审核不通过，发给林海榕。
            sendContent = smsContent + "未通过审查，请重新进行审定。";
            receiveUser = sysUserManager.getSysUserByDisplayName("林海榕");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_zxldsh_back", data.getId());
            oaTaskManager.createTask(simpleName + "_zxldsh_back", data.getId(), sendContent, managers, false, null, null);
        } else if (isJscPass || isNotJscPass) {//委建设处许可和不许可，发给狄永媚。
            sendContent = smsContent + "委建设处审查已完成，请委审批处进行审查。";
            receiveUser = sysUserManager.getSysUserByDisplayName("狄永媚");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_wjsc", data.getId());
            oaTaskManager.createTask(simpleName + "_wjsc", data.getId(), sendContent, managers, false, null, null);
        } else if (isJscBack) {//退回，发给杨志杰。
            sendContent = smsContent + "委建设处未通过审查，请中心领导进行审查。";
            receiveUser = sysUserManager.getSysUserByDisplayName("杨志杰");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_wjsc_back", data.getId());
            oaTaskManager.createTask(simpleName + "_wjsc_back", data.getId(), sendContent, managers, false, null, null);
        } else if (isSpcPass || isNotSpcPass) {//委审批处许可和不许可，发给刘军。
            sendContent = smsContent + "委审批处审查已完成，请委领导进行审查。";
            receiveUser = sysUserManager.getSysUserByDisplayName("刘军");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
            }
            oaTaskManager.removeTask(simpleName + "_wspc", data.getId());
            oaTaskManager.createTask(simpleName + "_wspc", data.getId(), sendContent, managers, false, null, null);
        } else if (isSpcBack) {//退回
            sendContent = smsContent + "委审批处未通过审查，请委建设处进行审查。";
            if (code.equals(Constants.PROJECT_TYPE_GL) || code.equals(Constants.PROJECT_TYPE_SZJCSH_CSDL)) {//公路和市政基础设施-城市道路发给胡燎原
                receiveUser = sysUserManager.getSysUserByDisplayName("胡燎原");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_HD) || code.equals(Constants.PROJECT_TYPE_GKSH)) {//港口和航道发给俞晓
                receiveUser = sysUserManager.getSysUserByDisplayName("俞晓");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_SD)) {//市政基础设施-隧道发给陈骞
                receiveUser = sysUserManager.getSysUserByDisplayName("陈骞");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_GD)) {//市政基础设施-隧道发给陈骞
                receiveUser = sysUserManager.getSysUserByDisplayName("宋光华");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            if (code.equals(Constants.PROJECT_TYPE_SZJCSH_GJCZ)) {//市政基础设施-公交场站
                receiveUser = sysUserManager.getSysUserByDisplayName("徐倩华");
                if (null != receiveUser) {
                    ids[0] = String.valueOf(receiveUser.getId());
                    msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                    managers.add(receiveUser.getId());
                }
            }
            oaTaskManager.removeTask(simpleName + "_wspc_back", data.getId());
            oaTaskManager.createTask(simpleName + "_wspc_back", data.getId(), sendContent, managers, false, null, null);
        } else if (isWldPass) {//委领导许可，发给建设单位。委领导许可，发给行政服务中心龚煜。
            receiveUser = sysUserManager.getSysUserByDisplayName("龚煜");
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                sendContent = smsContent + "审查已完成，请准备好施工许可证。";
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
                oaTaskManager.removeTask(simpleName + "_wldsh_pass", data.getId());
                oaTaskManager.createTask(simpleName + "_wldsh_pass", data.getId(), sendContent, managers, false, null, null);
            }
            receiveUser = sysUserManager.getSysUserByDisplayName(data.getBuildUnitPerson());
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                sendContent = smsContent + "审查已完成，请至交通委行政服务中心领证。";
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
                oaTaskManager.removeTask(simpleName + "_wldsh_pass", data.getId());
                oaTaskManager.createTask(simpleName + "_wldsh_pass", data.getId(), sendContent, managers, false, null, null);
            }
        } else if (isWldBack) {//委领导不予许可。
            sendContent = smsContent + "不予行政许可。";
            receiveUser = sysUserManager.getSysUserByDisplayName(data.getBuildUnitPerson());
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(sendContent, sysUser, ids);
                managers.add(receiveUser.getId());
                oaTaskManager.removeTask(simpleName + "_wldsh_back", data.getId());
                oaTaskManager.createTask(simpleName + "_wldsh_back", data.getId(), sendContent, managers, false, null, null);
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
        String page = "view/sg/sgPermit/input";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh_sd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_SD);//市政基础设施
        SysCodeDetail szjcsh_gd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GD);//市政基础设施
        SysCodeDetail szjcsh_gjcz = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GJCZ);//市政基础设施
        SysCodeDetail szjcsh_csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_CSDL);//市政基础设施
        if (projectType == gksh) {
            page = "view/sg/sgPermit/inputGksh";
        } else if (projectType == hd) {
            page = "view/sg/sgPermit/inputHd";
        } else if (projectType == gl) {
            page = "view/sg/sgPermit/inputGl";
        } else if (projectType == szjcsh_sd || projectType == szjcsh_gd || projectType == szjcsh_gjcz || projectType == szjcsh_csdl) {
            page = "view/sg/sgPermit/inputSzjcsh";
        }
        return page;
    }

    /**
     * 返回accept页面
     *
     * @param projectType 。
     * @return 。
     */
    private String backPageJgzxYs(SysCodeDetail projectType) {
        String page = "view/sg/sgPermit/jgzxYs";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh_sd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_SD);//市政基础设施
        SysCodeDetail szjcsh_gd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GD);//市政基础设施
        SysCodeDetail szjcsh_gjcz = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GJCZ);//市政基础设施
        SysCodeDetail szjcsh_csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_CSDL);//市政基础设施
        if (projectType == gksh) {
            page = "view/sg/sgPermit/jgzxYsGksh";
        } else if (projectType == hd) {
            page = "view/sg/sgPermit/jgzxYsHd";
        } else if (projectType == gl) {
            page = "view/sg/sgPermit/jgzxYsGl";
        } else if (projectType == szjcsh_sd || projectType == szjcsh_gd || projectType == szjcsh_gjcz || projectType == szjcsh_csdl) {
            page = "view/sg/sgPermit/jgzxYsSzjcsh";
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
        String page = "view/sg/sgPermit/accept";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh_sd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_SD);//市政基础设施
        SysCodeDetail szjcsh_gd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GD);//市政基础设施
        SysCodeDetail szjcsh_gjcz = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GJCZ);//市政基础设施
        SysCodeDetail szjcsh_csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_CSDL);//市政基础设施
        if (projectType == gksh) {
            page = "view/sg/sgPermit/acceptGksh";
        } else if (projectType == hd) {
            page = "view/sg/sgPermit/acceptHd";
        } else if (projectType == gl) {
            page = "view/sg/sgPermit/acceptGl";
        } else if (projectType == szjcsh_sd || projectType == szjcsh_gd || projectType == szjcsh_gjcz || projectType == szjcsh_csdl) {
            page = "view/sg/sgPermit/acceptSzjcsh";
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
        String page = "view/sg/sgPermit/audit";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh_sd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_SD);//市政基础设施
        SysCodeDetail szjcsh_gd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GD);//市政基础设施
        SysCodeDetail szjcsh_gjcz = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GJCZ);//市政基础设施
        SysCodeDetail szjcsh_csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_CSDL);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/sg/sgPermit/auditGksh";
            } else if (projectType == hd) {
                page = "view/sg/sgPermit/auditHd";
            } else if (projectType == gl) {
                page = "view/sg/sgPermit/auditGl";
            } else if (projectType == szjcsh_sd || projectType == szjcsh_gd || projectType == szjcsh_gjcz || projectType == szjcsh_csdl) {
                page = "view/sg/sgPermit/auditSzjcsh";
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
        String page = "view/sg/sgPermit/view";
        SysCodeDetail gksh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GKSH);//港口设施
        SysCodeDetail hd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_HD);//航道
        SysCodeDetail gl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_GL);//公路
        SysCodeDetail szjcsh_sd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_SD);//市政基础设施
        SysCodeDetail szjcsh_gd = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GD);//市政基础设施
        SysCodeDetail szjcsh_gjcz = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_GJCZ);//市政基础设施
        SysCodeDetail szjcsh_csdl = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH_CSDL);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/sg/sgPermit/viewGksh";
            } else if (projectType == hd) {
                page = "view/sg/sgPermit/viewHd";
            } else if (projectType == gl) {
                page = "view/sg/sgPermit/viewGl";
            } else if (projectType == szjcsh_sd || projectType == szjcsh_gd || projectType == szjcsh_gjcz || projectType == szjcsh_csdl) {
                page = "view/sg/sgPermit/viewSzjcsh";
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
        SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        String title = "";
        String titleFl = "";
        String code = sgPermit.getProjectType().getCode();
        String bizCode = "";
        if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
            bizCode = "GK";
            title = "上海市(港口)工程施工许可证";
            titleFl = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_GL)) {
            bizCode = "GL";
            title = "上海市(公路)工程施工许可证";
            titleFl = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_SZJCSH_SD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_CSDL) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GJCZ)) {
            bizCode = "SZ";
            title = "上海市(市政基础设施)工程施工许可证";
            titleFl = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        }
        beans.put("title", title);
        beans.put("titleFl", titleFl);
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date date = new Date(System.currentTimeMillis());
        String year = sdf.format(date);
        String sql = "select nvl(max(substr(biz_code,9,3)),0) max from sg_permit where substr(biz_code,5,2)='" + year.substring(0, 2) + "'";
        Integer max = simpleQueryManager.getIntegerBySql(sql);
        beans.put("code", "JT" + sgPermit.getBjbh() + sgPermit.getBdh() + year + bizCode + max);
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
        SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        String title = "";
        String titleFl = "";
        String bizCode = "";
        String code = sgPermit.getProjectType().getCode();
        if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
            bizCode = "GK";
            title = "上海市(港口)工程施工许可证";
            titleFl = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_GL)) {
            bizCode = "GL";
            title = "上海市(公路)工程施工许可证";
            titleFl = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        } else if (code.equals(Constants.PROJECT_TYPE_SZJCSH_SD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GD) || code.equals(Constants.PROJECT_TYPE_SZJCSH_CSDL) || code.equals(Constants.PROJECT_TYPE_SZJCSH_GJCZ)) {
            bizCode = "SZ";
            title = "上海市(市政基础设施)工程施工许可证";
            titleFl = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
        }
        beans.put("title", title);
        beans.put("titleFl", titleFl);
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date date = new Date(System.currentTimeMillis());
        String year = sdf.format(date);
        String sql = "select nvl(max(substr(biz_code,9,3)),0) max from sg_permit where substr(biz_code,5,2)='" + year.substring(0, 2) + "'";
        Integer max = simpleQueryManager.getIntegerBySql(sql);
        beans.put("code", "JT" + sgPermit.getBjbh() + sgPermit.getBdh() + year + bizCode + max);

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
        SgPermit sgPermit = sgPermitService.get(Long.valueOf(id));
        beans.put("bean", sgPermit);
        Set<SgPermitHdExtend> hdExtendSet = sgPermit.getSgPermitHdExtends();
        if (hdExtendSet.size() > 0) {
            SgPermitHdExtend hdExtend = hdExtendSet.iterator().next();
            beans.put("hdExtend", hdExtend);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date date = new Date(System.currentTimeMillis());
        String year = sdf.format(date);
        String sql = "select nvl(max(substr(biz_code,9,3)),0) max from sg_permit where substr(biz_code,5,2)='" + year.substring(0, 2) + "'";
        Integer max = simpleQueryManager.getIntegerBySql(sql);
        beans.put("code", "JT" + sgPermit.getBjbh() + sgPermit.getBdh() + year + "HD" + max);

        excelPrintManager.printExcel(response, request, SgPermit.class.getSimpleName(), xlsTemplateName3, beans, fileName);
    }
}
