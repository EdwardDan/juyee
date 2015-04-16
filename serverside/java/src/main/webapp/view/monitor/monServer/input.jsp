<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"name", rule:"validate[required,maxSize[200]]"},
            //{name:"serverName", rule:"validate[required,maxSize[200]]"},
            //{name:"ip", rule:"validate[required,maxSize[50]]"},
            //{name:"port", rule:"validate[required,maxSize[50]]"},
            //{name:"proxyIp", rule:"validate[required,maxSize[50]]"},
            //{name:"proxyName", rule:"validate[required,maxSize[50]]"},
            //{name:"loginName", rule:"validate[required,maxSize[50]]"},
            //{name:"password", rule:"validate[required,maxSize[50]]"},
            //{name:"description", rule:"validate[required,maxSize[50]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单
        saveAjaxData("${ctx}/monServer/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">项目名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">主机名：</td>
                <td class="form_content">
                    <form:input path="serverName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">IP：</td>
                <td class="form_content">
                    <form:input path="ip" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">端口：</td>
                <td class="form_content">
                    <form:input path="port" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">服务器类型</td>
                <td class="form_content">
                    <sys:code code="${monServerType}" sysCodeDetailId="${bean.serverType.id}" type="select" name="serverType"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">连接类型</td>
                <td class="form_content">
                   <sys:code code="${monConnectType}" sysCodeDetailId="${bean.connectType.id}" type="select" name="connectType"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">代理IP地址：</td>
                <td class="form_content">
                    <form:input path="proxyIp" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">代理IP主机名：</td>
                <td class="form_content">
                    <form:input path="proxyName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">登录名：</td>
                <td class="form_content">
                    <form:input path="loginName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">密码：</td>
                <td class="form_content">
                    <form:input path="password" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">备注：</td>
                <td class="form_content">
                    <form:input path="description" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>