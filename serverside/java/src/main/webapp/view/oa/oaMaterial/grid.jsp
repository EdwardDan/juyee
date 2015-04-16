<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMaterial/gridDataCustom.do",
                colNames: ['ID',
                    '申请编号',
                    '申请日期',
                    '申请人',
                    '申请部门',
                    '状态',
                    '状态code',
                    '创建人',
//                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "reportDate", width: "20", align: "center", searchtype: "date", sortable: true},
                    {name: "reportPerson", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "reportDept", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "statusName", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "5", align: "center", searchtype: "integer", hidden: true},
                    {name: "createUser", width: "10", align: "center", searchtype: "string", hidden: true}
//                    {name: "documentDownload", width: "47", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "物资设备采购管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];

                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["status"];//获取每一行的状态
                        var createUser = rowData["createUser"]; //获取每一行创建人
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canOfficeAudit}">
                        if (statusCode == ${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审批" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        <c:if test="${canLeaderAudit}">
                        if (statusCode == ${STATUS_SUBMIT_LEADER}) {
                            opButton += '<input type="button" value="审批" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        <c:if test="${canEdit}">
                        if (statusCode == ${STATUS_EDIT} || statusCode == ${STATUS_BACK} || statusCode == ${STATUS_BACK_LEADER}) {
                            if (createUser == '${currentUser}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            } else {   //不是当前登录用户时，判断其是否有强制删除权限
                                <c:if test="${canDelete}">
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                </c:if>
                            }
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "申请编号", "op": "cn", "data": ""},
                    { "field": "申请日期", "op": "bt", "data": ""},
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "申请部门", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看物资设备采购管理", "${ctx}/oaMaterial/view.do?id=" + id, false, 900, 550);
    }
    <c:if test="${canEdit || canOfficeAudit || canLeaderAudit}">
    function doAdd() {
        openWindow("物资设备申请", "${ctx}/oaMaterial/add.do", true, 900, 550);
    }
    function doEdit(id) {
        openWindow("修改物资设备采购管理", "${ctx}/oaMaterial/modify.do?id=" + id, true, 900, 550);
    }
    function doAudit(id) {
        openWindow("审核物资设备采购管理", "${ctx}/oaMaterial/audit.do?id=" + id, true, 900, 550);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaMaterial/delete.do?id=" + id);
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
                <input type="button" value="申请" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>