<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/netZbdl/gridDataCustom.do",
                colNames: ['ID',
                    '报建编号',
                    '标段号',
                    '项目名称',
                    '建设单位',
//                    '建设地点',
                    '购买标书截至时间',
//                    '开标日期',
                    "状态",
                    "状态code",
//                    '招标代理单位',
//                    '联系人',
//                    '联系电话',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "35", align: "center", searchtype: "string", sortable: true},
                    {name: "bdh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnit", width: "50", align: "left", searchtype: "string", sortable: true},
//                    {name: "buildAddress", width: "61", align: "center", searchtype: "string", sortable: true},
//                    {name: "signLastDate", width: "35", align: "center", searchtype: "date", sortable: true},
                    {name: "signLastDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
//                    {name: "signDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: "statusName", width: "25", align: "center", searchtype: "string", sortable: false},
                    {name:"status.code",width:"20",align:"center",searchtype:"string",sortable:false,hidden:true}
//                    {name: "signProxyUnit", width: "61", align: "center", searchtype: "string", sortable: true},
//                    {name: "linkPerson", width: "61", align: "center", searchtype: "string", sortable: true},
//                    {name: "linkTel", width: "61", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "招标登记列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status.code"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if(1==rowDataCell){
                            opButton += '<input type="button" value="购买标书登记" onclick="doRegister(' + id + ')" class="button_normal_long"/>';
                        }
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
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
                    { "field": "购买标书截至时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看招标登记", "${ctx}/netZbdl/view.do?id=" + id, false, 800, 500);
    }
    function doRegister(id) {
        loadAjaxData("mainContent", "${ctx}/netZbdlDept/grid.do?projectBidSignId=" + id);
    }
    <%--<c:if test="${canEdit}">--%>
    function doAdd() {
        openWindow("添加招标登记", "${ctx}/netZbdl/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改招标登记", "${ctx}/netZbdl/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/netZbdl/delete.do?id=" + id);
    }
    <%--</c:if>--%>

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
            <%--<c:if test="${canEdit}">--%>
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            <%--</c:if>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>