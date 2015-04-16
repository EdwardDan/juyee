<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projectBidCheck/gridDataCustom.do?codeStatus=${codeStatus}",
                colNames: ['ID',
                    '报建编号',
                    '标段号',
                    '项目名称',
                    '建设单位',
                    '购买标书截至时间',
                    '投标保证金(元)',
                    "状态",
                    "状态码",
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "bdh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnit", width: "70", align: "left", searchtype: "string", sortable: true},
                    {name: "signLastDate", width: "37", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: "signAccount",width:"25",align:"right",searchtype:"string",sortable:true},
                    {name: "statusName", width: "25", align: "center", searchtype: "string", sortable: false},
                    {name: "statusCode", width: "25", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
//                caption: "招标登记列表",
                caption:"${title}",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["statusCode"];
                        var opButton = '';
                        <c:if test="${canEdit}">
                        if (statusCode == '1') {
                            opButton += '<input type="button" value="查看" onclick="doViewBS (' + id + ')" class="button_normal"/> ';
                        }
                        if (statusCode == '2') {
                            opButton += '<input type="button" value="查看" onclick="doViewDS (' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal"/> ';
                        }
                        if (statusCode == '3') {
                            opButton += '<input type="button" value="查看" onclick="doViewDT(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="建管署确认" onclick="doCheckBack(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal_long" id="confirm"/> ';
                        }
                        if (statusCode == '4') {
                            opButton += '<input type="button" value="编辑" onclick="doCheckBack(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal" id="confirm"/> ';
                            opButton += '<input type="button" value="查看" onclick="doViewDT(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal"/> ';
                        }
                        if (statusCode == '5') {
                            opButton += '<input type="button" value="编辑" onclick="doCheckBack(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal" id="confirm"/> ';
                            opButton += '<input type="button" value="查看" onclick="doViewDT(' + id + ',' + "'" + statusCode + "'" + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "标段号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""},
                    { "field": "购买标书截至时间", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doViewBS(id) {
        parent.openWindow("查看招标登记", "${ctx}/projectBidSign/view.do?id=" + id, false);
    }
    function doViewDS(id,statusCode) {
        parent.openWindow("查看待收保证金", "${ctx}/projectBidPay/view.do?statusType=" + statusCode + "&id=" + id,false, 1000, 525);
    }
    function doViewDT(id,statusCode) {
        <%--parent.openWindow("查看待退保证金", "${ctx}/projectBidPay/view.do?statusType=status_DT&id=" + id, false, 900, 525);--%>
        parent.openWindow("查看待退保证金","${ctx}/projectBidPay/view.do?statusType=" + statusCode + "&id=" + id, false, 1000, 525);
    }
    function doCheckBack(id,statusCode) {
        parent.openWindow("确认待退保证金","${ctx}/projectBidCheck/checkBack.do?statusType=" + statusCode + "&id=" + id, true, 1000, 525,"tab6");
    }
    <c:if test="${canEdit}">
    function doConfirm(id) {
        if (confirm("是否确认")) {
            loadAjaxData("gridQueryTable", "${ctx}/projectBidCheck/confirm.do?id=" + id );
            refreshGrid(null);
        }
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
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="listGrid"></table>
        <div id="pager2"></div>
    </div>
</div>