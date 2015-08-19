<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function ()
    {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaWorkWatchSum/gridDataCustom.do",
                colNames: [
                    '汇总年月',
                    '汇总时间',
                    '操作'
                ],
                colModel: [
                    {name: "yearMonth", width: "88", align: "center", searchtype: "string", sortable: true},
                    {name: "hzTime", width: "88", align: "center", searchtype: "string", sortable: true},
                    {name: "queryItems", width: "30", align: "center", searchtype: "string", formatter: customeFormat}
                ],
                pager: '#pager2',
                caption: "工作督办汇总列表",
                shrinkToFit: true,
                rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "汇总年月", "op": "cn", "data": ""}
                    ]
                },
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    var TAB_NO="${tab}";
    function doView(queryItems)
    {
        parent.openWindow("查看工作督办汇总", "${ctx}/oaWorkWatchSum/view.do?queryItems=" + queryItems, false,700,450,TAB_NO);
    }
    <c:if test="${canEdit}">
    function doDelete(items)
    {
        doGridDelete("${ctx}/oaWorkWatchSum/delete.do?ids=" + items);
    }
    </c:if>

    //custom formatter
    function customeFormat(cellvalue, options, rowObject)
    {
        var button = '<input type="button" value="查看" onclick="doView(\'' + cellvalue + '\')" class="button_normal"/>';
        <c:if test="${canEdit}">
        button += ' <input type="button" value="删除" onclick="doDelete(\'' + cellvalue + '\')" class="button_normal"/>';
        </c:if>
        return button;

    }
    function doThisQuery(btn) {
        var beginTime = "";
        if ('' != $("#year").val()) {
            beginTime = $("#year").val()
        }
        var endTime = "";
        if ('' != $("#month").val()) {
            endTime = $("#month").val()
        }
        var v = "<beginTime>" + beginTime + "</beginTime><endTime>" + endTime + "</endTime>";
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'queryJson': v}
                }).trigger('reloadGrid');
    }
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="text" name="year" id="year" value="" class="input_date"/>年
            <input type="text" name="month" id="month" value="" class="input_date"/>月
            <input type="button" value="查询" class="btn_Search" onclick="doThisQuery(this)"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">

        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>