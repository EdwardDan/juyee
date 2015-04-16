<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label">监督任务书编号：</td>
            <td class="form_content">&nbsp;
                ${bean.jdTaskCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">报建编号：</td>
            <td class="form_content">&nbsp;
                ${bean.bjbh}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">工地编号：</td>
            <td class="form_content">&nbsp;
                ${bean.gdCode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地名称：</td>
            <td class="form_content">&nbsp;
                ${bean.gdName}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">所属区县：</td>
            <td class="form_content">&nbsp;
                ${bean.belongArea}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">街镇：</td>
            <td class="form_content">&nbsp;
                ${bean.streetArea}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">工地经度：</td>
            <td class="form_content">&nbsp;
                ${bean.longitude}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">工地纬度：</td>
            <td class="form_content">&nbsp;
                ${bean.latitude}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">设备名称：</td>
            <td class="form_content">&nbsp;
                ${bean.devName}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">设备序号：</td>
            <td class="form_content">&nbsp;
                ${bean.devSn}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">设备型号：</td>
            <td class="form_content">&nbsp;
                ${bean.devMode}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">设备SIM卡：</td>
            <td class="form_content">&nbsp;
                ${bean.devSim}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">设备IP：</td>
            <td class="form_content">&nbsp;
                ${bean.devIp}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">定位经度：</td>
            <td class="form_content">&nbsp;
                ${bean.currentLongitude}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">定位纬度：</td>
            <td class="form_content">&nbsp;
                ${bean.currentLatitude}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">定位时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.positionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">最近联机时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.lastOnlineTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">设备联机状态：</td>
            <td class="form_content">&nbsp;
                ${bean.onlineStatus}                    </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">是否同步：</td>
            <td class="form_content">&nbsp;
                <c:choose><c:when test="${bean.isSync}">是</c:when><c:otherwise>否</c:otherwise></c:choose>
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">注册时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.regDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">注册操作人：</td>
            <td class="form_content">&nbsp;
                ${bean.regUserName}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">注销时间：</td>
            <td class="form_content">&nbsp;
                <fmt:formatDate value="${bean.cancelDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label">注销状态：</td>
            <td class="form_content">&nbsp;
                ${bean.cancelStatus}                    </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label">注销操作人：</td>
            <td class="form_content">&nbsp;
                ${bean.cancelUserName}                    </td>
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