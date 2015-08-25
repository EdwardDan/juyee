<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projBid/projGridDataCustom.do?typeCode=${typeCode}",
                colNames: ['ID',
                    '填报年份',
                    '项目序号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '标段数',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "no", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "30", align: "center", searchtype: "string", sortable: true}
                    <c:if test="${TYPE_STAGE==typeCode}">
                    ,{name: "bidCountOfStage", width: "30", align: "center", searchtype: "integer", sortable: true}
                    </c:if>
                    <c:if test="${TYPE_NODE==typeCode}">
                    ,{name: "bidCountOfNode", width: "30", align: "center", searchtype: "integer", sortable: true}
                    </c:if>
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目基本信息列表（${typeName}）",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="维护标段" onclick="doToBid(' + id + ')" class="button_normal_long"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "填报年份", "op": "eq", "data": ""},
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
    function doToBid(projId) {
        loadAjaxData("mainContent", "${ctx}/projBid/bidGrid.do?projId=" + projId+"&typeCode=${typeCode}");
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