<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        $("#myTable").chromatable({
            width: "100%", // specify 100%, auto, or a fixed pixel amount
            height: "360px",
            scrolling: "yes" // must have the jquery-1.3.2.min.js script installed to use
        });
    });
</script>
<table cellpadding="0" cellspacing="0" class="form_table">
    <tr class="tr_light">
        <td align="left" nowrap>&nbsp;
            <%--&nbsp;<input type="button" value="导出" class="button_all" onclick="printProjectData(this)"/>--%>
            &nbsp; <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" id="myTable" style="width: 100%;">
    <thead>
    <tr class="tr_header">
        <th width="2%" nowrap>序号</th>
        <th width="15%" nowrap>项目名称</th>
        <th width="8%" nowrap>问题严重性</th>
        <th width="6%" nowrap>时间</th>
        <th width="20%" nowrap>问题描述</th>
        <c:if test="${dutyType==qdType}">
            <th width="20%" nowrap>责任部门</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mapList}" var="item" varStatus="status1">
        <c:set var="itemCode" value="item${item.projectId}"/>
        <c:if test="${fn:length(item[itemCode])>0}">
            <c:forEach items="${item[itemCode]}" var="question" varStatus="status2">
                <tr class="tr_light">
                    <c:if test="${status2.index==0}">
                        <td rowspan="${item.size}">${status1.index+1}</td>
                        <td style="text-align: left;" rowspan="${item.size}">&nbsp;${item.projectName}</td>
                        <td rowspan="${item.size}">
                            <c:if test="${item.size>1}">
                                <c:forEach begin="1" end="${item.size}">
                                    ★
                                </c:forEach>
                            </c:if>
                        </td>
                    </c:if>
                    <td>${question.year}年${question.month}月</td>
                    <td style="text-align: left;">&nbsp;${question.question}</td>
                    <c:if test="${dutyType==qdType}">
                        <td style="text-align: left;">&nbsp;${question.deptName}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${fn:length(item[itemCode])==0}">
            <tr class="tr_light">
                <td>${status1.index+1}</td>
                <td style="text-align: left;">&nbsp;${item.projectName}</td>
                <td></td>
                <td></td>
                <td></td>
                <c:if test="${dutyType==qdType}">
                    <td></td>
                </c:if>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
