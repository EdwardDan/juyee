<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">收文编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.code}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">来文文号：</td>
          <td class="form_content">&nbsp;
                      ${bean.fileCode}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">标题：</td>
          <td class="form_content">&nbsp;
                      ${bean.title}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">来文单位：</td>
          <td class="form_content">&nbsp;
                      ${bean.sourceDept}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">登记日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">提供部门：</td>
          <td class="form_content">&nbsp;
                      ${bean.deptName}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">成文日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.writtenDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">办理时限：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.limitDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">份数：</td>
          <td class="form_content">&nbsp;
                      ${bean.fs}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">页数：</td>
          <td class="form_content">&nbsp;
                      ${bean.ys}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">牵头部门ID：</td>
          <td class="form_content">&nbsp;
                      ${bean.startDeptId}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">处理人IDs：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealPersons}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">处理部门IDs：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealDepts}                    </td>
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