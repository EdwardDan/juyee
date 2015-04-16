package com.justonetech.biz.manager;

import com.justonetech.core.utils.CryptUtil;
import com.justonetech.system.utils.Md5Utils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description:
 * User: Chenjp
 * Date: 14-6-26 下午2:16
 */
public class MD5Test {
    private static Logger logger = LoggerFactory.getLogger(MD5Test.class);

    @Test
    public void testMethod1() {
        String password = "123456";
        String s = Md5Utils.md5(password);
        System.out.println("s = " + s);

        String encrypt = CryptUtil.encrypt("1234");
        System.out.println("encrypt = " + encrypt);
    }
}