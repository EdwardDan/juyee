<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    //    var last_m = "";
    function loadMonthReport(month, flag) {
//        if (month != null && month != "") {
//            if (last_m != month) {
//                if (last_m != "") {
//                    $("#td" + last_m).attr("class", "td_normal");
//                }
//                $("#td" + month).attr("class", "td_active");
//                last_m = month;
//            }
//        } else {
//            month = last_m;
//        }
        if (flag == "all") {
            $("#projectName").val("");
            $("#bidName").val("");
            $("#jsDept").val("");
            $("#year").val("${currentYear}");
        }
        var str = getCondStr();
        <c:if test="${empty id}">
        setButton(true);
        </c:if>
        if (month == '') {
            month = $("#month").val();
        }
        var year = $("#year").val();
        loadAjaxDataCallback("nodeDataDiv", "${ctx}/projectQueryNode/viewNodeData.do?id=${id}&month=" + month + "&year=" + year + "&" + str, resetButton);
    }
    function resetButton() {
        setButton(false);
    }
    function setButton(flag) {
        document.getElementById("btnQueryThis").disabled = flag;
        document.getElementById("btnQueryAll").disabled = flag;
    }

    //选择节点
    function selectNode(btn) {
        var str = getCondStr();
        openNewWindow('selectNodeDiv', '选择节点', "${ctx}/projectQueryNode/selectNode.do?id=${id}&month=" + $("#month").val() + "&year=" + $("#year").val() + "&" + str, false, 700, 450);
    }

    //导出
    function printMonthReport(btn) {
//        var ids = "";
//        $("input[name=nodeIds]").each(function () {
//            if ($(this).attr("checked") == "checked" || $(this).attr("checked") == true) {
//                ids += "," + $(this).val();
//            }
//        });
//        if (ids == "") {
//            alert("请选择至少一个节点！");
//        } else {
//            ids = ids.substring(1);
//            var str = getCondStr() + "&nodeIds=" + ids;
        var str = getCondStr();
        window.open("${ctx}/projectQueryNode/printExcel.do?id=${id}&month=" + $("#month").val() + "&year=" + $("#year").val() + "&" + str);
        <%--window.open("${ctx}/projectQueryNode/printExcel.do?id=${id}&month=" + last_m + "&" + str);--%>
//        }
    }

    function getCondStr() {
        var s = "projectName=" + encodeURI($("#projectName").val());
        s += "&propertyId=" + $("#propertyId").val();
        s += "&isMajor=" + $("#isMajor").val();
        s += "&qqdj=" + $("#qqdj").val();
        s += "&jsDept=" + encodeURI($("#jsDept").val());
        s += "&qqdj=" + $("#qqdj").val();
        s += "&categoryId=" + $("#categoryId").val();
        s += "&belongAreaId=" + $("#belongAreaId").val();
        s += "&infoStageId=" + $("#infoStageId").val();
        return s;
    }

    //初始化
    $(function () {
        loadMonthReport("${currentMonth}", '');
    });
</script>
<style type="text/css">
    .td_normal {
        height: 25px;
        /*min-width: 80px;*/
        word-break: break-all;
        background-color: white;
    }

    .td_active {
        height: 25px;
        /*min-width: 80px;*/
        word-break: break-all;
        background-color: #0074cc;
        font-weight: bold;
    }
</style>
<div class="form_div">
    <table cellpadding="1" cellspacing="1" width="500" border="0">
        <c:if test="${empty id}">
            <tr class="tr_light">
                <td align="right" width="70" nowrap>项目名称：</td>
                <td align="left" nowrap>
                    <input type="text" name="projectName" id="projectName" class="input_text"/>
                </td>

                <td align="right" width="70" nowrap>年份：</td>
                <td align="left" nowrap>
                    <select id="year" name="year" onchange="loadMonthReport('','')">
                            ${yearOptions}
                    </select>年
                    <select id="month" name="month" onchange="loadMonthReport('','')">
                            ${monthOptions}
                    </select>月
                </td>
                <td align="right" width="70" nowrap>管理属性：</td>
                <td align="left" nowrap>
                    <sys:code code="${PROJ_INFO_PROPERTY}" name="propertyId" id="propertyId" type="select"
                              sysCodeDetailId="" style="width: 100px;" isAlowedNull="true"/>
                </td>
                <td align="right" width="70" nowrap>是否重大：</td>
                <td align="left" nowrap>
                    <select name="isMajor" id="isMajor" class="form_select" style="width: 100px;">
                        <option value="">请选择</option>
                        <option value="1">重大</option>
                        <option value="0">非重大</option>
                    </select>
                </td>
                <td align="right" width="70" nowrap>项目属性：</td>
                <td align="left" nowrap>
                        <%--<select name="qqdj" id="qqdj" class="form_select" style="width: 120px;">--%>
                        <%--<option value="">请选择</option>--%>
                        <%--<option value="1012">2010-2012区区对接</option>--%>
                        <%--<option value="1517">2015-2017区区对接</option>--%>
                        <%--</select>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <sys:code code="${PORJECT_PROJ_PROPERTY}" name="qqdj" id="qqdj" type="select"
                              sysCodeDetailId="" style="width:100" isAlowedNull="true"/>
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
                              sysCodeDetailId="" style="width:100px" isAlowedNull="true"/>
                </td>
                <td align="right" width="70" nowrap>区县：</td>
                <td align="left" nowrap>
                    <sys:code code="${PROJ_INFO_BELONG_AREA}" name="belongAreaId" id="belongAreaId" type="select"
                              sysCodeDetailId="" style="width:100px" isAlowedNull="true"/>
                </td>
                <td align="right" width="70" nowrap>项目状态：</td>
                <td align="left" nowrap>
                    <sys:code code="${PROJ_INFO_STAGE}" name="infoStageId" id="infoStageId" type="select"
                              sysCodeDetailId="" style="width:100px" isAlowedNull="true"/>
                </td>
                <td align="left" nowrap colspan="3">&nbsp;
                    <input type="button" value="查询" id="btnQueryThis" class="button_all"
                           onclick="loadMonthReport('',null)"/>
                    <input type="button" value="显示全部" id="btnQueryAll" class="button_normal_long"
                           onclick="loadMonthReport('${currentMonth}','all')"/>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty id}">
            <tr>
                <td align="right" nowrap>查看月份：</td>
                <td align="left" nowrap colspan="7">
                    <select id="year" name="year" onchange="loadMonthReport('','')">
                            ${yearOptions}
                    </select>年
                    <select id="month" name="month" onchange="loadMonthReport('','')">
                            ${monthOptions}
                    </select>月
                </td>
            </tr>
        </c:if>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td id="nodeDataDiv">
                &nbsp;
            </td>
        </tr>
    </table>
    <div style="height: 30px;"></div>
</div>