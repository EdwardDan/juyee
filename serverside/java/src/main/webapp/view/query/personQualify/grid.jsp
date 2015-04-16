<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/personQualify/gridDataCustom.do",
                colNames:['ID','姓名','性别','身份证','证书名称','证书编号','有效期','证书所在单位','操作'],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:'personName', width:50, align:"center", searchtype:"string",sortable:true},
                    {name:'personSex', width:20, align:"center", searchtype:"string",sortable:true},
                    {name:'cardNo', width:50, align:"center", searchtype:"string",sortable:true},
                    {name:'qualifyTypeDesc', width:45, align:"center", searchtype:"string",sortable:true},
                    {name:'regQualifyCode', width:40, align:"left", searchtype:"integer",sortable:true},
                    {name:'validDate', width:40, align:"center", searchtype:"integer",sortable:true},
                    {name:'regUnitName', width:80, align:"left", searchtype:"date",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:30, align:'center'}
                ],
                pager: '#pager2',
                caption:"查询结果列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="详情" onclick="doView(' + id + ')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""},
                    { "field":"身份证", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("详细信息", "${ctx}/personQualify/view.do?id=" + id, false,800,500);
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