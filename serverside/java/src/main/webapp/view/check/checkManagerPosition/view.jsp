<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">监督任务书编号：</td>
            <td class="form_content">&nbsp;
                ${bean.jdTaskCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.bjbh}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">工地编号：</td>
            <td class="form_content">&nbsp;
                ${bean.gdCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地名称：</td>
            <td class="form_content">&nbsp;
                ${bean.gdName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">所属区县：</td>
            <td class="form_content">&nbsp;
                ${bean.belongArea}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">街镇：</td>
            <td class="form_content">&nbsp;
                ${bean.streetArea}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否有效：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isValid}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">岗位名称：</td>
            <td class="form_content">&nbsp;
                ${bean.positionName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">证书编号：</td>
            <td class="form_content">&nbsp;
                ${bean.certificateCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">证书名称：</td>
            <td class="form_content">&nbsp;
                ${bean.certificateName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">逻辑删除：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isDelete}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">是否同步：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isSync}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">GUID：</td>
            <td class="form_content">&nbsp;
                ${bean.guid}                    </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>