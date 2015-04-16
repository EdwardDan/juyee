package com.justonetech.biz.utils.jbpm.extattr;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @author: lerry
 * @date: 2009-3-27
 */
public class ExtAttrItems {
    private static final Log log = LogFactory.getLog(ExtAttrItems.class);

    List<Serializable> items;

    String property;

    public ExtAttrItems() {
    }

    public ExtAttrItems(List<Serializable> items, String property) {
        this.items = items;
        this.property = property;
    }

    public List<Serializable> getItems() {
        return items;
    }

    public void setItems(List<Serializable> items) {
        this.items = items;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Set getIds() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return getValues("id");

    }

    public Set getValues() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return getValues(property);

    }

    public Set getValues(String property) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Set ret = new HashSet();

        if (items != null)
        {
            for (Serializable serializable : items) {
                ret.add(PropertyUtils.getSimpleProperty(serializable, property));
            }
        }

        return ret;
    }

    public List<ExtAttrItem> list() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ExtAttrUtils.Objects2AttributeItems(items,property);
    }

}
