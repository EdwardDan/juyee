<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/default.js"></script>
    <script type="text/javascript">
        $(function () {
            refreshTaskIcon(null);

            $(document).click(function() {
                parent.hideWin();  //隐藏父窗口中的菜单DIV
            });
        });

        //刷新推送图标
        function refreshTaskIcon(flag){
            loadAjaxData("taskDivId", "${ctx}/mainPage/mainTask.do");
        }
    </script>
    <link href="${themePath}/style_index.css" rel="stylesheet" type="text/css"/>
</head>

<body scroll=no>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td style="background-image: url('${themePath}/index_new/scrollpic_left.png');background-repeat: no-repeat;width: 11px;height: 144px"></td>
        <td style="background-image: url('${themePath}/index_new/scrollpic_middle.png');background-repeat: repeat-x;width: auto;">
            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="3%"><img src="${themePath}/index_new/kjfs9.jpg" width="20" height="29" id="taskBtnPrev" onclick="refreshTaskIcon('prev')" style="cursor: pointer"/></td>
                    <td width="94%" id="taskDivId">&nbsp;</td>
                    <td width="3%" align="right"><img src="${themePath}/index_new/kjfs10.jpg" width="20" height="29" id="taskBtnNext" onclick="refreshTaskIcon('next')" style="cursor: pointer"/></td>
                </tr>
            </table>
        </td>
        <td style="background-image: url('${themePath}/index_new/scrollpic_right.png');background-repeat: no-repeat;width: 11px;height: 144px"></td>
    </tr>
</table>
</body>
</html>