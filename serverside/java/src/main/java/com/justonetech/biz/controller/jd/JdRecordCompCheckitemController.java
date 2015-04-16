package com.justonetech.biz.controller.jd;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.daoservice.JdRecordCompCheckitemService;
import com.justonetech.biz.domain.JdRecordCompCheckitem;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * note:安全质量监督--竣工验收--验收条件设置
 * author: guoqiong
 * create date:
 * modify date:
 */
@Controller
public class JdRecordCompCheckitemController extends BaseCRUDActionController<JdRecordCompCheckitem> {
    private Logger logger = LoggerFactory.getLogger(JdRecordCompCheckitemController.class);

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
    private JdRecordCompCheckitemService jdRecordCompCheckitemService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", true);

        return "view/jd/jdRecordCompCheckitem/grid";
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
            String hql = "from JdRecordCompCheckitem order by type.id asc,orderNo asc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = jdRecordCompCheckitemService.findByPage(pageModel, queryTranslate.toString());

            List<JdRecordCompCheckitem> list = pageModel.getRows();
            List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
            for (JdRecordCompCheckitem jdRecordCompCheckitem : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", jdRecordCompCheckitem.getId());
                map.put("orderNo", jdRecordCompCheckitem.getOrderNo());
                map.put("type", jdRecordCompCheckitem.getType().getName());
                map.put("condition", jdRecordCompCheckitem.getCondition());
                map.put("selectItems", jdRecordCompCheckitem.getSelectItems());
                retList.add(map);
            }
            //输出显示
            String json = GridJq.toJSON(retList, pageModel);
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
        JdRecordCompCheckitem jdRecordCompCheckitem = new JdRecordCompCheckitem();

        //如需增加其他默认值请在此添加
        model.addAttribute("type", Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        model.addAttribute("bean", jdRecordCompCheckitem);

        return "view/jd/jdRecordCompCheckitem/input";
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
        JdRecordCompCheckitem jdRecordCompCheckitem = jdRecordCompCheckitemService.get(id);
        //处理其他业务逻辑
        model.addAttribute("type", Constants.JD_RECORD_COMPLETE_CONDITION_TYPE);
        model.addAttribute("bean", jdRecordCompCheckitem);

        return "view/jd/jdRecordCompCheckitem/input";
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
        JdRecordCompCheckitem jdRecordCompCheckitem = jdRecordCompCheckitemService.get(id);

        model.addAttribute("bean", jdRecordCompCheckitem);

        return "view/jd/jdRecordCompCheckitem/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") JdRecordCompCheckitem entity, HttpServletRequest request, @RequestParam Long typeId) throws Exception {
        try {
            JdRecordCompCheckitem target;
            if (entity.getId() != null) {
                target = jdRecordCompCheckitemService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "orderNo",
                        "condition",
                        "selectItems",
                });
            } else {
                target = entity;
            }
            //设置竣工验收条件
            target.setType(sysCodeDetailService.get(typeId));

            jdRecordCompCheckitemService.save(target);

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
        jdRecordCompCheckitemService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}