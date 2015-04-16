package com.justonetech.biz.controller.platform;

import com.justonetech.biz.daoservice.OrderFormDeployService;
import com.justonetech.biz.domain.BpmProcessDefinition;
import com.justonetech.biz.domain.OrderFormDeploy;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.OrderFormManager;
import com.justonetech.biz.manager.workflow.BpmProcessDefinitionManager;
import com.justonetech.biz.manager.workflow.BpmProcessInstanceManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 外网监管平台
 */
@Controller
public class PlatformController extends BaseCRUDActionController {

//    @Autowired
//    private OrderFormManager orderFormManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private BpmProcessDefinitionManager bpmProcessDefinitionManager;

    @Autowired
    private BpmProcessInstanceManager bpmProcessInstanceManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private OrderFormManager orderFormManager;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    /**
     * 监管平台首页
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("projectArea", configManager.getProjectArea());

        SysUser user = sysUserManager.getSysUser();
        model.addAttribute("realName", user.getDisplayName());
        model.addAttribute("categoryCode", Constants.BPM_PROCESS_DEFINITION_CATEGORY_GD);

        return "view/platform/index";
    }

    /**
     * 主页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String main(Model model) {

        return "view/platform/main";
    }

    /**
     * 主页面--监督预约列表
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainJdyy(Model model) {
        //外网项目用户和工地用户只能查看本项目范围的记录
        String hql = "from OrderFormDeploy where 1=1";

        hql += orderFormManager.getOrderFormFilterHql();

        hql += " order by orderForm.orderCode desc";
//        System.out.println("..............hql = " + hql);
        List<OrderFormDeploy> list = orderFormDeployService.findByQuery(hql);
        if (list.size() > 5) {
            list = list.subList(0, 5);
        }
        model.addAttribute("list", list);

        return "view/platform/mainJdyy";
    }

    /**
     * 主页面--工地申报统计
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainGdsb(Model model) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SysUser sysUser = sysUserManager.getSysUser();
        Long userId = sysUser.getId();
        List<BpmProcessDefinition> definitionList = bpmProcessDefinitionManager.getBpmProcessDefinitionListByCode(Constants.BPM_PROCESS_DEFINITION_CATEGORY_GD, false);
        for (BpmProcessDefinition data : definitionList) {
            String code = data.getCode();
            int waitAuditCount = bpmProcessInstanceManager.getWaitAuditList(code, userId).size();
            int hasAuditCount = bpmProcessInstanceManager.getHasAuditList(code, userId).size();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", code);
            map.put("name", data.getName());
            map.put("waitAuditCount", waitAuditCount);
            map.put("hasAuditCount", hasAuditCount);
            map.put("totalAuditCount", (waitAuditCount + hasAuditCount));

            list.add(map);
        }
        model.addAttribute("list", list);

        model.addAttribute("categoryCode", Constants.BPM_PROCESS_DEFINITION_CATEGORY_GD);

        return "view/platform/mainGdsb";
    }

    /**
     * 主页面--网上办事流程
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainWsbslc(Model model) {

        //信息列表
        int recordCount = 5;
//        List<OaInfoApply> infoList = oaPublicInfoManager.getPublicList(Constants.OA_PUBLIC_INFO_RANGE_OUT, Constants.OA_PUBLIC_INO_TYPE_WSBSLC, recordCount);
//        model.addAttribute("infoList", infoList);
        model.addAttribute("recordCount", recordCount);

        //最多显示字符数
        model.addAttribute("maxWordCount", 30);

        //发布范围
        model.addAttribute("range", Constants.OA_PUBLIC_INFO_RANGE_OUT);
//        model.addAttribute("typeCode", Constants.OA_PUBLIC_INO_TYPE_WSBSLC);

        return "view/platform/mainWsbslc";
    }

    /**
     * 主页面--整改单据统计
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String mainZgdj(Model model) {
//        List<Map<String, Object>> pollingFormCalc = pollingFormManager.getPollingFormCalc("1901-01-01", DateTimeHelper.getCurrentDate(), true);
//        model.addAttribute("list", pollingFormCalc);

        return "view/platform/mainZgdj";
    }
}
