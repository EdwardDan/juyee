package com.justonetech.biz.utils.jbpm.extattr;

import com.justonetech.biz.utils.jbpm.extattr.definition.ExtAttrDef;
import com.justonetech.biz.utils.jbpm.extattr.instance.Attribute;
import com.justonetech.biz.utils.jbpm.extattr.instance.Values;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ExtAttrUtils {
    public static String getFetchFullHql(Attribute attribute, ExtAttrDef extAttrDef) throws ClassNotFoundException {
        StringBuffer hql = new StringBuffer();

        String from = extAttrDef.getFetchHqlFrom();
        if (StringUtils.isBlank(from)) {
            log.debug("class name is " + extAttrDef.getClassName());
            Class clazz = Class.forName(extAttrDef.getClassName());
            from = "select a from " + clazz.getSimpleName() + " as a";
        } else if (from.toUpperCase().indexOf("FROM") < 0) //can not find from keyword
        {
            from = "select a from " + from;
        }

        String where = extAttrDef.getFetchHqlWhere();
        if (StringUtils.isBlank(where)) {
            where = "where 1=1";
        } else if (where.toUpperCase().indexOf("WHERE") < 0) //can not find from keyword
        {
            where = "where " + where;
        }


        String orderBy = extAttrDef.getFetchHqlOrderBy();
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "order by a.id";
        } else if (orderBy.toUpperCase().indexOf("ORDER BY") < 0) //can not find from keyword
        {
            orderBy = "order by " + orderBy;
        }

        //expression 则直接作为hql
        if (attribute.getAll() != null) {
            hql.append(from).append(" ");
            hql.append(where).append(" ");
            hql.append(orderBy);
        } else if (attribute.getNone() != null) {
            hql.append(from).append(" ");
            hql.append(where).append(" ").append("and 1=2").append(" ");
            hql.append(orderBy);
        } else if (attribute.getValues() != null) {
            hql.append(from).append(" ");
            hql.append(where).append(" ");
            Values values = attribute.getValues();
            if (values != null && values.getValue().size() > 0) {
                hql.append("and a.id in(");

                List<Long> ids = values.getValue();
                String s = ArrayUtils.toString(ids);
                s = s.substring(1, s.length() - 1);

                hql.append(s).append(")").append(" ");
            } else {
                hql.append("and 1=2");
            }
            hql.append(orderBy);
        } else if (attribute.getExpression() != null) {
            //user set expression to ""
            if ("".equals(attribute.getExpression().trim())) {
                hql.append(from).append(" ");
                hql.append(where).append(" ").append("and 1=2").append(" ");
                hql.append(orderBy);
            } else {
                //user give a full hql
                if (attribute.getExpression().toUpperCase().indexOf("FROM") >= 0) {
                    hql.append(attribute.getExpression());
                } else {
                    //only where given
                    hql.append(from).append(" ");
                    hql.append(where).append(" ");
                    hql.append("and").append(" ").append(attribute.getExpression()).append(" ");
                    hql.append(orderBy);
                }
            }
        }

        log.debug("hql:" + hql.toString());

        return hql.toString();
    }

    public static List<ExtAttrItem> Objects2AttributeItems
            (List<Serializable> serializables, String
                    properyName) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<ExtAttrItem> ret = new ArrayList<ExtAttrItem>(serializables.size());
        for (int i = 0; i < serializables.size(); i++) {
            Serializable serializable = serializables.get(i);
            Long id = (Long) PropertyUtils.getSimpleProperty(serializable, "id");
            String value = (String) PropertyUtils.getSimpleProperty(serializable, properyName);
            ret.add(new ExtAttrItem(id, value, serializable));
        }
        return ret;
    }

    private static final Log log = LogFactory.getLog(ExtAttrUtils.class);
}
