<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link href="${themePath}/style_index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    //页面初始化加载各模块数据
    $(function () {
        $("#mainId").height($("#mainContent").height() - 40);
        loadAjaxDataCallback("sgxk", "${ctx}/platform/mainSgxk.do");
    });

    function showHref() {
        $("#href").show();
    }
</script>

<div style="width:100%;height:94%;padding-top:10px;position:absolute; overflow-y:auto;min-height:450px" id="mainId">
    <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
        <tr>
            <td id="sgxk">
                <!--  jdyy begin -->

                <!--  jdyy end -->
            </td>
        </tr>
    </table>
    <div class="index_space"></div>
</div>
