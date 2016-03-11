package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.AreaMaterialInfoService;
import com.justonetech.biz.daoservice.AreaPermitHdExtendService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.AreaSgPermitStatus;
import com.justonetech.biz.utils.enums.SgPermitNotAcceptMat;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 区县施工许可复杂逻辑处理类
 */
@Service
public class AreaSgPermitManager {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private AreaMaterialInfoService areaMaterialInfoService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private AreaPermitHdExtendService areaPermitHdExtendService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;


    /**
     * 自动生成业务编码
     *
     * @param type     。
     * @param unitCode 。
     * @return 。
     */
    public String getBizCode(String type, String unitCode) {
        String bizCode = unitCode;
        String code = type.substring(0, 2).toUpperCase();
        bizCode += code;
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Date date = new Date(System.currentTimeMillis());
        String yearMonth = sdf.format(date);
        bizCode += yearMonth;
        String sql = "select nvl(max(substr(biz_code,9,3)),0)+1 max from area_sg_permit where substr(biz_code,5,2)='" + yearMonth.substring(0, 2) + "'";
        Integer max = simpleQueryManager.getIntegerBySql(sql);
        bizCode += StringHelper.leftPad(String.valueOf(max), 3, "0");

        return bizCode;
    }

    /**
     * 权限编码
     *
     * @param model 。
     */
    public void doPrivilegeCodeAndStatus(Model model) {
        SysUser sysUser = sysUserManager.getSysUser();
        SysRegPerson regPerson = sysUser.getRegPerson();
        model.addAttribute("isReg", null != regPerson);

        List<SysCodeDetail> areaList = sysCodeManager.getCodeListByCode(Constants.PROJ_INFO_BELONG_AREA);
        model.addAttribute("areaList", areaList);

        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.AREA_PERMIT_EDIT));//编辑
        model.addAttribute("canCsAudit", sysUserManager.hasPrivilege(PrivilegeCode.AREA_PERMIT_CS_AUDIT));//初审
        model.addAttribute("canSlAudit", sysUserManager.hasPrivilege(PrivilegeCode.AREA_PERMIT_SL_AUDIT));//初审
        model.addAttribute("canFhAudit", sysUserManager.hasPrivilege(PrivilegeCode.AREA_PERMIT_FH_AUDIT));//复核
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.AREA_PERMIT_AUDIT));//审核

        model.addAttribute("STATUS_EDIT", AreaSgPermitStatus.STATUS_EDIT.getCode());//未提交
        model.addAttribute("STATUS_SUBMIT", AreaSgPermitStatus.STATUS_SUBMIT.getCode());//已提交
        model.addAttribute("STATUS_SLZX_PASS", AreaSgPermitStatus.STATUS_SLZX_PASS.getCode());//受理中心初审通过
        model.addAttribute("STATUS_SLZX_BACK", AreaSgPermitStatus.STATUS_SLZX_BACK.getCode());//受理中心初审退回
        model.addAttribute("STATUS_CS_PASS", AreaSgPermitStatus.STATUS_CS_PASS.getCode());//建管中心初审通过
        model.addAttribute("STATUS_CS_BACK", AreaSgPermitStatus.STATUS_CS_BACK.getCode());//建管中心初审退回
        model.addAttribute("STATUS_FH_PASS", AreaSgPermitStatus.STATUS_FH_PASS.getCode());//建管中心复核通过
        model.addAttribute("STATUS_FH_BACK", AreaSgPermitStatus.STATUS_FH_BACK.getCode());//建管中心复核退回
        model.addAttribute("STATUS_SH_PASS", AreaSgPermitStatus.STATUS_SH_PASS.getCode());//建管中心审核通过
        model.addAttribute("STATUS_SH_BACK", AreaSgPermitStatus.STATUS_SH_BACK.getCode());//建管中心审核退回

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
        //项目性质
        model.addAttribute("xmxz", Constants.PROJECT_PROPERTY);
    }

    /**
     * 获取申请材料数据
     *
     * @param sgPermit 。
     */
    public List<Map<String, Object>> getMaterials(AreaSgPermit sgPermit, String flag, String type) {
        String hql = "from AreaMaterialInfo where parent is not null and projectType.id=" + sgPermit.getProjectType().getId() + " and type='" + type + "' order by no asc";
        List<AreaMaterialInfo> infoList = areaMaterialInfoService.findByQuery(hql);
        String materialInfo = "";
        String yjNum = "";
        String[] materialInfos = {};
        String[] yjNums = {};
        for (AreaMaterialInfo info : infoList) {
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
            Set<AreaSgMaterial> sgMaterials = sgPermit.getAreaSgMaterials();
            if (null != sgMaterials && sgMaterials.size() > 0) {
                for (AreaSgMaterial material : sgMaterials) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", material.getNo());
                    map.put("materialName", materialInfos[JspHelper.getInteger(material.getNo()) - 1]);
                    map.put("yjNum", JspHelper.getLong(yjNums[JspHelper.getInteger(material.getNo()) - 1].trim()));
                    map.put("sjNum", material.getSjNum());
                    if ("view".equals(flag)) {
                        map.put("upLoad" + material.getNo(), documentManager.getDownloadButton(material.getDoc()));
                        map.put("docId" + material.getNo(), null != material.getDoc() ? material.getDoc().getId() : "");
                    } else {
                        map.put("upLoad" + material.getNo(), documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), AreaSgMaterial.class.getSimpleName(), material.getDoc(), null, null, String.valueOf(material.getNo())));
                    }
                    list.add(map);
                }
            } else {
                for (int i = 1; i <= num; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", i);
                    map.put("materialName", materialInfos[i - 1]);
                    map.put("yjNum", JspHelper.getLong(yjNums[i - 1].trim()));
                    map.put("sjNum", "");
                    map.put("upLoad" + i, documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), AreaSgMaterial.class.getSimpleName(), null, null, null, String.valueOf(i)));
                    list.add(map);
                }
            }
        } else if ("submit".equals(type)) {
            String auditReq = "";
            String auditReqGreen = "";
            String[] auditReqs = {};
            String[] auditReqGreens = {};
            for (AreaMaterialInfo info : infoList) {
                auditReq += "," + info.getAuditReq();
                auditReqGreen += "," + info.getAuditReqGreen();
            }
            if (!StringHelper.isEmpty(auditReq)) {
                auditReq = auditReq.substring(1);
                auditReqs = auditReq.split(",");
                auditReqGreen = auditReqGreen.substring(1);
                auditReqGreens = auditReqGreen.split(",");
            }
            Set<AreaAuditOpinion> sgAuditOpinions = sgPermit.getAreaAuditOpinions();
            if (null != sgAuditOpinions && sgAuditOpinions.size() > 0) {
                for (AreaAuditOpinion opinion : sgAuditOpinions) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("no", opinion.getNo());
                    map.put("materialName", materialInfos[JspHelper.getInteger(opinion.getNo()) - 1]);
                    String req = auditReqs[JspHelper.getInteger(opinion.getNo()) - 1];
                    String reqGreen = auditReqGreens[JspHelper.getInteger(opinion.getNo()) - 1];
                    map.put("auditReq", (!"null".equals(req) && !StringHelper.isEmpty(req)) ? req : "");
                    map.put("auditReqGreen", (!"null".equals(reqGreen) && !StringHelper.isEmpty(reqGreen)) ? reqGreen : "");
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
                    String reqGreen = auditReqGreens[i - 1];
                    map.put("auditReq", (!"null".equals(req) && !StringHelper.isEmpty(req)) ? req : "");
                    map.put("auditReqGreen", (!"null".equals(reqGreen) && !StringHelper.isEmpty(reqGreen)) ? reqGreen : "");
                    map.put("isCsOpinion", true);
                    map.put("isFhOpinion", true);
                    map.put("isShOpinion", true);
                    list.add(map);
                }
            }
        }
        return list;
    }

    public void saveHdExtend(HttpServletRequest request, AreaSgPermit sgPermit) {
        String mainSjZbfs = request.getParameter("mainSjZbfs");
        String mainSjZbj = request.getParameter("mainSjZbj");
        String mainSjZzdj = request.getParameter("mainSjZzdj");
        String mainSjXmfzr = request.getParameter("mainSjXmfzr");
        String mainSjZsbh = request.getParameter("mainSjZsbh");
        String mainSjZsbh2 = request.getParameter("mainSjZsbh2");
        String mainJlZbfs = request.getParameter("mainJlZbfs");
        String mainJlZbj = request.getParameter("mainJlZbj");
        String mainJlZzdj = request.getParameter("mainJlZzdj");
        String mainJlXmfzr = request.getParameter("mainJlXmfzr");
        String mainJlZsbh = request.getParameter("mainJlZsbh");
        String mainJlZsbh2 = request.getParameter("mainJlZsbh2");
        String mainSgZbfs = request.getParameter("mainSgZbfs");
        String mainSgZbj = request.getParameter("mainSgZbj");
        String mainSgZzdj = request.getParameter("mainSgZzdj");
        String mainSgXmfzr = request.getParameter("mainSgXmfzr");
        String mainSgZsbh = request.getParameter("mainSgZsbh");
        String mainSgZsbh2 = request.getParameter("mainSgZsbh2");
        String gkpzCode = request.getParameter("gkpzCode");
        String hzDate = request.getParameter("hzDate");
        String planCost = request.getParameter("planCost");
        String cbshCode = request.getParameter("cbshCode");
        String pfDate = request.getParameter("pfDate");
        String pfGq = request.getParameter("pfGq");
        String totalGs = request.getParameter("totalGs");
        String pzjgCode = request.getParameter("pzjgCode");
        String costFrom = request.getParameter("costFrom");
        AreaPermitHdExtend hdExtend = new AreaPermitHdExtend();
        hdExtend.setSgPermit(sgPermit);
        hdExtend.setMainSjUnit(sgPermit.getSjUnitName());
        hdExtend.setMainSgUnit(sgPermit.getSgUnitName());
        hdExtend.setMainJlUnit(sgPermit.getJlUnitName());
        hdExtend.setMainSjZbfs(JspHelper.getString(mainSjZbfs));
        hdExtend.setMainSjZbj(JspHelper.getDouble(mainSjZbj));
        hdExtend.setMainSjZzdj(JspHelper.getString(mainSjZzdj));
        hdExtend.setMainSjXmfzr(JspHelper.getString(mainSjXmfzr));
        hdExtend.setMainSjZsbh(JspHelper.getString(mainSjZsbh));
        hdExtend.setMainSjZsbh2(JspHelper.getString(mainSjZsbh2));
        hdExtend.setMainJlZbfs(JspHelper.getString(mainJlZbfs));
        hdExtend.setMainJlZbj(JspHelper.getDouble(mainJlZbj));
        hdExtend.setMainJlZzdj(JspHelper.getString(mainJlZzdj));
        hdExtend.setMainJlXmfzr(JspHelper.getString(mainJlXmfzr));
        hdExtend.setMainJlZsbh(JspHelper.getString(mainJlZsbh));
        hdExtend.setMainJlZsbh2(JspHelper.getString(mainJlZsbh2));
        hdExtend.setMainSgZbfs(JspHelper.getString(mainSgZbfs));
        hdExtend.setMainSgZbj(JspHelper.getDouble(mainSgZbj));
        hdExtend.setMainSgZzdj(JspHelper.getString(mainSgZzdj));
        hdExtend.setMainSgXmfzr(JspHelper.getString(mainSgXmfzr));
        hdExtend.setMainSgZsbh(JspHelper.getString(mainSgZsbh));
        hdExtend.setMainSgZsbh2(JspHelper.getString(mainSgZsbh2));
        hdExtend.setGkpzCode(JspHelper.getString(gkpzCode));
        hdExtend.setHzDate(JspHelper.getDate(hzDate));
        hdExtend.setPlanCost(JspHelper.getDouble(planCost));
        hdExtend.setCbshCode(JspHelper.getString(cbshCode));
        hdExtend.setPfDate(JspHelper.getDate(pfDate));
        hdExtend.setPfGq(JspHelper.getInteger(pfGq));
        hdExtend.setTotalGs(JspHelper.getDouble(totalGs));
        hdExtend.setPzjgCode(JspHelper.getString(pzjgCode));
        hdExtend.setCostFrom(JspHelper.getString(costFrom));
        areaPermitHdExtendService.save(hdExtend);
    }
}
