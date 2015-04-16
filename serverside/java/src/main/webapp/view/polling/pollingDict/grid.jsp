<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/pollingDict/gridDataCustom.do",
                colNames:['ID',
                    '名称',
                    '法规依据',
                    '整改情形',
                    '立案情形',
                    '安全隐患',
//                    '叶节点',
//                    '树形层次',
                    '是否有效',
//                    '排序号',
//                    '备注',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"57", align:"left", searchtype:"string", sortable:true},
                    {name:"refRule", width:"57", align:"left", searchtype:"string", sortable:true},
                    {name:"reformType.name", width:"57", align:"center", searchtype:"string", sortable:true},
                    {name:"registerType.name", width:"57", align:"center", searchtype:"string", sortable:true},
                    {name:"safeType.name", width:"57", align:"center", searchtype:"string", sortable:true},
//                    {name:"isLeaf", width:"57", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"treeId", width:"57", align:"center", searchtype:"string", sortable:true},
                    {name:"isValid", width:"57", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat}
//                    {name:"orderNo", width:"57", align:"center", searchtype:"string", sortable:true},
//                    {name:"description", width:"57", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"巡查字典列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"名称", "op":"cn", "data":""},
                    { "field":"法规依据", "op":"cn", "data":""},
                    { "field":"整改情形", "op":"cn", "data":""},
                    { "field":"立案情形", "op":"cn", "data":""},
                    { "field":"安全隐患", "op":"cn", "data":""}
//                    { "field":"是否有效", "op":"cn", "data":""},
//                    { "field":"排序号", "op":"cn", "data":""},
//                    { "field":"备注", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看巡查字典", "${ctx}/pollingDict/view.do?id=" + id, false);
    }
    <%--<c:if test="${canEdit}">--%>
    <%--function doAdd() {--%>
    <%--openWindow("添加巡查字典", "${ctx}/pollingDict/add.do", true);--%>
    <%--}--%>
    <%--function doEdit(id) {--%>
    <%--openWindow("修改巡查字典", "${ctx}/pollingDict/modify.do?id=" + id, true);--%>
    <%--}--%>
    <%--function doDelete(id) {--%>
    <%--doGridDelete("${ctx}/pollingDict/delete.do?id=" + id);--%>
    <%--}--%>
    <%--</c:if>--%>
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
        <%--<div style="float:right;padding-right: 10px">--%>
        <%--<c:if test="${canEdit}">--%>
        <%--<input type="button" value="添加" class="button_add"--%>
        <%--onclick="doAdd()"/>--%>
        <%--</c:if>--%>
        <%--</div>--%>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>