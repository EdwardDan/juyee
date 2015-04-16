<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaDeptNews/gridDataCustom.do",
                colNames: ['ID',
                    '主题',
                    '提交部门',
                    '责任人',
                    '主要内容(预留)',
                    '提交时间',
                    '附件',
                    '状态code',
                    '状态',
                    '当前用户',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "60", align: "left", searchtype: "string", sortable: true},
                    {name: "reportDept", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "content", width: "60", align: "center", searchtype: "string", hidden: true},
                    {name: "reportDate", width: "53", align: "center", searchtype: "date", sortable: true},
                    {name: "docButton", width: "20", align: "center", searchtype: "string", sortable: false},
                    {name: "status", width: "20", align: "center", searchtype: "integer", hidden: true},
                    {name: "createUser", width: "20", align: "center", searchtype: "string", hidden: true},
                    {name: "statusName", width: "30", align: "center", searchtype: "string", sortable: false}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "各科室新闻列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];//获取此时状态
                        var currentUser = rowData["createUser"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        {
                            if (currentUser == "${currentUser}") {
                                if (rowDataCell == ${STATUS_EDIT} || rowDataCell == ${STATUS_BACK}) {
                                    opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                    opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                }
                            }
                        }
                        </c:if>
                        <c:if test="${canAudit}">
                        if (rowDataCell == ${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "主题", "op": "cn", "data": ""},
                    { "field": "责任人", "op": "cn", "data": ""},
                    { "field": "提交部门", "op": "cn", "data": ""},
//                    { "field": "主要内容(预留)", "op": "cn", "data": ""},
                    { "field": "提交时间", "op": "bt", "data": ""}

                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看科室新闻", "${ctx}/oaDeptNews/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加各科室新闻", "${ctx}/oaDeptNews/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改各科室新闻", "${ctx}/oaDeptNews/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaDeptNews/delete.do?id=" + id);
    }
    function doAudit(id) {
        openWindow("审核各科室新闻", "${ctx}/oaDeptNews/audit.do?id=" + id, true);

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