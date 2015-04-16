<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/scjgFilePetition/gridDataCustom.do",
                colNames: ['ID',
                    '编号',
                    '信访人',
                    '信访日期',
//                    '联系地址电话',
//                    '被反映单位地址',
//                    '投诉内容',
//                    '投诉来源ID',
//                    '投诉来源中文描述',
                    '收单日期',
                    '处理时限',
//                    '处理情况',
//                    '承办科室名称(多个逗号分隔)',
//                    '承办人姓名(多个逗号分隔)',
//                    '承办人用户名(多个逗号分隔)',
//                    '承办日期',
//                    '领导批示内容',
//                    '领导批示签字',
//                    '领导批示日期',
//                    '转至科室日期',
//                    '要求回复日期',
//                    '实际回复日期',
//                    '情况核查及分析',
//                    '信访人对处理情况态度',
//                    '备注',
                    '状态',
//                    '创建时间',
                    '附件下载',
//                    '创建用户名',
//                    '更新时间',
//                    '更新用户名',
//                    '是否提醒',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "26", align: "center", searchtype: "string", sortable: true},
                    {name: "person", width: "26", align: "center", searchtype: "string", sortable: true},
                    {name: "petitionDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "contactAddress", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "targetDept", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "fileContent", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "fileSourceId", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "fileSourceDesc", width: "26", align: "center", searchtype: "string", sortable: true},
                    {name: "receiveDate", width: "26", align: "center", searchtype: "date", sortable: true},
                    {name: "dealTime", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "dealOpinion", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "dealDeptNames", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "dealPerson", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "dealUsername", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "dealDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "leaderOpinion", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "leaderPerson", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "leaderDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "toDeptDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "requireReplyDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "actualReplyDate", width: "26", align: "center", searchtype: "date", sortable: true},
//                    {name: "caseAnalyze", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "caseAttitude", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "description", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "status", width: "26", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}}
                    {name: "status", width: "20", align: "center", searchtype: "string", sortable: true},

//                    {name: "createTime", width: "26", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: "createUser", width: "15", align: "center", searchtype: "string", sortable: true}
//                    {name: "updateTime", width: "26", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
//                    {name: "updateUser", width: "26", align: "center", searchtype: "string", sortable: true},
//                    {name: "isRemind", width: "26", align: "center", searchtype: "integer", sortable: true, formatter: booleanFormat}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "信访来件管理--信访列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];

                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>

                        var colorName = "${STATUS_EDIT_COLOR_NAME}";
                        if (rowDataCell == '${STATUS_INSTRUCT}') {
                            colorName = "${STATUS_INSTRUCT_COLOR_NAME}";
                        } else if (rowDataCell == '${STATUS_UNDERTAKE}') {
                            colorName = "${STATUS_UNDERTAKE_COLOR_NAME}";
                        } else if (rowDataCell == '${STATUS_END}') {
                            colorName = "${STATUS_END_COLOR_NAME}";
                        }

                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton, status: colorName});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "编号", "op": "cn", "data": ""},
                    { "field": "信访人", "op": "cn", "data": ""},
                    { "field": "信访日期", "op": "cn", "data": ""},
//                    { "field": "联系地址电话", "op": "cn", "data": ""},
//                    { "field": "被反映单位地址", "op": "cn", "data": ""},
//                    { "field": "投诉内容", "op": "cn", "data": ""},
//                    { "field": "投诉来源ID", "op": "cn", "data": ""},
//                    { "field": "投诉来源中文描述", "op": "cn", "data": ""},
                    { "field": "收单日期", "op": "cn", "data": ""},
                    { "field": "处理时限", "op": "cn", "data": ""}
//                    { "field": "处理情况", "op": "cn", "data": ""},
//                    { "field": "承办科室名称(多个逗号分隔)", "op": "cn", "data": ""},
//                    { "field": "承办人姓名(多个逗号分隔)", "op": "cn", "data": ""},
//                    { "field": "承办人用户名(多个逗号分隔)", "op": "cn", "data": ""},
//                    { "field": "承办日期", "op": "cn", "data": ""},
//                    { "field": "领导批示内容", "op": "cn", "data": ""},
//                    { "field": "领导批示签字", "op": "cn", "data": ""},
//                    { "field": "领导批示日期", "op": "cn", "data": ""},
//                    { "field": "转至科室日期", "op": "cn", "data": ""},
//                    { "field": "要求回复日期", "op": "cn", "data": ""},
//                    { "field": "实际回复日期", "op": "cn", "data": ""},
//                    { "field": "情况核查及分析", "op": "cn", "data": ""},
//                    { "field": "信访人对处理情况态度", "op": "cn", "data": ""},
//                    { "field": "备注", "op": "cn", "data": ""},
//                    { "field": "状态(填写/批示/承办/结束)", "op": "cn", "data": ""},
//                    { "field": "创建时间", "op": "bw", "data": ""},
//                    { "field": "创建用户名", "op": "cn", "data": ""},
//                    { "field": "更新时间", "op": "bw", "data": ""},
//                    { "field": "更新用户名", "op": "cn", "data": ""},
//                    { "field": "是否提醒", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看信访来件管理--信访", "${ctx}/scjgFilePetition/view.do?id=" + id, false, 800, 470);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加信访来件管理--信访", "${ctx}/scjgFilePetition/add.do", true, 800, 470);
    }
    function doEdit(id) {
        openWindow("修改信访来件管理--信访", "${ctx}/scjgFilePetition/modify.do?id=" + id, true, 800, 470);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/scjgFilePetition/delete.do?id=" + id);
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