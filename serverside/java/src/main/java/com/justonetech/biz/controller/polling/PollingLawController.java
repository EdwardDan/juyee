package com.justonetech.biz.controller.polling;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.PollingLawService;
import com.justonetech.biz.domain.PollingLaw;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * note:法律法规查询
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class PollingLawController extends BaseCRUDActionController<PollingLaw> {
    private Logger logger = LoggerFactory.getLogger(PollingLawController.class);
    
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
    private PollingLawService pollingLawService;

   /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
      //判断是否有编辑权限
      model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
            
      return "view/polling/pollingLaw/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from PollingLaw order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = pollingLawService.findByPage(pageModel, query);            

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
        PollingLaw pollingLaw = new PollingLaw();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", pollingLaw);

        return "view/polling/pollingLaw/input";
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
        PollingLaw pollingLaw = pollingLawService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", pollingLaw);
        
        return "view/polling/pollingLaw/input";
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
        PollingLaw pollingLaw = pollingLawService.get(id);
        
        model.addAttribute("bean", pollingLaw);        
        return "view/polling/pollingLaw/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") PollingLaw entity, HttpServletRequest request) throws Exception {
        try {
            PollingLaw target;
            if (entity.getId() != null) {
                target = pollingLawService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                "stddocid",                                      
                                                                "catalog",                                      
                                                                "descriptions",                                      
                                                                "tksm",                                      
                                                                "tkbh",                                      
                                                                "lx",                                      
                                                                "jdfl",                                      
                                                                "iitemno",                                      
                                                                "type",                                      
                                                                "shotdes"                                      
                                                });

            } else {
                target = entity;
            }
            pollingLawService.save(target);

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
        pollingLawService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}