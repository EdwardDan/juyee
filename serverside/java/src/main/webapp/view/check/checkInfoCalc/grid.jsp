<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<%--<link href="${ctx}/js_new/FusionCharts/assets/ui/css/style.css" rel="stylesheet" type="text/css" />--%>
<link href="${ctx}/js/FusionCharts/assets/prettify/prettify.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${ctx}/js/FusionCharts/FusionCharts.js"></script>
<%--<script type="text/javascript" src="${ctx}/js_new/FusionCharts/assets/ui/js/jquery-1.4.2.min.js"></script>--%>
<script type="text/javascript" src="${ctx}/js/FusionCharts/assets/prettify/prettify.js"></script>
<script type="text/javascript" src="${ctx}/js/FusionCharts/assets/ui/js/json2.js"></script>
<script type="text/javascript" src="${ctx}/js/FusionCharts/assets/ui/js/lib.js"></script>
<script type="text/javascript" src="${ctx}/js/FusionCharts/assets/ui/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript">
    $(function () {
        loadChart();
//        setTabFrameHeight("tab_iframe");
    });

    function loadChart() {

        var defaultSwf = "MSLine.swf";
//        var defaultSwf = "MSColumn3D.swf";
        var chartDataUrl = "${ctx}/checkInfoCalc/chart.do?gdCode=${gdCode}";
        getChart(chartDataUrl, "chartDiv", "${ctx}/js/FusionCharts/swf/" + defaultSwf, document.getElementById("chartDiv").offsetWidth - 14, "380");
    }
</script>
<div class="form_div">
    <div style="padding: 5px">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF"
               class="table_frame" height=500>
            <tr>
                <td valign="top" height="30">
                    <div class="tab_bg">
                        <!-- title begin -->
                        当月考勤人数统计
                        <!-- title end -->
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="table_out" id="chartDiv" style="height: auto;">
                        &nbsp;
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>