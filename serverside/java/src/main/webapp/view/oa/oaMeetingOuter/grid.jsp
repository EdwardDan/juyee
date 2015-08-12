<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMeetingOuter/gridDataCustom.do",
                colNames: ['ID',
                    '会议名称',
                    '会议开始时间',
//                    '会议时间',
//                    '会议开始时间',
//                    '会议结束时间',
                    '会议地点',
                    '附件',
                    '会议状态',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "beginTime", width: "30", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i'}},
//                    {name: "meetTime", width: "60", align: "center", searchtype: "string", sortable: false},
//                    {name: "beginTime", width: "40", align: "center", searchtype: "date", sortable: true, hidden: true},
//                    {name: "endTime", width: "40", align: "center", searchtype: "date", sortable: true, hidden: true},
                    {name: "address", width: "40", align: "left", searchtype: "string", sortable: true},
                    {name: "docButton", width: "15", align: "center", sortable: false},
                    {name: "statusName", width: "25", align: "center", searchtype: "String", sortable: false},
                    {name: "statusCode", width: "5", align: "center", searchtype: "integer", sortable: true, hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "外出会议列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["statusCode"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
                            if (status == '${STATUS_EDIT}' || '' == status || status == '${STATUS_MAIN_BACK}' || status == '${STATUS_BRANCH_BACK}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                        }
                        if (${canEdit_FG}) {
                            if (status == '${STATUS_SUBMIT}') {
                                opButton += '<input type="button" value="分管领导审核" onclick="doAudit(' + id + ')" class="button_normal_longer"/> ';
                            }
                        }
                        if (${canEdit_ZR}) {
                            if (status == '${STATUS_BRANCH_PASS}') {
                                opButton += '<input type="button" value="主要领导审核" onclick="doAudit(' + id + ')" class="button_normal_longer"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "会议名称", "op": "cn", "data": ""},
                    { "field": "会议开始时间", "op": "bt", "data": ""},
                    { "field": "会议地点", "op": "cn", "data": ""},
                    { "field": "会议地点", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看外出会议", "${ctx}/oaMeetingOuter/view.do?id=" + id, false);
    }
    function doAdd() {
        openWindow("添加外出会议", "${ctx}/oaMeetingOuter/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改外出会议", "${ctx}/oaMeetingOuter/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaMeetingOuter/delete.do?id=" + id);
    }
    function doAudit(id) {
        openWindow("审核外出会议", "${ctx}/oaMeetingOuter/audit.do?id=" + id, true);
    }
    function doThisQuery(btn) {
        var beginTime = "";
        if ('' != $("#start").val()) {
            beginTime = $("#start").val()
        }
        var endTime = "";
        if ('' != $("#end").val()) {
            endTime = $("#end").val()
        }
        var v = "<beginTime>" + beginTime + "</beginTime><endTime>" + endTime + "</endTime><status>" + $("#status").val() + "</status>";
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'queryJson': v}
                }).trigger('reloadGrid');
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
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
        <div style="float:right;padding-right: 10px">
            <%--起始日期：<input type="text" name="start" id="start" value="" class="input_date"--%>
                        <%--onClick="calendar('start','start');"/>--%>
            <%--结束日期：<input type="text" name="end" id="end" value="" class="input_date"--%>
                        <%--onClick="calendar('end','end');"/>--%>
            状态：
            <select name="status" id="status" class="form_select_long" style="width:120px; ">
                <option value="" selected>全部</option>
                ${statusList}
            </select>
            <input type="button" value="查询" class="btn_Search" onclick="doThisQuery(this)"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>