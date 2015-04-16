package com.justonetech.biz.controller.net;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.NetApplyService;
import com.justonetech.biz.daoservice.NetContractService;
import com.justonetech.biz.domain.NetApply;
import com.justonetech.biz.domain.NetContract;
import com.justonetech.biz.manager.NetAcceptManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.NetMatterDefine;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.manager.SysCodeManager;
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
import java.util.List;


/**
 * note:项目合同备案
 * author: hgr
 * create date:
 * modify date:2014-06-24
 */
@Controller
public class NetContractController extends BaseCRUDActionController<NetContract> {
    private Logger logger = LoggerFactory.getLogger(NetContractController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private NetAcceptManager netAcceptManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private NetContractService netContractService;

    @Autowired
    private NetApplyService netApplyService;

    /**
     * 入口页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
        model.addAttribute("list", sysCodeManager.getCodeListByCode(Constants.NET_CONTRACT_TYPE));

        return "view/net/netContract/init";
    }

    /**
     * 列表显示页面
     *
     * @param model    .
     * @param typeCode .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String typeCode) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.NET_CONTRACT_EDIT));

        model.addAttribute("type", sysCodeManager.getCodeDetailByCode(Constants.NET_CONTRACT_TYPE, typeCode));
        model.addAttribute("className", "NetContract");
        model.addAttribute("matterCode", NetMatterDefine.MATTER_CONTRACT.getCode());

        return "view/net/netContract/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     * @param session  .
     * @param typeCode .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session, String typeCode, String setCode) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from NetContract where 1=1 ";
            //根据合同类型和受理状态过滤数据
            if (null != typeCode) {
                hql += "and contractType=" + typeCode + " ";
                if (!StringHelper.isEmpty(setCode)) {
                    hql += " and acceptStatus.name='" + setCode + "' ";
                }
            }
            hql += "order by id desc";
            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = netContractService.findByPage(pageModel, query);
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
     * @param model    .
     * @param typeCode .
     * @return .
     */
    @RequestMapping
    public String add(Model model, String typeCode) {
        NetContract netContract = new NetContract();

        //合同类型
        model.addAttribute("type", typeCode);

        model.addAttribute("bean", netContract);

        return "view/net/netContract/input";
    }

    /**
     * 修改显示页面
     *
     * @param id       .
     * @param model    .
     * @param typeCode .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id, String typeCode) {
        NetContract netContract = netContractService.get(id);

        model.addAttribute("type", typeCode);
        model.addAttribute("bean", netContract);

        return "view/net/netContract/input";
    }


    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param typeCode .
     * @param request  .
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") NetContract entity, String typeCode, HttpServletRequest request) throws Exception {
        String netCode = entity.getNetCode();
        String bjbh = request.getParameter("bjbh");
        String bdh = entity.getBdh();
//        Date date = netAcceptManager.getDateFromCode(netCode);
        NetApply net = netAcceptManager.getProjectUnLimit(bjbh);
        String hql = "from NetContract where apply.bjbh=? and bdh=?";
        List<NetContract> contracts = netContractService.findByQuery(hql, bjbh, bdh);
//        if (null == date) {
//            sendFailureJSON(response, "网上受理编号不正确，请重新输入！");
//        } else if (null == net) {
        if(null == net){
            sendFailureJSON(response, "未找到指定的项目工程，请重新输入报建编号！");
        } else if (null != contracts && contracts.size() > 0) {
            sendFailureJSON(response, "该标段号已录入!");
        } else {
            try {
                NetContract target;
                if (entity.getId() != null) {
                    target = netContractService.get(entity.getId());
                    ReflectionUtils.copyBean(entity, target, new String[]{
                            "netCode",
                            "bdh"
                    });

                } else {
                    target = entity;
                }
                //保存网上提交日期
//                target.setNetDate(date);
                //保存合同类型
                target.setContractType(sysCodeManager.getCodeDetailByCode(Constants.NET_CONTRACT_TYPE, typeCode));
                target.setContractTypeDesc(sysCodeManager.getCodeDetailByCode(Constants.NET_CONTRACT_TYPE, typeCode).getName());
                //保存项目信息
                String sql = "from NetApply where bjbh='" + bjbh + "'";
                List<NetApply> list = netApplyService.findByQuery(sql);
                if (null != list && list.size() > 0) {
                    NetApply netApply = list.iterator().next();
                    target.setApply(netApply);
                }
                target.setAcceptStatus(netAcceptManager.getFirstStatus(NetMatterDefine.MATTER_CONTRACT.getCode()));

                netContractService.save(target);

            } catch (Exception e) {
                log.error("error", e);
                super.processException(response, e);
                return;
            }
            sendSuccessJSON(response, "保存成功");
        }
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
        netContractService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

}