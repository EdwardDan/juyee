package com.justonetech.biz.manager;

import com.justonetech.core.utils.JspHelper;
import com.justonetech.biz.utils.Constants;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.domain.SysUser;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * 网站业务类
 * User: Chen Junping
 * Date: 12-4-20
 */
@Service
public class SiteManager {
    //页面显示记录数
    public final int PAGE_SIZE = 25;

    //图片类型
    public final String PIC_TYPE = "gif|jpg|png|bmp|tif";

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 各模块类型编码设置
     *
     * @param model .
     * @param type  .
     */
    public void setTypeModel(Model model, String type) {
        model.addAttribute("siteName", configManager.getSiteName());

        SysUser sysUser = sysUserManager.getSysUser();
        if (sysUser != null) {
            model.addAttribute("loginName", sysUser.getLoginName());
            model.addAttribute("realName", sysUser.getDisplayName());
            model.addAttribute("isPlatformUser", sysUser.getRegPerson() != null);
        }

        model.addAttribute("type", type);
        SysCodeDetail detailByCode = sysCodeManager.getCodeDetailByCode(Constants.OA_PUBLIC_INFO_TYPE, type);
        if (detailByCode != null) {
            model.addAttribute("typeName", detailByCode.getName());
        }
        model.addAttribute("OA_PUBLIC_INFO_TYPE_INTRODUCTION", Constants.OA_PUBLIC_INFO_TYPE_INTRODUCTION);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_NEWS", Constants.OA_PUBLIC_INFO_TYPE_NEWS);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_WORK", Constants.OA_PUBLIC_INFO_TYPE_WORK);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_POLICYOPEN", Constants.OA_PUBLIC_INFO_TYPE_POLICYOPEN);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_POLICY", Constants.OA_PUBLIC_INFO_TYPE_POLICY);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_BULLETIN", Constants.OA_PUBLIC_INFO_TYPE_BULLETIN);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_PIC", Constants.OA_PUBLIC_INFO_TYPE_PIC);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_STANDARD", Constants.OA_PUBLIC_INFO_TYPE_STANDARD);
        model.addAttribute("OA_PUBLIC_INFO_TYPE_PLAN", Constants.OA_PUBLIC_INFO_TYPE_PLAN);
        model.addAttribute("OA_PUBLIC_INO_TYPE_PARTYMEMBER", Constants.OA_PUBLIC_INO_TYPE_PARTYMEMBER);
        model.addAttribute("OA_PUBLIC_INO_TYPE_WSBSLC", Constants.OA_PUBLIC_INO_TYPE_WSBSLC);

    }

    /**
     * 注册类型编码设置
     *
     * @param model .
     */
    public void setRegType(Model model,String regType) {
        model.addAttribute("SYS_REGPERSON_TYPE_Gd",Constants.SYS_REGPERSON_TYPE_Gd); //临时保留
        model.addAttribute("SYS_REGPERSON_TYPE_UNIT_JS",Constants.SYS_REGPERSON_TYPE_UNIT_JS);
        model.addAttribute("SYS_REGPERSON_TYPE_UNIT_SG",Constants.SYS_REGPERSON_TYPE_UNIT_SG);
        model.addAttribute("SYS_REGPERSON_TYPE_UNIT_JL",Constants.SYS_REGPERSON_TYPE_UNIT_JL);

        model.addAttribute("isGd", regType.equals(Constants.SYS_REGPERSON_TYPE_Gd));   //临时保留
        model.addAttribute("isJs", regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JS));
        model.addAttribute("isSg", regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_SG));
        model.addAttribute("isJl", regType.equals(Constants.SYS_REGPERSON_TYPE_UNIT_JL));

        model.addAttribute("regType", JspHelper.getString(regType));
        SysCodeDetail detailByCode = sysCodeManager.getCodeDetailByCode(Constants.SYS_REGPERSON_TYPE, JspHelper.getString(regType));
        if(detailByCode != null){
            model.addAttribute("regTypeName",detailByCode.getName());
        }else{
            model.addAttribute("regTypeName","");
        }
    }

}
