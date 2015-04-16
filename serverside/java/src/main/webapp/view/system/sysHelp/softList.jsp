<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_header">
            <td class="form_border" width="5%" nowrap>序号</td>
            <td class="form_border" width="10%" nowrap>类别</td>
            <td class="form_border" width="50%" nowrap>附件名称</td>
            <td class="form_border" width="10%" nowrap>操作</td>
        </tr>
        <tr class="tr_light">
            <td class="form_border">1</td>
            <td class="form_border" nowrap>&nbsp;浏览器插件</td>
            <td class="form_border" align="left">&nbsp;视频监控播放插件（setup_video.exe）</td>
            <td class="form_border" nowrap>&nbsp;<input type="button" value="下载" class="button_normal" onclick="window.open('${ctx}/tools/setup_video.exe')"></td>
        </tr>
        <tr class="tr_dark">
            <td class="form_border">2</td>
            <td class="form_border" nowrap>&nbsp;常用软件</td>
            <td class="form_border" align="left">&nbsp;好讯即时通讯软件（IMClient.zip）</td>
            <td class="form_border" nowrap>&nbsp;<input type="button" value="下载" class="button_normal" onclick="window.open('${ctx}/tools/IMClient.zip')"></td>
        </tr>
        <%--<tr class="tr_dark">--%>
            <%--<td class="form_border">2</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;硬件驱动</td>--%>
            <%--<td class="form_border" align="left">&nbsp;指纹采集机驱动（fingerprint_driver.exe）</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;<input type="button" value="下载" class="button_normal" onclick="window.open('${ctx}/tools/fingerprint_driver.exe')"></td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_light">--%>
            <%--<td class="form_border">3</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;硬件驱动</td>--%>
            <%--<td class="form_border" align="left">&nbsp;身份证读卡器驱动（idcard_driver.exe）</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;<input type="button" value="下载" class="button_normal" onclick="window.open('${ctx}/tools/idcard_driver.exe')"></td>--%>
        <%--</tr>--%>
        <%--<tr class="tr_light">--%>
            <%--<td class="form_border">3</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;浏览器插件</td>--%>
            <%--<td class="form_border" align="left">&nbsp;身份证读卡器插件（SynCardOcx.CAB）</td>--%>
            <%--<td class="form_border" nowrap>&nbsp;<input type="button" value="下载" class="button_normal" onclick="window.open('${ctx}/tools/SynCardOcx.CAB')"></td>--%>
        <%--</tr>--%>
        <tr class="tr_button">
            <td class="form_td_line" align="center" colspan="6">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>