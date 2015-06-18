<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaPetition/gridDataCustom.do",
                colNames:['ID',
            	'受理编号',            	          	
            	'受理状态中文描述',            	          	
            	'信访来源中文描述',            	          	
            	'信访种类中文描述',            	          	
            	'信访人',            	          	
            	'联系电话',            	          	
            	'收信日期',            	          	
            	'联系地址',            	          	
            	'经办人姓名(冗余)',            	          	
            	'结案日期',            	          	
            	'信访事由',            	          	
            	'处理结果',            	          	
            	'备注',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"code",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"statusDesc",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"sourceDesc",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"typeDesc",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"person",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"tel",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"receiveDate",width:"47",align:"center",searchtype:"date",sortable:true},
{name:"address",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"jbrName",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"endDate",width:"47",align:"center",searchtype:"date",sortable:true},
{name:"content",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"dealResult",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"description",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"createTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"47",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"47",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"47",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"信访管理列表",
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
            	{ "field":"受理编号", "op":"cn", "data":""},            	    
            	{ "field":"受理状态中文描述", "op":"cn", "data":""},            	    
            	{ "field":"信访来源中文描述", "op":"cn", "data":""},            	    
            	{ "field":"信访种类中文描述", "op":"cn", "data":""},            	    
            	{ "field":"信访人", "op":"cn", "data":""},            	    
            	{ "field":"联系电话", "op":"cn", "data":""},            	    
            	{ "field":"收信日期", "op":"cn", "data":""},            	    
            	{ "field":"联系地址", "op":"cn", "data":""},            	    
            	{ "field":"经办人姓名(冗余)", "op":"cn", "data":""},            	    
            	{ "field":"结案日期", "op":"cn", "data":""},            	    
            	{ "field":"信访事由", "op":"cn", "data":""},            	    
            	{ "field":"处理结果", "op":"cn", "data":""},            	    
            	{ "field":"备注", "op":"cn", "data":""},            	    
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
        openWindow("查看信访管理", "${ctx}/oaPetition/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加信访管理", "${ctx}/oaPetition/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改信访管理", "${ctx}/oaPetition/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/oaPetition/delete.do?id=" + id);
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