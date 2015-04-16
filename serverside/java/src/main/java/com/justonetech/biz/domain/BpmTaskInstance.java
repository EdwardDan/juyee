package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseBpmTaskInstance;
import com.justonetech.biz.manager.workflow.BpmFormTemplateManager;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;


public class BpmTaskInstance extends BaseBpmTaskInstance {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public BpmTaskInstance() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public BpmTaskInstance(java.lang.Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    private static BpmFormTemplateManager bpmFormTemplateManager;

    @Autowired
    public void setBpmFormTemplateManager(BpmFormTemplateManager bpmFormTemplateManager) {
        this.bpmFormTemplateManager = bpmFormTemplateManager;
    }

    /**
     * 根据键，取得表单字段值
     *
     * @param key 表单字段键
     * @return 对应表单字段值
     * @throws Exception
     */
    public String getFormField(String key) throws Exception {
        String formXml = getBpmFormAction().getFormXml();
        return bpmFormTemplateManager.getValue(formXml, key);
    }

    /**
     * 根据表单名和表单字段键，取得表单字段值
     *
     * @param formName 表单名称
     * @param key      表单字段的键
     * @return 对应表单字段值
     * @throws org.dom4j.DocumentException
     */
    public String getFormValue(String formName, String key) throws DocumentException {
        return bpmFormTemplateManager.getDataFromXml(this.getProcessInstance(), formName, key);
    }

    /**
     * 根据传入的数据，更新表单中的字段值，并返回更新后整个表单的xml
     *
     * @param orgXml 初始的表单xml数据
     * @param key    需要更新的表单字段的键
     * @param value  传入的数据
     * @return 更新后的表单xml
     * @throws DocumentException
     */
    public String generateFormXml(String orgXml, String key, String value) throws DocumentException {
        return bpmFormTemplateManager.generateXml(orgXml, key, value);
    }
}