<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projInfo/gridDataCustom.do",
                colNames: ['ID',
                    '项目序号',
                    '项目编号',
                    '项目名称',
                    '所属区县',
                    '项目阶段',
                    '业态类别',
                    '工可批复总投资（亿元）',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "no", width: "30", align: "center", searchtype: "string", sortable: true, hidden: true},
                    {name: "projNum", width: "30", align: "center", searchtype: "string", sortable: true, hidden: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "areaCode", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "gkpfTotalInvest", width: "30", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 40, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目基本信息管理列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var stageName = rowData["stage.name"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        if (stageName == '未开工') {
                            //判断项目阶段的高亮显示（删除列时注意修改）
                            $("#" + id).find("td:eq(6)").css("background-color", " #f08080");
                        } else if (stageName == '在建') {
                            $("#" + id).find("td:eq(6)").css("background-color", "#add8e6");
                        } else if (stageName == '已完工') {
                            $("#" + id).find("td:eq(6)").css("background-color", "#90ee90");
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "项目编号", "op": "cn", "data": ""},
                        {"field": "项目名称", "op": "cn", "data": ""}
                    ]
                },
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目基本信息", "${ctx}/projInfo/view.do?id=" + id, false, 900, 500);
    }
    function doAdd() {
        openWindow("添加项目基本信息", "${ctx}/projInfo/add.do", true, 900, 500);
    }
    function doEdit(id) {
        openWindow("修改项目基本信息", "${ctx}/projInfo/modify.do?id=" + id, true, 900, 500);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projInfo/delete.do?id=" + id);
    }

    function viewBidInfoFormat1(cellvalue, options, rowObject) {
        var title = "查看办证推进标段（" + rowObject["name"] + "）";
        return "<a href='javascript:void(0)' onclick=loadBidInfoFormat('" + title + "','" + rowObject["id"] + "','${TYPE_STAGE}',true,false) class='grid_link'>" + cellvalue + "</a>";
    }
    function viewBidInfoFormat2(cellvalue, options, rowObject) {
        var title = "查看形象进度标段（" + rowObject["name"] + "）";
        return "<a href='javascript:void(0)' onclick=loadBidInfoFormat('" + title + "','" + rowObject["id"] + "','${TYPE_NODE}',true,false) class='grid_link'>" + cellvalue + "</a>";
    }
    function loadBidInfoFormat(title, projInfoId, typeCode, isParentWindow, isOpenNewWindow) {
        var url = "${ctx}/projInfo/viewBid.do?id=" + projInfoId + "&typeCode=" + typeCode;
        var windowId = isOpenNewWindow ? "newWinId" : null;
        if (isParentWindow) {
            parent.openNewWindow(windowId, title, url, false);
        } else {
            openNewWindow(windowId, title, url, false);
        }
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
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>管理属性:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projproperty" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="propertyL" items="${propertyList}">
                        <option value="${propertyL.name}">${propertyL.name}</option>
                    </c:forEach>
                </select>
                <select name="ismajor" class="form_select" style="width: 75px;">
                    <option value="">请选择</option>
                    <option value="1">重大</option>
                    <option value="0">非重大</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>项目状态:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projstage" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="projinfostage" items="${projinfostageList}">
                        <option value="${projinfostage.name}">${projinfostage.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>业务类别:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projcategory" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="projinfocategory" items="${projinfocategoryList}">
                        <option value="${projinfocategory.name}">${projinfocategory.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>
