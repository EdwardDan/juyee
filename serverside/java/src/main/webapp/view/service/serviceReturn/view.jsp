<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.code}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">受送达人：</td>
          <td class="form_content">&nbsp;
                      ${bean.servicePerson}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">事项名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.thingsName}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">送达单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.serviceUnit}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">送达地点：</td>
          <td class="form_content">&nbsp;
                      ${bean.serviceAddress}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.moemo}                    </td>
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