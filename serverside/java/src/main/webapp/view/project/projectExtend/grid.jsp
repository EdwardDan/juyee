<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    .form_selects {
        width: 90px;
        height: 22px;
        border: 1px solid #b8b6b9;
    }
</style>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projectExtend/gridDataCustom.do",
                colNames: ['ID',
                    '报建编号',
                    '项目名称',
                    '建设地点',
                    '项目属地',
                    '坐标X',
                    '坐标Y',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "bjbh", width: "60", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName",align:"left", width: "150", searchtype: "string", sortable: true},
                    {name: "buildAddress",align:"left", width: "150", searchtype: "string", sortable: true},
                    {name: "belongArea", width: "100", align: "center", searchtype: "string", sortable: true},
                    {name: "posX", width: "50", align: "center", searchtype: "string", sortable: true},
                    {name: "posY", width: "50", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目扩展信息列表",
                shrinkToFit: true,
                jsonReader: {
                    repeatitems: true,
                    cell: "",
                    id: "0"
                },
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
//                        var opButton = '<input type="button" value="查看" onclick="doView(' + "'" + id + "'" + ')" class="button_normal"/> ';
                        var opButton ='';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="属地" onclick="doEdit(' + "'" + id + "'" + ')" class="button_normal"/>';
                        opButton += '<input type="button" value="坐标" onclick="doMap(' + "'" + id + "'" + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="竣工" onclick="doComplete(' + "'" + id + "'" + ')" class="button_normal"/> ';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "报建编号", "op": "cn", "data": ""},
                    { "field": "项目属地", "op": "cn", "data": ""},
                    { "field": "坐标X", "op": "cn", "data": ""},
                    { "field": "坐标Y", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(bjbh) {
        openWindow("查看项目扩展信息", "${ctx}/projectExtend/view.do?bjbh=" + bjbh, false, 600, 400);
    }
    <c:if test="${canEdit}">
    function doMap(bjbh) {
        var url = "${ctx}/projectExtend/map.do?bjbh=" + bjbh;
        openFullWindow(url, 900, 600, "修改地图信息")
    }
    function doEdit(bjbh) {
        openWindow("修改属地信息", "${ctx}/projectExtend/modify.do?bjbh=" + bjbh, true, 600, 400);
    }
    function doComplete(bjbh) {
        openWindow("设置竣工项目信息", "${ctx}/projectExtend/doComplete.do?bjbh=" + bjbh, true, 600, 400);
    }
    </c:if>

    //按是否标注过滤数据
    function loadThisGrid() {
        var setCode = $("input[name='setCode']:checked").val();
        var searchType = $("#searchType").val();
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'setCode': setCode, 'searchType': searchType}
                }).trigger('reloadGrid');
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
            <select name="searchType" id="searchType" class="form_selects" onclick="loadThisGrid()">
                <option value="all">==全部==</option>
                <option value="area">属地</option>
                <option value="position">坐标</option>
            </select>
            <input type="radio" name="setCode" id="setCode1" value="" checked onclick="loadThisGrid()"><label
                for="setCode1">全部</label>
            <input type="radio" name="setCode" id="setCode2" value="1" onclick="loadThisGrid()"><label
                for="setCode2">已设置项目</label>
            <input type="radio" name="setCode" id="setCode3" value="0" onclick="loadThisGrid()"><label
                for="setCode3">未设置项目</label>
        </div>

        <div style="float:right;padding-right: 10px">
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>

