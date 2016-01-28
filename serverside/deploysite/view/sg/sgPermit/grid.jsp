<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/sgPermit/gridDataCustom.do",
                colNames: ['ID',
                    "绿色",
                    "项目性质",
                    '业务编号',
                    '报建编号',
                    '项目名称',
//                    '字号',
                    '项目类型',
                    '建设单位',
//                    '申请人',
//                    '申请号',
                    '状态code',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 5, align: "center", searchtype: "integer", hidden: true},
                    {name: "isGreen", width: "5", align: "center", searchtype: "string", sortable: true},
                    {name: "propertyType.id", width: "5", align: "center", searchtype: "string", hidden: true},
                    {name: "bizCode", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "bjbh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "35", align: "left", searchtype: "string", sortable: true},
                    {name: "projectType.name", width: "15", align: "center", searchtype: "string", sortable: true},
                    {name: "buildName", width: "35", align: "left", searchtype: "string", sortable: true},
                    {name: "status", width: "5", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    <c:if test="${isReg}">
                    {name: "statusNameBJ", width: "20", align: "center", searchtype: "string", sortable: true}
                    </c:if>
                    <c:if test="${!isReg}">
                    {name: "statusName", width: "20", align: "center", searchtype: "string", sortable: true}
                    </c:if>
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "施工许可证列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if ('' == status || status == '${STATUS_EDIT}' || status == '${STATUS_SLZX_BACK}' || status == '${STATUS_CS_BACK}' || status == '${STATUS_FH_BACK}' || status == '${STATUS_SH_BACK}' || status == '${STATUS_FGLD_BACK}' || status == '${STATUS_ZXLD_BACK}' || status == '${STATUS_WLD_BACK}') {
                            if (${canEdit||isReg}) {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_SUBMIT}') {
                            if (${canSlAudit}) {
                                opButton += '<input type="button" value="受理" onclick="doAccept(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_SLZX_PASS}') {
                            if (${canCsAudit}) {
                                opButton += '<input type="button" value="初审" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_CS_PASS}') {
                            if (${canFhAudit}) {
                                opButton += '<input type="button" value="复审" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_FH_PASS}') {
                            if (${canAudit}) {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_SH_PASS}') {
                            if (${canFgldAudit}) {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_FGLD_PASS}') {
                            if (${canZxldAudit}) {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        } else if (status == '${STATUS_ZXLD_PASS}') {
                            if (${canWldAudit}) {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        opButton += '<input type="button" value="操作步骤" onclick="doOperation(' + id + ')" class="button_normal_long"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "业务编号", "op": "cn", "data": ""},
                        {"field": "报建编号", "op": "cn", "data": ""},
                        {"field": "项目名称", "op": "cn", "data": ""},
                        {"field": "项目类型", "op": "cn", "data": ""},
                        {"field": "建设单位", "op": "cn", "data": ""},
                        {"field": "申请人", "op": "cn", "data": ""},
                        {"field": "申请号", "op": "cn", "data": ""}
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
        openWindow("查看施工许可证", "${ctx}/sgPermit/frame.do?act=view&id=" + id, false, 850, 500);
    }
    function doAdd() {
        openWindow("选择项目类型", "${ctx}/sgPermit/selectProjectType.do", true, 400, 200);
    }
    function doEdit(id) {
        openWindow("修改施工许可证", "${ctx}/sgPermit/frame.do?act=edit&id=" + id, true, 850, 500);
    }
    function doAccept(id) {
        openWindow("受理施工许可证", "${ctx}/sgPermit/frame.do?act=accept&id=" + id, true, 850, 500);
    }
    function doAudit(id) {
        openWindow("审核施工许可证", "${ctx}/sgPermit/frame.do?act=audit&id=" + id, true, 850, 500);
    }
    function doOperation(id) {
        loadMainPage("${ctx}/sgPermitOperation/grid.do?sgPermitId=" + id, "审查备案 > 施工许可管理 > 日志");
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sgPermit/delete.do?id=" + id);
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
            <c:if test="${canEdit||isReg}">
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>
