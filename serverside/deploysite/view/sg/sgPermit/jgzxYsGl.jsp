<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(buttonName, status) {
        if (!validateForm(formId)) {
            return;
        }
        $("#status").val(status);
        if (confirm("是否确定执行 " + buttonName + " 操作？")) {
            saveAjaxData("${ctx}/sgPermit/saveJgzxYs.do", formId, doCloseWin);
        }
    }
    function doCloseWin() {
        parent.closeWindow();
    }
    function checkInteger(element) {
        if (isNaN(element.value)) {
            showInfoMsg('只能输入数字！', null);
            element.value = element.value.replace(/[^\d]/g, '');
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <input type="hidden" name="projectType" id="projectType" value="${bean.projectType.id}">
    <input type="hidden" name="propertyType" id="propertyType" value="${bean.propertyType.id}">

    <div class="form_div">
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>申请信息</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>项目性质：</td>
                    <td class="form_content">${bean.propertyType.name}</td>
                    <td class="form_label_right" nowrap>所属区县：</td>
                    <td class="form_content">${bean.areaName}</td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>报建编号：</td>
                    <td class="form_content">${bean.bjbh}<form:hidden path="bjbh"/></td>
                    <td class="form_label_right" nowrap>标段号：</td>
                    <td class="form_content">${bean.bdh}<form:hidden path="bdh"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right" nowrap>业务编号：</td>
                    <td class="form_content" colspan="3">${bean.bizCode}<form:hidden path="bizCode"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">项目名称：</td>
                    <td class="form_content" colspan="3">${bean.projectName}<form:hidden path="projectName"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设单位：</td>
                    <td class="form_content" colspan="3">${bean.buildName}<form:hidden path="buildName"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" style="width: 20%;">建设单位性质：</td>
                    <td class="form_content" style="width: 30%;">${bean.buildUnitType}<form:hidden
                            path="buildUnitType"/></td>
                    <td class="form_label_right" style="width: 15%;">建设单位地址：</td>
                    <td class="form_content" style="width: 35%;">${bean.buildUnitAddress}<form:hidden
                            path="buildUnitAddress"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设单位法定代表人：</td>
                    <td class="form_content">${bean.fr}<form:hidden path="fr"/></td>
                    <td class="form_label_right">建设单位联系电话：</td>
                    <td class="form_content">${bean.buildUnitPhone}<form:hidden path="buildUnitPhone"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">建设单位联系人：</td>
                    <td class="form_content">${bean.buildUnitPerson}<form:hidden path="buildUnitPerson"/></td>
                    <td class="form_label_right">手机号：</td>
                    <td class="form_content">${bean.buildUnitMobile}<form:hidden path="buildUnitMobile"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设地点：</td>
                    <td class="form_content" colspan="3">${bean.buildSite}<form:hidden path="buildSite"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设地点所属区县：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${areaList}" var="item" varStatus="status">
                            <input type="radio" value="${item.id}" disabled
                                   <c:if test="${item.code==bean.buildSiteCounty}">checked</c:if>>${item.name}&nbsp;
                            <c:if test="${(status.index+1)%9==0}"><br></c:if>
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">建设工程类别：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${lbs}" var="item">
                            <input type="checkbox" name="buildLbId" value="${item.id}"
                                   <c:if test="${fn:contains(bean.buildLbIds, item.id)}">checked</c:if>
                                   disabled>${item.name}&nbsp;
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">建设工程属性：</td>
                    <td class="form_content" colspan="3">
                        <c:forEach items="${sxs}" var="item">
                            <input type="radio" name="buildSx" value="${item.id}"
                                   <c:if test="${bean.buildSx.id == item.id}">checked</c:if> disabled>${item.name}&nbsp;
                        </c:forEach>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">建设工程规模：</td>
                    <td class="form_content" colspan="3">${bean.buildProjSize}<form:hidden path="buildProjSize"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">国有资金比重%：</td>
                    <td class="form_content" colspan="3">
                            ${bean.nationalFundsPro}
                        <form:hidden path="nationalFundsPro"/>
                    </td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">合同价格（万元）：</td>
                    <td class="form_content">${bean.contractPrice}<form:hidden path="contractPrice"/></td>
                    <td class="form_label_right">合同工期（日历天）：</td>
                    <td class="form_content">${bean.contractPeriod}<form:hidden path="contractPeriod"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right" nowrap>中标价格（万元）：</td>
                    <td class="form_content">${bean.zbPrice}<form:hidden path="zbPrice"/></td>
                    <td class="form_label_right" nowrap>项目投资估算（万元）：</td>
                    <td class="form_content">${bean.projectPlanCost}<form:hidden path="projectPlanCost"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">计划开工：</td>
                    <td class="form_content">
                        <fmt:formatDate value="${bean.contractBeginDate}" pattern="yyyy-MM-dd"/>
                        <form:hidden path="contractBeginDate"/>
                    </td>
                    <td class="form_label_right">计划竣工：</td>
                    <td class="form_content">
                        <fmt:formatDate value="${bean.contractEndDate}" pattern="yyyy-MM-dd"/>
                        <form:hidden path="contractEndDate"/>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">现场开工情况：</td>
                    <td class="form_content" colspan="3">${bean.startWorkCon}<form:hidden path="startWorkCon"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">施工单位：</td>
                    <td class="form_content">${bean.sgUnitName}<form:hidden path="sgUnitName"/></td>
                    <td class="form_label_right">项目经理：</td>
                    <td class="form_content">${bean.sgUnitManager}<form:hidden path="sgUnitManager"/></td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">监理单位：</td>
                    <td class="form_content">${bean.jlUnitName}<form:hidden path="jlUnitName"/></td>
                    <td class="form_label_right">项目总监：</td>
                    <td class="form_content">${bean.jlUnitManager}<form:hidden path="jlUnitManager"/></td>
                </tr>
                <tr class="tr_dark">
                    <td class="form_label_right">设计单位：</td>
                    <td class="form_content" colspan="3">${bean.sjUnitName}<form:hidden path="sjUnitName"/></td>
                </tr>
                <tr class="tr_light">
                    <td colspan="4" class="form_content">
                        <input type="checkbox" <c:if test="${not empty bean.isZftzl}">checked </c:if> disabled>是否政府投资类
                        <form:hidden path="isZftzl"/>
                    </td>
                </tr>
                <tr id="yzzpl" <c:if test="${empty bean.isZftzl}">style="display: none" </c:if> class="tr_dark">
                    <td colspan="4">
                        <table style="width: 99%;">
                            <tr>
                                <td rowspan="4" valign="top">预制装配率</td>
                                <td>单跨跨径100米以下桥梁工程承台顶面以上构件</td>
                                <td>${bean.yzzpl_1}<form:hidden path="yzzpl_1"/>%</td>
                            </tr>
                            <tr>
                                <td>隧道工程盾构段</td>
                                <td>${bean.yzzpl_2}<form:hidden path="yzzpl_2"/>%</td>
                            </tr>
                            <tr>
                                <td>轨道交通工程地下过街通道</td>
                                <td>${bean.yzzpl_3}<form:hidden path="yzzpl_3"/>%</td>
                            </tr>
                            <tr>
                                <td>水运工程（港口）桩顶面以上构件</td>
                                <td>${bean.yzzpl_4}<form:hidden path="yzzpl_4"/>%</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                            <tr class="tr_header">
                                <td style="width: 5%;">序号</td>
                                <td style="width: 50%;">申请材料名称</td>
                                <td style="width: 8%;">应交份数</td>
                                <td style="width: 8%;">实交份数</td>
                                <td style="width: 15%;">附件</td>
                            </tr>
                            <c:forEach items="${applyList}" var="map">
                                <c:set value="upLoad${map.no}" var="upLoadNo"/>
                                <tr class="tr_dark">
                                    <td style="text-align: center;">${map.no}
                                        <input type="hidden" name="no" value="${map.no}">
                                    </td>
                                    <td style="text-align: left;">${map.materialName}</td>
                                    <td style="text-align: center;">${map.yjNum}
                                        <input type="hidden" name="yjNum${map.no}"
                                               value="<c:if test="${map.yjNum != 0}">${map.yjNum}</c:if>">
                                    </td>
                                    <td style="text-align: center;">${map.sjNum}
                                        <input type="hidden" name="sjNum${map.no}" class="input_number"
                                               value="${map.sjNum}" style="text-align: center;">
                                    </td>
                                    <td style="text-align: center;">${map[upLoadNo]}
                                        <c:set value="docId${map.no}" var="docIdNo"/>
                                        <input id="docId${map.no}" type="hidden" value="${map[docIdNo]}" name="docId${map.no}">
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td class="form_label_right">提交时间：</td>
                    <td class="form_content" colspan="3">
                        <fmt:formatDate value="${bean.submitDate}" pattern="yyyy-MM-dd HH:mm"/>
                        <form:hidden path="submitDate"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <div class="div_space"></div>
        <fieldset class="form_fieldset" style="width: 96%;">
            <legend>建管中心预审</legend>
            <table cellpadding="0" cellspacing="0" class="form_table">
                <tr class="tr_light">
                    <td class="form_label_right" nowrap style="width: 20%;">预审信息：</td>
                    <td class="form_content" style="width: 80%;">
                        <form:textarea path="jgzxYsOpinion" cssClass="input_textarea_long" cssStyle="width: 96%;"/>
                    </td>
                </tr>
            </table>
        </fieldset>
        <div style="text-align: center;" class="tr_button">
            <input type="button" value="预审通过" class="button_normal_long"
                   onclick="save(this.value,'${STATUS_JGZX_YS_PASS}')">&nbsp;
            <input type="button" value="预审退回" class="button_normal_long"
                   onclick="save(this.value,'${STATUS_JGZX_YS_BACK}')">&nbsp;
            <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
        </div>
        <div class="div_space"></div>
    </div>
</form:form>
