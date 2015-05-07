<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/msgMessage/gridDataCustom.do",
                colNames:['ID',
                    '消息内容',
                    '发送人',
                    '内部接收人',
                    '工地接收人',
                    '手机号码',
                    '是否发送短信',
                    '发送时间',
                    '是否已发送',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"content", width:"70", align:"left", searchtype:"string", sortable:true},
                    {name:"sender", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"innerPersonNames", width:"40", align:"left", searchtype:"string", sortable:true},
                    {name:"gdPersonNames", width:"40", align:"left", searchtype:"string", sortable:true},
                    {name:"mobiles", width:"40", align:"left", searchtype:"string", sortable:true},
                    {name:"isSendSms", width:"25", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"sendTime", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i', newformat:'Y-m-d H:i'}},
                    {name:"isSend", width:"25", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"消息发送列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (rowData['isSend'] == "否") {
                        <c:if test="${canEdit}">
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"消息内容", "op":"cn", "data":""},
                    { "field":"发送人", "op":"cn", "data":""},
                    { "field":"内部接收人", "op":"cn", "data":""},
                    { "field":"工地接收人", "op":"cn", "data":""},
                    { "field":"手机号码", "op":"cn", "data":""},
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
        openWindow("查看消息", "${ctx}/msgMessage/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加消息", "${ctx}/msgMessage/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改消息", "${ctx}/msgMessage/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/msgMessage/delete.do?id=" + id);
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