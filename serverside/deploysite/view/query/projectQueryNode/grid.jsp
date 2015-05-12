<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projectQueryNode/gridDataCustom.do",
                colNames:['ID',
                    '年份',
                    '项目序号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '标段数',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:"year",width:"30",align:"center",searchtype:"integer",sortable:true},
                    {name:"no",width:"30",align:"center",searchtype:"integer",sortable:true},
                    {name:"name",width:"70",align:"left",searchtype:"string",sortable:true},
                    {name:"property.name",width:"40",align:"center",searchtype:"string",sortable:true},
                    {name:"stage.name",width:"40",align:"center",searchtype:"string",sortable:true},
                    {name:"category.name",width:"40",align:"center",searchtype:"date",sortable:true},
                    {name:"bidCountOfNode",width:"25",align:"center",searchtype:"string",sortable:true},
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager: '#pager2',
                caption:"项目形象进度查询",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var name = rowData["name"];
                        var opButton = '<input type="button" value="形象进度" onclick="doViewNode(\'' + id + '\', \'' + name + '\')" class="button_normal_long"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"年份", "op":"eq", "data":""},
                    { "field":"项目序号", "op":"cn", "data":""},
                    { "field":"项目名称", "op":"cn", "data":""},
                    { "field":"项目性质", "op":"cn", "data":""},
                    { "field":"项目阶段", "op":"cn", "data":""},
                    { "field":"项目类型", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doViewNode(id, name) {
        openWindow("查看形象进度信息（" + name + "）", "${ctx}/projectQueryNode/viewNode.do?id=" + id, false, 1000, 550);
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
            <c:if test="${canViewAll}">
                <input type="button" value="形象进度汇总" class="button_normal_longer" onclick="doViewNode('','汇总')"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>