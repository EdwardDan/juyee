<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_title">
            <td colspan="5">上海市政局</td>
        </tr>
        <tr class="tr_light">
            <td class="form_content" style="width: 10%;"></td>
            <td class="form_content" style="width: 33%;">
                文种：${bean.type.name}
            </td>
            <td class="form_content" style="width: 33%;">
                密级：${bean.secret.name}
            </td>
            <td class="form_content" style="width: 33%;">
                （${bean.fileCode} ）号
            </td>
            <td class="form_content" style="width: 10%;"></td>
        </tr>
        <tr>
            <td colspan="5">
                <table cellpadding="0" cellspacing="0" class="form_table">
                    <tr class="tr_light">
                        <td class="form_label_right">发文标题：</td>
                        <td class="form_content" colspan="3">${bean.fileTitle}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">主送机关：</td>
                        <td class="form_content" colspan="3">${bean.sendDept}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right">抄送机关：</td>
                        <td class="form_content" colspan="3">${bean.ccDept}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">成文机关：</td>
                        <td class="form_content" colspan="3">${bean.writtenDept}</td>
                    </tr>
                    <tr class="tr_light">
                        <td class="form_label_right" style="width: 15%;">成文日期：</td>
                        <td class="form_content" style="width: 35%;">
                            <fmt:formatDate value="${bean.writtenDate}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td class="form_label_right" style="width: 15%;">紧急程度：</td>
                        <td class="form_content" style="width: 35%;">${bean.emergency.name}</td>
                    </tr>
                    <tr class="tr_dark">
                        <td class="form_label_right">附件：</td>
                        <td class="form_content" colspan="3">${docButton}</td>
                    </tr>

                </table>
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="5" style="text-align: center;">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>