<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaKnowledge/gridDataCustom.do",
                colNames: ['ID',
                    '主题名称',
                    '提出人',
                    '提出部门',
                    '主要内容',
                    '提出日期',
                    '相关附件',
                    '当前用户',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 5, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "61", align: "left", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "reportDept", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "content", width: "80", align: "left", searchtype: "string", hidden: true},
                    {name: "reportDate", width: "40", align: "center", searchtype: "datetime", sortable: true,formatter:'date', formatoptions:{srcformat: 'Y-m-d H:i:s',newformat:'Y-m-d H:i'}},
                    {name: "docButton", width: "30", align: "center", searchtype: "integer", sortable: false},
                    {name: "createUser", width: "30", align: "center", searchtype: "date",hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "业务知识交流列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["createUser"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="回复" onclick="doReply(' + id + ')" class="button_normal"/> ';
                        if(rowDataCell=="${currentUserName}"){
                            opButton += '<input type="button" value="修改" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        } else{
                            <c:if test="${canDelete}">
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "主题名称", "op": "cn", "data": ""},
                    { "field": "提出人", "op": "cn", "data": ""},
                    { "field": "提出部门", "op": "cn", "data": ""},
                    { "field": "主要内容", "op": "cn", "data": ""},
                    { "field": "提出部门", "op": "cn", "data": ""},
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看业务知识交流", "${ctx}/oaKnowledge/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加业务知识交流", "${ctx}/oaKnowledge/add.do", true);
    }
    function doReply(id) {
        openWindow("回复业务知识", "${ctx}/oaKnowledge/reply.do?id=" + id, true);
    }
    function doEdit(id) {
        openWindow("修改业务知识交流", "${ctx}/oaKnowledge/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaKnowledge/delete.do?id=" + id);
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
                <input type="button" value="新增" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>