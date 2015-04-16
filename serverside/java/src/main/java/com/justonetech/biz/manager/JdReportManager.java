package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.JdReportService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.JdReport;
import com.justonetech.biz.domain.JdReportDwgc;
import com.justonetech.biz.domain.ShareProDwgcMonitor;
import com.justonetech.biz.domain.bean.jdReport.JdReportContent;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysCodeManager;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.*;

/**
 * 监督报告业务逻辑类
 * User: Chen Junping
 * Date: 12-5-21
 */
@Service
public class JdReportManager {
    private Logger logger = LoggerFactory.getLogger(JdReportManager.class);

    private static String checkbox = "&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"{0}\" value=\"{1}\" {2}/>{1}";
    private static String checkboxValue = "&nbsp;&nbsp;&nbsp;&nbsp;{0}{1}";

    @Autowired
    private JdReportService jdReportService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    /**
     * 获取复选项列表
     *
     * @param objName .
     * @param checks  .
     * @param values  .
     * @return .
     */
    private String getCheckbox(String objName, String checks, String values) {
        String ret = "";
        String[] ss = StringHelper.stringToStringArray(checks, ",");
        for (String s : ss) {
            if (("," + values + ",").indexOf("," + s + ",") >= 0) {
                ret += FormatUtils.format(checkbox, objName, s, "checked");
            } else {
                ret += FormatUtils.format(checkbox, objName, s, "");
            }
        }
        return ret;
    }

    private String getCheckboxValues(String checks, String values, Boolean isOnlyShowChecked, Boolean isPrint) {
        String ret = "";
        String[] ss = StringHelper.stringToStringArray(checks, ",");
        for (String s : ss) {
            if (("," + values + ",").indexOf("," + s + ",") >= 0) {
                ret += FormatUtils.format(checkboxValue, isPrint ? "■" : "[√]", s);
            } else if (!isOnlyShowChecked) {
                ret += FormatUtils.format(checkboxValue, isPrint ? "□" : "[×]", s);
            }
        }
        if (isPrint) ret = StringHelper.findAndReplace(ret, "&nbsp;&nbsp;", " ");
        return ret;
    }

