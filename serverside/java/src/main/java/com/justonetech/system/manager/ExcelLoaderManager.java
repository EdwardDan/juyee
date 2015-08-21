package com.justonetech.system.manager;

import com.justonetech.core.service.HibernateService;
import com.justonetech.core.utils.DateHelper;
import com.justonetech.core.utils.DateTimeHelper;
import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.*;

/**
 *  该类提供了两种方式以实现Excel文件数据的转化。
 * 【I】Excel文件转实体类(Bean | POJO)
 * 【II】Excel文件转数据库对应表数据（类sql loader）目前支持Oracle
 *
 *  <p> The following example illustrates the usage.
 *
 *  <p>
 *     <blockquote>
 *         <pre>
 *
 *             以信访管理类 OaPetition (oa_petition) 为例
 *
 *             【I】
 *
 *             Excel文件中的中文列头和实体类的英文属性的对应关系
 *
 *             LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
 *             Excel文件中的中文列头
 *
 *             List<String> cnColNames = Arrays.asList(new String[]{"受理编号", "信访来源", "信访人", "收信日期", "创建时间", "经办人对象", "来源代码", "文档对象"});
 *             实体类的英文属性名称
 *
 *             List<String> enColNames = Arrays.asList(new String[]{"code", "sourceDesc", "person", "receiveDate", "createTime", "jbrUser", "source", "doc"});
 *             for (int i = 0; i < cnColNames.size(); i++) {
 *                 fieldMap.put(cnColNames.get(i), enColNames.get(i));
 *             }
 *
 *             实例域为POJO的域名称与该POJO所属类的映射关系   e.g. Excel文件中某个单元格显示SysUser经办人对象的名称，上载的数据转化成SysUser。此种情况映射关系为<jbrUser, SysUser.class>
 *             LinkedHashMap<String, Class<? extends Serializable>> fieldAsPojoClassMap = new LinkedHashMap<String, java.lang.Class<? extends Serializable>>();
 *             fieldAsPojoClassMap.put("jbrUser", SysUser.class);
 *             fieldAsPojoClassMap.put("source", SysCodeDetail.class);
 *             fieldAsPojoClassMap.put("doc", DocDocument.class);
 *
 *             OaPetition_.xls为包含配置查询语句（如需）模板的Excel文件
 *             List<OaPetition> oaPetitions = excelLoaderManager.excelToList(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\OaPetition_.xls")), OaPetition.class, fieldMap, fieldAsPojoClassMap);
 *             logger.debug("The target excel imported resulted in  " + excelLoaderManager.getXlLoadingResultInfo());
 *
 *
 *             【II】
 *
 *             oa_petition表中的英文字段名称（与Excel文件中的中文列头顺序一一对应，自增主键id除外，无需在Excel文件中配置，但需要在fieldTypeMap映射。若无自增主键id，则正常配置。）与字段类型的映射关系
 *
 *             LinkedHashMap<String, Class<?>> fieldTypeMap = new LinkedHashMap<String, Class<?>>();
 *
 *             oa_petition表以id为PK，则必须在映射表中配置id，在Excel文件中无需配置该id列。
 *             若xxx表不以id为PK， 如sys_sequence表之类的，则按照正常方式根据业务需求配置英文字段名称与字段类型的映射关系，Excel文件中的列与该映射关系对应。
 *
 *             String[] columnNames = StringHelper.stringToStringArray("id,code,status_id,status_desc,person,receive_date,jbr_user_id,jbr_name,content,update_time", ",");
 *             Class[] columnClazzs = new Class[]{Long.class, String.class, Long.class, String.class, String.class, java.sql.Date.class, Long.class, String.class, String.class, java.sql.Timestamp.class};
 *             for (int i = 0; i < columnNames.length; i++) {
 *                 fieldTypeMap.put(columnNames[i], columnClazzs[i]);
 *             }
 *
 *             OaPetition2_.xls为包含配置查询语句（如需）模板的Excel文件
 *
 *             excelLoaderManager.excelToDBDataRough(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\OaPetition2_.xls")), "oa_petition", fieldTypeMap);
 *             logger.debug("The target excel imported resulted in  " + excelLoaderManager.getXlLoadingResultInfo());
 *
 *         </pre>
 *     </blockquote>
 *  <p>
 * @author :        WH
 * @version :       1.0.0
 * @revisor:        Stanley
 * @date :          2014-1-2 21:13:21
 * @revision date   2015-08-20
 * @comments :      Excel导入上载处理类
 */
@Service
public class ExcelLoaderManager {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(ExcelLoaderManager.class);

