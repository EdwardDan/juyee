<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<style type="text/css">
    #box {
        font-size: 12px;
        padding-top: 100px;
        cursor: pointer;
    }

    .hover {
        background-color: #0099FF;
        color: #FFFFFF;
    }
</style>
<script type="text/javascript">
    var formId = "bean";
    $(function () {

        //页面验证初始化
        var validateCondition = [

        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysRole/savePrivilege.do", formId);
    }

    /**
     *如果选择父项是子项会自动被选上。
     * @param startTreeId .
     * @param checkBox .
     */
    function checkChildren(startTreeId, checkBox) {
        var startTreeIdLength = startTreeId.length;
        var treeIds = document.getElementsByName("treeId");
        var sysPrivilegeIds = document.getElementsByName("sysPrivilegeId");
        var length = sysPrivilegeIds.length;
        var checkStatus = checkBox.checked;
        for (var i = 0; i < length; i++) {
            var treeId = treeIds[i].value;
            if ((treeId.length >= startTreeIdLength) && (treeId.substr(0, startTreeIdLength) == startTreeId)) {
                sysPrivilegeIds[i].checked = checkStatus;
            }
        }
    }

    function changeBackground(startTreeId, state) {
        var startTreeIdLength = startTreeId.length;
        var treeIds = document.getElementsByName("treeId");
        var sysPrivilegeIds = document.getElementsByName("sysPrivilegeId");
        var length = sysPrivilegeIds.length;
        var color;
        if (state == 'over') {
            color = "#ddffdf";
        } else if (state == 'out') {
            color = "";
        }

        for (var i = 0; i < length; i++) {
            var treeId = treeIds[i].value;
            if ((treeId.length >= startTreeIdLength) && (treeId.substr(0, startTreeIdLength) == startTreeId)) {
                $("#" + sysPrivilegeIds[i].value).css("background", color);
            }
        }
    }

    //选择全选时所有选项都被自动选上。
    function checkAll() {
        var selectStatus = document.getElementById("selectAll").checked;
        var sysPrivilegeIds = document.getElementsByName("sysPrivilegeId");
        var length = sysPrivilegeIds.length;
        for (var i = 0; i < length; i++) {
            sysPrivilegeIds[i].checked = selectStatus;
        }
    }

</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark" align="center">
                <td colspan="2" align="center">权限选择（全选/全不选<input type="checkbox" id="selectAll" onclick="checkAll()">）
                </td>
            </tr>

            <tr class="tr_light">
                <td width="38%" nowrap align="right">&nbsp;</td>
                <td width="62%" nowrap align="left">
                    <c:forEach items="${list}" var="item">
                        <div style="height:30px" id="${item.sysPrivilege.id}"
                             onmouseover="changeBackground('${item.sysPrivilege.treeId}', 'over')"
                             onmouseout="changeBackground('${item.sysPrivilege.treeId}', 'out')"
                                >
                                ${item.space}
                            <input type="checkbox" name="sysPrivilegeId"
                                   onclick="checkChildren('${item.sysPrivilege.treeId}',this)"
                                   value="${item.sysPrivilege.id}"
                                   <c:if test="${item.isChecked}">checked</c:if> align="absmiddle">
                            <c:choose>
                                <c:when test="${item.sysPrivilege.type.id == buttonType}">
                                    ${item.sysPrivilege.name}
                                </c:when>
                                <c:otherwise>
                                    <b>${item.sysPrivilege.name}</b>
                                </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="treeId" value="${item.sysPrivilege.treeId}">
                        </div>
                    </c:forEach>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_border" colspan="2" align="center">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>