package com.justonetech.biz.controller.syn;

import com.justonetech.biz.domain.ExcelJdDwgc;
import com.justonetech.biz.manager.ExcelJdTasksSyncManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


/**
 * note:Excel监督任务书同步测试类
 * author: chenjp
 */
@Controller
public class ExcelJdTasksSyncController extends BaseCRUDActionController<ExcelJdDwgc> {
    private Logger logger = LoggerFactory.getLogger(ExcelJdTasksSyncController.class);

    @Autowired
    private ExcelJdTasksSyncManager excelJdTasksSyncManager;

    /**
     * 测试页面
     *
     * @param response .
     */
    @RequestMapping
    public void test(HttpServletResponse response) {
        excelJdTasksSyncManager.syncData();

        sendSuccessJSON(response, "同步成功");
    }
}