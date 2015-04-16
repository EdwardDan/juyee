<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>

<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/jdRecoverForm/gridDataCustom.do?stopId=${stopId}",
                colNames: ['ID',
                    '序号',
                    '年份',
                    '责任主体',
                    '工程名称',
                    '整改起始时间',
                    '恢复施工时间',
//                    '签发单位',
//                    '签发人',
//                    '签发日期',
                    '状态ID',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "orderNo", width: "20", align: "center", searchtype: "integer", sortable: true},
                    {name: "year", width: "20", align: "center", searchtype: "integer", sortable: true},
                    {name: "dutyDept", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "reformBeginDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
                    {name: "recoverDate", width: "40", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
//                    {name: "signDept", width: "53", align: "center", searchtype: "string", sortable: true},
//                    {name: "signPerson", width: "53", align: "center", searchtype: "string", sortable: true},
//                    {name: "signDate", width: "53", align: "center", searchtype: "date", sortable: true},
                    {name: "status", width: "30", align: "center", searchtype: "integer", hidden: true},
                    {name: "statusName", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "安全质量监督--(${formName})的复工通知单列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);//获取该行所有数据
                        var rowDataCell = rowData["status"];

                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        if (rowDataCell != '${STATUS_SUBMIT}') {
                            opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        }
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "年份", "op": "cn", "data": ""},
                    { "field": "序号", "op": "cn", "data": ""},
                    { "field": "责任主体", "op": "cn", "data": ""},
                    { "field": "整改起始时间", "op": "bt", "data": ""},
                    { "field": "恢复施工时间", "op": "bt", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看安全质量监督--复工通知单", "${ctx}/jdRecoverForm/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加安全质量监督--复工通知单", "${ctx}/jdRecoverForm/add.do?stopId=${stopId}", true);
    }
    function doEdit(id) {
        openWindow("修改安全质量监督--复工通知单", "${ctx}/jdRecoverForm/modify.do?id=" + id + "&stopId=${stopId}", true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/jdRecoverForm/delete.do?id=" + id);
    }
    </c:if>
    function jumpJdStopOrderGrid() {
        window.location.href = "${ctx}/jdStopOrder/grid.do?formCode=${fromCode}";
        <%--loadMainPage("${ctx}/jdStopOrder/grid.do?formCode=${fromCode}", "监督管理 >> ${formName}");--%>
    }

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
        <div style="float:right;padding-right: 10px">
            <input type="button" value="返回" class="button_back" onclick="jumpJdStopOrderGrid()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>