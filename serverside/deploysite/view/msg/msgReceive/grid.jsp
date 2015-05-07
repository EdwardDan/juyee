<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/msgReceive/gridDataCustom.do",
                colNames:['ID',
                    '消息内容',
                    '发送人',
                    '是否发送短信',
                    '发送时间',
                    '是否已读',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"content", width:"75", align:"left", searchtype:"string", sortable:true},
                    {name:"sender", width:"35", align:"center", searchtype:"string", sortable:true},
                    {name:"isSendSms", width:"25", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"sendTime", width:"35", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i', newformat:'Y-m-d H:i'}},
                    {name:"isRead", width:"25", align:"center", searchtype:"string", sortable:true, formatter:readFormat}
                ],
                actModel:[
                    {name:'operation', width:30, align:'center'}
                ],
                pager:'#pager2',
                caption:"我的消息列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"消息内容", "op":"cn", "data":""},
                    { "field":"发送人", "op":"cn", "data":""},
                    { "field":"发送时间", "op":"bw", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        parent.openWindow("查看消息", "${ctx}/msgReceive/view.do?id=" + id, false);
    }

    //已读
    function readFormat(cellvalue, options, rowObject) {
        if (cellvalue == "true") {
            return "<font color=blue>已读</font>";
        } else {
            return "<font color=red>未读</font>";
        }
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