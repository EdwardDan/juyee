<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysDept/gridDataCustom.do",
                colNames:['ID',
                    '单位代码',
                    '单位名称',
//                    '简称',
//                    '叶节点',
//                    '树形层次',
                    '机构代码证',
//                    '注册地编码',
                    '注册地名称',
//                    '隶属省市代码',
                    '隶属省市名称',
                    '注册地址',
//                    '排序',
                    '单位标志',
//                    '备注',
//                    '创建时间',
//                    '更新时间',
//                    '创建人',
//                    '更新人',
                    '是否有效',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"code", width:"42", align:"left", searchtype:"string", sortable:true},
                    {name:"name", width:"42", align:"left", searchtype:"string", sortable:true},
//                    {name:"shortName", width:"42", align:"center", searchtype:"string", sortable:true},
//                    {name:"isLeaf", width:"42", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"treeId", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"cardNo", width:"42", align:"left", searchtype:"string", sortable:true},
//                    {name:"cityCode", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"cityName", width:"42", align:"left", searchtype:"string", sortable:true},
//                    {name:"provinceCode", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"provinceName", width:"42", align:"left", searchtype:"string", sortable:true},
                    {name:"address", width:"42", align:"left", searchtype:"string", sortable:true},
//                    {name:"orderNo", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"isTag", width:"20", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"memo", width:"42", align:"center", searchtype:"string", sortable:true},
//                    {name:"createTime", width:"42", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"updateTime", width:"42", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"createUser", width:"42", align:"center", searchtype:"string", sortable:true},
//                    {name:"updateUser", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"isValid", width:"20", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat}
                ],
                actModel:[
                    {name:'operation', width:20, align:'center'}
                ],
                pager:'#pager2',
                caption:"单位部门列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ', \'' + rowData.isTag + '\')" class="button_normal"> ';
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
//                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"单位代码", "op":"cn", "data":""},
                    { "field":"单位名称", "op":"cn", "data":""},
//                    { "field":"简称", "op":"cn", "data":""},
//                    { "field":"叶节点", "op":"cn", "data":""},
//                    { "field":"树形层次", "op":"cn", "data":""},
                    { "field":"机构代码证", "op":"cn", "data":""},
//                    { "field":"注册地编码", "op":"cn", "data":""},
                    { "field":"注册地名称", "op":"cn", "data":""},
//                    { "field":"隶属省市代码", "op":"cn", "data":""},
                    { "field":"隶属省市名称", "op":"cn", "data":""}
//                    { "field":"注册地址", "op":"cn", "data":""},
//                    { "field":"排序", "op":"cn", "data":""},
//                    { "field":"单位标志", "op":"cn", "data":""},
//                    { "field":"备注", "op":"cn", "data":""},
//                    { "field":"创建时间", "op":"bw", "data":""},
//                    { "field":"更新时间", "op":"bw", "data":""},
//                    { "field":"创建人", "op":"cn", "data":""},
//                    { "field":"更新人", "op":"cn", "data":""},
//                    { "field":"是否有效", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doAdd() {
        openWindow("添加单位部门", "${ctx}/sysDept/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改单位部门", "${ctx}/sysDept/modify.do?id=" + id, true);
    }
    function doView(id, type) {
        if (type == "是") {
            openWindow("查看单位", "${ctx}/sysDept/viewDw.do?id=" + id, false);
        } else if (type == "否") {
            openWindow("查看部门", "${ctx}/sysDept/viewDept.do?id=" + id, false);
        }
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysDept/delete.do?id=" + id);
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
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <%--<div style="float:right;padding-right: 10px">--%>
        <%--<input type="button" value="添加" class="button_add"--%>
        <%--onclick="doAdd()"/>--%>
        <%--</div>--%>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>