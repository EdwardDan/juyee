<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/netApply/gridDataCustom.do",
                colNames: ['ID',
                    '网上受理编号',
                    '报建编号',
                    '项目名称',
                    '建设单位',
                    '建设地点',
                    '首次受理时间',
                    '受理状态',
                    '受理ID',
                    '是否结束',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "netCode", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "bjbh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "45", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnitName", width: "45", align: "left", searchtype: "string", sortable: true},
                    {name: "buildAddress", width: "45", align: "left", searchtype: "string", sortable: true},
                    {name: "netDate", width: "20", align: "center", searchtype: "date", sortable: true} ,
                    {name: "acceptStatus.name", width: "15", align: "center", searchtype: "string", sortable: true} ,
                    {name: "acceptStatus.id", width: "5", align: "center", searchtype: "string", hidden: true},
                    {name: "acceptStatus.isEnd", width: "5", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 35, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目报建列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var acceptStatusId = rowData["acceptStatus.id"];
                        var isEnd = rowData["acceptStatus.isEnd"];

                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
                        if (isEnd == 'false') {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="受理" onclick="doAudit(' + id + ',' + acceptStatusId + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }else{
                        <c:if test="${canForceDelete}">
                            opButton += '<input type="button" value="强制删除" onclick="doForceDelete(' + id + ')" class="button_normal_long"/>';
                        </c:if>
                        }
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "网上受理编号", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""},
                    { "field": "建设地点", "op": "cn", "data": ""},
                    { "field": "首次受理时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看受理过程", "${ctx}/netCommon/view.do?bizClass=${bizClass}&bizId=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目报建", "${ctx}/netApply/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目报建", "${ctx}/netApply/modify.do?id=" + id, true);
    }
    function doAudit(id, acceptStatusId) {
        openWindow("受理项目报建", "${ctx}/netApply/audit.do?bizId=" + id + "&acceptStatusId=" + acceptStatusId + "&matterCode=${matterCode}&bizClass=${bizClass}", true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/netApply/delete.do?id=" + id);
    }
    </c:if>
    <c:if test="${canForceDelete}">
    function doForceDelete(id) {
        doGridDelete("${ctx}/netApply/deleteAll.do?id=" + id);
    }
    </c:if>

    //按是否标注过滤数据
    function loadThisGrid() {
        var setCode = $("input[name='setCode']:checked").val();
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'setCode': setCode}
                }).trigger('reloadGrid');
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
            <input type="radio" name="setCode" id="setCode1" value="网上申请"  onclick="loadThisGrid()"><label
                for="setCode1">网上申请</label>
            <input type="radio" name="setCode" id="setCode2" value="受理退回" onclick="loadThisGrid()"><label
                for="setCode2">受理退回</label>
            <input type="radio" name="setCode" id="setCode3" value="受理通过" onclick="loadThisGrid()"><label
                for="setCode3">受理通过</label>
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