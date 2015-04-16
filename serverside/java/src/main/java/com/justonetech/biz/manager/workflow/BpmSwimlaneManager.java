package com.justonetech.biz.manager.workflow;

import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.BpmSwimlaneDefinitionService;
import com.justonetech.biz.daoservice.BpmSwimlaneService;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.Candidate;
import com.justonetech.biz.manager.SwimlaneManager;
import com.justonetech.biz.utils.CollectionUtils;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.util.*;

/**
 * @version 1.0
 * @author: Ma Ji
 * @since: 2009-8-26
 */
@Service
public class BpmSwimlaneManager {
    private static final Log log = LogFactory.getLog(BpmSwimlaneManager.class);

    @Autowired
    private SwimlaneManager swimlaneManager;

    @Autowired
    private BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private BpmSwimlaneService bpmSwimlaneService;

    @Autowired
    private BpmSwimlaneDefinitionService bpmSwimlaneDefinitionService;

    public BpmSwimlaneDefinition getSwimlaneDefinition(BpmNodeDefinition bpmNodeDefinition) throws Exception {
        //判断是全局泳道，流程泳道，任务泳道，并得到泳道定义
        BpmTaskSwimlane bpmTaskSwimlane = bpmNodeDefinition.getBpmTaskSwimlane();
        BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmTaskSwimlane.getSwimlaneDefinition();
        if (bpmSwimlaneDefinition == null) {
            BpmProcessSwimlane bpmProcessSwimlane = bpmTaskSwimlane.getProcessSwimlane();
            bpmSwimlaneDefinition = bpmProcessSwimlane.getSwimlaneDefinition();
            if (bpmSwimlaneDefinition == null) {
                BpmSwimlane swimlane = bpmProcessSwimlane.getSwimlane();
                if (swimlane != null) {
                    bpmSwimlaneDefinition = swimlane.getSwimlaneDefinition();
                } else {
                    throw new Exception("流程泳道【" + bpmProcessSwimlane.getName() + "】未定义正确！");
                }
            }
        }
        return bpmSwimlaneDefinition;
    }

    /**
     * 根据节点定义得到泳道定义，得到人员的用户id
     *
     * @param bpmSwimlaneDefinition
     * @return
     * @throws Exception
     */
    public String[] getUserIds(BpmSwimlaneDefinition bpmSwimlaneDefinition, Map varMap) throws Exception {

        //根据泳道定义得到泳道对应人员
        List<Candidate> candidates = getCandidates(bpmSwimlaneDefinition, varMap);
        Set<String> userIds = new HashSet<String>();
        for (Candidate candidate : candidates) {
            SysPerson sysPerson = candidate.getSysPerson();
            SysUser user = CollectionUtils.getFirstEle(sysPerson.getSysUsers());
            if (user != null) {
                userIds.add(String.valueOf(user.getId()));
            }
        }
        //如果泳道中没有对应人员，则返回默认用户（系统管理员）
        if (userIds.size() > 0) {
            return userIds.toArray(new String[userIds.size()]);
        } else {
            log.warn("the swimlane user is null and will return default user ids!bpmSwimlaneDefinition: " + bpmSwimlaneDefinition);
            return getDefaultUserIds();
        }
    }

    /**
     * 得到默认用户ids
     *
     * @return adminUserId
     */
    private String[] getDefaultUserIds() {
        SysUser adminUser = sysUserManager.getAdminUser();
        return new String[]{String.valueOf(adminUser.getId())};
    }

    public String[] getUserIds(BpmSwimlaneDefinition bpmSwimlaneDefinition) throws Exception {
        Map varMap = new HashMap();
        return getUserIds(bpmSwimlaneDefinition, varMap);
    }

    public String getUserNames(BpmSwimlaneDefinition bpmSwimlaneDefinition) throws Exception {
        return sysUserManager.getSysUserNames(getUserIds(bpmSwimlaneDefinition));
    }