    /**
     * 设置填报内容
     *
     * @param model    .
     * @param jdReport .
     */
    public void setReportContent(Model model, JdReport jdReport) {
        JdReportContent reportContent = null;
        if (jdReport != null) {
            if (jdReport.getId() != null) {
                reportContent = getReportContent(jdReport.getId(), false, false);

            } else {
                reportContent = new JdReportContent();
                String defaultValue = "无";

                //其他选项默认值为无
                reportContent.setJnbwgc_mcbw_qt(defaultValue);
                reportContent.setJnbwgc_qtjn_qt(defaultValue);
                reportContent.setJnbwgc_wmbw_qt(defaultValue);
                reportContent.setJnbwgc_xt_qtzbw_qt(defaultValue);
                reportContent.setJnbwgc_xt_wqnbw_qt(defaultValue);
                reportContent.setJnbwgc_xt_wqwbw_qt(defaultValue);

                //其他情况说明默认为无
                reportContent.setKgq_sm(defaultValue);
                reportContent.setGcz_sm(defaultValue);
                reportContent.setJszlcc_sm(defaultValue);
                reportContent.setSyccqk_sm(defaultValue);
                reportContent.setZlqx_sm(defaultValue);
                reportContent.setZlxw_sm(defaultValue);
                reportContent.setJnbwgc_sm(defaultValue);
                reportContent.setZjbw_sm(defaultValue);
            }
            model.addAttribute("content", reportContent);
        }
        model.addAttribute("CHECKBOX_gcz_ccbw", getCheckbox("gcz_ccbw", JdReportContent.CHECKBOX_gcz_ccbw, reportContent != null ? reportContent.getGcz_ccbw() : ""));
        model.addAttribute("CHECKBOX_gcz_fbyszm", getCheckbox("gcz_fbyszm", JdReportContent.CHECKBOX_gcz_fbyszm, reportContent != null ? reportContent.getGcz_fbyszm() : ""));
        model.addAttribute("CHECKBOX_jnbwgc_xt_wqwbw_xx", getCheckbox("jnbwgc_xt_wqwbw_xx", JdReportContent.CHECKBOX_jnbwgc_xt_wqwbw_xx, reportContent != null ? reportContent.getJnbwgc_xt_wqwbw_xx() : ""));
        model.addAttribute("CHECKBOX_jnbwgc_xt_wqnbw_xx", getCheckbox("jnbwgc_xt_wqnbw_xx", JdReportContent.CHECKBOX_jnbwgc_xt_wqnbw_xx, reportContent != null ? reportContent.getJnbwgc_xt_wqnbw_xx() : ""));
        model.addAttribute("CHECKBOX_jnbwgc_xt_qtzbw_xx", getCheckbox("jnbwgc_xt_qtzbw_xx", JdReportContent.CHECKBOX_jnbwgc_xt_qtzbw_xx, reportContent != null ? reportContent.getJnbwgc_xt_qtzbw_xx() : ""));
        model.addAttribute("CHECKBOX_jnbwgc_wmbw_lx", getCheckbox("jnbwgc_wmbw_lx", JdReportContent.CHECKBOX_jnbwgc_wmbw_lx, reportContent != null ? reportContent.getJnbwgc_wmbw_lx() : ""));
        model.addAttribute("CHECKBOX_jnbwgc_mcbw_lx", getCheckbox("jnbwgc_mcbw_lx", JdReportContent.CHECKBOX_jnbwgc_mcbw_lx, reportContent != null ? reportContent.getJnbwgc_mcbw_lx() : ""));
        model.addAttribute("CHECKBOX_syccqk_whjg", getCheckbox("syccqk_whjg", JdReportContent.CHECKBOX_syccqk_whjg, reportContent != null ? reportContent.getSyccqk_whjg() : ""));

        //监督报告类型
//        model.addAttribute("JD_REPORT_TYPE_CITY", Constants.JD_REPORT_TYPE_CITY);
//        model.addAttribute("JD_REPORT_TYPE_ZHUANGXIU", Constants.JD_REPORT_TYPE_ZHUANGXIU);
//        model.addAttribute("JD_REPORT_TYPE_NOJN", Constants.JD_REPORT_TYPE_NOJN);
//        model.addAttribute("JD_REPORT_TYPE_HASJN", Constants.JD_REPORT_TYPE_HASJN);
        model.addAttribute("reportTypeList", sysCodeManager.getCodeListByCode(Constants.JD_REPORT_TYPE));
        model.addAttribute("reportTypeList", sysCodeManager.getCodeListByCode(Constants.JD_REPORT_TYPE));
    }

    //获取其他选项
    private String getCheckboxValuesOther(String other, Boolean isPrint) {
        String ret = "";
        if (!StringHelper.isEmpty(other)) {
            ret = FormatUtils.format(checkboxValue, other, "");
        }
        if (isPrint) ret = StringHelper.findAndReplace(ret, "&nbsp;&nbsp;", " ");
        return ret;
    }

    /**
     * 获取填jdTasks
     *
     * @param jdTaskCode .
     * @return .
     */
    public List<ExcelJdDwgc> getJdTasksData(String jdTaskCode) {
        return excelJdDwgcService.findByQuery("from ExcelJdDwgc where jdTaskCode='" + jdTaskCode + "'");
    }

