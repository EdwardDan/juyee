<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysPrivilege/gridDataCustom.do",
                colNames:['ID',
                    '权限编码',
                    '权限名称',
                    '权限类型',
                    'TAG',
//                    '页面地址',
//                    '定义',
//                    '描述',
//                    '是否叶节点',
//                    '树形层次',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"code", width:"90", align:"left", searchtype:"string", sortable:true},
                    {name:"name", width:"90", align:"left", searchtype:"string", sortable:true},
                    {name:"type.name", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"tag", width:"30", align:"left", searchtype:"string", sortable:true}
//                    {name:"url", width:"150", align:"left", searchtype:"string", sortable:true}
//                    {name:"definition", width:"100", align:"left", searchtype:"string", sortable:true},
//                    {name:"description", width:"100", align:"center", searchtype:"string", sortable:true},
//                    {name:"isLeaf", width:"100", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"treeId", width:"100", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"权限管理列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
//                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"权限编码", "op":"cn", "data":""},
                    { "field":"权限名称", "op":"cn", "data":""}
//                    { "field":"TAG", "op":"cn", "data":""},
//                    { "field":"页面地址", "op":"cn", "data":""},
//                    { "field":"定义", "op":"cn", "data":""},
//                    { "field":"描述", "op":"cn", "data":""},
//                    { "field":"是否叶节点", "op":"cn", "data":""},
//                    { "field":"树形层次", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doAdd() {
        openWindow("添加权限管理", "${ctx}/sysPrivilege/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改权限管理", "${ctx}/sysPrivilege/modify.do?id=" + id, true);
    }
    function doView(id) {
        openWindow("查看权限管理", "${ctx}/sysPrivilege/view.do?id=" + id, false);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysPrivilege/delete.do?id=" + id);
    }
    //custom formatter
    //add attribute to colModel's column
    //exist define:booleanFormat/validFormat
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
            <%--<input type="button" value="添加" class="button_add"--%>
            <%--onclick="doAdd()"/>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>