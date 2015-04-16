package com.justonetech.biz.controller.check;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.CheckFingerPrintService;
import com.justonetech.biz.daoservice.CheckManagerService;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.CheckFingerPrint;
import com.justonetech.biz.domain.CheckManager;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:指纹信息表
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class CheckFingerPrintController extends BaseCRUDActionController<CheckFingerPrint> {
    private Logger logger = LoggerFactory.getLogger(CheckFingerPrintController.class);

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
    private CheckManagerService checkManagerService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private CheckFingerPrintService checkFingerPrintService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.CHECK_MANAGER_EDIT));

        return "view/check/checkFingerPrint/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from CheckManager order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = checkManagerService.findByPage(pageModel, queryTranslate.toString());
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            for (Map bean : list) {
                Object id = bean.get("id");
                List<CheckFingerPrint> checkFingerPrints = checkFingerPrintService.findByQuery("from CheckFingerPrint where isDelete=0 and manager.id=" + id);
                if (checkFingerPrints.size() > 0) {
                    bean.put("num", checkFingerPrints.size());
                } else {
                    bean.put("num", 0);
                }

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
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        CheckFingerPrint checkFingerPrint = new CheckFingerPrint();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", checkFingerPrint);

        return "view/check/checkFingerPrint/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        CheckManager checkManager = checkManagerService.get(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("man", checkManager);
        boolean tn = true;
        String initRegisteredFingers = "";
        List<CheckFingerPrint> checkFingerPrints = checkFingerPrintService.findByQuery("from CheckFingerPrint where isDelete=0 and manager.id=" + id + " order by fingerId");
        if (checkFingerPrints.size() > 0) {
            map.put("num", checkFingerPrints.size());
            for (int i = 0; i < 10; i++) {
                for (CheckFingerPrint checkFingerPrint : checkFingerPrints) {
                    if (checkFingerPrint.getFingerid() == i) {
                        initRegisteredFingers += "1";
                        tn = false;
                        break;
                    }
                    tn = true;
                }
                if (tn)
                    initRegisteredFingers += "0";
            }
            map.put("initRegisteredFingers", initRegisteredFingers);
        } else {
            map.put("num", "0");
            map.put("initRegisteredFingers", "0000000000");
        }
        //处理其他业务逻辑
        model.addAttribute("bean", map);

        return "view/check/checkFingerPrint/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        CheckManager checkManager = checkManagerService.get(id);


        model.addAttribute("bean", checkManager);
        return "view/check/checkFingerPrint/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, HttpServletRequest request,String mid,String text) throws Exception {
        try {
            CheckManager checkManager = checkManagerService.get(JspHelper.getLong(mid));
            text=request.getParameter("templates");
            List<CheckFingerPrint> checkFingerPrints = checkFingerPrintService.findByQuery("from CheckFingerPrint where isDelete=0 and manager.id=" + mid + " order by fingerId");
            text = text.substring(0, text.length() - 1);
            String[] temps = text.split(",");
            for (String s : temps) {
                boolean bool = true;
                String template = null;
                String fingerId = null;
                if (s.length() > 3) {
                    template = s.substring(2, s.length());
                    fingerId = s.substring(0, 1);
                }else if (s.length() > 2)  {
                    fingerId = s.substring(0, 1);
                }
                for (CheckFingerPrint print : checkFingerPrints) {
                    if (print.getFingerid().toString().equals(fingerId)) {
                        if (template==null) {
                            print.setIsDelete(true);
                            print.setDeleteTime(new Timestamp(System.currentTimeMillis()));
                            BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                            print.setDeleteUser(loginUser.getLoginName());
                            checkFingerPrintService.save(print);
                            bool = false;
                            break;
                        } else {
                            print.setTemplate(template);
                            checkFingerPrintService.save(print);
                            bool = false;
                            break;
                        }
                    } else {
                        bool = true;
                    }
                }
                if (bool && template != null) {
                    CheckFingerPrint checkFingerPrint = new CheckFingerPrint();
                    checkFingerPrint.setBioType(0l);
                    checkFingerPrint.setFingerid(JspHelper.getLong(fingerId));
                    checkFingerPrint.setTemplate(template);
                    checkFingerPrint.setIsDelete(false);
                    checkFingerPrint.setManager(checkManager);
                    checkFingerPrint.setFingerVersion("10");
                    checkFingerPrintService.save(checkFingerPrint);
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }

        sendSuccessJSON(response, "保存成功");
    }


    public void checkFinger(HttpServletResponse response, Long id) throws Exception {
        checkFingerPrintService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}