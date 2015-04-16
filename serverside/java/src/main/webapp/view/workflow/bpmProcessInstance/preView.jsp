<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${themePath}/workflow/workflow.css"/>
<script type="text/javascript" src="${ctx}/js/workflow.js"></script>

<script type="text/javascript">
    function jumpForm(value) {
        var v = 1;
        if (value.name == "left") {
            v = -1;
        }
        if ('${nowNo}' == '1' && value.name == 'left') {
            Ext.Msg.alert("提示", "已经是第一张！");
            return;
        }
        if ('${nowNo}' == '${no}' && value.name == 'right') {
            Ext.Msg.alert("提示", "已经是最后一张！");
            return;
        }
        var nowNo = v + ${nowNo};
        window.location = "preView.html?id=${id}&nowNo=" + nowNo;
    }

    function init() {
        var no = parseInt('${no}');
        if (no > 1) {
            document.getElementById("headTr").style.display = 'block';
        }
        process_main.location = "${ctx}/bpmProcessInstance/viewForm.do?processInstanceId=${id}&nowNo=${nowNo}&type=${type}";
    }
</script>

<body onload="init()" topmargin="0" leftmargin="0">
<table border="0" height="100%" width="100%">
    <tr id="headTr" style="display:none">
        <td align="center">
            <input type="button" name="left" class="button_normal_long" value="上一张" onclick="jumpForm(this);">
            &nbsp;${nowNo}/${no}&nbsp;
            <input type="button" name="right" class="button_normal_long" value="下一张" onclick="jumpForm(this);">
        </td>
    </tr>
    <tr>
        <td height="95%">
            <iframe name="process_main" id="process_main" src="${ctx}/blank.html" height="100%" frameborder="0"
                    width="100%"></iframe>
        </td>
    </tr>
</table>
</body>