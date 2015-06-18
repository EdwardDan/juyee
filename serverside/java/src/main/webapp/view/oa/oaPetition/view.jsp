<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">受理编号：</td>
          <td class="form_content">&nbsp;
                      ${bean.code}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">受理状态中文描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.statusDesc}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">信访来源中文描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.sourceDesc}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">信访种类中文描述：</td>
          <td class="form_content">&nbsp;
                      ${bean.typeDesc}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">信访人：</td>
          <td class="form_content">&nbsp;
                      ${bean.person}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">联系电话：</td>
          <td class="form_content">&nbsp;
                      ${bean.tel}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">收信日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.receiveDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">联系地址：</td>
          <td class="form_content">&nbsp;
                      ${bean.address}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">经办人姓名(冗余)：</td>
          <td class="form_content">&nbsp;
                      ${bean.jbrName}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">结案日期：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.endDate}" pattern="yyyy-MM-dd"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">信访事由：</td>
          <td class="form_content">&nbsp;
                      ${bean.content}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">处理结果：</td>
          <td class="form_content">&nbsp;
                      ${bean.dealResult}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.description}                    </td>
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