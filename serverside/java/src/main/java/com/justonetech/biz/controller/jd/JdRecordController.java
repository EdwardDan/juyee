package com.justonetech.biz.controller.jd;

import com.justonetech.biz.domain.JdRecordSafe;
import com.justonetech.biz.domain.bean.jdRecord.JdProjectInfo;
import com.justonetech.biz.manager.JdRecordManager;
import com.justonetech.biz.utils.enums.JdRecordStatus;
import com.justonetech.biz.utils.enums.JdStopOrderType;
import com.justonetech.core.controller.BaseCRUDActionController;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * note:安全质量监督--监督记录列表
 * author: chenjp
 * create date: 2014-01-07
 */
@Controller
public class JdRecordController extends BaseCRUDActionController<JdRecordSafe> {
    private Logger logger = LoggerFactory.getLogger(JdRecordController.class);

    @Autowired
    private JdRecordManager jdRecordManager;

    /**
     * tab显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model,String code)
    {
        model.addAttribute("code",code);//判断是安全监督还是质量监督
        return "view/jd/jdRecord/init";
    }

    /**
     * 创建行政措施单按钮
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String gridButton(Model model, String jdTypeCode,String jdAttributeCode) {
        //指令单类别编码
        model.addAttribute("TYPE_REFORM", JdStopOrderType.TYPE_REFORM.getCode());
        model.addAttribute("TYPE_SUSPEND", JdStopOrderType.TYPE_SUSPEND.getCode());
        model.addAttribute("TYPE_STOP", JdStopOrderType.TYPE_STOP.getCode());

        //监督记录类别
        model.addAttribute("jdTypeCode", jdTypeCode);
        model.addAttribute("jdAttributeCode", jdAttributeCode);
        model.addAttribute("STATUS_SUBMIT", JdRecordStatus.SUBMIT.getCode());
        model.addAttribute("STATUS_SUBMIT_NAME", JdRecordStatus.SUBMIT.getName());

        return "view/jd/jdRecord/gridButton";
    }

    /**
     * 通过监督任务书编号获取工程信息
     *
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String jdTaskCode, Model model) {
        JdProjectInfo jdProjectInfo = jdRecordManager.getProjectInfo(jdTaskCode);
        JSONArray jsonArray = JSONArray.fromObject(jdProjectInfo);
        String json = jsonArray.toString();
        model.addAttribute("msg", json);
        return "common/msg";
    }
}