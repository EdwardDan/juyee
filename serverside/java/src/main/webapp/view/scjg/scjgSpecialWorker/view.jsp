<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">姓名：</td>
            <td class="form_content">&nbsp;
                ${bean.name}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">人员分类：</td>
            <td class="form_content">&nbsp;
                ${bean.personType.name}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">身份证号码：</td>
            <td class="form_content">&nbsp;
                ${bean.idCard}                   </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">性别：</td>
            <td class="form_content">&nbsp;
                ${bean.sex}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">社保缴纳金额：</td>
            <td class="form_content">&nbsp;
                ${bean.sbjnMoney}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">社保缴纳开始年月：</td>
            <td class="form_content">&nbsp;
                ${bean.sbjnBeginMonth}        </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">社保缴纳最后一次年月：</td>
            <td class="form_content">&nbsp;
                ${bean.sbjnLastMonth}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">监督任务书编号：</td>
            <td class="form_content">&nbsp;
                ${bean.jdTaskCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">所在单位：</td>
            <td class="form_content">&nbsp;
                ${bean.deptName}                    </td>
        </tr>
        <tr>
        <tr class="tr_light">
            <td class="form_label">证书名称:</td>
            <td class="form_content">&nbsp;
                ${scjgSpecialWorkerCert.certName}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">证书编号:</td>
            <td class="form_content">&nbsp;
                ${scjgSpecialWorkerCert.certCode}</td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">证书有效期:</td>
            <td class="form_content">&nbsp;
                ${scjgSpecialWorkerCert.expireDate}</td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">备注:</td>
            <td class="form_content">&nbsp;
                ${scjgSpecialWorkerCert.description}</td>
        </tr>
        <%--<tr class="tr_light">--%>
        <%--<td class="form_label">创建时间：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
        <%----%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_dark">--%>
        <%--<td class="form_label">创建用户名：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--${bean.createUser}                    </td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_light">--%>
        <%--<td class="form_label">更新时间：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--<fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
        <%----%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_dark">--%>
        <%--<td class="form_label">更新用户名：</td>--%>
        <%--<td class="form_content">&nbsp;--%>
        <%--${bean.updateUser}                    </td>--%>
        <%--</tr>--%>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>