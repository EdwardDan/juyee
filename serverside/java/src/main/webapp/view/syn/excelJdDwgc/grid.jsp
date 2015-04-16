<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/excelJdDwgc/gridDataCustom.do",
                colNames: ['ID',
                    '工程名称',
                    '项目地点',
                    '项目报监日期',
                    '单位工程名称',
                    '虹口区单位工程编号',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name:"projectName",width:"65",align:"left",searchtype:"string",sortable:false},
                    {name:"projectAdd",width:"70",align:"left",searchtype:"string",sortable:false},
                    {name:"jdDateTime",width:"30",align:"center",searchtype: "date", sortable: false, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d'}},
                    {name: "dwgcName", width: "65", align: "left", searchtype: "string", sortable: true},
                    {name: "customCode", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "监督单位工程列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <%--<c:if test="${canEdit}">--%>
                        <%--opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';--%>
                        <%--opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';--%>
                        <%--</c:if>--%>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
//                    { "field": "工程名称", "op": "cn", "data": ""},
//                    { "field": "项目地点", "op": "cn", "data": ""},
//                    { "field": "项目报监日期", "op": "cn", "data": ""},
                    { "field": "单位工程名称", "op": "cn", "data": ""},
                    { "field": "虹口区单位工程编号", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看监督单位工程", "${ctx}/excelJdDwgc/view.do?id=" + id, false,800,500);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加监督单位工程", "${ctx}/excelJdDwgc/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改监督单位工程", "${ctx}/excelJdDwgc/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/excelJdDwgc/delete.do?id=" + id);
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
        <%--<div style="float:right;padding-right: 10px">--%>
            <%--<c:if test="${canEdit}">--%>
                <%--<input type="button" value="添加" class="button_add"--%>
                       <%--onclick="doAdd()"/>--%>
            <%--</c:if>--%>
        <%--</div>--%>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>