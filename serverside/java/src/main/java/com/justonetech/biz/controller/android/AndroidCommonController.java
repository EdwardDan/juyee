package com.justonetech.biz.controller.android;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.biz.manager.AndroidCommonManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传图片
 * User: juyee
 * Date: 12-9-17
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AndroidCommonController extends BaseCRUDActionController {

    private Logger logger = LoggerFactory.getLogger(AndroidCommonController.class);

    @Autowired
    private AndroidCommonManager androidCommonManager;

//    @Autowired
//    private CheckInfoSyncManager checkInfoSyncManager;

    /**
     * 上传巡查监督图片
     *
     * @param model 。
     */
    @RequestMapping
    public void uploadPhoto(Model model, String mark, Long id, HttpServletRequest request, HttpServletResponse response) {
        try {
            androidCommonManager.uploadPhoto(mark, id, request);
            sendSuccessJSON(response, "上传图片成功！");
        } catch (Exception e) {
            e.printStackTrace();
            sendFailureJSON(response, e.getMessage());
        }
    }
//
//    @RequestMapping
//    public void test(Model model) {
//        try {
//            checkInfoSyncManager.getCheckInfoList();
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//    }
}
