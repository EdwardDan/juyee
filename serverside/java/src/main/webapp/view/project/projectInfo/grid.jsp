<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projectInfo/gridDataCustom.do",
                colNames:['ID',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '${prop.get("columnName")}',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"buildCode", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDatetime", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"buildName", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDept", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptProperty", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptAddress", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptPhone", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptLegal", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptLinkman", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptZipcode", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildDeptRegCapital", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildAddress", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildProperty", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildScope", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildArea", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"buildStartDate", width:"30", align:"center", searchtype:"date", sortable:true},
                    {name:"totalInvest", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"projectType", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"belongArea", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"proDesc", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"createTime", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"updateTime", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"createUser", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"updateUser", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"proSchedule", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"proAttention", width:"30", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"项目信息列表",
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
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"bw", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"bw", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"bw", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""},
                    { "field":"${prop.get("columnName")}", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目信息", "${ctx}/projectInfo/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目信息", "${ctx}/projectInfo/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目信息", "${ctx}/projectInfo/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projectInfo/delete.do?id=" + id);
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