package com.justonetech.biz.controller.android;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.daoservice.OaTaskTypeService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * note:松江手持终端-代办事项
 * User: yujun
 * Date: 12-10-9
 * Time: 下午4:41
 */
@Controller
public class AndroidTaskController extends BaseCRUDActionController {

    @Autowired
    private SimpleQueryManager simpleQueryManager;


    @Autowired
    private OaTaskTypeService oaTaskTypeService;


    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaTaskManager oaTaskManager;


    /**
     * 获取监督计划任务列表
     *
     * @param model
     * @param userName
     * @return
     */
    @RequestMapping
    public String getPlanMainList(Model model, String userName) {
        SysUser sysUser = sysUserManager.getSysUser(userName);
        Long userId = null;
        if (sysUser != null)
            userId = sysUser.getId();
        //获取任务类型code
        String detailType = PlanDetail.class.getSimpleName();
        OaTaskType oaTaskType = oaTaskManager.getTaskType(detailType);
        Long typeId = null;
        if (oaTaskType != null) {
            typeId = oaTaskType.getId();
        }
        SysCodeDetail sysCodeDetail1 = sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EXCUTE);
        Long planStatusCheck = sysCodeDetail1.getId();
        String sql = "select t1.*,t2.*,t3.*,t4.*" +
                " from oa_task t1 ,plan_detail t2,plan_main_info t3 ,OA_TASK_DEAL t4" +
                " where t1.refer_id=t2.id " +
                " and t1.id = t4.TASK_ID" +
                " and t1.type_id ={0}" +
                " and t2.plan_id=t3.id and t3.plan_status={1}" +
                " and t4.USER_ID ={2} order by t2.plan_end_time asc";  //按计划结束时间排序
        sql = FormatUtils.format(sql, typeId, planStatusCheck, userId);
        //logger.debug("sql="+sql);
        List<Map> list = simpleQueryManager.getMapList(sql);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Map bean : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("taskId", bean.get("REFER_ID"));  //注意：此处为业务记录的ID，不是任务ID
            map.put("typeId", bean.get("TYPE_ID"));
            map.put("title", bean.get("TITLE"));
            map.put("createTime", bean.get("CREATE_TIME"));
            map.put("createUserId", bean.get("CREATE_USER_ID"));
            map.put("bjbh", bean.get("BJBH"));
            map.put("buildUnitName", bean.get("BUILD_UNIT_NAME"));
            map.put("status", bean.get("STATUS"));
            map.put("planEndTime", bean.get("PLAN_END_TIME"));
            map.put("planName", bean.get("PLAN_NAME"));
            map.put("planCode", bean.get("PLAN_CODE"));
            map.put("planType", bean.get("PLAN_TYPE"));
            map.put("updateTime", bean.get("UPDATE_TIME"));
            map.put("updateUser", bean.get("UPDATE_USER"));
            map.put("createUser", bean.get("CREATE_USER"));
            map.put("checkUserId", bean.get("CHECK_USER_ID"));
            map.put("checkUserName", bean.get("CHECK_USER_NAME"));
            map.put("checkOpinion", bean.get("CHECK_OPINION"));
            map.put("checkMemo", bean.get("CHECK_MEMO"));
            map.put("workGroupId", bean.get("GROUP_ID"));
            map.put("bjbh", bean.get("BJBH"));
            map.put("planId", bean.get("PLAN_ID"));
            //据报建编号获取项目位置
            ProjectExtend proPosition = relateManager.getProjectExtend(JspHelper.getString(bean.get("BJBH")));
            if (proPosition != null) {
                map.put("longitude", proPosition.getPosX());
                map.put("latitude", proPosition.getPosY());
            } else {
                map.put("longitude", null);
                map.put("latitude", null);
            }

            ShareProTobuild shareProTobuild = projectManager.getProject(bean.get("BJBH").toString());
            if (shareProTobuild != null)
                map.put("projectName", shareProTobuild.getProjectName());
            else
                map.put("projectName", null);

