package com.justonetech.biz.core.orm.hibernate;

import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.ui.UIHelper;
import com.justonetech.core.utils.StringHelper;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author Ma Ji
 */
public class GridJq {

    /**
     * 根据列名和page转json
     *
     * @param columnNames .
     * @param page        .
     * @return .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    public static String toJSON(String columnNames, Page page) throws Exception {
        List<Map> list = getGridValue(page.getRows(), columnNames);
        return toJSON(list, page);
    }

    /**
     * 添加jqGrid所必需的页面信息
     *
     * @param list .
     * @param page .
     * @return .
     */
    public static Map addPageInfo(List list, Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotalPages());
        map.put("page", page.getPage());
        map.put("records", page.getRecords());
        map.put("rows", list);
        return map;
    }

    public static String toJSON(List list, Page page) {
        return new JSONSerializer().exclude("*.class").include("rows").transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"), Date.class)
                .serialize(addPageInfo(list, page));
    }

    @SuppressWarnings("unchecked")
    public static List<Map> getGridValue(Collection col, String columnNames)
            throws Exception {
        String[] column_names = UIHelper.string2Array(columnNames);
        List<Map> valueList = new ArrayList<Map>();
        for (Object aList : col) {
            valueList.add(getRowValue(aList, column_names));
        }
        return valueList;
    }

    /**
     * 获得obj属性columnName的值.
     *
     * @param obj        .
     * @param columnName .
     * @return .
     * @throws Exception .
     */
    public static String getColumnValue(Object obj, String columnName) {
        String rel = "";
        columnName = columnName.trim();

        Object value = null;
        try {
            value = PropertyUtils.getNestedProperty(obj, columnName);
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        } catch (NestedNullException e) {
            value = null;
        }
        if (value != null) {
            rel = value.toString();
        }

        //注意以下这段是与ext的显示有关系
        if (!StringHelper.isEmpty(rel)) {
            //把回车换行做一个替换，到页面要plugin再替换过来
            rel = rel.replaceAll("\r\n", "<br/>");
            rel = rel.replaceAll("\r", "<br/>");
            rel = rel.replaceAll("\n", "<br/>");
            //把数据里的单引号替换成反斜杠加单引号，这样ext可以直接显示为单引号
            rel = StringHelper.findAndReplace(rel, "\'", "\\\'");
        }
        return rel;
    }

    public static Map<String, String> getRowValue(Object obj, String[] columnNames) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (String columnName : columnNames) {
            map.put(columnName, getColumnValue(obj, columnName));
        }
        return map;
    }
}
