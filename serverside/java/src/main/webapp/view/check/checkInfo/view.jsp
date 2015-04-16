<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">人员姓名：</td>
            <td class="form_content">&nbsp;
                ${bean.managerName}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">身份证号：</td>
            <td class="form_content">&nbsp;
                ${bean.cardNo}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">考勤时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.checkTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地编号：</td>
            <td class="form_content">&nbsp;
                ${bean.gdCode}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">设备序号：</td>
            <td class="form_content">&nbsp;
                ${bean.devSn}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">考勤状态（上班、下班）：</td>
            <td class="form_content">&nbsp;
                ${bean.checkStatus}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">识别标识（指纹、卡、指纹+面部）：</td>
            <td class="form_content">&nbsp;
                ${bean.verifyCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">经度：</td>
            <td class="form_content">&nbsp;
                ${bean.longitude}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">纬度：</td>
            <td class="form_content">&nbsp;
                ${bean.latitude}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">定位时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.positionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">GUID：</td>
            <td class="form_content">&nbsp;
                ${bean.guid}                    </td>
        </tr>
        <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>