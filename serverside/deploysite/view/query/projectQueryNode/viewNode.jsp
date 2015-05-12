<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var last_m = "";
    function loadMonthReport(month,flag) {
        if(month != null && month != ""){
            if (last_m != month) {
                if (last_m != "") {
                    $("#td" + last_m).attr("class", "td_normal");
                }
                $("#td" + month).attr("class", "td_active");
                last_m = month;
            }
        }else{
            month = last_m;
        }
        if (flag == "all") {
            $("#projectName").val("");
            $("#bidName").val("");
            $("#jsDept").val("");
            $("#year").val("${currentYear}");
        }
        var str = "projectName=" + $("#projectName").val() + "&bidName=" + $("#bidName").val() + "&jsDept=" + $("#jsDept").val() + "&year=" + $("#year").val();
        setButton(true);
        loadAjaxDataCallback("nodeDataDiv", "${ctx}/projectQueryNode/viewNodeData.do?id=${id}&month=" + month+"&" + str, resetButton);
    }
    function resetButton(){
        setButton(false);
    }
    function setButton(flag){
        document.getElementById("btnQueryThis").disabled = flag;
        document.getElementById("btnQueryAll").disabled = flag;
    }

    $(function () {
        loadMonthReport("${currentMonth}",'');
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
    <table cellpadding="1" cellspacing="1" width="500" border="0" <c:if test="${not empty id}">style="display: none"</c:if>>
        <tr class="tr_light">
            <td align="right" width="50" nowrap>项目名称：</td>
            <td align="left" nowrap>
                <input type="text" name="projectName" id="projectName" class="input_text"/>
            </td>
            <td align="right" width="50" nowrap>标段名称：</td>
            <td align="left" nowrap>
                <input type="text" name="bidName" id="bidName" class="input_text"/>
            </td>
            <td align="right" width="50" nowrap>年份：</td>
            <td align="left" nowrap>
                <select name="year" id="year">${yearOptions}</select>
            </td>
        </tr>
        <tr>
            <td align="right">建设单位：</td>
            <td align="left">
                <input type="text" name="jsDept" id="jsDept" class="input_text"/>
            </td>
            <td align="right">&nbsp;</td>
            <td align="left" colspan="3">
                <input type="button" value="查询" id="btnQueryThis" class="button_all" onclick="loadMonthReport('',null)"/>
                <input type="button" value="显示全部" id="btnQueryAll" class="button_normal_long" onclick="loadMonthReport('${currentMonth}','all')"/>
            </td>
        </tr>
        <tr>
            <td align="right" nowrap>&nbsp;上报月份：</td>
            <td align="left" colspan="5">
                <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="500">
                    <tr align="center">
                        <c:forEach var="m" begin="1" end="12" step="1">
                            <td width="8%" id="td${m}" onclick="loadMonthReport('${m}','')" <c:choose><c:when test="${currentMonth==m}">class="td_active"</c:when><c:otherwise>class="td_normal" style="cursor: pointer" title="查看当月数据"</c:otherwise></c:choose>>${m}月</td>
                        </c:forEach>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td id="nodeDataDiv">
                &nbsp;
            </td>
        </tr>
    </table>
</div>