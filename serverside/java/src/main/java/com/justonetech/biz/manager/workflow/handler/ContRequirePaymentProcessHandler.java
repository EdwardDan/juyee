//package com.justonetech.biz.manager.workflow.handler;
//
//import com.justonetech.ipromis.Constant;
//import com.justonetech.ipromis.daoservice.ContRequirePaymentService;
//import com.justonetech.ipromis.domain.ContRequirePayment;
//import com.justonetech.ipromis.service.contract.ContContractManager;
//import com.justonetech.ipromis.service.contract.ContRequirePaymentManager;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * 付款申请单流程handler
// *
// * @version 1.0
// * @author: Ma Ji
// * @since: 2009-10-15
// */
//@Service
//public class ContRequirePaymentProcessHandler implements ProcessHandler {
//    private static final Log log = LogFactory.getLog(ContRequirePaymentProcessHandler.class);
//
//    @Autowired
//    private ContRequirePaymentService contRequirePaymentService;
//
//    @Autowired
//    private ContContractManager contContractManager;
//
//    @Autowired
//    private ContRequirePaymentManager contRequirePaymentManager;
//
//
//    @Override
//    public void onCreate(Object bizObject) {
//        //把付款申请单标记为提交审核
//        ContRequirePayment contRequirePayment = (ContRequirePayment) bizObject;
//        contRequirePayment.setStatus("20");
//        contRequirePaymentService.save(contRequirePayment);
//        log.debug("set ContRequirePayment status to started.");
//    }
//
//    @Override
//    public void onUpdate(Object bizObject) {
//    }
//
//    @Override
//    public void onFinish(Object bizObject) {
//        //把付款申请单标记为审核通过
//        ContRequirePayment contRequirePayment = (ContRequirePayment) bizObject;
//        contRequirePayment.setStatus("40");
//
//        Double accuPayment = contRequirePaymentManager.getAccuPayment(contRequirePayment);
//        contRequirePayment.setAccuPayment(accuPayment);
//
//        contRequirePaymentService.save(contRequirePayment);
//        log.debug("set ContRequirePayment status to finished.");
//
//        //得到累计的批准支付
//
//        //计算并更新合同基本信息表的金额
//        contContractManager.calcContractMoney(contRequirePayment.getContract().getId(), Constant.CONT_CODE_REQUIRE_PAYMENT);
//        log.debug("ContRequirePayment finished and call ContRequirePaymentProcessHandler#onFinish to calcContractMoney");
//    }
//}