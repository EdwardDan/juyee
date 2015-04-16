<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:<c:choose>
                        <c:when test="${categoryId!=null}">
                        "${ctx}/bpmProcessTemplate/gridDataCustom.do?categoryId=" + ${categoryId},
                </c:when>
                <c:otherwise>
                "${ctx}/bpmProcessTemplate/gridDataCustom.do",
                </c:otherwise>
                </c:choose>
                colNames:['ID',
                    '名称',
                    '上传时间',
                    '分类',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"70", align:"center", searchtype:"string", sortable:true},
                    {name:"uploadTime", width:"50", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d '}},
                    {name:"category.name", width:"70", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"流程图模板库列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <%--<c:if test="${canEdit}">--%>
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    <%--</c:if>--%>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"名称", "op":"cn", "data":""},
                    { "field":"上传时间", "op":"bw", "data":""},
                    { "field":"分类", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看流程图模板库", "${ctx}/bpmProcessTemplate/view.do?id=" + id, false);
    }
    <%--<c:if test="${canEdit}">--%>

    function doAddno() {
        openFullWindow("${ctx}/bpmProcessTemplate/add.do", 800, 500, "查看流程图模板库");
    <%--openWindow("查看流程图模板库", "${ctx}/bpmProcessTemplate/add.do?categoryId=" +${categoryId}, true);--%>
    }

    function doAdd(id) {
    <%--openWindow("查看流程图模板库", "${ctx}/bpmProcessTemplate/add.do", true);--%>
        openFullWindow("${ctx}/bpmProcessTemplate/add.do?categoryId=" + id, 800, 500, "查看流程图模板库");
    }


    function doEdit(id) {
        openFullWindow("${ctx}/bpmProcessTemplate/modify.do?id=" + id, 800, 500, "修改流程图模板库");
    }
    function doDelete(id) {
        doGridDelete("${ctx}/bpmProcessTemplate/delete.do?id=" + id);
    }
    function doTest(id) {
        openFullWindow("${ctx}/bpmProcessTemplate/test.do?id=" + id, 600, 400, "测试流程图模板库");
    }

    <%--</c:if>--%>

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
                <c:choose>
                    <c:when test="${categoryId!=null}">
                        <input type="button" value="添加" class="button_add"
                               onclick="doAdd(${categoryId})"/>
                    </c:when>
                    <c:otherwise>
                        <input type="button" value="添加" class="button_add"
                               onclick="doAddno()"/>

                    </c:otherwise>
                </c:choose>
                <input type="button" value="测试" class="button_add"
                       onclick="doTest()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>