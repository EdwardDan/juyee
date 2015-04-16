<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/jdReport/gridDataCustom.do",
                colNames:['ID',
                    '报建编号',
                    '报告类型',
                    '建设单位',
                    '工程名称',
                    '监督报告日期',
                    '编制人',
//                    '打印内容',
//                    '打印时间',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"bjbh", width:"40", align:"center", searchtype:"string", sortable:true},
                    {name:"reportType.name", width:"20", align:"center", searchtype:"string", sortable:true},
                    {name:"buildUnit", width:"60", align:"left", searchtype:"string", sortable:true},
                    {name:"projectName", width:"75", align:"left", searchtype:"string", sortable:true},
                    {name:"reportDate", width:"30", align:"center", searchtype:"date", sortable:true},
                    {name:"reportPerson",width:"20",align:"center",searchtype:"string",sortable:true}
//                    {name:"printReport",width:"114",align:"center",searchtype:"string",sortable:true},
//                    {name:"printDatetime",width:"114",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"监督报告列表",
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
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"流转编号", "op":"cn", "data":""},
                    { "field":"报建编号", "op":"cn", "data":""},
                    { "field":"建设单位", "op":"cn", "data":""},
//                    { "field":"工程名称", "op":"cn", "data":""},
                    { "field":"监督报告日期", "op":"bt", "data":""}
//                    { "field":"打印内容", "op":"cn", "data":""},
//                    { "field":"打印时间", "op":"bw", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看监督报告", "${ctx}/jdReport/frame.do?act=view&id=" + id, false, 950, 525);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加监督报告", "${ctx}/jdReport/frame.do?act=add", true, 950, 525);
    }
    function doEdit(id) {
        openWindow("修改监督报告", "${ctx}/jdReport/frame.do?act=edit&id=" + id, true, 950, 525);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/jdReport/delete.do?id=" + id);
    }
    </c:if>
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