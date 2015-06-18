<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaMeetingOuter/gridDataCustom.do",
                colNames:['ID',
            	'会议开始时间',            	          	
            	'会议结束时间',            	          	
            	'会议地点',            	          	
            	'主持人',            	          	
            	'发起单位',            	          	
            	'会议领导',            	          	
            	'与会单位',            	          	
            	'会议名称',            	          	
            	'会议内容',            	          	
            	'与中心相关事宜',            	          	
            	'工作建议',            	          	
            	'状态',            	          	
            	'分管领导审核意见',            	          	
            	'分管领导审核时间',            	          	
            	'主任审核意见',            	          	
            	'主任审核时间',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"beginTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"endTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"address",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"chargePerson",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"startDept",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"leader",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"innerPersons",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"title",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"content",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"relateMatter",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"workAdvise",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"status",width:"40",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"fgAuditOpinion",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"fgAuditTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"zrAuditOpinion",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"zrAuditTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"40",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"40",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"40",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"外部会议列表",
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
                { "field":"会议开始时间", "op":"bw", "data":""},            	    
                { "field":"会议结束时间", "op":"bw", "data":""},            	    
            	{ "field":"会议地点", "op":"cn", "data":""},            	    
            	{ "field":"主持人", "op":"cn", "data":""},            	    
            	{ "field":"发起单位", "op":"cn", "data":""},            	    
            	{ "field":"会议领导", "op":"cn", "data":""},            	    
            	{ "field":"与会单位", "op":"cn", "data":""},            	    
            	{ "field":"会议名称", "op":"cn", "data":""},            	    
            	{ "field":"会议内容", "op":"cn", "data":""},            	    
            	{ "field":"与中心相关事宜", "op":"cn", "data":""},            	    
            	{ "field":"工作建议", "op":"cn", "data":""},            	    
            	{ "field":"状态", "op":"cn", "data":""},            	    
            	{ "field":"分管领导审核意见", "op":"cn", "data":""},            	    
                { "field":"分管领导审核时间", "op":"bw", "data":""},            	    
            	{ "field":"主任审核意见", "op":"cn", "data":""},            	    
                { "field":"主任审核时间", "op":"bw", "data":""},            	    
                { "field":"创建时间", "op":"bw", "data":""},            	    
            	{ "field":"创建用户名", "op":"cn", "data":""},            	    
                { "field":"更新时间", "op":"bw", "data":""},            	    
            	{ "field":"更新用户名", "op":"cn", "data":""}            	    
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看外部会议", "${ctx}/oaMeetingOuter/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加外部会议", "${ctx}/oaMeetingOuter/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改外部会议", "${ctx}/oaMeetingOuter/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/oaMeetingOuter/delete.do?id=" + id);
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