    private static StringBuilder xlLoadingResultInfo = new StringBuilder("Excel文件导入结果：\r\n");

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private SysSequenceManager sysSequenceManager;

    @Autowired
    private HibernateService hibernateService;

    /**
     * 获取Excel载入结果
     *
     * @return
     */
    public String getXlLoadingResultInfo() {
        return xlLoadingResultInfo.toString();
    }

    /**
     * 根据字段名获取字段
     *
     * @param fieldName 字段名
     * @param clazz     包含该字段的类
     * @return 字段
     */
    private Field getFieldByName(String fieldName, Class<?> clazz) {
        Field[] selfFields = clazz.getDeclaredFields();
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }
        return null;
    }

    /**
     * 根据字段名获取字段值
     *
     * @param fieldName 字段名
     * @param o         对象
     * @return 字段值
     */
    private Object getFieldValueByName(String fieldName, Object o) throws Exception {
        Object value;
        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            value = field.get(o);
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
        return value;
    }

    /**
     * 设置实体类的属性 暂时不支持复合主键
     *
     * @param o               实体类对象
     * @param fieldName       字段名
     * @param fieldValue      字段值
     * @param fieldClazz      字段所属类
     * @param alterFieldValue 对应Excel列单元格的批注(sql或者hql语句）
     *                        PK为Long类型的id表采取的方式： sql + hql    查询语句为sql
     *                        PK为非Long类型的id表（不以id为主键）采取的方式：  hql      查询语句为hql
     *                        e.g.1 select scd.id from sys_code sc left join sys_code_detail scd on sc.id = scd.sys_code_id where sc.code = 'OaPetitionType' and name = 'fieldValue')
     *                        e.g.2 from SysSequence where code = 'OAPETITION'
     * @param <T>             字段类所属范型
     * @throws Exception
     */
    private <T extends Serializable> void setFieldValueByName(Object o, String fieldName, Object fieldValue, Class<T> fieldClazz, String alterFieldValue) throws Exception {
        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            //获取字段类型
            Class<?> fieldType = field.getType();
            //根据字段类型为字段赋值
            if (String.class == fieldType) {
                field.set(o, JspHelper.getString(fieldValue));
            } else if (Boolean.TYPE == fieldType || (Boolean.class == fieldType)) {
                //统一boolean类型的字段值在Excel文件中显示为 是 | 否
                field.set(o, StringHelper.isNotEmpty(fieldValue.toString()) ? (StringHelper.equals("是", fieldValue.toString()) ? true : false) : null);
            } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                field.set(o, JspHelper.getInteger(fieldValue));
            } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                field.set(o, JspHelper.getLong(fieldValue));
            } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                field.set(o, JspHelper.getFloat(fieldValue));
            } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(fieldValue.toString()));
            } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                field.set(o, JspHelper.getDouble(fieldValue));
            } else if (Character.TYPE == fieldType) {
                if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
                    field.set(o, Character.valueOf(fieldValue.toString().charAt(0)));
                }
            } else if (java.util.Date.class == fieldType) {
                //统一java.util.Date类型的字段值在Excel文件中显示为yyyy-MM-dd HH:mm:ss格式
                field.set(o, DateHelper.parseUtilDate(JspHelper.getString(fieldValue)));
            } else if (java.sql.Date.class == fieldType) {
                //统一java.sql.Date类型的字段值在Excel文件中显示为yyyy-MM-dd格式
                field.set(o, DateTimeHelper.getDateByString(JspHelper.getString(fieldValue)));
            } else if (Timestamp.class == fieldType) {
                //统一java.sql.Timestamp类型的字段值在Excel文件中显示为yyyy-MM-dd HH:mm:ss格式
                field.set(o, DateHelper.parseTimeStamp(fieldValue.toString()));
            } else if (StringHelper.isNotEmpty(alterFieldValue) && fieldClazz != null) {
                //根据单元格批注提供的查询语句设置实例域为POJO（[sys|biz] domain下的POJO ）的域值
                if (alterFieldValue.contains("from")) {
                    //替换查询语句中的参数fieldValue为单元格内容
                    String queryStatement = alterFieldValue.replace("fieldValue", "" + JspHelper.getString(fieldValue) + "").trim();//// or replacement: new String(alterFieldValue).replace("fieldValue", JspHelper.getString(fieldValue))
                    String requeryStatement = null;
                    if (getFieldByName("id", o.getClass()) != null) {
                        List alterVals = simpleQueryManager.getListBySql(queryStatement);
                        if (alterVals.size() == 1 && alterVals.iterator().next() != null) {
                            Object beanId = alterVals.iterator().next();
                            //若实体类PK非id（需限定PK字段 e.g. code），则仍可以扩展！目前暂不支持！
                            requeryStatement = "from " + fieldClazz.getSimpleName() + " where id = " + JspHelper.getLong(beanId);
                        }
                    } else {
                        // 实际上，不论实体类PK是否为id，它都可以胜任工作，未经测试！
                        requeryStatement = queryStatement;
                    }
                    if (StringHelper.isNotEmpty(requeryStatement)) {
                        List<T> alterPojoInstances = (List<T>) hibernateService.findByQuery(requeryStatement);
                        if (!alterPojoInstances.isEmpty()) {
                            field.set(o, alterPojoInstances.iterator().next());
                        }
                    }
                }
            }
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类没有该字段:  " + fieldName);
        }
    }

    /**
     * 根据数据库对应表的字段类型(映射为Java数据类型)获取字段包装值
     * 注:若需转化原始抽取值以便于存储，则需要编写sql语句，查询对应表主键(id或非id), 该主键类型对应参数columnType。暂时不支持复合主键。
     *
     * @param columnValue      原始抽取值(来源于单元格内容)
     * @param columnType       字段类型
     * @param convertColumnVal 转化数据抽取的sql语句（非hql语句） 注：fieldValue为固定的替换参数名称
     *                         e.g.1  PK为id的表  获取Excel单元格中显示某一系统代码名称的记录id   select scd.id from sys_code sc left join sys_code_detail scd on sc.id = scd.sys_code_id where sc.code = 'OaPetitionType' and name = 'fieldValue'
     *                         e.g.2  PK为非id（e.g. code）的表  获取符合条件的记录code          select code from sys_sequence where lastid = 2757;
     * @return
     */
    private <T> String convertColumnValueByType(String columnValue, Class<T> columnType, String convertColumnVal) {
        try {
            if (StringHelper.isNotEmpty(columnValue)) {
//                logger.debug("columnValue    columnType    ------------->>  " + columnValue + "\t" + columnType.getSimpleName());
                if (StringHelper.isNotEmpty(convertColumnVal)) {
                    if (convertColumnVal.contains("from")) {
                        String queryStatement = convertColumnVal.replace("fieldValue", "" + JspHelper.getString(columnValue) + "").trim();
//                        System.out.println("sql       " + queryStatement);
                        List alterVals = simpleQueryManager.getListBySql(queryStatement);
                        if (alterVals.size() == 1 && alterVals.iterator().next() != null) {
                            Object beanPK = alterVals.iterator().next();
                            return convertColumnValueByType(JspHelper.getString(beanPK), columnType, null);
                        }
                    } else {
                        return "null";
                    }
                } else if (String.class == columnType) {
                    return "\'" + columnValue + "\'";
                } else if (Boolean.TYPE == columnType || (Boolean.class == columnType)) {
                    //统一boolean类型的字段值在Excel文件中显示为 是 | 否
                    return StringHelper.equals("是", columnValue.trim()) ? "true" : "false";
                } else if ((Integer.TYPE == columnType) || (Integer.class == columnType)) {
                    return String.valueOf(JspHelper.getInteger(columnValue));
                } else if ((Long.TYPE == columnType) || (Long.class == columnType)) {
                    return String.valueOf(JspHelper.getLong(columnValue) == 0L ? 0 : JspHelper.getLong(columnValue));
                } else if ((Float.TYPE == columnType) || (Float.class == columnType)) {
                    return String.valueOf(JspHelper.getFloat(columnValue) == 0.0F ? 0 : JspHelper.getFloat(columnValue));
                } else if ((Short.TYPE == columnType) || (Short.class == columnType)) {
                    return String.valueOf(Short.valueOf(columnValue));
                } else if ((Double.TYPE == columnType) || (Double.class == columnType)) {
                    return String.valueOf(JspHelper.getFloat(columnValue) == 0.0D ? 0 : JspHelper.getFloat(columnValue));
                } else if (Character.TYPE == columnType) {
                    return String.valueOf(columnValue.charAt(0));
                } else if (java.sql.Date.class == columnType || java.util.Date.class == columnType || Timestamp.class == columnType) {
                    //统一java.sql.Date、java.util.Date、java.sql.Timestamp类型的字段值在Excel文件中显示为yyyy/MM/dd HH24:mi:ss格式
                    String convertDate = "to_date(\'" + columnValue + "\', \'" + "yyyy/MM/dd HH24:mi:ss" + "\')";
                    return columnType != Timestamp.class ? convertDate : "cast(".concat(convertDate).concat(" as timestamp)");
                } else {
                    return "null";
                }
            } else {
                return "null";
            }
        } catch (Exception e) {
            return "null";
        }
        return "null";
    }

    /**
     * Excel文件转实体类
     *
     * @param in                  Excel文件输入流
     * @param entityClass         Excel文件中每条数据对应的实体类
     * @param fieldMap            Excel文件中的中文列头和实体类的英文属性的对应关系
     * @param fieldAsPojoClassMap 实例域为POJO的域名称与该POJO所属类的映射关系   e.g. Excel文件中某个单元格显示sys_code_detail的名称，上载的数据转化成SysCodeDetail。此种情况映射关系为<sourceCodeDetail, SysCodeDetail.class>
     * @param <T>                 实体类泛型
     * @return
     * @throws Exception
     */
    public <T> List<T> excelToList(InputStream in, Class<T> entityClass, LinkedHashMap<String, String> fieldMap, LinkedHashMap<String, Class<? extends Serializable>> fieldAsPojoClassMap) throws Exception {
        List<T> resultList = new ArrayList<T>();
        try {
            Workbook wb = Workbook.getWorkbook(in);
            Sheet sheet = wb.getSheet(0);
            //获取工作表的有效行数    首行为标题行   其余为数据行
            int realRows = 0;
            for (int i = 0; i < sheet.getRows(); i++) {
                int nullCols = 0;
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell currentCell = sheet.getCell(j, i);
                    if (currentCell == null || StringHelper.isEmpty(currentCell.getContents())) {
                        nullCols++;
                    }
                }
                if (nullCols == sheet.getColumns()) {
                    break;
                } else {
                    realRows++;
                }
            }
            //如果Excel没有任何有效数据，终止数据读取转化。
            if (realRows <= 1) {
                throw new Exception("该Excel文件没有任何数据！");
            }
            //标题行
            Cell[] firstRow = sheet.getRow(0);
            String[] excelFieldNames = new String[firstRow.length];
            //Excel中的列名
            for (int i = 0; i < firstRow.length; i++) {
                excelFieldNames[i] = JspHelper.getString(firstRow[i].getContents().trim());
            }
            //判断所需字段在Excel中是否都存在
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fieldMap.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }
            if (!isExist) {
                throw new Exception("该Excel文件缺少必要的列名，或列名有误！");
            }
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < excelFieldNames.length; i++) {
                colMap.put(excelFieldNames[i], firstRow[i].getColumn());
            }
            for (int i = 1; i < realRows; i++) {
                //待转换对象
                T entity = entityClass.newInstance();
                StringBuilder failureMsg = new StringBuilder("第" + i + "条记录的 ");
                //赋值对象字段
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    //获取中文字段名（即列名）
                    String cnNormalName = entry.getKey();
                    //获取英文字段名 （实体类属性名称）
                    String enNormalName = entry.getValue();
                    //根据中文字段名获取列号
                    int col = colMap.get(cnNormalName);
                    Cell cell = sheet.getCell(col, i);
                    //获取当前单元格中的内容
                    String content = cell.getContents().toString().trim();
                    //获取当前单元格所在列的标题头批注
                    String comment = firstRow[col].getCellFeatures() != null ? JspHelper.getString(firstRow[col].getCellFeatures().getComment()) : null;
                    try {
                        try {
                            setFieldValueByName(entity, enNormalName, content, comment != null ? fieldAsPojoClassMap.get(enNormalName) : null, comment);
                        } catch (Exception e) {
                            content = e.getMessage();
                        }
                        if (StringHelper.isNotEmpty(content) && getFieldValueByName(enNormalName, entity) == null) {
                            failureMsg.append(" 【" + cnNormalName + "】 ");
                        }
                    } catch (Exception e) {
                        if (!failureMsg.toString().contains("【")) {
                            failureMsg.append(" 【" + cnNormalName + "】 ");
                            xlLoadingResultInfo.append(failureMsg.toString() + "\r\n");
                        }
                        continue;
                    }
                }
                if (failureMsg.toString().contains("【")) {
                    failureMsg.append(" 未被成功导入！");
                    xlLoadingResultInfo.append(failureMsg.toString() + "\r\n");
                } else {
                    failureMsg.delete(0, failureMsg.length());
                }
                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导入Excel失败", e);
            if (!xlLoadingResultInfo.toString().contains("【")) {
                xlLoadingResultInfo.append("发生异常！请检查上载数据！");
            }
            throw new Exception("导入Excel失败");
        }
        if (!xlLoadingResultInfo.toString().contains("【")) {
            xlLoadingResultInfo.append("成功！");
        }
        return resultList;
    }

    /**
     * Excel文件转数据库对应表数据（类sql loader）目前支持Oracle
     *
     * @param in           Excel文件输入流
     * @param tableName    数据库对应表
     * @param fieldTypeMap 对应 表中的英文字段名称（与Excel文件中的中文列头顺序一一对应，自增主键id除外，无需在Excel文件中配置，但需要在fieldTypeMap映射。若无自增主键id，则正常配置。）与字段类型的映射关系
     *                     fieldTypeMap亦可扩展为由形参columnNamesStr与Excel标题行单元格批注columnType关联构建，目前不支持这种方式。
     */
    public synchronized void excelToDBDataRough(InputStream in, String tableName, LinkedHashMap<String, Class<?>> fieldTypeMap) {
        try {
            Workbook wb = Workbook.getWorkbook(in);
            Sheet sheet = wb.getSheet(0);
            //获取工作表的有效行数
            int realRows = 0;
            List<String> columnNames = new ArrayList<String>(fieldTypeMap.keySet());
            boolean isPkId = columnNames.contains("id");
            //fieldTypeMap中的配置必须满足注释要求
            if ((isPkId ? sheet.getColumns() + 1 : sheet.getColumns()) == fieldTypeMap.keySet().size()) {
                String columnNamesStr = StringHelper.stringArrayToString(columnNames.toArray(new String[columnNames.size()]), ",");
                Cell[] titleRow = null;
                for (int i = 0; i < sheet.getRows(); i++) {
                    int nullCols = 0;
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        Cell currentCell = sheet.getCell(j, i);
                        if (currentCell == null || StringHelper.isEmpty(currentCell.getContents())) {
                            nullCols++;
                        }
                    }
                    if (nullCols == sheet.getColumns()) {
                        if (i != 0) {
                            continue;
                        }
                        break;
                    } else {
                        realRows++;
                        if (titleRow == null) {
                            titleRow = sheet.getRow(0);
                        }
                        if (i != 0) {//首行为标题行
                            StringBuilder toDBDataSql = new StringBuilder("insert into ".concat(tableName).concat(" (").concat(columnNamesStr.substring(0, columnNamesStr.length() - 1)).concat(") values ("));
                            if (isPkId) {//对应表以id为PK
                                Integer maxId = simpleQueryManager.getIntegerBySql("select max(id) from ".concat(tableName)).intValue() + 1;
//                                logger.debug("maxId             ~~~~~~~~    " + maxId.toString());
                                toDBDataSql.append(convertColumnValueByType(maxId.toString(), Long.class, null).concat(","));
                            }
                            for (int k = 0; k < sheet.getColumns(); k++) {
                                Cell curCell = sheet.getCell(k, i);
                                //获取当前单元格所在列的标题头批注
                                String comment = titleRow[k].getCellFeatures() != null ? JspHelper.getString(titleRow[k].getCellFeatures().getComment()) : null;
                                String wrappedValue = convertColumnValueByType(curCell.getContents().trim(), fieldTypeMap.get(columnNames.get(isPkId ? k + 1 : k)), comment);
//                                logger.debug("wrappedValue          " + wrappedValue);
                                toDBDataSql.append(wrappedValue.concat(k != sheet.getColumns() - 1 ? ", " : ")"));
                            }
//                            logger.debug("toDBDataSql       ############### " + toDBDataSql.toString());
                            try {
                                hibernateService.executeBySql(toDBDataSql.toString());
//                              sysSequenceManager.updateMaxRecord(sequences, className, tableName);
                            } catch (Exception e) {
                                xlLoadingResultInfo.append("第" + i + "条记录导入失败！" + "\r\n");
                                logger.error("An error occured while inserting a record into ".concat(tableName), e);
                                continue;
                            }
                        }
                    }
                }
                //如果Excel中没有数据则提示错误
                if (realRows <= 1) {
                    xlLoadingResultInfo.append("未导入任何数据！");
                } else if (!xlLoadingResultInfo.toString().contains("失败")) {
                    xlLoadingResultInfo.append("成功！");
                };
                Map<String, String> pojo2Tables = sysSequenceManager.getTables();
                int tableIdx = new ArrayList<String>(pojo2Tables.values()).indexOf(tableName.toUpperCase());
                if (tableIdx > 0 && tableIdx < pojo2Tables.keySet().size()) {
                    sysSequenceManager.updateMaxRecord(sysSequenceManager.findAllSysSequence(), new ArrayList<String>(pojo2Tables.keySet()).get(tableIdx), tableName.toUpperCase());
                }
            }
        } catch (Exception e) {
            if (!xlLoadingResultInfo.toString().contains("失败")) {
                xlLoadingResultInfo.append("发生异常！请检查上载数据！");
            }
        }
    }
}