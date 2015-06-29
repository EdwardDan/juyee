<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaThingsApply/gridDataCustom.do",
                colNames:['ID',
                    '申请部门',
                    '申请人',
                    '申请时间',
                    '状态',
                    '状态code',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"applyDept.name", width:"80", align:"left", searchtype:"string", sortable:true},
                    {name:"applyUser.displayName", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"createTime", width:"40", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d'}},
                    {name:"statusName", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"status", width:"5", align:"center", searchtype:"integer", hidden:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"办公用品申请列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["status"];//获取每一行的状态
                        var createUser = rowData["applyUser.displayName"];//获取每一行的状态
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${auditKZ}">
                        if (statusCode == ${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审批" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                    </c:if>
                    <c:if test="${auditZR}">
                        if (statusCode == ${STATUS_BRANCH_PASS}) {
                            opButton += '<input type="button" value="审批" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                    </c:if>
                    <c:if test="${canEdit}">
                        if (statusCode == ${STATUS_EDIT} || statusCode == ${STATUS_BRANCH_BACK} || statusCode == ${STATUS_MAIN_BACK}) {
                            if (createUser == '${currentUser}'){
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                        }
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"申请部门", "op":"cn", "data":""},
                    { "field":"申请人", "op":"cn", "data":""},
                    { "field":"申请时间", "op":"bw", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看办公用品申请", "${ctx}/oaThingsApply/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加办公用品申请", "${ctx}/oaThingsApply/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改办公用品申请", "${ctx}/oaThingsApply/modify.do?id=" + id, true);
    }
    function doAudit(id) {
        openWindow("审核办公用品申请", "${ctx}/oaThingsApply/audit.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaThingsApply/delete.do?id=" + id);
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