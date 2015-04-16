<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            {name: "bjbh", rule: "validate[required,maxSize[30]]"}
        ];
        validateInit(validateCondition, formId);

        <c:choose>
        <c:when test="${fn:length(bjbhs)==1}">
        doNext(null, null);
        </c:when>
        <c:otherwise>
        loadProj();
        </c:otherwise>
        </c:choose>
    });

    function doNext(status, btn) {
        if (!validateForm(formId)) {
            return;
        }
        var url = "${ctx}/${url}";
        if (url.indexOf("?") > 0) {
            url += "&bjbh=" + $("#bjbh1").val()
        } else {
            url += "?bjbh=" + $("#bjbh1").val()
        }

        if (url.indexOf("jdJlReport") > 0) {  //监理报告上传
            openWindow("${title}", url, true, 800, 500);
        } else { //创优申报
            openWindow("${title}", url, true);
        }
    }

    //根据报建编号获取工程信息
    function loadProj() {
        loadProjectInfoByCode(null, document.getElementById("bjbh1").value, null, true, true);
    }
</script>
<form:form commandName="bean">
    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_light" height="30">
                <td class="form_label" colspan="2"></td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label" align="right" nowrap>报建编号：</td>
                <td class="form_content">${bean.bjbh}
                    <select name="bjbh1" id="bjbh1" class="form_select" onchange="loadProj()">
                        <c:forEach items="${bjbhs}" var="item">
                            <option value="${item}" <c:if test="${bean.bjbh==item}">selected</c:if>>${item}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">工程名称：</td>
                <td class="form_content">
                    <span id="projectName"></span>
                </td>
            </tr>

            <tr class="tr_button">
                <td class="form_content" colspan="2" style="text-align: center">
                    <input id="submit" name="submit" type="button" value="下一步" class="button_normal_long"
                           onclick="doNext('',this)">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>