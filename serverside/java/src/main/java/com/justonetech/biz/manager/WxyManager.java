package com.justonetech.biz.manager;//package com.justonetech.biz.manager;
//
//
//import com.justonetech.core.utils.JspHelper;
//import com.justonetech.sjjjw.daoservice.SynGreatDangerService;
//import com.justonetech.sjjjw.domain.SynGreatDanger;
//import com.justonetech.sjjjw.utils.webService.wxyWebservice.WxyServiceClient;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.Timestamp;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * 重大危险源同步--从webservice获取数据
// */
//@Service
//public class WxyManager {
//
//
//    @Autowired
//    private SynGreatDangerService synGreatDangerService;
//
//    /**
//     * 获得所有当前的重大危险源信息
//     * 存入数据库
//     *
//     * @throws Exception
//     */
//    public void saveToTable() throws Exception {
//        WxyServiceClient wxyServiceClient = new WxyServiceClient();
//        String json = wxyServiceClient.getZdwxy();
//        json = json.replaceAll("new Date\\((\\d*)\\)", "$1");
//        JSONArray jsonArray = JSONArray.fromObject(json);
//        int len = jsonArray.size();
//        //查找已有的记录
//        String hql = "from SynGreatDanger where 1=1";
//        List<SynGreatDanger> list = synGreatDangerService.findByQuery(hql);
//        //set存放范围开始日期和结束日期的组合
//        Set<String> set = new HashSet<String>();
//        for (SynGreatDanger synGreatDanger : list) {
//            set.add(synGreatDanger.getGcRange() + "_" + synGreatDanger.getStartDatetime() + "_" + synGreatDanger.getEndDatetime());
//        }
//        //循环比较插入数据时候，set是否包含
//        for (int i = 0; i < len; i++) {
//            SynGreatDanger synGreatDanger = new SynGreatDanger();
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            String str = jsonObject.get("Gcfw") + "_" + new Timestamp(jsonObject.getLong("Ksrq")) + "_" + new Timestamp(jsonObject.getLong("Jsrq"));
//            if (!set.contains(str)) {
//                if (jsonObject.get("Gdbh") != null && jsonObject.get("Gdmc") != null && jsonObject.get("Gcfw") != null) {
//                    synGreatDanger.setGdbh(JspHelper.getString(jsonObject.get("Gdbh")));
//                    synGreatDanger.setGdName(JspHelper.getString(jsonObject.get("Gdmc")));
//                    synGreatDanger.setEndDatetime(new Timestamp(jsonObject.getLong("Jsrq")));
//                    synGreatDanger.setGcRange(JspHelper.getString(jsonObject.get("Gcfw")));
//                    synGreatDanger.setLb(JspHelper.getString(jsonObject.get("Lb")));
//                    synGreatDanger.setStartDatetime(new Timestamp(jsonObject.getLong("Ksrq")));
//                    synGreatDanger.setSubjectUnitCode(JspHelper.getString(jsonObject.get("Zycbdwdm")));
//                    synGreatDanger.setWxxcd(JspHelper.getString(jsonObject.get("Wxxcd")));
//                    synGreatDanger.setSubjectUnitName(JspHelper.getString(jsonObject.get("Zycbdwmc")));
//                    //每插入一条之后进入set
//                    set.add(str);
//                    //循环向表中插入数据
//                    synGreatDangerService.save(synGreatDanger);
//                }
//            }
//        }
//        //释放set
//        set = null;
//    }
//}
