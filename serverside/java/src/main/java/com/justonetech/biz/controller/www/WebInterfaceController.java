package com.justonetech.biz.controller.www;

import com.justonetech.biz.domain.*;
import com.justonetech.biz.domain.bean.webInterface.*;
import com.justonetech.biz.manager.MsgMessageManager;
import com.justonetech.biz.manager.NetAcceptManager;
import com.justonetech.biz.manager.OaTaskManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetCfbBidMethod;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


/**
 * 网站数据接口--项目审批流程--提供给骏诺
 * Date: 2014-8-19
 * test url: http://localhost:8089/mis/webInterface/getProjectInfo.do?bjbh=1402HK0054
 * test url: http://localhost:8089/mis/webInterface/getCfbInfo.do?bjbh=1402HK0026
 * test url: http://localhost:8089/mis/webInterface/getSecondInfo.do?bizCode=NetCfb&bidMethod=public&childId=6
 * test url: http://localhost:8089/mis/webInterface/getUnitQualifyList.do?startDate=2014-07-01&endDate=2014-07-31
 */
@Controller
public class WebInterfaceController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(WebInterfaceController.class);

    @Autowired
    private NetAcceptManager netAcceptManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 获取报建工程基本信息
     *
     * @param model .
     * @param bjbh  报建编号
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(Model model, String bjbh) {
        String msg = "";
        NetApply netApply = netAcceptManager.getProjectUnLimit(bjbh);
        if (netApply != null) {
            Long netApplyId = netApply.getId();

            //项目基本信息
            WebProject data = new WebProject();
            data.setBjbh(bjbh);
            data.setProjectName(netApply.getProjectName());
            data.setBuildUnitName(netApply.getBuildUnitName());
            data.setBuildAddress(netApply.getBuildAddress());

            ShareProTobuild proTobuild = projectManager.getProject(bjbh);
            if (proTobuild != null) {
                data.setTotalInvestment(proTobuild.getTotalInvestment());
            }

            //报建信息
            WebFirstStep bjAction = new WebFirstStep();
            bjAction.setNeed(true);
            bjAction.setComplete(netApply.getAcceptStatus().getIsEnd() != null && netApply.getAcceptStatus().getIsEnd()); //报建是否完成

            List<WebOperation> bjOps = new ArrayList<WebOperation>();
            List<NetOpLog> bjOpLogs = netAcceptManager.getNetOpLogs(NetApply.class.getSimpleName(), netApplyId);
            for (NetOpLog log : bjOpLogs) {
                WebOperation op = new WebOperation();
                op.setStep(log.getAcceptStatus().getAcceptStep().getName());
                op.setName(log.getAcceptStatus().getName());
                op.setResults(log.getBackCause());
                op.setTime(String.valueOf(log.getAcceptDate()));
                bjOps.add(op);
            }
            bjAction.setChild(bjOps);
            data.setBjAction(bjAction);

            //施工图
            WebFirstStep sgt = new WebFirstStep();
            sgt.setNeed(netApply.getIsCheckDraw());
            sgt.setComplete(false);    //todo 无法获取，暂不考虑
            data.setSgt(sgt);

            //项目报监
            WebFirstStep monitor = new WebFirstStep();
            List<WebOperation> monitorOps = new ArrayList<WebOperation>();
            Boolean isMonitorComplete = false;   //是否完成
            Set<NetMonitor> netMonitors = netApply.getNetMonitors();   //todo 一个项目的多次报监全部列出，以标段号区分
            for (NetMonitor netMonitor : netMonitors) {
                List<NetOpLog> monitorOpLogs = netAcceptManager.getNetOpLogs(NetMonitor.class.getSimpleName(), netMonitor.getId());
                for (NetOpLog log : monitorOpLogs) {
                    NetAcceptStatus acceptStatus = log.getAcceptStatus();

                    WebOperation op = new WebOperation();
                    op.setBdh(netMonitor.getBdh());
                    op.setStep(acceptStatus.getAcceptStep().getName());
                    op.setName(acceptStatus.getName());
                    op.setResults(log.getBackCause());
                    op.setTime(String.valueOf(log.getAcceptDate()));
                    monitorOps.add(op);

                    //完成状态：只要有任意一条记录受理通过就代表完成
                    if (acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) {
                        isMonitorComplete = true;
                    }
                }
            }
            monitor.setChild(monitorOps);
            monitor.setNeed(true);
            monitor.setComplete(isMonitorComplete);      //只要有一条记录全部步骤受理通过即为完成
            data.setXmbj(monitor);

            //施工许可
            WebFirstStep sgxk = new WebFirstStep();
            List<WebOperation> sgxkOps = new ArrayList<WebOperation>();
            Boolean isSgxkComplete = false;   //是否完成
            Set<NetSgpermit> netSgpermits = netApply.getNetSgpermits();  //todo 一个项目的多次许可证是否全部列出
            for (NetSgpermit netSgpermit : netSgpermits) {
                List<NetOpLog> monitorOpLogs = netAcceptManager.getNetOpLogs(NetSgpermit.class.getSimpleName(), netSgpermit.getId());
                for (NetOpLog log : monitorOpLogs) {
                    NetAcceptStatus acceptStatus = log.getAcceptStatus();

                    WebOperation op = new WebOperation();
                    op.setBdh(netSgpermit.getBdh());
                    op.setStep(acceptStatus.getAcceptStep().getName());
                    op.setName(acceptStatus.getName());
                    op.setResults(log.getBackCause());
                    op.setTime(String.valueOf(log.getAcceptDate()));
                    sgxkOps.add(op);

                    //完成状态：只要有任意一条记录受理通过就代表完成
                    if (acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) {
                        isSgxkComplete = true;
                    }
                }
            }
            sgxk.setChild(sgxkOps);
            sgxk.setNeed(true);
            sgxk.setComplete(isSgxkComplete);
            data.setSgxk(sgxk);

//            System.out.println("data = " + data);
            msg = JSONObject.fromObject(data).toString();
        }
        model.addAttribute("msg", msg);
        return "common/androidMsg";
    }

    /**
     * 获取承发包信息
     *
     * @param model .
     * @param bjbh  报建编号
     * @return .
     */
    @RequestMapping
    public String getCfbInfo(Model model, String bjbh) {
        String msg = "";
        NetApply netApply = netAcceptManager.getProjectUnLimit(bjbh);
        if (netApply != null) {
            List<WebCfb> cfbList = new ArrayList<WebCfb>();

            //承发包记录
            Map<String, List<NetCfb>> cfbMap = netAcceptManager.getCfbRecordByBjbh(bjbh);
            Map<String, List<NetContract>> contractMap = netAcceptManager.getContractRecordByBjbh(bjbh);

            //发包方式
            Map<Long, NetApplyFbType> existHM = new HashMap<Long, NetApplyFbType>();
            Set<NetApplyFbType> fbTypes = netApply.getNetApplyFbTypes();
            for (NetApplyFbType fbType : fbTypes) {
                existHM.put(fbType.getFbTypeId().getId(), fbType);
            }
            List<SysCodeDetail> typeList = sysCodeManager.getCodeListByCode(Constants.NET_APPLY_FB_TYPE);
            for (SysCodeDetail fbType : typeList) {
                NetApplyFbType netApplyFbType = existHM.get(fbType.getId());

                //承发包--公开招标
                WebCfb cfbPublic = new WebCfb();
                cfbPublic.setType(fbType.getCode().toUpperCase() + "_FB");
                cfbPublic.setNeed(false);     //是否要做
                Boolean isFBComplete = false; //是否完成
                cfbPublic.setBidMethod(NetCfbBidMethod.MTHOD_PUBLIC.getCode());
                if (netApplyFbType != null) {
                    cfbPublic.setNeed(netApplyFbType.getIsBid()); //报建信息中如果勾选"是否招标"项则必须要做

                    //公开招标记录
                    List<WebCfbFb> cfbPublicChildren = new ArrayList<WebCfbFb>();
                    String key = NetCfbBidMethod.MTHOD_PUBLIC.getCode() + "_" + fbType.getCode();
                    List<NetCfb> netCfbs = cfbMap.get(key);
//                    System.out.println("key = " + key+"|"+netCfbs);
                    if (netCfbs != null) {
                        for (NetCfb netCfb : netCfbs) {
                            WebCfbFb fb = new WebCfbFb();
                            fb.setChildName(fbType.getName() + "发包" + netCfb.getBdh());
                            fb.setChildId(netCfb.getId());
                            fb.setChildTime(JspHelper.getString(netCfb.getNetDate()));
                            fb.setBizCode(NetCfb.class.getSimpleName());
                            fb.setBidMethod(NetCfbBidMethod.MTHOD_PUBLIC.getCode());
                            cfbPublicChildren.add(fb);

                            //完成状态：只要有任意一条记录全部步骤受理通过就代表完成
                            NetAcceptStatus acceptStatus = netCfb.getAcceptStatus();
                            if (acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) {
                                isFBComplete = true;
                            }
                        }
                    }
                    cfbPublic.setChildren(cfbPublicChildren);
                }
                cfbPublic.setComplete(isFBComplete);
                cfbList.add(cfbPublic);

                //合同备案
                WebCfb ba = new WebCfb();
                ba.setType(fbType.getCode().toUpperCase() + "_BA");
                ba.setNeed(false);            //是否要做
                Boolean isBAComplete = false; //是否完成
                if (netApplyFbType != null) {
                    ba.setNeed(true);         //报建信息中如果勾选则必须要做

                    //备案记录
                    List<WebCfbFb> baChildren = new ArrayList<WebCfbFb>();
                    String key = fbType.getCode();
                    List<NetContract> netContracts = contractMap.get(key);
                    if (netContracts != null) {
                        for (NetContract data : netContracts) {
                            WebCfbFb fb = new WebCfbFb();
                            fb.setChildName(fbType.getName() + "备案" + data.getBdh());
                            fb.setChildId(data.getId());
                            fb.setChildTime(JspHelper.getString(data.getNetDate()));
                            fb.setBizCode(NetContract.class.getSimpleName());
                            fb.setBidMethod("");
                            baChildren.add(fb);

                            //完成状态：只要有任意一条记录全部步骤受理通过就代表完成
                            NetAcceptStatus acceptStatus = data.getAcceptStatus();
                            if (acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) {
                                isBAComplete = true;
                            }
                        }
                    }
                    ba.setChildren(baChildren);
                }
                ba.setComplete(isBAComplete);
                cfbList.add(ba);
            }

            //承发包--直接发包(只有施工发包)
            SysCodeDetail directFB = sysCodeManager.getCodeDetailByCode(Constants.NET_CFB_FB_TYPE, Constants.NET_CFB_FB_TYPE_SG);
            if (directFB != null) {
                WebCfb cfbDirect = new WebCfb();
                cfbDirect.setType(directFB.getCode().toUpperCase() + "_FB");
                cfbDirect.setNeed(false);  //todo 无法得知是否要做
                Boolean isDirectComplete = false; //是否完成
                cfbDirect.setBidMethod(NetCfbBidMethod.MTHOD_DIRECT.getCode());

                //承发包--直接发包记录
                List<WebCfbFb> cfbDirectChildren = new ArrayList<WebCfbFb>();
                String key = NetCfbBidMethod.MTHOD_DIRECT.getCode() + "_" + directFB.getCode();
                List<NetCfb> netCfbs = cfbMap.get(key);
                if (netCfbs != null) {
                    for (NetCfb netCfb : netCfbs) {
                        WebCfbFb fb = new WebCfbFb();
                        fb.setChildName(directFB.getName() + "发包" + netCfb.getBdh());
                        fb.setChildId(netCfb.getId());
                        fb.setChildTime(JspHelper.getString(netCfb.getNetDate()));
                        fb.setBizCode(NetCfb.class.getSimpleName());
                        fb.setBidMethod(NetCfbBidMethod.MTHOD_DIRECT.getCode());
                        cfbDirectChildren.add(fb);

                        //完成状态：只要有任意一条记录全部步骤受理通过就代表完成
                        NetAcceptStatus acceptStatus = netCfb.getAcceptStatus();
                        if (acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) {
                            isDirectComplete = true;
                        }
                    }
                }
                cfbDirect.setChildren(cfbDirectChildren);
                cfbDirect.setComplete(isDirectComplete);
                cfbList.add(cfbDirect);
            }

            msg = JSONArray.fromObject(cfbList).toString();
        }
        model.addAttribute("msg", msg);
        return "common/androidMsg";
    }

    /**
     * 获取步骤信息
     *
     * @param model     .
     * @param bizCode   .业务编码 （从承发包节点传递过来）
     * @param bidMethod .招标方式（public公开招标，direct直接发包，从承发包节点传递过来）
     * @param childId   .发包记录ID（承发包节点的childId）
     * @return .
     */
    @RequestMapping
    public String getSecondInfo(Model model, String bizCode, String bidMethod, Long childId) {
        String msg = "";

        //操作日志按步骤分类
        Map<Long, List<NetOpLog>> opHM = new HashMap<Long, List<NetOpLog>>();
        List<NetOpLog> logs = netAcceptManager.getNetOpLogs(bizCode, childId);
        for (NetOpLog log : logs) {
            Long stepId = log.getAcceptStatus().getAcceptStep().getId();
            List<NetOpLog> netOpLogs = opHM.get(stepId);
            if (netOpLogs == null) netOpLogs = new ArrayList<NetOpLog>();
            netOpLogs.add(log);
            opHM.put(stepId, netOpLogs);
        }

        //获取步骤列表
        List<WebSecondStep> secondSteps = new ArrayList<WebSecondStep>();
        String matterCode = bizCode;   //事项编码（承发包区分招标或直接发包）
        if (NetCfb.class.getSimpleName().equals(bizCode) && !StringHelper.isEmpty(bidMethod)) {
            matterCode += "_" + bidMethod;
        }
        List<NetAcceptStep> steps = netAcceptManager.getSteps(matterCode);
        for (NetAcceptStep step : steps) {
            WebSecondStep secondStep = new WebSecondStep();
            secondStep.setChildName(step.getName());
            secondStep.setNeed(true);      //todo 默认为全部要做

            //操作列表
            Boolean isComplete = false;   //是否完成
            List<WebOperation> operations = new ArrayList<WebOperation>();
            List<NetOpLog> netOpLogs = opHM.get(step.getId());
            if (netOpLogs != null) {
                for (NetOpLog netOpLog : netOpLogs) {
                    WebOperation op = new WebOperation();
                    NetAcceptStatus acceptStatus = netOpLog.getAcceptStatus();

                    op.setName(acceptStatus.getName());
                    op.setTime(String.valueOf(netOpLog.getAcceptDate()));
                    op.setResults(netOpLog.getBackCause());
                    operations.add(op);

                    //是否完成
                    if ((acceptStatus.getIsEnd() != null && acceptStatus.getIsEnd()) || (acceptStatus.getIsPass() != null && acceptStatus.getIsPass())) {
                        isComplete = true;
                    }
                }
            }
            secondStep.setChild(operations);
            secondStep.setComplete(isComplete);
            secondSteps.add(secondStep);
        }

        if (secondSteps.size() > 0) {
            msg = JSONArray.fromObject(secondSteps).toString();
        }
        model.addAttribute("msg", msg);

        return "common/androidMsg";
    }

    /**
     * 获取待办事项数量
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getTaskList(Model model, String loginName) {
        String msg = "";
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

        //MIS系统待办事项和通知
        SysUser sysUser = sysUserManager.getSysUser(loginName);
        if (sysUser != null) {
            int taskCount = oaTaskManager.getTaskDealList(sysUser.getId()).size();
            int msgCount = msgMessageManager.getMyMsgs(true).size();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "待办任务");
            map.put("count", taskCount + msgCount);
            ret.add(map);
        }

        if (ret.size() > 0) {
            msg = JSONArray.fromObject(ret).toString();
        }
        model.addAttribute("msg", msg);

        return "common/androidMsg";
    }

    /**
     * 获取企业资质批准信息
     *
     * @param model     .
     * @param startDate .
     * @param endDate   .
     * @return .
     */
    @RequestMapping
    public String getUnitQualifyList(Model model, String startDate, String endDate) {
        String msg = "";
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        Calendar c = Calendar.getInstance();
        if (StringHelper.isEmpty(startDate)) {
            startDate = c.get(Calendar.YEAR) + "-01-01";
        }
        if (StringHelper.isEmpty(endDate)) {
            endDate = DateTimeHelper.getCurrentDate();
        }
        String sql = "select distinct a.id,b.unit_name,a.qualify_big_type_desc,a.qualify_type_desc,a.qualify_level_desc,to_char(a.accept_datetime,'yyyy-mm-dd'),a.accept_datetime \n" +
                "from share_unit_qualify a,share_unit_info b \n" +
                "where to_char(a.accept_datetime,'yyyy-mm-dd')>= '{0}' and to_char(a.accept_datetime,'yyyy-mm-dd')<= '{1}' \n" +
                "and a.unit_id=b.id and b.reg_city_code='310109'\n" +
                "order by a.accept_datetime asc";
        sql = FormatUtils.format(sql, startDate, endDate);
//        System.out.println("sql = " + sql);
        List list = simpleQueryManager.getListBySql(sql);
        for (Object o : list) {
            Object[] oo = (Object[]) o;
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", JspHelper.getLong(oo[0]));
            map.put("unit", JspHelper.getString(oo[1]));
            map.put("zzlx", JspHelper.getString(oo[2]));
            map.put("zzmc", JspHelper.getString(oo[3]));
            map.put("zzdj", JspHelper.getString(oo[4]));
            map.put("pzsj", JspHelper.getString(oo[5]));
            ret.add(map);
        }

        if (ret.size() > 0) {
            msg = JSONArray.fromObject(ret).toString();
        }
        model.addAttribute("msg", msg);

        return "common/androidMsg";
    }
}
