<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:if test="${isTab}">
    <%@ include file="/common/header.jsp" %>
</c:if>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 15%">报建编号：</td>
            <td class="form_content" style="width: 30%">
                ${bean.bjbh}
            </td>
            <td class="form_label_right" style="width: 10%">项目编号：</td>
            <td class="form_content" style="width: 45%">
                ${bean.projNum}
            </td>
        </tr>
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
            <td class="form_label_right">项目状态：</td>
            <td class="form_content">
                <sys:code code="${PROJ_INFO_STAGE}" name="ProjStage" id="ProjStage" type="select" disabled="true"
                          sysCodeDetailId="${bean.stage.id}" style="width:150px"/>
            </td>
            <td class="form_label_right">业态类别：</td>
            <td class="form_content">
                <sys:code code="${PROJ_INFO_CATEGORY}" name="ProjCategory" id="ProjCategory" type="select"
                          disabled="true"
                          sysCodeDetailId="${bean.category.id}" style="width:150px"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">管理属性：</td>
            <td class="form_content">
                <select name="ProjProperty" id="ProjProperty" disabled style="width: 70px">
                    <c:forEach var="propertyL" items="${propertyList}">
                        <option value="${propertyL.id}"
                                <c:if test="${bean.property.id==propertyL.id}">selected </c:if>>${propertyL.name}</option>
                    </c:forEach>
                </select>
                <select name="isMajor" id="isMajor" disabled style="width: 75px">
                    <option value="1">重大</option>
                    <option value="0" <c:if test="${!bean.isMajor}">selected</c:if>>非重大</option>
                </select>
            </td>
            <td class="form_label_right">项目来源：</td>
            <td class="form_content">
                <sys:code code="${PROJ_INFO_SOURCE}" name="ProjSources" id="ProjSources" type="select" disabled="true"
                          sysCodeDetailId="${bean.projectSource.id}" style="width:150px"/>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">所属区县：</td>
            <td class="form_content">
                <select name="areaId" id="areaId" disabled style="width: 75px;">
                    <option value="0">上海市</option>
                    <c:forEach var="area" items="${areaList}">
                        <option value="${area.id}"
                                <c:if test="${bean.areaCode==area.name}">selected </c:if>>${area.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td class="form_label_right">打包属性：</td>
            <td class="form_content">
                <sys:checkbox name="ProjPackageAttr" code="${PROJ_INFO_DBSX}" checkedNames="${bean.packageAttr}"
                              inputType="checkbox" isSaveName="true" showType="view" colNum="4"/>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">开工日期：</td>
            <td class="form_content" colspan="3">
                <fmt:formatDate value="${bean.startDate}" pattern="yyyy-MM-dd"/>
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
            <td class="form_content" colspan="3">
                <c:forEach var="area" items="${areas}"><input type="checkbox" name="ProjBelongArea" value="${area}" checked disabled/>${area}</c:forEach>
                <%--<sys:checkbox name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}"--%>
                              <%--inputType="checkbox" isSaveName="false" showType="view" colNum="9"/>--%>
            </td>

        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">工程简介：</td>
            <td class="form_content" colspan="3">
                <sys:toHtml>${bean.intro}</sys:toHtml>
            </td>
        </tr>

    </table>
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right" style="width: 15%">建设单位：</td>
            <td class="form_content" style="width: 25%">
                ${bean.jsDept}
            </td>
            <td class="form_label_right" style="width: 10%">联系人：</td>
            <td class="form_content" style="width: 20%">
                ${bean.jsDeptPerson}
            </td>
            <td class="form_label_right" style="width: 10%">联系电话：</td>
            <td class="form_content" style="width: 20%">
                ${bean.jsDeptTel}
            </td>
        </tr>
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
            <td class="form_content">
                ${bean.jlDeptTel}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">功能作用：</td>
            <td class="form_content" colspan="5">
                <sys:toHtml>${bean.function}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">工程范围：</td>
            <td class="form_content" colspan="5">
                <sys:toHtml> ${bean.engineerRange}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">主要内容：</td>
            <td class="form_content" colspan="5">
                <sys:toHtml>${bean.mainContent}</sys:toHtml>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="6" style="text-align: center">
                <input type="button" value="关闭" class="button_cancel" onclick="
                <c:if test="${!isTab}">closeWindow()</c:if>
                <c:if test="${isTab}">parent.closeWindow()</c:if>">
            </td>
        </tr>
    </table>
</div>