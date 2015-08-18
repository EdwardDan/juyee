<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaFgldSet/gridDataCustom.do",
                colNames:['ID',
                    '人员',
                    '分管部门',
                    '备注',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"userName",width:"100",align:"center",searchtype:"string",sortable:false},
                    {name:"deptNames",width:"200",align:"left",searchtype:"string",sortable:false},
                    {name:"description", width:"200", align:"left", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"分管领导审批设置列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <%--<c:if test="${canEdit}">--%>
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
//                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    <%--</c:if>--%>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"备注", "op":"cn", "data":""},
                    { "field":"树形层次", "op":"cn", "data":""},
                    { "field":"是否叶节点", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看分管领导审批设置", "${ctx}/oaFgldSet/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加分管领导审批设置", "${ctx}/oaFgldSet/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改分管领导审批设置", "${ctx}/oaFgldSet/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaFgldSet/delete.do?id=" + id);
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
            <%--<c:if test="${canEdit}">--%>
                <%--<input type="button" value="添加" class="button_add"--%>
                       <%--onclick="doAdd()"/>--%>
            <%--</c:if>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>