<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaPetition/gridDataCustom.do",
                colNames: ['ID',
                    '受理编号',
                    '信访来源',
                    '信访种类',
                    '信访人',
                    '联系电话',
                    '收信日期',
                    '结案日期',
                    '经办人',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "sourceDesc", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "typeDesc", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "person", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "tel", width: "70", align: "center", searchtype: "string", sortable: true},
                    {name: "receiveDate", width: "50", align: "center", searchtype: "date", sortable: true},
                    {name: "endDate", width: "50", align: "center", searchtype: "date", sortable: true},
                    {name: "jbrName", width: "50", align: "center", searchtype: "string", sortable: true},
                ],
                actModel: [
                    {name: 'operation', width: 100, align: 'center'}
                ],
                pager: '#pager2',
                caption: "信访记录列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="预览" onclick="doPreview(' + id + ')" class="button_normal"/>';
                        opButton += '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
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
                    { "field": "受理编号", "op": "cn", "data": ""},
                    { "field": "信访来源", "op": "cn", "data": ""},
                    { "field": "信访种类", "op": "cn", "data": ""},
                    { "field": "信访人", "op": "cn", "data": ""},
                    { "field": "联系电话", "op": "cn", "data": ""},
                    { "field": "收信日期", "op": "bt", "data": ""},
                    { "field": "结案日期", "op": "bt", "data": ""},
                    { "field": "经办人", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });

    function doPreview(id) {
        openWindow("预览信访记录", "${ctx}/oaPetition/preview.do?id=" + id, false);
    }

    function doView(id) {
        openWindow("查看信访记录", "${ctx}/oaPetition/view.do?id=" + id, false, 786, 550);
    }

    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加信访记录", "${ctx}/oaPetition/add.do", true, 786, 550);
    }

    function doEdit(id) {
        openWindow("修改信访记录", "${ctx}/oaPetition/modify.do?id=" + id, true, 786, 550);
    }

    function doDelete(id) {
        doGridDelete("${ctx}/oaPetition/delete.do?id=" + id);
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