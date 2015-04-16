<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link href="${themePath}/style_index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    //查看信息发布
    function viewInfo(id) {
        openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
    }

    //页面初始化加载各模块数据
    $(function () {
        $("#mainId").height($("#mainContent").height() - 40);
        loadAjaxDataCallback("jdyy", "${ctx}/platform/mainJdyy.do", loadForGdsb);

    });

    //工地申报
    function loadForGdsb() {
        loadAjaxDataCallback("gdsb", "${ctx}/platform/mainGdsb.do", loadForWsbslc);
    }

    //网上办事流程
    function loadForWsbslc() {
        loadAjaxDataCallback("wsbslc", "${ctx}/platform/mainWsbslc.do", loadForZgdj);
    }

    //整改单据
    function loadForZgdj() {
        loadAjaxDataCallback("zgdj", "${ctx}/platform/mainZgdj.do", showHref);
    }

    function showHref() {
        $("#href").show();
    }
</script>

<div style="width:100%;height:94%;padding-top:10px;position:absolute; overflow-y:auto;min-height:450px" id="mainId">
    <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
        <tr>
            <td id="jdyy">
                <!--  jdyy begin -->

                <!--  jdyy end -->
            </td>
        </tr>
    </table>
    <div class="index_space"></div>
    <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
        <tr>
            <td id="gdsb">
                <!--  gdsb begin -->

                <!--  gdsb end -->
            </td>
        </tr>
    </table>
    <div class="index_space"></div>
    <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
        <tr>
            <td width="50%" id="wsbslc">
                <!--  wsbslc begin -->

                <!--  wsbslc end -->
            </td>
            <td width="10"></td>
            <td id="zgdj">
                <!--  zgdj begin -->

                <!--  zgdj end -->
            </td>
        </tr>
    </table>
    <div class="index_space"></div>
    <div id="href" style="display: none;">
        <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
            <tr>
                <td align="center">
                    <a href="javascript:void(0)" onclick="loadPlatPage('qyzzcx');">
                        <img src="${ctx}/view/platform/images/qyzzcx.png" width="268" height="71"/>
                    </a>
                </td>
                <td align="center">
                    <a href="javascript:void(0)" onclick="loadPlatPage('ryzzcx');">
                        <img src="${ctx}/view/platform/images/ryzgcx.png" width="268" height="71"/>
                    </a>
                </td>
                <td align="center">
                    <a href="javascript:void(0)" onclick="loadPlatPage('xmxxcx');">
                        <img src="${ctx}/view/platform/images/xmxx.png" width="268" height="71"/>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="index_space"></div>

</div>
<%--<script type="text/javascript">--%>
    <%--window.onload = load;--%>
        <%--function load() {--%>
            <%--$("#href").show(1000);--%>
        <%--}--%>
<%--</script>--%>
