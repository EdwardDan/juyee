<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaNews/gridDataCustom.do",
                colNames: ['ID',
                    '新闻名称',
                    '发布人',
                    '创建人',
                    '发布科室',
                    '是否发布',
                    '发布时间',
                    '阅读次数',
                    '相关附件',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 1, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "100", align: "left", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "createUser", width: "30", align: "center", searchtype: "string", hidden: true},//创建人，用于权限设置
                    {name: "reportDept", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: 'isValid', width: "30", align: "center", searchtype: "string", sortable: true, formatter: booleanFormat},
                    {name: "reportDate", width: "30", align: "center", searchtype: "date", sortable: true},
                    {name: "visitTimes", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: 'docButton', width: "40", align: "center", searchtype: "string", sortable: false },
                    {name: 'isValid', width: "30", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "新闻知识发布列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var createUser = rowData["createUser"];
                        var isValid = rowData["isValid"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        if (isValid == "false" && createUser == '${currentUser}') {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        } else {
                            <c:if test="${canDelete}">
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "新闻名称", "op": "cn", "data": ""},
                    { "field": "发布人", "op": "cn", "data": ""},
                    { "field": "发布科室", "op": "cn", "data": ""},
                    { "field": "发布时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看新闻知识发布", "${ctx}/oaNews/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit}">
    function doAdd() {

        openWindow("添加新闻知识发布", "${ctx}/oaNews/add.do", true, 800, 500);
    }
    function doEdit(id) {
        openWindow("修改新闻知识发布", "${ctx}/oaNews/modify.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaNews/delete.do?id=" + id);
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