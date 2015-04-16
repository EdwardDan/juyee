<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaLeaveApply/gridDataCustom.do",
                colNames: ['ID',
                    '申请部门',
                    '申请人',
                    '创建人',
                    '申请日期',
                    '请假起始时间',
                    '状态',
                    '状态code',
                    '分管领导',
                    '领导',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "reportDept", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "reportPerson", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "createUser", width: "15", align: "center", searchtype: "string", hidden: true},//创建人，用于权限设置
                    {name: "reportDate", width: "15", align: "center", searchtype: "date", sortable: true},
                    {name: "durationTime", width: "25", align: "left", searchtype: "string", sortable: true},
                    {name: "statusName", width: "20", align: "center", searchtype: "string", sortable: false},
                    {name: "status", width: "5", align: "center", searchtype: "integer", hidden: true},
                    {name:"officeAuditUser",width:"20",align:"center",searchtype:"string", hidden: true},//分管领导用户名，用于权限设置
                    {name:"leaderAuditUser",width:"20",align:"center",searchtype:"string", hidden: true} //领导用户名，用于权限设置
                ],
                actModel: [
                    {name: 'operation', width: 20, align: 'center'}
                ],
                pager: '#pager2',
                caption: "请假单列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["status"];
                        var createUser = rowData["createUser"]; //获取每一行创建人
                        var leaderAuditUser = rowData["leaderAuditUser"];  //获取每行的领导姓名
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canLeaderAudit}">
                        if (statusCode == ${STATUS_SUBMIT}) {
                            if(leaderAuditUser=='${currentUser}'||''==leaderAuditUser){
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        </c:if>
                        <c:if test="${canEdit}">
                        if (statusCode == ${STATUS_EDIT} || statusCode == ${STATUS_BACK_LEADER}) {
                            if (createUser == '${currentUser}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            } else {   //不是当前登录用户时，判断其是否有强制删除权限
                                <c:if test="${canDelete}">
                                opButton += '<input type="button" value="删除"  onclick="doDelete(' + id + ')" class="button_normal"/>';
                                </c:if>
                            }
                        }
                        else { <c:if test="${canDelete}">//管理员对自己申请的东西具有强制删除权限
                            opButton += '<input type="button" value="删除"  onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "申请部门", "op": "cn", "data": ""},
                    { "field": "申请日期", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看请假单", "${ctx}/oaLeaveApply/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit|| canLeaderAudit}">
    function doAdd() {
        openWindow("添加请假单", "${ctx}/oaLeaveApply/add.do", true, 800, 500);
    }
    function doEdit(id) {
        openWindow("修改请假单", "${ctx}/oaLeaveApply/modify.do?id=" + id, true, 800, 500);
    }
    function doAudit(id) {
        openWindow("审核请假单", "${ctx}/oaLeaveApply/audit.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaLeaveApply/delete.do?id=" + id);
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

                <input type="button" value="申请" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>