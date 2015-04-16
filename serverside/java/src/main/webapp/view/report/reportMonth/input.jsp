<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
//        var validateCondition = [ ];
//        //设置本月数据位必输项
//        $('input[id^=monthValue]').each(function () {
//            validateCondition.push({name: this.name, rule: "validate[required,maxSize[4]"});
//        });
//        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        saveAjaxData("${ctx}/reportMonth/save.do", formId);
    }
    //输入数字验证
    function checkInteger(element) {
        if (isNaN(element.value)) {
            showInfoMsg('只能输入数字！', null);
            element.value = element.value.replace(/[^\d]/g, '');
        }
    }
    function checkNumner(element) {
        if (/^\d+\.\d+$/.test(element.value) || !isNaN(element.value)) {
        } else {
            showInfoMsg('只能输入整数和小数！', null);
            element.value = 0;
        }
    }
</script>
<style type="text/css">
    .input_textarea_short {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 100px;
        height: 22px;
    }
</style>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="month"/>
    <input type="hidden" name="defineId" value="${bean.reportDeptDefine.id}">
    <input type="hidden" name="versionId" value="${bean.version.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <br>
            <tr>
                <td colspan="2">
                    <span class="net_form_title">虹口区建筑业管理署综合报表</span>
                    <br><br>
                </td>
            </tr>
            <tr class="tr_light">
                <td align="left">
                    &nbsp;上报部门：${bean.reportDeptDefine.deptName}
                </td>
                <td align="right">
                    报表时间：${reportTime}&nbsp;
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line_center" border="1">
                        <tr class="tr_header">
                            <td nawrap width="10%"></td>
                            <td nawrap width="30%" colspan="2">项目</td>
                            <td nawrap width="10%">本月</td>
                            <td nawrap width="10%">累计</td>
                            <td nawrap width="10%">环比</td>
                            <td nawrap width="10%">同比</td>
                            <td nawrap width="10%">备注</td>
                        </tr>

                        <c:forEach items="${list}" var="item1" varStatus="level1">
                            <c:forEach items="${item1.item.reportStructures}" var="item2" varStatus="level2">
                                <c:if test="${fn:length(item2.reportStructures)>0}">
                                    <c:forEach items="${item2.reportStructures}" var="item3" varStatus="level3">
                                        <tr
                                                <c:if test="${level3.index%2==0}">class="tr_dark"</c:if>
                                                <c:if test="${level3.index%2==1}">class="tr_light"</c:if>
                                                >
                                            <c:if test="${level2.index==0 && level3.index==0}">
                                                <td rowspan="${item1.size}">
                                                    <strong>${item1.name}</strong>
                                                </td>
                                            </c:if>
                                            <c:if test="${level3.index==0}">
                                                <td rowspan="${fn:length(item2.reportStructures)}">
                                                    <strong>${item2.name}</strong></td>
                                            </c:if>
                                            <td align="left">
                                                &nbsp;${item3.name}
                                                <c:if test="${not empty item3.measureUnit}">(${item3.measureUnit.name})</c:if>
                                                <input type="hidden" name="item3Id" value="${item3.id}">
                                            </td>
                                            <td>
                                                <c:set var="monthValue" value="monthValue${item3.id}"/>
                                                <input type="text" class="input_number_short" style="width: 80%"
                                                       name="monthValue${item3.id}" id="monthValue${item3.id}"
                                                       value="${item1[monthValue]}" onchange="checkNumner(this)">
                                            </td>
                                            <td>
                                                <c:set var="accuValue" value="accuValue${item3.id}"/>
                                                <c:if test="${item3.isSumAccu}">
                                                    <input type="text" class="input_number_short" style="width: 80%"
                                                           name="accuValue${item3.id}" value="${item1[accuValue]}"
                                                           onchange="checkNumner(this)" readonly="true">
                                                </c:if>
                                                <c:if test="${!item3.isSumAccu}">
                                                    /
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:set var="percentHb" value="percentHb${item3.id}"/>
                                                <input type="text" class="input_number_short" style="width: 80%"
                                                       name="percentHb${item3.id}" value="${item1[percentHb]}"
                                                       onchange="checkNumner(this)" readonly="true">
                                            </td>
                                            <td>
                                                <c:set var="percentTb" value="percentTb${item3.id}"/>
                                                <input type="text" class="input_number_short" style="width: 80%"
                                                       name="percentTb${item3.id}" value="${item1[percentTb]}"
                                                       onchange="checkNumner(this)" readonly="true">
                                            </td>
                                            <td>
                                                <c:set var="description" value="description${item3.id}"/>
                                                <textarea class="input_textarea_short" rows="1"
                                                          name="description${item3.id}">${item1[description]}</textarea>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${fn:length(item2.reportStructures)==0}">
                                    <tr
                                            <c:if test="${level2.index%2==0}">class="tr_dark"</c:if>
                                            <c:if test="${level2.index%2==1}">class="tr_light"</c:if>
                                            >
                                        <c:if test="${level2.index==0}">
                                            <td rowspan="${item1.size}">
                                                <strong>${item1.name}</strong>
                                            </td>
                                        </c:if>
                                        <td colspan="2" align="left">
                                            &nbsp;${item2.name}
                                            <c:if test="${not empty item2.measureUnit}">(${item2.measureUnit.name})</c:if>
                                            <input type="hidden" name="item2Id" value="${item2.id}">
                                        </td>
                                        <td>
                                            <c:set var="monthValue" value="monthValue${item2.id}"/>
                                            <input type="text" class="input_number_short" style="width: 80%"
                                                   name="monthValue${item2.id}" id="monthValue${item2.id}"
                                                   value="${item1[monthValue]}" onchange="checkNumner(this)">
                                        </td>
                                        <td>
                                            <c:set var="accuValue" value="accuValue${item2.id}"/>
                                            <c:if test="${item2.isSumAccu}">
                                                <input type="text" class="input_number_short" style="width: 80%"
                                                       name="accuValue${item2.id}" value="${item1[accuValue]}"
                                                       onchange="checkNumner(this)" readonly="true">
                                            </c:if>
                                            <c:if test="${!item2.isSumAccu}">
                                                /
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:set var="percentHb" value="percentHb${item2.id}"/>
                                            <input type="text" class="input_number_short" style="width: 80%"
                                                   name="percentHb${item2.id}" value="${item1[percentHb]}"
                                                   onchange="checkNumner(this)" readonly="true">
                                        </td>
                                        <td>
                                            <c:set var="percentTb" value="percentTb${item2.id}"/>
                                            <input type="text" class="input_number_short" style="width:80%"
                                                   name="percentTb${item2.id}" value="${item1[percentTb]}"
                                                   onchange="checkNumner(this)" readonly="true">
                                        </td>
                                        <td>
                                            <c:set var="description" value="description${item2.id}"/>
                                            <textarea class="input_textarea_short" rows="1"
                                                      name="description${item2.id}">${item1[description]}</textarea>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="20%">
                    填报人：
                </td>
                <td class="form_content">
                    <form:input path="reportPerson" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_border" align="left" colspan="2">
                    &nbsp;填表说明：1、统计周期为当月26日至次月25日。
                </td>
            </tr>
            <tr class="tr_button" align="center">
                <td class="form_border" align="center" colspan="2">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>

</form:form>