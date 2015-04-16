package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.android.*;
import com.justonetech.biz.domain.bean.jdRecord.JdProjectInfo;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.JdRecordType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.FileUtils;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * note:安全质量监督接口
 * User: Shaxj
 * Date: 14-8-4
 * Time: 下午1:04
 */
@Controller
public class AndroidJdRecordController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidJdRecordController.class);

    @Autowired
    private JdRecordFirstService jdRecordFirstService;

    @Autowired
    private JdRecordSafeService jdRecordSafeService;

    @Autowired
    private JdRecordQualityService jdRecordQualityService;

    @Autowired
    private JdRecordCompleteService jdRecordCompleteService;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private JdRecordManager jdRecordManager;

    @Autowired
    private PlanMainInfoManager planMainInfoManager;

    @Autowired
    private JdRecordQuestionService jdRecordQuestionService;

    @Autowired
    private ExcelJdDwgcService excelJdDwgcService;

    @Autowired
    private JdRecordCompleteDwgcService jdRecordCompleteDwgcService;

    @Autowired
    private JdRecordCompleteResultService jdRecordCompleteResultService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private JdRecordPersonService jdRecordPersonService;

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private JdRecordCompCheckitemService jdRecordCompCheckitemService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocDocumentAttachService docDocumentAttachService;

    @Autowired
    private ConfigManager configManager;


    /**
     * 上传照片 --客户端接口
     */
    @RequestMapping
    public String savePhoto(@RequestBody AndroidJdPhoto[] list, Model model) throws Exception {

        String bizCode = "JdRecord";
        //  创建文档
        DocCategory category = documentManager.findCategoryByBizCode(bizCode);
        DocDocument document = documentManager.createNewDocument(documentManager.getDefaultXmlConfig(), category);
        docDocumentService.save(document);

        Long docId = document.getId();
        DocDocument doc =docDocumentService.get(docId);
        String docPath = documentManager.getDocPath(documentManager.findCategoryByBizCode(bizCode), "");
        for (int i = 0; i < list.length; i++) {
            DocDocumentAttach documentAttach = new DocDocumentAttach();
            if (docId != null) {
                documentAttach.setDocument(doc);
            }
            uploadSave(list[i], i, docPath, documentAttach);
            docDocumentAttachService.save(documentAttach);
        }
        //        documentManager.getAttachInfo(documentAttach, request, bizCode, "");
        model.addAttribute("msg", docId);
        return "common/androidMsg";
    }

    /**
     * 上传照片 --服务器端调用
     */
    public Long savePhoto(List<AndroidJdPhoto> list) throws Exception {

        String bizCode = "JdRecord";
        //  创建文档
        DocCategory category = documentManager.findCategoryByBizCode(bizCode);
        DocDocument document = documentManager.createNewDocument(documentManager.getDefaultXmlConfig(), category);
        docDocumentService.save(document);

        Long docId = document.getId();
        DocDocument doc =docDocumentService.get(docId);
        String docPath = documentManager.getDocPath(documentManager.findCategoryByBizCode(bizCode), "");
        for (int i = 0; i < list.size(); i++) {
            DocDocumentAttach documentAttach = new DocDocumentAttach();
            if (docId != null) {
                documentAttach.setDocument(doc);
            }
            uploadSave(list.get(i), i, docPath, documentAttach);
            docDocumentAttachService.save(documentAttach);
        }
        //        documentManager.getAttachInfo(documentAttach, request, bizCode, "");
        return docId;
    }

    /**
     * 获取文件存放的临时路径
     *
     * @return
     */
    public String getTempPath() {
        return configManager.getFilePath() + "temp";
    }

    /**
     * 附件上传保存页面
     *
     * @throws java.io.IOException .
     */
    public void uploadSave(AndroidJdPhoto androidJdPhoto, Integer i, String path, DocDocumentAttach attach) throws Exception {

        String originalFileName = androidJdPhoto.getName();
        //临时目录
        String dir = getTempPath();
        if (StringUtils.isNotEmpty(path)) {
            dir = path;
        }

        String fileext = FileUtils.getFileExt(originalFileName);
        if (!FileUtils.checkFileExt(originalFileName)) {
            throw new Exception("上传失败，文件后缀名不合法");
        }

        String fileName = null;
        String fullPathName = null;

        if (!StringHelper.isEmpty(originalFileName)) {
            //保存文件的名字为在上传的文件名字后面加上当前的时间毫秒数
            fileName = FileUtils.getFileWithoutExt(originalFileName) + "_" + i + "_" +
                    String.valueOf(System.currentTimeMillis()) + "." + fileext;
            fullPathName = dir + File.separator + fileName;
            File file = new File(fullPathName);
//            if (!file.exists()) {
//                file.mkdirs();
//            }

            String pic = androidJdPhoto.getPhotoByte();
            if (!StringHelper.isEmpty(pic)) {
                byte[] photo = org.apache.commons.codec.binary.Base64.decodeBase64(pic.getBytes());
                org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(fullPathName), photo);
            }
        }
        if (attach != null) {
            attach.setFileName(originalFileName);
            attach.setSaveFileName(fileName);
        }
    }


    /**
     * 获取当前用户的所有任务接口
     *
     * @param rn  页数，1表示第一页
     * @param max 每页显示记录数
     * @return json.
     */
    @RequestMapping
    public String getJdRecord(Model model, HttpServletRequest request, Long rn, Integer max, String userName) throws ParseException {
        if (null == max) max = 10;
        if (null == rn) rn = 1L;
        Long statusid = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_NOCHECK).getId();
        Long mainStatusid = sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EXCUTE).getId();
        if (!StringHelper.isEmpty(userName)) {
            userName = StringHelper.findAndReplace(userName, "'", "");
            SysUser sysUser = sysUserManager.getSysUser(userName);
            String hqlProblem = " select * from (SELECT  id,project_name,TYPE,JD_TASK_CODE,listagg(person_id,',')  within GROUP (order by person_id)as person_ids ," +
                    " listagg(person_name,',')  within GROUP (order by person_name)as person_names ,plan_end_time,bjbh" +
                    "  FROM(SELECT p.id,e.project_name  as project_name,d.name as TYPE ,p.JD_TASK_CODE as JD_TASK_CODE,NVL(su.id,-1) as person_id,NVL(su.display_name,-1) as person_name ,p.plan_end_time,p.bjbh" +
                    " FROM  PLAN_DETAIL P " +
                    "  LEFT JOIN PLAN_DETAIL_USER U ON U .PLAN_DETAIL_ID = P . ID " +
                    " LEFT JOIN SYS_USER su on su.id=u.user_id  " +
                    " left Join EXCEL_JD_TASKS e on e.jd_task_code= p.jd_task_code " +
                    " left join PLAN_MAIN_INFO  M on M.id=p.Plan_id " +
                    " left join SYS_CODE_DETAIL D on d.id= M.Plan_type " +
                    " where p.status =" + statusid + " and m.plan_status =" + mainStatusid + ") " +
                    " group by id,project_name  ,TYPE  ,JD_TASK_CODE ,plan_end_time,bjbh)  " +
                    " where instr(person_ids,'" + sysUser.getId() + "')>0 and instr(person_names,'" + sysUser.getDisplayName() + "')>0 ";

            List recordList = jdRecordFirstService.findBySql(hqlProblem);
            List<AndroidJdTask> androidJdTask = new ArrayList<AndroidJdTask>();
            for (Object o : recordList) {
                AndroidJdTask task = new AndroidJdTask();
                Object[] objects = (Object[]) o;
                if (!StringHelper.isEmpty(String.valueOf(objects[0])) && !"null".equals(String.valueOf(objects[0])))
                    task.setId(Long.parseLong(String.valueOf(objects[0])));
                task.setProjectName(String.valueOf(objects[1]));
                task.setType(String.valueOf(objects[2]));
                task.setJdTaskCode(String.valueOf(objects[3]));
                task.setBjbh(String.valueOf(objects[7]));
                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                task.setJdDatetime(String.valueOf(sp.parse(String.valueOf(objects[6])).getTime()));
                String personIds[] = String.valueOf(objects[4]).split(",");
                String personNames[] = String.valueOf(objects[5]).split(",");
                List<AndroidJdPersonInfo> plist = new ArrayList<AndroidJdPersonInfo>();
                for (int i = 0; i < personIds.length; i++) {
                    AndroidJdPersonInfo androidJdPersonInfo = new AndroidJdPersonInfo();
                    androidJdPersonInfo.setId(Long.parseLong(personIds[i]));
                    androidJdPersonInfo.setName(personNames[i]);
                    plist.add(androidJdPersonInfo);
                }
                task.setJdPersons(plist);
                androidJdTask.add(task);
            }

            model.addAttribute("msg", JSONArray.fromObject(androidJdTask).toString());
        }
        return "common/androidMsg";
    }

    /**
     * 根据监督任务书编号获取工程信息
     *
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getDwgcsByJdTaskCode(String jdTaskCode, Model model) {
        String json = "";
        List<ExcelJdDwgc> dwgcLists = excelJdTasksManager.getExcelJdDwgcs(jdTaskCode);
        List<AndroidDwgc> dwgc = new ArrayList<AndroidDwgc>();
        if (dwgcLists != null) {
            for (ExcelJdDwgc ex : dwgcLists) {
                AndroidDwgc androidDwgc = new AndroidDwgc();
                androidDwgc.setId(ex.getId());
                androidDwgc.setName(ex.getDwgcName());
                androidDwgc.setCode(ex.getDwgcCode());
                dwgc.add(androidDwgc);
            }
            JSONArray jsonArray = JSONArray.fromObject(dwgc);
            json = jsonArray.toString();
        }
        model.addAttribute("msg", json);
        return "common/androidMsg";
    }

    /**
     * 通过监督任务书编号获取工程信息
     *
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String jdTaskCode, Model model) {
        JdProjectInfo jdProjectInfo = jdRecordManager.getProjectInfo(jdTaskCode);
        JSONArray jsonArray = JSONArray.fromObject(jdProjectInfo);
        String json = jsonArray.toString();
        model.addAttribute("msg", json);
        // 安卓端口接收domain为AndroidJdRecordCjdw
        return "common/androidMsg";
    }

    /**
     * 获取巡查问题查询条件下拉数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getDictOption(Model model) {
        String sql = "select id ,name  from Polling_Dict where parent_id is null order by tree_Id asc ";
        List recordList = jdRecordFirstService.findBySql(sql);
        List<AndroidPollingDictOption> list = new ArrayList<AndroidPollingDictOption>();
        for (Object o : recordList) {
            AndroidPollingDictOption dict = new AndroidPollingDictOption();
            Object[] objects = (Object[]) o;
            dict.setId(Long.valueOf(String.valueOf(objects[0])));
            dict.setName(String.valueOf(objects[1]));
            list.add(dict);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        model.addAttribute("msg", jsonArray.toString());
        return "common/androidMsg";
    }

    /**
     * 获取巡查问题
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getDict(Model model, String refRule, String name, Long parentId) {
        String sql1 = "";
        String ids = "";
        // 判断是否选择了父节点，如果选择了父节点，则取出当前节点下的所有数据（取第三层数据，第二层数据舍弃）
        if (null != parentId) {
            sql1 += "select id ,name  from Polling_Dict where parent_id = " + parentId + " order by tree_Id asc";
            List list = jdRecordFirstService.findBySql(sql1);
            if (null != list && list.size() > 0) {
                for (Object o : list) {
                    Object[] objects = (Object[]) o;
                    ids += String.valueOf(objects[0]) + ",";
                }
            }
            if (ids.length() > 0) ids = ids.substring(0, ids.length() - 1);
        } else {
            // 如果没有父节点则数据全部取出
            sql1 += "select id ,name  from Polling_Dict where parent_id is null order by tree_Id asc";
            List list = jdRecordFirstService.findBySql(sql1);
            String treeIds = "";
            if (null != list && list.size() > 0) {
                for (Object o : list) {
                    Object[] objects = (Object[]) o;
                    treeIds += String.valueOf(objects[0]) + ",";
                }
            }
            if (treeIds.length() > 0) treeIds = treeIds.substring(0, treeIds.length() - 1);

            String sql2 = "select id ,name  from Polling_Dict where parent_id in (" + treeIds + ") order by tree_Id asc";
            List restList = jdRecordFirstService.findBySql(sql2);
            if (null != restList && restList.size() > 0) {
                for (Object o : restList) {
                    Object[] objects = (Object[]) o;
                    ids += String.valueOf(objects[0]) + ",";
                }
            }
            if (ids.length() > 0) ids = ids.substring(0, ids.length() - 1);
        }

        String sql = "SELECT ROWNUM RN,p.id,p.ref_rule ,p.name from Polling_Dict p where 1=1 " +
                "and parent_id in (" + ids + ")";
        if (!StringHelper.isEmpty(name)) {
            sql += " and (name like '%" + name + "%' or ref_Rule like '%" + name + "%')";
        }
        if (!StringHelper.isEmpty(refRule)) {
            sql += " and ref_Rule like '%" + refRule + "%' order by id desc";
        }
        List recordList = jdRecordFirstService.findBySql(sql);
        List<AndroidJdRecordDict> list = new ArrayList<AndroidJdRecordDict>();
        for (Object o : recordList) {
            AndroidJdRecordDict dict = new AndroidJdRecordDict();
            Object[] objects = (Object[]) o;
            dict.setRn(Integer.valueOf(String.valueOf(objects[0])));
            dict.setId(Long.valueOf(String.valueOf(objects[1])));
            dict.setRefRule(String.valueOf(objects[2]));
            dict.setName(String.valueOf(objects[3]));
            list.add(dict);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        model.addAttribute("msg", jsonArray.toString());
        return "common/androidMsg";
    }


    /**
     * 获取竣工检查内容及发现问题
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getCompleteCheckItem(Model model) {
        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        List<AndroidJdCompleteSysCode> sysCodeList = new ArrayList<AndroidJdCompleteSysCode>();
        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            AndroidJdCompleteSysCode sysCode = new AndroidJdCompleteSysCode();
            sysCode.setId(sysCodeDetail.getId());
            sysCode.setName(sysCodeDetail.getName());
            List<AndroidJdRecordCompleteCheckItem> list = new ArrayList<AndroidJdRecordCompleteCheckItem>();
            String hql = "from JdRecordCompCheckitem where type.id={0} order by id desc,orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem j : jdRecordCompCheckitems) {
                AndroidJdRecordCompleteCheckItem item = new AndroidJdRecordCompleteCheckItem();
                item.setId(j.getId());
                item.setCondition(j.getCondition());
                item.setSelectItems(j.getSelectItems());
                list.add(item);
            }
            sysCode.setJdRecordCompleteCheckItem(list);
            sysCodeList.add(sysCode);
        }
        JSONArray jsonArray = JSONArray.fromObject(sysCodeList);
        model.addAttribute("msg", jsonArray.toString());
        return "common/androidMsg";
    }

    /**
     * 获取施工进度
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getSgjd(Model model) {
        List<SysCodeDetail> sysCodeDetails = sysCodeManager.getCodeListByCode("PollingRecordStage");
        List<AndroidJdSgjd> list = new ArrayList<AndroidJdSgjd>();
        for (SysCodeDetail sd : sysCodeDetails) {
            AndroidJdSgjd androidJdSgjd = new AndroidJdSgjd();
            androidJdSgjd.setId(sd.getId());
            androidJdSgjd.setName(sd.getName());
            list.add(androidJdSgjd);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        model.addAttribute("msg", jsonArray.toString());
        return "common/androidMsg";
    }

    /**
     * 保存首次监督
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveJdRecordFirst(@RequestBody AndroidJdRecordFirst result, Model model, String userName) throws Exception {
        JdRecordFirst target;
        if (null != result.getId()) {
            target = jdRecordFirstService.get(result.getId());
        } else {
            target = new JdRecordFirst();
        }
        String attendPersons = "";
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!StringHelper.isEmpty(androidJdPersonInfos.getName())) {
                    attendPersons += androidJdPersonInfos.getName() + ",";
                }

//                if (!"".equals(androidJdPersonInfos.getId()) && null != androidJdPersonInfos.getId()) {
//                    SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
//                    attendPersons += sysUser1.getDisplayName() + ",";
//                }
            }
        }
        if (attendPersons.length() > 0) {
            attendPersons = attendPersons.substring(0, attendPersons.length() - 1);
        }
        target.setAttendPersons(attendPersons);
        target.setStatus(result.getStatus());
        target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_FIRST.getCode(), null));
        target.setJdTypeCode(result.getType());
        target.setJdTaskCode(result.getJdTaskCode());
        target.setBjbh(result.getBjbh());
        target.setProjectName(result.getProjectName());
        target.setWeather(result.getWeather());
        if (null != result.getJdDatetime())
            target.setJdDatetime(new java.sql.Date(Long.parseLong(result.getJdDatetime())));
        target.setJsDept(result.getJsDept());
        target.setKcDept(result.getKcDept());
        target.setSjDept(result.getSjDept());
        target.setSgDept(result.getSgDept());
        target.setJlDept(result.getJlDept());
        target.setJcDept(result.getJcDept());
        target.setInspectionContent(result.getInspectionContent());
        target.setNotifyContent(result.getNotifyContent());
        target.setDealOpinion(result.getDealOpinion());
        target.setDescription(result.getDescription());
        target.setJdTypeCode(result.getType());
        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        if (null != sysUser) {
            target.setJdManager(sysUser.getPerson());
            target.setJdManagerName(sysUser.getDisplayName());
        }
        // 单位工程
        if (null != result.getDwgc() && null != result.getDwgc().getId())
            target.setDwgc(excelJdDwgcService.get(result.getDwgc().getId()));
        // 照片
        if (null != result.getDocumentId())
            target.setDocument(docDocumentService.get(result.getDocumentId()));
        if (null != result.getPhotos())
            target.setDocument(docDocumentService.get(savePhoto(result.getPhotos())));
        jdRecordFirstService.save(target);
        if (null != result.getPlanDetailid()) {
            String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
            planMainInfoManager.setDetailStatus(result.getPlanDetailid(), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
        }

        String hql = "select j from JdRecordPerson j where j.recordId={0}";
        hql = FormatUtils.format(hql, target.getId());
        List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hql);
        for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
            jdRecordPersonService.delete(jdRecordPerson);
        }
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!"".equals(androidJdPersonInfos.getId())) {
                    JdRecordPerson jdRecordPerson = new JdRecordPerson();
                    jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_FIRST.getCode());
                    if (null != androidJdPersonInfos.getId()) {
                        SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
                        jdRecordPerson.setJdPerson(sysUser1.getPerson());
                        jdRecordPerson.setJdPersonDesc(sysUser1.getPerson().getName());
                        jdRecordPerson.setRecordId(target.getId());
                        // 保存参加监督人员
                        jdRecordPersonService.save(jdRecordPerson);
                    }
                }
            }
        }
        // 删除
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_FIRST.getCode(), Constants.JD_RECORD_FIRST_CHECK_NORMAL, target.getId());
        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }
        List<AndroidJdRecordQuestion> questions = result.getQuestions();
        if (null != questions && questions.size() > 0) {
            for (AndroidJdRecordQuestion ajq : questions) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_FIRST.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_FIRST_CHECK_NORMAL);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg("保存成功");
        msg.setId(target.getId());
        msg.setType("AndroidJdRecordFirst");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 保存安全监督
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveJdRecordSafe(@RequestBody AndroidJdRecordSafe result, Model model, String userName) throws Exception {

        JdRecordSafe target;
        if (null != result.getId()) {
            target = jdRecordSafeService.get(result.getId());
        } else {
            target = new JdRecordSafe();
        }
        String attendPersons = "";
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!StringHelper.isEmpty(androidJdPersonInfos.getName())) {
                    attendPersons += androidJdPersonInfos.getName() + ",";
                }

//                if (!"".equals(androidJdPersonInfos.getId()) && null != androidJdPersonInfos.getId()) {
//                    SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
//                    attendPersons += sysUser1.getDisplayName() + ",";
//                }
            }
        }
        if (attendPersons.length() > 0) {
            attendPersons = attendPersons.substring(0, attendPersons.length() - 1);
        }
        target.setAttendPersons(attendPersons);
        target.setStatus(result.getStatus());
        target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_SAFE.getCode(), null));
        target.setJsDept(result.getJsDept());
        target.setKcDept(result.getKcDept());
        target.setSjDept(result.getSjDept());
        target.setSgDept(result.getSgDept());
        target.setJlDept(result.getJlDept());
        target.setJcDept(result.getJcDept());
        target.setJdTaskCode(result.getJdTaskCode());
        target.setBjbh(result.getBjbh());
        target.setProjectName(result.getProjectName());
        target.setWeather(result.getWeather());
        if (null != result.getJdDatetime())
            target.setJdDatetime(new java.sql.Date(Long.parseLong(result.getJdDatetime())));
        target.setScheduleItems(result.getScheduleItems());
        target.setInspectionContent(result.getContent());
        target.setInspectionContent(result.getInspectionContent());
        target.setInspectionPosition(result.getInspectionPosition());
        target.setDealOpinion(result.getDealOpinion());
        target.setDescription(result.getDescription());
        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        if (null != sysUser) {
            target.setJdManager(sysUser.getPerson());
            target.setJdManagerName(sysUser.getDisplayName());
        }
        // 照片
        if (null != result.getDocumentId())
            target.setDocument(docDocumentService.get(result.getDocumentId()));
        if (null != result.getPhotos())
            target.setDocument(docDocumentService.get(savePhoto(result.getPhotos())));
        jdRecordSafeService.save(target);

        if (null != result.getPlanDetailid()) {
            String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
            planMainInfoManager.setDetailStatus(result.getPlanDetailid(), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
        }
        String hql = "select j from JdRecordPerson j where j.recordId={0}";
        hql = FormatUtils.format(hql, target.getId());
        List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hql);
        for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
            jdRecordPersonService.delete(jdRecordPerson);
        }
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!"".equals(androidJdPersonInfos.getId())) {
                    JdRecordPerson jdRecordPerson = new JdRecordPerson();
                    jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                    if (null != androidJdPersonInfos.getId()) {
                        SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
                        jdRecordPerson.setJdPerson(sysUser1.getPerson());
                        jdRecordPerson.setJdPersonDesc(sysUser1.getPerson().getName());
                        jdRecordPerson.setRecordId(target.getId());
                        // 保存参加监督人员
                        jdRecordPersonService.save(jdRecordPerson);
                    }
                }
            }
        }
        // 删除安全监督问题
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR, target.getId());
        List<JdRecordQuestion> jdRecordQItemFacility = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_SAFE.getCode(), Constants.JD_RECORD_SAFE_CHECK_FACILITY, target.getId());
        // 删除安全监督-行为检查问题
        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }

        // 删除安全监督-设施检查
        for (JdRecordQuestion jdRecordQuestion2 : jdRecordQItemFacility) {
            jdRecordQuestionService.delete(jdRecordQuestion2);
        }
        List<AndroidJdRecordQuestion> questions = result.getBehavior();
        if (null != questions && questions.size() > 0) {
            for (AndroidJdRecordQuestion ajq : questions) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_SAFE_CHECK_BEHAVIOR);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        List<AndroidJdRecordQuestion> facility = result.getFacility();
        if (null != facility && facility.size() > 0) {
            for (AndroidJdRecordQuestion ajq : facility) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_SAFE.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_SAFE_CHECK_FACILITY);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg("保存成功");
        msg.setId(target.getId());
        msg.setType("AndroidJdRecordSafe");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 保存质量监督
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveJdRecordQuality(@RequestBody AndroidJdRecordQuality result, Model model, String userName) throws Exception {

        JdRecordQuality target;
        if (null != result.getId()) {
            target = jdRecordQualityService.get(result.getId());
        } else {
            target = new JdRecordQuality();
        }

        String attendPersons = "";
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!StringHelper.isEmpty(androidJdPersonInfos.getName())) {
                    attendPersons += androidJdPersonInfos.getName() + ",";
                }

//                if (!"".equals(androidJdPersonInfos.getId()) && null != androidJdPersonInfos.getId()) {
//                    SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
//                    attendPersons += sysUser1.getDisplayName() + ",";
//                }
            }
        }
        if (attendPersons.length() > 0) {
            attendPersons = attendPersons.substring(0, attendPersons.length() - 1);
        }
        target.setAttendPersons(attendPersons);
        target.setStatus(result.getStatus());
        target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_QUALITY.getCode(), null));
        target.setJdTaskCode(result.getJdTaskCode());
        target.setBjbh(result.getBjbh());
        target.setProjectName(result.getProjectName());
        target.setWeather(result.getWeather());
        if (null != result.getJdDatetime())
            target.setJdDatetime(new java.sql.Date(Long.parseLong(result.getJdDatetime())));
        target.setJsDept(result.getJsDept());
        target.setKcDept(result.getKcDept());
        target.setSjDept(result.getSjDept());
        target.setSgDept(result.getSgDept());
        target.setJlDept(result.getJlDept());
        target.setJcDept(result.getJcDept());
        target.setScheduleItems(result.getScheduleItems());
        target.setInspectionContent(result.getInspectionContent());
        target.setInspectionPosition(result.getInspectionPosition());
        target.setJdInspection(result.getJdInspection());
        target.setInspectionContent(result.getContent());
        target.setDealOpinion(result.getDealOpinion());
        target.setDescription(result.getDescription());

        if (null != result.getDwgc() && null != result.getDwgc().getId()) {
            target.setDwgc(excelJdDwgcService.get(result.getDwgc().getId()));
        }

        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        if (null != sysUser) {
            target.setJdManager(sysUser.getPerson());
            target.setJdManagerName(sysUser.getDisplayName());
        }

        // 照片
        if (null != result.getDocumentId())
            target.setDocument(docDocumentService.get(result.getDocumentId()));
        if (null != result.getPhotos())
            target.setDocument(docDocumentService.get(savePhoto(result.getPhotos())));
        jdRecordQualityService.save(target);

        if (null != result.getPlanDetailid()) {
            String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
            planMainInfoManager.setDetailStatus(result.getPlanDetailid(), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
        }
        String hql = "select j from JdRecordPerson j where j.recordId={0}";
        hql = FormatUtils.format(hql, target.getId());
        List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hql);
        for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
            jdRecordPersonService.delete(jdRecordPerson);
        }
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!"".equals(androidJdPersonInfos.getId())) {
                    JdRecordPerson jdRecordPerson = new JdRecordPerson();
                    jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                    if (null != androidJdPersonInfos.getId()) {
                        SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
                        jdRecordPerson.setJdPerson(sysUser1.getPerson());
                        jdRecordPerson.setJdPersonDesc(sysUser1.getPerson().getName());
                        jdRecordPerson.setRecordId(target.getId());
                    }
                    // 保存参加监督人员
                    jdRecordPersonService.save(jdRecordPerson);
                }
            }
        }

        // 删除
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR, target.getId());
        List<JdRecordQuestion> jdRecordQItemFacility = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_QUALITY.getCode(), Constants.JD_RECORD_QUALITY_CHECK_ENTITY, target.getId());

        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }
        for (JdRecordQuestion jdRecordQuestion2 : jdRecordQItemFacility) {
            jdRecordQuestionService.delete(jdRecordQuestion2);
        }
        List<AndroidJdRecordQuestion> questions = result.getBehavior();
        if (null != questions && questions.size() > 0) {
            for (AndroidJdRecordQuestion ajq : questions) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_QUALITY_CHECK_BEHAVIOR);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        List<AndroidJdRecordQuestion> facility = result.getEntity();
        if (null != facility && facility.size() > 0) {
            for (AndroidJdRecordQuestion ajq : facility) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_QUALITY_CHECK_ENTITY);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg("保存成功");
        msg.setId(target.getId());
        msg.setType("AndroidJdRecordQuality");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }

    /**
     * 获取人员信息
     *
     * @param userName .
     * @param model    .
     * @return .
     */
    @RequestMapping
    public String getPersonName(Model model, String userName) {
        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        AndroidJdPersonInfo androidJdPersonInfo = new AndroidJdPersonInfo();
        androidJdPersonInfo.setName(sysUser.getDisplayName());
        androidJdPersonInfo.setLoginName(userName);
        androidJdPersonInfo.setId(sysUser.getId());
        JSONArray jsonArray = JSONArray.fromObject(androidJdPersonInfo);
        model.addAttribute("msg", jsonArray.toString());
        return "common/androidMsg";
    }

    /**
     * 保存竣工监督
     *
     * @param result .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String saveJdRecordComplete(@RequestBody AndroidJdRecordComplete result, Model model, String userName) throws Exception {

        JdRecordComplete target;
        if (null != result.getId()) {
            target = jdRecordCompleteService.get(result.getId());
        } else {
            target = new JdRecordComplete();
        }
        String attendPersons = "";
        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!StringHelper.isEmpty(androidJdPersonInfos.getName())) {
                    attendPersons += androidJdPersonInfos.getName() + ",";
                }

//                if (!"".equals(androidJdPersonInfos.getId()) && null != androidJdPersonInfos.getId()) {
//                    SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
//                    attendPersons += sysUser1.getDisplayName() + ",";
//                }
            }
        }
        if (attendPersons.length() > 0) {
            attendPersons = attendPersons.substring(0, attendPersons.length() - 1);
        }
        target.setAttendPersons(attendPersons);
        target.setStatus(result.getStatus());
        target.setCode(jdRecordManager.generateCode(JdRecordType.TYPE_COMPLETE.getCode(), null));
        target.setJdTaskCode(result.getJdTaskCode());
        target.setBjbh(result.getBjbh());
        target.setProjectName(result.getProjectName());
        target.setWeather(result.getWeather());
        if (null != result.getJdDatetime())
            target.setJdDatetime(new java.sql.Date(Long.parseLong(result.getJdDatetime())));
        target.setJsDept(result.getJsDept());
        target.setKcDept(result.getKcDept());
        target.setSjDept(result.getSjDept());
        target.setSgDept(result.getSgDept());
        target.setJlDept(result.getJlDept());
        target.setJcDept(result.getJcDept());
        target.setDealOpinion(result.getDealOpinion());
        target.setDescription(result.getDescription());
        target.setJdTypeCode(JdRecordType.TYPE_QUALITY.getCode());

//        if (null != result.getJdManagerName()) {
//            SysPerson sysPerson = sysPersonService.get(result.getJdManagerName().getId());
//            target.setJdManager(sysPerson);
//        }
        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        if (null != sysUser) {
            target.setJdManager(sysUser.getPerson());
            target.setJdManagerName(sysUser.getDisplayName());
        }
        // 照片
        if (null != result.getDocumentId())
            target.setDocument(docDocumentService.get(result.getDocumentId()));
        if (null != result.getPhotos())
            target.setDocument(docDocumentService.get(savePhoto(result.getPhotos())));
        jdRecordCompleteService.save(target);

        if (null != result.getPlanDetailid()) {
            String cancelCode = sysCodeManager.getCodeDetailByCode(Constants.PLAN_DETAIL_STATUS, Constants.PLAN_DETAIL_STATUS_CHECKED).getCode();
            planMainInfoManager.setDetailStatus(result.getPlanDetailid(), cancelCode, java.sql.Date.valueOf(DateTimeHelper.getCurrentDate()));
        }

        String hqlq = "select j from JdRecordPerson j where j.recordId={0}";
        hqlq = FormatUtils.format(hqlq, target.getId());
        List<JdRecordPerson> jdRecordPersons = jdRecordPersonService.findByQuery(hqlq);
        for (JdRecordPerson jdRecordPerson : jdRecordPersons) {
            jdRecordPersonService.delete(jdRecordPerson);
        }

        if (null != result.getAttendPersons() && result.getAttendPersons().size() > 0) {
            for (AndroidJdPersonInfo androidJdPersonInfos : result.getAttendPersons()) {
                if (!"".equals(androidJdPersonInfos.getId())) {
                    JdRecordPerson jdRecordPerson = new JdRecordPerson();
                    jdRecordPerson.setJdTypeCode(JdRecordType.TYPE_COMPLETE.getCode());
                    if (null != androidJdPersonInfos.getId()) {
                        SysUser sysUser1 = sysUserService.get(androidJdPersonInfos.getId());
                        jdRecordPerson.setJdPerson(sysUser1.getPerson());
                        jdRecordPerson.setJdPersonDesc(sysUser1.getPerson().getName());
                        jdRecordPerson.setRecordId(target.getId());
                    }
                    // 保存参加监督人员
                    jdRecordPersonService.save(jdRecordPerson);
                }
            }
        }
        //先删除子表：安全质量监督--竣工验收--单位工程
        Set<JdRecordCompleteDwgc> jdRecordCompleteDwgcs = target.getJdRecordCompleteDwgcs();
        for (JdRecordCompleteDwgc jdRecordCompleteDwgc : jdRecordCompleteDwgcs) {
            jdRecordCompleteDwgcService.delete(jdRecordCompleteDwgc);
        }

        if (null != result.getDwgc()) {
            List<AndroidDwgc> lit = result.getDwgc();
            for (AndroidDwgc aLit : lit) {
                JdRecordCompleteDwgc jdRecordCompleteDwgc = new JdRecordCompleteDwgc();
                jdRecordCompleteDwgc.setDwgcCode(String.valueOf(aLit.getCode()));
                jdRecordCompleteDwgc.setDwgcName(aLit.getName());
                jdRecordCompleteDwgc.setRecordComplete(target);
                jdRecordCompleteDwgcService.save(jdRecordCompleteDwgc);
            }

        }

        //先删除子表：安全质量监督--竣工验收--验收结果
        Set<JdRecordCompleteResult> jdRecordCompleteResults = target.getJdRecordCompleteResults();
        for (JdRecordCompleteResult jdRecordCompleteResult : jdRecordCompleteResults) {
            jdRecordCompleteResultService.delete(jdRecordCompleteResult);
        }

        List<SysCodeDetail> codeListByCode = sysCodeManager.getCodeListByCode(Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);

        for (SysCodeDetail sysCodeDetail : codeListByCode) {
            String hql = "from JdRecordCompCheckitem where type.id={0} order by id desc,orderNo asc";
            hql = FormatUtils.format(hql, sysCodeDetail.getId());
            List<JdRecordCompCheckitem> jdRecordCompCheckitems = jdRecordCompCheckitemService.findByQuery(hql);
            for (JdRecordCompCheckitem jdRecordCompCheckitem : jdRecordCompCheckitems) {
                List<AndroidJdRecordCompleteResult> androidJdRecordCompleteResults = result.getJdRecordCompleteResult();
                if (null != androidJdRecordCompleteResults && androidJdRecordCompleteResults.size() > 0) {
                    for (AndroidJdRecordCompleteResult a : androidJdRecordCompleteResults) {
                        if (a.getId().equals(jdRecordCompCheckitem.getId())) {
                            String checkItem = a.getCheckResult();
                            JdRecordCompleteResult jdRecordCompleteResult = new JdRecordCompleteResult();
                            jdRecordCompleteResult.setRecordComplete(target);
                            jdRecordCompleteResult.setCheckitem(jdRecordCompCheckitem);
                            jdRecordCompleteResult.setCheckResult(checkItem);
                            jdRecordCompleteResultService.save(jdRecordCompleteResult);
                        }
                    }
                }
            }
        }

        // 删除
        List<JdRecordQuestion> jdRecordQItemBehavior = jdRecordManager.getJdRecordQuestions(JdRecordType.TYPE_COMPLETE.getCode(), Constants.JD_RECORD_COMPLETE_CHECK_OTHER, target.getId());
        for (JdRecordQuestion jdRecordQuestion : jdRecordQItemBehavior) {
            jdRecordQuestionService.delete(jdRecordQuestion);
        }
        List<AndroidJdRecordQuestion> questions = result.getQuestions();
        if (null != questions && questions.size() > 0) {
            for (AndroidJdRecordQuestion ajq : questions) {

                JdRecordQuestion jdRecordQuestion = new JdRecordQuestion();
                jdRecordQuestion.setQuestionDesc(ajq.getDictName());
                jdRecordQuestion.setUnlawDesc(ajq.getRefRule());
                jdRecordQuestion.setUnlawId(ajq.getDictId());
                jdRecordQuestion.setJdPersonId(ajq.getPersonId());
                jdRecordQuestion.setJdPersonDesc(ajq.getPersonName());
                jdRecordQuestion.setQuestionId(ajq.getId());
                jdRecordQuestion.setRecordId(target.getId());
                jdRecordQuestion.setJdTypeCode(JdRecordType.TYPE_COMPLETE.getCode());
                jdRecordQuestion.setTypeCode(Constants.JD_RECORD_COMPLETE_CHECK_OTHER);
                jdRecordQuestionService.save(jdRecordQuestion);
            }
        }
        AndroidCommonMsg msg = new AndroidCommonMsg();
        msg.setMsg("保存成功");
        msg.setId(target.getId());
        msg.setType("AndroidJdRecordComplete");
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }
}

