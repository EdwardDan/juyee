<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projectQueryStage/gridDataCustom.do",
                colNames: ['ID',
                    '年份',
                    '项目序号',
                    '项目编号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '办证推进标段数',
                    '形象进度标段数',
                    '问题附件',
                    '问题附件(非输出下载内容)',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "no", width: "20", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "projNum", width: "20", align: "center", searchtype: "integer", sortable: true, hidden: true},
                    {name: "name", width: "70", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "40", align: "center", searchtype: "string", sortable: true},
                    {name: "bidCountOfStage", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "bidCountOfNode", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "doc.id", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "docId", width: "30", align: "center", searchtype: "string", sortable: true, hidden: true}
                ],
                actModel: [
                    {name: 'operation', width: 90, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目办证推进查询",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var name = rowData["name"];
                        var docId = rowData['docId'] != null ? rowData['docId'] : "";
                        var stageName = rowData["stage.name"];
                        var opButton = '<input type="button" value="办证推进" onclick="doViewStage(\'' + id + '\', \'' + name + '\')" class="button_normal_long"/> ';
                        opButton += '<input type="button" value="形象进度" onclick="doViewNode(\'' + id + '\', \'' + name + '\')" class="button_normal_long"/> ';
                        opButton += '<input type="hidden" name="docIdDocument" value="' + docId + '" id="docIdDocument' + id + '" />' +
                                '<input type="button" value="上传附件" class="button_normal_long" onclick="doUploadDocAttachs(' + id + ')"/>';
                        if (stageName == '未开工') {
                            //判断项目阶段的高亮显示（删除列时注意修改）
                            $("#" + id).find("td:eq(7)").css("background-color", " #f08080");
                        } else if (stageName == '在建') {
                            $("#" + id).find("td:eq(7)").css("background-color", "#add8e6");
                        } else if (stageName == '已完工') {
                            $("#" + id).find("td:eq(7)").css("background-color", "#90ee90");
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "年份", "op": "eq", "data": ""},
//                    { "field": "项目序号", "op": "cn", "data": ""},
                    { "field": "项目编号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });

    function doViewProject(id, name) {
        openWindow("查看项目推进信息（" + name + "）", "${ctx}/projectQueryProject/viewProject.do?id=" + id, false, 1000, 550);
    }

    function doViewStage(id, name) {
        openWindow("查看办证推进信息（" + name + "）", "${ctx}/projectQueryStage/viewStage.do?id=" + id, false, 1000, 550);
    }

    function doViewNode(id, name) {
        openWindow("查看形象进度信息（" + name + "）", "${ctx}/projectQueryNode/viewNode.do?id=" + id, false, 1000, 550);
    }

    function doUploadDocAttachs(prjId) {
        var docIdEle = $("#docIdDocument" + prjId + "");
        var params = "xmlConfig=${xmlconfig}&bizCode=" + $("#bizCode").val() + "&userId=${userId}&secondDir=";
        var isNewDoc = false;
        if (!docIdEle.val()) {
            isNewDoc = true;
            var rs = $.ajax({
                url: CONTEXT_NAME + "/docCommon/getDocument.do?" + params,
                async: false,
                success: function (data) {
                    $(docIdEle).val(data);
                }
            });
        }
        params += "&docId=" + docIdEle.val();
        var url = CONTEXT_NAME + "/docCommon/add.do?" + params;
        var windowId = "fileUpload";
        if ($('#' + windowId).length <= 0) {
            $("body").append("<div id=\"" + windowId + "\"></div>");
        }
        var left = ($(window).width() - 750) * 0.5 + 20;
        var top = ($(window).height() - 500) * 0.5 - 10;
        $('#' + windowId).window({
            title: "附件上传",
            loadingMessage: "正在加载数据......",
            iconCls: "icon-edit",
            width: 750,
            height: 500,
            left: left,
            top: top,
            content: createFrame(url, windowId + "iframe"),
            modal: true,
            shadow: true,
            minimizable: false,
            maximizable: true,
            closed: true,
            resizable: true,
            onClose: function () {
                $.ajax({
                    type: 'post',
                    url: '${ctx}/projectQueryStage/uploadProblematicDoc.do',
                    data: 'prjId=' + prjId + '&docId=' + docIdEle.val(),
                    async: false,
                    cache: false,
                    success: function () {
                        showInfoMsg("操作成功！", "info");
                        refreshGrid();
                    },
                    error: function () {
                        showErrorMsg("操作失败！");
                    }
                });
                if (isNewDoc && docIdEle.val()) {
                    $.get(CONTEXT_NAME + "/docCommon/getDelIsNull.do?docId=" + docIdEle.val(), function (msg) {
                        msg = eval("(" + msg + ")");
                        if (msg.success) {
                            docIdEle.val('');
                        }
                    });
//                refreshWindow();
                }
            }
        });
        $('#' + windowId).window('open');
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
            <c:if test="${canViewAll}">
                <input type="button" value="项目推进汇总" class="button_normal_longer" onclick="doViewProject('','汇总')"/>
                <input type="button" value="办证推进汇总" class="button_normal_longer" onclick="doViewStage('','汇总')"/>
                <input type="button" value="形象进度汇总" class="button_normal_longer" onclick="doViewNode('','汇总')"/>
            </c:if>
            <input type="hidden" id="bizCode" value="${bizCode}"/>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table style="border: 0 none;display: none;width: 100%;" class="ui-widget ui-widget-content" id="otherConditions">
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>项目性质:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projproperty" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="propertyL" items="${propertyList}">
                        <option value="${propertyL.name}">${propertyL.name}</option>
                    </c:forEach>
                </select>
                <select name="ismajor" class="form_select" style="width: 75px;">
                    <option value="">请选择</option>
                    <option value="1">重大</option>
                    <option value="0">非重大</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>项目状态:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projstage" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="projinfostage" items="${projinfostageList}">
                        <option value="${projinfostage.name}">${projinfostage.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="first"></td>
            <td class="columns" style='width: 15%;' nowrap>业务类别:&nbsp;</td>
            <td class="operators" style="display: none;">=</td>
            <td class="data">
                <select name="projcategory" class="form_select" style="width: 70px;">
                    <option value="">请选择</option>
                    <c:forEach var="projinfocategory" items="${projinfocategoryList}">
                        <option value="${projinfocategory.name}">${projinfocategory.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td></td>
        </tr>
    </table>
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>