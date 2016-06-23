<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaPublicInfo/gridDataCustom.do?range=${range}&typeCode=${typeCode}&isZc=${isZc}",
                colNames:['ID',
                    <c:if test="${empty typeCode&&empty isZc}">
                    '信息类型',
                    </c:if>
                    '标题',
                    <c:if test="${empty isZc}">
                    '信息来源',
                    </c:if>
                    <c:if test="${canEdit&&empty isZc}">
                    '创建人',
                    '是否发布',
                    '发布范围',
                    '是否置顶',
                    '访问次数',
                    </c:if>
                    '发布时间',
                    '附件',
                    '操作'
                ],
                colModel:[
                    {name: 'id', width: 1, align: "center", searchtype: "integer", hidden: true},
                    <c:if test="${empty typeCode&&empty isZc}">
                    {name: "type.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    </c:if>
                    {name: "title", width: "100", align: "left", searchtype: "string", sortable: true},
                    <c:if test="${empty isZc}">
                    {name: "createDeptName", width: "45", align: "center", searchtype: "string", sortable: true},
                    </c:if>
                    <c:if test="${canEdit&&empty isZc}">
                    {name:"user.displayName", width:"28", align:"center", searchtype:"string", sortable:true},
                    {name:"isPublic", width:"35", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"accessRange.name", width:"32", align:"center", searchtype:"string", sortable:true},
                    {name:"isTop", width:"34", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
                    {name:"visitTimes", width:"34", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                    {name:"reportDate", width:"32", align:"center", searchtype:"date", sortable:true},
                    {name:"document.id", width:"30", align:"center", searchtype:"string", sortable:true}

                ],
                actModel:[
                    {name:'operation', width:30, align:'center', sortable:false}
                ],
                pager: '#pager2',
                <c:if test="${empty isZc}">
                caption: "<c:choose><c:when test="${not empty typeName}">${typeName}列表</c:when><c:otherwise>公共信息发布列表</c:otherwise></c:choose>",
                </c:if>
                <c:if test="${not empty isZc}">
                caption: "政策规章列表",
                </c:if>
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" title="查看" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" title="编辑" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" title="删除" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"信息类型", "op":"cn", "data":""},
                    { "field":"标题", "op":"cn", "data":""},
                    { "field":"信息来源", "op":"cn", "data":""},
                    <c:if test="${canEdit}">
                    { "field":"创建人", "op":"cn", "data":""},
                    { "field":"发布范围", "op":"cn", "data":""},
                    </c:if>
                    { "field":"发布时间", "op":"bt", "data":""}

                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });

    function doView(id) {
    <c:choose>
    <c:when test="canEdit">
        parent.openWindow("查看公共信息发布", "${ctx}/oaPublicInfo/view.do?id=" + id, false, 900, 525);
    </c:when>
    <c:otherwise>
        openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
    </c:otherwise>
    </c:choose>
    }
    <c:if test="${canEdit}">
    function doAdd() {
        parent.openFullWindow("${ctx}/oaPublicInfo/add.do?isZc=${isZc}", 900, 525);
    }
    function doEdit(id) {
        parent.openFullWindow("${ctx}/oaPublicInfo/modify.do?id=" + id + "&isZc=${isZc}", 900, 525);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaPublicInfo/delete.do?id=" + id);
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
