<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/workerTalkForm/gridDataCustom.do",
                colNames: ['ID',
                    '工程名称',
                    '谈话单位1',
                    '谈话单位2',
//                    '谈话事由',
                    '谈话时间',
                    '签发时间',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "projectName", width: "55", align: "left", searchtype: "string", sortable: true},
                    {name: "unitName1", width: "40", align: "left", searchtype: "string", sortable: true},
                    {name: "unitName2", width: "40", align: "left", searchtype: "string", sortable: true},
//                    {name: "content", width: "57", align: "left", searchtype: "string", sortable: true},
                    {name: "talkTime", width: "40", align: "center", searchtype: "datetime", sortable: true,
                        formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y年m月d日 H 时'}},
                    {name: "signDate", width: "30", align: "center", searchtype: "date", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "执法管理谈话通知书列表",
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
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "号", "op": "cn", "data": ""},
                    { "field": "谈话单位1", "op": "cn", "data": ""},
                    { "field": "谈话单位2", "op": "cn", "data": ""},
                    { "field": "谈话事由", "op": "cn", "data": ""},
                    { "field": "谈话时间", "op": "bw", "data": ""},
                    { "field": "签发时间", "op": "cn", "data": ""},
                    { "field": "签发人", "op": "cn", "data": ""},
                    { "field": "内部谈话人", "op": "cn", "data": ""},
                    { "field": "携带材料", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看执法管理谈话通知书", "${ctx}/workerTalkForm/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加执法管理谈话通知书", "${ctx}/workerTalkForm/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改执法管理谈话通知书", "${ctx}/workerTalkForm/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/workerTalkForm/delete.do?id=" + id);
    }
    </c:if>

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
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>