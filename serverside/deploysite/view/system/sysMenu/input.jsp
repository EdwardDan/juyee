<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required]"},
            {name:"privilege", rule:"validate[required]"},
            {name:"menuLevel", rule:"validate[custom[integer],maxSize[3]"}
            //{name:"url", rule:"validate[required]"},
            //{name:"jsEvent", rule:"validate[required]"},
            //{name:"isLeaf", rule:"validate[required]"},
            //{name:"treeId", rule:"validate[required]"},
            //{name:"isValid", rule:"validate[required]"},
            //{name:"param", rule:"validate[required]"},
            //{name:"target", rule:"validate[required]"},
            //{name:"icon", rule:"validate[required]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(btn) {
        if (!validateForm(formId)) {
            return;
        }

        //提交表单
        disableBtn(btn);
        saveAjaxData("${ctx}/sysMenu/save.do", formId);
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <input type="hidden" name="parent" value="${bean.parent.id}"/>
    <form:hidden path="platform"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light">
                <td class="form_label">名称:</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">编码:</td>
                <td class="form_content">
                    <form:input path="privilege" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">层次:</td>
                <td class="form_content">
                    <form:input path="menuLevel" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">链接地址:</td>
                <td class="form_content">
                    <form:input path="url" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">事件:</td>
                <td class="form_content">
                    <form:input path="jsEvent" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">是否有效:</td>
                <td class="form_content">
                    <form:checkbox path="isValid" value="1"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">参数:</td>
                <td class="form_content">
                    <form:input path="param" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">目标窗口:</td>
                <td class="form_content">
                    <form:input path="target" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">显示图标:</td>
                <td class="form_content">
                    <table border="0" align="left" width="95%">
                        <tr>
                            <c:forEach items="${MENU_ICON_LIST}" var="item" varStatus="status">
                            <td align="left" nowrap width="5%">
                                <input type="radio" name="icon" id="icon" <c:if test="${item == bean.icon}">checked</c:if> value="${item}"><img src="${themePath}/index_new/menu_icon/${item}.png" border="0" title="${item}.png"/>
                            </td>
                            <c:if test="${status.index>0 && (status.index+1) % 5 == 0}">
                        </tr>
                        <tr>
                            </c:if>
                            </c:forEach>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr class="tr_button">
                <td class="form_label"></td>
                <td class="form_content">
                    <input type="button" value="确定" class="button_confirm" onclick="save(this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>