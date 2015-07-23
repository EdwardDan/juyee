<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/oaMailGroupUser/gridDataCustom.do",
                multiselect:true,
                multiselectWidth:30,
                colNames:['ID',
                    '用户名',
                    '姓名',
                    '电话',
                    '科室',
                    '我的组',
                    '从全部组中移除'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                    {name:"loginName", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"displayName", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"person.mobile", width:"50", align:"center", searchtype:"string", sortable:true},
                    {name:"person.deptName", width:"80", align:"center", searchtype:"string", sortable:false},
                    {name:"mailGroupNames", width:"60", align:"center", searchtype:"string", sortable:false}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager:'#pager2',
                caption:"通讯录",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = "";
                    <c:if test="${canEdit}">
//                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
//                        var groupName = rowData["mailGroupName"];
                        opButton += '<input type="button" value="移除" onclick="doDelete(' + id + ',\'\')" class="button_normal"/>';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true, rowNum:2000
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    //过滤查询数据
    function loadThisGrid() {
        jQuery("#listGrid").jqGrid('setGridParam',
                {
                    postData:{'deptId':$("#deptId").val(), 'groupId':$("#groupId").val()}
                }).trigger('reloadGrid');
    }

    <c:if test="${canEdit}">
    //加入组
    function doAddGroup(btn) {
        var groupId = $("#addGroup").val();
        if (groupId == null || groupId == "") {
            showInfoMsg("请先编辑组！");
            return;
        }
        var userIds = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (userIds == null || userIds == "") {
            showInfoMsg("请选择需要加入的人员！");
            return;
        }
        btn.disable = true;
        loadAjaxDataCallback(null, "${ctx}/oaMailGroupUser/save.do?groupId=" + groupId + "&userIds=" + userIds, showOperateMsg);
    }

    //加入组提示
    function showOperateMsg(ret) {
        $("#queryButton3").attr("disabled", false);
        var obj = eval("(" + ret + ")");
        if (obj.success == true) {
            showInfoMsg(obj.msg);
            loadThisGrid();
        } else {
            showErrorMsg("操作失败！");
        }
    }

    //编辑组
    function doEditGroup(btn) {
        btn.disable = true;
        window.location.href = "${ctx}/oaMailGroup/grid.do?tabNo=${tabNo}";
    }

    //移除人员的全部组
    function doDelete(userId,groupId) {
        doGridDeleteCustom("${ctx}/oaMailGroupUser/delete.do?groupId="+groupId+"&userId=" + userId);
    }

    //从单个组中移除人员
    function doDeleteSingle(obj) {
        var groupId = $("#addGroup").val();
        if (groupId == null || groupId == "") {
            showInfoMsg("请先编辑组！");
            return;
        }
        var userIds = $("#listGrid").jqGrid("getGridParam", "selarrrow");
        if (userIds == null || userIds == "") {
            showInfoMsg("请先选择需要移除的人员！");
            return;
        }
        doDelete(userIds,groupId);
    }

    //操作确认
    function doGridDeleteCustom(url, msg, opts) {
        if (msg == null) msg = "您确定要从组中移除人员记录吗?";
        $.messager.confirm('系统提示', msg, function (r) {
            if (r) {
                saveAjaxData(url, null, null, opts);
            }
        });
    }
    </c:if>
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px;display: none">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px;display: none" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div>
            <table width="98%" align="center" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td width="33%" align="left" nowrap>
                        科室：
                        <select name="deptId" id="deptId">
                            <option value="">全部</option>
                            <c:forEach items="${depts}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="33%" align="center" nowrap>
                        我的组：
                        <select name="groupId" id="groupId">
                            <option value="">全部</option>
                            <c:forEach items="${groups}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                        <input type="button" id="queryButton1" value="查询" class="btn_Search"
                               onclick="loadThisGrid(this)"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <c:if test="${canEdit}">
                            <input type="button" id="queryButton2" value="编辑组" class="button_all"
                                   onclick="doEditGroup(this)"/>
                            <%--<input type="hidden" id="objId" value="" class="input_text"/>--%>
                            <%--<input type="text" id="objName" value="" class="input_text"/>--%>
                            <%--<input type="button" value="选择" class="button_all"--%>
                                   <%--onclick="parent.openWindow('选择用户','${ctx}/oaMailGroupUser/select.do?objId=objId&objName=objName&tabNo=${tabNo}',false,700,450,null)"/>--%>
                        </c:if>
                    </td>
                    <td width="33%" align="right" nowrap>
                        <c:if test="${canEdit}">
                            <select name="addGroup" id="addGroup">
                                <c:forEach items="${groups}" var="item">
                                    <option value="${item.id}">${item.name}</option>
                                </c:forEach>
                            </select>
                            <input type="button" id="queryButton3" value="加入" class="button_add" onclick="doAddGroup(this)"/>
                            <input type="button" id="queryButton4" value="移除" class="button_cancel" onclick="doDeleteSingle(this)"/>
                        </c:if>
                    </td>
            </table>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>