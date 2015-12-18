<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"year", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            //{name:"projectName", rule:"validate[required,maxSize[200]]"},
            //{name:"buildName", rule:"validate[required,maxSize[200]]"},
            //{name:"hYear", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"hNum", rule:"validate[required,custom[integer],maxSize[4]"},
            //{name:"applyPerson", rule:"validate[required,maxSize[50]]"},
            //{name:"applyMatter", rule:"validate[required,maxSize[200]]"},
            //{name:"applyNum", rule:"validate[required,maxSize[50]]"},
            //{name:"materialPerson", rule:"validate[required,maxSize[200]]"},
            //{name:"materialPersonPhone", rule:"validate[required,maxSize[50]]"},
            //{name:"materialPersonAddress", rule:"validate[required,maxSize[200]]"},
            //{name:"receivePerson", rule:"validate[required,maxSize[200]]"},
            //{name:"receivePersonPhone", rule:"validate[required,maxSize[50]]"},
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},
            //{name:"csOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"fhOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"shOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"fgldOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"zxldOpinion", rule:"validate[required,maxSize[1000]]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn, buttonName, status, tab) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        disableBtn(btn);
        butType = tab;
        if ("" != buttonName) {
            $("#status").val(status);
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/sgPermit/save.do", formId);
            }
        } else {
            saveAjaxData("${ctx}/sgPermit/save.do", formId, refreshTabParam);
        }
    }
    function refreshTabParam() {
        if ($("#id").val() == "") {
            var ret = getAjaxData("${ctx}/sgPermit/getSgPermitId.do?projectTypeId=" + $("#projectType").val());
            if (ret != "") {
                var retId = getElementValue(ret, "id");
                if (retId != "") {
                    parent.id = retId;
                    $("#id").val(retId);
                }
            }
        }
        jumpInTab();
    }
    var butType;
    // tab页中跳转 butType为next 或者prev
    function jumpInTab() {
        var target = parent.$("li.tabs-selected");
        if ("tab1" == butType) {
            if ($(target).next()) {
                parent.$('#tabs').tabs('select', $(target).next().text());
            }
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <input type="hidden" name="projectType" id="projectType" value="${bean.projectType.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content">
                    <form:input path="bjbh" cssClass="input_text_long"/>
                </td>
                <td class="form_label_right" nowrap>受理编号：</td>
                <td class="form_content">
                    <form:input path="acceptCode" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content" colspan="3">
                    <form:input path="projectName" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">
                    <form:input path="buildName" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right" style="width: 20%;">建设单位性质：</td>
                <td class="form_content" style="width: 30%;">
                    <form:input path="buildUnitType" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
                <td class="form_label_right" style="width: 15%;">建设单位地址：</td>
                <td class="form_content" style="width: 35%;">
                    <form:input path="buildUnitAddress" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设地点：</td>
                <td class="form_content" colspan="3">
                    <form:input path="buildSite" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设工程类别：</td>
                <td class="form_content" colspan="3">
                    <c:forEach items="${lbs}" var="item">
                        <input type="checkbox" name="buildLbId" value="${item.id}"
                               <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if>>${item.name}&nbsp;
                    </c:forEach>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设工程属性：</td>
                <td class="form_content" colspan="3">
                    <c:forEach items="${sxs}" var="item">
                        <input type="radio" name="buildSx" value="${item.id}"
                               <c:if test="${bean.buildSx.id == item.id}">checked</c:if>>${item.name}&nbsp;
                    </c:forEach>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设工程规模：</td>
                <td class="form_content" colspan="3">
                    <form:input path="buildProjSize" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">合同价格：</td>
                <td class="form_content">
                    <form:input path="contractPrice" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
                <td class="form_label_right">合同工期：</td>
                <td class="form_content">
                    <form:input path="contractPeriod" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">中标价格（万元）：</td>
                <td class="form_content">
                    <form:input path="zbPrice" cssClass="input_text_long" cssStyle="width: 90%;"/>
                </td>
                <td colspan="2"></td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">开工日期：</td>
                <td class="form_content">
                    <form:input path="contractBeginDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('contractBeginDate');">
                </td>
                <td class="form_label_right">完工日期：</td>
                <td class="form_content">
                    <form:input path="contractEndDate" cssClass="input_date" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('contractEndDate');">
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">法定代表人：</td>
                <td class="form_content">
                    <form:input path="fr" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
                <td class="form_label_right">建设单位联系电话：</td>
                <td class="form_content">
                    <form:input path="buildUnitPhone" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位联系人：</td>
                <td class="form_content">
                    <form:input path="buildUnitPerson" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
                <td class="form_label_right">手机号：</td>
                <td class="form_content">
                    <form:input path="buildUnitMobile" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label_right">建设用地批准文件编号：</td>--%>
                <%--<td class="form_content" colspan="3">--%>
                <%--<form:input path="buildFileCode" cssClass="input_text" cssStyle="width: 96%;"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label_right">建设工程规划许可证编号：</td>--%>
                <%--<td class="form_content" colspan="3">--%>
                <%--<form:input path="buildXkzCode" cssClass="input_text" cssStyle="width: 96%;"/>--%>
                <%--</td>--%>
                <%--</tr>--%>
            <tr class="tr_light">
                <td class="form_label_right">现场开工情况：</td>
                <td class="form_content" colspan="3">
                    <form:input path="startWorkCon" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">沪交管收字</td>
                <td class="form_content" colspan="3">
                    （<form:input path="hjgYear" cssClass="input_number" cssStyle="text-align: center;"/> ）
                    第<form:input path="hjgNum" cssClass="input_number" cssStyle="text-align: center;"/>号
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请人：</td>
                <td class="form_content" colspan="3">
                    <form:input path="applyPerson" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请事项：</td>
                <td class="form_content" colspan="3">
                    <form:input path="applyMatter" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请号：</td>
                <td class="form_content" colspan="3">
                    <form:input path="applyNum" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 50%;">申请材料名称</td>
                                <%--<td style="width: 20%;">材料齐全情况</td>--%>
                                <%--<td style="width: 8%;">份数</td>--%>
                            <td style="width: 8%;">应交份数</td>
                            <td style="width: 8%;">实交份数</td>
                            <td style="width: 15%;">附件</td>
                        </tr>
                        <c:forEach items="${applyList}" var="map">
                            <c:set value="upLoad${map.no}" var="upLoadNo"/>
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}
                                    <input type="hidden" name="no" value="${map.no}">
                                </td>
                                <td style="text-align: left;">&nbsp;${map.materialName}</td>
                                    <%--<td style="text-align: center;">--%>
                                    <%--有<input type="radio" name="isFull${map.no}" value="1"--%>
                                    <%--<c:if test="${map.isFull=='true'}">checked="checked"</c:if>>--%>
                                    <%--无<input type="radio" name="isFull${map.no}" value="0"--%>
                                    <%--<c:if test="${map.isFull=='false'}">checked="checked"</c:if>>--%>
                                    <%--</td>--%>
                                    <%--<td style="text-align: center;">--%>
                                    <%--<input type="text" name="num${map.no}" class="input_number" value="${map.num}"--%>
                                    <%--style="text-align: center;">--%>
                                    <%--</td>--%>
                                <td style="text-align: center;">
                                    <c:if test="${map.yjNum != 0}">${map.yjNum}</c:if>
                                    <input type="hidden" name="yjNum${map.no}"
                                           value="<c:if test="${map.yjNum != 0}">${map.yjNum}</c:if>">
                                </td>
                                <td style="text-align: center;">
                                    <input type="text" name="sjNum${map.no}" class="input_number" value="${map.sjNum}"
                                           style="text-align: center;">
                                </td>
                                <td style="text-align: center;">${map[upLoadNo]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">材料提交人：</td>
                <td class="form_content" colspan="3">
                    <form:input path="materialPerson" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">材料提交人联系电话：</td>
                <td class="form_content" colspan="3">
                    <form:input path="materialPersonPhone" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人联系地址：</td>
                <td class="form_content" colspan="3">
                    <form:input path="materialPersonAddress" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">收件人：</td>
                <td class="form_content" colspan="3">
                    <form:input path="receivePerson" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">收件人联系电话：</td>
                <td class="form_content" colspan="3">
                    <form:input path="receivePersonPhone" cssClass="input_text" cssStyle="width: 96%;"/>
                </td>
            </tr>
            <tr class="tr_button" style="text-align: center;">
                <td class="form_content" colspan="4" style="text-align: center;">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save(this,this.value,'${STATUS_SUBMIT}','${tab}')">&nbsp;
                    <input type="button" value="保存" class="button_confirm"
                           onclick="save(this,'','${STATUS_EDIT}','${tab}')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
