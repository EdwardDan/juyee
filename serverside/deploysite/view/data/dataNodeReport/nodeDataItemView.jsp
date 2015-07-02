<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .td_normal {
        height: 20px;
        background-color: white;
    }

    .td {
        height: 60px;
    }

    .td2 {
        height: 120px;
    }
</style>
<table cellpadding="0" cellspacing="0" border="1" class="table_thin_line" width="99%">
    <tr class="tr_header">
        <td nowrap colspan="3" width="26%">形象进度</td>
        <td nowrap colspan="2" width="74%" align="center">推进情况&nbsp;</td>
    </tr>
    <c:forEach items="${firstNodes}" var="firstNode">
        <c:if test="${firstNode.totalLevel==2}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode" varStatus="status">
                <tr class="td_normal" align="center">
                    <c:if test="${status.index ==0}">
                        <td class="td" rowspan="${firstNode.totalChildCount}"
                            <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if>
                            nowrap>${firstNode.name}</td>
                    </c:if>
                    <td class="td" <c:if
                            test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if>
                        nowrap>${secondNode.name}&nbsp;</td>
                    <c:set var="dataKey" value="${secondNode.id}"/>
                    <c:if test="${status.index%2==0}">
                        <td class="td" width="37%" align="left">
                            <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml></td>
                        <td class="td2" rowspan="2" width="37%" align="left">
                            <sys:toHtml> ${dataMap[dataKey].problem}</sys:toHtml></td>
                    </c:if>
                    <c:if test="${status.index%2==1}">
                        <td class="td" width="37%" align="left">
                            <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml></td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${firstNode.totalLevel==3}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode" varStatus="secondStatus">
                <c:forEach items="${secondNode.projNodes}" var="thirdNode" varStatus="thirdStatus">
                    <tr class="td_normal" align="center">
                        <c:if test="${secondStatus.index ==0&&thirdStatus.index ==0}">
                            <td class="td" rowspan="${firstNode.totalChildCount}"
                                <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if>
                                nowrap>${firstNode.name}</td>
                        </c:if>
                        <c:if test="${thirdStatus.index ==0}">
                            <td class="td" <c:if
                                    test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if>
                                nowrap>${secondNode.name}&nbsp;</td>
                        </c:if>
                        <td class="td" nowrap>${thirdNode.name}&nbsp;</td>
                        <c:set var="dataKey" value="${thirdNode.id}"/>
                        <td class="td" width="74%" colspan="2" align="left">
                            <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </c:if>
    </c:forEach>
</table>