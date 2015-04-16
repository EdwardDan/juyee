package com.justonetech.system.manager;

import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.StringHelper;
import org.hibernate.EntityMode;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用于维护sys_sequence的类
 * User: Chen Junping
 * Date: 12-3-27
 */
@Service
public class SysSequenceManager {
    private Logger logger = LoggerFactory.getLogger(SysSequenceManager.class);

    @Autowired
    private HibernateService hibernateService;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    /**
     * 从数据库中获取表名和注释
     */
    public Map<String, String> getComments() {
        Map<String, String> comments = new HashMap<String, String>();
        String sql = "select u.table_name,u.comments from user_tab_comments u";
        List<Object[]> list = hibernateService.findBySql(sql);
        for (Object[] objects : list) {
            String tableName = (String) objects[0];
            String comment = (String) objects[1];
            if (null == comment) {
                comment = tableName;
            }
            comments.put(tableName, comment);
        }
        return comments;
    }

    /**
     * 获得domain中实体和数据库中表的对应关系
     *
     * @return
     */
    public Map<String, String> getTables() {
        Map<String, String> tables = new HashMap<String, String>();
        Map allClassMetadata = hibernateService.getSession().getSessionFactory().getAllClassMetadata();
        for (Object key : allClassMetadata.keySet()) {
            Object value = allClassMetadata.get(key);
            if (value instanceof AbstractEntityPersister) {
                AbstractEntityPersister abstractEntityPersister = (AbstractEntityPersister) value;
                Class clazz = abstractEntityPersister.getMappedClass(EntityMode.POJO);
                String packageName = clazz.getPackage().getName();
                if(packageName.startsWith("com.justonetech.") && packageName.endsWith("domain")){
                    String tableName = abstractEntityPersister.getTableName().toUpperCase();

                    tables.put(clazz.getSimpleName(), tableName);
                }
            }
        }

        //排序
        ArrayList<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(tables.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> arg0,
                               Map.Entry<String, String> arg1) {
                return arg0.getValue().compareTo(arg1.getValue());
            }
        });
        Map<String, String> newMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> aList : list) {
            newMap.put(aList.getKey(), aList.getValue());
        }
        return newMap;
    }

    /**
     * 获取sys_sequence表中的所有记录
     *
     * @return  。
     */
    public Map<String, Long> findAllSysSequence() {
        Map<String, Long> map = new HashMap<String, Long>();
        String sql = "select s.code,s.lastid from sys_sequence s";
        List<Object[]> list = hibernateService.findBySql(sql);
        for (Object[] objects : list) {
            String code = (String) objects[0];
            Long lastid = 0L;
            if (null != objects[1]) {
                lastid = Long.valueOf(objects[1].toString());
            }
            map.put(code, lastid);
        }
        return map;
    }

    /**
     * 更新最大记录数
     *
     * @param sequences  。
     * @param className  。
     * @param tableName  。
     */
    public void updateMaxRecord(Map<String, Long> sequences, String className, String tableName) {
        try {
            String sql = "select max(id) from " + tableName;
            String maxId = simpleQueryManager.getStringBySql(sql);

            String code = className.toUpperCase();
            Long sequenceId = sequences.get(code);
            if (!StringHelper.isEmpty(maxId)) {
                Long lastId = Long.valueOf(maxId) + 1;
                String updateSql;
                if (null == sequenceId) {
                    updateSql = "insert into sys_sequence(code,lastid) values('" + code + "'," + lastId + ")";
                    logger.debug("execute sql11:{}", updateSql);
                    hibernateService.executeBySql(updateSql);
                } else if (lastId > sequenceId) {
                    updateSql = "update sys_sequence set lastId=" + lastId + " where code='" + code + "'";
                    logger.debug("execute sql:{}", updateSql);
                    hibernateService.executeBySql(updateSql);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error:" + e.getMessage());
            logger.error("update table '" + tableName + "' has failed!!");
        }
    }
}
