package com.justonetech.biz.controller.oa;

import java.text.SimpleDateFormat;
import java.util.*;

import com.justonetech.biz.domain.DocDocument;
import com.justonetech.biz.domain.OaMeetingOuter;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysPerson;
import org.apache.commons.lang.StringUtils;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.ui.grid.Grid;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaMeetingInnerService;
import com.justonetech.biz.domain.OaMeetingInner;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:内部会议
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaMeetingInnerController extends BaseCRUDActionController<OaMeetingInner>
{
    private Logger logger = LoggerFactory.getLogger(OaMeetingInnerController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private DocDocumentService docDocumentService;

    @Autowired
    private OaMeetingInnerService oaMeetingInnerService;

    @Autowired
    private SysPersonService sysPersonService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model)
    {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.OA_MEETING_INNER_EDIT));

        return "view/oa/oaMeetingInner/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .
     * @param session .
     * @param queryJson .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session,String queryJson)
    {
        try
        {
            String beginTime = StringHelper.getElementValue(queryJson, "beginTime");
            String endTime = StringHelper.getElementValue(queryJson, "endTime");
            String status = StringHelper.getElementValue(queryJson, "status");
            Page pageModel = new Page(page, rows, true);
            String hql = "from OaMeetingInner where 1=1 ";
            //增加自定义查询条件
            if (!StringHelper.isEmpty(beginTime)) {
                hql += " and to_char(beginTime,'YYYY-MM-DD')>='" + beginTime + "'";
            }
            if (!StringHelper.isEmpty(endTime)) {
                hql += " and to_char(endTime,'YYYY-MM-DD')<='" + endTime + "'";
            }
            hql += " order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaMeetingInnerService.findByPage(pageModel, query);
            List<OaMeetingInner> rowList = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (OaMeetingInner data : rowList)
            {
                map = new HashMap<String, Object>();
                map.put("id", data.getId());
                map.put("beginTime", data.getBeginTime());
                map.put("endTime", data.getEndTime());
                map.put("title", data.getTitle());
                map.put("meetTime", data.getMeetTime());
                map.put("address", data.getAddress());
                map.put("docDown", documentManager.getDownloadButton(data.getDoc()));
                retList.add(map);
            }

            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
            sendJSON(response, json);

        } catch (Exception e)
        {
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
    public String add(Model model)
    {
        OaMeetingInner oaMeetingInner = new OaMeetingInner();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaMeetingInner);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaMeetingInner.class.getSimpleName(), oaMeetingInner.getDoc(), null, null));

        return "view/oa/oaMeetingInner/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id)
    {
        OaMeetingInner oaMeetingInner = oaMeetingInnerService.get(id);

        //内部参会人员
        String innerPersonIds = oaMeetingInner.getInnerPersons();
        if (!StringHelper.isEmpty(innerPersonIds)) {
            List<SysPerson> persons = sysPersonService.findByQuery("from SysPerson where id in("+innerPersonIds+")");
            model.addAttribute("innerPersons",persons);
        }

        //处理其他业务逻辑
        model.addAttribute("bean", oaMeetingInner);

        model.addAttribute("uploadButton", documentManager.getUploadButton(documentManager.getDefaultXmlConfig(),
                OaMeetingInner.class.getSimpleName(), oaMeetingInner.getDoc(), null, null));

        return "view/oa/oaMeetingInner/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id)
    {
        OaMeetingInner oaMeetingInner = oaMeetingInnerService.get(id);
        //内部参会人员
        String innerPersonIds = oaMeetingInner.getInnerPersons();
        if (!StringHelper.isEmpty(innerPersonIds)) {
            List<SysPerson> persons = sysPersonService.findByQuery("from SysPerson where id in("+innerPersonIds+")");
            model.addAttribute("innerPersons",persons);
        }
        model.addAttribute("meetTime", oaMeetingInner.getMeetTime());
        model.addAttribute("docButton", documentManager.getDownloadButton(oaMeetingInner.getDoc()));
        model.addAttribute("bean", oaMeetingInner);
        return "view/oa/oaMeetingInner/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaMeetingInner entity, HttpServletRequest request) throws Exception
    {
        try
        {
            OaMeetingInner target;
            if (entity.getId() != null)
            {
                target = oaMeetingInnerService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "beginTime",
                        "endTime",
                        "address",
                        "innerPersons",
                        "outerPersons",
                        "title",
                        "content"
                });

            } else
            {
                target = entity;
            }
            //保存文件
            String docId = request.getParameter("docId");
            if (StringHelper.isNotEmpty(docId))
            {
                DocDocument docDocument = docDocumentService.get(Long.valueOf(docId));
                target.setDoc(docDocument);
            }

            oaMeetingInnerService.save(target);
        } catch (Exception e)
        {
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
    public void delete(HttpServletResponse response, Long id) throws Exception
    {
        oaMeetingInnerService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}