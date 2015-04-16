//package com.justonetech.biz.manager;
//
//import com.justonetech.biz.daoservice.OaPublicInfoService;
//import com.justonetech.biz.daoservice.WorkerComplainService;
//import com.justonetech.biz.domain.OaDynamicWork;
//import com.justonetech.biz.domain.OaNews;
//import com.justonetech.biz.domain.OaPublicInfo;
//import com.justonetech.biz.domain.WorkerComplain;
//import com.justonetech.biz.utils.Constants;
//import com.justonetech.core.utils.StringHelper;
//import com.justonetech.system.manager.SysCodeManager;
//import freemarker.template.utility.StringUtil;
//import jgs.api.content.Announcement;
//import jgs.api.content.Complain;
//import jgs.api.content.News;
//import jgs.api.content.RTWork;
//import jgs.api.http.ApiContentUtil;
//import jgs.api.http.ContentErrorException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
///**
//* 数据同步 -- 门户网站数据同步
//* 1、MIS系统发布或删除新闻时需推送到门户网站
//* 2、从门户网站定时获取务工投诉等数据
//* chenjp at 2014-06-11
//*/
//@Service
//public class OaPushSiteManager {
//    private Logger logger = LoggerFactory.getLogger(OaPushSiteManager.class);
//
//    @Autowired
//    private ConfigManager configManager;
//
//    @Autowired
//    private SysParameterManager sysParameterManager;
//
//    @Autowired
//    private WorkerComplainService workerComplainService;
//
//    @Autowired
//    private OaPublicInfoService oaPublicInfoService;
//
//    @Autowired
//    private SysCodeManager sysCodeManager;
//
//    //数据操作类型
//    public final String OP_TYPE_QUERY = "0";   //查询
//    public final String OP_TYPE_CREATE = "1";  //创建
//    public final String OP_TYPE_UPDATE = "2";  //更新
//    public final String OP_TYPE_DELETE = "3";  //删除
//
//    //推送地址和key
//    private static String PUSH_SITE_HOST = null;
//    private static String PUSH_SITE_APIKEY = null;
//
//    //系统参数编码
//    private static String PARAM_COMPLAIN = "OaPushSiteComplain";
//    private static String PARAM_BULLETIN = "OaPushSiteBulletin";
//
//    private Boolean initParam() {
//        if (!configManager.getPushsiteSwitch()) {
//            logger.debug("pom set : PushsiteSwitch is close!");
//            return false;
//        }
//        if (PUSH_SITE_HOST == null) PUSH_SITE_HOST = configManager.getPushsiteHost();
//        if (PUSH_SITE_APIKEY == null) PUSH_SITE_APIKEY = configManager.getPushsiteApiKey();
//        if (PUSH_SITE_HOST == null || PUSH_SITE_APIKEY == null) {
//            logger.debug("pom set : PUSH_SITE_HOST or PUSH_SITE_APIKEY  is null!");
//            return false;
//        }
//        return true;
//    }
//    /****************************** 推送信息 begin ***********************************/
//    /**
//     * 推送数据到网站
//     *
//     * @param object .
//     * @param opType .
//     */
//    public void pushData(Object object, String opType) {
//        if (!initParam()) return;
//
//        String objName = object.getClass().getSimpleName();
//        if (OaNews.class.getSimpleName().equals(objName)) {
//            pushNews(object, opType);
//        }else if (OaDynamicWork.class.getSimpleName().equals(objName)) {
//            pushDynamicWork(object, opType);
//        }
//    }
//
//    //推送新闻
//    private void pushNews(Object object, String opType) {
//        if (OP_TYPE_CREATE.equals(opType)) {
//            OaNews data = (OaNews) object;
//            News news = new News();
//            news.setTitle(data.getTitle());
//            news.setBody(data.getContent());
//            news.setMisId(data.getId());
//
//            // 返回false表示同步失败
//            boolean ret = ApiContentUtil.createOrUpdate(PUSH_SITE_HOST, news, PUSH_SITE_APIKEY);
//            logger.debug(opType + " = " + ret);
//
//        } else if (OP_TYPE_DELETE.equals(opType)) {
//            OaNews data = (OaNews) object;
//            News news = new News();
//            news.setMisId(data.getId());
//            boolean ret = ApiContentUtil.delete(PUSH_SITE_HOST, news, PUSH_SITE_APIKEY);
//            logger.debug(opType + " = " + ret);
//        }
//    }
//
//    //推送实时工作动态
//    private void pushDynamicWork(Object object, String opType) {
//        if (OP_TYPE_CREATE.equals(opType)) {
//            OaDynamicWork data = (OaDynamicWork) object;
//            RTWork work = new RTWork();
////            work.setTitle("");
//            work.setBody(data.getContent());
//            work.setMisId(data.getId());
//
//            // 返回false表示同步失败
//            boolean ret = ApiContentUtil.createOrUpdate(PUSH_SITE_HOST, work, PUSH_SITE_APIKEY);
//            logger.debug(opType + " = " + ret);
//
//        } else if (OP_TYPE_DELETE.equals(opType)) {
//            OaDynamicWork data = (OaDynamicWork) object;
//            RTWork work = new RTWork();
//            work.setMisId(data.getId());
//            boolean ret = ApiContentUtil.delete(PUSH_SITE_HOST, work, PUSH_SITE_APIKEY);
//            logger.debug(opType + " = " + ret);
//        }
//    }
//    /****************************** 推送信息 end ***********************************/
//
//
//    /**
//     * *************************** 获取信息 begin **********************************
//     */
//
//    //同步数据
//    public void syncSiteData() {
//        if (!initParam()) return;
//        getComplains();
//        getAnouncements();
//
//    }
//
//    /**
//     * 获取农民工投诉数据，可以传递上次获取的时间或者全部获取
//     */
//    private void getComplains() {
//        //当前时间
//        long endTime = System.currentTimeMillis();
//
//        //默认同步30天前到现在的数据， 0表示同步所有，秒
//        long lastFetchTime = new Date().getTime() / 1000 - 30 * 24 * 60 * 60;
//        String value = sysParameterManager.getSysParameterValue(PARAM_COMPLAIN);
//        if (!StringHelper.isEmpty(value)) {
//            lastFetchTime = Long.valueOf(value);
//        }
//
//        try {
//            List<Complain> complains = ApiContentUtil.listComplan(PUSH_SITE_HOST, PUSH_SITE_APIKEY, lastFetchTime);
//
//            for (Complain complain : complains) {
//                WorkerComplain data = null;
//                Long nid = complain.getNid();
//                if (nid != null && nid > 0) {  //更新操作
//                    WorkerComplain existData = workerComplainService.findUniqueByProperty("outerId", nid);
//                    if (existData != null) {
//                        data = existData;
//                    }
//                }
//                if (data == null) data = new WorkerComplain();
//
//                data.setProjectName(complain.getField_project_name());       //项目名称
//                data.setProjectAddress(complain.getField_project_address()); //项目地址
//                data.setContent(complain.getBody());                 //内容
//                data.setPersonName(complain.getField_lian_xi_ren()); //联系人
//                data.setPersonTel(complain.getField__shou_ji());     //联系电话
//                data.setPersonAddress(complain.getField__di_zhi());  //联系地址
//                data.setVisitDate(new java.sql.Date(complain.getCreated() * 1000));  //来访日期（获取的是秒，需转为毫秒）
//                data.setOuterId(nid);  //设置外部记录ID，避免插入重复记录
//                workerComplainService.save(data);
//            }
//
//            //设置最后更新时间
//            sysParameterManager.setParamValueByCode(PARAM_COMPLAIN, String.valueOf(endTime));
//
//        } catch (ContentErrorException e) {
//            // 如果抛出exception表示获取数据失败
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 获取内部公告，可以传递上次获取的时间或者全部获取
//     */
//    private void getAnouncements() {
//        //当前时间
//        long endTime = System.currentTimeMillis();
//
//        //默认同步5天前到现在的数据， 0表示同步所有，秒
//        long lastFetchTime = new Date().getTime() / 1000 - 30 * 24 * 60 * 60;
//        String value = sysParameterManager.getSysParameterValue(PARAM_BULLETIN);
//        if (!StringHelper.isEmpty(value)) {
//            lastFetchTime = Long.valueOf(value);
//        }
//
//        try {
//            List<Announcement> list = ApiContentUtil.listAnnouncements(PUSH_SITE_HOST, PUSH_SITE_APIKEY, lastFetchTime);
//
//            for (Announcement announcement : list) {
//                OaPublicInfo data = null;
//                Long nid = announcement.getNid();
//                if (nid != null && nid > 0) {  //更新操作
//                    OaPublicInfo existData = oaPublicInfoService.findUniqueByProperty("outerId", nid);
//                    if (existData != null) {
//                        data = existData;
//                    }
//                }
//                if (data == null) data = new OaPublicInfo();
//                data.setTitle(announcement.getTitle());    //标题
//                String body = announcement.getBody();      //内容
//                body = StringUtil.replace(body, " ", " ", false, false);     //解决乱码问题---空格变成了问号
//                data.setContent(body);
//                data.setReportDate(new java.sql.Date(announcement.getCreated() * 1000));  //创建日期（获取的是秒，需转为毫秒）
//                data.setType(sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, Constants.OA_PUBLIC_INFO_TYPE_BULLETIN));    //信息类型--公告
//                data.setAccessRange(sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_RANGE, Constants.OA_PUBLIC_INFO_RANGE_ALL)); //发布范围--全部
//                data.setIsValid(true);    //有效
//                data.setIsPublic(true);   //公开
//                data.setOuterId(nid);     //外部记录ID，避免插入重复记录
//                oaPublicInfoService.save(data);
//            }
//
//            //设置最后更新时间
//            sysParameterManager.setParamValueByCode(PARAM_BULLETIN, String.valueOf(endTime));
//
//        } catch (ContentErrorException e) {
//            // 如果抛出exception表示获取数据失败
//            e.printStackTrace();
//        }
//    }
//    /****************************** 获取信息 end ***********************************/
//}
