<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var pageParam = "gdCode=${gdCode}&jdTaskCode=${jdTaskCode}";
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkInfoPerson/gridDataCustom.do?" + pageParam,
                colNames:['ID',
                    '姓名',
                    '性别',
//                    '岗位',
                    '身份证号',
                    '手机号码',
//                    '已采集指纹数',

//                    '照片',
//                    '是否同步',
//                    '创建时间',
//                    '更新时间',
//                    '更新人',
//                    '创建人',
                    '岗位名称',
//                    'GUID',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"name", width:"47", align:"center", searchtype:"string", sortable:true},
                    {name:"sex", width:"32", align:"center", searchtype:"string", sortable:true, formatter:customeFormat},
                    {name:"m.cardNo", width:"82", align:"left", searchtype:"string", sortable:true},
                    {name:"mobile", width:"72", align:"center", searchtype:"string", sortable:true},

//                    {name:"fingerNum", width:"25", align:"center", searchtype:"string", sortable:true}//,
//                    {name:"photo", width:"72", align:"center", searchtype:"string", sortable:true},
//                    {name:"isSync", width:"72", align:"center", searchtype:"integer", sortable:true, formatter:booleanFormat},
//                    {name:"createTime", width:"72", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"updateTime", width:"72", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i:s'}},
//                    {name:"updateUser", width:"72", align:"center", searchtype:"string", sortable:true},
                    {name:"createUser", width:"72", align:"center", searchtype:"string", sortable:true}//,
//                    {name:"guid", width:"72", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:45, align:'center'}
                ],
                pager:'#pager2',
                caption:"管理人员表列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" title="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                    adjustGridAfterLoad();
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""},
//                    { "field":"性别", "op":"cn", "data":""},
                    { "field":"身份证号", "op":"cn", "data":""},
                    { "field":"手机号码", "op":"cn", "data":""}//,
//                    { "field":"照片", "op":"cn", "data":""},
//                    { "field":"是否同步", "op":"cn", "data":""}//,
//                    { "field":"创建时间", "op":"bw", "data":""},
//                    { "field":"更新时间", "op":"bw", "data":""},
//                    { "field":"更新人", "op":"cn", "data":""},
//                    { "field":"创建人", "op":"cn", "data":""},
//                    { "field":"GUID", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看管理人员表", "${ctx}/checkInfoPerson/view.do?id=" + id + "&" + pageParam, false, null, 400);
    }

    function jumpMessageGrid() {
        loadMainPage("${ctx}/checkManager/grid.do", "项目信息维护 >> 考勤人员登记");
    }


    //    custom formatter
    function customeFormat(cellvalue, options, rowObject) {
        return cellvalue == "1" ? "男" : "女";
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
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>