package com.justonetech.biz.controller.workflow;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.BpmDutyPersonService;
import com.justonetech.biz.daoservice.BpmProjectGroupDutyService;
import com.justonetech.biz.daoservice.BpmProjectGroupService;
import com.justonetech.biz.domain.BpmDutyPerson;
import com.justonetech.biz.domain.BpmProjectGroup;
import com.justonetech.biz.domain.BpmProjectGroupDuty;
import com.justonetech.biz.manager.workflow.ExtAttrManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItem;
import com.justonetech.biz.utils.jbpm.extattr.ExtendAttributeFactory;
import com.justonetech.biz.utils.jbpm.extattr.definition.ExtAttrDef;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attribute;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attributes;
import com.justonetech.biz.utils.jbpm.extattr.instance.AttributesUtils;
import com.justonetech.biz.utils.jbpm.extattr.instance.Values;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * note:项目组
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProjectGroupController extends BaseCRUDActionController<BpmProjectGroup> {
    private Logger logger = LoggerFactory.getLogger(BpmProjectGroupController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private BpmProjectGroupDutyService bpmProjectGroupDutyService;

    @Autowired
    private BpmDutyPersonService bpmDutyPersonService;

    @Autowired
    private BpmProjectGroupService bpmProjectGroupService;

    @Autowired
    private ExtAttrManager extAttrManager;

    @Autowired
    private ExtendAttributeFactory extendAttributeFactory;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROJECT_GROUP_EDIT));

        return "view/workflow/bpmProjectGroup/grid";
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
            String hql = "from BpmProjectGroup order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            pageModel = bpmProjectGroupService.findByPage(pageModel, query);
            session.setAttribute(Constants.GRID_SQL_KEY, query);

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
        BpmProjectGroup bpmProjectGroup = new BpmProjectGroup();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", bpmProjectGroup);
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_TYPE);
        return "view/workflow/bpmProjectGroup/input";
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
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", bpmProjectGroup);
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_TYPE);
        return "view/workflow/bpmProjectGroup/input";
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
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_TYPE);
        model.addAttribute("bean", bpmProjectGroup);
        return "view/workflow/bpmProjectGroup/view";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") BpmProjectGroup entity) throws Exception {
        try {
            BpmProjectGroup target;
            if (entity.getId() != null) {
                target = bpmProjectGroupService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "type",
                        "name",
                        "stamper",
                        "attributes",
                        "isValid"
                });

            } else {
                target = entity;
            }
            bpmProjectGroupService.save(target);

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
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);
        Set<BpmProjectGroupDuty> bpmProjectGroupDuties = bpmProjectGroup.getBpmProjectGroupDuties();
        for (BpmProjectGroupDuty bpmProjectGroupDuty : bpmProjectGroupDuties) {
            Set<BpmDutyPerson> bpmDutyPersonSet = bpmProjectGroupDuty.getBpmDutyPersons();
            for (BpmDutyPerson bdp : bpmDutyPersonSet) {
                bpmDutyPersonService.delete(bdp.getId());
            }
            bpmProjectGroupDutyService.delete(bpmProjectGroupDuty.getId());
        }
        bpmProjectGroupService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }


    /**
     * 设置属性
     *
     * @param id    .
     * @param model .
     * @return .
     * @throws javax.xml.bind.JAXBException .
     */
    @RequestMapping
    public String setExtAttr(Long id, Model model) throws JAXBException {
        //得到已定义的attribute,并放入map
        BpmProjectGroup sysProjectGroup = bpmProjectGroupService.get(id);
        String xmlAttribute = sysProjectGroup.getAttributes();
        Attributes attributes = getAttributesByXml(xmlAttribute);
        List<Attribute> attributeList = attributes.getAttribute();
        Map<String, Attribute> attributeMap = new HashMap<String, Attribute>();
        for (Attribute attribute : attributeList) {
            attributeMap.put(attribute.getCode(), attribute);
        }

        //得到所有的attribute,发现在已定义map中，则标记为已定义
        List<Map> attrs = new ArrayList<Map>();
        List<ExtAttrDef> defs = extendAttributeFactory.getAllExtAttrDefList();
        for (ExtAttrDef def : defs) {
            Map attr = new HashMap();
            attr.put("code", def.getCode());
            attr.put("name", def.getName());
            if (attributeMap.get(def.getCode()) != null) {
                attr.put("checked", true);
            } else {
                attr.put("checked", false);
            }
            attrs.add(attr);
        }

        model.addAttribute("bean", sysProjectGroup);
        model.addAttribute("attrs", attrs);
        return "view/workflow/bpmProjectGroup/setExtAttr";
    }


    /**
     * @param id            .
     * @param defCode       .
     * @param attributeType .
     * @param expression    .
     * @param model         .
     * @return .
     * @throws JAXBException          .
     * @throws java.lang.reflect.InvocationTargetException
     *                                .
     * @throws ClassNotFoundException .
     * @throws NoSuchMethodException  .
     * @throws IllegalAccessException .
     */
    @RequestMapping
    public String extAttr(Long id, String defCode, String attributeType, String expression, Model model) throws
            JAXBException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        //得到sysProjectGroup对应的所有attribute，并生成tab页所需数据
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);
        String xmlAttribute = bpmProjectGroup.getAttributes();
        Map<String, ExtAttrDef> extAttrDefMap = getExtAttrDef();
        Attributes attributes = getAttributesByXml(xmlAttribute);
        List<Attribute> attributeList = attributes.getAttribute();

        List<Map> attrs = new ArrayList<Map>();
        Attribute currentAttribute = null;
        //为每个tab页的动态查出数据
        for (Attribute attribute : attributeList) {
            //页面的tab页
            Map<String, String> attr = new HashMap<String, String>();
            ExtAttrDef attrDef = extAttrDefMap.get(attribute.getCode());
            attr.put("code", attribute.getCode());
            attr.put("name", attrDef.getName());
            attrs.add(attr);

            //为页面赋默认值
            if (defCode.equals("")) {
                defCode = attribute.getCode();
            }

            //为页面设置
            if (defCode.equals(attribute.getCode())) {
                currentAttribute = attribute;
                String type = "all";
                if (attribute.getAll() != null) {
                    type = "all";
                } else if (attribute.getNone() != null) {
                    type = "none";
                } else if (attribute.getValues() != null) {
                    type = "values";
                } else if (attribute.getExpression() != null) {
                    type = "express";
                    if (expression.equals("")) {
                        expression = attribute.getExpression();
                    }
                }
                if (attributeType.equals("")) {
                    attributeType = type;
                }

                if (!attributeType.equals(type)) {
                    currentAttribute.setAll(null);
                    currentAttribute.setNone(null);
                    currentAttribute.setValues(null);
                    currentAttribute.setExpression(null);
                    if (attributeType.toLowerCase().equals("all")) {
                        currentAttribute.setAll(true);
                    } else if (attributeType.toLowerCase().equals("none")) {
                        currentAttribute.setNone(true);
                    } else if (attributeType.toLowerCase().equals("values")) {
                        Values values = new Values();
                        currentAttribute.setValues(values);
                    } else if (attributeType.toLowerCase().equals("express")) {
                        currentAttribute.setExpression(expression);
                    }
                } else if (type.toLowerCase().equals("express")) {
                    currentAttribute.setExpression(expression);
                }
            }

        }
        if (currentAttribute != null) {
            ExtAttrDef extAttrDef = extAttrDefMap.get(defCode);
            List<ExtAttrItem> extAttrItemList = extAttrManager.getAttrItemList(currentAttribute, extAttrDef);
            logger.debug("extAttrItemList's size is {}", extAttrItemList.size());
            List<Map> extAttrItems = new ArrayList<Map>();
            for (ExtAttrItem extAttrItem : extAttrItemList) {
                Map map = new HashMap();
                map.put("id", extAttrItem.getId());
                map.put("value", extAttrItem.getValue());
                map.put("isChecked", true);
                extAttrItems.add(map);
            }

            if (attributeType.equals("values")) {
                List<ExtAttrItem> unCheckedExtAttrItems = extAttrManager.getUnCheckedExtAttrItems(currentAttribute, extAttrDef);
                logger.debug("unCheckedExtAttrItems's size is {}", unCheckedExtAttrItems.size());
                for (ExtAttrItem extAttrItem : unCheckedExtAttrItems) {
                    Map map = new HashMap();
                    map.put("id", extAttrItem.getId());
                    map.put("value", extAttrItem.getValue());
                    map.put("isChecked", false);
                    extAttrItems.add(map);
                }
            }

            logger.debug("extAttrItems's size is {}", extAttrItems.size());

            model.addAttribute("attrs", attrs);
            model.addAttribute("defCode", defCode);
            model.addAttribute("defName", extAttrDef.getName());
            model.addAttribute("attributeType", attributeType);
            model.addAttribute("expression", expression);
            model.addAttribute("extAttrItems", extAttrItems);
        }

        model.addAttribute("bean", bpmProjectGroup);

        return "view/workflow/bpmProjectGroup/extAttr";
    }

    /**
     * @param id            .
     * @param defCode       .
     * @param attributeType .
     * @param expression    .
     * @param model         .
     * @return .
     * @throws JAXBException          .
     * @throws java.lang.reflect.InvocationTargetException
     *                                .
     * @throws ClassNotFoundException .
     * @throws NoSuchMethodException  .
     * @throws IllegalAccessException .
     */
    @RequestMapping
    public String extAttrCheck(Long id, String defCode, String attributeType, String expression, Model model) throws
            JAXBException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
