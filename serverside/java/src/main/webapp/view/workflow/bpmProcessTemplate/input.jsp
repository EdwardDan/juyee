<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required,maxSize[100]]"},
            {name:"category", rule:"validate[required,maxSize[100]]"}
            //{name:"code", rule:"validate[required,maxSize[50]]"},
            //{name:"orderNo", rule:"validate[required,custom[integer],max[10]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function formCheck() {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn($("#ok"));

        //加入其他业务判断
//        if ($('#name').val() == '') {
//            showInfoMsg('请输入姓名！',null);
//            return;
//        }

        //提交表单

    }
</script>
<form:form commandName="bean" method="post" action="${ctx}/bpmProcessTemplate/save.do" onsubmit="return formCheck();"
           enctype="multipart/form-data">
    <form:hidden path="id"/>
    <input type="hidden" value='${gridParam}'>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label">上传时间：</td>--%>
                <%--<td class="form_content">--%>
                <%--<input type="text" name="uploadTime" id="uploadTime" class="input_datetime"--%>
                <%--value="<fmt:formatDate value="${bean.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="true"/>--%>
                <%--<input type="button" class="button_calendar" value=" " onClick="calendar('uploadTime','all')">                                                        --%>
                <%----%>
                <%--</td>                                --%>
                <%--</tr>--%>
            <tr class="tr_dark">
                <td class="form_label">分类：</td>
                <td class="form_content">
                        <%--<c:out value="${bean.category.name}"></c:out>--%>
                        <%--<input type="hidden" name="category" value="${bean.category.id}">--%>
                    <sys:code code="${infoType}" name="category" type="select" defaultName=""
                              sysCodeDetailId="${bean.category.id}" disabled="" id="category"
                              isAlowedNull="true"
                              onChange=""/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">选择par：</td>
                <td class="form_content">
                    <input type="file" name="visioPar" class="input_text" style="width:215px"/>
                </td>
            </tr>


            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="submit" value="确定" id = "ok" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="window.close()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
