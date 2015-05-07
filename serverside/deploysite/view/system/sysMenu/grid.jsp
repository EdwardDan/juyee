<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysMenu/gridDataCustom.do",
                colNames:['ID',
                    '名称',
                    '编码',
                    '层次',
                    '链接地址',
//                    '事件',
                    '是否有效',
//                    '参数',
//                    '目标窗口',
                    '显示图标',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"70", align:"left", searchtype:"string", sortable:true},
                    {name:"privilege", width:"70", align:"left", searchtype:"string", sortable:true},
                    {name:"menuLevel", width:"30", align:"center", searchtype:"integer", sortable:true, formatter:'integer', formatoptions:{thousandsSeparator:",", defaulValue:0}},
                    {name:"url", width:"100", align:"left", searchtype:"string", sortable:true},
//                    {name:"jsEvent", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"isValid", width:"30", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"param", width:"50", align:"center", searchtype:"string", sortable:true},
//                    {name:"target", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"icon", width:"30", align:"center", searchtype:"string", sortable:true, formatter:iconFormat}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"系统菜单列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
//                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"名称", "op":"cn", "data":""},
                    { "field":"编码", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doAdd() {
        openWindow("添加系统菜单", "${ctx}/sysMenu/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改系统菜单", "${ctx}/sysMenu/modify.do?id=" + id, true);
    }
    function doView(id) {
        openWindow("查看系统菜单", "${ctx}/sysMenu/view.do?id=" + id, false);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysMenu/delete.do?id=" + id);
    }
    //custom formatter
    function iconFormat(cellvalue, options, rowObject) {
        return '<span class="icon ' + cellvalue + '">&nbsp;</span>';
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