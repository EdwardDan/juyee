<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/planDetail/gridDataCustom.do?planMainInfoId=${bean.id}",
                colNames: ['ID',
                    '监督任务编号',
                    '报建编号',
                    '建设单位',
//                    '监督组',
                    '计划完成日期',
                    '实际完成日期',
                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "jdTaskCode", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "bjbh", width: "40", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnitName", width: "70", align: "left", searchtype: "string", sortable: true},
//                    {name:"group.name",width:"30",align:"center",searchtype:"string",sortable:true},
                    {name: "planEndTime", width: "30", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
                    {name: "planActTime", width: "30", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
                    {name: "status.name", width: "15", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 70, align: 'center'}
                ],
                pager: '#pager2',
                caption: "执行任务列表（${bean.planName}）",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var jdTaskCode = rowData["jdTaskCode"];
                        var opButton = '';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="填报监督记录" onclick="doEdit(' + id + ",'" + jdTaskCode + "'" + ')" class="button_normal_long"/> ';
                        </c:if>
                        <c:if test="${isPermitAudit}">
                        opButton += '<input type="button" value="取消任务" onclick="doCancel(' + id + ')" class="button_normal_long"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
//                    { "field":"流转编号", "op":"cn", "data":""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""}
//                    { "field":"计划完成日期", "op":"bw", "data":""},
//                    { "field":"实际完成日期", "op":"bw", "data":""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doEdit(id, jdTaskCode) {
//        var planParam = "<detailId>"+id+"</detailId>";
        <%--var taskParam = "<typeCode>${bean.planType.code}</typeCode><typeId>${bean.planType.id}</typeId><referId>"+id+"</referId>";--%>
        <%--openWindow("填报监督记录", "${ctx}/jdRecord/init.do?formClass=${formClass}&action=add&taskParam=" + taskParam, true, 1000, 550);--%>
        openWindow("选择填报监督记录", "${ctx}/planDetail/select.do?planDetailId="+id+"&jdTaskCode=" + jdTaskCode + "&typeCode=${bean.planType.code}", true, 350, 200);
    }
    function doCancel(id) {
        doGridDelete("${ctx}/planDetail/cancelPlan.do?planDetailId=" + id, "确定要取消此任务吗");
    }
    function doBack() {
        loadAjaxData("mainContent", "${ctx}/planMainInfo/grid.do?flag=${flag}");
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
            <input type="button" value="返回" class="button_back"
                   onclick="doBack()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>