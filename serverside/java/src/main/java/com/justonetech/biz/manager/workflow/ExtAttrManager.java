package com.justonetech.biz.manager.workflow;

import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItem;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrUtils;
import com.justonetech.biz.utils.jbpm.extattr.ExtendAttributeFactory;
import com.justonetech.biz.utils.jbpm.extattr.ExtAttrItems;
import com.justonetech.biz.utils.jbpm.extattr.definition.ExtAttrDef;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attribute;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attributes;
import com.justonetech.biz.utils.jbpm.extattr.instance.AttributesUtils;
import com.justonetech.core.service.HibernateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * User: Chen Junping
 * Date: 12-5-3
 */
@Service
public class ExtAttrManager {
    private static final Log log = LogFactory.getLog(ExtAttrManager.class);

//    @Autowired
//    private ExtendAttributeFactory extendAttributeFactory;

    private static ExtendAttributeFactory extendAttributeFactory;

    public static void setExtendAttributeFactory(ExtendAttributeFactory extendAttributeFactory) {
        ExtAttrManager.extendAttributeFactory = extendAttributeFactory;
    }

    @Autowired
    private HibernateService hibernateService;

    public List<ExtAttrItem> getAttrItemList(Attribute attribute, ExtAttrDef extAttrDef) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return getExtAttrItems(attribute, extAttrDef).list();
    }

    public ExtAttrItems getExtAttrItems(Attribute attribute, ExtAttrDef extAttrDef) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<Serializable> serializables;
        //none 则返回一个空的list
        if (attribute.getNone() != null) {
            serializables = new ArrayList<Serializable>(0);
        } else {

            String hql = ExtAttrUtils.getFetchFullHql(attribute, extAttrDef);

            //add project condition if the hql contains {:projectid}
//            hql = hql.replaceAll(":projectid", CurrentProject.getProjectId() + "");

            //todo 过滤器先打开，不然在单项目下显示了所有项目的合同段
            //hql已存在project id的过滤，所以要关闭filter
//            FilterBeforeOperator.closeFilter();
            serializables = hibernateService.findByQuery(hql);
            log.debug("hql:" + hql);
//            FilterBeforeOperator.openFilter();
        }
        return new ExtAttrItems(serializables, extAttrDef.getClassProperty());
    }

    public List<ExtAttrItem> getAttrItemList(Attribute attribute) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ExtAttrDef extAttrDef = extendAttributeFactory.getExtAttrDef(attribute.getCode());
        return getAttrItemList(attribute, extAttrDef);
    }

    public ExtAttrItems getExtAttrItems(Attribute attribute) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ExtAttrDef extAttrDef = extendAttributeFactory.getExtAttrDef(attribute.getCode());

        return getExtAttrItems(attribute, extAttrDef);
    }

    public ExtAttrItems getExtAttrItems(String attributesXml, String extAttrName) throws JAXBException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Attributes attributes = AttributesUtils.loadFromXml(attributesXml);
        Attribute attribute = AttributesUtils.getAttribute(attributes, extAttrName);
        return getExtAttrItems(attribute);
    }

    public List<ExtAttrItem> getUnCheckedExtAttrItems(Attribute attribute, ExtAttrDef extAttrDef) throws InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        List<ExtAttrItem> ret = new ArrayList<ExtAttrItem>();

        List<ExtAttrItem> checkedExtAttrItems = getAttrItemList(attribute, extAttrDef);
        attribute.setValues(null);
        attribute.setAll(true);
        List<ExtAttrItem> allExtAttrItems = getAttrItemList(attribute, extAttrDef);
        Map<Long, ExtAttrItem> checkedAttrDefMap = new HashMap<Long, ExtAttrItem>();
        for (ExtAttrItem extAttrItem : checkedExtAttrItems) {
            checkedAttrDefMap.put(extAttrItem.getId(), extAttrItem);

        }
        for (ExtAttrItem extAttrItem : allExtAttrItems) {
            if (checkedAttrDefMap.get(extAttrItem.getId()) == null) {
                ret.add(extAttrItem);
            }
        }

        return ret;
    }
}
