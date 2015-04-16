<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMonthplanSum/gridDataCustom.do",
                colNames: ['ID',
                    '报告时间',
                    '已审核通过部门（已汇总部门）',
                    '状态',
                    '状态code',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportTime", width: "20", align: "center", searchtype: "date", sortable: false},
                    {name: "reportDepts", width: "80", align: "left", searchtype: "string", sortable: false},
                    {name: "statusName", width: "20", align: "center", searchtype: "string", sortable: false},
                    {name: "status", width: "5", align: "center", searchtype: "integer", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "月度总结和计划汇总列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];

                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["status"];//获取每一行的状态

                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canAudit}">
                        if (statusCode == ${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        <c:if test="${canEdit}">
                        if (statusCode == ${STATUS_BACK_LEADER} || statusCode == ${STATUS_EDIT}) {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
//                    { "field": "报告年份", "op": "cn", "data": ""},
//                    { "field": "报告月份", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看月度总结和计划汇总", "${ctx}/oaMonthplanSum/view.do?id=" + id, false, 900, 550);
    }
    <c:if test="${canEdit || canAudit}">
    function doAdd() {
        openWindow("添加月度总结和计划汇总", "${ctx}/oaMonthplanSum/add.do", true, 900, 550);
    }
    function doEdit(id) {
        openWindow("修改月度总结和计划汇总", "${ctx}/oaMonthplanSum/modify.do?id=" + id, true, 900, 550);
    }
    function doAudit(id) {
        openWindow("审核月度总结和计划汇总", "${ctx}/oaMonthplanSum/audit.do?id=" + id, true, 900, 550);
    }
    function doCount() {
        openWindow("选择年和月进行汇总", "${ctx}/oaMonthplanSum/count.do", true, 350, 200);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaMonthplanSum/delete.do?id=" + id);
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
                <input type="button" value="汇总" class="button_add" onclick="doCount()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>报告年份:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="year" class="input-elm">
                    <option value="">==请选择==</option>
                    ${yearOptions}
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>报告月份:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="period" class="input-elm">
                    <option value="">==请选择==</option>
                    ${monthOptions}
                </select>
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>