package com.justonetech.biz.controller.syn;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.manager.ExcelJdTasksManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.ReadExcelPoi;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.justonetech.biz.manager.ProFlowCodeManager;


/**
 * note:Excel导入监督任务书
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ExcelJdTasksOldController extends BaseCRUDActionController<ExcelJdTasks> {
    private Logger logger = LoggerFactory.getLogger(ExcelJdTasksOldController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

//    @Autowired
//    private ProFlowCodeManager proFlowCodeManager;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private SysCodeManager sysCodeManager;

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

        return "view/syn/excelJdTasksOld/grid";
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
    public String excelAdd(Model model) {
        ExcelJdTasks excelJdTasks = new ExcelJdTasks();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", excelJdTasks);

        return "view/syn/excelJdTasksOld/excelAdd";
    }

    /**
     * 保存扩展属性
     *
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") ExcelJdTasks entity) throws Exception {
        ExcelJdTasks target = excelJdTasksService.get(entity.getId());
        ReflectionUtils.copyBean(entity, target, new String[]{
                "other1",
                "other2",
                "other3",
                "other4",
                "other5",
                "isRemoteMonitor",
                "isManagerCheck",
                "position",
                "property",
        });
        excelJdTasksService.save(target);
        sendSuccessJSON(response, "保存成功");
    }


    /**
     * 导入保存
     *
     * @param model   .
     * @param request .
     * @return .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public String excelSave(Model model, HttpServletRequest request) throws Exception {
        //声明是否是跟新excelJdTasks，ExcelJdDwgc更新记录条数，添加纪录条数，错误条数
        int excelJdTaskStatue, excelJdTasksAddNum = 0, excelJdTasksUpdateNum = 0, excelJdTasksErrorNum = 0;
        int excelJdDwgcAddNum = 0, errorNum = 0, excelJdDwgcNum = 0;
        double buildArea = 0.0, jagzl = 0.0;
        Map<String, String> importResult = new HashMap<String, String>();
        List<Integer> errNos = new ArrayList<Integer>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile multipartFile = (CommonsMultipartFile) multipartRequest.getFile("file");
        InputStream in = multipartFile.getInputStream();

        ReadExcelPoi readExcelPoi = new ReadExcelPoi(in);
        //获取监督任务书编号
        String jdTaskCode = "";
        //流转编号
//        String flowCode = getClearString(readExcelPoi.getCellData(0, 1, 0));
        //判断任务书编号，流转编号是否为空
        /*add 20140124*/
        int deptEndFlag = 0;
        int projDetailEndFlag = 0;
        int flag = 0;
