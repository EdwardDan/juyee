package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
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

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String projectTypeId) {
        SgPermit sgPermit = new SgPermit();
        if (!StringHelper.isEmpty(projectTypeId)) {
            SysCodeDetail projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
            sgPermit.setProjectType(projectType);
        }
        Calendar calendar = Calendar.getInstance();
        sgPermit.setYear(calendar.get(Calendar.YEAR));
        sgPermit.setStatus(SgPermitStatus.STATUS_EDIT.getCode());
        model.addAttribute("bean", sgPermit);
        List<Map<String, Object>> applyList = getMaterials(sgPermit, "edit", "apply");//处理申请材料数据
        model.addAttribute("applyList", applyList);
        doPrivilegeCodeAndStatus(model);//编码和状态

        return "view/sg/sgPermit/input";
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
        if (!StringHelper.isEmpty(projectTypeId)) {
            SysCodeDetail projectType = sysCodeManager.getCodeListById(Long.valueOf(projectTypeId));
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

        return "view/sg/sgPermit/input";
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

        return "view/sg/sgPermit/audit";
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

        return "view/sg/sgPermit/view";
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
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") SgPermit entity, HttpServletRequest request, Model model, String act) throws Exception {
        String id = "";
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
                        "status"
                });
            } else {
                target = entity;
            }
            sgPermitService.save(target);
            id = String.valueOf(target.getId());
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
                    //材料是否齐全
                    String isFull = request.getParameter("isFull" + no);
                    if (!StringHelper.isEmpty(isFull) && Constants.FLAG_TRUE.equals(isFull)) {
                        sgMaterial.setIsFull(true);
                    } else if (!StringHelper.isEmpty(isFull) && Constants.FLAG_FALSE.equals(isFull)) {
                        sgMaterial.setIsFull(false);
                    }
                    //份数
                    String num = request.getParameter("num" + no);
                    if (!StringHelper.isEmpty(num)) {
                        sgMaterial.setNum(Long.valueOf(num));
                    } else {
                        sgMaterial.setNum(null);
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
            Integer status = target.getStatus();
            if (status == SgPermitStatus.STATUS_SUBMIT.getCode()) {
                SgPermitOperation operation = new SgPermitOperation();
                operation.setSgPermit(target);
                operation.setOptionCode(SgPermitStatus.STATUS_SUBMIT.getStepCode());
                operation.setOptionName(SgPermitStatus.STATUS_SUBMIT.getName());
                operation.setOptionUser(sysUserManager.getSysUser().getDisplayName());
                operation.setStatus(status);
                sgPermitOperationService.save(operation);
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
                        "wldOpinion"
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
                    if (status == SgPermitStatus.STATUS_FH_PASS.getCode()) {
                        String fhOpnion = request.getParameter("fhOpnion" + opinion.getNo());
                        if (!StringHelper.isEmpty(fhOpnion) && Constants.FLAG_TRUE.equals(fhOpnion)) {
                            opinion.setIsFhOpinion(true);
                        } else if (!StringHelper.isEmpty(fhOpnion) && Constants.FLAG_FALSE.equals(fhOpnion)) {
                            opinion.setIsFhOpinion(false);
                        }
                    }
                    if (status == SgPermitStatus.STATUS_SH_PASS.getCode()) {
                        String shOpnion = request.getParameter("shOpnion" + opinion.getNo());
                        if (!StringHelper.isEmpty(shOpnion) && Constants.FLAG_TRUE.equals(shOpnion)) {
                            opinion.setIsShOpinion(true);
                        } else if (!StringHelper.isEmpty(shOpnion) && Constants.FLAG_FALSE.equals(shOpnion)) {
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
                        String csOpnion = request.getParameter("csOpnion" + no);
                        if (!StringHelper.isEmpty(csOpnion) && Constants.FLAG_TRUE.equals(csOpnion)) {
                            opinion.setIsCsOpinion(true);
                        } else if (!StringHelper.isEmpty(csOpnion) && Constants.FLAG_FALSE.equals(csOpnion)) {
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
    }

    /**
     * 获取申请材料数据
     *
     * @param sgPermit 。
     */
    private List<Map<String, Object>> getMaterials(SgPermit sgPermit, String flag, String type) {
        String hql = "from SgMaterialInfo where parent is not null and projectType.id=" + sgPermit.getProjectType().getId() + " and type='" + type + "' order by treeId asc";
        List<SgMaterialInfo> infoList = sgMaterialInfoService.findByQuery(hql);
        String materialInfo = "";
        String[] materialInfos = {};
        for (SgMaterialInfo info : infoList) {
            materialInfo += "," + info.getMaterialName();
        }
        if (!StringHelper.isEmpty(materialInfo)) {
            materialInfo = materialInfo.substring(1);
            materialInfos = materialInfo.split(",");
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
                    map.put("isFull", material.getIsFull());
                    map.put("num", material.getNum());
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
                    map.put("isFull", "");
                    map.put("num", "");
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
                    map.put("csOpinion", opinion.getIsCsOpinion());
                    map.put("fhOpinion", opinion.getIsFhOpinion());
                    map.put("shOpinion", opinion.getIsShOpinion());
                    list.add(map);
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", i);
                    map.put("materialName", materialInfos[i - 1]);
                    String req = auditReqs[i - 1];
                    map.put("auditReq", (!"null".equals(req) && !StringHelper.isEmpty(req)) ? req : "");
                    map.put("csOpinion", true);
                    map.put("fhOpinion", true);
                    map.put("shOpinion", true);
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
}