package com.justonetech.system.utils;

import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.StringHelper;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * description: MD5加密
 * User: Chenjp
 * Date: 14-4-17 下午4:01
 */
public class Md5Utils {

    public static String md5(String password) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算md5函数
            md.update(password.getBytes());

            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public static void main(String[] args) {
        try {
            String s1 = "1234";
            System.out.println(md5(s1).equals("81dc9bdb52d04dc20036dbd8313ed055"));

            String s2 = "1234";
            System.out.println(s2.equals(CryptUtil.decrypt("055086222055086223111046049193053084118048053203244")));
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
