<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        //name,birthday,possession,age,registerTime,isMarried,description,isLeaf,treeId
        var conf = {
            gridOpts:{
                url:"${ctx}/sample/gridDataCustom.do",
                colNames:['ID','姓名','生日','资产','年龄','所属单位','学历','注册时间','婚否','备注','操作'],
                colModel:[
                    {name:'id', width:5, align:"center", searchtype:"integer",hidden:true},
                    {name:'name', width:60, align:"center", searchtype:"string",sortable:true},
                    {name:'birthday', width:40, align:"center", searchtype:"date",sortable:true},
                    {name:'possession', width:40, align:"right", searchtype:"integer",sortable:true,formatter:'currency',formatoptions:{decimalSeparator:",", thousandsSeparator: ",",
                        decimalPlaces: 2, prefix: "￥"}},
                    {name:'age', width:30, align:"center", searchtype:"integer",sortable:true},
                    {name:'sysDept.name', width:80, align:"left", searchtype:"string",sortable:true},
                    {name:'education.name', width:40, align:"center", searchtype:"string",sortable:true},
                    {name:'registerTime', width:40, align:"center", searchtype:"datetime",sortable:true,formatter:'date', formatoptions:{srcformat: 'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
                    {name:'isMarried', width:40, align:"center", searchtype:"integer",sortable:true,formatter:marriedFormat},
                    {name:'description', width:40, align:"left", searchtype:"string",sortable:true}
//                    {name:'operation', width:50,align:'center'}
                ],
                actModel:[
                    {name:'operation', width:50, align:'center'}
                ],
                pager: '#pager2',
                caption:"查询结果列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"> ';
                    <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal">';
                    </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
                    { "field":"姓名", "op":"cn", "data":""},
                    { "field":"年龄", "op":"eq", "data":""}
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            }
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看样例", "${ctx}/sample/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加样例", "${ctx}/sample/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改样例", "${ctx}/sample/modify.do?id=" + id, true);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/sample/delete.do?id=" + id);
    }
    </c:if>
    //婚否
    function marriedFormat(cellvalue, options, rowObject) {
        return cellvalue == "true" ? "是" : "否";
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
            <c:if test="${canEdit}">
                <input type="button" value="添加" class="button_add"
                       onclick="doAdd()"/>
            </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>