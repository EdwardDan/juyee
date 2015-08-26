package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMeetingService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaMeeting;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.OaInnerMeetingStatus;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @description:内部会议管理
 * @author: subo
 * @revisor: Stanley
 */
@Controller
public class OaMeetingController extends BaseCRUDActionController<OaMeeting> {

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private OaMeetingService oaMeetingService;

    @Autowired
    private SysPersonService sysPersonService;

    /**
     * 会议室查看与会议室管理列表tab页
     *
     * @return
     */
    @RequestMapping
    public String init() {
        return "view/oa/oaMeeting/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_EDIT));
        model.addAttribute("canAudit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_AUDIT));
        model.addAttribute("canDelete", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_DELETE));
        model.addAttribute("STATUS_EDIT", OaInnerMeetingStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaInnerMeetingStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("STATUS_BACK", OaInnerMeetingStatus.STATUS_BACK.getCode());
        model.addAttribute("STATUS_PASS", OaInnerMeetingStatus.STATUS_PASS.getCode());
        model.addAttribute("currentUser", sysUserManager.getSysUser().getLoginName());
        return "view/oa/oaMeeting/grid";
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
    public void gridDataCustom(HttpServletRequest request, HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMeeting where 1 = 1 ";
            String useDateFrom = request.getParameter("useDateFrom"), useDateTo = request.getParameter("useDateTo"), useAtTime = request.getParameter("useTime");
            if (StringHelper.isNotEmpty(useDateFrom)) {
                hql = hql.concat("and useDate >= to_date(\'" + useDateFrom + "\', \'" + "yyyy-MM-dd" + "\') ");
            }
            if (StringHelper.isNotEmpty(useDateTo)) {
                hql = hql.concat("and useDate <= to_date(\'" + useDateTo + "\', \'" + "yyyy-MM-dd" + "\') ");
            }
            if (StringHelper.isNotEmpty(useAtTime)) {
                hql = hql.concat("and useTime = \'" + useAtTime + "\' ");
            }
            hql = hql.concat("order by useDate desc");
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = oaMeetingService.findByPage(pageModel, queryTranslate.toString());
            columns += ",useDate";
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                String useDate = (String) bean.get("useDate");
                String useTime = (String) bean.get("useTime");
                String td = useDate + " " + useTime;
                bean.put("useTime", td);
            }
            String json = GridJq.toJSON(list, pageModel);
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
        OaMeeting oaMeeting = new OaMeeting();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String now = format.format(calendar.getTime());
        oaMeeting.setUseDate(Date.valueOf(now));
        String applyPerson = sysUserManager.getSysUser().getDisplayName();
        oaMeeting.setApplyPerson(applyPerson);
        String applyDept = sysUserManager.getSysUser().getPerson().getDeptName();
        oaMeeting.setApplyDept(applyDept);
        model.addAttribute("STATUS_EDIT", OaInnerMeetingStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaInnerMeetingStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("innerPersons", getInnerPersons(oaMeeting.getInnerPersons()));
        model.addAttribute("uploadButton", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaMeeting.class.getSimpleName(), oaMeeting.getDoc(), sysUserManager.getSysUser().getId(), null, null));
        model.addAttribute("bean", oaMeeting);
        return "view/oa/oaMeeting/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        OaMeeting oaMeeting = oaMeetingService.get(id);
        model.addAttribute("innerPersons", getInnerPersons(oaMeeting.getInnerPersons()));
        model.addAttribute("uploadButton", documentManager.getUploadButtonForMulti(documentManager.getDefaultXmlConfig(), OaMeeting.class.getSimpleName(), oaMeeting.getDoc(), sysUserManager.getSysUser().getId(), null, null));
        model.addAttribute("STATUS_EDIT", OaInnerMeetingStatus.STATUS_EDIT.getCode());
        model.addAttribute("STATUS_SUBMIT", OaInnerMeetingStatus.STATUS_SUBMIT.getCode());
        model.addAttribute("bean", oaMeeting);
        return "view/oa/oaMeeting/input";
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
        OaMeeting oaMeeting = oaMeetingService.get(id);
        model.addAttribute("innerPersons", getInnerPersons(oaMeeting.getInnerPersons()));
        model.addAttribute("downloadButton", documentManager.getDownloadButton(oaMeeting.getDoc()));
        model.addAttribute("bean", oaMeeting);
        return "view/oa/oaMeeting/view";
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
        oaMeetingService.delete(id);
        oaTaskManager.removeTask(OaMeeting.class.getSimpleName(), id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 审核前操作
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String beforeAudit(Model model, Long id) {
        OaMeeting oaMeeting = oaMeetingService.get(id);
        oaMeeting.setAuditOpinion("");
        model.addAttribute("innerPersons", getInnerPersons(oaMeeting.getInnerPersons()));
        model.addAttribute("downloadButton", documentManager.getDownloadButton(oaMeeting.getDoc()));
        model.addAttribute("bean", oaMeeting);
        model.addAttribute("STATUS_BACK", OaInnerMeetingStatus.STATUS_BACK.getCode());
        model.addAttribute("STATUS_PASS", OaInnerMeetingStatus.STATUS_PASS.getCode());
        return "view/oa/oaMeeting/audit";
    }

    /**
     * 颜色说明
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String beforeViewMeeting(Model model) {
        Map<String, String> colorDeclare = new HashMap<String, String>();
        colorDeclare.put("审批完成", "#00B0F0");
        colorDeclare.put("申请中", "#FFFF00");
        model.addAttribute("colorDeclare", colorDeclare);
        return "view/oa/oaMeeting/viewMeeting";
    }

    /**
     * 查看会议室
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewMeeting(Model model, HttpServletRequest request) {
        //日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //开始日期
        String startDte = request.getParameter("startDate");
        //结束日期
        String endDate = request.getParameter("endDate");
        Date start = Date.valueOf(startDte);
        Date end = Date.valueOf(endDate);
        //所有的会议室
        List<SysCodeDetail> rooms = sysCodeManager.getCodeListByCode(Constants.OA_MEETING_ROOM);
        String hql = "from OaMeeting where status != ? and useDate between ? and ? order by id desc";
        //找到所有符合的记录
        List<OaMeeting> oaMeetings = oaMeetingService.find(hql, OaInnerMeetingStatus.STATUS_EDIT.getCode(), start, end);
        //将时间段封装map<日期，周>
        Map<String, String> period = new TreeMap<String, String>();
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(start);
        while (!tempCal.getTime().after(end)) {
            period.put(format.format(tempCal.getTime()), String.valueOf(tempCal.get(Calendar.DAY_OF_WEEK) - 1));
            tempCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        //星期数组
        String[] weeks = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        //日期上下午数组
        String[] times = {"上午", "下午"};
        //数据处理Map<会议室,Map<上/下午,Map<日期,数据>>>
        Map<SysCodeDetail, Map<String, Map<String, String[]>>> meetings = new LinkedHashMap<SysCodeDetail, Map<String, Map<String, String[]>>>();
        //遍历会议室
        for (SysCodeDetail room : rooms) {
            Map<String, Map<String, String[]>> data = new TreeMap<String, Map<String, String[]>>();
            //遍历日期上下午
            for (String time : times) {
                Map<String, String[]> w = new TreeMap<String, String[]>();
                Iterator<String> it = period.keySet().iterator();
                //遍历得到的日期
                while (it.hasNext()) {
                    String key = it.next();
                    String value = period.get(key);
                    //遍历数据库中查到的数据
                    for (OaMeeting oaMeeting : oaMeetings) {
                        //得到房间
                        String roomName = oaMeeting.getRoom().getName();
                        //得到日期
                        Date date = oaMeeting.getUseDate();
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        //得到周
                        int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
                        //得到时间
                        String t = oaMeeting.getUseTime();
                        String d = format.format(date);
                        //比较会议室
                        boolean f1 = roomName.equals(room.getName());
                        //比较时间
                        boolean f2 = t.equals(time);
                        //比较周
                        boolean f3 = value.equals(String.valueOf(weekDay));
                        //比较日期
                        boolean f4 = key.equals(d);
                        if (f1 && f2 && f3 & f4) {
                            String color = "";
                            if (oaMeeting.getStatus() == OaInnerMeetingStatus.STATUS_PASS.getCode()) {
                                color = "#00B0F0";   //审核完成
                            } else {
                                color = "#FFFF00";
                            }
                            String[] values = new String[4];
                            values[0] = oaMeeting.getTitle();
                            values[1] = color;
                            values[2] = t;
                            values[3] = String.valueOf(oaMeeting.getId());
                            w.put(key, values);
                            break;
                        }
                    }
                    //如果值为空的情况
                    if (w.get(key) == null) {
                        w.put(key, null);
                    }
                }
                data.put(time, w);
            }
            meetings.put(room, data);
        }
        //标题
        String title = "会议室";
        //标题显示
        List<String> showTitle = new LinkedList<String>();
        Iterator<String> t = period.keySet().iterator();
        while (t.hasNext()) {
            String key = t.next();
            String value = period.get(key);
            //生成标题
            String string = weeks[Integer.parseInt(value)] + "<br />(" + key + ")";
            showTitle.add(string);
        }
        model.addAttribute("showTitle", showTitle);
        model.addAttribute("title", title);
        model.addAttribute("bean", meetings);
        return "view/oa/oaMeeting/data";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("bean") OaMeeting entity) throws Exception {
        try {
            OaMeeting target;
            if (entity.getId() != null) {
                target = oaMeetingService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "applyDept",
                        "applyPerson",
                        "room",
                        "useDate",
                        "useTime",
                        "personNum",
                        "innerPersons",
                        "outerPersons",
                        "title",
                        "content",
                        "description",
                        "status",
                });
            } else {
                target = entity;
            }
            target.setRoomDesc(sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("room"))).getName());
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId)) {
                DocDocument docDocument = documentManager.getDocDocument(Long.valueOf(docId));
                target.setDoc(docDocument);
                documentManager.updateDocumentByBizData(docDocument, OaMeeting.class.getSimpleName(), docDocument.getName());
            }
            if (isRoomOnDateAvailable(target)) {
                oaMeetingService.save(target);
                sendSuccessJSON(response, "保存成功");
            } else {
                sendSuccessJSON(response, "日期不可用，保存失败");
            }
            if (target.getStatus() != OaInnerMeetingStatus.STATUS_EDIT.getCode()) {//创建待办事项
                createOaTask(target);
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 审核操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception
     */
    @RequestMapping
    public void audit(HttpServletResponse response, @ModelAttribute("bean") OaMeeting entity) throws Exception {
        try {
            OaMeeting target = oaMeetingService.get(entity.getId());
            ReflectionUtils.copyBean(entity, target, new String[]{
                    "status",
                    "auditOpinion"
            });
            target.setAuditUser(sysUserManager.getSysUser().getDisplayName());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String now = format.format(calendar.getTime());
            target.setAuditTime(Timestamp.valueOf(now));
            oaMeetingService.save(target);
            createOaTask(target);
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "审核成功");
    }

    /**
     * 创建系统任务
     *
     * @param data .
     * @throws Exception .
     */
    public void createOaTask(OaMeeting data) throws Exception {
        int Status = data.getStatus();
        //创建任务
        if (Status == OaInnerMeetingStatus.STATUS_SUBMIT.getCode()) {
            String privilegeCode = PrivilegeCode.OA_MEETING_AUDIT;
            String title = oaTaskManager.getTaskTitle(data, OaMeeting.class.getSimpleName());
            Set<Long> managers = sysUserManager.getUserIdsByPrivilegeCode(privilegeCode);
            if (managers.size() > 0) {
                oaTaskManager.createTask(OaMeeting.class.getSimpleName(), data.getId(), title, managers, false, null, null);
            }
        }
        if (Status == OaInnerMeetingStatus.STATUS_PASS.getCode() || Status == OaInnerMeetingStatus.STATUS_BACK.getCode()) {
            SysUser sysUser = sysUserManager.getSysUser();
            SysUser receiveUser = sysUserManager.getSysUserByDisplayName(data.getApplyPerson());
            String msgTemp = oaTaskManager.getTaskTitle(data, OaMeeting.class.getSimpleName() + "_Pass");
            if (Status == OaInnerMeetingStatus.STATUS_BACK.getCode()) {
                msgTemp = oaTaskManager.getTaskTitle(data, OaMeeting.class.getSimpleName() + "_Back");
            }
            String[] ids = new String[1];
            if (null != receiveUser) {
                ids[0] = String.valueOf(receiveUser.getId());
                msgMessageManager.sendSmsByUser(msgTemp, sysUser, ids);
            }
        }
    }

    /**
     * 判断日期是否可用
     *
     * @param oaMeeting .
     * @return .
     */
    public boolean isRoomOnDateAvailable(OaMeeting oaMeeting) {
        String hql = "";
        List<OaMeeting> oaMeetings = null;
        if (oaMeeting.getId() != null) {
            hql = "from OaMeeting where status != ? and id != ?";
            oaMeetings = oaMeetingService.find(hql, OaInnerMeetingStatus.STATUS_EDIT.getCode(), oaMeeting.getId());
        } else {
            hql = "from OaMeeting where status != ?";
            oaMeetings = oaMeetingService.find(hql, OaInnerMeetingStatus.STATUS_EDIT.getCode());
        }
        boolean flag = true;
        for (OaMeeting o : oaMeetings) {
            String roomName = o.getRoom().getName();
            Date date = o.getUseDate();
            String time = o.getUseTime();
            if (oaMeeting.getRoom().getName().equals(roomName) && oaMeeting.getUseDate().equals(date) && oaMeeting.getUseTime().equals(time)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 获取内部参会人员
     *
     * @param innerPersonIds
     * @return
     */
    private List<SysPerson> getInnerPersons(String innerPersonIds) {
        if (StringHelper.isNotEmpty(innerPersonIds)) {
            List<SysPerson> persons = sysPersonService.findByQuery("from SysPerson where id in (" + innerPersonIds + ") ");
            for (SysPerson person : persons) {
                person.setName(person.getName() + "(" + person.getDept().getName() + ")");
            }
            return persons;
        }
        return null;
    }
}