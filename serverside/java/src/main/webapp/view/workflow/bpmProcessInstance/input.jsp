<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>
<script type="text/javascript">
    var formId = "bean";

    function doSave(btn) {
        if (!validateForm(formId)) {
            return;
        }

        var result = getRawData();
        var ccUserIds = "";
        if (checkObj("ccUserIds")) {
            ccUserIds = $("#ccUserIds").val();
        }
        var param = "xmlData=" + result + "&bpmTaskInstanceId=${bpmTaskInstanceId}&ccUserIds=" + ccUserIds;
        btn.disabled = true;
        saveAjaxData("${ctx}/bpmProcessInstance/saveForm.do?" + encodeURI(param), null, null, null);
        setTimeout(function () {
            btn.disabled = false;
        }, 5000);
    }

    function doSaveNoPrompt() {
        var result = getRawData();
        var param = "xmlData=" + result + "&bpmTaskInstanceId=${bpmTaskInstanceId}";
        loadAjaxData(null, "${ctx}/bpmProcessInstance/saveForm.do?" + encodeURI(param));
    }

    //表单提交
    function doSub(btn, bpmProcessTransitionId, toNodeName) {
        if (!validateForm(formId)) {
            return;
        }
        if (!confirm("确定要提交吗？")) {
            return;
        }

        var result = getRawData();
        document.bean.action = "${ctx}/bpmProcessInstance/submitCheck.do";
        document.bean.xmlData.value = result;

        if (bpmProcessTransitionId != "") {
            document.bean.bpmProcessTransitionId.value = bpmProcessTransitionId;
        }
        document.bean.toNodeName.value = toNodeName;
        btn.disabled = true;
        document.bean.submit();
    }

    //上传附件
    function doAttach() {
        parent.openWindow("查看附件", "${ctx}/bpmProcessAttach/formAttach.do?bpmTaskInstanceId=${bpmTaskInstanceId}&act=${act}", false, 700, 400);
    }

    //查询附件数量
    function getAttachNum() {
        $.ajax({
            url:"${ctx}/bpmProcessAttach/getAttachNum.do",
            cache:false,
            async:false,
            data:"bpmTaskInstanceId=${bpmTaskInstanceId}",
            success:function (ret) {
                $("#btnFJ").val(ret.trim());
            }
        });
    }

    //日志
    function viewLog() {
        parent.openWindow("查看日志", "${ctx}/bpmProcessLog/log.do?processInstanceId=${bpmProcessInstanceId}", false, 850, 500);
    }

    //弹出审核操作层
    function popup_show() {
        //先保存
        doSaveNoPrompt();

        //如果是表单审核那么指向表单审核页面，否则指向标准操作页面
        var isFormAudit = true;
        //operateType==2 为审核操作
        if ("${operateType}" == 2) {
            isFormAudit = false;
        }

        var element;
        if (isFormAudit) {
            //弹出审核操作层--表单操作
            element = document.getElementById('popup_form');
            popup_exit_form();
            loadAjaxData("audit_form", "${ctx}/bpmProcessInstance/formOperation.do?bpmTaskInstanceId=${bpmTaskInstanceId}");
        } else {
            //弹出审核操作层--标准操作
            element = document.getElementById('popup_standard');
            popup_exit_standard();
            loadAjaxData("audit_standard", "${ctx}/bpmProcessInstance/standardOperation.do?bpmTaskInstanceId=${bpmTaskInstanceId}");
        }

        element.style.left = (document.body.clientWidth / 2) - 250 + 'px';
        //        element.style.top = document.getElementById("audit_button").style.top;
        element.style.top = 50 + 'px';
        element.style.position = "absolute";
        element.style.visibility = "visible";
        element.style.display = "block";
    }
    //关闭审核操作层
    function popup_exit_form() {
        var element = document.getElementById('popup_form');
        element.style.visibility = 'hidden';
        element.style.display = 'none';
    }
    //关闭审核操作层--标准操作
    function popup_exit_standard() {
        var element = document.getElementById('popup_standard');
        element.style.visibility = 'hidden';
        element.style.display = 'none';
    }

    //初始化-是否允许操作
    function init() {
        lock();
        workflowValidateInit(formId);
    }

    //显示操作按钮，如不锁定则无法看到保存和审核按钮
    function showAuditButton(isShow){
        var element = document.getElementById('audit_button');
        //            element.style.left = (document.body.clientWidth - 30) + 'px';
        //            element.style.top = (document.body.clientHeight /2)-80 + 'px';
        element.style.left = '0px';
        element.style.top = '0px';
        element.style.position = "absolute";
        element.style.visibility = "visible";
        element.style.display = "block";

        if(!isShow){
            $("#btnBC").hide();
            $("#btnFJ").hide();
            $("#btnSH").hide();
        }
    }

    //当节点上有多人审核时，提示是否锁定
    function lock() {
        if ("${actorSize}" != "" && "${actorSize}" > 1) {
            $.messager.confirm('系统提示', '您是否要进行当前步骤操作?', function (r) {
                if (r) {
                    $.ajax({
                        url:"${ctx}/bpmProcessInstance/lock.do",
                        cache:false,
                        async:false,
                        data:"bpmTaskInstanceId=${bpmTaskInstanceId}",
                        success:function (html) {
                            showAuditButton(true);
                        },
                        failure:function (html) {
                            showAuditButton(false);
                            $.prompt('操作失败！');
                        }
                    });
                } else {
                    showAuditButton(false);
                }
            });
        }else{
            showAuditButton(true);
        }
    }

    function formChange(formDataId) {
        var url = "${ctx}/bpmProcessInstance/input.do?bpmTaskInstanceId=${bpmTaskInstanceId}&formDataId=" + formDataId;
        url += "&gridParam=" + '${gridParam}';
        window.location = url;
    }
