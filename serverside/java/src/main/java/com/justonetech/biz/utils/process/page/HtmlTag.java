package com.justonetech.biz.utils.process.page;

import com.justonetech.core.utils.StringHelper;

/**
 * @author tcg
 */
public class HtmlTag {
    private String key;
    private String privilege;
    private String inputType;
    private String viewType;
    private String inputTypeSource;
    private String inputClass;
    private String printType;
    private String inputHint;
    private String require;
    private String requireMsg;
    private String seperate;
    private String event;
    private String eventCode;
    private String formula;
    private String defaultValue;
    private String permitEdit;
    private String isSign;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getInputTypeSource() {
        return inputTypeSource;
    }

    public void setInputTypeSource(String inputTypeSource) {
        this.inputTypeSource = inputTypeSource;
    }

    public String getInputClass() {
        return inputClass;
    }

    public void setInputClass(String inputClass) {
        this.inputClass = inputClass;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getInputHint() {
        return inputHint;
    }

    public void setInputHint(String inputHint) {
        this.inputHint = inputHint;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getRequireMsg() {
        return requireMsg;
    }

    public void setRequireMsg(String requireMsg) {
        this.requireMsg = requireMsg;
    }

    public String getSeperate() {
        return seperate;
    }

    public void setSeperate(String seperate) {
        this.seperate = seperate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getPermitEdit() {
        return permitEdit;
    }

    public void setPermitEdit(String permitEdit) {
        this.permitEdit = permitEdit;
    }

    public String getSign() {
        return isSign;
    }

    public void setSign(String sign) {
        isSign = sign;
    }

    private boolean isInputType() {
        String[] types = {"text", "hidden", "checkbox", "radio"};
        boolean isInput = false;
        for (String type : types) {
            if (this.inputType.equals(type)) {
                isInput = this.inputType.equals(type);
                break;
            }
        }
        return isInput;
    }

    private boolean isSelect() {
        return this.inputType.equals("select") || this.inputType.equals("multiSelect");
    }

    private boolean isTextArea() {
        return this.inputType.equals("textarea");
    }

    private boolean isMultiSelect() {
        return this.inputType.equals("multiSelect");
    }

    private boolean isDate() {
        return this.inputType.equals("date");
    }

    private String addAttribute() {
        String addtributes = "";
        if (!StringHelper.isEmpty(this.inputHint)) {
            addtributes += "title='" + this.inputHint + "' ";
        }
        if (!StringHelper.isEmpty(this.seperate)) {
            addtributes += "seperate='" + this.seperate + "' ";
        }
        if (!StringHelper.isEmpty(this.key)) {
            addtributes += "name='" + this.key + "' ";
            addtributes += "id='" + this.key + "' ";
        }
        if (!StringHelper.isEmpty(this.inputClass)) {
            addtributes += "class='" + this.inputClass + "' ";
        } else {
            addtributes += "class='flow_" + this.inputType + "' ";
        }
        if (!StringHelper.isEmpty(this.require) && this.require.equalsIgnoreCase("1")) {
            addtributes += "data-validation-engine='validate[required]' ";
        }
        if (!StringHelper.isEmpty(this.requireMsg)) {
            addtributes += "msg='" + this.requireMsg + "' ";
        }
        if (!StringHelper.isEmpty(this.event) && !StringHelper.isEmpty(this.eventCode)) {
            addtributes += this.event + "='" + this.eventCode + "' ";
        }

        if (!StringHelper.isEmpty(this.permitEdit) && this.permitEdit.equalsIgnoreCase("0")) {
            addtributes += "readonly='true' ";
        }

        if (!StringHelper.isEmpty(this.isSign) && this.isSign.equalsIgnoreCase("1")) {
            addtributes += "isSign='" + this.isSign + "' ";
        }
        //formula
        if (!StringHelper.isEmpty(this.formula)) {
            addtributes += "ondblclick=\"doFormula(this,'" + this.formula + "')\" ";
        }
        return addtributes;
    }

    public String getFormValue(String action) {
        String ret = "";
        if ((this.inputType.equalsIgnoreCase("radio") || this.inputType.equalsIgnoreCase("checkbox")) && !StringHelper.isEmpty(this.inputTypeSource)) {
            String[] selectValues = this.inputTypeSource.split("\\|");
            for (int i = 0; i < selectValues.length; i++) {
                String selectValue = selectValues[i];
                String[] key_value = selectValue.split(":");
                if (key_value.length == 2) {
                    if (!StringHelper.isEmpty(this.defaultValue) && (","+this.defaultValue+",").indexOf(","+key_value[1]+",")>=0) {
                        //解决换行问题
                        ret += "[√]" + key_value[0].trim()+"\n";
                    }
                }
            }
        }
        return ret;
    }


    public String toHtmlString(Boolean hasPrivilege) {
        String htmlString = "";
        if (StringHelper.isEmpty(this.inputType)) {

        } else if (isInputType()) {
            //文本输入框，单选框，复选框转化
            if (this.inputType.equalsIgnoreCase("text") || this.inputType.equalsIgnoreCase("hidden")) {
                htmlString = "<input type='" + this.inputType + "' " + addAttribute() + " value='" + this.defaultValue + "'/>";
            } else if ((this.inputType.equalsIgnoreCase("radio") || this.inputType.equalsIgnoreCase("checkbox")) && !StringHelper.isEmpty(this.inputTypeSource)) {
                if(!hasPrivilege){
                   //解决换行问题
                   this.inputTypeSource = StringHelper.findAndReplace(this.inputTypeSource,"<br/>","\n");
                   this.inputTypeSource = StringHelper.findAndReplace(this.inputTypeSource,"<br>","\n");
                }
                String[] selectValues = this.inputTypeSource.split("\\|");
                for (String selectValue : selectValues) {
                    String[] key_value = selectValue.split(":");
                    if (key_value.length == 2) {
                        if (!StringHelper.isEmpty(this.defaultValue) && (","+this.defaultValue+",").indexOf(","+key_value[1]+",")>=0) {
                            htmlString += "<input type='" + this.inputType + "' " + addAttribute() + "value='" + key_value[1] + "' checked/>" + key_value[0].trim() + "\n";
                        } else {
                            htmlString += "<input type='" + this.inputType + "' " + addAttribute() + "value='" + key_value[1] + "'/>" + key_value[0].trim() + "\n";
                        }
                    }
                }
            }
        } else if (isSelect() || isMultiSelect()) {
            if (isSelect()) {
                htmlString = "<select " + addAttribute() + ">" + "\n";
            } else {
                htmlString = "<select " + addAttribute() + "multiple='true'>" + "\n";
            }
            if (!StringHelper.isEmpty(this.inputTypeSource)) {
                String[] selectValues = this.inputTypeSource.split("\\|");
                for (int i = 0; i < selectValues.length; i++) {
                    String selectValue = selectValues[i];
                    String[] key_value = selectValue.split(":");
                    if (key_value.length == 2) {
                        if (!StringHelper.isEmpty(this.defaultValue) && (","+this.defaultValue+",").indexOf(","+key_value[1]+",")>=0) {
                            htmlString += "<option value='" + key_value[1] + "' selected>" + key_value[0] + "</option>\n";
                        } else {
                            htmlString += "<option value='" + key_value[1] + "' >" + key_value[0] + "</option>\n";
                        }
                    }
                }
                htmlString += "</select>";
            }
        } else if (isTextArea()) {
            htmlString = "<textarea " + addAttribute() + ">" + (this.defaultValue == null ? "" : this.defaultValue) + "</textarea>";
        } else if (isDate()) {
            htmlString = "<input type='text' " + addAttribute() + "value='" + this.defaultValue + "' onClick='calendar(this);'/>";
        }

        return htmlString;
    }
}
