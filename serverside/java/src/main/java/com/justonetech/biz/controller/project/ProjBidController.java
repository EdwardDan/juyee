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
import java.util.Set;


/**
 * note:项目标段管理(包括办证推进和形象进度2种标段)
 * author: system
 * create date:
 * modify date:
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
    public void projGridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String typeCode, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo where 1=1";
            //增加项目过滤
            hql += projectRelateManager.getRelateProjectHql("id");

            hql += "order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);

            //输出显示
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
            hql += " order by id asc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projBidService.findByPage(pageModel, query);

            //输出显示
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
        ProjBid projBid = new ProjBid();

        //如需增加其他默认值请在此添加
        projBid.setProject(projInfoService.get(projId));
        projBid.setTypeCode(typeCode);
        model.addAttribute("bean", projBid);

        return "view/project/projBid/input";
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
        ProjBid projBid = projBidService.get(id);

        model.addAttribute("bean", projBid);
        model.addAttribute("areas", projBid.getBelongAreaNames());

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
        ProjBid projBid = projBidService.get(id);

        model.addAttribute("bean", projBid);
        model.addAttribute("areas", projBid.getBelongAreaNames());
        return "view/project/projBid/view";
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
                        "code",
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
            projBidService.save(target);
            //保存区县前删除保存过的信息
            for (ProjBidArea projBidArea : target.getProjBidAreas()) {
                projBidAreaService.delete(projBidArea);
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

}