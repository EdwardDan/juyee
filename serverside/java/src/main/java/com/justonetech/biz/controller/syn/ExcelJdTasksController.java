package com.justonetech.biz.controller.syn;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ExcelJdTasksManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:Excel导入监督任务书
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ExcelJdTasksController extends BaseCRUDActionController<ExcelJdTasks> {
    private Logger logger = LoggerFactory.getLogger(ExcelJdTasksController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYN_EXCEL_JD_TASKS_EDIT));

        return "view/syn/excelJdTasks/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ExcelJdTasks order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = excelJdTasksService.findByPage(pageModel, queryTranslate.toString());

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
    public String add(Model model, String jdTasksCode) {
        model.addAttribute("jdTasksCode", jdTasksCode);
        return "view/syn/excelJdTasks/add";
    }

    /**
     * tab显示添加页面
     *
     * @return .
     */
    @RequestMapping
    public String frame() {

        return "view/syn/excelJdTasks/frame";
    }

    /**
     * 判断输入的监督任务书编号是否可以获取到信息
     *
     * @param jdTasksCode .
     */
    @RequestMapping
    public String inputJdTasksCheck(Model model, String jdTasksCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("msg", "");
        try {
            ExcelJdTasks excelJdTasks = excelJdTasksManager.getExcelJdTasksByWebservice(jdTasksCode, null);
            if (excelJdTasks == null || null == excelJdTasks.getBjbh() || "".equals(excelJdTasks.getBjbh())) {
                map.put("success", false);
                map.put("msg", "未找到指定编号的监督任务书信息，请重新输入！");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", "获取数据失败！");
        }
        model.addAttribute("msg", JSONObject.fromObject(map).toString());
        return "common/msg";
    }

    /**
     * 新增监督任务书录入页面
     *
     * @param jdTasksCode .
     * @param model       .       .
     * @return .
     */
    @RequestMapping
    public String inputJdTasks(Model model, String jdTasksCode, String reportType) {
        //根据监督任务书编号查找监督任务书信息
        ExcelJdTasks excelJdTasks = excelJdTasksManager.getExcelJdTasksByWebservice(jdTasksCode, reportType);

        //项目类型选择
        model.addAttribute("EXCEL_JDTASK_OTHER1", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER1));
        excelJdTasks.setJdTaskCode(jdTasksCode);

        model.addAttribute("bean", excelJdTasks);
        model.addAttribute("jdTasksCode", jdTasksCode);

        return "view/syn/excelJdTasks/inputJdTasks";
    }

    /**
     * 新增单位工程录入页面
     *
     * @param jdTasksCode .
     * @param model       .       .
     * @return .
     */
    @RequestMapping
    public String inputDwgc(Model model, String jdTasksCode, String reportType) {
        //根据监督任务书编号查找单位工程信息
        List<ExcelJdDwgc> excelJdDwgcList = excelJdTasksManager.getExcelJdDwgcs(jdTasksCode);
        Map<String, ExcelJdDwgc> map = new HashMap<String, ExcelJdDwgc>();
        for (ExcelJdDwgc excelJdDwgc : excelJdDwgcList) {
            map.put(excelJdDwgc.getDwgcCode(), excelJdDwgc);
        }
        List<ExcelJdDwgc> jdDwgcList = excelJdTasksManager.getExcelJdDwgcsByWebservice(jdTasksCode, map);
        model.addAttribute("list", jdDwgcList);

        //获取报监日期
        ExcelJdTasks excelJdTasks = excelJdTasksManager.getExcelJdTasksByWebservice(jdTasksCode, reportType);

        model.addAttribute("year", DateTimeHelper.formatTimestamp(excelJdTasks.getJdDatetime(), "YYYY"));
        model.addAttribute("projectArea", configManager.getProjectArea());
        model.addAttribute("reportType", reportType);
        model.addAttribute("jdTasksCode", jdTasksCode);

        return "view/syn/excelJdTasks/inputDwgc";
    }

    /**
     * 保存添加监督任务书操作
     *
     * @param response .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void inputSave(HttpServletResponse response, HttpServletRequest request, String reportType, String jdTasksCode) throws Exception {
        //保存监督任务书信息
        ExcelJdTasks excelJdTasks = excelJdTasksManager.getExcelJdTasksByWebservice(jdTasksCode, reportType);
        excelJdTasks.setReportType(reportType);
        excelJdTasks.setJdTaskCode(jdTasksCode);
        excelJdTasksService.save(excelJdTasks);

        //获取已有单位工程信息
        List<ExcelJdDwgc> excelJdDwgcList = excelJdTasksManager.getExcelJdDwgcs(jdTasksCode);
        Map<String, ExcelJdDwgc> map = new HashMap<String, ExcelJdDwgc>();
        for (ExcelJdDwgc excelJdDwgc : excelJdDwgcList) {
            String dwgcbh = excelJdDwgc.getDwgcCode();
            map.put(dwgcbh, excelJdDwgc);
        }

        //保存单位工程信息
        List<ExcelJdDwgc> jdDwgcList = excelJdTasksManager.getExcelJdDwgcsByWebservice(jdTasksCode, map);
        for (ExcelJdDwgc excelJdDwgc : jdDwgcList) {
            excelJdDwgc.setCustomCode(request.getParameter("customCode_" + excelJdDwgc.getDwgcCode()));
            excelJdDwgcService.save(excelJdDwgc);
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 查看页面--tab入口
     *
     * @param id    .    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        model.addAttribute("id", id);
        return "view/syn/excelJdTasks/view";
    }


    /**
     * 查看监督任务书
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String viewTask(Model model, Long id) {
        model.addAttribute("bean", excelJdTasksService.get(id));

        return "view/syn/excelJdTasks/viewTask";
    }

    /**
     * 查看单位工程
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String viewDwgc(Model model, Long id) {
        //单位工程信息
        model.addAttribute("projectArea", configManager.getProjectArea());

        model.addAttribute("list", excelJdTasksManager.getExcelJdDwgcs(id));

        return "view/syn/excelJdTasks/viewDwgc";
    }

    /**
     * 编辑页面--tab入口
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        model.addAttribute("id", id);
        return "view/syn/excelJdTasks/modify";
    }

    /**
     * 编辑监督任务书信息
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyTask(Model model, Long id) {
        model.addAttribute("bean", excelJdTasksService.get(id));
        model.addAttribute("EXCEL_JDTASK_OTHER1", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER1));
        return "view/syn/excelJdTasks/modifyTask";
    }

    /**
     * 保存编辑监督任务书操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void modifyTaskSave(HttpServletResponse response, @ModelAttribute("bean") ExcelJdTasks entity) throws Exception {
        try {
            ExcelJdTasks target;
            if (entity.getId() != null) {
                target = excelJdTasksService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "jdDatetime",
                        "jdTaskCode",
                        "reportType",
                        "bjbh",
                        "bid",
                        "projectName",
                        "projectAdd",
                        "belongArea",
                        "contMoney",
                        "jsUnitName",
                        "jsUnitAdd",
                        "zipcode",
                        "jsLinkman",
                        "jsPhone",
                        "sgzbUnitName",
                        "sgzbLinkman",
                        "sgzbPhone",
                        "kcUnitName",
                        "kcLinkman",
                        "kcPhone",
                        "sjUnitName",
                        "sjLinkman",
                        "sjPhone",
                        "jlUnitName",
                        "jlLinkman",
                        "jlPhone",
                        "sgUnitName",
                        "sgLinkman",
                        "sgPhone",
                        "jagzl",
                        "buildArea",
                        "dtsl"
                });
            } else {
                target = entity;
            }
            excelJdTasksService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 编辑单位工程信息
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modifyDwgc(Model model, Long id) {
        ExcelJdTasks excelJdTasks = excelJdTasksService.get(id);

        //获取报监年份
        model.addAttribute("year", DateTimeHelper.formatTimestamp(excelJdTasks.getJdDatetime(), "YYYY"));
        model.addAttribute("reportType", excelJdTasks.getReportType());
        model.addAttribute("projectArea", configManager.getProjectArea());
        model.addAttribute("list", excelJdTasksManager.getExcelJdDwgcs(id));

        return "view/syn/excelJdTasks/modifyDwgc";
    }

    /**
     * 保存编辑单位工程操作
     *
     * @param response .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void modifyDwgcSave(HttpServletResponse response, HttpServletRequest request, String reportType, String jdTaskCode) throws Exception {
        String[] dwgcIdses = request.getParameterValues("dwgcIds");
        String[] dwgcCodes = request.getParameterValues("dwgcCode");//单位工程编号
        String[] projectTypes = request.getParameterValues("projectType"); //工程类型
        String[] dwgcAreas = request.getParameterValues("dwgcArea"); //建筑面积
        String[] upCses = request.getParameterValues("upCs");//地上层数
        String[] downCses = request.getParameterValues("downCs");//地下层数
        String[] tses = request.getParameterValues("ts"); //电梯层数
        String[] dwgcMoneys = request.getParameterValues("dwgcMoney"); //造价
        String[] structTypes = request.getParameterValues("structType"); //结构类型
        for (int i = 0; i < dwgcIdses.length; i++) {
            ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(Long.parseLong(dwgcIdses[i]));
            excelJdDwgc.setDwgcCode(dwgcCodes[i]);
            excelJdDwgc.setCustomCode(request.getParameter("customCode_" + dwgcCodes[i]));   //虹口区单位工程编号
            excelJdDwgc.setProjectType(projectTypes[i]);
            excelJdDwgc.setDwgcArea(JspHelper.getDouble(dwgcAreas[i]));
            excelJdDwgc.setUpCs(upCses[i]);
            excelJdDwgc.setDownCs(downCses[i]);
            excelJdDwgc.setTs(tses[i]);
            excelJdDwgc.setDwgcMoney(JspHelper.getDouble(dwgcMoneys[i]));
            excelJdDwgc.setStructType(structTypes[i]);

            excelJdDwgcService.save(excelJdDwgc);
        }
        //根据监督任务书编号获取监督任务书信息
        if(reportType!=null){
            ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
            excelJdTasks.setReportType(reportType);
            excelJdTasksService.save(excelJdTasks);
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 根据监督任务书编号自动生成单位工程编号
     *
     * @param jdTaskCode .
     * @param reportType .
     * @param year       .
     * @param count      .
     * @return .
     */
    @RequestMapping
    public String getCustomCode(Model model, String jdTaskCode, String reportType, String year, int count) {
        Map<String, String> codeNameMap = new HashMap<String, String>();
//        List<String> sa = new ArrayList<String>();
        String type = "";
        if (reportType.equals("装饰")) {
            type = "装";
        } else if (reportType.equals("新建")) {
            type = "新";
        } else if (reportType.equals("市政")) {
            type = "市";
        }
        String prefix = year + type + "-";
        int countMax = getCodeCount(prefix);
        for (int i = 0; i < count; i++) {
            countMax++;
            String v = prefix + StringHelper.leftPad(JspHelper.getString(countMax), 3, "0");
            codeNameMap.put(String.valueOf(countMax), v);
//            sa.add(v);
        }
        String string = JSONObject.fromObject(codeNameMap).toString();
        if (codeNameMap.size() > 0) {
            model.addAttribute("msg", string);
        } else {
            model.addAttribute("msg", "");
        }
        return "common/msg";
    }

    /**
     * 生成编号
     *
     * @return .
     */
    private int getCodeCount(String prefix) {
        int count = 0;
        String sql = "select max(t.custom_code) as maxCode from excel_jd_dwgc t where t.custom_code like '{0}%'";
        sql = FormatUtils.format(sql, prefix);
        String maxCode = simpleQueryManager.getStringBySql(sql);
        if (!StringHelper.isEmpty(maxCode)) {
//            count = Integer.parseInt(maxCode.substring(maxCode.indexOf("-")));
            String[] split = StringUtils.split(maxCode, "-");
            count = JspHelper.getInteger(split[1]);
        }
        return count;
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
        ExcelJdTasks excelJdTasks = excelJdTasksService.get(id);
        //先删除单位工程信息
        List<ExcelJdDwgc> list = excelJdTasksManager.getExcelJdDwgcs(id);
        for (ExcelJdDwgc excelJdDwgc : list) {
            excelJdDwgcService.delete(excelJdDwgc);
        }
        excelJdTasksService.delete(excelJdTasks);

        sendSuccessJSON(response, "删除成功");
    }
}