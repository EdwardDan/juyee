package com.justonetech.biz.manager;

import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.jdRecord.JdProjectInfo;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdCheckDeptType;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * description:(新)监督记录（包括首次、质量、安全、竣工）业务类
 * User: Chenjp
 * Date: 14-1-2 下午4:14
 */
@Service
public class JdRecordManager {
    private Logger logger = LoggerFactory.getLogger(JdRecordManager.class);

    @Autowired
    private WorkerTalkFormService workerTalkFormService;

    @Autowired
    private JdRecordFirstService jdRecordFirstService;

    @Autowired
    private JdRecordSafeService jdRecordSafeService;

    @Autowired
    private JdRecordQualityService jdRecordQualityService;

    @Autowired
    private JdRecordCompleteService jdRecordCompleteService;

    @Autowired
    private JdRecordPersonService jdRecordPersonService;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private JdRecordCompCheckitemService jdRecordCompCheckitemService;

    @Autowired
    private JdStopOrderService jdStopOrderService;

    /**
     * 获取监督项目信息
     *
     * @param jdTaskCode 监督任务书编号
     * @return 监督项目信息
     */
    public JdProjectInfo getProjectInfo(String jdTaskCode) {
        JdProjectInfo projectInfo = new JdProjectInfo();
        projectInfo.setJdTaskCode(jdTaskCode);

        List<ExcelJdTasks> list = excelJdTasksService.findByQuery("from ExcelJdTasks where jdTaskCode=?", jdTaskCode);
        if (list.size() > 0) {
            ExcelJdTasks excelJdTasks = list.iterator().next();
            projectInfo.setBjbh(excelJdTasks.getBjbh());
            projectInfo.setFlowCode(excelJdTasks.getFlowCode());

//            ShareProTobuild project = projectManager.getProject(excelJdTasks.getBjbh());
//            if (project != null) {
            projectInfo.setProjectName(excelJdTasks.getProjectName());
            projectInfo.setJsDept(StringHelper.isEmpty(excelJdTasks.getJsUnitName()) ? "无" : excelJdTasks.getJsUnitName());
            projectInfo.setKcDept(StringHelper.isEmpty(excelJdTasks.getKcUnitName()) ? "无" : excelJdTasks.getKcUnitName());
            projectInfo.setSjDept(StringHelper.isEmpty(excelJdTasks.getSjUnitName()) ? "无" : excelJdTasks.getSjUnitName());
            projectInfo.setSgDept(StringHelper.isEmpty(excelJdTasks.getSgUnitName()) ? "无" : excelJdTasks.getSgUnitName());
            projectInfo.setJlDept(StringHelper.isEmpty(excelJdTasks.getJlUnitName()) ? "无" : excelJdTasks.getJlUnitName());
            projectInfo.setJcDept("无");
            projectInfo.setJdjg(configManager.getJdDeptName());
//            }
        }
        return projectInfo;
    }

    /**
     * 获取监督记录的自动编号
     *
     * @param formTypeCode 监督表单类别编号
     * @param formId       监督表单ID
     * @return 自动编号
     */
    public String generateCode(String formTypeCode, Long formId) {
        String code = "";
        int length = 3;
        String date = DateTimeHelper.getCurrentDate();
        date = StringHelper.findAndReplace(date, "-", "");
        date = JdRecordType.getPrefixByCode(formTypeCode) + date;

        if (JdRecordType.TYPE_FIRST.getCode().equals(formTypeCode)) {
            List<JdRecordFirst> list = jdRecordFirstService.findByQuery(FormatUtils.format("from JdRecordFirst where code like '{0}%' order by code desc", date));
            if (list.size() > 0) {
                code = (list.iterator().next()).getCode();
            }
        } else if (JdRecordType.TYPE_SAFE.getCode().equals(formTypeCode)) {
            List<JdRecordSafe> list = jdRecordSafeService.findByQuery(FormatUtils.format("from JdRecordSafe where code like '{0}%' order by code desc", date));
            if (list.size() > 0) {
                code = (list.iterator().next()).getCode();
            }
        } else if (JdRecordType.TYPE_QUALITY.getCode().equals(formTypeCode)) {
            List<JdRecordQuality> list = jdRecordQualityService.findByQuery(FormatUtils.format("from JdRecordQuality where code like '{0}%' order by code desc", date));
            if (list.size() > 0) {
                code = (list.iterator().next()).getCode();
            }
        } else if (JdRecordType.TYPE_COMPLETE.getCode().equals(formTypeCode)) {
            List<JdRecordComplete> list = jdRecordCompleteService.findByQuery(FormatUtils.format("from JdRecordComplete where code like '{0}%' order by code desc", date));
            if (list.size() > 0) {
                code = (list.iterator().next()).getCode();
            }
        }
        if (StringHelper.isEmpty(code)) {
            code = date + StringHelper.leftPad("1", length, "0");
        } else {
            code = code.substring(date.length());
            code = date += StringHelper.leftPad(String.valueOf(Integer.parseInt(code) + 1), length, "0");
        }
        return code;
    }

