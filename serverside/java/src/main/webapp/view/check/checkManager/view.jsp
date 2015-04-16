<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
            <td class="form_label_right" width="14%">监督任务书编号：</td>
            <td class="form_content" width="38%">
                &nbsp;
                ${jdTaskCode}
            </td>

            <td class="form_label_right" width="10%">工地编号：</td>
            <td class="form_content">
                &nbsp;
                ${gdCode}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">工地名称：</td>
            <td class="form_content">
                &nbsp;
                ${gdName}
            </td>

            <td class="form_label_right">工程名称：</td>
            <td class="form_content">
                &nbsp;
                ${projectName}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right" width="12%">姓名：</td>
            <td class="form_content">
                &nbsp;${bean.name}
            </td>

            <td class="form_label_right" width="10%">性别：</td>
            <td class="form_content">
                &nbsp;<c:choose><c:when test="${bean.sex == male}">男</c:when><c:otherwise>女</c:otherwise></c:choose>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">岗位：</td>
            <td class="form_content">
                &nbsp;${checkManagerPosition.positionName}
            </td>

            <td class="form_label_right">身份证号：</td>
            <td class="form_content">
                &nbsp;${bean.cardNo}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">手机号码：</td>
            <td class="form_content">
                &nbsp;${bean.mobile}
            </td>

            <td class="form_label_right">采集日期：</td>
            <td class="form_content">
                &nbsp;
            </td>
        </tr>

        <%--<tr class="tr_light">--%>
        <%--&lt;%&ndash;<td class="form_label_right">登记指纹：</td>&ndash;%&gt;--%>
        <%--<td class="form_label_right">已采集指纹数量：</td>--%>
        <%--<td class="form_content" colspan="3">--%>
        <%--&nbsp;${fingerNum}--%>
        <%--</td>--%>
        <%--</tr>--%>

        <tr class="tr_dark">
            <td class="form_label_right">照片：</td>
            <td class="form_content">
                &nbsp;
            </td>

            <td class="form_label_right">岗位证书：</td>
            <td class="form_content">
                &nbsp;${imageButton}&nbsp;证书扫描件
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right" rowspan="5">&nbsp;</td>
            <td class="form_content" rowspan="5" style="width: 180px; height: 140px">
                <c:if test="${not empty photoFile}"><img src="${ctx}/uploads/doc${photoFile}"></c:if>
                &nbsp;
            </td>

            <td class="form_label_right">证书编号：</td>
            <td class="form_content">
                &nbsp;${checkManagerPosition.certificateCode}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">证书名称：</td>
            <td class="form_content">
                &nbsp;${checkManagerPosition.certificateName}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">&nbsp;</td>
            <td class="form_content">
                &nbsp;
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">&nbsp;</td>
            <td class="form_content">
                &nbsp;
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">&nbsp;</td>
            <td class="form_content">
                &nbsp;
            </td>
        </tr>

        <tr class="tr_button">
            <td class="form_border" colspan="4">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>