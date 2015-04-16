package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.OrderFormService;
import com.justonetech.biz.domain.bean.android.AndroidOrderForm;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * note:监督预约
 * User: Shaxj
 * Date: 14-8-15
 * Time: 下午1:44
 */
@Controller
public class AndroidOrderFormController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidOrderFormController.class);

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 获取监督预约单
     *
     * @return .
     */
    @RequestMapping
    public String getOrderForm(Model model, String userName) {
        userName = StringHelper.findAndReplace(userName, "'", "");
        SysUser sysUser = sysUserManager.getSysUser(userName);
        SysCodeDetail sysCodeDetail2 = sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_DEPLOY_OPINION, Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE);

        SysCodeDetail sysCodeDetail1 = sysCodeManager.getCodeDetailByCode(Constants.ORDER_FORM_STATUS, Constants.ORDER_FORM_STATUS_ACCEPT);
        String sql = " select DISTINCT o.id, o.jd_task_code,o.project_name,o.build_address  from  order_Form o " +
                " left join order_form_deploy d on d.order_form_id=o.id  " +
                " left Join ORDER_FORM_DEPLOY_USER U on u.order_form_deploy_id =  d.id " +
                " left join SYS_USER S on s.id=U.user_id " +
                "  where o.order_status =" + sysCodeDetail1.getId() +
                " and S .id ='" + sysUser.getId() + "' and d.ACCEPT_OPINION=" + sysCodeDetail2.getId();
        List orderList = orderFormService.findBySql(sql);
        List<AndroidOrderForm> androidJdTask = new ArrayList<AndroidOrderForm>();
        for (Object o : orderList) {
            AndroidOrderForm orderForm = new AndroidOrderForm();
            Object[] objects = (Object[]) o;
            if (!StringHelper.isEmpty(String.valueOf(objects[0])))
                orderForm.setId(Long.parseLong(String.valueOf(objects[0])));
            orderForm.setJdTaskCode(String.valueOf(objects[1]));
            orderForm.setProjectName(String.valueOf(objects[2]));
            orderForm.setBuildAddress(String.valueOf(objects[3]));
            androidJdTask.add(orderForm);
        }

        model.addAttribute("msg", JSONArray.fromObject(androidJdTask).toString());
        return "common/androidMsg";
    }

}
