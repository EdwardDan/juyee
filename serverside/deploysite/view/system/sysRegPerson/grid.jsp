<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/sysRegPerson/gridDataCustom.do?regType=${regType}",
                colNames:['ID',
                    <c:if test="${isGd}">'工地编号', </c:if>
                    <c:if test="${isJs}"> '报建编号', </c:if>
                    <c:if test="${isJs}">'项目卡号', </c:if>
                    <c:if test="${isGd||isJs}">'工程名称', </c:if>
                    <c:if test="${isSg||isJl}">'企业编码', </c:if>
                    <c:if test="${isSg||isJl}">'企业标识码', </c:if>
                    <c:if test="${isSg||isJl}"> '企业名称', </c:if>
                    '联系人',
                    '手机号码',
                    '注册来源',
                    '受理意见',
                    '受理日期',
                    '开通账号',
                    '操作'
                ],
                colModel:[
                    {name:'id', width:10, align:"center", searchtype:"integer", hidden:true},
                        <c:if test="${isGd}">{name:"gdCode", width:"30", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                    <c:if test="${isJs}"> {name:"bjbh", width:"30", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                    <c:if test="${isJs}"> {name:"projectCard", width:"30", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                        <c:if test="${isGd||isJs}">{name:"projectName", width:"70", align:"left", searchtype:"string", sortable:true},
                    </c:if>
                    <c:if test="${isSg||isJl}"> {name:"unitCode", width:"40", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                    <c:if test="${isSg||isJl}"> {name:"unitIdentifyCode", width:"40", align:"center", searchtype:"string", sortable:true},
                    </c:if>
                        <c:if test="${isSg||isJl}">{name:"unitName", width:"60", align:"left", searchtype:"string", sortable:true},
                    </c:if>
                    {name:"personName", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"mobile", width:"30", align:"center", searchtype:"string", sortable:true},
                    {name:"regResource", width:"30", align:"center", searchtype:"integer", sortable:true, formatter:sourceFormat},
                    {name:"acceptOpinion", width:"40", align:"center", searchtype:"integer", sortable:true, formatter:opinionFormat},
                    {name:"acceptDatetime", width:"30", align:"center", searchtype:"datetime", sortable:true, formatter:'date', formatoptions:{srcformat:'Y-m-d', newformat:'Y-m-d'}},
                    {name:"sysUsers", width:"30", align:"center", searchtype:"string", sortable:true}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager:'#pager2',
                caption:"注册人员列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var acceptOpinion = rowData["acceptOpinion"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                    <c:if test="${canEdit}">
                        if (acceptOpinion != '已通过') {
                            opButton += '<input type="button" value="受理" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        } else {
                            opButton += '<input type="button" value="修改" onclick="doEdit(' + id + ')" class="button_normal"/>';
                        }
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                        <c:if test="${isGd}">{ "field":"工地编号", "op":"cn", "data":""},
                    </c:if>
                    <c:if test="${isJs||isSg}"> { "field":"报建编号", "op":"cn", "data":""},
                    </c:if>
                    <c:if test="${isJs}"> { "field":"项目卡号", "op":"cn", "data":""},
                    </c:if>
                        <c:if test="${isGd||isJs}" >{ "field":"工程名称", "op":"cn", "data":""},
                    </c:if>
                    <c:if test="${isSg||isJl}"> { "field":"企业编码", "op":"cn", "data":""},
                    </c:if>
                    <c:if test="${isSg||isJl}">  { "field":"企业标识码", "op":"cn", "data":""},
                    </c:if>
                    <c:if test="${isSg||isJl}">  { "field":"企业名称", "op":"cn", "data":""},
                    </c:if>
                    { "field":"联系人", "op":"cn", "data":""},
                    { "field":"手机号码", "op":"cn", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看注册人员", "${ctx}/sysRegPerson/view.do?id=" + id, false, 630, 450);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加注册人员", "${ctx}/sysRegPerson/add.do?regType=${regType}", true, 630, 450);
    }
    function doEdit(id) {
        openWindow("受理注册人员", "${ctx}/sysRegPerson/modify.do?id=" + id, true, 630, 450);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sysRegPerson/delete.do?id=" + id);
    }
    </c:if>
    function opinionFormat(cellvalue, options, rowObject) {
        if (cellvalue == 0) {
            return "未受理";
        }
        if (cellvalue == 1) {
            return "已通过";
        }
        if (cellvalue == 2) {
            return "未通过";
        }
    }
    function sourceFormat(cellvalue, options, rowObject) {
        if (cellvalue == 0) {
            return "窗口";
        }
        if (cellvalue == 1) {
            return "网站";
        }
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
            <%--<c:if test="${canEdit}">--%>
            <input type="button" value="添加" class="button_add"
                   onclick="doAdd()"/>
            <%--</c:if>--%>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>