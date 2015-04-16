<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "beanDwgc";
    function goBack(){
        setBtn(true);
        var jdTasksCode = $("#jdTasksCode").val();
        var reportType = $("#reportType").val();
        window.location ="${ctx}/excelJdTasks/inputJdTasks.do?jdTasksCode="+jdTasksCode+"&reportType="+reportType;
    }
    function setBtn(isDisabled){
        if(isDisabled){
            $("#btnBack").attr("disabled",true);
            $("#btnCode").attr("disabled",true);
            $("#btnSave").attr("disabled",true);
            $("#btnClose").attr("disabled",true);
        }
    }

    function getCustomCode() {
        var jdTasksCode = $("#jdTasksCode").val();
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
           alert("请返回上一页面选择项目类型！");
           return;
        }
        var url = "${ctx}/excelJdTasks/getCustomCode.do?"+encodeURI("jdTaskCode=" + jdTasksCode+"&reportType="+reportType +"&year="+year+"&count=" + num);
//        var data =getAjaxData(url).split(",");
//        var j = 0;
//        $("input[id^=customCode_]").each(function () {
//            if (this.value == '') {
//                this.value = data[j].replace("[","").replace("]","");
//                j++;
//            }
//        });
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

    function save(btn) {
        var jdTasksCode = $("#jdTasksCode").val();
        var reportType = $("#reportType").val();
        saveAjaxData("${ctx}/excelJdTasks/inputSave.do", formId,function(){
            //保存之后刷新grid数据
            parent.refreshGrid();
            parent.closeWindow();
        });
    }
</script>

<form:form commandName="beanDwgc">
    <div class="form_div">
        <input type="hidden" name="jdTasksCode" id="jdTasksCode" value="${jdTasksCode}">
        <input type="hidden" name="year" id="year" value="${year}"/>
        <input type="hidden" name="reportType" id="reportType" value="${reportType}">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header">
                    <%--单位工程名称、单位工程编号、工程进度、工程类型、建筑面积、地上层数、地下层数、电梯台数、造价（万元）、结构类型--%>
                <td class="form_border" nowrap width="15%">单位工程名称</td>
                <td class="form_border" nowrap width="15%">单位工程编号</td>
                <td class="form_border" nowrap width="8%">${projectArea}区单位工程编号</td>
                <td class="form_border" nowrap width="10%">工程类型</td>
                <td class="form_border" nowrap width="8%">建筑面积</td>
                <td class="form_border" nowrap width="8%">地上层数</td>
                <td class="form_border" nowrap width="8%">地下层数</td>
                <td class="form_border" nowrap width="8%">电梯台数</td>
                <td class="form_border" nowrap width="10%">造价（万元）</td>
                <td class="form_border" nowrap width="10%">结构类型</td>
            </tr>
            <c:forEach items="${list}" var="bean" varStatus="status">
                <tr class="<c:choose><c:when test="${status.index % 2==0}">tr_light</c:when><c:otherwise>tr_dark</c:otherwise></c:choose>">
                    <td class="form_border">${bean.dwgcName}</td>
                    <td class="form_border">${bean.dwgcCode}<input type="hidden" name="dwgcCode" value="${bean.dwgcCode}"></td>
                    <td class="form_content">
                        <input name="customCode_${bean.dwgcCode}" id="customCode_${bean.dwgcCode}" value="${bean.customCode}" class="input_text">
                    </td>
                    <td class="form_border">${bean.projectType}</td>
                    <td class="form_border">${bean.dwgcArea}</td>
                    <td class="form_border">${bean.upCs}</td>
                    <td class="form_border">${bean.downCs}</td>
                    <td class="form_border">${bean.ts}</td>
                    <td class="form_border">${bean.dwgcMoney}</td>
                    <td class="form_border">${bean.structType}</td
                </tr>
            </c:forEach>
            <tr class="tr_button">
                <td class="form_td_line" colspan="10">
                    <input type="button" id="btnBack" value="上一步" class="button_back" onclick="goBack()">
                    <input type="button" id="btnCode" value="生成编号" class="button_normal_long" onclick="getCustomCode()">
                    <input type="button" id="btnSave" value="保存" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" id="btnClose" value="关闭" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>