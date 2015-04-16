<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaQuarterplan/gridDataCustom.do",
                colNames: ['ID',
                    '提交部门',
                    '责任人',
                    '报告时间',
                    '提交时间',
                    '状态code',
                    '类型',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportDept", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "reportTime", width: "35", align: "center", searchtype: "string", sortable: true},
                    {name: "reportDate", width: "25", align: "center", searchtype: "date", sortable: true},
                    {name: "status", width: "10", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "reportType", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "statusName", width: "25", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "季度/年度总结计划列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        if (rowDataCell ==${STATUS_EDIT} || rowDataCell ==${STATUS_BACK}) {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }
                        </c:if>
                        <c:if test="${canAudit}">
                        if (rowDataCell ==${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "提交部门", "op": "cn", "data": ""},
                    { "field": "责任人", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        parent.openWindow("查看季度年度总结计划", "${ctx}/oaQuarterplan/view.do?id=" + id, false, 900, 525);
    }
    <c:if test="${canEdit||canAudit}">
    function doAdd() {
        openWindow("编辑总结计划", "${ctx}/oaQuarterplan/add.do", true, 900, 525);
    }
    function doEdit(id) {
        openWindow("编辑总结计划", "${ctx}/oaQuarterplan/modify.do?id=" + id, true, 900, 525);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaQuarterplan/delete.do?id=" + id);
    }
    function doAudit(id) {
        openWindow("季度年度总结计划审核", "${ctx}/oaQuarterplan/audit.do?id=" + id, true, 900, 525);
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
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>