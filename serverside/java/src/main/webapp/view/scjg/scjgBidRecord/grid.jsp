<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/scjgBidRecord/gridDataCustom.do",
                colNames: ['ID',
                    '流水号',
                    '报建编号',
//                    '标段号',
                    '项目名称',
                    '记录日期',
//                    '招标单位名称',
//                    '招标单位人员',
//                    '招标代理单位',
//                    '招标代理单位人员',
//                    '评标委员会人员',
//                    '监督记录',
//                    '处理意见',
                    '状态',
                    '监督类型',
                    '状态cd',
                    '经办人',
                    '复核人',
//                    '审核用户名',
//                    '审核时间',
//                    '审核意见',
//                    '创建时间',
//                    '创建用户名',
//                    '更新时间',
//                    '更新用户名',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "36", align: "center", searchtype: "string", sortable: true},
                    {name: "bjbh", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "bdh", width: "36", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "60", align: "center", searchtype: "string", sortable: true},
                    {name: "fillDate", width: "36", align: "center", searchtype: "date", sortable: true},
//                    {name: "bidDeptName", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "bidDeptPerson", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "bidDlDeptName", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "bidDlDeptPerson", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "bidCheckPerson", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "jdRecord", width: "36", align: "center", searchtype: "string", sortable: true},
                    {name: "statusName", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "jdStage.name", width: "36", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "36", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "jbr", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "fhr", width: "20", align: "center", searchtype: "string", sortable: true}
//                    {name: "auditUser", width: "36", align: "center", searchtype: "string", sortable: true}
//                    {name: "auditTime", width: "36", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
//                    {name: "auditOpinion", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "createTime", width: "36", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
//                    {name: "createUser", width: "36", align: "center", searchtype: "string", sortable: true},
//                    {name: "updateTime", width: "36", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
//                    {name: "updateUser", width: "36", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "招投标监管记录列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (statusCode == ${SCJG_BID_RECORD_FU_SHEN}) {
                            <c:if test ="${canAudit}" >
                            opButton += '<input type="button" value="复核" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        } else if ( statusCode == ${SCJG_BID_RECORD_TUI_HUI}) {
                            <c:if test ="${canEdit}" >
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        } else if (statusCode == ${SCJG_BID_RECORD_TONG_GUO}) {
                        }else if(statusCode == ${SCJG_BID_RECORD_TIAN_XIE}){
                            <c:if test ="${canEdit}" >
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            </c:if>
                        }
                        else {
                            <c:if test ="${canEdit}" >
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            </c:if>
                        }

                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "经办人", "op": "cn", "data": ""},
//                    { "field": "复核人", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "流水号", "op": "cn", "data": ""},
                    { "field": "标段号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
//                    { "field": "记录日期", "op": "cn", "data": ""},
                    { "field": "招标单位名称", "op": "cn", "data": ""},
//                    { "field": "招标单位人员", "op": "cn", "data": ""},
                    { "field": "招标代理单位", "op": "cn", "data": ""},
//                    { "field": "招标代理单位人员", "op": "cn", "data": ""},
//                    { "field": "评标委员会人员", "op": "cn", "data": ""},
//                    { "field": "监督记录", "op": "cn", "data": ""},
//                    { "field": "处理意见", "op": "cn", "data": ""},
//                    { "field": "状态", "op": "cn", "data": ""},
                    { "field": "审核用户名", "op": "cn", "data": ""}
//                    { "field": "审核时间", "op": "bw", "data": ""},
//                    { "field": "审核意见", "op": "cn", "data": ""},
//                    { "field": "创建时间", "op": "bw", "data": ""},
//                    { "field": "创建用户名", "op": "cn", "data": ""}
//                    { "field": "更新时间", "op": "bw", "data": ""},
//                    { "field": "更新用户名", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
//            }
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("招投标监督记录", "${ctx}/scjgBidRecord/view.do?id=" + id, false, 850, 520);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("招投标监督记录", "${ctx}/scjgBidRecord/add.do", true, 850, 520);
    }
    function doEdit(id) {

        openWindow("招投标监督记录", "${ctx}/scjgBidRecord/modify.do?id=" + id, true, 850, 520);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/scjgBidRecord/delete.do?id=" + id);
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