<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/areaPermitHdExtend/gridDataCustom.do",
                colNames:['ID',
            	'主要设计单位',            	          	
            	'主要设计招标方式',            	          	
            	'主要设计中标价',            	          	
            	'主要设计资质等级',            	          	
            	'主要设计项目负责人',            	          	
            	'主要设计证书编号',            	          	
            	'主要设计证书编号2',            	          	
            	'主要监理单位',            	          	
            	'主要监理招标方式',            	          	
            	'主要监理中标价',            	          	
            	'主要监理资质等级',            	          	
            	'主要监理项目负责人',            	          	
            	'主要监理证书编号',            	          	
            	'主要监理证书编号2',            	          	
            	'主要施工单位',            	          	
            	'主要施工招标方式',            	          	
            	'主要施工中标价',            	          	
            	'主要施工资质等级',            	          	
            	'主要施工项目负责人',            	          	
            	'主要施工证书编号',            	          	
            	'主要施工证书编号2',            	          	
            	'工可批准或核准机关和文号',            	          	
            	'批复或核准日期',            	          	
            	'投资估算',            	          	
            	'初步设计批准机关和文号',            	          	
            	'批复日期',            	          	
            	'批复工期',            	          	
            	'总概算',            	          	
            	'批准机关和文号',            	          	
            	'投资来源',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"mainSjUnit",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjZbfs",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjZbj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjZzdj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjXmfzr",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjZsbh",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSjZsbh2",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlUnit",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlZbfs",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlZbj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlZzdj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlXmfzr",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlZsbh",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainJlZsbh2",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgUnit",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgZbfs",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgZbj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgZzdj",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgXmfzr",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgZsbh",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"mainSgZsbh2",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"gkpzCode",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"hzDate",width:"26",align:"center",searchtype:"date",sortable:true},
{name:"planCost",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"cbshCode",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"pfDate",width:"26",align:"center",searchtype:"date",sortable:true},
{name:"pfGq",width:"26",align:"center",searchtype:"integer",sortable:true,formatter:'integer',formatoptions:{thousandsSeparator:",",defaulValue:0}},
{name:"totalGs",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"pzjgCode",width:"26",align:"center",searchtype:"string",sortable:true},
{name:"costFrom",width:"26",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"区县施工许可_航道扩展信息列表",
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
            	{ "field":"主要设计单位", "op":"cn", "data":""},            	    
            	{ "field":"主要设计招标方式", "op":"cn", "data":""},            	    
            	{ "field":"主要设计中标价", "op":"cn", "data":""},            	    
            	{ "field":"主要设计资质等级", "op":"cn", "data":""},            	    
            	{ "field":"主要设计项目负责人", "op":"cn", "data":""},            	    
            	{ "field":"主要设计证书编号", "op":"cn", "data":""},            	    
            	{ "field":"主要设计证书编号2", "op":"cn", "data":""},            	    
            	{ "field":"主要监理单位", "op":"cn", "data":""},            	    
            	{ "field":"主要监理招标方式", "op":"cn", "data":""},            	    
            	{ "field":"主要监理中标价", "op":"cn", "data":""},            	    
            	{ "field":"主要监理资质等级", "op":"cn", "data":""},            	    
            	{ "field":"主要监理项目负责人", "op":"cn", "data":""},            	    
            	{ "field":"主要监理证书编号", "op":"cn", "data":""},            	    
            	{ "field":"主要监理证书编号2", "op":"cn", "data":""},            	    
            	{ "field":"主要施工单位", "op":"cn", "data":""},            	    
            	{ "field":"主要施工招标方式", "op":"cn", "data":""},            	    
            	{ "field":"主要施工中标价", "op":"cn", "data":""},            	    
            	{ "field":"主要施工资质等级", "op":"cn", "data":""},            	    
            	{ "field":"主要施工项目负责人", "op":"cn", "data":""},            	    
            	{ "field":"主要施工证书编号", "op":"cn", "data":""},            	    
            	{ "field":"主要施工证书编号2", "op":"cn", "data":""},            	    
            	{ "field":"工可批准或核准机关和文号", "op":"cn", "data":""},            	    
            	{ "field":"批复或核准日期", "op":"cn", "data":""},            	    
            	{ "field":"投资估算", "op":"cn", "data":""},            	    
            	{ "field":"初步设计批准机关和文号", "op":"cn", "data":""},            	    
            	{ "field":"批复日期", "op":"cn", "data":""},            	    
            	{ "field":"批复工期", "op":"cn", "data":""},            	    
            	{ "field":"总概算", "op":"cn", "data":""},            	    
            	{ "field":"批准机关和文号", "op":"cn", "data":""},            	    
            	{ "field":"投资来源", "op":"cn", "data":""}            	    
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看区县施工许可_航道扩展信息", "${ctx}/areaPermitHdExtend/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加区县施工许可_航道扩展信息", "${ctx}/areaPermitHdExtend/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改区县施工许可_航道扩展信息", "${ctx}/areaPermitHdExtend/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/areaPermitHdExtend/delete.do?id=" + id);
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