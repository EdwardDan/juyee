<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/safeProductCheck/gridDataCustom.do",
                colNames: ['ID',
                    '项目名称',
                    '工地编号',
                    '施工单位',
//                    '监理单位',
//                    '年份',
                    '考核季度',
//                    '总分',
//                    '情况说明',
//                    '整改单数量',
//                    '暂缓单数量',
//                    '处罚数量',
//                    '其他数量',
//                    '确认等级中文描述',
//                    '企业应到现场检查次数',
//                    '企业实到现场检查次数',
//                    '状态',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "projectName", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "gdCode", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "sgdwmc", width: "50", align: "left", searchtype: "string", sortable: true},
//                    {name: "jldwmc", width: "38", align: "center", searchtype: "string", sortable: true},
//                    {name: "year", width: "38", align: "center", searchtype: "integer", sortable: true},
                    {name: "examQuarter", width: "20", align: "center", searchtype: "string", sortable: true}
//                    {name: "totalScore", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "content", width: "38", align: "center", searchtype: "string", sortable: true},
//                    {name: "reformNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "stopformNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "punishNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "otherNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "levelDesc", width: "38", align: "center", searchtype: "string", sortable: true},
//                    {name: "planCheckNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "actualCheckNum", width: "38", align: "center", searchtype: "integer", sortable: true},
//                    {name: "status", width: "38", align: "center", searchtype: "integer", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 25, align: 'center'}
                ],
                pager: '#pager2',
                caption: "安全生产季度考核列表",
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
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "工地编号", "op": "cn", "data": ""},
                    { "field": "施工单位", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看安全生产季度考核", "${ctx}/safeProductCheck/view.do?id=" + id, false, 900, 550);
    }
    <c:if test="${canEdit}">
    function doEdit(id) {
        openWindow("修改安全生产季度考核", "${ctx}/safeProductCheck/modify.do?id=" + id, true, 900, 550);
    }
    function doSelect() {
        openWindow("选择考核季度", "${ctx}/safeProductCheck/count.do", true, 350, 200);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/safeProductCheck/delete.do?id=" + id);
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
                <input type="button" value="添加" class="button_add" onclick="doSelect()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>考核季度:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="gridYear" class="input-elm">
                    <option value="">==请选择==</option>
                    ${yearOptions}
                </select>年
                <select name="gridQuarter" class="input-elm">
                    <option value="">==请选择==</option>
                    ${quarterOptions}
                </select>
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>