//        List<String[]> rowList = readExcelPoi.getListData(0, 20, 10);
        List<String[]> rowList = readExcelPoi.getListData(0, 11, 10);
        for (String[] row : rowList) {
            if (row[0].startsWith("工程明细")) {
                jdTaskCode += StringHelper.getElementValue(getClearString(row[0]), "：", "）");
                deptEndFlag = flag;
            } else if (row[0].startsWith("合计")) {
                projDetailEndFlag = flag;
            } else if (row[0].startsWith("备注")) {
                flag++;
                break;
            } else {
                flag++;
            }
        }
        if (StringHelper.isEmpty(jdTaskCode) /*|| StringHelper.isEmpty(flowCode)*/ || readExcelPoi.getCellDataType(0, 1, 1) != 0) {      //todo excel文件生成日期格式判断
            excelJdTaskStatue = 0;
            excelJdTasksErrorNum++;
        } else {
            /*删掉对应任务书编号对应的单位工程原始数据*/
            for (ExcelJdDwgc excelJdDwgc : excelJdDwgcService.findByProperty("jdTaskCode", jdTaskCode)) {
                excelJdDwgcService.delete(excelJdDwgc);
            }
            ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
            excelJdTaskStatue = 1;
            //判断是否excelJdTasks存在
            if (excelJdTasks == null) {
                excelJdTasks = new ExcelJdTasks();
                //excelJdTasks同步时间
                excelJdTasks.setSynDatetime(DateTimeHelper.getTimestamp());
                excelJdTasksAddNum++;//新增记录++
            } else {
                excelJdTasksUpdateNum++;
            }

            /*监督任务书生成日期*/
            Timestamp timestamp = readExcelPoi.getCellDateValue(0, 1, 1);

            excelJdTasks.setJdDatetime(timestamp);

            /*修改时间*/
            excelJdTasks.setChangeTime(DateTimeHelper.getTimestamp());
            /*流转编号*/
            //getCell(sheet,1,0).toString();
//            excelJdTasks.setFlowCode(flowCode);
            /*报建编号*/
            String bjbh = getClearString(readExcelPoi.getCellData(0, 1, 2));
            excelJdTasks.setBjbh(bjbh);
            /*标段号*/
            String bid = getClearString(readExcelPoi.getCellData(0, 12, 2));
            excelJdTasks.setBid(bid);
            /*项目名称*/
            String projectName = getClearString(readExcelPoi.getCellData(0, 1, 3));
            excelJdTasks.setProjectName(projectName);
            /*工程地点*/
            String projectAdd = getClearString(readExcelPoi.getCellData(0, 1, 4));
            excelJdTasks.setProjectAdd(projectAdd);
            /*所在区县*/
            String belongArea = getClearString(readExcelPoi.getCellData(0, 1, 5));
            excelJdTasks.setBelongArea(belongArea);
            /*合同价*/
            String contMoney = getClearString(readExcelPoi.getCellData(0, 10, 5));
            excelJdTasks.setContMoney(JspHelper.getDouble(contMoney));

            /*建设单位*/
            String jsUnitName = getClearString(readExcelPoi.getCellData(0, 1, 6));
            excelJdTasks.setJsUnitName(jsUnitName);
            String jsUnitAdd = getClearString(readExcelPoi.getCellData(0, 1, 7));
            excelJdTasks.setJsUnitAdd(jsUnitAdd);
            String zipcode = getClearString(readExcelPoi.getCellData(0, 10, 7));
            excelJdTasks.setZipcode(zipcode);
            String jsLinkman = getClearString(readExcelPoi.getCellData(0, 1, 8));
            excelJdTasks.setJsLinkman(jsLinkman);
            String jsPhone = getClearString(readExcelPoi.getCellData(0, 10, 8));
            excelJdTasks.setJsPhone(jsPhone);

            /*任务书编号*/
            excelJdTasks.setJdTaskCode(jdTaskCode);
            /*参建单位相关数据设为空值*/
            /*施工总包*/
            excelJdTasks.setSgzbUnitName("");   /*单位名称*/
            excelJdTasks.setSgzbLinkman("");    /*联系人*/
            excelJdTasks.setSgzbPhone("");      /*联系电话*/
            /*勘察单位*/
            excelJdTasks.setKcUnitName("");      /*单位名称*/
            excelJdTasks.setKcLinkman("");       /*联系人*/
            excelJdTasks.setKcPhone("");         /*联系电话*/
            /*设计单位*/
            excelJdTasks.setSjUnitName("");      /*单位名称*/
            excelJdTasks.setSjLinkman("");       /*联系人*/
            excelJdTasks.setSjPhone("");         /*联系电话*/
            /*监理单位*/
            excelJdTasks.setJlUnitName("");       /*单位名称*/
            excelJdTasks.setJlLinkman("");        /*联系人*/
            excelJdTasks.setJlPhone("");          /*联系电话*/
            /*施工单位*/
            excelJdTasks.setSgUnitName("");        /*单位名称*/
            excelJdTasks.setSgLinkman("");         /*联系人*/
            excelJdTasks.setSgPhone("");           /*联系电话*/
            /*参建单位遍历*/
            for (int i = 0; i < deptEndFlag; i++) {
                String[] cells = rowList.get(i);
                if (StringHelper.equals(cells[0], "施工总包")) {
                    excelJdTasks.setSgzbUnitName(getClearString(cells[1]));   /*单位名称*/
                    excelJdTasks.setSgzbLinkman(getClearString(cells[7]));    /*联系人*/
                    excelJdTasks.setSgzbPhone(getClearString(cells[12]));      /*联系电话*/
                } else if (StringHelper.equals(cells[0], "勘察单位")) {
                    excelJdTasks.setKcUnitName(getClearString(cells[1]));      /*单位名称*/
                    excelJdTasks.setKcLinkman(getClearString(cells[7]));       /*联系人*/
                    excelJdTasks.setKcPhone(getClearString(cells[12]));         /*联系电话*/
                } else if (StringHelper.equals(cells[0], "设计单位")) {
                    excelJdTasks.setSjUnitName(getClearString(cells[1]));      /*单位名称*/
                    excelJdTasks.setSjLinkman(getClearString(cells[7]));       /*联系人*/
                    excelJdTasks.setSjPhone(getClearString(cells[12]));         /*联系电话*/
                } else if (StringHelper.equals(cells[0], "监理单位")) {
                    excelJdTasks.setJlUnitName(getClearString(cells[1]));       /*单位名称*/
                    excelJdTasks.setJlLinkman(getClearString(cells[7]));        /*联系人*/
                    excelJdTasks.setJlPhone(getClearString(cells[12]));          /*联系电话*/
                } else if (StringHelper.equals(cells[0], "施工单位")) {
                    excelJdTasks.setSgUnitName(getClearString(cells[1]));        /*单位名称*/
                    excelJdTasks.setSgLinkman(getClearString(cells[7]));         /*联系人*/
                    excelJdTasks.setSgPhone(getClearString(cells[12]));           /*联系电话*/
                }
            }
            /*判断是否导入施工单位，如果不存在则将总包单位信息复制给施工单位*/
            if (StringHelper.isEmpty(excelJdTasks.getSgUnitName())) {
                excelJdTasks.setSgUnitName(excelJdTasks.getSgzbUnitName());        /*单位名称*/
                excelJdTasks.setSgLinkman(excelJdTasks.getSgzbLinkman());         /*联系人*/
                excelJdTasks.setSgPhone(excelJdTasks.getSgzbPhone());           /*联系电话*/
            }

            /*工程明细*/
            for (int i = deptEndFlag + 4; i < projDetailEndFlag + 1; i++) {
                String[] cells = rowList.get(i);
                excelJdDwgcNum++;

                /*单位工程编码*/
                String dwgcCode = cells[8];
                if (StringHelper.isEmpty(dwgcCode)) {
                    errorNum++;
                    errNos.add(excelJdDwgcNum);
                    continue;
                }
                ExcelJdDwgc excelJdDwgc = new ExcelJdDwgc();
//                excelJdDwgc.setFlowCode(flowCode);  /*流转编号*/
                excelJdDwgc.setJdTaskCode(jdTaskCode);   /*监督任务编号*/
                excelJdDwgc.setSynDatetime(DateTimeHelper.getTimestamp());/*excelJdDwgc同步时间*/
                excelJdDwgcAddNum++;    /*新增记录++*/
                excelJdDwgc.setChangetime(DateTimeHelper.getTimestamp());     /*修改时间*/
                /*工程名称*/
                String dwgcName = cells[0];
                excelJdDwgc.setDwgcName(dwgcName);
                /*工程类型*/
                String projectType = cells[1];
                excelJdDwgc.setProjectType(projectType);
                /*面积*/
                String dwgcArea = cells[2];
                excelJdDwgc.setDwgcArea(JspHelper.getDouble(dwgcArea));
                /*地上层数*/
                String upCs = cells[3];
                excelJdDwgc.setUpCs(upCs);
                /*底下层数*/
                String downCs = cells[4];
                excelJdDwgc.setDownCs(downCs);
                /*台数*/
                String ts = cells[5];
                excelJdDwgc.setTs(JspHelper.getString(ts));
                /*造价*/
                String dwgcMoney = cells[6];
                excelJdDwgc.setDwgcMoney(JspHelper.getDouble(dwgcMoney));
                /*结构类型*/
                String structType = cells[7];
                excelJdDwgc.setStructType(structType);
                /*工程编号*/
                excelJdDwgc.setDwgcCode(dwgcCode);
                excelJdDwgcService.save(excelJdDwgc);
                buildArea += Double.parseDouble(dwgcArea);
                jagzl += Double.parseDouble(dwgcMoney);
            }

            //单体数量
            int dtsl = excelJdDwgcAddNum;
            excelJdTasks.setDtsl(dtsl);
            excelJdTasks.setBuildArea(buildArea);
            excelJdTasks.setJagzl(jagzl);
            excelJdTasksService.save(excelJdTasks);

        }
        importResult.put("excelJdTaskStatue", "" + excelJdTaskStatue);
        importResult.put("excelJdTasksAddNum", "" + excelJdTasksAddNum);
        importResult.put("excelJdTasksUpdateNum", "" + excelJdTasksUpdateNum);
        importResult.put("excelJdTasksErrorNum", "" + excelJdTasksErrorNum);
        importResult.put("excelJdDwgcAddNum", "" + excelJdDwgcAddNum);
        importResult.put("excelJdDwgcNum", "" + excelJdDwgcNum);
        importResult.put("errorNum", "" + errorNum);
        model.addAttribute("importResult", importResult);
        model.addAttribute("errNos", errNos);

        return "view/syn/excelJdTasksOld/excelAdd";
    }

    private String getClearString(String s) {
        return JspHelper.getString(s).trim();
    }

    /**
     * 查看页面--tab入口
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        model.addAttribute("id", id);
        return "view/syn/excelJdTasksOld/view";
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


        model.addAttribute("EXCEL_JDTASK_OTHER1", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER1));
        model.addAttribute("EXCEL_JDTASK_OTHER2", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER2));
        model.addAttribute("EXCEL_JDTASK_OTHER3", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER3));
        model.addAttribute("EXCEL_JDTASK_OTHER4", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER4));
        model.addAttribute("EXCEL_JDTASK_OTHER5", sysCodeManager.getCodeByCode(Constants.EXCEL_JDTASK_OTHER5));
//        model.addAttribute("EXCEL_JDTASK_OTHER1", Constants.EXCEL_JDTASK_OTHER1);
//        model.addAttribute("EXCEL_JDTASK_OTHER2", Constants.EXCEL_JDTASK_OTHER2);
//        model.addAttribute("EXCEL_JDTASK_OTHER3", Constants.EXCEL_JDTASK_OTHER3);
//        model.addAttribute("EXCEL_JDTASK_OTHER4", Constants.EXCEL_JDTASK_OTHER4);
//        model.addAttribute("EXCEL_JDTASK_OTHER5", Constants.EXCEL_JDTASK_OTHER5);

        model.addAttribute("EXCEL_JDTASK_POSITION", Constants.EXCEL_JDTASK_POSITION);
//        model.addAttribute("EXCEL_JDTASK_PROPERTY", Constants.PRO_TYPE);
        return "view/syn/excelJdTasksOld/viewTask";
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
        //工程进度
        model.addAttribute("proSchedule", Constants.EXCEL_JDTASK_SCHEDULE);
        model.addAttribute("list", excelJdTasksManager.getExcelJdDwgcs(id));

        return "view/syn/excelJdTasksOld/viewDwgc";
    }

    /**
     * 保存操作
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void saveExcelJdDwgc(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String[] dwgcIdses = request.getParameterValues("dwgcIds");
        String[] proSchedules = request.getParameterValues("proSchedule");
        for (int i = 0; i < proSchedules.length; i++) {
            String proSchedule = proSchedules[i];
            ExcelJdDwgc excelJdDwgc = excelJdDwgcService.get(Long.parseLong(dwgcIdses[i]));
            excelJdDwgc.setProSchedule(proSchedule);
            excelJdDwgcService.save(excelJdDwgc);
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
        ExcelJdTasks excelJdTasks = excelJdTasksService.get(id);
        List<ExcelJdDwgc> list = excelJdTasksManager.getExcelJdDwgcs(id);
        for (ExcelJdDwgc excelJdDwgc : list) {
            excelJdDwgcService.delete(excelJdDwgc);
        }

        excelJdTasksService.delete(excelJdTasks);

        sendSuccessJSON(response, "删除成功");
    }

}