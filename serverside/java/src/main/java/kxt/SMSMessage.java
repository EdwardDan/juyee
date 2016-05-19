package kxt;



import kxt.util.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发送短信实体
 *
 * @author user
 */
public class SMSMessage {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSW");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 机构编号
    private String cid;
    // 用户登录名
    private String uid;
    // 密码,加密后的密文
    private String pwd;
    /*
    * 时间戳
    * 18 位字符串;格式是 yyyyMMddHHmmssNNNN;
    * 前面是 14 位的时间 (精确到秒),再追加 4 位随机数字,总共 18 位;
    * */
    private String timestamp;
    /*
    * 目标号码
    * 数组格式;
    * 平台支持每次最多 10000 个号码。
    * */
    private String mobiles[];
    /*
    * 短信内容;平台支持最多 1000 字。
    * */
    private String content;
    /*
    * 定时发送时间;
    * 如果是立即发送,则可以不填;
    * 如果要填,其格式是 yyyy-MM-dd HH:mm:ss(19 位长度); 例如 2015-04-01 12:00:00
    * */
    private String atTime;
    /*
    * 每日限发时段的起始时间;
    * 可选项,可以不填;
    * 如果填写,其格式是 HH:mm:ss(8 位长度);
    * 例如,如果希望早上九点半开始发,则该参数可填写为 09:30:00;
    * 该参数最小值是 00:00:00。
    */
    private String dailyBeginTime;
    /*
    每日限发时段的截止时间;
    可选项,可以不填;
    如果填写,其格式是 HH:mm:ss(8 位长度);例如,如果希望下午 六点后不要发,则该参数可填写为 18:00:00;
    该参数最大值是 23:59:59。
    */
    private String dailyEndTime;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {

        pwd = MD5.GetMD5Code(pwd + this.getTimestamp());
        this.pwd = pwd;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = sdf.format(timestamp);
    }

    public String[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtTime() {
        return atTime;
    }

    public void setAtTime(Date atTime) {

        this.atTime = sdf2.format(atTime);
    }

    public String getDailyBeginTime() {
        return dailyBeginTime;
    }

    public void setDailyBeginTime(String dailyBeginTime) {
        this.dailyBeginTime = dailyBeginTime;
    }

    public String getDailyEndTime() {
        return dailyEndTime;
    }

    public void setDailyEndTime(String dailyEndTime) {
        this.dailyEndTime = dailyEndTime;
    }

}
