package com.justonetech.biz.controller.syn;

import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.SyncDatabaseManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 同步测试
 */
@Controller
public class SyncTestController extends BaseCRUDActionController {

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private SyncDatabaseManager syncDatabaseManager;

    @RequestMapping
    public void testSyncData(HttpServletResponse response) throws Exception {
        syncDatabaseManager.syncDatabase();

        sendSuccessJSON(response, "同步数据成功！");

    }
}
