<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%--<%@include file="/common/header.jsp" %>--%>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaTaskCalc/gridDataCustom.do",
                colNames:['ID',
                    '任务类型',
                    '任务标题',
                    '创建人',
                    '创建时间',
                    '待处理人员',
                    '处理状态',
//                    'URL',
                    'VIEWURL',
                    'REFERID',
                    'ISWORKFLOW',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"task.type.name", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"task.title", width:"120", align:"left", searchtype:"string", sortable:true},
                    {name:"task.createUser.displayName", width:"22", align:"center", searchtype:"string", sortable:true},
                    {name:"task.createTime", width:"40", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"user.displayName", width:"22", align:"center", searchtype:"string", sortable:true},
                    {name:"status", width:"20", align:"center", searchtype:"string", sortable:true},
//                    {name:"task.type.url",width:"5",align:"center",searchtype:"string",hidden:true},
                    {name:"task.type.viewUrl", width:"5", align:"center", searchtype:"string", hidden:true},
                    {name:"task.referId", width:"5", align:"center", searchtype:"string", hidden:true},
                    {name:"task.type.isWorkflow", width:"5", align:"center", searchtype:"string", hidden:true}
                ],
                actModel:[
                    {name:'operation', width:20, align:'center'}
                ],
                pager:'#pager2',
                caption:"待办事项列表（全部）",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '<input type="button" value="查看" onclick="viewTask(\'' + rowData["id"] + '\',\'' + rowData["task.type.viewUrl"] + rowData["task.referId"] + '\',\'' + rowData["task.type.isWorkflow"] + '\',true,true)" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"任务类型", "op":"cn", "data":""},
                    { "field":"任务标题", "op":"cn", "data":""},
                    { "field":"创建时间", "op":"bt", "data":""},
                    { "field":"创建人", "op":"cn", "data":""},
                    { "field":"待处理人员", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doDelete(id) {
        doGridDelete("${ctx}/oaTask/delete.do?id=" + id);
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

        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>