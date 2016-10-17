package com.justonetech.biz.utils;

import com.justonetech.core.utils.CryptUtil;
import com.justonetech.core.utils.JspHelper;

/**
 * description: 系统工具类
 * User: Chenjp
 * Date: 15-6-11 下午1:10
 */
public class SysUtils {

    /**
     * 获取解密的密码
     *
     * @param savePass .
     * @return .
     */
    public static String getPassword(String savePass) {
        savePass = JspHelper.getString(savePass);
        if (savePass.length() > 20) {
            try {
                savePass = CryptUtil.decrypt(savePass);
            } catch (Exception e) {

            }
        }
        return savePass;
    }
}
