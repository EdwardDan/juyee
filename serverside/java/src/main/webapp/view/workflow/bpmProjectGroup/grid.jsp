<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>


<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/bpmProjectGroup/gridDataCustom.do",
                colNames:[
                    'ID',
                    '项目组类型',
                    '项目组名称',
                    '印章名称',
                    //'项目组类型',
//            	'是否有效',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"type.name", width:"75", align:"center", searchtype:"string", sortable:true},
                    {name:"name", width:"75", align:"center", searchtype:"string", sortable:true},
                    {name:"stamper", width:"120", align:"center", searchtype:"string", sortable:true}
//{name:"attributes",width:"160",align:"center",searchtype:"string",sortable:true}
//{name:"isValid",width:"160",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat}
                ],
                actModel:[
                    {name:'operation', width:"80", align:'center'}
                ],
                pager:'#pager2',
                caption:"项目组列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    </c:if>
                        opButton += '<input type="button" value="岗位" onclick="doGroup(' + id + ')" class="button_normal"/>';
                        opButton += '<input type="button" value="属性" onclick="doAttr(' + id + ')" class="button_normal"/>';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"项目组类型", "op":"cn", "data":""},
                    { "field":"项目组名称", "op":"cn", "data":""},
                    { "field":"印章名称", "op":"cn", "data":""}
                    //      	{ "field":"项目组类型", "op":"cn", "data":""}
//            	{ "field":"是否有效", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目组", "${ctx}/bpmProjectGroup/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目组", "${ctx}/bpmProjectGroup/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目组", "${ctx}/bpmProjectGroup/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/bpmProjectGroup/delete.do?id=" + id);
    }
    </c:if>
    function doGroup(id) {
        loadMainPage("${ctx}/bpmProjectGroupDuty/grid.do?projectGroupId=" + id, "业务流程 >> 项目组 >> 岗位列表");
    <%--openWindow("项目组岗位"," ${ctx}/bpmProjectGroupDuty/grid.do?projectGroupId=" + id, true);--%>
    }
    function doAttr(id) {
        openWindow("项目组扩展属性", "${ctx}/bpmProjectGroup/extAttr.do?id=" + id + "&defCode=&attributeType=&expression=", true, 800, 500);
    }

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