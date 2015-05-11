<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projRelateDept/gridDataCustom2.do?deptId=${deptId}",
                colNames: ['ID',
                    '年份',
                    '项目名称',
                    '项目负责人姓名',
                    '项目负责人座机',
                    '项目负责人手机',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: 'year', width: 30, align: "center", searchtype: "string", sortable: true},
                    {name: 'pi.name', width: 100, align: "left", searchtype: "string", sortable: true},
                    {name: 'spname', width: 50, align: "center", searchtype: "string", sortable: true},
                    {name: 'office_tel', width: 50, align: "center", searchtype: "string", sortable: true},
                    {name: 'mobile', width: 50, align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager3',
                caption: "单位承担项目列表",
                jsonReader: {
                    repeatitems: true,
                    cell: "",
                    id: "0"
                },
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid3").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = "";
                        <c:if test="${canEdit}">
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid3").jqGrid('setRowData', ids[i], { operation: opButton});
//                        $(".ui-jqgrid-bdiv").height(260);  //重新设置grid高度
                    }
                }, rownumbers: true
            },
            /*userOpts: {
             defaultQuery: { "groupOp": "AND", "rules": [
             { "field": "年份", "op": "cn", "data": ""},
             { "field": "项目名称", "op": "cn", "data": ""},
             { "field": "项目负责人姓名", "op": "cn", "data": ""},
             { "field": "项目负责人座机", "op": "cn", "data": ""},
             { "field": "项目负责人手机", "op": "cn", "data": ""}
             ]},
             }*/
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": []},
                queryButton: $("#queryButton3"),
                queryDesc: $("#queryConditionDesc3")
            }
        };
        gridinit($("#listGrid3"), conf);
    });

    <c:if test="${canEdit}">
    function doAddPrj(button) {
        removeRepeatOption(document.getElementById("unitPrjInfo"));
        $.ajax({
            type: "POST",
            url: "${ctx}/projRelateDept/savePrjRelateDept.do",
            data: {deptId: "${deptId}", projectIds: $("#unitPrjInfoIds").val()},
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    showInfoMsg(data.msg);
                    refreshGrid("listGrid3");
                } else {
                    showErrorMsg(data.msg);
                }
                button.disabled = false;
            },
            error: function (xmlR, status, e) {
                showErrorMsg("[" + e + "]" + xmlR.responseText);
                button.disabled = false;
            }
        });
    }

    <%--function doEdit(id) {--%>
    <%--openWindow("修改承担项目明细", "${ctx}/projRelateDept/modify2.do?id=" + id, true);--%>
    <%--}--%>

    function doDelete(id) {
        doGridDelete("${ctx}/projRelateDept/delete2.do?id=" + id);
    }
    </c:if>

    function doQuery(ele) {
        var year = ele != null ? $("#yearQuery").val() : $("#yearQuery").val("").val();
        var piName = ele != null ? $("#piNameQuery").val() : $("#piNameQuery").val("").val();
//        var spname = $("#spnameQuery").val();
//        var officetel = $("#officetelQuery").val();
//        var mobile = $("#mobileQuery").val();
        jQuery("#listGrid3").jqGrid('setGridParam', {postData: {'year': year, 'piName': piName/*, 'spname': spname, 'officetel': officetel, 'mobile': mobile*/}}).trigger('reloadGrid');
    }

</script>

<%--<div style="width: 100%">--%>
    <%--<div class="title_Search">--%>
        <%--<div class="gridQueryArea">--%>
            <%--<div style="float:left;padding-left: 10px" id="conditionsDesc3">--%>
                <%--报建编号：<input type="text" name="bjbhQuery" id="bjbhQuery" value="" style="width: 6%" class="input_text">--%>
                <%--工程名称：<input type="text" name="gdmcQuery" id="gdmcQuery" value="" style="width: 13%" class="input_text">--%>
                <%--建设单位：<input type="text" name="jsdwQuery" id="jsdwQuery" value="" style="width: 13%" class="input_text">--%>
                <%--施工单位：<input type="text" name="sgdwQuery" id="sgdwQuery" value="" style="width: 13%" class="input_text">--%>
                <%--<input type="button" value="查询" class="btn_Search" style="text-align: left" onclick="doQuery()">&nbsp;--%>
                <%--<input type="button" value="确定" class="button_confirm" style="text-align: left" onclick="doGdConfirm()">--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="gridQueryTable">--%>
        <%--<table id="listGrid3"></table>--%>
        <%--<div id="pager3"></div>--%>
    <%--</div>--%>
<%--</div>--%>

<div style="width: 100%">
    <div class="title_Search">
        <div class="gridQueryArea">
            <div style="float:left;padding-left: 10px" id="conditionsDesc3">
                年份：<input type="text" name="yearQuery" id="yearQuery" value="" class="input_text">
                项目名称：<input type="text" name="piNameQuery" id="piNameQuery" value="" class="input_text">
                <%--项目负责人姓名：<input type="text" name="spnameQuery" id="spnameQuery" value="" style="width: 8%"
                               class="input_text">
                项目负责人座机：<input type="text" name="officetelQuery" id="officetelQuery" value="" style="width: 8%"
                               class="input_text">
                项目负责人手机：<input type="text" name="mobileQuery" id="mobileQuery" value="" style="width: 8%"
                               class="input_text">--%>
            </div>
            <div style="float: right;padding-right: 10px;">
                <input type="button" value="查询" class="btn_Search" onclick="doQuery(this)">&nbsp;
                <input type="button" value="全部" class="btn_Search" onclick="doQuery()">&nbsp;
                <c:if test="${canEdit}">
                    <select multiple="multiple" id="unitPrjInfo" name="unitPrjInfo"
                            style="display:none;width:250px;height:110px;">${unitPrjInfoOptions}</select>
                    <input type="button" value="添加" title="点击添加单位承担项目" class="button_add"
                           onclick="multiSelectUnitPrjs('unitPrjInfo', 'unitPrjInfoIds', '', doAddPrj)"/>
                    <input type="hidden" id="unitPrjInfoIds" name="unitPrjInfoIds" value=""/>
                </c:if>
            </div>
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="listGrid3"></table>
        <div id="pager3"></div>
    </div>
</div>
