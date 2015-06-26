<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
    });
    function doInit() {
        loadMainPage("${ctx}/oaWeekArrange/init.do", null);
    }
    function doSave() {
        saveAjaxData("${ctx}/oaWeekArrange/save.do?start=${start}", formId);
    }
</script>
<form name="bean" id="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="1" class="table_thin_line_center" border="1" style="width: 98%;">
            <tr class="tr_header">
                <td width="10%" nowrap colspan="2">姓名</td>
                <c:forEach items="${weekDates}" var="week">
                    <td width="10%" nowrap>${week}</td>
                </c:forEach>
            </tr>
            <c:forEach items="${userList}" var="user" varStatus="status1">
                <c:forEach items="${periodList}" var="period" varStatus="status2">
                    <tr class="tr_dark">
                        <c:if test="${status2.index==0}">
                            <td rowspan="${fn:length(periodList)}">${user.displayName}</td>
                        </c:if>
                        <td>${period.name}</td>
                        <td>
                            <c:set var="content_0" value="content_${user.id}_${period.id}_${dates[0]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[0]}"
                                   value="${mapHM[content_0]}">
                        </td>
                        <td>
                            <c:set var="content_1" value="content_${user.id}_${period.id}_${dates[1]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[1]}"
                                   value="${mapHM[content_1]}">
                        </td>
                        <td>
                            <c:set var="content_2" value="content_${user.id}_${period.id}_${dates[2]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[2]}"
                                   value="${mapHM[content_2]}">
                        </td>
                        <td>
                            <c:set var="content_3" value="content_${user.id}_${period.id}_${dates[3]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[3]}"
                                   value="${mapHM[content_3]}">
                        </td>
                        <td>
                            <c:set var="content_4" value="content_${user.id}_${period.id}_${dates[4]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[4]}"
                                   value="${mapHM[content_4]}">
                        </td>
                        <td>
                            <c:set var="content_5" value="content_${user.id}_${period.id}_${dates[5]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[5]}"
                                   value="${mapHM[content_5]}">
                        </td>
                        <td>
                            <c:set var="content_6" value="content_${user.id}_${period.id}_${dates[6]}"/>
                            <input type="text" class="input_text" name="content_${user.id}_${period.id}_${dates[6]}"
                                   value="${mapHM[content_6]}">
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
            <tr class="tr_dark">
                <td colspan="2">备注：</td>
                <td colspan="7" style="text-align: left;">（）内为待定事项</td>
            </tr>
        </table>
        <br>

        <div class="form_div">
            <input type="button" value="保存" class="button_confirm" onclick="doSave()">
            <input type="button" value="返回" class="button_back" onclick="doInit()">
        </div>
    </div>
</form>
