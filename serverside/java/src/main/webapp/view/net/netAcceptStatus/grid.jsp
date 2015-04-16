<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/netAcceptStatus/gridDataCustom.do?acceptStepId=${acceptStep.id}",
                colNames: ['ID',
                    '序号',
                    '状态名称',
                    '是否通过',
                    '是否开始状态',
                    '是否结束状态',
                    '受理日期重命名',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "no", width: "30", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}},
                    {name: "name", width: "60", align: "center", searchtype: "string", sortable: true},
                    {name: "isPass", width: "30", align: "center", searchtype: "integer", sortable: true, formatter: booleanFormat},
                    {name: "isStart", width: "30", align: "center", searchtype: "integer", sortable: true, formatter: booleanFormat},
                    {name: "isEnd", width: "30", align: "center", searchtype: "integer", sortable: true, formatter: booleanFormat},
                    {name: "label", width: "30", align: "center", searchtype: "integer", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目审批受理状态列表（${acceptStep.name}）",
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
                    { "field": "状态名称", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目审批受理状态", "${ctx}/netAcceptStatus/view.do?id=" + id, false);
    }
    function doBack() {
        window.location = "${ctx}/netAcceptStep/grid.do?matterCode=${acceptStep.matterCode}";
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目审批受理状态", "${ctx}/netAcceptStatus/add.do?acceptStepId=${acceptStep.id}", true);
    }
    function doEdit(id) {
        openWindow("修改项目审批受理状态", "${ctx}/netAcceptStatus/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/netAcceptStatus/delete.do?id=" + id);
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
            <input type="button" value="返回" class="button_add" onclick="doBack()"/>
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