//        if(StringHelper.isEmpty(defCode)){defCode="";}
//        if(StringHelper.isEmpty(expression)){expression="";}
//        if(StringHelper.isEmpty(attributeType)){attributeType="";}

        //得到sysProjectGroup对应的所有attribute，并生成tab页所需数据
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);
        String xmlAttribute = bpmProjectGroup.getAttributes();
        Map<String, ExtAttrDef> extAttrDefMap = getExtAttrDef();
        Attributes attributes = getAttributesByXml(xmlAttribute);
        List<Attribute> attributeList = attributes.getAttribute();

        List<Map> attrs = new ArrayList<Map>();
        Attribute currentAttribute = null;
        //为每个tab页的动态查出数据
        for (Attribute attribute : attributeList) {
            //页面的tab页
            Map<String, String> attr = new HashMap<String, String>();
            ExtAttrDef attrDef = extAttrDefMap.get(attribute.getCode());
            attr.put("code", attribute.getCode());
            attr.put("name", attrDef.getName());
            attrs.add(attr);

            //为页面赋默认值
            if (defCode.equals("")) {
                defCode = attribute.getCode();
            }

            //为页面设置
            if (defCode.equals(attribute.getCode())) {
                currentAttribute = attribute;
                String type = "all";
                if (attribute.getAll() != null) {
                    type = "all";
                } else if (attribute.getNone() != null) {
                    type = "none";
                } else if (attribute.getValues() != null) {
                    type = "values";
                } else if (attribute.getExpression() != null) {
                    type = "express";
                    if (expression.equals("")) {
                        expression = attribute.getExpression();
                    }
                }
                if (attributeType.equals("")) {
                    attributeType = type;
                }

                if (!attributeType.equals(type)) {
                    currentAttribute.setAll(null);
                    currentAttribute.setNone(null);
                    currentAttribute.setValues(null);
                    currentAttribute.setExpression(null);
                    if (attributeType.toLowerCase().equals("all")) {
                        currentAttribute.setAll(true);
                    } else if (attributeType.toLowerCase().equals("none")) {
                        currentAttribute.setNone(true);
                    } else if (attributeType.toLowerCase().equals("values")) {
                        Values values = new Values();
                        currentAttribute.setValues(values);
                    } else if (attributeType.toLowerCase().equals("express")) {
                        currentAttribute.setExpression(expression);
                    }
                } else if (type.toLowerCase().equals("express")) {
                    currentAttribute.setExpression(expression);
                }
            }

        }
        if (currentAttribute != null) {

            ExtAttrDef extAttrDef = extAttrDefMap.get(defCode);
            List<ExtAttrItem> extAttrItemList = extAttrManager.getAttrItemList(currentAttribute, extAttrDef);
            logger.debug("extAttrItemList's size is {}", extAttrItemList.size());
            List<Map> extAttrItems = new ArrayList<Map>();
            for (ExtAttrItem extAttrItem : extAttrItemList) {
                Map map = new HashMap();
                map.put("id", extAttrItem.getId());
                map.put("value", extAttrItem.getValue());
                map.put("isChecked", true);
                extAttrItems.add(map);
            }

            if (attributeType.equals("values")) {
                List<ExtAttrItem> unCheckedExtAttrItems = extAttrManager.getUnCheckedExtAttrItems(currentAttribute, extAttrDef);
                logger.debug("unCheckedExtAttrItems's size is {}", unCheckedExtAttrItems.size());
                for (ExtAttrItem extAttrItem : unCheckedExtAttrItems) {
                    Map map = new HashMap();
                    map.put("id", extAttrItem.getId());
                    map.put("value", extAttrItem.getValue());
                    map.put("isChecked", false);
                    extAttrItems.add(map);
                }
            }


            model.addAttribute("attrs", attrs);
            model.addAttribute("defCode", defCode);
            model.addAttribute("defName", extAttrDef.getName());
            model.addAttribute("attributeType", attributeType);
            model.addAttribute("expression", expression);
            model.addAttribute("extAttrItems", extAttrItems);
        }

        model.addAttribute("bean", bpmProjectGroup);
        return "view/workflow/bpmProjectGroup/extAttrCheck";

    }

    private Attributes getAttributesByXml(String xmlAttribute) throws JAXBException {
        Attributes attributes;
        if (!StringHelper.isEmpty(xmlAttribute) && !xmlAttribute.trim().equals("")) {
            attributes = AttributesUtils.loadFromXml(xmlAttribute);
        } else {
            attributes = new Attributes();
        }
        return attributes;
    }

    private Map<String, ExtAttrDef> getExtAttrDef() {
        //得到系统注册的所有扩展属性，并放入map
        Map<String, ExtAttrDef> extAttrDefMap = new HashMap<String, ExtAttrDef>();
        extAttrManager.getClass();
        List<ExtAttrDef> defs = this.extendAttributeFactory.getAllExtAttrDefList();

        for (ExtAttrDef def : defs) {
            logger.debug("def : {} put to map", def.getCode());
            extAttrDefMap.put(def.getCode(), def);
        }
        return extAttrDefMap;
    }

    /**
     * 保存属性设置
     *
     * @param request  .
     * @param id       .
     * @param response .
     * @throws JAXBException .
     */
    @RequestMapping
    public void saveExtAttrSetting(HttpServletRequest request, @RequestParam Long id, HttpServletResponse response) throws JAXBException {
        String[] items = request.getParameterValues("item");

        //得到已定义的attribute,并放入map
        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);

        Map<String, Attribute> oldAttributeMap = new HashMap<String, Attribute>();
        Attributes oldAttributes = getAttributesByXml(bpmProjectGroup.getAttributes());
        List<Attribute> oldAttributeList = oldAttributes.getAttribute();
        for (Attribute attribute : oldAttributeList) {
            oldAttributeMap.put(attribute.getCode(), attribute);
        }

        Attributes attributes = new Attributes();
        List<Attribute> attributeList = attributes.getAttribute();

        if (items != null) {
            for (String item : items) {

                Attribute attribute = oldAttributeMap.get(item);
                if (attribute == null) {
                    attribute = new Attribute();
                    attribute.setCode(item);
                    attribute.setNone(true);
                }
                attributeList.add(attribute);
            }
        }
        String xml = AttributesUtils.saveToXml(attributes);
        bpmProjectGroup.setAttributes(xml);
        bpmProjectGroupService.save(bpmProjectGroup);

        sendSuccessJSON(response, "保存成功");

    }

    /**
     * 保存属性
     *
     * @param request       .
     * @param id            .
     * @param defCode       .
     * @param attributeType .
     * @param expression    .
     * @param response      .
     * @throws JAXBException          .
     * @throws ClassNotFoundException .
     * @throws IllegalAccessException .
     * @throws NoSuchMethodException  .
     * @throws java.lang.reflect.InvocationTargetException
     *                                .
     */
    @RequestMapping
    public void saveExtAttr(HttpServletRequest request, Long id, String defCode, String attributeType, String expression, HttpServletResponse response) throws
            JAXBException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        String[] itemIds = request.getParameterValues("itemId");

        BpmProjectGroup bpmProjectGroup = bpmProjectGroupService.get(id);
        String xmlAttribute = bpmProjectGroup.getAttributes();

        Attributes attributes = getAttributesByXml(xmlAttribute);
        List<Attribute> attributeList = attributes.getAttribute();
        Attribute currentAttribute = null;

        for (Attribute attribute : attributeList) {
            if (defCode.equals(attribute.getCode())) {
                currentAttribute = attribute;

                //先把所有的属性清空
                currentAttribute.setAll(null);
                currentAttribute.setNone(null);
                currentAttribute.setValues(null);
                currentAttribute.setExpression(null);

                //根据类型为其赋值
                if (attributeType.toLowerCase().equals("all")) {
                    currentAttribute.setAll(true);
                } else if (attributeType.toLowerCase().equals("none")) {
                    currentAttribute.setNone(true);
                } else if (attributeType.toLowerCase().equals("values")) {
                    //currentAttribute.getValues().getValue()返回一个list
                    Values values = new Values();
                    currentAttribute.setValues(values);
                    List<Long> valueList = currentAttribute.getValues().getValue();
                    if (itemIds != null) {
                        logger.debug("itemIds.length {}", itemIds.length);
                        for (String itemId : itemIds) {
                            valueList.add(Long.valueOf(itemId));
                        }
                    }
                } else if (attributeType.toLowerCase().equals("express")) {
                    currentAttribute.setExpression(expression);
                } else {
                    logger.error("attribute type not in (all,none,values,express)!");
                    throw new RuntimeException("attribute type not in (all,none,values,express)!");
                }
                break;
            }
        }
        //save attributes to sysProjectGroup
        String xml = AttributesUtils.saveToXml(attributes);
        bpmProjectGroup.setAttributes(xml);
        logger.debug("sysProjectGroup attribute is {}", xml);
        //因为是持久化对象，不保存session close 时也会做同步
        bpmProjectGroupService.save(bpmProjectGroup);
//        sysProjectGroupService.flush();
//        expression = URLTransferred(expression);
        sendSuccessJSON(response, "保存成功");
    }


}