<%@ tag pageEncoding="UTF-8" %>
<%--
 针对领导一周安排
 用法：
 1、在jsp页面中引入taglib
    <%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
 2、在需要系统代码的地方使用如下代码：<sys:calendarWeekArrange themePath="${themePath}" requestPage="${requestPage}" startDate="${startDate}" endDate="${endDate}"/>
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ tag import="com.justonetech.core.utils.StringHelper" %>
<%@ tag import="org.apache.commons.collections.map.LinkedMap" %>
<%@ tag import="java.util.Calendar" %>
<%@ tag import="java.util.Map" %>

<%@ attribute name="colspan" description="该标签在table中所占行数" %>
<%@ attribute name="themePath" required="true" description="css路径" %>
<%@ attribute name="requestPage" required="true" description="查询请求的页面" %>
<%@ attribute name="startDate" required="false" description="开始时间" %>
<%@ attribute name="endDate" required="false" description="结束时间" %>
<%
    Calendar localdate = Calendar.getInstance();
    int month = localdate.get(Calendar.MONTH);
    int year = localdate.get(Calendar.YEAR);
    int week = localdate.get(Calendar.WEEK_OF_MONTH);
    //添加年份
    Map yearMap = new LinkedMap();
    for (int i = year - 4; i < year + 6; i++) {
        yearMap.put(i, i);
    }
    //添加月份
    Map monthMap = new LinkedMap();
    for (int i = 0; i < 12; i++) {
        if (i < 9) {
            monthMap.put(i, "0" + (i + 1));
        } else {
            monthMap.put(i, (i + 1));
        }
    }
    request.setAttribute("week", week);
    request.setAttribute("yearMap", yearMap);
    request.setAttribute("currentYear", year);
    request.setAttribute("monthMap", monthMap);
    request.setAttribute("currentMonth", month);
    request.setAttribute("dateStyle", "display:none");
    request.setAttribute("check1", "checked");
    if (!StringHelper.isEmpty(startDate) && !StringHelper.isEmpty(endDate)) {
        request.setAttribute("check0", "checked");
        request.setAttribute("check1", "");
    }
%>
<%--<tr align="center" class="tr_light">--%>
<%--<td id="timeShow"></td>--%>
<%--</tr>--%>
<tr style="${weekStyle}" id="weekTr" align="center" class="tr_dark">
    <td class="td_dark" align="center" colspan="${colspan}">
        <select name="year" id="year" class="select_normal" onchange="updateWeek();">
            <c:forEach items="${yearMap}" var="year">
                <option value="${year.key}"
                        <c:if test="${currentYear == year.key}">selected</c:if>>${year.value}</option>
            </c:forEach>
        </select>&nbsp;年
        <select name="month" id="month" class="select_normal" onchange="updateWeek();">
            <c:forEach items="${monthMap}" var="month">
                <option value="${month.key}"
                        <c:if test="${currentMonth == month.key}">selected</c:if>>${month.value}</option>
            </c:forEach>
        </select>&nbsp;月
        <select id="week" class="select_normal"/>
    </td>
</tr>
<tr class="tr_light" align="center" style="${dateStyle}" id="dateTr">
    <td height="25" colspan="3" nowrap class="td_dark"> 开始日期:
        <input name="startDate" id="startDate" type="text" class="input_date" value="${startDate}" readonly size="16">
        <img onClick="calendar('startDate')" src="${themePath}/jquery/easyui/buttons/calendar.gif" align="absmiddle"
             style="cursor:pointer">
        ---- 结束日期:
        <input name="endDate" id="endDate" type="text" class="input_date" value="${endDate}" readonly size="16">
        <img onClick="calendar('endDate')" src="${themePath}/jquery/easyui/buttons/calendar.gif" align="absmiddle"
             style="cursor:pointer">
    </td>
</tr>
<tr class="tr_dark" align="center">
    <td colspan="${colspan}" nowrap>
        <input type="radio" name="radiobutton" value="1" onClick="change()" ${check1}>按周查询
        <input type="radio" name="radiobutton" value="0" onClick="change()" ${check0}>按时间段查询
        <input type="button" name="btn_query" value="查询" class="btn_Search" onclick="queryDate(true)">&nbsp;
        <c:if test="${canEdit}">
            <input type="button" class="button_all" value="编辑"
                   onclick="doEdit(document.getElementById('startDate').value,document.getElementById('endDate').value)">
        </c:if>
    </td>
