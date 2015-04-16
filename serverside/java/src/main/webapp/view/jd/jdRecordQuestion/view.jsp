<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">监督id(首次/安全/质量/竣工)：</td>
          <td class="form_content">&nbsp;
                      ${bean.recordId}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">问题类别编码：</td>
          <td class="form_content">&nbsp;
                      ${bean.typeCode}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">序号：</td>
          <td class="form_content">&nbsp;
                      ${bean.orderNo}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">问题id：</td>
          <td class="form_content">&nbsp;
                      ${bean.questionId}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">问题描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.questionDesc}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">处理建议：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealAdvise}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">违法条款id：</td>
          <td class="form_content">&nbsp;
                      ${bean.unlawId}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">违法条款描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.unlawDesc}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">监督员id：</td>
          <td class="form_content">&nbsp;
                      ${bean.jdPersonId}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">监督员描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.jdPersonDesc}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">拟整改截止日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.planEndDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">是否开单：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isForm}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
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