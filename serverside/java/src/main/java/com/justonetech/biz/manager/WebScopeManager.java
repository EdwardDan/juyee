package com.justonetech.biz.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * note: 爬虫工具类
 * User: Shaxj
 * Date: 15-4-7
 * Time: 下午2:54
 */
public class WebScopeManager {
    private Logger logger = LoggerFactory.getLogger(WebScopeManager.class);

    public static String getDocs(String strURL) {
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn
                    .getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);

            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("========= 连接发生异常！=========== ");
        }

        return contentBuf.toString();
    }

    /**
     * 获取doc中的所有tag节点元素
     *
     * @param doc
     * @return
     */
    public static List<String> getElementsFromTags(String doc, String tag) {
        String startTag = "<" + tag + ">";
        String endTag = "</" + tag + ">";
        List<String> trList = new ArrayList<String>();

        List<Integer> start = new ArrayList<Integer>();
        int index = 0;
        doc = doc.replaceAll("<\\s*" + tag + ".*?\\s*>", startTag);
        while (doc.indexOf(startTag, index) != -1) {
            index = doc.indexOf(startTag, index);
            if (start.size() == 0 || start.get(start.size() - 1) < index) {
                start.add(index);
            }
            index += startTag.length();
        }
        for (int i = 0; i < start.size(); i++) {
            Integer st = start.get(i);
            int pEnd = findEndTag(doc, st, endTag);

            Integer count = 0;
            int temp = st;
            if (i != 0 && i < (start.size() - 1)) {
                for (int j = i + 1; j < start.size(); j++) {
                    if (temp < start.get(j) && start.get(j) < pEnd) {
                        temp = start.get(j);
                        pEnd = findEndTag(doc, pEnd + endTag.length(), endTag);
                        count++;
                    }
                }
            }

            i = i + count;
            String ret = "";

            if ((st >= 0) && (pEnd > st)) {
                ret = doc.substring(st + startTag.length(), pEnd);
                trList.add(ret.trim());
            }
        }
        return trList;
    }

    /**
     * 获取标签内的文本
     *
     * @param doc
     * @param tag
     * @return
     */
    public static String getElementValue(String doc, String tag) {
        if (doc == null) return "";
        String startTag = "<" + tag + ">";
        String endTag = "</" + tag + ">";
        doc = doc.replaceAll("<\\s*" + tag + ".*?\\s*>", "<" + tag + ">");
        return getElementValue(doc, startTag, endTag);
    }

    public static String OTHERS = "<others>";
    public static String RESULTS = "<results>";

    /**
     * 获取有关键字的标签中文本
     *
     * @param doc
     * @param tag
     * @return
     */
    public static String getElementValueByKeyWords(String doc, String tag, String keyWords) {
        if (doc == null) return "";
        String endTag = "</" + tag + ">";
        doc = doc.replaceAll("<\\s*" + tag + ".*?" + keyWords + ".*?" + "\\s*>", RESULTS);
        doc = doc.replaceAll("<\\s*" + tag + ".*?" + "\\s*>", OTHERS);
        return getElementValue(doc, RESULTS, endTag);
    }

    /**
     * 获取标签内的文本
     * 不建议调用此接口（未处理传入数据）  取替换完后的，<others></tag>中的数据时使用
     *
     * @param doc
     * @param resultTag
     * @param endTag
     * @return
     */
    @Deprecated
    public static String getElementValue(String doc, String resultTag, String endTag) {
        if (doc == null || doc.indexOf(resultTag) == -1) return "";

        String ret = "";
        List<Integer> start = new ArrayList<Integer>();
        int index = 0;
        while (doc.indexOf(resultTag, index) != -1 || doc.indexOf(OTHERS, index) != -1) {
            if (doc.indexOf(resultTag, index) != -1) {
                index = doc.indexOf(resultTag, index);
                if (start.size() == 0 || start.get(start.size() - 1) < index) {
                    start.add(index);
                }
            }
            index += resultTag.length();
            if (doc.indexOf(OTHERS, index) != -1) {
                index = doc.indexOf(OTHERS, index);
                if (start.size() == 0 || start.get(start.size() - 1) < index) {
                    start.add(index);
                }
            }
            index += OTHERS.length();
        }
        if (start.size() > 0) {
            int pStart = start.get(0);
            int pEnd = findEndTag(doc, pStart, endTag);
            Integer st = start.get(0);
            int ed = findEndTag(doc, st, endTag);

            int temp = st;
            if (0 < (start.size() - 1)) {
                for (int j = 1; j < start.size(); j++) {
                    if (temp < start.get(j) && start.get(j) < ed) {
                        temp = start.get(j);
                        ed = findEndTag(doc, ed + endTag.length(), endTag);
                        pEnd = ed;
                    }
                }
            }

            if ((pStart >= 0) && (pEnd > pStart)) {
                ret = doc.substring(pStart + resultTag.length(), pEnd);
            }
        }
        return ret.trim();
    }

    /**
     * 根据起始标签位查找结束标签
     *
     * @param doc
     * @param start
     * @param str
     * @return
     */
    private static Integer findEndTag(String doc, int start, String str) {
        int index = 0;
        while (doc.indexOf(str, index) != -1) {
            index = doc.indexOf(str, index);
            if (start < index) {
                return index;
            }
            index += str.length();
        }
        return 0;
    }
}
