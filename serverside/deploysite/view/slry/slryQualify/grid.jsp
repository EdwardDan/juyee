<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/slryQualify/gridDataCustom.do",
                colNames: ['ID',
                    '企业名称',
                    '企业类型',
                    '姓名',
                    '性别',
                    '出生日期',
                    '证件号码',
                    '学历',
                    '技术职称',
                    '申请类型',
                    '申请证书类型',
                    '状态值',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "unitName", width: "53", align: "center", searchtype: "string", sortable: true},
                    {name: "unitType.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "30", align: "left", searchtype: "string", sortable: true},
                    {name: "sex", width: "10", align: "center", searchtype: "integer", sortable: true, formatter: boolFormat},
                    {name: "birthDate", width: "40", align: "center", searchtype: "date", sortable: true},
                    {name: "idCard", width: "63", align: "right", searchtype: "string", sortable: true},
                    {name: "educationType.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "techType.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "applyType.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "applyCerType.name", width: "60", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "42", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "25", align: "center", searchtype: "string", sortable: false}
                ],
                actModel: [
                    {name: 'operation', width: 50, align: 'center'}
                ],
                pager: '#pager2',
                caption: "三类人员列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
                            if (status == '${STATUS_EDIT}' || status == '${STATUS_BACK}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                            if (status == '${STATUS_SUBMIT}') {
                                opButton += '<input type="button" value="审核" onclick="doAudit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "企业名称", "op": "cn", "data": ""},
                        {"field": "企业类型", "op": "cn", "data": ""},
                        {"field": "姓名", "op": "cn", "data": ""},
                        {"field": "出生日期", "op": "cn", "data": ""},
                        {"field": "证件号码", "op": "cn", "data": ""},
                        {"field": "学历", "op": "cn", "data": ""},
                        {"field": "技术职称", "op": "cn", "data": ""},
                        {"field": "状态", "op": "cn", "data": ""},
                        {"field": "申请类型", "op": "cn", "data": ""},
                        {"field": "申请证书类型", "op": "cn", "data": ""}
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
        openWindow("查看三类人员", "${ctx}/slryQualify/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加三类人员", "${ctx}/slryQualify/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改三类人员", "${ctx}/slryQualify/modify.do?id=" + id, true);
    }
    function doAudit(id) {
        openWindow("审核三类人员", "${ctx}/slryQualify/audit.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/slryQualify/delete.do?id=" + id);
    }
    </c:if>
    //过滤查询数据
    function loadThisGridBySearch() {
        jQuery("#listGrid").jqGrid('setGridParam', {
            postData: {'status': $("#status1").val()}
        }).trigger('reloadGrid');
    }
    function boolFormat(cellvalue, options, rowObject) {
        return cellvalue == "true" ? "男" : "女";
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
            <td class="columns" style='width: 18%;' nowrap>状态:&nbsp;</td>
            <td class="data">
                <select name="status1" id="status1" class="form_select" style="width: 80px;"
                        onchange="loadThisGridBySearch()">
                    <option value="">请选择</option>
                    ${option}
                </select>
            </td>
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" id="otherConditions">
        <div style="float:right;padding-right: 10px">
            <td class="columns" style='width: 20%;' nowrap>&nbsp;&nbsp;性别:&nbsp;</td>
            <td class="data">
                <select name="sex" id="sex" class="form_select" style="width: 80px;">
                    <option value="">请选择</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </div>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>