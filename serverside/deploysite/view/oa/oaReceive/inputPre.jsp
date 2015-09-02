<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"code", rule:"validate[required,maxSize[100]]"},
            //{name:"fileCode", rule:"validate[required,maxSize[100]]"},
            //{name:"title", rule:"validate[required,maxSize[250]]"},
            //{name:"sourceDept", rule:"validate[required,maxSize[250]]"},
            //{name:"receiveDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"deptName", rule:"validate[required,maxSize[100]]"},
            //{name:"writtenDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"limitDate", rule:"validate[required,custom[date],maxSize[7]"},
            //{name:"fs", rule:"validate[required,custom[integer],maxSize[6]"},
            //{name:"ys", rule:"validate[required,custom[integer],maxSize[6]"},
            //{name:"startDeptId", rule:"validate[required,custom[integer],maxSize[10]"},
            //{name:"dealPersons", rule:"validate[required,maxSize[200]]"},
            //{name:"dealDepts", rule:"validate[required,maxSize[200]]"},
            //{name:"createTime", rule:"validate[required,maxSize[7]]"},
            //{name:"createUser", rule:"validate[required,maxSize[100]]"},
            //{name:"updateTime", rule:"validate[required,maxSize[7]]"},
            //{name:"updateUser", rule:"validate[required,maxSize[100]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(operationId,btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/oaReceive/savePre.do?operationId="+operationId, formId);
    }
</script>
<style type="text/css">
    .td_border {
        /*border: 1px solid;*/
        border-top-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-right-width: 1px;
        border-top-style: solid;
        border-bottom-style: solid;
        border-left-style: solid;
        border-right-style: solid;
        border-top-color: #333;
        border-bottom-color: #333;
        border-left-color: #333;
        border-right-color: #333;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="orderNo"/>
    <input type="hidden" name="node" id="node" value="${node.id}">
    <input type="hidden" name="step" id="step" value="${bean.step.id}">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table" style="border-collapse: collapse">
            <tr >
                <td class="head_title form_border" colspan="6">上海市路政局收文登记单</td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="5">&nbsp;&nbsp;文件类型： <sys:code code="${type}" type="select" name="type" id="type" sysCodeDetailId="${bean.type.id}"/></td>
                <td class="form_label" align="right"><%--收文编号：--%>沪路政收（${bean.year}）${bean.orderNo}号&nbsp;&nbsp;<input type="hidden" name="code" class="input_text" value="沪路政收（${bean.year}）${bean.orderNo}号"/></td>

            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文文号：</td>
                <td class="td_border" align="left" colspan="3">
                    <input name="fileCode" id="fileCode" value="${bean.fileCode}" class="input_text_long" style="width: 80%">
                </td>
                <td class="td_border" align="right">办理时限：</td>
                <td class="td_border" align="left">
                    <form:input path="limitDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('limitDate','all');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="td_border" align="right">标题：</td>
                <td class="td_border" align="left" colspan="5">
                    <input name="title" id="title" value="${bean.title}" class="input_text_long" style="width: 80%">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">来文单位：</td>
                <td class="td_border" align="left" colspan="3">
                    <input name="sourceDept" id="sourceDept" value="${bean.sourceDept}" class="input_text_long" style="width: 80%">
                </td>
                <td class="td_border" align="right">份数：</td>
                <td class="td_border" align="left">
                    <form:input path="fs" cssClass="input_text"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="td_border" align="right"  width="10%">登记日期：</td>
                <td class="td_border" align="left" width="23%">
                    <form:input path="receiveDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('receiveDate','all');">
                </td>
                <td class="td_border" align="right" width="10%">成文日期：</td>
                <td class="td_border" align="left" width="23%">
                    <form:input path="writtenDate" cssClass="input_datetime" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('writtenDate','all');">
                </td>
                <td class="td_border" align="right" width="10%">页数：</td>
                <td class="td_border" align="left" width="24%">
                    <form:input path="ys" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="td_border" align="right">提供部门：</td>
                <td class="td_border" align="left" colspan="3">
                    <input name="deptName" id="deptName" value="${bean.deptName}" class="input_text_long" style="width: 80%">
                </td>
                <td class="td_border" align="right">密级：</td>
                <td class="td_border" align="left">
                    <sys:code code="${secret}" type="select" name="secret" id="secret" sysCodeDetailId="${bean.secret.id}"/>
                </td>
            </tr>


            <tr class="tr_light">
                <td class="td_border" align="right">紧急程度：</td>
                <td class="td_border" align="left">
                    <sys:code code="${urgent}" type="select" name="urgent" id="urgent" sysCodeDetailId="${bean.urgent.id}"/>
                </td>
                <td class="td_border" align="right">公文种类：</td>
                <td class="td_border" align="left">
                    <sys:code code="${fileType}" type="select" name="fileType" id="fileType" sysCodeDetailId="${bean.fileType.id}"/>
                </td>
                <td class="td_border" align="right">牵头部门：</td>
                <td class="td_border" align="left">
                    <form:input path="startDept" cssClass="input_text_long"/>
                </td>
            </tr>
           <tr  class="tr_light">
               <td class="td_border" align="right">附件：</td>
               <td class="td_border" align="left" colspan="5">
               &nbsp;<c:forEach items="${docAttachs}" var="docName">&nbsp;${docName.fileName}&nbsp;
               </c:forEach>${uploadButton}
               </td>
           </tr>
            <tr class="tr_button">
                <td class="form_border" align="center" colspan="6">
                    <c:forEach items="${operations}" var="operation" >
                        <input type="button" value="${operation.name}" class="button_normal_longer"
                               onclick="save('${operation.id}',this.value)">&nbsp;
                    </c:forEach>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>