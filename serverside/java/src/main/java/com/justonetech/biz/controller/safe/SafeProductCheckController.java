package com.justonetech.biz.controller.safe;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SafeProductCheckItemService;
import com.justonetech.biz.daoservice.SafeProductCheckService;
import com.justonetech.biz.daoservice.SafeProductStandardService;
import com.justonetech.biz.domain.SafeProductCheck;
import com.justonetech.biz.domain.SafeProductCheckItem;
import com.justonetech.biz.domain.SafeProductStandard;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.SafeProductCheckManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCode;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONArray;
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
 * note:安全生产季度考核
 * author: guoqiong
 * modify date: 2014-6-9
 */
@Controller
public class SafeProductCheckController extends BaseCRUDActionController<SafeProductCheck> {
    private Logger logger = LoggerFactory.getLogger(SafeProductCheckController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SafeProductCheckService safeProductCheckService;

    @Autowired
    private SafeProductCheckItemService safeProductCheckItemService;

    @Autowired
    private SafeProductCheckManager safeProductCheckManager;

    @Autowired
    private SafeProductStandardService safeProductStandardService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SAFE_PRODUCT_CHECK_EDIT));
        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String currentQuarter = safeProductCheckManager.getCurrentQuarter();
        String quarterSelectOptions = DateTimeHelper.getQuarterSelectOptions(currentQuarter);
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("quarterOptions", quarterSelectOptions);

        return "view/safe/safeProductCheck/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, HttpServletRequest request) {
        try {
            String year = request.getParameter("gridYear");
            String quarter = request.getParameter("gridQuarter");

            Page pageModel = new Page(page, rows, true);
            String hql = "from SafeProductCheck where 1=1 ";
            if (!StringHelper.isEmpty(year)) {
                hql += " and year=" + Integer.parseInt(year);
            }
            if (!StringHelper.isEmpty(quarter)) {
                hql += " and quarter=" + Integer.parseInt(quarter);
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = safeProductCheckService.findByPage(pageModel, query);

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
        Calendar c = Calendar.getInstance();
        model.addAttribute("yearOptions", DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR))));
        model.addAttribute("quarterOptions", DateTimeHelper.getQuarterSelectOptions(safeProductCheckManager.getCurrentQuarter()));

        return "view/safe/safeProductCheck/count";
    }

    /**
     * 判断所选年月是否存在
     *
     * @param model   。
     * @param year    。
     * @param quarter 。
     * @return 。
     */
    @RequestMapping
    public String checkYearQuarter(Model model, String year, String quarter) {
        //查询所选年月是否已经存在
        String hql = "from SafeProductCheck where 1=1";
        if (!StringHelper.isEmpty(year)) {
            hql += " and year=?";
        }
        if (!StringHelper.isEmpty(quarter)) {
            hql += " and quarter=?";
        }
        List<SafeProductCheck> checkList = safeProductCheckService.findByQuery(hql, Integer.parseInt(year), Integer.parseInt(quarter));
        if (checkList.size() > 0) {
            model.addAttribute("msg", "{success:'true'}");
        } else {
            model.addAttribute("msg", "{success:'false'}");
        }

        return "common/msg";
    }

    /**
     * 通过gdCode编号获取工地信息
     *
     * @param gdCode .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String getGdInfo(String gdCode, Model model) {
        String json = "";
        ShareGdInfo gdInfo = projectManager.getGDInfo(gdCode);
        if (null != gdInfo) {
            Map<String, Object> retMap = new HashMap<String, Object>();
            retMap.put("gdName", gdInfo.getGdName());
            retMap.put("gdCode", gdInfo.getGdCode());
            retMap.put("sgdwmc", gdInfo.getSgTotalUnitName());
            retMap.put("jldwmc", gdInfo.getJlUnitName());
            JSONArray jsonArray = JSONArray.fromObject(retMap);
            json = jsonArray.toString();
        }
        model.addAttribute("msg", json);

        return "common/msg";
    }

    /**
     * 新增录入页面
     *
     * @param model   .
     * @param year    .
     * @param quarter .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String year, String quarter) {
        SafeProductCheck safeProductCheck = new SafeProductCheck();
        //新增所选考核季度的数据
        safeProductCheck.setYear(Integer.valueOf(year));
        safeProductCheck.setQuarter(Integer.valueOf(quarter));
        //获取考核标准
        List<Map<String, Object>> mapList = safeProductCheckManager.getSafeProductStandardMap(safeProductCheck, model);
        model.addAttribute("mapList", mapList);
        SysCode code = sysCodeManager.getCodeByCode(Constants.SAFE_PRODUCT_CHECK_LEVEL);
        Set<SysCodeDetail> sysCodeDetails = code.getSysCodeDetails();
        Map<Long, String> levelMap = new HashMap<Long, String>();
        for (SysCodeDetail detail : sysCodeDetails) {
            levelMap.put(detail.getId(), detail.getName());
        }
        model.addAttribute("levelMap", levelMap);
        model.addAttribute("bean", safeProductCheck);
        model.addAttribute("year", safeProductCheck.getYear());
        model.addAttribute("quarter", safeProductCheck.getQuarter());
        model.addAttribute("sjajz", configManager.getJdDeptName());
        model.addAttribute("bean", safeProductCheck);

        return "view/safe/safeProductCheck/input";
    }


    /**
     * 修改显示页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        SafeProductCheck safeProductCheck = safeProductCheckService.get(id);
        //获取考核标准
        List<Map<String, Object>> mapList = safeProductCheckManager.getSafeProductStandardMap(safeProductCheck, model);
        model.addAttribute("mapList", mapList);
        model.addAttribute("title", "修改安全生产季度考核");
        //处理其他业务逻辑
        model.addAttribute("quarterName", safeProductCheck.getYear() + "年第" + safeProductCheck.getQuarter() + "季度");
        SysCode code = sysCodeManager.getCodeByCode(Constants.SAFE_PRODUCT_CHECK_LEVEL);
        Set<SysCodeDetail> sysCodeDetails = code.getSysCodeDetails();
        Map<Long, String> levelMap = new HashMap<Long, String>();
        for (SysCodeDetail detail : sysCodeDetails) {
            levelMap.put(detail.getId(), detail.getName());
        }
        model.addAttribute("levelMap", levelMap);
        model.addAttribute("bean", safeProductCheck);
        model.addAttribute("year", safeProductCheck.getYear());
        model.addAttribute("quarter", safeProductCheck.getQuarter());
        model.addAttribute("sjajz", configManager.getJdDeptName());

        return "view/safe/safeProductCheck/input";
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
        SafeProductCheck safeProductCheck = safeProductCheckService.get(id);
        //获取考核标准
        List<Map<String, Object>> mapList = safeProductCheckManager.getSafeProductStandardMap(safeProductCheck, model);
        model.addAttribute("mapList", mapList);
        model.addAttribute("sjajz", configManager.getJdDeptName());
        model.addAttribute("bean", safeProductCheck);

        return "view/safe/safeProductCheck/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SafeProductCheck entity, HttpServletRequest request) throws Exception {
        try {
            SafeProductCheck target;
            if (entity.getId() != null) {
                target = safeProductCheckService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "gdCode",
                        "projectName",
                        "sgdwmc",
                        "jldwmc",
                        "year",
                        "quarter",
                        "totalScore",
                        "content",
                        "reformNum",
                        "stopformNum",
                        "punishNum",
                        "otherNum",
                        "planCheckNum",
                        "actualCheckNum",
                        "description",
                });
            } else {
                target = entity;
            }
            //获取季度综合确认等级
            String levelId = request.getParameter("levelId");
            SysCodeDetail codeDetail = sysCodeManager.getCodeListById(Long.valueOf(levelId));
            target.setLevelId(codeDetail);
            target.setLevelDesc(codeDetail.getName());
            safeProductCheckService.save(target);

            //保存明细
            String[] standIds = request.getParameterValues("standIds");
            if (null != standIds && standIds.length > 0) {
                for (int i = 0; i < standIds.length; i++) {
                    SafeProductStandard standard = safeProductStandardService.get(Long.valueOf(standIds[i]));
                    String score = request.getParameter("score" + standIds[i]);
                    SafeProductCheckItem checkItem = safeProductCheckManager.getSafeProductCheckItem(target, standard);
                    if (null == checkItem) {
                        checkItem = new SafeProductCheckItem();
                        checkItem.setProductStandard(standard);
                        checkItem.setProductCheck(target);
                        checkItem.setScore(Integer.valueOf(score));
                    } else {
                        checkItem.setScore(Integer.valueOf(score));
                    }
                    safeProductCheckItemService.save(checkItem);
                }
            }
            //保存明细的外层数据
            String[] standParentIds = request.getParameterValues("standParentIds");
            if (null != standParentIds && standParentIds.length > 0) {
                for (int i = 0; i < standParentIds.length; i++) {
                    String parentId = standParentIds[i];
                    SafeProductStandard standardParent = safeProductStandardService.get(Long.valueOf(parentId));
                    String score = request.getParameter("score" + parentId);
                    SafeProductCheckItem checkItem = safeProductCheckManager.getSafeProductCheckItem(target, standardParent);
                    if (null == checkItem) {
                        checkItem = new SafeProductCheckItem();
                        checkItem.setProductStandard(standardParent);
                        checkItem.setProductCheck(target);
                        checkItem.setScore(Integer.valueOf(score));
                    } else {
                        checkItem.setScore(Integer.valueOf(score));
                    }
                    safeProductCheckItemService.save(checkItem);
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
        SafeProductCheck safeProductCheck = safeProductCheckService.get(id);
        Set<SafeProductCheckItem> safeProductCheckItems = safeProductCheck.getSafeProductCheckItems();
        if (safeProductCheckItems != null) {
            for (SafeProductCheckItem safeProductCheckItem : safeProductCheckItems) {
                safeProductCheckItemService.delete(safeProductCheckItem);
            }
        }
        safeProductCheckService.delete(safeProductCheck);

        sendSuccessJSON(response, "删除成功");
    }

}