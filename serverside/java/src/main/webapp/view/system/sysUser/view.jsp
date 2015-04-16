<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="no_scrollbar">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form-table" width="96%">
            <tr class="tr_light">
                <td class="form_label">
                    用户名：
                </td>
                <td class="form_content">
                    ${bean.loginName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    对应人员：
                </td>
                <td class="form_content">
                    ${bean.person.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    显示名称：
                </td>
                <td class="form_content">
                    ${bean.displayName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">
                    是否有效：
                </td>
                <td class="form_content">
                    <input type="checkbox" name="status" id="status" value="1"
                           <c:if test="${bean.status=='1'}">checked</c:if> disabled="true"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">
                    角色设置：
                </td>
                <td class="form_content">
                    <table border="0" align="left" width="95%">
                        <tr>
                            <c:forEach items="${roles}" var="item" varStatus="status">
                            <td align="left" nowrap width="33%">
                                <c:choose>
                                    <c:when test="${item.check}">
                                    <input type="checkbox" name="roleId" id="roleId" value="${item.role.id}" checked disabled="true"/> <font color="blue">${item.role.roleName}</font>
                                    </c:when>
                                    <c:otherwise>
                                    <input type="checkbox" name="roleId" id="roleId" value="${item.role.id}" disabled="true"/> ${item.role.roleName}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <c:if test="${status.index>0 && (status.index+1) % 3 == 0}">
                        </tr>
                        <tr>
                            </c:if>
                            </c:forEach>
                        </tr>
                    </table>
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
</div>