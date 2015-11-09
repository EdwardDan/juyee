package com.justonetech.biz.controller.sg;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.SgPermitService;
import com.justonetech.biz.domain.SgMaterial;
import com.justonetech.biz.domain.SgPermit;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
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
        doPrivilegeCode(model);

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
            //增加自定义查询条件

            //执行查询
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
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            String names[] = {};
            int num = 11;
            String code = projectType.getCode();
            if (code.equals(Constants.PROJECT_TYPE_GKSH)) {
                names = gkMaterialNames;
            } else if (code.endsWith(Constants.PROJECT_TYPE_GL)) {
                names = glMaterialNames;
                num = 10;
            } else if (code.equals(Constants.PROJECT_TYPE_HD)) {
                names = hdMaterialNames;
            }
            for (int i = 1; i < num; i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("no", i);
                map.put("materialName", names[i - 1]);
                map.put("isFull", "");
                map.put("num", "");
                map.put("upLoad", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), SgMaterial.class.getSimpleName(), null, null, null));
                list.add(map);
            }
            model.addAttribute("list", list);
        }
        Calendar calendar = Calendar.getInstance();
        sgPermit.setYear(calendar.get(Calendar.YEAR));

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", sgPermit);


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

        //处理其他业务逻辑
        model.addAttribute("bean", sgPermit);

        return "view/sg/sgPermit/input";
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
                        "hYear",
                        "hNum",
                        "applyPerson",
                        "applyMatter",
                        "applyNum",
                        "materialPerson",
                        "materialPersonPhone",
                        "materialPersonAddress",
                        "receivePerson",
                        "receivePersonPhone",
                        "status",
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
        sendSuccessJSON(response, "保存成功");
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
        sgPermitService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 权限编码
     *
     * @param model 。
     */
    private void doPrivilegeCode(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_EDIT));
        model.addAttribute("canCsAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_CS_AUDIT));
        model.addAttribute("canFhAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_FH_AUDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_AUDIT));
        model.addAttribute("canFgldAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_FGLD_AUDIT));
        model.addAttribute("canZxldAudit", sysUserManager.hasPrivilege(PrivilegeCode.SG_PERMIT_ZXLD_AUDIT));
    }

}