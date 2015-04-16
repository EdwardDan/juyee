<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/shareUnitQualify/gridDataCustom.do?curDate=${curDate}",
                colNames:['ID', '企业名称', '批准资质类型', '批准资质名称', '资质等级', '批准时间', '操作'],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:'unit_name', width:80, align:"left", searchtype:"string", sortable:true},
                    {name:'qualify_big_type_desc', width:50, align:"center", searchtype:"string", sortable:true},
                    {name:'qualify_type_desc', width:60, align:"center", searchtype:"string", sortable:true},
                    {name:'qualify_level_desc', width:40, align:"center", searchtype:"string", sortable:true},
                    {name:'accept_datetime', width:40, align:"center", searchtype:"date", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"企业资质审批列表",
                jsonReader:{
                    repeatitems:true,
                    cell:"",
                    id:"0"
                },
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ',1)" class="button_normal"> ';
//                        opButton += '<input type="button" value="人员资格" onclick="doView(' + id + ',2)" class="button_normal_long"> ';
//                        opButton += '<input type="button" value="承建工程" onclick="doView(' + id + ',3)" class="button_normal_long"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"企业名称", "op":"cn", "data":""},
                    { "field":"批准资质类型", "op":"cn", "data":""},
                    { "field":"批准资质名称", "op":"cn", "data":""},
                    { "field":"资质等级", "op":"cn", "data":""},
                    { "field":"批准时间", "op":"bt", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    //查看
    function doView(id, flag) {
        if (flag == 1) {
            openWindow("资质详情", "${ctx}/shareUnitQualify/view.do?id=" + id, false, 900, 525);
        }
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
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>