    /**
     * 获取填报内容
     *
     * @param id      .
     * @param isView  .
     * @param isPrint .
     * @return .
     */
    public JdReportContent getReportContent(Long id, Boolean isView, Boolean isPrint) {
        JdReport data = jdReportService.get(id);
        String printReport = data.getPrintReport();
        if (!StringHelper.isEmpty(printReport)) {
            if (!"null".equals(printReport)) {
                JdReportContent content = new JSONDeserializer<JdReportContent>().use(null, JdReportContent.class).deserialize(printReport);

                //将复选项进行处理后输出
                if (isView || isPrint) {
                    content.setGcz_ccbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_gcz_ccbw, content.getGcz_ccbw(), isView, isPrint));
                    content.setGcz_fbyszm_desc(getCheckboxValues(JdReportContent.CHECKBOX_gcz_fbyszm, content.getGcz_fbyszm(), isView, isPrint));
                    content.setJnbwgc_xt_wqwbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_jnbwgc_xt_wqwbw_xx, content.getJnbwgc_xt_wqwbw_xx(), false, isPrint) + getCheckboxValuesOther(content.getJnbwgc_xt_wqwbw_qt(), isPrint));
                    content.setJnbwgc_xt_wqnbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_jnbwgc_xt_wqnbw_xx, content.getJnbwgc_xt_wqnbw_xx(), false, isPrint) + getCheckboxValuesOther(content.getJnbwgc_xt_wqnbw_qt(), isPrint));
                    content.setJnbwgc_xt_qtzbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_jnbwgc_xt_qtzbw_xx, content.getJnbwgc_xt_qtzbw_xx(), false, isPrint) + getCheckboxValuesOther(content.getJnbwgc_xt_qtzbw_qt(), isPrint));
                    content.setJnbwgc_wmbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_jnbwgc_wmbw_lx, content.getJnbwgc_wmbw_lx(), false, isPrint) + getCheckboxValuesOther(content.getJnbwgc_wmbw_qt(), isPrint));
                    content.setJnbwgc_mcbw_desc(getCheckboxValues(JdReportContent.CHECKBOX_jnbwgc_mcbw_lx, content.getJnbwgc_mcbw_lx(), false, isPrint) + getCheckboxValuesOther(content.getJnbwgc_mcbw_qt(), isPrint));
                    content.setSyccqk_whjg_desc(getCheckboxValues(JdReportContent.CHECKBOX_syccqk_whjg, content.getSyccqk_whjg(), false, isPrint));

                    if (isPrint) {
                        //报告日期转中文
                        content.setReportDate(getGbkDate(content.getReportDate()));

                        //申报日期转中文
                        content.setZljd_sbrq(getGbkDate(content.getZljd_sbrq()));

                        //首次交底会议时间转中文
                        content.setKgq_scjdhy_rq(getGbkDate(content.getKgq_scjdhy_rq()));

                        //节能监督首次时间转中文
                        content.setKgq_jnjdsc_rq(getGbkDate(content.getKgq_jnjdsc_rq()));

                    }
                }
                return content;
            }
        }
        return null;
    }

    /**
     * 日期格式转为中文
     *
     * @param date .
     * @return .
     */
    private String getGbkDate(String date) {
        if (!StringHelper.isEmpty(date)) {
            return DateTimeHelper.formatDateGBK(Date.valueOf(date));
        }
        return date;
    }

    /**
     * 得到类的所有属性
     *
     * @return .
     */
    private List<String> getFieldList() {
        List<String> ret = new ArrayList<String>();
        Field[] fields = JdReportContent.class.getDeclaredFields();
        for (Field field : fields) {
            String column = field.getName();
            if (column.indexOf("CHECKBOX") >= 0) {
                continue;
            }
            ret.add(column);
        }
        return ret;
    }

    /**
     * 将页面输入转成json
     *
     * @param data    已有数据
     * @param request 页面获取数据
     * @param isCheck 是否核查表
     * @return json .
     */
    public String getRequestContent(JdReport data, HttpServletRequest request, Boolean isCheck) {
        JdReportContent content = null;
        if (data != null) {
            if (data.getId() != null) {
                content = getReportContent(data.getId(), false, false);
            }
        }
        String checkFilters = "projectName,sgdwmc,buildUnit,jldwmc,kcdwmc,sjdwmc,jcdwmc,stdwmc";
        if (content == null) {
            content = new JdReportContent();
//            content.setJnbwgc_xt_lx("无");
        }
        List<String> fields = getFieldList();
        for (String column : fields) {
            if (isCheck) {
                //核查表只要保存部分字段
                if (("," + checkFilters + ",").indexOf(column) < 0) {
                    continue;
                }
            } else {
//                //填报表不能覆盖核查表字段
//                if(column.startsWith("audit")){
//                    continue;
//                }
            }
            String getMethodName = "get" + column.substring(0, 1).toUpperCase() + column.substring(1);
            String setMethodName = "set" + column.substring(0, 1).toUpperCase() + column.substring(1);
            String value = request.getParameter(column);
//            System.out.println(getMethodName+" = " + getMethodName);
            try {
                Method getMethod = content.getClass().getMethod(getMethodName);
                String returnType = getMethod.getGenericReturnType().toString();
//                    System.out.println("method.getGenericReturnType() = " + returnType);
                if (returnType.indexOf("java.lang.String") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, String.class);
                    //复选项特殊处理
                    if (("," + JdReportContent.CHECKBOX_FILTER + ",").indexOf(column) >= 0) {
                        String[] parameterValues = request.getParameterValues(column);
                        if (parameterValues != null) {
//                        System.out.println(value+" = " + parameterValues.length);
                            value = StringHelper.stringArrayToString(parameterValues, ",");
                        }
                    }
                    setMethod.invoke(content, value);

                } else if (returnType.indexOf("java.lang.Double") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Double.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getDouble(value) : null);

                } else if (returnType.indexOf("java.lang.Integer") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Integer.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getInteger(value) : null);

                } else if (returnType.indexOf("java.sql.Date") >= 0) {
                    Method setMethod = content.getClass().getMethod(setMethodName, Date.class);
                    setMethod.invoke(content, !StringHelper.isEmpty(value) ? JspHelper.getDate(value) : null);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new JSONSerializer().include().exclude("*.class").serialize(content);
    }

    /**
     * 获取监督报告打印内容
     *
     * @param id .
     * @return .
     * @throws NoSuchMethodException     .
     * @throws java.lang.reflect.InvocationTargetException .
     * @throws IllegalAccessException    .
     */
    public String[][] getDatas(Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("............id = " + id);

        JdReportContent content = null;
        if (id > 0) {
            try {
                content = getReportContent(id, true, true);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        int i = 0;
        List<String> fields = getFieldList();
        String[][] datas = new String[2][fields.size()];
        for (String column : fields) {
            datas[0][i] = column;
            if (content != null) {
                String methodName = "get" + column.substring(0, 1).toUpperCase() + column.substring(1);
//                System.out.println("....methodName = " + methodName);
                Method method = content.getClass().getDeclaredMethod(methodName);
                Object object = method.invoke(content, null);
//                System.out.println(".........object = " + object);
                if (object != null) {
                    datas[1][i] = object.toString();
                }
            }
            i++;
        }
        return datas;
    }

    /**
     * 获取监督报告单位工程列表
     *
     * @param id 监督报告ID
     * @return .
     * @throws NoSuchMethodException     .
     * @throws java.lang.reflect.InvocationTargetException .
     * @throws IllegalAccessException    .
     */
    public String[][] getDwgcDatas(Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] columns = {"序号", "单位工程名称", "建筑面积/层数", "面积", "备注"};
        //todo
        JdReport jdReport = new JdReport();
        if (id > 0) {
            jdReport = jdReportService.get(id);
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Set<JdReportDwgc> jdReportDwgcs = jdReport.getJdReportDwgcs();

        //先一次性取出单位工程信息（单位工程表数据量太大，逐个取出效率太低）
        int m = 0;
        String[] dwgcCodes = new String[jdReportDwgcs.size()];
        for (JdReportDwgc jdReportDwgc : jdReportDwgcs) {
            ExcelJdDwgc excelJdDwgc = jdReportDwgc.getExcelJdDwgc();
            dwgcCodes[m] = JspHelper.getString(excelJdDwgc.getDwgcCode());
            m++;
        }
        Map<String, ShareProDwgcMonitor> dwgcMonitorMap = relateManager.getShareProDwgcMonitors(dwgcCodes);

        for (JdReportDwgc jdReportDwgc : jdReportDwgcs) {
            ExcelJdDwgc excelJdDwgc = jdReportDwgc.getExcelJdDwgc();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("relate", jdReportDwgc);
            map.put("dwgcName", excelJdDwgc.getDwgcName());

            //获取单位工程结构类型和建筑面积
            ShareProDwgcMonitor shareProDwgcMonitor = dwgcMonitorMap.get(excelJdDwgc.getDwgcCode());

            //必须判断是否为空
            if (shareProDwgcMonitor != null) {
                if (shareProDwgcMonitor.getBuildArea() == null) {
                    map.put("buildArea", 0);
                } else {
                    map.put("buildArea", shareProDwgcMonitor.getBuildArea());
                }

                if (shareProDwgcMonitor.getCs() != null) {
                    map.put("dwgcTypeDesc", shareProDwgcMonitor.getDwgcTypeDesc() + "/" + shareProDwgcMonitor.getCs());
                } else {
                    map.put("dwgcTypeDesc", shareProDwgcMonitor.getDwgcTypeDesc());
                }

            }
            list.add(map);
        }
        if (list.size() < 21) {
            for (int i = jdReportDwgcs.size(); i < 21; i++) {
                list.add(null);
            }

        }
        String[][] datas = new String[list.size() + 1][5];
        int i = 1;

        for (Map map : list) {
            int j = 0;
            for (String column : columns) {
                datas[0][j] = column;
                j++;
            }
            if (map != null) {
                datas[i][0] = i + "";
                datas[i][1] = map.get("dwgcName") + "";
                datas[i][2] = map.get("dwgcTypeDesc") + "";
                datas[i][3] = map.get("buildArea") + "";
                datas[i][4] = null;
                i++;
            } else {
                datas[i][0] = i + "";
                datas[i][1] = null;
                datas[i][2] = null;
                datas[i][3] = null;
                datas[i][4] = null;
                i++;
            }

        }

//        String[][] datas = new String[jdReportDwgcs.size()+1][5];
//        int i = 1;
//        for (JdReportDwgc jdReportDwgc : jdReportDwgcs) {
//            JdTaskDwgc jdTaskDwgc = jdReportDwgc.getJdTaskDwgc();
//            int j=0;
//            for(String column:columns){
//                datas[0][j]=column;
//                j++;
//            }
//            datas[i][0] = i+ "";
//            datas[i][1] = jdTaskDwgc.getDwgcName();
//            ShareProDwgcMonitor shareProDwgcMonitor = relateManager.getShareProDwgcMonitor(jdTaskDwgc.getDwgcCode());
//            if (shareProDwgcMonitor != null) {
//                if (shareProDwgcMonitor.getCs() != null) {
//                    datas[i][2] = shareProDwgcMonitor.getDwgcTypeDesc() + "/" + shareProDwgcMonitor.getCs();
//                } else {
//                    datas[i][2] = shareProDwgcMonitor.getDwgcTypeDesc();
//                }
//                datas[i][3] = "" + shareProDwgcMonitor.getBuildArea();
//                datas[i][4] = null;
//            }
//            i++;
//
//        }
//        if(jdReportDwgcs.size()<21){
//            for(int k=i;k<21;k++){
//                datas[k][0]=i+k+1+"";
//                datas[k][1]=null;
//                datas[k][2]=null;
//                datas[k][3]=null;
//                datas[k][4]=null;
//            }
//        }else{
//
//        }

        return datas;
    }
}
