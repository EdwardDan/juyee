<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkFingerPrint/gridDataCustom.do",
                colNames:['ID',
                    '姓名',
                    '性别',
                    '身份证号',
                    '已经采集指纹数量',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"72", align:"center", searchtype:"string", sortable:true},
                    {name:"sex", width:"15", align:"center", searchtype:"integer", sortable:true, formatter:sexFormat},
                    {name:"cardNo", width:"72", align:"center", searchtype:"string", sortable:true},
                    {name:"num", width:"72", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"指纹信息表列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="采集" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""},
                    { "field":"性别", "op":"cn", "data":""},
                    { "field":"身份证号", "op":"cn", "data":""},
                    { "field":"手机号码", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    <%--<c:if test="${canEdit}">--%>
    function doEdit(id) {
        openWindow("修改指纹信息表", "${ctx}/checkFingerPrint/modify.do?id=" + id, true);
    }
    <%--</c:if>--%>
    function sexFormat(cellvalue, options, rowObject) {
        if (cellvalue == "1") {
            return "男";
        } else if (cellvalue == "0") {
            return "女";
        } else {
            return "";
        }
    }
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
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>