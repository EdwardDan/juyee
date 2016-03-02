<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/areaMaterialInfo/gridDataCustom.do",
                colNames: ['ID',
                    '序号',
                    '项目类型',
                    '类型',
                    '材料名称',
                    '审核要求',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "no", width: "10", align: "center", searchtype: "integer", sortable: true},
                    {name: "projectType.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "type", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "materialName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "auditReq", width: "80", align: "left", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 25, align: 'center'}
                ],
                pager: '#pager2',
                caption: "施工材料信息列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "序号", "op": "cn", "data": ""},
                    { "field": "类型", "op": "cn", "data": ""},
                    { "field": "材料名称", "op": "cn", "data": ""},
                    { "field": "审核要求", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看施工材料信息", "${ctx}/areaMaterialInfo/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加施工材料信息", "${ctx}/areaMaterialInfo/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改施工材料信息", "${ctx}/areaMaterialInfo/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/areaMaterialInfo/delete.do?id=" + id);
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
