<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysRole/gridDataCustom.do",
                colNames:['ID',
                    '角色编码',
                    '角色名称',
                    '描述',
                    '权限设置',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"code", width:"86", align:"left", searchtype:"string", sortable:true},
                    {name:"roleName", width:"80", align:"left", searchtype:"string", sortable:true},
                    {name:"description", width:"164", align:"left", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'setPrivilege', width:22, align:'center', sortable:false},
                    {name:'operation', width:58, align:'center', sortable:false}

                ],
                pager:'#pager2',
                caption:"角色管理列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接，“权限设置”项添加"授权"按钮
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                    <c:if test="${canEdit}">
                        var opButtonPrivilege = '<input type="button" title="授权" value="授权" onclick="doSetPrivilege(' + id + ')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { setPrivilege:opButtonPrivilege});
                    </c:if>
                        var opButton = '<input type="button" title="查看" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" title="编辑" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" title="删除" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"角色编码", "op":"cn", "data":""},
                    { "field":"角色名称", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doSetPrivilege(id) {
        openWindow("角色授权", "${ctx}/sysRole/setPrivilege.do?id=" + id, true, 800, 500);
    }
    function doAdd() {
        openWindow("添加角色", "${ctx}/sysRole/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改角色", "${ctx}/sysRole/modify.do?id=" + id, true);
    }
    function doView(id) {
        openWindow("查看角色", "${ctx}/sysRole/view.do?id=" + id, false);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysRole/delete.do?id=" + id);
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