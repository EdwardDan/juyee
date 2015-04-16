<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaExpertise/gridDataCustom.do",
                colNames: ['ID',
                    '主题',
                    '责任人',
                    '时间',
                    '措施与方式',
                    '相关附件',
                    '状态code',
                    '状态',
                    '当前用户',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "30", align: "left", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "time", width: "50", align: "center", searchtype: "date", sortable: true},
                    {name: "method", width: "47", align: "left", searchtype: "string", sortable: false},
                    {name: "docButton", width: "20", align: "center", searchtype: "integer", sortable: false},
                    {name: "status", width: "10", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "15", align: "center", searchtype: "string", sortable: false},
                    {name: "createUser", width: "30", align: "center", searchtype: "date", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "专业知识培训列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];//获取此时状态
                        var currentUser = rowData["createUser"];//获取当前用户
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        {
                            if (rowDataCell == ${STATUS_EDIT} || rowDataCell == ${STATUS_BACK}) {
                                if (currentUser == '${currentUser}') {
                                    opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                    opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                }else{
                                    <c:if test="${canDelete}">
                                    opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                    </c:if>
                                }
                            }
                        }
                        </c:if>
                        <c:if test="${canAudit}">
                        if (rowDataCell == ${STATUS_SUBMIT}) {
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                        }
                        </c:if>
                        <c:if test="${canAudit}">
                        if (rowDataCell == ${STATUS_PASS}) {
                            opButton += '<input type="button" value="完成" onclick="doComplete(' + id + ')" class="button_normal"/> ';
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
                    { "field": "措施与方式", "op": "cn", "data": ""},
                    { "field": "学习目标", "op": "cn", "data": ""},
                    { "field": "学习内容", "op": "cn", "data": ""}

                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看专业知识培训", "${ctx}/oaExpertise/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit ||canAudit}">
    function doAdd() {
        openWindow("添加专业知识培训", "${ctx}/oaExpertise/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改专业知识培训", "${ctx}/oaExpertise/modify.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaExpertise/delete.do?id=" + id);
    }
    function doAudit(id) {
        openWindow("审核专业知识培训", "${ctx}/oaExpertise/audit.do?id=" + id, true, 800, 500);
    }
    function doComplete(id) {
        openWindow("完成专业知识培训", "${ctx}/oaExpertise/complete.do?id=" + id, true, 800, 500);
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