    /**
     * 获取监督人员列表
     *
     * @param formTypeCode 监督表单类别编号
     * @param formId       监督表单ID
     * @return 人员列表
     */
    public List<JdRecordPerson> getJdRecordPersons(String formTypeCode, Long formId) {
        if (formId == null) {
            formId = 0L;
        }
        return jdRecordPersonService.findByQuery("from JdRecordPerson where jdTypeCode=? and recordId=? order by id asc", formTypeCode, formId);
    }

    /**
     * 获取监督问题列表
     *
     * @param formTypeCode     监督表单类别编码
     * @param questionTypeCode 问题类别编码
     * @param formId           监督表单ID
     * @return 问题列表
     */
    public List<JdRecordQuestion> getJdRecordQuestions(String formTypeCode, String questionTypeCode, Long formId) {
        if (formId == null) {
            formId = 0L;
        }
        if (!StringHelper.isEmpty(questionTypeCode)) {
            return jdRecordQuestionService.findByQuery("from JdRecordQuestion where jdTypeCode=? and typeCode=? and recordId=? order by typeCode asc,id asc", formTypeCode, questionTypeCode, formId);
        } else {
            return jdRecordQuestionService.findByQuery("from JdRecordQuestion where jdTypeCode=? and recordId=? order by typeCode asc,id asc", formTypeCode, formId);
        }
    }

    /**
     * 获取竣工验收检查内容给打印模块
     *
     * @param id .
     * @return .
     */
    public List getJdRecordCheckItemReportList(Long id) {
        List<Object[]> resultList = new ArrayList<Object[]>();
        JdRecordComplete jdRecordComplete = jdRecordCompleteService.get(id);
        Map<Long, String> map1 = new HashMap<Long, String>();

        Set<JdRecordCompleteResult> jdRecordCompleteResults = jdRecordComplete.getJdRecordCompleteResults();
        for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
            map1.put(jdRecordCompleteResult.getCheckitem().getId(), jdRecordCompleteResult.getCheckResult());
        }

        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            Object[] data = new Object[2];
            data[0] = sysCodeDetail.getName();
            data[1] = "";
            resultList.add(data);

            String hql = "from JdRecordCompCheckitem where type.id={0} order by orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {
                String selectItems = jdRecordCompCheckitem.getSelectItems();
                String[] split = StringUtils.split(selectItems, "|");
                String dom = "";
                for (String s : split) {
                    if (StringUtils.equals(s, map1.get(jdRecordCompCheckitem.getId()))) {
                        dom += "√" + s + "  ";
                    } else {
                        dom += "□" + s + "  ";
                    }
                }

