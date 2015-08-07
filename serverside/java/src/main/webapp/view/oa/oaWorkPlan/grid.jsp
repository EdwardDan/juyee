<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaWorkPlan/gridDataCustom.do",
                colNames: ['ID',
                    '上报科室',
//                '上报人用户名',
                    '提交人',
//            	'上报人姓名',
                    '工作时间',
//            	'上报开始时间',
//            	'上报结束时间',
//            	'附件ID(预留)',
                    '状态值',
                    '状态',
//                    '科长审核意见',
//                    '科长审核时间',
//                    '科长审核用户名',
//                    '分管领导审核意见',
//                    '分管领导审核时间',
//                    '分管领导审核用户名',
//                    '创建时间',
//                    '创建用户名',
//                    '更新时间',
//                    '更新用户名',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportDept", width: "47", align: "center", searchtype: "string", sortable: true},
//                    {name:"reportUser",width:"47",align:"center",searchtype:"string",sortable:true},
                    {name: "reportPerson", width: "47", align: "center", searchtype: "string", sortable: true},
//                    {name:"beginDate",width:"47",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
                    {
                        name: "workTime",
                        width: "47",
                        align: "center",
                        searchtype: "date",
                        sortable: true,
                        formatter: 'date',
                        formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}
                    },
//                    {name:"documentId",width:"47",align:"center",searchtype:"string",sortable:true},
                    {name: "status", width: "47", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "47", align: "center", searchtype: "string", sortable: true},
//                    {name:"kzOpinion",width:"47",align:"center",searchtype:"string",sortable:true},
//                    {name:"kzAuditTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"kzAuditUser",width:"47",align:"center",searchtype:"string",sortable:true},
//                    {name:"fgOpinion",width:"47",align:"center",searchtype:"string",sortable:true},
//                    {name:"fgAuditTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"fgAuditUser",width:"47",align:"center",searchtype:"string",sortable:true},
//                    {name:"createTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"createUser",width:"47",align:"center",searchtype:"string",sortable:true},
//                    {name:"updateTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//                    {name:"updateUser",width:"47",align:"center",searchtype:"string",sortable:true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "科室工作周上报列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
//                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            if (status == '${STATUS_EDIT}' || '' == status || status == '${STATUS_MAIN_BACK}' || status == '${STATUS_BRANCH_BACK}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                        }
                        if (${canEdit_FG||canEdit_ZR}) {
                            if (status == '${STATUS_SUBMIT}' || status == '${STATUS_BRANCH_PASS}' && status != "") {
                                opButton += '<input type="button" value="审核" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "上报科室", "op": "cn", "data": ""},
//                        {"field": "上报人用户名", "op": "cn", "data": ""},
                        {"field": "上报人姓名", "op": "cn", "data": ""},
                        {"field": "上报开始时间", "op": "cn", "data": ""},
                        {"field": "上报结束时间", "op": "cn", "data": ""},
//                        {"field": "附件ID(预留)", "op": "cn", "data": ""},
                        {"field": "状态", "op": "cn", "data": ""},
//                        {"field": "科长审核意见", "op": "cn", "data": ""},
//                        {"field": "科长审核时间", "op": "bw", "data": ""},
//                        {"field": "科长审核用户名", "op": "cn", "data": ""},
//                        {"field": "分管领导审核意见", "op": "cn", "data": ""},
//                        {"field": "分管领导审核时间", "op": "bw", "data": ""},
//                        {"field": "分管领导审核用户名", "op": "cn", "data": ""},
//                        {"field": "创建时间", "op": "bw", "data": ""},
//                        {"field": "创建用户名", "op": "cn", "data": ""},
//                        {"field": "更新时间", "op": "bw", "data": ""},
//                        {"field": "更新用户名", "op": "cn", "data": ""}
                    ]
                },
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看科室工作周上报", "${ctx}/oaWorkPlan/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加科室工作周上报", "${ctx}/oaWorkPlan/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改科室工作周上报", "${ctx}/oaWorkPlan/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaWorkPlan/delete.do?id=" + id);
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