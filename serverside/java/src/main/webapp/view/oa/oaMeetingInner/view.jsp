<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">会议开始时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">会议结束时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">会议地点：</td>
          <td class="form_content">&nbsp;
                      ${bean.address}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">内部人员：</td>
          <td class="form_content">&nbsp;
                      ${bean.innerPersons}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">外部人员：</td>
          <td class="form_content">&nbsp;
                      ${bean.outerPersons}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">会议议题：</td>
          <td class="form_content">&nbsp;
                      ${bean.title}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">会议内容：</td>
          <td class="form_content">&nbsp;
                      ${bean.content}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">是否提交：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
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