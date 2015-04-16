package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaQuarterplanService;
import com.justonetech.biz.daoservice.OaQuarterplanSumItemService;
import com.justonetech.biz.daoservice.OaQuarterplanSumService;
import com.justonetech.biz.domain.OaQuarterplan;
import com.justonetech.biz.domain.OaQuarterplanSum;
import com.justonetech.biz.domain.OaQuarterplanSumItem;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.enums.OaMonthplanSumStatus;
import com.justonetech.biz.utils.enums.OaQuarterplanStatus;
import com.justonetech.biz.utils.enums.OaQuarterplanSumStatus;
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
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * note:季度年度总结计划汇总
 * author: subo,guoqiong
 * create date:
 * modify date: 2014-5-5
 */
@Controller
public class OaQuarterplanSumController extends BaseCRUDActionController<OaQuarterplanSum> {
    private Logger logger = LoggerFactory.getLogger(OaQuarterplanSumController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaQuarterplanSumService oaQuarterplanSumService;

    @Autowired
    private OaQuarterplanService oaQuarterplanService;

    @Autowired
    private OaQuarterplanSumItemService oaQuarterplanSumItemService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_QUARTERPLAN_SUM_EDIT));
        //判断是否有审核权限
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_QUARTERPLAN_SUM_AUDIT));

        setOaMaterialStatus(model);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String quarterSelectOptions = DateTimeHelper.getQuarterSelectOptions(JspHelper.getString(0));
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("quarterOptions", quarterSelectOptions);

        return "view/oa/oaQuarterplanSum/grid";
    }

    /**
     * 编辑审核权限状态
     *
     * @param model .
     */
    private void setOaMaterialStatus(Model model) {
        //填写状态
        model.addAttribute("STATUS_EDIT", OaQuarterplanSumStatus.STATUS_EDIT.getCode());
        //提交状态
        model.addAttribute("STATUS_SUBMIT", OaQuarterplanSumStatus.STATUS_SUBMIT.getCode());
        //审核通过状态
        model.addAttribute("STATUS_PASS", OaQuarterplanSumStatus.STATUS_PASS.getCode());
        //退回修改状态
        model.addAttribute("STATUS_BACK", OaQuarterplanSumStatus.STATUS_BACK.getCode());

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
            String hql = "from OaQuarterplanSum where 1=1 ";
            if (!StringHelper.isEmpty(year)) {
                hql += " and year=" + Integer.parseInt(year);
            }
            if (!StringHelper.isEmpty(period)) {
                hql += " and period=" + Integer.parseInt(period);
            }
            hql += " order by id desc";
            //增加自定义查询条件
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaQuarterplanSumService.findByPage(pageModel, queryTranslate.toString());
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
        String hql = "from OaQuarterplan where status=?";
        List<OaQuarterplan> list = oaQuarterplanService.findByQuery(hql, OaQuarterplanStatus.STATUS_PASS.getCode());

        Set<String> setOaQuarterplan = new HashSet<String>();
        for (OaQuarterplan oaQuarterplan : list) {
            Integer year = oaQuarterplan.getYear();
            Integer period = oaQuarterplan.getPeriod();
            String yearPeriod = year + "_" + period;
            if (!setOaQuarterplan.contains(yearPeriod)) {
                setOaQuarterplan.add(yearPeriod);
            }
        }
        //取出所有汇总过的年月
        List<OaQuarterplanSum> sumList = oaQuarterplanSumService.findAll();
        Set<String> setSum = new HashSet<String>();
        for (OaQuarterplanSum oaQuarterplanSum : sumList) {
            Integer year = oaQuarterplanSum.getYear();
            Integer period = oaQuarterplanSum.getPeriod();
            String yearPeriod = year + "_" + period;
            if (!setSum.contains(yearPeriod)) {
                setSum.add(yearPeriod);
            }
        }
        //将汇总过的年月从原来的年月中去除
        for (String s : setSum) {
            if (setOaQuarterplan.contains(s)) {
                setOaQuarterplan.remove(s);
            }
        }
        //获取年和月的下拉框
        String yearPeriodSelectOptions = getYearPeriodSelectOptions("", setOaQuarterplan);
        model.addAttribute("yearPeriodSelectOptions", yearPeriodSelectOptions);

        return "view/oa/oaQuarterplanSum/count";
    }

    /**
     * 获取没有汇总的年季度下拉框
     *
     * @param yearPeriod 。
     * @param set        。
     * @return 。
     */
    public String getYearPeriodSelectOptions(String yearPeriod, Set<String> set) {
        String options = "";
        for (String s : set) {
            String[] strings = s.split("_");
            if ("null".equals(strings[1])) {
                if (!StringHelper.isEmpty(yearPeriod)) {
                    if (s.equals(yearPeriod)) {
                        options += FormatUtils.format(JspHelper.SELECT_OPTION, s, strings[0] + "年度", "selected");
                    } else {
                        options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年度");
                    }
                } else {
                    options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年度");
                }
            }else if(JspHelper.getInteger(strings[1])>4) {
                if (!StringHelper.isEmpty(yearPeriod)) {
                    if (s.equals(yearPeriod)) {
                        if(JspHelper.getInteger(strings[1])==5){
                          options += FormatUtils.format(JspHelper.SELECT_OPTION, s, strings[0] + "年"+ "上半年度", "selected");
                        }else{
                          options += FormatUtils.format(JspHelper.SELECT_OPTION, s, strings[0] + "年"+ "下半年度", "selected");
                        }
                    } else {
                        if(JspHelper.getInteger(strings[1])==5){
                            options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年"+ "上半年度");
                        }else{
                            options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年"+ "下半年度");
                        }
                    }
                } else {
//                    options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年第" + strings[1] + "季度");
                    if(JspHelper.getInteger(strings[1])==5){
                        options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年"+ "上半年度");
                    }else{
                        options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年"+ "下半年度");
                    }
                }
            } else {
                if (!StringHelper.isEmpty(yearPeriod)) {
                    if (s.equals(yearPeriod)) {
                        options += FormatUtils.format(JspHelper.SELECT_OPTION, s, strings[0] + "年第" + strings[1] + "季度", "selected");
                    } else {
                        options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年第" + strings[1] + "季度");
                    }
                } else {
                    options += FormatUtils.format(JspHelper.SELECTOPTION, s, strings[0] + "年第" + strings[1] + "季度");
                }
            }

        }
        return options;
    }

    /**
     * 新增录入页面
     *
     * @param model      .
     * @param yearPeriod .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String yearPeriod) {
        String[] strings = yearPeriod.split("_");
        //将获取的年季度分离
        Integer year = Integer.parseInt(strings[0]);
        Integer period = null;
        if ("null".equals(strings[1])) {
            period = null;
        } else {
            period = Integer.parseInt(strings[1]);
        }
        OaQuarterplanSum oaQuarterplanSum = new OaQuarterplanSum();
        oaQuarterplanSum.setYear(year);
        oaQuarterplanSum.setPeriod(period);
        model.addAttribute("id", "");
        model.addAttribute("bean", oaQuarterplanSum);

        //获取对应年季度下的详细信息(未删除的信息)
        List<OaQuarterplan> oaQuarterplans = null;
        String hqlItem = "from OaQuarterplan where status = ? ";
        if (null == period) {
            hqlItem += " and year = ? and isSumDelete = 0";
            oaQuarterplans = oaQuarterplanService.findByQuery(hqlItem, OaQuarterplanStatus.STATUS_PASS.getCode(), year);
        } else {
            hqlItem += " and year = ? and period = ? and isSumDelete = 0";
            oaQuarterplans = oaQuarterplanService.findByQuery(hqlItem, OaQuarterplanStatus.STATUS_PASS.getCode(), year, period);
        }
        //拼接原来的内容
        String sumContent = "";
        for (OaQuarterplan oaQuarterplan : oaQuarterplans) {
            String content = JspHelper.FormatOutPutString(JspHelper.getString(oaQuarterplan.getContent()));  //必须处理换行
            if(!"".equals(sumContent)){
                sumContent += "<br><br>"+ content;
            }else{
                sumContent += content;
            }
        }
        String yearPeriodName = getYearPeriod(oaQuarterplanSum);
        model.addAttribute("yearPeriodName",yearPeriodName);
        model.addAttribute("sumContent", sumContent);
        model.addAttribute("oaQuarterplans", oaQuarterplans);


        setOaMaterialStatus(model);

        return "view/oa/oaQuarterplanSum/input";
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
        OaQuarterplanSum oaQuarterplanSum = oaQuarterplanSumService.get(id);
        model.addAttribute("id", id);
        model.addAttribute("bean", oaQuarterplanSum);
        String yearPeriodName = getYearPeriod(oaQuarterplanSum);
        model.addAttribute("yearPeriodName",yearPeriodName);
        setOaMaterialStatus(model);

        return "view/oa/oaQuarterplanSum/input";
    }

    /**
     * 审核操作
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String audit(Model model, Long id) {
        OaQuarterplanSum oaQuarterplanSum = oaQuarterplanSumService.get(id);
        model.addAttribute("bean", oaQuarterplanSum);
        String yearPeriodName = getYearPeriod(oaQuarterplanSum);
        model.addAttribute("yearPeriodName",yearPeriodName);
        setOaMaterialStatus(model);

        return "view/oa/oaQuarterplanSum/audit";
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
        OaQuarterplanSum oaQuarterplanSum = oaQuarterplanSumService.get(id);
        String yearPeriodName = getYearPeriod(oaQuarterplanSum);
        model.addAttribute("yearPeriodName",yearPeriodName);
        model.addAttribute("bean", oaQuarterplanSum);

        return "view/oa/oaQuarterplanSum/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaQuarterplanSum entity, HttpServletRequest request, Integer status) throws Exception {
        try {
            OaQuarterplanSum target;
            if (entity.getId() != null) {
                target = oaQuarterplanSumService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{

                });
            } else {
                target = entity;
            }
            //保存年和月
            String year = request.getParameter("year");
            target.setYear(Integer.valueOf(year));
            String period = request.getParameter("period");
            if (StringHelper.isEmpty(period)) {
                target.setPeriod(null);
            } else {
                target.setPeriod(Integer.valueOf(period));
            }
            target.setStatus(status);
            if (target.getStatus() == OaQuarterplanSumStatus.STATUS_SUBMIT.getCode()) {
                target.setReportDate(new Date(System.currentTimeMillis()));
            }
            //获取内容
            String sumContent = request.getParameter("content");
            target.setSumContent(sumContent);
            oaQuarterplanSumService.save(target);

            //保存从表
            saveOaQuarterplanSumItem(target, request);

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
     * @param oaQuarterplanSum .
     * @param request          .
     */
    private void saveOaQuarterplanSumItem(OaQuarterplanSum oaQuarterplanSum, HttpServletRequest request) {
        //先删除从表信息，在保存
        Set<OaQuarterplanSumItem> oaQuarterplanSumItems = oaQuarterplanSum.getOaQuarterplanSumItems();
        for (OaQuarterplanSumItem oaQuarterplanSumItem : oaQuarterplanSumItems) {
            oaQuarterplanSumItemService.delete(oaQuarterplanSumItem);
        }

        //获取页面传过来的值
        String[] itemIds = request.getParameterValues("itemId");   //隐藏域详细表中的ID
        if (itemIds != null) {
            for (int i = 0; i < itemIds.length; i++) {
                OaQuarterplanSumItem oaQuarterplanSumItem = new OaQuarterplanSumItem();
                oaQuarterplanSumItem.setQuarterplanSum(oaQuarterplanSum);
                OaQuarterplan oaQuarterplan = oaQuarterplanService.get(Long.valueOf(itemIds[i]));
                oaQuarterplanSumItem.setQuarterplanItem(oaQuarterplan);
                oaQuarterplanSumItem.setReportDept(oaQuarterplan.getReportDept());
                oaQuarterplanSumItem.setReportPerson(oaQuarterplan.getReportPerson());
                oaQuarterplanSumItem.setContent(oaQuarterplan.getContent());
                oaQuarterplanSumItemService.save(oaQuarterplanSumItem);
            }
        }

    }

    /**
     * 审核保存
     *
     * @param response 。
     * @param entity   。
     * @param status   。
     * @throws Exception 。
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void auditSave(HttpServletResponse response, @ModelAttribute("bean") OaQuarterplanSum entity, Integer status) throws Exception {
        try {
            OaQuarterplanSum target;
            if (entity.getId() != null) {
                target = oaQuarterplanSumService.get(entity.getId());
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

            oaQuarterplanSumService.save(target);

            //统一把部门设置为建管署
            if (target.getStatus() == OaMonthplanSumStatus.STATUS_PASS.getCode()) {
                Set<OaQuarterplanSumItem> oaQuarterplanSumItems = target.getOaQuarterplanSumItems();
                for (OaQuarterplanSumItem oaQuarterplanSumItem : oaQuarterplanSumItems) {
                    oaQuarterplanSumItem.setReportDept("建管署");
                    oaQuarterplanSumItemService.save(oaQuarterplanSumItem);
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
        OaQuarterplanSum oaQuarterplanSum = oaQuarterplanSumService.get(id);
        Set<OaQuarterplanSumItem> oaQuarterplanSumItems = oaQuarterplanSum.getOaQuarterplanSumItems();
        for (OaQuarterplanSumItem oaQuarterplanSumItem : oaQuarterplanSumItems) {
            oaQuarterplanSumItemService.delete(oaQuarterplanSumItem);
        }
        oaQuarterplanSumService.delete(oaQuarterplanSum);

        sendSuccessJSON(response, "删除成功");
    }
    /**
     * @param oaQuarterplanSum;
     *
     */
    public String getYearPeriod( OaQuarterplanSum oaQuarterplanSum){
        Integer year = oaQuarterplanSum.getYear();
        Integer period = oaQuarterplanSum.getPeriod();
        String yearPeriodName ="";
        String periodName="";
        if(null!=period){
            if(period<5){
               periodName = "第"+ period+"季度";
            }else if(period==5){
               periodName = "上半年度";
            }else{
               periodName = "下半年度";
            }
        }
        yearPeriodName = year+"年"+periodName;
        return yearPeriodName;
    }
}