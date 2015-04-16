<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">监督任务编号：</td>
            <td class="form_content">&nbsp;
                ${bean.jdTaskCode}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.bjbh}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">标段号：</td>
            <td class="form_content">&nbsp;
                ${bean.bdh}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">建设单位：</td>
            <td class="form_content">&nbsp;
                ${bean.buildUnitName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">施工单位：</td>
            <td class="form_content">&nbsp;
                ${bean.sgUnitName}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地名称：</td>
            <td class="form_content">&nbsp;
                ${bean.gdName}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">计划完成日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.planEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">实际完成日期：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.planActTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">创建时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">更新时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">创建人：</td>
            <td class="form_content">&nbsp;
                ${bean.createUser}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">更新人：</td>
            <td class="form_content">&nbsp;
                ${bean.updateUser}
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