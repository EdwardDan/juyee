<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var last_m = "";
    function loadStageData(month,flag) {
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
            $("#beginDate").val("");
            $("#endDate").val("");
        }
        var str = getCondStr();
        setButton(true);
        loadAjaxDataCallback("stageDataDiv", "${ctx}/projectQueryStage/viewStageData.do?id=${id}&month=" + month+"&" + str, resetButton);
    }
    function resetButton(){
        setButton(false);
    }
    function setButton(flag){
        document.getElementById("btnQueryThis").disabled = flag;
        document.getElementById("btnQueryAll").disabled = flag;
    }

    //选择阶段
    function selectStage(btn){
        var str = getCondStr();
        openNewWindow('selectStageDiv','选择阶段',"${ctx}/projectQueryStage/selectStage.do?id=${id}&month=" + last_m+"&" + str,false,600,450);
    }

    //导出
    function printStageData(btn){
        var resultIds = "";
        var ids = "";
        $("input[name=stageIds]").each(function () {
            if ($(this).attr("checked") == "checked" || $(this).attr("checked") == true) {
                var v = $(this).val();
                ids += "," + v;
                var r = $("#result_" + v).val();
                if (r == null || r == "") r = "0";
                resultIds += "," + r;
            }
        });
        if(ids == ""){
            alert("请选择至少一个节点！");
        }else{
            ids = ids.substring(1);
            resultIds = resultIds.substring(1);
            var str = getCondStr()+"&stageIds="+ids+"&resultIds="+resultIds;
            window.open( "${ctx}/projectQueryStage/printExcel.do?id=${id}&month=" + last_m+"&" + str);
        }
    }

    function getCondStr() {
        var s = "projectName=" + $("#projectName").val();
        s += "&bidName=" + $("#bidName").val();
        s += "&jsDept=" + $("#jsDept").val();
        s += "&year=" + $("#year").val();
        s += "&categoryId=" + $("#categoryId").val();
        s += "&qqdj=" + $("#qqdj").val();
        s += "&beginDate=" + $("#beginDate").val();
        s += "&endDate=" + $("#endDate").val();
        return s;
    }

    //显示图示
    function showStatusHint(){
        openNewWindow("showHint","图示说明","${ctx}/view/query/projectQueryStage/showHint.jsp",false,600,300,null);
    }

    //初始化
    $(function () {
        loadStageData("${currentMonth}",'');
    });
</script>
<style type="text/css">
    .td_normal{
        height: 25px;
        /*min-width: 80px;*/
        word-break: break-all;
    }
    .td_active{
        height: 25px;
        /*min-width: 80px;*/
        word-break: break-all;
        background-color: #0074cc;
        font-weight: bold;
    }
    .td_change{
        color: red;
        word-break: break-all;
    }
    .td_note{
        width: 40px;
        height: 20px;
        float: left;
        border: #00458a solid thin;
    }
    .td_note_font{
        height: 20px;
        float: left;
        padding-left: 5px;
        vertical-align: middle;
    }
</style>
<div class="form_div">
    <table cellpadding="1" cellspacing="1" width="500" border="0" <c:if test="${not empty id}">style="display: none"</c:if>>
        <tr class="tr_light">
            <td align="right" width="70" nowrap>项目名称：</td>
            <td align="left" nowrap>
               <input type="text" name="projectName" id="projectName" class="input_text"/>
            </td>
            <td align="right" width="70" nowrap>标段名称：</td>
            <td align="left" nowrap>
                <input type="text" name="bidName" id="bidName" class="input_text"/>
            </td>
            <td align="right" width="70" nowrap>年份：</td>
            <td align="left" nowrap>
                <select name="year" id="year">${yearOptions}</select>
            </td>
            <td align="right" width="70" nowrap>创建时间：</td>
            <td align="left" nowrap>
                从
                <input type="text" name="beginDate" id="beginDate" class="input_date"/>
                <input type="button" class="button_calendar" value="" onClick="calendar('beginDate');">
                到
                <input type="text" name="endDate" id="endDate" class="input_date"/>
                <input type="button" class="button_calendar" value="" onClick="calendar('endDate');">
            </td>
        </tr>
        <tr>
            <td align="right" nowrap>建设单位：</td>
            <td align="left" nowrap>
                <input type="text" name="jsDept" id="jsDept" class="input_text"/>
            </td>
            <td align="right" width="70" nowrap>项目类型：</td>
            <td align="left" nowrap>
                <sys:code code="${PROJ_INFO_CATEGORY}" name="categoryId" id="categoryId" type="select"
                          sysCodeDetailId="" style="width:155px" isAlowedNull="true"/>
            </td>
            <td align="left" nowrap colspan="4">&nbsp;
                区区对接：
                <select name="qqdj" id="qqdj" class="form_select" style="width: 90px;">
                    <option value="">请选择</option>
                    <option value="1012">2010-2012区区对接</option>
                    <option value="1517">2015-2017区区对接</option>
                </select>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="查询" id="btnQueryThis" class="button_all" onclick="loadStageData('',null)"/>
                <input type="button" value="显示全部" id="btnQueryAll" class="button_normal_long" onclick="loadStageData('${currentMonth}','all')"/>
                &nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="showStatusHint()" title="查看图示">【图示说明】</a>
            </td>
        </tr>
        <tr>
            <td align="right" nowrap>上报月份：</td>
            <td align="left" nowrap colspan="7">
                <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="500">
                    <tr align="center">
                        <c:forEach var="m" begin="1" end="12" step="1">
                            <td width="8%" id="td${m}" onclick="loadStageData('${m}','')" <c:choose><c:when test="${currentMonth==m}">class="td_active"</c:when><c:otherwise>class="td_normal" style="cursor: pointer;width: 80px" title="查看当月数据"</c:otherwise></c:choose>>${m}月</td>
                        </c:forEach>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td id="stageDataDiv">
                &nbsp;
            </td>
        </tr>
    </table>
</div>