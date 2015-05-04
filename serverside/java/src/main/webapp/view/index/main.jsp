<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link href="${themePath}/style_index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    <c:if test="${!isRegPerson}">
    //页面初始化加载各模块数据
    $(function () {
        loadForTask();
    });
    function loadForTask() {
        taskIframeId.location.href = "${ctx}/view/index/mainTaskIframe.jsp";
        loadForBulletin();
    }
    function loadForBulletin() {
        loadAjaxDataCallback("bulletinDivId", "${ctx}/mainPage/mainBulletin.do?typeCode=${code_bulletin}", loadForDaily);
    }
    function loadForDaily() {
        loadAjaxDataCallback("dailyDivId", "${ctx}/mainPage/mainDaily.do", loadForMsg);
    }
    function loadForMsg() {
        loadInfoData();
        loadAjaxData("msgDivId", "${ctx}/mainPage/mainMsg.do");
    }

    var car_no = 0;
    function loadInfoData() {
        car_no++;
        if (car_no > 4) return;
        loadAjaxDataCallback("car" + car_no, "${ctx}/mainPage/mainInfo.do?orderNo=" + car_no, loadInfoData);
    }

    //根据显示对象的宽度、字的宽度设置显示的字数。
    function setTitleContent() {
//        setContentByRowWidth();
    }

    //系统推送定制
    function showEditButton(imgId) {
        $("#" + imgId).show();
    }
    function hideEditButton(imgId) {
        $("#" + imgId).hide();
    }
    function editPushUser() {
        loadMainPage("${ctx}/sysPushUser/grid.do","系统推送定制")
    }

    //版块定制
    function editCustomGrid(no){
        openWindow("首页版块定制","${ctx}/sysCustomGridUser/select.do?orderNo="+no,false,400,250);
    }

    //显示版块记录详细信息
    function viewCustomGridDetail(url){
        openWindow("查看详细信息","${ctx}/"+url,false,900,500,null);
    }
    </c:if>
</script>

<div style="width:100%;height:auto;padding-top:0;overflow-y:auto;min-height:450px;" id="mainId">
    <table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
        <tr>
            <td valign="top">
                <!-- main_center begin -->

                <!-- task begin -->
                <div class="index_space" style="height: 16px" onmouseover="showEditButton('taskImgId')"
                     onmouseout="hideEditButton('taskImgId')">
                    <input type="button" class="button_edit" value=" "
                           style="float: right;margin-right: 18px;display: none;cursor: pointer" id="taskImgId"
                           onclick="editPushUser()">
                </div>
                <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="144" onmouseover="showEditButton('taskImgId')"
                            onmouseout="hideEditButton('taskImgId')">
                            <iframe name="taskIframeId" id="taskIframeId" width="100%" height="100%" frameborder="0"
                                    src="${ctx}/welcome.jsp"></iframe>
                        </td>
                    </tr>
                </table>
                <!-- task end -->
                <div class="index_space"></div>

                <!-- car12 begin -->
                <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
                    <tr>
                        <td width="50%" id="car1">
                            <!--  car1 content begin -->

                            <!--  car1 content end -->
                        </td>
                        <td width="10"></td>
                        <td width="50%" id="car2">
                            <!--  car2 content begin -->

                            <!--  car2 content end -->
                        </td>
                    </tr>
                </table>
                <!-- car12 end -->

                <div class="index_space"></div>

                <!-- car34 begin -->
                <table border="0" cellpadding="0" cellspacing="0" width="98%" align="center">
                    <tr>
                        <td width="50%" id="car3">
                            <!--  car3 content begin -->

                            <!--  car3 content end -->
                        </td>
                        <td width="10"></td>
                        <td width="50%" id="car4">
                            <!--  car4 content begin -->

                            <!--  car4 content end -->
                        </td>
                    </tr>
                </table>
                <!-- car34 end -->

                <!-- main_center end -->
            </td>
            <td width="255" valign="top" bgcolor="#eef7fd">
                <div style="height: 5px"></div>
                <!-- msg begin -->
                <table width="240" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td><img src="${themePath}/index_new/dbsx.jpg" width="240" height="37"/></td>
                    </tr>
                    <tr>
                        <td align="center" id="msgDivId" height="120" class="ggl">
                            <!--  msg content begin -->

                            <!--  msg content end -->
                        </td>
                    </tr>
                    <tr>
                        <td><img src="${themePath}/index_new/ggl3.jpg" width="240" height="9"/></td>
                    </tr>
                </table>
                <!-- msg end -->

                <div class="index_space"></div>
                <!-- bulletin begin -->
                <table width="240" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td><img src="${themePath}/index_new/ggl1.jpg" width="240" height="37"/></td>
                    </tr>
                    <tr>
                        <td align="center" id="bulletinDivId">
                            <!--  bulletin content begin -->

                            <!--  bulletin content end -->
                        </td>
                    </tr>
                    <tr>
                        <td><img src="${themePath}/index_new/ggl3.jpg" width="240" height="9"/></td>
                    </tr>
                </table>
                <!-- bulletin end -->

                <div class="index_space"></div>
                <!-- daily begin -->
                <table width="240" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" id="dailyDivId">
                            <!--  daily content begin -->

                            <!--  daily content end -->
                        </td>
                    </tr>
                </table>
                <!-- daily end -->
            </td>
        </tr>
    </table>

    <div class="index_space"></div>
    <div class="index_space"></div>
</div>
