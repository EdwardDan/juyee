<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var pageParam = "gdCode=${gdCode}&jdTaskCode=${jdTaskCode}";
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkInfoHistory/gridDataCustom.do?" + pageParam,
                colNames:['ID',
                    'checkInfoId',
                    'reasonId',
                    '姓名',
                    '职务',
                    '考勤时间',
                    '签到情况',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:'checkInfoId', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:'reasonId', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"managerName", width:"60", align:"center", searchtype:"string", sortable:true},
                    {name:"position", width:"70", align:"center", searchtype:"string", sortable:true},
                    {name:"checkTime", width:"50", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"checkStatusName", width:"50", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"管理人员表列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var checkInfoId = rowData["checkInfoId"];
                        var reasonId = rowData["reasonId"];
                        var opButton = '';
                        if(checkInfoId != ""){
                            opButton = '<input type="button" value="查看" title="查看" onclick="doViewPhoto(' + checkInfoId + ')" class="button_normal"/> ';
                        }else if(reasonId != ""){
                            opButton = '<input type="button" value="查看" title="查看" onclick="doViewReason(' + reasonId + ')" class="button_normal"/> ';
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                    adjustGridAfterLoad(null,360);
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doViewPhoto(id) {
        openWindow("照片比对", "${ctx}/checkInfoHistory/checkImage.do?id=" + id + "&" + pageParam, false, 560, 422);
    }
    function doViewReason(id) {
        openWindow("未考勤原因", "${ctx}/checkInfoDay/view.do?id=" + id + "&" + pageParam, false, 560, 422);
    }
    function doThisQuery(btn) {
        var v = "<beginTime>"+$("#beginTime").val()+"</beginTime><endTime>"+$("#endTime").val()+"</endTime><managerId>"+$("#managerId").val()+"</managerId><status>"+$("#status").val()+"</status>";
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData:{'queryJson':v}
                }).trigger('reloadGrid');
    }
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px;display: none">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px;display: none" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div style="float:left;padding-right: 10px">
            起始日期：<input type="text" name="beginTime" id="beginTime" value="${beginTime}" class="input_date" onClick="calendar('beginTime');"/>
            结束日期：<input type="text" name="endTime" id="endTime" value="${endTime}" class="input_date" onClick="calendar('endTime');"/>
            人员：<select name="managerId" id="managerId">
            <option value="">==全部==</option>
            <c:forEach items="${managerList}" var="manager">
                <option value="${manager.id}">${manager.name}</option>
            </c:forEach>
        </select>
            状态：<select name="status" id="status">
            <option value="" selected>全部</option>
            <option value="check">签到</option>
            <option value="notCheck">未签到</option>
        </select>
            <input type="button" value="查询" class="btn_Search" onclick="doThisQuery(this)"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>