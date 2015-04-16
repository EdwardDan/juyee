<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/workerSchool/gridDataCustom.do",
                colNames: ['ID',
                    '项目名称',
                    '项目地点',
                    '创建时间',
                    '建设单位名称',
                    '施工单位名称',
//                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "projectName", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "projectAddress", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "createTime", width: "32", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: "jsDept", width: "42", align: "left", searchtype: "string", sortable: true},
                    {name: "sgDept", width: "42", align: "left", searchtype: "string", sortable: true}
//                    {name: 'docButton', width: "30", align: "center", searchtype: "string", sortable: false }
                ],
                actModel: [
                    {name: 'operation', width: 32, align: 'center'}
                ],
                pager: '#pager2',
                caption: "务工人员学校管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="活动" onclick="doAction(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        <c:if test="${isZCYH}">
                        opButton += '<input type="button" value="活动" onclick="doAction(' + id + ')" class="button_normal"/> ';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "项目地点", "op": "cn", "data": ""},
                    { "field": "创建时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看务工人员学校管理", "${ctx}/workerSchool/view.do?id=" + id, false,900,550);
    }
    <c:if test="${canEdit || isZCYH}">
    function doAdd() {
        openWindow("添加务工人员学校管理", "${ctx}/workerSchool/add.do", true,900,550);
    }
    function doEdit(id) {
        openWindow("修改务工人员学校管理", "${ctx}/workerSchool/modify.do?id=" + id, true,900,550);
    }
    function doAction(id) {
        openWindow("添加活动信息", "${ctx}/workerSchool/action.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/workerSchool/delete.do?id=" + id);
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
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>