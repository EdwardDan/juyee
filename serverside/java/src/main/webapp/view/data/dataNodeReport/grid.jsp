<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projInfo/gridDataCustom.do",
                colNames: ['ID',
                    '填报年份',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目基本信息管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var projectId = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', projectId);
                        var bidCountOfNode = rowData["bidCountOfNode"];
                        var year = rowData["year"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + projectId + ',' + bidCountOfNode + ')" class="button_normal"> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="形象进度维护" onclick="doEdit(' + projectId + ',' + bidCountOfNode + ')" class="button_add_long" /> ';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "填报年份", "op": "eq", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "项目性质", "op": "cn", "data": ""},
                    { "field": "项目阶段", "op": "cn", "data": ""},
                    { "field": "项目类型", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doEdit(projectId, bidCountOfNode) {
        openWindow("修改项目形象进度推进", "${ctx}/dataNodeReport/modify.do?projectId=" + projectId, true, 1000, 600);
    }
    function doView(projectId, bidCountOfNode) {
        openWindow("查看项目形象进度推进", "${ctx}/dataNodeReport/view.do?projectId=" + projectId, false, 1000, 600);
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
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>