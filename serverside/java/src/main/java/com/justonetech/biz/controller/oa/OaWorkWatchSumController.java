package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaWorkWatchService;
import com.justonetech.biz.daoservice.OaWorkWatchSumService;
import com.justonetech.biz.domain.OaWorkWatch;
import com.justonetech.biz.domain.OaWorkWatchSum;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * note:工作督办汇总
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaWorkWatchSumController extends BaseCRUDActionController<OaWorkWatchSum>
{
    private Logger logger = LoggerFactory.getLogger(OaWorkWatchSumController.class);

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
    private OaWorkWatchSumService oaWorkWatchSumService;

    @Autowired
    private OaWorkWatchService oaWorkWatchService;

    @Autowired
    private OaWorkWatchSum oaWorkWatchSum;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model)
    {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_WORK_WATCH_SUM));

        return "view/oa/oaWorkWatchSum/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session)
    {
        try
        {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaWorkWatchSum order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaWorkWatchSumService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e)
        {
            log.error("error", e);
            super.processException(response, e);
        }
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
        OaWorkWatchSum oaWorkWatchSum = oaWorkWatchSumService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaWorkWatchSum);

        return "view/oa/oaWorkWatchSum/input";
    }

    /**
     * 添加页面
     *
     * @param ids   .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String ids)
    {
        System.out.println("ids = " + ids);
        String[] oaWorkWatchIds = ids.split("\\,");

        ArrayList<OaWorkWatch> oaWorkWatches = new ArrayList<OaWorkWatch>();
        for (String oaWorkWatchId : oaWorkWatchIds)
        {
            OaWorkWatch oaWorkWatch = oaWorkWatchService.get(JspHelper.getLong(oaWorkWatchId));
            oaWorkWatches.add(oaWorkWatch);
        }
        model.addAttribute("oaWorkWatches", oaWorkWatches);

        //获取年和月的下拉框（为空为当前年月）
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(String.valueOf(c.get(Calendar.YEAR)));
        String monthSelectOptions = DateTimeHelper.getMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1));
        String weeksOfMonthSelectOptions = getWeeksOfMonthSelectOptions(String.valueOf(c.get(Calendar.MONTH) + 1), String.valueOf(c.get(Calendar.WEEK_OF_MONTH)));
        String daysOfMonthSelectOptions = getDaysOfMonthSelectOptions();
        model.addAttribute("yearOptions", yearSelectOptions);
        model.addAttribute("monthOptions", monthSelectOptions);
        model.addAttribute("weekOptions", weeksOfMonthSelectOptions);
        model.addAttribute("dayOptions", daysOfMonthSelectOptions);
        return "view/oa/oaWorkWatchSum/input";
    }

    /**
     * 获取指定月的周数
     *
     * @param month 。
     * @param week  。
     * @return 。
     */
    public String getWeeksOfMonthSelectOptions(String month, String week)
    {
        String options = "";
        for (int i = 1; i < 6; i++)
        {
            if (!StringHelper.isEmpty(month))
            {
                if (week.equals(String.valueOf(i)))
                {
                    options += FormatUtils.format(JspHelper.SELECT_OPTION, week, week, "selected");
                } else
                {
                    options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
                }
            } else
            {
                options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
            }
        }

        options = StringHelper.findAndReplace(options, "'", "\"");
        options = StringHelper.findAndReplace(options, "\n", "");

        return options;
    }

    /*
     *获取每个月的天数
     */
    public String getDaysOfMonthSelectOptions()
    {
        String options = "";
        for (int i = 1; i < 32; i++)
        {
            options += FormatUtils.format(JspHelper.SELECTOPTION, i, i);
        }
        options = StringHelper.findAndReplace(options, "'", "\"");
        options = StringHelper.findAndReplace(options, "\n", "");
        return options;
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaWorkWatchSum entity, HttpServletRequest request) throws Exception
    {
        try
        {
            OaWorkWatchSum target;
            if (entity.getId() != null)
            {
                target = oaWorkWatchSumService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "year",
                        "month",
                        "week",
                        "beginDate",
                        "endDate",
                        "createTime",
                        "createUser",
                        "updateTime",
                        "updateUser"
                });

            } else
            {
                target = entity;
            }
            oaWorkWatchSumService.save(target);

        } catch (Exception e)
        {
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
    public void delete(HttpServletResponse response, Long id) throws Exception
    {
        oaWorkWatchSumService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}