<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/bpmProjectGroupDuty/gridDataCustom.do?projectGroupId=${group.id}",
                colNames:['ID',
                    '岗位类型',
                    '岗位名称',
                    '备注',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:"type.name",width:"100",align:"center",searchtype:"string",sortable:true},
                    {name:"name",width:"100",align:"center",searchtype:"string",sortable:true},
                    {name:"description",width:"100",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:80, align:'center'}
                ],
                pager: '#pager2',
                caption:"项目组岗位列表",
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
                        opButton += '<input type="button" value="属性" onclick="doExtAttr(' + id + ')" class="button_normal"/>';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"岗位类型", "op":"cn", "data":""},
                    { "field":"岗位名称", "op":"cn", "data":""},
                    { "field":"备注", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目组岗位", "${ctx}/bpmProjectGroupDuty/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目组岗位", "${ctx}/bpmProjectGroupDuty/add.do?projectGroupId="+${group.id}, true);
    }
    function doEdit(id) {
        openWindow("修改项目组岗位", "${ctx}/bpmProjectGroupDuty/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/bpmProjectGroupDuty/delete.do?id=" + id);
    }
    </c:if>
    function loadback() {
        loadMainPage ("${ctx}/bpmProjectGroup/grid.do","项目组岗位列表");
    }
    function doExtAttr(id) {
        openWindow("岗位扩展属性", "${ctx}/bpmProjectGroupDuty/extAttr.do?id=" + id+ "&defCode=&attributeType=&expression=", true,800,500);
    }
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input" readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">
            <input type="button" value="返回" class="button_back"
                   onclick="loadback()"/>
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