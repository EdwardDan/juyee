<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<c:if test="${isTab}">
    <%@ include file="/common/header.jsp" %>
</c:if>
<div class="form_div">
    <fieldset class="form_fieldset" style="width: 96%;">
        <legend>项目基本信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 20%">项目编号：</td>
                <td class="form_content" style="width: 25%;">
                    ${bean.projNum}
                </td>
                <td class="form_label_right" style="width: 10%;">项目序号：</td>
                <td class="form_content" style="width: 50%;">
                    ${bean.no}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目状态：</td>
                <td class="form_content">
                    ${bean.stage.name}
                </td>
                <td class="form_label_right">业态类别：</td>
                <td class="form_content">
                    ${bean.category.name}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">管理属性：</td>
                <td class="form_content">
                    <select name="managerProperty" id="managerProperty" onchange="changeArea()" class="form_select"
                            style="width: 70px;" disabled>
                        <c:forEach var="propertyL" items="${propertyList}">
                            <option value="${propertyL.id}"
                                    <c:if test="${bean.property.id==propertyL.id}">selected </c:if>>${propertyL.name}</option>
                        </c:forEach>
                    </select>
                    <select name="isMajor" id="isMajor" class="form_select" style="width: 75px;" disabled>
                        <option value="1">重大</option>
                        <option value="0" <c:if test="${!bean.isMajor}">selected</c:if>>非重大</option>
                    </select>
                </td>
                <td class="form_label_right">项目来源：</td>
                <td class="form_content">
                    ${bean.projectSource.name}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">所属区县：</td>
                <td class="form_content">
                    <select name="areaId" id="areaId" class="form_select" style="width: 150px;" disabled>
                        <option value="0">上海市</option>
                        <c:forEach var="area" items="${areaList}">
                            <option value="${area.id}"
                                    <c:if test="${bean.areaCode==area.name}">selected </c:if>>${area.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td class="form_label_right">项目属性：</td>
                <td class="form_content">
                    ${bean.projProperty.id}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">开工日期：</td>
                <td class="form_content">
                    <fmt:formatDate value="${bean.startDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right">完工日期：</td>
                <td class="form_content">
                    <fmt:formatDate value="${bean.endDate}" pattern="yyyy-MM-dd"/>
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
                    <sys:checkbox name="ProjBelongArea" code="ProjBelongArea" checkedNames="${areas}"
                                  inputType="checkbox" isSaveName="false" showType="edit" colNum="9"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">规划红线（宽度m）：</td>
                <td class="form_content">
                    ${bean.ghhx}
                </td>
                <td class="form_label_right">道路等级：</td>
                <td class="form_content">
                    ${bean.roadGrade.id}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">道路技术等级：</td>
                <td class="form_content" colspan="3">
                    ${bean.roadTecGrade.name}
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="div_space"></div>
    <fieldset class="form_fieldset" style="width: 96%;">
        <legend>项目扩展信息</legend>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_border" rowspan="2" style="width:5%;">计划任务书</td>
                <td class="form_label_right" style="width: 15%;">开工节点：</td>
                <td class="form_content" style="width: 25%;" nowrap>
                    <fmt:formatDate value="${bean.kgjd}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right" style="width: 15%;">完工节点：</td>
                <td class="form_content" style="width: 30%;" nowrap>
                    <fmt:formatDate value="${bean.wgjd}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 15%;">计划开工时间：</td>
                <td class="form_content" style="width: 25%;" nowrap>
                    <fmt:formatDate value="${bean.planStartDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_label_right" style="width: 15%;">计划完工时间：</td>
                <td class="form_content" style="width: 30%;" nowrap>
                    <fmt:formatDate value="${bean.planEndDate}" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 15%;" colspan="2">工程范围和主要内容：</td>
                <td class="form_content" style="width: 25%;" colspan="3">
                    <sys:toHtml>${bean.intro}</sys:toHtml>
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" rowspan="3" style="width:10%;">计划总投资：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${bean.planTotalInvest}
                </td>
                <td class="form_border" rowspan="3" style="width:5%;">工可批复总投资</td>
                <td class="form_label_right" style="width: 10%;">总投资：</td>
                <td class="form_content" style="width: 25%;">
                    ${bean.gkpfTotalInvest}
                </td>
                <td class="form_border" rowspan="3" style="width:5%;">初设批复总投资</td>
                <td class="form_label_right" style="width: 10%;">总投资：</td>
                <td class="form_content" style="width: 25%;">
                    ${bean.csTotalInvest}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;">前期费用：</td>
                <td class="form_content" style="width: 25%;">
                    ${bean.gkpfPreInvest}
                </td>
                <td class="form_label_right" style="width: 10%;">前期费用：</td>
                <td class="form_content" style="width: 25%;">
                    ${bean.csPreInvest}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;">建安费用：</td>
                <td class="form_content" style="width: 25%;">
                    <form:input path="gkpfJaInvest" cssClass="input_number"/>
                </td>
                <td class="form_label_right" style="width: 10%;">建安费用：</td>
                <td class="form_content" style="width: 25%;">
                    <form:input path="csJaInvest" cssClass="input_number"/>
                </td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>建设公司：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${content.jsgs}
                </td>
                <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_dlfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_dlfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_dlfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_dlfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_xmfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_xmfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_xmfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_xmfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_lxr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_lxr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_lxr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jsgs_lxr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>勘察单位：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${content.kcdw}
                </td>
                <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_dlfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_dlfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_dlfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_dlfr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_xmfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_xmfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_xmfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_xmfr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_lxr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_lxr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_lxr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.kcdw_lxr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>设计单位：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${content.sjdw}
                </td>
                <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_dlfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_dlfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_dlfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_dlfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_xmfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_xmfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_xmfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_xmfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_lxr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_lxr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_lxr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sjdw_lxr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>施工单位：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${content.sgdw}
                </td>
                <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_dlfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_dlfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_dlfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_dlfr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_xmfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_xmfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_xmfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_xmfr_phone}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_lxr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_lxr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_lxr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.sgdw_lxr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" rowspan="3" style="width:10%;" nowrap>监理单位：</td>
                <td class="form_content" style="width: 15%;" rowspan="3">
                    ${content.jldw}
                </td>
                <td class="form_label_right" style="width: 10%;" nowrap>单独独立法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_dlfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_dlfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_dlfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_dlfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>项目法人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_xmfr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_xmfr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_xmfr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_xmfr_phone}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 10%;" nowrap>联系人：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_lxr}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>电话：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_lxr_tel}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>传真：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_lxr_fax}
                </td>
                <td class="form_label_right" style="width: 5%;" nowrap>手机：</td>
                <td class="form_content" style="width: 15%;">
                    ${content.jldw_lxr_phone}
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="div_space"></div>
    <div style="text-align: center;">
        <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
    </div>
</div>
