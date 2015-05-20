<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projRelatePerson/gridDataCustomForPrjRelatePerson.do?personId=${personId}",
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
                pager: '#pager4',
                caption: "单位所属人员承担项目列表",
                jsonReader: {
                    repeatitems: true,
                    cell: "",
                    id: "0"
                },
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid4").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = "";
                        <c:if test="${canEdit}">
//                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid4").jqGrid('setRowData', ids[i], { operation: opButton});
//                        $(".ui-jqgrid-bdiv").height(260);  //重新设置grid高度
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": []},
                queryButton: $("#queryButton4"),
                queryDesc: $("#queryConditionDesc4")
            }
        };
        gridinit($("#listGrid4"), conf);
    });

    <c:if test="${canEdit}">
    function doAddPrj(button) {
        removeRepeatOption(document.getElementById("personPrjInfo"));
        $.ajax({
            type: "POST",
            url: "${ctx}/projRelatePerson/savePrjRelatePerson.do",
            data: {personId: "${personId}", projectIds: $("#personPrjInfoIds").val()},
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    showInfoMsg(data.msg);
                    refreshGrid("listGrid4");
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

    function doDelete(id) {
        doGridDelete("${ctx}/projRelatePerson/deletePrjRelatePerson.do?id=" + id);
    }
    </c:if>

    function doQuery(ele) {
        var year = ele != null ? $("#yearQuery").val() : $("#yearQuery").val("").val();
        var piName = ele != null ? $("#piNameQuery").val() : $("#piNameQuery").val("").val();
        jQuery("#listGrid4").jqGrid('setGridParam', {postData: {'year': year, 'piName': piName}}).trigger('reloadGrid');
    }

</script>

<div style="width: 1050px">
    <div class="title_Search">
        <div class="gridQueryArea">
            <div style="float:left;padding-left: 10px" id="conditionsDesc4">
                年份：<input type="text" name="yearQuery" id="yearQuery" value="" class="input_text">
                项目名称：<input type="text" name="piNameQuery" id="piNameQuery" value="" class="input_text">
            </div>
            <div style="float: right;padding-right: 10px;">
                <input type="button" value="查询" class="btn_Search" style="text-align: left" onclick="doQuery(this)">&nbsp;
                <input type="button" value="重置" class="btn_Search" style="text-align: left" onclick="doQuery()">&nbsp;
                <c:if test="${canEdit}">
                    <select multiple="multiple" id="personPrjInfo" name="personPrjInfo"
                            style="display:none;width:250px;height:110px;">${personPrjInfoOptions}</select>
                    <input type="button" value="添加" title="点击添加单位下属承担项目" class="button_add"
                           onclick="multiSelectUnitPrjs('personPrjInfo', 'personPrjInfoIds', '', doAddPrj)"/>
                    <input type="hidden" id="personPrjInfoIds" name="personPrjInfoIds" value=""/>
                </c:if>
            </div>
        </div>
    </div>
    <div class="gridQueryTable">
        <table id="listGrid4"></table>
        <div id="pager4"></div>
    </div>
</div>
