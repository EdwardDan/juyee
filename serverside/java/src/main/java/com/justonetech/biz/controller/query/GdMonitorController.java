package com.justonetech.biz.controller.query;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.daoservice.ShareGdInfoService;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RegPersonManager;
import com.justonetech.biz.utils.CollectionUtils;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.webService.monitorWebService.Exception_Exception;
import com.justonetech.biz.utils.webService.monitorWebService.Monitor;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorParam;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorWebServiceClient;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import flexjson.JSONSerializer;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Chen Junping
 * Date: 12-3-19
 */
@Controller
public class GdMonitorController extends BaseCRUDActionController {

    private Logger logger = LoggerFactory.getLogger(ProjectQueryController.class);

    @Autowired
    MonitorWebServiceClient monitorWebServiceClient;

    @Autowired
    ConfigManager configManager;

    @Autowired
    ShareGdInfoService shareGdInfoService;

    @Autowired
    ProjectManager projectManager;

    @Autowired
    SysUserManager sysUserManager;

    @Autowired
    RegPersonManager regPersonManager;

    /**
     * 树+列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {
        return "view/query/gdMonitor/init";
    }

    /**
     * 树显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {

        return "view/query/gdMonitor/tree";
    }

    /**
     * 获取树数据
     * 注意：此页面为内外网公用
     *
     * @param model 。
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) throws Exception_Exception, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        ZTreeNode noMonitorNode = treeBranch.getRootNode("无视频接入");
        noMonitorNode.setIsLeaf(true);
        noMonitorNode.setIsParent(false);
        Map noMonitorMap = BeanUtils.describe(treeBranch.processNode(noMonitorNode));

        MonitorParam monitorParam = new MonitorParam();
        //区县编号
        monitorParam.setQxbh(configManager.getProjectAreaCode());
//        monitorParam.setQxbh("sj");

        //外网用户需限制范围，内网用户查看全部摄像头
        SysRegPerson regPerson = regPersonManager.getRegPerson();
        String hql = "from ShareGdInfo";
        if (regPerson != null) {
            String typeCode = regPerson.getRegType().getCode();
            String unitCode = regPerson.getUnitCode();
            String bjbh = regPerson.getBjbh();

            if (typeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG)) {     //施工单位
                hql = "from ShareGdInfo where sgTotalUnitCode='" + unitCode + "'";
//                monitorParam.setQydm(unitCode);  //后面会根据hql进行再次过滤
            } else if (typeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL)) {  //监理单位
                hql = "from ShareGdInfo where jlUnitCode ='" + unitCode + "'";
//                monitorParam.setQydm(unitCode);  //后面会根据hql进行再次过滤
            } else if (typeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {  //建设单位
                hql = "from ShareGdInfo where jlUnitCode ='" + unitCode + "'";
                monitorParam.setBjbh(bjbh);       //直接根据bjbh过滤
            } else {
                hql = "from ShareGdInfo where 1=2";   //无权限
            }

            //无企业代码和报建编号则直接返回无视频接入
            if (StringHelper.isEmpty(unitCode) && StringHelper.isEmpty(bjbh)) {
                model.addAttribute("msg", new JSONSerializer().exclude("*.checked", "*.class").serialize(noMonitorMap));
                return "common/msg";
            }
        }
        //从平安工地取该区县的摄像头
        List<Monitor> monitors = monitorWebServiceClient.getMonitorList(monitorParam);
        Map<String, List<Monitor>> monitorMap = new HashMap<String, List<Monitor>>();
        for (Monitor monitor : monitors) {
            List<Monitor> gdMonitors = monitorMap.get(monitor.getGdbh());
            if (gdMonitors == null) {
                gdMonitors = new ArrayList<Monitor>();
            }
            gdMonitors.add(monitor);
            monitorMap.put(monitor.getGdbh(), gdMonitors);
        }

        Map<String, Object> rootMap = BeanUtils.describe(treeBranch.processNode(treeBranch.getRootNode("根节点")));
        rootMap.put("open", true);

        if (monitorMap.keySet().size() > 0) {
            //根据当前用户权限查询工地列表
            List<ShareGdInfo> shareGdInfos = shareGdInfoService.findByQuery(hql);
            List<Map> gdList = new ArrayList<Map>();
            for (ShareGdInfo gdInfo : shareGdInfos) {
                List<Monitor> gdMonitors = monitorMap.get(gdInfo.getGdCode());
                if (gdMonitors == null) continue;   //如果没有摄像头则不显示此工地

                ZTreeNode gdNode = new ZTreeNode();
                gdNode.setId(gdInfo.getGdCode());
                gdNode.setName(gdInfo.getGdName());
                if (gdMonitors.size() > 0) {
                    gdNode.setIsLeaf(false);
                } else {
                    gdNode.setIsLeaf(true);
                }
                gdNode.setIcon("1");
                gdNode.setType("data");
                Map<String, Object> gdMap = BeanUtils.describe(treeBranch.processNode(gdNode));

                List<Map> monitorList = new ArrayList<Map>();
                for (Monitor monitor : gdMonitors) {
                    ZTreeNode monitorNode = new ZTreeNode();
                    monitorNode.setId(monitor.getGuid());
                    monitorNode.setName(monitor.getName());
                    monitorNode.setIsLeaf(true);
                    monitorNode.setIcon("3");
                    monitorNode.setType("monitor");
                    treeBranch.processNode(monitorNode);
                    monitorList.add(BeanUtils.describe(monitorNode));
                }
                gdMap.put("childs", monitorList);
                gdList.add(gdMap);
            }
            rootMap.put("childs", gdList);
        } else {
            rootMap = noMonitorMap;
        }
        monitorMap.clear();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"checked", "class"});
        JSONArray tranfer = JSONArray.fromObject(rootMap, jsonConfig);
        model.addAttribute("msg", tranfer.toString());
        return "common/msg";
    }

    /**
     * 查看页面
     *
     * @param model  .
     * @param gdCode .
     * @param guid   .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String gdCode, String guid) throws Exception_Exception {
        model.addAttribute("gdCode", gdCode);
        List<ShareGdInfo> shareGdInfos = shareGdInfoService.findByQuery("from ShareGdInfo where gdCode='" + gdCode + "'");
        ShareGdInfo shareGdInfo = CollectionUtils.getFirstEle(shareGdInfos);
        if (shareGdInfo != null) {
            model.addAttribute("project", projectManager.getProjectInfo(shareGdInfo.getBjbh()));
            model.addAttribute("monitorService", monitorWebServiceClient.getMonitorService(guid));
        }
        model.addAttribute("guid", guid);
        return "view/query/gdMonitor/view";
    }

    /**
     * 请求工地信息
     *
     * @param model    .
     * @param response .
     * @param gdCode   .
     */
    @RequestMapping
    public void getProjectInfo(Model model, HttpServletResponse response, String gdCode) {
        List<ShareGdInfo> shareGdInfos = shareGdInfoService.findByQuery("from ShareGdInfo where gdCode='" + gdCode + "'");
        ShareGdInfo shareGdInfo = CollectionUtils.getFirstEle(shareGdInfos);
        Map<String, Object> projectInfo = projectManager.getProjectInfo(shareGdInfo.getBjbh());
        if (projectInfo != null) {
            sendJSON(response, new JSONSerializer().include("data.buildUnitName", "data.projectName")
                    .exclude("*.class").serialize(projectInfo));
        }
    }
}
