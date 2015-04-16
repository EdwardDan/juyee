<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">发包类型中文描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.fbTypeDesc}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">是否招标：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isBid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>