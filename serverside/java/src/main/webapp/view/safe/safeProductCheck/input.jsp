<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "gdCode", rule: "validate[required,maxSize[50]]"},
            {name: "projectName", rule: "validate[required,maxSize[200]]"},
            {name: "sgdwmc", rule: "validate[required,maxSize[200]]"},
            {name: "jldwmc", rule: "validate[required,maxSize[200]]"},
            {name: "year", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "quarter", rule: "validate[required,custom[integer],maxSize[2]"},
            {name: "totalScore", rule: "validate[required,custom[integer],maxSize[5]"},
            {name: "content", rule: "validate[required,maxSize[2000]]"},
            {name: "reformNum", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "stopformNum", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "punishNum", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "otherNum", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "levelDesc", rule: "validate[required,maxSize[50]]"},
            {name: "planCheckNum", rule: "validate[required,custom[integer],maxSize[4]"},
            {name: "actualCheckNum", rule: "validate[required,custom[integer],maxSize[4]"}
        ];
        $('input[id^=kf]').each(function () {
            validateCondition.push({name: this.name, rule: "validate[required,custom[integer],maxSize[4]"});
        });
        validateInit(validateCondition, formId);
        //计算总扣分
        totalKfSum();
    });
    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/safeProductCheck/save.do", formId);
    }
    //通过gdCode编号获取工地信息
    function getGdInfo(btn) {
        var gdCode = $("#gdCode").val();
        if (gdCode == "") {
            showInfoMsg("请输入工地编号!");
            return;
        }
        btn.value = "请稍候";
        btn.disabled = true;
        $.ajax({
            url: "${ctx}/safeProductCheck/getGdInfo.do?gdCode=" + gdCode,
            cache: false,
            data: "",
            success: function (ret) {
                if (ret.indexOf("{") >= 0) {
                    var json = eval("(" + ret + ")");
                    var data = json[0];
                    if (data.gdName != "") {
                        $("#gdCode").val(data.gdCode);
                        $("#sgdwmc").val(data.sgdwmc);
                        $("#jldwmc").val(data.jldwmc);
                    }
                } else {
                    showInfoMsg("未找到任何工地信息，请重新输入工地编号！");
                }
                btn.value = "获取";
                btn.disabled = false;
            }, error: function () {
                btn.value = "获取";
                btn.disabled = false;
            }
        });
    }
    //计算扣分总和
    function totalKfSum() {
        var totalKjScore = 0;
        $('input[id^=kf]').each(function () {
            var num = parseFloat(this.value);
            if (!isNaN(num)) {
                totalKjScore += parseFloat(this.value);
            }
        });
        $('#totalKjScore').val(totalKjScore);
    }
    $(document).ready(function () {
        $('input[id^=kf]').change(function () {
            totalKfSum();
        });
    });
    //计算实际得分
    function countSjScore(id, scoreLimit) {
        var totalKf = 0;
        $('input[id^=kf' + id + ']').each(function () {
            var score = parseFloat(this.value);
            if (!isNaN(score)) {
                totalKf += score;
            }
        });
        var sjScore = parseFloat(scoreLimit) - parseFloat(totalKf);
        if (parseFloat(sjScore) > 0.0) {
            $('input[id^=score' + id + ']').val(sjScore);
        } else {
            $('input[id^=score' + id + ']').val(0);
        }
        //计算实际总得分
        var totalSj = 0;
        $('input[id^=score]').each(function () {
            var score = parseFloat(this.value);
            if (!isNaN(score)) {
                totalSj += score;
            }
        });
        $("#totalScore").val(parseFloat(totalSj));
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="year" value="${year}">
    <input type="hidden" name="quarter" value="${quarter}">

    <div class="form_div" align="center">
        <fieldset class="form_fieldset" style="width: 95%;margin: 0 auto;">
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr align="center">
                                <td colspan="2">
                                    <span class="net_form_title">安全生产标准化达标工地季度确认评分表</span>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td width="70%" align="right">工地编号：</td>
                                <td width="30%" align="left" nowrap>
                                    <form:input path="gdCode" cssClass="input_text"/>
                                    <input type="button" value="获取" class="button_all" onclick="getGdInfo(this)">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%">项目名称：</td>
                                <td class="form_content" colspan="3">
                                    <form:input path="projectName" cssClass="input_text_long" cssStyle="width: 70%;"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td class="form_label_right" width="15%">施工单位：</td>
                                <td class="form_content" width="35%">
                                    <form:input path="sgdwmc" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label_right" width="15%">受监安监站：</td>
                                <td class="form_content" width="35%">${sjajz}</td>
                            </tr>
                            <tr class="tr_dark">
                                <td class="form_label_right" width="15%">监理单位：</td>
                                <td class="form_content" width="35%">
                                    <form:input path="jldwmc" cssClass="input_text_long"/>
                                </td>
                                <td class="form_label_right" width="15%">考核季度：</td>
                                <td class="form_content" width="35%">${bean.year}年第${bean.quarter}季度</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
                            <tr class="tr_header">
                                <td align="center" rowspan="3" width="20%">项目</td>
                                <td align="center" rowspan="3" width="60%">考核内容</td>
                                <td align="center" colspan="2" width="20%">受监站</td>
                            </tr>
                            <tr class="tr_header">
                                <td align="center" colspan="2">季度</td>
                            </tr>
                            <tr class="tr_header">
                                <td align="center" width="10%">扣减分</td>
                                <td align="center" width="10%">实得分</td>
                            </tr>
                            <c:forEach items="${mapList}" var="item1" varStatus="level1">
                                <c:forEach items="${item1.item.safeProductStandards}" var="item2" varStatus="level2">
                                    <tr <c:choose>
                                        <c:when test="${(level2.index+1)%2==0}">
                                            class="tr_light"
                                        </c:when>
                                        <c:otherwise>
                                            class="tr_dark"
                                        </c:otherwise>
                                    </c:choose>>
                                        <c:if test="${level2.index==0}">
                                            <td rowspan="${item1.size}" align="center">
                                                    ${item1.name}
                                            </td>
                                        </c:if>
                                        <td>${item2.itemName}</td>
                                        <td align="center">
                                            <input type="text" class="input_number_short"
                                                   name="score${item2.id}" id="kf${item1.id}_${item2.id}"
                                                   value="<fmt:formatNumber value="${checkItemMap[item2.id].score}" pattern="#" type="number"/>"
                                                   onblur="countSjScore('${item1.id}',' ${item1.scoreLimit}')">
                                            <input type="hidden" name="standIds" value="${item2.id}">
                                        </td>
                                        <c:if test="${level2.index==0}">
                                            <td rowspan="${item1.size}" align="center">
                                                <input type="text" class="input_number_short" readonly="true"
                                                       value="<fmt:formatNumber value="${item1.score}" pattern="#" type="number"/>"
                                                       name="${item1.inputName}" id="${item1.inputName}">
                                                <input type="hidden" name="standParentIds" value="${item1.id}">
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                            <tr class="tr_dark">
                                <td align="right" colspan="2">总分：</td>
                                <td align="center">
                                    <input type="text" id="totalKjScore" name="totalKjScore"
                                           value="<fmt:formatNumber value="" pattern="#" type="number"/>"
                                           style="text-align:center;padding: 0px" class="input_number_short"
                                           readonly="true">
                                </td>
                                <td align="center">
                                    <input type="text" id="totalScore" name="totalScore"
                                           value="<fmt:formatNumber value="${bean.totalScore}" pattern="#" type="number"/>"
                                           style="text-align:center;padding: 0px" class="input_number_short"
                                           readonly="true">
                                </td>
                            </tr>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr class="tr_light">
                                <td align="left">&nbsp;监督机构季度确认意见并盖章：</td>
                                <td align="left">本季度监督情况：</td>
                                <td align="left">
                                    整改单<form:input path="reformNum" cssClass="input_text_short"/> 次，
                                    暂缓单<form:input path="stopformNum" cssClass="input_text_short"/>次，
                                    处罚<form:input path="punishNum" cssClass="input_text_short"/>次，
                                    其他<form:input path="otherNum" cssClass="input_text_short"/>次。
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td align="left">&nbsp;情况说明：</td>
                                <td colspan="2" align="left">
                                    季度综合确认等级：<form:radiobuttons path="levelId" items="${levelMap}"/>
                                </td>
                            </tr>
                            <tr class="tr_light">
                                <td align="left">
                                    <form:textarea path="description" cssClass="input_textarea"/>
                                </td>
                                <td colspan="2" align="left">
                                    企业：共应到现场检查<form:input path="planCheckNum" cssClass="input_text_short"/>次，
                                    实到<form:input path="actualCheckNum" cssClass="input_text_short"/>次。
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" class="form_table">
                            <tr align="center">
                                <td>
                                    <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
</form:form>