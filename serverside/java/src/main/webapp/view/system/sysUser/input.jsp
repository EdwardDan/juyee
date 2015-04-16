<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"loginName", rule:"validate[required,maxSize[30]]"},
            {name:"person", rule:"validate[required]"},
            {name:"displayName", rule:"validate[required,maxSize[50]]"},
            {name:"password", rule:"validate[maxSize[10]]"},
            {name:"confirmPassword", rule:"validate[maxSize[10]]"}
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        var newP = $('#password');
        var conP = $('#confirmPassword');

        if (newP.val() != conP.val()) {
            showInfoMsg('两次密码不一致！请重新输入', null);
            return;
        }

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysUser/save.do", formId);
    }

    //显示姓名
    function doDisplayName(){
        var v = $("#personName").val();
        if(v != ""){
            $("#displayName").val(v);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">
                    用户名：
                </td>
                <td class="form_content">
                    <form:input path="loginName" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    对应人员：
                </td>
                <td class="form_content">
                    <input type="text" name="personName" id="personName" class="input_text"
                           value="${bean.person.name}" readonly="true"/>
                    <input type="hidden" name="person" id="person" value="${bean.person.id}"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysPerson('person','personName');" title="点击选择人员">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    显示名称：
                </td>
                <td class="form_content">
                    <form:input path="displayName" cssClass="input_text"/>
                    <input type="button" value=" " class="button_refresh"
                           onclick="doDisplayName();" title="刷新人员姓名">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    密码：
                </td>
                <td class="form_content">
                    <form:password path="password" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    密码确认：
                </td>
                <td class="form_content">
                    <input type="password" name="confirmPassword" id="confirmPassword" class="input_text" value=""/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    是否有效：
                </td>
                <td class="form_content">
                    <input type="checkbox" name="status" id="status" value="1"
                           <c:if test="${bean.status=='1'}">checked</c:if>/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    角色设置：
                </td>
                <td class="form_content">
                    <table border="0" align="left" width="95%">
                        <tr>
                            <c:forEach items="${roles}" var="item" varStatus="status">
                            <td align="left" nowrap width="33%">
                                <input type="checkbox" name="roleId" id="roleId" value="${item.role.id}"
                                       <c:if test="${item.check}">checked</c:if>/> ${item.role.roleName}
                            </td>
                            <c:if test="${status.index>0 && (status.index+1) % 3 == 0}">
                        </tr>
                        <tr>
                            </c:if>
                            </c:forEach>
                        </tr>
                    </table>
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