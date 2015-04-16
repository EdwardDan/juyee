<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/orderFormSite/gridDataCustom.do",
                colNames:['ID','报建编号','监督任务书编号','项目名称','建设地点','项目分类','总投资(万元)','总面积(㎡)','报建日期'
                    ,'HIDE1'
                    ,'HIDE2'
                    ,'建设单位'
//                    ,'施工单位'
//                    ,'监理单位'
                    ,'操作'],
                colModel:[
                    {name:'id', width:5, align:"center", searchtype:"string",hidden:true},
                    {name:'t.bjbh', width:33, align:"center", searchtype:"string",sortable:true},
                    {name:'t.jd_task_code', width:50, align:"center", searchtype:"string",sortable:true},
                    {name:'t.project_name', width:60, align:"left", searchtype:"string",sortable:true},
                    {name:'t.build_address', width:40, align:"left", searchtype:"string",sortable:true},
                    {name:'s.name', width:30, align:"center", searchtype:"string",sortable:true},
                    {name:'t.total_Investment', width:30, align:"right", searchtype:"integer",sortable:true,formatter:'currency',formatoptions:{decimalSeparator:".", thousandsSeparator: ",",
                        decimalPlaces: 2, prefix: ""}},
                    {name:'t.total_Area', width:30, align:"right", searchtype:"integer",sortable:true,formatter:'currency',formatoptions:{decimalSeparator:".", thousandsSeparator: ",",
                        decimalPlaces: 2, prefix: ""}},
                    {name:"t.jd_datetime", width:30, align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    {name:'gdCount', width:5, align:"center", searchtype:"string",hidden:true},
                    {name:'gdCode', width:5, align:"center", searchtype:"string",hidden:true},
                    {name:'t.js_unit_name', width:5, align:"center", searchtype:"string",hidden:true}
//                    {name:'g.sg_total_unit_name', width:5, align:"center", searchtype:"string",hidden:true}
//                    {name:'j.dwmc', width:5, align:"center", searchtype:"string",hidden:true}
                ],
                actModel:[
                    {name:'operation', width:35, align:'center'}
                ],
                pager: '#pager2',
                caption:"监督预约列表",
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
                        var jdTaskCode = rowData["t.jd_task_code"];
                        var idParam = rowData["t.bjbh"];
                        var opButton = "";
//                        if (gdCount == "0") {
//                            opButton = '<input type="button" value="详情" onclick="doView(\'' + idParam + '\',\'\',\'' + flowCode + '\')" class="button_normal"> ';
//                        }else {
                        opButton = '<input type="button" value="详情" onclick="doView(\'' + idParam + '\',\'' + gdCode + '\',\'' + jdTaskCode + '\')" class="button_normal"> ';
                        opButton += '<input type="button"  value="监督预约" onclick="addOrderForm(\'' + jdTaskCode + '\')" class="button_normal_long"> ';
//                        }
//                        else if (gdCount == "1") {
//                            opButton = '<input type="button" value="详情" onclick="doView(\'' + idParam + '\',\'' + gdCode + '\',\'' + flowCode + '\')" class="button_normal"> ';
//                        } else {
//                            opButton = '<input type="button" value="详情" onclick="doViewSelect(\'' + idParam + '\',\'' + flowCode + '\')" class="button_normal"> ';
//                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
//                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"项目名称", "op":"cn", "data":""},
                    { "field":"监督任务书编号", "op":"cn", "data":""},
                    { "field":"报建日期", "op":"bt", "data":""},
                    { "field":"建设单位", "op":"cn", "data":""}
//                    { "field":"施工单位", "op":"cn", "data":""}
//                    { "field":"监理单位", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });

    //gdCode不再使用
    function doView(id, gdCode,jdTaskCode) {
        var title = "详细信息（报建编号："+id;
//        if(gdCode != ""){
//            title += "，工地编号："+gdCode;
//        }
        if(jdTaskCode != ""){
            title += "，监督任务书编号："+jdTaskCode;
        }
        title += "）";
        viewProjectInfo(title,id,gdCode,jdTaskCode,true,false);
    }
    <%--function doViewSelect(id,jdTaskCode) {--%>
        <%--openWindow("选择工地", "${ctx}/projectQuery/viewSelect.do?bjbh=" + id+"&jdTaskCode="+jdTaskCode, false, 500, 300);--%>
    <%--}--%>
    function addOrderForm(jdTaskCode){
        openWindow("填写监督预约", "${ctx}/orderFormSite/add.do?jdTaskCode="+jdTaskCode, false,860, 500);
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
    <%--<table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">--%>
        <%--<tr>--%>
            <%--<td class="first"></td>--%>
            <%--<td class="columns" style='width: 15%;' nowrap>施工单位:&nbsp;</td>--%>
            <%--<td class="operators" style="display: none;">包含</td>--%>
            <%--<td class="data"><input type="text" name="sgdw" style="width: 120px;" class="input-elm"></td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="first"></td>--%>
            <%--<td class="columns">监理单位:&nbsp;</td>--%>
            <%--<td class="operators" style="display: none;">包含</td>--%>
            <%--<td class="data"><input type="text" name="jldw" style="width: 120px;" class="input-elm"></td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>