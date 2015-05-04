<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">编码：</td>
          <td class="form_content">&nbsp;
                      ${bean.code}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">名称：</td>
          <td class="form_content">&nbsp;
                      ${bean.name}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">是否有效：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.description}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">是否叶节点：</td>
          <td class="form_content">&nbsp;
                                  <c:choose><c:when test="${bean.isLeaf}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
                                </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">树形层次：</td>
          <td class="form_content">&nbsp;
                      ${bean.treeId}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>