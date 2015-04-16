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
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.domain.BpmDutyPerson;
import com.justonetech.biz.domain.BpmProjectGroup;
import com.justonetech.biz.domain.BpmProjectGroupDuty;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.manager.ProjectManager;
import com.justonetech.biz.manager.RelateManager;
import com.justonetech.biz.manager.workflow.ExtAttrManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItem;
import com.justonetech.biz.utils.jbpm.extattr.ExtendAttributeFactory;
import com.justonetech.biz.utils.jbpm.extattr.definition.ExtAttrDef;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attribute;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attributes;
import com.justonetech.biz.utils.jbpm.extattr.instance.AttributesUtils;
import com.justonetech.biz.utils.jbpm.extattr.instance.Values;
import com.justonetech.system.daoservice.SysPersonService;
import com.justonetech.system.domain.SysPerson;
import com.justonetech.system.manager.SimpleQueryManager;
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
import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * note:项目组岗位
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class BpmProjectGroupDutyController extends BaseCRUDActionController<BpmProjectGroupDuty> {
    private Logger logger = LoggerFactory.getLogger(BpmProjectGroupDutyController.class);

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
    private BpmProjectGroupDutyService bpmProjectGroupDutyService;

    @Autowired
    private BpmProjectGroupService bpmProjectGroupService;

    @Autowired
    private BpmDutyPersonService bpmDutyPersonService;

    @Autowired
    private SysPersonService sysPersonService;

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
    public String grid(Model model, Long projectGroupId) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.BPM_PROJECT_GROUP_EDIT));
        BpmProjectGroup group = bpmProjectGroupService.get(projectGroupId);
        model.addAttribute("group", group);
        return "view/workflow/bpmProjectGroupDuty/grid";
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
    public void gridDataCustom(Long projectGroupId, HttpServletResponse response, String filters, String columns, int page, int rows) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from BpmProjectGroupDuty d where d.projectGroup.id = " + projectGroupId + "order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            pageModel = bpmProjectGroupDutyService.findByPage(pageModel, queryTranslate.toString());

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model, Long projectGroupId) {
        BpmProjectGroupDuty bpmProjectGroupDuty = new BpmProjectGroupDuty();

        BpmProjectGroup group = bpmProjectGroupService.get(projectGroupId);
        bpmProjectGroupDuty.setProjectGroup(group);
        //如需增加其他默认值请在此添加
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_DUTY_TYPE);
        model.addAttribute("bean", bpmProjectGroupDuty);

        return "view/workflow/bpmProjectGroupDuty/input";
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
        String personsadd = "";
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);
        Set<BpmDutyPerson> bpmDutyPersonSet = bpmProjectGroupDuty.getBpmDutyPersons();
        List<SysPerson> persons = new ArrayList<SysPerson>();
        for (BpmDutyPerson dutyPerson : bpmDutyPersonSet) {
            SysPerson person = dutyPerson.getPerson();
            personsadd += person.getId() + ",";
            persons.add(person);
        }
        if (personsadd != "") {
            personsadd = personsadd.substring(0, personsadd.length() - 1);
        }
        //处理其他业务逻辑
        model.addAttribute("bean", bpmProjectGroupDuty);
        model.addAttribute("persons", persons);
        model.addAttribute("personsadd", personsadd);
        model.addAttribute("infoType", Constants.BPM_PROJECT_GROUP_DUTY_TYPE);

        return "view/workflow/bpmProjectGroupDuty/input";
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
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);

        model.addAttribute("bean", bpmProjectGroupDuty);
        return "view/workflow/bpmProjectGroupDuty/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") BpmProjectGroupDuty entity, HttpServletRequest request, String personIds) throws Exception {
        try {
            BpmProjectGroupDuty target;
            if (entity.getId() != null) {
                target = bpmProjectGroupDutyService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "code",
                        "name",
                        "attributes",
                        "description",
                        "isValid"
                });

            } else {
                target = entity;
            }
            Set<BpmDutyPerson> bpmDutyPersonSet = target.getBpmDutyPersons();
            if (bpmDutyPersonSet != null) {
                for (BpmDutyPerson sysDutyPerson : bpmDutyPersonSet) {
                    bpmDutyPersonService.delete(sysDutyPerson);
                }
                bpmDutyPersonService.flush();
            }

            bpmProjectGroupDutyService.save(target);

            if (!StringHelper.isEmpty(personIds)) {
                String[] ids = personIds.split(",");
                for (String id : ids) {
                    BpmDutyPerson bpmDutyPerson = new BpmDutyPerson();
                    SysPerson person = sysPersonService.get(Long.valueOf(id));
                    bpmDutyPerson.setGroupDuty(target);
                    bpmDutyPerson.setPerson(person);
                    bpmDutyPersonService.save(bpmDutyPerson);
                }
            }
            bpmProjectGroupDutyService.save(target);

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
        Set<BpmDutyPerson> bpmDutyPersonSet = bpmProjectGroupDutyService.get(id).getBpmDutyPersons();
        for (BpmDutyPerson bdp : bpmDutyPersonSet) {
            bpmDutyPersonService.delete(bdp.getId());
        }
        bpmProjectGroupDutyService.delete(id);

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
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);
        String xmlAttribute = bpmProjectGroupDuty.getAttributes();
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

        model.addAttribute("bean", bpmProjectGroupDuty);
        model.addAttribute("attrs", attrs);
        return "view/workflow/bpmProjectGroupDuty/setExtAttr";
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


    @RequestMapping
    public void saveExtAttrSetting(HttpServletRequest request, Long id, Model model, HttpServletResponse response) throws JAXBException {
        String[] items = request.getParameterValues("item");

        //得到已定义的attribute,并放入map
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);

        Map<String, Attribute> oldAttributeMap = new HashMap<String, Attribute>();
        Attributes oldAttributes = getAttributesByXml(bpmProjectGroupDuty.getAttributes());
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
        bpmProjectGroupDuty.setAttributes(xml);
        bpmProjectGroupDutyService.save(bpmProjectGroupDuty);

        sendSuccessJSON(response, "保存成功");
    }


    /**
     * @param id            .
     * @param defCode       .
     * @param attributeType .
     * @param expression    .
     * @param model         .
     * @throws JAXBException          .
     * @throws java.lang.reflect.InvocationTargetException
     *                                .
     * @throws ClassNotFoundException .
     * @throws NoSuchMethodException  .
     * @throws IllegalAccessException .
     */
    @RequestMapping
    public String extAttr
    (
            Long id,
            String defCode,
            String attributeType,
            String expression, Model
            model) throws
            JAXBException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        //得到sysProjectGroup对应的所有attribute，并生成tab页所需数据
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);
        String xmlAttribute = bpmProjectGroupDuty.getAttributes();
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
            if (attrDef == null) {
                logger.error("can not find extAttr code:'" + attribute.getCode() + "' in extAttrDef!!");
                continue;
            }
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
                System.out.println(" ********************** ");
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

        model.addAttribute("bean", bpmProjectGroupDuty);
        return "view/workflow/bpmProjectGroupDuty/extAttr";
    }

    private Map<String, ExtAttrDef> getExtAttrDef() {
        //得到系统注册的所有扩展属性，并放入map
        Map<String, ExtAttrDef> extAttrDefMap = new HashMap<String, ExtAttrDef>();
        List<ExtAttrDef> defs = extendAttributeFactory.getAllExtAttrDefList();
        for (ExtAttrDef def : defs) {
            logger.debug("def : {} put to map", def.getCode());
            extAttrDefMap.put(def.getCode(), def);
        }
        return extAttrDefMap;
    }

    @RequestMapping
    public void saveExtAttr
            (HttpServletRequest request, Long id, String defCode, String attributeType, String expression, Model model, HttpServletResponse response) throws
            JAXBException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        String[] itemIds = request.getParameterValues("itemId");

        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);
        String xmlAttribute = bpmProjectGroupDuty.getAttributes();

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
        //save attributes to sysProjectGroupDuty
        String xml = AttributesUtils.saveToXml(attributes);
        bpmProjectGroupDuty.setAttributes(xml);
        //因为是持久化对象，不保存session close 时也会做同步
        bpmProjectGroupDutyService.save(bpmProjectGroupDuty);
