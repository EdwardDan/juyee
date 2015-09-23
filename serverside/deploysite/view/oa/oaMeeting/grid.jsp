<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMeeting/gridDataCustom.do",
                colNames: ['ID',
                    '申请会议室',
                    '会议召开时间',
//                    '会议召开日期',
                    '申请人',
                    '申请科室',
                    '会议主题',
                    '状态',
                    '状态code',
                    '创建人',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "room.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "useTime", width: "20", align: "center", searchtype: "string", sortable: true},
//                    {name: "useDate", width: "0", align: "center", searchtype: "date", sortable: true, hidden: true/*, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}*/},
                    {name: "applyPerson", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "applyDept", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "title", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "statusName", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "5", align: "center", searchtype: "string", hidden: true},
                    {name: "createUser", width: "20", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "会议管理列表",
                shrinkToFit: true,
                gridComplete: function () {
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var createUser = rowData["createUser"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (status == ${STATUS_EDIT} || status == ${STATUS_BACK}) {
                            <c:if test="${canEdit}">
                            if (createUser == '${currentUser}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            } else {
                                <c:if test="${canDelete}">
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                                </c:if>
                            }
                            </c:if>
                        }
                        if (status == ${STATUS_SUBMIT}) {
                            <c:if test="${canAudit}">
                            opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            </c:if>
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "申请科室", "op": "cn", "data": ""},
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "申请会议室", "op": "cn", "data": ""},
//                    { "field": "会议召开时间", "op": "cn", "data": ""},
                    { "field": "会议主题", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });

    function doView(id) {
        openWindow("查看会议申请", "${ctx}/oaMeeting/view.do?id=" + id, false);
    }

    function doAdd() {
        openWindow("申请会议室", "${ctx}/oaMeeting/add.do", true);
    }

    function doEdit(id) {
        openWindow("修改会议申请", "${ctx}/oaMeeting/modify.do?id=" + id, true);
    }

    function doAudit(id) {
        openWindow("审核", "${ctx}/oaMeeting/beforeAudit.do?id=" + id, true, 800, 500);
    }

    <c:if test="${canEdit}">
    function doDelete(id) {
        doGridDelete("${ctx}/oaMeeting/delete.do?id=" + id);
    }
    </c:if>
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
            <input type="button" value="申请" class="button_add" onclick="doAdd()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <%--<table id="otherConditions" class="ui-widget ui-widget-content" style="border: 0 none; display: none; width: 100%">--%>
        <%--<tr>--%>
            <%--<td class="first"></td>--%>
            <%--<td class="columns" style="width: 15%;" nowrap>会议召开时间: &nbsp;</td>--%>
            <%--<td class="operators" style="display: none">=</td>--%>
            <%--<td class="data">--%>
                <%--<input type="text" name="useDateFrom" class="input_text" onclick="WdatePicker()" style="width: 30%;height: 100%" readonly/> ----%>
                <%--<input type="text" name="useDateTo" class="input_text" onclick="WdatePicker()" style="width: 30%;height: 100%" readonly/>&nbsp;&nbsp;--%>
                <%--<select id="useTime1" name="useTime1" class="input-elm" style="float:right;margin-right:4%">--%>
                    <%--<option value=""></option>--%>
                    <%--<option value="上午">上午</option>--%>
                    <%--<option value="下午">下午</option>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>