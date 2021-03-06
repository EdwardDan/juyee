package com.justonetech.biz.controller.service;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.ServiceReturnItemService;
import com.justonetech.biz.daoservice.ServiceReturnService;
import com.justonetech.biz.domain.ServiceReturn;
import com.justonetech.biz.domain.ServiceReturnItem;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
        model.addAttribute("canEdit", true);
        return "view/service/serviceReturn/grid";
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
            List<ServiceReturnItem> serviceReturnItemList=new ArrayList<ServiceReturnItem>();
            if (null != nums) {
                for (String num : nums) {
                    ServiceReturnItem serviceReturnItem = new ServiceReturnItem();
                    int numSub = Integer.valueOf(num);
                    serviceReturnItem.setNum(numSub);
                    if (StringHelper.isNotEmpty(serviceBooks[numSub - 1])) {
                        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeListById(Long.valueOf(serviceBooks[numSub - 1]));
                        serviceReturnItem.setServiceBook(sysCodeDetail.getName());
                        serviceReturnItem.setServiceBookType(sysCodeDetail);
                    }
                    if (StringHelper.isNotEmpty(servicePersons[numSub - 1])) {
                        serviceReturnItem.setServicePerson(servicePersons[numSub - 1]);
                    }
                    if (StringHelper.isNotEmpty(receiveDates[numSub - 1])) {
                        serviceReturnItem.setReceiveDate(Date.valueOf(receiveDates[numSub - 1]));
                    }
                    if (StringHelper.isNotEmpty( receiveSigns[numSub - 1])){
                        serviceReturnItem.setReceiveSign(receiveSigns[numSub - 1]);
                    }
                    if (StringHelper.isNotEmpty( memos[numSub - 1])) {
                        serviceReturnItem.setMemo(memos[numSub - 1]);
                    }
                    serviceReturnItem.setServiceReturn(target);
                    serviceReturnItemList.add(serviceReturnItem);
                }
                serviceReturnItemService.batchSave(serviceReturnItemList,serviceReturnItemList.size());
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
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        ServiceReturn serviceReturn = serviceReturnService.get(id);
        Set<ServiceReturnItem> serviceReturnItems = serviceReturn.getServiceReturnItems();
        if (null != serviceReturnItems && serviceReturnItems.size() > 0) {
            for (ServiceReturnItem serviceReturnItem : serviceReturnItems) {
                serviceReturnItemService.delete(serviceReturnItem);
            }
        }
        serviceReturnService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}
