<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${themePath}/jquery/easyui/default.css"/>
<script type="text/javascript">
    $(function () {
        $.parser.parse();
        $('#tabs').tabs({width: $("#tabs").parent().width(), height: $("#tabs").parent().height(), fit: true, border: false});
        $(window).resize(function () {
            setTimeout(function () {
                $('#tabs').tabs("resize");
            }, 500);
        });
        addTab("收件箱", "${ctx}/oaMailReceive/grid.do", "tab1");
        addTab("发件箱", "${ctx}/oaMailWait/grid.do", "tab2");
        addTab("已发送邮件", "${ctx}/oaMailSend/grid.do", "tab3");
        addTab("通讯录", "${ctx}/oaMailGroupUser/grid.do?tabNo=tab4", "tab4");
        addTab("写邮件", "${ctx}/oaMailNew/add.do", "tab5");
    });

    //tab按钮跳转
    function jumbTab(tabTitle) {
        $("#tabs").tabs("select", tabTitle);
    }
</script>

<div id="tabs" class="easyui-tabs1" style="width:100%;height:100%;"></div>