package com.justonetech.system.controller;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.PersonRegSource;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.*;
import com.justonetech.system.daoservice.SysRegPersonService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysRegPerson;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.Md5Utils;
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
    private SysRegPersonService sysRegPersonService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.SYS_REGPERSON_EDIT));

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
            String hql = "from SysRegPerson where 1=1 order by id desc ";
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
    public String add(Model model) {
        SysRegPerson sysRegPerson = new SysRegPerson();
        sysRegPerson.setAcceptOpinion(1);
        sysRegPerson.setRegResource(PersonRegSource.RESOURCE_WEBSITE.getCode());
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
        Set<SysUser> sysusers = sysRegPerson.getSysUsers();
        StringBuilder sb = new StringBuilder("");
        try {
            for (SysUser sysuser : sysusers) {
                sb.append(sysuser.getLoginName());
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
                if (!StringHelper.isEmpty(password) && password.length() > 20) {
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
            SysRegPerson target;
            if (entity.getId() != null) {
                target = sysRegPersonService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "personName",
                        "mobile",
                        "gdCode",
                        "bjbh",
                        "unitCode",
                        "unitIdentifyCode",
                        "regResource",
                        "acceptOpinion",
//                        "acceptDesc"
                });
            } else {
                target = entity;
            }
            sysRegPersonService.save(target);
            String loginName = request.getParameter("loginName");
            if (Integer.parseInt(request.getParameter("acceptOpinion")) == 1) {
                target.setRegResource(Integer.parseInt(request.getParameter("regResource")));
                target.setAcceptDatetime(DateTimeHelper.getTimestamp());
                SysUser user = null;
                SysUser sysUser = sysUserService.findUniqueByProperty("loginName", loginName);
                if (null != sysUser) {
                    user = sysUser;
                } else {
                    user = new SysUser();
                }
                user.setLoginName(getCodeByRegType(target));
                user.setDisplayName(target.getPersonName());
                user.setStatus(String.valueOf(PersonRegSource.RESOURCE_WEBSITE.getCode()));
                user.setCreateTime(DateTimeHelper.getTimestamp());
                BaseUser loginUser = SpringSecurityUtils.getCurrentUser();
                user.setCreateUser(loginUser.getLoginName());
                int pas = (int) (Math.random() * 999999);
                if (pas < 100000) {
                    pas += 100000;
                }
                user.setPassword(CryptUtil.encrypt(String.valueOf(pas)));
                user.setMd5Pass(Md5Utils.md5(String.valueOf(pas)));
                user.setPasswordUpdateTime(new Timestamp(System.currentTimeMillis()));
                user.setRegPerson(target);
                sysUserService.save(user);

//                    String message = "您所注册的用户已通过审核,您的用户名为:" + user.getLoginName() + ",密码为:" + pas + ",请牢记!联系电话：021-57780775";
//                    if (oaTaskManager.getTask(oaTaskManager.getTaskType(SysRegPerson.class.getSimpleName()), target.getId()) != null) {
//                        oaTaskManager.removeTask(SysRegPerson.class.getSimpleName(), target.getId());
//                    }
//                    msgMessageManager.sendSmsByRegPerson(message + " " + configManager.getSiteName(), sysUserManager.getSysUser(loginUser.getLoginName()), target);
            }
            sysRegPersonService.save(target);


        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    private String getCodeByRegType(SysRegPerson target) {
        String code = null;
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
    public String getReg(String loginName, Model model, String bjbh, String unitCode) throws Exception {
        String regInfo = isReg(loginName, bjbh, unitCode);
        if (!StringHelper.isEmpty(regInfo) && regInfo.equals("用户已经注册!!")) {
            model.addAttribute("msg", "{success:'false',msg:'" + regInfo + "'}");
        } else {
            model.addAttribute("msg", "{success:'true',msg:'" + regInfo + "'}");
        }
        return "common/msg";
    }

    //是否已注册
    public String isReg(String loginName, String bjbh, String unitCode) {
        String msg = "用户已经注册!!";
        List<SysRegPerson> sysRegPersons = sysRegPersonService.findByProperty("bjbh", bjbh);
        if (null != sysRegPersons && sysRegPersons.size() > 0) {
            return msg;
        }
        String[] loginNames = loginName.split("_");
        SysUser sysUser = sysUserService.findUniqueByProperty("loginName", loginName);
        if (sysUser == null) {
            return "";
        } else {
            if (loginNames[0].equals(unitCode)) {
                return msg;
            } else {
                return "";
            }
        }
    }

}