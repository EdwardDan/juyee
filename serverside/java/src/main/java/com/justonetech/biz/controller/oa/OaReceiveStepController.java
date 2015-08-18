package com.justonetech.biz.controller.oa;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaReceiveOperationService;
import com.justonetech.biz.daoservice.OaReceiveStepService;
import com.justonetech.biz.domain.OaReceiveOperation;
import com.justonetech.biz.domain.OaReceiveStep;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * note:收文管理流转步骤
 * author: hgr
 * create date:
 * modify date:2015-08-18
 */
@Controller
public class OaReceiveStepController extends BaseCRUDActionController<OaReceiveStep> {
    private Logger logger = LoggerFactory.getLogger(OaReceiveStepController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private OaReceiveStepService oaReceiveStepService;

    @Autowired
    private OaReceiveOperationService oaReceiveOperationService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_RECEIVE_STEP_EDIT));

        return "view/oa/oaReceiveStep/grid";
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
            String hql = "from OaReceiveStep order by orderNo,id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaReceiveStepService.findByPage(pageModel, query);

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
        OaReceiveStep oaReceiveStep = new OaReceiveStep();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaReceiveStep);

        return "view/oa/oaReceiveStep/input";
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
        OaReceiveStep oaReceiveStep = oaReceiveStepService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaReceiveStep);

        return "view/oa/oaReceiveStep/input";
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
        OaReceiveStep oaReceiveStep = oaReceiveStepService.get(id);

        model.addAttribute("bean", oaReceiveStep);
        return "view/oa/oaReceiveStep/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaReceiveStep entity, HttpServletRequest request) throws Exception {
        try {
            OaReceiveStep target;
            if (entity.getId() != null) {
                target = oaReceiveStepService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "orderNo",
                        "code",
                        "name",
                        "isJoin"
                });

            } else {
                target = entity;
            }
            oaReceiveStepService.save(target);

            //保存流转操作，先删除原来的 再保存所有的
            Set<OaReceiveOperation> oaReceiveOperations = target.getOaReceiveOperations();
            List<OaReceiveOperation> operations = new ArrayList<OaReceiveOperation>(oaReceiveOperations);
            if (null != operations && operations.size() > 0) {
                oaReceiveOperationService.batchDelete(operations, operations.size());
            }
            String[] codes = request.getParameterValues("operationCode");
            String[] names = request.getParameterValues("operationName");
            String[] isValid = request.getParameterValues("operationIsValid");
            if (null != codes) {
                for (int i = 0; i < codes.length; i++) {
                    OaReceiveOperation operation = new OaReceiveOperation();
                    operation.setCode(codes[i]);
                    operation.setName(names[i]);
                    operation.setIsValid(Boolean.valueOf(isValid[i]));
                    operation.setStep(target);
                    oaReceiveOperationService.save(operation);
                }
            }
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
        OaReceiveStep step = oaReceiveStepService.get(id);
        //先删除流转操作
        Set<OaReceiveOperation> oaReceiveOperations = step.getOaReceiveOperations();
        List<OaReceiveOperation> operations = new ArrayList<OaReceiveOperation>(oaReceiveOperations);
        if (null != operations && operations.size() > 0) {
            oaReceiveOperationService.batchDelete(operations, operations.size());
        }
        oaReceiveStepService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}