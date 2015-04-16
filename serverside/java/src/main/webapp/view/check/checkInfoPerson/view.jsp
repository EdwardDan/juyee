<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">


        <tr class="tr_dark">
            <td class="form_label_right" width="18%">姓名：</td>
            <td class="form_content" width="60%">&nbsp;
                ${bean.checkManager.name}
            </td>
            <td class="table_tr_line" width="4%" rowspan="5" style="text-align: center">照<br/>片</td>
            <td valign="top" rowspan="5">
                <div align="left">
                    <c:choose>
                        <c:when test="${not empty bean.checkManager.photoFile}">
                            <img width="100" height="135" src="${ctx}/uploads/doc${bean.checkManager.photoFile}"/>
                        </c:when>
                        <c:otherwise>
                            <img width="95" height="135" src="${themePath}/images/no_picture.gif" alt="暂无照片"/>
                        </c:otherwise>
                    </c:choose>
                </div>
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">性别：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.checkManager.sex == 1}">男</c:when><c:otherwise>女</c:otherwise></c:choose>
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">身份证号：</td>
            <td class="form_content">&nbsp;
                ${bean.checkManager.cardNo}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">手机号码：</td>
            <td class="form_content">&nbsp;
                ${bean.checkManager.mobile}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">岗位名称：</td>
            <td class="form_content">&nbsp;
                ${bean.positionName}
            </td>
        </tr>

        <tr class="tr_light">
            <td class="form_label_right">证书编号：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.certificateCode}
            </td>
        </tr>

        <tr class="tr_dark">
            <td class="form_label_right">证书名称：</td>
            <td class="form_content" colspan="3">&nbsp;
                ${bean.certificateName}
            </td>
        </tr>

        <tr class="tr_button">
            <td class="form_border" colspan="4">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>

    </table>
</div>