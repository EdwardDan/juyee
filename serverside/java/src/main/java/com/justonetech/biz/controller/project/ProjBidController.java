package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjBidAreaService;
import com.justonetech.biz.daoservice.ProjBidService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjBid;
import com.justonetech.biz.domain.ProjBidArea;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:项目标段管理(包括办证推进和形象进度2种标段)
 * author: system
 * create date: 2015-05-04
 * modify date: 2015-07-23
 */
@Controller
public class ProjBidController extends BaseCRUDActionController<ProjBid> {
    private Logger logger = LoggerFactory.getLogger(ProjBidController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private ProjBidService projBidService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private ProjBidAreaService projBidAreaService;

    /**
     * projBid 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String typeCode) {
        model.addAttribute("typeCode", typeCode);
        model.addAttribute("typeName", ProjBidType.getNameByCode(typeCode));
        model.addAttribute("TYPE_STAGE", ProjBidType.TYPE_STAGE.getCode());
        model.addAttribute("TYPE_NODE", ProjBidType.TYPE_NODE.getCode());
        return "view/project/projBid/projGrid";
    }

    /**
     * projInfo 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void projGridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, /*String typeCode,*/ HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1 = 1 ";
            //增加项目过滤
            hql += projectRelateManager.getRelateProjectHql("id");
            hql += "order by no asc,id asc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }


    /**
     * projBid 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String bidGrid(Model model, Long projId, String typeCode) {
        //判断是否有编辑权限
        if (ProjBidType.TYPE_STAGE.getCode().equals(typeCode)) {
            model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_BID_STAGE_EDIT));
        } else if (ProjBidType.TYPE_NODE.getCode().equals(typeCode)) {
            model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_BID_NODE_EDIT));
        }
        model.addAttribute("typeCode", typeCode);
        model.addAttribute("TYPE_STAGE", ProjBidType.TYPE_STAGE.getCode());
        model.addAttribute("projId", projId);
        model.addAttribute("projName", projInfoService.get(projId).getName());
        return "view/project/projBid/grid";
    }

    /**
     * projBid获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, Long projId, String typeCode, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjBid where project.id=" + projId;
            //增加自定义查询条件
            if (!StringHelper.isEmpty(typeCode)) {
                hql += " and typeCode='" + typeCode + "'";
            }
            hql += " order by no asc,id asc";
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projBidService.findByPage(pageModel, query);
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
    public String add(Model model, Long projId, String typeCode) {
        String forwardUrl = modify(model, null);
        ProjBid projBid = new ProjBid();
        projBid.setProject(projInfoService.get(projId));
        projBid.setTypeCode(typeCode);
        model.addAttribute("bean", projBid);
        return forwardUrl;
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
        ProjBid projBid = id != null ? projBidService.get(id) : new ProjBid();
        List<String[]> relatedUnits = new ArrayList<String[]>();
        String[] unitContactInfos = new String[]{"建设单位", "jsdw", projBid.getJsdwName(), projBid.getJsdwPerson(), projBid.getJsdwTel(),
                "勘察单位", "kcdw", projBid.getKcdwName(), projBid.getKcdwPerson(), projBid.getKcdwTel(),
                "设计单位", "sjdw", projBid.getSjdwName(), projBid.getSjdwPerson(), projBid.getSjdwTel(),
                "施工单位", "sgdw", projBid.getSgdwName(), projBid.getSgdwPerson(), projBid.getSgdwTel(),
                "监理单位", "jldw", projBid.getJldwName(), projBid.getJldwPerson(), projBid.getJldwTel()
        };
        String[] oneUnitInfo;
        for (int i = 0; i < unitContactInfos.length; i++) {
            if (i % 5 == 0) {
                oneUnitInfo = new String[]{unitContactInfos[i], unitContactInfos[i + 1], unitContactInfos[i + 2], unitContactInfos[i + 3], unitContactInfos[i + 4]};
                relatedUnits.add(oneUnitInfo);
            }
        }
        model.addAttribute("bean", projBid);
        model.addAttribute("areas", projBid.getBelongAreaNames());
        model.addAttribute("relatedUnits", relatedUnits);
        return "view/project/projBid/input";
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
        return modify(model, id).replace("input", "view");
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjBid entity, HttpServletRequest request) throws Exception {
        try {
            ProjBid target;
            if (entity.getId() != null) {
                target = projBidService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "no",
                        "name",
                        "buildMileage",
                        "projLink",
                        "linkTel",
                        "startDate",
                        "typeCode"
                });
            } else {
                target = entity;
            }
            String[] areaIds = request.getParameterValues("ProjBelongArea");
            String projInfoId = request.getParameter("projInfoId");
            target.setProject(projInfoService.get(Long.valueOf(projInfoId)));
            //保存参建单位各信息（按顺序为： 建设单位  勘察单位  设计单位  施工单位  监理单位）
            //参建单位名称、联系人、联系电话信息 | 参建单位类型  | 参建单位字段属性
            String[][] relatedUnitInfos = new String[][] {StringHelper.stringToStringArray(request.getParameter("relatedUnitInfos"), ","), {"Jsdw", "Kcdw", "Sjdw", "Sgdw", "Jldw"}, {"Name", "Person", "Tel"}};
            String grpUnitType = "";
            for (int i = 0; i < relatedUnitInfos[0].length; i++) {
                if (i % 3 == 0) {
                    grpUnitType = relatedUnitInfos[1][i / 3];
                }
                target.getClass().getMethod("set".concat(grpUnitType).concat(relatedUnitInfos[2][i % 3]), new Class<?>[]{String.class}).invoke(target, new Object[]{relatedUnitInfos[0][i].replace("empty", "")});
            }
            projBidService.save(target);
            //保存区县前删除保存过的信息
            if (target.getProjBidAreas() != null) {
                for (ProjBidArea projBidArea : target.getProjBidAreas()) {
                    projBidAreaService.delete(projBidArea);
                }
            }
            if (areaIds != null && areaIds.length > 0) {
                for (String areaId : areaIds) {
                    if (!StringHelper.isEmpty(areaId)) {
                        SysCodeDetail sysCodeDetail = sysCodeDetailService.get(Long.valueOf(areaId));
                        ProjBidArea projBidArea = new ProjBidArea();
                        projBidArea.setBelongArea(sysCodeDetail);
                        projBidArea.setBid(target);
                        projBidAreaService.save(projBidArea);
                    }
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
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        ProjBid projBid = projBidService.get(id);
        Set<ProjBidArea> projBidAreas = projBid.getProjBidAreas();
        for (ProjBidArea projBidArea : projBidAreas) {
            projBidAreaService.delete(projBidArea);
        }
        projBidService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 复制项目办证标段到形象进度标段对应项目下
     *
     * @param response
     * @param prjBidId
     * @throws Exception
     */
    @RequestMapping
    public void duplicatePrjBid4Schedule(HttpServletResponse response, Long prjBidId) throws Exception {
        try {
            ProjBid projBid2BeDupSrc = projBidService.get(prjBidId);
            ProjBid projBid2BeDupTar = new ProjBid();
            ReflectionUtils.copyBean(projBid2BeDupSrc, projBid2BeDupTar, new String[]{
                    "code",
                    "name",
                    "buildMileage",
                    "projLink",
                    "linkTel",
                    "startDate",
                    "jsdwName",
                    "jsdwTel",
                    "sjdwPerson",
                    "sgdwName",
                    "jldwName",
                    "sjdwName",
                    "jldwPerson",
                    "no",
                    "kcdwTel",
                    "kcdwName",
                    "jsdwPerson",
                    "sgdwPerson",
                    "sgdwTel",
                    "name",
                    "linkTel",
                    "jldwTel",
                    "kcdwPerson",
                    "sjdwTel"
            });
            projBid2BeDupTar.setProject(projBid2BeDupSrc.getProject());
            projBid2BeDupTar.setTypeCode(ProjBidType.TYPE_NODE.getCode());
            projBidService.save(projBid2BeDupTar);
            for (ProjBidArea pba : projBid2BeDupSrc.getProjBidAreas()) {
                ProjBidArea prjBa = new ProjBidArea();
                prjBa.setBelongArea(pba.getBelongArea());
                prjBa.setBid(projBid2BeDupTar);
                projBidAreaService.save(prjBa);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            super.processException(response, e);
            sendFailureJSON(response, "复制失败");
            return;
        }
        sendSuccessJSON(response, "复制成功！");
    }
}