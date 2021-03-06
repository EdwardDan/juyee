<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projExtend/gridDataCustom.do?flag=${flag}&msg=${msg}&qdType=${qdType}",
                colNames: ['ID',
                    '填报年份',
                    '项目序号',
                    '项目编号',
                    '项目名称',
                    <c:if test="${flag!='qqdj'}">
                    '项目性质',
                    </c:if>
                    <c:if test="${flag=='qqdj'}">
                    '所属区县',
                    </c:if>
                    '项目阶段',
                    '业态类别',
                    "工可总投资（亿元）",
                    "年度累计完成额",
                    "本年计划完成率（%）",
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "10", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "no", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projNum", width: "25", align: "center", searchtype: "string", sortable: true, hidden: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    <c:if test="${flag!='qqdj'}">
                    {name: "property.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    </c:if>
                    <c:if test="${flag=='qqdj'}">
                    {name: "areaCode", width: "20", align: "center", searchtype: "string", sortable: true},
                    </c:if>
                    {name: "stage.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "gctxGkpfTotal", width: "35", align: "right", searchtype: "string", sortable: false},
                    {name: "accCost", width: "30", align: "right", searchtype: "string", sortable: false},
                    {name: "costRate", width: "35", align: "center", searchtype: "string", sortable: false}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager2',
                caption: "${titleName}",
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
                        </c:if>
                        if (stageName == '未开工') {
                            //判断项目阶段的高亮显示（删除列时注意修改）
                            $("#" + id).find("td:eq(7)").css("background-color", " #f08080");
                        } else if (stageName == '在建') {
                            $("#" + id).find("td:eq(7)").css("background-color", "#add8e6");
                        } else if (stageName == '已完工') {
                            $("#" + id).find("td:eq(7)").css("background-color", "#90ee90");
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], {operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: {
                    "groupOp": "AND", "rules": [
                        {"field": "填报年份", "op": "eq", "data": ""},
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
        openWindow("查看${qdName}", "${ctx}/projExtendQuestion/view.do?projectId=" + id + "&qdType=${qdType}", false);
    }
    <c:if test="${canEdit}">
    function doEdit(id) {
        openWindow("填报${qdName}", "${ctx}/projExtendQuestion/input.do?projectId=" + id + "&qdType=${qdType}", true);
    }
    function doSum() {
        openWindow("${qdName}汇总页面", "${ctx}/projExtendQuestion/doSum.do?qdType=${qdType}&flag=${flag}&msg=${msg}", false, 1000, 550);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projExtend/delete.do?projectId=" + id);
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
                <input type="button" value="${qdName}汇总" class="button_normal_longer" onclick="doSum()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>项目性质:&nbsp;</td>
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
