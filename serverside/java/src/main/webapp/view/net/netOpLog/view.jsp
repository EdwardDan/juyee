<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">业务对象编码：</td>
          <td class="form_content">&nbsp;
                      ${bean.bizClass}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">业务记录ID：</td>
          <td class="form_content">&nbsp;
                      ${bean.bizId}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">操作人：</td>
          <td class="form_content">&nbsp;
                      ${bean.opPerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">受理日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.acceptDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">退回原因：</td>
          <td class="form_content">&nbsp;
                      ${bean.backCause}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.description}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">操作时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">操作用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>