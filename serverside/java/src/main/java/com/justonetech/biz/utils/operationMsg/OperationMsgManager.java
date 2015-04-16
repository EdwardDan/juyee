package com.justonetech.biz.utils.operationMsg;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * User: Chen Junping
 * Date: 12-5-9
 */
@Service
public class OperationMsgManager {
    private static String msgType_success = "success";
    private static String msgType_fail = "fail";

    /**
     * 操作成功提示
     *
     * @param model .
     * @param url   .
     * @param msg   .
     * @return .
     */
    public static String successMsg(Model model, String url, String msg) {
        OperationMsg operationMsg = new OperationMsg();
        operationMsg.setMsgType(msgType_success);
        operationMsg.setMsg(msg);
        operationMsg.setUrl(url);
        operationMsg.setAutoJump(true);
        operationMsg.setNeedClose(false);
        operationMsg.setRefreshTree(false);
        operationMsg.setRefreshOpener(false);
        operationMsg.setRefreshTreeChildren(false);
        operationMsg.setIsQuickEvent(false);

        model.addAttribute("msg", operationMsg);
        return "common/successMsg";
    }

    /**
     * 操作成功提示，关闭窗口
     *
     * @param model .
     * @param url   .
     * @param msg   .
     * @return .
     */
    public static String successCloseMsg(Model model, String url, String msg) {
        OperationMsg operationMsg = new OperationMsg();
        operationMsg.setMsgType(msgType_success);
        operationMsg.setMsg(msg);
        operationMsg.setUrl(url);
        operationMsg.setAutoJump(true);
        operationMsg.setNeedClose(true);
        operationMsg.setRefreshTree(false);
        operationMsg.setRefreshOpener(false);
        operationMsg.setRefreshTreeChildren(false);
        operationMsg.setIsQuickEvent(false);

        //如果业务对象类名和流程模板编码一致，则启动流程（显示启动流程按钮）
        //目前仅用于合同的付款申请单
//        bpmProcessFormDataManager.getBizFlowTag(model);

        model.addAttribute("msg", operationMsg);
        return "common/successMsg";
    }

    public static String successCloseMsg(Model model, String url, String msg, String customEvent,Boolean isQuickEvent) {
        OperationMsg operationMsg = new OperationMsg();
        operationMsg.setMsgType(msgType_success);
        operationMsg.setMsg(msg);
        operationMsg.setUrl(url);
        operationMsg.setAutoJump(true);
        operationMsg.setNeedClose(true);
        operationMsg.setRefreshTree(false);
        operationMsg.setRefreshOpener(false);
        operationMsg.setRefreshTreeChildren(false);
        operationMsg.setCustomEvent(customEvent);
        operationMsg.setIsQuickEvent(isQuickEvent);

        model.addAttribute("msg", operationMsg);
        return "common/successMsg";
    }

        /**
        * 操作成功提示
        *
        * @param model       .
        * @param url         .
        * @param msg         .
        * @param customEvent .
        * @return .
        */
    public static String successMsg(Model model, String url, String msg, String customEvent) {
        OperationMsg operationMsg = new OperationMsg();
        operationMsg.setMsgType(msgType_success);
        operationMsg.setMsg(msg);
        operationMsg.setUrl(url);
        operationMsg.setAutoJump(true);
        operationMsg.setNeedClose(false);
        operationMsg.setRefreshTree(false);
        operationMsg.setRefreshOpener(false);
        operationMsg.setRefreshTreeChildren(false);
        operationMsg.setCustomEvent(customEvent);
        operationMsg.setIsQuickEvent(false);

        model.addAttribute("msg", operationMsg);
        return "common/successMsg";
    }

     /**
     * 操作失败提示
     *
     * @param model .
     * @param url   .
     * @param msg   .
     * @return .
     */
    public static String errorMsg(Model model, String url, String msg) {
        OperationMsg operationMsg = new OperationMsg();
        operationMsg.setMsgType(msgType_fail);
        operationMsg.setMsg(msg);
        operationMsg.setUrl(url);
        operationMsg.setAutoJump(true);
        operationMsg.setNeedClose(false);
        operationMsg.setRefreshTree(false);
        operationMsg.setRefreshOpener(false);
        operationMsg.setIsQuickEvent(false);

        model.addAttribute("msg", operationMsg);
        return "common/errorMsg";
    }
}
