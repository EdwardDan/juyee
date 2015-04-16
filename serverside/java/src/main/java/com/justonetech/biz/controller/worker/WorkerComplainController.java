package com.justonetech.biz.controller.worker;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.WorkerComplainService;
import com.justonetech.biz.domain.ShareProTobuild;
import com.justonetech.biz.domain.WorkerComplain;
import com.justonetech.biz.domain.bean.WorkerComplain.WorkerComplainInfo;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Map;


/**
 * note:务工人员投诉管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class WorkerComplainController extends BaseCRUDActionController<WorkerComplain> {
    private Logger logger = LoggerFactory.getLogger(WorkerComplainController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private WorkerComplainService workerComplainService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.WORKER_COMPLAIN_EDIT));

        return "view/worker/workerComplain/grid";
    }

    /**
     * 通过bjbh编号获取工程信息
     *
     * @param bjbh  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String getProjectInfo(String bjbh, Model model) {
        Map<String, Object> pam = projectManager.getProjectInfo(bjbh);
        ShareProTobuild shareProTobuild = (ShareProTobuild) pam.get("data");
        WorkerComplainInfo winfo = new WorkerComplainInfo();
        if (null != shareProTobuild) {
            winfo.setBjbh(shareProTobuild.getBjbh());
            winfo.setProjectName(shareProTobuild.getProjectName());
            winfo.setProjectAddress(shareProTobuild.getBuildAddress());
            winfo.setJsDept(shareProTobuild.getBuildUnitName());
            winfo.setJsDeptLxr(shareProTobuild.getBuildUnitLinkman());
            winfo.setJsDeptTel(shareProTobuild.getBuildUnitTel());
//        winfo.setZbDept(shareProTobuild);       TODO
        }
        JSONArray jsonArray = JSONArray.fromObject(winfo);
        String json = jsonArray.toString();
        model.addAttribute("msg", json);
        return "common/msg";
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
            String hql = "from WorkerComplain order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = workerComplainService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
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
        WorkerComplain workerComplain = new WorkerComplain();
        SysUser sysUser = sysUserManager.getSysUser();
        workerComplain.setDealJbr(sysUser.getDisplayName());
        workerComplain.setDealDate(new Date(System.currentTimeMillis()));
        workerComplain.setVisitDate(new Date(System.currentTimeMillis()));
        //如需增加其他默认值请在此添加
        model.addAttribute("bean", workerComplain);
        model.addAttribute("monyCode", Constants.WORKER_MONEY_TYPE);
        return "view/worker/workerComplain/input";
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
        WorkerComplain workerComplain = workerComplainService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", workerComplain);
        model.addAttribute("monyCode", Constants.WORKER_MONEY_TYPE);

        return "view/worker/workerComplain/input";
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
        WorkerComplain workerComplain = workerComplainService.get(id);
        model.addAttribute("monyCode", Constants.WORKER_MONEY_TYPE);
        model.addAttribute("bean", workerComplain);
        return "view/worker/workerComplain/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") WorkerComplain entity, HttpServletRequest request) throws Exception {
        try {
            WorkerComplain target;
            if (entity.getId() != null) {
                target = workerComplainService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "bjbh",
                        "projectName",
                        "projectAddress",
                        "jsDept",
                        "jsDeptLxr",
                        "jsDeptTel",
                        "zbDept",
                        "zbDeptLxr",
                        "zbDeptTel",
                        "fbDept",
                        "fbDeptLxr",
                        "fbDeptTel",
                        "manager",
                        "managerTel",
                        "visitDate",
                        "code",
                        "personName",
                        "personCount",
                        "personAddress",
                        "personIdcard",
                        "personTel",
                        "debtPerson",
                        "debtMoney",

                        "moneyType",
                        "debtCert",
                        "content",
                        "dealOpinion",
                        "dealDate",
                        "dealJbr"
                });

            } else {
                target = entity;
            }
            String debtPersons = request.getParameter("debtPersons");
            target.setDebtPersons(StringHelper.isEmpty(debtPersons)?0:Integer.parseInt(debtPersons));
            workerComplainService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        workerComplainService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}