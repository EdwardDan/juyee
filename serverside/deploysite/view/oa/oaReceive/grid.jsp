<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaReceive/gridDataCustom.do",
                colNames:['ID',
            	'收文编号',            	          	
            	'来文文号',            	          	
            	'标题',            	          	
            	'来文单位',            	          	
            	'登记日期',            	          	
            	'提供部门',            	          	
            	'成文日期',            	          	
            	'办理时限',            	          	
            	'份数',            	          	
            	'页数',            	          	
            	'牵头部门ID',            	          	
            	'处理人IDs',            	          	
            	'处理部门IDs',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"code",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"fileCode",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"title",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"sourceDept",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"receiveDate",width:"47",align:"center",searchtype:"date",sortable:true},
{name:"deptName",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"writtenDate",width:"47",align:"center",searchtype:"date",sortable:true},
{name:"limitDate",width:"47",align:"center",searchtype:"date",sortable:true},
{name:"fs",width:"47",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"ys",width:"47",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"startDeptId",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"dealPersons",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"dealDepts",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"createTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"47",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"收文管理列表",
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
            	{ "field":"收文编号", "op":"cn", "data":""},            	    
            	{ "field":"来文文号", "op":"cn", "data":""},            	    
            	{ "field":"标题", "op":"cn", "data":""},            	    
            	{ "field":"来文单位", "op":"cn", "data":""},            	    
            	{ "field":"登记日期", "op":"cn", "data":""},            	    
            	{ "field":"提供部门", "op":"cn", "data":""},            	    
            	{ "field":"成文日期", "op":"cn", "data":""},            	    
            	{ "field":"办理时限", "op":"cn", "data":""},            	    
            	{ "field":"份数", "op":"cn", "data":""},            	    
            	{ "field":"页数", "op":"cn", "data":""},            	    
            	{ "field":"牵头部门ID", "op":"cn", "data":""},            	    
            	{ "field":"处理人IDs", "op":"cn", "data":""},            	    
            	{ "field":"处理部门IDs", "op":"cn", "data":""},            	    
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
        openWindow("查看收文管理", "${ctx}/oaReceive/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加收文管理", "${ctx}/oaReceive/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改收文管理", "${ctx}/oaReceive/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/oaReceive/delete.do?id=" + id);
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