            mapList.add(map);
        }
        String msg = new JSONSerializer().exclude("*.class").deepSerialize(mapList);
        model.addAttribute("msg", msg);
        return "common/msg";

    }

    /**
     * 获取监督预约任务列表
     *
     * @param model
     * @param userName
     * @return
     */
    @RequestMapping
    public String getOrderFormList(Model model, String userName) {

        SysUser sysUser = sysUserManager.getSysUser(userName);
        Long userId = null;
        if (sysUser != null) {
            userId = sysUser.getId();
        }
        //获取任务类型的code
        String taskType = OrderFormDeploy.class.getSimpleName();
        OaTaskType oaTaskType = oaTaskManager.getTaskType(taskType);
        Long typeId = null;
        if (oaTaskType != null) {
            typeId = oaTaskType.getId();
        }
        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE);
        Long opinionId = sysCodeDetail.getId();
        String sql = "select t1.*,t2.*,t3.*,t4.*" +
                " from oa_task t1, order_form t2,order_form_deploy t3,oa_task_deal t4" +
                " where t1.refer_id=t2.id" +
                " and t1.id = t4.task_id" +
                " and t1.type_id ={0}" +
                " and t2.id=t3.order_form_id and t3.accept_opinion={1}" +
                " and t4.user_id={2} order by t2.order_datetime asc"; //按预约时间排序


        List<Map> list = simpleQueryManager.getMapList(FormatUtils.format(sql, typeId, opinionId, userId));
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Map bean : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("taskId", bean.get("REFER_ID"));   //注意：此处为业务记录的ID，不是任务ID
            map.put("typeId", bean.get("TYPE_ID"));
            map.put("title", bean.get("TITLE"));
            map.put("createTime", bean.get("CREATE_TIME"));
            map.put("createUserId", bean.get("CREATE_USER_ID"));
            map.put("bjbh", bean.get("BJBH"));
            map.put("buildUnitName", bean.get("BUILD_UNIT_NAME"));
            map.put("projectName", bean.get("PROJECT_NAME"));
            map.put("buildAddress", bean.get("BUILD_ADDRESS"));
            map.put("buildLegalPerson", bean.get("BUILD_LEGAL_PERSON"));
            map.put("buildLegalPhone", bean.get("BUILD_LEGAL_PHONE"));    //字段录入已取消
            map.put("planSgTime", bean.get("PLAN_SG_DATATIME"));           //字段录入已取消
            map.put("linkMan", bean.get("LINK_MAN"));
            map.put("updateTime", bean.get("UPDATE_TIME"));
            map.put("updateUser", bean.get("UPDATE_USER"));
            map.put("createUser", bean.get("CREATE_USER"));
            map.put("acceptUserId", bean.get("ACCEPT_USER_ID"));
            map.put("acceptUserName", bean.get("ACCEPT_USER_NAME"));
            map.put("acceptTime", bean.get("ACCEPT_DATETIME"));
            map.put("acceptOpinion", bean.get("ACCEPT_OPINION"));
            map.put("acceptOpinionDesc", bean.get("ACCEPT_OPINION_DESC"));
            map.put("workGroupId", bean.get("WORK_GROUP_ID"));

            String bjbh =JspHelper.getString(bean.get("BJBH"));
            if (bjbh != null) {
                ProjectExtend proPosition = relateManager.getProjectExtend(bjbh);
                if (proPosition != null) {
                    map.put("longitude", proPosition.getPosX());
                    map.put("latitude", proPosition.getPosY());
                } else {
                    map.put("longitude", null);
                    map.put("latitude", null);
                }
            } else {
                map.put("longitude", null);
                map.put("latitude", null);
            }
            mapList.add(map);

        }
        String msg = new JSONSerializer().exclude("*.class").deepSerialize(mapList);
        model.addAttribute("msg", msg);
        return "common/msg";
    }

    /**
     * 任务数量的接口
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping
    public String getPollingTaskCount(String userName, Model model) {
        SysUser sysUser = sysUserManager.getSysUser(userName);
        Long userId = null;
        if (sysUser != null) {
            userId = sysUser.getId();
        }
        //监督计划任务数量
        String detailType = PlanDetail.class.getSimpleName();
        OaTaskType oaTaskTypeDetail = oaTaskManager.getTaskType(detailType);
        Long typeId1 = null;
        if (oaTaskTypeDetail != null) {
            typeId1 = oaTaskTypeDetail.getId();
        }
        SysCodeDetail sysCodeDetail1 = sysCodeManager.getCodeDetailByCode(Constants.PLAN_MAIN_INFO_STATUS, Constants.PLAN_MAIN_INFO_STATUS_EXCUTE);
        Long planStatusCheck = sysCodeDetail1.getId();
        String sql1 = "select count(*) from oa_task t1 ,plan_detail t2,plan_main_info t3 ,OA_TASK_DEAL t4" +
                " where t1.refer_id=t2.id " +
                " and t1.id = t4.TASK_ID" +
                " and t1.type_id ={0}" +
                " and t2.plan_id=t3.id and t3.plan_status={1}" +
                " and t4.USER_ID ={2}";
        int pollingPlanCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(sql1, typeId1, planStatusCheck, userId));

        //监督预约任务数量
        String deployType = OrderFormDeploy.class.getSimpleName();
        OaTaskType oaTaskTypeOder = oaTaskManager.getTaskType(deployType);
        Long typeId2 = null;
        if (oaTaskTypeOder != null) {
            typeId2 = oaTaskTypeOder.getId();
        }
        SysCodeDetail sysCodeDetail2 = sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE);
        Long opinion = sysCodeDetail2.getId();
        String sql2 = "select count(*) from oa_task t1, order_form t2,order_form_deploy t3,oa_task_deal t4" +
                " where t1.refer_id=t2.id" +
                " and t1.id = t4.task_id" +
                " and t1.type_id ={0}" +
                " and t2.id=t3.order_form_id and t3.accept_opinion={1}" +
                " and t4.user_id={2}";
        int pollingOrderCount = simpleQueryManager.getIntegerBySql(FormatUtils.format(sql2, typeId2, opinion, userId));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pollingPlanCount", pollingPlanCount);
        map.put("pollingOrderCount", pollingOrderCount);
        String msg = new JSONSerializer().exclude("*.class").deepSerialize(map);
        model.addAttribute("msg", msg);
        return "common/msg";
    }
}
