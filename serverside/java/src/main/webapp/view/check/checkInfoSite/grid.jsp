<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkInfoSite/gridDataCustom.do",
                colNames:['ID',
                    '报建编号',
                    '工地编号',
                    '工地名称',
                    '街镇',
                    '建设单位',
                    '施工总包单位',
                    '应到人数',
                    '实到人数',
//                    '设备序号',
//                    '设备SIM卡',
//                    '设备联机状态',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"t1.bjbh", width:"20", align:"left", searchtype:"string", sortable:true},
                    {name:"t1.gd_code", width:"27", align:"left", searchtype:"string", sortable:true},
                    {name:"t1.gd_name", width:"40", align:"left", searchtype:"string", sortable:true},
                    {name:"streetArea", width:"12", align:"center", searchtype:"string", sortable:true},
                    {name:"unitName", width:"35", align:"left", searchtype:"string", sortable:true},
                    {name:"totalUnitName", width:"35", align:"left", searchtype:"string", sortable:true},
                    {name:"regCount", width:"12", align:"center", searchtype:"string", sortable:true},
                    {name:"realCount", width:"12", align:"center", searchtype:"string", sortable:true}
//                    {name:"devSn", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"devSim", width:"32", align:"center", searchtype:"string", sortable:true},
//                    {name:"onlineStatus", width:"32", align:"center", searchtype:"string", sortable:true}//,
                ],
                actModel:[
                    {name:'operation', width:25, align:'center'}
                ],
                pager:'#pager2',
                caption:"考勤记录查询",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var regCount = rowData['regCount'];
                        var realCount = rowData['realCount'];
                        if (parseFloat(realCount) <parseFloat(regCount)) {
                            jQuery("#listGrid").jqGrid('setRowData', id,'', {background: 'yellow'});
                        }

                        var gdCode = rowData['t1.gd_code'];
                        var jdTaskCode = rowData['t1.jd_task_code'];
                        var opButton = '<input type="button" value="查询记录" title="查询记录" onclick="doView(' + "'" + gdCode + "','" + jdTaskCode + "'" + ')" class="button_normal_long"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"工地编号", "op":"cn", "data":""},
                    { "field":"工地名称", "op":"cn", "data":""}//,
//                    { "field":"街镇", "op":"cn", "data":""}//,
//                    { "field":"设备序号", "op":"cn", "data":""},
//                    { "field":"设备SIM卡", "op":"cn", "data":""},
//                    { "field":"设备联机状态", "op":"cn", "data":""}//,
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });

    function doView(gdCode, jdTaskCode) {
        openNewWindow("viewCheckWin","工地编号："+gdCode+"","${ctx}/checkInfoDay/init.do?gdCode=" + gdCode + "&jdTaskCode=" + jdTaskCode,false,900,550);
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
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>