<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaCar/gridDataCustom.do",
                colNames:['ID',
            	'使用车辆开始时间',            	          	
            	'使用车辆结束时间',            	          	
            	'用车人数',            	          	
            	'用车事由',            	          	
            	'目的地',            	          	
            	'科长审核意见',            	          	
            	'科长审核时间',            	          	
            	'办公室主任审核意见',            	          	
            	'办公室主任审核时间',            	          	
            	'拟派司机电话',            	          	
            	'状态',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"beginTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"endTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"personNum",width:"53",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"useCause",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"address",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"kzAuditOpinion",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"kzAuditTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"zrAuditOpinion",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"zrAuditTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"driverMobile",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"status",width:"53",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"createTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"53",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"53",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"53",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"车辆申请列表",
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
                { "field":"使用车辆开始时间", "op":"bw", "data":""},            	    
                { "field":"使用车辆结束时间", "op":"bw", "data":""},            	    
            	{ "field":"用车人数", "op":"cn", "data":""},            	    
            	{ "field":"用车事由", "op":"cn", "data":""},            	    
            	{ "field":"目的地", "op":"cn", "data":""},            	    
            	{ "field":"科长审核意见", "op":"cn", "data":""},            	    
                { "field":"科长审核时间", "op":"bw", "data":""},            	    
            	{ "field":"办公室主任审核意见", "op":"cn", "data":""},            	    
                { "field":"办公室主任审核时间", "op":"bw", "data":""},            	    
            	{ "field":"拟派司机电话", "op":"cn", "data":""},            	    
            	{ "field":"状态", "op":"cn", "data":""},            	    
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
        openWindow("查看车辆申请", "${ctx}/oaCar/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加车辆申请", "${ctx}/oaCar/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改车辆申请", "${ctx}/oaCar/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/oaCar/delete.do?id=" + id);
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