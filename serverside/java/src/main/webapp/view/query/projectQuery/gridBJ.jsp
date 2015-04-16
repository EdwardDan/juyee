<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projectQuery/gridDataCustomBJ.do?flag=${flag}",
                colNames:['ID','报建编号','项目名称','建设地点','项目分类','总投资(万元)','总面积(㎡)','报建日期'
                    ,'有无工地' //hide column
                    ,'工地编号' //hide column
                    ,'建设单位'
                    ,'操作'],
                colModel:[
                    {name:'id', width:5, align:"center", searchtype:"string",hidden:true},
                    {name:'t.bjbh', width:30, align:"center", searchtype:"string",sortable:true},
                    {name:'t.project_name', width:80, align:"left", searchtype:"string",sortable:true},
                    {name:'t.build_address', width:60, align:"left", searchtype:"string",sortable:true},
                    {name:'t.property', width:30, align:"center", searchtype:"string",sortable:true,hidden:true},
                    {name:'t.total_Investment', width:30, align:"right", searchtype:"integer",sortable:true,formatter:'currency',formatoptions:{decimalSeparator:".", thousandsSeparator: ",",
                        decimalPlaces: 2, prefix: ""}},
                    {name:'t.total_Area', width:30, align:"right", searchtype:"integer",sortable:true,formatter:'currency',formatoptions:{decimalSeparator:".", thousandsSeparator: ",",
                        decimalPlaces: 2, prefix: ""}},
                    {name:'t.bj_Date', width:30, align:"center", searchtype:"date",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d',newformat:'Y-m-d'}},
                    {name:'gdCount', width:20, align:"center", searchtype:"string",formatter:showGd},
                    {name:'gdCode', width:5, align:"center", searchtype:"string",hidden:true},
                    {name:'t.build_unit_name', width:5, align:"center", searchtype:"string",hidden:true}
                ],
                actModel:[
                    {name:'operation', width:20, align:'center'}
                ],
                pager: '#pager2',
                caption:"查询结果列表",
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
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var gdCount = rowData["gdCount"];
                        var gdCode = rowData["gdCode"];
                        var idParam = rowData["t.bjbh"];
                        var opButton = '<input type="button" value="详情" onclick="doViewUrl(\'' + idParam + '\')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"项目名称", "op":"cn", "data":""},
                    { "field":"建设地点", "op":"cn", "data":""},
                    { "field":"报建日期", "op":"bt", "data":""},
                    { "field":"建设单位", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });

    //链接到市系统的项目详情页面
    function doViewUrl(id) {
        openFullWindow("http://ciacdata.ciac.sh.cn/Common/Details.aspx?bjbh="+id,900,600,"查看项目");
    }

    //是否有工地
    function showGd(cellvalue, options, rowObject) {
        if(cellvalue != null && cellvalue != ""){
            if(parseInt(cellvalue)>0){
                return "有";
            }
        }
        return "无";
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
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>施工单位:&nbsp;</td>
            <td class="operators" style="display: none;">包含</td>
            <td class="data"><input type="text" name="sgdw" style="width: 355px;" class="input-elm"></td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns">监理单位:&nbsp;</td>
            <td class="operators" style="display: none;">包含</td>
            <td class="data"><input type="text" name="jldw" style="width: 355px;" class="input-elm"></td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>