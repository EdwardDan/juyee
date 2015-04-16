package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.CheckInfo;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckReason;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.hibernate.annotations.common.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * note:当日考勤记录表。
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckInfoDayController extends BaseCRUDActionController<CheckInfo> {
    private Logger logger = LoggerFactory.getLogger(CheckInfoDayController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private RelateManager relateManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private CheckInfoService checkInfoService;

    @Autowired
    private CheckReasonService checkReasonService;

    @Autowired
    private CheckManagerService checkManagerService;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    /**
     * tab显示页面
     *
     * @param model    .
     * @param gdCode   .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String init(Model model, String gdCode, String jdTaskCode) {
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);

        return "view/check/checkInfoDay/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String gdCode) {

        model.addAttribute("gdCode", gdCode);
        return "view/check/checkInfoDay/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String gdCode, String setCode) {

        try {
            SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
            Long detailId = sysCodeDetail.getId();
            Page pageModel = new Page(page, rows, true);
            List<Map> list = new ArrayList<Map>();
            if (StringHelper.isEmpty(setCode)) {

                String currentDate = DateTimeHelper.getCurrentDate();
                String hql = "select a from CheckInfo a,CheckManager b,CheckManagerPosition c where a.gdCode= '" + gdCode + "'" +
                        " and to_char(a.checkTime,'YYYY-MM-DD')='" + currentDate + "'" +
                        " and a.manager.id = b.id" +
                        " and c.manager.id =b.id" +
                        " and c.positionType.id <>" + detailId +
                        " order by a.id desc";
                //执行查询
                QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
                String query = queryTranslate.toString();
                query = query.replaceAll("managerName","a.managerName") ;
                pageModel = checkInfoService.findByPage(pageModel, query);
                list = GridJq.getGridValue(pageModel.getRows(), columns);
                for (Map bean : list) {
                    Object id = bean.get("id");
                    CheckInfo checkInfo = checkInfoService.get(JspHelper.getLong(id));
                    CheckManager checkManager = checkInfo.getManager();
                    bean.put("cardNo", checkManager.getPositionNames());
                    bean.put("createUser", "check");
                    bean.put("checkStatus", "已签到");

                }
                getNotCheck(filters, gdCode, list);

            } else {
                getNotCheck(filters, gdCode, list);
            }

            pageModel = new Page(page, rows, list);
            List<Map> rowList = pageModel.getRows();


            //输出显示
            String json = GridJq.toJSON(rowList, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    //得到未签到人员
    private void getNotCheck(String filters, String gdCode, List<Map> list) {
        String currentDate = DateTimeHelper.getCurrentDate();
        SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
        Long detailId = sysCodeDetail.getId();
        String hql = "select c from CheckManager c,CheckManagerPosition u where not  exists(  select t from CheckInfo t " +
                "where t.gdCode= '" + gdCode + "' " +
                "and t.manager.id=c.id " +
                "and to_char(t.checkTime,'YYYY-MM-DD')='" + currentDate + "'" +
                ") and c.id=u.manager.id and u.gdCode='" + gdCode + "'" +
//                "and t.manager.id=c.id " +
                " and u.positionType.id !=" + detailId +
                " and c.isDelete=false and u.isDelete=false" +
                " order by c.id";

        //执行查询
        QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
        String query = queryTranslate.toString();
        query = query.replaceAll("managerName", "c.name");

        List<CheckManager> checkManagerList = checkManagerService.findByQuery(query);

        for (CheckManager checkManager : checkManagerList) {
            Map<String, Object> map = new HashMap<String, Object>();

            List<CheckReason> checkReasons;
            hql = "from CheckReason where manager.id=" + checkManager.getId() + " and gdCode='" + gdCode + "' " +
                    "and to_char(checkDate,'YYYY-MM-DD')='" + currentDate + "'";
            checkReasons = checkReasonService.findByQuery(hql);
            if (checkReasons.size() > 0) {
                map.put("createUser", checkReasons.get(0).getId());
            } else {
                map.put("createUser", "noMsg");
            }

            map.put("managerName", checkManager.getName());
            map.put("id", checkManager.getId().toString());
            map.put("cardNo", checkManager.getPositionNames());
            map.put("checkStatus", "未签到");
            list.add(map);

        }
    }

    /**
     * 查看页面
     *
     * @param id       .
     * @param model    .
     * @param gdCode   .
     * @param jdTaskCode .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String gdCode, String jdTaskCode) {
        CheckReason checkReason = checkReasonService.get(id);
        model.addAttribute("bean", checkReason);

        return "view/check/checkInfoDay/view";

    }
}
