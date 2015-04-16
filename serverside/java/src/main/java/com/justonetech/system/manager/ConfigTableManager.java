package com.justonetech.system.manager;

import com.justonetech.core.orm.log.ITableConfigService;
import com.justonetech.core.orm.log.TableLogConfig;
import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.ConfigTableService;
import com.justonetech.system.domain.ConfigTable;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.hibernate.EntityMode;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: tcg
 * Date: 2011-11-6
 * Time: 13:21:14
 */
@Service
public class ConfigTableManager implements ITableConfigService {
    @Autowired
    private ConfigTableService configTableService;

    @Autowired
    private HibernateService hibernateService;

    /**
     * 通过类名获取表日志配置信息
     *
     * @param className
     * @return
     */
    public ConfigTable getByClassName(String className) {
        String hql = "from ConfigTable t where className ='" + className + "' ";

        List<ConfigTable> list = configTableService.find(hql);

        if (list != null) {
            return list.get(0);
        }

        return null;
    }

    /**
     * 通过表名获取表日志配置信息
     *
     * @param tableName
     * @return
     */
    public ConfigTable getByTableName(String tableName) {
        String hql = "from ConfigTable t where tableName ='" + tableName + "' ";

        List<ConfigTable> list = configTableService.find(hql);

        if (list != null) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public Map<String, TableLogConfig> getAllConfig() {
        Map<String, TableLogConfig> map = new HashMap<String, TableLogConfig>();

        String hql = "from ConfigTable t where isLog = '1' order by tableName asc";

        List<ConfigTable> list = configTableService.find(hql);

        for (ConfigTable tmp : list) {
            map.put(tmp.getClassName(), tmp);
        }

        return map;
    }

    /**
     * 得到所有业务类名及中文表名
     *
     * @return
     */
    public List<Map> getAllBizClass() {
        List<Map> bizClasses = new ArrayList<Map>();
        Map<String, String> comments = getComments();
        Map allClassMetadata = hibernateService.getSession().getSessionFactory().getAllClassMetadata();
        for (Object key : allClassMetadata.keySet()) {
            Object value = allClassMetadata.get(key);
            if (value instanceof AbstractEntityPersister) {
                AbstractEntityPersister abstractEntityPersister = (AbstractEntityPersister) value;
                Class clazz = abstractEntityPersister.getMappedClass(EntityMode.POJO);
                String packageName = clazz.getPackage().getName();
                if (packageName.endsWith("domain")) {
                    Map<String, String> bizClass = new HashMap<String, String>();
                    String tableName = abstractEntityPersister.getTableName().toUpperCase();
                    String comment = comments.get(tableName);
                    bizClass.put("tableName", tableName);
                    if (StringHelper.isEmpty(comment)) {
                        comment = tableName;
                    }
//                    System.out.println();
                    bizClass.put("comment", comment);
                    bizClass.put("allClassName", clazz.getSimpleName());
                    bizClass.put("className",clazz.getCanonicalName());


                    bizClasses.add(bizClass);
                }
            }
        }
        //顺序
        Comparator mycmp = ComparatorUtils.NATURAL_COMPARATOR;
        ArrayList<Object> sortFields = new ArrayList<Object>();
        //按字段submitTime排序
        sortFields.add(new BeanComparator("className", mycmp));
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(bizClasses, multiSort);
        return bizClasses;
    }

    /**
     * 从数据库中获取表名和注释
     *
     * @return
     */
    public Map<String, String> getComments() {
        Map<String, String> comments = new HashMap<String, String>();
        String sql = "select u.table_name,u.comments from user_tab_comments u";
        List<Object[]> list = hibernateService.findBySql(sql);
        for (Object[] objects : list) {
            String tableName = (String) objects[0];
            String comment = (String) objects[1];
            if (comment == null) {
                comment = tableName;
            }
            comments.put(tableName, comment);
        }
        return comments;
    }

}