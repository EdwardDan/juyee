<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {

    });
    function selectProjectType(btn) {
        var projectType = $("#projectType").val();
        if (null != projectType || '' != projectType) {
            openWindow("添加施工许可证", "${ctx}/sgPermit/frame.do?id=&act=add&projectTypeId=" + projectType, true, 850, 500);
        }
    }
</script>

<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td style="text-align: center;">
                <div class="div_space" style="height: 30px;"></div>
            </td>
        </tr>
        <tr class="tr_light">
            <td style="text-align: center;">
                <select name="projectType" id="projectType" class="form_select_long" style="width:150px;">
                    <c:forEach items="${list}" var="item">
                        <option value="${item.id}">${item.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="tr_button" style="text-align: center;">
            <td class="form_content" style="text-align: center;">
                <input type="button" value="确定" class="button_confirm" onclick="selectProjectType(this)">&nbsp;
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>