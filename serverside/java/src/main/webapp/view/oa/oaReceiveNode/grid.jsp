<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaReceiveNode/gridDataCustom.do?oaReceiveId=${oaReceiveId}",
                colNames:['ID',
                    '节点名称',
                    '操作',
                    '处理人',
                    '处理结果',
                    '收到时间',
                    '打开时间',
                    '处理完成时间',
//                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"operation.step.name", width:"20", align:"center", searchtype:"string", sortable:true},
                    {name:"operation.name", width:"20", align:"center", searchtype:"string", sortable:true},
                    {name:"dealUser", width:"20", align:"center", searchtype:"string", sortable:true},
                    {name:"dealResult", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"receiveTime", width:"20", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"openTime", width:"20", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"completeTime", width:"20", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}}
                ],
                actModel:[
//                    {name:'operation', width:15, align:'center'}
                ],
                pager:'#pager2',
                caption:"收文管理流转节点列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"处理人", "op":"cn", "data":""},
                    { "field":"处理结果", "op":"cn", "data":""},
                    { "field":"收到时间", "op":"bw", "data":""},
                    { "field":"打开时间", "op":"bw", "data":""},
                    { "field":"处理完成时间", "op":"bw", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看收文管理流转节点", "${ctx}/oaReceiveNode/view.do?id=" + id, false);
    }
    function doEdit(id) {
        openWindow("修改收文管理流转节点", "${ctx}/oaReceiveNode/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaReceiveNode/delete.do?id=" + id);
    }
    function loadback() {
        loadMainPage("${ctx}/oaReceive/grid.do", "收文管理");
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
            <input type="button" value="返回" class="button_back"
                   onclick="loadback()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>