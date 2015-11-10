package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.SgPermitStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.util.*;


/**
 * note:施工许可证
 * author: system
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
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SgPermitService sgPermitService;

    @Autowired
    private SgMaterialService sgMaterialService;

    @Autowired
    private SgAuditOpinionService sgAuditOpinionService;

    @Autowired
    private SgPermitOperationService sgPermitOperationService;

    public static String hdMaterialNames[] = {"航道建设项目项目开工备案表", "主体工程施工图设计审批文件", "项目已列入年度投资计划或建设资金落实的证明", "主体工程各合同段施工单位和监理单位资质证书", "主体工程各合同段施工单位和监理单位合同", "施工、监理单位中标通知书", "主体工程安全质量报监证明材料", "建设项目用地规划许可证", "动迁基本完成情况证明", "其他证明资料"};
    public static String glMaterialNames[] = {"公路建设项目项目施工许可表", "国土资源部门关于征地的批复或者控制性用地的批复", "施工图设计文件批复", "建设资金证明", "施工、监理招标中标通知书", "建设工程施工、监理承发包合同、廉政协议和安全文明施工合同", "交通建设工程安全质量报监受理证明", "提供项目场地内完成动迁的证明材料", "其他证明材料"};
    public static String gkMaterialNames[] = {"港口设施建设项目项目施工许可表", "申请人情况及相关证明材料（如营业执照等）", "港口设施建设项目的规划审核意见", "施工、监理的中标通知书", "建设工程各合同段的施工单位和监理单位合同副本、廉洁协议", "施工图审查意见", "建设工程安全质量报监办结单", "建设资金", "提供施工场地已经具备施工条件证明材料", "其他证明资料"};


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
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
            String hql = "from SgPermit order by id desc";
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
        getMaterials(sgPermit, model, "edit");//处理申请材料数据
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
    public String modify(Model model, Long id) {
        SgPermit sgPermit = sgPermitService.get(id);
        model.addAttribute("bean", sgPermit);
        getMaterials(sgPermit, model, "edit");//处理申请材料数据
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
        getMaterials(sgPermit, model, "view");//处理申请材料数据
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

        return "view/sg/sgPermit/view";
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
                        "projectType"
                });
            } else {
                target = entity;
            }
            sgPermitService.save(target);
            //保存信息之前先删除材料申请信息
            Set<SgMaterial> sgMaterials = target.getSgMaterials();
            for (SgMaterial material : sgMaterials) {
                sgMaterialService.delete(material);
            }
            //保存材料信息
            String[] nos = request.getParameterValues("no");//序号
            if (null != nos && nos.length > 0) {
                for (String no : nos) {
                    System.out.println("no = " + no);
                    SgMaterial sgMaterial = new SgMaterial();
                    sgMaterial.setSgPermit(target);
                    sgMaterial.setNo(Long.valueOf(no));
                    //材料是否齐全
                    String isFull = request.getParameter("isFull" + no);
                    if (!StringHelper.isEmpty(isFull)) {
                        if ("1".equals(isFull)) {
                            sgMaterial.setIsFull(true);
                        } else {
                            sgMaterial.setIsFull(false);
                        }
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
                    sgMaterialService.save(sgMaterial);
                }
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
                        "csOpinion",
                        "fhOpinion",
                        "shOpinion",
                        "fgldOpinion",
                        "zxldOpinion"
                });
            } else {
                target = entity;
            }
            sgPermitService.save(target);


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
        Set<SgAuditOpinion> sgAuditOpinions = sgPermit.getSgAuditOpinions();
        for (SgAuditOpinion opinion : sgAuditOpinions) {
            sgAuditOpinionService.delete(opinion);
        }
        //删除材料申请
        Set<SgMaterial> sgMaterials = sgPermit.getSgMaterials();
        for (SgMaterial material : sgMaterials) {
            DocDocument doc = material.getDoc();
            if (null != doc) {
                documentManager.removeAllDoc(doc.getId(), null);
            }
            sgMaterialService.delete(material);
        }
        //删除操作记录
        Set<SgPermitOperation> sgPermitOperations = sgPermit.getSgPermitOperations();
        for (SgPermitOperation operation : sgPermitOperations) {
            sgPermitOperationService.delete(operation);
        }
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
    }

    /**
     * 获取申请材料数据
     *
     * @param sgPermit 。
     * @param model    。
     */
    private void getMaterials(SgPermit sgPermit, Model model, String flag) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String names[] = {};
        int num = 11;
        String code = sgPermit.getProjectType().getCode();
        if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
            names = gkMaterialNames;
        } else if (code.endsWith(Constants.PROJECT_TYPE_GL)) {
            names = glMaterialNames;
            num = 10;
        } else if (code.equals(Constants.PROJECT_TYPE_HD)) {
            names = hdMaterialNames;
        }
        Set<SgMaterial> sgMaterials = sgPermit.getSgMaterials();
        if (null != sgMaterials && sgMaterials.size() > 0) {
            for (SgMaterial material : sgMaterials) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("no", material.getNo());
                map.put("materialName", names[JspHelper.getInteger(material.getNo()) - 1]);
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
            for (int i = 1; i < num; i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("no", i);
                map.put("materialName", names[i - 1]);
                map.put("isFull", "");
                map.put("num", "");
                map.put("upLoad" + i, documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), SgMaterial.class.getSimpleName(), null, null, null, String.valueOf(i)));
                list.add(map);
            }
        }
        model.addAttribute("list", list);
    }
}