                data = new Object[2];
                data[0] = "    " + jdRecordCompCheckitem.getOrderNo() + "、" + jdRecordCompCheckitem.getCondition();
                data[1] = dom;
                resultList.add(data);
            }
        }

        int rowNum = 9;
        while (resultList.size() < rowNum) {
            Object[] data = new Object[6];
            resultList.add(data);
        }

        return resultList;
    }

    /**
     * 监督安全打印模块
     *
     * @param id   .
     * @param type .
     * @return .
     */
    public List getJdRecordCheckBoxs(Long id, String type) {
        List<Object[]> resultList = new ArrayList<Object[]>();
        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.POLLING_RECORD_STAGE);
        String[] items = null;
        if (Constants.POLLING_FORM_CLASS_SAFE.equals(type)) {
            JdRecordSafe jdRecordSafe = jdRecordSafeService.get(id);

            if (null != jdRecordSafe && null != jdRecordSafe.getScheduleItems()) {
                items = jdRecordSafe.getScheduleItems().split(",");
            }
        } else if (Constants.POLLING_FORM_CLASS_QUALITY.equals(type)) {
            JdRecordQuality jdRecordQuality = jdRecordQualityService.get(id);

            if (null != jdRecordQuality && null != jdRecordQuality.getScheduleItems()) {
                items = jdRecordQuality.getScheduleItems().split(",");
            }
        }
        Object[] data = new Object[codeListByCode.size()];
        String list = "";
        for (int i = 0; i < codeListByCode.size(); i++) {
            if (null != items) {
                boolean flag = false;
                for (String item : items) {
                    if (item.equals(codeListByCode.get(i).getName())) {
                        flag = true;
                    }
                }
                if (flag) {
                    list += "√" + codeListByCode.get(i).getName() + "    ";
                } else {
                    list += "□" + codeListByCode.get(i).getName() + "    ";
                }
            } else {
                list += "□" + codeListByCode.get(i).getName() + "    ";
            }
        }
        data[0] = list;
        resultList.add(data);
        return resultList;
    }

    /**
     * 谈话通知书，携带材料
     *
     * @param id .
     * @return .
     */
    public List getMaterialIds(Long id) {
        List<Object[]> resultList = new ArrayList<Object[]>();
        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.WORKER_TALK_FORM_LISTS);
        String[] items = null;
        WorkerTalkForm workerTalkForm = workerTalkFormService.get(id);
        if (null != workerTalkForm && null != workerTalkForm.getMaterialIds()) {
            items = workerTalkForm.getMaterialIds().split(",");
        }
        Object[] data = new Object[codeListByCode.size()];
        String list = "";
        for (int i = 0; i < codeListByCode.size(); i++) {
            boolean isBr = false;
            if ((i + 1) % 2 == 0) {
                isBr = true;
            }
            if (null != items) {
                boolean flag = false;
                for (String item : items) {
                    if (item.equals(codeListByCode.get(i).getName())) {
                        flag = true;
                    }
                }
                if (flag) {
                    list += "√" + codeListByCode.get(i).getName() + "     ";
                    if (isBr) {
                        list += "\r\n";
                    }
                } else {
                    list += "□" + codeListByCode.get(i).getName() + "     ";
                    if (isBr) {
                        list += "\r\n";
                    }
                }
            } else {
                list += "□" + codeListByCode.get(i).getName() + "     ";
                if (isBr) {
                    list += "\r\n";
                }
            }
        }
        data[0] = list;
        Timestamp talkDate = workerTalkForm.getTalkTime();
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(talkDate);
        if (ca.get(GregorianCalendar.AM_PM) == 0) {
            data[1] = "上午";
        } else {
            data[1] = "下午";
        }

        resultList.add(data);
        return resultList;
    }

    /**
     * 获取复查单位
     *
     * @param id .
     * @return .
     */
    public List getRecheckDeptCheckBoxs(Long id) {
        List<Object[]> resultList = new ArrayList<Object[]>();
        String[] jdCheckDeptTypes = JdCheckDeptType.getNames();
        JdStopOrder jdStopOrder = jdStopOrderService.get(id);
        Object[] data = new Object[jdCheckDeptTypes.length];
        String list = "";
        for (String jdCheckDeptType : jdCheckDeptTypes) {
            if (StringHelper.equals(jdCheckDeptType, jdStopOrder.getRecheckDept())) {
                list += "√" + jdCheckDeptType + " ";
            } else {
                list += "□" + jdCheckDeptType + " ";
            }
        }
        data[0] = list;
        resultList.add(data);
        return resultList;
    }
}
