<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/jdJlReport/gridDataCustom.do",
                colNames: [
                    'ID',
                    '报建编号',
                    '工程名称',
                    '监理单位',    //暂时不知道从哪获取监理单位
                    '最后一次提交时间',
                    '上传次数',
//                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "long", hidden: true},
                    {name: "bjbh", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "100", align: "left", searchtype: "string", sortable: false},
                    {name:"jlDept",width:"50",align:"left",searchtype:"string",sortable:false},
                    {name: "reportTime", width: "50", align: "center", searchtype: "date", sortable: false, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'}},
                    {name: "reportCount", width: "50", align: "center", searchtype: "string", sortable: false}
//                    {name: "docButton", width: "30", align: "center", searchtype: "integer", sortable: false}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "监理报告列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${isJLDW}">
                        opButton += '<input type="button" value="填报" onclick="doAdd()" class="button_normal"/> ';
                        </c:if>
                        <c:if test="${isJLDW||canEdit}">
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "最后一次提交时间", "op": "bt", "data": ""}
//                    { "field": "备注", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看监理报告", "${ctx}/jdJlReport/view.do?id=" + id, false, 800, 500);
    }
    <c:if test="${canEdit||isJLDW}">
    function doAdd() {
        openWindow("选择工程报建编号", "${ctx}/jdCommon/selectJdTaskCode.do?url=jdJlReport/add.do&title="+encodeURI('添加监理报告'), true, 600, 300);

        <%--openWindow("添加监理报告", "${ctx}/jdJlReport/add.do", true, 800, 500);--%>
    }
    function doEdit(id) {
        openWindow("修改监理报告", "${ctx}/jdJlReport/modify.do?id=" + id, true, 800, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/jdJlReport/delete.do?id=" + id);
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
            <c:if test="${isJLDW}">
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