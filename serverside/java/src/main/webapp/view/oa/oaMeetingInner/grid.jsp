<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMeetingInner/gridDataCustom.do",
                colNames: ['ID',
                    '会议议题',
                    '会议时间',
                    '会议开始时间',
                    '会议结束时间',
                    '会议地点',
                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "title", width: "66", align: "left", searchtype: "string", sortable: true},
                    {name: "meetTime", width: "75", align: "center", searchtype: "datetime", sortable: true},
                    {name: "beginTime", width: "40", align: "center", searchtype: "date", sortable: true, hidden: true},
                    {name: "endTime", width: "40", align: "center", searchtype: "date", sortable: true, hidden: true},
                    {name: "address", width: "66", align: "left", searchtype: "string", sortable: true},
                    {name: "docDown", width: "30", align: "center"}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "内部会议列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "会议议题", "op": "cn", "data": ""},
                        {"field": "会议地点", "op": "cn", "data": ""}
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
        openWindow("查看内部会议", "${ctx}/oaMeetingInner/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加内部会议", "${ctx}/oaMeetingInner/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改内部会议", "${ctx}/oaMeetingInner/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaMeetingInner/delete.do?id=" + id);
    }
    </c:if>

    function doThisQuery(btn) {
        var beginTime = "";
        if ('' != $("#start").val()) {
            beginTime = $("#start").val();
        }
        var endTime = "";
        if ('' != $("#end").val()) {
            endTime = $("#end").val();
        }
        var v = "<beginTime>" + beginTime + "</beginTime><endTime>" + endTime + "</endTime>";
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'queryJson': v}
                }).trigger('reloadGrid');
    }
    function resetDate() {
        document.getElementById("start").value = "";
        document.getElementById("end").value = "";
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
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
        <div style="float:left;padding-right: 10px">
            起始日期：<input type="text" name="start" id="start" value="" class="input_datetime"
                        style="width: 120px"
                        onClick="calendar('start','start');"/>
            结束日期：<input type="text" name="end" id="end" value="" class="input_datetime"
                        style="width: 120px"
                        onClick="calendar('end','end');"/>
            <input type="button" value="重置" class="button_all" onclick="resetDate()"/>
            <input type="button" value="查询" class="btn_Search" onclick="doThisQuery(this)"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>