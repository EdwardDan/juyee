<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projRelateDept/gridDataCustom.do",
                colNames: ['ID',
                    '单位类型',
                    '单位名称',
                    '单位负责人',
                    '电话',
                    '传真',
                    '承担项目',
                    '下属人员',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: 'depttype', width: 25, align: "center", searchtype: "string", sortable: true, formatter: customFormat1},
                    {name: 'sd.name', width: 120, align: "left", searchtype: "string", sortable: true},
                    {name: 'manager', width: 35, align: "center", searchtype: "string", sortable: true},
                    {name: 'tel', width: 50, align: "center", searchtype: "string", sortable: true},
                    {name: 'fax', width: 50, align: "center", searchtype: "string", sortable: true},
                    {name: 'prjCharged', width: 30, align: "center", searchtype: "string", sortable: true, formatter: customFormat2},
                    {name: 'deptPersons', width: 25, align: "center", searchtype: "string", sortable: true, formatter: customFormat3}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目建设单位列表",
                jsonReader: {
                    repeatitems: true,
                    cell: "",
                    id: "0"
                },
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="详细" onclick="doView(' + id + ')" class="button_normal"/> ';
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
                    { "field": "单位名称", "op": "cn", "data": ""},
                    { "field": "单位负责人", "op": "cn", "data": ""},
                    { "field": "电话", "op": "cn", "data": ""},
                    { "field": "传真", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });

    function doView(id) {
        openWindow("查看项目建设单位明细", "${ctx}/projRelateDept/view.do?id=" + id, false);
    }

    function doViewPrjChargedByDept(deptId, deptName) {
        openWindow("查看" + deptName + "所承担的项目", "${ctx}/projRelateDept/gridForPrjRelateDept.do?deptId=" + deptId, true, 1061, 531);
    }

    function doViewDeptPersons(deptId, deptName) {
        loadMainPage("${ctx}/projRelatePerson/gridForDeptPersons.do?deptId=" + encodeURI(deptId) + "&deptName=" + encodeURI(deptName) + "&originalUrl=${ctx}/projRelateDept/grid.do&originalLocation=" + encodeURI("项目建设单位列表"), "建设单位 > 人员列表");
    }

    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目建设单位", "${ctx}/projRelateDept/add.do", true);
    }

    function doEdit(id) {
        openWindow("修改项目建设单位明细", "${ctx}/projRelateDept/modify.do?id=" + id, true);
    }

    function doDelete(id) {
        doGridDelete("${ctx}/projRelateDept/delete.do?id=" + id);
    }
    </c:if>

    function customFormat1(cellvalue, options, rowObject) {
        return cellvalue == null || cellvalue == "" ? "建设单位" : cellvalue;
    }

    function customFormat2(cellvalue, options, rowObject) {
        var deptid = rowObject[0];
        var deptName = rowObject[2];
        return "<a href='#' onclick='doViewPrjChargedByDept(" + deptid + ", \"" + deptName + "\")' class='grid_link'>" + "查看承担项目" + "</a>";
    }

    function customFormat3(cellvalue, options, rowObject) {
        var deptid = rowObject[0];
        var deptName = rowObject[2];
        return "<a href='javascript:void(0)' onclick='doViewDeptPersons(" + deptid + ", \"" + deptName + "\")' class='grid_link'>" + "查看下属人员" + "</a>";
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