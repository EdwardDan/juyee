<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysDeptUser/gridDataCustom.do",
                colNames:['ID',
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                ],
                actModel:[
                    {name:'operation', width:80, align:'center'}
                ],
                pager: '#pager2',
                caption:"单位用户列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doAdd() {
        openWindow("添加单位用户", "${ctx}/sysDeptUser/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改单位用户", "${ctx}/sysDeptUser/modify.do?id=" + id, true);
    }
    function doView(id) {
        openWindow("查看单位用户", "${ctx}/sysDeptUser/view.do?id=" + id, false);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysDeptUser/delete.do?id=" + id);
    }
    //custom formatter
    //add attribute to colModel's column
    //exist define:booleanFormat/validFormat
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
            <input type="button" value="添加" class="button_add"
                   onclick="doAdd()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>