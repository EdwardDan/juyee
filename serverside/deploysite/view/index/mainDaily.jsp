<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .rili_title{
        color: white;
        font-weight: bold;
    }
    .rili_today {
        /*font-family: "宋体";*/
        font-size: 12px;
        text-decoration: none;
        color: #FFFFFF;
        background-image: url( ${themePath}/index_new/rili_td_today.png);
        background-position: right top;
        background-repeat: no-repeat;
        height: 26px;
        width: 14%;
        text-align: center;
        vertical-align: middle
    }

    .rili_weekend {
        /*font-family: "宋体";*/
        font-size: 12px;
        text-decoration: none;
        color: #000000;
        background-image: url( ${themePath}/index_new/rili_weekend.png );
        background-position: right top;
        background-repeat: no-repeat;
        height: 26px;
        width: 14%;
        text-align: center;
        vertical-align: middle
    }

    .rili_normal {
        /*font-family: "宋体";*/
        font-size: 12px;
        text-decoration: none;
        color: #000000;
        background-image: url( ${themePath}/index_new/rili_td.png);
        background-position: right top;
        background-repeat: no-repeat;
        height: 26px;
        width: 14%;
        text-align: center;
        vertical-align: middle
    }
    .rili_none {
        /*font-family: "宋体";*/
        font-size: 12px;
        text-decoration: none;
        color: #BBBBBB;
        background-image: url( ${themePath}/index_new/rili_td.png );
        height: 26px;
        width: 14%;
        text-align: center;
        vertical-align: middle
    }
    .rili_head {
        /*font-family: "宋体";*/
        font-size: 13px;
        text-decoration: none;
        color: #A0A0A0;
        background-color: #FFFFFF;
        font-weight: bold;
        height:20px;
    }
    .rili_head_end {
        /*font-family: "宋体";*/
        font-size: 13px;
        text-decoration: none;
        color: #A0A0A0;
        background-color: #FEF2EC;
        font-weight: bold;
    }
</style>
<script type="text/javascript">
    //按月跳转
    function changeDailyMonth(act){
        loadAjaxData("dailyDivId","${ctx}/mainPage/mainDaily.do?curdate=${curdate}&query="+act);
    }
    function viewDailyplan(dte)
    {
        //打开个人日程页面--按开始结束日期方式查看
        window.open("${ctx}/oa/oaDailyPlan/init.html?startDate=" + dte + "&endDate=" + dte);
    }
</script>

<table width="240" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" height="50" style="background-image: url('${themePath}/index_new/rili_top.png');background-repeat: no-repeat;">
            <table border="0" width="240" cellpadding="0" cellspacing="0" style="padding-top: 15px">
                <tr>
                    <td width="20"><img src="${themePath}/index_new/rili_arrow_left.png" border="0" style="cursor: pointer" onclick="changeDailyMonth('prev')" title="上一月"/></td>
                    <td width="200" align="center" class="rili_title">${title}</td>
                    <td width="20"><img src="${themePath}/index_new/rili_arrow_right.png" border="0" style="cursor: pointer" onclick="changeDailyMonth('next')" title="下一月"/></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="center" height="180" style="background-image: url('${themePath}/index_new/rili_m_bg.png');background-repeat: repeat-y;">
            <!--begin-->
            <table cellpadding="0" cellspacing="0" width="216" border="0" id="curRili">
                <tr align="center" valign="middle">
                    <c:forEach items="${weeks}" var="item" varStatus="status">
                        <c:choose>
                            <c:when test="${status.index==0||status.index==6}">
                                <td width='14%' class='rili_head_end'>${item}</td>
                            </c:when>
                            <c:otherwise>
                                <td width='14%' class='rili_head'>${item}</td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <c:forEach items="${data}" var="item" varStatus="status">
                    <c:if test="${status.index == 0 || (item.no + startNo) % 7 == 1}">
                        <tr align="center" valign="middle" id="${(item.no + startNo)}" id2="${(item.no + startNo)}">
                    </c:if>
                    <td class="${item.tdClass}"  id="SD${status.index}" title="${item.hint}" <c:if test="${item.alert==true}">style="background-image: url(${themePath}/index_new/rili_td_alert.png);cursor: pointer" onclick="viewDailyplan('${item.alertDate}')" </c:if>>${item.day}</td>
                    <c:if test="${item.no > 0 && (item.no + startNo) % 7 == 0}">
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <!--end-->
        </td>
    </tr>
    <tr>
        <td align="center" height="10" style="background-image: url('${themePath}/index_new/rili_bottom.png');background-repeat: no-repeat;"></td>
    </tr>
</table>