<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "beanDwgc";
    function getCustomCode() {
        var jdTaskCode = $("#jdTaskCode").val();
        var reportType = $("#reportType").val();
        var year =$("#year").val();
        var num = 0;
        $("input[name^=customCode_]").each(function () {
            if (this.value == '') {
                num++
            }
        });
        if(num==0){
            alert("编号已全部生成，无需生成！");
        }
        //判断项目类型是否选择
        if(reportType==''){
           alert("请返回基本信息页面选择项目类型！");
           return;
        }
        var url = "${ctx}/excelJdTasks/getCustomCode.do?"+encodeURI("jdTaskCode=" + jdTaskCode+"&reportType="+reportType +"&year="+year+"&count=" + num);
        var data =getAjaxData(url);
        var vc = '';
        if (data != null) {
            for (var key in data) {
                vc += data[key] + ",";
            }
        }
        if (vc.length > 0) {
            vc = vc.substr(0, vc.length - 1).split(",");
        } else {
            vc = vc.split(",");
        }
        var j = 0;
        $("input[id^=customCode_]").each(function () {
            if (this.value == '') {
                this.value = vc[j];
                j++;
            }
        });
    }

    //保存操作
    function save(btn) {
        var jdTaskCode = $("#jdTaskCode").val();
        var reportType = $("#reportType").val();
        //判断电梯数量为整数
        var r = /^[-+]?\d*$/;
        var flag = true;
        $("input[id^=ts_]").each(function () {
            if (!r.test(this.value)) {
                flag=false;
                alert("请确认输入的电梯信息为整数！");
            }
        });
        if(flag){
            saveAjaxData("${ctx}/excelJdTasks/modifyDwgcSave.do?"+encodeURI("jdTaskCode=" + jdTaskCode+"&reportType=" + reportType), formId, true);
        }
    }

</script>
<style type="text/css">
    .input_texts {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 70px;
        height: 20px;
    }
</style>
<form:form commandName="beanDwgc">
    <div class="form_div">
        <%--<input type="hidden" name="jdTaskCode" value="${jdTaskCode}">--%>
        <%--<input type="hidden" name="reportType" value="${reportType}">--%>
        <input type="hidden" name="year" id="year" value="${year}"/>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header">
                <td class="form_border" nowrap  width="15%">单位工程名称</td>
                <td class="form_border" nowrap  width="10%">单位工程编号</td>
                <td class="form_border" nowrap  width="8%">${projectArea}区单位工程编号</td>
                <td class="form_border" nowrap  width="8%">工程类型</td>
                <td class="form_border" nowrap  width="8%">建筑面积</td>
                <td class="form_border" nowrap  width="8%">地上层数</td>
                <td class="form_border" nowrap  width="8%">地下层数</td>
                <td class="form_border" nowrap  width="8%">电梯台数</td>
                <td class="form_border" nowrap  width="8%">造价（万元）</td>
                <td class="form_border" nowrap  width="10%">结构类型</td>
            </tr>
            <c:forEach items="${list}" var="bean" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                    <td class="form_border">
                            ${bean.dwgcName}
                    </td>
                    <td class="form_border">
                        <input name="dwgcCode" class="input_text" value="${bean.dwgcCode}" style="width:100px">
                    </td>
                    <td calss="form_border">
                        <input name="customCode_${bean.dwgcCode}" id="customCode_${bean.dwgcCode}" class="input_text" style="width:90px"
                               value="${bean.customCode}">
                    </td>
                    <td class="form_border">
                        <input name="projectType" class="input_texts" value="${bean.projectType}">
                    </td>
                    <td class="form_border">
                        <input name="dwgcArea" class="input_texts" value="${bean.dwgcArea}">
                    </td>
                    <td class="form_border">
                        <input name="upCs" class="input_texts" value="${bean.upCs}">
                    </td>
                    <td class="form_border">
                        <input name="downCs" class="input_texts" value="${bean.downCs}">
                    </td>
                    <td class="form_border">
                        <input name="ts" id="ts_${bean.dwgcCode}"class="input_texts" value="${bean.ts}">
                    </td>
                    <td class="form_border">
                        <input name="dwgcMoney" class="input_texts" value="${bean.dwgcMoney}">
                    </td>
                    <td class="form_border">
                        <input name="structType" class="input_texts" value="${bean.structType}">
                        <input type="hidden" name="dwgcIds" value="${bean.id}">
                    </td>
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_td_line" colspan="10">
                    <input type="button" value="生成编号" class="button_normal_long" onclick="getCustomCode()">
                    <input type="button" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>