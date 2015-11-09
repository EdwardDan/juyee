<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/sgPermit/gridDataCustom.do",
                colNames: ['ID',
                    '年',
                    '报建编号',
                    '项目名称',
                    '建设单位',
                    '沪交管收字_年',
                    '沪交管收字_号',
                    '申请人',
                    '申请事项',
                    '申请号',
                    '材料提交人',
                    '材料提交人联系电话',
                    '材料提交人联系地址',
                    '收件人',
                    '收件人联系电话',
                    '状态',
                    '初审意见',
                    '复核意见',
                    '审核意见',
                    '分管领导审核意见',
                    '中心领导审核意见',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "33", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}},
                    {name: "bjbh", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "buildName", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "hYear", width: "33", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}},
                    {name: "hNum", width: "33", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}},
                    {name: "applyPerson", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "applyMatter", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "applyNum", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "materialPerson", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "materialPersonPhone", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "materialPersonAddress", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "receivePerson", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "receivePersonPhone", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "status", width: "33", align: "center", searchtype: "integer", sortable: true, formatter: 'integer', formatoptions: {thousandsSeparator: ",", defaulValue: 0}},
                    {name: "csOpinion", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "fhOpinion", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "shOpinion", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "fgldOpinion", width: "33", align: "center", searchtype: "string", sortable: true},
                    {name: "zxldOpinion", width: "33", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "施工许可证列表",
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
                    { "field": "年", "op": "cn", "data": ""},
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""},
                    { "field": "沪交管收字_年", "op": "cn", "data": ""},
                    { "field": "沪交管收字_号", "op": "cn", "data": ""},
                    { "field": "申请人", "op": "cn", "data": ""},
                    { "field": "申请事项", "op": "cn", "data": ""},
                    { "field": "申请号", "op": "cn", "data": ""},
                    { "field": "材料提交人", "op": "cn", "data": ""},
                    { "field": "材料提交人联系电话", "op": "cn", "data": ""},
                    { "field": "材料提交人联系地址", "op": "cn", "data": ""},
                    { "field": "收件人", "op": "cn", "data": ""},
                    { "field": "收件人联系电话", "op": "cn", "data": ""},
                    { "field": "状态", "op": "cn", "data": ""},
                    { "field": "初审意见", "op": "cn", "data": ""},
                    { "field": "复核意见", "op": "cn", "data": ""},
                    { "field": "审核意见", "op": "cn", "data": ""},
                    { "field": "分管领导审核意见", "op": "cn", "data": ""},
                    { "field": "中心领导审核意见", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看施工许可证", "${ctx}/sgPermit/view.do?id=" + id, false);
    }
    function doAdd() {
        openWindow("选择项目类型", "${ctx}/sgPermit/selectProjectType.do", true, 400, 200);
    }
    function doEdit(id) {
        openWindow("修改施工许可证", "${ctx}/sgPermit/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sgPermit/delete.do?id=" + id);
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
                <input type="button" value="添加" class="button_add" onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>