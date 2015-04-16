package com.justonetech.biz.utils.SyncData;

import com.justonetech.core.utils.JspHelper;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: dai
 * Date: 12-1-5
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class ResultSetSync {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    boolean isTestMode = false;

    public ResultSetSync(boolean testMode) {
        isTestMode = testMode;
    }

    /**
     * 记录日志
     *
     * @param message 日志信息
     */
    public void log(String message) {
//        System.out.println("message = " + message);
        logger.info(message);
    }

    /**
     * 单个表同步入口
     *
     * @param srcCon   源数据库连接
     * @param srcSql   源同步SQL
     * @param dstCon   目标连接
     * @param dstSql   目标数据库SQL
     * @param dstTable 目标表
     * @throws SQLException
     */
    public void sync(Connection srcCon, String srcSql, Connection dstCon, String dstSql, String dstTable) throws SQLException {
        log("****************表:" + dstTable + " 开始同步!*********************");

        Statement srcStmt = srcCon.createStatement();
        ResultSet srcRst = srcStmt.executeQuery(srcSql);

        Statement dstStmt = dstCon.createStatement();
        ResultSet dstRst = dstStmt.executeQuery(dstSql);

        //获取目标数据库主键
        String[] keys = getKeys(dstCon, dstTable);
        //获取源表与目标表匹配的列
        String[] matchColumns = getMatchColumns(srcRst, dstRst);

        dstCon.setAutoCommit(true);
        long insertNum = 0;    //记录同步操作的个数
        long updateNum = 0;
        long delNum = 0;

        //源表和目标表根据主键大小进行游标移动做增，删，改同步
        if (!srcRst.isAfterLast() && !dstRst.isAfterLast()) {
            srcRst.next();
            dstRst.next();
            if (dstRst.isClosed()) {
                do {
                    doInsert(dstCon, dstTable, srcRst, matchColumns, keys);
                    insertNum++;
                } while (srcRst.next());
            } else {
                while (true) {
                    //比较主键
                    int compareValue = compareKeys(srcRst, dstRst, keys);
                    if (compareValue == 0)  //equals
                    {
                        //do update if needed                  比较每个数据库字段，如果出现不同字段则update
                        String[] updateColumns = getNotMatchColumnByValues(srcRst, dstRst, matchColumns);
                        if (updateColumns.length > 0) {
                            doUpdate(dstCon, dstTable, srcRst, keys, updateColumns);
                            updateNum++;
                        }
                        boolean srcLast = srcRst.next();
                        boolean dstLast = dstRst.next();
                        if (!srcLast) break;
                        if (!dstLast) break;
                    } else if (compareValue < 0) {
                        //do insert
                        System.out.println("dstTable = " + dstTable);
                        doInsert(dstCon, dstTable, srcRst, matchColumns, keys);
                        insertNum++;
                        if (!srcRst.next()) break;

                    } else if (compareValue > 0) {
                        //do delete
                        doDelete(dstCon, dstTable, dstRst, keys);
                        delNum++;
                        if (!dstRst.next()) break;
                    }
                }

                while (!srcRst.isAfterLast()) {
                    //do insert
                    doInsert(dstCon, dstTable, srcRst, matchColumns, keys);
                    insertNum++;
                    if (!srcRst.next()) break;
                }

                while (!dstRst.isAfterLast()) {
                    doDelete(dstCon, dstTable, dstRst, keys);
                    delNum++;
                    if (!dstRst.next()) break;
                }
            }
        }

        dstRst.close();
        srcStmt.close();

        dstRst.close();
        dstStmt.close();

        log("同步" + dstTable + "表,共插入" + insertNum + " ,修改" + updateNum + " ,删除" + delNum);
        log("*************表" + dstTable + "同步结束!*********************");
    }

    /**
     * 更新操作
     *
     * @param dstCon        源数据库链接
     * @param dstTable      目标表
     * @param srcRst        源数据集
     * @param keys          主键
     * @param updateColumns 需要更新的列
     * @throws SQLException
     */
    private void doUpdate(Connection dstCon, String dstTable, ResultSet srcRst, String[] keys, String[] updateColumns) throws SQLException {
//        System.out.println("do update.....");
        logKeyDetails(keys, srcRst, " update");
        String sql = getUpdateSql(dstTable, updateColumns, keys);
        PreparedStatement preparedStatement = dstCon.prepareStatement(sql);
        for (int i = 0; i < updateColumns.length; i++) {
            String updateColumnName = updateColumns[i];
            Object srcObj = srcRst.getObject(updateColumnName);
            if (srcObj instanceof net.sourceforge.jtds.jdbc.ClobImpl) {  //jtds会把sqlserver的text字段映射成clob字段，sqljdbc不会
                preparedStatement.setClob(i + 1, ((Clob) srcObj).getCharacterStream());
            } else {
                preparedStatement.setObject(i + 1, srcObj);
            }
        }

        for (int i = 0; i < keys.length; i++) {
            preparedStatement.setObject(updateColumns.length + i + 1, srcRst.getObject(keys[i]));
        }
        if (!isTestMode) preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    /**
     * 插入方法
     *
     * @param dstCon       目标数据库链接
     * @param dstTable     目标表
     * @param srcRst       源数据集
     * @param matchColumns 匹配列
     * @param keys         主键
     * @throws SQLException
     */
    private void doInsert(Connection dstCon, String dstTable, ResultSet srcRst, String[] matchColumns, String[] keys) throws SQLException {
//        System.out.println("do insert.....");
        logKeyDetails(keys, srcRst, " insert");
        String sql = getInsertSql(dstTable, matchColumns);
        PreparedStatement preparedStatement = dstCon.prepareStatement(sql);
        String values = "";
        for (int i = 0; i < matchColumns.length; i++) {
            String insertColumnName = matchColumns[i];
            Object srcObj = srcRst.getObject(insertColumnName);

            //特殊处理：解决xmhtdj表中主键wsslbh为空格时无法插入
            Boolean isKey = false;
            for (String key : keys) {
                if (key.toUpperCase().equals(insertColumnName.toUpperCase())) {
                    isKey = true;
                    break;
                }
            }
            if (isKey && "".equals(JspHelper.getString(srcObj))) {
                srcObj = " ";
            }
            values += ",'"+srcObj+"'";
            if (srcObj instanceof net.sourceforge.jtds.jdbc.ClobImpl) {  //jtds会把sqlserver的text字段映射成clob字段，sqljdbc不会
                preparedStatement.setClob(i + 1, ((Clob) srcObj).getCharacterStream());
            } else {
                preparedStatement.setObject(i + 1, srcObj);
            }
        }
//        System.out.println(".............sql = " + sql+"|"+values.substring(1));
        if (!isTestMode) {
            int ret = 0;
            try {
                ret = preparedStatement.executeUpdate();
            } catch (SQLException e) {

            }
            System.out.println("ret = " + ret);
        }
        preparedStatement.close();
    }

    /**
     * 删除操作
     *
     * @param dstCon   目标数据库链接
     * @param dstTable 目标表
     * @param dstRst   目标数据集
     * @param keys     主键
     * @throws SQLException
     */
    private void doDelete(Connection dstCon, String dstTable, ResultSet dstRst, String[] keys) throws SQLException {
//        System.out.println("do delete.....");
        logKeyDetails(keys, dstRst, " delete");
        String sql = getDeleteSql(dstTable, keys);
        PreparedStatement preparedStatement = dstCon.prepareStatement(sql);
        for (int i = 0; i < keys.length; i++) {
            String keyColumn = keys[i];
            preparedStatement.setObject(i + 1, dstRst.getObject(keyColumn));
        }
        if (!isTestMode) preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    /**
     * 记录同步了的行的主键
     *
     * @param keys 主键
     * @param rs   数据集
     * @param type 同步类型
     * @throws SQLException
     */
    private void logKeyDetails(String[] keys, ResultSet rs, String type) throws SQLException {
        String keyDetails = type + " :   ";
        for (String key : keys) {
            keyDetails += (key + " : " + rs.getObject(key) + ", ");
        }
        log(keyDetails);
    }

    /**
     * 获取主键
     *
     * @param dstCon       目标数据库连接
     * @param dstTableName 目标表
     * @return .
     * @throws SQLException
     */
    public String[] getKeys(Connection dstCon, String dstTableName) throws SQLException {
        String schema = null;
        //用于sqlserver中ShareJgb.tab_share_cfbzbdw类型的表
        if (dstTableName.contains(".")) {
            String[] temp = dstTableName.split("\\.");
            schema = temp[0];
            dstTableName = temp[1];
        }
        ResultSet primaryKeys = dstCon.getMetaData().getPrimaryKeys(null, schema, dstTableName);
        List<String> keys = new ArrayList<String>();
        while (primaryKeys.next()) {
            keys.add(primaryKeys.getString("COLUMN_NAME"));
        }
        primaryKeys.close();
        return keys.toArray(new String[keys.size()]);
    }

    /**
     * 比较行中的列
     *
     * @param srcRst  源数据集
     * @param dstRst  目标数据集
     * @param columns 所有匹配的列
     * @return 返回不同的列，如果没有，则返回长度为0的数组
     * @throws SQLException
     */
    public String[] getNotMatchColumnByValues(ResultSet srcRst, ResultSet dstRst, String[] columns) throws SQLException {
        List<String> ret = new ArrayList<String>();

        for (int i = 0; i < columns.length; i++) {
            String matchColumn = columns[i];
            Object srcObj = srcRst.getObject(matchColumn);
            Object dstObj = dstRst.getObject(matchColumn);

            if (srcObj == null) {    //源列为空，目标列不为空
                if (dstObj != null) {
                    ret.add(matchColumn);
                }
            } else if (srcObj instanceof String) {
                if (((((String) srcObj).length() != 0) && dstObj != null)) {
                    if (dstObj instanceof String && ((String) dstObj).length() != 0 && !srcObj.equals(dstObj)) {     //源列是字符串与目标列字符串是null或"",则相等
                        ret.add(matchColumn);
                    } else if (dstObj instanceof Clob) {    //源列是string,目标列是clob进行比较，TAB_SHARE_XMBJXX.LINE共享库是string，bizsystem中是clob
                        Clob dstClob = (Clob) dstObj;
                        if (dstClob.length() != 0) {
                            byte[] strByte = ((String) srcObj).getBytes();
                            try {
                                if (strByte.length != dstClob.length()) {
                                    ret.add(matchColumn);
                                } else {
                                    InputStream is = dstClob.getAsciiStream();
                                    for (int j = 0; j < strByte.length; j++) {
                                        int dstbyte = is.read();
                                        if (dstbyte == -1 || dstbyte != strByte[j]) {
                                            ret.add(matchColumn);
                                            break;
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }else if(((((String) srcObj).length() != 0) && dstObj == null)){
                    ret.add(matchColumn);
                }
            } else if (srcObj instanceof Boolean) {   //比较布尔型，sqlserver中是true:false,oracle中是1:0
                if (dstObj instanceof Number) {
                    dstObj = ((Number) dstObj).intValue() > 0;
                }
                if (!srcObj.equals(dstObj)) {
                    ret.add(matchColumn);
                }
            } else if (srcObj instanceof Number) {       //sqlserver与oracle的数字类型不同，且有1.00，1的区分，比较两者的差，现取数度1
                if (dstObj == null || ((Number) srcObj).doubleValue() - ((Number) dstObj).doubleValue() > 1) {
                    ret.add(matchColumn);
                }
            } else if (dstObj instanceof Timestamp) {
                if ((((Timestamp) srcObj).getTime() - ((Timestamp) dstObj).getTime() > 1000)) {   //sqlserver中与oracle的毫秒值不同，忽略
                    ret.add(matchColumn);
                }
            } else if (srcObj instanceof Clob) {     //比较clob字段类型
                Clob srcClob = (Clob) srcObj;
                if (srcClob.length() != 0 && dstObj == null) {
                    ret.add(matchColumn);
                } else if (dstObj instanceof Clob) {
                    Clob dstClob = (Clob) dstObj;
                    if (srcClob.length() != dstClob.length()) {
                        ret.add(matchColumn);
                    } else {
                        InputStream srcIs = srcClob.getAsciiStream();
                        InputStream dstIs = dstClob.getAsciiStream();
                        try {
                            int srcByte;
                            int dstByte;
                            while (true) {
                                srcByte = srcIs.read();
                                dstByte = dstIs.read();
                                if (srcByte != dstByte) {
                                    ret.add(matchColumn);
                                    break;
                                } else if (srcByte == -1 || dstByte == -1) {
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (!srcObj.equals(dstObj)) {   //其它的比较
                ret.add(matchColumn);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

    /**
     * 获取插入语句
     *
     * @param tableName 目标表名
     * @param columns   插入列
     * @return 返回sql
     */
    public String getInsertSql(String tableName, String[] columns) {
//        String ret = "insert into " + tableName + " (ID,";
        String ret = "insert into " + tableName + " (";
        for (int i = 0; i < columns.length - 1; i++) {
            String column = columns[i];
            ret = ret + column + ",";
        }
        ret = ret + columns[columns.length - 1] + ")";

//        ret = ret + " values((select nvl(max(id),0)+1 from " + tableName + "),";
        ret = ret + " values(";
        for (int i = 0; i < columns.length - 1; i++) {
            ret = ret + "?,";
        }
        ret = ret + "?)";
        return ret;
    }

    /**
     * 获取更新的sql
     *
     * @param tableName 目标表名
     * @param columns   需要更新的列
     * @param keys      主键
     * @return 返回sql    .
     */
    public String getUpdateSql(String tableName, String[] columns, String[] keys) {
        String ret = "update " + tableName + " set ";
        for (int i = 0; i < columns.length - 1; i++) {
            String column = columns[i];
            ret = ret + " " + column + "=?,";
        }
        ret = ret + " " + columns[columns.length - 1] + "=?";

        ret = ret + " where ";

        for (int i = 0; i < keys.length - 1; i++) {
            String column = keys[i];
            ret = ret + column + "=? and ";
        }

        ret = ret + keys[keys.length - 1] + "=?";
        return ret;
    }

    /**
     * 删除语句
     *
     * @param tableName 目标表名
     * @param keys      主键
     * @return 返回sql
     */
    public String getDeleteSql(String tableName, String[] keys) {
        String ret = "delete " + tableName + " where ";
        for (int i = 0; i < keys.length - 1; i++) {
            String column = keys[i];
            ret = ret + column + "=? and ";
        }

        ret = ret + keys[keys.length - 1] + "=?";
        return ret;
    }

    /**
     * 获取源数据库与目标数据库列名相同的列
     *
     * @param src 源数据集
     * @param dst 目标数据集
     * @return 。
     * @throws SQLException
     */
    public String[] getMatchColumns(ResultSet src, ResultSet dst) throws SQLException {
        ResultSetMetaData srcMeta = src.getMetaData();    //获取列名
        ResultSetMetaData dstMeta = dst.getMetaData();

        Map<String, String> srcColumnsMap = new HashMap<String, String>();
        for (int i = 1; i <= srcMeta.getColumnCount(); i++) {
            String srcColName = srcMeta.getColumnName(i);
            srcColumnsMap.put(srcColName.toUpperCase(), srcColName);
        }

        List<String> columns = new ArrayList<String>();

        List<String> dstCols = new ArrayList<String>();
        for (int i = 1; i <= dstMeta.getColumnCount(); i++) {
            String columnName = dstMeta.getColumnName(i).toUpperCase(); //不区分大小写
            dstCols.add(columnName);
//            int columnType = dstMeta.getColumnType(i);
            String orgSrcColName = srcColumnsMap.get(columnName);
            if (orgSrcColName != null) { // && srcColumnsMap.get(columnName).equals(new Integer(columnType))) {
                columns.add(orgSrcColName);
            }
        }
        Collection changeCols = CollectionUtils.disjunction(srcColumnsMap.keySet(), dstCols);
        if (changeCols.size() > 0) {
            System.out.println("变更的列为：" + changeCols.toString());
        }

        return columns.toArray(new String[columns.size()]);
    }

    /**
     * 比较主键大小
     *
     * @param src  源数据集
     * @param dst  目标数据集
     * @param keys 主键
     * @return 0 if equals, -1 src less than dst, 1 src grater than dst
     */
    public int compareKeys(ResultSet src, ResultSet dst, String[] keys) throws SQLException {
        int ret = 0;
        for (String key : keys) {
            Comparable srcObject = (Comparable) src.getObject(key).toString();
            Comparable dstObject = (Comparable) dst.getObject(key).toString();
            //modify at 20121115 不能使用长度来判断，当目标数据与源数据主键不一致时应执行删除
            if (!srcObject.equals(dstObject)) {
//                if (srcObject instanceof String && dstObject instanceof String) {
//                    Integer sLen = ((String) srcObject).length();
//                    Integer dLen = ((String) dstObject).length();
//                    if (!sLen.equals(dLen)) {
//                        ret = sLen.compareTo(dLen);
//                        break;
//                    }
//                }
                ret = srcObject.compareTo(dstObject);
                break;
            }
        }
        return ret;
    }
}
