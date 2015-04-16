package com.justonetech.biz.controller.polling;

import com.justonetech.biz.domain.PollingGroupUser;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import flexjson.JSONSerializer;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.justonetech.biz.manager.PollingWorkGroupManager;


/**
 * author:
 * create date:
 * modify date:
 */
@Controller
public class PollingPersonMapController extends BaseCRUDActionController<PollingGroupUser> {
    private Logger logger = LoggerFactory.getLogger(PollingPersonMapController.class);

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String init(Model model) {

        return "view/polling/pollingPersonMap/init";

    }

    /**
     * 列表显示页面
     *
     * @param model .
     */
    @RequestMapping
    public String map(Model model, String showQuery) {
        String date = DateTimeHelper.getCurrentDate();
        model.addAttribute("time", date);
        if (StringHelper.isEmpty(showQuery)) {
            model.addAttribute("showQuery", true);
        } else {
            model.addAttribute("showQuery", false);
        }
        return "view/polling/pollingPersonMap/map";

    }

    /**
     * 项目组地图分布
     *
     * @param model   .
     * @param request .
     */
    @RequestMapping
    public void getMapData(Model model, HttpServletResponse response, HttpServletRequest request) {
        String time = request.getParameter("time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ("".equals(time) || time == null) {
            time = sdf.format(new Date());
        }
        String sql = "select s.user_id,s.longitude as x,s.latitude as y from pad_polling_tracks s, \n" +
                "(select p.user_id,max(p.create_time)as time from pad_polling_tracks p where to_char(p.create_time,'YYYY-MM-DD')='" + time + "' " +
//                "and p.user_id in (select t.user_id from polling_group_user t where t.is_charge=1) \n" +
                "group by p.user_id) x where x.user_id=s.user_id and x.time=s.create_time ";
        List<Map> list = simpleQueryManager.getMapList(sql);
        for (Map bean : list) {
            if (!StringHelper.isEmpty(bean.get("USER_ID").toString())) {
                SysUser sysUser = sysUserService.get(Long.parseLong(bean.get("USER_ID").toString()));
                bean.put("personName", sysUser.getDisplayName());
                bean.put("personid", sysUser.getId());
                String sql2 = " select j.attend_persons from jd_record  j left join sys_user s " +
                        " on s.person_id = j.jd_manager_id " +
                        " where s.id=" + sysUser.getId();
                List<Map> list2 = simpleQueryManager.getMapList(sql2);
                if (null != list2 && list2.size() > 0)
                    bean.put("attendPersons", list2.iterator().next().get("ATTEND_PERSONS"));
            }
        }
        JSONSerializer serializer = new JSONSerializer();
        sendJSON(response, serializer.serialize(list));
    }
}