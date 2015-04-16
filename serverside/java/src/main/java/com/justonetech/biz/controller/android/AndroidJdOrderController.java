package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.JdRecordQuestionService;
import com.justonetech.biz.daoservice.JdStopOrderQuestionService;
import com.justonetech.biz.daoservice.JdStopOrderService;
import com.justonetech.biz.domain.JdRecordQuestion;
import com.justonetech.biz.domain.JdStopOrder;
import com.justonetech.biz.domain.JdStopOrderQuestion;
import com.justonetech.biz.domain.bean.android.*;
import com.justonetech.biz.manager.JdStopOrderManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.biz.utils.enums.JdStopOrderStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * note:监督指令单
 * User: Shaxj
 * Date: 14-8-14
 * Time: 上午10:17
 */
@Controller
public class AndroidJdOrderController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidJdOrderController.class);

    @Autowired
    private JdStopOrderService jdStopOrderService;

    @Autowired
    private JdStopOrderManager jdStopOrderManager;

    @Autowired
    private JdStopOrderQuestionService jdStopOrderQuestionService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;


    /**
     * 整改单据模块查询某一条监督任务书下的所有指令单
     *
     * @param id         .
     * @param model
     * @param jdTypeCode
     * @return .
     */
    @RequestMapping
    public String getJdOrderQuestionsByJdTask(Model model, Long id, String jdTypeCode) {
        if (null == id) id = 0L;
        if (StringHelper.isEmpty(jdTypeCode)) jdTypeCode = "";
        String sql = "select id,record_id,Jd_type_code,question_desc,unlaw_desc,unlaw_id,jd_person_desc" +
                " from JD_RECORD_QUESTION " +
                " where RECORD_ID ={0}" +
                " and JD_TYPE_CODE='{1}' ";
        sql = FormatUtils.format(sql, String.valueOf(id), jdTypeCode);
        List list = jdStopOrderQuestionService.findBySql(sql);
        List<AndroidJdRecordQuestion> result = new ArrayList<AndroidJdRecordQuestion>();
        for (Object o : list) {
            AndroidJdRecordQuestion question = new AndroidJdRecordQuestion();
            Object[] objects = (Object[]) o;
            question.setId(Long.valueOf(String.valueOf(objects[0])));
            question.setRecordid(Long.valueOf(String.valueOf(objects[1])));
            question.setTypeCode(String.valueOf(objects[2]));
            question.setDictName(String.valueOf(objects[3]));
            question.setRefRule(String.valueOf(objects[4]));
            question.setPersonId(Long.parseLong(String.valueOf(objects[5])));
            question.setPersonName(String.valueOf(objects[6]));
            result.add(question);
        }
        model.addAttribute("msg", JSONArray.fromObject(result).toString());
        return "common/androidMsg";
    }

    /**
     * 获取责任主体
     *
     * @param id    .
     * @param model
     * @param id
     * @return .
     */
    @RequestMapping
    public String getDept(Model model, Long id, String jdTypeCode, String type) {

        String sql = " select j.js_dept,kc_dept,sj_dept,sg_dept,jl_dept,jc_dept from jd_record j where j.JDTYPECODE='" + jdTypeCode + "' " +
                " and j.id='" + id + "' and j.typeCode='" + type + "'";
        List list = jdStopOrderQuestionService.findBySql(sql);
        List<AndroidJdRecord> result = new ArrayList<AndroidJdRecord>();
        for (Object o : list) {
            AndroidJdRecord record = new AndroidJdRecord();
            Object[] objects = (Object[]) o;
            record.setJsDept(String.valueOf(objects[0]));
            record.setKcDept(String.valueOf(objects[1]));
            record.setSjDept(String.valueOf(objects[2]));
            record.setSgDept(String.valueOf(objects[3]));
            record.setJlDept(String.valueOf(objects[4]));
            record.setJcDept(String.valueOf(objects[5]));
            result.add(record);

        }
        model.addAttribute("msg", JSONArray.fromObject(result).toString());
        return "common/androidMsg";
    }

    /**
     * 保存完监督记录后获取改记录的指令单问题
     *
     * @param id         .
     * @param model
     * @param jdTypeCode
     * @return .
     */
    @RequestMapping
    public String getJdQuestions(Model model, Long id, Long recordid, String jdTypeCode) {
        if (null == id) id = 0L;
        if (null == recordid) recordid = 0L;
        if (StringHelper.isEmpty(jdTypeCode)) jdTypeCode = "";
        String sql = "select q.id,q.record_id,q.Jd_type_code,q.question_desc,q.unlaw_desc,q.unlaw_id,q.jd_person_desc" +
                " from JD_RECORD_QUESTION q " +
                " where q.RECORD_ID ={0}" +
                " and q.JD_TYPE_CODE='{1}' " +
                " and q.id not in( SELECT RECORD_QUESTION_ID  as id from JD_STOP_ORDER_QUESTION where REFORM_ORDER_ID  in " +
                "(select id from jd_stop_order " +
                "where JD_TYPE_CODE ='{2}' and RECORD_ID = {3}) ) ";
        sql = FormatUtils.format(sql, String.valueOf(recordid), jdTypeCode,jdTypeCode,String.valueOf(recordid));
        List list = jdStopOrderQuestionService.findBySql(sql);
        List<AndroidJdRecordQuestion> result = new ArrayList<AndroidJdRecordQuestion>();
        for (Object o : list) {
            AndroidJdRecordQuestion question = new AndroidJdRecordQuestion();
            Object[] objects = (Object[]) o;
            if (!StringHelper.isEmpty(String.valueOf(objects[0])) && !"null".equals(String.valueOf(objects[0]))) {
                question.setId(Long.valueOf(String.valueOf(objects[0])));
                if (!StringHelper.isEmpty(String.valueOf(objects[1])) && !"null".equals(String.valueOf(objects[1])))
                    question.setRecordid(Long.valueOf(String.valueOf(objects[1])));
                question.setTypeCode(String.valueOf(objects[2]));
                question.setDictName(String.valueOf(objects[3]));
                question.setRefRule(String.valueOf(objects[4]));
                if (!StringHelper.isEmpty(String.valueOf(objects[5])) && !"null".equals(String.valueOf(objects[5])))
                    question.setPersonId(Long.parseLong(String.valueOf(objects[5])));
                question.setPersonName(String.valueOf(objects[6]));
                result.add(question);
            }
        }
        model.addAttribute("msg", JSONArray.fromObject(result).toString());
        return "common/androidMsg";
    }

    /**
     * 保存（整改/暂缓/停工指令单）
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveJdStopOrder(@RequestBody AndroidJdStopOrder result, Model model, String userName) throws Exception {
        JdStopOrder target;
        if (null != result.getId()) {
            target = jdStopOrderService.get(result.getId());
        } else {
            target = new JdStopOrder();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, +10);
            target.setOrderNo(jdStopOrderManager.getStopOrderOrderNo(result.getFormCode()));
            target.setYear(calendar.get(Calendar.YEAR));

            target.setStatus(result.getStatus());
            target.setFormCode(result.getFormCode());
            target.setJdTypeCode(result.getJdTypeCode());
            target.setJdAttributeCode(result.getType());
            target.setRecordId(result.getRecordId());
            target.setDutyDept(result.getDutyDept());
            target.setProjectName(result.getProjectName());
            target.setBjbh(result.getBjbh());
            target.setRecheckOther(result.getRecheckOther());
            target.setRecheckDept(result.getRecheckDept());
            target.setReformArea(result.getReformArea());
            if (!StringHelper.isEmpty(result.getReformBeginDate()))
                target.setReformBeginDate(new Timestamp(Long.parseLong(result.getReformBeginDate())));
            if (!StringHelper.isEmpty(result.getReformLimit()))
                target.setReformLimit(new Date(Long.parseLong(result.getReformLimit())));
            target.setSignDept(result.getSignDept());
            target.setSignPerson(result.getSignPerson());
            if (!StringHelper.isEmpty(result.getSignDate()))
                target.setSignDate(new Date(Long.parseLong(result.getSignDate())));
            target.setDescription(result.getDescription());

            jdStopOrderService.save(target);
            if (target.getStatus() != JdStopOrderStatus.STATUS_EDIT.getCode()) {
                createOaTask(target);
            }
        }

        // 不需要删除，在接口getJdQuestions()已经做了过滤，之前选择过的问题不再显示
//        if (null != target.getJdStopOrderQuestions()) {
//            for (JdStopOrderQuestion jdStopOrderQuestion : target.getJdStopOrderQuestions()) {
//                jdStopOrderQuestionService.delete(jdStopOrderQuestion);
//            }
//        }
        if (result.getQuestionList() != null && result.getQuestionList().size() > 0) {
            for (AndroidJdRecordQuestion question : result.getQuestionList()) {
                JdStopOrderQuestion jdStopOrderQuestion = new JdStopOrderQuestion();
                if (null != question.getId()) {
                    JdRecordQuestion jdRecordQuestion = jdRecordQuestionService.get(question.getId());
                    jdStopOrderQuestion.setRecordQuestion(jdRecordQuestion);
                    jdStopOrderQuestion.setReformOrder(target);
                    jdStopOrderQuestionService.save(jdStopOrderQuestion);
                }
            }
        }
        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg("保存成功");
        msg.setId(target.getId());
        String typeMsg = "";
        if (AndroidConst.TYPE_REFORM.equals(target.getFormCode())) {
            typeMsg += "jdReformOrder";
        } else if (AndroidConst.TYPE_SUSPEND.equals(target.getFormCode())) {
            typeMsg += "jdSuspendOrder";
        } else if (AndroidConst.TYPE_STOP.equals(target.getFormCode())) {
            typeMsg += "jdStopOrder";
        }
        msg.setType(typeMsg);
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(JdStopOrder data) throws Exception {
        //创建任务
        int Status = data.getStatus();
        if (Status == JdStopOrderStatus.STATUS_UNREFORMED.getCode()) {//整改中
            SysRegPerson dutyUser = null;
            Set<Long> managers = new HashSet<Long>();
            //获取单位负责人
            if (null != regPersonManager.getSysRegPersonByBjbh(data.getBjbh())) {
                dutyUser = regPersonManager.getSysRegPersonByBjbh(data.getBjbh());
                String hql = "from SysUser where regPerson='" + dutyUser.getId() + "'";
                List<SysUser> list = sysUserService.findByQuery(hql);
                SysUser sysUser = null;
                sysUser = list.iterator().next();
                managers.add(sysUser.getId());
            }

            String title = "";
            if (data.getFormCode().equals("reform")) {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Reform");
            } else if (data.getFormCode().equals("stop")) {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Stop");

            } else {
                title = oaTaskManager.getTaskTitle(data, JdStopOrder.class.getSimpleName() + "_Suspend");
            }
            if (managers.size() > 0) {
                oaTaskManager.createTask(JdStopOrder.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
    }

    /**
     * 查询在监项目
     *
     * @param bjbh
     * @param jdTaskCode
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getExcelJdTasks(Model model, String bjbh, String jdTaskCode, String projectName) throws Exception {
        String sql = " SELECT id,jd_Datetime,bjbh,jd_task_code,Project_name,project_add ,js_unit_name,js_unit_add," +
                " js_linkman,js_Phone,x,y " +
                "   FROM EXCEL_JD_TASKS  where 1=1 ";
        if (!StringHelper.isEmpty(projectName)) {
            sql += "  and project_Name like '%" + projectName + "%'";
        }
        if (!StringHelper.isEmpty(bjbh)) {
            sql += "  and bjbh ='" + bjbh + "'";
        }
        if (!StringHelper.isEmpty(jdTaskCode)) {
            sql += " and jd_Task_Code ='" + jdTaskCode + "'";
        }
        List list = jdStopOrderService.findBySql(sql);
        List<AndroidExcelJdTasks> result = new ArrayList<AndroidExcelJdTasks>();
        for (Object o : list) {
            AndroidExcelJdTasks tasks = new AndroidExcelJdTasks();
            Object[] objects = (Object[]) o;
            tasks.setId(Long.valueOf(String.valueOf(objects[0])));
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            tasks.setJdDatetime(String.valueOf(sp.parse(String.valueOf(objects[1])).getTime()));
            tasks.setBjbh(String.valueOf(objects[2]));
            tasks.setJdTaskCode(String.valueOf(objects[3]));
            tasks.setProjectName(String.valueOf(objects[4]));
            tasks.setProjectAdd(String.valueOf(objects[5]));
            tasks.setJsUnitName(String.valueOf(objects[6]));
            tasks.setJsUnitAdd(String.valueOf(objects[7]));
            tasks.setJsLinkman(String.valueOf(objects[8]));
            tasks.setJsPhone(String.valueOf(objects[9]));
            if (!StringHelper.isEmpty(String.valueOf(objects[10])) && !"null".equals(String.valueOf(objects[10])))
                tasks.setX(Double.parseDouble(String.valueOf(objects[10])));
            if (!StringHelper.isEmpty(String.valueOf(objects[11])) && !"null".equals(String.valueOf(objects[11])))
                tasks.setY(Double.parseDouble(String.valueOf(objects[11])));
            result.add(tasks);
        }

        model.addAttribute("msg", JSONArray.fromObject(result).toString());
        return "common/androidMsg";
    }

    /**
     * 根据监督任务书编号查询监督记录
     *
     * @param jdTaskCode
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getJdRecordFromJdTaskCode(Model model, String jdTaskCode) throws Exception {

        String sql = " select o.FORM_CODE,j.JD_TASK_CODE,o.PROJECT_NAME,o.DUTY_DEPT,o.reform_Limit ,o.status ,o.id" +
                "  from JD_STOP_ORDER o  " +
                " left join jd_record j on j.JDTYPECODE=o.JD_TYPE_CODE and o.RECORD_ID=j.ID " +
                " where j.JD_TASK_CODE = '" + jdTaskCode + "'  ";
        List list = jdStopOrderService.findBySql(sql);
        List<AndroidJdStopOrder> result = new ArrayList<AndroidJdStopOrder>();
        for (Object o : list) {
            AndroidJdStopOrder record = new AndroidJdStopOrder();
            Object[] objects = (Object[]) o;
            record.setFormCode(String.valueOf(objects[0]));
            String fromCode = String.valueOf(objects[0]);
            if ("reform".equals(fromCode)) {
                record.setFormCodeDesc("整改指令单");
            } else if ("suspend".equals(fromCode)) {
                record.setFormCodeDesc("局部暂缓指令单");
            } else if ("stop".equals(fromCode)) {
                record.setFormCodeDesc("停工指令单");
            }
            record.setJdTypeCode(String.valueOf(objects[1]));
            record.setProjectName(String.valueOf(objects[2]));
            record.setDutyDept(String.valueOf(objects[3]));
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            record.setReformLimit(String.valueOf(sp.parse(String.valueOf(objects[4])).getTime()));
            if (!StringHelper.isEmpty(String.valueOf(objects[5])) && !"null".equals(String.valueOf(objects[5]))) {
                Integer status = Integer.parseInt(String.valueOf(objects[5]));
                record.setStatus(status);
                if (JdStopOrderStatus.STATUS_EDIT.getCode() == status) {
                    record.setStatusDesc("填写");
                } else if (JdStopOrderStatus.STATUS_UNREFORMED.getCode() == status) {
                    record.setStatusDesc("整改中");
                } else if (JdStopOrderStatus.STATUS_REFORMED.getCode() == status) {
                    record.setStatusDesc("已经整改");
                }
            }
            if (!StringHelper.isEmpty(String.valueOf(objects[6])) && !"null".equals(String.valueOf(objects[6])))
                record.setId(Long.parseLong(String.valueOf(objects[6])));
            result.add(record);
        }

        model.addAttribute("msg", JSONArray.fromObject(result).toString());
        return "common/androidMsg";
    }
}
