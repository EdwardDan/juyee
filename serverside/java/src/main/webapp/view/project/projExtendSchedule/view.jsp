<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label_right" width="20%">是否开工：</td>
                <td class="form_content" width="30%">
                        <c:if test="${bean.gcjsIsBigin}"> 已开工 </c:if>
                        <c:if test="${!bean.gcjsIsBigin}">未开工 </c:if>
                </td>
                <td class="form_label_right" width="20%">开工时间：</td>
                <td class="form_content" width="30%">${bean.gcjsBeginTime}</td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">是否完工：</td>
                <td class="form_content">
                        <c:if test="${bean.gcjsIsEnd}"> 已开工 </c:if>
                        <c:if test="${!bean.gcjsIsEnd}">未开工</c:if>
                </td>
                <td class="form_label_right">完工时间：</td>
                <td class="form_content">${bean.gcjsEndTime}
                </td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
               style="text-align: center;width: 98%;"
               id="itemTable">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width:80%;" colspan="2">项目情况</td>
            </tr></table>

        <c:forEach items="${bean.projExtendSchedules}" var="item">
            <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
                   style="text-align: center;width: 98%;">
                <tr class="tr_light">
                    <td width="15%" rowspan="4">
                        <span>${item.title}</span>
                    </td>
                    <td width="20%">项目进展情况</td>
                    <td width="60%" align="left">&nbsp;${item.projProgress}
                    </td>

                </tr>
                <tr class="tr_light">
                    <td> 存在问题</td>
                    <td  align="left"> &nbsp;${item.question}</td>
                </tr>
                <tr class="tr_light">
                    <td>改进意见</td>
                    <td  align="left">&nbsp;${item.improveOpinion}</td>
                </tr>
                <tr class="tr_light">
                    <td> 备注</td>
                    <td  align="left">&nbsp;${item.description}</td>
                </tr>
            </table>
        </c:forEach>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>