</script>
<script type="text/javascript">
    //层跟随滚动
    $(document).ready(function () {
        //增加输入框的激活样式
        eventFocus("text");
        eventFocus("textarea");
        eventFocus("date");
        $("td").css({"padding-top":"0px", "padding-bottom":"0px"});  //避免出现下边线条不全
        $("table").css({"background-color":"#f4f8ff"});
        $("body").css({"background-color":"#f4f8ff"});
    });
    function scrollObj_operation(objId) {
        var menuYloc = $("#" + objId).offset().top;
        var y = 0;
        $(window).scroll(function () {
            var offsetTop = menuYloc + $(window).scrollTop() + y + "px";
            $("#" + objId).animate({top:offsetTop }, { duration:600, queue:false });
        });
    }
    function scrollObj(objId) {
        var menuYloc = $("#" + objId).offset().top;
        var y = 200;
        $(window).scroll(function () {
            var offsetTop = menuYloc + $(window).scrollTop() + y + "px";
            $("#" + objId).animate({top:offsetTop }, { duration:600, queue:false });
        });
    }

    function eventFocus(inputType) {
        //获得焦点
        var obj;
        obj = $(".flow_" + inputType);
        obj.focus(function () {
            // 添加 Class
            $(this).addClass("flow_" + inputType + "_over");
        });

        obj.blur(function () {
            // 添加 Class
            $(this).removeClass("flow_" + inputType + "_over");
            $(this).addClass("flow_" + inputType + "");
        });
    }

    function doClose() {
        window.opener.refreshIframGrid('tab1', null);
        self.close();
    }

    function jumpBackPage(){
        window.location = '${ctx}/bpmProcessInstance/grid.do?type=${type}&categoryCode=${categoryCode}&processDefinitionCode=${bpmProcessDefinition.code}';
    }
</script>

