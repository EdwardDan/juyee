<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/planDetail/selectProjectGridData.do?id=${id}&tabType=${tabType}",
                colNames: ['FID',
                    '监督任务编号',
                    '报建编号',
                    '建设单位',
                    <c:if test="${tabType==danger}">
                    '开始日期',
                    '结束日期',
                    </c:if>
                    <c:if test="${tabType==leaving}">
                    "最后监督时间",
                    </c:if>
                    <c:if test="${(tabType==all)||(tabType==nothing)}">
                    '报监日期',
                    </c:if>
                    '项目名称',
//                    '项目地点',
                    '操作'
                ],
                colModel: [
                    {name: "fid", width: "50", align: "center", searchtype: "string", sortable: true, hidden: true},
                    {name: "t.jd_task_code", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "t.bjbh", width: "35", align: "center", searchtype: "string", sortable: true},
                    {name: "t.JS_UNIT_NAME", width: "55", align: "center", searchtype: "string", sortable: true},
                    <c:if test="${tabType==danger}">
                    {name: "t.START_DATETIME", width: "40", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    {name: "t.END_DATETIME", width: "40", align: "center", searchtype: "date", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d', newformat: 'Y-m-d'}},
                    </c:if>
                    <c:if test="${tabType==leaving}">
                    {name: "T.time", width: "40", align: "center", searchtype: "date", sortable: true,formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    </c:if>
                    <c:if test="${(tabType==all)||(tabType==nothing)}">
                    {name: "t.jd_datetime", width: "35", align: "center", searchtype: "date", sortable: true,formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    </c:if>
                    {name: "t.project_name", width: "90", align: "left", searchtype: "string", sortable: true}
//                    {name:"t.project_add",width:"100",align:"left",searchtype:"string",sortable:true}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "",
                jsonReader: {
                    repeatitems: true,
                    cell: "",
                    id: "0"
                },
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#planDetailGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#planDetailGrid").jqGrid('getRowData', id);
                        var opButton = '';
                        if (rowData["t.jd_task_code"] != "") {
                            opButton += "<input type='button' value='选择' onclick='doSelect(this,\"" + rowData["t.jd_task_code"] + "\")' class='button_normal'> ";
                            opButton += "<input type='button' value='查看' onclick='doView(this,\"" + rowData["t.jd_task_code"] + "\")' class='button_normal'>";
                        }
                        jQuery("#planDetailGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "监督任务编号", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
//                    { "field": "报监日期", "op": "bt", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#planDetailGrid"), conf, "#planDetailDiv");
        var obj = $("div.gridQueryArea");
//        $("#planDetailGrid").setGridWidth(obj.width()-5);
//        var h = $($("#planDetailGrid")[0].grid.bDiv).height();
//        var h = $("#gbox_planDetailGrid");
//        $($("#planDetailGrid")[0].grid.bDiv).height(h.height()-150);

        $("#planDetailGrid").setGridWidth(obj.width());
        var h = $($("#planDetailGrid")[0].grid.bDiv).height();
        $($("#planDetailGrid")[0].grid.bDiv).height(h - 72);
    });

    function doSelect(btn, id) {
        var flagF = false;
        $.ajax({
            url: "${ctx}/planDetail/checkSelectProjectGridData.do?jdTaskCode=" + id + "&planMainInfoId=${id}" + "&tabType=${tabType}",
            async: false,
            data: "",
            contentType: "application/json; charset=utf-8",
            success: function (flag) {
                if (flag == "true") {
                    flagF = true;
                    $.messager.confirm("系统提示", "规定日期内已有监督计划，是否选择？", function (r) {
                        if (r) {
                            btn.value = "已选择";
                            btn.disabled = true;
                            openWindow("请说明原因", "${ctx}/planDetail/msgSelectProjectGridData?id=" + id, false, 300, 200);
                        }
                    });
                }
            }
        });
        if (!flagF) {
            parent.loadProjectData(id, "", "");
            btn.value = "已选择";
            btn.disabled = true;
        } else {
            return null;
        }
    }
    function doView(btn, jdTaskCode) {
        viewProjectInfo('查看项目信息', '', null, jdTaskCode, true, true);
    }
</script>

<div id="planDetailDiv">
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
                <input type="button" value="关闭" class="button_cancel"
                       onclick="parent.closeWindow('selectWindow')"/>
            </div>
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="planDetailGrid"></table>
        <div id="pager2"></div>
    </div>
</div>