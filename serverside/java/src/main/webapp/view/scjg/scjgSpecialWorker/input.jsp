<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "name", rule: "validate[required,maxSize[10]]"},
            {name: "idCard", rule: "validate[required,custom[number],maxSize[50]]"},
            {name: "sex", rule: "validate[required]"},
            //{name:"sbjnMoney", rule:"validate[required,custom[number],maxSize[10]"},
            //{name:"sbjnBeginMonth", rule:"validate[required,maxSize[50]]"},
            //{name:"sbjnLastMonth", rule:"validate[required,maxSize[50]]"},
            //{name:"jdTaskCode", rule:"validate[required,maxSize[50]]"},
            {name: "deptName", rule: "validate[required,maxSize[200]]"}
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
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
        var beginYear=parseInt( $("#beginYearSelect").val(),10);
        var beginMonth=parseInt($("#beginMonthSelect").val(),10);
        var lastYear=parseInt( $("#lastYearSelect").val(),10);
        var lastMonth=parseInt( $("#lastMonthSelect").val(),10);
        if(beginYear>lastYear||((beginYear==lastYear)&&(beginMonth>lastMonth)))
        {
            showInfoMsg('日期输入不正确！',null);
            return;
        }

        var beginYearSelect = $("#beginYearSelect").val();
        var beginMonthSelect = $("#beginMonthSelect").val();
        $("#sbjnBeginMonth").val(beginYearSelect + "-" + beginMonthSelect);
        var lastYearSelect = $("#lastYearSelect").val();

        var lastMonthSelect = $("#lastMonthSelect").val();
        $("#sbjnLastMonth").val(lastYearSelect + "-" + lastMonthSelect);
        //提交表单
        saveAjaxData("${ctx}/scjgSpecialWorker/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">姓名：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">人员分类：</td>
                <td class="form_content">
                    <sys:code code="ScjgSpecialWorkerType" name="personType" type="select" defaultName=""
                              sysCodeDetailId="${bean.personType.id}" disabled="" id="personType"
                              isAlowedNull="false"
                              onChange=""/>
                        <%--<form:input path="personType" cssClass="input_text"/>--%>
                        <%--<select name="examClass" id="class">--%>
                        <%--<c:forEach items="${examClasses}" var="examClass">--%>
                        <%--<option value="${examClass.id}">${examClass.name}</option>--%>

                        <%--</c:forEach>--%>
                        <%--</select>--%>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">身份证号码：</td>
                <td class="form_content">
                    <form:input path="idCard" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">性别：</td>
                <td class="form_content">
                    <form:radiobutton path="sex" value="男"/>男
                    <form:radiobutton path="sex" value="女"/>女
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">社保缴纳金额：</td>
                <td class="form_content">
                    <form:input path="sbjnMoney" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">社保缴纳开始年月：</td>
                <td class="form_content">
                    <input type="hidden" name="sbjnBeginMonth" id="sbjnBeginMonth" value=""/>
                        <%--<input type="button" class="button_calendar" value=" " onClick="calendar('sbjnBeginMonth');">--%>
                    <select name="" id="beginYearSelect">
                            ${beginYearSelect}
                    </select>年
                    <select name="" id="beginMonthSelect">
                            ${beginMonthSelect}
                    </select>月
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">社保缴纳最后一次年月：</td>
                <td class="form_content">
                        <%--<form:input path="sbjnLastMonth" cssClass="input_date" redonly="true"/>--%>
                        <%--<input type="button" class="button_calendar" value=" " onClick="calendar('sbjnLastMonth');">--%>
                    <input type="hidden" name="sbjnLastMonth" id="sbjnLastMonth" value=""/>
                    <select name='' id="lastYearSelect">
                            ${lastYearSelect}
                    </select>年
                    <select name="" id="lastMonthSelect">
                            ${lastMonthSelect}
                    </select>月
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">监督任务书编号：</td>
                <td class="form_content">
                    <form:input path="jdTaskCode" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">所在单位：</td>
                <td class="form_content">
                    <form:input path="deptName" cssClass="input_text_long"/>
                </td>
            </tr>
            </tr>
            <tr class="tr_light">
                <td class="form_label">证书名称：</td>
                <td class="form_content">
                        <%--<form:input path="certName" cssClass="input_text"/>--%>
                    <input type="text" name="certName" value="${scjgSpecialWorkerCert.certName}"/>
                </td>
            </tr>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">证书编号：</td>
                <td class="form_content">
                    <input type="text" name="certCode" value="${scjgSpecialWorkerCert.certCode}"/>
                </td>
            </tr>
            </tr>
            <tr class="tr_light">
                <td class="form_label">证书有效期：</td>
                <td class="form_content">
                        <%--<form:input path="expireDate" cssClass="input_date" readonly="true"/>--%>
                    <input type="text" cssClass="input_data" name="expireDate" id="expireDate"
                           value="${scjgSpecialWorkerCert.expireDate}" readonly="true"/>
                    <input type="button" class="button_calendar" value="" onClick="calendar('expireDate','')">

                </td>
            </tr>
            <tr class="tr_dark">

                <td class="form_label">备注：</td>
                <td class="form_content">
                    <textarea rows="3" cols="40" name="description" >
                    <%--<input type="text" name="description" value="${scjgSpecialWorkerCert.description}"/>   --%>
                    <%--<form:textarea path="scjgSpecialWorkerCert.description" cssClass="input_textarea"/>--%>
                            ${scjgSpecialWorkerCert.description}
                    </textarea>
                </td>

            </tr>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">创建时间：</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="createTime" id="createTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('createTime','all')">                                                        --%>
                <%----%>
                <%--</td>                                --%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">创建用户名：</td>--%>
                <%--<td class="form_content">--%>
                <%--<form:input path="createUser" cssClass="input_text"/>						--%>
                <%--</td>                                --%>
                <%--</tr>--%>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label">更新时间：</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="updateTime" id="updateTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('updateTime','all')">--%>

                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">更新用户名：</td>--%>
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