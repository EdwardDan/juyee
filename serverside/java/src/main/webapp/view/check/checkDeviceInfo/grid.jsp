<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkDeviceInfo/gridDataCustom.do",
                colNames:['ID',
                    '监督任务书编号',
//                    '报建编号',
                    '工地编号',
                    '工地名称',
//            	'所属区县',
                    '街镇',
//            	'工地经度',
//            	'工地纬度',
//            	'设备名称',
                    '设备编号',
                    '注册人数',

//            	'设备型号',
//                    '设备SIM卡',
//                    '设备IP',
//            	'定位经度',
//            	'定位纬度',
//            	'定位时间',
//                    '最近联机时间',
                    '联机状态',
                    '地理位置',
//            	'注册时间',
//            	'注册操作人',
//            	'注销时间',
                    '注销状态',
//                    '注销操作人',
//                    'GUID',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"jdTaskCode", width:"25", align:"left", searchtype:"string", sortable:true},
//                    {name:"bjbh", width:"32", align:"center", searchtype:"string", sortable:true},
                    {name:"gdCode", width:"45", align:"left", searchtype:"string", sortable:true},
                    {name:"gdName", width:"60", align:"left", searchtype:"string", sortable:true},
//                    {name:"belongArea", width:"32", align:"center", searchtype:"string", sortable:true},
                    {name:"streetArea", width:"22", align:"center", searchtype:"string", sortable:true},
//                    {name:"longitude", width:"19", align:"center", searchtype:"string", sortable:true},
//                    {name:"latitude", width:"32", align:"center", searchtype:"string", sortable:true, hidden:true},
//                    {name:"devName", width:"32", align:"center", searchtype:"string", sortable:true},
                    {name:"devSn", width:"30", align:"left", searchtype:"string", sortable:true},
                    {name:"longitude", width:"17", align:"center", searchtype:"string", sortable:true},

//                    {name:"devMode", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"devSim", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"devIp", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"currentLongitude", width:"32", align:"center", searchtype:"string", sortable:true, hidden:true},
//                    {name:"currentLatitude", width:"32", align:"center", searchtype:"string", sortable:true, hidden:true},
//                    {name:"positionTime", width:"32", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"lastOnlineTime", width:"32", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"onlineStatus", width:"19", align:"center", searchtype:"string", sortable:true},
                    {name:"regDateTime", width:"22", align:"center", searchtype:"string", sortable:true},
//                    {name:"regDateTime", width:"32", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"regUserName", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"cancelDateTime", width:"32", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"cancelStatus", width:"19", align:"center", searchtype:"string", sortable:true}//,
//                    {name:"cancelUserName", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"guid", width:"32", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"设备注册表列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        <c:if test="${canEdit}">
                        var opButton = '<input type="button" value="注销" title="注销" onclick="doCancel(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="编辑" title="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" title="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                        </c:if>
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"监督任务书编号", "op":"cn", "data":""},
//                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"工地编号", "op":"cn", "data":""},
                    { "field":"工地名称", "op":"cn", "data":""},
//            	{ "field":"所属区县", "op":"cn", "data":""},
                    { "field":"街镇", "op":"cn", "data":""},
//            	{ "field":"工地经度", "op":"cn", "data":""},
//            	{ "field":"工地纬度", "op":"cn", "data":""},
//            	{ "field":"设备名称", "op":"cn", "data":""},
                    { "field":"设备编号", "op":"cn", "data":""}//,
//            	{ "field":"设备型号", "op":"cn", "data":""},
//                    { "field":"设备SIM卡", "op":"cn", "data":""},
//                    { "field":"设备IP", "op":"cn", "data":""},
//            	{ "field":"定位经度", "op":"cn", "data":""},
//            	{ "field":"定位纬度", "op":"cn", "data":""},
//                { "field":"定位时间", "op":"bw", "data":""},
//                    { "field":"最近联机时间", "op":"bw", "data":""},
//                    { "field":"联机状态", "op":"cn", "data":""},
//                { "field":"注册时间", "op":"bw", "data":""},
//            	{ "field":"注册操作人", "op":"cn", "data":""},
//                { "field":"注销时间", "op":"bw", "data":""},
//                    { "field":"注销状态", "op":"cn", "data":""}//,
//                    { "field":"注销操作人", "op":"cn", "data":""},
//                    { "field":"GUID", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });

    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加设备注册表", "${ctx}/checkDeviceInfo/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改设备注册表", "${ctx}/checkDeviceInfo/modify.do?id=" + id, true);
    }
    function doCancel(id) {
        openWindow("注销设备注册表", "${ctx}/checkDeviceInfo/cancel.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/checkDeviceInfo/delete.do?id=" + id);
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