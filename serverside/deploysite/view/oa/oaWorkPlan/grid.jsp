<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaWorkPlan/gridDataCustom.do",
                colNames: ['ID',
                    '上报科室',
                    '提交人',
                    '工作时间',
                    '状态值',
                    '状态',
                    '分管部门名称',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportDept", width: "47", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "47", align: "center", searchtype: "string", sortable: true},
                    {name: "workTime", width: "47", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "47", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "47", align: "center", searchtype: "string", sortable: true},
                    {name: "deptNames", width: "47", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "科室工作周上报列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var reportDept = rowData["reportDept"];//上报部门
                        var deptNames = rowData["deptNames"];//分管部门
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
                            if (status == '${STATUS_EDIT}' || '' == status || status == '${STATUS_MAIN_BACK}' || status == '${STATUS_BRANCH_BACK}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                        }
                        if (${canEdit_KZ}) {
                            if (status == '${STATUS_SUBMIT}') {
                                opButton += '<input type="button" value="科长审核" onclick="doAudit(' + id + ')" class="button_normal_longer"/> ';
                            }
                        }
                        if (${canEdit_FG}) {
                            if (status == '${STATUS_BRANCH_PASS}' && (deptNames.indexOf(reportDept) > -1)) {
                                opButton += '<input type="button" value="分管领导审核" onclick="doAudit(' + id + ')" class="button_normal_longer"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "上报科室", "op": "cn", "data": ""},
//                        {"field": "上报人用户名", "op": "cn", "data": ""},
//                        {"field": "上报人姓名", "op": "cn", "data": ""},
//                        {"field": "上报开始时间", "op": "cn", "data": ""},
//                        {"field": "上报结束时间", "op": "cn", "data": ""},
//                        {"field": "附件ID(预留)", "op": "cn", "data": ""},
//                        {"field": "状态", "op": "cn", "data": ""}
                    ]
                },
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看科室工作周上报", "${ctx}/oaWorkPlan/view.do?id=" + id, false, 900, 450);
    }
    <%--<c:if test="${canEdit}">--%>
    function doAdd() {
        openWindow("添加科室工作周上报", "${ctx}/oaWorkPlan/add.do", true, 900, 450);
    }
    function doEdit(id) {
        openWindow("修改科室工作周上报", "${ctx}/oaWorkPlan/modify.do?id=" + id, true, 900, 450);
    }
    function doAudit(id) {
        openWindow("审核科室工作周上报", "${ctx}/oaWorkPlan/audit.do?id=" + id, true, 900, 450);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaWorkPlan/delete.do?id=" + id);
    }
    <%--</c:if>--%>
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