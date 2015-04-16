<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/scjgSpecialWorker/gridDataCustom.do",
                colNames: ['ID',
                    '姓名',
                    '人员分类',
                    '身份证号码',
                    '性别',
                    '证书名称',
                    '证书编号',
//            	'社保缴纳金额',
//            	'社保缴纳开始年月',
//            	'社保缴纳最后一次年月',
//            	'监督任务书编号',
                    '所在单位',
//            	'创建时间',
//            	'创建用户名',
//            	'更新时间',
//            	'更新用户名',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "name", width: 10, align: "center", searchtype: "string", sortable: true},
                    {name: "personType.name", width: 10, align: "center", searchtype: "string", sortable: true},
                    {name: "idCard", width: 15, align: "center", searchtype: "string", sortable: true},
                    {name: "sex", width: 5, align: "center", searchtype: "string", sortable: true},
                    {name: "certName", width: 5, align: "center", searchtype: "string", sortable: true},
                    {name: "certCode", width: 5, align: "center", searchtype: "string", sortable: true},
//{name:"sbjnMoney",width:10,align:"center",searchtype:"string",sortable:true},
//{name:"sbjnBeginMonth",width:15,align:"center",searchtype:"string",sortable:true},
//{name:"sbjnLastMonth",width:15,align:"center",searchtype:"string",sortable:true},
//{name:"jdTaskCode",width:15,align:"center",searchtype:"string",sortable:true},
                    {name: "deptName", width: 15, align: "center", searchtype: "string", sortable: true}
//{name:"createTime",width:"66",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//{name:"createUser",width:"66",align:"center",searchtype:"string",sortable:true},
//{name:"updateTime",width:"66",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
//{name:"updateUser",width:"66",align:"center",searchtype:"string",sortable:true}
                ],
                actModel: [
                    {name: 'operation', width: 10, align: 'center'}
                ],
                pager: '#pager2',
                caption: "特种作业人员信息列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "姓名", "op": "cn", "data": ""},
                    { "field": "人员分类", "op": "cn", "data": ""},
                    { "field": "身份证号码", "op": "cn", "data": ""},
                    { "field": "性别", "op": "cn", "data": ""},
                    { "field": "证书名称", "op": "cn", "data": ""},
                    { "field": "证书编号", "op": "cn", "data": ".certCode"},

//            	{ "field":"社保缴纳金额", "op":"cn", "data":""},
//            	{ "field":"社保缴纳开始年月", "op":"cn", "data":""},
//            	{ "field":"社保缴纳最后一次年月", "op":"cn", "data":""},
//            	{ "field":"监督任务书编号", "op":"cn", "data":""},
                    { "field": "所在单位", "op": "cn", "data": ""}
//                { "field":"创建时间", "op":"bw", "data":""},
//            	{ "field":"创建用户名", "op":"cn", "data":""},
//                { "field":"更新时间", "op":"bw", "data":""},
//            	{ "field":"更新用户名", "op":"cn", "data":""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看特种作业人员信息", "${ctx}/scjgSpecialWorker/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加特种作业人员信息", "${ctx}/scjgSpecialWorker/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改特种作业人员信息", "${ctx}/scjgSpecialWorker/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/scjgSpecialWorker/delete.do?id=" + id);
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