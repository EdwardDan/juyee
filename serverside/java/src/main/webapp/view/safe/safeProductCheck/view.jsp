<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //计算总扣分
        totalKfSum();
    });
    //计算扣分总和
    function totalKfSum() {
        var totalKjScore = 0;
        $('.input_number_short').each(function () {
            var num = parseFloat(this.value);
            if (!isNaN(num)) {
                totalKjScore += parseFloat(this.value);
            }
        });
        $('td[id^=totalKjScore]').html(totalKjScore);
    }
    //打印
    function doPrint() {
        printFR("SafeProductCheck", "id=${bean.id}");
    }
</script>
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
                            <td width="30%" align="left" nowrap>${bean.gdCode}</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">项目名称：</td>
                            <td class="form_content" colspan="3">${bean.projectName}</td>
                        </tr>
                        <tr class="tr_light">
                            <td class="form_label_right" width="15%">施工单位：</td>
                            <td class="form_content" width="35%">${bean.sgdwmc}</td>
                            <td class="form_label_right" width="15%">受监安监站：</td>
                            <td class="form_content" width="35%">&nbsp;${sjajz}</td>
                        </tr>
                        <tr class="tr_dark">
                            <td class="form_label_right" width="15%">监理单位：</td>
                            <td class="form_content" width="35%">${bean.jldwmc}</td>
                            <td class="form_label_right" width="15%">考核季度：</td>
                            <td class="form_content" width="35%">
                                ${bean.year}年第${bean.quarter}季度
                            </td>
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
                                        <fmt:formatNumber value="${checkItemMap[item2.id].score}" pattern="#"
                                                          type="number"/>
                                        <input type="hidden" class="input_number_short"
                                               name="score${item2.id}" id="${item1.id}_${item2.id}"
                                               value="${checkItemMap[item2.id].score}">
                                    </td>
                                    <c:if test="${level2.index==0}">
                                        <td rowspan="${item1.size}" align="center">
                                            <fmt:formatNumber value="${item1.score}" pattern="#" type="number"/>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                        <tr class="tr_dark">
                            <td align="right" colspan="2">总分：</td>
                            <td align="center" id="totalKjScore"></td>
                            <td align="center">
                                <fmt:formatNumber value="${bean.totalScore}" pattern="#" type="number"/>
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
                                整改单&nbsp;${bean.reformNum}&nbsp;次，
                                暂缓单&nbsp;${bean.stopformNum}&nbsp;次，
                                处罚&nbsp;${bean.punishNum}&nbsp;次，
                                其他&nbsp;${bean.otherNum}&nbsp;次。
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td align="left">&nbsp;情况说明：</td>
                            <td colspan="2" align="left">
                                季度综合确认等级：${bean.levelDesc}
                            </td>
                        </tr>
                        <tr class="tr_light">
                            <td align="left">
                                <sys:toHtml>${bean.description}</sys:toHtml>
                            </td>
                            <td colspan="2" align="left">
                                企业：共应到现场检查&nbsp;${bean.planCheckNum}&nbsp;次，
                                实到&nbsp;${bean.actualCheckNum}&nbsp;次
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
                                <%--<input type="button" value="打印" class="button_all" onclick="doPrint()">--%>
                                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>
</div>