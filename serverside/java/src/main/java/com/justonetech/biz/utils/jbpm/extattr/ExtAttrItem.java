package com.justonetech.biz.utils.jbpm.extattr;

import org.apache.commons.beanutils.PropertyUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class ExtAttrItem implements Serializable{
    Long id;
    String value;
    Serializable object;

    public ExtAttrItem(Long id, String value, Serializable object) {
        this.id = id;
        this.value = value;
        this.object = object;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getValue(String property) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return PropertyUtils.getSimpleProperty(object,property);
    }

    public Serializable getObject() {
        return object;
    }

    public void setObject(Serializable object) {
        this.object = object;
    }

    @Override
    public String toString() {
        org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
		builder.append(id);
		builder.append(value);
		return builder.toString();
    }
}
