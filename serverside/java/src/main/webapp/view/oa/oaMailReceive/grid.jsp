<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/oaMailReceive/gridDataCustom.do",
                multiselect: true,
                multiselectWidth: 30,
                colNames: ['ID',
                    '发件人',
                    '主题',
                    '发送时间',
                    '状态',
                    '附件',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "sendPerson", width: "20", align: "center", searchtype: "string", sortable: true},
                    {name: "title", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "sendTime", width: "20", align: "center", searchtype: "datetime", sortable: true, formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i'}},
                    {name: "isRead", width: "10", align: "center", searchtype: "string", sortable: true},
                    {name: "documentFile", width: "10", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 10, align: 'center'}
                ],
                pager: '#pager2',
                caption: "接收邮件列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "主题", "op": "cn", "data": "", "alias":"m.title"},
                    { "field": "发件人", "op": "cn", "data": "", "alias":"m.sendPerson"},
                    { "field": "发送时间", "op": "bt", "data": "", "alias":"m.sendTime"}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    //过滤查询数据
    function loadThisGrid() {
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData: {'deptId': $("#deptId").val(), 'groupId': $("#groupId").val()}
                }).trigger('reloadGrid');
    }
    //查看页面
    function doView(id) {
        location.replace("${ctx}/oaMailReceive/view.do?id=" + id);
    }

    //删除邮件
    function doDelete(btn) {
        var ids = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (ids == null || ids == "") {
            showInfoMsg("请选择需要删除的邮件！");
            return;
        }
        $.messager.confirm('系统提示', "您确定要删除选中邮件吗？", function (r) {
            if (r) {
                btn.disable = true;
                loadAjaxDataCallback(null, "${ctx}/oaMailReceive/delete.do?ids=" + ids, doDeleteMsg);
            }
        });
    }
    //删除提示
    function doDeleteMsg(ret) {
        $("#delete").attr("disabled", false);
        var obj = eval("(" + ret + ")");
        if (obj.success == true) {
            showInfoMsg(obj.msg);
            loadThisGrid();
        } else {
            showErrorMsg("删除失败！");
        }
    }
    //转发邮件
    function doForward(btn, mailType) {
        var ids = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (ids == null || ids == "") {
            showInfoMsg("请选择需要转发的邮件！");
            return;
        }
        if (ids.length > 1) {
            showInfoMsg("只能选取一封邮件！");
            return;
        }
        btn.disable = true;
        location.replace("${ctx}/oaMailReceive/modify.do?id=" + ids + "&mailType=" + mailType);
    }
    //回复邮件
    function doReply(btn, mailType) {
        var ids = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (ids == null || ids == "") {
            showInfoMsg("请选择需要回复的邮件！");
            return;
        }
        if (ids.length > 1) {
            showInfoMsg("只能选取一封邮件！");
            return;
        }
        btn.disable = true;
        location.replace("${ctx}/oaMailReceive/modify.do?id=" + ids + "&mailType=" + mailType);
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
            <input type="button" id="delete" value="删除" class="button_cancel" onclick="doDelete(this)"/>&nbsp;
            <input type="button" id="reBack" value="回复" class="button_back" onclick="doReply(this,'${MAIL_TYPE_RE}')"/>&nbsp;
                <input type="button" id="forward" value="转发" class="button_confirm"
                       onclick="doForward(this,'${MAIL_TYPE_FW}')"/>&nbsp;
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>