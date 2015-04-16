<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/orderForm/gridDataCustom.do",
                colNames: ['ID',
                    '预约单号',
                    '监督任务书编号',
                    '工程名称',
                    '预约日期',
                    '监督负责人',
                    '受理日期',
                    '受理意见',
                    '状态',
                    '附件',
                    'status',
                    'cuser',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "orderForm.orderCode", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: 'orderForm.jdTaskCode', width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "orderForm.projectName", width: "68", align: "left", searchtype: "string", sortable: true},
                    {name: "orderForm.orderDatetime", width: "45", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i'}},
                    {name: "jdManagerName", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "acceptDatetime", width: "45", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i'}},
                    {name: "acceptOpinion", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "orderForm.orderStatus.name", width: "22", align: "center", searchtype: "string", sortable: true},
                    {name: "orderForm.formDoc.id", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "orderForm.orderStatus.code", width: "10", align: "center", searchtype: "string", hidden: true},
                    {name: "orderForm.createUser", width: "10", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 52, align: 'center'}
                ],
                pager: '#pager2',
                caption: "监督预约列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["orderForm.orderStatus.code"];
                        var createUserName = rowData["orderForm.createUser"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if ("${canEdit}" == "true" && ("${ORDER_FORM_STATUS_EDIT}" == statusCode || "${ORDER_FORM_STATUS_BACK}" == statusCode) && createUserName == "${currentUserName}") {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        } else if ("${canAudit}" == "true" && ("${ORDER_FORM_STATUS_NOTACCEPT}" == statusCode)) {
                            /*add 2014*/
                            opButton += '<input type="button" value="编辑" onclick="doEditPlus(' + id + ')" class="button_normal"/> ';
                            /*add 2014*/

                            opButton += '<input type="button" value="受理" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        } else if ("${canRedo}" == "true" && ("${ORDER_FORM_STATUS_ACCEPT}" == statusCode)) {
                            opButton += '<input type="button" value="重新安排" onclick="doAudit(' + id + ')" class="button_normal_long"/> ';
                        } else if ("${canMemoEdit}" == "true" && ("${ORDER_FORM_STATUS_BACK}" == statusCode)) {
                            opButton += '<input type="button" value="修改备注" onclick="doMemoEdit(' + id + ')" class="button_normal_long"/> ';
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                    addButtonHint();
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "监督任务书编号", "op": "cn", "data": ""},
                    { "field": "预约单号", "op": "cn", "data": ""},
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "预约日期", "op": "bt", "data": ""},
                    { "field": "受理日期", "op": "bt", "data": ""},
                    { "field": "状态", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    var winW = 800;
    var winH = 500;
    var winWAddAndEdit = 860;

    function doView(id) {
        openWindow("查看监督预约", "${ctx}/orderForm/view.do?id=" + id, false, winW, winH);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("填写监督预约", "${ctx}/orderForm/add.do", true, winWAddAndEdit, winH);
    }
    function doEdit(id) {
        openWindow("编辑监督预约", "${ctx}/orderForm/modify.do?id=" + id, true, winWAddAndEdit, winH);
    }

    function doDelete(id) {
        doGridDelete("${ctx}/orderForm/delete.do?id=" + id);
    }
    </c:if>
    <c:if test="${canAudit || canRedo}">
    /*add 2014*/
    function doEditPlus(id) {
        openWindow("编辑监督预约", "${ctx}/orderForm/modifyPlus.do?id=" + id, true, winWAddAndEdit, winH);
    }
    /*add 2014*/
    function doAudit(id) {
        openWindow("监督预约受理", "${ctx}/orderForm/audit.do?id=" + id, true, winW, winH);
    }
    function doBack(id) {
        doGridDelete("${ctx}/orderForm/doBack.do?id=" + id, "确定要将此预约退回吗？");
    }
    </c:if>
    //添加修改受理备注
    <c:if test="${canMemoEdit}">
    function doMemoEdit(id) {
        openWindow("修改受理备注信息", "${ctx}/orderForm/memoEdit.do?id=" + id, true, winWAddAndEdit, winH);
    }
    </c:if>

    //设置已有的过滤条件
    function reloadGridByItem(itemName, itemValue) {
        var columnNum = -1;
        $(".searchFilter .columns select").each(function (i, val) {
            if (val.value == itemName) {
                columnNum = i;
            }
        })
        if (columnNum == -1)return;
        var inputElms = $("#fbox_listGrid .input-elm");
        var item = inputElms.eq(columnNum);
        $("#queryButton").trigger("click");
        item.val(itemValue);
        item.trigger("change");
        $("#fbox_listGrid_search").trigger("click");
    }

    function loadGridByStatus() {
        var v = $("input[name='orderStatus']:checked").val();
        reloadGridByItem("状态", v);
    }

    function initQueryItem() {
        $("#queryButton").trigger("click");
        $("#fbox_listGrid_search").trigger("click");
    }
    initQueryItem();

</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
            <input type="radio" name="orderStatus" value="" checked onclick="loadGridByStatus()">全部预约
            <input type="radio" name="orderStatus" value="已受理" onclick="loadGridByStatus()">已受理
            <input type="radio" name="orderStatus" value="未受理" onclick="loadGridByStatus()">未受理
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