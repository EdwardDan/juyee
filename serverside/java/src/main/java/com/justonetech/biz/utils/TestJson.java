package com.justonetech.biz.utils;

import com.justonetech.biz.utils.webService.integratedService.bean.GcmxData;
import com.justonetech.biz.utils.webService.integratedService.bean.JdrwsData;
import flexjson.JSONDeserializer;

import java.util.List;

/**
 * User: Chen Junping
 * Date: 12-4-23
 */
public class TestJson {

    public static void main(String[] args) {
        String jdrws = "[{\"JdRwsBh\":\"1001SJ0001JDS001\",\"JdRwsScRq\":\"2012-04-02\",\"JdRwsMc\":\"车墩重大工程配套商品房一标监督任务书\",\"Zt\":\"1\",\"Bz\":\"\",\"Bjbh\":\"1001SJ0001\",\"DwDm\":\"B2JGSJ\",\"Jbr\":\"朱菁\",\"JbrDm\":\"B2AZSJ1001\",\"ChangeTime\":null,\"wtyn\":true,\"firstTime\":\"2012-04-02\",\"xmmc\":\"车墩重大工程配套商品房\",\"xmdd\":\"虹口区东至车峰路，西至好莱坞小区，南至影佳路，北至北松公路\"},{\"JdRwsBh\":\"1001SJ0001JDS002\",\"JdRwsScRq\":\"2012-04-02\",\"JdRwsMc\":\"车墩重大工程配套商品房二标监督任务书\",\"Zt\":\"1\",\"Bz\":\"\",\"Bjbh\":\"1001SJ0001\",\"DwDm\":\"B2JGSJ\",\"Jbr\":\"朱菁\",\"JbrDm\":\"B2AZSJ1001\",\"ChangeTime\":null,\"wtyn\":true,\"firstTime\":\"2012-04-02\",\"xmmc\":\"车墩重大工程配套商品房\",\"xmdd\":\"虹口区东至车峰路，西至好莱坞小区，南至影佳路，北至北松公路\"}]";
        List<JdrwsData> list = new JSONDeserializer<List<JdrwsData>>().use("values", JdrwsData.class).deserialize(jdrws);
        System.out.println("jdrws.size() = " + list.size());


        String gcmxs = "[{\"id\":\"522394\",\"DwGcBh\":\"1001SJ0001D013\",\"JdRwsBh\":\"1001SJ0001JDS002\",\"DwGcMc\":\"13#楼整体\",\"GcLx\":\"K\",\"JzMj\":3233.7700,\"GzZj\":345.3975,\"ChangeTime\":null,\"Jbr\":null,\"JbrDm\":null,\"bjbh\":\"1001SJ0001\",\"dwgch\":\"D013\",\"ts\":0,\"jglx\":null}]";
        List<GcmxData> gcmxDatas = new JSONDeserializer<List<GcmxData>>().use("values", GcmxData.class).deserialize(gcmxs);
        System.out.println("gcmxDatas.size() = " + gcmxDatas.size());
    }
}
