package com.justonetech.system.manager;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.domain.SysSkin;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义皮肤-- taglibs.jsp调用
 * author: Chen Junping
 * Date: 2014-03-18
 */
@Service
public class CustomSkin {

    private Logger logger = LoggerFactory.getLogger(CustomSkin.class);

    public String CUSTOM_SKIN = null;

    /**
     * 获取皮肤路径
     *
     * @return .
     */
    public String getCustomSkinName() {
        if(CUSTOM_SKIN == null){
            CUSTOM_SKIN = getMySkin();
        }
        return CUSTOM_SKIN;
    }

    private String getMySkin() {
        String skinPath = "";

        //获取用户皮肤（若用户未设置则登录时直接取系统缺省皮肤）
        SysUserManager sysUserManager = (SysUserManager) SpringContextUtil.getBean("sysUserManager");
        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            SysSkin skin = sysUser.getSkin();
            if (skin != null) {
                skinPath = JspHelper.getString(skin.getPath());
            }
        }
        if (StringHelper.isEmpty(skinPath)) {
            //获取缺省皮肤
            try {
                SysSkinManager sysSkinManager = (SysSkinManager) SpringContextUtil.getBean("sysSkinManager");
                skinPath = sysSkinManager.getDefaultSkinPath();
            } catch (Exception e) {
                logger.debug("UserSession invalid!");
            }
        }
//        logger.debug("...................................skinPath=" + skinPath);
        return skinPath;
    }
}