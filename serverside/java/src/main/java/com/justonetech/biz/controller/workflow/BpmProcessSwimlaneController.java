package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.BpmProcessSwimlaneService;
import com.justonetech.biz.domain.BpmProcessSwimlane;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:流程泳道表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProcessSwimlaneController extends BaseCRUDActionController<BpmProcessSwimlane> {
    private Logger logger = LoggerFactory.getLogger(BpmProcessSwimlaneController.class);
    
    @Autowired
    private SysUserManager sysUserManager;
    
    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;
    
    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;
    
    @Autowired
    private DocumentManager documentManager;
    
    @Autowired
    private SimpleQueryManager simpleQueryManager;
    
    @Autowired
    private DocDocumentService docDocumentService;

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
      model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.BPM_SWIMLANE_EDIT));
            
      return "view/workflow/bpmProcessSwimlane/grid";
    }
    
    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmProcessSwimlane order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = bpmProcessSwimlaneService.findByPage(pageModel, queryTranslate.toString());

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
        BpmProcessSwimlane bpmProcessSwimlane = new BpmProcessSwimlane();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", bpmProcessSwimlane);

        return "view/workflow/bpmProcessSwimlane/input";
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
        BpmProcessSwimlane bpmProcessSwimlane = bpmProcessSwimlaneService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", bpmProcessSwimlane);
        
        return "view/workflow/bpmProcessSwimlane/input";
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
        BpmProcessSwimlane bpmProcessSwimlane = bpmProcessSwimlaneService.get(id);
        
        model.addAttribute("bean", bpmProcessSwimlane);        
        return "view/workflow/bpmProcessSwimlane/view";
    }
    
    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") BpmProcessSwimlane entity, HttpServletRequest request) throws Exception {
        try {
            BpmProcessSwimlane target;
            if (entity.getId() != null) {
                target = bpmProcessSwimlaneService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                "name",                                      
                                                                "shapeId"                                      
                                                });

            } else {
                target = entity;
            }
            bpmProcessSwimlaneService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        bpmProcessSwimlaneService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}