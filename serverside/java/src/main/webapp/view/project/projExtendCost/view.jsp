<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">类型：</td>
          <td class="form_content">&nbsp;
                      ${bean.type}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">年：</td>
          <td class="form_content">&nbsp;
                      ${bean.year}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">月：</td>
          <td class="form_content">&nbsp;
                      ${bean.month}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">半年：</td>
          <td class="form_content">&nbsp;
                      ${bean.half}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">时间（冗余字段）：</td>
          <td class="form_content">&nbsp;
                      ${bean.title}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">累计完成投资（亿元）：</td>
          <td class="form_content">&nbsp;
                      ${bean.accComplete}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">财政资金已拨付额（亿元）：</td>
          <td class="form_content">&nbsp;
                      ${bean.czzjYbf}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">财政资金已完成额（亿元）：</td>
          <td class="form_content">&nbsp;
                      ${bean.czzjYwc}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>