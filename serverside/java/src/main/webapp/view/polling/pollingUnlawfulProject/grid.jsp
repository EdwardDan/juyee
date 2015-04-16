<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/pollingUnlawfulProject/gridDataCustom.do",
                colNames: ['ID',
                    '工程名称',
                    '建设单位',
                    '发现时间',
                    '立项申请',
                    '土地权证',
                    '规划许可',
                    '施工许可',
                    '坐标X',
                    '坐标Y',
//                    '处理状态',
                    "项目附件",
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "projectName", width: "47", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnit", width: "47", align: "left", searchtype: "string", sortable: true},
                    {name: "createTime", width: "29", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d ', newformat: 'Y-m-d '}},
                    {name: "isLx", width: "20", align: "center", searchtype: "integer", sortable: true, formatter: customeFormat},
                    {name: "isTdqz", width: "20", align: "center", searchtype: "integer", sortable: true, formatter: customeFormat},
                    {name: "isGhxk", width: "20", align: "center", searchtype: "integer", sortable: true, formatter: customeFormat},
                    {name: "isSgxk", width: "20", align: "center", searchtype: "integer", sortable: true, formatter: customeFormat},
//                    {name: "status.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "posX", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "posY", width: "30", align: "center", searchtype: "string", sortable: true} ,
                    {name: "projectDoc.id", width: "40", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "六无工地信息列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <%--<c:if test="${canEdit}">--%>
                        opButton += '<input type="button" value="修改" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="属地" onclick="doBelongArea(' + id + ')" class="button_normal"/>';
                        opButton += '<input type="button" value="坐标" onclick="doMap(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/> ';
                        <%--</c:if>--%>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "工程名称", "op": "cn", "data": ""},
                    { "field": "建设单位", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看六无工地信息", "${ctx}/pollingUnlawfulProject/view.do?id=" + id, false);
    }
    function doEdit(id) {
        openWindow("修改六无工地信息", "${ctx}/pollingUnlawfulProject/modify.do?id=" + id, true);
    }
    function doAdd(id) {
        openWindow("修改六无工地信息", "${ctx}/pollingUnlawfulProject/add.do?id=" + id, true);
    }
    function doMap(id) {
        var url = "${ctx}/pollingUnlawfulProject/map.do?id=" + id;
        openFullWindow(url, 900, 600, "修改地图信息")
    }
    function doBelongArea(id) {
        openWindow("修改属地信息", "${ctx}/pollingUnlawfulProject/belongArea.do?id=" + id, true, 600, 400);
    }
    function customeFormat(cellvalue, options, rowObject) {
        return cellvalue == "true" ? "有" : "无";
    }
    function doDelete(id) {
        doGridDelete("${ctx}/pollingUnlawfulProject/delete.do?id=" + id);
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
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>