<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script>
    function queryDataByCanlendar(startDate, endDate) {
        $.ajax({
            url: "${ctx}/oaWeekArrange/data.do",
            cache: false,
            data: "startDate=" + startDate + "&endDate=" + endDate,
            success: function (html) {
                $("#results").html(html);
            }
        });
    }
    function doEdit(startDate, endDate) {
        $.ajax({
            url: "${ctx}/oaWeekArrange/modify.do",
            cache: false,
            data: "startDate=" + startDate + "&endDate=" + endDate,
            success: function (html) {
                $("#results").html(html);
            }
        });
    }
</script>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr>
            <td class="tr_title">
                中心领导一周工作安排表
            </td>
        </tr>
        <sys:calendarWeekArrange themePath="${themePath}" requestPage="${requestPage}" startDate="${startDate}"
                      endDate="${endDate}"/>
    </table>
    <div id="results" style="overflow: auto;"></div>
    <br>
</div>