</tr>
<script type="text/javascript">
    //日期格式化，否则在IE9下会有问题
    function date2str(x) {
        var y = "yyyy-MM-dd";
        var z = {M: x.getMonth() + 1, d: x.getDate(), h: x.getHours(), m: x.getMinutes(), s: x.getSeconds()};
        y = y.replace(/(M+|d+|h+|m+|s+)/g, function (v) {
            return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-2);
        });
        return y.replace(/(y+)/g, function (v) {
            return x.getFullYear().toString().slice(-v.length);
        });
    }
    //查询每月周数
    function weeksInMonth(m, y) {
//        y = y || new Date().getFullYear();
//        var d = new Date(y, m, 0);
//        return Math.floor((d.getDate() - 1) / 7) + 1;
        //workable
        var date = new Date(y, m);
        var month = date.getMonth(), year = date.getFullYear(), firstWeekday = new Date(year, month, 1).getDay(), lastDateOfMonth = new Date(year, month + 1, 0).getDate(), offsetDate = date.getDate() + firstWeekday - 1
                , index = 1, weeksInMonth = index + Math.ceil((lastDateOfMonth + firstWeekday - 7) / 7);
        return weeksInMonth;
    }
    //显示周下拉框
    function updateWeek() {
        var year = document.getElementById("year").value;
        var month = document.getElementById("month").value;
        var date = new Date(year, month, 1);
//        var weeks = date.getWeeksOfMonth(); //IE9下不支持
        var weeks = weeksInMonth(month, year);
        document.getElementById("week").options.length = 0;
        for (var i = 1; i <= weeks; i++) {
            document.getElementById("week").options[i - 1] = new Option("第" + i + "周", i);
        }
    }
    //切换查询方式
    function change() {
        var weekTr = document.getElementById("weekTr");
        var dateTr = document.getElementById("dateTr");
        if (document.getElementsByName("radiobutton")[0].checked) {
            weekTr.style.display = "block";
            dateTr.style.display = "none";
        }
        else {
            weekTr.style.display = "none";
            dateTr.style.display = "block";
        }
    }
    //查询
    function queryDate(goButton) {
        var startDate;
        var endDate;
        var year = document.getElementById("year").value;
        var month = document.getElementById("month").value;
        var week = document.getElementById("week").value;
        var date = new Date(year, month, 1);
        var weekFirstDate = (week - 1) * 7 - date.getDay() + 1;
        weekFirstDate = weekFirstDate + 1;  //第一天由周日改为周一
        startDate = date2str(new Date(year, month, weekFirstDate));
        endDate = date2str(new Date(year, month, weekFirstDate + 6));
        if (document.getElementsByName("radiobutton")[1].checked && goButton) {
            check_form();
            if (check == 0) {
                startDate = document.getElementById("startDate").value;
                endDate = document.getElementById("endDate").value;
            } else if (check == 1) {
                alert("对不起,开始时间不能为空!");
                return;
            } else if (check == 2) {
                alert("对不起,结束时间不能为空!");
                return;
            } else if (check == 3) {
                alert("对不起,开始时间不能在结束时间之后!");
                return;
            }
        }
        queryDataByCanlendar(startDate, endDate);
//        timeShow.innerHTML = startDate + "---" + endDate;
        document.getElementById("startDate").value = startDate;
        document.getElementById("endDate").value = endDate;
    }
    var check = 0;
    function check_form() {
        if (document.getElementsByName("radiobutton")[1].checked) {
            if (document.getElementById("startDate").value == "") {
                check = 1;
            } else if (document.getElementById("endDate").value == "") {
                check = 2;
            } else if (document.getElementById("endDate").value < document.getElementById("startDate").value) {
                check = 3;
            } else {
                check = 0;
            }
        }
    }
    $(function () {
        updateWeek();
        document.getElementById("week").selectedIndex = ${week-1};
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        change();
        if (startDate != "" && endDate != "") {
            queryDate(true);
        } else {
            queryDate(false);
        }
    });
</script>