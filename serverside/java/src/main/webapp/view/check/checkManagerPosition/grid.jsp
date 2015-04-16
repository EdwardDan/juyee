<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkManagerPosition/gridDataCustom.do",
                colNames:['ID',
                    '监督任务书编号',
                    '报建编号',
                    '工地编号',
                    '工地名称',
                    '所属区县',
                    '街镇',
                    '是否有效',
                    '岗位名称',
                    '证书编号',
                    '证书名称',
                    '逻辑删除',
                    '是否同步',
                    'GUID',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:"jdTaskCode",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"bjbh",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"gdCode",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"gdName",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"belongArea",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"streetArea",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"isValid",width:"61",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
                    {name:"positionName",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"certificateCode",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"certificateName",width:"61",align:"center",searchtype:"string",sortable:true},
                    {name:"isDelete",width:"61",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
                    {name:"isSync",width:"61",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
                    {name:"guid",width:"61",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"人员岗位表列表",
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
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"监督任务书编号", "op":"cn", "data":""},
                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"工地编号", "op":"cn", "data":""},
                    { "field":"工地名称", "op":"cn", "data":""},
                    { "field":"所属区县", "op":"cn", "data":""},
                    { "field":"街镇", "op":"cn", "data":""},
                    { "field":"是否有效", "op":"cn", "data":""},
                    { "field":"岗位名称", "op":"cn", "data":""},
                    { "field":"证书编号", "op":"cn", "data":""},
                    { "field":"证书名称", "op":"cn", "data":""},
                    { "field":"逻辑删除", "op":"cn", "data":""},
                    { "field":"是否同步", "op":"cn", "data":""},
                    { "field":"GUID", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看人员岗位表", "${ctx}/checkManagerPosition/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加人员岗位表", "${ctx}/checkManagerPosition/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改人员岗位表", "${ctx}/checkManagerPosition/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/checkManagerPosition/delete.do?id=" + id);
    }
    </c:if>

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
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input" readonly="true"/>
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