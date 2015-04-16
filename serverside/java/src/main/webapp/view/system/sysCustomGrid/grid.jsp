<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysCustomGrid/gridDataCustom.do",
                colNames:['ID',
                    '板块编码',
                    '板块名称',
                    '系统权限名称',
                    '是否有效',
                    '排序号',
                    '最后更新时间',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"modelCode", width:"60", align:"center", searchtype:"string", sortable:true},
                    {name:"modelName", width:"80", align:"center", searchtype:"string", sortable:true},
                    {name:"privilege.name", width:"80", align:"center", searchtype:"string", sortable:true},
                    {name:"isValid", width:"50", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"orderNo", width:"50", align:"center", searchtype:"integer", sortable:true, formatter:'integer', formatoptions:{thousandsSeparator:",", defaulValue:0}},
                    {name:"updateTime", width:"70", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"系统首页板块设置列表",
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
                    { "field":"板块编码", "op":"cn", "data":""},
                    { "field":"板块名称", "op":"cn", "data":""},
                    { "field":"排序号", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看系统首页板块设置", "${ctx}/sysCustomGrid/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加系统首页板块设置", "${ctx}/sysCustomGrid/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改系统首页板块设置", "${ctx}/sysCustomGrid/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysCustomGrid/delete.do?id=" + id);
    }
    </c:if>

    //custom formatter
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
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>