package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.ExcelJdDwgcService;
import com.justonetech.biz.daoservice.ExcelJdTasksService;
import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.domain.ExcelJdTasks;
import com.justonetech.biz.utils.DateUtil;
import com.justonetech.biz.utils.webService.jdrwsWebService.JdrwsServiceClient;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.Jdrws;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsDw;
import com.justonetech.biz.utils.webService.jdrwsWebService.bean.JdrwsDwGc;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description: 监督任务书逻辑类
 */
@Service
public class ExcelJdTasksManager {
    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private JdrwsServiceClient jdrwsServiceClient;

    /**
     * 根据监督任务书编号获取获取ExcelJdTasks
     *
     * @param jdTaskCode .
     * @return .
     */
    public ExcelJdTasks findExcelJdTasks(String jdTaskCode) {
        String hql = "from ExcelJdTasks where trim(jdTaskCode)=?";
        List<ExcelJdTasks> list = excelJdTasksService.findByQuery(hql, jdTaskCode);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 通过jdTaskId获取ExcelJdDwgc列表
     *
     * @param excelJdTasksId .
     * @return .
     */
    public List<ExcelJdDwgc> getExcelJdDwgcs(Long excelJdTasksId) {
        ExcelJdTasks excelJdTasks = excelJdTasksService.get(excelJdTasksId);
        String jdTaskCode = JspHelper.getString(excelJdTasks.getJdTaskCode()).trim();
        String hql = "from ExcelJdDwgc where trim(jdTaskCode)='" + jdTaskCode + "' order by id asc";
//        String hql = "from ExcelJdDwgc dwgc inner join ExcelJdTasks task on trim(dwgc.jdTaskCode)=trim(task.jdTaskCode) where task.id=? order by dwgc.id asc";
//        return excelJdDwgcService.findByQuery(hql, excelJdTasksId);
        return excelJdDwgcService.findByQuery(hql);
    }

    /**
     * 根据报建编号获取默认的监督任务书
     * @param bjbh .
     * @return .
     */
    public ExcelJdTasks getDefaultExcelJdTasks(String bjbh) {
        String hql = "from ExcelJdTasks where trim(bjbh)=?";
        List<ExcelJdTasks> list = excelJdTasksService.findByQuery(hql, bjbh);
        if (list.size() > 0) {
            return list.iterator().next();
        }
        return null;
    }

    /**
     * 根据监督任务书编号获取单位工程列表
     * @param jdTaskCode .
     * @return .
     */
    public List<ExcelJdDwgc> getExcelJdDwgcs(String jdTaskCode) {
        String hql = "from ExcelJdDwgc where trim(jdTaskCode)='" + jdTaskCode + "' order by id asc";
        return excelJdDwgcService.findByQuery(hql);
    }

    /**
     * 获取监督任务书信息 -- 从webservice
     *
     * @param jdrwsbh 监督任务书编号
     * @param xmlx    项目类型
     * @return .
     */
    public ExcelJdTasks getExcelJdTasksByWebservice(String jdrwsbh, String xmlx) {
        ExcelJdTasks data = findExcelJdTasks(jdrwsbh);
        if (data == null) {
            data = new ExcelJdTasks();
            data.setJdTaskCode(jdrwsbh);
        }
        Jdrws jdrws = jdrwsServiceClient.getJdrwsByJdrwsbh(jdrwsbh);
        if (jdrws != null) {
            if (!StringHelper.isEmpty(xmlx)) {    //项目类型
                data.setReportType(xmlx);
            }
            data.setProjectName(jdrws.getXmmc());
            data.setProjectAdd(jdrws.getGcdd());
            data.setJdDatetime(DateUtil.xmlDate2Time(jdrws.getJdDateTime()));
            data.setBjbh(jdrws.getBjbh());
            data.setBid(jdrws.getBdh());
            data.setBelongArea(jdrws.getSzqx()); //所在区县
            data.setContMoney(jdrws.getHtj());
            data.setMemo(jdrws.getBz());
            data.setJsUnitName(jdrws.getJsdw());
            data.setJsUnitAdd(jdrws.getJsdwDz());
            data.setJsLinkman(jdrws.getLxr());
            data.setJsPhone(jdrws.getLxrDh());
            data.setZipcode(jdrws.getYzbm());
            data.setSynDatetime(DateUtil.xmlDate2Time(jdrws.getTimeflag()));
            data.setChangeTime(DateUtil.xmlDate2Time(jdrws.getChangeTime()));

            //参建单位
            List<JdrwsDw> dwList = jdrws.getJdrwsDwList();
            for (JdrwsDw dw : dwList) {
                String dwLx = dw.getDwLx();
                if ("施工单位".equals(dwLx)) {
                    data.setSgUnitName(dw.getDwMc());
                    data.setSgLinkman(dw.getLxr());
                    data.setSgPhone(dw.getLxrDh());

                } else if ("设计单位".equals(dwLx)) {
                    data.setSjUnitName(dw.getDwMc());
                    data.setSjLinkman(dw.getLxr());
                    data.setSjPhone(dw.getLxrDh());

                } else if ("勘察单位".equals(dwLx)) {
                    data.setKcUnitName(dw.getDwMc());
                    data.setKcLinkman(dw.getLxr());
                    data.setKcPhone(dw.getLxrDh());

                } else if ("监理单位".equals(dwLx)) {
                    data.setJlUnitName(dw.getDwMc());
                    data.setJlLinkman(dw.getLxr());
                    data.setJlPhone(dw.getLxrDh());

                } else if ("施工总包单位".equals(dwLx)) {
                    data.setSgzbUnitName(dw.getDwMc());
                    data.setSgzbLinkman(dw.getLxr());
                    data.setSgzbPhone(dw.getLxrDh());
                }
            }

            //计算面积、工作量和单体数量
            double jagzl = 0;
            double buildArea = 0;
            int dtsl = 0;
            List<JdrwsDwGc> jdrwsDwGcList = jdrws.getJdrwsDwGcList();
            for (JdrwsDwGc jdrwsDwGc : jdrwsDwGcList) {
                jagzl += JspHelper.getDouble(jdrwsDwGc.getZj());
                buildArea += JspHelper.getDouble(jdrwsDwGc.getMj());
                dtsl++;
            }
            data.setJagzl(jagzl);
            data.setBuildArea(buildArea);
            data.setDtsl(dtsl);
        }
        return data;
    }

    /**
     * 获取监督任务书单位工程列表 -- 从webservice
     *
     * @param jdrwsbh  监督任务书编号
     * @param existMap 已有数据
     * @return .
     */
    public List<ExcelJdDwgc> getExcelJdDwgcsByWebservice(String jdrwsbh, Map<String, ExcelJdDwgc> existMap) {
        List<ExcelJdDwgc> ret = new ArrayList<ExcelJdDwgc>();
        Jdrws jdrws = jdrwsServiceClient.getJdrwsByJdrwsbh(jdrwsbh);
        if (jdrws != null) {
            List<JdrwsDwGc> dwGcList = jdrws.getJdrwsDwGcList();
            if (dwGcList != null) {
                for (JdrwsDwGc dwGc : dwGcList) {
                    String dwgcBh = dwGc.getDwgcBh();
                    ExcelJdDwgc excelJdDwgc = existMap.get(dwgcBh);
                    if (excelJdDwgc == null) {
                        excelJdDwgc = new ExcelJdDwgc();
                    }
                    excelJdDwgc.setJdTaskCode(jdrwsbh); //监督任务书编号
                    excelJdDwgc.setDwgcCode(dwgcBh);
                    excelJdDwgc.setDwgcName(dwGc.getDwgcMc());
//                    excelJdDwgc.setCustomCode(""); //todo 生成区县自定义的编号
                    excelJdDwgc.setUpCs(JspHelper.getString(dwGc.getDsCs()));
                    excelJdDwgc.setDownCs(JspHelper.getString(dwGc.getDxCs()));
                    excelJdDwgc.setDwgcArea(dwGc.getMj());
                    excelJdDwgc.setDwgcMoney(dwGc.getZj());
                    excelJdDwgc.setProjectType(dwGc.getGcLx());
                    excelJdDwgc.setStructType(dwGc.getJgLx());
                    excelJdDwgc.setSynDatetime(DateUtil.xmlDate2Time(dwGc.getTimeflag()));
                    excelJdDwgc.setTs(JspHelper.getString(dwGc.getTs()));
//                    excelJdDwgc.setProSchedule("");
                    ret.add(excelJdDwgc);
                }
            }
        }
        return ret;
    }
}