    public String[] getUserIds(BpmProcessInstance bpmProcessInstance, BpmSwimlaneDefinition bpmSwimlaneDefinition) throws Exception {
        Map<String, String> varMap = getVariableMap(bpmSwimlaneDefinition.getExpression(), bpmProcessInstance);
        return getUserIds(bpmSwimlaneDefinition, varMap);
    }

    public List<Candidate> getCandidates(BpmSwimlaneDefinition bpmSwimlaneDefinition, Map varMap) throws Exception {
        if (bpmSwimlaneDefinition != null) {
            return swimlaneManager.getSwimlaneInstance(bpmSwimlaneDefinition.getGroup(), bpmSwimlaneDefinition.getPositionType(), bpmSwimlaneDefinition.getExpression(), varMap);
        } else {
            return new ArrayList<Candidate>();
        }
    }

    public List<Candidate> getCandidates(BpmSwimlaneDefinition bpmSwimlaneDefinition) throws Exception {
        return getCandidates(bpmSwimlaneDefinition, new HashMap());
    }

    /**
     * 判断一个用户是否属于流程的查看泳道
     *
     * @param bpmProcessDefinition
     * @param actorId
     * @return
     * @throws Exception
     */
    public boolean isViewSwimlaneActor(BpmProcessDefinition bpmProcessDefinition, String actorId) throws Exception {
        BpmSwimlaneDefinition bpmSwimlaneDefinition = bpmProcessDefinition.getViewSwimlaneDefinition();
        if (bpmSwimlaneDefinition == null) {
            return false;
        }
        List<Candidate> candidates = getCandidates(bpmSwimlaneDefinition, new HashMap());
        for (Candidate candidate : candidates) {
            SysPerson sysPerson = candidate.getSysPerson();
            if (sysPerson.getSysUsers().size() > 0) {
                Long userId = CollectionUtils.getFirstEle(sysPerson.getSysUsers()).getId();
                if (actorId.equals(String.valueOf(userId))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isViewByCcUser(BpmProcessDefinition bpmProcessDefinition, String actorId) {
        //判断当前用户是否属于被抄送的用户
        Set<BpmProcessInstance> processInstances = bpmProcessDefinition.getBpmProcessInstances();
        for (BpmProcessInstance processInstance : processInstances) {
            String userIds = processInstance.getCcUserIds();
            if (userIds != null) {
                String[] ccUserIds = userIds.split(",");
                for (String ccUserId : ccUserIds) {
                    if (ccUserId.equals(actorId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 根据泳道定义得到泳道对应的人员
     *
     * @param bpmSwimlaneDefinition
     * @return
     * @throws Exception
     */
    public Set<String> getSwimlaneActors(BpmSwimlaneDefinition bpmSwimlaneDefinition) throws Exception {
        Set<String> ret = new HashSet<String>();
        if (bpmSwimlaneDefinition != null) {
            List<Candidate> candidates = getCandidates(bpmSwimlaneDefinition, new HashMap());
            for (Candidate candidate : candidates) {
                SysPerson sysPerson = candidate.getSysPerson();
                if (sysPerson.getSysUsers().size() > 0) {
                    ret.add(String.valueOf(CollectionUtils.getFirstEle(sysPerson.getSysUsers())));
                }
            }
        }
        return ret;
    }

    public Map<String, String> getVariableMap(String expression, BpmProcessInstance bpmProcessInstance) throws DocumentException {
        Map<String, String> variableMap = new HashMap<String, String>();
        if (!StringHelper.isEmpty(expression)) {
            Set<String> varNames = SwimlaneManager.extractVarNames(expression);
            for (String varName : varNames) {
                String value = bpmFormTemplateManager.getDataFromXml(bpmProcessInstance, varName);
                variableMap.put(varName, value);
            }
        }

        return variableMap;
    }

    /**
     * 泳道根据表达式测试数据
     */
    public List<Map> getVarNameMap(String expression, Map<String, String> varMap, String varValue) {
        List<Map> varNames = new ArrayList<Map>();
        if (!StringHelper.isEmpty(expression)) {
            Set<String> varNameSet = SwimlaneManager.extractVarNames(expression);
            for (String varName : varNameSet) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("varName", varName);
//                String varValue = request.getParameter(varName);
                varValue = FormatUtils.format(varValue, varName);
                log.debug("varValue is " + varValue);
                if (varValue == null) {
                    varValue = "";
                }
                map.put("varValue", varValue);
                varNames.add(map);
                varMap.put(varName, varValue);
            }
        }
        return varNames;
    }

    /**
     *
     * */
    public List<Map> getPersonMap(SysCodeDetail groupTye, SysCodeDetail dutyType, String expression, Map varMap) throws ScriptException {
        List<Map> persons = new ArrayList<Map>();
        List<Candidate> canditates = swimlaneManager.getSwimlaneInstance(groupTye, dutyType, expression, varMap);
        for (Candidate canditate : canditates) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("group", canditate.getBpmProjectGroup().getName());
            map.put("duty", canditate.getBpmProjectGroupDuty().getName());
            map.put("person", canditate.getSysPerson().getName());
            persons.add(map);
        }
        return persons;
    }

    /**
     * 保存导入的泳道
     */
    public void saveImport() {
        //根据被导项目的Id找出泳道集合
//        FilterBeforeOperator.closeFilter();
        List<BpmSwimlane> bpmSwimlaneList = bpmSwimlaneService.findAll();
//        FilterBeforeOperator.openFilter();

        //准备数据，找出所有当前项目的泳道压入HashMap<泳道名称，泳道对象>中，用于重复泳道不导入
        List<BpmSwimlane> currentSwimlanes = bpmSwimlaneService.findAll();
        HashMap<String, BpmSwimlane> currentSwimlaneHM = new HashMap<String, BpmSwimlane>();
        for (BpmSwimlane currentSwimlane : currentSwimlanes) {
            currentSwimlaneHM.put(currentSwimlane.getName(), currentSwimlane);
        }

        //遍历被导项目的泳道
        for (BpmSwimlane fromSwimlane : bpmSwimlaneList) {
            importBpmSwimlane(fromSwimlane, currentSwimlaneHM);
        }
    }

    /**
     * 保存泳道-泳道定义
     *
     * @param fromSwimlane
     * @param currentSwimlaneHM
     * @return
     */
    public BpmSwimlane importBpmSwimlane(BpmSwimlane fromSwimlane, HashMap<String, BpmSwimlane> currentSwimlaneHM) {
        BpmSwimlane newBpmSwimlane = null;
        if (fromSwimlane != null) {
            newBpmSwimlane = currentSwimlaneHM.get(fromSwimlane.getName());

            //判断当前项目中的泳道名是否与导入的泳道名一样
            if (newBpmSwimlane == null) {
                newBpmSwimlane = new BpmSwimlane();
                newBpmSwimlane.setName(fromSwimlane.getName());

                BpmSwimlaneDefinition fromSwimlaneDefinition = fromSwimlane.getSwimlaneDefinition();

                //判断导入的泳道定义是否为空，不为空的保存，为空的就不进行泳道定义的保存操作
                if (fromSwimlaneDefinition != null) {
                    BpmSwimlaneDefinition newSwimlaneDefinition = new BpmSwimlaneDefinition();
                    newSwimlaneDefinition.setGroup(fromSwimlaneDefinition.getGroup());
                    newSwimlaneDefinition.setPositionType(fromSwimlaneDefinition.getPositionType());
                    newSwimlaneDefinition.setExpression(fromSwimlaneDefinition.getExpression());
                    bpmSwimlaneDefinitionService.save(newSwimlaneDefinition);

                    newBpmSwimlane.setSwimlaneDefinition(newSwimlaneDefinition);
                }
                bpmSwimlaneService.save(newBpmSwimlane);
            }
        }
        return newBpmSwimlane;
    }
}