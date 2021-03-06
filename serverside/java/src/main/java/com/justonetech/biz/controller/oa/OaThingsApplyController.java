package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaThingsApplyItemService;
import com.justonetech.biz.daoservice.OaThingsApplyService;
import com.justonetech.biz.daoservice.OaThingsService;
import com.justonetech.biz.domain.OaThings;
import com.justonetech.biz.domain.OaThingsApply;
import com.justonetech.biz.domain.OaThingsApplyItem;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaCarStatus;
import com.justonetech.biz.utils.enums.OaThingsApplyStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysDept;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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
 * note:办公用品申请
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaThingsApplyController extends BaseCRUDActionController<OaThingsApply> {
    private Logger logger = LoggerFactory.getLogger(OaThingsApplyController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private OaThingsApplyItemService oaThingsApplyItemService;

    @Autowired
    private OaThingsService oaThingsService;

    @Autowired
    private OaThingsApplyService oaThingsApplyService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_APPLY_EDIT));// 编辑
        pushStaticValueToPage(model);
        return "view/oa/oaThingsApply/grid";
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
            String hql = "from OaThingsApply t where 1=1";

            //增加自定义查询条件
            SysUser sysUser = sysUserManager.getSysUser();
            //获取登录人的部门
            SysDept dept = sysUser.getPerson().getDept();
            Boolean auditKZ = sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_APPLY_AUDIT_KZ);//科长审核
            Boolean auditZR = sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_APPLY_AUDIT_ZR); //主任审核
            if (!auditZR && auditKZ) {
                hql += " and t.applyDept.id=" + dept.getId();
            }
            if (!auditKZ && !auditZR) {
                hql += " and t.applyUser.id=" + sysUser.getId();
            }
            hql += " order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaThingsApplyService.findByPage(pageModel, query);

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
    public String add(Model model) {
        OaThingsApply oaThingsApply = new OaThingsApply();
        //默认申请人为当前用户
        SysUser sysUser = sysUserManager.getSysUser();
        oaThingsApply.setApplyUser(sysUser);
        //获取登录人的部门
        SysDept dept = sysUser.getPerson().getDept();
        oaThingsApply.setApplyDept(dept);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaThingsApply);
        pushStaticValueToPage(model);
        return "view/oa/oaThingsApply/input";
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
        OaThingsApply oaThingsApply = oaThingsApplyService.get(id);
        //处理其他业务逻辑
        model.addAttribute("bean", oaThingsApply);
        pushStaticValueToPage(model);
        return "view/oa/oaThingsApply/input";
    }

    /**
     * 审核页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaThingsApply oaThingsApply = oaThingsApplyService.get(id);
        //处理其他业务逻辑
        model.addAttribute("bean", oaThingsApply);
        pushStaticValueToPage(model);
        sumMoney(oaThingsApply, model);
        return "view/oa/oaThingsApply/audit";
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
        OaThingsApply oaThingsApply = oaThingsApplyService.get(id);
        pushStaticValueToPage(model);
        model.addAttribute("bean", oaThingsApply);
        sumMoney(oaThingsApply, model);
        return "view/oa/oaThingsApply/view";
    }

    private void sumMoney(OaThingsApply oaThingsApply, Model model) {
        double count = 0.0;
        if (null != oaThingsApply.getOaThingsApplyItems()) {
            for (OaThingsApplyItem oaThingsApplyItem : oaThingsApply.getOaThingsApplyItems()) {
                if (oaThingsApplyItem.getAmount() != null && oaThingsApplyItem.getPrice() != null) {
                    count += oaThingsApplyItem.getAmount() * oaThingsApplyItem.getPrice();
                }
            }
        }
        model.addAttribute("count", count);
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
    public void saveInput(HttpServletResponse response, @ModelAttribute("bean") OaThingsApply entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaThingsApply target;
            if (entity.getId() != null) {
                target = oaThingsApplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "applyContent",
                        "applyUser",
                        "applyDept"
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));
            target.setKzAuditOpinion(null);
            target.setKzAuditUser(null);
            target.setKzAuditTime(null);
            target.setZrAuditOpinion(null);
            target.setZrAuditUser(null);
            target.setZrAuditTime(null);
            oaThingsApplyService.save(target);
            //保存前先删除关联子表数据便于更新
            List<OaThingsApplyItem> oaThingsApplyItemList = new ArrayList<OaThingsApplyItem>(target.getOaThingsApplyItems());
            oaThingsApplyItemService.batchDelete(oaThingsApplyItemList, oaThingsApplyItemList.size());
            oaThingsApplyItemList = new ArrayList<OaThingsApplyItem>();

            String[] name = request.getParameterValues("name");//申请物品
            String[] model = request.getParameterValues("model");//型号
            String[] unit = request.getParameterValues("unit");//单位
            String[] price = request.getParameterValues("price");//预计单价
            String[] amount = request.getParameterValues("amount");//数量
            if (null != name && name.length>0) {
                for (int i = 0; i < name.length; i++) {
                    OaThingsApplyItem oaThingsApplyItem = new OaThingsApplyItem();
                    oaThingsApplyItem.setName(name[i]);//申请物品
                    oaThingsApplyItem.setModel(model[i]);//型号
                    oaThingsApplyItem.setUnit(unit[i]);//单位
                    if (null != price[i] && !StringHelper.isEmpty(price[i])) {//预计单价
                        oaThingsApplyItem.setPrice(Double.valueOf(price[i]));
                    }
                    oaThingsApplyItem.setOaThingsApply(target);//申请id
                    if (null != amount[i] && !StringHelper.isEmpty(amount[i])) {//数量
                        oaThingsApplyItem.setAmount(Double.valueOf(amount[i]));
                    }
                    oaThingsApplyItemList.add(oaThingsApplyItem);
                }
            oaThingsApplyItemService.batchSave(oaThingsApplyItemList, oaThingsApplyItemList.size());//保存申请记录物品
            }
            if (target.getStatus() == OaThingsApplyStatus.STATUS_SUBMIT.getCode()) {
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
     * 保存操作（审核）
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveAudit(HttpServletResponse response, @ModelAttribute("bean") OaThingsApply entity, HttpServletRequest request, String status) throws Exception {
        try {
            OaThingsApply target;
            if (entity.getId() != null) {
                target = oaThingsApplyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "kzAuditOpinion",
                        "zrAuditOpinion",
                        "dealUser"
                });

            } else {
                target = entity;
            }
            target.setStatus(Integer.valueOf(status));
            //设置审核时间为当前时间
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //获取当前登录用户
            SysUser sysUser = sysUserManager.getSysUser();
            //保存当前审核人
            if (target.getStatus() == OaThingsApplyStatus.STATUS_BRANCH_PASS.getCode() || target.getStatus() == OaThingsApplyStatus.STATUS_BRANCH_BACK.getCode()) {
                target.setKzAuditUser(sysUser);
                target.setKzAuditTime(timestamp);
            }
            if (target.getStatus() == OaThingsApplyStatus.STATUS_MAIN_PASS.getCode() || target.getStatus() == OaThingsApplyStatus.STATUS_MAIN_BACK.getCode()) {
                target.setZrAuditUser(sysUser);
                target.setZrAuditTime(timestamp);
            }
            oaThingsApplyService.save(target);
            createOaTask(target);
//            if (target.getStatus() == OaThingsApplyStatus.STATUS_MAIN_PASS.getCode()) {
//                Set<OaThingsApplyItem> oaThingsApplyItems = target.getOaThingsApplyItems();
//                for (OaThingsApplyItem oaThingsApplyItem : oaThingsApplyItems) {
//                    OaThings oaThings = oaThingsApplyItem.getOaThings();
//                    oaThings.setAmount(oaThings.getAmount() - oaThingsApplyItem.getAmount());
//                    if (oaThings.getAmount() < 0) {
//                        oaThings.setAmount(new Double(0));
//                    }
//                    oaThingsService.save(oaThings);
//                }
//            }
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
        OaThingsApply oaThingsApply = oaThingsApplyService.get(id);
        Set<OaThingsApplyItem> oaThingsApplyItems = oaThingsApply.getOaThingsApplyItems();
        List<OaThingsApplyItem> list = new ArrayList<OaThingsApplyItem>(oaThingsApplyItems);
        oaThingsApplyItemService.batchDelete(list, list.size());
        oaThingsApplyService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 办公用品选择树
     *
     * @param id
     * @param icon
     * @param model 。
     * @return
     */
    @RequestMapping
    public String treeDataForSelect(String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //单位
            String hql = "from OaThings  order by orderNo asc";
//            String hql = "from OaThings where isValid=1 order by orderNo asc";
            List<OaThings> nodeList = oaThingsService.findByQuery(hql);
            for (OaThings data : nodeList) {
                boolean isLeaf = true;
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setIsLeaf(isLeaf);
                treeNode.setName(data.getName());
                treeNode.setIcon("1");
                treeNode.setType("thing");
                treeBranch.addTreeNode(treeNode);
            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

    /**
     * 根据code返回办公用品
     *
     * @param id 。
     */
    @RequestMapping
    public String getThing(Model model, String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null == id || id.equals("")) {
            return "";
        }
        OaThings oaThings = oaThingsService.get(Long.valueOf(id));
        map.put("name", oaThings.getName());
        map.put("model", oaThings.getModel());
        map.put("amount", oaThings.getAmount());
        map.put("price", oaThings.getPrice());
        map.put("unit", oaThings.getUnit());
        String string = JSONObject.fromObject(map).toString();
        model.addAttribute("msg", string);
        return "common/msg";

    }

    /**
     * 各种状态的编码
     *
     * @param model .
     */
    private void pushStaticValueToPage(Model model) {
        model.addAttribute("auditKZ", sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_APPLY_AUDIT_KZ));//科长审核
        model.addAttribute("auditZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_THINGS_APPLY_AUDIT_ZR)); //主任审核
        model.addAttribute("STATUS_EDIT", OaThingsApplyStatus.STATUS_EDIT.getCode()); //填写
        model.addAttribute("STATUS_SUBMIT", OaThingsApplyStatus.STATUS_SUBMIT.getCode()); //提交
        model.addAttribute("STATUS_BRANCH_PASS", OaThingsApplyStatus.STATUS_BRANCH_PASS.getCode()); //科长审核通过
        model.addAttribute("STATUS_BRANCH_BACK", OaThingsApplyStatus.STATUS_BRANCH_BACK.getCode()); //科长审核退回
        model.addAttribute("STATUS_MAIN_PASS", OaThingsApplyStatus.STATUS_MAIN_PASS.getCode()); //办公室主任审核通过
        model.addAttribute("STATUS_MAIN_BACK", OaThingsApplyStatus.STATUS_MAIN_BACK.getCode()); //办公室主任审核退回
        model.addAttribute("currentUser", sysUserManager.getSysUser().getDisplayName()); //当前登录用户
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaThingsApply data) throws Exception {
        int Status = data.getStatus();
        String simpleName = OaThingsApply.class.getSimpleName();
        //创建任务
        String title = oaTaskManager.getTaskTitle(data, simpleName);
        Set<Long> managers = new HashSet<Long>();
        //科长和办公室主任在提交后收到待办提醒
        if (Status == OaThingsApplyStatus.STATUS_SUBMIT.getCode()) { //当前用户在提交后科长收到待办提醒
            //获取科长
            SysUser kz = sysUserManager.getDeptLeaderByRole(sysUserManager.getSysUser().getLoginName());
            Set<Long> managersKZ = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.OA_THINGS_APPLY_AUDIT_KZ);
            if (null != kz && managersKZ.contains(kz.getId())) {
                managers.add(kz.getId());
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName, data.getId(), title, managers, false, null, null);
            }
        } else if (Status == OaThingsApplyStatus.STATUS_BRANCH_PASS.getCode()) { //科长在提交后办公室主任收到待办提醒
            title = oaTaskManager.getTaskTitle(data, simpleName + "_KZ_Pass");
            //获取有办公室主任权限的用户
            Set<Long> managersZR = sysUserManager.getUserIdsByPrivilegeCode(PrivilegeCode.OA_THINGS_APPLY_AUDIT_ZR);
            managers.addAll(managersZR);
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_KZ_Pass", data.getId(), title, managers, false, null, null);
            }
        } else if (Status == OaThingsApplyStatus.STATUS_BRANCH_BACK.getCode() || Status == OaThingsApplyStatus.STATUS_MAIN_BACK.getCode()) {
            String msg;
            if (Status == OaThingsApplyStatus.STATUS_BRANCH_BACK.getCode()) {
                msg = "_KZ_Back";
            } else {
                msg = "_BGS_Back";
            }
            title = oaTaskManager.getTaskTitle(data, simpleName + msg);
            SysUser applyUser = data.getApplyUser();
            if (null != applyUser) {
                managers.add(applyUser.getId());
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + msg, data.getId(), title, managers, false, null, null);
            }
        } else if (Status == OaThingsApplyStatus.STATUS_MAIN_PASS.getCode()) {  //办公室在审核后申请人收到待办提醒
            title = oaTaskManager.getTaskTitle(data, simpleName + "_BGS_Pass");
            SysUser applyUser = data.getApplyUser();
            if (null != applyUser) {
                managers.add(applyUser.getId());
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(simpleName + "_BGS_Pass", data.getId(), title, managers, false, null, null);
            }
        }
    }
}