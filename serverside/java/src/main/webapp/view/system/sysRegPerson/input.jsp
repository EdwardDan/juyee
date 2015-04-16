<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">

    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"personName", rule:"validate[required,maxSize[50]]"},
                <c:if test="${isGd}">{name:"gdCode", rule:"validate[required,maxSize[50]]"},
            </c:if>
                <c:if test="${isJs}">{name:"bjbh", rule:"validate[required,maxSize[50]]"},
            </c:if>
                <c:if test="${isJs}">{name:"projectCard", rule:"validate[required,maxSize[50]]"},
            </c:if>
            <c:if test="${isGd||isJs}"> {name:"projectName", rule:"validate[required,maxSize[200]]"},
            </c:if>
                <c:if test="${isSg||isJl}">{name:"unitCode", rule:"validate[required,maxSize[50]]"},
            </c:if>
                <c:if test="${isSg||isJl}">{name:"unitIdentifyCode", rule:"validate[required,maxSize[50]]"},
            </c:if>
                <c:if test="${isSg||isJl}">{name:"unitName", rule:"validate[required,maxSize[200]]"},
            </c:if>
            {name:"mobile", rule:"validate[required,custom[mobile]]"}
            //{name:"acceptDesc", rule:"validate[required,maxSize[200]]"},

        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
    <c:if test="${bean.acceptOpinion!=1&&bean.acceptOpinion!=null}">
        if (document.getElementById("acceptOpinion").value == 1) {
            var item;

            if ($("#gdCode").attr("value") != null) {
                item = document.getElementById("gdCode");
            }
            else if ($("#bjbh").attr("value") != null) {
                item = document.getElementById("bjbh");
            }
            else if ($("#unitCode").attr("value") != null) {
                item = document.getElementById("unitCode");
            }
            getitemName();

        }
    </c:if>

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysRegPerson/save.do", formId);
    }
    function getitemName() {
        var regTypeCode = document.getElementById("regTypeCode").value;
        var obj;
        var item;
        if (regTypeCode == '${SYS_REGPERSON_TYPE_Gd}') {
            obj = document.getElementById("gdCode").value;
        }
        else if (regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_JS}') {
            obj = document.getElementById("bjbh").value;
        }
        else if (regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_SG}'||regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_JL}') {
            obj = document.getElementById("unitCode").value + "," + document.getElementById("bjbh").value;
            if (document.getElementById("unitCode").value == "" || document.getElementById("bjbh").value == "")
                return false;
        }

        if (obj == "" || obj == null) {

            return false;
        } else {
            item = obj;
        }
        var msg = getAjaxData("${ctx}/site/getReg.do?loginName=" + item + "&regType=" + regTypeCode);


        if (regTypeCode == '${SYS_REGPERSON_TYPE_Gd}' || regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_JS}') {
            if (msg.success == "true") {
                document.getElementById("projectName").value = msg.msg;
                document.getElementById("msg").innerHTML = "";
            } else {
                document.getElementById("projectName").value = "";
                document.getElementById("msg").innerHTML = msg.msg;
            }
        } else if (regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_SG}' || regTypeCode == '${SYS_REGPERSON_TYPE_UNIT_JL}') {
            if (msg.success == "true") {
                document.getElementById("unitName").value = msg.msg;
                document.getElementById("msg").innerHTML = "";
            } else {
                document.getElementById("unitName").value = "";
                document.getElementById("msg").innerHTML = msg.msg;
            }
        }

    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" value="${bean.regType.id}" name="regType" id="regType">
    <input type="hidden" value="${bean.regType.code}" name="regTypeCode" id="regTypeCode">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <c:if test="${isGd}">
                <tr class="tr_dark">
                    <td class="form_label">工地编号：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.gdCode}<form:hidden
                            path="gdCode"/></c:when><c:otherwise>
                        <form:input path="gdCode" cssClass="input_text_long" onblur="getitemName(this)"/><input
                            type="button" value="获取" class="button_all" name="btn" onclick="getitemName()">
                        <div
                                id="msg"
                                style="color:red;display:inline"></div>
                    </c:otherwise></c:choose>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isJs}">
                <tr class="tr_light">
                    <td class="form_label">报建编号：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.bjbh}<form:hidden path="bjbh"/></c:when><c:otherwise>
                        <form:input path="bjbh" cssClass="input_text_long" onblur="getitemName(this)"/>
                        <input type="button" value="获取" class="button_all"
                               name="btn"
                               onclick="getitemName()"><span
                            id="msg"
                            style="color:red"></span></c:otherwise></c:choose>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isJs}">
                <tr class="tr_dark">
                    <td class="form_label">项目卡号：</td>
                    <td class="form_content">
                        <form:input path="projectCard" cssClass="input_text_long"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isGd||isJs}">
                <tr class="tr_light">
                    <td class="form_label">工程名称：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.projectName}<form:hidden
                            path="projectName"/></c:when><c:otherwise>
                        <form:input path="projectName" cssClass="input_text_long"
                                    readonly="true"/></c:otherwise></c:choose>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isSg||isJl}">
                <tr class="tr_dark">
                    <td class="form_label">报建编号：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.bjbh}<form:hidden path="bjbh"/></c:when><c:otherwise>
                        <form:input path="bjbh" cssClass="input_text_long" />
                       </c:otherwise></c:choose>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label">企业编码：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.unitCode}<form:hidden
                            path="unitCode"/></c:when><c:otherwise>
                        <form:input path="unitCode" cssClass="input_text_long" onblur="getitemName(this)"/><input type="button"
                            value="获取"
                            class="button_all"
                            name="btn"
                            onclick="getitemName()"><span
                            id="msg"
                            style="color:red"></span></c:otherwise></c:choose>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isSg||isJl}">
                <tr class="tr_dark">
                    <td class="form_label">企业标识码：</td>
                    <td class="form_content">
                        <form:input path="unitIdentifyCode" cssClass="input_text_long"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${isSg||isJl}">
                <tr class="tr_light">
                    <td class="form_label">企业名称：</td>
                    <td class="form_content"><c:choose><c:when
                            test="${bean.acceptOpinion==1}">${bean.unitName}<form:hidden
                            path="unitName"/></c:when><c:otherwise>
                        <form:input path="unitName" cssClass="input_text_long"
                                    readonly="true"/></c:otherwise></c:choose>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_dark">
                <td class="form_label">联系人：</td>
                <td class="form_content">
                    <form:input path="personName" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">手机号码：</td>
                <td class="form_content">
                    <form:input path="mobile" cssClass="input_text_long"/>
                </td>
            </tr>
            <c:if test="${bean.id==null}"><input type="hidden" value="0" name="regResource"></c:if>
            <c:if test="${bean.id!=null}"><input type="hidden" value="${bean.regResource}" name="regResource"></c:if>
            <c:if test="${bean.id!=null}">
                <tr class="tr_dark">
                    <td class="form_label">受理意见：</td>
                    <td class="form_content">
                        <c:if test="${bean.acceptOpinion==1}">已通过</c:if>
                        <c:if test="${bean.acceptOpinion!=1}">
                            <select id="acceptOpinion" name="acceptOpinion">${option}
                            </select>
                        </c:if>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_light">
                <td class="form_label">受理描述：</td>
                <td class="form_content">
                    <form:textarea path="acceptDesc" cssClass="input_textarea"/>
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