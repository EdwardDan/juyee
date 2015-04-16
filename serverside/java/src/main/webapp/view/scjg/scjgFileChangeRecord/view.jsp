<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">文件类别编码(交办件/来件/信访)：</td>
          <td class="form_content">&nbsp;
                      ${bean.fileTypeCode}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">承办科室：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealDept}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">承办人员：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealPerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">转至科室日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.changeDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">要求回复日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.planReplyDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">实际回复日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.actualReplyDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">办理情况：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealContent}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.description}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">是否提醒：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isRemind}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">创建时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">创建用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">更新时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
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