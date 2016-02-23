package com.justonetech.biz.controller.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import com.justonetech.biz.daoservice.ServiceReturnItemService;
import com.justonetech.biz.domain.ServiceReturnItem;
import org.apache.commons.lang.StringUtils;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.ui.grid.Grid;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ServiceReturnService;
import com.justonetech.biz.domain.ServiceReturn;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:送达回证
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ServiceReturnController extends BaseCRUDActionController<ServiceReturn> {
    private Logger logger = LoggerFactory.getLogger(ServiceReturnController.class);
    
    @Autowired
    private SysUserManager sysUserManager;
    
    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;
    
    @Autowired
    private DocumentManager documentManager;
    
    @Autowired
    private SimpleQueryManager simpleQueryManager;
    
    @Autowired
    private ServiceReturnItemService serviceReturnItemService;

    @Autowired
    private ServiceReturnService serviceReturnService;

   /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
      //判断是否有编辑权限
      model.addAttribute("canEdit",sysUserManager.hasPrivilege("ServiceReturn"));
            
      return "view/service/serviceReturn/grid";
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
            String hql = "from ServiceReturn order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = serviceReturnService.findByPage(pageModel, query);            

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 打印页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String printView(Model model, Long id) {
        ServiceReturn serviceReturn = serviceReturnService.get(id);
        model.addAttribute("bean", serviceReturn);
        Set<ServiceReturnItem> serviceReturnItems = serviceReturn.getServiceReturnItems();
        model.addAttribute("serviceReturnItems", serviceReturnItems);
        return "view/service/serviceReturn/printView";
    }





    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ServiceReturn serviceReturn = new ServiceReturn();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", serviceReturn);
        model.addAttribute("SERVICE_BOOK_TYPE", Constants.SERVICE_BOOK_TYPE);

        return "view/service/serviceReturn/input";
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
        ServiceReturn serviceReturn = serviceReturnService.get(id);
        Set<ServiceReturnItem> serviceReturnItems = serviceReturn.getServiceReturnItems();
        //处理其他业务逻辑
        model.addAttribute("bean", serviceReturn);
        model.addAttribute("serviceReturnItems", serviceReturnItems);
        model.addAttribute("SERVICE_BOOK_TYPE", Constants.SERVICE_BOOK_TYPE);
        return "view/service/serviceReturn/input";
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
        ServiceReturn serviceReturn = serviceReturnService.get(id);
        Set<ServiceReturnItem> serviceReturnItems = serviceReturn.getServiceReturnItems();
        model.addAttribute("bean", serviceReturn);        
        model.addAttribute("serviceReturnItems", serviceReturnItems);
        return "view/service/serviceReturn/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") ServiceReturn entity, HttpServletRequest request) throws Exception {
        try {
            ServiceReturn target;
            if (entity.getId() != null) {
                target = serviceReturnService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                "code",                                      
                                                                "servicePerson",                                      
                                                                "thingsName",                                      
                                                                "serviceUnit",                                      
                                                                "serviceAddress",                                      
                                                                "moemo"
                                                });

            } else {
                target = entity;
            }
            serviceReturnService.save(target);
            //保存子表前先把子表相关数据删除
            Set<ServiceReturnItem> serviceReturnItems = target.getServiceReturnItems();
            for (ServiceReturnItem serviceReturnItem : serviceReturnItems) {
                serviceReturnItemService.delete(serviceReturnItem);
            }

            //保存子表数据
            String[] nums = request.getParameterValues("num");
            String[] serviceBooks = request.getParameterValues("serviceBook");
            String[] servicePersons = request.getParameterValues("servicePersonSub");
            String[] receiveDates = request.getParameterValues("receiveDate");
            String[] receiveSigns = request.getParameterValues("receiveSign");
            String[] memos = request.getParameterValues("memo");
            if(null!=nums){
                for (String num : nums) {
                    ServiceReturnItem serviceReturnItem=new ServiceReturnItem();
                    int numSub=Integer.valueOf(num);
                    serviceReturnItem.setNum(numSub);
                    if(null!=serviceBooks[numSub-1]){
                        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeListById(Long.valueOf(serviceBooks[numSub - 1]));
                        serviceReturnItem.setServiceBook(sysCodeDetail.getName());
                        serviceReturnItem.setServiceBookType(sysCodeDetail);
                    }
                    if(null!=servicePersons[numSub-1]){
                        serviceReturnItem.setServicePerson(servicePersons[numSub - 1]);
                    }
                    if(null!=receiveDates[numSub-1]){
                        serviceReturnItem.setReceiveDate(Date.valueOf(receiveDates[numSub - 1]));
                    }
                    if(null!=receiveSigns[numSub-1]){
                        serviceReturnItem.setReceiveSign(receiveSigns[numSub - 1]);
                    }
                    if(null!=memos[numSub-1]){
                        serviceReturnItem.setMemo(memos[numSub-1]);
                    }
                    serviceReturnItem.setReturn(target);
                    serviceReturnItemService.save(serviceReturnItem);
                }
            }

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
        ServiceReturn serviceReturn = serviceReturnService.get(id);
        Set<ServiceReturnItem> serviceReturnItems = serviceReturn.getServiceReturnItems();
        for (ServiceReturnItem serviceReturnItem : serviceReturnItems) {
            serviceReturnItemService.delete(serviceReturnItem);
        }
        serviceReturnService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}