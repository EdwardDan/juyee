<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">工可批复总投资（亿元）：</td>
          <td class="form_content">&nbsp;
                      ${bean.gctxGkpfTotal}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">初设批复总投资（亿元）：</td>
          <td class="form_content">&nbsp;
                      ${bean.gctxCspfTotal}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">资金来源：</td>
          <td class="form_content">&nbsp;
                      ${bean.gctxSourceFund}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">项目建议书完成时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.planXmjysTime}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">工可完成时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.planGkTime}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">初步设计完成时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.planCbsjTime}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">是否开工：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.gcjsIsBigin}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">开工时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.gcjsBeginTime}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">是否完工：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.gcjsIsEnd}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">完工时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.gcjsEndTime}" pattern="yyyy-MM-dd"/>
            
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