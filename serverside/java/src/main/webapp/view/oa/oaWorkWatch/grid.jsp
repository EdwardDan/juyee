<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaWorkWatch/gridDataCustom.do",
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
                    {name: "statusName", width: "40", align: "center", searchtype: "string", sortable: false}
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
                        var buttonName = "";
                        if ('' == status || status == '${STATUS_EDIT}' || status == '${STATUS_BACK}' || status == '${STATUS_CHECK_BACK}') {
                            buttonName = "编辑";
                        } else if (status == '${STATUS_ZR_SH}') {
                            buttonName = "审核";
                        } else if (status == '${STATUS_INFO}') {
                            buttonName = "上报";
                        } else if (status == '${STATUS_B_CHECK}') {
                            buttonName = "核实";
                        }
                        <c:if test="${canEdit||canEdit_ZR||canEdit_KZ||canEdit_B}">
                        if (buttonName != '') {
                            opButton += '<input type="button" value="' + buttonName + '" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "上报科室", "op": "cn", "data": ""},
                    { "field": "上报人用户名", "op": "cn", "data": ""},
                    { "field": "科室分管领导", "op": "cn", "data": ""},
                    { "field": "上报开始时间", "op": "cn", "data": ""},
                    { "field": "上报结束时间", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看工作督办", "${ctx}/oaWorkWatch/view.do?id=" + id, false, 900, 450);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加工作督办", "${ctx}/oaWorkWatch/add.do", true, 900, 450);
    }
    function doEdit(id) {
        openWindow("修改工作督办", "${ctx}/oaWorkWatch/modify.do?id=" + id, true, 900, 450);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaWorkWatch/delete.do?id=" + id);
    }
    </c:if>

    //custom formatter
    //function customeFormat(cellvalue, options, rowObject) {
    //    return cellvalue == "true"?"是":"否";
    //}
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