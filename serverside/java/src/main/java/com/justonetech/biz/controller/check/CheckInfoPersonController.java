package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.domain.CheckManagerPosition;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
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
 * note:管理人员表。
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckInfoPersonController extends BaseCRUDActionController<CheckManager> {
    private Logger logger = LoggerFactory.getLogger(CheckInfoPersonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private CheckManagerService checkManagerService;

    @Autowired
    private ProjectWorkSiteService projectWorkSiteService;

    @Autowired
    private CheckManagerPositionService checkManagerPositionService;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private CheckFingerPrintService checkFingerPrintService;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SysCodeManager sysCodeManager;


    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String gdCode, String jdTaskCode) {
        //判断是否有编辑权限
        model.addAttribute("gdCode", gdCode);
        model.addAttribute("jdTaskCode", jdTaskCode);
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CHECK_MANAGER_EDIT));

        return "view/check/checkInfoPerson/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String gdCode, String jdTaskCode) {
        try {
            SysCodeDetail sysCodeDetail = sysCodeManager.getCodeDetailByCode(Constants.CHECK_MANAGER_POSITION, Constants.CHECK_MANAGER_POSITION_SBGUL);
            Long detailId = sysCodeDetail.getId();
            Page pageModel = new Page(page, rows, true);
            //针对一个工地编号对应多个监督任务书编号的情况，查询时不再过滤监督任务书编号
//            String hql = "select distinct m from CheckManager m, CheckManagerPosition n where m.id=n.manager.id and m.isDelete=false and n.gdCode='{0}' and n.jdTaskCode='{1}' order by m.id desc";
            String hql = "select distinct m from CheckManager m, CheckManagerPosition n where m.id=n.manager.id " +
                    " and m.isDelete=false and n.gdCode='{0}'" +
                    " and n.positionType.id !={1}" +
                    " order by m.id desc";
            hql = FormatUtils.format(hql, gdCode,detailId+"");

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
//            query  =query.replaceAll("cardNo","m.cardNo");
            pageModel = checkManagerService.findByPage(pageModel, query);

            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                CheckManager checkManager = checkManagerService.get(JspHelper.getLong(id));
                bean.put("m.cardNo",checkManager.getCardNo());
                bean.put("createUser", checkManager.getPositionNames());

            }
            //输出显示
            String json = GridJq.toJSON(list, pageModel);

            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String gdCode, String jdTaskCode) {
        CheckManager checkManager = checkManagerService.get(id);

        Map<String, Object> map = new HashMap<String, Object>();
        List<CheckManagerPosition> checkManagerPositionList = getPersonPositionList(checkManager);

        String certificateCode = "";
        String certificateName = "";
        for (CheckManagerPosition checkManagerPosition : checkManagerPositionList) {
            if (com.justonetech.core.utils.StringHelper.isNotEmpty(checkManagerPosition.getCertificateCode())) {
                certificateCode += checkManagerPosition.getCertificateCode() + "，";
            }

            if (com.justonetech.core.utils.StringHelper.isNotEmpty(checkManagerPosition.getCertificateName())) {
                certificateName += checkManagerPosition.getCertificateName() + "，";
            }
        }

        if (com.justonetech.core.utils.StringHelper.isNotEmpty(certificateCode)) {
            certificateCode = certificateCode.substring(0, certificateCode.length() - 1);
            map.put("certificateCode", certificateCode);
        }
        if (com.justonetech.core.utils.StringHelper.isNotEmpty(certificateName)) {
            certificateName = certificateName.substring(0, certificateName.length() - 1);
            map.put("certificateName", certificateName);
        }


//        if (com.justonetech.core.utils.StringHelper.isEmpty(checkManager.getPhotoFile())) {
////            model.addAttribute("photoMsg", "无此人照片");../skin_new/images/no_picture.gif
//            checkManager.setPhotoFile("/skin/images/no_picture.gif");
//        }
        map.put("checkManager", checkManager);

        map.put("positionName", checkManager.getPositionNames());

        model.addAttribute("bean", map);
        return "view/check/checkInfoPerson/view";
    }

    /**
     * 根据考勤人员获得人员岗位表中对应的信息。
     *
     * @param checkManager .
     * @return .
     */
    private List<CheckManagerPosition> getPersonPositionList(CheckManager checkManager) {
        List<CheckManagerPosition> checkManagerPositionList = new ArrayList<CheckManagerPosition>();

        if (checkManager != null && checkManager.getId() != null) {
            String hql = "from CheckManagerPosition where manager.id=" + checkManager.getId() + " order by id desc";
            checkManagerPositionList = checkManagerPositionService.findByQuery(hql);
        }
        return checkManagerPositionList;
    }

//    /**
//     * 根据考勤人员获得人员岗位表中对应的岗位名称。
//     *
//     * @param checkManager .
//     * @return .
//     */
//    private String getPositionNames(CheckManager checkManager) {
//        String pstName = "";
//        if (checkManager != null && checkManager.getId() != null) {
//            String hql = "from CheckManagerPosition where manager.id=" + checkManager.getId() + " order by id desc";
//            List<CheckManagerPosition> checkManagerPositionList = checkManagerPositionService.findByQuery(hql);
//            for(CheckManagerPosition checkManagerPosition : checkManagerPositionList){
//                pstName += checkManagerPosition.getPositionName() + "，";
//            }
//            if(StringHelper.isNotEmpty(pstName)){
//                pstName = pstName.substring(0, pstName.length() - 1);
//            }
//
//        }
//        return pstName;
//    }
}
