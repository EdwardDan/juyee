<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/sgPermitOperation/gridDataCustom.do?sgPermitId=${sgPermitId}",
                colNames: ['ID',
                    '操作编码',
                    '操作名称',
                    '审核操作人'
//                    '状态',
//                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "optionCode", width: "100", align: "center", searchtype: "string", sortable: true},
                    {name: "optionName", width: "100", align: "center", searchtype: "string", sortable: true},
                    {name: "optionUser", width: "100", align: "center", searchtype: "string", sortable: true}
//                    {name: "status", width: "100", align: "center", searchtype: "integer", sortable: true}
                ],
                actModel: [
//                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "施工许可流转操作列表",
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
                    { "field": "操作编码", "op": "cn", "data": ""},
                    { "field": "操作名称", "op": "cn", "data": ""},
                    { "field": "审核操作人", "op": "cn", "data": ""},
                    { "field": "状态", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看施工许可流转操作", "${ctx}/sgPermitOperation/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加施工许可流转操作", "${ctx}/sgPermitOperation/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改施工许可流转操作", "${ctx}/sgPermitOperation/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sgPermitOperation/delete.do?id=" + id);
    }
    </c:if>
    function loadBack() {
        loadMainPage("${ctx}/sgPermit/grid.do", "审查备案 > 施工许可管理");
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
            <input type="button" value="返回" class="button_back" onclick="loadBack()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>