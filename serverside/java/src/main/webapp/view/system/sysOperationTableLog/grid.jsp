<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysOperationTableLog/gridDataCustom.do",
                colNames:['ID',
//                    '操作日志',
//                    'IP地址',
//                    '日志类型',
                    '数据表',
                    '操作类型',
                    'IP地址',
                    '操作人',
                    '操作时间',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:'table.tableName', width:80, align:"center", searchtype:"string", sortable:true},
                    {name:"logType", width:"110", align:"center", searchtype:"string", sortable:true},
//                    {name:"logXml",width:"110",align:"center",searchtype:"string",sortable:true},
                    {name:"ipAddress", width:"110", align:"center", searchtype:"string", sortable:true},
                    {name:"createUser", width:"110", align:"center", searchtype:"string", sortable:true},
                    {name:"createTime", width:"110", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}}
//                    {name:"updateTime",width:"110",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"updateUser",width:"110",align:"center",searchtype:"string",sortable:true},


                ],
                actModel:[
                    {name:'operation', width:60, align:'center'}
                ],
                pager:'#pager2',
                caption:"数据表操作日志列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"数据表", "op":"cn", "data":""},
                    { "field":"操作时间", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看数据表操作日志", "${ctx}/sysOperationTableLog/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加数据表操作日志", "${ctx}/sysOperationTableLog/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改数据表操作日志", "${ctx}/sysOperationTableLog/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysOperationTableLog/delete.do?id=" + id);
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
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>