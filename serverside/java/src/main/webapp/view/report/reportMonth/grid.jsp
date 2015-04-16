<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/reportMonth/gridDataCustom.do?code=${code}",
                colNames: ['ID',
                    '报表时间',
                    '填报人',
                    '提交时间',
                    '是否提交',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportTime", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "reportDate", width: "30", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
                    {name: "isValid", width: "20", align: "center", searchtype: "integer", sortable: true, formatter: booleanFormat}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "${name}综合报表月份上报列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "填报人", "op": "cn", "data": ""},
                    { "field": "提交时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看${name}综合报表月份上报", "${ctx}/reportMonth/view.do?id=" + id, false, 900, 550);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加${name}综合报表月份上报", "${ctx}/reportMonth/add.do", true, 900, 550);
    }
    function doEdit(id) {
        openWindow("修改${name}综合报表月份上报", "${ctx}/reportMonth/modify.do?id=" + id, true, 900, 550);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/reportMonth/delete.do?id=" + id);
    }
    function doCount() {
        openWindow("选择${name}报表年月", "${ctx}/reportMonth/count.do?code=${code}", true, 350, 200);
    }
    </c:if>

</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add" onclick="doCount()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>报表年份:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="year" class="input-elm">
                    <option value="">==请选择==</option>
                    ${yearOptions}
                </select>&nbsp;年
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>报表月份:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="month" class="input-elm">
                    <option value="">==请选择==</option>
                    ${monthOptions}
                </select>&nbsp;月
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>