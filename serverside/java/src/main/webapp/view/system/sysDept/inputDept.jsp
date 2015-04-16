<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"code", rule:"validate[required,maxSize[50]]"},
            {name:"name", rule:"validate[required,maxSize[50]]"},
            {name:"shortName", rule:"validate[maxSize[50]]"},
            //{name:"isLeaf", rule:"validate[required]"},
            //{name:"treeId", rule:"validate[required]"},
            {name:"cardNo", rule:"validate[maxSize[20]]"},
            {name:"cityCode", rule:"validate[maxSize[50]]"},
            {name:"cityName", rule:"validate[maxSize[50]]"},
            {name:"provinceCode", rule:"validate[maxSize[50]]"},
            {name:"provinceName", rule:"validate[maxSize[50]]"},
            {name:"address", rule:"validate[maxSize[100]]"},
            {name:"orderNo", rule:"validate[custom[integer],maxSize[10]"},
//            {name:"isTag", rule:"validate[required]"},
            {name:"memo", rule:"validate[maxSize[250]]"}
            //{name:"createTime", rule:"validate[required]"},
            //{name:"updateTime", rule:"validate[required]"},
            //{name:"createUser", rule:"validate[required]"},
            //{name:"updateUser", rule:"validate[required]"},
//            {name:"isValid", rule:"validate[required]"}
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
        saveAjaxData("${ctx}/sysDept/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="parent" value="${bean.parent.id}"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">部门代码:</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">部门名称:</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">简称:</td>
                <td class="form_content">
                    <form:input path="shortName" cssClass="input_text"/>
                </td>
            </tr>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">叶节点:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:checkbox path="isLeaf" value="1"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">树形层次:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="treeId" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">机构代码证:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="cardNo" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">注册地编码:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="cityCode" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">注册地名称:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="cityName" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">隶属省市代码:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="provinceCode" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">隶属省市名称:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="provinceName" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">注册地址:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="address" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_light" style="display: none;">
                <td class="form_label">单位标志:</td>
                <td class="form_content">
                    <form:hidden path="isTag"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">是否有效:</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">排序:</td>
                <td class="form_content">
                    <form:input path="orderNo" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">备注:</td>
                <td class="form_content">
                    <form:textarea path="memo" cssClass="input_textarea"/>
                </td>
            </tr>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">创建时间:</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="createTime" id="createTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">--%>

                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">更新时间:</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="updateTime" id="updateTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">--%>

                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">创建人:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="createUser" cssClass="input_text"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">更新人:</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="updateUser" cssClass="input_text"/>--%>
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