<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //加载项目信息
        loadProjectInfoByCode(null, "${bean.bjbh}",null, false, true);
    });

    //保存操作
    function save(status, btn) {
        if (!validateForm(formId)) {
            return;
        }

        if ("${STATUS_PASS}" == status || "${STATUS_SUBMIT_LEADER}" == status) {
            if (confirm("审核通过后将不能再修改，确定继续吗？")) {
                $("#status").val(status);
                saveAjaxData("${ctx}/jdInform/auditSave.do", formId, null);
            }
        }else if ("${STATUS_BACK}" == status) {
            var auditOpinion = $("#auditOpinion").val();
            if (auditOpinion == '') {
                showInfoMsg("请输入退回意见！");
                return;
            }
        }else if (status == "${STATUS_BACK_LEADER}") {
            var fgOpinion = $("#fgOpinion").val();
            if (fgOpinion == '') {
                showInfoMsg("请输入退回意见！");
                return;
            }
        }
        if (status == "${STATUS_BACK_LEADER}" || "${STATUS_BACK}" == status) {
            if (confirm("确定要退回修改吗？")) {
                $("#status").val(status);
                saveAjaxData("${ctx}/jdInform/auditSave.do", formId, null);
            }
        }
    }
</script>
<form:form commandName="bean">
<form:hidden path="id"/>
<form:hidden path="status"/>

<div class="form_div">
<table cellpadding="0" cellspacing="0" class="form_table">
<tr>
    <td colspan="2">
        <fieldset class="form_fieldset">
            <legend class="form_legend">工程信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" width="20%" nowrap>报建编号：</td>
                    <td class="form_content" width="30%" nowrap>
                            ${bean.bjbh}
                    </td>
                    <td class="form_label_right" width="20%" nowrap>项目名称：</td>
                    <td class="form_content" width="30%" nowrap>
                        <span id="projectName"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>项目分类：</td>
                    <td class="form_content" nowrap>
                        <span id="projectType"></span>
                    </td>
                    <td class="form_label_right" nowrap>工程地点：</td>
                    <td class="form_content" nowrap>
                        <span id="buildAddress"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>建筑面积：</td>
                    <td class="form_content" nowrap>
                        <span id="totalAreaDesc"></span>
                    </td>
                    <td class="form_label_right" nowrap>单体数量：</td>
                    <td class="form_content" nowrap>
                        <span id="dtsl"></span>
                    </td>
                </tr>
                <tr class="tr_dark">

                    <td class="form_label_right" nowrap>工程造价：</td>
                    <td class="form_content" nowrap colspan="3">
                        <span id="totalInvestmentDesc"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>建设单位：</td>
                    <td class="form_content" nowrap>
                        <span id="jsdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="jsdwLxr"></span>&nbsp;&nbsp;<span id="jsdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>施工单位：</td>
                    <td class="form_content" nowrap>
                        <span id="sgdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sgdwLxr"></span>&nbsp;&nbsp;<span id="sgdwTel"></span>

                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>勘察单位：</td>
                    <td class="form_content" nowrap>
                        <span id="kcdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="kcdwLxr"></span>&nbsp;&nbsp;<span id="kcdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>设计单位：</td>
                    <td class="form_content" nowrap>
                        <span id="sjdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sjdwLxr"></span>&nbsp;&nbsp;<span id="sjdwTel"></span>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>监理单位：</td>
                    <td class="form_content" nowrap>
                        <span id="jldwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="jldwLxr"></span>&nbsp;&nbsp;<span id="jldwTel"></span>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>施工总包：</td>
                    <td class="form_content" nowrap>
                        <span id="sgzbdwmc"></span>
                    </td>
                    <td class="form_label_right" nowrap>联系人：</td>
                    <td class="form_content" nowrap>
                        <span id="sgzbdwLxr"></span>&nbsp;&nbsp;<span id="sgzbdwTel"></span>
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>
<tr>
    <td colspan="2">
        <fieldset class="form_fieldset">
            <legend class="form_legend">质量监督告知书</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap width="20%">监督联系人：</td>
                    <td class="form_content" nowrap width="30%">
                            ${bean.lxr}
                    </td>

                    <td class="form_label_right" nowrap width="20%">联系电话：</td>
                    <td class="form_content" nowrap width="30%">
                            ${bean.tel}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>邮政编码：</td>
                    <td class="form_content" nowrap>
                            ${bean.zipCode}
                    </td>

                    <td class="form_label_right" nowrap>联系地址：</td>
                    <td class="form_content" nowrap>
                            ${bean.address}
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>传真号码：</td>
                    <td class="form_content" nowrap>
                            ${bean.fax}
                    </td>
                    <td class="form_label_right" nowrap>施工许可证发放日期：</td>
                    <td class="form_content" nowrap>
                            ${bean.sgxkDate}
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>备注：</td>
                    <td class="form_content" colspan="3">
                            ${bean.description}
                    </td>
                </tr>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>
<tr>
    <td>
        <fieldset class="form_fieldset">
            <legend class="form_legend">科长审核</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <c:choose>
                    <c:when test="${bean.status == STATUS_SUBMIT}">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="21%">科长审核意见：</td>
                            <td class="form_content">
                                <form:textarea path="auditOpinion" cssClass="input_textarea" cssStyle="width: 100%"/>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="21%">科长审核意见：</td>
                            <td class="form_content">
                                <sys:toHtml>${bean.auditOpinion}</sys:toHtml>
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="21%">科长审核时间：</td>
                            <td class="form_content">
                                <fmt:formatDate value="${bean.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </fieldset>
    </td>
</tr>
<tr>
    <td colspan="2" class="form_fieldset_space">&nbsp;</td>
</tr>

<c:if test="${bean.status == STATUS_SUBMIT_LEADER}">
    <tr>
        <td>
            <fieldset class="form_fieldset">
                <legend class="form_legend">分管领导审核</legend>
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_dark">
                        <td class="form_label_right" width="21%">分管领导审核意见：</td>
                        <td class="form_content">
                            <form:textarea path="fgOpinion" cssClass="input_textarea" cssStyle="width: 100%"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</c:if>
<tr class="tr_button">
    <td class="form_border" align="center" colspan="4">
        <c:choose>
            <c:when test="${bean.status == STATUS_SUBMIT}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_SUBMIT_LEADER}',this)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_BACK}',this)">&nbsp;
            </c:when>
            <c:when test="${bean.status == STATUS_SUBMIT_LEADER}">
                <input type="button" value="审核通过" class="button_normal_long"
                       onclick="save('${STATUS_PASS}',this)">&nbsp;
                <input type="button" value="退回修改" class="button_normal_long"
                       onclick="save('${STATUS_BACK_LEADER}',this)">&nbsp;
            </c:when>
        </c:choose>
        <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
    </td>
</tr>
</table>
</div>
</form:form>