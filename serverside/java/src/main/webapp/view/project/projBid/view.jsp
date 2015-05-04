<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">标段编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.code}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">标段名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.name}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">建设里程：</td>
          <td class="form_content">&nbsp;
                      ${bean.buildMileage}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">项目联系人：</td>
          <td class="form_content">&nbsp;
                      ${bean.projLink}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.linkTel}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">开工日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.startDate}" pattern="yyyy-MM-dd"/>
            
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