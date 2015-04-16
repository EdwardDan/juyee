package com.justonetech.biz.utils.SyncData;

import com.justonetech.core.utils.StringHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: dai
 * Date: 12-1-5
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class ResultSetSyncMain {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * 获取xml配置文件
     *
     * @param filePath 文件名
     * @return .
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public Map<String, Object> getXMLConfig(String filePath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
//        System.out.println("filePath = " + filePath);
        Document document = db.parse(filePath);

        Map<String, Object> configMap = new HashMap<String, Object>();
        Node srcConn = document.getElementsByTagName("srcConn").item(0);
        Node dstConn = document.getElementsByTagName("dstConn").item(0);
        configMap.put("srcConn", getXMLConnectionConfig(srcConn));
        configMap.put("dstConn", getXMLConnectionConfig(dstConn));

        Node syncList = document.getElementsByTagName("syncList").item(0);
        configMap.put("syncList", getSyncList(syncList));

        return configMap;
    }

    /**
     * 读取数据库配置
     *
     * @param connNode 数据库配置节点
     * @return 。
     */
    public Map<String, String> getXMLConnectionConfig(Node connNode) {
        Map<String, String> connConfMap = new HashMap<String, String>();
        NodeList connConfNodeList = connNode.getChildNodes();
        int len = connConfNodeList.getLength();
        for (int i = 0; i < len; i++) {
            Node node = connConfNodeList.item(i);
            if (node.getNodeType() != Node.TEXT_NODE) {
                connConfMap.put(node.getNodeName(), node.getChildNodes().item(0).getNodeValue());
            }
        }
        return connConfMap;
    }

    /**
     * 同步的SQL配置
     *
     * @param syncListNode SQL配置节点
     * @return .
     */
    public List<Map<String, String>> getSyncList(Node syncListNode) {
        List<Map<String, String>> syncList = new ArrayList<Map<String, String>>();
        NodeList connConfNodeList = syncListNode.getChildNodes();
        int len = connConfNodeList.getLength();
        for (int i = 0; i < len; i++) {
            Node syncElement = connConfNodeList.item(i);
            if (syncElement.getNodeType() != Node.TEXT_NODE) {
                NodeList syncChildren = syncElement.getChildNodes();

                Map<String, String> syncEle = new HashMap<String, String>();
                int childLen = syncChildren.getLength();
                for (int j = 0; j < childLen; j++) {
                    Node syncEleNode = syncChildren.item(j);
                    if (syncEleNode.getNodeType() != Node.TEXT_NODE) {
                        syncEle.put(syncEleNode.getNodeName(), syncEleNode.getChildNodes().item(0).getNodeValue());
                    }
                }
                syncList.add(syncEle);
            }
        }
        return syncList;
    }

    /**
     * 获取数据库连接
     *
     * @param connProps 数据库配置
     * @return 。
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection(Map<String, String> connProps) throws SQLException, ClassNotFoundException {
        Class.forName(connProps.get("driverClass"));
        return DriverManager.getConnection(connProps.get("jdbcUrl"), connProps.get("user"), connProps.get("password"));
    }

    /**
     * 同步调用
     *
     * @param fileName   配置文件名
     * @param isTestMode 测试模式，只记录LOG，不会进行表的同步
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void doSyncWithConfig(String fileName, boolean isTestMode) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException {
        if (isTestMode)
            logger.info("仅为测试，程序将不会执行！");
        Map<String, Object> config = getXMLConfig(fileName);
        try {
            Connection srcCon = getConnection((Map<String, String>) config.get("srcConn"));
            Connection dstCon = getConnection((Map<String, String>) config.get("dstConn"));
            List<Map<String, String>> syncList = (List<Map<String, String>>) config.get("syncList");

            logger.info("--------------------------开始同步------------------------");
            ResultSetSync resultSetSync = new ResultSetSync(isTestMode);
            for (Map<String, String> syncProp : syncList) {
                resultSetSync.sync(srcCon, syncProp.get("srcSQL"), dstCon, syncProp.get("dstSQL"), syncProp.get("dstTBName"));
            }
            logger.info("--------------------------结束同步------------------------");

            srcCon.close();
            dstCon.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getClass().getSimpleName(), e);
        }
        //由于在定时器中起动，handler不断被添加，并且保持对该handler日志文件的锁定和修改，所以要移除
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            if (handler instanceof FileHandler) {
                handler.flush();
                handler.close();
                logger.removeHandler(handler);
            }
        }
    }

    /**
     * 同步程序的执行方法
     *
     * @param args 配置参数， args[0]： 配置文件路径， args[1]：是否是测试模式，测试模式只记录日志，不进行同步
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws SAXException
     * @throws SQLException
     * @throws ParserConfigurationException
     */
    public void exec(String[] args) throws ClassNotFoundException, IOException, SAXException, SQLException, ParserConfigurationException {
        Logger globalLog = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        try {
            String timeString = new Timestamp(System.currentTimeMillis()).toString().replaceAll("[- :]", "");
            timeString = timeString.substring(0, timeString.length() - 4);
            String filePath = timeString + ".log";
            if (args.length > 2) {
                filePath = args[2] + File.separator + filePath;
            }
            Handler fh = new FileHandler(filePath);
            globalLog.addHandler(fh);//一个logger可以有多个handler
            Formatter ft = new SimpleFormatter();//FileHandler默认的Formatter是XMLFormatter
            fh.setFormatter(ft);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResultSetSyncMain resultSetSyncMain = new ResultSetSyncMain();

        boolean isTestMode = false;
        String xmlFileName = args[0];
        if (args.length > 1) {
            isTestMode = args[1].toLowerCase().equals("testmode");
        }
//        System.out.println("xmlFileName = " + xmlFileName);
//        System.out.println("isTestMode = " + isTestMode);
        resultSetSyncMain.doSyncWithConfig(xmlFileName, isTestMode);
    }

    /**
     * 数据同步
     *
     * @param logPath 日志文件路径
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void init(String logPath) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException, SQLException {
        URL url = ResultSetSyncMain.class.getClassLoader().getResource("com\\");
        File file = new File(url.getPath().substring(1));
        String path = file.getParent();
        if (StringHelper.isEmpty(logPath)) {
            logPath = "d:";
        }

        new ResultSetSyncMain().exec(new String[]{
                path + File.separator + "sqlServerToOracle.xml", "", logPath
        });
        new ResultSetSyncMain().exec(new String[]{
                path + File.separator + "oracleToOracle.xml", "", logPath
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, SAXException, SQLException, ParserConfigurationException {
        init(null);
    }
}
