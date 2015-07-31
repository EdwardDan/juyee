<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function loadStageData(flag) {
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
        loadAjaxDataCallback("stageDataDiv", "${ctx}/projectQueryStage/viewStageData.do?id=${id}&" + str, resetButton);
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
        openNewWindow('selectStageDiv','选择阶段',"${ctx}/projectQueryStage/selectStage.do?id=${id}&" + str,false,600,450);
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
            window.open( "${ctx}/projectQueryStage/printExcel.do?id=${id}&" + str);
        }
    }

    function getCondStr() {
        var s = "projectName=" + $("#projectName").val();
        s += "&bidName=" + $("#bidName").val();
        s += "&jsDept=" + $("#jsDept").val();
        s += "&year=" + $("#year").val();
        s += "&categoryId=" + $("#categoryId").val();
        s += "&beginDate=" + $("#beginDate").val();
        s += "&endDate=" + $("#endDate").val();
        return s;
    }

    //初始化
    $(function () {
        loadStageData(null);
    });
</script>
<style type="text/css">
    .td_normal{
        height: 30px;
        min-width: 80px;
        word-break: break-all;
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
                <input type="button" value="查询" id="btnQueryThis" class="button_all" onclick="loadStageData(null)"/>
                <input type="button" value="显示全部" id="btnQueryAll" class="button_normal_long" onclick="loadStageData('all')"/>
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light" style="display: none">
            <td id="stageDataPrintDiv">
                &nbsp;
            </td>
        </tr>
        <tr class="tr_light">
            <td id="stageDataDiv">
                &nbsp;
            </td>
        </tr>
    </table>
</div>