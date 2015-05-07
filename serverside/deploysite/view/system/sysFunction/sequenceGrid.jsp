<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysFunction/sequenceGridDataCustom.do",
                colNames:['ID', '表名', '中文描述', '表记录最大ID', '当前SEQUENCE_ID'],
                colModel:[
                    {name:'id', width:5, align:"center", searchtype:"integer", hidden:true},
                    {name:'tableName', width:70, align:"left", searchtype:"string", sortable:true},
                    {name:'comment', width:60, align:"left", searchtype:"string", sortable:true},
                    {name:'maxId', width:40, align:"right", searchtype:"string", sortable:true},
                    {name:'sequenceId', width:40, align:"right", searchtype:"string", sortable:true}
                ],
                actModel:[
//                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"表记录最大数列表",
                shrinkToFit:true,
                gridComplete:function () {

                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"表名", "op":"cn", "data":""},
                    { "field":"中文描述", "op":"eq", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });

    function doUpdateRecord() {
        var url = "${ctx}/sysFunction/updateSquence.do";
        $.messager.confirm('系统提示', "您确定要更新最大记录数吗?", function (r) {
            if (r) {
                saveAjaxData(url, null, null, null);
            }
        });
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
            <input type="button" value="更新" class="button_all"  onclick="doUpdateRecord()"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>