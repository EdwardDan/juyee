<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">序号：</td>
          <td class="form_content">&nbsp;
                      ${bean.num}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">送达文书：</td>
          <td class="form_content">&nbsp;
                      ${bean.serviceBook}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">送达人：</td>
          <td class="form_content">&nbsp;
                      ${bean.servicePerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">收到日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">收到人签名：</td>
          <td class="form_content">&nbsp;
                      ${bean.receiveSign}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.memo}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>