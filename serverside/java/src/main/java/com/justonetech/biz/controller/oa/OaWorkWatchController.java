package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaWorkWatchItemService;
import com.justonetech.biz.daoservice.OaWorkWatchService;
import com.justonetech.biz.domain.OaWorkWatch;
import com.justonetech.biz.domain.OaWorkWatchItem;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaWorkWatchStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
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
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * note:工作督办
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkWatchController extends BaseCRUDActionController<OaWorkWatch> {
    private Logger logger = LoggerFactory.getLogger(OaWorkWatchController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaWorkWatchItemService oaWorkWatchItemService;

    @Autowired
    private OaWorkWatchService oaWorkWatchService;

    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        model.addAttribute("canSum", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_SUM));

        return "view/oa/oaWorkWatch/init";
    }

    /**
     * 列表显示页面
     * @param tab .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String tab) {
        //判断是否有编辑权限
        setStatus(model);
        model.addAttribute("tab", tab);
        return "view/oa/oaWorkWatch/grid";
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
            String hql = "from OaWorkWatch order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaWorkWatchService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 权限和状态
     *
     * @param model 。
     */
    public void setStatus(Model model) {

        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_EDIT));//编辑
        model.addAttribute("canEdit_ZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_ZR));//填写主任审核
        model.addAttribute("canEdit_KZ", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_KZ));//科长上报
        model.addAttribute("canEdit_B", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_AUDIT_B));//办公室核实

        model.addAttribute("STATUS_EDIT", OaWorkWatchStatus.STATUS_EDIT.getCode());//填写
        model.addAttribute("STATUS_SUBMIT", OaWorkWatchStatus.STATUS_SUBMIT.getCode());//提交
        model.addAttribute("STATUS_ZR_PASS", OaWorkWatchStatus.STATUS_ZR_PASS.getCode());//主任审核通过
        model.addAttribute("STATUS_ZR_BACK", OaWorkWatchStatus.STATUS_ZR_BACK.getCode());//主任审核退回
        model.addAttribute("STATUS_INFO", OaWorkWatchStatus.STATUS_INFO.getCode());//已上报
        model.addAttribute("STATUS_B_PASS", OaWorkWatchStatus.STATUS_B_PASS.getCode());//办公室核实通过
        model.addAttribute("STATUS_B_BACK", OaWorkWatchStatus.STATUS_B_BACK.getCode());//办公室核实退回
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        OaWorkWatch oaWorkWatch = new OaWorkWatch();
        oaWorkWatch.setStatus(OaWorkWatchStatus.STATUS_EDIT.getCode());
        model.addAttribute("bean", oaWorkWatch);
        setStatus(model);

        return "view/oa/oaWorkWatch/input";
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
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        model.addAttribute("bean", oaWorkWatch);
        setStatus(model);

        return "view/oa/oaWorkWatch/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        model.addAttribute("bean", oaWorkWatch);
        setStatus(model);

        return "view/oa/oaWorkWatch/audit";
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
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        setStatus(model);
        model.addAttribute("bean", oaWorkWatch);

        return "view/oa/oaWorkWatch/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaWorkWatch entity, HttpServletRequest request, Integer status) throws Exception {
        try {
            SysUser sysUser = sysUserManager.getSysUser();

            OaWorkWatch target;
            if (entity.getId() != null) {
                target = oaWorkWatchService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "reportDept",
                        "reportPerson",
                        "bgsOpinion"
                });
            } else {
                target = entity;
                target.setReportUser(sysUser.getDisplayName());
            }
            target.setStatus(status);
            if (status == OaWorkWatchStatus.STATUS_INFO.getCode()) {
                target.setBeginDate(new Date(System.currentTimeMillis()));
            } else if (status == OaWorkWatchStatus.STATUS_B_BACK.getCode() || status == OaWorkWatchStatus.STATUS_B_PASS.getCode()) {
                target.setBgsAuditTime(new Timestamp(System.currentTimeMillis()));
                target.setBgsAuditUser(sysUser.getDisplayName());
                if (status == OaWorkWatchStatus.STATUS_B_PASS.getCode()) {
                    target.setEndDate(new Date(System.currentTimeMillis()));
                }
            }
            oaWorkWatchService.save(target);

            //先删除数据，在保存
            Set<OaWorkWatchItem> oaWorkWatchItems = target.getOaWorkWatchItems();
            if (null != oaWorkWatchItems) {
                for (OaWorkWatchItem oaWorkWatchItem : oaWorkWatchItems) {
                    oaWorkWatchItemService.delete(oaWorkWatchItem);
                }
            }
            //获取数据
            String[] orderNo = request.getParameterValues("orderNo");
            String[] content = request.getParameterValues("content");
            String[] timeNode = request.getParameterValues("timeNode");
            String[] reportMethod = request.getParameterValues("reportMethod");
            String[] completeDesc = request.getParameterValues("completeDesc");
            String[] actualDesc = request.getParameterValues("actualDesc");
            if (null != orderNo) {
                for (int i = 0; i < orderNo.length; i++) {
                    OaWorkWatchItem oaWorkWatchItem = new OaWorkWatchItem();
                    if (null != orderNo[i]) {
                        oaWorkWatchItem.setOrderNo(Integer.parseInt(orderNo[i]));
                    }
                    oaWorkWatchItem.setContent(content[i]);
                    oaWorkWatchItem.setTimeNode(timeNode[i]);
                    oaWorkWatchItem.setReportMethod(reportMethod[i]);
                    oaWorkWatchItem.setCompleteDesc(completeDesc[i]);
                    oaWorkWatchItem.setActualDesc(actualDesc[i]);
                    oaWorkWatchItem.setWorkWatch(target);
                    oaWorkWatchItemService.save(oaWorkWatchItem);
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
     * 保存审核
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveAudit(HttpServletResponse response, @ModelAttribute("bean") OaWorkWatch entity, Integer status) throws Exception {
        try {
            OaWorkWatch target;
            if (entity.getId() != null) {
                target = oaWorkWatchService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "zrOpinion"
                });
            } else {
                target = entity;
            }
            target.setStatus(status);
            SysUser sysUser = sysUserManager.getSysUser();

            if (status == OaWorkWatchStatus.STATUS_ZR_PASS.getCode() || status == OaWorkWatchStatus.STATUS_ZR_BACK.getCode()) {
                target.setZrAuditTime(new Timestamp(System.currentTimeMillis()));
                target.setZrAuditUser(sysUser.getDisplayName());
            }
            oaWorkWatchService.save(target);
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
        OaWorkWatch oaWorkWatch = oaWorkWatchService.get(id);
        Set<OaWorkWatchItem> oaWorkWatchItems = oaWorkWatch.getOaWorkWatchItems();
        for (OaWorkWatchItem oaWorkWatchItem : oaWorkWatchItems) {
            oaWorkWatchItemService.delete(oaWorkWatchItem);
        }
        oaWorkWatchService.delete(oaWorkWatch);

        sendSuccessJSON(response, "删除成功");
    }

}