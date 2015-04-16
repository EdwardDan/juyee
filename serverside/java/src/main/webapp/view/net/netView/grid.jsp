<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/netView/gridDataCustom.do",
                colNames: ['ID',
                    '报建编号',
                    '项目名称',
                    '建设单位',
                    '申请单位',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "Integer", hidden: true},
                    {name: "bjbh", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "projectName", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "buildUnitName", width: "50", align: "left", searchtype: "string", sortable: true},
                    {name: "applyUnitName", width: "50", align: "left", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 15, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目报建列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];

                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            }, isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看汇总页面", "${ctx}/netView/iframe.do?applyId=" + id, false, 800, 500);
    }
</script>

<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>