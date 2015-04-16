package com.justonetech.biz.controller.android;

import com.justonetech.biz.domain.bean.android.AndroidCommonMsg;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * note: 打印查看页面
 * User: Shaxj
 * Date: 14-8-13
 * Time: 下午4:06
 */
@Controller
public class AndroidJdRecordViewController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(AndroidJdRecordViewController.class);

    /**
     * 打印查看页面（公用）
     *
     * @param reportName
     * @return
     */
    @RequestMapping
    public String getView(Model model, String reportName, Long id, HttpServletRequest request) {
        AndroidCommonMsg msg = new AndroidCommonMsg();
//        String contextPath = "";
//        if (!StringHelper.isEmpty(request.getContextPath())) {
//            contextPath += "/" + request.getContextPath();
//        }
        String url = "ReportServer?reportlet=report/" + reportName + ".cpt&" + "id=" + id;
//        String url = contextPath + "/ReportServer?reportlet=report/" + reportName + ".cpt&" + "id=" + id;
        msg.setMsg(url);
        model.addAttribute("msg", JSONArray.fromObject(msg).toString());
        return "common/androidMsg";
    }
}
