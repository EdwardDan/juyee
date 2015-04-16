<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    var formId = "bean";
    refreshMarkStatue();
    function doSet(button, id) {
        openFullWindow("${ctx}/excelJdTasksPosition/map.do?id=" + id, 900, 600);
    }
    //保存成功后切换到单位工程tab页面
    function save(btn) {
        saveAjaxData("${ctx}/excelJdTasks/save.do", formId, jumpTab, "notClose");
    }

    function refreshMarkStatue() {
        $("#mark").html(getAjaxData("${ctx}/excelJdTasksPosition/markCheck.do?id=${bean.id}"));

    }
</script>

<form:form commandName="bean">
    <form:hidden path="id"></form:hidden>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right">
                    报监日期：
                </td>
                <td class="form_content">
                    &nbsp;<fmt:formatDate value="${bean.jdDatetime}" pattern="yyyy-MM-dd"/>
                </td>
                <td class="form_content" colspan="2">
                    &nbsp;
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right" width="15%">
                    监督任务书编号：
                </td>
                <td class="form_content" width="35%">
                    &nbsp;${bean.jdTaskCode}
                </td>
                <td class="form_label_right" width="15%">项目类型：</td>
                <td class="form_content"  width="35%">
                   &nbsp;${bean.reportType}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">
                    报建编号：
                </td>
                <td class="form_content">
                    &nbsp;${bean.bjbh}
                </td>
                <td class="form_label_right">
                    标段号：
                </td>
                <td class="form_content">
                    &nbsp;${bean.bid}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">
                    项目名称：
                </td>
                <td class="form_content" colspan="3">
                    &nbsp;${bean.projectName}
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">
                    工程地点：
                </td>
                <td class="form_content" colspan="3">
                    &nbsp;${bean.projectAdd}
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">
                    所在县区：
                </td>
                <td class="form_content">
                    &nbsp;${bean.belongArea}
                </td>
                <td class="form_label_right">
                    合同价：
                </td>
                <td class="form_content">
                    &nbsp;${bean.contMoney}(万元)
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">
                    建安工作量：
                </td>
                <td class="form_content">
                    &nbsp;${bean.jagzl}(万元)
                </td>
                <td class="form_label_right">
                    面积：
                </td>
                <td class="form_content">
                    &nbsp;${bean.buildArea}(㎡)
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">
                    电梯数量：
                </td>
                <td class="form_content" colspan="3">
                    &nbsp;${bean.dtsl}(个)
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content" colspan="3">&nbsp;${bean.jsUnitName}</td>

            </tr>
            <tr class="tr_light">
                <td class="form_label_right">建设单位地址：</td>
                <td class="form_content">&nbsp;${bean.jsUnitAdd}</td>
                <td class="form_label_right">邮政编码：</td>
                <td class="form_content">&nbsp;${bean.zipcode}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;${bean.jsLinkman}</td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;${bean.jsPhone}</td>
            </tr>
        </table>

        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_header">
                <td colspan="6">参建单位</td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right" width="15%">施工总包单位：</td>
                <td class="form_content" width="25%">&nbsp;${bean.sgzbUnitName}</td>
                <td class="form_label_right" width="10%">联系人：</td>
                <td class="form_content" width="20%">&nbsp;${bean.sgzbLinkman}</td>
                <td class="form_label_right"  width="10%">联系电话：</td>
                <td class="form_content" width="20%">&nbsp;${bean.sgzbPhone}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">勘察单位：</td>
                <td class="form_content">&nbsp;${bean.kcUnitName}</td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;${bean.kcLinkman}</td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;${bean.kcPhone}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">设计单位：</td>
                <td class="form_content">&nbsp;${bean.sjUnitName}</td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;${bean.sjLinkman}</td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;${bean.sjPhone}</td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">监理单位：</td>
                <td class="form_content">&nbsp;${bean.jlUnitName}</td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;${bean.jlLinkman}</td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;${bean.jlPhone}</td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">施工单位：</td>
                <td class="form_content">&nbsp;${bean.sgUnitName}</td>
                <td class="form_label_right">联系人：</td>
                <td class="form_content">&nbsp;${bean.sgLinkman}</td>
                <td class="form_label_right">联系电话：</td>
                <td class="form_content">&nbsp;${bean.sgPhone}</td>
            </tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_button">
                <td class="form_td_line" colspan="4">
                    <%--<input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;--%>
                    <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>