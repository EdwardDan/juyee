<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projBid/gridDataCustom.do?projId=${projId}",
                colNames: ['ID',
                    '标段编号',
                    '标段名称',
                    '建设里程',
                    '项目联系人',
                    '联系电话',
                    '开工日期',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "buildMileage", width: "133", align: "center", searchtype: "string", sortable: true},
                    {name: "projLink", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "linkTel", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "startDate", width: "50", align: "center", searchtype: "date", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目标段管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <%--<c:if test="${canEdit}">--%>
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        <%--</c:if>--%>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "标段编号", "op": "cn", "data": ""},
                    { "field": "标段名称", "op": "cn", "data": ""},
                    { "field": "建设里程", "op": "cn", "data": ""},
                    { "field": "项目联系人", "op": "cn", "data": ""},
                    { "field": "联系电话", "op": "cn", "data": ""},
                    { "field": "开工日期", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目标段管理", "${ctx}/projBid/view.do?id=" + id, false);
    }
    <%--<c:if test="${canEdit}">--%>
    function doAdd() {
        openWindow("添加项目标段管理", "${ctx}/projBid/add.do?projId=${projId}", true);
    }
    function doEdit(id) {
        openWindow("修改项目标段管理", "${ctx}/projBid/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projBid/delete.do?id=" + id);
    }
    <%--</c:if>--%>
    function jumpProjInfoGrid() {
        loadAjaxData("mainContent", "${ctx}/projBid/grid.do");
    }
    //custom formatter
    //function customeFormat(cellvalue, options, rowObject) {
    //    return cellvalue == "true"?"是":"否";
    //}
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
            <%--<c:if test="${canEdit}">--%>
            <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            <%--</c:if>--%>
        </div>
        <div style="float:right;padding-right: 10px">
            <input type="button" value="返回" class="button_back" onclick="jumpProjInfoGrid()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>