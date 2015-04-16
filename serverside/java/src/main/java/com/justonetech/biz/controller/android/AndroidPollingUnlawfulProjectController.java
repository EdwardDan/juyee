package com.justonetech.biz.controller.android;

import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.daoservice.PollingUnlawfulProjectService;
import com.justonetech.biz.daoservice.PollingWorkGroupService;
import com.justonetech.biz.domain.PollingUnlawfulProject;
import com.justonetech.biz.domain.PollingWorkGroup;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import flexjson.JSONSerializer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 六无工地信息上报与查询
 * User: WangBinbin
 * Date: 12-10-8
 */
@Controller
public class AndroidPollingUnlawfulProjectController extends BaseCRUDActionController {

    @Autowired
    private PollingUnlawfulProjectService pollingUnlawfulProjectService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private PollingWorkGroupService pollingWorkGroupService;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    /**
     * 上传六无工地信息至数据库
     * @param response
     * @param json
     * @param padTime
     */
    @RequestMapping
    public void updateRecord(HttpServletResponse response, String json, String padTime) {
        try {
            JSONArray jsonArray = JSONArray.fromObject(json);
            Map<Long, String> map = new HashMap<Long, String>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String projectName = jsonObject.getString("projectName");
                String buildAddress = jsonObject.getString("buildAddress");
                String buildUnit = jsonObject.getString("buildUnit");
                String buildUnitAddress = jsonObject.getString("buildUnitAddress");
                String buildLinkMan = jsonObject.getString("buildLinkMan");
                String buildLinkPhone = jsonObject.getString("buildLinkPhone");
                String sgUnit = jsonObject.getString("sgUnit");
                String sgUnitLinkMan = jsonObject.getString("sgUnitLinkMan");
                String sgUnitLinkPhone = jsonObject.getString("sgUnitLinkPhone");
                String currentLongitude = jsonObject.getString("currentLongitude");
                String currentLatitude = jsonObject.getString("currentLatitude");
//                Long pollingGroup = jsonObject.getLong("pollingGroup");
                String mainPerson = jsonObject.getString("mainPerson");
                String groupPerson = jsonObject.getString("groupPerson");
                Boolean isLx = jsonObject.getBoolean("isLx");
                Boolean isTdqz = jsonObject.getBoolean("isTdqz");
                Boolean isGhxk = jsonObject.getBoolean("isGhxk");
                Boolean isSgxk = jsonObject.getBoolean("isSgxk");
                String questionDesc = jsonObject.getString("questionDesc");
                Long status = jsonObject.getLong("status");
                String dealResult = jsonObject.getString("dealResult");
//                String dealUser = jsonObject.getString("dealUser");
//                Long dealTime = jsonObject.getLong("dealTime");
                Long createTime = jsonObject.getLong("createTime");
                String createUser = jsonObject.getString("createUser");
                String padImei = jsonObject.getString("padImei");
                String photoPaths = jsonObject.getString("photoPaths");
                String hql1 ="from PollingUnlawfulProject where projectName ='{0}'  and padImei='{1}' and groupPerson='{2}'";
                hql1 = FormatUtils.format(hql1,projectName,padImei,groupPerson);
                List<PollingUnlawfulProject>  pollingUnlawfulProjects = pollingUnlawfulProjectService.findByQuery(hql1);
                if(pollingUnlawfulProjects.size()>0){
                    sendFailureJSON(response, "重复的上传数据");
                    return;
                }
                SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.POLLING_UNLAWFUL_PROJECT_STATUS, Constants.POLLING_UNLAWFUL_PROJECT_STATUS_UNPROCESSED);
//                PollingWorkGroup pollingWorkGroup = pollingWorkGroupService.get(pollingGroup);
                PollingUnlawfulProject pollingUnlawfulProject = new PollingUnlawfulProject();
                pollingUnlawfulProject.setBuildAddress(buildAddress);
                pollingUnlawfulProject.setBuildLinkman(buildLinkMan);
                pollingUnlawfulProject.setBuildLinkPhone(buildLinkPhone);
                pollingUnlawfulProject.setBuildUnit(buildUnit);
                pollingUnlawfulProject.setBuildUnitAddress(buildUnitAddress);
                pollingUnlawfulProject.setCurrentLongitude(Double.valueOf(currentLongitude));
                pollingUnlawfulProject.setCurrentLatitude(Double.valueOf(currentLatitude));
                pollingUnlawfulProject.setDealResult(dealResult);
                pollingUnlawfulProject.setGroupPerson(groupPerson);
                pollingUnlawfulProject.setProjectName(projectName);
                pollingUnlawfulProject.setSgUnit(sgUnit);
                pollingUnlawfulProject.setSgUnitLinkman(sgUnitLinkMan);
                pollingUnlawfulProject.setSgUnitLinkPhone(sgUnitLinkPhone);
                pollingUnlawfulProject.setMainPerson(mainPerson);
//                pollingUnlawfulProject.setDealUser(dealUser);
                pollingUnlawfulProject.setQuestionDesc(questionDesc);
                pollingUnlawfulProject.setCreateUser(createUser);
                pollingUnlawfulProject.setPadImei(padImei);
                pollingUnlawfulProject.setIsLx(isLx);
                pollingUnlawfulProject.setIsGhxk(isGhxk);
                pollingUnlawfulProject.setIsSgxk(isSgxk);
                pollingUnlawfulProject.setIsTdqz(isTdqz);
                pollingUnlawfulProject.setPhotoPaths(photoPaths);
//                Timestamp dealTimeStamp = new Timestamp(dealTime);
//                pollingUnlawfulProject.setDealTime(dealTimeStamp);
                Timestamp createTimeStamp = new Timestamp(createTime);
                pollingUnlawfulProject.setCreateTime(createTimeStamp);
//                pollingUnlawfulProject.setPollingGroup(pollingWorkGroup);
                pollingUnlawfulProject.setStatus(sysCodeDetail);
                pollingUnlawfulProjectService.save(pollingUnlawfulProject);
                String hql = "from PollingUnlawfulProject order by id desc";
                List<PollingUnlawfulProject> list = pollingUnlawfulProjectService.findByQuery(hql);
                PollingUnlawfulProject pollingUnlawfulProject1 = list.get(0);
                if (pollingUnlawfulProject1.getPhotoPaths() != null)
                    map.put(pollingUnlawfulProject1.getId(), pollingUnlawfulProject1.getPhotoPaths());
            }
            sendSuccessJSON(response, new JSONSerializer().serialize(map));
        } catch (Exception e) {
            sendFailureJSON(response, e.getMessage());
        }

    }

    /**
     * 获取六无工地表数据
     * @param model
     * @param name
     * @param count
     * @param start
     * @return
     */
    @RequestMapping
    public String getProjectList(Model model, String name, Long count, Long start, String longitude, String latitude) {
        List<PollingUnlawfulProject> pollingUnlawfulProjects = new ArrayList<PollingUnlawfulProject>();
        if (null != name && (!"".equals(name)) && (!"null".equalsIgnoreCase(name))) {
            String hql = "from PollingUnlawfulProject where projectName like  '%{0}%' order by id ";
            hql = FormatUtils.format(hql, name);
            pollingUnlawfulProjects = pollingUnlawfulProjectService.findByQuery(hql);
        } else {
            List<PollingUnlawfulProject> projects;
            String hql1 = "from PollingUnlawfulProject where currentLongitude is not null order by id";
            projects = pollingUnlawfulProjectService.findByQuery(hql1);
            for (PollingUnlawfulProject project : projects) {
                Double aDouble = projectManager.distance(project.getCurrentLongitude(),project.getCurrentLatitude(), JspHelper.getDouble(longitude), JspHelper.getDouble(latitude) );
                System.out.println(project.getProjectName()+" = " + aDouble);
                if (aDouble < projectManager.DISTANCE_NUM) {
                    project.setDistance(aDouble);
                    pollingUnlawfulProjects.add(project);
                }
            }
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (PollingUnlawfulProject pollingUnlawfulProject : pollingUnlawfulProjects) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("unlawfulProjectId", pollingUnlawfulProject.getId());
            map.put("projectName", pollingUnlawfulProject.getProjectName());
            map.put("buildAddress", pollingUnlawfulProject.getBuildAddress());
            map.put("buildUnit", pollingUnlawfulProject.getBuildUnit());
            map.put("buildUnitAddress", pollingUnlawfulProject.getBuildUnitAddress());
            map.put("buildLinkMan", pollingUnlawfulProject.getBuildLinkman());
            map.put("buildLinkPhone", pollingUnlawfulProject.getBuildLinkPhone());
            map.put("sgUnit", pollingUnlawfulProject.getSgUnit());
            map.put("sgUnitLinkMan", pollingUnlawfulProject.getSgUnitLinkman());
            map.put("sgUnitLinkPhone", pollingUnlawfulProject.getSgUnitLinkPhone());
            map.put("currentLongitude", pollingUnlawfulProject.getCurrentLongitude());
            map.put("currentLatitude", pollingUnlawfulProject.getCurrentLatitude());
            if (pollingUnlawfulProject.getPollingGroup() != null) {
                map.put("pollingGroup", pollingUnlawfulProject.getPollingGroup().getId());
            } else {
                map.put("pollingGroup", null);
            }
            map.put("mainPerson", pollingUnlawfulProject.getMainPerson());
            map.put("groupPerson", pollingUnlawfulProject.getGroupPerson());
            map.put("isLx", pollingUnlawfulProject.getIsLx());
            map.put("isTdqz", pollingUnlawfulProject.getIsTdqz());
            map.put("isGhxk", pollingUnlawfulProject.getIsGhxk());
            map.put("isSgxk", pollingUnlawfulProject.getIsSgxk());
            map.put("questionDesc", pollingUnlawfulProject.getQuestionDesc());
            if (pollingUnlawfulProject.getStatus() != null) {
                map.put("status", pollingUnlawfulProject.getStatus().getId());
            } else {
                map.put("status", null);
            }
            map.put("dealResult", pollingUnlawfulProject.getDealResult());
            map.put("dealUser", pollingUnlawfulProject.getDealUser());
            map.put("dealTime", pollingUnlawfulProject.getDealTime());
            map.put("createTime", pollingUnlawfulProject.getCreateTime());
            map.put("createUser", pollingUnlawfulProject.getCreateUser());
            map.put("padImei", pollingUnlawfulProject.getPadImei());
            map.put("distance", pollingUnlawfulProject.getDistance());
            mapList.add(map);
        }
        model.addAttribute("msg", new JSONSerializer().exclude("*.class").serialize(mapList));
        return "common/msg";
    }
}
