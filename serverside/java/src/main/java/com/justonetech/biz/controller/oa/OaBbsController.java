package com.justonetech.biz.controller.oa;

import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.OaBbsService;
import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaBbs;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.operationMsg.OperationMsgManager;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * note:员工论坛
 * author: gq
 * create date: 2015-4-2
 * modify date:
 */
@Controller
public class OaBbsController extends BaseCRUDActionController<OaBbs> {
    private Logger logger = LoggerFactory.getLogger(OaBbsController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaBbsService oaBbsService;

    /**
     * 入口页面
     *
     * @return 。
     */
    @RequestMapping
    public String init() {

        return "view/oa/oaBbs/init";
    }

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //封装类型
        List<SysCodeDetail> detailList = sysCodeManager.getCodeListByCode(OaBbs.class.getSimpleName());
        String sql = "select type_id,count(type_id) from oa_bbs where parent_id is null group by type_id";
        List typeList = simpleQueryManager.getListBySql(sql);
        List<Map<String, Object>> typeMapList = new ArrayList<Map<String, Object>>();
        for (SysCodeDetail detail : detailList) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (Object o : typeList) {
                Object[] obj = (Object[]) o;
                Long objId = JspHelper.getLong(obj[0]);
                if (detail.getId().equals(objId)) {
                    map.put("typeId", detail.getId());
                    map.put("code", detail.getCode());
                    map.put("typeName", detail.getName() + "[" + obj[1] + "]");
                    typeMapList.add(map);
                }
            }
        }
        model.addAttribute("types", typeMapList);
        //判断是否有编辑或管理权限
        doPrivilege(model);

