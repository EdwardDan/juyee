<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projExtendSchedule/gridDataCustom.do",
                colNames:['ID',
            	'年',            	          	
            	'月',            	          	
            	'时间（冗余字段）',            	          	
            	'项目进展情况',            	          	
            	'存在问题',            	          	
            	'改进意见',            	          	
            	'备注',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"year",width:"114",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"month",width:"114",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"title",width:"114",align:"center",searchtype:"string",sortable:true},
{name:"projProgress",width:"114",align:"center",searchtype:"string",sortable:true},
{name:"question",width:"114",align:"center",searchtype:"string",sortable:true},
{name:"improveOpinion",width:"114",align:"center",searchtype:"string",sortable:true},
{name:"description",width:"114",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"项目建设情况列表",
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
            	{ "field":"年", "op":"cn", "data":""},            	    
            	{ "field":"月", "op":"cn", "data":""},            	    
            	{ "field":"时间（冗余字段）", "op":"cn", "data":""},            	    
            	{ "field":"项目进展情况", "op":"cn", "data":""},            	    
            	{ "field":"存在问题", "op":"cn", "data":""},            	    
            	{ "field":"改进意见", "op":"cn", "data":""},            	    
            	{ "field":"备注", "op":"cn", "data":""}            	    
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看项目建设情况", "${ctx}/projExtendSchedule/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目建设情况", "${ctx}/projExtendSchedule/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目建设情况", "${ctx}/projExtendSchedule/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/projExtendSchedule/delete.do?id=" + id);
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