<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/jdRecordQuestion/gridDataCustom.do",
                colNames: ['ID',
                    '名称',
                    '名称',
                    '法规依据',
                    '整改情形',
                    '立案情形',
                    '安全隐患',
                    '选择'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "description", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true, hidden: true},
                    {name: "refRule", width: "40", align: "left", searchtype: "string", sortable: true},
                    {name: "reformType.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "registerType.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "safeType.name", width: "40", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 30, align: 'center'}
                ],
                pager: '#pager3',
                rowNum: 15,
                caption: "巡查问题列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid3").jqGrid('getDataIDs');

                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var data = jQuery("#listGrid3").jqGrid('getRowData', id);
                        var name = data['name'];
                        var refRule = data['refRule'];
                        var opButton = '<input type="checkbox" onclick="selectQuestion(' + "this" + ',' + "'" + id + "'" + ',' + "'" + name + "'" + ',' + "'" + refRule + "'" +','+"'"+'${questionTypeCode}'+"'"+ ')"/>';
                        jQuery("#listGrid3").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "名称", "op": "cn", "data": ""},
                    { "field": "法规依据", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton3"),
                queryDesc: $("#queryConditionDesc3")
            }
        };
        gridinit($("#listGrid3"), conf);
    });

</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton3" id="queryButton3" value="查询" class="btn_Search"/>
        </div>

        <div style="float:left;padding-left: 10px" id="conditionsDesc3">
            <input type="text" name="queryConditionDesc3" id="queryConditionDesc3" value="" class="title_input_short"
                   readonly="true"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid3"></table>
    <div id="pager3"></div>
</div>