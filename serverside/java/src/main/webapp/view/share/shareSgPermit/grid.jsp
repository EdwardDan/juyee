<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
                    gridOpts: {
                        url: "${ctx}/shareSgPermit/gridDataCustom.do?curDate=${curDate}",
                        colNames: [
                            'ID',
                            '报建编号',
                            '标段号',
                            '项目名称',
                            '施工单位',
                            '签证日期',
                            '操作'
                        ],
                        colModel: [
                            {name: 'id', width: 10, align: "center", searchtype: "string", hidden: true},
                            {name: "bjbh", width: "20", align: "center", searchtype: "string", sortable: true},
                            {name: "bdh", width: "10", align: "center", searchtype: "string", hidden: true},
                            {name: "pro_name", width: "40", align: "left", searchtype: "string", sortable: true},
                            {name: "sg_zb_unit", width: "40", align: "left", searchtype: "string", sortable: true},
                            {name: 'issue_datetime', width: "20", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}}
                        ],
                        actModel: [
                            {name: 'operation', width: 20, align: 'center'}
                        ],
                        pager: '#pager2',
                        caption: "发放施工许可",
                        jsonReader: {
                            repeatitems: true,
                            cell: "",
                            id: "0"
                        },
                        shrinkToFit: true,
                        gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                            var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                            for (var i = 0; i < ids.length; i++) {
                                var id = ids[i];
                                var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                                var bjbh = rowData['bjbh'];
                                var bdh = rowData['bdh'];
                                var opButton = '<input type="button" value="查看" onclick="doView(' + "'" + bjbh + "'" + "," + "'" + bdh + "'" + ')" class="button_normal"/> ';
                                jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                            }
                        },
                        rownumbers: true
                    },
                    userOpts: {
                        defaultQuery: {
                            "groupOp": "AND", "rules": [
                                { "field": "报建编号", "op": "cn", "data": ""},
                                { "field": "项目名称", "op": "cn", "data": ""},
                                { "field": "施工单位", "op": "cn", "data": ""},
                                { "field": "签证日期", "op": "bt", "data": ""}
                            ]
                        },
                        queryButton: $("#queryButton"),
                        queryDesc: $("#queryConditionDesc")
                    },
                    isExportExcel: true
                };
        gridinit($("#listGrid"), conf);
    });

    function doView(bjbh, bdh) {
        openWindow("查看发放施工许可", "${ctx}/shareSgPermit/view.do?bjbh=" + bjbh + "&bdh=" + bdh, false);
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
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>