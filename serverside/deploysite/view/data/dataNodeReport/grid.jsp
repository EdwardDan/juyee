<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projInfo/gridDataCustom.do",
                colNames: ['ID',
                    '开始年份',
                    '项目序号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '标段数',
                    '标段数1',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "no", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "bidCountOfNode", width: "30", align: "center", searchtype: "integer", sortable: true, formatter: viewBidInfoFormat},
                    {name: "bidCountOfNode", width: "30", align: "center", searchtype: "integer", hidden: true}
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
                        var opButton = '<input type="button" value="查看" onclick="doView(' + projectId + ','+bidCountOfNode+')" class="button_normal"> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="形象进度维护" onclick="doEdit(' + projectId + ','+bidCountOfNode+')" class="button_add_long" /> ';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "开始年份", "op": "eq", "data": ""},
                    { "field": "项目序号", "op": "cn", "data": ""},
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
    function doEdit(projectId,bidCountOfNode) {
        if(bidCountOfNode==0){
         alert("该项目形象进度标段数为零，请先在[形象进度标段管理]中添加标段！");
        }else{
            openWindow("修改项目形象进度推进", "${ctx}/dataNodeReport/modify.do?projectId=" + projectId, true,1125,500);
        }
    }
    function doView(projectId,bidCountOfNode) {
        if(bidCountOfNode==0){
            alert("该项目形象进度标段数为零，请先在[形象进度标段管理]中添加标段！");
        }else{
        openWindow("查看项目形象进度推进", "${ctx}/dataNodeReport/view.do?projectId=" + projectId, false,1125,500);
        }
    }

    function viewBidInfoFormat(cellvalue, options, rowObject) {
        var title = "查看标段";
        return "<a href='javascript:void(0)' onclick=loadBidInfoFormat('" + title + "','" + rowObject["id"] + "','${TYPE_NODE}',true,false) class='grid_link'>" + cellvalue + "</a>";
    }
    function loadBidInfoFormat(title, projInfoId, typeCode, isParentWindow, isOpenNewWindow) {
        var url = "${ctx}/projInfo/viewBid.do?id=" + projInfoId+"&typeCode="+typeCode;
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
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>