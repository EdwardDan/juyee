package com.justonetech.system.controller;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.*;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.domain.ShareGdInfo;
import com.justonetech.biz.manager.*;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.PersonRegOpinion;
import com.justonetech.biz.utils.enums.PersonRegSource;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.utils.Md5Utils;
import com.justonetech.system.utils.PrivilegeCode;
import org.apache.commons.lang.StringUtils;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * note:注册人员
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SysRegPersonController extends BaseCRUDActionController<SysRegPerson> {
    private Logger logger = LoggerFactory.getLogger(SysRegPersonController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private ConfigManager configManager;


    @Autowired
    private SysRegPersonService sysRegPersonService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RegPersonManager regPersonManager;

    @Autowired
    private MsgMessageManager msgMessageManager;

    @Autowired
    private SiteManager siteManager;

    @Autowired
    private OaTaskManager oaTaskManager;

    /**
     * tab显示页面
     *
     * @param model 。
     */
    @RequestMapping
    public String init(Model model) {

        List<SysCodeDetail> list = sysCodeManager.getCodeListByCode(Constants.SYS_REGPERSON_TYPE);
        model.addAttribute("list", list);

        model.addAttribute("SYS_REGPERSON_TYPE_Gd", Constants.SYS_REGPERSON_TYPE_Gd); //临时保留

        return "view/system/sysRegPerson/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model, String regType) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_REGPERSON_EDIT));
        siteManager.setRegType(model, regType);

        return "view/system/sysRegPerson/grid";
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
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, String regType, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            //增加自定义查询条件
            String hql = "from SysRegPerson where regType.code='{0}' order by id desc ";
            hql = FormatUtils.format(hql, regType);

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = sysRegPersonService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            List<SysRegPerson> sysRegPersons = pageModel.getRows();
            List<Map> list = GridJq.getGridValue(pageModel.getRows(), columns);
            int i = 0;
            for (Map bean : list) {
                Set<SysUser> sysusers = sysRegPersons.get(i).getSysUsers();
                StringBuffer stringBuffer = new StringBuffer("");
                for (SysUser sysuser : sysusers) {
                    stringBuffer.append(sysuser.getLoginName());
                    stringBuffer.append(",");
                }

                if (sysusers.size() != 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    bean.put("sysUsers", stringBuffer.toString());
                } else {
                    bean.put("sysUsers", "");
                }
                i++;
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
    public String add(Model model, String regType) {
        SysRegPerson sysRegPerson = new SysRegPerson();
        siteManager.setRegType(model, regType);

        //如需增加其他默认值请在此添加
        sysRegPerson.setRegType(sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, regType));
        model.addAttribute("bean", sysRegPerson);

        return "view/system/sysRegPerson/input";
    }

    /**
     * 修改显示页面
     *
     * @param model .
     * @param id    .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        SysRegPerson sysRegPerson = sysRegPersonService.get(id);
        model.addAttribute("bean", sysRegPerson);

        siteManager.setRegType(model, sysRegPerson.getRegType().getCode());

        model.addAttribute("option", PersonRegOpinion.getOptions(String.valueOf(sysRegPerson.getAcceptOpinion())));

        return "view/system/sysRegPerson/input";
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
        SysRegPerson sysRegPerson = sysRegPersonService.get(id);
        model.addAttribute("bean", sysRegPerson);

        Set<SysUser> sysusers = sysRegPerson.getSysUsers();
        StringBuilder sb = new StringBuilder("");
        try {
            for (SysUser sysuser : sysusers) {
                String password = sysuser.getPassword();
                if (!StringHelper.isEmpty(password) && password.length()>20) {
                    password = CryptUtil.decrypt(password);
                }
                sb.append(sysuser.getLoginName()).append("/").append(password);
                sb.append(",");
            }
        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (sysusers.size() != 0) {
            sb.deleteCharAt(sb.length() - 1);
            model.addAttribute("sysUsers", sb.toString());
        } else {
            model.addAttribute("sysUsers", "");
        }
        model.addAttribute("acceptOption", regPersonManager.getAcceptOption(sysRegPerson));

        return "view/system/sysRegPerson/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SysRegPerson entity, HttpServletRequest request) throws Exception {
        try {
            SysCodeDetail regType = sysCodeManager.getCodeListById(JspHelper.getLong(request.getParameter("regType")));

            SysRegPerson target;
            if (request.getParameter("acceptOpinion") == null && entity.getId() != null) {
                target = entity;
//                Long idd = JspHelper.getLong(request.getParameter("regType"));
                target.setRegType(regType);
                target.setAcceptOpinion(PersonRegOpinion.OPINION_PASS.getCode());
                target.setAcceptDatetime(DateTimeHelper.getTimestamp());

            } else if (entity.getId() != null) {
                target = sysRegPersonService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "personName",
                        "mobile",
                        "gdCode",
                        "bjbh",
                        "projectCard",
//                        "projectName",
                        "unitCode",
                        "unitIdentifyCode",
//                        "unitName",
                        "regResource",
                        "acceptOpinion",
                        "acceptDesc"
                });
                if (Integer.parseInt(request.getParameter("acceptOpinion")) == 1) {
                    SysUser user = new SysUser();
//                    if (target.getUnitName() != null) {
//                        user.setLoginName(target.getUnitCode());
//                    } else if (target.getGdCode() != null) {
//                        user.setLoginName(target.getGdCode());
//                    } else {
//                        user.setLoginName(target.getBjbh());
//                    }
                    user.setLoginName(getCodeByRegType(target, regType));
                    user.setDisplayName(target.getPersonName());
                    user.setStatus(String.valueOf(PersonRegSource.RESOURCE_WEBSITE.getCode()));
                    user.setCreateTime(DateTimeHelper.getTimestamp());
                    BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                    user.setCreateUser(loginUser.getLoginName());
//                    Long idd = JspHelper.getLong(request.getParameter("regType"));
                    user.setUserType(regType);
                    int pas = (int) (Math.random() * 999999);
                    if (pas < 100000) {
                        pas += 100000;
                    }
                    user.setPassword(CryptUtil.encrypt(String.valueOf(pas)));
                    user.setMd5Pass(Md5Utils.md5(String.valueOf(pas)));
                    user.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                    String message = "您所注册的用户已通过审核,您的用户名为:" + user.getLoginName() + ",密码为:" + pas + ",请牢记!联系电话：021-57780775";
                    user.setRegPerson(target);
                    sysUserService.save(user);

                    if (oaTaskManager.getTask(oaTaskManager.getTaskType(SysRegPerson.class.getSimpleName()), target.getId()) != null) {
                        oaTaskManager.removeTask(SysRegPerson.class.getSimpleName(), target.getId());
                    }
                    msgMessageManager.sendSmsByRegPerson(message + " " + configManager.getSiteName(), sysUserManager.getSysUser(loginUser.getLoginName()), target);
                } else if (Integer.parseInt(request.getParameter("acceptOpinion")) == PersonRegOpinion.OPINION_NOTPASS.getCode()) {
                    String message = "贵公司申请的帐号:" + getCodeByRegType(target, regType) + "，未通过受理。未通过原因：" + target.getAcceptDesc() + "  联系电话：021-57780775";
                    BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                    if (oaTaskManager.getTask(oaTaskManager.getTaskType(SysRegPerson.class.getSimpleName()), target.getId()) != null) {
                        oaTaskManager.removeTask(SysRegPerson.class.getSimpleName(), target.getId());
                    }
                    msgMessageManager.sendSmsByRegPerson(message + " " + configManager.getSiteName(), sysUserManager.getSysUser(loginUser.getLoginName()), target);
                }

            } else {
                target = entity;
                target.setRegResource(Integer.parseInt(request.getParameter("regResource")));
//                Long idd = JspHelper.getLong(request.getParameter("regType"));

                target.setRegType(regType);
                target.setAcceptOpinion(PersonRegOpinion.OPINION_NOTACCEPT.getCode());
                target.setAcceptDatetime(DateTimeHelper.getTimestamp());
            }

            if (target.getBjbh() == null && target.getGdCode() != null) {
                target.setBjbh(projectManager.getGDInfo(target.getGdCode()).getBjbh());
            }
            if(target.getAcceptUser()==null){
                target.setAcceptUser(sysUserManager.getSysUser());
            }
            sysRegPersonService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    private String getCodeByRegType(SysRegPerson target, SysCodeDetail regType) {
        String code = null;
        if (regType != null) {
            String regTypeCode = regType.getCode();
            if (regTypeCode.equals(Constants.SYS_REGPERSON_TYPE_Gd)) {
                code = target.getGdCode();
            } else if (regTypeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS)) {
                code = target.getBjbh();
            } else if (regTypeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG) || regTypeCode.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL)) {
                String sql = " from SysRegPerson where unitCode =?";
                List<SysRegPerson> list = sysRegPersonService.findByQuery(sql, target.getUnitCode());
                Integer maxNo = 0;
                if (null != list && list.size() > 0) {
                    for (SysRegPerson sp : list) {
                        Set<SysUser> set = sp.getSysUsers();
                        if (null != set) {
                            for (SysUser user : set) {
                                if (user.getLoginName().indexOf("_") > 0) {
                                    Integer no = Integer.parseInt(user.getLoginName().split("_")[1]);
                                    if (no > maxNo) {
                                        maxNo = no;
                                    }
                                }
                            }
                        }
                    }
                }
                code = target.getUnitCode() + "_" + (maxNo + 1);
            }
        }
        return code;
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
        SysUser sysUser = sysUserService.findUniqueByProperty("regPerson", sysRegPersonService.get(id));
        if (sysUser != null) {
            sysUserService.delete(sysUser.getId());
        }
        sysRegPersonService.delete(id);
        sendSuccessJSON(response, "删除成功");
    }

    /**
     * 验证是否已有注册
     *
     * @throws Exception .
     */
    @RequestMapping
    public String getReg(String loginName, Model model, String regType) throws Exception {
        String regInfo = regPersonManager.isReg(loginName, regType);
        if (regInfo.equals("用户已经注册!!") || regInfo.equals("未找到有效编号!!")) {
            model.addAttribute("msg", "{success:'false',msg:'" + regInfo + "'}");
        } else {
            model.addAttribute("msg", "{success:'true',msg:'" + regInfo + "'}");
        }
        return "common/msg";
    }

    /**
     * 工地管理人员选择树
     *
     * @param type  .
     * @param id    .
     * @param icon  .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String treeDataForSelect(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("根节点"));
        } else if (StringUtils.equals(id, "root")) {
            //工地
            String hpl = "from SysRegPerson where gdCode is not null order by id,personName asc";
            List<SysRegPerson> sysRegPersons = sysRegPersonService.findByQuery(hpl);
            for (SysRegPerson sysRegPerson : sysRegPersons) {

                ShareGdInfo shareGdInfo = projectManager.getGDInfo(sysRegPerson.getGdCode());
                if(shareGdInfo != null){
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(shareGdInfo.getGdCode());
                treeNode.setIsLeaf(false);
                treeNode.setName(shareGdInfo.getGdName());
                treeNode.setIcon("1");
                treeNode.setType("company");

                treeBranch.addTreeNode(treeNode);
                }
            }

        } else if (StringUtils.equals(type, "company") || StringUtils.equals(type, "dept")) {
            //工地管理人员
            String hpl = "from SysRegPerson where gdCode='" + id + "' order by id,personName asc";
            List<SysRegPerson> sysRegPersons = sysRegPersonService.findByQuery(hpl);

            for (SysRegPerson sysRegPerson : sysRegPersons) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(sysRegPerson.getId()));
                treeNode.setIsLeaf(true);
                treeNode.setName(sysRegPerson.getPersonName());
                treeNode.setIcon("3");
                treeNode.setType("person");
                treeBranch.addTreeNode(treeNode);
            }
        }
        String s = treeBranch.toJsonString(false);
        model.addAttribute("msg", s);
        return "common/msg";
    }

}