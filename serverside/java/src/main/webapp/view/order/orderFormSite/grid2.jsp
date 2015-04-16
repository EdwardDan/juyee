<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/orderFormSite/gridDataCustom2.do",
                colNames:['ID',
                    '预约单号',
                    '监督任务书编号',
                    '工程名称',
                    '预约日期',
                    '监督组',
                    '受理日期',
                    '受理意见',
                    '状态',
                    '附件',
                    'status',
                    'cuser',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"orderForm.orderCode", width:"33", align:"center", searchtype:"string", sortable:true},
                    {name:'orderForm.jdTaskCode', width:"60", align:"center", searchtype:"string", sortable:true},
                    {name:"orderForm.projectName", width:"60", align:"left", searchtype:"string", sortable:true},
                    {name:"orderForm.orderDatetime", width:"40", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"workGroup.name", width:"48", align:"center", searchtype:"string", sortable:true},
                    {name:"acceptDatetime", width:"40", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"acceptOpinion", width:"48", align:"center", searchtype:"string", sortable:true},
                    {name:"orderForm.orderStatus.name", width:"22", align:"center", searchtype:"string", sortable:true},
                    {name:"orderForm.formDoc.id", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"orderForm.orderStatus.code", width:"10", align:"center", searchtype:"string", hidden:true},
                    {name:"orderForm.createUser", width:"10", align:"center", searchtype:"string", hidden:true}
                ],
                actModel:[
                    {name:'operation', width:52, align:'center'}
                ],
                pager:'#pager2',
                caption:"历史预约单列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["orderForm.orderStatus.code"];
                        var createUserName = rowData["orderForm.createUser"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                           //受理成功的记录不允许施工单位删除
                         if(statusCode!="${ORDER_FORM_STATUS_ACCEPT}"){
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                         }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                    addButtonHint();
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"监督任务书编号", "op":"cn", "data":""},
                    { "field":"预约单号", "op":"cn", "data":""},
                    { "field":"工程名称", "op":"cn", "data":""},
                    { "field":"预约日期", "op":"bt", "data":""},
                    { "field":"受理日期", "op":"bt", "data":""},
                    { "field":"状态", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    var winW = 800;
    var winH = 500;
    var winWAddAndEdit = 860;

    function doView(id) {
        openWindow("查看监督预约", "${ctx}/orderForm/view.do?id=" + id, false, winW, winH);
    }
    <%--<c:if test="${canEdit}">--%>
    function doAdd() {
        openWindow("填写监督预约", "${ctx}/orderForm/add.do", true, winWAddAndEdit, winH);
    }
    function doEdit(id) {
        openWindow("编辑监督预约", "${ctx}/orderFormSite/modify.do?id=" + id, true, winWAddAndEdit, winH);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/orderForm/delete.do?id=" + id);
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

    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>
