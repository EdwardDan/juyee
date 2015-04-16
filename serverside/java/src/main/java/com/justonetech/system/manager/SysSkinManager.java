package com.justonetech.system.manager;

import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.system.daoservice.SysSkinService;
import com.justonetech.system.domain.SysSkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统皮肤管理
 * author: Chen Junping
 * Date: 2014-03-18
 */
@Service
public class SysSkinManager {
    @Autowired
    private SysSkinService sysSkinService;

    @Autowired
    private ConfigManager configManager;

    /**
     * 将当前版本之外的其他版本设为无效
     *
     * @param target .
     */
    public void updateSkinDefault(SysSkin target) {
        String hql = "from SysSkin where id != " + target.getId();
        List<SysSkin> sysSkins = sysSkinService.findByQuery(hql);
        for (SysSkin sysSkin : sysSkins) {
            sysSkin.setIsDefault(false);
            sysSkinService.save(sysSkin);
        }
    }

    /**
     * 获取缺省皮肤路径
     *
     * @return .
     */
    public String getDefaultSkinPath() {
        String hql = "from SysSkin where isValid='{0}' and isDefault='{1}'";
        List<SysSkin> sysSkins = sysSkinService.findByQuery(FormatUtils.format(hql, Constants.FLAG_TRUE, Constants.FLAG_TRUE));
        if (sysSkins.size() > 0) {
            return (sysSkins.iterator().next()).getPath();
        } else {
            return configManager.getDefaultSkinPath();
        }
    }

    /**
     * 选择有效的系统皮肤
     *
     * @return .
     */
    public List<SysSkin> getValidSkins() {
        String hql = "from SysSkin where isValid='{0}' order by name asc";
        return sysSkinService.findByQuery(FormatUtils.format(hql, Constants.FLAG_TRUE));
    }

}
