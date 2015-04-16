<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:<c:choose>
                        <c:when test="${codeId!=null}">
                        "${ctx}/sysCodeDetail/gridDataCustom.do?codeId=" + ${codeId},
                </c:when>
                <c:otherwise>
                "${ctx}/sysCodeDetail/gridDataCustom.do?",
                </c:otherwise>
                </c:choose>
                colNames:['ID',
                    '编码',
                    '名称',
                    '是否系统定义',
                    '特殊标记',
                    '是否有效',
                    '备注',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"code", width:"100", align:"left", searchtype:"string", sortable:true},
                    {name:"name", width:"100", align:"left", searchtype:"string", sortable:true},
                    {name:"isReserved", width:"68", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"tag", width:"104", align:"left", searchtype:"string", sortable:true},
                    {name:"isValid", width:"48", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"description", width:"190", align:"left", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:30, align:'center', sortable:false}
                ],
                pager:'#pager2',
                caption:"系统代码明细列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" title="查看" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"编码", "op":"cn", "data":""},
                    { "field":"名称", "op":"cn", "data":""},
//                    { "field":"叶节点", "op":"cn", "data":""},
//                    { "field":"树形层次", "op":"cn", "data":""},
//                    { "field":"是否系统定义", "op":"cn", "data":""},
                    { "field":"特殊标记", "op":"cn", "data":""}//,
//                    { "field":"是否有效", "op":"cn", "data":""},
//                    { "field":"备注", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看系统代码明细", "${ctx}/sysCodeDetail/view.do?id=" + id, false);
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