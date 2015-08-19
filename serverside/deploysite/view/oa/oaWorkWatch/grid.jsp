<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaWorkWatch/gridDataCustom.do",
                multiselect: true,
                multiselectWidth: 30,
                colNames: ['ID',
                    '上报科室',
                    '科室分管领导',
                    '上报开始时间',
                    '上报结束时间',
                    '状态Id',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportDept", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "beginDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    {name: "endDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    {name: "status", width: "30", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "statusName", width: "40", align: "center", searchtype: "String", sortable: false}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "工作督办列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if ('' == status || status == '${STATUS_EDIT}' || status == '${STATUS_ZR_BACK}' || status == '${STATUS_B_BACK}') {
                            if (${canEdit}) {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_SUBMIT}') {
                            if (${canEdit_ZR}) {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_ZR_PASS}') {
                            if (${canEdit_KZ}) {
                                opButton += '<input type="button" value="上报" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_INFO}') {
                            if (${canEdit_B}) {
                                opButton += '<input type="button" value="核实" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "上报科室", "op": "cn", "data": ""},
                    { "field": "科室分管领导", "op": "cn", "data": ""},
                    { "field": "上报开始时间", "op": "bt", "data": ""},
                    { "field": "上报结束时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    var TAB_NO="${tab}";
    function doView(id) {
        parent.openWindow("查看工作督办", "${ctx}/oaWorkWatch/view.do?id=" + id, false,700,450,TAB_NO);
    }
    function doAdd() {
        parent.openWindow("添加工作督办", "${ctx}/oaWorkWatch/add.do", true,700,450,TAB_NO);
    }
    function doSum(btn)
    {
        var ids = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (ids == null || ids == "") {
            showInfoMsg("请选择需要汇总的记录！");
            return;
        }
        btn.disable = true;
        return parent.openWindow("工作督办汇总", "${ctx}/oaWorkWatchSum/add.do?ids="+ids, true,700,450,TAB_NO);

    }
    function doEdit(id) {
        parent.openWindow("修改工作督办", "${ctx}/oaWorkWatch/modify.do?id=" + id, true,700,450,TAB_NO);
    }
    function doAudit(id) {
        parent.openWindow("审核工作督办", "${ctx}/oaWorkWatch/audit.do?id=" + id, true,700,450,TAB_NO);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaWorkWatch/delete.do?id=" + id);
    }
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
                <input type="button" value="汇总" class="button_all" onclick="doSum(this)"/>
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>