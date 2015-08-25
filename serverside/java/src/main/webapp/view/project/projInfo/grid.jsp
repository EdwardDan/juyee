<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projInfo/gridDataCustom.do",
                colNames: ['ID',
                    '填报年份',
                    '项目序号',
                    '项目名称',
                    '管理属性',
                    '项目状态',
                    '业态类别',
                    '办证推进标段数',
                    '形象进度标段数',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "no", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "bidCountOfStage", width: "35", align: "center", searchtype: "integer", sortable: true, formatter: viewBidInfoFormat1},
                    {name: "bidCountOfNode", width: "35", align: "center", searchtype: "integer", sortable: true, formatter: viewBidInfoFormat2}
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
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "填报年份", "op": "eq", "data": ""},
                    { "field": "项目序号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "管理属性", "op": "cn", "data": ""},
                    { "field": "项目状态", "op": "cn", "data": ""},
                    { "field": "业态类别", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目基本信息", "${ctx}/projInfo/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目基本信息", "${ctx}/projInfo/add.do", true, 800, 500);
    }
    function doEdit(id) {
        openWindow("修改项目基本信息", "${ctx}/projInfo/modify.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projInfo/delete.do?id=" + id);
    }
    </c:if>

    function viewBidInfoFormat1(cellvalue, options, rowObject) {
        var title = "查看办证推进标段（" + rowObject["name"] + "）";
        return "<a href='javascript:void(0)' onclick=loadBidInfoFormat('" + title + "','" + rowObject["id"] + "','${TYPE_STAGE}',true,false) class='grid_link'>" + cellvalue + "</a>";
    }
    function viewBidInfoFormat2(cellvalue, options, rowObject) {
        var title = "查看形象进度标段（" + rowObject["name"] + "）";
        return "<a href='javascript:void(0)' onclick=loadBidInfoFormat('" + title + "','" + rowObject["id"] + "','${TYPE_NODE}',true,false) class='grid_link'>" + cellvalue + "</a>";
    }
    function loadBidInfoFormat(title, projInfoId, typeCode, isParentWindow, isOpenNewWindow) {
        var url = "${ctx}/projInfo/viewBid.do?id=" + projInfoId + "&typeCode=" + typeCode;
        var windowId = isOpenNewWindow ? "newWinId" : null;
        if (isParentWindow) {
            parent.openNewWindow(windowId, title, url, false);
        } else {
            openNewWindow(windowId, title, url, false);
        }
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