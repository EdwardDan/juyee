<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    var pageParam = "gdCode=${gdCode}&jdTaskCode=${jdTaskCode}";
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/checkInfoDay/gridDataCustom.do?" + pageParam,
                colNames:['ID',
                    '姓名',
                    '职务',
                    '考勤时间',
                    '签到情况',
                    '创建人',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"managerName", width:"48", align:"center", searchtype:"string", sortable:true},
                    {name:"cardNo", width:"72", align:"center", searchtype:"string", sortable:true},
                    {name:"checkTime", width:"72", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d H:i:s', newformat:'Y-m-d H:i'}},
                    {name:"checkStatus", width:"52", align:"center", searchtype:"string", sortable:true},
                    {name:"createUser", width:"72", align:"center", searchtype:"string", sortable:true, hidden:true}

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
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var opButton = '';
                        var createUser = rowData['createUser'];
                        createUser = $.trim(createUser);
                        if (createUser == 'check') {
                            opButton = '<input type="button" value="查看" title="查看" onclick="doViewPhoto(' + "'" + id + "'" + ')" class="button_normal"/> ';
                        } else if (createUser != 'noMsg' && createUser != 'check') {
                            opButton = '<input type="button" value="查看" title="查看" onclick="doView(' + "'" + createUser + "'" + ')" class="button_normal"/> ';
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                    adjustGridAfterLoad();
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""}//,
//                    { "field":"性别", "op":"cn", "data":""},
//                    { "field":"身份证号", "op":"cn", "data":""},
//                    { "field":"手机号码", "op":"cn", "data":""}//,
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
    function doViewPhoto(id) {
        openWindow("照片比对", "${ctx}/checkInfoHistory/checkImage.do?id=" + id + "&" + pageParam, false, 560, 422);
    }
    function doView(id) {
        openWindow("未考勤原因", "${ctx}/checkInfoDay/view.do?id=" + id + "&" + pageParam, false, 560, 422);
    }

    //custom formatter
    //    function customeFormat(cellvalue, options, rowObject) {
    //        return cellvalue == "0"?"已签到":"未签到";
    //    }

    //按是否标注过滤数据
    function loadThisGrid() {
        var v = $("input[name='setCode']:checked").val();
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData:{'setCode':v}
                }).trigger('reloadGrid');
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
            &nbsp;&nbsp;
            <input type="radio" name="setCode" value="" checked onclick="loadThisGrid()">全部
            <input type="radio" name="setCode" value="1" onclick="loadThisGrid()">未签到记录
        </div>
        <div style="float:right;padding-right: 10px">
        </div>

    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>