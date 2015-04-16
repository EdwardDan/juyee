<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysUser/gridDataCustom.do",
                colNames:['ID',
                    '登陆名',
                    '显示名称',
                    '对应人员',
                    '帐号状态',
                    '角色设置',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"loginName", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"displayName", width:"35", align:"center", searchtype:"string", sortable:true},
                    {name:"person.name", width:"35", align:"center", searchtype:"date", sortable:true},
                    {name:"status", width:"20", align:"center", searchtype:"string", sortable:false, formatter:customFormat},
                    {name:"roleNames", width:"80", align:"left", searchtype:"string", sortable:false}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"用户管理列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"登陆名", "op":"cn", "data":"", "alias":"t.loginName"},
                    { "field":"显示名称", "op":"cn", "data":"", "alias":"t.displayName"}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc"),
                resetButton:"#conditionsDesc"
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看用户管理", "${ctx}/sysUser/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加用户管理", "${ctx}/sysUser/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改用户管理", "${ctx}/sysUser/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysUser/delete.do?id=" + id);
    }
    </c:if>
    //状态
    function customFormat(cellvalue, options, rowObject) {
        return cellvalue == "1" ? "有效" : "无效";
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