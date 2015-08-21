<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">年：</td>
          <td class="form_content">&nbsp;
                      ${bean.year}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">月：</td>
          <td class="form_content">&nbsp;
                      ${bean.month}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">时间（冗余字段）：</td>
          <td class="form_content">&nbsp;
                      ${bean.title}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">项目进展情况：</td>
          <td class="form_content">&nbsp;
                      ${bean.projProgress}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">存在问题：</td>
          <td class="form_content">&nbsp;
                      ${bean.question}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">改进意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.improveOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">备注：</td>
          <td class="form_content">&nbsp;
                      ${bean.description}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>