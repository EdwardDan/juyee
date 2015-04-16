package com.justonetech.biz.controller.report;

import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.JdReportDwgcService;
import com.justonetech.biz.daoservice.JdReportService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.JdReport;
import com.justonetech.biz.domain.JdReportDwgc;
import com.justonetech.biz.domain.ShareProDwgcMonitor;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.beanutils.BeanComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * note:监督报告单位工程
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class JdReportDwgcController extends BaseCRUDActionController<JdReportDwgc> {
    private Logger logger = LoggerFactory.getLogger(JdReportDwgcController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private JdReportDwgcService jdReportDwgcService;

    @Autowired
    private JdReportService jdReportService;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;


    /**
     * 查看页面
     *
     * @param id    .
     * @param act   .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String id, String act) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", (sysUserManager.hasPrivilege(PrivilegeCode.JD_REPORT_EDIT) && !StringHelper.isEmpty(id) && "edit".equals(act)));

        JdReport jdReport = new JdReport();

        if (!StringHelper.isEmpty(id)) {
            jdReport = jdReportService.get(Long.valueOf(id));
        }
        model.addAttribute("bean", jdReport);

        //获取关联的单位工程列表
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();


        Set<JdReportDwgc> jdReportDwgcs = jdReport.getJdReportDwgcs();

        //先一次性取出单位工程信息（单位工程表数据量太大，逐个取出效率太低）
        int i = 0;
        String[] dwgcCodes = new String[jdReportDwgcs.size()];
        for (JdReportDwgc jdReportDwgc : jdReportDwgcs) {
            ExcelJdDwgc excelJdDwgc = jdReportDwgc.getExcelJdDwgc();
            dwgcCodes[i] = JspHelper.getString(excelJdDwgc.getDwgcCode());
            i++;
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
                map.put("buildArea", shareProDwgcMonitor.getBuildArea());
                map.put("dwgcTypeDesc", shareProDwgcMonitor.getDwgcTypeDesc());
                map.put("cs", shareProDwgcMonitor.getCs());
            }
            list.add(map);
        }

        //按单位工程名称排序
        BeanComparator beanComparator = new BeanComparator("dwgcName");
        Collections.sort(list, beanComparator);

        model.addAttribute("list", list);
        return "view/report/jdReportDwgc/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param id       .
     * @param dwgcIds  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, Long id, String dwgcIds) throws Exception {
        try {
            //监督报告
            JdReport jdReport = jdReportService.get(id);

            //获取已存在的单位工程
            Set<Long> existDwgcIds = new HashSet<Long>();
            Set<JdReportDwgc> jdReportDwgcs = jdReport.getJdReportDwgcs();
            for (JdReportDwgc dwgc : jdReportDwgcs) {
                existDwgcIds.add(dwgc.getExcelJdDwgc().getId());
            }

            //处理页面传递过来的单位工程ID
            //必须判断是否为空
            if (!StringHelper.isEmpty(dwgcIds)) {
                String[] ids = StringHelper.stringToStringArray(dwgcIds, ",");
                for (String dwgcId : ids) {
                    if (StringHelper.isEmpty(dwgcId)) {
                        continue;
                    }

                    //不在已保存列表中才需要保存
                    if (!existDwgcIds.contains(Long.valueOf(dwgcId))) {
                        JdReportDwgc jdReportDwgc = new JdReportDwgc();
                        jdReportDwgc.setJdReport(jdReport);

                        ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(Long.valueOf(dwgcId));
                        jdReportDwgc.setExcelJdDwgc(excelJdDwgc);
                        jdReportDwgcService.save(jdReportDwgc);
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
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        jdReportDwgcService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}