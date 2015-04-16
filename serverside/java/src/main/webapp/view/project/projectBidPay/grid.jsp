<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projectBidPay/gridDataCustom.do?statusType=${statusType}",
                colNames: ['ID',
                    '报建编号',
                    '标段号',
                    '项目名称',
                    '建设单位',
                    '购买标书截至时间',
                    '投标保证金(元)',
                    '是否能录入',
                    "状态",
                    "状态code",
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "bdh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnit", width: "70", align: "left", searchtype: "string", sortable: true},
                    {name: "signLastDate", width: "37", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}},
                    {name: "signAccount",width:"25",align:"right",searchtype:"string",sortable:true},
                    {name: "canInput", width: "25", align: "center", searchtype: "string",hidden: true},
                    {name: "statusName", width: "25", align: "center", searchtype: "string", sortable: false},
                    {name: "statusCode", width: "5", align: "center", searchtype: "string", hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
//                caption: "招标登记列表11",
                caption:"${title}",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var statusCode = rowData["statusCode"];
                        var canInput = rowData["canInput"];
                        var opButton = '';
                        opButton += '<input type="button" class="button_normal" value="查看" onclick="doViewDS(' + id + ',' + "'" + statusCode + "'" + ')" /> ';
                        <c:if test="${canEdit}">
                        if ((statusCode == ${STATUS_DS}||statusCode==${STATUS_DJ})&& canInput == 'true') {
                            opButton += '<input type="button" class="button_normal_long"  value="保证金登记" onclick="doEditDS(' + id + ',' + "'" + statusCode + "'" + ')" /> ';
                        }
                        if (statusCode ==${STATUS_YQR}) {
                            opButton += '<input type="button" class="button_normal_long" value="退还保证金" onclick="doEditDT(' + id + ',' + "'" + statusCode + "'" + ')" />';
                        }

                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "标段号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""},
                    { "field": "购买标书截至时间", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doViewDS(id, statusCode) {
        var title;
        if (statusCode ==${STATUS_DS}) {
            title = "查看征收保证金";
        }
        else {
            title = "查看退还保证金"
        }
        parent.openWindow(title, "${ctx}/projectBidPay/view.do?statusType=" + statusCode + "&id=" + id, false, 1000, 525);
    }
    <c:if test="${canEdit}">
    function doEditDS(id, statusCode) {
        parent.openWindow("保证金登记", "${ctx}/projectBidPay/add.do?statusType=" + statusCode + "&projectId=" + id, true, 1000, 525, "tab1");
    }
    function doEditDT(id, statusCode) {
        parent.openWindow("退还保证金", "${ctx}/projectBidPay/add.do?statusType=" + statusCode + "&projectId=" + id, true, 1000, 525, "tab2");
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
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="listGrid"></table>
        <div id="pager2"></div>
    </div>
</div>