<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.userName}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">排序号：</td>
          <td class="form_content">&nbsp;
                      ${bean.orderNo}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">创建时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">创建用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">更新时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">更新用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.updateUser}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>