<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var isPermitEdit = ${isPermitEdit};
    var isPermitAudit = ${isPermitAudit};
    var status_edit_code = "${status_edit_code}";
    var status_submit_code = "${status_submit_code}";
    var status_back_code = "${status_back_code}";
    var status_pass_code = "${status_pass_code}";
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/planMainInfo/gridDataCustom.do?planType=${flag}",
                colNames:['ID',
                    '计划编号',
                    '计划名称',
                    '创建人',
                    '创建时间',
                    '审核人',
                    '审核日期',
                    '审核意见',
                    '状态',
                    '状态CODE',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"planCode", width:"35", align:"center", searchtype:"string", sortable:true},
                    {name:"planName", width:"80", align:"left", searchtype:"string", sortable:true},
                    {name:"createUserName", width:"30", align:"center", searchtype:"string", sortable:false},
                    {name:"createTime", width:"37", align:"center", searchtype:"datetime", sortable:false, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    {name:"checkUserName", width:"30", align:"center", searchtype:"string", sortable:false},
                    {name:"checkDateTime", width:"40", align:"center", searchtype:"datetime", sortable:false, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    {name:"checkOpinion.name", width:"25", align:"center", searchtype:"string", sortable:true},
                    {name:"planStatus.name", width:"25", align:"center", searchtype:"string", sortable:true},
                    {name:"planStatus.code", width:"10", align:"center", searchtype:"string", hidden:true}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"${flagName}监督计划列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["planStatus.code"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (isPermitEdit && (status_edit_code == statusCode || status_back_code == statusCode)) {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        } else if (isPermitAudit && (status_submit_code == statusCode)) {
                            opButton += '<input type="button" value="审核" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        } else if (status_pass_code == statusCode) {
                        <c:if test="${isPermitExcute||isPermitAudit}">
                            opButton += '<input type="button" value="执行任务" onclick="doExecute(' + id + ')" class="button_normal_long"/> ';
                        </c:if>
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"计划名称", "op":"cn", "data":""},
                    { "field":"计划编号", "op":"cn", "data":""},
                    { "field":"创建人", "op":"cn", "data":""},
                    { "field":"状态", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看监督计划", "${ctx}/planMainInfo/view.do?id=" + id, false, 1100, 525);
    }
    <c:if test="${isPermitEdit || isPermitAudit}">
    function doAdd() {
        openWindow("添加监督计划", "${ctx}/planMainInfo/add.do?planType=${flag}", true, 1100, 525);
    }
    function doEdit(id) {
        openWindow("修改监督计划", "${ctx}/planMainInfo/modify.do?id=" + id, true, 1100, 525);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/planMainInfo/delete.do?id=" + id);
    }
    function doExecute(id) {
        loadAjaxData("mainContent", "${ctx}/planDetail/grid.do?planMainInfoId=" + id);
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
            <c:if test="${isPermitEdit}">
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