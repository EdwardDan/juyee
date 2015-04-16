<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    var jdTitleName = "<c:choose><c:when test="${code=='quality'}">竣工验收监督</c:when><c:otherwise>现场踏勘监督</c:otherwise></c:choose>";
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/jdRecordComplete/gridDataCustom.do?code=${code}",
                colNames: ['ID',
                    '选择',  //单选项
                    '监督记录编号',
                    '报建编号',
                    '工程名称',
                    '监督负责人',
                    '监督日期',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "id", width: "10", align: "center", searchtype: "string", formatter: gridRadioFormat},   //单选项
                    {name: "code", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "bjbh", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "jdManager.name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "jdDatetime", width: "30", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    {name: "status", width: "20", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 35, align: 'center'}
                ],
                pager: '#pager2',
                caption: "质量安全监督记录（"+jdTitleName+"）列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];

                        var opButton = '<input type="button" value="查看" title="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        if (rowDataCell != '${STATUS_SUBMIT}') {
                            opButton += '<input type="button" value="编辑" title="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" title="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }
                        </c:if>
//                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});

                        var colorName = "${STATUS_EDIT_COLOR_NAME}";
                        if (rowDataCell == '${STATUS_SUBMIT}') {
                            colorName = "${STATUS_SUBMIT_COLOR_NAME}";
                        } else if (rowDataCell == '${STATUS_BACK}') {
                            colorName = "${STATUS_BACK_COLOR_NAME}";
                        } else if (rowDataCell == '${STATUS_PASS}') {
                            colorName = "${STATUS_PASS_COLOR_NAME}";
                        }

                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton, status: colorName});

                    }
                }, onSelectRow: function (ids) {
                    $('input:radio[name="radioId"]').each(function () {
                        if (this.value == ids) {
                            this.checked = true;
                        }
                    });
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "监督记录编号", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "监督负责人", "op": "cn", "data": ""},
                    { "field": "监督日期", "op": "bw", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);

        <%--loadJdGridButton('${jdTypeCode}');--%>
        loadJdGridButton('${jdTypeCode}','${code}');
    });
    var TAB_NO = "tab4";
    function doView(id) {
        parent.openWindow("查看"+jdTitleName+"记录", "${ctx}/jdRecordComplete/view.do?id=" + id, false, 900, 470);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        parent.openWindow("添加"+jdTitleName+"记录", "${ctx}/jdRecordComplete/add.do?jdcode=${code}", true, 900, 470, TAB_NO);
    }
    function doEdit(id) {
        parent.openWindow("修改"+jdTitleName+"记录", "${ctx}/jdRecordComplete/modify.do?jdcode=${code}&id=" + id, true, 900, 470, TAB_NO);
    }
    function doDelete(id) {
        parent.doGridDelete("${ctx}/jdRecordComplete/delete.do?id=" + id, null, {iframeId: TAB_NO});
    }
    </c:if>
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>

        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input_short"
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