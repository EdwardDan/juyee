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
                    '用车时间',
                    '起止时间',
                    '拟派车牌',
                    '拟派驾驶员',
                    '用车事由',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "applyDept.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "applyUser.displayName", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "beginTime", width: "30", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    {name: "endTime", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "car.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "driverPerson.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "useCause", width: "53", align: "left", searchtype: "string", sortable: true},
                    {name: "statu", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "车辆申请列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';

                        <c:if test="${canEdit}">
                        if (rowData['statu'].indexOf("填写") > 0 || rowData['statu'].indexOf("科长审核退回") > 0 || rowData['statu'].indexOf("办公室主任审核退回") > 0) {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        } else if (rowData['statu'].indexOf("提交") > 0 || rowData['statu'].indexOf("科长审核通过") > 0||rowData['statu'].indexOf("办公室主任审核通过") > 0) {
                            <c:if test="${canKzAudit || canZrAudit}">
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            </c:if>
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "用车时间", "op": "bt", "data": ""},
                    { "field": "拟派车牌", "op": "cn", "data": ""},
                    { "field": "拟派驾驶员", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看车辆申请", "${ctx}/oaCar/view.do?id=" + id, false, 800, 500);
    }

    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加车辆申请", "${ctx}/oaCar/add.do", true, 800, 500);
    }
    function doEdit(id) {
        openWindow("修改车辆申请", "${ctx}/oaCar/modify.do?id=" + id, true, 800, 500);
    }
    function doAudit(id) {
        openWindow("审核车辆申请", "${ctx}/oaCar/audit.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaCar/delete.do?id=" + id);
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