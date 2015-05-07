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
                    {name: 'pi.name', width: 140, align: "left", searchtype: "string", sortable: true},
                    {name: 'spname', width: 60, align: "center", searchtype: "string", sortable: true},
                    {name: 'office_tel', width: 80, align: "center", searchtype: "string", sortable: true},
                    {name: 'mobile', width: 80, align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
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
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
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
             queryButton: $("#queryButton3"),
             queryDesc: $("#queryConditionDesc3")
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
    function doAdd() {
        openWindow("添加承担项目", "${ctx}/projRelateDept/add2.do", true);
    }

    function doEdit(id) {
        openWindow("修改承担项目明细", "${ctx}/projRelateDept/modify2.do?id=" + id, true);
    }

    function doDelete(id) {
        doGridDelete("${ctx}/projRelateDept/delete2.do?id=" + id);
    }
    </c:if>

    function doQuery() {
        var year = $("#yearQuery").val();
        var piName = $("#piNameQuery").val();
        var spname = $("#spnameQuery").val();
        var officetel = $("#officetelQuery").val();
        var mobile = $("#mobileQuery").val();
        jQuery("#listGrid3").jqGrid('setGridParam',{postData: {'year': year, 'piName': piName, 'spname': spname, 'officetel': officetel, 'mobile': mobile}}).trigger('reloadGrid');
    }

</script>

<div style="width: 100%">
    <div class="title_Search">
        <div class="gridQueryArea">
            <div style="float:left;padding-left: 10px" id="conditionsDesc3">
                年份：<input type="text" name="yearQuery" id="yearQuery" value="" style="width: 6%" class="input_text">
                项目名称：<input type="text" name="piNameQuery" id="piNameQuery" value="" style="width: 13%"
                            class="input_text">
                项目负责人姓名：<input type="text" name="spnameQuery" id="spnameQuery" value="" style="width: 8%"
                               class="input_text">
                项目负责人座机：<input type="text" name="officetelQuery" id="officetelQuery" value="" style="width: 13%"
                               class="input_text">
                项目负责人手机：<input type="text" name="mobileQuery" id="mobileQuery" value="" style="width: 13%"
                               class="input_text">
                <input type="button" value="查询" class="btn_Search" style="text-align: left" onclick="doQuery()">&nbsp;
            </div>
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="listGrid3"></table>
        <div id="pager3"></div>
    </div>
</div>