<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<script src="${ctx}/js/fckeditor/fckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(status, buttonName) {
        if (!validateForm(formId)) {
            return;
        }
        var oEditor = FCKeditorAPI.GetInstance('contentFck');
        $("#content").val(oEditor.GetXHTML());
        //加入其他业务判断
        var content = $("#content").val();
        if (content == '') {
            showInfoMsg("发布内容未输入！", null);
            return false;
        }

        //提交表单
        if (buttonName != "") {
            if (confirm("提交之后将不能再修改，确定继续吗？")) {
                saveAjaxData("${ctx}/oaQuarterplanSum/save.do?status=" + status, formId, null);
            }
        } else {
            saveAjaxData("${ctx}/oaQuarterplanSum/save.do?status=" + status, formId, null);
        }
    }

</script>

<style type="text/css">
    .input_text_short {
        font-size: 12px;
        border: 1px solid #b8b6b9;
        color: #007DBC;
        background-color: #FFFFFF;
        width: 100px;
        height: 20px;
    }

    .input_number_short {
        font-size: 12px;
        color: #007DBC;
        border: 1px solid #b8b6b9;
        background-color: #FFFFFF;
        width: 50px;
        height: 20px;
    }
</style>

<form:form commandName="bean">
    <form:hidden path="id"/>

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr height="50">
                <td colspan="2" align="center">
                    <span class="net_form_title">
                        <%--虹口建管署${bean.year}年<c:if test="${not empty bean.period}">第${bean.period}季度</c:if>主要工作完成--%>
                        虹口建管署${yearPeriodName}主要工作完成
                        <input type="hidden" id="year" name="year" value="${bean.year}">
                        <input type="hidden" id="period" name="period" value="${bean.period}">
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset class="form_fieldset" style="width: 96%;margin: 0 auto;display: true;">
                        <legend class="form_legend">季度/年度汇总</legend>
                        <table cellpadding="0" cellspacing="0" class="form_table" id="table1">
                            <c:if test="${empty bean.id}">
                                <c:forEach items="${oaQuarterplans}" var="itemAdd" varStatus="status">
                                    <input type="hidden" name="itemId" value="${itemAdd.id}"/>
                                </c:forEach>
                                <tr class="tr_dark">
                                    <td class="form_label_right" width="25%" nowrap>发布内容：</td>
                                    <td class="form_content" nawrap>
                                        <textarea style="display:none" id="contentFck" name="contentFck"
                                                  class="input_textarea">${sumContent}</textarea>
                                        <script language="javascript">
                                            var oFCKeditor = new FCKeditor('contentFck');
                                            oFCKeditor.Width = "780";
                                            oFCKeditor.Height = "500";
                                            oFCKeditor.BasePath = '${ctx}/js/fckeditor/';
                                            oFCKeditor.Value = '';
                                            oFCKeditor.ReplaceTextarea();
                                        </script>
                                        <textarea hidden="true" id="content"
                                                  name="content">${sumContent}</textarea>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty bean.id}">
                                <c:forEach items="${bean.oaQuarterplanSumItems}" var="item" varStatus="status">
                                    <input type="hidden" name="itemId" value="${item.quarterplanItem.id}"/>
                                </c:forEach>
                                <tr class="tr_dark">
                                    <td class="form_label_right" width="25%" nowrap>发布内容：</td>
                                    <td class="form_content" nawrap>
                                        <textarea style="display:none" name="contentFck"
                                                  class="input_textarea">${bean.sumContent}</textarea>
                                        <script language="javascript">
                                            var oFCKeditor = new FCKeditor('contentFck');
                                            oFCKeditor.Width = "780";
                                            oFCKeditor.Height = "500";
                                            oFCKeditor.BasePath = '${ctx}/js/fckeditor/';
                                            oFCKeditor.Value = '';
                                            oFCKeditor.ReplaceTextarea();
                                        </script>
                                        <textarea hidden="true"
                                                  name="content">${bean.sumContent}</textarea>
                                    </td>
                                </tr>
                            </c:if>
                        </table>
                    </fieldset>
                </td>
            </tr>

            <tr class="tr_button" align="center">
                <td class="form_border" colspan="2">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save('${STATUS_SUBMIT}',this.value)">&nbsp;
                    <input type="button" value="暂存" class="button_confirm" onclick="save('${STATUS_EDIT}','')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow();">
                </td>
            </tr>
        </table>
    </div>

</form:form>
