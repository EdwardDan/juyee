<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/projExtend/gridDataCustom.do",
                colNames:['ID',
            	'工可批复总投资（亿元）',            	          	
            	'初设批复总投资（亿元）',            	          	
            	'资金来源',            	          	
            	'项目建议书完成时间',            	          	
            	'工可完成时间',            	          	
            	'初步设计完成时间',            	          	
            	'是否开工',            	          	
            	'开工时间',            	          	
            	'是否完工',            	          	
            	'完工时间',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"gctxGkpfTotal",width:"57",align:"center",searchtype:"string",sortable:true},
{name:"gctxCspfTotal",width:"57",align:"center",searchtype:"string",sortable:true},
{name:"gctxSourceFund",width:"57",align:"center",searchtype:"string",sortable:true},
{name:"planXmjysTime",width:"57",align:"center",searchtype:"date",sortable:true},
{name:"planGkTime",width:"57",align:"center",searchtype:"date",sortable:true},
{name:"planCbsjTime",width:"57",align:"center",searchtype:"date",sortable:true},
{name:"gcjsIsBigin",width:"57",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
{name:"gcjsBeginTime",width:"57",align:"center",searchtype:"date",sortable:true},
{name:"gcjsIsEnd",width:"57",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
{name:"gcjsEndTime",width:"57",align:"center",searchtype:"date",sortable:true},
{name:"createTime",width:"57",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"57",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"57",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"57",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"项目扩展信息列表",
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
            	{ "field":"工可批复总投资（亿元）", "op":"cn", "data":""},            	    
            	{ "field":"初设批复总投资（亿元）", "op":"cn", "data":""},            	    
            	{ "field":"资金来源", "op":"cn", "data":""},            	    
            	{ "field":"项目建议书完成时间", "op":"cn", "data":""},            	    
            	{ "field":"工可完成时间", "op":"cn", "data":""},            	    
            	{ "field":"初步设计完成时间", "op":"cn", "data":""},            	    
            	{ "field":"是否开工", "op":"cn", "data":""},            	    
            	{ "field":"开工时间", "op":"cn", "data":""},            	    
            	{ "field":"是否完工", "op":"cn", "data":""},            	    
            	{ "field":"完工时间", "op":"cn", "data":""},            	    
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
        openWindow("查看项目扩展信息", "${ctx}/projExtend/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加项目扩展信息", "${ctx}/projExtend/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改项目扩展信息", "${ctx}/projExtend/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/projExtend/delete.do?id=" + id);
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