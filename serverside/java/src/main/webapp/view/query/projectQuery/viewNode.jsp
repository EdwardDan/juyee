<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var last_m = "";
    function loadMonthReport(month) {
        if (last_m != month) {
            if (last_m != "") {
                $("#td" + last_m).attr("class", "td_normal");
            }
            $("#td" + month).attr("class", "td_active");
            last_m = month;
        }
        var year = $("#year").val();
        loadAjaxData("monthReportDiv", "${ctx}/projectQuery/viewNodeData.do?id=${id}&year=" + year + "&month=" + month);
    }

    $(function () {
        loadMonthReport("${currentMonth}");
    });
</script>
<style type="text/css">
    .td_normal{
        height: 20px;
        background-color: white;
    }
    .td_active{
        height: 20px;
        background-color: #0074cc;
        font-weight: bold;
    }
</style>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td align="right" width="50" nowrap>&nbsp;上报年份：</td>
            <td align="left">
                <select name="year" id="year">${yearOptions}</select>
            </td>
        </tr>
        <tr>
            <td align="right">&nbsp;上报月份：</td>
            <td align="left">
                <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="500">
                    <tr align="center">
                        <c:forEach var="m" begin="1" end="12" step="1">
                            <td width="8%" id="td${m}" onclick="loadMonthReport('${m}')" <c:choose><c:when test="${currentMonth==m}">class="td_active"</c:when><c:otherwise>class="td_normal" style="cursor: pointer" title="查看当月数据"</c:otherwise></c:choose>>${m}月</td>
                        </c:forEach>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="2" id="monthReportDiv">
                &nbsp;
            </td>
        </tr>
    </table>
</div>