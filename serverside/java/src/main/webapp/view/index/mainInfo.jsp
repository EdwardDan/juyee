<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<table width="100%" border="0" cellpadding="0" cellspacing="0" onmouseover="showEditButton('btnCustomGrid${orderNo}')" onmouseout="hideEditButton('btnCustomGrid${orderNo}')">
    <tr>
        <td class="tableleft">&nbsp;</td>
        <td class="tablecenter">${bean.modelName}</td>
        <td class="tablecenter" align="right">
            <input type="button" class="button_edit" value=" " id="btnCustomGrid${orderNo}" style="cursor: pointer;display: none" onclick="editCustomGrid(${orderNo})">
            <img src="${themePath}/index_new/more.png" width="36" height="14" title="查看更多" style="cursor: pointer" onclick="loadMainPage('${ctx}/${bean.moreLink}','${bean.modelName}');" align="absmiddle"/>
        </td>
        <td class="tableright">&nbsp;</td>
    </tr>
    <tr>
        <td class="tablemiddle">&nbsp;</td>
        <td colspan="2">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <c:forEach items="${bean.cols}" var="col" varStatus="status">
                        <td class="tablehead" width="${bean.widths[status.index]}%" nowrap>${col}</td>
                    </c:forEach>
                </tr>
                <c:forEach items="${bean.list}" var="item">
                    <tr>
                        <c:forEach items="${item}" var="detail" varStatus="detailStatus">
                            <td class="tablelight" style="text-align:${bean.aligns[detailStatus.index]}">${detail}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td class="tablemiddle1">&nbsp;</td>
    </tr>
    <tr>
        <td class="tablefoot1">&nbsp;</td>
        <td colspan="2" class="tablefoot2">&nbsp;</td>
        <td class="tablefoot3">&nbsp;</td>
    </tr>
</table>