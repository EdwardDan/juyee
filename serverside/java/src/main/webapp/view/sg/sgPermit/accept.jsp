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
      saveAjaxData("${ctx}/sgPermit/save.do", formId, doCloseWin);
    }
  }
  function doCloseWin() {
    parent.closeWindow();
  }
</script>
<form:form commandName="bean">
  <form:hidden path="id"/>
  <form:hidden path="year"/>
  <form:hidden path="status"/>
  <input type="hidden" name="projectType" id="projectType" value="${bean.projectType.id}">

  <div class="form_div">
    <fieldset class="form_fieldset" style="width: 96%;">
      <legend>申请信息</legend>
      <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_dark">
          <td class="form_label_right" nowrap>报建编号：</td>
          <td class="form_content">${bean.bjbh}<form:hidden path="bjbh"/></td>
          <td class="form_label_right" nowrap>业务编号：</td>
          <td class="form_content">${bean.bizCode}<form:hidden path="bizCode"/></td>
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
          <td class="form_label_right">建设地点：</td>
          <td class="form_content" colspan="3">${bean.buildSite}<form:hidden path="buildSite"/></td>
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
          <td class="form_label_right">开工日期：</td>
          <td class="form_content">
            <fmt:formatDate value="${bean.contractBeginDate}" pattern="yyyy-MM-dd"/>
            <form:hidden path="contractBeginDate"/>
          </td>
          <td class="form_label_right">完工日期：</td>
          <td class="form_content">
            <fmt:formatDate value="${bean.contractEndDate}" pattern="yyyy-MM-dd"/>
            <form:hidden path="contractEndDate"/>
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">法定代表人：</td>
          <td class="form_content">${bean.fr}<form:hidden path="fr"/></td>
          <td class="form_label_right">建设单位联系电话：</td>
          <td class="form_content">${bean.buildUnitPhone}<form:hidden path="buildUnitPhone"/></td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">建设单位联系人：</td>
          <td class="form_content">${bean.buildUnitPerson}<form:hidden path="buildUnitPerson"/></td>
          <td class="form_label_right">手机号：</td>
          <td class="form_content">${bean.buildUnitMobile}<form:hidden path="buildUnitMobile"/></td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">现场开工情况：</td>
          <td class="form_content" colspan="3">${bean.startWorkCon}<form:hidden path="startWorkCon"/></td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">施工单位：</td>
          <td class="form_content" colspan="3">${bean.sgUnitName}<form:hidden path="sgUnitName"/></td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">监理单位：</td>
          <td class="form_content" colspan="3">${bean.jlUnitName}<form:hidden path="jlUnitName"/></td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">设计单位：</td>
          <td class="form_content" colspan="3">${bean.sjUnitName}<form:hidden path="sjUnitName"/></td>
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
      <legend>受理初审</legend>
      <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
          <td class="form_label_right" nowrap style="width: 20%;">受理编号：</td>
          <td class="form_content" style="width: 80%;">
            <form:input path="acceptCode" cssClass="input_text_long"/>
          </td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">沪交管收字</td>
          <td class="form_content">
            （<form:input path="hjgYear" cssClass="input_number" cssStyle="text-align: center;"/> ）
            第<form:input path="hjgNum" cssClass="input_number" cssStyle="text-align: center;"/>号
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">申请人：</td>
          <td class="form_content">
            <form:input path="applyPerson" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">申请事项：</td>
          <td class="form_content">
            <form:input path="applyMatter" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">申请号：</td>
          <td class="form_content">
            <form:input path="applyNum" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">材料提交人：</td>
          <td class="form_content">
            <form:input path="materialPerson" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">材料提交人联系电话：</td>
          <td class="form_content">
            <form:input path="materialPersonPhone" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">材料提交人联系地址：</td>
          <td class="form_content">
            <form:input path="materialPersonAddress" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">收件人：</td>
          <td class="form_content">
            <form:input path="receivePerson" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_dark">
          <td class="form_label_right">收件人联系电话：</td>
          <td class="form_content">
            <form:input path="receivePersonPhone" cssClass="input_text" cssStyle="width: 96%;"/>
          </td>
        </tr>
        <tr class="tr_light">
          <td class="form_label_right">受理意见：</td>
          <td class="form_content">
            <form:textarea path="acceptOpinion" cssClass="input_textarea" cssStyle="width: 96%;"/>
          </td>
        </tr>
      </table>
    </fieldset>
    <div style="text-align: center;" class="tr_button">
      <input type="button" value="受理通过" class="button_normal_long"
             onclick="save(this.value,'${STATUS_SLZX_PASS}')">&nbsp;
      <input type="button" value="受理退回" class="button_normal_long"
             onclick="save(this.value,'${STATUS_SLZX_BACK}')">&nbsp;
      <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
    </div>
    <div class="div_space"></div>
  </div>
</form:form>
