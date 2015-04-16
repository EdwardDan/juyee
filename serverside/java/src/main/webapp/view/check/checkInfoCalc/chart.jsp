<%@include file="/common/taglibs.jsp" %>
<%@ page contentType="text/xml;charset=utf-8" pageEncoding="utf-8" %>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<chart rotateYAxisName="0" baseFontSize="12" baseFont="宋体" imageSaveURL="" imageSave="0"
       formatNumberScale="0" thousandSeparator="," yAxisName="" xAxisName="" showValues="0" unescapeLinks='0'>
    <categories>
        <c:forEach items="${data.categoryNames}" var="categoryName">
            <category label="${categoryName}"/>
        </c:forEach>
    </categories>
    <c:forEach items="${data.seriesNames}" var="seriesName" varStatus="sItem">
        <dataset seriesName="${seriesName}">
            <c:forEach items="${data.categoryNames}" var="cName" varStatus="cItem">
                <set value="<fmt:formatNumber pattern="###" value="${data.values[cItem.index][sItem.index]}"/>" color="${colors[0][sItem.index]}" <c:if test="${hasLink}">link="javascript:viewChartDetail('${cItem.index}','${sItem.index}')"</c:if>/>
            </c:forEach>
        </dataset>
    </c:forEach>
</chart>