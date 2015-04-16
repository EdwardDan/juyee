package com.justonetech.biz.manager;

import com.justonetech.biz.domain.bean.param.Constraint;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.JaxbUtil;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.system.daoservice.SysParameterService;
import com.justonetech.system.domain.SysParameter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统参数
 *
 * @author Youyiming
 */
@Service
public class SysParameterManager {
    private Logger logger = LoggerFactory.getLogger(SysParameterManager.class);

    @Autowired
    private SysParameterService sysParameterService;

    /**
     * 获取参数的显示值
     *
     * @param sysParameter 系统参数
     * @return .
     * @throws javax.xml.bind.JAXBException .
     */
    public String getDisplayValue(SysParameter sysParameter) throws JAXBException {
        String value = sysParameter.getValue();

        String xml = sysParameter.getConstraint();
        if (!StringHelper.isEmpty(xml)) {
            Constraint constraint = JaxbUtil.unmarshall(Constraint.class, xml);
            value = getDisplayValue(sysParameter, constraint);
        }
        return value;
    }

    /**
     * 根据参数和约束获得参数的显示值
     * 如果是enum类型或者boolean类型的话，不能直接将value中的值显示在grid上面
     * 如果是Text类型的话，显示clobvalue在页面上
     *
     * @param sysParameter 系统参数
     * @param constraint   参数对应的约束
     * @return .
     */
    private String getDisplayValue(SysParameter sysParameter, Constraint constraint) {
        String value = sysParameter.getValue();
        if ("Text".equals(constraint.getType())) {
            value = sysParameter.getClobvalue();
        } else if ("Boolean".equals(constraint.getType())) {
            if (Constants.FLAG_FALSE.equals(value)) {
                value = "否";
            } else {
                value = "是";
            }
        } else if ("Enum".equals(constraint.getType())) {
            Map<String, String> map = getEnumMap(constraint);
            value = map.get(value);
        }
        return value;
    }


    /**
     * 该方法从Constraint中获取enum类型约束definition对应的map
     *
     * @param constraint .
     * @return .
     */
    private Map<String, String> getEnumMap(Constraint constraint) {
        Map<String, String> map = new HashMap<String, String>();

        if ("Enum".equals(constraint.getType())) {
            String definition = constraint.getDefinition();
            String[] entrySet = StringUtils.split(definition, ",");
            for (String entry : entrySet) {
                int index = entry.indexOf("=");
                if (-1 != index) {
                    String key = entry.substring(0, index);
                    String value = entry.substring(index + 1);
                    map.put(key, value);
                } else {
                    map.put(entry, entry);
                }
            }
        }
        return map;
    }

    /**
     * 通过code获得系统参数
     *
     * @param code 系统参数对应的编码
     * @return .
     */
    public SysParameter getSysParameter(String code) {
        return sysParameterService.findUniqueByProperty("code", code);
    }

    /**
     * 通过code获得系统参数中的值
     *
     * @param code .
     * @return .
     */
    public String getSysParameterValue(String code) {
        String value = "";
        SysParameter sysParameter = getSysParameter(code);
        if (null != sysParameter) {
            //如果clobvalue中有值，那么返回clobvalue中的值，否则返回value中的值
            value = sysParameter.getClobvalue();
            if (StringHelper.isEmpty(value)) {
                value = sysParameter.getValue();
            }
        }
        return value;
    }

    /**
     * 设置参数值
     *
     * @param code  .
     * @param value .
     */
    public void setParamValueByCode(String code, String value) {
        SysParameter parameter = getSysParameter(code);
        if (parameter == null) {
            parameter = new SysParameter();
            parameter.setCode(code);
            parameter.setName(code);
        }
        parameter.setValue(value);
        sysParameterService.save(parameter);
    }

}
