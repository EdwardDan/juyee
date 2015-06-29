<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">年份：</td>
            <td class="form_content" style="width: 30%">
                ${bean.year}
            </td>
            <td class="form_label_right" style="width: 20%">项目序号：</td>
            <td class="form_content" style="width: 30%">
                ${bean.no}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">项目来源：</td>
            <td class="form_content" style="width: 30%">
                ${bean.property.name}
            </td>
            <td class="form_label_right" style="width: 20%">项目阶段：</td>
            <td class="form_content" style="width: 30%">
                ${bean.stage.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">项目类型：</td>
            <td class="form_content" style="width: 30%">
                ${bean.category.name}
            </td>
            <td class="form_label_right" style="width: 20%">建设里程：</td>
            <td class="form_content" style="width: 30%">
                ${bean.buildMileage}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">项目名称：</td>
            <td class="form_content" colspan="3">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">起讫地点：</td>
            <td class="form_content" colspan="3">
                ${bean.location}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">涉及区（县）：</td>
            <td class="form_content" style="width: 30%">
                ${areas}
            </td>
            <td class="form_label_right" style="width: 20%">开工日期：</td>
            <td class="form_content" style="width: 30%">
                ${bean.startDate}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">工程简介：</td>
            <td class="form_content" colspan="3">
                <sys:toHtml>${bean.intro}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">建设单位：</td>
            <td class="form_content" colspan="3">
                ${bean.jsDept}
            </td>
        </tr>
    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" style="width: 20%">施工单位：</td>
            <td class="form_content" style="width: 20%">
                ${bean.sgDept}
            </td>
            <td class="form_label_right" style="width: 10%">联系人：</td>
            <td class="form_content" style="width: 20%">
                ${bean.sgDeptPerson}
            </td>
            <td class="form_label_right" style="width: 10%">联系电话：</td>
            <td class="form_content" style="width: 20%">
                ${bean.sgDeptTel}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right" style="width: 20%">监理单位：</td>
            <td class="form_content" style="width: 20%">
                ${bean.jlDept}
            </td>
            <td class="form_label_right" style="width: 10%">联系人：</td>
            <td class="form_content" style="width:20%">
                ${bean.jlDeptPerson}
            </td>
            <td class="form_label_right" style="width: 10%">联系电话：</td>
            <td class="form_content" style="width: 20%">
                ${bean.jlDeptTel}
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="6" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>