<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysLog/gridDataCustom.do",
                colNames:['ID',
                    '用户名',
                    'IP地址',
                    '登陆时间',
                    '退出时间',
                    '浏览器版本',
                    '访问页面',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"user.loginName", width:"45", align:"center", searchtype:"string", sortable:true},
                    {name:"ipAddress", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"enterTime", width:"50", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"outTime", width:"50", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
                    {name:"ieVersion", width:"80", align:"center", searchtype:"string", sortable:true},
                    {name:"pageUrl", width:"50", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:25, align:'center'}
                ],
                pager:'#pager2',
                caption:"用户日志列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"用户名", "op":"cn", "data":""},
                    { "field":"IP地址", "op":"cn", "data":""},
                    { "field":"登陆时间", "op":"bt", "data":""},
                    { "field":"退出时间", "op":"bt", "data":""},
                    { "field":"访问页面", "op":"cn", "data":""}
//                    { "field":"浏览器版本", "op":"cn", "data":""},
//                    { "field":"SESSIONID", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true

        };
        gridinit($("#listGrid"), conf);
    });

    function doView(id) {
        openWindow("查看用户日志", "${ctx}/sysLog/view.do?id=" + id, false);
    }
    <%--function doDelete(id) {--%>
    <%--doGridDelete("${ctx}/sysLog/delete.do?id=" + id);--%>
    <%--}--%>
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
            <%--<input type="button" value="添加" class="button_add"--%>
            <%--onclick="doAdd()"/>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>