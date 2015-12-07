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
    function save(buttonName, status) {
        if (!validateForm(formId)) {
            return;
        }
        $("#status").val(status);
        if (confirm("是否确定执行 " + buttonName + " 操作？")) {
            saveAjaxData("${ctx}/sgPermit/saveAudit.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <form:hidden path="csOpinion"/>
    <form:hidden path="fhOpinion"/>
    <form:hidden path="shOpinion"/>
    <form:hidden path="fgldOpinion"/>
    <form:hidden path="zxldOpinion"/>
    <form:hidden path="wldOpinion"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" nowrap>报建编号：</td>
                <td class="form_content" colspan="3">${bean.bjbh}</td>
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
            <tr class="tr_light">
                <td class="form_label_right">建设用地批准文件编号：</td>
                <td class="form_content" colspan="3">${bean.buildFileCode}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设工程规划许可证编号：</td>
                <td class="form_content" colspan="3">${bean.buildXkzCode}</td>
            </tr>
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
                            <td style="width: 20%;">材料齐全情况</td>
                            <td style="width: 8%;">份数</td>
                            <td style="width: 15%;">附件</td>
                        </tr>
                        <c:forEach items="${applyList}" var="map">
                            <c:set value="upLoad${map.no}" var="upLoadNo"/>
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td style="text-align: center;">
                                    有<input type="radio" name="isFull${map.no}" value="1" disabled="true"
                                            <c:if test="${map.isFull=='true'}">checked="checked"</c:if>>
                                    无<input type="radio" name="isFull${map.no}" value="0" disabled="true"
                                            <c:if test="${map.isFull=='false'}">checked="checked"</c:if>>
                                </td>
                                <td style="text-align: center;">${map.num}</td>
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
                            <tr class="tr_dark">
                                <td style="text-align: center;">${map.no}</td>
                                <td style="text-align: left;">${map.materialName}</td>
                                <td style="text-align: left;">${map.auditReq}</td>
                                <td style="text-align: center;">
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_SUBMIT)&&canCsAudit}">
                                            <select name="csOpnion${map.no}" id="csOpnion${map.no}"
                                                    class="form_select_long" style="width: 70px;">
                                                <option value="1" <c:if test="${map.csOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.csOpinion=='false'||map.csOpinion==''}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="csOpnion${map.no}" id="csOpnion${map.no}"
                                                    class="form_select_long" style="width: 70px;" disabled>
                                                <option value="1" <c:if test="${map.csOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.csOpinion=='false'||map.csOpinion==''}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_CS_PASS)&&canFhAudit}">
                                            <select name="fhOpnion${map.no}" id="fhOpnion${map.no}"
                                                    class="form_select_long" style="width: 70px;">
                                                <option value="1" <c:if test="${map.fhOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.fhOpinion=='false'||map.fhOpinion==''||map.fhOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="fhOpnion${map.no}" id="fhOpnion${map.no}"
                                                    class="form_select_long" style="width: 70px;" disabled>
                                                <option value="1" <c:if test="${map.fhOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.fhOpinion=='false'||map.fhOpinion==''||map.fhOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${(bean.status==STATUS_FH_PASS)&&canAudit}">
                                            <select name="shOpnion${map.no}" id="shOpnion${map.no}"
                                                    class="form_select_long"
                                                    style="width: 70px;">
                                                <option value="1" <c:if test="${map.shOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.shOpinion=='false'||map.shOpinion==''||map.shOpinion=='null'}">selected</c:if>>
                                                    不符合
                                                </option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="shOpnion${map.no}" id="shOpnion${map.no}"
                                                    class="form_select_long"
                                                    style="width: 70px;" disabled>
                                                <option value="1" <c:if test="${map.shOpinion=='true'}">selected</c:if>>
                                                    符合
                                                </option>
                                                <option value="0"
                                                        <c:if test="${map.shOpinion=='false'||map.shOpinion==''||map.shOpinion=='null'}">selected</c:if>>
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
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
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
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
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
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">分管领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
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
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">复核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fhOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.shOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">分管领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.fgldOpinion}</sys:toHtml>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">中心领导审核意见：</td>
                    <td class="form_content" colspan="3">
                        <sys:toHtml>${bean.zxldOpinion}</sys:toHtml>
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
                               onclick="save(this.value,'${STATUS_CS_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_CS_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_CS_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_FH_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_FH_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_FH_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_SH_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_SH_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_SH_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_FGLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_FGLD_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_FGLD_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_ZXLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_ZXLD_BACK}')">&nbsp;
                    </c:if>
                    <c:if test="${bean.status==STATUS_ZXLD_PASS}">
                        <input type="button" value="审核通过" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_WLD_PASS}')">&nbsp;
                        <input type="button" value="审核退回" class="button_normal_long"
                               onclick="save(this.value,'${STATUS_WLD_BACK}')">&nbsp;
                    </c:if>
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>