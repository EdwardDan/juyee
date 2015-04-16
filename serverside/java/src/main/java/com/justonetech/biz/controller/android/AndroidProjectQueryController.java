package com.justonetech.biz.controller.android;

import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.manager.projectInfo.CustomProjectInfo;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.domain.*;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.webService.monitorWebService.MonitorWebServiceClient;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysUserManager;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手持终端信息交互--项目查询
 * User: Wu yang
 * Date: 12-3-19
 */
@Controller
public class AndroidProjectQueryController extends BaseCRUDActionController<ShareProTobuild> {
    private Logger logger = LoggerFactory.getLogger(AndroidProjectQueryController.class);

    @Autowired
    private PlanDetailService planDetailService;

    @Autowired
    private ShareProTobuildService shareProTobuildService;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private MonitorWebServiceClient monitorWebServiceClient;

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private ShareProDwgcMonitorService shareProDwgcMonitorService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OrderFormDeployService orderFormDeployService;

    @Autowired
    private ExcelJdTasksManager excelJdTasksManager;

    @Autowired
    private ExcelJdTasksService excelJdTasksService;

    @Autowired
    private JdRecordFirstService jdRecordFirstService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private PlanDetailUserService planDetailUserService;

    /**
     * 获取指定范围内的项目列表
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String name, String JdTaskCode, String longitude, String latitude) {
        String sql = "select distinct s.bjbh,s.project_name,s.build_address as build_address,pe.pos_x as x,pe.pos_y as y,t.property,t.cont_Money as total_Investment,s.total_Area as total_Area,s.bj_date as bj_Date" +
//                ",'' as gdCount,'' as gdCode" +
                ",t.JS_UNIT_NAME as build_unit_name" +
                ",s.share_datetime as share_datetime" +
                " from excel_jd_tasks t " +
                " left join project_extend pe on pe.bjbh=t.bjbh " +
                " inner join SHARE_PRO_TOBUILD s on s.bjbh=t.bjbh " +
//                " left join share_gd_info g on t.bjbh=g.bjbh" +
//                " left join share_pro_jl_info j on t.bjbh=j.bjbh" +
//                " where trim(t.belong_area)='{0}'";
                " where 1=1";   //excel_jd_tasks.belong_area存储是松江下面的街镇名称，不需要再过滤

//        sql += " and t.bjbh in (select bjbh from Share_Gd_Info where gd_Status_Code in (" + projectManager.GD_STATUS_CODE_NOTCOMPLETE + "))";
//        sql = FormatUtils.format(sql, configManager.getProjectArea());
        List shareProTobuilds = new ArrayList();
        if (!StringHelper.isEmpty(name) || !StringHelper.isEmpty(JdTaskCode)) {
            if (!StringHelper.isEmpty(name)) {
                String regExp = "[\u4E00-\u9FA5]";
                Pattern p = Pattern.compile(regExp);
                Matcher m = p.matcher(name);
                // 如果有中文则判断为项目名称，没有则判断为报建编号
                if (m.find()) {
                    sql += " and  t.project_name like '%" + name + "%'";
                } else {
                    sql += " and  t.bjbh like '%" + name + "%'";
                }
            }
            if (!StringHelper.isEmpty(JdTaskCode)) {
                sql += " and t.Jd_Task_Code='" + JdTaskCode.toUpperCase() + "'";
            }
            shareProTobuilds = simpleQueryManager.getMapList(sql);
        } else if (!StringHelper.isEmpty(longitude) && !StringHelper.isEmpty(latitude)) {
            sql += " and t.x is not null";
            List list = simpleQueryManager.getMapList(sql);
            for (Object obj : list) {
                Map map = (Map) obj;
                double distance = projectManager.distance(JspHelper.getDouble(map.get("X")), JspHelper.getDouble(map.get("Y")), JspHelper.getDouble(longitude), JspHelper.getDouble((latitude)));
                if (distance < projectManager.DISTANCE_NUM) {
//                    System.out.println(map.get("ID")+" = " + distance);
                    shareProTobuilds.add(map);
                }
            }
        }
        String msg = new JSONSerializer().exclude("*.class").serialize(shareProTobuilds);
        model.addAttribute("msg", msg);
        return "common/msg";
    }


    /**
     * 查看页面--先选择工地
     *
     * @param model .
     * @param bjbh  .
     * @return .
     */
    @RequestMapping
    public String viewSelect(Model model, String bjbh) {
        String sql = " select DISTINCT t.ID,s .bjbh,T .JD_TASK_CODE,s .project_name,s .build_address AS build_address,pe .pos_x as x,pe .pos_y as y,T .property," +
                " T .cont_Money AS total_Investment,s .total_Area AS total_Area,T .jd_datetime AS bj_Date,T .JS_UNIT_NAME AS build_unit_name " +
                " FROM excel_jd_tasks T " +
                " left join project_extend pe on pe.bjbh=t.bjbh  " +
                " inner join SHARE_PRO_TOBUILD s on s.bjbh=t.bjbh " +
                "  WHERE 1 = 1 and t.bjbh='" + String.valueOf(bjbh) + "'";
        List shareProTobuilds = new ArrayList();
        List list = simpleQueryManager.getMapList(sql);
        if (null != list && list.size() > 0)
            shareProTobuilds = list;
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(shareProTobuilds));
        return "common/msg";
    }

    /**
     * 项目详细页面--同时提供给其他模块调用
     *
     * @param model      .
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String view(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ExcelJdTasks excelJdTasks = excelJdTasksManager.findExcelJdTasks(jdTaskCode);
        if (excelJdTasks != null) {
            bjbh = excelJdTasks.getBjbh();
        }
//        if (StringHelper.isEmpty(bjbh)) {
//            ProFlowCode proFlowCode = proFlowCodeManager.getProFlowCode(flowCode);
//            if (proFlowCode != null) {
//                bjbh = proFlowCode.getBjbh();
//            }
//        }

        model.addAttribute("excelJdTasks", excelJdTasks);
        model.addAttribute("bjbh", JspHelper.getString(bjbh));
        model.addAttribute("gdCode", JspHelper.getString(gdCode));
        model.addAttribute("jdTaskCode", JspHelper.getString(jdTaskCode));
        model.addAttribute("param", "bjbh=" + bjbh + "&gdCode=" + gdCode + "&jdTaskCode=" + jdTaskCode);

        return "view/query/projectQuery/view";
    }

    /**
     * 1、查看项目概况
     *
     * @param model
     * @param bjbh
     * @param jdTaskCode
     * @return
     */
    @RequestMapping
    public String viewProject(Model model, String bjbh, String jdTaskCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ExcelJdTasks> excelJdTaskList = excelJdTasksService.findByProperty("jdTaskCode", jdTaskCode);
        if (null != excelJdTaskList) {
            ExcelJdTasks excelJdTasks = excelJdTaskList.get(0);
            // 报监日期
            map.put("jdDateTime", JspHelper.getString(excelJdTasks.getJdDatetime()));
            // 工程建安量
            map.put("jagzl", JspHelper.getString(excelJdTasks.getContMoney()) + "万");
        }
        CustomProjectInfo allProjectInfo = projectManager.getProjectInfoByBjbh(bjbh);
        map.put("buildAddress", JspHelper.getString(allProjectInfo.getBuildAddress()));
        // 报建日期
        map.put("bjDate", JspHelper.getString(allProjectInfo.getBjDate()));
        map.put("bjProjectProperty", JspHelper.getString(allProjectInfo.getProjectProperty()));
        map.put("totalArea", JspHelper.getString(allProjectInfo.getTotalArea()));
        map.put("buildUnitName", JspHelper.getString(allProjectInfo.getJsdwmc()));
        map.put("buildUnitLxr", JspHelper.getString(allProjectInfo.getJsdwLxr()));
        map.put("buildUnitTel", JspHelper.getString(allProjectInfo.getJsdwTel()));
        map.put("belongArea", JspHelper.getString(allProjectInfo.getBelongArea()));

        map.put("projectName", JspHelper.getString(allProjectInfo.getProjectName()));
        map.put("sgUnit", JspHelper.getString(allProjectInfo.getSgdwmc()));
        map.put("sgUnitLxr", JspHelper.getString(allProjectInfo.getSgdwLxr()));
        map.put("sgUnitTel", JspHelper.getString(allProjectInfo.getSgdwTel()));
        map.put("kcUnit", JspHelper.getString(allProjectInfo.getKcdwmc()));
        map.put("kcUnitLxr", JspHelper.getString(allProjectInfo.getKcdwLxr()));
        map.put("kcUnitTel", JspHelper.getString(allProjectInfo.getKcdwTel()));
        map.put("sjUnit", JspHelper.getString(allProjectInfo.getSjdwmc()));
        map.put("sjUnitLxr", JspHelper.getString(allProjectInfo.getSjdwLxr()));
        map.put("sjUnitTel", JspHelper.getString(allProjectInfo.getSjdwTel()));
        map.put("jlUnit", JspHelper.getString(allProjectInfo.getJldwmc()));
        map.put("jlUnitLxr", JspHelper.getString(allProjectInfo.getJldwLxr()));
        map.put("jlUnitTel", JspHelper.getString(allProjectInfo.getJldwTel()));
        map.put("sgMainUnit", JspHelper.getString(allProjectInfo.getSgzbdwmc()));
        map.put("sgMainUnitLxr", JspHelper.getString(allProjectInfo.getSgzbdwLxr()));
        map.put("sgMainUnitTel", JspHelper.getString(allProjectInfo.getSgzbdwTel()));

        map.put("jdTaskCode", jdTaskCode);
        map.put("bjbh", bjbh);
        map.put("hasJdTaskCode", false);
        if (!StringHelper.isEmpty(jdTaskCode)) {
            map.put("hasJdTaskCode", true);
        }
        map.put("hasJDTask", getProjectJDTaskStatus(bjbh));
        List<Map<String, Object>> shareGdDwgcMapList = relateManager.getShareGdDwgcMapList(bjbh, null, null);
        map.put("dtsl", shareGdDwgcMapList.size());

        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }

    /**
     * 2、查看建设程序
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewBuild(Model model, String bjbh) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bean", data);
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        map.put("bjDateSelf", null != data.getBjDate() ? sp.format(data.getBjDate().getTime()) : "");
        map.put("list", relateManager.getShareProSgPermitList(bjbh));
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }

    /**
     * 3、查看承发包
     *
     * @param bjbh   .
     * @param gdCode .
     * @param model  .
     * @return .
     */
    @RequestMapping
    public String viewCfb(Model model, String bjbh, String gdCode, String jdTaskCode) {
        ShareProTobuild data = projectManager.getProject(bjbh);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bean", data);

        if (!StringHelper.isEmpty(jdTaskCode)) {
            Set<Map<String, Object>> kcList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> sjList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> jlList = new HashSet<Map<String, Object>>();
            Set<Map<String, Object>> sgList = new HashSet<Map<String, Object>>();

//            ProFlowCode proFlowCode = proFlowCodeManager.getProFlowCode(flowCode);
//            if (proFlowCode != null) {
//            String jdTaskCode = excelJdTasksManager.getJdTaskCode(flowCode);
            if (!StringHelper.isEmpty(jdTaskCode)) {
                List<ShareProDwgcMonitor> monitorList = relateManager.getShareProDwgcMonitorList(jdTaskCode);
                for (ShareProDwgcMonitor monitor : monitorList) {
                    getcfbList(kcList, monitor, Constants.BID_UNIT_TYPE_KC);
                    getcfbList(sjList, monitor, Constants.BID_UNIT_TYPE_SJ);
                    getcfbList(jlList, monitor, Constants.BID_UNIT_TYPE_JL);
                    getcfbList(sgList, monitor, Constants.BID_UNIT_TYPE_SG);
                }
            }
            map.put("kcList", kcList);
            map.put("sjList", sjList);
            map.put("jlList", jlList);
            map.put("sgList", sgList);
        } else {
            //kc、sj、jl、sg
            Set kcSet = new HashSet();
            Set sjSet = new HashSet();
            Set jlSet = new HashSet();
            Set sgSet = new HashSet();
            kcSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_KC, gdCode));
            sjSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_SJ, gdCode));
            jlSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_JL, gdCode));
            sgSet.addAll(relateManager.getBidUnitList(bjbh, Constants.BID_UNIT_TYPE_SG, gdCode));
            map.put("kcList", kcSet);
            map.put("sjList", sjSet);
            map.put("jlList", jlSet);
            map.put("sgList", sgSet);
        }

        model.addAttribute("msg", new JSONSerializer().exclude("*.class").deepSerialize(map));
        return "common/msg";
    }


    private void getcfbList(Set<Map<String, Object>> kcList, ShareProDwgcMonitor monitor, String type) {
        Map<String, Object> map = new HashMap<String, Object>();
        String unitCode = monitor.getSgUnitCode();
        String unitName = monitor.getSgUnitName();
        if (Constants.BID_UNIT_TYPE_KC.equals(type)) {
            unitCode = monitor.getKcUnitCode();
            unitName = monitor.getKcUnitName();
        } else if (Constants.BID_UNIT_TYPE_SJ.equals(type)) {
            unitCode = monitor.getSjUnitCode();
            unitName = monitor.getSjUnitName();
        } else if (Constants.BID_UNIT_TYPE_JL.equals(type)) {
            unitCode = monitor.getJlUnitCode();
            unitName = monitor.getJlUnitName();
        } else if (Constants.BID_UNIT_TYPE_SG.equals(type)) {
            map.put("PRO_HEADER", monitor.getSgUnitManager());
            map.put("PRO_HEADER_CARD", monitor.getSgUnitManagerCode());
            map.put("PRO_HEADER_PHONE", monitor.getSgUnitPhone());
        }
        map.put("CB_UNIT", unitName);

        ShareProContract contract = relateManager.getShareProContract(monitor.getBjbh(), unitCode);
        if (contract != null) {
            map.put("ZB_TYPE", contract.getCbTypeName());
            map.put("BID_DATE", contract.getAcceptTime());
            map.put("SIGN_DATE", "");
            map.put("EXPIRE_DATE", "");
            map.put("BEGIN_DATE", "");
            map.put("END_DATE", "");
            if (!Constants.BID_UNIT_TYPE_SG.equals(type)) {
                map.put("PRO_HEADER", contract.getProHeader());
                map.put("PRO_HEADER_CARD", contract.getProHeaderCard());
                map.put("PRO_HEADER_PHONE", contract.getProHeaderPhone());
            }

            if (Constants.BID_UNIT_TYPE_KC.equals(type)) {
                map.put("KC_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_SJ.equals(type)) {
                map.put("SJ_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_JL.equals(type)) {
                map.put("JL_FEE", contract.getContMoney());
            } else if (Constants.BID_UNIT_TYPE_SG.equals(type)) {
                map.put("SG_FEE", contract.getContMoney());
            }
        }
        if (unitName != null && !"".equals(unitName) && !"无".equals(unitName))
            kcList.add(map);
    }

    /**
     * 4、查看施工分包
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewSgfb(Model model, String bjbh) {
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(relateManager.getShareProContractList(bjbh)));
        return "common/msg";
    }

    /**
     * 5、查看单位工程
     *
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @param model      .
     * @return .
     */
    @RequestMapping
    public String viewUnit(Model model, String bjbh, String gdCode, String jdTaskCode) {
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(relateManager.getShareGdDwgcMapList(bjbh, gdCode, jdTaskCode)));
        return "common/msg";
    }


    /**
     * 7、查看监管情况
     *
     * @param model      .
     * @param bjbh       .
     * @param gdCode     .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String viewMonitor(Model model, String bjbh, String gdCode, String jdTaskCode) {

        Map<String, List> res = new HashMap<String, List>();
        //巡检记录
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        List<PollingRecord> recordList = relateManager.getPollingRecordList(bjbh, flowCode);
        String hqlProblem = "SELECT * from JD_RECORD where 1=1 order by JD_DATETIME";
        List recordList = jdRecordFirstService.findBySql(hqlProblem);
        Map<String, Object> map;
        for (Object o : recordList) {
            Object[] objects = (Object[]) o;
            map = new HashMap<String, Object>();
            map.put("pollingCode", objects[2]);
            map.put("pollingDate", objects[6]);
            map.put("jdManagerName", objects[5]);
//            map.put("className", record.getPollingClass() != null ? record.getPollingClass().getName() : "");

            //巡检问题的附件
            String doc = null;
            if (objects[7] != null) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(String.valueOf(objects[7])));
                Set<DocDocumentAttach> docDocumentAttachs = docDocument.getDocDocumentAttachs();
                for (DocDocumentAttach docDocumentAttach : docDocumentAttachs) {
                    doc += docDocumentAttach.getId() + ",";
                }
            }
            if (doc != null) {
                map.put("doc", doc.substring(0, doc.length() - 1));
            } else {
                map.put("doc", "");
            }
            //三类整改单据的附件
            String hql2 = " select s.jd_TYPE_CODE ,s.document_id as docID FROM JD_RECORD j inner join JD_STOP_ORDER s on s.id = j.id and s.JD_TYPE_CODE=j.JDTYPECODE and j.bjbh=s.bjbh where j.bjbh='" + objects[3] + "'";
            List questions = jdRecordFirstService.findBySql(hql2);
            String questionForm = "";
            String partstopForm = "";
            String stopForm = "";
            for (Object question : questions) {
//                PollingForm form = question.getForm();
//                String code = form.getFormType().getCode();
                String button = "";
                Object[] docs = (Object[]) question;
                if (docs[1] != null) {
                    DocDocument docDocument = docDocumentService.get((Long) docs[1]);
                    if (docDocument != null) {
                        Set<DocDocumentAttach> docDocumentAttachs = docDocument.getDocDocumentAttachs();
                        for (DocDocumentAttach docDocumentAttach : docDocumentAttachs) {
                            button += docDocumentAttach.getId() + ",";
                        }
                    }
                }
                if (Constants.POLLING_FORM_TYPE_QUESTION.equals(docs[0])) {
                    questionForm += button.substring(0, button.length() - 1);
                } else if (Constants.POLLING_FORM_TYPE_PARTSTOP.equals(docs[0])) {
                    partstopForm += button.substring(0, button.length() - 1);
                } else if (Constants.POLLING_FORM_TYPE_STOP.equals(docs[0])) {
                    stopForm += button.substring(0, button.length() - 1);
                }
            }
            map.put("questionForm", questionForm);
            map.put("partstopForm", partstopForm);
            map.put("stopForm", stopForm);

            list.add(map);
        }


        if (!"".equals(jdTaskCode) && jdTaskCode != null) {
            String hql = "from OrderFormDeploy where 1=1 and orderForm.jdTaskCode = '{0}' ";
            //外网项目用户和工地用户只能查看本项目范围的记录
            SysRegPerson regPerson = regPersonManager.getRegPerson();
            if (regPerson != null) {
                String currentBjbh = regPersonManager.getBjbh(regPerson);
                if (!StringHelper.isEmpty(currentBjbh)) {
                    SysUser sysUser = sysUserManager.getSysUser();
                    hql += " and ((orderForm.jdTaskCode is not null and orderForm.jdTaskCode in(select jdTaskCode from ExcelJdTasks where bjbh='" + currentBjbh + "')) or orderForm.createUser='" + sysUser.getLoginName() + "')";
//                    hql += " and ((orderForm.flowCode is not null and orderForm.flowCode in(select flowCode from ProFlowCode where bjbh='" + currentBjbh + "')) or orderForm.createUser='" + sysUser.getLoginName() + "')";
                } else {
                    hql += " and 1=2";
                }
            }
            hql += " order by  acceptDatetime asc";
            List<OrderFormDeploy> orderFormDeployList = orderFormDeployService.findByQuery(FormatUtils.format(hql, jdTaskCode));
            List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
            if (orderFormDeployList.size() > 0) {
                for (OrderFormDeploy orderFormDeploy : orderFormDeployList) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    String button = "";
                    if (orderFormDeploy.getOrderForm().getFormDoc() != null) {
                        Set<DocDocumentAttach> docDocumentAttachs = orderFormDeploy.getOrderForm().getFormDoc().getDocDocumentAttachs();
                        for (DocDocumentAttach docDocumentAttach : docDocumentAttachs) {
                            button += docDocumentAttach.getId() + ",";
                        }
                        m.put("doc", button);
                    }
                    SysCodeDetail sysCodeDetail = orderFormDeploy.getAcceptOpinion();
                    if (sysCodeDetail != null) {
                        if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_ARRANGE))
                            m.put("acceptOpinion", "安排监督");
                        else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_NOTARRANGE))
                            m.put("acceptOpinion", "不安排监督");
                        else if (sysCodeDetail.getCode().equals(Constants.ORDER_FORM_DEPLOY_OPINION_BACK))
                            m.put("acceptOpinion", "退回");
                        else
                            m.put("acceptOpinion", null);
                    } else
                        m.put("acceptOpinion", null);
                    m.put("acceptDatetime", orderFormDeploy.getAcceptDatetime());
                    m.put("jdTaskCode", jdTaskCode);
//                    m.put("flowCode", flowCode);
                    m.put("orderFormId", orderFormDeploy.getOrderForm().getId());
                    m.put("orderCode", orderFormDeploy.getOrderForm().getOrderCode());
                    m.put("orderDatetime", orderFormDeploy.getOrderForm().getOrderDatetime());
                    if (orderFormDeploy.getOrderForm().getOrderStatus() != null)
                        m.put("orderStatus", Constants.ORDER_FORM_STATUS_ACCEPT.equals(orderFormDeploy.getOrderForm().getOrderStatus().getCode()) ? "已受理" : "未受理");
                    m.put("projectName", orderFormDeploy.getOrderForm().getProjectName());
                    m.put("workGroup", orderFormDeploy.getWorkGroup() == null ? "" : orderFormDeploy.getWorkGroup().getName());
                    list1.add(m);
                }
            }
            res.put("orderFormList", list1);
        }
        Map<String, Object> mapp;
        List<PlanDetail> planDetails = planDetailService.findByQuery("from PlanDetail where bjbh='" + bjbh + "' and jdTaskCode ='" + jdTaskCode + "'");
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        for (PlanDetail planDetail : planDetails) {
            mapp = new HashMap<String, Object>();
            mapp.put("jdTaskCode", planDetail.getJdTaskCode());
            mapp.put("bjbh", planDetail.getBjbh());
//
            String hqlUser = "from PlanDetailUser  p  where p.planDetail.id= " + planDetail.getId();
            List<PlanDetailUser> planDetailUserList = planDetailUserService.findByQuery(hqlUser);
            if (null != planDetailUserList && planDetailUserList.size() > 0) {
                String managerName = "";
                for (int i = 0; i < planDetailUserList.size(); i++) {
                    if (i != (planDetailUserList.size() - 1)) {
                        managerName += planDetailUserList.get(i).getUser().getDisplayName() + ",";
                    } else {
                        managerName += planDetailUserList.get(i).getUser().getDisplayName();
                    }
                }
                mapp.put("managerName", managerName);
            }

            mapp.put("planEndTime", planDetail.getPlanEndTime());

            Map<String, Object> allProjectInfo = projectManager.getProjectInfo(bjbh);
            mapp.put("projectName", JspHelper.getString(allProjectInfo.get("projectName")));
            mapp.put("jdrwsbh", JspHelper.getString(allProjectInfo.get("jdrwsbh")));
            mapp.put("jdDatetime", JspHelper.getString(allProjectInfo.get("jdDatetime")));

            list2.add(mapp);
        }
        res.put("pollingRecordList", list);
        res.put("planDetailList", list2);
        model.addAttribute("msg", new JSONSerializer().deepSerialize(res));
        return "common/msg";
    }

    /**
     * 8、查看行政处罚
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewPunish(Model model, String bjbh) {
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(relateManager.getSharePunishCaseList(bjbh)));
        return "common/msg";
    }

    /**
     * 获取项目监督任务书状态
     *
     * @param bjbh .
     * @return .
     */
    private boolean getProjectJDTaskStatus(String bjbh) {
//        boolean hasJDTask=false;
//        String hql = "from ShareProDwgcMonitor where bjbh='{0}' and jdrwsbh is not null order by id desc";
//        List<ShareProDwgcMonitor> dwgcList = shareProDwgcMonitorService.findByQuery(FormatUtils.format(hql, bjbh));
//        if (dwgcList.size() > 0) {
//           return  true;
//        }
        String hql = "from ExcelJdTasks where bjbh=? and jdTaskCode is not null";
        return excelJdTasksService.findByQuery(hql, bjbh).size() > 0;
    }

}