<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"csOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"fhOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"shOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"fgldOpinion", rule:"validate[required,maxSize[1000]]"},
            //{name:"zxldOpinion", rule:"validate[required,maxSize[1000]]"},
        ];
        validateInit(validateCondition, formId);
    });
    //保存操作
    function save(btn, buttonName, status) {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn(btn);
        $("#status").val(status);
        if (status == '${STATUS_CS_BACK}' || status == '${STATUS_FH_BACK}' || status == '${STATUS_SH_BACK}' || status == '${STATUS_FGLD_BACK}' || status == '${STATUS_ZXLD_BACK}' || status == '${STATUS_WLD_BACK}') {
            parent.openNewWindow("selectMaterial", "退回选择页面", "${ctx}/sgPermit/selectMaterial.do", true, 400, 200);
        } else {
            savaAudit(buttonName);
        }
    }
    function savaAudit(buttonName) {
        if (confirm("是否确定执行 " + buttonName + " 操作？")) {
            saveAjaxData("${ctx}/sgPermit/saveAudit.do", formId);
        }
    }
</script>
<form:form commandName="bean" name="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <form:hidden path="backNum"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content">${bean.bjbh}</td>
                <td class="form_label_right" nowrap>受理编号：</td>
                <td class="form_content">${bean.acceptCode}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content" colspan="3">${bean.projectName}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">${bean.buildName}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 20%;">建设单位性质：</td>
                <td class="form_content" style="width: 30%;">${bean.buildUnitType}</td>
                <td class="form_label_right" style="width: 15%;">建设单位地址：</td>
                <td class="form_content" style="width: 35%;">${bean.buildUnitAddress}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设地点：</td>
                <td class="form_content" colspan="3">${bean.buildSite}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设工程类别：</td>
                <td class="form_content" colspan="3">
                    <c:forEach items="${lbs}" var="item">
                        <input type="checkbox" name="buildLbId" value="${item.id}"
                               <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if>
                               disabled>${item.name}&nbsp;
                    </c:forEach>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设工程属性：</td>
                <td class="form_content" colspan="3">
                    <c:forEach items="${sxs}" var="item">
                        <input type="radio" name="buildSx" value="${item.id}"
                               <c:if test="${bean.buildSx.id == item.id}">checked</c:if> disabled>${item.name}&nbsp;
                    </c:forEach>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设工程规模：</td>
                <td class="form_content" colspan="3">${bean.buildProjSize}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">合同价格：</td>
                <td class="form_content">${bean.contractPrice}</td>
                <td class="form_label_right">合同工期：</td>
                <td class="form_content">${bean.contractPeriod}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">中标价格（万元）：</td>
                <td class="form_content" colspan="3">${bean.zbPrice}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">开工日期：</td>
                <td class="form_content">
                    <fmt:formatDate value="${bean.contractBeginDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right">完工日期：</td>
                <td class="form_content">
                    <fmt:formatDate value="${bean.contractEndDate}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">法定代表人：</td>
                <td class="form_content">${bean.fr}</td>
                <td class="form_label_right">建设单位联系电话：</td>
                <td class="form_content">${bean.buildUnitPhone}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位联系人：</td>
                <td class="form_content">${bean.buildUnitPerson}</td>
                <td class="form_label_right">手机号：</td>
                <td class="form_content">${bean.buildUnitMobile}</td>
            </tr>
                <%--<tr class="tr_light">--%>
                <%--<td class="form_label_right">建设用地批准文件编号：</td>--%>
                <%--<td class="form_content" colspan="3">${bean.buildFileCode}</td>--%>
                <%--</tr>--%>
                <%--<tr class="tr_dark">--%>
                <%--<td class="form_label_right">建设工程规划许可证编号：</td>--%>
                <%--<td class="form_content" colspan="3">${bean.buildXkzCode}</td>--%>
                <%--</tr>--%>
            <tr class="tr_light">
                <td class="form_label_right">现场开工情况：</td>
                <td class="form_content" colspan="3">${bean.startWorkCon}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">沪交管收字</td>
                <td class="form_content" colspan="3">
                    （${bean.hjgYear}）第&nbsp;${bean.hjgNum}&nbsp;号
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请人：</td>
                <td class="form_content" colspan="3">${bean.applyPerson}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请事项：</td>
                <td class="form_content" colspan="3">${bean.applyMatter}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请号：</td>
                <td class="form_content" colspan="3">${bean.applyNum}</td>
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
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                    <%--<td style="text-align: center;">--%>
                                    <%--有<input type="radio" name="isFull${map.no}" value="1" disabled="true"--%>
                                    <%--<c:if test="${map.isFull=='true'}">checked="checked"</c:if>>--%>
                                    <%--无<input type="radio" name="isFull${map.no}" value="0" disabled="true"--%>
                                    <%--<c:if test="${map.isFull=='false'}">checked="checked"</c:if>>--%>
                                    <%--</td>--%>
                                    <%--<td style="text-align: center;">${map.num}</td>--%>
                                <td style="text-align: center;">${map.yjNum}</td>
                                <td style="text-align: center;">${map.sjNum}</td>
                                <td style="text-align: center;">${map[upLoadNo]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人：</td>
                <td class="form_content" colspan="3">${bean.materialPerson}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">材料提交人联系电话：</td>
                <td class="form_content" colspan="3">${bean.materialPersonPhone}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人联系地址：</td>
                <td class="form_content" colspan="3">${bean.materialPersonAddress}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">收件人：</td>
                <td class="form_content" colspan="3">${bean.receivePerson}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">收件人联系电话：</td>
                <td class="form_content" colspan="3">${bean.receivePersonPhone}</td>
            </tr>
            <tr>
                <td colspan="4">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 25%;">提交材料名称</td>
                            <td style="width: 40%;">审核要求</td>
                            <td style="width: 8%;">初审意见</td>
                            <td style="width: 8%;">复核意见</td>
                            <td style="width: 8%;">审核意见</td>
                        </tr>
                        <c:forEach items="${submitList}" var="map">
                            <input type="hidden" name="no" value="${map.no}"/>
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td style="text-align: left;">${map.auditReq}</td>
                                <td style="text-align: center;">
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_SUBMIT)&&canCsAudit}">
                                            <select name="isCsOpinion${map.no}" id="isCsOpinion${map.no}"
                                                    class="form_select_long" style="width: 70px;">
                                                <option value="1"
                                                        <c:if test="${map.isCsOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isCsOpinion=='false'||map.isCsOpinion==''}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="isCsOpinion${map.no}" id="isCsOpinion${map.no}"
                                                    class="form_select_long" style="width: 70px;" disabled>
                                                <option value="1"
                                                        <c:if test="${map.isCsOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isCsOpinion=='false'||map.isCsOpinion==''}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_CS_PASS)&&canFhAudit}">
                                            <select name="isFhOpinion${map.no}" id="isFhOpinion${map.no}"
                                                    class="form_select_long" style="width: 70px;">
                                                <option value="1"
                                                        <c:if test="${map.isFhOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isFhOpinion=='false'||map.isFhOpinion==''||map.isFhOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="isFhOpinion${map.no}" id="isFhOpinion${map.no}"
                                                    class="form_select_long" style="width: 70px;" disabled>
                                                <option value="1"
                                                        <c:if test="${map.isFhOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isFhOpinion=='false'||map.isFhOpinion==''||map.isFhOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_FH_PASS)&&canAudit}">
                                            <select name="isShOpinion${map.no}" id="isShOpinion${map.no}"
                                                    class="form_select_long"
                                                    style="width: 70px;">
                                                <option value="1"
                                                        <c:if test="${map.isShOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isShOpinion=='false'||map.isShOpinion==''||map.isShOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="isShOpinion${map.no}" id="isShOpinion${map.no}"
                                                    class="form_select_long"
                                                    style="width: 70px;" disabled>
                                                <option value="1"
                                                        <c:if test="${map.isShOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.isShOpinion=='false'||map.isShOpinion==''||map.isShOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>

            <c:if test="${(bean.status==STATUS_SUBMIT)&&canCsAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="csOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>

            <c:if test="${(bean.status==STATUS_CS_PASS)&&canFhAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        <form:hidden path="csOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="fhOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>

            <c:if test="${(bean.status==STATUS_FH_PASS)&&canAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        <form:hidden path="csOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        <form:hidden path="fhOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="shOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>

            <c:if test="${(bean.status==STATUS_SH_PASS)&&canFgldAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        <form:hidden path="csOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        <form:hidden path="fhOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        <form:hidden path="shOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">分管领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="fgldOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>

            <c:if test="${(bean.status==STATUS_FGLD_PASS)&&canZxldAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        <form:hidden path="csOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        <form:hidden path="fhOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        <form:hidden path="shOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">分管领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                        <form:hidden path="fgldOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">中心领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="zxldOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>

            <c:if test="${(bean.status==STATUS_ZXLD_PASS)&&canWldAudit}">
                <tr class="tr_dark">
                    <td class="form_label_right">初审意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.csOpinion}</sys:toHtml>
                        <form:hidden path="csOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                        <form:hidden path="fhOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                        <form:hidden path="shOpinion"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">分管领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                        <form:hidden path="fgldOpinion"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">中心领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
                        <form:hidden path="zxldOpinion"/>
                    </td>
                </tr>

                <tr class="tr_dark">
                    <td class="form_label_right">中心领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <form:textarea path="wldOpinion" cssClass="input_textarea" cssStyle="width: 90%;"/>
                    </td>
                </tr>
            </c:if>
            <tr class="tr_button">
                <td class="form_content" colspan="4" style="text-align: center;">
                    <c:if test="${bean.status==STATUS_SUBMIT}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_CS_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_CS_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_CS_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_FH_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_FH_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_FH_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_SH_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_SH_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_SH_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_FGLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_FGLD_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_FGLD_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_ZXLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_ZXLD_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_ZXLD_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_WLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this,this.value,'${STATUS_WLD_BACK}')">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>
