<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%" nowrap>序号</td>
            <td class="form_border" width="10%" nowrap>类别</td>
            <td class="form_border" width="40%" nowrap>附件名称</td>
            <td class="form_border" width="10%" nowrap>操作</td>
        </tr>
        <tr class="tr_light">
            <td class="form_border">1</td>
            <td class="form_border" nowrap>&nbsp;施工许可</td>
            <td class="form_border" align="left">&nbsp;施工许可申请表</td>
            <td class="form_border" nowrap>&nbsp;
                <input type="button" value="下载" class="button_normal"
                                                        onclick="window.open('${ctx}/tools/施工许可申请表.docx')">
            </td>
        </tr>
    </table>
</div>
