package com.justonetech.biz.manager;

import com.justonetech.biz.daoservice.JdStopOrderService;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SimpleQueryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:(新)监督指令单业务类
 * User: Chenjp
 * Date: 14-1-7 上午09:33
 */
@Service
public class JdStopOrderManager {
    private Logger logger = LoggerFactory.getLogger(JdStopOrderManager.class);

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private JdStopOrderService jdStopOrderService;

    /**
     * 获取最大序号+1
     *
     * @param formCode .
     * @return .
     */
    public String getStopOrderOrderNo(String formCode) {
        String code = simpleQueryManager.getStringBySql("select max(order_no) as no from jd_stop_order where form_code='" + formCode + "'");
        if (StringHelper.isEmpty(code)) {
            code = "0";
        }
        return StringHelper.leftPad(String.valueOf(Integer.parseInt(code) + 1), 3, "0");
    }

    /**
     * 获取最大序号+1
     *
     * @return .
     */
    public String getRecoverFormOrderNo() {
        String code = simpleQueryManager.getStringBySql("select max(order_no) as no from jd_recover_form");
        if (StringHelper.isEmpty(code)) {
            code = "0";
        }
        return StringHelper.leftPad(String.valueOf(Integer.parseInt(code) + 1), 3, "0");
    }

    /**
     * 单据数量
     *
     * @param code .
     * @param date .
     * @return .
     */
    public int getNum(String code, String date) {
        int num = 0;
        String sql = "select count(form_code) from jd_stop_order where form_code='" + code +
                "' and (select distinct to_char(sign_date,'yyyy-mm')  from jd_stop_order where to_char(sign_date,'yyyy-mm')='" + date + "') = '" + date + "'";
        List listStop = jdStopOrderService.findBySql(sql);
        if (null != listStop && listStop.size() > 0) {
            num = JspHelper.getInteger(listStop.iterator().next());
        }
        return num;
    }

}