<body onload="init();transfer2Num();" <c:if test="${from == 'task'}">onunload="doClose();"</c:if>>
<!-- 操作区域无缝滚动-->
<div id="scrollDiv"
     style="width: 100%;height: 100%; overflow: auto;position: absolute; cursor: default; display: inline;margin-top:0px">
    <!-- 保留操作区域高度-->
    <div height="25">&nbsp;</div>
    <form action="${ctx}/bpmProcessInstance/save.do" name="bean" id="bean" method="post">
        <input type="hidden" name="bpmProcessTransitionId" value="">
        <input type="hidden" name="xmlData">
        <input type="hidden" name="userName" id="userName" value="${userName}">
        <input type="hidden" name="currenttime" id="currenttime" value="${currenttime}">
        <input type="hidden" name="toNodeName" id="toNodeName" value="">
        <input type="hidden" name="from" id="from" value="${from}">
        <input type="hidden" name="categoryCode" id="categoryCode" value="${categoryCode}">

        <!-- form html code begin -->
        <div align="center" style="margin-top:20px">
            ${bizHtml}<br><br>
        </div>
        <!-- form html code end -->

        <%--<div align="center">--%>
        <%--<jsp:include page="DocumentAttach.jsp"></jsp:include>--%>
        <%--</div>--%>

        <%--<link rel="stylesheet" type="text/css" href="${themePath}/workflow/style.css"/>--%>
        <style type="text/css">
            td {
                font-family: "宋体";
                font-size: 12px;
            }
        </style>

        <!-- operation area begin -->
        <div id="audit_button" class="fixed_title_row">
            <!-- operation button begin -->
            <table cellpadding="0" cellspacing="0" border="0" class="sptable_line_blue" align="right">
                <tr>
                    <td nowrap align="right">
                        <input name="btnBC" id="btnBC" type="button" class="spbutton_save" value="保存"
                               onclick="doSave(this)" <c:if test="${act == 'view'}">style="display:none"</c:if>/>
                        <input name="btnFJ" id="btnFJ" type="button" class="spbutton_fj" value="附件${attachsNum}"
                               onclick="doAttach();"/>
                        <input name="btnSH" id="btnSH" type="button" class="spbutton_sh" value="审核" onclick="popup_show()"
                               <c:if test="${act == 'view'}">style="display:none"</c:if>/>
                        <c:if test="${operateType=='2'&& fn:length(formDatas)>1}">
                            <select name="formDataId" onchange="formChange(this.value)">
                                <c:forEach items="${formDatas}" var="formData">
                                    <option value="${formData.id}"
                                            <c:if test="${bpmFormTemplateId==formData.bpmFormTemplate.id}">selected</c:if>
                                            >${formData.bpmFormTemplate.name}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                        <input name="btnRZ" id="btnRZ" type="button" class="spbutton_rz" value="日志" onclick="viewLog()"/>
                        <c:choose>
                            <c:when test="${from == 'task'}">
                                <input name="btnFH" type="button" class="spbutton_fh" value="关闭"
                                       onclick="doClose();"/>
                            </c:when>
                            <c:otherwise>
                                <input name="btnFH" type="button" class="spbutton_fh" value="返回"
                                       onclick="jumpBackPage()"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
            <!-- operation button end -->

            <!-- form operation code begin -->
            <div class="popup_form" id="popup_form" style="visibility:hidden;display:none">
                <table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
                    <tr class="popup_form_head">
                        <td width="95%">&nbsp;表单审核操作</td>
                        <td width="30" nowrap align="right"><img src="${themePath}/workflow/tck_2.jpg"
                                                                 onclick="popup_exit_form()"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" height="99%" style="vertical-align:top;" bgcolor="#E5F8FC" id="audit_form">

                        </td>
                    </tr>
                </table>
            </div>
            <!-- form operation code end -->

            <!-- standard operation code begin -->
            <div class="popup_standard" id="popup_standard" style="visibility:hidden;display:none;height:320px">
                <table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
                    <tr class="popup_form_head">
                        <td width="95%">&nbsp;标准审核操作</td>
                        <td width="30" nowrap align="right">
                            <img src="${themePath}/workflow/tck_2.jpg" onclick="popup_exit_standard()"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" height="99%" style="vertical-align:top;" bgcolor="#E5F8FC" id="audit_standard">

                        </td>
                    </tr>
                </table>
            </div>
            <!-- standard operation code end -->
        </div>
        <!-- operation area end -->
    </form>
</div>
</body>