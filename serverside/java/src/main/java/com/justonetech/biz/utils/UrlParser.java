package com.justonetech.biz.utils;

import com.justonetech.core.utils.StringHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;

/**
 * description: 使用Jsoup组件对Url内容解析
 * <dependency>
 * <groupId>org.jsoup</groupId>
 * <artifactId>jsoup</artifactId>
 * <version>1.7.2</version>
 * </dependency>
 * User: Chenjp
 * Date: 13-7-17 下午3:26
 */
public class UrlParser {
    /**
     * 解析url内容
     * @param url 链接
     * @param timeout 超时
     * @return .
     */
    public static org.jsoup.nodes.Document getDocument(URL url,int timeout){
        try {
            return Jsoup.parse(url, timeout);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    /**
     * 根据标记解析内容为字符串数组
     * @param doc 待解析内容
     * @param htmlTag 标记，比如title、div、table或者复合标记table[class=biao_jg]
     * @return .
     */
    public static String[] getDocTexts(org.jsoup.nodes.Document doc, String htmlTag){
        String[] texts = new String[10];
        if(doc != null){
            Elements links = doc.select(htmlTag);
            if(links.size()>0){
                Element element = links.iterator().next();
                String text = element.text();
                if (!StringHelper.isEmpty(text)) {
                    texts = text.split(" ");
                }
            }
        }
        return texts;
    }


    /**
     * 获取当前路径前缀
     * @param request .
     * @return .
     */
    public static String getFrontUrl(HttpServletRequest request){
        String path = request.getContextPath();
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }
}
