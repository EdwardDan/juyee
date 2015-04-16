<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@include file="/common/header.jsp" %>
<base target="_self">
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name:"name", rule:"validate[required,maxSize[100]]"},
            {name:"category", rule:"validate[required,maxSize[100]]"}
//          {name:"formPar", rule:"validate[required,maxSize[100]]"}
            //{name:"orderNo", rule:"validate[required,custom[integer],max[10]"},
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function formCheck() {
        if (!validateForm(formId)) {
            return;
        }
        disableBtn($("#ok"));
    }
</script>
<form:form commandName="bean" method="post" action="${ctx}/bpmFormTemplate/save.do" onsubmit="return formCheck();"
           id="bean"
           enctype="multipart/form-data">
    <form:hidden path="id" id="id"/>
    <input type="hidden" value='${gridParam}'>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td align="right">模板编码：</td>
                <td class="form_content">
                    <form:input path="code" cssClass="input_text"/>（注：可以使用名称的拼音首字母缩写方式命名）
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">名称：</td>
                <td class="form_content">
                    <form:input path="name" cssClass="input_text"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label">分类：</td>
                <td class="form_content">
                        <%--<c:out value="${bean.category.name}"></c:out>--%>
                        <%--<input type="hidden" name="category" value="${bean.category.id}">--%>
                    <sys:code code="${infoType}" name="category" type="select" defaultName=""
                              sysCodeDetailId="${bean.category.id}" disabled="" id="category"
                              isAlowedNull="true"
                              onChange=""/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label">选择par：</td>
                <td class="form_content">
                    <input type="file" name="formPar" id="formPar" class="input_text" style="width:215px"/>
                </td>
            </tr>
            <table cellpadding="1" cellspacing="1" class="form_table" bgcolor="#e6e6fa">
                <tr class="tr_dark">
                    <td colspan="6">字段映射</td>
                </tr>
                <div class="form_table">
                    <table cellpadding="1" cellspacing="1" class="form_table">
                        <tr class="tr_header" align="center">
                            <td width="30%" nowrap>数据库字段</td>
                            <td width="20%" nowrap>模板定义KEY</td>
                            <td width="20%" nowrap>列表显示名称</td>
                            <td width="10%" nowrap>列表显示宽度</td>
                            <td width="5%" nowrap>是否生效</td>
                            <td width="5%" nowrap>列表显示</td>
                        </tr>
                        <c:forEach items="${list}" var="listcolumn" varStatus="s">
                            <input type="hidden" name="no">
                            <tr class="tr_dark" align="center">
                                <td nowrap>
                                    <input type="text" class="input_none" name="column_${s.index+1}"
                                           id="column_${s.index+1}"
                                           value="${listcolumn.column}"
                                           readonly style="text-align:center">
                                </td>
                                <td nowrap>
                                    <input type="button" value="=" class="button_normal"
                                           onclick="document.getElementById('key_${s.index+1}').value = document.getElementById('column_${s.index+1}').value">
                                    <input type="text" class="input_text" name="key_${s.index+1}"
                                           value="${listcolumn.key}" id="key_${s.index+1}">
                                    <input type="button" value=" " class="button_select"
                                           onclick="selectFormKey('${bean.id}',key_${s.index+1},null)"/>
                                    &nbsp;&nbsp;
                                </td>
                                <td nowrap>
                                    <input type="text" class="input_text" name="gridName_${s.index+1}"
                                           value="${listcolumn.gridName}">

                                </td>
                                <td nowrap>
                                    <input type="text" class="input_text" name="gridWidth_${s.index+1}"
                                           value="${listcolumn.gridWidth}" style="width:60px">%
                                </td>
                                <td nowrap>
                                    <input type="checkbox" name="isValid_${s.index+1}" value="1"
                                           <c:if test="${listcolumn.isValid}">checked</c:if>>
                                </td>
                                <td nowrap>
                                    <input type="checkbox" name="isGridShow_${s.index+1}" value="1"
                                           <c:if test="${listcolumn.isGridShow}">checked</c:if>>
                                </td>
                            </tr>
                        </c:forEach>

                        <tr class="tr_light">

                            <td class="form_content" colspan="6" style="text-align: center;">
                                <input type="submit" value="确定" id="ok" class="button_confirm">&nbsp;
                                <input type="reset" value="重写" class="button_confirm">&nbsp;
                                <input type="button" value="取消" class="button_cancel" onclick="window.close()">
                            </td>
                        </tr>
                    </table>
                </div>
            </table>
        </table>
    </div>

</form:form>