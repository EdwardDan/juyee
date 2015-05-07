<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/configTable/gridDataCustom.do",
                colNames:['ID',
                    '表名',
                    '类名',
                    '扩展XML',
                    '记录日志',
                    '创建时间',
//                    '更新时间',
//                    '更新人',
                    '创建人',

                    '操作'
                ],
                colModel:[
                    {name:'id', width:"1", align:"center", searchtype:"integer", hidden:true},
                    {name:"tableName", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"className", width:"50", align:"center", searchtype:"string", sortable:true, formatter:customeFormat},
                    {name:"extendXml", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"isLog", width:"20", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},

                    {name:"createTime", width:"40", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"updateTime",width:"100",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"updateUser",width:"100",align:"center",searchtype:"string",sortable:true},
                    {name:"createUser", width:"17", align:"center", searchtype:"string", sortable:true}

                ],
                actModel:[
                    {name:'operation', width:"40", align:'center'}
                ],
                pager:'#pager2',
                caption:"表日志配置列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"表名", "op":"cn", "data":""},
                    { "field":"类名", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看表日志配置", "${ctx}/configTable/view.do?id=" + id, false, 800, 450);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加表日志配置", "${ctx}/configTable/add.do", true, 800, 450);
    }
    function doEdit(id) {
        openWindow("修改表日志配置", "${ctx}/configTable/modify.do?id=" + id, true, 800, 450);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/configTable/delete.do?id=" + id);
    }
    </c:if>

    //custom formatter
    function customeFormat(cellvalue, options, rowObject) {
        return cellvalue = cellvalue.substring(cellvalue.lastIndexOf(".") + 1);

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
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>