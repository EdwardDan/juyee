package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.CheckReasonService;
import com.justonetech.biz.domain.CheckReason;

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
 * note:未考勤理由
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckReasonController extends BaseCRUDActionController<CheckReason> {
    private Logger logger = LoggerFactory.getLogger(CheckReasonController.class);
    
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
    private CheckReasonService checkReasonService;

   /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
      //判断是否有编辑权限
      model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.CHECK_MANAGER_EDIT));
            
      return "view/check/checkReason/grid";
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
            String hql = "from CheckReason order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = checkReasonService.findByPage(pageModel, queryTranslate.toString());

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
        CheckReason checkReason = new CheckReason();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", checkReason);

        return "view/check/checkReason/input";
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
        CheckReason checkReason = checkReasonService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", checkReason);
        
        return "view/check/checkReason/input";
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
        CheckReason checkReason = checkReasonService.get(id);
        
        model.addAttribute("bean", checkReason);        
        return "view/check/checkReason/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") CheckReason entity, HttpServletRequest request) throws Exception {
        try {
            CheckReason target;
            if (entity.getId() != null) {
                target = checkReasonService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                "checkReason",                                      
                                                                "isSync",                                      
                                                                "checkDate",                                      
                                                                "createTime",                                      
                                                                "updateTime",                                      
                                                                "updateUser",                                      
                                                                "createUser"                                      
                                                });

            } else {
                target = entity;
            }
            checkReasonService.save(target);

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
        checkReasonService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}