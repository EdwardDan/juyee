<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right">年份：</td>
            <td class="form_content">
                ${bean.year}
            </td>
            <td class="form_label_right">项目序号：</td>
            <td class="form_content">
                ${bean.no}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目来源：</td>
            <td class="form_content">
                ${bean.property.name}
            </td>
            <td class="form_label_right">项目阶段：</td>
            <td class="form_content">
                ${bean.stage.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">项目类型：</td>
            <td class="form_content">
                ${bean.category.name}
            </td>
            <td class="form_label_right">建设里程：</td>
            <td class="form_content">
                ${bean.buildMileage}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">项目名称：</td>
            <td class="form_content" colspan="3">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">起讫地点：</td>
            <td class="form_content" colspan="3">
                ${bean.location}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">涉及区（县）：</td>
            <td class="form_content">
                ${bean.belongArea.name}
            </td>
            <td class="form_label_right">开工日期：</td>
            <td class="form_content">
                ${bean.startDate}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工程简介：</td>
            <td class="form_content" colspan="3">
                <sys:toHtml>${bean.intro}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">建设单位：</td>
            <td class="form_content" colspan="3">
                ${bean.jsDept}
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right">施工单位：</td>
            <td class="form_content">
                ${bean.sgDept}
            </td>
            <td class="form_label_right">联系人：</td>
            <td class="form_content">
                ${bean.sgDeptPerson}
            </td>
            <td class="form_label_right">联系电话：</td>
            <td class="form_content">
                ${bean.sgDeptTel}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">监理单位：</td>
            <td class="form_content">
                ${bean.jlDept}
            </td>
            <td class="form_label_right">联系人：</td>
            <td class="form_content">
                ${bean.jlDeptPerson}
            </td>
            <td class="form_label_right">联系电话：</td>
            <td class="form_content"> ${bean.jlDeptTel}
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="6" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>