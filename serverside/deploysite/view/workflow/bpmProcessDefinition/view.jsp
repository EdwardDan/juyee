<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .input_none {
        font-size: 12px;
        border: 0px none;
        background-color: #e0ebf2;
        width: 100%;
        height: 20px
    }
</style>
<div class="no_scrollbar">
<div class="form_div">
    <div align="center" class="tr_dark">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">业务流程编码：</td>
                <td class="form_content">
                    ${bean.code}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">业务流程名称：</td>
                <td class="form_content">
                    ${bean.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">业务流程分类：</td>
                <td class="form_content">
                    ${bean.category.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">流程图模板：</td>
                <td class="form_content" nowrap>
                    ${bean.processTemplate.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">表单模板：</td>
                <td class="form_content">
                    <c:forEach var="formTemplate" items="${formTemplates}">
                        ${formTemplate.name}<br/>
                    </c:forEach>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">文档目录：</td>
                <td class="form_content" nowrap>
                    ${bean.fileCategory.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">备注：</td>
                <td class="form_content">
                    <sys:toHtml>${bean.description}</sys:toHtml>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">排序：</td>
                <td class="form_content">
                    ${bean.orderNo}
                </td>
            </tr>
        </table>
        <div class="div_space"></div>
        <fieldset class="form_fieldset">
            <legend class="form_legend">
                字段映射
            </legend>
            <div class="form_table">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_header" align="center">
                        <td width="30%" class="form_border" nowrap>数据库字段</td>
                        <td width="15%" class="form_border" nowrap>表单模板</td>
                        <td width="20%" class="form_border" nowrap>模板定义KEY</td>
                        <td width="20%" class="form_border" nowrap>列表显示名称</td>
                        <td width="20%" class="form_border" nowrap>列表显示宽度</td>
                        <td width="5%" class="form_border" nowrap>是否生效</td>
                        <td width="5%" class="form_border" nowrap>列表显示</td>
                    </tr>
                    <c:forEach items="${list}" var="listcolumn" varStatus="s">
                        <input type="hidden" name="no">
                        <tr class="tr_light">
                            <td nowrap class="form_border">
                                    ${listcolumn.column}&nbsp;
                            </td>
                            <td nowrap class="form_border">
                                    ${listcolumn.formName}&nbsp;
                            </td>
                            <td nowrap class="form_border">
                                    ${listcolumn.key}&nbsp;
                            </td>
                            <td nowrap class="form_border">
                                    ${listcolumn.gridName}&nbsp;
                            </td>
                            <td nowrap class="form_border">
                                    ${listcolumn.gridWidth}&nbsp;
                            </td>
                            <td nowrap class="form_border">
                                <input type="checkbox" name="isValid_${s.index+1}" value="1" disabled="true"
                                       <c:if test="${listcolumn.isValid}">checked</c:if>>
                            </td>
                            <td nowrap class="form_border">
                                <input type="checkbox" name="isGridShow_${s.index+1}" value="1" disabled="true"
                                       <c:if test="${listcolumn.isGridShow}">checked</c:if>>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </fieldset>
    </div>

    <div class="tr_button">
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
</div>
</div>