//        sysProjectGroupDutyService.flush();
//        expression = URLTransferred(expression);
        sendSuccessJSON(response, "保存成功");
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

        //得到sysProjectGroup对应的所有attribute，并生成tab页所需数据
        BpmProjectGroupDuty bpmProjectGroupDuty = bpmProjectGroupDutyService.get(id);
        String xmlAttribute = bpmProjectGroupDuty.getAttributes();
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
            if (attrDef == null) {
                logger.error("can not find extAttr code:'" + attribute.getCode() + "' in extAttrDef!!");
                continue;
            }
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

            logger.debug("attribute type is {}", attributeType);

            List<ExtAttrItem> extAttrItemList = extAttrManager.getAttrItemList(currentAttribute, extAttrDef);
            logger.debug("extAttrItemList's size is {}", extAttrItemList.size());
            List<Map> extAttrItems = new ArrayList<Map>();
            for (ExtAttrItem extAttrItem : extAttrItemList) {
                Map map = new HashMap();
                map.put("id", extAttrItem.getId());
                map.put("value", extAttrItem.getValue());
                map.put("isChecked", true);
                extAttrItems.add(map);
                System.out.println(" ********************** ");
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

        model.addAttribute("bean", bpmProjectGroupDuty);
        return "view/workflow/bpmProjectGroupDuty/extAttrCheck";

    }

}