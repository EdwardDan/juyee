<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"refRule", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[100]]"},
//            {name:"reformType", rule:"validate[required,custom[integer],maxSize[10]"},
//            {name:"registerType", rule:"validate[required,custom[integer],maxSize[10]"},
//            {name:"safeType", rule:"validate[required,custom[integer],maxSize[10]"},
//            {name:"isLeaf", rule:"validate[required,maxSize[1]]"},
//            {name:"treeId", rule:"validate[required,maxSize[200]]"},
//            {name:"isValid", rule:"validate[required,maxSize[1]]"},
            {name:"orderNo", rule:"validate[custom[integer],maxSize[10]"},
            {name:"description", rule:"validate[maxSize[100]]"}
//            {name:"createTime", rule:"validate[required,maxSize[16]]"},
//            {name:"updateTime", rule:"validate[required,maxSize[16]]"},
//            {name:"updateUser", rule:"validate[required,maxSize[100]]"},
//            {name:"createUser", rule:"validate[required,maxSize[100]]"},
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
        disableBtn(btn);
        saveAjaxData("${ctx}/pollingDict/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <c:if test="${level!=1&&level!=2}">
            <tr class="tr_light">
                <td class="form_label">法规依据：</td>
                <td class="form_content">
                    <form:textarea path="refRule" cssClass="input_textarea"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">整改情形：</td>
                <td class="form_content">
                    <sys:code code="REFORM_TYPE" type="select" name="reformType"
                              sysCodeDetailId="${bean.reformType.id}"/>
                        <%--<form:input path="reformType" cssClass="input_text"/>--%>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">立案情形：</td>
                <td class="form_content">
                    <sys:code code="REGISTER_TYPE" type="select" name="registerType"
                              sysCodeDetailId="${bean.registerType.id}"/>
                        <%--<form:input path="registerType" cssClass="input_text"/>--%>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">安全隐患：</td>
                <td class="form_content">
                    <sys:code code="SAFE_TYPE" type="select" name="safeType" sysCodeDetailId="${bean.safeType.id}"/>
                        <%--<form:input path="safeType" cssClass="input_text"/>--%>
                </td>
            </tr>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">叶节点：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:checkbox path="isLeaf" value="1"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">树形层次：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="treeId" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_dark">
                <td class="form_label">是否有效：</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_label">排序号：</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>
                </td>
            </tr>
            <c:if test="${level!=1&&level!=2}">
            <tr class="tr_dark">
                <td class="form_label">问题描述：</td>
                <td class="form_content">
                    <form:textarea path="description" cssClass="input_textarea"/>
                </td>
            </tr>
            </c:if>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">创建时间：</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="createTime" id="createTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">--%>

                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">更新时间：</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="updateTime" id="updateTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">--%>

                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">更新人：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="updateUser" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">创建人：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="createUser" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>

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