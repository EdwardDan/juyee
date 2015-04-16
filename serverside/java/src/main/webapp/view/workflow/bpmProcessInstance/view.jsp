<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabsFlow').tabs({width: $("#tabsFlow").parent().width(), height:$("#tabsFlow").parent().height(), fit: true, border:false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabsFlow').tabs("resize");
            }, 500);
        });
        addCustomTab("表单信息", "${ctx}/bpmProcessInstance/viewForm.do?processInstanceId=${processInstanceId}", "tab1_flow");
        addCustomTab("表单附件", "${ctx}/bpmProcessAttach/formAttachView.do?processInstanceId=${processInstanceId}&from=view", "tab2_flow");
        addCustomTab("流转日志", "${ctx}/bpmProcessLog/log.do?processInstanceId=${processInstanceId}&from=view", "tab3_flow");
    });
    //加载tab
    function addCustomTab(subtitle, url, id) {
        var isFirstLoad = true;
        if (!$('#tabsFlow').tabs('exists', subtitle)) {
            $('#tabsFlow').tabs('add', {
                title:subtitle,
                content:createFrame('', id),
                closable:false,
                closed:true,
//			icon:icon
                onOpen:function () {
                    if (isFirstLoad) {
                        isFirstLoad = false;
                    } else {
                        $("#" + id).attr("src", url);
                    }
                }
            });
        } else {
            $('#tabsFlow').tabs('select', subtitle);
            $('#mm-tabupdate').click();
        }
    }
</script>

<div id="tabsFlow" class="easyui-tabs1" style="width:100%;height:100%;"></div>