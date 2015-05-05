<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projInfo/gridDataCustom.do",
                colNames:['ID',
                    '年份',
                    '项目序号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '标段数',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name:"name",width:"57",align:"center",searchtype:"string",sortable:true},
                    {name:"year",width:"57",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
                    {name:"no",width:"57",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
                    {name:"buildMileage",width:"57",align:"center",searchtype:"string",sortable:true},
                    {name:"location",width:"57",align:"center",searchtype:"string",sortable:true},
                    {name:"startDate",width:"57",align:"center",searchtype:"date",sortable:true},
                    {name:"intro",width:"57",align:"center",searchtype:"string",sortable:true},
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"项目基本信息管理列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"项目名称", "op":"cn", "data":""},
                    { "field":"年份", "op":"cn", "data":""},
                    { "field":"项目序号", "op":"cn", "data":""},
                    { "field":"建设里程", "op":"cn", "data":""},
                    { "field":"起讫地点", "op":"cn", "data":""},
                    { "field":"开工日期", "op":"cn", "data":""},
                    { "field":"工程简介", "op":"cn", "data":""},
                    { "field":"建设单位", "op":"cn", "data":""},
                    { "field":"施工单位", "op":"cn", "data":""},
                    { "field":"施工单位联系人", "op":"cn", "data":""},
                    { "field":"施工单位联系电话", "op":"cn", "data":""},
                    { "field":"监理单位", "op":"cn", "data":""},
                    { "field":"监理单位联系人", "op":"cn", "data":""},
                    { "field":"监理单位联系电话", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目基本信息管理", "${ctx}/projInfo/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目基本信息管理", "${ctx}/projInfo/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目基本信息管理", "${ctx}/projInfo/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projInfo/delete.do?id=" + id);
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
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input" readonly="true"/>
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