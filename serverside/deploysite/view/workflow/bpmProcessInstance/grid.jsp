<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>
<script type="text/javascript">
    var pageParam = encodeURI("type=${type}&categoryCode=${categoryCode}");
    var pdCode = encodeURI("${processDefinitionCode}");
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/bpmProcessInstance/gridDataCustom.do?processDefinitionCode="+pdCode+"&" + pageParam,
                colNames:['ID',
                    <c:forEach items="${columnGridList}" var="customGrid">
                    "${customGrid.gridName}",
                    </c:forEach>
                    '状态',
                    '附件',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    <c:forEach items="${columnGridList}" var="customGrid">
                    <c:choose>
                    <c:when test="${customGrid.column == 'reportDate'}">
                    {name:"${customGrid.column}",searchtype:"date",width:"${customGrid.gridWidth}",align:"center",formatter:'date',formatoptions:{srcformat:'Y-m-d',newformat:'Y-m-d'}},
                    </c:when>
                    <c:otherwise>
                    {name:"${customGrid.column}",searchtype:"string",width:"${customGrid.gridWidth}",align:"center"},
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
                    {name:"statusName",width:"10",align:"center",searchtype:"string",sortable:false},
                    {name:"attachImg",width:"10",align:"center",searchtype:"string",sortable:false},
                    {name:"auditImg",width:"25",align:"center",searchtype:"string",sortable:false}
                ],
                actModel:[
//                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"<c:choose><c:when test="${processDefinition != null}">${processDefinition.name}列表</c:when><c:otherwise>业务流程实例列表</c:otherwise></c:choose>",
                shrinkToFit:true,
                gridComplete:function () {
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    <c:forEach items="${columnGridList}" var="customGrid">
                    <c:choose>
                    <c:when test="${customGrid.column == 'reportDate'}">
                    { "field":"${customGrid.gridName}", "op":"bt", "data":""},
                    </c:when>
                    <c:otherwise>
                    { "field":"${customGrid.gridName}", "op":"cn", "data":""},
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
//                    { "field":"编号", "op":"cn", "data":""},
//                    { "field":"标题", "op":"cn", "data":""},
//                    { "field":"申请日期", "op":"bt", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });

    <c:if test="${canEdit}">
    function doAdd() {
        var pCode = "${processDefinitionCode}";
    <c:if test="${not empty categoryCode}">
        pCode = $("#processDefinitionSelect").val();
    </c:if>
        if (pCode == "") {
            showInfoMsg("请先选择一项流程");
        } else {
            $.messager.confirm('系统提示', '确定要启动一个流程吗？', function(r) {
                if (r) {
                    var url = "${ctx}/bpmProcessInstance/start.do?processDefinitionCode=" + encodeURI(pCode);
                    var ret = getAjaxData(url);
                    if (ret.success) {
                        showInfoMsg(ret.msg,null,dealEvent(ret.id));
                    } else {
                        showErrorMsg(ret.msg);
                    }
                }
            });
        }
    }
    </c:if>
    function jumpEditPage(ret){
        if(ret.success){
            showInfoMsg(ret.msg);
            dealEvent(ret.id);
        }else{
            showErrorMsg(ret.msg);
        }
    }
    function dealEvent(id) {
        window.location = "${ctx}/bpmProcessInstance/modify.do?bpmTaskInstanceId=" + id+ "&" + pageParam;
    }
    function doDelete(id) {
        doGridDelete("${ctx}/bpmProcessInstance/delete.do?id=" + id);
    }
    //sens msg
    function sendMsg(id) {
        if (id != "") {
            loadAjaxDataCallback(null,"${ctx}/bpmProcessInstance/getJsonMsg.do?bpmProcessInstanceId="+id,sendMsgJump);
        }
    }
    function sendMsgJump(ret){
        parent.openWindow("发送短信","${ctx}/smsMessage/add.do?jsonData=" + encodeURI(ret),false,800,450);
    }


    //查看
    function doView(id) {
        parent.openWindow("查看信息", "${ctx}/bpmProcessInstance/view.do?id=" + id + "&" + pageParam, false,950,450);
    }

    //查看流转示意图事件
    function viewFlowPic(value) {
        if(!checkIsIE()){
            showInfoMsg("当前您的浏览器不支持流程示意图的显示方式，请改用IE浏览器查看！","warning");
        }else{
            var url = "?id=" + value;
            parent.openFullWindow("${ctx}/bpmProcessInstance/viewFlowPic.do" + url,900, 450);
        }
    }
    //view attachs
    function viewAttach(value) {
        parent.openWindow("查看附件","${ctx}/bpmProcessAttach/formAttachView.do?processInstanceId=" + value,false, 800, 400);
    }

    //按表单过滤数据
    function loadThisGrid() {
        var v = $("#processDefinitionSelect").val();
        parent.processDefinitionCode = v;
        window.location = "${ctx}/bpmProcessInstance/grid.do?processDefinitionCode=" + encodeURI(v) + "&" + pageParam;
    }
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
            <c:if test="${not empty categoryCode}">
                <font color="red" style="font-weight:normal;">请选择表单：</font>
                <select name="processDefinitionSelect" id="processDefinitionSelect" onchange="loadThisGrid()" class="form_select" style="background-color:yellow;" >
                        <%--<option value="">全部</option>--%>
                    <c:forEach items="${bpmProcessDefinitions}" var="item">
                        <option value="${item.code}" <c:if test="${item.code==processDefinitionCode}">selected</c:if>>${item.name}</option>
                    </c:forEach>
                </select>
            </c:if>
            <c:if test="${canEdit && type !='hasAudit'}">
                &nbsp;&nbsp;<input type="button" value="添加" class="button_add"
                onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>