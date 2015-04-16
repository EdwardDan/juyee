<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/pollingLaw/gridDataCustom.do",
                colNames:['ID',
            	'关联字段ID',            	          	
            	'条款编号',            	          	
            	'条款内容',            	          	
            	'标准名称',            	          	
            	'标准编号',            	          	
            	'分类',            	          	
            	'监督分类',            	          	
            	'序号',            	          	
            	'类型',            	          	
            	'条款简述',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"stddocid",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"catalog",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"descriptions",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"tksm",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"tkbh",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"lx",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"jdfl",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"iitemno",width:"80",align:"center",searchtype:"string",sortable:true},
{name:"type",width:"80",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"shotdes",width:"80",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"法律法规查询列表",
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
            	{ "field":"关联字段ID", "op":"cn", "data":""},            	    
            	{ "field":"条款编号", "op":"cn", "data":""},            	    
            	{ "field":"条款内容", "op":"cn", "data":""},            	    
            	{ "field":"标准名称", "op":"cn", "data":""},            	    
            	{ "field":"标准编号", "op":"cn", "data":""},            	    
            	{ "field":"分类", "op":"cn", "data":""},            	    
            	{ "field":"监督分类", "op":"cn", "data":""},            	    
            	{ "field":"序号", "op":"cn", "data":""},            	    
            	{ "field":"类型", "op":"cn", "data":""},            	    
            	{ "field":"条款简述", "op":"cn", "data":""}            	    
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看法律法规查询", "${ctx}/pollingLaw/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加法律法规查询", "${ctx}/pollingLaw/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改法律法规查询", "${ctx}/pollingLaw/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/pollingLaw/delete.do?id=" + id);
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