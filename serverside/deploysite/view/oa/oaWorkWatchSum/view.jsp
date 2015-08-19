<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellspacing="3" cellpadding="3" class="form_table">
        <tr class="tr_title">
            <td style="text-align: center">
                <strong>
                    ${reportTime}
                </strong>
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
        <tr class="tr_header">
            <td><strong>科室</strong></td>
            <td><strong>序号</strong></td>
            <td><strong>工作内容</strong></td>
            <td><strong>分管领导</strong></td>
            <td><strong>时间节点</strong></td>
            <td><strong>上报形式</strong></td>
            <td><strong>完成情况</strong></td>
        </tr>
        <c:set var="index" value="0"></c:set>
        <c:forEach items="${deptMap}" var="bean" varStatus="st">
            <c:forEach items="${bean.value}" var="oaWorkWatchItem" varStatus="stItem">
                <tr
                        <c:if test="${stItem.index%2==0}">class="tr_dark"</c:if>
                        <c:if test="${stItem.index%2==1}">class="tr_light"</c:if>
                        >
                    <c:if test="${stItem.index==0}">
                        <td rowspan="${fn:length(bean.value)}">
                            <strong>${bean.key}</strong>
                        </td>
                    </c:if>
                    <td>
                        <c:set var="index" value="${index+1}"></c:set>
                        <c:out value="${index}"></c:out>
                    </td>
                    <td style="text-align: left;">
                            <sys:toHtml>${oaWorkWatchItem.content}</sys:toHtml>
                    </td>
                    <c:if test="${stItem.index==0}">
                        <td rowspan="${fn:length(bean.value)}">
                            <sys:toHtml>${stringHashMap[bean.key]}</sys:toHtml>
                        </td>
                    </c:if>
                    <td>
                            ${oaWorkWatchItem.timeNode}
                    </td>
                    <td>
                            ${oaWorkWatchItem.reportMethod}
                    </td>
                    <td>
                            ${oaWorkWatchItem.completeDesc}
                    </td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
    <table cellpadding="3" cellspacing="3" class="form_table">
        <tr class="tr_button">
            <td class="form_border">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>