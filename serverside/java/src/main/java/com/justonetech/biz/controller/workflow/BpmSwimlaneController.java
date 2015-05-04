package com.justonetech.biz.controller.workflow;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.BpmProcessSwimlaneService;
import com.justonetech.biz.daoservice.BpmSwimlaneDefinitionService;
import com.justonetech.biz.daoservice.BpmSwimlaneService;
import com.justonetech.biz.domain.BpmProcessSwimlane;
import com.justonetech.biz.domain.BpmSwimlane;
import com.justonetech.biz.domain.BpmSwimlaneDefinition;
import com.justonetech.biz.manager.workflow.BpmSwimlaneManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:项目泳道表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmSwimlaneController extends BaseCRUDActionController<BpmSwimlane> {
    private Logger logger = LoggerFactory.getLogger(BpmSwimlaneController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private BpmSwimlaneService bpmSwimlaneService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private BpmSwimlaneDefinitionService bpmSwimlaneDefinitionService;

    @Autowired
    private BpmSwimlaneManager bpmSwimlaneManager;

    @Autowired
    private BpmProcessSwimlaneService bpmProcessSwimlaneService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_SWIMLANE_EDIT));

        return "view/workflow/bpmSwimlane/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmSwimlane order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = bpmSwimlaneService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);
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
    public String add(Model model) {
        BpmSwimlane bpmSwimlane = new BpmSwimlane();
        model.addAttribute("groupType", Constants.BPM_PROJECT_GROUP_TYPE);
        model.addAttribute("positionType", Constants.BPM_PROJECT_GROUP_DUTY_TYPE);
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", bpmSwimlane);

        return "view/workflow/bpmSwimlane/input";
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
        BpmSwimlane bpmSwimlane = bpmSwimlaneService.get(id);
        model.addAttribute("groupType", Constants.BPM_PROJECT_GROUP_TYPE);
        model.addAttribute("positionType", Constants.BPM_PROJECT_GROUP_DUTY_TYPE);
        //处理其他业务逻辑
        model.addAttribute("bean", bpmSwimlane);

        return "view/workflow/bpmSwimlane/input";
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
        BpmSwimlane bpmSwimlane = bpmSwimlaneService.get(id);
        String hql = "from BpmProcessSwimlane t where t.swimlane.id=" + id;
        List<BpmProcessSwimlane> swimlanes = bpmProcessSwimlaneService.findByQuery(hql);

        model.addAttribute("swimlanes", swimlanes);
        model.addAttribute("bean", bpmSwimlane);
        return "view/workflow/bpmSwimlane/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") BpmSwimlane bpmSwimlane, HttpServletRequest request, @RequestParam Long groupId, @RequestParam Long positionTypeId, @RequestParam String expression) throws Exception {
        try {
            BpmSwimlane target;
            BpmSwimlaneDefinition definition;
            if (bpmSwimlane.getId() != null) {
                target = bpmSwimlaneService.get(bpmSwimlane.getId());
                ReflectionUtils.copyBean(bpmSwimlane, target, new String[]{
                        "name"
                });
                definition = target.getSwimlaneDefinition();
            } else {
                target = bpmSwimlane;
                definition = new BpmSwimlaneDefinition();
            }
            SysCodeDetail group = sysCodeDetailService.get(groupId);
            definition.setGroup(group);
            SysCodeDetail positionType = sysCodeDetailService.get(positionTypeId);
            definition.setPositionType(positionType);
//        expression = htmlChar2java(expression);
            definition.setExpression(expression);
            bpmSwimlaneDefinitionService.save(definition);
            target.setSwimlaneDefinition(definition);
            bpmSwimlaneService.save(target);

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
        bpmSwimlaneService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }


    /**
     * 查看人员
     */
    @RequestMapping
    public String queryPerson(HttpServletRequest request, @RequestParam(required = false) String expression, @RequestParam(required = false) Long groupId, @RequestParam(required = false) Long positionTypeId, @RequestParam(required = false) Long id, Model model) throws Exception {
        SysCodeDetail groupTye;
        SysCodeDetail dutyType;
        if (id != null) {
            BpmSwimlane swimlane = bpmSwimlaneService.get(id);
            BpmSwimlaneDefinition definition = swimlane.getSwimlaneDefinition();
            expression = definition.getExpression();
            groupTye = definition.getGroup();
            dutyType = definition.getPositionType();
            model.addAttribute("bean", swimlane);
        } else {
            groupTye = sysCodeDetailService.get(groupId);
            dutyType = sysCodeDetailService.get(positionTypeId);
        }
        Map<String, String> varMap = new HashMap<String, String>();
//        List<Map> varNames = bpmSwimlaneManager.getVarNameMap(expression, varMap, request);
        String varValue = "request.getParameter({0})";
        List<Map> varNames = bpmSwimlaneManager.getVarNameMap(expression, varMap, varValue);
//        get person
        List<Map> persons = bpmSwimlaneManager.getPersonMap(groupTye, dutyType, expression, varMap);
        model.addAttribute("groupId", groupId);
        model.addAttribute("positionTypeId", positionTypeId);
        model.addAttribute("expression", expression);
        model.addAttribute("varNames", varNames);
        model.addAttribute("persons", persons);

        return "view/workflow/bpmSwimlane/queryPerson";
    }


    /**
     * 测试表达式是否有效
     */
    @RequestMapping
    public String isScriptVaild(HttpServletRequest request, HttpServletResponse response, @RequestParam String expression, @RequestParam Long groupId, @RequestParam Long positionTypeId, Model model) {
        String str = "<isScript>{0}</isScript>";
        try {
            Map<String, String> varMap = new HashMap<String, String>();
//            bpmSwimlaneManager.getVarNameMap(expression, varMap, request);
            String varValue = "request.getParameter({0})";
            bpmSwimlaneManager.getVarNameMap(expression, varMap, varValue);
            bpmSwimlaneManager.getPersonMap(sysCodeDetailService.get(groupId), sysCodeDetailService.get(positionTypeId), expression, varMap);
            str = String.valueOf(true);
        } catch (ScriptException e) {
            str = String.valueOf(false);
        }
        str = "{msg:" + str + "}";
        model.addAttribute("msg", str);
//        sendJSON(response, str);
        return "common/msg";
    }


}