<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script>
    function queryDataByCanlendar(startDate, endDate) {
        $.ajax({
            url: "${ctx}/oaMeeting/viewMeeting.do",
            cache: false,
            data: "startDate=" + startDate + "&endDate=" + endDate,
            success: function (html) {
                $("#results").html(html);
            }
        });
    }
    function viewMeeting(id){
        parent.openWindow("查看会议", "${ctx}/oaMeeting/view.do?id=" + id, false);
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <sys:calendar themePath="" requestPage="" startDate="" endDate=""/>
    </table>
    <div id="results" style="overflow: auto;"></div>
    <br>
    <table cellpadding="0" cellspacing="0" class="form_table" style="width: 30%" align="center">
        <tr class="tr_light">
            <c:forEach items="${colorDeclare}" var="entry">
                <td width="10%" align="right">${entry.key}:</td>
                <td style="background-color: ${entry.value}" width="10%"></td>
            </c:forEach>
        </tr>
    </table>
</div>