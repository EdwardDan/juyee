package com.justonetech.biz.manager;

import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.BpmProjectGroup;
import com.justonetech.biz.domain.BpmProjectGroupDuty;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysPerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author: lerry
 * @date: 2009-3-27
 */
@Service
public class SwimlaneManager {

    @Autowired
    private SysPersonService sysPersonService;

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 得到swimlane instance
     *
     * @param groupTye
     * @param dutyType
     * @param condition
     * @param varMap    放置变量
     * @return
     * @throws Exception
     */
    public List<Candidate> getSwimlaneInstance(SysCodeDetail groupTye, SysCodeDetail dutyType, String condition, Map varMap) throws ScriptException {
        List<Candidate> swimlaneInstances = new ArrayList<Candidate>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");


        String hql = getSwimlaneHQL(groupTye, dutyType);

        List list = sysPersonService.findByQuery(hql);
        log.debug("list size is " + list.size());
        condition = getVarMap(condition, varMap, engine);

        engine.put("applicationContext", applicationContext);

        for (Object aList : list) {
            Object[] obj = (Object[]) aList;
            BpmProjectGroupDuty bpmProjectGroupDuty = (BpmProjectGroupDuty) obj[0];
            BpmProjectGroup bpmProjectGroup = (BpmProjectGroup) obj[1];
            SysPerson sysPerson = (SysPerson) obj[2];

            engine.put("duty", bpmProjectGroupDuty);
            engine.put("group", bpmProjectGroup);
            engine.put("person", sysPerson);

            Boolean result = true;
            if (!StringHelper.isEmpty(condition)) {
                log.debug("condition:" + condition);
                result = (Boolean) engine.eval(condition);
            }
            //如符合查询条件则构造Candidate，放入List 
            if (result) {
                Candidate candidate = new Candidate();
                candidate.setBpmProjectGroupDuty(bpmProjectGroupDuty);
                candidate.setBpmProjectGroup(bpmProjectGroup);
                candidate.setSysPerson(sysPerson);

                swimlaneInstances.add(candidate);
            }
        }
        log.debug("swimlaneInstances size is " + swimlaneInstances.size());
        return swimlaneInstances;
    }

    private String getVarMap(String condition, Map varMap, ScriptEngine engine) {
        //put outer vars
        if (!StringHelper.isEmpty(condition)) {
            Set<String> varNameSet = extractVarNames(condition);
            String[] varNames = varNameSet.toArray(new String[0]);

            for (int i = 0; i < varNames.length; i++) {
                String varName = varNames[i];
                //把所有传过来的变量名改为varName加上循环变量的形式,解决有可能的中文问题
                if (varMap.containsKey(varName)) {
                    engine.put("varName" + i, varMap.get(varName));
                }
                log.debug(".........varName is " + varName);
                log.debug("varName value is #" + varMap.get(varName) + "#");
                condition = condition.replaceAll("#" + varName, "varName" + i);
            }

            log.debug("after transfer, condition is " + condition);
        }
        return condition;
    }

    private String getSwimlaneHQL(SysCodeDetail groupTye, SysCodeDetail dutyType) {
        String hql = "select dp.groupDuty,dp.groupDuty.projectGroup,dp.person \n" +
                "from BpmDutyPerson dp \n" +
                "where 1=1";
        if (groupTye != null) {
            hql += " and dp.groupDuty.projectGroup.type.id =" + groupTye.getId();
        }
        log.debug(dutyType != null);
        if (dutyType != null) {
            hql += " and dp.groupDuty.type.id = " + dutyType.getId();
        }
        log.info("the hql is " + hql);
        return hql;
    }

    static Pattern pattern = Pattern.compile("#([a-zA-Z0-9_\\u4e00-\\u9fa5]+)");

    /**
     * 取得匹配到的去掉#的字符串集合
     * eg.var123,var34
     *
     * @param expression
     * @return
     */
    public static Set<String> extractVarNames(String expression) {
        log.debug("expression:" + expression);

        Set<String> ret = new HashSet<String>();
        if (expression != null) {
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                String varName = matcher.group(1);
                log.debug("varName is " + varName);
                ret.add(varName);
            }
        }
        return ret;
    }

    private static final Log log = LogFactory.getLog(SwimlaneManager.class);
}
