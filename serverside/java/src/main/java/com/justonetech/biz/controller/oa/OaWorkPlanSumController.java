package com.justonetech.biz.controller.oa;

import java.sql.Timestamp;
import java.util.*;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.enums.OaMeetingStatus;
import com.justonetech.biz.utils.enums.OaWorkPlanSumStatus;
import com.justonetech.core.utils.JspHelper;
import org.apache.commons.lang.StringUtils;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.ui.grid.Grid;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:科室上报汇总
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkPlanSumController extends BaseCRUDActionController<OaWorkPlanSum>
{
    private Logger logger = LoggerFactory.getLogger(OaWorkPlanSumController.class);

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
    private OaWorkPlanSumService oaWorkPlanSumService;

    @Autowired
    private OaWorkPlanService oaWorkPlanService;

    @Autowired
    private OaWorkPlanItemService oaWorkPlanItemService;

    @Autowired
    private OaWorkPlanSumItemService oaWorkPlanSumItemService;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model)
    {
        OaWorkPlanSumStatus statusBean[] = {OaWorkPlanSumStatus.STATUS_EDIT, OaWorkPlanSumStatus.STATUS_SUBMIT
                , OaWorkPlanSumStatus.STATUS_MAIN_PASS, OaWorkPlanSumStatus.STATUS_MAIN_BACK};
        List<Map<String, String>> statusList = setStatusBean(statusBean);
        model.addAttribute("statusList", statusList);
        //判断是否有编辑权限
        setStatus(model);
        return "view/oa/oaWorkPlanSum/grid";
    }

    public List<Map<String, String>> setStatusBean(OaWorkPlanSumStatus statusBean[])
    {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for (OaWorkPlanSumStatus bean : statusBean)
        {
            Map<String, String> status = new HashMap<String, String>();
            status.put("name", bean.getName());
            status.put("value", String.valueOf(bean.getCode()));
            result.add(status);
        }
        return result;
    }

    public void setStatus(Model model)
    {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_SUM_EDIT));
        model.addAttribute("canEdit_ZR", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_PLAN_SUM_AUDIT_ZR));

        model.addAttribute("STATUS_EDIT", OaWorkPlanSumStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaWorkPlanSumStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_MAIN_PASS", OaWorkPlanSumStatus.STATUS_MAIN_PASS.getCode());
        model.addAttribute("STATUS_MAIN_BACK", OaWorkPlanSumStatus.STATUS_MAIN_BACK.getCode());
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String queryJson)
    {
        try
        {
            String beginTime = StringHelper.getElementValue(queryJson, "beginTime");
            String endTime = StringHelper.getElementValue(queryJson, "endTime");
            String status = StringHelper.getElementValue(queryJson, "status");
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaWorkPlanSum where 1=1";
            //增加自定义查询条件
            if (!StringHelper.isEmpty(beginTime))
            {
                hql += " and to_char(beginDate,'yyyy-MM-dd')>='" + beginTime + "'";
            }
            if (!StringHelper.isEmpty(endTime))
            {
                hql += " and to_char(endDate,'yyyy-MM-dd')<='" + endTime + "'";
            }

            if (!StringHelper.isEmpty(status))
            {
                hql += " and status ='" + status + "'";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaWorkPlanSumService.findByPage(pageModel, query);
            List<OaWorkPlanSum> rowList = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (OaWorkPlanSum data : rowList)
            {
                map = new HashMap<String, Object>();
                map.put("id", data.getId());
                map.put("beginTime", data.getBeginDate());
                map.put("endTime", data.getEndDate());
                map.put("workTime", data.getWorkTime());
                map.put("sumDept", data.getSumDept());
                map.put("statusName", data.getStatusName());
                map.put("status", data.getStatus());
                retList.add(map);
            }
            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
            sendJSON(response, json);

        } catch (Exception e)
        {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 时间选择页面
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String count(Model model)
    {

        return "view/oa/oaWorkPlanSum/count";
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String queryJson)
    {
        setStatus(model);
        String beginTime = StringHelper.getElementValue(queryJson, "beginTime");
        String endTime = StringHelper.getElementValue(queryJson, "endTime");
        String hql = "from OaWorkPlan where 1=1 ";
        //增加自定义查询条件
        if (!StringHelper.isEmpty(beginTime))
        {
            hql += " and to_char(beginDate,'yyyy-MM-dd')>='" + beginTime + "'";
        }
        if (!StringHelper.isEmpty(endTime))
        {
            hql += " and to_char(endDate,'yyyy-MM-dd')<='" + endTime + "'";
        }
        hql += " and status>1 order by id desc";
        List<OaWorkPlan> oaWorkPlanList = oaWorkPlanService.findByQuery(hql);
        ArrayList<OaWorkPlanItem> oaWorkPlanItems = new ArrayList<OaWorkPlanItem>();
        for (OaWorkPlan oaWorkPlan : oaWorkPlanList)
        {
            Set<OaWorkPlanItem> workPlanItems = oaWorkPlan.getOaWorkPlanItems();
            for (OaWorkPlanItem workPlanItem : workPlanItems)
            {
                oaWorkPlanItems.add(workPlanItem);
            }
        }

        model.addAttribute("oaWorkPlanItems", oaWorkPlanItems);
        OaWorkPlanSum oaWorkPlanSum = new OaWorkPlanSum();
        oaWorkPlanSum.setBeginDate(JspHelper.getDate(beginTime));
        oaWorkPlanSum.setEndDate(JspHelper.getDate(endTime));
        oaWorkPlanSum.setStatus(OaWorkPlanSumStatus.STATUS_EDIT.getCode());

        model.addAttribute("bean", oaWorkPlanSum);

        return "view/oa/oaWorkPlanSum/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id)
    {
        OaWorkPlanSum oaWorkPlanSum = oaWorkPlanSumService.get(id);
        if (null != oaWorkPlanSum.getOaWorkPlanSumItems())
        {
            model.addAttribute("oaWorkPlanItems", oaWorkPlanSum.getOaWorkPlanSumItems());
        }

        //处理其他业务逻辑
        setStatus(model);
        model.addAttribute("bean", oaWorkPlanSum);

        return "view/oa/oaWorkPlanSum/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id)
    {
        OaWorkPlanSum oaWorkPlanSum = oaWorkPlanSumService.get(id);
        if (null != oaWorkPlanSum.getOaWorkPlanSumItems())
        {
            model.addAttribute("oaWorkPlanItems", oaWorkPlanSum.getOaWorkPlanSumItems());
        }

        setStatus(model);

        model.addAttribute("bean", oaWorkPlanSum);
        return "view/oa/oaWorkPlanSum/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaWorkPlanSum entity, HttpServletRequest request) throws Exception
    {
        String msg = "保存成功";
        try
        {
            OaWorkPlanSum target;
            if (entity.getId() != null)
            {
                target = oaWorkPlanSumService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "beginDate",
                        "endDate",
//                        "documentId",
                        "status",
                        "leaderOpinion"
                });

            } else
            {
                target = entity;
            }
            //修改主任审核状态
            Integer status = target.getStatus();
            if (null != status && OaWorkPlanSumStatus.STATUS_MAIN_PASS.getCode() == status || OaWorkPlanSumStatus.STATUS_MAIN_BACK.getCode() == status)
            {
                target.setLeaderAuditTime(new Timestamp(System.currentTimeMillis()));
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                if (loginUser != null)
                {
                    target.setLeaderAuditUser(loginUser.getRealName());
                }
            }
            if (OaMeetingStatus.STATUS_MAIN_BACK.getCode() == target.getStatus())
            {
                msg = "已退回修改!";
            } else if (OaMeetingStatus.STATUS_MAIN_PASS.getCode() == target.getStatus())
            {
                msg = "审核已通过!";
            } else if (OaMeetingStatus.STATUS_SUBMIT.getCode() == target.getStatus())
            {
                msg = "已提交!";
            }

            oaWorkPlanSumService.save(target);

            Set<OaWorkPlanSumItem> oaWorkPlanSumItems = target.getOaWorkPlanSumItems();
            if (oaWorkPlanSumItems != null)
            {
                for (OaWorkPlanSumItem oaWorkPlanSumItem : oaWorkPlanSumItems)
                {
                    oaWorkPlanSumItemService.delete(oaWorkPlanSumItem.getId());
                }
            }

            String[] itemId = request.getParameterValues("itemId");
            String[] orderNos = request.getParameterValues("orderNo");
            String[] dutyPerosns = request.getParameterValues("dutyPerosn");
            String[] keyWorks = request.getParameterValues("keyWork");
            String[] contents = request.getParameterValues("content");
            String[] schedules = request.getParameterValues("schedule");
            String[] jbrs = request.getParameterValues("jbr");

            if (orderNos.length > 0)
            {
                for (int i = 0; i < orderNos.length; i++)
                {
                    OaWorkPlanSumItem oaWorkPlanSumItem = new OaWorkPlanSumItem();
                    oaWorkPlanSumItem.setWorkPlanItem(oaWorkPlanItemService.get(JspHelper.getLong(itemId[i])));
                    oaWorkPlanSumItem.setOrderNo(JspHelper.getInteger(orderNos[i]));
                    oaWorkPlanSumItem.setDutyPerosn(dutyPerosns[i]);
                    oaWorkPlanSumItem.setKeyWork(keyWorks[i]);
                    oaWorkPlanSumItem.setContent(contents[i]);
                    oaWorkPlanSumItem.setSchedule(schedules[i]);
                    oaWorkPlanSumItem.setJbr(jbrs[i]);
                    oaWorkPlanSumItem.setWorkPlanSum(entity);
                    oaWorkPlanSumItemService.save(oaWorkPlanSumItem);


                }
            }

        } catch (Exception e)
        {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, msg);
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception
    {
        System.out.println("id = " + id);
        Set<OaWorkPlanSumItem> oaWorkPlanSumItems = oaWorkPlanSumService.get(id).getOaWorkPlanSumItems();
        for (OaWorkPlanSumItem oaWorkPlanSumItem : oaWorkPlanSumItems)
        {
            oaWorkPlanSumItemService.delete(oaWorkPlanSumItem.getId());
        }
        oaWorkPlanSumService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}