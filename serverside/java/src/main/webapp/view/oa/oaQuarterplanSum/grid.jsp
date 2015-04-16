<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaQuarterplanSum/gridDataCustom.do",
                colNames: ['ID',
                    '报告时间',
                    '已审核通过部门（已汇总部门）',
                    '提交类型',
                    '状态',
                    '状态code',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: 'reportTime', width: 20, align: "center", searchtype: "string", sortable: false},
                    {name: 'reportDepts', width: 80, align: "left", searchtype: "string", sortable: false},
                    {name: 'reportType', width: 20, align: "center", searchtype: "string", sortable: false},
                    {name: 'statusName', width: 20, align: "center", searchtype: "string", sortable: false},
                    {name: 'status', width: 5, align: "center", searchtype: "integer", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "季度年度总结计划汇总列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (status == ${STATUS_EDIT} || status == ${STATUS_BACK}) {
                            <c:if test="${canEdit}">
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }
                        if (status == ${STATUS_SUBMIT}) {
                            <c:if test="${canAudit}">
                            opButton += '<input type="button" value="审核" onclick="doAdit(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
//                    { "field": "报告年份", "op": "cn", "data": ""},
//                    { "field": "报告季度", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看季度年度总结计划汇总", "${ctx}/oaQuarterplanSum/view.do?id=" + id, false, 900, 550);
    }
    <c:if test="${canEdit || canAudit}">
    function doAdd() {
        <%--parent.openFullWindow("${ctx}/oaQuarterplanSum/add.do", 900, 550);--%>
        openWindow("添加季度年度总结计划汇总", "${ctx}/oaQuarterplanSum/add.do", true, 900, 550);
    }
    function doEdit(id) {
        openWindow("修改季度年度总结计划汇总", "${ctx}/oaQuarterplanSum/modify.do?id=" + id, true, 900, 550);
    }
    function doAdit(id) {
        openWindow("审核季度年度总结计划汇总", "${ctx}/oaQuarterplanSum/audit.do?id=" + id, true, 900, 550);
    }
    function doCount() {
        openWindow("选择年和月进行汇总", "${ctx}/oaQuarterplanSum/count.do", true, 350, 200);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaQuarterplanSum/delete.do?id=" + id);
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
            <td class="columns" style='width: 15%;' nowrap>报告季度:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="period" class="input-elm">
                    <option value="">==请选择==</option>
                    ${quarterOptions}
                </select>
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>