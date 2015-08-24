<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    var today = new Date();
    var currYear=today.getFullYear();
    var currMonth=today.getMonth()+1;
    var year=today.getFullYear();
    var month=today.getMonth()+1;
    var i=0;       //用于和历史数据中的最大年月一起判断 是否已添加

    $(function () {
        //页面验证初始化
        var validateCondition = [
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function saveSch(btn) {
        if (!validateForm(formId)) {
            return;
        }
        //提交表单
        saveAjaxData("${ctx}/projExtendSchedule/save.do", formId);
    }
    function addLineSch(obj) {
        if(currYear!=year||currMonth!=month){
            alert("已经添加过"+currYear+"年"+currMonth+"月的数据！");
            return;
        }
        //如果将当前年月的数据删掉 ，就不再根据历史数据最大年月进行判断
        if(i==0&&currYear==${BigYear}&&currMonth==${BigMonth}){
            alert("已经添加过"+currYear+"年"+currMonth+"月的数据！");
            return;
        }

        var target=$("#hiddenStyle");
        target.find("input[name='yearSch']").val(year);
        target.find("input[name='monthSch']").val(month);
        target.find("input[name='titleSch']").val(year + "年" + month + "月");
        target.find("span[name='titleSch']").text(year + "年" + month + "月");
        if (obj.value == '增加') {
            $("#tablesDiv").append(target.html() + "");
            if(month==12){
                year=year+1;
                month=1;
            }else{
                month=month+1;
            }
        }
        target.find("input[name='yearSch']").val("");
        target.find("input[name='monthSch']").val("");
        target.find("input[name='titleSch']").val("");
        target.find("span[name='titleSch']").text("");
    }

    function deleteLineSch(obj,yearsch,monthsch) {
        if(currYear==yearsch&&currMonth==monthsch){
            if (confirm("确定要删除吗!")) {
                var trObj = obj.parentNode.parentNode.parentNode;
                trObj.parentElement.removeChild(trObj);
                    year=currYear;
                    month=currMonth;
                i=i+1;       //如果将当前年月的数据删掉 ，就不再根据历史数据最大年月进行判断
            }
        }else{
            alert("历史数据不能删！");
        }
    }
</script>
<style type="text/css">
    .input {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 98.5%;
        height: 40px;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">

            <tr class="tr_light">
                <td class="form_label_right" width="20%">是否开工：</td>
                <td class="form_content" width="30%">
                    <select name="gcjsIsBigin">
                        <option value="1"
                        <c:if test="${bean.gcjsIsBigin =='1'}"> selected </c:if>>已开工</option>
                        <option value="0"
                        <c:if test="${bean.gcjsIsBigin =='0'}">selected </c:if>>未开工</option>
                    </select>
                </td>
                <td class="form_label_right" width="20%">开工时间：</td>
                <td class="form_content" width="30%">
                    <input type="text" name="gcjsBeginTime" class="input_date"
                           value="${bean.gcjsBeginTime}" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('gcjsBeginTime','all')">
                </td>
            </tr>

            <tr class="tr_light">
                <td class="form_label_right">是否完工：</td>
                <td class="form_content">
                    <select name="gcjsIsEnd">
                        <option value="1"
                        <c:if test="${bean.gcjsIsEnd =='1'}"> selected </c:if>>已开工</option>
                        <option value="0"
                        <c:if test="${bean.gcjsIsEnd =='0'}">selected </c:if>>未开工</option>
                    </select>
                </td>
                <td class="form_label_right">完工时间：</td>
                <td class="form_content">
                    <input type="text" name="gcjsEndTime" class="input_date"
                           value="${bean.gcjsEndTime}" readonly="true"/>
                    <input type="button" class="button_calendar" value=" " onClick="calendar('gcjsEndTime','all')">
                </td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
               style="text-align: center;width: 98%;"
               id="itemTable">
            <tr class="tr_header">
                <td style="width: 15%;">时间</td>
                <td style="width:80%;" colspan="2">项目情况</td>
                <td style="width:5%;">
                    <input type='button' value='增加' class='button_select_add' onclick='addLineSch(this)'>
                </td>
            </tr></table>

            <c:forEach items="${bean.projExtendSchedules}" var="item">
                <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
                       style="text-align: center;width: 98%;">
                <tr class="tr_light">
                    <td width="15%" rowspan="4">
                        <input type="hidden" name="yearSch" value="${item.year}">
                        <input type="hidden" name="monthSch" value="${item.month}">
                        <input type="hidden" name="titleSch" value="${item.title}">
                        <span>${item.title}</span>
                    </td>
                    <td width="20%">项目进展情况</td>
                    <td width="60%">
                        <textarea  name="projProgress" class="input">${item.projProgress}</textarea>
                    </td>
                    <td width="5%" rowspan="4">
                        <input type="button" value="删除" class="button_select_remove"
                               onclick="deleteLineSch(this,${item.year},${item.month})">
                    </td>
                </tr>
                <tr class="tr_light">
                    <td> 存在问题</td>
                    <td>   <textarea  name="question" class="input">${item.question}</textarea>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td>改进意见</td>
                    <td>  <textarea  name="improveOpinion" class="input">${item.improveOpinion}</textarea>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td> 备注</td>
                    <td>  <textarea  name="description" class="input">${item.description}</textarea>
                    </td>
                </tr>
                </table>
            </c:forEach>

        <div id="tablesDiv"></div>
        <div id="hiddenStyle" style="display: none">
            <table cellpadding="0" cellspacing="0" border="1" class="table_thin_line"
                   style="text-align: center;width: 98%;">
                <tr class="tr_light">
                    <td width="15%" rowspan="4">
                        <input type="hidden" name="yearSch" >
                        <input type="hidden" name="monthSch" >
                        <input type="hidden" name="titleSch" >
                        <span name="titleSch"></span>
                    </td>
                    <td width="20%">项目进展情况</td>
                    <td width="60%">
                        <textarea  name="projProgress" class="input" ></textarea>
                    </td>
                    <td width="5%" rowspan="4">
                        <input type='button' value='删除' class='button_select_remove'
                               onclick='deleteLineSch(this,currYear,currMonth)'>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td> 存在问题</td>
                    <td>
                        <textarea  name="question" class="input"></textarea>
                    </td>
                </tr>
                <tr class="tr_light">
                    <td>改进意见</td>
                    <td>
                        <textarea  name="improveOpinion" class="input"></textarea>

                    </td>
                </tr>
                <tr class="tr_light">
                    <td> 备注</td>
                    <td>
                        <textarea  name="description" class="input"></textarea>

                    </td>
                </tr>
            </table>
        </div>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="saveSch(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="parent.closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>