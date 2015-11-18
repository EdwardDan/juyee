<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, status) {
        if (!validateForm(formId)) {
            return;
        }
        //修改状态
        if (status == '${STATUS_SUBMIT}') {
            $("#status").val(status);
            $.messager.confirm('系统提示', "确定提交吗？提交后将不能修改！", function (r) {
                if (r) {
                    //提交表单
                    saveAjaxData("${ctx}/slryQualify/save.do", formId);
                }
            });
        } else {
            $("#status").val(status);
            //提交表单
            saveAjaxData("${ctx}/slryQualify/save.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="status"/>
    <form:hidden path="name"/>
    <form:hidden path="sex"/>
    <form:hidden path="birthDate"/>
    <form:hidden path="idCard"/>
    <form:hidden path="graduationTime"/>
    <form:hidden path="graduationSchool"/>
    <form:hidden path="major"/>
    <form:hidden path="workResume"/>
    <form:hidden path="production"/>
    <form:hidden path="unitName"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <form:hidden path="status"/>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">姓名：</td>
                <td class="form_content" width="80%">&nbsp;
                        ${bean.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">性别：</td>
                <td class="form_content">&nbsp;
                    <c:choose><c:when test="${bean.sex}">男</c:when><c:otherwise>女</c:otherwise></c:choose>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">出生日期：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.birthDate}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">证件类型：</td>
                <td class="form_content">&nbsp;
                    身份证
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">证件号码：</td>
                <td class="form_content">&nbsp;
                        ${bean.idCard}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">学历：</td>
                <td class="form_content">&nbsp;
                        ${bean.educationType.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">技术职称：</td>
                <td class="form_content">&nbsp;
                        ${bean.techType.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">毕业时间：</td>
                <td class="form_content">&nbsp;
                    <fmt:formatDate value="${bean.graduationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">毕业院校：</td>
                <td class="form_content">&nbsp;
                        ${bean.graduationSchool}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">所学专业：</td>
                <td class="form_content">&nbsp;
                        ${bean.major}
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">申请类型：</td>
                <td class="form_content">&nbsp;
                        ${bean.applyType.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">工作简历：</td>
                <td class="form_content">&nbsp;
                    <sys:toHtml> ${bean.workResume}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">生产业绩：</td>
                <td class="form_content">&nbsp;
                    <sys:toHtml>${bean.production}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请类别：</td>
                <td class="form_content">&nbsp;
                        ${bean.applyCerType.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">企业名称：</td>
                <td class="form_content">&nbsp;
                        ${bean.unitName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">企业类型：</td>
                <td class="form_content">&nbsp;
                        ${bean.unitType.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">照片：</td>
                <td class="form_content">
                        ${photoButton}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">身份证照片：</td>
                <td class="form_content">
                        ${cardButton}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">学历证或职称证照片：</td>
                <td class="form_content">
                        ${educationButton}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">合同文件：</td>
                <td class="form_content">
                        ${contractButton}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">初审意见：</td>
                <td class="form_content">
                    <form:textarea path="csOpinion" style="height: 100px; width: 200px;"/>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label_right"></td>
                <td class="form_content">
                    <input type="button" value="通过" class="button_normal_long" onclick="save(this,${STATUS_PASS})">&nbsp;
                    <input type="button" value="不通过" class="button_normal_long" onclick="save(this,${STATUS_BACK})">&nbsp;
                    <input type="button" value="返回" class="button_normal_long" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
