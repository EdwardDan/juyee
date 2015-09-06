<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaReceive/gridDataCustom.do",
                colNames:['ID',
                    '收文编号',
                    '来文文号',
                    '标题',
                    '来文单位',
                    '登记日期',
                    '办理时限',
                    '当前步骤',
                    '当前步骤code',
                    '是否可编辑',
                    '是否催办',
                    '附件',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"code", width:"47", align:"left", searchtype:"string", sortable:true},
                    {name:"fileCode", width:"47", align:"left", searchtype:"string", sortable:true},
                    {name:"title", width:"47", align:"left", searchtype:"string", sortable:true},
                    {name:"sourceDept", width:"47", align:"left", searchtype:"string", sortable:true},
                    {name:"receiveDate", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d'}},
                    {name:"limitDate", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d'}},
                    {name:"step.name", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"step.code", width:"30", align:"center", searchtype:"string", hidden:true},
                     {name:"isValid", width:"30", align:"center", searchtype:"string", hidden:true},
                     {name:"isPress", width:"30", align:"center", searchtype:"string", hidden:true},
                    {name:"documentFile", width:"30", align:"center", searchtype:"string"}
                ],
                actModel:[
                    {name:'operation', width:60, align:'center'}
                ],
                pager:'#pager2',
                caption:"收文管理列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var step = rowData["step.code"];
                        var isValid = rowData["isValid"];
                        var isPress = rowData["isPress"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="日志" onclick="doViewNode(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}){
                            if (step =='${BGSNB}' &&${isZR}){
                                opButton += '<input type="button" value="拟办" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            }
                            if (isValid=='true') {
                                if (step=='${LDPS}' || step =='${BMLDYJ}' || step =='${BLJG}') {
                                    opButton += '<input type="button" value="审核" onclick="doAuditMain(' + id + ')" class="button_normal"/> ';
                                }
                                if (step =='${SWDJ}') {
                                    opButton += '<input type="button" value="编辑" onclick="doEditPre(' + id + ')" class="button_normal"/> ';
                                    opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                }
                            }
                            if (isPress=='true') {
                                opButton += '<input type="button" value="催办" onclick="doPress(' + id + ')" class="button_normal"/> ';
                            }

                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"收文编号", "op":"cn", "data":""},
                    { "field":"来文文号", "op":"cn", "data":""},
                    { "field":"标题", "op":"cn", "data":""},
                    { "field":"来文单位", "op":"cn", "data":""},
                    { "field":"登记日期", "op":"bw", "data":""},
                    { "field":"办理时限", "op":"bw", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看收文管理", "${ctx}/oaReceive/auditMain.do?id=" + id + "&type=view", false, 850, 500);
    }
    function doViewNode(oaReceiveId) {
        loadMainPage("${ctx}/oaReceiveNode/grid.do?oaReceiveId=" + oaReceiveId, "OA办公 >> 收文登记单 >> 日志");
    }
    function doAdd() {
        openWindow("添加收文管理", "${ctx}/oaReceive/add.do", true, 850, 500);
    }
    function doEdit(id) {
        openWindow("收文管理办公室拟办", "${ctx}/oaReceive/modify.do?id=" + id, true, 850, 500);
    }
    function doEditPre(id) {
        openWindow("修改收文管理", "${ctx}/oaReceive/modifyPre.do?id=" + id, true, 850, 500);
    }
    function doAuditMain(id) {
        openWindow("审核收文管理", "${ctx}/oaReceive/auditMain.do?id=" + id + "&type=auditMain", true, 850, 500);
    }
    function doPress(id) {
        openWindow("收文管理催办", "${ctx}/oaReceive/press.do?id=" + id, true, 650, 400);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaReceive/delete.do?id=" + id);
    }

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