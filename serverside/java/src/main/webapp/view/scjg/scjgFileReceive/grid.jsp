<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/scjgFileReceive/gridDataCustom.do",
                colNames: ['ID',
                    '编号',
                    '来件单位',
//            	'被反映单位地址',
                    '来件日期',
                    '来件名称',
//                    '来件编号',
//                    '来件内容',
                    '处理时限',
//            	'处理情况',
//            	'承办科室名称(多个逗号分隔)',
//            	'承办人姓名(多个逗号分隔)',
//            	'承办人用户名(多个逗号分隔)',
//            	'承办日期',
//            	'领导批示内容',
//            	'领导批示签字',
//            	'领导批示日期',
//            	'备注',
                    '状态',
                    '状态code',
                    '附件下载',
//            	'转至科室日期',
//            	'要求回复日期',
//            	'实际回复日期',
//            	'创建时间',
//            	'创建用户名',
//            	'更新时间',
//            	'更新用户名',
//            	'是否提醒',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "source", width: "40", align: "center", searchtype: "string", sortable: true},
//{name:"targetDept",width:"30",align:"center",searchtype:"string",sortable:true},
                    {name: "receiveDate", width: "20", align: "center", searchtype: "date", sortable: true},
                    {name: "fileName", width: "40", align: "center", searchtype: "string", sortable: true},
//                    {name: "fileCode", width: "30", align: "center", searchtype: "string", sortable: true},
//                    {name: "fileContent", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "dealTime", width: "20", align: "center", searchtype: "date", sortable: true},
//{name:"dealOpinion",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"dealDeptNames",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"dealPerson",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"dealUsername",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"dealDate",width:"30",align:"center",searchtype:"date",sortable:true},
//{name:"leaderOpinion",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"leaderPerson",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"leaderDate",width:"30",align:"center",searchtype:"date",sortable:true},
//{name:"description",width:"30",align:"center",searchtype:"string",sortable:true},
                    {name: "statusName", width: "30", align: "center", searchtype: "string", sortable: true, formatter: 'string'},
                    {name: "status", width: "10", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "loadDocument", width: "20", align: "center", searchtype: "string", sortable: true}
//{name:"toDeptDate",width:"30",align:"center",searchtype:"date",sortable:true},
//{name:"requireReplyDate",width:"30",align:"center",searchtype:"date",sortable:true},
//{name:"actualReplyDate",width:"30",align:"center",searchtype:"date",sortable:true},
//{name:"createTime",width:"30",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//{name:"createUser",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"updateTime",width:"30",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//{name:"updateUser",width:"30",align:"center",searchtype:"string",sortable:true},
//{name:"isRemind",width:"30",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat}
                ],
                actModel: [
                    {name: 'operation', width: 25, align: 'center'}
                ],
                pager: '#pager2',
                caption: "信访来件管理--来件列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers:true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "编号", "op": "cn", "data": ""},
//                    { "field": "来件单位", "op": "cn", "data": ""},
//            	{ "field":"被反映单位地址", "op":"cn", "data":""},
//                    { "field": "来件日期", "op": "cn", "data": ""},
                    { "field": "来件名称", "op": "cn", "data": ""},
                    { "field": "来件编号", "op": "cn", "data": ""},
//                    { "field": "来件内容", "op": "cn", "data": ""},
//            	{ "field":"处理时限", "op":"cn", "data":""},
//            	{ "field":"处理情况", "op":"cn", "data":""},
//            	{ "field":"承办科室名称(多个逗号分隔)", "op":"cn", "data":""},
//            	{ "field":"承办人姓名(多个逗号分隔)", "op":"cn", "data":""},
//            	{ "field":"承办人用户名(多个逗号分隔)", "op":"cn", "data":""},
//            	{ "field":"承办日期", "op":"cn", "data":""},
//            	{ "field":"领导批示内容", "op":"cn", "data":""},
//            	{ "field":"领导批示签字", "op":"cn", "data":""},
//            	{ "field":"领导批示日期", "op":"cn", "data":""},
//            	{ "field":"备注", "op":"cn", "data":""},
                    { "field": "状态", "op": "cn", "data": ""}
//            	{ "field":"转至科室日期", "op":"cn", "data":""},
//            	{ "field":"要求回复日期", "op":"cn", "data":""},
//            	{ "field":"实际回复日期", "op":"cn", "data":""},
//                { "field":"创建时间", "op":"bw", "data":""},
//            	{ "field":"创建用户名", "op":"cn", "data":""},
//                { "field":"更新时间", "op":"bw", "data":""},
//            	{ "field":"更新用户名", "op":"cn", "data":""},
//            	{ "field":"是否提醒", "op":"cn", "data":""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看信访来件管理--来件", "${ctx}/scjgFileReceive/view.do?id=" + id, false,800,470);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加信访来件管理--来件", "${ctx}/scjgFileReceive/add.do", true, 800, 470);
    }
    function doEdit(id) {
        openWindow("修改信访来件管理--来件", "${ctx}/scjgFileReceive/modify.do?id=" + id, true, 800, 470);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/scjgFileReceive/delete.do?id=" + id);
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