<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" width="25%">工作组名称：</td>
            <td class="form_content">
                ${bean.name}
                &nbsp;
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">
                责任区域：
            </td>
            <td class="form_content">
                ${belongAreaNames}
                <%--<select multiple="multiple" id="SysCode" name="SysCode"--%>
                        <%--style="width:250px;height:110px;">${belongAreaOptions}</select>--%>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">工作组成员：</td>
            <td bgcolor="white">
                <table border="0" cellpadding="1" cellspacing="1" style="border-color:white" class="form_table"
                       id="table_list">
                    <tr class="tr_light">
                        <td>姓名</td>
                        <td>所属部门</td>
                        <td>负责人</td>
                    </tr>
                    <c:forEach items="${userList}" var="item">
                        <tr class="tr_dark" id="${item.sysUserId}">
                            <td>${item.userName}</td>
                            <td>${item.deptName}</td>
                            <td>${item.isCharge}</td>
                        </tr>
                    </c:forEach>

                </table>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">备注：</td>
            <td class="form_content">
                <sys:toHtml>${bean.memo}</sys:toHtml>
                &nbsp;
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_border" colspan="2">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>