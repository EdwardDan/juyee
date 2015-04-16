<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var pageParam = "gdCode=${gdCode}&jdTaskCode=${jdTaskCode}";
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkManager/gridDataCustomDetail.do?" + pageParam,
                colNames:['ID',
                    '姓名',
//                    '性别',
                    '岗位',
                    '身份证号',
                    '手机号码',
                    '已采集指纹数',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"42", align:"center", searchtype:"string", sortable:true},
                    {name:"sex", width:"72", align:"center", searchtype:"string", sortable:true},
                    {name:"cardNo", width:"72", align:"left", searchtype:"string", sortable:true},
                    {name:"mobile", width:"72", align:"left", searchtype:"string", sortable:true},
                    {name:"fingerNum", width:"25", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:60, align:'center'}
                ],
                pager:'#pager2',
                caption:"管理人员表列表（工地编号：${gdCode} , <c:if test='${not empty jdTaskCode}'>监督任务书编号：${jdTaskCode}</c:if>）",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" title="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" title="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" title="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        opButton += '<input type="button" value="指纹登记" title="指纹登记" onclick="doFinger(' + id + ')" class="button_normal_long"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""},
//                    { "field":"性别", "op":"cn", "data":""},
                    { "field":"身份证号", "op":"cn", "data":""},
                    { "field":"手机号码", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看管理人员表", "${ctx}/checkManager/view.do?id=" + id + "&" + pageParam, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加管理人员表", "${ctx}/checkManager/add.do?" + pageParam, true);
    }
    function doEdit(id) {
        openWindow("修改管理人员表", "${ctx}/checkManager/modify.do?id=" + id + "&" + pageParam, true);
    }
    function doFinger(id) {
        openWindow("指纹登记", "${ctx}/checkFingerPrint/modify.do?id=" + id , true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/checkManager/delete.do?id=" + id);
    }
    </c:if>
    function jumpMessageGrid() {
        loadMainPage("${ctx}/checkManager/grid.do", "项目信息维护 >> 考勤人员登记");
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
            &nbsp;
            <input type="button" value="返回" class="button_back" onclick="jumpMessageGrid()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>