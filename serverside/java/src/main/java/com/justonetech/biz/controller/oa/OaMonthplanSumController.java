package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMonthplanItemService;
import com.justonetech.biz.daoservice.OaMonthplanService;
import com.justonetech.biz.daoservice.OaMonthplanSumItemService;
import com.justonetech.biz.daoservice.OaMonthplanSumService;
import com.justonetech.biz.domain.OaMonthplan;
import com.justonetech.biz.domain.OaMonthplanItem;
import com.justonetech.biz.domain.OaMonthplanSum;
import com.justonetech.biz.domain.OaMonthplanSumItem;
import com.justonetech.biz.utils.enums.OaMonthplanStatus;
import com.justonetech.biz.utils.enums.OaMonthplanSumStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;


/**
 * note:月度总结和计划汇总
 * author: guoqiong
 * create date:
 * modify date: 2014-4-29
 */
@Controller
public class OaMonthplanSumController extends BaseCRUDActionController<OaMonthplanSum> {
    private Logger logger = LoggerFactory.getLogger(OaMonthplanSumController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaMonthplanSumService oaMonthplanSumService;

    @Autowired
    private OaMonthplanSumItemService oaMonthplanSumItemService;

    @Autowired
    private OaMonthplanService oaMonthplanService;

    @Autowired
    private OaMonthplanItemService oaMonthplanItemService;

    private static final String REPORT_TYPE_ZJ = "总结";
    private static final String REPORT_TYPE_JH = "计划";

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MONTHPLAN_SUM_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MONTHPLAN_SUM_AUDIT));
        setOaMaterialStatus(model);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);

        return "view/oa/oaMonthplanSum/grid";
    }

    /**
     * 编辑审核权限状态
     *
     * @param model .
     */
    private void setOaMaterialStatus(Model model) {
        // 办公室主任填写
        model.addAttribute("STATUS_EDIT", OaMonthplanSumStatus.STATUS_EDIT.getCode());
        // 提交
        model.addAttribute("STATUS_SUBMIT", OaMonthplanSumStatus.STATUS_SUBMIT.getCode());
        // 领导退回
        model.addAttribute("STATUS_BACK_LEADER", OaMonthplanSumStatus.STATUS_BACK_LEADER.getCode());
        // 领导审核通过
        model.addAttribute("STATUS_PASS", OaMonthplanSumStatus.STATUS_PASS.getCode());
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpServletRequest request) {
        try {
            String year = request.getParameter("year");
            String period = request.getParameter("period");

            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMonthplanSum where 1=1 ";
            if (!StringHelper.isEmpty(year)) {
                hql += " and year=" + Integer.parseInt(year);
            }
            if (!StringHelper.isEmpty(period)) {
                hql += " and period=" + Integer.parseInt(period);
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMonthplanSumService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 年月选择页面
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String count(Model model) {
        //取出原来表中的所有审核通过的年月
        String hql = "from OaMonthplan where status=?";
        List<OaMonthplan> list = oaMonthplanService.findByQuery(hql, OaMonthplanStatus.STATUS_PASS.getCode());
        Set<String> setOaMonthplan = new HashSet<String>();
        for (OaMonthplan oaMonthplan : list) {
            Integer year = oaMonthplan.getYear();
            Integer period = oaMonthplan.getPeriod();
            String yearPeriod = year + "_" + period;
            if (!setOaMonthplan.contains(yearPeriod)) {
                setOaMonthplan.add(yearPeriod);
            }
        }
        //取出所有汇总过的年月
        List<OaMonthplanSum> sumList = oaMonthplanSumService.findAll();
        Set<String> setSum = new HashSet<String>();
        for (OaMonthplanSum oaMonthplanSum : sumList) {
            Integer year = oaMonthplanSum.getYear();
            Integer period = oaMonthplanSum.getPeriod();
            String yearPeriod = year + "_" + period;
            if (!setSum.contains(yearPeriod)) {
                setSum.add(yearPeriod);
            }
        }
        //将汇总过的年月从原来的年月中去除
        for (String s : setSum) {
            if (setOaMonthplan.contains(s)) {
                setOaMonthplan.remove(s);
            }
        }
        //获取年和月的下拉框
        String yearPeriodSelectOptions = getYearPeriodSelectOptions("", setOaMonthplan);
        model.addAttribute("yearPeriodSelectOptions", yearPeriodSelectOptions);

        return "view/oa/oaMonthplanSum/count";
    }

    /**
     * 获取没有汇总的年月下拉框
     *
     * @param yearPeriod 。
     * @param set        。
     * @return 。
     */
    public String getYearPeriodSelectOptions(String yearPeriod, Set<String> set) {
        String options = "";
        for (String s : set) {
            String[] strings = s.split("_");
            if (!StringHelper.isEmpty(yearPeriod)) {
                if (s.equals(yearPeriod)) {
                    options += FormatUtils.format(JspHelper.SELECT_OPTION, s, strings[0] + "年" + strings[1] + "月", "selected");
                } else {
                    options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年" + strings[1] + "月");
                }
            } else {
                options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年" + strings[1] + "月");
            }
        }
        return options;
    }

    /**
     * 新增录入页面
     *
     * @param model      。
     * @param yearPeriod .
     * @return 。
     */
    @RequestMapping
    public String add(Model model, String yearPeriod) {
        String[] strings = yearPeriod.split("_");
        //将获取的年月分离
        int year = Integer.parseInt(strings[0]);
        int period = Integer.parseInt(strings[1]);
        OaMonthplanSum oaMonthplanSum = new OaMonthplanSum();
        oaMonthplanSum.setYear(year);
        oaMonthplanSum.setPeriod(period);
        model.addAttribute("bean", oaMonthplanSum);

        String itemHql = getOaMonthplanItemHql(year, period);
        List<OaMonthplanItem> itemList = oaMonthplanItemService.findByQuery(itemHql);
        List<Map<String, Object>> monthMapListZj = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> monthMapListJh = new ArrayList<Map<String, Object>>();
        for (OaMonthplanItem oaMonthplanItem : itemList) {
            Map<String, Object> mapZj = new HashMap<String, Object>();
            Map<String, Object> mapJh = new HashMap<String, Object>();
            String reportType = oaMonthplanItem.getReportType();
            //获取对应年月下的详细信息(类型为总结的未删除的信息)
            if (!StringHelper.isEmpty(reportType) && reportType.equals(REPORT_TYPE_ZJ)) {
                mapZj.put("zj", oaMonthplanItem);
            }
            monthMapListZj.add(mapZj);
            //获取对应年月下的详细信息(类型为计划的未删除的信息)
            if (!StringHelper.isEmpty(reportType) && reportType.equals(REPORT_TYPE_JH)) {
                mapJh.put("jh", oaMonthplanItem);
            }
            monthMapListJh.add(mapJh);
        }
        model.addAttribute("itemListZjs", monthMapListZj);
        model.addAttribute("itemListJhs", monthMapListJh);

        setOaMaterialStatus(model);

        return "view/oa/oaMonthplanSum/input";
    }

    /**
     * 查询对应年月下的详细信息
     *
     * @param year   。
     * @param period 。
     * @return 。
     */
    private String getOaMonthplanItemHql(int year, int period) {
        return "from OaMonthplanItem t where t.monthplan.status=" + OaMonthplanStatus.STATUS_PASS.getCode()
                + " and t.monthplan.year=" + year + " and t.monthplan.period=" + period + " and t.isSumDelete=0";
    }

    /**
     * 修改页面
     *
     * @param model 。
     * @param id    。
     * @return 。
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        OaMonthplanSum oaMonthplanSum = oaMonthplanSumService.get(id);
        model.addAttribute("bean", oaMonthplanSum);

        //已经存在于数据库中的数据（汇总过的数据）
        Set<OaMonthplanSumItem> oaMonthplanSumItems = oaMonthplanSum.getOaMonthplanSumItems();
        Map<Long, OaMonthplanSumItem> existMap = new HashMap<Long, OaMonthplanSumItem>();
        for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
            Long monthItemId = oaMonthplanSumItem.getMonthplanItem().getId();
            existMap.put(monthItemId, oaMonthplanSumItem);
        }
        String itemHql = getOaMonthplanItemHql(oaMonthplanSum.getYear(), oaMonthplanSum.getPeriod());
        //获取对应年月下的详细信息(类型为计划的未删除的信息)
        String hqlItemJh = itemHql + " and t.reportType='计划' order by t.id desc";
        List<OaMonthplanItem> itemListJh = oaMonthplanItemService.findByQuery(hqlItemJh);
        //获取对应年月下的详细信息(类型为总结的未删除的信息)
        String hqlItemZj = itemHql + " and t.reportType='总结' order by t.id desc";
        List<OaMonthplanItem> itemListZj = oaMonthplanItemService.findByQuery(hqlItemZj);

        List<Map<String, Object>> mapListZj = getMonthMapList(existMap, itemListZj);
        List<Map<String, Object>> mapListJh = getMonthMapList(existMap, itemListJh);
        model.addAttribute("mapListZjs", mapListZj);
        model.addAttribute("mapListJhs", mapListJh);

        setOaMaterialStatus(model);

        return "view/oa/oaMonthplanSum/input";
    }

    /**
     * 汇总两张表的数据
     *
     * @param existMap 。
     * @param itemList 。
     */
    private List<Map<String, Object>> getMonthMapList(Map<Long, OaMonthplanSumItem> existMap, List<OaMonthplanItem> itemList) {

        List<Map<String, Object>> monthMapList = new ArrayList<Map<String, Object>>();
        for (OaMonthplanItem oaMonthplanItem : itemList) {
            Map<String, Object> map = new HashMap<String, Object>();
            //原始未统计的数据
            map.put("itemId", oaMonthplanItem.getId());
            map.put("orderNo", oaMonthplanItem.getOrderNo());
            map.put("content", oaMonthplanItem.getContent());
            map.put("timeNode", oaMonthplanItem.getTimeNode());
            map.put("reportPerson", oaMonthplanItem.getMonthplan().getReportPerson());
            map.put("reportDept", oaMonthplanItem.getMonthplan().getReportDept());
            map.put("isComplete", oaMonthplanItem.getIsComplete());
            map.put("reportType", oaMonthplanItem.getReportType());
            OaMonthplanSumItem oaMonthplanSumItem = existMap.get(oaMonthplanItem.getId());
            if (oaMonthplanSumItem != null) {
                map.put("itemId", oaMonthplanSumItem.getMonthplanItem().getId());
                map.put("orderNo", oaMonthplanSumItem.getOrderNo());
                map.put("content", oaMonthplanSumItem.getContent());
                map.put("timeNode", oaMonthplanSumItem.getTimeNode());
                map.put("reportPerson", oaMonthplanSumItem.getReportPerson());
                map.put("reportDept", oaMonthplanSumItem.getReportDept());
                map.put("isComplete", oaMonthplanSumItem.getIsComplete());
                map.put("reportType", oaMonthplanSumItem.getReportType());
            }
            monthMapList.add(map);
        }
        return monthMapList;
    }

    /**
     * 审核页面
     *
     * @param model 。
     * @param id    。
     * @return 。
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaMonthplanSum oaMonthplanSum = oaMonthplanSumService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaMonthplanSum);
        getSumItemByType(oaMonthplanSum, model);

        setOaMaterialStatus(model);

        return "view/oa/oaMonthplanSum/audit";
    }

    /**
     * 按类型把汇总内容分开
     *
     * @param oaMonthplanSum 。
     */
    private void getSumItemByType(OaMonthplanSum oaMonthplanSum, Model model) {
        List<Map<String, Object>> monthMapListZj = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> monthMapListJh = new ArrayList<Map<String, Object>>();
        Set<OaMonthplanSumItem> oaMonthplanSumItems = oaMonthplanSum.getOaMonthplanSumItems();
        for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
            Map<String, Object> mapZj = new HashMap<String, Object>();
            Map<String, Object> mapJh = new HashMap<String, Object>();
            String reportType = oaMonthplanSumItem.getReportType();
            if (!StringHelper.isEmpty(reportType) && reportType.equals(REPORT_TYPE_ZJ)) {
                mapZj.put("zj", oaMonthplanSumItem);
            }
            monthMapListZj.add(mapZj);
            if (!StringHelper.isEmpty(reportType) && reportType.equals(REPORT_TYPE_JH)) {
                mapJh.put("jh", oaMonthplanSumItem);
            }
            monthMapListJh.add(mapJh);
        }
        model.addAttribute("mapListZjs", monthMapListZj);
        model.addAttribute("mapListJhs", monthMapListJh);
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
        OaMonthplanSum oaMonthplanSum = oaMonthplanSumService.get(id);

        model.addAttribute("bean", oaMonthplanSum);
        getSumItemByType(oaMonthplanSum, model);

        return "view/oa/oaMonthplanSum/view";
    }

    /**
     * 保存操作(填写信息)
     *
     * @param response 。
     * @param entity   。
     * @param request  。
     * @param status   。
     * @throws Exception 。
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMonthplanSum entity, HttpServletRequest request, Integer status) throws Exception {
        try {
            OaMonthplanSum target;
            if (entity.getId() != null) {
                target = oaMonthplanSumService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{

                });
            } else {
                target = entity;
            }
            target.setStatus(status);
            //保存年和月
            String year = request.getParameter("year");
            String period = request.getParameter("period");
            target.setYear(Integer.valueOf(year));
            target.setPeriod(Integer.valueOf(period));
            //提交时设置提交时间为当前时间
            if (target.getStatus() == OaMonthplanSumStatus.STATUS_SUBMIT.getCode())
                target.setReportDate(new Date(System.currentTimeMillis()));
            oaMonthplanSumService.save(target);
            //保存从表
            saveOaMonthplanSumItem(target, request);

            //设置未统计的表中的是否删除状态
            String monthItemId = request.getParameter("monthItemId");
            if (!StringHelper.isEmpty(monthItemId)) {
                String[] monthItemIds = monthItemId.split(",");
                for (String itemId : monthItemIds) {
                    if (!StringHelper.isEmpty(itemId)) {
                        OaMonthplanItem oaMonthplanItem = oaMonthplanItemService.get(Long.valueOf(itemId));
                        oaMonthplanItem.setIsSumDelete(true);
                        oaMonthplanItemService.save(oaMonthplanItem);
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
     * 保存操作（审核信息）
     *
     * @param response 。
     * @param entity   。
     * @param status   。
     * @throws Exception 。
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaMonthplanSum entity, Integer status) throws Exception {
        try {
            OaMonthplanSum target;
            if (entity.getId() != null) {
                target = oaMonthplanSumService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "leaderOpinion",
                });

            } else {
                target = entity;
            }
            target.setStatus(status);
            //获取当前登录用户,保存当前审核人
            target.setLeaderAuditUser(sysUserManager.getSysUser().getDisplayName());
            //设置当前审核时间
            target.setLeaderAuditTime(new Timestamp(System.currentTimeMillis()));

            oaMonthplanSumService.save(target);

            //统一把部门设置为建管署
            if (target.getStatus() == OaMonthplanSumStatus.STATUS_PASS.getCode()) {
                Set<OaMonthplanSumItem> oaMonthplanSumItems = target.getOaMonthplanSumItems();
                for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
                    oaMonthplanSumItem.setReportDept("建管署");
                    oaMonthplanSumItemService.save(oaMonthplanSumItem);
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
     * 保存从表信息
     *
     * @param oaMonthplanSum .
     * @param request        .
     */
    private void saveOaMonthplanSumItem(OaMonthplanSum oaMonthplanSum, HttpServletRequest request) {
        //先删除从表信息，在保存
        Set<OaMonthplanSumItem> oaMonthplanSumItems = oaMonthplanSum.getOaMonthplanSumItems();
        for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
            oaMonthplanSumItemService.delete(oaMonthplanSumItem);
        }
        //获取页面传过来的值
        String[] itemIds = request.getParameterValues("itemId");   //隐藏域详细表中的ID
        String[] orderNos = request.getParameterValues("orderNo"); //序号
        String[] contents = request.getParameterValues("content");//工作内容
        String[] timeNodes = request.getParameterValues("timeNode"); //时间节点
        String[] reportPersons = request.getParameterValues("reportPerson"); //责任人
        String[] reportDepts = request.getParameterValues("reportDept");//部门
        String[] isCompletes = request.getParameterValues("isComplete"); //是否完成
        String[] reportTypes = request.getParameterValues("reportType");
        if (itemIds != null) {
            for (int i = 0; i < itemIds.length; i++) {
                OaMonthplanSumItem oaMonthplanSumItem = new OaMonthplanSumItem();
                oaMonthplanSumItem.setMonthplanSum(oaMonthplanSum);
                oaMonthplanSumItem.setMonthplanItem(oaMonthplanItemService.get(Long.valueOf(itemIds[i])));
                if (!StringHelper.isEmpty(orderNos[i])) {
                    oaMonthplanSumItem.setOrderNo(Integer.valueOf(orderNos[i]));
                }
                if (!StringHelper.isEmpty(contents[i])) {
                    oaMonthplanSumItem.setContent(contents[i]);
                }
                if (!StringHelper.isEmpty(timeNodes[i])) {
                    oaMonthplanSumItem.setTimeNode(java.sql.Date.valueOf(timeNodes[i]));
                }
                if (!StringHelper.isEmpty(reportPersons[i])) {
                    oaMonthplanSumItem.setReportPerson(reportPersons[i]);
                }
                if (!StringHelper.isEmpty(reportDepts[i])) {
                    oaMonthplanSumItem.setReportDept(reportDepts[i]);
                }
                if (!StringHelper.isEmpty(isCompletes[i])) {
                    if (isCompletes[i].equals("1")) {
                        oaMonthplanSumItem.setIsComplete(true);
                    } else {
                        oaMonthplanSumItem.setIsComplete(false);
                    }
                }
                if (!StringHelper.isEmpty(reportTypes[i])) {
                    oaMonthplanSumItem.setReportType(reportTypes[i]);
                }
                oaMonthplanSumItemService.save(oaMonthplanSumItem);
            }
        }
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
        OaMonthplanSum oaMonthplanSum = oaMonthplanSumService.get(id);
        Set<OaMonthplanSumItem> oaMonthplanSumItems = oaMonthplanSum.getOaMonthplanSumItems();
        for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
            oaMonthplanSumItemService.delete(oaMonthplanSumItem);
        }
        oaMonthplanSumService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }


}