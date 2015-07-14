<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .input {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 98.5%;
        height: 100%
    }

    .td {
        height: 60px;
        text-align: left;
    }

    .td2 {
        height: 120px;
        text-align: left;
    }
</style>
<table cellpadding="0" cellspacing="0" border="1" class="form_table" style="width: 100%;">
    <tr class="tr_header">
        <td nowrap colspan="3" style="width: 20%;">形象进度</td>
        <c:forEach items="${steps}" var="step">
            <c:if test="${step.isValid}">
                <td nowrap colspan="2" style="width: 80%;">${step.name}&nbsp;</td>
            </c:if>
        </c:forEach>
    </tr>
    <c:forEach items="${firstNodes}" var="firstNode">
        <c:if test="${firstNode.totalLevel==2}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode" varStatus="status">
                <tr class="tr_dark">
                    <c:if test="${status.index ==0}">
                        <td rowspan="${firstNode.totalChildCount}" style="text-align: center;"
                            <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}" </c:if>
                            nowrap>${firstNode.name}
                        </td>
                    </c:if>
                    <td class="td" <c:if test="${secondNode.totalChildCount>0}"> rowspan="${secondNode.totalChildCount}"</c:if>
                            style="text-align: center;" nowrap>${secondNode.name}
                    </td>
                    <c:forEach items="${steps}" var="step">
                        <c:if test="${step.isValid}">
                            <c:set var="dataKey" value="${secondNode.id}_${step.id}"/>
                            <c:if test="${status.index%2==0}">
                                <td style="width: 30%;" class="td">
                                    <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml>
                                </td>
                                <td rowspan="2" style="width: 30%;" class="td2">
                                    <sys:toHtml>${dataMap[dataKey].problem}</sys:toHtml>
                                </td>
                            </c:if>
                            <c:if test="${status.index%2==1}">
                                <td style="width: 30%;" class="td">
                                    <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml>
                                </td>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${firstNode.totalLevel==3}">
            <c:forEach items="${firstNode.projNodes}" var="secondNode" varStatus="secondStatus">
                <c:forEach items="${secondNode.projNodes}" var="thirdNode" varStatus="thirdStatus">
                    <tr class="td_dark">
                        <c:if test="${secondStatus.index ==0&&thirdStatus.index ==0}">
                            <td rowspan="${firstNode.totalChildCount}" class="td" style="text-align: center;"
                                <c:if test="${firstNode.totalLevel<3}">colspan="${firstNode.totalLevel}"</c:if>
                                nowrap>${firstNode.name}
                            </td>
                        </c:if>
                        <c:if test="${thirdStatus.index ==0}">
                            <td
                                    <c:if test="${secondNode.totalChildCount>0}">rowspan="${secondNode.totalChildCount}"</c:if>
                                    style="text-align: center;" nowrap>${secondNode.name}
                            </td>
                        </c:if>
                        <td class="td" style="text-align: center;" nowrap>${thirdNode.name}&nbsp;</td>
                        <c:forEach items="${steps}" var="step">
                            <c:if test="${step.isValid}">
                                <c:set var="dataKey" value="${thirdNode.id}_${step.id}"/>
                                <td class="td" colspan="2">
                                    <sys:toHtml>${dataMap[dataKey].content}</sys:toHtml>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </c:forEach>
        </c:if>
    </c:forEach>
</table>