        return "view/oa/oaBbs/grid";
    }

    /**
     * 判断是否有编辑或管理权限
     *
     * @param model .
     */
    public void doPrivilege(Model model) {
        //判断是否有编辑或管理权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OABBS_EDIT));
        model.addAttribute("canManager", sysUserManager.hasPrivilege(PrivilegeCode.OABBS_MANAGER));
    }

    /**
     * 处理分页和查询
     *
     * @param model    。
     * @param pageNum  。
     * @param pageSize 。
     * @param title    。
     * @param time     。
     * @param order    。
     * @param typeId   。
     * @param msg      。
     * @return 。
     */
    @RequestMapping
    public String getData(Model model, Integer pageNum, Integer pageSize, String title, String time, String order, String typeId, String msg) {
        model.addAttribute("title", title);
        model.addAttribute("time", time);
        model.addAttribute("order", order);
        model.addAttribute("msg", msg);
        // 初始化分页
        if (null == pageSize || "".equals(pageSize)) {
            pageSize = 10;
        }
        if (null == pageNum || "".equals(pageNum) || pageNum < 1) {
            pageNum = 1;
        }
        Page pageModel = new Page(pageNum, pageSize, true);
        String orderBy = " order by createTime desc";
        //按输入条件查询
        String hql = "from OaBbs where parent is null and isValid=1";
        if (!StringHelper.isEmpty(title)) {
            hql += " and title like '%" + title + "%'";
        }
        //时间的查询
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp oldTimestamp = new Timestamp(System.currentTimeMillis());//当前时间
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());//当前时间
        String oldFormat = sdf.format(oldTimestamp);
        String newFormat = sdf.format(newTimestamp);
        if ("oneDay".equals(time)) {  //一天
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        } else if ("twoDay".equals(time)) {  //两天
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTimestamp);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            oldFormat = sdf.format(calendar.getTime());
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        } else if ("threeDay".equals(time)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTimestamp);
            calendar.add(Calendar.DAY_OF_MONTH, -2);
            oldFormat = sdf.format(calendar.getTime());
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        } else if ("oneWeek".equals(time)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTimestamp);
            calendar.add(Calendar.WEEK_OF_MONTH, -1);
            oldFormat = sdf.format(calendar.getTime());
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        } else if ("oneMonth".equals(time)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTimestamp);
            calendar.add(Calendar.MONTH, -1);
            oldFormat = sdf.format(calendar.getTime());
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        } else if ("threeMonth".equals(time)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(oldTimestamp);
            calendar.add(Calendar.MONTH, -3);
            oldFormat = sdf.format(calendar.getTime());
            hql += " and to_char(createTime,'yyyy-MM-dd') between '" + oldFormat + "' and '" + newFormat + "'";
        }
        //排序查询
        if ("new".equals(order)) {
            hql += orderBy;
        } else if ("last".equals(order)) {

        }
        //最新，热门，精华查询
        if ("new".equals(msg)) {
            hql += orderBy;
        } else if ("hot".equals(msg)) {
            hql += " order by visitTimes desc,replyTimes desc,createTime desc";
        } else if ("top".equals(msg)) {
            hql += " and isTop=1" + orderBy;
        }
        //类型查询
        if (!StringHelper.isEmpty(typeId)) {
            hql += " and type.id=" + typeId;
        }
        if (StringHelper.isEmpty(order) || StringHelper.isEmpty(msg)) {
            hql += orderBy;
        }
        pageModel = oaBbsService.findByPage(pageModel, hql);
        // 查询总共记录
        List<OaBbs> totalList = oaBbsService.findByQuery(hql);
        model.addAttribute("totalListSize", totalList == null ? 0 : totalList.size());
        // 当前页的数据
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pageSize", pageSize);

        List<OaBbs> list = pageModel.getRows();
        //重新封装数据
        List<Map<String, Object>> oaBbsList = new ArrayList<Map<String, Object>>();
        for (OaBbs oaBbs : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", oaBbs.getId());
            map.put("typeName", oaBbs.getType().getName());
            map.put("title", oaBbs.getTitle());
            map.put("isTop", oaBbs.getIsTop());
            map.put("docButton", documentManager.getDownloadButton(oaBbs.getDocument()));
            map.put("visitTimes", oaBbs.getVisitTimes());
            map.put("replyTimes", oaBbs.getReplyTimes());
            map.put("createTime", oaBbs.getCreateTime());
            map.put("personName", oaBbs.getPersonName());
            Set<OaBbs> oaBbses = oaBbs.getOaBbs();
            if (null != oaBbses && oaBbses.size() > 0) {
                OaBbs bbs = oaBbses.iterator().next();
                map.put("lastReplyTime", bbs.getCreateTime());
                map.put("lastReplyPerson", bbs.getPersonName());
            } else {
                map.put("lastReplyTime", "");
                map.put("lastReplyPerson", "");
            }
            oaBbsList.add(map);
        }
        model.addAttribute("list", oaBbsList);

        return "view/oa/oaBbs/data";
    }

    /**
     * 发表新帖
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String newPost(Model model, Long parentId) {
        //当前登录用户
        SysUser sysUser = sysUserManager.getSysUser();
        //论坛类型
        List<SysCodeDetail> detailList = sysCodeManager.getCodeListByCode(OaBbs.class.getSimpleName());
        model.addAttribute("types", detailList);
        //新增
        OaBbs oaBbs;
        if (null != parentId) {
            oaBbs = oaBbsService.get(parentId);
        } else {
            oaBbs = new OaBbs();
        }
        model.addAttribute("bean", oaBbs);
        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaBbs.class.getSimpleName(), null, sysUser.getId(), null));

        return "view/oa/oaBbs/newPost";
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
    public String savePublish(HttpServletResponse response, @ModelAttribute("bean") OaBbs entity, HttpServletRequest request, Model model) throws Exception {
        try {
            OaBbs target;
            if (entity.getId() != null) {
                target = oaBbsService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "title",
                        "content"
                });
            } else {
                target = entity;
                target.setVisitTimes(0);
                target.setReplyTimes(0);
                target.setIsValid(true);
                target.setIsTop(false);
            }
            //获取员工论坛类型
            String typeId = request.getParameter("type");
            SysCodeDetail detail = sysCodeManager.getCodeListById(Long.valueOf(typeId));
            target.setType(detail);
            target.setTypeName(detail.getName());
            //获取主题
            String title = request.getParameter("title");
            target.setTitle(title);
            //获取内容
            String content = request.getParameter("content");
            target.setContent(content);
            //获取上传附件ID
            String docId = request.getParameter("docId");
            //保存附件
            if (!StringHelper.isEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            //当前登录用户
            String displayName = sysUserManager.getSysUser().getDisplayName();
            target.setPersonName(displayName);

            oaBbsService.save(target);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
        return OperationMsgManager.successMsg(model, "oaBbs/grid.do", "操作成功", null);
    }

    /**
     * 发表新帖
     *
     * @param model 。
     * @return 。
     */
    @RequestMapping
    public String reply(Model model, Long parentId, Long id) {
        OaBbs parent = oaBbsService.get(parentId);
        model.addAttribute("bean", parent);
        OaBbs child;
        if (id != null) {
            child = oaBbsService.get(id);
        } else {
            child = new OaBbs();
        }
        model.addAttribute("child", child);
        //当前登录用户
        SysUser sysUser = sysUserManager.getSysUser();
        //论坛类型
        List<SysCodeDetail> detailList = sysCodeManager.getCodeListByCode(OaBbs.class.getSimpleName());
        model.addAttribute("types", detailList);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(), OaBbs.class.getSimpleName(), null, sysUser.getId(), null));

        return "view/oa/oaBbs/reply";
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
    public String saveReply(HttpServletResponse response, @ModelAttribute("bean") OaBbs entity, HttpServletRequest request, Model model) throws Exception {
        try {
            OaBbs target;
            if (entity.getId() != null) {
                target = oaBbsService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "content"
                });
            } else {
                target = entity;
            }
            //获取父id
            String parentId = request.getParameter("parentId");
            OaBbs parent = oaBbsService.get(Long.valueOf(parentId));
            target.setParent(parent);
            target.setType(parent.getType());
            target.setTypeName(parent.getType().getName());
            //获取内容
            String content = request.getParameter("content");
            target.setContent(content);
            //获取上传附件ID
            String docId = request.getParameter("docId");
            //保存附件
            if (!StringHelper.isEmpty(docId)) {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDocument(docDocument);
            }
            //当前登录用户
            String displayName = sysUserManager.getSysUser().getDisplayName();
            target.setPersonName(displayName);
            target.setIsValid(true);
            target.setIsTop(false);
            oaBbsService.save(target);
            //保存回复次数
            Set<OaBbs> oaBbs = parent.getOaBbs();
            if (null != oaBbs && oaBbs.size() > 0) {
                parent.setReplyTimes(oaBbs.size());
                oaBbsService.save(parent);
            }

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
        return OperationMsgManager.successMsg(model, "oaBbs/grid.do", "操作成功", null);
    }

    /**
     * 浏览页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id, String flag) {
        String loginName = sysUserManager.getSysUser().getLoginName();
        model.addAttribute("loginName", loginName);
        OaBbs oaBbs = oaBbsService.get(id);
        Integer visitTimes = oaBbs.getVisitTimes();
        visitTimes++;
        oaBbs.setVisitTimes(visitTimes);
        oaBbsService.save(oaBbs);
        model.addAttribute("bean", oaBbs);
        model.addAttribute("docButton", documentManager.getDownloadButton(oaBbs.getDocument()));
        Set<OaBbs> list = oaBbs.getOaBbs();
        if ("lz".equals(flag)) {
            if (null != list && list.size() > 0) {
                for (OaBbs bbs : list) {
                    if (!list.contains(bbs)) {
                        if (bbs.getCreateUser().equals(oaBbs.getCreateUser())) {
                            list.add(bbs);
                        } else {
                            list.remove(bbs);
                        }
                    }
                }
            }
        }
        //重新封装数据
        List<Map<String, Object>> oaBbsList = new ArrayList<Map<String, Object>>();
        if (null != list && list.size() > 0) {
            for (OaBbs bbs : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", bbs.getId());
                map.put("content", bbs.getContent());
                map.put("docButton", documentManager.getDownloadButton(bbs.getDocument()));
                map.put("docId", bbs.getDocument());
                map.put("createTime", bbs.getCreateTime());
                map.put("createUser", bbs.getCreateUser());
                map.put("personName", bbs.getPersonName());
                oaBbsList.add(map);
            }
        }
        model.addAttribute("list", oaBbsList);
        //判断是否有编辑或管理权限
        doPrivilege(model);

        return "view/oa/oaBbs/view";
    }

    /**
     * 删除操作
     *
     * @param id .
     * @throws Exception .
     */
    @RequestMapping
    public String remove(Long id, Model model, String flag) throws Exception {
        OaBbs oaBbs = oaBbsService.get(id);
        Long parentId = oaBbs.getId();
        if ("removeParent".equals(flag)) {  //删除有孩子的父亲和孩子
            Set<OaBbs> bbsSet = oaBbs.getOaBbs();
            if (null != bbsSet && bbsSet.size() > 0) {
                for (OaBbs bbs : bbsSet) {
                    oaBbsService.delete(bbs);
                }
            }
        } else {
            parentId = oaBbs.getParent().getId();
        }
        oaBbsService.delete(oaBbs);

        if ("removeParent".equals(flag)) {
            return OperationMsgManager.successMsg(model, "oaBbs/grid.do", "操作成功", null);
        } else {
            return OperationMsgManager.successMsg(model, "oaBbs/view.do?id=" + parentId + "&flag=" + flag, "操作成功", null);
        }
    }

    /**
     * 关闭操作
     *
     * @param id .
     * @throws Exception .
     */
    @RequestMapping
    public String close(Long id, Model model) throws Exception {
        OaBbs oaBbs = oaBbsService.get(id);
        oaBbs.setIsValid(true);
        oaBbsService.save(oaBbs);
        return OperationMsgManager.successMsg(model, "oaBbs/grid.do", "操作成功", null);
    }

    /**
     * 设置精华
     *
     * @param id .
     * @throws Exception .
     */
    @RequestMapping
    public String setIsTop(Long id, Model model) throws Exception {
        OaBbs oaBbs = oaBbsService.get(id);
        oaBbs.setIsTop(true);
        oaBbsService.save(oaBbs);
        return OperationMsgManager.successMsg(model, "oaBbs/view.do?id=" + id, "操作成功", null);
    }

    /**
     * 只看某人
     *
     * @param id .
     * @throws Exception .
     */
    @RequestMapping
    public String onlyThisPerson(Long id, Model model, String flag) throws Exception {
        OaBbs oaBbs = oaBbsService.get(id);
        if ("lz".equals(flag)) {
            id = oaBbs.getId();
        } else {
            id = oaBbs.getParent().getId();
        }
        String msg;
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("id", id);
            map.put("success", true);
        }
        msg = JSONObject.fromObject(map).toString();
        model.addAttribute("msg", msg);

        return "common/msg";
    }

}