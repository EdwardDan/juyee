<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaCar/gridDataCustom.do",
                colNames: ['ID',
                    '申请部门',
                    '申请人',
                    '用车日期',
                    '起始时间',
                    '拟派车牌号',
                    '拟派驾驶员',
                    '事由',
                    '状态code',
                    '状态',
                    '创建人',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "applyDept", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "applyPerson", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "useDate", width: "15", align: "center", searchtype: "date", sortable: true},
                    {name: "useTime", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "carNo", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "driverName", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "useReason", width: "35", align: "left", searchtype: "string", sortable: true},
                    {name: "status", width: "10", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "createUser", width: "10", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "车辆管理",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];
                        var createUser = rowData["createUser"];  //获取每一行数据的创建人
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        if (rowDataCell ==${STATUS_EDIT} || rowDataCell ==${STATUS_BACK}) {
                            if (createUser == '${currentUser}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            } else {
                                <c:if test="${canDelete}">
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                </c:if>
                            }
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
                    { "field": "申请部门", "op": "cn", "data": ""},
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "拟派车牌号", "op": "cn", "data": ""},
                    { "field": "拟派司机", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看车辆管理", "${ctx}/oaCar/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit||canAudit}">
    function doAdd() {
        openWindow("车辆申请", "${ctx}/oaCar/add.do", true, 800, 500);
    }
    function doEdit(id) {
        openWindow("修改车辆管理", "${ctx}/oaCar/modify.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaCar/delete.do?id=" + id);
    }
    function doAudit(id) {
        openWindow("审核车辆管理", "${ctx}/oaCar/audit.do?id=" + id, true, 800, 500);
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
                <input type="button" value="申请" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>