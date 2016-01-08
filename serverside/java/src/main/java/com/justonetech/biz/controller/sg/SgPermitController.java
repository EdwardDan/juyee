package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.SgPermitNotAcceptMat;
import com.justonetech.biz.utils.enums.SgPermitStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
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
import java.sql.Date;
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
    private SgMaterialInfoService sgMaterialInfoService;

    @Autowired
    private SgContractProjPersonService sgContractProjPersonService;

    @Autowired
    private SgUnitProjService sgUnitProjService;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        SysUser sysUser = sysUserManager.getSysUser();
        SysRegPerson regPerson = sysUser.getRegPerson();
        model.addAttribute("isReg", null != regPerson);
        doPrivilegeCodeAndStatus(model);//编码和状态

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
            String hql = "from SgPermit where 1=1";
            if (null != sysUser.getRegPerson()) {
                hql += " and createUser='" + sysUser.getLoginName() + "'";
            }
            hql += " order by id desc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = sgPermitService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
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
    public String frame(Model model, String id, String act, String projectTypeId) {
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

        return "view/sg/sgPermit/frame";
    }

//    /**
//     * 新增录入页面
//     *
//     * @param model .
//     * @return .
//     */
//    @RequestMapping
//    public String add(Model model, String projectTypeId) {
//        SgPermit sgPermit = new SgPermit();
//        if (!StringHelper.isEmpty(projectTypeId)) {
//            SysCodeDetail projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
//            sgPermit.setProjectType(projectType);
//        }
//        Calendar calendar = Calendar.getInstance();
//        sgPermit.setYear(calendar.get(Calendar.YEAR));
//        sgPermit.setStatus(SgPermitStatus.STATUS_EDIT.getCode());
//        model.addAttribute("bean", sgPermit);
//        List<Map<String, Object>> applyList = getMaterials(sgPermit, "edit", "apply");//处理申请材料数据
//        model.addAttribute("applyList", applyList);
//        doPrivilegeCodeAndStatus(model);//编码和状态
//
//        return "view/sg/sgPermit/input";
//    }

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
        SysCodeDetail projectType = null;
        if (!StringHelper.isEmpty(projectTypeId)) {
            projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            sgPermit.setProjectType(projectType);
        }
        if (!StringHelper.isEmpty(id)) {
            sgPermit = sgPermitService.get(Long.valueOf(id));
        } else {
            Calendar calendar = Calendar.getInstance();
            sgPermit.setYear(calendar.get(Calendar.YEAR));
            sgPermit.setStatus(SgPermitStatus.STATUS_EDIT.getCode());
        }
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "edit", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        doPrivilegeCodeAndStatus(model);//编码和状态

        return backPageInput(projectType);
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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "edit", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        doPrivilegeCodeAndStatus(model);//编码和状态

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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        doPrivilegeCodeAndStatus(model);

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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "view", "submit");//处理申请材料数据
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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);

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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "view", "submit");//处理申请材料数据
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
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "view", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        List<Map<String, Object>> submitList = getMaterials(sgPermit, "view", "submit");//处理申请材料数据
        model.addAttribute("submitList", submitList);
        doPrivilegeCodeAndStatus(model);

        return "view/sg/sgPermit/printView3";
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
                        "contractEndDate"
                });
            } else {
                target = entity;
            }
            Integer status = target.getStatus();
            if (status == SgPermitStatus.STATUS_SUBMIT.getCode()) {
                target.setSubmitDate(new Date(System.currentTimeMillis()));
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
//                    //材料是否齐全
//                    String isFull = request.getParameter("isFull" + no);
//                    if (!StringHelper.isEmpty(isFull) && Constants.FLAG_TRUE.equals(isFull)) {
//                        sgMaterial.setIsFull(true);
//                    } else if (!StringHelper.isEmpty(isFull) && Constants.FLAG_FALSE.equals(isFull)) {
//                        sgMaterial.setIsFull(false);
//                    }
//                    //份数
//                    String num = request.getParameter("num" + no);
//                    if (!StringHelper.isEmpty(num)) {
//                        sgMaterial.setNum(Long.valueOf(num));
//                    } else {
//                        sgMaterial.setNum(null);
//                    }
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

            if (status == SgPermitStatus.STATUS_SUBMIT.getCode()) {
                SgPermitOperation operation = new SgPermitOperation();
                operation.setSgPermit(target);
                operation.setOptionCode(SgPermitStatus.STATUS_SUBMIT.getStepCode());
                operation.setOptionName(SgPermitStatus.STATUS_SUBMIT.getName());
                operation.setOptionUser(sysUserManager.getSysUser().getDisplayName());
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
                        "wldOpinion",
                        "backNum"
                });
            } else {
                target = entity;
            }

            sgPermitService.save(target);
            Integer status = target.getStatus();
            SysUser sysUser = sysUserManager.getSysUser();
            Date date = new Date(System.currentTimeMillis());
            if (status == SgPermitStatus.STATUS_CS_PASS.getCode()) { //初审
                target.setCsUser(sysUser.getDisplayName());
                target.setCsDate(date);
            } else if (status == SgPermitStatus.STATUS_FH_PASS.getCode()) { //复审
                target.setFhUser(sysUser.getDisplayName());
                target.setFhDate(date);
            } else if (status == SgPermitStatus.STATUS_SH_PASS.getCode()) { //审核
                target.setShUser(sysUser.getDisplayName());
                target.setShDate(date);
            } else if (status == SgPermitStatus.STATUS_FGLD_PASS.getCode()) { //分管领导审核
                target.setFgldUser(sysUser.getDisplayName());
                target.setFgldDate(date);
            } else if (status == SgPermitStatus.STATUS_ZXLD_PASS.getCode()) { //中心领导审核
                target.setZxldUser(sysUser.getDisplayName());
                target.setZxldDate(date);
            } else if (status == SgPermitStatus.STATUS_WLD_PASS.getCode()) { //委领导审核
                target.setWldUser(sysUser.getDisplayName());
                target.setWldDate(date);
            }
            sgPermitService.save(target);
            //保存审核信息
            List<SgAuditOpinion> saveList = new ArrayList<SgAuditOpinion>();
            List<SgAuditOpinion> list = sgAuditOpinionService.findByProperty("sgPermit.id", target.getId());
            if (null != list && list.size() > 0) {
                for (SgAuditOpinion opinion : list) {
                    Long no = opinion.getNo()-1;
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
        sgPermitService.delete(sgPermit);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 权限编码
     *
     * @param model 。
     */
    private void doPrivilegeCodeAndStatus(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_EDIT));//编辑
        model.addAttribute("canCsAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_CS_AUDIT));//初审
        model.addAttribute("canFhAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_FH_AUDIT));//复核
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_AUDIT));//审核
        model.addAttribute("canFgldAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_FGLD_AUDIT));//分管领导审核
        model.addAttribute("canZxldAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_ZXLD_AUDIT));//中心领导审核
        model.addAttribute("canWldAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_WLD_AUDIT));//委领导审核

        model.addAttribute("STATUS_EDIT", SgPermitStatus.STATUS_EDIT.getCode());//未提交
        model.addAttribute("STATUS_SUBMIT", SgPermitStatus.STATUS_SUBMIT.getCode());//已提交
        model.addAttribute("STATUS_CS_PASS", SgPermitStatus.STATUS_CS_PASS.getCode());//初审通过
        model.addAttribute("STATUS_CS_BACK", SgPermitStatus.STATUS_CS_BACK.getCode());//初审退回
        model.addAttribute("STATUS_FH_PASS", SgPermitStatus.STATUS_FH_PASS.getCode());//复核通过
        model.addAttribute("STATUS_FH_BACK", SgPermitStatus.STATUS_FH_BACK.getCode());//复核退回
        model.addAttribute("STATUS_SH_PASS", SgPermitStatus.STATUS_SH_PASS.getCode());//审核通过
        model.addAttribute("STATUS_SH_BACK", SgPermitStatus.STATUS_SH_BACK.getCode());//审核退回
        model.addAttribute("STATUS_FGLD_PASS", SgPermitStatus.STATUS_FGLD_PASS.getCode());//分管领导审核通过
        model.addAttribute("STATUS_FGLD_BACK", SgPermitStatus.STATUS_FGLD_BACK.getCode());//分管领导审核退回
        model.addAttribute("STATUS_ZXLD_PASS", SgPermitStatus.STATUS_ZXLD_PASS.getCode());//中心领导审核通过
        model.addAttribute("STATUS_ZXLD_BACK", SgPermitStatus.STATUS_ZXLD_BACK.getCode());//中心领导审核退回
        model.addAttribute("STATUS_WLD_PASS", SgPermitStatus.STATUS_WLD_PASS.getCode());//委领导审核通过
        model.addAttribute("STATUS_WLD_BACK", SgPermitStatus.STATUS_WLD_BACK.getCode());//委领导审核退回

        //退回材料枚举类
        SgPermitNotAcceptMat[] mats = SgPermitNotAcceptMat.values();
        List<SgPermitNotAcceptMat> matList = new ArrayList<SgPermitNotAcceptMat>();
        for (SgPermitNotAcceptMat mat : mats) {
            matList.add(mat);
        }
        model.addAttribute("matList", matList);

        List<SysCodeDetail> lbs = sysCodeManager.getCodeListByCode(Constants.JSGCLB);
        List<SysCodeDetail> sxs = sysCodeManager.getCodeListByCode(Constants.JSGCSX);
        model.addAttribute("lbs", lbs);
        model.addAttribute("sxs", sxs);

    }

    /**
     * 获取申请材料数据
     *
     * @param sgPermit 。
     */
    private List<Map<String, Object>> getMaterials(SgPermit sgPermit, String flag, String type) {
        String hql = "from SgMaterialInfo where parent is not null and projectType.id=" + sgPermit.getProjectType().getId() + " and type='" + type + "' order by no asc";
        List<SgMaterialInfo> infoList = sgMaterialInfoService.findByQuery(hql);
        String materialInfo = "";
        String yjNum = "";
        String[] materialInfos = {};
        String[] yjNums = {};
        for (SgMaterialInfo info : infoList) {
            materialInfo += "," + info.getMaterialName();
            yjNum += "," + JspHelper.getString(info.getYjNum()) + " ";
        }
        if (!StringHelper.isEmpty(materialInfo)) {
            materialInfo = materialInfo.substring(1);
            materialInfos = materialInfo.split(",");
            yjNum = yjNum.substring(1);
            yjNums = yjNum.split(",");
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int num = infoList.size();
        if ("apply".equals(type)) {
            Set<SgMaterial> sgMaterials = sgPermit.getSgMaterials();
            if (null != sgMaterials && sgMaterials.size() > 0) {
                for (SgMaterial material : sgMaterials) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", material.getNo());
                    map.put("materialName", materialInfos[JspHelper.getInteger(material.getNo()) - 1]);
//                    map.put("isFull", material.getIsFull());
//                    map.put("num", material.getNum());
                    map.put("yjNum", JspHelper.getLong(yjNums[JspHelper.getInteger(material.getNo()) - 1].trim()));
                    map.put("sjNum", material.getSjNum());
                    if ("view".equals(flag)) {
                        map.put("upLoad" + material.getNo(), documentManager.getDownloadButton(material.getDoc()));
                    } else {
                        map.put("upLoad" + material.getNo(), documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SgMaterial.class.getSimpleName(), material.getDoc(), null, null, String.valueOf(material.getNo())));
                    }
                    list.add(map);
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", i);
                    map.put("materialName", materialInfos[i - 1]);
//                    map.put("isFull", "");
//                    map.put("num", "");
                    map.put("yjNum", JspHelper.getLong(yjNums[i - 1].trim()));
                    map.put("sjNum", "");
                    map.put("upLoad" + i, documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SgMaterial.class.getSimpleName(), null, null, null, String.valueOf(i)));
                    list.add(map);
                }
            }
        } else if ("submit".equals(type)) {
            String auditReq = "";
            String[] auditReqs = {};
            for (SgMaterialInfo info : infoList) {
                auditReq += "," + info.getAuditReq();
            }
            if (!StringHelper.isEmpty(auditReq)) {
                auditReq = auditReq.substring(1);
                auditReqs = auditReq.split(",");
            }
            Set<SgAuditOpinion> sgAuditOpinions = sgPermit.getSgAuditOpinions();
            if (null != sgAuditOpinions && sgAuditOpinions.size() > 0) {
                for (SgAuditOpinion opinion : sgAuditOpinions) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", opinion.getNo());
                    map.put("materialName", materialInfos[JspHelper.getInteger(opinion.getNo()) - 1]);
                    String req = auditReqs[JspHelper.getInteger(opinion.getNo()) - 1];
                    map.put("auditReq", (!"null".equals(req) && !StringHelper.isEmpty(req)) ? req : "");
                    map.put("isCsOpinion", opinion.getIsCsOpinion());
                    map.put("isFhOpinion", opinion.getIsFhOpinion());
                    map.put("isShOpinion", opinion.getIsShOpinion());
                    list.add(map);
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", i);
                    map.put("materialName", materialInfos[i - 1]);
                    String req = auditReqs[i - 1];
                    map.put("auditReq", (!"null".equals(req) && !StringHelper.isEmpty(req)) ? req : "");
                    map.put("isCsOpinion", true);
                    map.put("isFhOpinion", true);
                    map.put("isShOpinion", true);
                    list.add(map);
                }
            }
        }
        return list;
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
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(SgPermit data) throws Exception {
        int status = data.getStatus();
        String simpleName = SgPermit.class.getSimpleName();
        //创建任务
        String title = "";
        Set<Long> managers = new HashSet<Long>();
        if (status == SgPermitStatus.STATUS_SUBMIT.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_ch_pass");
            //获取有初审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_CS_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_ch_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_CS_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_fh_pass");
            //获取有复审权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_FH_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_fh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_FH_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_sh_pass");
            //获取有审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_sh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_SH_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_fgldsh_pass");
            //获取有审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_FGLD_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_fgldsh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_FGLD_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_fgldsh_pass");
            //获取有审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_ZXLD_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_fgldsh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_ZXLD_PASS.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_wldsh_pass");
            //获取有审核权限的用户
            Set<Long> audit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_WLD_AUDIT);
            managers.addAll(audit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_wldsh_pass", data.getId(), title, managers, false, null, null);
            }
        } else if (status == SgPermitStatus.STATUS_EDIT.getCode() || status == SgPermitStatus.STATUS_CS_BACK.getCode() || status == SgPermitStatus.STATUS_FH_BACK.getCode() || status == SgPermitStatus.STATUS_SH_BACK.getCode() || status == SgPermitStatus.STATUS_FGLD_BACK.getCode() || status == SgPermitStatus.STATUS_ZXLD_BACK.getCode() || status == SgPermitStatus.STATUS_WLD_BACK.getCode()) {
            title = oaTaskManager.getTaskTitle(data, simpleName + "_back");
            //获取有编辑权限的用户
            Set<Long> edit = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.SG_PERMIT_EDIT);
            managers.addAll(edit);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_back", data.getId(), title, managers, false, null, null);
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
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (projectType == gksh) {
            page = "view/sg/sgPermit/inputGksh";
        } else if (projectType == hd) {
            page = "view/sg/sgPermit/inputHd";
        } else if (projectType == gl) {
            page = "view/sg/sgPermit/inputGl";
        } else if (projectType == szjcsh) {
            page = "view/sg/sgPermit/inputSzjcsh";
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
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/sg/sgPermit/auditGksh";
            } else if (projectType == hd) {
                page = "view/sg/sgPermit/auditHd";
            } else if (projectType == gl) {
                page = "view/sg/sgPermit/auditGl";
            } else if (projectType == szjcsh) {
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
        SysCodeDetail szjcsh = sysCodeManager.getCodeDetailByCode(Constants.PROJECT_TYPE, Constants.PROJECT_TYPE_SZJCSH);//市政基础设施
        if (null != projectType) {
            if (projectType == gksh) {
                page = "view/sg/sgPermit/viewGksh";
            } else if (projectType == hd) {
                page = "view/sg/sgPermit/viewHd";
            } else if (projectType == gl) {
                page = "view/sg/sgPermit/viewGl";
            } else if (projectType == szjcsh) {
                page = "view/sg/sgPermit/viewSzjcsh";
            }
        }

        return page;
    }
}
