<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--pageEncoding="UTF-8" import="net.fckeditor.*" %>--%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ include file="/common/taglibs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /><%--为了使FCKeditor在IE10、IE11上能够兼容--%>
<title>信息发布</title>
<%@include file="/common/header.jsp" %>
<script src="${ctx}/js/fckeditor/fckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"type", rule:"validate[required]"},
            {name:"title", rule:"validate[required,maxSize[100]]"},
            //{name:"iconImage", rule:"validate[required,maxSize[200]]"},
            //{name:"userId", rule:"validate[required,custom[integer],max[10]"},
            {name:"createDeptName", rule:"validate[required,maxSize[50]]"}
            //{name:"createDate", rule:"validate[required,custom[date],max[10]"},
            //{name:"isPublic", rule:"validate[required,maxSize[1]]"},
            //{name:"reportDate", rule:"validate[required,custom[date],max[10]"},
            //{name:"visitTimes", rule:"validate[required,custom[integer],max[10]"},
            //{name:"accessRange", rule:"validate[required,custom[integer],max[10]"},
            //{name:"documentId", rule:"validate[required,custom[integer],max[10]"},
            //{name:"isValid", rule:"validate[required,maxSize[1]]"},
            //{name:"isTop", rule:"validate[required,maxSize[1]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        var oEditor = FCKeditorAPI.GetInstance('contentFck');
        $("#content").val(oEditor.GetXHTML());

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/oaPublicInfo/save.do", formId, refreshOpenerGrid, null);
    }
    function refreshOpenerGrid(ret) {
        enableBtn($("#btnSub"));
        opener.window.refreshGrid();
        self.close();
    }

    function checkOpinion(obj) {
        var b = document.getElementById("accessRange");
        var a = document.getElementById("isTop");
        if (!obj.checked) {
            b.value = null;
            //            b.sysCodeDetailId = null;
            a.checked = false;
        }
    }

    function changeOpinion(obj) {
        var b = document.getElementById("accessRange");
        var v = document.getElementById("isPublic");
        if (!v.checked) {
            b.value = null;
            //            alert("发布状态为否，不能选择发布范围！");
            showInfoMsg('发布状态为否，不能选择发布范围！', null);
        }
    }

    function checkTop(obj) {
        var v = document.getElementById("isPublic");
        if (!v.checked) {
            obj.checked = false;
            //            alert("发布状态为否，不能选择置顶！");
            showInfoMsg('发布状态为否，不能选择置顶！', null);
        }
    }

</script>
<form:form commandName="bean" action="${ctx}/oaPublicInfo/save.do" method="post">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">

            <tr class="tr_light">
                <td class="form_label_right" width="20%">标题：</td>
                <td class="form_content">
                    <form:input path="title" cssClass="input_text_long" style="width:517px"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">信息来源：</td>
                <td class="form_content">
                    <form:input path="createDeptName" cssClass="input_text_long"/>
                    <input type="button" value=" " class="button_select"
                           onclick="selectSysDept('','createDeptName')" title="点击选择来源单位">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">信息类型：</td>
                <td class="form_content">
                    <sys:code code="${infoType}" name="type" type="select" defaultName=""
                              sysCodeDetailId="${bean.type.id}" disabled="" id="type"
                              isAlowedNull="true"
                              onChange=""/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">展示图片：</td>
                <td class="form_content">
                        ${uploadButtonImage}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">发布内容：</td>
                <td class="form_content">
                    <textarea style="display:none" id="contentFck" name="contentFck"
                              class="input_textarea">${bean.content}
                    </textarea>
                    <script language="javascript">
                        var oFCKeditor = new FCKeditor('contentFck');
                        oFCKeditor.Width = "780";
                        oFCKeditor.Height = "500";
                        oFCKeditor.BasePath = '${ctx}/js/fckeditor/';
                        oFCKeditor.Value = '';
                        //oFCKeditor.SkinPath = '/skins/office2003/';
                        //oFCKeditor.Create();
                        oFCKeditor.ReplaceTextarea();
                    </script>

                    <form:hidden path="content"/>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">是否发布：</td>
                <td class="form_content">
                    <form:checkbox path="isPublic" id="isPublic" value="1" onclick="checkOpinion(this)"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">发布范围：</td>
                <td class="form_content">
                    <sys:code code="${range}" name="accessRange" type="select" defaultName=""
                              sysCodeDetailId="${bean.accessRange.id}" disabled="" id="accessRange"
                              isAlowedNull="true"
                              onChange="changeOpinion(this)"/>
                </td>
            </tr>

            <%--<tr class="tr_dark">--%>
                <%--<td class="form_label_right">是否有效：</td>--%>
                <%--<td class="form_content">--%>
                    <%--<form:checkbox path="isValid" value="1"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr class="tr_dark">
                <td class="form_label_right">是否置顶：</td>
                <td class="form_content">
                    <form:checkbox path="isTop" id="isTop" value="1" onclick="checkTop(this)"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">附件：</td>
                <td class="form_content">&nbsp;${uploadButtonDocument}</td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="2">
                    <div align="center">
                        <input type="button" value="确定" id="btnSub" class="button_confirm" onclick="save(this)">&nbsp;
                        <input type="button" value="取消" class="button_cancel" onclick="window.close()">
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form:form>