<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaWorkPlanSum/gridDataCustom.do",
                colNames:['ID',
            	'工作时间',
            	'上报开始时间',
            	'上报结束时间',
            	'已汇总科室',
//            	'附件ID(预留)',
            	'状态',
            	'状态',
                '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
                    {name: "workTime", width: "60", align: "center", searchtype: "string", sortable: false},
                    {name:"beginTime",width:"72",align:"center",searchtype:"date",hidden:true},
                    {name:"endTime",width:"72",align:"center",searchtype:"date",hidden:true},
                    {name:"sumDept",width:"72",align:"center",searchtype:"string"},
//                    {name:"documentId",width:"72",align:"center",searchtype:"string",sortable:true},
                    {name:"statusName",width:"72",align:"center",searchtype:"integer"},
                    {name:"status",width:"72",align:"center",searchtype:"integer",hidden:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"一周工作上报汇总列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var status = rowData["status"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        if (${canEdit}) {
                            if (status == '${STATUS_EDIT}' || '' == status || status == '${STATUS_MAIN_BACK}') {
                                opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                                opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                            }
                        }
                        if (${canEdit_ZR}) {
                            if (status == '${STATUS_SUBMIT}' || status == '${STATUS_BRANCH_PASS}' && status != "") {
                                opButton += '<input type="button" value="审核" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                            }
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
            	{ "field":"已汇总科室", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看一周工作上报汇总", "${ctx}/oaWorkPlanSum/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加一周工作上报汇总", "${ctx}/oaWorkPlanSum/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改一周工作上报汇总", "${ctx}/oaWorkPlanSum/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/oaWorkPlanSum/delete.do?id=" + id);
    }
    function doCount() {
        openWindow("选择工作时间进行汇总", "${ctx}/oaWorkPlanSum/count.do", true, 350, 200);
    }
    </c:if>

    function doThisQuery(btn) {
        var beginTime = "";
        if ('' != $("#start").val()) {
            beginTime = $("#start").val()
        }
        var endTime = "";
        if ('' != $("#end").val()) {
            endTime = $("#end").val()
        }
        var v = "<beginTime>" + beginTime + "</beginTime><endTime>" + endTime + "</endTime><status>" + $("#stat").val() + "</status>";
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'queryJson': v}
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
        </div>
        <div style="float:right;padding-right: 10px">
            <c:if test="${canEdit}">
                <input type="button" value="汇总" class="button_add"
                       onclick="doCount()"/>
            </c:if>
        </div>
        <div style="float:left;padding-right: 10px">
            起始日期：<input type="text" name="start" id="start" value="" class="input_datetime"
                        style="width: 120px"
                        onClick="calendar('start','start');"/>
            结束日期：<input type="text" name="end" id="end" value="" class="input_datetime"
                        style="width: 120px"
                        onClick="calendar('end','end');"/>
            状态：
            <select name="stat" id="stat">
                <option value="" selected>全部</option>
                <c:forEach var="fo" items="${statusList}">
                    <option value="${fo.value}">${fo.name}</option>
                </c:forEach>
            </select>
            <input type="button" value="查询" class="btn_Search" onclick="doThisQuery(this)"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>