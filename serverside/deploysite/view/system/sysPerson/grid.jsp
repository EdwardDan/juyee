<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var urlOpt = "${ctx}/sysPerson/gridDataCustom" + "<c:choose><c:when test="${empty deptId}">.do</c:when><c:otherwise>2.do?deptId=${deptId}</c:otherwise></c:choose>";
        var conf = {
            gridOpts: {
                url: urlOpt,
                colNames: ['ID',
                    '编号',
                    '姓名',
                    '性别',
//                    '身份证号',
                    '移动电话',
//                    '固定电话',
                    '所属单位',
                    '所属部门',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "code", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "sex", width: "15", align: "center", searchtype: "integer", sortable: true, formatter: sexFormat},
//                    {name:"card",width:"50",align:"center",searchtype:"string",sortable:true,formatter:cardFormat},
                    {name: "mobile", width: "40", align: "center", searchtype: "string", sortable: true},
//                    {name:"officeTel",width:"40",align:"center",searchtype:"string",sortable:true},
                    {name: "company.name", width: "37", align: "center", searchtype: "string", sortable: true},
                    {name: "dept.name", width: "28", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 55, align: 'center'}
                ],
                pager: '#pager2',
                caption: "<c:if test="${not empty deptName}">${deptName}  </c:if>人员管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                        </c:if>
                        <c:if test="${canEditPro}">
                        opButton += '<input type="button" value="专业资质" onclick="doJdperson(' + id + ')" class="button_normal_long">';
                        </c:if>
                        <c:if test="${not empty deptId}">
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        opButton += '<input type="button" value="分配项目" onclick="doViewPrjChargedByPerson(' + id + ', \'' + rowData["name"] + '\', \'' + rowData["company.name"] + '\')" class="button_normal_long">';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "编号", "op": "cn", "data": ""},
                    { "field": "姓名", "op": "cn", "data": ""},
//                    { "field":"移动电话", "op":"cn", "data":""},
//                    { "field":"固定电话", "op":"cn", "data":""},
//                    { "field":"所属单位", "op":"cn", "data":""},
                    { "field": "所属部门", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });

    function doView(id) {
        openWindow("查看人员管理", "${ctx}/sysPerson/view.do?id=" + id, false);
    }

    function doViewPrjChargedByPerson(personId, personName, deptName) {
        openWindow("查看 " + deptName + " 下 " + personName + " 所承担的项目", "${ctx}/projRelatePerson/grid2.do?personId=" + personId, true, 1061, 531);
    }

    <c:if test="${canEdit}">
    function doAdd() {
        var addOpt = "<c:choose><c:when test="${empty deptId}">add.do</c:when><c:otherwise>add2.do?deptId=${deptId}&deptName=${deptName}</c:otherwise></c:choose>";
        openWindow("添加人员管理", "${ctx}/sysPerson/" + addOpt, true);
    }

    function doEdit(id) {
        var editOpt = "<c:choose><c:when test="${empty deptId}">modify.do?id=" + id + "</c:when><c:otherwise>modify2.do?deptId=${deptId}&deptName=${deptName}&id=" + id + "</c:otherwise></c:choose>";
        openWindow("修改人员管理", "${ctx}/sysPerson/" + editOpt, true);
    }

    function doDelete(id) {
        doGridDelete("${ctx}/sysPerson/delete.do?id=" + id);
    }

    function doJdperson(id) {
        loadMainPage("${ctx}/jdPersonSubject/grid.do?personid=" + id, "系统管理 >> 人事管理 >> 人员资质");
    }
    </c:if>
    //custom formatter
    function cardFormat(cellvalue, options, rowObject) {
        return cellvalue;
    }

    function sexFormat(cellvalue, options, rowObject) {
        if (cellvalue == "true") {
            return "男";
        } else if (cellvalue == "false") {
            return "女";
        } else {
            return "";
        }
    }

    function doBackForward(originalUrl, originalLocation) {
        loadMainPage(originalUrl, originalLocation);
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
                <c:if test="${not empty originalUrl && not empty deptId}">
                    <input type="button" value="返回" class="button_back"
                           onclick="doBackForward('${originalUrl}', '${originalLocation}')"/>
                </c:if>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap="nowrap">所属单位:&nbsp;</td>
            <td class="operators" style="display: none;">包含</td>
            <td class="data"><input type="text" name="unitName" style="width: 120px;" class="input-elm"></td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>