package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ProjExtendCostService;
import com.justonetech.biz.daoservice.ProjExtendService;
import com.justonetech.biz.daoservice.ProjInfoService;
import com.justonetech.biz.domain.ProjExtend;
import com.justonetech.biz.domain.ProjExtendCost;
import com.justonetech.biz.manager.ProjectRelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjExtendCostType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
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
 * note:项目投资情况
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjExtendCostController extends BaseCRUDActionController<ProjExtendCost> {
    private Logger logger = LoggerFactory.getLogger(ProjExtendCostController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjExtendCostService projExtendCostService;

    @Autowired
    private ProjExtendService projExtendService;

    @Autowired
    private ProjectRelateManager projectRelateManager;

    @Autowired
    private ProjInfoService projInfoService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));

        return "view/project/projExtendCost/grid";
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
            String hql = "from ProjExtendCost order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projExtendCostService.findByPage(pageModel, query);

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
        ProjExtendCost projExtendCost = new ProjExtendCost();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", projExtendCost);

        return "view/project/projExtendCost/input";
    }

    /**
     * 修改显示页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long projectId) {
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);
        if (null == projExtend) {
            projExtend = new ProjExtend();
            projExtend.setProject(projInfoService.get(projectId));
        } else {
            //投资的数据
            List<ProjExtendCost> listType1 = getCostByType(ProjExtendCostType.EXTEND_TYPE_1.getCode(), projExtend.getId());
            List<ProjExtendCost> listType2 = getCostByType(ProjExtendCostType.EXTEND_TYPE_2.getCode(), projExtend.getId());
            List<ProjExtendCost> listType3 = getCostByType(ProjExtendCostType.EXTEND_TYPE_3.getCode(), projExtend.getId());
            List<ProjExtendCost> listType4 = getCostByType(ProjExtendCostType.EXTEND_TYPE_4.getCode(), projExtend.getId());
            model.addAttribute("listType1", listType1);
            model.addAttribute("listType2", listType2);
            model.addAttribute("listType3", listType3);
            model.addAttribute("listType4", listType4);
        }
        model.addAttribute("bean", projExtend);
        Calendar c = Calendar.getInstance();
        model.addAttribute("curYear", c.get(Calendar.YEAR));
        model.addAttribute("curMonth", c.get(Calendar.MONTH) + 1);
        pushType(model);

        return "view/project/projExtendCost/input";
    }

    /**
     * 查看页面
     *
     * @param projectId .
     * @param model     .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long projectId) {
        ProjExtend projExtend = projectRelateManager.getProjExtend(projectId);

        if (null == projExtend) {
            projExtend = new ProjExtend();
            projExtend.setProject(projInfoService.get(projectId));
        } else {
            //投资的数据
            List<ProjExtendCost> listType1 = getCostByType(ProjExtendCostType.EXTEND_TYPE_1.getCode(), projExtend.getId());
            List<ProjExtendCost> listType2 = getCostByType(ProjExtendCostType.EXTEND_TYPE_2.getCode(), projExtend.getId());
            List<ProjExtendCost> listType3 = getCostByType(ProjExtendCostType.EXTEND_TYPE_3.getCode(), projExtend.getId());
            List<ProjExtendCost> listType4 = getCostByType(ProjExtendCostType.EXTEND_TYPE_4.getCode(), projExtend.getId());
            model.addAttribute("listType1", listType1);
            model.addAttribute("listType2", listType2);
            model.addAttribute("listType3", listType3);
            model.addAttribute("listType4", listType4);
        }
        model.addAttribute("bean", projExtend);

        return "view/project/projExtendCost/view";
    }

    /**
     * 判断数据是否存在
     *
     * @param model 。
     * @param type  。
     * @param year  。
     * @param month 。
     * @param half  。
     * @return 。
     */
    @RequestMapping
    public String checkData(Model model, String type, String year, String month, String half, Long extendId) {
        String msg;
        //根据年月查询是否已经存在
        String hql = "from ProjExtendCost where 1=1 and projExtend.id=" + extendId + " and year=" + JspHelper.getInteger(year) + " and type='" + type + "'";
        if (!StringHelper.isEmpty(half)) {
            hql += " and half='" + half + "'";
        }
        if (!StringHelper.isEmpty(month)) {
            hql += " and month=" + JspHelper.getInteger(month);
        }
        List<ProjExtendCost> list = projExtendCostService.findByQuery(hql);
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != list && list.size() > 0) {
            map.put("title", list.iterator().next().getTitle());
            map.put("size", list.size());
            map.put("success", true);
        } else {
            map.put("size", 0);
            map.put("success", false);
        }
        msg = JSONObject.fromObject(map).toString();
        model.addAttribute("msg", msg);

        return "common/msg";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjExtend entity, HttpServletRequest request) throws Exception {
        try {
            ProjExtend target;
            if (entity.getId() != null) {
                target = projExtendService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "project",
                        "gctxGkpfTotal",
                        "gctxCspfTotal",
                        "gctxSourceFund"
                });
            } else {
                target = entity;
            }
            projExtendService.save(target);
            //先删除，在保存
            Set<ProjExtendCost> projExtendCosts = target.getProjExtendCosts();
            for (ProjExtendCost cost : projExtendCosts) {
                projExtendCostService.delete(cost);
            }
            //历年累计完成投资
            String[] accIndexs = request.getParameterValues("index" + ProjExtendCostType.EXTEND_TYPE_1.getCode());
            if (null != accIndexs && accIndexs.length > 0) {
                for (String accIndex : accIndexs) {
                    String accTime = request.getParameter("time" + ProjExtendCostType.EXTEND_TYPE_1.getCode() + accIndex);
                    String accYear = request.getParameter("year" + ProjExtendCostType.EXTEND_TYPE_1.getCode() + accIndex);
                    String accCost = request.getParameter("cost" + ProjExtendCostType.EXTEND_TYPE_1.getCode() + accIndex);
                    ProjExtendCost projExtendCost = new ProjExtendCost();
                    projExtendCost.setProjExtend(target);
                    projExtendCost.setType(ProjExtendCostType.EXTEND_TYPE_1.getCode());
                    if (!StringHelper.isEmpty(accTime)) {
                        projExtendCost.setTitle(accTime);
                    }
                    if (!StringHelper.isEmpty(accYear)) {
                        projExtendCost.setYear(Integer.valueOf(accYear));
                    }
                    if (!StringHelper.isEmpty(accCost)) {
                        projExtendCost.setAccComplete(Double.valueOf(accCost));
                    }
                    projExtendCostService.save(projExtendCost);
                }
            }
            //年度计划投资
            String[] yearPlanIndexs = request.getParameterValues("index" + ProjExtendCostType.EXTEND_TYPE_2.getCode());
            if (null != yearPlanIndexs && yearPlanIndexs.length > 0) {
                for (String yearPlanIndex : yearPlanIndexs) {
                    String yearPlanTime = request.getParameter("time" + ProjExtendCostType.EXTEND_TYPE_2.getCode() + yearPlanIndex);
                    String yearPlanYear = request.getParameter("year" + ProjExtendCostType.EXTEND_TYPE_2.getCode() + yearPlanIndex);
                    String yearPlanCost = request.getParameter("cost" + ProjExtendCostType.EXTEND_TYPE_2.getCode() + yearPlanIndex);
                    ProjExtendCost projExtendCost = new ProjExtendCost();
                    projExtendCost.setProjExtend(target);
                    projExtendCost.setType(ProjExtendCostType.EXTEND_TYPE_2.getCode());
                    if (!StringHelper.isEmpty(yearPlanTime)) {
                        projExtendCost.setTitle(yearPlanTime);
                    }
                    if (!StringHelper.isEmpty(yearPlanYear)) {
                        projExtendCost.setYear(Integer.valueOf(yearPlanYear));
                    }
                    if (!StringHelper.isEmpty(yearPlanCost)) {
                        projExtendCost.setAccComplete(Double.valueOf(yearPlanCost));
                    }
                    projExtendCostService.save(projExtendCost);
                }
            }
            //当年累计完成投资
            String[] yearAccIndexs = request.getParameterValues("index" + ProjExtendCostType.EXTEND_TYPE_3.getCode());
            if (null != yearAccIndexs && yearAccIndexs.length > 0) {
                for (String yearAccIndex : yearAccIndexs) {
                    String yearAccTime = request.getParameter("time" + ProjExtendCostType.EXTEND_TYPE_3.getCode() + yearAccIndex);
                    String yearAccYear = request.getParameter("year" + ProjExtendCostType.EXTEND_TYPE_3.getCode() + yearAccIndex);
                    String yearAccHalf = request.getParameter("half" + ProjExtendCostType.EXTEND_TYPE_3.getCode() + yearAccIndex);
                    String yearAccCost = request.getParameter("cost" + ProjExtendCostType.EXTEND_TYPE_3.getCode() + yearAccIndex);
                    ProjExtendCost projExtendCost = new ProjExtendCost();
                    projExtendCost.setProjExtend(target);
                    projExtendCost.setType(ProjExtendCostType.EXTEND_TYPE_3.getCode());
                    if (!StringHelper.isEmpty(yearAccTime)) {
                        projExtendCost.setTitle(yearAccTime);
                    }
                    if (!StringHelper.isEmpty(yearAccYear)) {
                        projExtendCost.setYear(Integer.valueOf(yearAccYear));
                    }
                    if (!StringHelper.isEmpty(yearAccHalf)) {
                        projExtendCost.setHalf(yearAccHalf);
                    }
                    if (!StringHelper.isEmpty(yearAccCost)) {
                        projExtendCost.setAccComplete(Double.valueOf(yearAccCost));
                    }
                    projExtendCostService.save(projExtendCost);
                }
            }
            //财政资金
            String[] czIndexs = request.getParameterValues("index" + ProjExtendCostType.EXTEND_TYPE_4.getCode());
            if (null != czIndexs && czIndexs.length > 0) {
                for (String czIndex : czIndexs) {
                    String czTime = request.getParameter("time" + ProjExtendCostType.EXTEND_TYPE_4.getCode() + czIndex);
                    String czYear = request.getParameter("year" + ProjExtendCostType.EXTEND_TYPE_4.getCode() + czIndex);
                    String czMonth = request.getParameter("month" + ProjExtendCostType.EXTEND_TYPE_4.getCode() + czIndex);
                    String czCostYbf = request.getParameter("czCostYbf" + ProjExtendCostType.EXTEND_TYPE_4.getCode() + czIndex);
                    String czCostYwc = request.getParameter("czCostYwc" + ProjExtendCostType.EXTEND_TYPE_4.getCode() + czIndex);
                    ProjExtendCost projExtendCost = new ProjExtendCost();
                    projExtendCost.setProjExtend(target);
                    projExtendCost.setType(ProjExtendCostType.EXTEND_TYPE_4.getCode());
                    if (!StringHelper.isEmpty(czTime)) {
                        projExtendCost.setTitle(czTime);
                    }
                    if (!StringHelper.isEmpty(czYear)) {
                        projExtendCost.setYear(Integer.valueOf(czYear));
                    }
                    if (!StringHelper.isEmpty(czMonth)) {
                        projExtendCost.setMonth(Integer.valueOf(czMonth));
                    }
                    if (!StringHelper.isEmpty(czCostYbf)) {
                        projExtendCost.setCzzjYbf(Double.valueOf(czCostYbf));
                    }
                    if (!StringHelper.isEmpty(czCostYwc)) {
                        projExtendCost.setCzzjYwc(Double.valueOf(czCostYwc));
                    }
                    projExtendCostService.save(projExtendCost);
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
     * 投资类型
     *
     * @param model ，
     */
    private void pushType(Model model) {
        model.addAttribute("TYPE1", ProjExtendCostType.EXTEND_TYPE_1.getCode());
        model.addAttribute("TYPE2", ProjExtendCostType.EXTEND_TYPE_2.getCode());
        model.addAttribute("TYPE3", ProjExtendCostType.EXTEND_TYPE_3.getCode());
        model.addAttribute("TYPE4", ProjExtendCostType.EXTEND_TYPE_4.getCode());
    }

    /**
     * 根据类型和项目扩展表获取数据
     *
     * @param type     。
     * @param extendId 。
     * @return 。
     */
    public List<ProjExtendCost> getCostByType(String type, Long extendId) {
        String hql = "from ProjExtendCost where projExtend.id=? and type=? order by year asc,month asc,half desc";
        return projExtendCostService.findByQuery(hql, extendId, type);
    }

}