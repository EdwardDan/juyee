<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    function loadStageData(flag) {
        if (flag == "all") {
            $("#projectName").val("");
            $("#bidName").val("");
            $("#jsDept").val("");
            $("#year").val("${currentYear}");
        }
        var str = "projectName=" + $("#projectName").val() + "&bidName=" + $("#bidName").val() + "&jsDept=" + $("#jsDept").val() + "&year=" + $("#year").val();
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
        var str = "projectName=" + $("#projectName").val() + "&bidName=" + $("#bidName").val() + "&jsDept=" + $("#jsDept").val() + "&year=" + $("#year").val();
        openNewWindow('selectStageDiv','选择阶段',"${ctx}/projectQueryStage/selectStage.do?id=${id}&" + str,false,600,450);
    }

    //导出
    function printStageData(btn){
        var ids = "";
        $("input[name=stageIds]").each(function(){
            if($(this).attr("checked")=="checked"||$(this).attr("checked")==true){
                ids += ","+$(this).val();
            }
        });
        if(ids == ""){
            alert("请选择至少一个节点！");
        }else{
            ids = ids.substring(1);
            var str = "projectName=" + $("#projectName").val() + "&bidName=" + $("#bidName").val() + "&jsDept=" + $("#jsDept").val() + "&year=" + $("#year").val();
            str += "&stageIds="+ids;
            window.open( "${ctx}/projectQueryStage/printExcel.do?id=${id}&" + str);
        }
    }

    //初始化
    $(function () {
        loadStageData(null);
    });
</script>
<style type="text/css">
    .td_normal{
        min-width: 60px;
        height: 30px;
    }
    .td_change{
        color: red;
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
        </tr>
        <tr>
            <td align="right" nowrap>建设单位：</td>
            <td align="left" nowrap>
                <input type="text" name="jsDept" id="jsDept" class="input_text"/>
            </td>
            <td align="right" nowrap>&nbsp;</td>
            <td align="left" colspan="3" nowrap>
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