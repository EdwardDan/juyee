<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="0" class="form_div">
    <tr class="tr_light">
        <td class="form_border" align="left">
            <div style="padding-left: 50px;">
                <%--<div>图示说明：</div>--%>
                <div>&nbsp;</div>
                <li><div class="td_note" style="background-color: yellow"></div><div class="td_note_font">计划办理（显示计划办理时间，如果时间在当前天之后则不显示底色，反之显示黄色）</div></li>
                <li><div class="td_note" style="background-color: lightskyblue"></div><div class="td_note_font">办理中（显示“办理中”）</div></li>
                <li><div class="td_note" style="background-color: green"></div><div class="td_note_font">办理完成（显示“√”）</div></li>
                <li><div class="td_note" style="background-color: red"></div><div class="td_note_font">办理受阻（显示受阻原因）</div></li>
                <li><div class="td_note" style="background-color: white;"></div><div class="td_note_font">无需办理（显示“—”）</div></li>
            </div>
        </td>
    </tr>
    <tr class="tr_button">
        <td class="form_border" align="center">
            <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
        </td>
    </tr>
</table>