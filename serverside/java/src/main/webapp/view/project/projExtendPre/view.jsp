<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<style type="text/css">
    .addTd {
        border: 1px solid;
    }
</style>
<form:form commandName="bean">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right">项目建议书：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="project" id="project" type="select"
                              sysCodeDetailId="${bean.project.id}" />
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content" >
                    <form:input path="planXmjysTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planXmjysTime');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">工可：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="planGk" id="planGk" type="select"
                              sysCodeDetailId="${bean.planGk.id}"/>
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content" >
                    <form:input path="planGkTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planGkTime');">
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">初步设计：</td>
                <td class="form_content">
                    <sys:code code="ProjState" name="planCbsj" id="planCbsj" type="select"
                              sysCodeDetailId="${bean.planCbsj.id}" />
                </td>

                <td class="form_label_right">完成时间：</td>
                <td class="form_content">
                    <form:input path="planCbsjTime" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('planCbsjTime');">
                </td>
            </tr>
        </table>
        <tr class="tr_button">
            <td class="form_content" colspan="6" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
            </td>
        </tr>
        </table>
    </div>
</form:form>