<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaThings/gridDataCustom.do",
                colNames: ['ID',
                    '办公用品名称',
                    '型号',
                    '单位',
                    '单价',
                    '库存',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "name", width: "72", align: "left", searchtype: "string", sortable: true},
                    {name: "model", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "unit", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "price", width: "50", align: "right", searchtype: "string", sortable: true},
                    {name: "amount", width: "50", align: "right", searchtype: "string", sortable: true},
                ],
                actModel: [
                    {name: 'operation', width: 50, align: 'center'}
                ],
                pager: '#pager2',
                caption: "办公用品信息列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "办公用品名称", "op": "cn", "data": ""},
                        {"field": "型号", "op": "cn", "data": ""},
                    ]
                },
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看办公用品信息", "${ctx}/oaThings/view.do?id=" + id, false,700,200);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加办公用品信息", "${ctx}/oaThings/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改办公用品信息", "${ctx}/oaThings/modify.do?id=" + id, true,700,200);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaThings/delete.do?id=" + id);
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