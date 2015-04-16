package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetCfbBidMethod;
import com.justonetech.biz.utils.enums.NetMatterDefine;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 汇总查看
 * User: guoqiong
 * Date: 14-6-25
 */
@Controller
public class NetViewController extends BaseCRUDActionController {
    private Logger logger = LoggerFactory.getLogger(NetViewController.class);

    @Autowired
    private NetOpLogService netOpLogService;

    @Autowired
    private NetSgpermitService netSgpermitService;

    @Autowired
    private NetCfbService netCfbService;

    @Autowired
    private NetApplyService netApplyService;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private NetMonitorService netMonitorService;

    @Autowired
    private NetContractService netContractService;

    /**
     * 列表显示页面
     *
     * @return .
     */
    @RequestMapping
    public String grid() {

        return "view/net/netView/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetApply where isImportant=1 order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netApplyService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看页面
     *
     * @param model   .
     * @param applyId .
     * @return .
     */
    @RequestMapping
    public String iframe(Model model, Long applyId) {
        model.addAttribute("id", applyId);

        return "view/net/netView/iframe";
    }

    /**
     * 查看页面
     *
     * @param model   .
     * @param applyId .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long applyId) {
        NetApply netApply = netApplyService.get(applyId);
        String bjbh = netApply.getBjbh();

        //标段号(施工许可) --不需要div切换tab
        String hqlSg = "from NetSgpermit where apply.bjbh=?";
        List<NetSgpermit> sgPermitList = netSgpermitService.findByQuery(hqlSg, bjbh);
        if (null != sgPermitList && sgPermitList.size() > 0) {
            NetSgpermit netSgpermit = sgPermitList.iterator().next();
            List<Map<String, Object>> retSg = getMapList(NetSgpermit.class.getSimpleName(), netSgpermit.getId());
            model.addAttribute("stepSgName", NetMatterDefine.MATTER_SGPERMIT.getName());
            model.addAttribute("bdhSg", netSgpermit.getBdh());
            model.addAttribute("listSg", retSg);
        }

        //合同备案
        Map<String, Map<String, String>> listMapContract = new HashMap<String, Map<String, String>>();
        Map<String, List<Map<String, Object>>> listContract = new HashMap<String, List<Map<String, Object>>>();
        List<SysCodeDetail> listByCodeCon = sysCodeManager.getCodeListByCode(Constants.NET_CONTRACT_TYPE);
        model.addAttribute("listCon", listByCodeCon);
        model.addAttribute("conSize1", listByCodeCon.size());
        for (SysCodeDetail detail : listByCodeCon) {
            String hqlContract = "from NetContract where contractType.id=? and apply.bjbh=?";
            List<NetContract> netContractList = netContractService.findByQuery(hqlContract, detail.getId(), bjbh);
            if (null != netContractList && netContractList.size() > 0) {
                NetContract netContract = netContractList.iterator().next();
                List<Map<String, Object>> retContract = getMapList(NetContract.class.getSimpleName(), netContract.getId());
                Map<String, String> map = new HashMap<String, String>();
                map.put("stepContractName", NetMatterDefine.MATTER_CONTRACT.getName());
                map.put("bdhContract", netContract.getBdh());
                listMapContract.put(detail.getName(), map);
                listContract.put(detail.getName(), retContract);
            }
        }
        model.addAttribute("stepContractName", NetMatterDefine.MATTER_CONTRACT.getName());
        model.addAttribute("listContract", listContract);
        model.addAttribute("listMapCon", listMapContract);
        model.addAttribute("conSize2", listMapContract.size());

        //项目承发包（公开招标）
        Map<String, Map<String, String>> listMapCfb = new HashMap<String, Map<String, String>>();
        Map<String, List<Map<String, Object>>> listCfb = new HashMap<String, List<Map<String, Object>>>();
        List<SysCodeDetail> listByCodeCfb = sysCodeManager.getCodeListByCode(Constants.NET_CFB_FB_TYPE);
        model.addAttribute("listCfbCode", listByCodeCfb);
        model.addAttribute("cfbSize1", listByCodeCfb.size());
        for (SysCodeDetail detail : listByCodeCfb) {
            String hqlContract = "from NetCfb where bidMethodCode=? and fbType.id=? and apply.bjbh=?";
            List<NetCfb> netCfbList = netCfbService.findByQuery(hqlContract, NetCfbBidMethod.MTHOD_PUBLIC.getCode(), detail.getId(), bjbh);
            if (null != netCfbList && netCfbList.size() > 0) {
                NetCfb netCfb = netCfbList.iterator().next();
                List<Map<String, Object>> retCfb = getMapList(NetCfb.class.getSimpleName(), netCfb.getId());
                Map<String, String> map = new HashMap<String, String>();
                map.put("stepCfbName", NetMatterDefine.MATTER_CFB_PUBLIC.getName());
                map.put("bdhCfb", netCfb.getBdh());
                listMapCfb.put(detail.getName(), map);
                listCfb.put(detail.getName(), retCfb);
            }
        }
        model.addAttribute("stepCfbName", NetMatterDefine.MATTER_CFB_PUBLIC.getName());
        model.addAttribute("listCfb", listCfb);
        model.addAttribute("listMapCfb", listMapCfb);
        model.addAttribute("cfbSize2", listMapCfb.size());

        //项目承发包（直接发包）--不需要div切换tab
        String hqlCfbZj = "from NetCfb where bidMethodCode=? and apply.bjbh=?";
        List<NetCfb> cfbZjList = netCfbService.findByQuery(hqlCfbZj, NetCfbBidMethod.MTHOD_DIRECT.getCode(), bjbh);
        if (null != cfbZjList && cfbZjList.size() > 0) {
            NetCfb netCfb = cfbZjList.iterator().next();
            List<Map<String, Object>> retCfbZj = getMapList(NetCfb.class.getSimpleName(), netCfb.getId());

            model.addAttribute("stepCfbZjName", NetMatterDefine.MATTER_CFB_DIRECT.getName());
            model.addAttribute("bdhCfbZj", netCfb.getBdh());
            model.addAttribute("listCfbZj", retCfbZj);
        }

        //项目报监 --不需要div切换tab
        String hqlMonitor = "from NetMonitor where apply.bjbh=?";
        List<NetMonitor> monitorList = netMonitorService.findByQuery(hqlMonitor, bjbh);
        if (null != monitorList && monitorList.size() > 0) {
            NetMonitor netMonitor = monitorList.iterator().next();
            List<Map<String, Object>> retMonitor = getMapList(NetMonitor.class.getSimpleName(), netMonitor.getId());

            model.addAttribute("stepMonitorName", NetMatterDefine.MATTER_MONITOR.getName());
            model.addAttribute("bdhMonitor", netMonitor.getBdh());
            model.addAttribute("listMonitor", retMonitor);
        }

        //项目报建 --不需要div切换tab
        List<Map<String, Object>> retApply = getMapList(NetApply.class.getSimpleName(), netApply.getId());
        model.addAttribute("stepApplyName", NetMatterDefine.MATTER_APPLY.getName());
        model.addAttribute("listApply", retApply);

        return "view/net/netView/view";
    }

    /**
     * 根据类名和id获取list
     *
     * @param bizClass .
     * @param bizId    .
     * @return .
     */
    private List<Map<String, Object>> getMapList(String bizClass, Long bizId) {
        List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
        Map<Long, List<NetOpLog>> logMap = new HashMap<Long, List<NetOpLog>>();
        String hqlSgLog = "from NetOpLog where bizClass=? and bizId=? order by acceptStatus.acceptStep.no,id asc";
        List<NetOpLog> logSgs = netOpLogService.findByQuery(hqlSgLog, bizClass, bizId);
        for (NetOpLog log : logSgs) {
            NetAcceptStep step = log.getAcceptStatus().getAcceptStep();
            Long key = step.getId();
            List<NetOpLog> list = logMap.get(key);
            if (list == null) {
                list = new ArrayList<NetOpLog>();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("step", step);
                ret.add(map);
            }
            list.add(log);
            logMap.put(key, list);
        }

        for (Map<String, Object> map : ret) {
            NetAcceptStep step = (NetAcceptStep) map.get("step");
            map.put("logs", logMap.get(step.getId()));
        }
        return ret;
    }

}
