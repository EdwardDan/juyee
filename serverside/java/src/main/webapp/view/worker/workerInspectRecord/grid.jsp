<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/workerInspectRecord/gridDataCustom.do",
                colNames: ['ID',
                    '报建编号',
                    '项目名称',
                    '检查地点',
                    '检查时间',
                    '检查人员',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name:"projectName",width:"50",align:"left",searchtype:"string",sortable:false},
                    {name: "checkAddress", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name:"checkTime",width:"45",align:"center",searchtype:"string",sortable:false},
                    {name: "checkPerson", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "现场检查记录列表",
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
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "检查地点", "op": "cn", "data": ""},
                    { "field": "检查人员", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看现场检查记录", "${ctx}/workerInspectRecord/view.do?id=" + id, false,800,500);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加现场检查记录", "${ctx}/workerInspectRecord/add.do", true,850,500);
    }
    function doEdit(id) {
        openWindow("修改现场检查记录", "${ctx}/workerInspectRecord/modify.do?id=" + id, true,850,500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/workerInspectRecord/delete.do?id=" + id);
    }
    </c:if>

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