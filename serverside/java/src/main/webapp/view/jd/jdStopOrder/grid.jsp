<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script src="${ctx}/js/jquery/easyui/outlook2.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/jdStopOrder/gridDataCustom.do?formCode=${formCode}&code=${code}",
                colNames: ['ID',
                    '责任主体',
                    '工程名称',
                    '复查单位',
                    '整改期限',
                    '签发日期',
                    '表单类别',
                    '状态code',
                    '行政措施单状态',
                    '整改回复单状态code',
                    '整改回复单状态',
                    '操作',
                    '整改回复'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "dutyDept", width: "70", align: "left", searchtype: "string", sortable: true},
                    {name: "projectName", width: "60", align: "left", searchtype: "string", sortable: true},
                    {name: "recheckDept", width: "40", align: "left", searchtype: "string", sortable: true},
                    {name: "reformLimit", width: "35", align: "center", searchtype: "date", sortable: true},
                    {name: "signDate", width: "35", align: "center", searchtype: "date", sortable: true},
                    {name: "formCode", width: "5", align: "center", searchtype: "string", hidden: true},
                    {name: "status", width: "20", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "45", align: "center", searchtype: "string", sortable: true},
                    {name: "replyStatus", width: "20", align: "center", searchtype: "integer", hidden: true},
                    {name: "replyStatusName", width: "45", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 75, align: 'center'},
                    {name: 'reply', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "${formName}列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var rowDataCell = rowData["status"]; // 状态code
                        var replyStatus = rowData["replyStatus"]; //整改回复单状态code
                        var formCode = rowData["formCode"];
                        /*整改回复按钮*/
                        var replyButton = '';
                        /*操作按钮*/
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/>';
                        if (${canEdit}) {
                            if ('${EDIT}' == rowDataCell) {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/>';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                            if ("reform" != formCode && "" != formCode) {
                                opButton += '<input type="button" value="复工单" onclick="doRecoverForm(' + id + ')" class="button_normal_long"/>';
                            }
                            if (replyStatus == '${STATUS_SUBMIT}') {
                                replyButton += '<input type="button" value="初审回复单" onclick="doCheck(' + id + ')" class="button_normal_long"/> ';
                            } else if (replyStatus == '${STATUS_FIRST_PASS}') {
                                replyButton += '<input type="button" value="复审回复单" onclick="doCheck(' + id + ')" class="button_normal_long"/> ';
                            } else if (replyStatus == '${STATUS_FIRST_BACK}' || replyStatus == '${STATUS_BACK}') {
                                replyButton += '<input type="button" value="查看回复单" onclick="doCheckView(' + id + ')" class="button_normal_long"/> '
                            }

                            <%--if ((replyStatus == '${STATUS_SUBMIT}') || (replyStatus == '${STATUS_FIRST_PASS}')) {--%>
                            <%--replyButton += '<input type="button" value="审核回复单" onclick="doCheck(' + id + ')" class="button_normal_long"/> ';--%>
                            <%--} else if (replyStatus == '${STATUS_BACK}' || replyStatus == '${STATUS_FIRST_BACK}') {--%>
                            <%--replyButton += '<input type="button" value="审核回复单" onclick="doCheckView(' + id + ')" class="button_normal_long"/> ';--%>
                            <%--}--%>
                        } else if (!${canEdit} && !${isSGUser}) {
                            replyButton += '<input type="button" value="查看回复单" onclick="doCheckView(' + id + ')" class="button_normal_long"/> ';
//                            replyButton += '<input type="button" value="审核回复单" onclick="doCheckView(' + id + ')" class="button_normal_long"/> ';
                        }

                        if (${isSGUser}) {
                            if (replyStatus == '${STATUS_EDIT}' || replyStatus == '${STATUS_FIRST_BACK}') {
                                replyButton += '<input type="button" value="整改回复单" onclick="doReform(' + id + ')" class="button_normal_long"/> ';
                            } else {
                                replyButton += '<input type="button" value="查看回复单" onclick="doReformView(' + id + ')" class="button_normal_long"/> ';
                            }
                        } else if (!${isSGUser} && !${canEdit}) {
                            replyButton += '<input type="button" value="整改回复单" onclick="doReformView(' + id + ')" class="button_normal_long"/> ';
                        } else if (${canEdit}){
                            replyButton += '<input type="button" value="整改回复单" onclick="doReply(' + id + ')" class="button_normal_long"/> ';
                        }
                        <%--if (${isSGUser}) {--%>
                        <%--if (replyStatus == '${STATUS_SUBMIT}' || replyStatus == '${STATUS_FIRST_PASS}' || replyStatus == '${STATUS_BACK}') {--%>
                        <%--replyButton += '<input type="button" value="整改回复单" onclick="doReformView(' + id + ')" class="button_normal_long"/> ';--%>
                        <%--} else {--%>
                        <%--replyButton += '<input type="button" value="整改回复单" onclick="doReform(' + id + ')" class="button_normal_long"/> ';--%>
                        <%--}--%>
                        <%--} else if (!${isSGUser} && !${canEdit}) {--%>
                        <%--replyButton += '<input type="button" value="整改回复单" onclick="doReformView(' + id + ')" class="button_normal_long"/> ';--%>
                        <%--}--%>

                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton, reply: replyButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "责任主体", "op": "cn", "data": ""},
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "整改期限", "op": "bt", "data": ""},
                    { "field": "签发日期", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        parent.openWindow("查看${formName}", "${ctx}/jdStopOrder/view.do?id=" + id, false);
    }
    function doRecoverForm(id) {
        window.location.href = "${ctx}/jdRecoverForm/grid.do?stopId=" + id;
        <%--loadMainPage("${ctx}/jdRecoverForm/grid.do?stopId=" + id, "监督管理 >> ${formName} >> 复工通知单列表");--%>
    }
    function doReform(id) {
        parent.openWindow("整改回复单列表", "${ctx}/jdReformReply/commonLogin.do?id=" + id, true, 700, 450,"${tableNo}");
    }
    function doReformView(id) {
        parent.openWindow("查看整改回复单列表", "${ctx}/jdReformReply/reformView.do?id=" + id, true, 700, 450);
    }
    function doCheck(id) {
        parent.openWindow("整改回复单列表", "${ctx}/jdReformReply/modifyAduit.do?id=" + id, true, 700, 450,"${tableNo}");
    }
    function doCheckView(id) {
        parent.openWindow("查看整改回复单列表", "${ctx}/jdReformReply/checkView.do?id=" + id, true, 700, 450);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        parent.openWindow("添加${formName}", "${ctx}/jdStopOrder/add.do", true);
    }
    function doEdit(id) {
        parent.openWindow("修改${formName}", "${ctx}/jdStopOrder/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        parent.doGridDelete("${ctx}/jdStopOrder/delete.do?id=" + id);
    }
    function doReply(id) {
        parent.openWindow("建管署回复", "${ctx}/jdReformReply/reply.do?id=" + id, true, 700, 450, "${tableNo}");
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
            <%--<c:if test="${canEdit}">--%>
            <%--<input type="button" value="添加" class="button_add"--%>
            <%--onclick="doAdd()"/>--%>
            <%--</c:if>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>