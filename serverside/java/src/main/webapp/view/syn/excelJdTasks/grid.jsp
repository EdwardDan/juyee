<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/excelJdTasks/gridDataCustom.do",
                colNames: ['ID',
                    '报建编号',
                    '监督任务书编号',
                    '项目名称',
                    '项目地点',
                    '项目类型',
                    '报监日期',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "jdTaskCode", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "projectAdd", width: "90", align: "left", searchtype: "string", sortable: true},
                    {name: "reportType", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "jdDatetime", width: "35", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "监督单位工程列表",
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
                    { "field": "监督任务书编号", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "报监日期", "op": "bt", "data": ""},
                    { "field": "项目类型", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看监督单位工程", "${ctx}/excelJdTasks/view.do?id=" + id, false, 1000, 500);
    }
    <c:if test="${canEdit}">
    function doExcelAdd() {
        window.open("${ctx}/excelJdTasksOld/excelAdd.do", "监督任务书excel导入", 'height=500,width=900,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
    }
    function doAdd() {
        openWindow("添加监督任务书", "${ctx}/excelJdTasks/frame.do", true, 950, 525);
    }
    function doEdit(id) {
        openWindow("编辑监督单位工程", "${ctx}/excelJdTasks/modify.do?id=" + id, false, 1000, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/excelJdTasks/delete.do?id=" + id);
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
                <input type="button" value="导入" class="button_add"
                       onclick="doExcelAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>