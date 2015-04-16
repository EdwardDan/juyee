<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/unitQualify/gridDataCustom.do",
                colNames:['ID','机构代码证','单位名称','注册地址','注册省市','所属区域','经济类型','操作'],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:'orgCode', width:45, align:"center", searchtype:"string",sortable:true},
                    {name:'unitName', width:70, align:"left", searchtype:"string",sortable:true},
                    {name:'regAddress', width:95, align:"left", searchtype:"string",sortable:true},
                    {name:'belogProvince', width:30, align:"center", searchtype:"string",sortable:true},
                    {name:'regCityName', width:30, align:"center", searchtype:"string",sortable:true},
                    {name:'unitEcoName', width:50, align:"center", searchtype:"integer",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:120, align:'center'}
                ],
                pager: '#pager2',
                caption:"查询结果列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="资质详情" onclick="doView(' + id + ',1)" class="button_normal_long"> ';
                        opButton += '<input type="button" value="人员资格" onclick="doView(' + id + ',2)" class="button_normal_long"> ';
                        opButton += '<input type="button" value="承建工程" onclick="doView(' + id + ',3)" class="button_normal_long"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"机构代码证", "op":"cn", "data":""},
                    { "field":"单位名称", "op":"cn", "data":""},
                    { "field":"注册地址", "op":"cn", "data":""},
                    { "field":"注册省市", "op":"cn", "data":""},
                    { "field":"所属区域", "op":"cn", "data":""}
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
            openWindow("资质详情", "${ctx}/unitQualify/view.do?id=" + id, false, 900, 525);
        } else if (flag == 2) {
            openWindow("人员资格", "${ctx}/unitQualify/viewPerson.do?id=" + id, false, 900, 525);
        } else if (flag == 3) {
            openWindow("承建工程", "${ctx}/unitQualify/viewProject.do?id=" + id, false, 900, 525);
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