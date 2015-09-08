<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaSendFile/gridDataCustom.do",
                colNames: ['ID',
                    '发文字号',
                    '发文标题',
                    '主送机关',
                    '成文日期',
                    '创建人',
                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "fileCode", width: "35", align: "center", searchtype: "string", sortable: true},
                    {name: "fileTitle", width: "90", align: "left", searchtype: "string", sortable: true},
                    {name: "sendDept", width: "60", align: "left", searchtype: "string", sortable: true},
                    {name: "writtenDate", width: "25", align: "center", searchtype: "date", sortable: true},
                    {name: "createUser", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "fileDoc.id", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: "30", align: 'center'}
                ],
                pager: '#pager2',
                caption: "发文记录列表",
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
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "发文字号", "op": "cn", "data": ""},
                    { "field": "发文标题", "op": "cn", "data": ""},
                    { "field": "主送机关", "op": "cn", "data": ""},
                    { "field": "成文日期", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看发文记录", "${ctx}/oaSendFile/view.do?id=" + id, false, 700, 400);
    }
    function doAdd() {
        openWindow("添加发文记录", "${ctx}/oaSendFile/add.do", true, 700, 400);
    }
    function doEdit(id) {
        openWindow("修改发文记录", "${ctx}/oaSendFile/modify.do?id=" + id, true, 700, 400);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaSendFile/delete.do?id=" + id);
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
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>