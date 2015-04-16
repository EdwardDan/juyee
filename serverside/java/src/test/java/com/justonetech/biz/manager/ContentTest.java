package com.justonetech.biz.manager;

import jgs.api.content.*;
import jgs.api.http.ApiContentUtil;
import jgs.api.http.ContentErrorException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentTest {

    public static void main(String args[]) throws IOException {

        // 目前测试环境，线上环境以后只需要替换成域名就OK了
        String host = "www.hkjgzx.sh.cn";
        // 目前测试的KEY，将来需要切换到线上的KEY
        String apiKey = "7b54765e-3ad2-4b9a-8da2-d7506a8859f1";

        //获取农民工投诉
        getComplains(host, apiKey);

        //获取内部公告
        getAnouncements(host, apiKey);
    }

    /**
     * 创建新闻
     *
     * @param host
     * @param apiKey
     */
    public static void createNews(String host, String apiKey) {
        News news = new News();
        // 标题
        news.setTitle("test1222211444");

        // 内容，支持富文本格式
        news.setBody("<span>test</span>");

        // 信息系统的ID，门户会根据此ID来做新增或者更新
        news.setMisId(113311112l);

        // 返回false表示同步失败
        System.out.println(ApiContentUtil.createOrUpdate(host, news, apiKey));

    }

    /**
     * @param host
     * @param apiKey
     */
    public static void deleteNews(String host, String apiKey) {
        News deletedNews = new News();

        // 只需要设置信息系统的ID就行了
        deletedNews.setMisId(11111212l);

        // 返回false表示同步失败
        System.out.println(ApiContentUtil.delete(host, deletedNews, apiKey));
    }

    /**
     * 创建政策法规
     *
     * @param host
     * @param apiKey
     */
    public static void createPolicy(String host, String apiKey) {
        Policy policy = new Policy();
        // 标题
        policy.setTitle("编号1212");

        // 内容，支持富文本格式
        policy.setBody("新的政策法规");

        // 信息系统的ID
        policy.setMisId(222222l);

        // 返回false表示同步失败
        System.out.println(ApiContentUtil.createOrUpdate(host, policy, apiKey));
    }

    /**
     * @param host
     * @param apiKey
     */
    public static void deletePolicy(String host, String apiKey) {
        Policy deletedPolicy = new Policy();

        // 删除其它的内型也一样，只需要设置信息系统的ID就行了
        deletedPolicy.setMisId(444444l);

        // 返回false表示同步失败
        System.out.println(ApiContentUtil.delete(host, deletedPolicy, apiKey));
    }

    /**
     * 创建现行标准
     *
     * @param host
     * @param apiKey
     */
    public static void createCriterion(String host, String apiKey) {
        Criterion criterion = new Criterion();
        // 标题
        criterion.setTitle("建筑标准2014");

        // 内容，支持富文本格式
        criterion.setBody("建筑标准2014");

        // 信息系统的ID
        criterion.setMisId(222222l);

        // 返回false表示同步失败
        System.out.println(ApiContentUtil.createOrUpdate(host, criterion, apiKey));
    }

    /**
     * 获取农民工投诉数据，可以传递上次获取的时间或者全部获取
     *
     * @param host
     * @param apiKey
     */

    public static void getComplains(String host, String apiKey) {

        // 同步5天前到现在的数据， 0表示同步所有，秒
        long lastFetchTime = new Date().getTime() / 1000 - 5 * 24 * 60 * 60;

        List<Complain> complains = new ArrayList<Complain>();
        try {
            complains = ApiContentUtil.listComplan(host, apiKey, lastFetchTime);
        } catch (ContentErrorException e) {

            e.printStackTrace();
            // 如果抛出exception表示获取数据失败
        }
        System.out.println("complains.size() = " + complains.size());
        for (Complain complain : complains) {

            // 标题
            System.out.println(complain.getTitle());

            // 内容
            System.out.println(complain.getBody());

            // 联系地址
            System.out.println(complain.getField__di_zhi());

            // 联系电话
            System.out.println(complain.getField__shou_ji());

            // 联系人
            System.out.println(complain.getField_lian_xi_ren());

            System.out.println(complain.getField_project_name());

            System.out.println(complain.getField_project_address());

            // 门户返回的此数据ID
            System.out.println(complain.getNid());
        }
    }

    /**
     * 获取内部公告，可以传递上次获取的时间或者全部获取
     *
     * @param host
     * @param apiKey
     */

    public static void getAnouncements(String host, String apiKey) {

        // 同步30天前到现在的数据， 0表示同步所有, 秒
        long lastFetchTime = new Date().getTime() / 1000 - 45 * 24 * 60 * 60;


        List<Announcement> list = new ArrayList<Announcement>();
        try {
            list = ApiContentUtil.listAnnouncements(host, apiKey, lastFetchTime);
        } catch (ContentErrorException e) {

            e.printStackTrace();
            // 如果抛出exception表示获取数据失败
        }
        System.out.println("list.size() = " + list.size());
        for (Announcement announcement : list) {

            // 标题
            System.out.println(announcement.getTitle());

            // 内容
            System.out.println(announcement.getBody());

            java.sql.Date date = new java.sql.Date(announcement.getCreated()*1000);
            System.out.println("date = " + date);

            // System.out.println(announcement.());

        }
    }

}
